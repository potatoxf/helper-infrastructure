package potatoxf.helper.api.base;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Objects;

/**
 * 三重键
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class TripleKey<F, S, T> implements Serializable, Cloneable {
  @Nullable private F firstKey;
  @Nullable private S secondKey;
  @Nullable private T thirdKey;

  @Nullable
  public F getFirstKey() {
    return firstKey;
  }

  public void setFirstKey(@Nullable F firstKey) {
    this.firstKey = firstKey;
  }

  @Nullable
  public S getSecondKey() {
    return secondKey;
  }

  public void setSecondKey(@Nullable S secondKey) {
    this.secondKey = secondKey;
  }

  @Nullable
  public T getThirdKey() {
    return thirdKey;
  }

  public void setThirdKey(@Nullable T thirdKey) {
    this.thirdKey = thirdKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TripleKey<?, ?, ?> tripleKey = (TripleKey<?, ?, ?>) o;
    return Objects.equals(firstKey, tripleKey.firstKey)
        && Objects.equals(secondKey, tripleKey.secondKey)
        && Objects.equals(thirdKey, tripleKey.thirdKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstKey, secondKey, thirdKey);
  }

  @Override
  public String toString() {
    return "(" + firstKey + "," + secondKey + "," + thirdKey + ")";
  }

  @Override
  public TripleKey<F, S, T> clone() {
    try {
      TripleKey<F, S, T> clone = (TripleKey<F, S, T>) super.clone();
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
