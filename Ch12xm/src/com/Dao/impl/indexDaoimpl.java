package com.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.BaseDao;
import com.Dao.indexDao;
import com.entity.News;
import com.entity.Page;
import com.entity.topic;

public class indexDaoimpl extends BaseDao implements indexDao {

	public List<News> list(Page page) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT * from news limit ?,?";
		int count = (page.getCurrPageNo() - 1) * page.getPageSize();
		this.executeQuery(sql, count, page.getPageSize());
		try {
			while (rs.next()) {
				News newsUser = new News();
				newsUser.setNid(rs.getInt("nid"));
				newsUser.setNtitle(rs.getString("ntitle"));
				newsUser.setTime(rs.getDate("ncreateDate"));
				newsUser.setNcontent(rs.getString("ncontent"));
				newsUser.setNauthor(rs.getString("nauthor"));
				newsUser.setNtid(rs.getInt("ntid"));
				list.add(newsUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, psmt, rs);
		}
		return list;
	}

	public List<News> list(int nid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		try {
			conn = getConnection();
			String sql = "SELECT * from news where ntid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
			rs = ps.executeQuery();
			while (rs.next()) {
				News newsUser = new News();
				newsUser.setNid(rs.getInt("nid"));
				newsUser.setNtitle(rs.getString("ntitle"));
				newsUser.setTime(rs.getDate("ncreateDate"));
				newsUser.setNcontent(rs.getString("ncontent"));
				newsUser.setNauthor(rs.getString("nauthor"));
				newsUser.setNtid(rs.getInt("ntid"));
				list.add(newsUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return list;
	}

	public int countNews() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = getConnection();
			String sql = "SELECT count(1) from news";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return count;
	}

	@Override
	public List<topic> list() {
		List<topic> list = new ArrayList<topic>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select*from topic";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				topic topic = new topic(rs.getInt(1), rs.getString(2));
				list.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}
		return list;
	}

}
