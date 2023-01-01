package entity;

public class Product {
	private int pid;
	private String pname;
	private String image;
	private String price;
	
	private String descrip;
	private String cid;
	public Product(int pid, String pname, String image, String price, String descrip, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.image = image;
		this.price = price;
		this.descrip = descrip;
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", image=" + image + ", price=" + price  
				+ ", descrip=" + descrip + ", cid=" + cid + "]";
	}


}
