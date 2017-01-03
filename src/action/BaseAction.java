package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;


public class BaseAction extends ActionSupport {

    protected static Logger log = Logger.getLogger("A1");

    public String header(){
        return "header";
    }

}
