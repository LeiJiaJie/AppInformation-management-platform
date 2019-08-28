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
			pd = "已有相同主题";
		}else if (daoimpl.UpdataTopic(topic)>0) {
			pd = "已成功更新主题";
		}else {
			pd = "未找到主题";
		}
		return pd;
	}

	@Override
	public String DeleteTopic(int id) {
		glhtDaoimpl daoimpl = new glhtDaoimpl();
		String pd = null;
		if(daoimpl.selectNews(id)) {
			pd = "该主题下还有文章";
		}else if (daoimpl.delete(id)>0) {
			pd = "已成功删除主题";
		}else {
			pd = "未找到主题";
		}
		return pd;
	}

	@Override
	public String insertTopic(String name) {
		glhtDaoimpl daoimpl = new glhtDaoimpl();
		String pd = null;
		if(daoimpl.selectTopic(name)) {
			pd = "已有该主题";
		}else if (daoimpl.insertTopic(name)>0) {
			pd = "已成功添加主题";
		}else {
			pd = "未找到主题";
		}
		return pd;
	}


}
