package potatoxf.helper.basic.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author potatoxf
 * @date 2022/6/29
 */
public abstract class AbstractBaseTreeTable<
        PrimaryKey extends Serializable & Comparable<PrimaryKey>,
        Table extends AbstractBaseTreeTable<PrimaryKey, Table>>
    extends AbstractBaseTable<PrimaryKey, Table> implements TableSupportTree<PrimaryKey, Table> {

  @ApiModelProperty(value = "逻辑删除标识")
  @TableLogic
  @TableField(value = DEFAULT_FIELD_NAME_PARENT, fill = FieldFill.INSERT)
  private PrimaryKey parent;
}
