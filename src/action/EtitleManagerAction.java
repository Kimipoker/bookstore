package action;

import com.opensymphony.xwork2.ModelDriven;
import dao.EtitleDAO;
import model.EtitleModel;

import java.util.List;

/**
 * 试题模块后台操作类
 */
public class EtitleManagerAction extends BaseAction implements ModelDriven<EtitleModel> {

    private EtitleModel model = new EtitleModel();

    private List<EtitleModel> list ;

    public List<EtitleModel> getList() {
        return list;
    }

    public void setList(List<EtitleModel> list) {
        this.list = list;
    }

    public String list(){
        EtitleDAO dao = new EtitleDAO();
        this.list = dao.findAllEtitle();
        return "list";
    }

    public String add(){
        return "add";
    }

    public String doadd(){
        EtitleDAO dao = new EtitleDAO();
        if(dao.createEtitle(this.getModel())){
            addActionMessage("新增试题成功！");
        }else{
            addActionMessage("新增试题失败！");
        }
       return SUCCESS;
    }

    /**
     *编辑试题
     * @return
     */
    public String edit(){
        EtitleDAO dao = new EtitleDAO();
        this.model = dao.getEtitleByEid(this.getModel().getEid());
        return "edit";
    }

    /**
     * 执行更新试题信息
     * @return
     */
    public String doedit(){
        EtitleDAO dao = new EtitleDAO();
        if(dao.updateEtitle(this.getModel())){
            addActionMessage("更新试题信息成功！");
        }else{
            addActionMessage("更新试题信息失败！");
        }
        return "result";
    }

    @Override
    public EtitleModel getModel() {
        return model;
    }

}
