package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import dao.ScoreDAO;
import model.ScoreModel;
import model.UserModel;

import java.util.List;
import java.util.Map;

/**
 * 学生考试分数管理后台操作
 */
public class ScoreAction extends BaseAction implements ModelDriven<ScoreModel> {

    private ScoreModel model = new ScoreModel();

    private List<ScoreModel> list;

    public List<ScoreModel> getList() {
        return list;
    }

    public void setList(List<ScoreModel> list) {
        this.list = list;
    }

    /**
     * 后台成绩管理
     * @return
     */
    public String list(){
        ScoreDAO dao = new ScoreDAO();
        this.list = dao.findScoreByUserId(this.model.getUserId());
        return "list";
    }

    /**
     * 我的成绩
     * @return
     */
    public String mylist(){
        ScoreDAO dao = new ScoreDAO();
        Map session = ActionContext.getContext().getSession();
        UserModel um = (UserModel)session.get("user");
        this.list = dao.findScoreByUserId(um.getUserId());
        return "mylist";
    }

    @Override
    public ScoreModel getModel() {
        return model;
    }
}
