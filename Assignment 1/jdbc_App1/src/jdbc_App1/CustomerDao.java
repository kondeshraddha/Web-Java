package jdbc_App1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements AutoCloseable {
	private Connection con;
	
	public CustomerDao() throws Exception {
		con = DbUtil.getConnection();
	}

	@Override
	public void close() throws Exception{
		if(con != null)
			con.close();
	}
	
	public List<Customer>findAll() throws Exception{
		List<Customer>list=new ArrayList<Customer>();
		String sql="Select * from customers";
		try(PreparedStatement stmt= con.prepareStatement(sql)){
			try(ResultSet rs= stmt.executeQuery()){
				while(rs.next()){
				int id = rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String mobileno=rs.getString("mobile");
				String address=rs.getString("address");
				String email=rs.getString("email");
				Date birth=rs.getDate("birth");
				Customer c=new Customer(id,name,password,mobileno,address,email,birth);
				list.add(c);
				
				}
			}

		}
		return list;
	}
	public int update(Customer c) throws Exception{
		String sql= "update customers set name=?,password=?,mobile=?,address=?,email=?,birth=? where id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1,c.getName());
			stmt.setString(2,c.getPassword());
			stmt.setString(3,c.getMobile());
			stmt.setString(4,c.getAddress());
			stmt.setString(5,c.getEmail());
			stmt.setDate(6,c.getBirth());
			stmt.setInt(7,c.getId());

			int count=stmt.executeUpdate();
			return count;
		}


	}
	public int changePassword(String email,String password) throws Exception{
		String sql= "Update customers set password=? where email=?";

		try(PreparedStatement stmt=con.prepareStatement(sql)){
		stmt.setString(1,password);
		stmt.setString(2,email);
		int count=stmt.executeUpdate();
		return count;

		}
	}

public Customer findByEmailAndPasswd(String email, String passwd) throws Exception{
	String sql="select * from customers where email=? and password=?";
	try(PreparedStatement stmt=con.prepareStatement(sql)){
		stmt.setString(1,email);
		stmt.setString(2,passwd);
		try(ResultSet rs=stmt.executeQuery()){
			if(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String psswd=rs.getString("password");
				String mobileno=rs.getString("mobile");
				String address=rs.getString("address");
				Date birth=rs.getDate("birth");
				Customer c=new Customer(id,name,passwd,mobileno,address,birth);
				return c;
			}
		}
	}
	return null;
}
	public int deleteById(int cusId) throws Exception{
		String sql="delete from customers where id=?";
		try(PreparedStatement stmt= con.prepareStatement(sql)){
			stmt.setInt(1,cusId);
			int count=stmt.executeUpdate();
			return count;
		}
	}
	
	public Customer findByEmail(String email) throws Exception {
		String sql="Select * from customers where email=?";
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setString(1,email);
			try(ResultSet rs= stmt.executeQuery()){
				if(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String psswd=rs.getString("password");
				String mobileno=rs.getString("mobile");
				String address=rs.getString("address");
				Date birth=rs.getDate("birth");
				Customer c=new Customer(id,name,psswd,mobileno,address,birth);
				return c;
				}

			}
		}
		// ...
		return null;
	}
	
	public int save(Customer cust) throws Exception {
		String sql = "INSERT INTO customers (id, name, email, mobile, address, birth) VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, cust.getId());
			stmt.setString(2, cust.getName());
			stmt.setString(3, cust.getEmail());
			stmt.setString(4, cust.getMobile());
			stmt.setString(5, cust.getAddress());
			stmt.setDate(6, cust.getBirth());
			int count = stmt.executeUpdate();
			return count;
		}
	}
}

