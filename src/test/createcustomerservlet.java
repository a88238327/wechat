package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tuil.SelectUsermaData;
import entity.MemoryCustom;

/**
 * Servlet implementation class createcustomerservlet
 */
@WebServlet("/createcustomerservlet")
public class createcustomerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createcustomerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(MemoryCustom.LookingandRecord(SelectUsermaData.getUserInfo(request.getParameter("cardid"), request.getParameter("code"))))
		{
			request.getRequestDispatcher("/createsuccess.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("/createfailure.jsp").forward(request,response);
		}
	}

}
