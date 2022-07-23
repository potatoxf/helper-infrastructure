package potatoxf.helper.api.base;

import potatoxf.helper.api.HelperOnArray;
import potatoxf.helper.api.iterate.ArrayIterator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 数组对象建
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public final class ImmutableArray<T> implements Serializable, Iterable<T> {

  private static final long serialVersionUID = 1L;
  private final T[] values;

  public ImmutableArray(T[] values) {
    this.values = values;
  }

  /**
   * 是否数组有元素
   *
   * @return 如果空为 {@code true}，否则 {@code false}
   */
  public final boolean isPresent() {
    return !isEmpty();
  }

  /**
   * 是否数组为空
   *
   * @return 如果空为 {@code true}，否则 {@code false}
   */
  public final boolean isEmpty() {
    return length() == 0;
  }

  /**
   * 数组长度
   *
   * @return 长度
   */
  public final int length() {
    return values.length;
  }

  /**
   * 获取元素
   *
   * @param index 元素索引，任何数值都可以转化成合法索引 {@link HelperOnArray#legalizedIndex(int, int)}
   * @return 返回元素
   */
  public T get(int index) {
    int idx = HelperOnArray.legalizedIndex(index, values.length);
    return values[idx];
  }

  /**
   * 返回数组迭代器
   *
   * @return {@code Iterator<T>}
   */
  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator<T>(values);
  }

  protected final T[] getValues() {
    return values;
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}
