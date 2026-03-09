package model;

public class Book {
int bookid;
String title;
double price;
public Book()
{
	
}
public Book(int bookid,String title,double price)
{
	this.bookid=bookid;
	this.title=title;
	this.price=price;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
