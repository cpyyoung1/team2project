package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import spring.service.ProductInsert;
import spring.service.ProductModify;
import spring.vo.Like;
import spring.vo.Member;
import spring.vo.Order;
import spring.vo.Product;

public class ProductDAO {

	private JdbcTemplate jdbcTemplate;
	private Product product;
	private Member member;
	private Like like;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 제품 등록하기
	public void insert(Product product) {
		ProductInsert productInsert = new ProductInsert();
		productInsert.setProduct(product);

		int jdbc =jdbcTemplate.update(productInsert);

		System.out.println("쿼리성공"+jdbc);

	}
	
	// 제품 수정등록하기
		public void modify(Product product) {
			ProductModify productModify = new ProductModify();
			productModify.setProduct(product);
			
			int jdbc =jdbcTemplate.update(productModify);

			System.out.println("쿼리성공"+jdbc);

		}

	//전체 제품 조회
	public List<Product> selectAll() {
		List<Product> result = jdbcTemplate.query(
				"SELECT * FROM product ORDER BY productNumber ASC",// 첫번째 매개값 : 쿼리문
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product product = new Product(
								rs.getInt("productNumber"),
								rs.getString("productTitle"),
								rs.getInt("productPrice"),
								rs.getString("productText"),
								rs.getString("productName"),
								rs.getString("productPictureNameURL"),
								rs.getInt("productCount"),
								rs.getDate("productDate"),
								rs.getInt("memberNumber"),
								rs.getInt("categoryNumber")
								);
						product.setProductNumber(rs.getInt("productNumber"));
						return product;
					}
				});
		return result;
	}

	//productNumber를 통해 제품 정보 불러오는 기능
	public Product selectByproductNumber(int productNumber) {
		List<Product> result = jdbcTemplate.query(
				"SELECT * FROM product WHERE productNumber=?", 
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product product = new Product(
								rs.getInt("productNumber"),
								rs.getString("productTitle"),
								rs.getInt("productPrice"),
								rs.getString("productText"),
								rs.getString("productName"),
								rs.getString("productPictureNameURL"),
								rs.getInt("productCount"),
								rs.getDate("productDate"),
								rs.getInt("memberNumber"),
								rs.getInt("categoryNumber")

								);
						product.setProductNumber(rs.getInt("productNumber"));
						return product;
					}

				},productNumber);

		return result.isEmpty()?null:result.get(0);

	}
	
	//제품번호를 이용해 관리자가 제품을 삭제하는 기능
	public void delete(Product product) {
		jdbcTemplate.update(
				"DELETE FROM product WHERE productNumber=?",
				product.getProductNumber()
				);
	}
	
	//조회수 올려주는 기능
	public void plusCount(Product product) {
		jdbcTemplate.update(
				"UPDATE product set productCount=? WHERE ProductNumber=?",
				(product.getProductCount()+1),
				product.getProductNumber()
				);
	}
	

	// 상품 수정 기능
