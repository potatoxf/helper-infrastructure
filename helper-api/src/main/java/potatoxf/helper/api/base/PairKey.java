package potatoxf.helper.api.base;

import java.io.Serializable;
import java.util.Objects;

/**
 * 一对键
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class PairKey<F, S> implements Serializable, Cloneable {
  /** 键1 */
  private F firstElement;
  /** 键2 */
  private S secondElement;

  public F getFirstElement() {
    return firstElement;
  }

  public void setFirstElement(F firstElement) {
    this.firstElement = firstElement;
  }

  public S getSecondElement() {
    return secondElement;
  }

  public void setSecondElement(S s) {
    this.secondElement = s;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PairKey<?, ?> pairKey = (PairKey<?, ?>) o;

    if (!Objects.equals(firstElement, pairKey.firstElement)) return false;
    return Objects.equals(secondElement, pairKey.secondElement);
  }

  @Override
  public int hashCode() {
    int result = firstElement != null ? firstElement.hashCode() : 0;
    result = 31 * result + (secondElement != null ? secondElement.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "(" + firstElement + "," + secondElement + ")";
  }

  @SuppressWarnings("unchecked")
  @Override
  public PairKey<F, S> clone() {
    try {
      return (PairKey<F, S>) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
