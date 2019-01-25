package com.zhj.dao;

import java.util.List;

public interface FileDao {
	//查询列表  需要imFile_up_do去实现他
		public List<Filelog> geList(Filelog file);
		
		//添加类
		public int addFile(Filelog file);
}
