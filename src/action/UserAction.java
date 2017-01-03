package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import dao.UserDAO;
import model.UserModel;
import util.WebSiteUtil;

import java.util.List;
import java.util.Map;
/**
 * 用户相关操作action类
 */
public class UserAction extends BaseAction implements ModelDriven<UserModel>{
	
	private UserModel model = new UserModel();
	
	private List<UserModel> list;

    private String oldPass;
    private String newPass;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public List<UserModel> getList() {
        return list;
    }

    public void setList(List<UserModel> list) {
        this.list = list;
    }
	
	public String reg(){
		return "reg";
	}
	
	public String login(){
		return "login";
	}

    /**
     * 跳转到用户编辑页面
     * @return
     */
    public String edit(){
        UserDAO dao = new UserDAO();
        if(WebSiteUtil.isNotEmpty(this.getModel().getUserId())){
            this.model = dao.getUserByUserId(this.getModel().getUserId());
        }else{
            Map session = ActionContext.getContext().getSession();
            this.model = (UserModel)session.get("user");
        }
        return "useredit";
    }

    /**
     * 执行用户编辑操作
     * @return
     */
    public String doedit(){
        UserDAO dao = new UserDAO();
        UserModel um = dao.getUserByUserId(this.getModel().getUserId());
        um.setCname(this.getModel().getCname());
        if(dao.updateUser(um)){
            addActionMessage("更新学生信息成功！");
        }else{
            addActionMessage("更新学生信息失败！");
        }
        return "result";
    }

    /**
     * 用户（或管理员）退出
     * @return
     */
	public String logout(){
		Map session = ActionContext.getContext().getSession();
        session.remove("user");
        session.remove("manager");
        session.clear();
		return "login";
	}

    /**
     * 用户退出
     * @return
     */
	public String dologin(){
		String userId = model.getUserId();
		UserDAO dao = new UserDAO();
		UserModel um = dao.getUserByUserId(userId);
		if(um==null||!um.getPassword().equals(this.model.getPassword())){
			addActionMessage("用户名或密码有误！");
			return "login";
		}
        if(um.getRole().equals(model.getRole())){
            Map session = ActionContext.getContext().getSession();
            if("1".equals(um.getRole())){
                session.put("manager", um);
                return "manager";
            }else{
                session.put("user", um);
                return SUCCESS;
            }
        }else{
            addActionMessage("用户类型选择有误！");
            return "login";
        }
	}

    /**
     * 执行注册操作
     * @return
     */
	public String doreg(){
		String userId = model.getUserId();
		UserDAO dao = new UserDAO();
		UserModel um = dao.getUserByUserId(userId);
		if(um!=null){
			addActionMessage("账号'"+userId+"'已经存在！");
			return "reg";
		}
		boolean rs = dao.createUser(model);
		if(!rs){
			addActionMessage("对不起，系统出现异常，请稍后重试！");
			return "reg";
		}
		return "reg_success";
	}

    /**
     * 跳转到更改密码页面
     * @return
     */
    public String modifyPass(){
        Map session = ActionContext.getContext().getSession();
        //如果检测到用户没有登录，则跳转到登录页面
        if(session.get("user")==null&&session.get("manager")==null)
            return "login";
         return "modifyPass";
    }

    /**
     * 执行更改密码操作
     * @return
     */
    public String doModifyPass(){
        UserModel um = null;
        Map session = ActionContext.getContext().getSession();
        if(session.get("user")!=null)
            um = (UserModel)session.get("user");
        if(session.get("manager")!=null)
            um = (UserModel)session.get("manager");
        //如果不存在有效的登录用户，跳转至用户登录页面
        if(um==null)
            return "login";
        UserDAO dao = new UserDAO();
        um = dao.getUserByUserId(um.getUserId());
        if(um.getPassword().equals(this.getOldPass())){
            if(WebSiteUtil.isNotEmpty(this.getNewPass())){
                um.setPassword(this.getNewPass());
                if(dao.updateUser(um)){
                    addActionMessage("密码更新成功！");
                } else{
                    addActionMessage("密码更新失败！");
                }
            }

        }else{
            addActionMessage("旧密码输入有误！");
        }
        return "modifyPass";
    }

	@Override
    public UserModel getModel() {
        return model;
    }

}
