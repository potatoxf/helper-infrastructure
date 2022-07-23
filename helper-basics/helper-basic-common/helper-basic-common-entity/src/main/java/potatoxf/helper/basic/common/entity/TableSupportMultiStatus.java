package potatoxf.helper.basic.common.entity;

import potatoxf.helper.api.This;

import java.io.Serializable;

/**
 * 表格支持多位状态值
 *
 * @author potatoxf
 * @date 2021/6/19
 */
public interface TableSupportMultiStatus<
        PrimaryKey extends Serializable & Comparable<PrimaryKey>,
        Table extends
            TableSupportCommon<PrimaryKey, Table> & TableSupportMultiStatus<PrimaryKey, Table>>
    extends This<Table> {

  String DEFAULT_FIELD_NAME_MULTI_STATUS = "MULTI_STATUS";

  /**
   * 返回多位状态值
   *
   * @return 多位状态值
   */
  int getMultiStatus();

  /**
   * 设置多位状态值
   *
   * @param multiStatus 多位状态值
   * @return {@link #this$()}
   */
  Table setMultiStatus(int multiStatus);

  /**
   * 获取多位状态值属性名称
   *
   * @return {@link String}
   */
  default String getMultiStatusFieldName() {
    return DEFAULT_FIELD_NAME_MULTI_STATUS;
  }
}
