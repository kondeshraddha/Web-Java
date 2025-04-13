package jdbc_App1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements AutoCloseable {
	private Connection con;
	public BookDao() throws Exception {
		con=DbUtil.getConnection();
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con!=null)
			con.close();
			
	}
	
	public int save(Book b) throws Exception {
		String sql="Insert into books values(? ,? ,? ,? ,? )";
		try(PreparedStatement stmt= con.prepareStatement(sql))
		{
			stmt.setInt(1,b.getId());
			stmt.setString(2, b.getName());
			stmt.setString(3, b.getAuthor());
			stmt.setString(4, b.getSubject());
			stmt.setDouble(5, b.getPrice());
			int count =stmt.executeUpdate();
			return count;
		}
	}
	
	public List<Book> findAll() throws Exception{
		List<Book>list=new ArrayList<Book>();
		String sql="select * from books";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs= stmt.executeQuery()){
				while(rs.next()) {
				int id= rs.getInt("id");
				String name=rs.getString("name");
				String author=rs.getString("author");
				String subject=rs.getString("subject");
				double price=rs.getDouble("price");
				Book b= new Book(id,name,author,subject,price);
				list.add(b);
				
			}
		}
		
	}
		return list;
	}
	
	public Book findByID(int bookID) throws Exception {
		String sql="select * from books where id=?";
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setInt(1, bookID);
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String author=rs.getString("author");
					String subject=rs.getString("subject");
					double price= rs.getDouble("price");
					Book b= new Book(id,name,author,subject,price);
					return b;
				}
			}
		}
		return null;
	}
	public List<Book> findBySubject(String subje) throws SQLException{
		List<Book>list=new ArrayList<Book>();
		String sql="select * from books where subject=?";
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setString(1,subje);
			try(ResultSet rs= stmt.executeQuery()){
				while(rs.next()){
					int id=rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");
					Book b = new Book(id, name, author, subject, price);
					list.add(b);
					
				}
			}

	} 
		return list;
	}
	
	public int updated(Book b) throws Exception {
		String sql="Update books set name=?,author=?,subject=?,price=? where id=?";
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			stmt.setInt(5, b.getId());
			int count= stmt.executeUpdate();
			return count;
		}
	}
	
	public int deleted(int bookID) throws Exception {
		String sql="delete from books where id=?";
		try(PreparedStatement stmt= con.prepareStatement(sql)){
			stmt.setInt(1, bookID);
			int count= stmt.executeUpdate();
			return count;
		}
	}

}
