package potatoxf.helper.api.base;

import potatoxf.helper.api.Tools;
import potatoxf.helper.api.Whether;
import potatoxf.helper.api.iterate.ArrayIterator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 数组对象
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class ArrayObject<T> implements Serializable, Iterable<T> {

  private static final long serialVersionUID = 1L;
  private volatile T[] array;

  public ArrayObject(T[] array) {
    this.array = array;
  }

  public ArrayObject(ArrayObject<T> arrayObject) {
    this.array = arrayObject.array;
  }

  public ArrayObject(ArrayObject<T> arrayObject, T[] array) {
    if (Whether.empty(array)) {
      this.array = arrayObject.array;
    }
    int newLen = arrayObject.array.length + array.length;
    T[] newArr = Arrays.copyOf(arrayObject.array, newLen);
    System.arraycopy(array, 0, newArr, arrayObject.array.length, array.length);
    this.array = newArr;
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
    return array.length;
  }

  /**
   * 获取元素
   *
   * @param index 元素索引，任何数值都可以转化成合法索引 {@link Tools#safeAt(Object[], int)}
   * @return 返回元素
   */
  public T get(int index) {
    return Tools.safeAt(array, index);
  }

  /**
   * 添加元素
   *
   * @param arrayObject 数组对象
   */
  public void add(ArrayObject<T> arrayObject) {
    if (arrayObject != null) {
      add(arrayObject.array);
    }
  }

  /**
   * 添加元素
   *
   * @param array 数组
   */
  public void add(T[] array) {
    if (Whether.noEmpty(array)) {
      int newLen = this.array.length + array.length;
      T[] newArr = Arrays.copyOf(this.array, newLen);
      System.arraycopy(array, 0, newArr, this.array.length, array.length);
      this.array = newArr;
    }
  }

  public T[] getArray() {
    return array;
  }

  public ArrayObject<T> setArray(T[] values) {
    this.array = values;
    return this;
  }

  /**
   * 返回数组拷贝迭代器，这也意味着该迭代器线程安全
   *
   * @return {@code Iterator<T>}
   */
  public Iterator<T> copyIterator() {
    return new ArrayIterator<>(Arrays.copyOf(array, array.length));
  }

  /**
   * 返回数组迭代器
   *
   * @return {@code Iterator<T>}
   */
  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator<>(array);
  }

  @Override
  public String toString() {
    return Arrays.toString(array);
  }
}
