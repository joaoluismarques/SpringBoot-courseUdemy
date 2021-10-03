package com.joaoluis.courseudemy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaoluis.courseudemy.entities.Category;
import com.joaoluis.courseudemy.entities.Order;
import com.joaoluis.courseudemy.entities.OrderItem;
import com.joaoluis.courseudemy.entities.Payment;
import com.joaoluis.courseudemy.entities.Product;
import com.joaoluis.courseudemy.entities.User;
import com.joaoluis.courseudemy.entities.enums.OrderStatus;
import com.joaoluis.courseudemy.repositories.CategoryRepository;
import com.joaoluis.courseudemy.repositories.OrderItemRepository;
import com.joaoluis.courseudemy.repositories.OrderRepository;
import com.joaoluis.courseudemy.repositories.ProductRepository;
import com.joaoluis.courseudemy.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Natalia", "nati@gmail.com", "9921-7512", "natalia789");
		User u2 = new User(null, "Matheus", "math@gmail.com", "8856-2361", "74125823");
		
		Order o1 = new Order(null, Instant.parse("2021-09-28T16:09:30Z"), OrderStatus.WAITING_PAYMENT, u1);
 		Order o2 = new Order(null, Instant.parse("2021-09-28T09:31:58Z"), OrderStatus.PAID, u2);
 		
 		Product p1 = new Product(null, "Tv", "Samsumg", 1950.00, " ");
 		Product p2 = new Product(null, "Livro", "Orgulho e preconceito, romance", 64.00, " ");
 		
 		Category cat1 = new Category(null, "Eletronics");
 		Category cat2 = new Category(null, "Books");
 		Category cat3 = new Category(null, "Computers");
 		Category cat4 = new Category(null, "Fashion");
 		
 		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
 		OrderItem oi2 = new OrderItem(o2, p2, 4, p2.getPrice());
 		
 		p1.getCategories().add(cat1);
 		p2.getCategories().add(cat2);	
 		
 		Payment pay1 = new Payment(null, Instant.parse("2021-09-29T07:00:02Z"), o2); 		
		o2.setPayment(pay1);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));		
		orderRepository.saveAll(Arrays.asList(o1, o2));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		productRepository.saveAll(Arrays.asList(p1, p2));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2));
	}		
}
