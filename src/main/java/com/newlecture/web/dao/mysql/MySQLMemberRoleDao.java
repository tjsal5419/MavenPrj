package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.MemberRoleDao;
import com.newlecture.web.data.entity.MemberRole;

public class MySQLMemberRoleDao implements MemberRoleDao {

	@Override
	public String getDefaultRoleById(String memberId) {
		  String sql = "SELECT ROLE_ID From MEMBER_ROLE WHERE MEMBER_ID=? AND DEFAULT_ROLE=1";
		  String memberRole = null;
		  
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				memberRole = rs.getString("ROLE_ID");
				
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return memberRole;
	}

	@Override
	public List<MemberRole> getRolesOfMember(String memberId) {
		

		  String sql = "SELECT * USER_ROLE From MEMBER_ROLE WHERE MEMBERID=?";

		  List<MemberRole> list = new ArrayList<>();
		  
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
			Connection con = DriverManager.getConnection(url, "newlec", "sclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				MemberRole memberRole = new MemberRole();
				memberRole.setRoleId(rs.getString("ROLE_ID"));
				memberRole.setMemberId(rs.getString("MEMBER_ID"));
				memberRole.setRegAdmin(rs.getString("REG_ADMIN"));
				memberRole.setDefaultRole(rs.getBoolean("DEFAULT_ROLE"));
				memberRole.setRegDate(rs.getDate("REG_DATE"));
				
				list.add(memberRole);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return list;

	}

	@Override
	public List<MemberRole> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberRole memberRole) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberRole memberRole) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberRole memberRole) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberRole> getList(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(MemberRole memberRole) {
		// TODO Auto-generated method stub
		return 0;
	}


}
