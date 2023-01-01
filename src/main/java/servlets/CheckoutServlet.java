package servlets;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.DAO;
import entity.OrderDetail;
import entity.Orders;
import entity.ProductCart;
import entity.Users;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
	
		if (action == null) {
			action = "load";
		}
		if(action.equalsIgnoreCase("checkout")) {
			doPostCheckout(request, response);
		}
		if(action.equalsIgnoreCase("load")) {
			doPostLoad(request, response);
		}
	}
	protected void doPostLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		DAO dao = new DAO();
		if(users != null) {
				users = dao.checkUserExist(users.getUsername());
				request.setAttribute("user", users);
		}
		
		double subPrice = 0;

		Object object = session.getAttribute("cart");
		Map<String, ProductCart> listOrder = (Map<String, ProductCart>) object;
		for (Map.Entry<String, ProductCart> entry : listOrder.entrySet()) {
			subPrice += entry.getValue().getQuantity() * Double.parseDouble(entry.getValue().getProduct().getPrice()) ;
			request.setAttribute("subPrice", subPrice);
        }
		double deliveryPrice = (subPrice*0.05);
		double totalPrice = subPrice+ deliveryPrice;
		
		request.setAttribute("total", totalPrice);
		request.setAttribute("deli", deliveryPrice);
		
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
	}
	protected void doPostCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		double totalPrice = 0;
		HttpSession session = request.getSession();
		Object object = session.getAttribute("cart");
		Map<String, ProductCart> listOrder = (Map<String, ProductCart>) object;
		for (Map.Entry<String, ProductCart> entry : listOrder.entrySet()) {
            totalPrice += entry.getValue().getQuantity() * Double.parseDouble(entry.getValue().getProduct().getPrice()) ;
        }
		totalPrice = totalPrice+ (totalPrice*0.05);
		Orders orders = new Orders(name, address, phone, totalPrice);
		DAO dao = new DAO();
		int idOrder = dao.addOrder(orders);
		
		for (Map.Entry<String, ProductCart> entry : listOrder.entrySet()) {
            OrderDetail orderDetail = new OrderDetail(entry.getValue().getProduct().getPid(), idOrder, entry.getValue().getQuantity(), Double.parseDouble(entry.getValue().getProduct().getPrice()) * entry.getValue().getQuantity());
            dao.addOrderDetail(orderDetail); 
		}
	
		response.sendRedirect("ShopServlet");
	}

}
