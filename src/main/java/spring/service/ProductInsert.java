package spring.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.vo.Product;

public class ProductInsert implements PreparedStatementCreator{
	
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
				"INSERT INTO product VALUES(SEQ_PRODUCTNUMBER.NEXTVAL,?,?,?,?,?,0,SYSDATE,?,?)");
		psmt.setString(1,product.getProductTitle() );
		psmt.setInt(2,product.getProductPrice() );
		psmt.setString(3,product.getProductText() );
		psmt.setString(4,product.getProductName());
		psmt.setString(5,product.getProductPictureNameURL() );
		psmt.setInt(6,product.getMemberNumber() );
		psmt.setInt(7,product.getCategoryNumber() );
	
		return psmt;
	}
	
	

}
