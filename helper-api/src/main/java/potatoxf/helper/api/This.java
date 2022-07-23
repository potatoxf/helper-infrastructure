package potatoxf.helper.api;

/**
 * this引用
 *
 * @author potatoxf
 * @date 2022/07/02
 */
public interface This<This> {

  /**
   * 返回this
   *
   * @return {@code this}
   */
  @SuppressWarnings("unchecked")
  default This this$() {
    return (This) this;
  }
}
