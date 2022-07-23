package potatoxf.helper.api.function;

/**
 * @author potatoxf
 * @date 2022/07/02
 */
public interface VaryConsumerThrow<E extends Throwable> {

  /**
   * @param args
   * @throws E
   */
  void apply(Object... args) throws E;
}
