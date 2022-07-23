package potatoxf.helper.api.base;

import java.util.Arrays;

/**
 * 数组对象建
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class ArrayKey<T> extends ArrayObject<T> {
  private static final long serialVersionUID = 1L;

  public ArrayKey(T[] array) {
    super(array);
  }

  public ArrayKey(ArrayObject<T> arrayObject) {
    super(arrayObject);
  }

  public ArrayKey(ArrayObject<T> arrayObject, T[] array) {
    super(arrayObject, array);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ArrayObject)) return false;
    ArrayObject<?> that = (ArrayObject<?>) o;
    return Arrays.equals(getArray(), that.getArray());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(getArray());
  }
}
