package potatoxf.helper.api.base;

/**
 * 不靠变的二重键
 *
 * @author potatoxf
 * @date 2021/8/24
 */
public final class ImmutablePairKey<K1, K2> extends PairKey<K1, K2> {

  private ImmutablePairKey(K1 k1, K2 k2) {
    super.setFirstElement(k1);
    super.setSecondElement(k2);
  }

  public static <K1, K2> ImmutablePairKey<K1, K2> of(K1 k1, K2 k2) {
    return new ImmutablePairKey<>(k1, k2);
  }

  /**
   * @param k1
   */
  @Override
  public void setFirstElement(K1 k1) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }

  /**
   * @param k2
   */
  @Override
  public void setSecondElement(K2 k2) {
    throw new UnsupportedOperationException("Does not support modifier keys");
  }
}
