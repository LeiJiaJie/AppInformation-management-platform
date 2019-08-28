package com.servic;

import java.util.List;

import com.entity.News;
import com.entity.topic;

public interface glhtServic {
	//获取所有新闻
	public List<News> list();
	//通过ID修改主题
	public String UpdataTopic(topic topic);
	//通过ID删除新闻主题
	public String DeleteTopic(int id);
	//通过名字添加新闻主题
	public String insertTopic(String name);
}
