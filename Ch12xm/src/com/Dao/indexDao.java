package com.Dao;

import java.util.List;

import com.entity.News;
import com.entity.Page;
import com.entity.topic;

public interface indexDao {
	//��ȡ��ҳ�����������
	public List<News> list(Page page);
	//��ȡ��������
	public List<News> list(int nid);
	//��������������
	public int countNews();
	//��ѯ������������
	public List<topic> list();
}
