package com.servic;

import java.util.List;

import com.entity.Page;
import com.entity.topic;

public interface NewSelectServic {
	//获取所有新闻，新闻分页
	public Page list(Page str);
	//通过id获取所有新闻
	public Page iDList(Page page,int id);
}
