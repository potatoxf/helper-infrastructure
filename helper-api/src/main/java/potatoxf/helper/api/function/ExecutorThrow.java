package potatoxf.helper.api.function;

/**
 * 执行器
 *
 * @author potatoxf
 * @date 2022/07/02
 */
public interface ExecutorThrow<E extends Throwable> {
  /**
   * 执行方法
   *
   * @throws E 抛出的异常
   */
  void execute() throws E;
}
