package file.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.connection.DBConnection;
import file.model.User;

public class UserDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	
	int sid;
	String name, email;
	
	public static List<User> listuser() {
		List<User> user = new ArrayList<User>();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM person");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				
				user.add(u);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
