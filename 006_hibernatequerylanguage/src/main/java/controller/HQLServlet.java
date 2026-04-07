package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentManager;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/HQLServlet")
public class HQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HQLServlet() {
        super();  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			StudentManager SM = new StudentManager();
			request.setAttribute("slist", SM.fromClause());
			request.setAttribute("slist1", SM.selectClause());
			request.setAttribute("slist2", SM.whereClause());
			request.setAttribute("slist3", SM.namedParameters());
			request.setAttribute("count",SM.count());
			request.setAttribute("sum", SM.sumofCGPA());
			request.setAttribute("average", SM.avgofCGPA());
			request.setAttribute("min", SM.minCGPA());
			request.setAttribute("max", SM.maxCGPA());
		} catch (Exception e) {
			pw.print(e.getMessage());
		}
		RequestDispatcher RD = request.getRequestDispatcher("index.jsp");
		RD.forward(request, response);
	}

}
