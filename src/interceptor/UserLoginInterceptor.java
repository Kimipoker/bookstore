package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import model.UserModel;

import java.util.Map;

public class UserLoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        UserModel user = (UserModel)session.get("user");
        //检测到用户没有登录，跳转到登录页面
        if(user==null){
            return "login";
        }else{
            return invocation.invoke();
        }
    }
}
