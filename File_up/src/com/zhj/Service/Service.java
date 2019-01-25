package com.zhj.Service;

import java.util.List;

import com.zhj.dao.Filelog;

public interface Service {
	//查询列表  需要一个类去实现他
			public List<Filelog> geList(Filelog file);
			
			//添加类
			public int addFile(Filelog file);



		
}
