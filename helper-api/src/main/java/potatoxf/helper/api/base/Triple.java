package potatoxf.helper.api.base;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Objects;

/**
 * 键值对
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public class Triple<F, S, T> implements Serializable, Cloneable {
  @Nullable private F firstElement;
  @Nullable private S secondElement;
  @Nullable private T thirdElement;

  @Nullable
  public F getFirstElement() {
    return firstElement;
  }

  @Nonnull
  public Triple<F, S, T> setFirstElement(@Nullable final F firstElement) {
    this.firstElement = firstElement;
    return this;
  }

  @Nullable
  public S getSecondElement() {
    return secondElement;
  }

  @Nonnull
  public Triple<F, S, T> setSecondElement(@Nullable final S secondElement) {
    this.secondElement = secondElement;
    return this;
  }

  @Nullable
  public T getThirdElement() {
    return thirdElement;
  }

  @Nonnull
  public Triple<F, S, T> setThirdElement(@Nullable final T thirdElement) {
    this.thirdElement = thirdElement;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
    return Objects.equals(firstElement, triple.firstElement)
        && Objects.equals(secondElement, triple.secondElement)
        && Objects.equals(thirdElement, triple.thirdElement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstElement, secondElement, thirdElement);
  }

  @Override
  public String toString() {
    return "(" + firstElement + "," + secondElement + "," + thirdElement + ")";
  }

  @Override
  public Triple<F, S, T> clone() {
    try {
      Triple<F, S, T> clone = (Triple<F, S, T>) super.clone();
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
