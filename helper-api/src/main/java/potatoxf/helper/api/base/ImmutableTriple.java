package potatoxf.helper.api.base;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 不靠变的键值对
 *
 * @author potatoxf
 * @date 2021/06/19
 */
public final class ImmutableTriple<F, S, T> extends Triple<F, S, T> {

  public ImmutableTriple(
      @Nullable final F firstElement,
      @Nullable final S secondElement,
      @Nullable final T thirdElement) {
    super.setFirstElement(firstElement);
    super.setSecondElement(secondElement);
    super.setThirdElement(thirdElement);
  }

  @Nonnull
  @Override
  public ImmutableTriple<F, S, T> setFirstElement(@Nullable final F firstElement) {
    throw new UnsupportedOperationException("Does not support modifier");
  }

  @Nonnull
  @Override
  public ImmutableTriple<F, S, T> setSecondElement(@Nullable final S secondElement) {
    throw new UnsupportedOperationException("Does not support modifier");
  }

  @Nonnull
  @Override
  public ImmutableTriple<F, S, T> setThirdElement(@Nullable final T thirdElement) {
    throw new UnsupportedOperationException("Does not support modifier");
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public Triple<F, S, T> clone() {
    return super.clone();
  }
}
