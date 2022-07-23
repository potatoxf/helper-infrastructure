package potatoxf.helper.basic.common.entity;

import potatoxf.helper.api.This;

import java.io.Serializable;

/**
 * 树形实体
 *
 * @author potatoxf
 * @date 2021/6/19
 */
public interface TableSupportStatusFlag<
        PrimaryKey extends Serializable & Comparable<PrimaryKey>,
        Table extends
            TableSupportCommon<PrimaryKey, Table> & TableSupportStatusFlag<PrimaryKey, Table>>
    extends This<Table> {

  String DEFAULT_FIELD_NAME_STATUS_FLAG = "STATUS_FLAG";

  /**
   * 获取状态值
   *
   * @return 状态值
   */
  int getStatusFLag();

  /**
   * 设置状态值
   *
   * @param statusFlag 状态值
   * @return {@link #this$()}
   */
  Table setStatusFlag(int statusFlag);

  /**
   * 获取状态值属性名称
   *
   * @return {@link String}
   */
  default String getStatusFlagFieldName() {
    return DEFAULT_FIELD_NAME_STATUS_FLAG;
  }
}
