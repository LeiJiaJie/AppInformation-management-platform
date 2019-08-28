package com.Dao;

import java.util.List;

import com.entity.News;
import com.entity.topic;

public interface glhtDao {
	//获取所有新闻
	public List<News> list();
	//通过ID修改主题
	public int UpdataTopic(topic topic);
	//查找是否有相同主题
	public boolean selectTopic(String name);
	//查找该主题下是否有文章
	public boolean selectNews(int id);
	//删除该主题
	public int delete(int id);
	//添加新闻主题
	public int insertTopic(String name);
	
}
