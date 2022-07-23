package potatoxf.helper.api.function;

/**
 * 条件器，用于判断元素条件
 *
 * @author potatoxf
 * @date 2022/07/02
 */
public interface BiConditionThrow<T, U, E extends Throwable> {

  /**
   * 测试对象是否满足条件
   *
   * @param t 输入对象
   * @param u 输入对象
   * @return 如果满足条件返回true，否则返回false
   * @throws E 抛出异常
   */
  boolean test(T t, U u) throws E;
}
