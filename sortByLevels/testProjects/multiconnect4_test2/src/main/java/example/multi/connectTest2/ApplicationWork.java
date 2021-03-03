package example.multi.connectTest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("example.multi.connectTest2")
public class ApplicationWork {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWork.class, args);
    }
}
