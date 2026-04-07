package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.EmployeeManger;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertEmployee")
public class InsertEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int empid = Integer.parseInt(request.getParameter("T1"));
		String name = request.getParameter("T2");
		double salary = Double.parseDouble(request.getParameter("T3"));
		
		try
		{
			Employee E = new Employee(empid, name, salary);
			EmployeeManger EM = new EmployeeManger();
			String ack = EM.insertData(E);
			pw.print(ack);
		}catch (Exception e) {
			pw.print(e.getMessage());
		}
		
		RequestDispatcher RD = request.getRequestDispatcher("index.jsp");
		RD.include(request, response);
	}

}
