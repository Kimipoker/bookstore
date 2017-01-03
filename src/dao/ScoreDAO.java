package dao;

import common.db.DbConnection;
import model.ScoreModel;
import util.WebSiteUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 得分数据库操作类
 */
public class ScoreDAO {
    /**
     * 创建得分对象
     * @param model
     * @return
     */
    public boolean createScore(ScoreModel model){
        boolean rs = false;
        String sql = "insert into score(userid,eid,etitle,totalscore,score,createtime) values (?,?,?,?,?,NOW())";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,model.getUserId());
            ps.setInt(2,model.getEid());
            ps.setString(3,model.getEtitle());
            ps.setInt(4,model.getTotalscore());
            ps.setInt(5,model.getScore());
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

    /**
     * 查询得分列表
     * @return
     */
    public List<ScoreModel> findScoreByUserId(String userId){
        List<ScoreModel> list = new ArrayList<ScoreModel>();
        String sql = "select * from score ";
        if(WebSiteUtil.isNotEmpty(userId))
            sql+=" where userid='"+userId+"'";
        sql+=" order by createtime asc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ScoreModel model = new ScoreModel();
                model.setId(rs.getInt("id"));
                model.setUserId(rs.getString("userid"));
                model.setEid(rs.getInt("eid"));
                model.setEtitle(rs.getString("etitle"));
                model.setTotalscore(rs.getInt("totalscore"));
                model.setScore(rs.getInt("score"));
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
}
