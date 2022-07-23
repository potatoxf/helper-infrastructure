package potatoxf.helper.basic.app.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import potatoxf.helper.basic.common.db.TableGenerator;
import potatoxf.helper.basic.common.db.TableGeneratorProperties;

import javax.sql.DataSource;

/**
 * @author potatoxf
 * @date 2022/7/3
 */
@SpringBootTest
public class AdminApplicationTest {

  @Autowired DataSource dataSource;
  @Autowired TableGenerator tableGenerator;

  @Autowired TableGeneratorProperties tableGeneratorProperties;

  @Test
  public void generate() {
    tableGenerator.generate(dataSource, tableGeneratorProperties);
  }
}
