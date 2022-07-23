package potatoxf.helper.basic.app.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import potatoxf.helper.basic.starter.common.Swagger3Configuration;

/**
 * @author potatoxf
 * @date 2022/7/3
 */
@Import({Swagger3Configuration.class})
@SpringBootApplication
public class AdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdminApplication.class, args);
  }
}
