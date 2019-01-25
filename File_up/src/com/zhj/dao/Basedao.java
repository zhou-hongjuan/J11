package com.zhj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.zhj.until.ConfigMapper;

public class Basedao {
/*对于数据库的基类操作 增删改查 以及通过数据源获得数据库连接*/
	private Connection conn;//铺路
	private PreparedStatement pstm;//执行人
	private ResultSet rs;//结果集
	
	//获取连接 ：通过配置获取
	private boolean getConn(){
		
		try {
			Class.forName(ConfigMapper.getInstance().getString("jdbc.driver"));
			String url=ConfigMapper.getInstance().getString("jdbc.connection.url");
			String username=ConfigMapper.getInstance().getString("jdbc.connection.username");
			String password=ConfigMapper.getInstance().getString("jdbc.connection.password");
			conn = DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;//如果获得链接就返回
	}
	
	//获取链接  ：通过数据源获取
	public boolean getConn2(){
		//初始化上下文
		try {
			Context cxt=new InitialContext();
			//获取与逻辑名称相关的数据源对象                                 拼接规则：java:comp/env/+名称   
			DataSource ds=(DataSource)cxt.lookup("java:comp/env/jdbc/file_log");
			//通过数据源获取数据库链接
			conn=ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;//如果获得链接就获得true

	}

	
	//查询
  public ResultSet getfiles(String sql,Object...objects){
	  if (getConn()){//如果获取到了链接  
		  try {
			pstm=conn.prepareStatement(sql);//执行sql语句
			for(int i=0;i<objects.length;i++){
				pstm.setObject((i+1),objects[i]);
			}
			rs=pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  return rs;//如果成功获取到了链接  那么就返回结果集
  }
  
  
  //增删改
  
  public int executeSQL(String sql,Object...objects){
	  int rs_zsg=0;//?????????
	  if (getConn()){//如果获取到了链接  
		  try {
			pstm=conn.prepareStatement(sql);//执行sql语句
			for(int i=0;i<objects.length;i++){
				pstm.setObject((i+1),objects[i]);
			}
			rs_zsg = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  return rs_zsg;//如果成功获取到了链接  那么就返回结果集
			
  }
  public void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstm!=null){
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
