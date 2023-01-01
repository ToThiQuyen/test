package entity;

public class OrderDetail {
	private int id;
	private int idProduct;
	private int idOrders;
	private int quantity;
	private double unitPrice;
	
	
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(int id, int idProduct, int idOrders, int quantity, double unitPrice) {
		super();
		this.id = id;
		this.idProduct = idProduct;
		this.idOrders = idOrders;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public OrderDetail(int idProduct, int idOrders, int quantity, double unitPrice) {
		
		this.idProduct = idProduct;
		this.idOrders = idOrders;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIdOrders() {
		return idOrders;
	}
	public void setIdOrders(int idOrders) {
		this.idOrders = idOrders;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	@Override
	public String toString() {
		return "OrdeDetail [id=" + id + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", idOrders=" + idOrders
				+ ", idProduct=" + idProduct + "]";
	}
	
	
}
