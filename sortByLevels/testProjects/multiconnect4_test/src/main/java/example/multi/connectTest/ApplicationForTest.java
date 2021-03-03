package example.multi.connectTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"example.multi.connectTest"})
public class ApplicationForTest {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationForTest.class, args);
    }
}
