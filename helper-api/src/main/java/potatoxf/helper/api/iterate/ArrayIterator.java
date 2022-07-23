package potatoxf.helper.api.iterate;

import java.util.Iterator;

/**
 * 数组迭代器
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class ArrayIterator<T> implements Iterator<T> {

  /** 数组 */
  private final T[] array;
  /** 指针 */
  private int i;

  /**
   * @param array
   */
  @SafeVarargs
  public ArrayIterator(T... array) {
    this.array = array;
    this.i = array == null || array.length == 0 ? -1 : 0;
  }

  /**
   * @return
   */
  @Override
  public boolean hasNext() {
    return i >= 0 && i < array.length;
  }

  /**
   * @return
   */
  @Override
  public T next() {
    return array[i++];
  }

  /** */
  @Override
  public void remove() {
    throw new UnsupportedOperationException("remove");
  }
}
