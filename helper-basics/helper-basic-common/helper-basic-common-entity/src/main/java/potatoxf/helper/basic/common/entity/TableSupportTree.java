package potatoxf.helper.basic.common.entity;

import potatoxf.helper.api.This;
import potatoxf.helper.api.TreeTableNode;

import java.io.Serializable;

/**
 * 树形实体
 *
 * @author potatoxf
 * @date 2021/6/19
 */
public interface TableSupportTree<
        PrimaryKey extends Serializable & Comparable<PrimaryKey>,
        Table extends
            TableSupportPrimaryKey<PrimaryKey, Table> & TableSupportTree<PrimaryKey, Table>>
    extends TreeTableNode<PrimaryKey, TableSupportTree<PrimaryKey, Table>>, This<Table> {

  String DEFAULT_FIELD_NAME_PARENT = "PARENT";
  /**
   * 获取父级主键
   *
   * @return 父级主键
   */
  PrimaryKey getParent();

  /**
   * 设置父级主键
   *
   * @param primaryKey 父级主键
   */
  void setParent(PrimaryKey primaryKey);

  /**
   * 获取父级主键属性名称
   *
   * @return {@link String}
   */
  default String getParentFieldName() {
    return DEFAULT_FIELD_NAME_PARENT;
  }

  /**
   * 获取当前ID
   *
   * @return {@code I}
   */
  @Override
  default PrimaryKey getKey() {
    return this$().getPrimaryKey();
  }

  /**
   * 获取当前父级ID
   *
   * @return {@code I}
   */
  @Override
  default PrimaryKey getParentKey() {
    return getParent();
  }
}
