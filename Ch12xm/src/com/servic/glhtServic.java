package com.servic;

import java.util.List;

import com.entity.News;
import com.entity.topic;

public interface glhtServic {
	//��ȡ��������
	public List<News> list();
	//ͨ��ID�޸�����
	public String UpdataTopic(topic topic);
	//ͨ��IDɾ����������
	public String DeleteTopic(int id);
	//ͨ�����������������
	public String insertTopic(String name);
}
