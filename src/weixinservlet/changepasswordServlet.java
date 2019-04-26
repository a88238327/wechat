package weixinservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.CheckUser;
import entity.UpdatePW;

/**
 * Servlet implementation class changepasswordServlet
 */
@WebServlet("/changepasswordServlet")
public class changepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepasswordServlet() {
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
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String password=request.getParameter("password");
		String passwordtwo=request.getParameter("passwordtwo");
		String phone_number=request.getParameter("phone_number");
		HttpSession session=request.getSession();
		if(password.equals(session.getAttribute("password")))
		{
				if(passwordtwo.length()>=6)
				{	
					if(UpdatePW.updatepw(phone_number, passwordtwo))
					{
						response.getWriter().write("true");
						return;
					}	
				}
				else {
					response.getWriter().write("not_enough");
					return;
				}
		}
		else
		{
			response.getWriter().write("false");
			return;
		}
	}

}
