package potatoxf.helper.api.iterate;

import potatoxf.helper.api.Tools;

/**
 * 数组迭代器
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class ArrayIteratorOnLong extends ArrayIterator<Long> {

  /**
   * @param array
   */
  public ArrayIteratorOnLong(long... array) {
    super(Tools.toObjectValue(array));
  }
  /**
   * @param array
   */
  public ArrayIteratorOnLong(Long... array) {
    super(array);
  }
}
