package spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.Product;

public class ProductModify implements PreparedStatementCreator{
	
	private Product product;
		
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		System.out.println("성공"+product.getProductTitle());
		PreparedStatement psmt = con.prepareStatement(
				"UPDATE product set productTitle=?, productPrice=?, productText=?, productName=?, "
						+ "productPictureNameURL=?, categoryNumber=?  WHERE ProductNumber=?");
		psmt.setString(1,product.getProductTitle() );
		psmt.setInt(2,product.getProductPrice() );
		psmt.setString(3,product.getProductText() );
		psmt.setString(4,product.getProductName());
		psmt.setString(5,product.getProductPictureNameURL() );
		psmt.setInt(6,product.getCategoryNumber() );
		psmt.setInt(7,product.getProductNumber() );
	
		return psmt;
	}

}
