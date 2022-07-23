package potatoxf.helper.api.function;

/**
 * 消费器，处理两个参数
 *
 * @author potatoxf
 * @date 2022/07/02
 */
public interface BiConsumerThrow<T, U, E extends Throwable> {
  /**
   * 执行方法
   *
   * @param t 参数1
   * @param u 参数2
   * @throws E 抛出的异常
   */
  void apply(T t, U u) throws E;
}
