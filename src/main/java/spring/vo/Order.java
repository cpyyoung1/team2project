package spring.vo;

import java.util.Date;

public class Order {

	private int orderNumber;
	private String productPicture;
	private String productName;
	private Date orderDate;
	private int productPrice;
	private int sellerNumber;
	private String sellerNickname;
	private String memberNickname;
	private int memberNumber;
	
	public Order(int orderNumber, String productPicture, String productName, Date orderDate, int productPrice,
			int sellerNumber, String sellerNickname, String memberNickname, int memberNumber) {
		this.orderNumber = orderNumber;
		this.productPicture = productPicture;
		this.productName = productName;
		this.orderDate = orderDate;
		this.productPrice = productPrice;
		this.sellerNumber = sellerNumber;
		this.sellerNickname = sellerNickname;
		this.memberNickname = memberNickname;
		this.memberNumber = memberNumber;
	}
	
	public Order(String productPicture, String productName, int productPrice,
			int sellerNumber, String sellerNickname, String memberNickname, int memberNumber) {
		this.productPicture = productPicture;
		this.productName = productName;
		this.productPrice = productPrice;
		this.sellerNumber = sellerNumber;
		this.sellerNickname = sellerNickname;
		this.memberNickname = memberNickname;
		this.memberNumber = memberNumber;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getSellerNumber() {
		return sellerNumber;
	}
	public void setSellerNumber(int sellerNumber) {
		this.sellerNumber = sellerNumber;
	}
	public String getSellerNickname() {
		return sellerNickname;
	}
	public void setSellerNickname(String sellerNickname) {
		this.sellerNickname = sellerNickname;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	

	
	
}
