package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Products;
import model.ProductsManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("T1"));
		String name = request.getParameter("T2");
		double price = Double.parseDouble(request.getParameter("T3"));
		try
		{
			Products P = new Products(pid, name, price);
			ProductsManager PM = new ProductsManager();
			String ack = PM.insertProduct(P);
			pw.print(ack);
		}catch(Exception e)
		{
			pw.print(e.getMessage());
		}
		RequestDispatcher RD = request.getRequestDispatcher("index.jsp");
		RD.include(request, response);
	}
}
