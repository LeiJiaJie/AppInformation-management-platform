package com.Dao;

import java.util.List;

import com.entity.News;
import com.entity.topic;

public interface glhtDao {
	//��ȡ��������
	public List<News> list();
	//ͨ��ID�޸�����
	public int UpdataTopic(topic topic);
	//�����Ƿ�����ͬ����
	public boolean selectTopic(String name);
	//���Ҹ��������Ƿ�������
	public boolean selectNews(int id);
	//ɾ��������
	public int delete(int id);
	//�����������
	public int insertTopic(String name);
	
}
