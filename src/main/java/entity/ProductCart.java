package entity;

public class ProductCart {
	private int quantity;
	private Product product;
	public ProductCart() {
		
	}
	public ProductCart(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "ProductCart [quantity=" + quantity + ", product=" + product + "]";
	}
	
}
