package potatoxf.helper.basic.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author potatoxf
 * @date 2022/6/29
 */
@Getter
@Setter
@ApiModel(value = "基本数据")
public abstract class AbstractBaseTable<
        PrimaryKey extends Serializable & Comparable<PrimaryKey>,
        Table extends AbstractBaseTable<PrimaryKey, Table>>
    implements TableSupportPrimaryKey<PrimaryKey, Table>,
        TableSupportCommon<PrimaryKey, Table>,
        TableSupportDeleteFlag<PrimaryKey, Table>,
        TableSupportStatusFlag<PrimaryKey, Table> {

  @ApiModelProperty(value = "逻辑删除标识")
  @TableLogic
  @TableField(value = DEFAULT_FIELD_NAME_DELETE_FLAG, fill = FieldFill.INSERT)
  private int deleteFlag;

  @ApiModelProperty(value = "状态标识")
  @TableField(value = DEFAULT_FIELD_NAME_STATUS_FLAG, fill = FieldFill.INSERT)
  private int statusFlag;

  @ApiModelProperty(value = "乐观锁")
  @Version
  @TableField
  private int revision;

  @ApiModelProperty(value = "创建人")
  @TableField(value = DEFAULT_FIELD_NAME_CREATED_BY, fill = FieldFill.INSERT)
  private String createdBy;

  @ApiModelProperty(value = "创建时间")
  @TableField(value = DEFAULT_FIELD_NAME_CREATED_TIME, fill = FieldFill.INSERT)
  private Date createdTime;

  @ApiModelProperty(value = "更新人")
  @TableField(value = DEFAULT_FIELD_NAME_UPDATED_BY, fill = FieldFill.INSERT_UPDATE)
  private String updatedBy;

  @ApiModelProperty(value = "更新时间")
  @TableField(value = DEFAULT_FIELD_NAME_UPDATED_TIME, fill = FieldFill.INSERT_UPDATE)
  private Date updatedTime;

  @ApiModelProperty(value = "起始创建时间")
  @TableField(exist = false)
  private Date createdTimeStart;

  @ApiModelProperty(value = "结束创建时间")
  @TableField(exist = false)
  private Date createdTimeEnd;

  @ApiModelProperty(value = "起始更新时间")
  @TableField(exist = false)
  private Date updatedTimeStart;

  @ApiModelProperty(value = "结束更新时间")
  @TableField(exist = false)
  private Date updatedTimeEnd;

  @ApiModelProperty(value = "参数")
  @TableField(exist = false)
  private Map<String, Object> params;

  /**
   * 获取删除状态
   *
   * @return
   */
  @Override
  public final int getDeleteFlag() {
    return this.deleteFlag;
  }

  /**
   * 设置删除状态
   *
   * @param deleteFlag
   * @return {@link #this$()}
   */
  @Override
  public final Table setDeleteFlag(int deleteFlag) {
    this.deleteFlag = deleteFlag;
    return this$();
  }

  /**
   * 获取状态值
   *
   * @return 状态值
   */
  @Override
  public final int getStatusFLag() {
    return this.statusFlag;
  }

  /**
   * 设置状态值
   *
   * @param statusFlag 状态值
   * @return {@link #this$()}
   */
  @Override
  public final Table setStatusFlag(int statusFlag) {
    this.statusFlag = statusFlag;
    return this$();
  }

  @Override
  public final String getCreatedBy() {
    return this.createdBy;
  }

  @Override
  public final Table setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
    return this$();
  }

  @Override
  public final Date getCreatedTime() {
    return this.createdTime;
  }

  @Override
  public final Table setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
    return this$();
  }

  @Override
  public final String getUpdatedBy() {
    return this.updatedBy;
  }

  @Override
  public final Table setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this$();
  }

  @Override
  public final Date getUpdatedTime() {
    return this.updatedTime;
  }

  @Override
  public final Table setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
    return this$();
  }

  @Override
  public final int getRevision() {
    return this.revision;
  }

  @Override
  public final Table setRevision(int revision) {
    this.revision = revision;
    return this$();
  }
}