//	public void modifyProduct(Product product) {
//		jdbcTemplate.update(
//				"UPDATE product set productTitle=?, productPrice=?, productText=?, productName=?, "
//				+ "productPictureNameURL=?, categoryNumber=?  WHERE ProductNumber=?",
//				product.getProductTitle(),
//				product.getProductPrice(),
//				product.getProductText(),
//				product.getProductName(),
//				product.getProductPictureNameURL(),
//				product.getCategoryNumber(),
//				product.getProductNumber()
//				);
//	}
	
	// 찜하기 기능
	public void like(Like like) {
		 jdbcTemplate.update(
		            new PreparedStatementCreator() {

		               @Override
		               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		                  PreparedStatement psmt = con.prepareStatement(
		                        "INSERT INTO likey VALUES(likey_seq.NEXTVAL,?,?,?,?,?,?)");
		                  psmt.setString(1,like.getProductName()); 
		                  psmt.setString(2,like.getSellerNickname());   
		                  psmt.setInt(3,like.getProductPrice());   
		                  psmt.setInt(4,like.getMemberNumber());   
		                  psmt.setInt(5,like.getProductNumber());
		                  psmt.setString(6,like.getProductPicture());
		                  return psmt;
		               }
		            });
	}
	
	// 찜 삭제 기능
	public void deleteLike(int likeNumber) {
		jdbcTemplate.update(
				"DELETE FROM likey WHERE likeNumber=?",
				likeNumber
				);
	}
	
	// 제품에 대한 전체 찜 삭제기능
	public void likeProductDelete(Product product) {
		jdbcTemplate.update(
				"DELETE FROM likey WHERE productNumber=?",
				product.getProductNumber()
				);
	}
	
	// 찜목록 리스트 불러오기
	public List<Like> likeSelectAll() {
		List<Like> result = jdbcTemplate.query(
				"SELECT * FROM likey ORDER BY likeNumber ASC",// 첫번째 매개값 : 쿼리문
				new RowMapper<Like>() {

					@Override
					public Like mapRow(ResultSet rs, int rowNum) throws SQLException {
						Like like = new Like(
								rs.getInt("likeNumber"),
								rs.getString("productName"),
								rs.getString("sellerNickname"),
								rs.getInt("productPrice"),
								rs.getInt("memberNumber"),
								rs.getInt("productNumber"),
								rs.getString("productPicture")
								);
						like.setLikeNumber(rs.getInt("likeNumber"));
						return like;
					}
				});
		return result;
	}
	
	// 주문내역 저장 기능
		public void order(Order order) {
			 jdbcTemplate.update(
			            new PreparedStatementCreator() {

			               @Override
			               public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			                  PreparedStatement psmt = con.prepareStatement(
			                        "INSERT INTO orderHistory VALUES(order_seq.NEXTVAL,?,?,SYSDATE,?,?,?,?,?)");
			                  psmt.setString(1,order.getProductPicture());
			                  psmt.setString(2,order.getProductName()); 
			                  psmt.setInt(3,order.getProductPrice()); 
			                  psmt.setInt(4,order.getSellerNumber()); 
			                  psmt.setString(5,order.getSellerNickname());
			                  psmt.setString(6,order.getMemberNickname());
			                  psmt.setInt(7,order.getMemberNumber()); 
			                  return psmt;
			               }
			            });
		}
		
		// 주문내역 불러오기 기능
		public List<Order> orderSelectAll() {
			List<Order> result = jdbcTemplate.query(
					"SELECT * FROM orderHistory ORDER BY orderNumber DESC",// 첫번째 매개값 : 쿼리문
					new RowMapper<Order>() {

						@Override
						public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
							Order order = new Order(
									rs.getInt("orderNumber"),
									rs.getString("productPicture"),
									rs.getString("productName"),
									rs.getDate("orderDate"),
									rs.getInt("productPrice"),
									rs.getInt("sellerNumber"),
									rs.getString("sellerNickname"),
									rs.getString("memberNickname"),
									rs.getInt("memberNumber")
									);
							order.setOrderNumber(rs.getInt("orderNumber"));
							return order;
						}
					});
			return result;
		}
		
		
		//제품 이름 검색기능
		public List<Product> findProductName(String productName)
		{
			productName = "%"+productName+"%";
			
			String sql = "SELECT * FROM product WHERE productName like ?";
			List<Product> results = jdbcTemplate.query(sql,
					new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product(
							rs.getInt("productNumber"),
							rs.getString("productTitle"),
							rs.getInt("productPrice"),
							rs.getString("productText"),
							rs.getString("productName"),
							rs.getString("productPictureNameURL"),
							rs.getInt("productCount"),
							rs.getDate("productDate"),
							rs.getInt("memberNumber"),
							rs.getInt("categoryNumber")
							);
					product.setProductNumber(rs.getInt("productNumber"));
					return product;
				}
			},productName);
			return results;
		}


}
