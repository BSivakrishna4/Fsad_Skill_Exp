package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import model.BookManager;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();
	    int bookid = Integer.parseInt(request.getParameter("T1"));
	    String title = request.getParameter("T2");
	    double price = Double.parseDouble(request.getParameter("T3"));
	    try
	    {
	      Book B = new Book(bookid, title, price);
	      BookManager BM = new BookManager();
	      String ack = BM.updateBook(B); 
	      pw.print(ack);
	    }catch(Exception e)
	    {
	      pw.print(e.getMessage());
	    }
	    RequestDispatcher RD = request.getRequestDispatcher("update.jsp");
	    RD.include(request, response);
	  }

}
