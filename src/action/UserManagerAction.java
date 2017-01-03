package action;

import com.opensymphony.xwork2.ModelDriven;
import dao.UserDAO;
import model.UserModel;
import util.WebSiteUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理类
 */
public class UserManagerAction extends BaseAction implements ModelDriven<UserModel> {

    private UserModel model = new UserModel();

    private List<UserModel> userlist; //用户集合

    public List<UserModel> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserModel> userlist) {
        this.userlist = userlist;
    }

    /**
     * 后台管理员查询用户信息
     * @return
     */
    public String list(){
        UserDAO dao = new UserDAO();
        //如果用户userId传入则按userId查询，否则查询所有用户
        if(WebSiteUtil.isNotEmpty(this.getModel().getUserId())){
            UserModel um = dao.getUserByUserId(this.getModel().getUserId());
            if(um!=null){
                this.userlist = new ArrayList<UserModel>();
                this.userlist.add(um);
            }
        }else{
            this.userlist = dao.findAllUserByRole(this.getModel().getRole());
        }
        return "userlist";
    }

    @Override
    public UserModel getModel() {
        return model;
    }
}
