package potatoxf.helper.api.function;

/**
 * @author potatoxf
 * @date 2022/07/02
 */
public interface VaryFactoryThrow<R, E extends Throwable> {

  /**
   * @param args
   */
  R handle(Object... args) throws E;
}
