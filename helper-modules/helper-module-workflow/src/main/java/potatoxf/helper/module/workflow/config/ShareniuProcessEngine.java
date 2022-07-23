package potatoxf.helper.module.workflow.config;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

/**
 * @author potatoxf
 * @date 2022/7/1
 */
@ComponentScan(
    value = {
      "org.flowable.ui.modeler.conf",
      "org.flowable.ui.modeler.repository",
      "org.flowable.ui.common.repository",
      "org.flowable.ui.common.tenant",
      "org.flowable.ui.modeler.service",
      "org.flowable.ui.modeler.rest.app",
      "org.flowable.ui.common.rest"
    })
@Configuration
public class ShareniuProcessEngine {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public SpringProcessEngineConfiguration springProcessEngineConfiguration(
      DataSource dataSource, DataSourceTransactionManager dataSourceTransactionManager) {
    SpringProcessEngineConfiguration springProcessEngineConfiguration =
        new SpringProcessEngineConfiguration();

    springProcessEngineConfiguration.setDataSource(dataSource);
    springProcessEngineConfiguration.setTransactionManager(dataSourceTransactionManager);
    springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
    return springProcessEngineConfiguration;
  }

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
