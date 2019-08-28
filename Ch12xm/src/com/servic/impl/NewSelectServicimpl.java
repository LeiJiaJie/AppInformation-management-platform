package com.servic.impl;


import java.util.List;

import com.Dao.impl.indexDaoimpl;
import com.entity.Page;
import com.entity.topic;
import com.servic.NewSelectServic;

public class NewSelectServicimpl implements NewSelectServic {

	public Page list(Page str) {
		indexDaoimpl indexDaoimpl = new indexDaoimpl();
		str.setTotalCount(indexDaoimpl.countNews());
		str.setNewsList(indexDaoimpl.list(str));
		return str;
	}
	
	public List<topic> SelectComment(){
		return new indexDaoimpl().list();
	}
	
	public Page iDList(Page str,int id) {
		indexDaoimpl indexDaoimpl = new indexDaoimpl();
		str.setTotalCount(indexDaoimpl.countNews());
		str.setNewsList(indexDaoimpl.list(id));
		return str;
	}
}
