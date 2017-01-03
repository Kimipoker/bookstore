package dao;

import common.db.DbConnection;
import model.EtitleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 试题对象数据库查询类
 */
public class EtitleDAO {
    /**
     * 根据试题ID获取试题信息
     * @param eid
     * @return
     */
    public EtitleModel getEtitleByEid(int eid){
        String sql = "select * from etitle where eid =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,eid);
            rs = ps.executeQuery();
            while(rs.next()){
                EtitleModel model = new EtitleModel();
                model.setEid(rs.getInt("eid"));
                model.setEtitle(rs.getString("etitle"));
                model.setAuthor(rs.getString("author"));
                java.sql.Timestamp d = rs.getTimestamp("createtime");
                model.setCreateTime(new java.util.Date(d.getTime()));
                return model;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * 查询试题列表
     * @return
     */
    public List<EtitleModel> findAllEtitle(){
        List<EtitleModel> list = new ArrayList<EtitleModel>();
        String sql = "select * from etitle order by createtime desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                EtitleModel model = new EtitleModel();
                model.setEid(rs.getInt("eid"));
                model.setEtitle(rs.getString("etitle"));
                model.setAuthor(rs.getString("author"));
                java.sql.Timestamp d = rs.getTimestamp("createtime");
                model.setCreateTime(new java.util.Date(d.getTime()));
                list.add(model);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
    /**
     * 更新试题
     * @param model
     * @return
     */
    public boolean updateEtitle(EtitleModel model){
        boolean rs = false;
        String sql = "update etitle set etitle=?,author=?  where eid=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,model.getEtitle());
            ps.setString(2,model.getAuthor());
            ps.setInt(3,model.getEid());
            int s = ps.executeUpdate();
            if(s>0)
                rs = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return rs;
    }
    /**
     * 创建试题对象
     * @param model
     * @return
     */
    public boolean createEtitle(EtitleModel model){
        boolean rs = false;
        String sql = "insert into etitle(etitle,author,createtime) values (?,?,NOW())";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,model.getEtitle());
            ps.setString(2,model.getAuthor());
            ps.execute();
            rs = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ps!=null){
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return rs;
    }

}
