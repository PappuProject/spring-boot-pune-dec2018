
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.AppConfig;
import com.demo.spring.service.HrService;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		HrService service = (HrService) ctx.getBean("hrService");
		
		System.out.println(service.registerEmployee(100, "Raju", "Pune", 89000));
	}


}
