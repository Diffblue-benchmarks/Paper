package co.aikar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CounterDiffblueTest {
  /**
   * Test {@link Counter#decrement(Object)} with {@code key}.
   *
   * <p>Method under test: {@link Counter#decrement(Object)}
   */
  @Test
  @DisplayName("Test decrement(Object) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Counter.decrement(Object)"})
  void testDecrementWithKey() {
    // Arrange
    Counter<Object> objectMap = new Counter<>();

    // Act and Assert
    assertEquals(-1L, objectMap.decrement("Key"));
    assertEquals(1, objectMap.size());
    assertEquals(-1L, objectMap.get("Key").longValue());
  }

  /**
   * Test {@link Counter#decrement(Object, long)} with {@code key}, {@code amount}.
   *
   * <p>Method under test: {@link Counter#decrement(Object, long)}
   */
  @Test
  @DisplayName("Test decrement(Object, long) with 'key', 'amount'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Counter.decrement(Object, long)"})
  void testDecrementWithKeyAmount() {
    // Arrange
    Counter<Object> objectMap = new Counter<>();

    // Act and Assert
    assertEquals(-10L, objectMap.decrement("Key", 10L));
    assertEquals(1, objectMap.size());
    assertEquals(-10L, objectMap.get("Key").longValue());
  }

  /**
   * Test {@link Counter#increment(Object)} with {@code key}.
   *
   * <p>Method under test: {@link Counter#increment(Object)}
   */
  @Test
  @DisplayName("Test increment(Object) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Counter.increment(Object)"})
  void testIncrementWithKey() {
    // Arrange
    Counter<Object> objectMap = new Counter<>();

    // Act
    long actualIncrementResult = objectMap.increment("Key");

    // Assert
    assertEquals(1, objectMap.size());
    assertEquals(1L, actualIncrementResult);
    assertEquals(1L, objectMap.get("Key").longValue());
  }

  /**
   * Test {@link Counter#increment(Object, long)} with {@code key}, {@code amount}.
   *
   * <p>Method under test: {@link Counter#increment(Object, long)}
   */
  @Test
  @DisplayName("Test increment(Object, long) with 'key', 'amount'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Counter.increment(Object, long)"})
  void testIncrementWithKeyAmount() {
    // Arrange
    Counter<Object> objectMap = new Counter<>();

    // Act
    long actualIncrementResult = objectMap.increment("Key", 10L);

    // Assert
    assertEquals(1, objectMap.size());
    assertEquals(10L, actualIncrementResult);
    assertEquals(10L, objectMap.get("Key").longValue());
  }

  /**
   * Test {@link Counter#getCount(Object)}.
   *
   * <p>Method under test: {@link Counter#getCount(Object)}
   */
  @Test
  @DisplayName("Test getCount(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Counter.getCount(Object)"})
  void testGetCount() {
    // Arrange
    Counter<Object> objectMap = new Counter<>();

    // Act and Assert
    assertEquals(0L, objectMap.getCount("Key"));
  }

  /**
   * Test {@link Counter#delegate()}.
   *
   * <p>Method under test: {@link Counter#delegate()}
   */
  @Test
  @DisplayName("Test delegate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map Counter.delegate()"})
  void testDelegate() {
    // Arrange
    Counter<Object> objectMap = new Counter<>();

    // Act and Assert
    assertTrue(objectMap.delegate().isEmpty());
  }

  /**
   * Test new {@link Counter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Counter}
   */
  @Test
  @DisplayName("Test new Counter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Counter.<init>()"})
  void testNewCounter() {
    // Arrange and Act
    Counter<Object> actualObjectMap = new Counter<>();

    // Assert
    assertTrue(actualObjectMap.isEmpty());
  }
}
