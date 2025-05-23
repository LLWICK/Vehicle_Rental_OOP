package vOwnerManageByAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SingleOwnerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SingleOwnerProfileServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VehicleOwner vowner = new VehicleOwner();
		vowner.setEmail(request.getParameter("email"));
		VehicleOwnerController service = new VehicleOwnerController();
		
		VehicleOwner vehiOwner = service.getSingleOwner(vowner);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/singleVOwnerProfile.jsp");
		request.setAttribute("vehiOwner", vehiOwner);
		dispatcher.forward(request, response);
		
	}

}

