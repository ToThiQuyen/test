package dao;

import java.util.List;

import entity.Category;
import entity.Product;

public class Test {
	public static void main(String[] args) {
		DAO dao = new DAO();

int tomp = dao.getTotalProductByCategory("1");
	System.out.println(tomp);
	}
}
