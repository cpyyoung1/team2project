package spring.vo;

import java.util.Date;

public class ProductAuthInfo {
	
	private int productNumber;
	private String productTitle;
	private int productPrice;
	private String productText;
	private String productName;
	private String productPictureNameURL;
	private int productCount;
	private Date productDate;
	private int memberNumber;
	private int categoryNumber;
	
	public ProductAuthInfo(int productNumber, String productTitle, int productPrice, String productText,
			String productName, String productPictureNameURL, int productCount, Date productDate, int memberNumber,
			int categoryNumber) {
		this.productNumber = productNumber;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productText = productText;
		this.productName = productName;
		this.productPictureNameURL = productPictureNameURL;
		this.productCount = productCount;
		this.productDate = productDate;
		this.memberNumber = memberNumber;
		this.categoryNumber = categoryNumber;
	}
	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductText() {
		return productText;
	}

	public void setProductText(String productText) {
		this.productText = productText;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPictureNameURL() {
		return productPictureNameURL;
	}

	public void setProductPictureNameURL(String productPictureNameURL) {
		this.productPictureNameURL = productPictureNameURL;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	
	
}
