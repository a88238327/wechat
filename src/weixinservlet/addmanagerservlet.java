package weixinservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UpdatePW;
import entity.addmanager_info;
import entity.selectManager;
import entity.truenumber;

/**
 * Servlet implementation class addmanagerservlet
 */
@WebServlet("/addmanagerservlet")
public class addmanagerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmanagerservlet() {
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
		String phone_number=request.getParameter("phone_number");
		String lv=request.getParameter("lv");
		String managername=request.getParameter("managername");
		String managerphone=request.getParameter("managerphone");
		System.out.println(phone_number);
		System.out.println(lv);
		System.out.println(managername);
		System.out.println(managerphone);
		HttpSession session=request.getSession();
		if(managername.equals(""))
		{
			response.getWriter().write("errorname");
			return;
		}
		if(truenumber.isNumber(managerphone))
		{
			System.out.println("true");
			if(!selectManager.selectmanager(managerphone))
			{
				int i = Integer.valueOf(lv).intValue(); 
				i=i+1;
				lv = Integer.toString(i); 
				if(addmanager_info.addmanager(managerphone,managername,phone_number,lv))
				{
					response.getWriter().write("true");
					return;
				}
				
			}
			else {
				
					response.getWriter().write("false");
			}	
		}
		else
		{
			response.getWriter().write("errormanagerphone");
			return;
		}
	}

}
