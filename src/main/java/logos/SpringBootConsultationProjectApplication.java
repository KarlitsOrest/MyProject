package logos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import logos.entity.ItemsMake;
// import logos.entity.Product;
import logos.entity.UserEntity;
import logos.entity.enumeration.Role;
import logos.repository.MakerRepository;
// import logos.repository.ProductRepository;
import logos.repository.UserRepository;

@SpringBootApplication
public class SpringBootConsultationProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootConsultationProjectApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsultationProjectApplication.class, args);
		addAdmin(context);
		addItemsMake(context);
	//	addProduct(context);
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "admin@gmail.com";
		String adminPassword = "123";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByEmail(adminEmail);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_ADMIN);
			
			userRepository.save(entity);
		}
	}
	static void addItemsMake(ConfigurableApplicationContext context) {
		String title = "apple";
		MakerRepository makerRepository = context.getBean(MakerRepository.class);
		ItemsMake make = makerRepository.findMakerByName(title);
		if(make==null) {
			make = new ItemsMake();
			make.setTitle(title);
			makerRepository.save(make);
		}
	}
//	static void addProduct(ConfigurableApplicationContext context) {
//		String title = "6S"; 
//		
//		
//		ProductRepository productRepository = context.getBean(ProductRepository.class);
//		Product product = productRepository.findProductByTitle(title);
//		if(product==null) {
//			product = new Product();
//			product.setTitle(title);
//			productRepository.save(product);
//		}
//	}
	
}
