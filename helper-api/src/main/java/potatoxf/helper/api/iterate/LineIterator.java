package potatoxf.helper.api.iterate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 行迭代器
 *
 * @author potatoxf
 * @date 2021/3/5
 */
public class LineIterator extends AbstractIterator<String> implements Iterator<String>, Closeable {

  private static final Logger LOGGER = LoggerFactory.getLogger(LineIterator.class);
  /** */
  private final BufferedReader bufferedReader;
  /** */
  private final boolean isAutoClose;
  /** */
  private String cachedLine;
  /** */
  private boolean finished = false;

  /**
   * @param inputStream
   */
  public LineIterator(InputStream inputStream) {
    this(inputStream, true);
  }

  /**
   * @param inputStream
   * @param isAutoClose
   */
  public LineIterator(InputStream inputStream, boolean isAutoClose) {
    this(new InputStreamReader(inputStream), isAutoClose);
  }

  /**
   * @param reader
   */
  public LineIterator(Reader reader) {
    this(reader, true);
  }

  /**
   * @param reader
   * @param isAutoClose
   */
  public LineIterator(Reader reader, boolean isAutoClose) {
    if (reader instanceof BufferedReader) {
      bufferedReader = (BufferedReader) reader;
    } else {
      bufferedReader = new BufferedReader(reader);
    }
    this.isAutoClose = isAutoClose;
  }

  /**
   * 指示是否有更多行
   *
   * @return 如果有下一行则返回 {@code true}
   * @throws IllegalStateException 如果发生IO异常
   */
  @Override
  public final boolean hasNext() {
    if (cachedLine != null) {
      return true;
    } else if (finished) {
      return false;
    } else {
      try {
        while (true) {
          String line = bufferedReader.readLine();
          if (line == null) {
            finished = true;
            return false;
          } else if (isValidLine(line = line.trim())) {
            cachedLine = line;
            return true;
          }
        }
      } catch (IOException ioe) {
        close();
        throw new IllegalStateException(ioe.toString());
      }
    }
  }

  /**
   * 返回下一行。
   *
   * @return 输入的下一行
   * @throws NoSuchElementException 如果没有行返回
   */
  @Override
  public final String next() {
    String nextLine = nextLine();
    if (isAutoClose && !hasNext()) {
      close();
    }
    return nextLine;
  }

  /**
   * 返回包装的 {@code Reader}中的下一行。
   *
   * @return 输入的下一行
   * @throws NoSuchElementException 如果没有行返回
   */
  public String nextLine() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more lines");
    }
    String currentLine = cachedLine;
    cachedLine = null;
    return currentLine;
  }

  /** 关闭相关的流 */
  @Override
  public void close() {
    finished = true;
    try {
      bufferedReader.close();
    } catch (IOException e) {
      if (LOGGER.isWarnEnabled()) {
        LOGGER.warn("Error closing stream", e);
      }
    }
    cachedLine = null;
  }

  /**
   * 用于验证返回的每一行的可重写方法。
   *
   * @param line 要验证的行
   * @return 如果有效，则返回 {@code true}；从迭代器中移除，返回 {@code false}
   */
  protected boolean isValidLine(String line) {
    return true;
  }
}
