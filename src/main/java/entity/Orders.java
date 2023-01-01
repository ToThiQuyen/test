package entity;

public class Orders {
	private int idOrders;
	private String customer_name;
	private String address;
	private String phone;
	private double priceTotal;
	public Orders() {
		
	}
	public Orders(int idOrders, String customer_name, String address, String phone, double priceTotal) {
		super();
		this.idOrders = idOrders;
		this.customer_name = customer_name;
		this.address = address;
		this.phone = phone;
		this.priceTotal = priceTotal;
	}
	public Orders(String customer_name, String address, String phone, double priceTotal) {
		super();
		this.customer_name = customer_name;
		this.address = address;
		this.phone = phone;
		this.priceTotal = priceTotal;
	}
	public int getIdOrders() {
		return idOrders;
	}
	public void setIdOrders(int idOrders) {
		this.idOrders = idOrders;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	@Override
	public String toString() {
		return "Orders [idOrders=" + idOrders + ", customer_name=" + customer_name + ", address=" + address + ", phone="
				+ phone + ", priceTotal=" + priceTotal + "]";
	}
	
	
}
