package jdbc_App1;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner sc= new Scanner(System.in);
	public static void saveBook() {
		try(BookDao bookDao= new BookDao()){
			System.out.print("Enter ID : ");
			int id=sc.nextInt();
			System.out.print("Enter name : ");
			String name=sc.next();
			System.out.print("Enter author : ");
			String author=sc.next();
			System.out.print("Enter subject : ");
			String subject=sc.next();
			System.out.print("Enter price : ");
			double price=sc.nextDouble();
			
			Book b= new Book(id,name,author,subject,price);
			int count=bookDao.save(b);
			System.out.println("Book inserted : "+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printAll() {
		try(BookDao bookDao= new BookDao()){
			List<Book>list=bookDao.findAll();
			for(Book b:list) {
				System.out.println(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchBook() {
		try(BookDao bookDao= new BookDao()){
			System.out.print("Enter id : ");
			int id= sc.nextInt();
			Book b= bookDao.findByID(id);
			if(b==null) {
				System.out.println("book not found");
			}else {
				System.out.println("fount"+b.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void findBYsubject(){
		try(BookDao bookDao=new BookDao()){
		System.out.print("enter Subject : ");
		String subject=sc.next();
	    List<Book>list= bookDao.findBySubject(subject);
		
		for(Book b:list) {
			System.out.println(b.toString());
		
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void updatedBook() {
		try(BookDao bookDao= new BookDao()){
			System.out.print("Enter id : ");
			int id= sc.nextInt();
			
			System.out.print("Enter name : ");
			String name =sc.next();
			System.out.print("Enter author : ");
			String author =sc.next();
			System.out.print("Enter subject : ");
			String subject =sc.next();
			System.out.print("Enter price : ");
			double price =sc.nextDouble();
			
			Book b= new Book(id,name,author,subject,price);
			int count= bookDao.updated(b);
			System.out.println("Book Updated : "+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void bookDeleted() {
		try(BookDao bookDao= new BookDao()){
			System.out.print("Enter id :");
			int id=sc.nextInt();
			int count=bookDao.deleted(id);
			System.out.println("Book deleted : "+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveCustomer() {
		try(CustomerDao custDao = new CustomerDao()) {
			System.out.print("enter id: ");
			int id = sc.nextInt();
			System.out.print("enter name: ");
			String name = sc.next();
			System.out.print("enter email: ");
			String email = sc.next();
			System.out.print("enter mobile: ");
			String mobile = sc.next();
			System.out.print("enter address: ");
			String addr = sc.next();
			System.out.print("enter birth (yyyy-MM-dd): ");
			String birth = sc.next();
			Date birthDate = Date.valueOf(birth);
			Customer c = new Customer(id, name, email, mobile, addr, birthDate);
			int count = custDao.save(c);
			System.out.println("Customer Added: " + count);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getAllCustomer() {
		try(CustomerDao c=new CustomerDao()){
			List<Customer>list=c.findAll();
			for(Customer c1:list) {
				System.out.println(c.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void updateCustomer() {
		try(CustomerDao c1= new CustomerDao()){
			System.out.print("Enter id : ");
			int id=sc.nextInt();
			System.out.print("Enter name : ");
			String name=sc.next();
			System.out.print("Enter password : ");
			String password=sc.next();
			System.out.print("Enter mobile NO : ");
			String mobile= sc.next();
			System.out.print("Address : ");
			String addr=sc.next();
			System.out.print("Enter email : ");
			String email=sc.next();
			System.out.print("Enter birth date : ");
			String birth=sc.next();
			Date birthdate=Date.valueOf(birth);
			Customer c= new Customer(id,name,password,mobile,addr,email,birthdate);
			int count=c1.update(c);
			System.out.println("Customer Updated : "+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getPassword() {
		try(CustomerDao custDao= new CustomerDao()){
			System.out.print("Enter email : ");
			String email=sc.next();
			System.out.print("Enter password : ");
			String passwd=sc.next();
			int count=custDao.changePassword(email, passwd);
			System.out.println("Password changed : "+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getCustByEmailAndPasswd() {
		try(CustomerDao custDao=new CustomerDao()){
			System.out.print("Enter email : ");
			String email= sc.next();
			System.out.println("enter password : ");
			String password=sc.next();
			Customer c=custDao.findByEmailAndPasswd(email, password);
			if(c==null) {
				System.out.println("Wrong email and password ");
				
			}
			else {
				System.out.println("customer : "+c.toString());
			}

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void deleteCustomer() {
		try(CustomerDao cDao=new CustomerDao()){
			System.out.print("Enter id : ");
			int id= sc.nextInt();
			int count=cDao.deleteById(id);
			System.out.println("Customer deleted : "+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void getCustomerByEmail() {
		try(CustomerDao cusDao= new CustomerDao()){
			System.out.println("Enter email : ");
			String email=sc.next();
			Customer c=cusDao.findByEmail(email);
			if(c==null) {
				System.out.println("Wrong email");
				
			}
			else {
				System.out.println("customer : "+c.toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int choice=0;
		do {
			System.out.println("\n0.exit\n1.AddBook\n2.getAllBook\n3.getBookById\n4.updateBook\n5.deleteBook"
					+ "\n6.getBookBySubject\n7getAllCustomer\n8.updateCustomer\n9.saveCustomer\n10.getCustByEmail\n11.getCustEmailAndPasswd\n"
					+ "12.getCustPassword\n13.deleteCustomer");
			choice=sc.nextInt();
			switch(choice) {
			case 0:
				System.out.println("bye");
				break;
			case 1:
				saveBook();
				break;
			case 2: 
				printAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				updatedBook();
				break;
			case 5:
				bookDeleted();
				break;
			case 6:
				findBYsubject();
				break;
			case 7:
				getAllCustomer();
				break;
			case 8: 
				updateCustomer();
				break;
			case 9:
				saveCustomer();
				break;
			case 10:
				getCustomerByEmail();
				break;
			case 11: 
				getCustByEmailAndPasswd();
				break;
			case 12:
				getPassword();
				break;
			case 13:
				deleteCustomer();
				break;
			}
		}while(choice!=0);
		

	}

}
