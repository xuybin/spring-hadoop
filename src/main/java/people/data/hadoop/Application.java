package people.data.hadoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:hadoop-spring.xml")
public class Application {

	public static void main(String[] args) {
		//    System.setProperty("hadoop.home.dir", "D:\\\\dev_evn\\\\hadoop-2.7.3");
		SpringApplication.run(Application.class, args);
	}
}
