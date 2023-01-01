package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String indexString = request.getParameter("index");
		String cid = request.getParameter("cid");
		if(indexString == null) {
			indexString = "1";
		}
		int index = Integer.parseInt(indexString);
		
		
		DAO dao = new DAO();
		int count = dao.getTotalProductByName(name);
		int page = count/2;
		if(count % 2 != 0) {
			page++;
		}
		
		List<Product> listp = dao.panigationProductsByName(name, index);
		
	
		request.setAttribute("listPani", listp);
		request.setAttribute("tag", cid);
		request.setAttribute("activeCate", index);
		request.setAttribute("pageCate", page);
		/* response.sendRedirect("panigation"); */
		 request.getRequestDispatcher("/shop.jsp").forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
