package dao;

import common.db.DbConnection;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserModel> findAllUserByRole(String role){
        List<UserModel> list = new ArrayList<UserModel>();
        String sql = "select * from user where role=? order by createtime desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,role);
            rs = ps.executeQuery();
            while(rs.next()){
                UserModel user = new UserModel();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCname(rs.getString("cname"));
                user.setSex(rs.getString("sex"));
                user.setRole(rs.getString("role"));
                java.sql.Timestamp d = rs.getTimestamp("createtime");
                user.setCreateTime(new java.util.Date(d.getTime()));
                list.add(user);
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
     * 根据用户ID获取用户对象
     * @param userId
     * @return
     */
	public UserModel getUserByUserId(String userId){
		String sql = "select * from user where userid =?";
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
        	conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,userId);
            rs = ps.executeQuery();
            while(rs.next()){
         	   UserModel user = new UserModel();
         	   user.setUserId(userId);
         	   user.setUserName(rs.getString("username"));
         	   user.setPassword(rs.getString("password"));
                user.setCname(rs.getString("cname"));
         	   user.setSex(rs.getString("sex"));
         	   user.setRole(rs.getString("role"));
               java.sql.Timestamp d = rs.getTimestamp("createtime");
         	   user.setCreateTime(new java.util.Date(d.getTime()));
         	   return user;
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
	 * 创建用户对象
	 * @param model
	 * @return
	 */
	public boolean createUser(UserModel model){
		boolean rs = false;
        String sql = "insert into user(userid,username,password,cname,sex,createtime) values (?,?,?,?,?,NOW())";
        System.out.println("创建用户对象:userid:"+model.getUserId()+",username:"+model.getUserName());
        Connection conn = null;
        PreparedStatement ps = null;
        try{
           conn = DbConnection.getInstance().getConnection();
           ps = conn.prepareStatement(sql);
           ps.setString(1, model.getUserId());
           ps.setString(2, model.getUserName());
           ps.setString(3, model.getPassword());
           ps.setString(4,model.getCname());
           ps.setString(5, model.getSex());
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
     *更新用户密码
     * @return
     */
    public boolean updateUser(UserModel model){
        boolean rs = false;
        String sql = "update user set password=?,cname=?,username=? where userid=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbConnection.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,model.getPassword());
            ps.setString(2,model.getCname());
            ps.setString(3,model.getUserName());
            ps.setString(4,model.getUserId());
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
}
