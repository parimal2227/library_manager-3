
public class Book {

	private int bookid;
	private String author;
	private String name;
	private double price;
	private int isAvailable=0;

	public int isAvailable() {
		return isAvailable;
	}
	public void setAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
