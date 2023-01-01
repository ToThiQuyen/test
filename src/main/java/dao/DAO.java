package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Category;
import entity.OrderDetail;
import entity.Orders;
import entity.Product;
import entity.Users;
import servlets.CartServlet;

public class DAO {
	Connection connection = null; // kết nối tới mySQL
	PreparedStatement pStatement = null;
	ResultSet rs = null;

	public List<Category> getListCategory() {
		try {
			String query = "SELECT * FROM category";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			rs = pStatement.executeQuery();
			List<Category> listCategories = new ArrayList<Category>();
			while (rs.next()) {
				Category cate = new Category(rs.getInt(1), rs.getString(2));
				listCategories.add(cate);
			}
			return listCategories;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public List<Product> getListProduct() {
		try {
			String query = "SELECT * FROM product";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			rs = pStatement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6));
				listProduct.add(p);
			}
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Product> getProductByCategory(String cid) {
		try {
			String query = "SELECT * FROM product where cid = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, cid);
			rs = pStatement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6));
				listProduct.add(p);
			}
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Product getProductById(String id) {
		try {
			String query = "SELECT * FROM product where pid = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, id);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						 rs.getString(6));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Users checkUserLogin(String username, String pass) {
		try {
			String query = "SELECT * FROM bannoithat.users where usersname = ? and pass = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, username);
			pStatement.setString(2, pass);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				return new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void signUpUsers(String username, String pass, String fullname, String phone) {
		try {
			String query = "insert bannoithat.users (usersname, pass, fullname, phone) values(?, ?, ?, ?)";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, username);
			pStatement.setString(2, pass);
			pStatement.setString(3, fullname);
			pStatement.setString(4, phone);
			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void signUpAdmin(String username, String pass, String fullname, String phone) {
		try {
			String query = "insert into bannoithat.users values(?, ?, 1, ?, ?)";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, username);
			pStatement.setString(2, pass);
			pStatement.setString(3, fullname);
			pStatement.setString(4, phone);
			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Users checkUserExist(String username) {
		try {
			String query = "SELECT * FROM bannoithat.users where usersname = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, username);

			rs = pStatement.executeQuery();

			while (rs.next()) {
				return new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Product> findByName(String name) {
		try {
			String query = "SELECT * FROM product where pname like ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, "%" + name + "%");
			rs = pStatement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6));
				listProduct.add(p);
			}
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public int getTotalProduct() {
		try {
			String query = "select count(*) from product";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<Product> panigationProducts(int index) {
		try {
			String query = "SELECT * FROM product LIMIT ?,6";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, (index - 1) * 6);
			rs = pStatement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6));
				listProduct.add(p);
			}
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public int getTotalProductByCategory(String cid) {
		try {
			String query = "select count(*) from product where cid = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, cid);
			rs = pStatement.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<Product> panigationProductsByCategory(String cid, int index) {
		try {
			String query = "select * from product where cid = ? LIMIT ?,2";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, cid);
			pStatement.setInt(2, (index - 1) * 2);
			rs = pStatement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6));
				listProduct.add(p);
			}
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public int getTotalProductByName(String pname) {
		try {
			String query = "select count(*) from product where pname like ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, "%" + pname + "%");
			rs = pStatement.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public List<Product> panigationProductsByName(String pname, int index) {
		try {
			String query = "select * from product where pname like ? LIMIT ?,6";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, "%" + pname + "%");
			pStatement.setInt(2, (index - 1) * 6);
			rs = pStatement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6));
				listProduct.add(p);
			}
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public void deleteProduct(String pid) {
		try {
			String query = "delete from bannoithat.product where pid = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, pid);

			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void addProduct(String pname, String image, String price, String description, String cid) {
		try {
			String query = "insert product (pname, image, price, descrip, cid) " + "values (?, ?, ?, ?, ?)";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, pname);
			pStatement.setString(2, image);
			pStatement.setString(3, price);
			pStatement.setString(4, description);
			pStatement.setString(5, cid);
			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void editProduct(String pname, String image, String price, String description, String cid,
			String pid) {
		try {
			String query = "update product set pname=?, image=?, price=?, descrip=?, cid=? where pid = ?";
			connection = new DBConnect().getConnection();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, pname);
			pStatement.setString(2, image);
			pStatement.setString(3, price);
			pStatement.setString(4, description);
			pStatement.setString(5, cid);
			pStatement.setString(6, pid);
			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public int addOrder(Orders orders) { 
		try { String query = "insert orders (customer_name, address, phone, priceTotal) values (?, ?, ?, ?)"; 
		connection = new DBConnect().getConnection();
		 pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); 
		 pStatement.setString(1,orders.getCustomer_name()); 
		 pStatement.setString(2, orders.getAddress()); 
		 pStatement.setString(3, orders.getPhone());
		pStatement.setDouble(4, orders.getPriceTotal()); 
	
		pStatement.executeUpdate();
		ResultSet rs = pStatement.getGeneratedKeys();
		if(rs.next()) {
			return rs.getInt(1);
		}
	  rs.close();
	 
	  
	  } catch (Exception e) { // TODO: handle exception }
	  
	  }
		return 0;
	}
	public void  addOrderDetail(OrderDetail orderDetail) { 
		try { String query = "insert order_detail (idProduct, idOrder, quantity, unitPrice) values (?, ?, ?, ?)"; 
		connection = new DBConnect().getConnection();
		 pStatement = connection.prepareStatement(query); 
		 pStatement.setInt(1,orderDetail.getIdProduct()); 
		 pStatement.setInt(2, orderDetail.getIdOrders()); 
		 pStatement.setInt(3, orderDetail.getQuantity());
		pStatement.setDouble(4, orderDetail.getUnitPrice()); 
	
		pStatement.executeUpdate();
		
	
	  } catch (Exception e) { // TODO: handle exception }
	  
	  }
		
	}
	
}
