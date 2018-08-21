
import java.util.*;
public class issueDetails {
	private int issue_Id;
	private int member_id;
	private int book_id;
	public issueDetails(){};
	public issueDetails(int issue_Id,Member_Record member,Book book)
	{
		super();
		this.issue_Id = issue_Id;
		this.member_id = member.getMember_id();
		this.book_id =book.getBookid();
	}
	public int getIssueId() {
		return issue_Id;
	}
	public void setIssueId(int transId) {
		this.issue_Id = transId;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
	public issueDetails createIssueRecord(int issue_Id,Member_Record member,Book book)
	{
		

		if(member.getNumber_of_book_issued()<2&&book.isAvailable()==0)
		{
			issueDetails t=new issueDetails(issue_Id,member,book);
			member.setNumber_of_book_issued(member.getNumber_of_book_issued()+1);
			book.setAvailable(book.isAvailable()+1);
			return(t);
		}
		else
		{
			return(null);
		}
		
	}	
	public boolean returnBook(int issue_Id,TreeMap<Integer, issueDetails> issue_map,Member_Record member,Book book)
	{
		Integer integer_object=new Integer(issue_Id);
		Set set_issue = issue_map.entrySet();
	      Iterator issue_iterator = set_issue.iterator();
	      while(issue_iterator.hasNext()) {
		      Map.Entry mentry = (Map.Entry)issue_iterator.next();
		      if(mentry.getKey().equals(integer_object))
		      {
		    	  member.setNumber_of_book_issued(member.getNumber_of_book_issued()-1);
		    	  book.setAvailable(0);
		    	  
		    	  issue_map.remove(mentry.getKey());
		    	  
		    	  return true;
		      }
	      }
		return(false);
	}
	
	
}
