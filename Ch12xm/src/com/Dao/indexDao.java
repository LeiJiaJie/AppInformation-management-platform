package com.Dao;

import java.util.List;

import com.entity.News;
import com.entity.Page;
import com.entity.topic;

public interface indexDao {
	//获取分页后的所有新闻
	public List<News> list(Page page);
	//获取所有新闻
	public List<News> list(int nid);
	//计算总新闻数量
	public int countNews();
	//查询所有新闻类型
	public List<topic> list();
}
