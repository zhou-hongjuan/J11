package com.zhj.pojo;

import java.util.List;

import com.zhj.Service.Service;
import com.zhj.dao.Filelog;

public class ImpService implements Service{
	private Service fld;
	
	public ImpService(){
		fld=new impFileLogDao();
	}
	
	//添加
	@Override
	public int addFile(Filelog file) {
		// TODO Auto-generated method stub
		
		return fld.addFile(file);
	}
	//查询
	@Override
	public List<Filelog> geList(Filelog file) {
		// TODO Auto-generated method stub
		return fld.geList(file);
	}

	
	

}
