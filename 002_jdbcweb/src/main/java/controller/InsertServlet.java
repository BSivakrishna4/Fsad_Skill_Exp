package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Students;
import model.StudentsManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("Hello World from Get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();
	    try
	    {
	      //Collecting data from front end
	      int rollno = Integer.parseInt(request.getParameter("T1"));
	      String name = request.getParameter("T2");
	      String dept = request.getParameter("T3");
	      
	      Students S = new Students(rollno, name, dept);
	      StudentsManager SM = new StudentsManager();
	      String ack = SM.insertData(S); //Insert Operation
	      pw.print("<span style='color:green'>"+ ack +"</span>"); // Return response back to front end      
	    }catch (Exception e) 
	    {
	      pw.print("<span style='color:red'>" + e.getMessage() + "</span>"); //Send error message to front end
	    }
	    RequestDispatcher RD = request.getRequestDispatcher("index.jsp");
	    RD.include(request, response);
	  }

}
