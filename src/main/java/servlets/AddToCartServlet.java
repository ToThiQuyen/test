package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.OrderDetail;
import entity.Product;
import entity.ProductCart;
import entity.Users;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
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
		if(action.equalsIgnoreCase("add")) {
			doGetAdd(request, response);
		}
		if(action.equalsIgnoreCase("delete")) {
			String key = request.getParameter("key");
			HttpSession session = request.getSession();
			Object object = session.getAttribute("cart");
			Map<String, ProductCart> listOrder = (Map<String, ProductCart>) object;
			
			listOrder.remove(key);
			session.setAttribute("cart", listOrder);
			response.sendRedirect("cart");
		}
	
		  if(action.equalsIgnoreCase("updateQuantity")) { 
			  doGetUpdateQuantity(request, response); 
			  
		  }
		 
		

	}
	protected void doGetUpdateQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");
		int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
		HttpSession session = request.getSession();
		Object object = session.getAttribute("cart");
		Map<String, ProductCart> listOrder = (Map<String, ProductCart>) object;
		ProductCart productCart = listOrder.get(key);
		productCart.setQuantity(newQuantity);
		session.setAttribute("cart", listOrder);
		response.sendRedirect("cart");
	}
	
	protected void doGetAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		DAO dao = new DAO();
		if(users == null) {
				response.sendRedirect("login.jsp");
		}else {
			
		
		String pid = request.getParameter("pid");
		
		int quantity =1;
		
		Product product = dao.getProductById(pid);
		
		Object object = session.getAttribute("cart");
		if(object==null)
		{
			ProductCart productCart = new ProductCart();
			productCart.setProduct(product);
			productCart.setQuantity(quantity);
			
			Map<String, ProductCart> listOrder = new HashMap<String, ProductCart>();
			listOrder.put(pid, productCart);
			session.setAttribute("cart", listOrder);
		}else
		{
			Map<String, ProductCart> listOrder = (Map<String, ProductCart>) object;
			ProductCart productCart = listOrder.get(pid);
			if (productCart == null) {
				productCart = new ProductCart();
				productCart.setProduct(product);
				productCart.setQuantity(quantity);
				
				listOrder.put(pid, productCart);
			} else {
				productCart.setQuantity(productCart.getQuantity() + 1);
			}
			session.setAttribute("cart", listOrder);
			
		}response.sendRedirect("cart");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
