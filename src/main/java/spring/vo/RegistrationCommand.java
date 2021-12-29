package spring.vo;

public class RegistrationCommand { //사용자로부터 상품등록 정보를 가져오는 커맨드 객체
	
	private int memberNumber;
	private int categoryNumber;
	private String productTitle;
	private int productPrice;
	private String productName;
	private String productText;
	private String ProductPictureNameURL;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductText() {
		return productText;
	}
	public void setProductText(String productText) {
		this.productText = productText;
	}
	public String getProductPictureNameURL() {
		return ProductPictureNameURL;
	}
	public void setProductPictureNameURL(String productPictureNameURL) {
		ProductPictureNameURL = productPictureNameURL;
	}

	
	
}
