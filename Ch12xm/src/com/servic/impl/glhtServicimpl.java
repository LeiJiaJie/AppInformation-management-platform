package com.servic.impl;

import java.util.List;

import com.Dao.impl.glhtDaoimpl;
import com.entity.News;
import com.entity.topic;
import com.servic.glhtServic;

public class glhtServicimpl implements glhtServic {

	@Override
	public List<News> list() {
		return new glhtDaoimpl().list();
	}

	@Override
	public String UpdataTopic(topic topic) {
		glhtDaoimpl daoimpl = new glhtDaoimpl();
		String pd = null;
		if(daoimpl.selectTopic(topic.getTname())) {
			pd = "������ͬ����";
		}else if (daoimpl.UpdataTopic(topic)>0) {
			pd = "�ѳɹ���������";
		}else {
			pd = "δ�ҵ�����";
		}
		return pd;
	}

	@Override
	public String DeleteTopic(int id) {
		glhtDaoimpl daoimpl = new glhtDaoimpl();
		String pd = null;
		if(daoimpl.selectNews(id)) {
			pd = "�������»�������";
		}else if (daoimpl.delete(id)>0) {
			pd = "�ѳɹ�ɾ������";
		}else {
			pd = "δ�ҵ�����";
		}
		return pd;
	}

	@Override
	public String insertTopic(String name) {
		glhtDaoimpl daoimpl = new glhtDaoimpl();
		String pd = null;
		if(daoimpl.selectTopic(name)) {
			pd = "���и�����";
		}else if (daoimpl.insertTopic(name)>0) {
			pd = "�ѳɹ��������";
		}else {
			pd = "δ�ҵ�����";
		}
		return pd;
	}


}
