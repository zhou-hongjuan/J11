package com.zhj.pojo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhj.Service.Service;
import com.zhj.dao.Basedao;
import com.zhj.dao.Filelog;

public class impFileLogDao extends Basedao implements Service {

	
	//查询
	@Override
	public List<Filelog> geList(Filelog file) {
		List<Filelog>  files = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT * From file_log");
		Object[] params={};
		ResultSet rs = getfiles(sql.toString(), params);
		try {
			while(rs.next()){
				Filelog newfile = new Filelog();
				newfile.setFid(rs.getInt("fid"));
				newfile.setFusername(rs.getString("user_name"));
				newfile.setFcreatetime(rs.getString("create_date"));
				newfile.setFname(rs.getString("file_name"));
				newfile.setFpath(rs.getString("file_path"));
				files.add(newfile);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return files;
	}

	@Override
	public int addFile(Filelog file) {
		StringBuffer sql = new StringBuffer("INSERT INTO file_log VALUES(?,?,?,?,?)");
		Object[] params = {
			file.getFid(),
			file.getFusername(),
			file.getFcreatetime(),
			file.getFname(),
			file.getFpath()
		};
		
		int flag = executeSQL(sql.toString(), params);
		return flag;
	}
	

}
