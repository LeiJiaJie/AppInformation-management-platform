package com.servic;

import java.util.List;

import com.entity.Page;
import com.entity.topic;

public interface NewSelectServic {
	//��ȡ�������ţ����ŷ�ҳ
	public Page list(Page str);
	//ͨ��id��ȡ��������
	public Page iDList(Page page,int id);
}
