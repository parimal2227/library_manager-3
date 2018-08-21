
import java.util.*;

public class Library_manager { 
	
	static TreeMap<Integer, Book> book_map = new TreeMap<Integer, Book>();
	static TreeMap<Integer, Member_Record> member_map = new TreeMap<Integer, Member_Record>();
	static TreeMap<Integer, issueDetails> issue_map = new TreeMap<Integer, issueDetails>();
	
	static Scanner sc=new Scanner(System.in);
	static String option,i;
	static int j=1;
	static issueDetails issue_instance=new issueDetails();
	static boolean bError=true;
	static int choose=1;
	
	public static void main(String args[])
	{
	
	bb:
		while(true)
		{
			bError=true;
		  System.out.println("WELCOME TO LIBRARY MANAGEMENT SYSTEM:"
		  		+ "\nCHOOSE OUT OF FOLLOWING OPTIONS:"
		  		+ "\n\t1. Add Books"
		  		+ "\n\t"+ "2. Add Users"
		  				+ "\n\t3. Issue Book"
		  				+ "\n\t4. Return book"
		  				+ "\n\t5. Search books by Title and Author"
		  				+"\n\t6. Search users by name");
		  option=sc.nextLine();
		  switch(option)
		  {
		  	case "1":
		  		addBook();
		  		   break;

		  	case "2":
		  		addmember();
		  		   break;
		  	case "3":
		  		issueBook();
		  			break;
		  	case "4":
		  		returnBook();
	  		      break;
	  		   
		  	case "5":
		  		searchBook();
		  		break;
		  		
		  	case "6":
		  		searchMember();
		  		break;
		  		
		  	
	  		 default:System.out.println("Wrong choice selected");
	  		 		  continue;
	  		 		
		  }
		  bError=true;
				do {
					
				try
				{
		  System.out.println("press 1 to for main menu and any other integer to quit");
			choose=sc.nextInt();
			sc.nextLine();
			bError=false;
			if(choose!=1)
				break bb;
			else
				continue;		
			
		}
		
		catch(Exception e)
		  {
			  System.out.println("please enter an integer");
			  sc.nextLine();
		  }
	  }while(bError);
		}
		}
	
	//function to add book records
	
	public static void addBook()
	{
		bError=true;
		Book b=new Book();
		Scanner in=new Scanner(System.in);
		int flag=0;
		int b_id=0;
		aa:
		do{
			try {
		System.out.println("enter the ISBN of the book");
		b_id=in.nextInt();
		b.setBookid(b_id);
				if(book_map.containsKey(b_id))
				{
					flag=1;
				}
				
		if(flag!=1)
		{
			
			System.out.println("enter the title of the book");
			in.nextLine();
			String title=in.nextLine();
			b.setName(title.toLowerCase());
		
	   
			System.out.println("enter the Author of the book");
			String author=in.nextLine();
			b.setAuthor(author.toLowerCase());
			
				
			System.out.println("enter the price of the book");
			double price=in.nextDouble();
			b.setPrice(price);
			book_map.put(b.getBookid(),b);
			bError=false;
		}
		
			else
				System.out.println("this ISBN already exists\n");
			
		}
	
			catch(Exception e)
			{
				System.out.println("please enter all the fields in coreect format");
				 in.nextLine();
				 System.out.println("press any key and enter to go to main menue");
				 in.nextLine();
				 break;
			}
			
			}while(bError);
	   
	}
		
	//function to add user details
	
	public static void addmember()
	{
		Member_Record m=new Member_Record();
		Scanner in=new Scanner(System.in);
		int flag=0;
		bError=true;
		
	    do {
			try {
			System.out.println("enter the User id of the user");
			int m_id=in.nextInt();
			m.setMember_id(m_id);
			
					if(member_map.containsKey(m_id))
					{
						flag=1;
					}
			
			
			if(flag!=1)
			{
				 
						System.out.println("enter the corresponding user name");
					    in.nextLine();
						String name=in.nextLine();
						m.setName(name.toLowerCase());
				 member_map.put(m.getMember_id(),m);
				 
			}
			else
				System.out.println("this member id already exists\n");
		
			bError=false;
			}
			catch(Exception e)
			{
				System.out.println("please enter the all the fields in correct format");
				 in.nextLine();
				 System.out.println("press any key and enter to go to main menue");
				 in.nextLine();
				 break;
			}	
			
			}while(bError);
	
	}
	
	//function to return book
	
