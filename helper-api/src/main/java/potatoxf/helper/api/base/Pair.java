package potatoxf.helper.api.base;

import java.io.Serializable;

/**
 * 键值对
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class Pair<K, V> implements Serializable, Cloneable {

  /** 键 */
  private K key;
  /** 值 */
  private V value;

  /**
   * 获取键
   *
   * @return {@code K}
   */
  public K getKey() {
    return key;
  }

  /**
   * 设置键
   *
   * @param key {@code K}
   */
  public Pair<K, V> setKey(K key) {
    this.key = key;
    return this;
  }

  /**
   * 获取值
   *
   * @return {@code V}
   */
  public V getValue() {
    return value;
  }

  /**
   * 设置值
   *
   * @param value {@code V}
   */
  public Pair<K, V> setValue(V value) {
    this.value = value;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return getKey().equals(pair.getKey());
  }

  @Override
  public int hashCode() {
    return key.hashCode();
  }

  @Override
  public String toString() {
    return key + " = " + value;
  }

  /**
   * @return
   */
  @Override
  @SuppressWarnings("unchecked")
  public Pair<K, V> clone() {
    try {
      return (Pair<K, V>) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
