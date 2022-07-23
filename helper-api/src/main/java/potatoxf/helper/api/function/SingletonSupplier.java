package potatoxf.helper.api.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单例提供器
 *
 * @author potatoxf
 * @date 2022/07/02
 */
public final class SingletonSupplier<T, E extends Throwable> implements SupplierThrow<T, E> {

  private static final Logger LOG = LoggerFactory.getLogger(SingletonSupplier.class);
  /** */
  private final SupplierThrow<? extends T, E> instanceSupplier;
  /** */
  private final SupplierThrow<? extends T, E> defaultSupplier;
  /** */
  private volatile T singletonInstance;

  /**
   * @param singletonInstance
   * @param instanceSupplier
   * @param defaultSupplier
   */
  private SingletonSupplier(
      T singletonInstance,
      SupplierThrow<? extends T, E> instanceSupplier,
      SupplierThrow<? extends T, E> defaultSupplier) {
    this.singletonInstance = singletonInstance;
    this.instanceSupplier = instanceSupplier;
    this.defaultSupplier = defaultSupplier;
  }

  /**
   * @param instance
   * @param <T>
   * @param <E>
   * @return
   */
  public static <T, E extends Throwable> SingletonSupplier<T, E> of(T instance) {
    return new SingletonSupplier<T, E>(instance, null, null);
  }

  /**
   * @param instanceSupplier
   * @param <T>
   * @param <E>
   * @return
   */
  public static <T, E extends Throwable> SingletonSupplier<T, E> of(
      SupplierThrow<T, E> instanceSupplier) {
    return new SingletonSupplier<T, E>(null, instanceSupplier, null);
  }

  /**
   * @param instanceSupplier
   * @param defaultSupplier
   * @param <T>
   * @param <E>
   * @return
   */
  public static <T, E extends Throwable> SingletonSupplier<T, E> of(
      SupplierThrow<T, E> instanceSupplier, SupplierThrow<T, E> defaultSupplier) {
    return new SingletonSupplier<T, E>(null, instanceSupplier, defaultSupplier);
  }

  /**
   * @return
   */
  @Override
  public T get() {
    T instance = singletonInstance;
    if (instance == null) {
      synchronized (this) {
        instance = singletonInstance;
        if (instance == null) {
          if (instanceSupplier != null) {
            try {
              instance = instanceSupplier.get();
            } catch (Throwable e) {
              LOG.warn("Error getting value from instance provider", e);
            }
          }
          if (instance == null && defaultSupplier != null) {
            try {
              instance = defaultSupplier.get();
            } catch (Throwable e) {
              LOG.warn("Error getting value from default provider", e);
            }
          }
          singletonInstance = instance;
        }
      }
    }
    return instance;
  }
}
