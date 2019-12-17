package com.lti.test;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.dto.OrderDetails;
import com.lti.entity.Product;
import com.lti.service.OrderService;

public class OrderTest {
	
	@Test
	public void addProduct() {
		Product p =new Product();
		p.setProductName("Samsung");
		p.setProductPrice(25000);
		p.setProductQuantity(10);
		
		Product p2 =new Product();
		p2.setProductName("Redmi");
		p2.setProductPrice(10000);
		p2.setProductQuantity(5);
		
		GenericDao dao= new GenericDao();
		dao.save(p);
		dao.save(p2);
	}
	
	@Test
	public void testSave() {
		OrderService os = new OrderService();
		OrderDetails od = new OrderDetails();

		od.setBankName("ICICI");
		od.setProductId(353);
		od.setQuantity(2);
		od.setUserId(160);

		os.placeOrder(od);
	}

}
