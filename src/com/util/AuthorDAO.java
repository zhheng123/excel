package com.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class AuthorDAO {
	
	
	public static Integer isNewUserByPhone(String phone){
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs=null;
		Integer num=0;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(
					"select count(1) as num from appuser  where phone=?");
			prep.setString(1, phone);
			rs=prep.executeQuery();
			while(rs.next()){
				num=rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return num;
	}
	//插入后台编辑作者
	public static void  insertAuthor(String author,String ctype) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(
					"insert into auther(writer,stype) values(?,?)");
			prep.setString(1, author);
			prep.setString(2, ctype);
			 prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
	
	//生成每个作者的评论excel表
	public static void createExcelByUserId(int userID,String startTime,String endTime,String author){
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs=null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(
					"select id,convert(comments using gb2312),newId,commentTime,praiseCount,stepCount from comment where userId=? and date(str_to_date(commentTime,'%Y-%m-%d %H:%i:%s')) between ? and ? order by id desc into outfile ?");
			prep.setInt(1, userID);
			prep.setString(2, startTime);
			prep.setString(3, endTime);
			prep.setString(4, "E:/commentExcel/"+author+".xls");
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	//根据用户ID查询所有评论
	public static List<Comment>findAllComment(int userID,String startTime,String endTime){
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs=null;
		List<Comment>comments=new ArrayList<Comment>();
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(
					"select * from comment where userId=? and date(str_to_date(commentTime,'%Y-%m-%d %H:%i:%s')) between ? and ?");
			prep.setInt(1,userID);
			prep.setString(2, startTime);
			prep.setString(3, endTime);
			rs=prep.executeQuery();
			while(rs.next()){
				Comment co=new Comment();
				co.setId(rs.getInt("id"));
				co.setComments(rs.getString("comments"));
				co.setCommenttime(rs.getString("commentTime"));
				co.setPraisecount(rs.getInt("praiseCount"));
				co.setStepcount(rs.getInt("stepCount"));
				comments.add(co);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return comments;
	}
}