	public static void returnBook()
	{
		bError=true;
		aa:
		do {
			try {
			System.out.println("enter the User id of user who want to return the book");
			int member_num=sc.nextInt();
			
			System.out.println("Enter the  corresponding ISBN");
	        int isbn_num=sc.nextInt();
			
	        System.out.println("Enter the  corresponding issue id");
	        int issue_num=sc.nextInt();
	
	        
	        if(issue_instance.returnBook(issue_num,issue_map,member_map.get(member_num),book_map.get(isbn_num)))
	        {
	  	      System.out.println("record deleted successfully!!,Book returned succesfully\n");
	        }
	        else
	        {
	  		System.out.println("Transaction deletion Unsuccessful,Data not present or had already returned the book");
	        }
	        
			bError=false;
			}
			catch(Exception e)
			{
				System.out.println("please enter fiels in correct format");
				 sc.nextLine();
				 System.out.println("press any key and enter to go to main menue");
				 sc.nextLine();
				 break;
			}
			}while(bError);
	    
	}
	
	//function to issue book
	
	public static void issueBook()
	{
		bError=true;	
		aa:
		do
		{
			try
			{
	System.out.println("Enter the member_id to whom book to be issued\n");
		int member_id=sc.nextInt();
		System.out.println("Enter the book_id to be issued\n");
		int book_id=sc.nextInt();
		issueDetails temp_issue;
		if(issue_map.isEmpty())
		{
			temp_issue=issue_instance.createIssueRecord(1, member_map.get(member_id),book_map.get(book_id));
		
		}
		else
		{
			
			temp_issue=issue_instance.createIssueRecord(issue_map.lastEntry().getKey()+1, member_map.get(member_id),book_map.get(book_id));
		
		}
		if(temp_issue!=null) {
			issue_map.put(temp_issue.getIssueId(),temp_issue);
			System.out.println("issued succesfully with issue id: "+j);
			++j;}
		else
			System.out.println("can not issue book,Already issued two books or the book is already issued to someone");
		
		bError=false;
	}
		catch (Exception e)
		{
		System.out.println("failed to issue!!  May be one f the reasons: "
				+ "\n\t1. please enter the fields in correct format"
				+ "\n\t2. Book or user is not available in Library database");
		sc.nextLine();
		System.out.println("press any key and enter to go to main menue");
		 sc.nextLine();
		 break;
		}
		}while(bError);
	
	}
	
	//function to search book by name and author
	
	public static void searchBook()
	{
		bError=true;
		aa:
		do
		{
			try
			{
		if(book_map.isEmpty())
			System.out.println("No recrord available\n");
		
		else
		{
	System.out.println("Enter the Title of the book you want to search\n");
	String st2=sc.nextLine();
	
	System.out.println("Enter the Author of the book you want to search\n");
	String au=sc.nextLine();
	int found=0;
		Set set = book_map.entrySet();
		Iterator book_iterator = set.iterator();
		while(book_iterator.hasNext()) 
		{
			Map.Entry mentry = (Map.Entry)book_iterator.next();
			Book b=(Book) mentry.getValue();
			
			if(b.getName().equals(st2.toLowerCase())&&b.getAuthor().equals(au.toLowerCase()))
			{
			System.out.println("\tISBN:"+mentry.getKey()+", Title:"+b.getName()+", Author:"+b.getAuthor()+", Price:"+b.getPrice());
			found=1;
			}
		}
		if(found==0)
			System.out.println("Sorry! either title and author did not matched or the record is not available f0r the input");
		}
		bError=false;
			}
			catch (Exception e)
			{	
				System.out.println("enter the fields in correct format");
				sc.nextLine();
				System.out.println("press any key and enter to go to main menue");
				 sc.nextLine();
				 break;
			}
		}while(bError);
		
	}
	
	//function t search user by name
	
	public static void searchMember()
	{
		int found=0;
		bError=true;
		aa:
		do
		{
			try
			{
		if(member_map.isEmpty())
			System.out.println("No recrord available\n");
		
		else
		{
	  System.out.println("Enter the name of members you want to search\n");
	  String st=sc.nextLine();
	  
	   Set set_member = member_map.entrySet();
	   Iterator member_iterator = set_member.iterator();
	   while(member_iterator.hasNext()) 
	   {
		   Map.Entry mentry = (Map.Entry)member_iterator.next();
		   Member_Record m=(Member_Record) mentry.getValue();
		   if(m.getName().equals(st.toLowerCase())) {
		   System.out.println("\tmember found with user id:"+m.getMember_id()+", Name:"+m.getName()+"\n");
		   found=1;}
		}
	}
	if(found==0)
		System.out.println("Sorry! no records found for this user name");
		
	   bError=false;
			}
			catch (Exception e)
			{
				System.out.println("please enter fields in correct format");
				sc.nextLine();
				System.out.println("press any key and enter to go to main menue");
				 sc.nextLine();
				 break;
			}
					
		}while(bError);
	}
	
	}

	

