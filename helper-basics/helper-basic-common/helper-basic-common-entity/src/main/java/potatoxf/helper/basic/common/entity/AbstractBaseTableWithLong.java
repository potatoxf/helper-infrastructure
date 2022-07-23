package potatoxf.helper.basic.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author potatoxf
 * @date 2022/6/29
 */
public abstract class AbstractBaseTableWithLong<Table extends AbstractBaseTableWithLong<Table>>
    extends AbstractBaseTable<Long, Table> {

  @ApiModelProperty(value = "全局ID")
  @TableId(type = IdType.ASSIGN_ID)
  private Long gid;
}
