package potatoxf.helper.api.iterate;

import potatoxf.helper.api.Tools;

/**
 * 数组迭代器
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class ArrayIteratorOnInt extends ArrayIterator<Integer> {

  /**
   * @param array
   */
  public ArrayIteratorOnInt(int... array) {
    super(Tools.toObjectValue(array));
  }
  /**
   * @param array
   */
  public ArrayIteratorOnInt(Integer... array) {
    super(array);
  }
}
