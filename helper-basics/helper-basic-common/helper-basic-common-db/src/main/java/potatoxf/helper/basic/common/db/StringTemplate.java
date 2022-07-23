package potatoxf.helper.basic.common.db;

import potatoxf.helper.api.base.ImmutableArrayKey;
import potatoxf.helper.api.InstanceManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 字符串模板
 *
 * @author potatoxf
 * @date 2022/6/24
 */
public final class StringTemplate implements InstanceManager<String> {

  /** 模板 */
  private final String template;

  /** 模板解析后的容器 */
  private final Map<ImmutableArrayKey<Object>, String> data = new ConcurrentHashMap<>();

  private StringTemplate(String template) {
    this.template = template;
  }

  public static StringTemplate of(String template) {
    return InstanceManager.of(template, StringTemplate::new);
  }

  /**
   * Returns a formatted string using the specified format string and arguments.
   *
   * <p>The locale always used is the one returned by {@link java.util.Locale#getDefault()
   * Locale.getDefault()}.
   *
   * @param args Arguments referenced by the format specifiers in the format string. If there are
   *     more arguments than format specifiers, the extra arguments are ignored. The number of
   *     arguments is variable and may be zero. The maximum number of arguments is limited by the
   *     maximum dimension of a Java array as defined by <cite>The Java&trade; Virtual Machine
   *     Specification</cite>. The behaviour on a {@code null} argument depends on the <a
   *     href="../util/Formatter.html#syntax">conversion</a>.
   * @throws java.util.IllegalFormatException If a format string contains an illegal syntax, a
   *     format specifier that is incompatible with the given arguments, insufficient arguments
   *     given the format string, or other illegal conditions. For specification of all possible
   *     formatting errors, see the <a href="../util/Formatter.html#detail">Details</a> section of
   *     the formatter class specification.
   * @return A formatted string
   */
  public String format(Object... args) {
    ImmutableArrayKey<Object> arrayKey = new ImmutableArrayKey<>(args);
    String result;
    if (!data.containsKey(arrayKey)) {
      result = String.format(template, args);
      data.put(arrayKey, result);
    } else {
      result = data.get(arrayKey);
    }
    return result;
  }
}
