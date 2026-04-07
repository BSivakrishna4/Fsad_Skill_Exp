package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentsManager;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/HCQLServlet")
public class HCQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HCQLServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
			StudentsManager SM = new StudentsManager();
			pw.print(SM.getStudents());
			
		} catch (Exception e) {
			pw.print(e.getMessage());
		}
	}

}
