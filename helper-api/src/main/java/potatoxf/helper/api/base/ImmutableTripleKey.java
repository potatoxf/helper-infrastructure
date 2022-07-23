package potatoxf.helper.api.base;

/**
 * 不靠变的三重键
 *
 * @author potatoxf
 * @date 2021/8/24
 */
public final class ImmutableTripleKey<K1, K2, K3> extends TripleKey<K1, K2, K3> {
  /**
   * @param k1
   * @param k2
   * @param k3
   */
  private ImmutableTripleKey(K1 k1, K2 k2, K3 k3) {
    super.setFirstKey(k1);
    super.setSecondKey(k2);
    super.setThirdKey(k3);
  }

  public static <K1, K2, K3> ImmutableTripleKey<K1, K2, K3> of(K1 k1, K2 k2, K3 k3) {
    return new ImmutableTripleKey<>(k1, k2, k3);
  }

  /**
   * @param firstKey
   */
  @Override
  public void setFirstKey(K1 firstKey) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }

  /**
   * @param secondKey
   */
  @Override
  public void setSecondKey(K2 secondKey) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }

  /**
   * @param thirdKey
   */
  @Override
  public void setThirdKey(K3 thirdKey) {
    throw new UnsupportedOperationException("Does not support modifier keys");
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

  /**
   * @return
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
