package com.sathya.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public static int saveData(UserData user) {
		int res = 0;
		try {
			Connection connection = TestConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into user_details values(userid_user_details_seq.nextval,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCountry());
			preparedStatement.setString(5, user.getQualification());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getTechnologies());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.setString(9, user.getComments());
			res = preparedStatement.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;

	}

	public static boolean checkLogin(String email, String password) {
		boolean result = false;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select email,password from user_details where email='" + email
					+ "'and password='" + password + "'");

			if (set.next()) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static int passwordreset(String email, String password) {

		int res = 0;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			res = statement
					.executeUpdate("update user_details set password='" + password + "' where email='" + email + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static List<UserData> userList() {

		ResultSet set = null;
		ArrayList<UserData> users = new ArrayList<UserData>();

		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			set = statement.executeQuery("select * from user_details");
			while (set.next()) {
				UserData user = new UserData(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9),
						set.getString(10));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static boolean updateUser(UserData user) {
		boolean res = false;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			statement.addBatch(
					"update user_details set username='" + user.getUsername() + "' where USERID=" + user.getUserId());
			statement.addBatch(
					"update user_details set email='" + user.getEmail() + "' where USERID=" + user.getUserId());
			statement.addBatch(
					"update user_details set country='" + user.getCountry() + "' where USERID=" + user.getUserId());
			statement.addBatch("update user_details set qualification='" + user.getQualification() + "' where USERID="
					+ user.getUserId());
			statement.addBatch(
					"update user_details set gender='" + user.getGender() + "' where USERID=" + user.getUserId());
			statement.addBatch("update user_details set technologies='" + user.getTechnologies() + "' where USERID="
					+ user.getUserId());
			statement.addBatch(
					"update user_details set address='" + user.getAddress() + "' where USERID=" + user.getUserId());
			statement.executeBatch();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean deleteUser(int userId) {
		boolean res = false;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from user_details where USERID=" + userId);
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static UserData getUser(String username) {
		UserData user = null;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select * from user_details where username='" + username + "'");
			set.next();
			user = new UserData(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
					set.getString(6), set.getString(7), set.getString(8), set.getString(9), set.getString(10));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
