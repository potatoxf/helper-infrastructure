package potatoxf.helper.basic.rest.db;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import potatoxf.helper.basic.common.db.TableGenerator;
import potatoxf.helper.basic.common.db.TableGeneratorProperties;

import javax.sql.DataSource;

/**
 * @author potatoxf
 * @date 2022/7/2
 */
@Api(tags = "数据库表管理")
@RequestMapping("/helper-basic-db")
@RestController
public class TableGeneratorResource {

  @Autowired private DataSource dataSource;
  @Autowired private TableGenerator commonTableGenerator;

  @ApiOperation(value = "生产表结构")
  @GetMapping("/table-generator")
  public Object generate(@ApiParam("模块名称") String module, @ApiParam("表名称") String... tables) {
    TableGeneratorProperties tableGeneratorProperties =
        TableGeneratorProperties.loadModule(module, tables);
    if (tableGeneratorProperties == null) {
      return "无法生产表";
    }
    commonTableGenerator.generate(dataSource, tableGeneratorProperties);
    return "生成数据成功";
  }
}
