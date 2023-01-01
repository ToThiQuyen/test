package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Users;
import util.Encrypt;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("admin")) {
			doPostAdmin(request, response);
		}
		if(action.equalsIgnoreCase("customer")) {
			doPostCustomer(request, response);
		}
		
		
		
		
			/* request.setAttribute("erorr", "Username is exist"); */
	}
	protected void doPostCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		

			if (!repass.equals(pass)) {
				request.setAttribute("erorr", "Wrong pass");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			} else {
				DAO dao = new DAO();
				Users users = dao.checkUserExist(username);
				if (users != null) {
					request.setAttribute("erorr", "Username is exist");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				} else {
					pass = Encrypt.toSHA1(pass);
					dao.signUpUsers(username, pass, fullname, phone);
					response.sendRedirect("login.jsp");
				}
			}
	}
	protected void doPostAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		

			if (!repass.equals(pass)) {
				request.setAttribute("erorr", "Wrong pass");
				request.getRequestDispatcher("signupAdmin.jsp").forward(request, response);
			} else {
				
				DAO dao = new DAO();
				Users users = dao.checkUserExist(username);
				if (users != null) {
					request.setAttribute("erorr", "Username is exist");
					request.getRequestDispatcher("signupAdmin.jsp").forward(request, response);
				} else {
					repass = Encrypt.toSHA1(repass);
					dao.signUpAdmin(username, repass, fullname, phone);
					response.sendRedirect("ShopServlet");
				}
			}

			
	}

}
