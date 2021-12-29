package spring.vo;

public class Like {
	
	private int likeNumber;
	private String productName;
	private String sellerNickname;
	private int productPrice;
	private int memberNumber;
	private int productNumber;
	private String productPicture;

	public Like(String productName, String sellerNickname, int productPrice, int memberNumber,
			int productNumber, String productPicture) {
		this.productName = productName;
		this.sellerNickname = sellerNickname;
		this.productPrice = productPrice;
		this.memberNumber = memberNumber;
		this.productNumber = productNumber;
		this.productPicture = productPicture;
	}
	
	

	public Like(int likeNumber, String productName, String sellerNickname, int productPrice, int memberNumber,
			int productNumber, String productPicture) {
		this.likeNumber = likeNumber;
		this.productName = productName;
		this.sellerNickname = sellerNickname;
		this.productPrice = productPrice;
		this.memberNumber = memberNumber;
		this.productNumber = productNumber;
		this.productPicture = productPicture;
	}



	public String getProductPicture() {
		return productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSellerNickname() {
		return sellerNickname;
	}

	public void setSellerNickname(String sellerNickname) {
		this.sellerNickname = sellerNickname;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	
}
