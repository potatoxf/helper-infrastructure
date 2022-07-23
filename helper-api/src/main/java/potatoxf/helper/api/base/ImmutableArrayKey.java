package potatoxf.helper.api.base;

/**
 * 数组对象键
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public final class ImmutableArrayKey<T> extends ArrayKey<T> {

  private static final long serialVersionUID = 1L;

  public ImmutableArrayKey(T[] array) {
    super(array);
  }

  public ImmutableArrayKey(ArrayObject<T> arrayObject) {
    super(arrayObject);
  }

  public ImmutableArrayKey(ArrayObject<T> arrayObject, T[] array) {
    super(arrayObject, array);
  }

  @Override
  public void add(T[] array) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }

  @Override
  public void add(ArrayObject<T> arrayObject) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }

  @Override
  public ArrayObject<T> setArray(T[] values) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }
}
