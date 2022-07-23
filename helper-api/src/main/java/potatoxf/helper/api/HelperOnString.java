package potatoxf.helper.api;

/**
 * @author potatoxf
 * @date 2022/7/11
 */
public class HelperOnString {
  private HelperOnString() throws IllegalAccessException {
    throw new IllegalAccessException(
        "The instance creation is not allowed,because this is static method utils class");
  }

  /**
   * 按固定长度处理字符串
   *
   * @param input 显示对象
   * @param length 固定长度
   * @param pad 填充字符
   * @param isLeft 是否靠左
   */
  public static String layout(
      final CharSequence input, final int length, final char pad, final boolean isLeft) {
    CharSequenceAppendable charSequenceAppendable = CharSequenceAppendable.ofStringBuilder();
    layout(charSequenceAppendable, input, length, pad, isLeft);
    return charSequenceAppendable.toString();
  }
  /**
   * 按固定长度处理字符串
   *
   * @param container 字符串容器
   * @param input 显示对象
   * @param length 固定长度
   * @param pad 填充字符
   * @param isLeft 是否靠左
   */
  public static void layout(
      final CharSequenceAppendable container,
      final CharSequence input,
      final int length,
      final char pad,
      final boolean isLeft) {
    if (input == null || input.length() == 0) {
      return;
    }
    if (length <= input.length()) {
      container.append(input);
      return;
    }
    if (isLeft) {
      container.append(input);
      repeat(container, pad, length - input.length());
    } else {
      repeat(container, pad, length - input.length());
      container.append(input);
    }
  }

  /**
   * Returns padding using the specified delimiter repeated to a given length.
   *
   * @param container The String Container
   * @param input character to repeat
   * @param repeat number of times to repeat char, negative treated as zero
   */
  public static CharSequenceAppendable repeat(
      final CharSequenceAppendable container, final char input, final int repeat) {
    for (int i = 0; i < repeat; i++) {
      container.append(input);
    }
    return container;
  }

  /**
   * Repeat a String {@code repeat} times to form a new String.
   *
   * @param container The String Container
   * @param input the String to repeat, may be null
   * @param repeat number of times to repeat input, negative treated as zero
   * @return a new String consisting of the original String repeated, {@code null} if null String
   *     input
   */
  public static CharSequenceAppendable repeat(
      final CharSequenceAppendable container, final CharSequence input, final int repeat) {
    if (input == null || input.length() == 0 || repeat <= 0) {
      return container;
    }
    if (repeat == 1) {
      container.append(input);
    } else if (input.length() == 1) {
      repeat(container, input.charAt(0), repeat);
    } else {
      for (int i = 0; i < repeat; i++) {
        container.append(input);
      }
    }
    return container;
  }
}
