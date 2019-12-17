package com.lti.service;

import java.time.LocalDate;

import com.lti.dao.GenericDao;
import com.lti.dto.OrderDetails;
import com.lti.entity.Order;
import com.lti.entity.Payment;
import com.lti.entity.Product;

public class OrderService {

	public void placeOrder(OrderDetails orderDetails) {
		GenericDao dao = new GenericDao();
		Product product = (Product) dao.fetchByPk(Product.class, orderDetails.getProductId());
		double total = product.getProductPrice() * orderDetails.getQuantity();

		Order order = new Order();
		order.setOrderPrice(total);
		order.setOrderDate(LocalDate.now());
		order.setProduct(product);

		Payment payment = new Payment();
		payment.setPaymentAmount(total);
		payment.setBankName(orderDetails.getBankName());
		payment.setPaymentDate(LocalDate.now());
		
		product.setProductQuantity(product.getProductQuantity() - orderDetails.getQuantity());

		Order orderWithPk = (Order) dao.save(order);
		payment.setOrder(orderWithPk);

		dao.save(payment);
		dao.save(product);

	}

	public void cancelOrder(int orderId) {
		

	}

}
