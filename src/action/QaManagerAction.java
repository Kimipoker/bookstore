package action;

import com.opensymphony.xwork2.ModelDriven;
import dao.EtitleDAO;
import dao.QaDAO;
import model.EtitleModel;
import model.QaModel;

import java.util.List;

/**
 * 题库管理后台操作
 */
public class QaManagerAction extends BaseAction implements ModelDriven<QaModel> {

    private QaModel model = new QaModel();

    private List<QaModel> list;
    private List<EtitleModel> elist;

    public List<EtitleModel> getElist() {
        return elist;
    }

    public void setElist(List<EtitleModel> elist) {
        this.elist = elist;
    }

    public List<QaModel> getList() {
        return list;
    }

    public void setList(List<QaModel> list) {
        this.list = list;
    }

    public String add(){
        EtitleDAO dao = new EtitleDAO();
        this.elist =  dao.findAllEtitle();
        return "add";
    }

    public String doadd(){
        QaDAO dao = new QaDAO();
        if(dao.createQa(this.getModel())){
            addActionMessage("新增题目成功");
        }else{
            addActionMessage("新增题目失败");
        }
        return "result";
    }

    public String edit(){
        EtitleDAO dao = new EtitleDAO();
        this.elist =  dao.findAllEtitle();
        QaDAO qdao = new QaDAO();
        this.model = qdao.getQaByQid(this.model.getQid());
        return "edit";
    }

    public String doedit(){
        QaDAO dao = new QaDAO();
        if(dao.updateQa(this.getModel())){
            addActionMessage("更新题目成功");
        }else{
            addActionMessage("更新题目失败");
        }
        return "result";
    }

    public String delete(){
        QaDAO dao = new QaDAO();
        dao.deleteQaByQid(this.model.getQid());
        return SUCCESS;
    }

    /**
     * 后台题目列表
     * @return
     */
    public String list(){
        EtitleDAO edao = new EtitleDAO();
        this.elist = edao.findAllEtitle();
        QaDAO dao = new QaDAO();
        this.list = dao.findQaByEid(this.model.getEid());
        return "list";
    }

    @Override
    public QaModel getModel() {
        return model;
    }
}
