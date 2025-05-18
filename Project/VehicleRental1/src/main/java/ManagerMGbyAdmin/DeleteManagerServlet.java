package ManagerMGbyAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



public class DeleteManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteManagerServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ManagerAd mng = new ManagerAd();
		mng.setEmail(request.getParameter("email"));
		
		ManagerAdController service = new ManagerAdController();
		service.deleteManager(mng);
		
		RequestDispatcher dspt = request.getRequestDispatcher("ManagerDetailsServlet");
		dspt.forward(request, response);
	}

}
