package potatoxf.helper.basic.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author potatoxf
 * @date 2022/6/29
 */
public abstract class AbstractBaseTableWithString<Table extends AbstractBaseTableWithString<Table>>
    extends AbstractBaseTable<String, Table> {

  @ApiModelProperty(value = "全局ID")
  @TableId(type = IdType.ASSIGN_UUID)
  private String gid;
}
