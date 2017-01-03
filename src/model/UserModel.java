package model;

import java.util.Date;
/**
 * 用户模型
 * @author lenovo
 *
 */
public class UserModel {
	
	private String userId; //用户账号
	private String userName; //用户名称
	private String password; //用户密码
    private String cname;//班级
	private String sex;      //性别
	private String role;    //角色
	private Date createTime; //注册时间

    public String getUserId() {
        return userId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
