package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookManager;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		try {
			BookManager BM=new BookManager();
			request.setAttribute("booklist", BM.getBooks());
			}
		catch(Exception e){
			pw.print(e.getMessage());
		}
		RequestDispatcher RD=request.getRequestDispatcher("read.jsp");
		RD.forward(request, response);
	}

}
