package dao;

import common.db.DbConnection;
import model.QaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 题库数据库查询类
 */
public class QaDAO {
    /**
     * 创建题目对象
     * @param model
     * @return
     */
    public boolean createQa(QaModel model){
        boolean rs = false;
        String sql = "insert into qa(eid,qtitle,a1,a2,a3,a4,answer,score) values (?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,model.getEid());
            ps.setString(2,model.getQtitle());
            ps.setString(3,model.getA1());
            ps.setString(4,model.getA2());
            ps.setString(5,model.getA3());
            ps.setString(6,model.getA4());
            ps.setString(7,model.getAnswer());
            ps.setInt(8,model.getScore());
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
     * 根据题目ID获取题目信息
     * @param qid
     * @return
     */
    public QaModel getQaByQid(int qid){
        String sql = "select * from qa where qid =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, qid);
            rs = ps.executeQuery();
            while(rs.next()){
                QaModel model = new QaModel();
                model.setQid(rs.getInt("qid"));
                model.setEid(rs.getInt("eid"));
                model.setQtitle(rs.getString("qtitle"));
                model.setA1(rs.getString("a1"));
                model.setA2(rs.getString("a2"));
                model.setA3(rs.getString("a3"));
                model.setA4(rs.getString("a4"));
                model.setAnswer(rs.getString("answer"));
                model.setScore(rs.getInt("score"));
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
     * 根据题目ID删除题目信息
     * @param qid
     * @return
     */
    public boolean deleteQaByQid(int qid){
        boolean rs = false;
        String sql = "delete from qa  where qid=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,qid);
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
     * 更新试题
     * @param model
     * @return
     */
    public boolean updateQa(QaModel model){
        boolean rs = false;
        String sql = "update qa set eid=?,qtitle=?,a1=?,a2=?,a3=?,a4=?,answer=?,score=?  where qid=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,model.getEid());
            ps.setString(2,model.getQtitle());
            ps.setString(3,model.getA1());
            ps.setString(4,model.getA2());
            ps.setString(5,model.getA3());
            ps.setString(6,model.getA4());
            ps.setString(7,model.getAnswer());
            ps.setInt(8,model.getScore());
            ps.setInt(9,model.getQid());
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
     * 根据试题ID查询该试题下的题目列表
     * @param eid
     * @return
     */
    public List<QaModel> findQaByEid(int eid){
        List<QaModel> list = new ArrayList<QaModel>();
        String sql = "select * from qa where eid =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,eid);
            rs = ps.executeQuery();
            while(rs.next()){
                QaModel model = new QaModel();
                model.setQid(rs.getInt("qid"));
                model.setEid(rs.getInt("eid"));
                model.setQtitle(rs.getString("qtitle"));
                model.setA1(rs.getString("a1"));
                model.setA2(rs.getString("a2"));
                model.setA3(rs.getString("a3"));
                model.setA4(rs.getString("a4"));
                model.setAnswer(rs.getString("answer"));
                model.setScore(rs.getInt("score"));
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
