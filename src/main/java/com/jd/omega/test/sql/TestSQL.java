package com.jd.omega.test.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jd.omega.jdutil.FileUtilJD;

public class TestSQL {

	// @SuppressWarnings("resource")
	public static void test01() {
		final String sql_url = "jdbc:postgresql://localhost/ring";
		final String sql_user = "ring";
		final String sql_password = "ring";

		try {
			Connection conn1 = DriverManager.getConnection(sql_url, sql_user, sql_password);
			String cmd = FileUtilJD.TextFileRead("d:\\foo.sql");
			System.out.println(cmd);
			
			// Statement stmt = conn1.createStatement();
			// ResultSet rs = stmt.executeQuery(cmd);			
			ResultSet rs = conn1.createStatement().executeQuery(cmd);			
			conn1.close();
			while (rs.next()) {
				System.out.println(rs.getString("nom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // some method to get a // Connection

	}

}
