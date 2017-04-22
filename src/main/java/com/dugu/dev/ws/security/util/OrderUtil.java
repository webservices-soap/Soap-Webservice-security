package com.dugu.dev.ws.security.util;

import in.order.online.services.types.Order;
import in.order.online.services.types.Product;
import in.order.online.services.types.Recipt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.dugu.dev.ws.security.model.OrderModel;
import com.dugu.dev.ws.security.model.ProductModel;

public class OrderUtil {

	public static OrderModel pojoMapper(Order order) {
		OrderModel model = new OrderModel();
		List<ProductModel> products = new ArrayList<>();
		model.setName(order.getName());
		model.setMobile(order.getMobile());
		model.setEmailId(order.getEmail());
		model.setGender(order.getGender());
		ProductModel productModel = null;
		for (Product product : order.getProduct()) {
			productModel=new ProductModel();
			productModel.setProductName(product.getProductName());
			productModel.setQuantity(product.getQuantity());
			productModel.setProductType(product.getProductType());
			products.add(productModel);
		}
		model.setProducts(products);
		return model;
	}

	public static Recipt generateRecipt() {
		Recipt recipt = new Recipt();
		recipt.setProductID(UUID.randomUUID().toString());
		recipt.setPrice(new Random().nextInt(524));
		recipt.setPurchaseDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a")
				.format(new Date()));
		return recipt;
	}
}
