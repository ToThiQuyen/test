package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Product;
import entity.Users;

/**
 * Servlet implementation class AdminManagerProductServlet
 *
 */
@WebServlet("/managerproduct")
public class AdminManagerProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManagerProductServlet() {
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
		String action = request.getParameter("action");

		if (action == null) {
			action = "load";
		}
		if (action.equalsIgnoreCase("edit")) {
			doGetEdit(request, response);
		}
		if (action.equalsIgnoreCase("add")) {
			doGetAdd(request, response);
		}
		if (action.equalsIgnoreCase("delete")) {
			doGetDelete(request, response);
		}
		if (action.equalsIgnoreCase("load")) {
			doGetLoad(request, response);
		}
	}

	protected void doGetLoad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * DAO dao = new DAO(); List<Product> list = dao.getListProduct();
		 * request.setAttribute("listProduct", list);
		 */
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		DAO dao = new DAO();
		String url = request.getRequestURI();
		if(users == null || url.startsWith("/Project_BanNoiThat/managerproduct?action=load")) {
				response.sendRedirect("login.jsp");
		}else {
			
		
		String indexString = request.getParameter("index");
		if (indexString == null) {
			indexString = "1";
		}
		int index = Integer.parseInt(indexString);

		
		int count = dao.getTotalProduct();
		int page = count / 6;
		if (count % 6 != 0) {
			page++;
		}
		List<Product> list = dao.panigationProducts(index);

		request.setAttribute("listPani", list);
		request.setAttribute("page", page);
		request.setAttribute("active", index);
//		response.sendRedirect("managerproduct");

		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
		}
	}

	protected void doGetAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		DAO dao = new DAO();
		String url = request.getRequestURI();
		if(users == null || Integer.parseInt(users.getIsAd()) != 1 || url.startsWith("/Project_BanNoiThat/managerproduct?action=add")) {
				response.sendRedirect("login.jsp");
		}else {
			
		
		String name = request.getParameter("pname");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String cid = request.getParameter("cid");
		
		dao.addProduct(name, image, price, description, cid);
		response.sendRedirect("managerproduct");
		}
	}

	protected void doGetDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		DAO dao = new DAO();
		String url = request.getRequestURI();
		if(users == null|| Integer.parseInt(users.getIsAd()) != 1 || url.startsWith("/Project_BanNoiThat/managerproduct?action=delete")) {
				response.sendRedirect("login.jsp");
		}else {
			
		String pid = request.getParameter("pid");
		
		dao.deleteProduct(pid);
		response.sendRedirect("managerproduct");
		}
	}

	protected void doGetEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		DAO dao = new DAO();
		String url = request.getRequestURI();
		if(users == null|| Integer.parseInt(users.getIsAd()) != 1 || url.startsWith("/Project_BanNoiThat/managerproduct?action=edit")) {
				response.sendRedirect("login.jsp");
		}else {
			
		String pid = request.getParameter("pid");
		String name = request.getParameter("pname");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		
		String description = request.getParameter("description");
		String cid = request.getParameter("cid");
		
		dao.editProduct(name, image, price, description, cid, pid);
		response.sendRedirect("managerproduct");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
