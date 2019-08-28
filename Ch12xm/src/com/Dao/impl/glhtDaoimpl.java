package com.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.BaseDao;
import com.Dao.glhtDao;
import com.entity.News;
import com.entity.topic;

public class glhtDaoimpl extends BaseDao implements glhtDao {

	@Override
	public List<News> list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		try {
			conn = getConnection();
			String sql = "SELECT * from news";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				News news = new News(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6));
				list.add(news);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int UpdataTopic(topic topic) {
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE topic SET tname=? WHERE tid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, topic.getTname());
			ps.setInt(2, topic.getTid());
			count = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, null);
		}
		return count;
	}

	@Override
	public boolean selectTopic(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean pd = false;
		try {
			conn = getConnection();
			String sql = "select * from Topic where tname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pd = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}
		return pd;
	}

	@Override
	public boolean selectNews(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean pd = false;
		try {
			conn = getConnection();
			String sql = "select * from News where ntid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pd = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}
		return pd;
	}

	@Override
	public int delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM topic WHERE tid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			count = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, null);
		}
		return count;
	}

	@Override
	public int insertTopic(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO topic(tname) VALUES(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			count = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, null);
		}
		return count;
	}

}
