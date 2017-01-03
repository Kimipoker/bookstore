package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import dao.EtitleDAO;
import dao.QaDAO;
import dao.ScoreDAO;
import model.EtitleModel;
import model.QaModel;
import model.ScoreModel;
import model.UserModel;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 前台用户试题操作
 */
public class KaoshiAction extends BaseAction implements ModelDriven<ScoreModel> {

    private ScoreModel model = new ScoreModel();

    private List<EtitleModel> etitlelist; //试卷列表
    private List<QaModel> qalist;//题目列表
    private EtitleModel emodel;//试卷

    public EtitleModel getEmodel() {
        return emodel;
    }

    public void setEmodel(EtitleModel emodel) {
        this.emodel = emodel;
    }

    public List<QaModel> getQalist() {
        return qalist;
    }

    public void setQalist(List<QaModel> qalist) {
        this.qalist = qalist;
    }

    public List<EtitleModel> getEtitlelist() {
        return etitlelist;
    }

    public void setEtitlelist(List<EtitleModel> etitlelist) {
        this.etitlelist = etitlelist;
    }

    /**
     * 查询所有试卷
     * @return
     */
    public String etitlelist(){
        EtitleDAO edao = new EtitleDAO();
        this.etitlelist = edao.findAllEtitle();
        return "etitlelist";
    }

    /**
     * 进入考试页面
     * @return
     */
    public String qalist(){
        QaDAO dao = new QaDAO();
        this.qalist = dao.findQaByEid(this.model.getEid());
        EtitleDAO edao = new EtitleDAO();
        this.emodel = edao.getEtitleByEid(this.model.getEid());
        return "qalist";
    }

    /**
     * 交卷
     * @return
     */
    public String jiaojuan(){
        EtitleDAO edao = new EtitleDAO();
        this.emodel = edao.getEtitleByEid(this.model.getEid());
        QaDAO dao = new QaDAO();
        this.qalist = dao.findQaByEid(this.model.getEid());
        HttpServletRequest request = ServletActionContext.getRequest();

        //统计试卷总分,并计算学生算分
        int totalScore = 0; //卷面总分
        int score = 0; //学生得分
        if(this.qalist!=null&&this.qalist.size()>0){
            for(QaModel q:this.qalist){
                totalScore+=q.getScore();
                String v = request.getParameter("qa"+q.getQid());
                if(q.getAnswer().equals(v))
                    score+=q.getScore();
            }
        }
        Map session = ActionContext.getContext().getSession();
        UserModel um = (UserModel)session.get("user");
        this.model.setTotalscore(totalScore);
        this.model.setScore(score);
        this.model.setUserId(um.getUserId());
        this.model.setEtitle(this.emodel.getEtitle());
        ScoreDAO sdao = new ScoreDAO();
        if(sdao.createScore(this.getModel())){
            addActionMessage("交卷成功，你的得分为:"+score);
        }else{
            addActionMessage("交卷失败！请稍后重试！");
        }
        return "result";
    }

    @Override
    public ScoreModel getModel() {
        return model;
    }
}
