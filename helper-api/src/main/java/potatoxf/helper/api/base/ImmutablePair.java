package potatoxf.helper.api.base;

import java.util.Map;

/**
 * 不靠变的键值对
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public final class ImmutablePair<K, V> extends Pair<K, V> {

  /**
   * @param entry
   */
  public ImmutablePair(Map.Entry<K, V> entry) {
    this(entry.getKey(), entry.getValue());
  }

  /**
   * @param key
   * @param value
   */
  public ImmutablePair(K key, V value) {
    super.setKey(key);
    super.setValue(value);
  }

  /**
   * @param key {@code K}
   * @return
   */
  @Override
  public ImmutablePair<K, V> setKey(K key) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }

  /**
   * @param value {@code V}
   * @return
   */
  @Override
  public ImmutablePair<K, V> setValue(V value) {
    throw new UnsupportedOperationException("Does not support modifying values");
  }

  /**
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * @return
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
