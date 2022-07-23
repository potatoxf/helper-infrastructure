package potatoxf.helper.basic.logic.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import potatoxf.helper.basic.common.db.TableGeneratorProperties;

/**
 * @author potatoxf
 * @date 2022/7/2
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties("helper.basic.db")
public class TableGeneratorPropertiesConfig extends TableGeneratorProperties {
}
