package example.shoppee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // bat che do auto send email
public class ShoppeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppeeApplication.class, args);
        System.out.println("=================== Backend Application ===================");
        System.out.println();
        System.out.println("\t\t\thttp://localhost:8080");
        System.out.println();
        System.out.println("===========================================================");
    }

}
