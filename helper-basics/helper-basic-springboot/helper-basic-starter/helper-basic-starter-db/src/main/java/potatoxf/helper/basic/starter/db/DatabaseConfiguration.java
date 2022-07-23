package potatoxf.helper.basic.starter.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import potatoxf.helper.basic.common.db.CommonTableGenerator;
import potatoxf.helper.basic.common.db.TableGenerator;
import potatoxf.helper.basic.logic.db.TableGeneratorPropertiesConfig;

import javax.sql.DataSource;

/**
 * @author potatoxf
 * @date 2022/7/2
 */
@ComponentScan({"potatoxf.helper.basic.logic.db", "potatoxf.helper.basic.rest.db"})
@Configuration
public class DatabaseConfiguration {

  @Autowired DataSource dataSource;

  @Bean
  public TableGenerator tableGenerator(
      TableGeneratorPropertiesConfig tableGeneratorPropertiesConfig) {
    CommonTableGenerator commonTableGenerator = new CommonTableGenerator();
    commonTableGenerator.setDefaultTableGeneratorProperties(tableGeneratorPropertiesConfig);
    return commonTableGenerator;
  }
}
