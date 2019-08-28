package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.util.ConfigManager;

/**
 * 数据库连接与关闭工具类�??
 * 
 * @author 北大青鸟
 */
public class BaseDao {
   
    protected Connection conn;
    protected ResultSet rs;
    protected PreparedStatement psmt;
    /**
     * 获取数据库连接对象�??
     */
    public Connection getConnection() {
        // 获取连接并捕获异�?
        try {
            if (conn == null || conn.isClosed()) {
            	Context ctx = new InitialContext();
        		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/news");
        		conn = ds.getConnection(); 
        		}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;// 返回连接对象
    }

    /**
     * 关闭数据库连接�??
     * 
     * @param conn
     *            数据库连�?
     * @param stmt
     * Statement对象
     * @param rs
     *            结果�?
     */
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关�?
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关�?
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关�?
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void executeQuery(String sql ,Object... parma) {
    	psmt = null;
    	rs = null;
    	conn = this.getConnection();
    	try {
    		psmt = conn.prepareStatement(sql);
    		for(int i=0;i<parma.length;i++) {
    			psmt.setObject(i+1, parma[i]);
    		}
    		rs = psmt.executeQuery();
    	}catch (Exception e) {
			e.getSuppressed();
		}
    }
}
