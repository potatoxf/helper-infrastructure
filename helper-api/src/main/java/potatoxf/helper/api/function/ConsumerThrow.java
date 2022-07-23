package potatoxf.helper.api.function;

/**
 * 消费器，处理单个参数
 *
 * @author potatoxf
 * @date 2022/07/02
 */
public interface ConsumerThrow<P, E extends Throwable> {
  /**
   * 执行方法
   *
   * @param p 参数
   * @throws E 抛出的异常
   */
  void apply(P p) throws E;
}
