package potatoxf.helper.api.base;

import java.util.NoSuchElementException;

/**
 * A container object which may or may not contain a non-null value. If a value is present, {@code
 * isPresent()} will return {@code true} and {@code get()} will return the value.
 *
 * @author potatoxf
 * @date 2021/8/24
 */
public class Option<T> {

  /** If non-null, the value; if null, indicates no value is present */
  private T value;

  /**
   * If a value is present in this {@code Opt}, returns the value, otherwise throws {@code
   * NoSuchElementException}.
   *
   * @return the non-null value held by this {@code Opt}
   * @throws NoSuchElementException if there is no value present
   * @see Option#isPresent()
   */
  public T get() {
    return value;
  }

  /**
   * Set a value
   *
   * @param value the non-null value
   */
  public Option<T> setValue(T value) {
    this.value = value;
    return this;
  }

  /**
   * Return {@code true} if there is a value present, otherwise {@code false}.
   *
   * @return {@code true} if there is a value present, otherwise {@code false}
   */
  public boolean isPresent() {
    return value != null;
  }

  /**
   * Return {@code true} if there is a value no present, otherwise {@code false}.
   *
   * @return {@code true} if there is a value no present, otherwise {@code false}
   */
  public boolean isNoPresent() {
    return value == null;
  }

  /**
   * Return the value if present, otherwise return {@code other}.
   *
   * @param other the value to be returned if there is no value present, may be null
   * @return the value, if present, otherwise {@code other}
   */
  public T orElse(T other) {
    return value != null ? value : other;
  }

  /**
   * Indicates whether some other object is "equal to" this Opt. The other object is considered
   * equal if:
   *
   * <ul>
   *   <li>it is also an {@code Opt} and;
   *   <li>both instances have no value present or;
   *   <li>the present values are "equal to" each other via {@code equals()}.
   * </ul>
   *
   * @param o an object to be tested for equality
   * @return {code true} if the other object is "equal to" this object otherwise {@code false}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Option<?> option = (Option<?>) o;

    return value != null ? value.equals(option.value) : option.value == null;
  }

  /**
   * Returns the hash code value of the present value, if any, or 0 (zero) if no value is present.
   *
   * @return hash code value of the present value or 0 if no value is present
   */
  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  /**
   * Returns a non-empty string representation of this Opt suitable for debugging. The exact
   * presentation format is unspecified and may vary between implementations and versions.
   *
   * @return the string representation of this instance
   */
  @Override
  public String toString() {
    return value != null ? String.format("Opt[%s]", value) : "Opt.empty";
  }
}
