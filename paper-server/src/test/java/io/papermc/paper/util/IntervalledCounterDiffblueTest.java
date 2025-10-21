package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntervalledCounterDiffblueTest {
  /**
   * Test {@link IntervalledCounter#IntervalledCounter(long)}.
   *
   * <p>Method under test: {@link IntervalledCounter#IntervalledCounter(long)}
   */
  @Test
  @DisplayName("Test new IntervalledCounter(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.<init>(long)"})
  void testNewIntervalledCounter() {
    // Arrange and Act
    IntervalledCounter actualIntervalledCounter = new IntervalledCounter(42L);

    // Assert
    assertEquals(0, actualIntervalledCounter.head);
    assertEquals(0, actualIntervalledCounter.tail);
    assertEquals(0.0d, actualIntervalledCounter.getRate());
    assertEquals(0L, actualIntervalledCounter.getSum());
    assertEquals(0L, actualIntervalledCounter.minTime);
    assertEquals(42L, actualIntervalledCounter.getInterval());
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, actualIntervalledCounter.counts);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, actualIntervalledCounter.times);
  }

  /**
   * Test {@link IntervalledCounter#updateCurrentTime(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateCurrentTime(long)}
   */
  @Test
  @DisplayName("Test updateCurrentTime(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateCurrentTime(long)"})
  void testUpdateCurrentTimeWithLong() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.updateCurrentTime(1L);

    // Assert
    assertEquals(-41L, intervalledCounter.minTime);
    assertEquals(0, intervalledCounter.head);
    assertEquals(0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateCurrentTime(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateCurrentTime(long)}
   */
  @Test
  @DisplayName("Test updateCurrentTime(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateCurrentTime(long)"})
  void testUpdateCurrentTimeWithLong2() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);
    intervalledCounter.addTime(1L);

    // Act
    intervalledCounter.updateCurrentTime(1L);

    // Assert
    assertEquals(-41L, intervalledCounter.minTime);
    assertEquals(0, intervalledCounter.head);
    assertEquals(1L, intervalledCounter.getSum());
    assertEquals(2.3809523809523806E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateCurrentTime(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateCurrentTime(long)}
   */
  @Test
  @DisplayName("Test updateCurrentTime(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateCurrentTime(long)"})
  void testUpdateCurrentTimeWithLong3() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(-1L);
    intervalledCounter.addTime(1L);

    // Act
    intervalledCounter.updateCurrentTime(1L);

    // Assert
    assertEquals(-0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertEquals(1, intervalledCounter.head);
    assertEquals(2L, intervalledCounter.minTime);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateCurrentTime()}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is forty-two
   *       {@link IntervalledCounter#head} is one.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateCurrentTime()}
   */
  @Test
  @DisplayName(
      "Test updateCurrentTime(); then IntervalledCounter(long) with interval is forty-two head is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateCurrentTime()"})
  void testUpdateCurrentTime_thenIntervalledCounterWithIntervalIsFortyTwoHeadIsOne() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);
    intervalledCounter.addTime(1L);

    // Act
    intervalledCounter.updateCurrentTime();

    // Assert
    assertEquals(0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertEquals(1, intervalledCounter.head);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateCurrentTime()}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is forty-two
   *       {@link IntervalledCounter#head} is zero.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateCurrentTime()}
   */
  @Test
  @DisplayName(
      "Test updateCurrentTime(); then IntervalledCounter(long) with interval is forty-two head is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateCurrentTime()"})
  void testUpdateCurrentTime_thenIntervalledCounterWithIntervalIsFortyTwoHeadIsZero() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.updateCurrentTime();

    // Assert that nothing has changed
    assertEquals(0, intervalledCounter.head);
    assertEquals(0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateCurrentTime()}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is {@link
   *       Long#MAX_VALUE} {@link IntervalledCounter#head} is zero.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateCurrentTime()}
   */
  @Test
  @DisplayName(
      "Test updateCurrentTime(); then IntervalledCounter(long) with interval is MAX_VALUE head is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateCurrentTime()"})
  void testUpdateCurrentTime_thenIntervalledCounterWithIntervalIsMax_valueHeadIsZero() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(Long.MAX_VALUE);
    intervalledCounter.addTime(1L);

    // Act
    intervalledCounter.updateCurrentTime();

    // Assert that nothing has changed
    assertEquals(0, intervalledCounter.head);
    assertEquals(1.0842021724855043E-10d, intervalledCounter.getRate());
    assertEquals(1L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#addTime(long, long)} with {@code currTime}, {@code count}.
   *
   * <p>Method under test: {@link IntervalledCounter#addTime(long, long)}
   */
  @Test
  @DisplayName("Test addTime(long, long) with 'currTime', 'count'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.addTime(long, long)"})
  void testAddTimeWithCurrTimeCount() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.addTime(1L, 3L);

    // Assert
    assertEquals(1, intervalledCounter.tail);
    assertEquals(3L, intervalledCounter.getSum());
    assertEquals(7.142857142857142E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
    assertArrayEquals(new long[] {3L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#addTime(long, long)} with {@code currTime}, {@code count}.
   *
   * <p>Method under test: {@link IntervalledCounter#addTime(long, long)}
   */
  @Test
  @DisplayName("Test addTime(long, long) with 'currTime', 'count'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.addTime(long, long)"})
  void testAddTimeWithCurrTimeCount2() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.addTime(-1L, 3L);

    // Assert that nothing has changed
    assertEquals(0, intervalledCounter.tail);
    assertEquals(0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
  }

  /**
   * Test {@link IntervalledCounter#addTime(long)} with {@code currTime}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is forty-two
   *       {@link IntervalledCounter#tail} is one.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#addTime(long)}
   */
  @Test
  @DisplayName(
      "Test addTime(long) with 'currTime'; then IntervalledCounter(long) with interval is forty-two tail is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.addTime(long)"})
  void testAddTimeWithCurrTime_thenIntervalledCounterWithIntervalIsFortyTwoTailIsOne() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.addTime(1L);

    // Assert
    assertEquals(1, intervalledCounter.tail);
    assertEquals(1L, intervalledCounter.getSum());
    assertEquals(2.3809523809523806E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
  }

  /**
   * Test {@link IntervalledCounter#addTime(long)} with {@code currTime}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is forty-two
   *       {@link IntervalledCounter#tail} is zero.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#addTime(long)}
   */
  @Test
  @DisplayName(
      "Test addTime(long) with 'currTime'; then IntervalledCounter(long) with interval is forty-two tail is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.addTime(long)"})
  void testAddTimeWithCurrTime_thenIntervalledCounterWithIntervalIsFortyTwoTailIsZero() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.addTime(-1L);

    // Assert that nothing has changed
    assertEquals(0, intervalledCounter.tail);
    assertEquals(0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long, long)} with {@code count}, {@code currTime}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long, long)}
   */
  @Test
  @DisplayName("Test updateAndAdd(long, long) with 'count', 'currTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long, long)"})
  void testUpdateAndAddWithCountCurrTime() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.updateAndAdd(3L, 1L);

    // Assert
    assertEquals(1, intervalledCounter.tail);
    assertEquals(3L, intervalledCounter.getSum());
    assertEquals(7.142857142857142E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
    assertArrayEquals(new long[] {3L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long, long)} with {@code count}, {@code currTime}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long, long)}
   */
  @Test
  @DisplayName("Test updateAndAdd(long, long) with 'count', 'currTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long, long)"})
  void testUpdateAndAddWithCountCurrTime2() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(-1L);

    // Act
    intervalledCounter.updateAndAdd(3L, 1L);

    // Assert
    assertEquals(-0.0d, intervalledCounter.getRate());
    assertEquals(0, intervalledCounter.tail);
    assertEquals(0L, intervalledCounter.getSum());
    assertEquals(2L, intervalledCounter.minTime);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long, long)} with {@code count}, {@code currTime}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long, long)}
   */
  @Test
  @DisplayName("Test updateAndAdd(long, long) with 'count', 'currTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long, long)"})
  void testUpdateAndAddWithCountCurrTime3() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);
    intervalledCounter.addTime(42L);

    // Act
    intervalledCounter.updateAndAdd(3L, 1L);

    // Assert
    assertEquals(2, intervalledCounter.tail);
    assertEquals(4L, intervalledCounter.getSum());
    assertEquals(9.523809523809522E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {1L, 3L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
    assertArrayEquals(new long[] {42L, 1L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.times);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long, long)} with {@code count}, {@code currTime}.
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long, long)}
   */
  @Test
  @DisplayName("Test updateAndAdd(long, long) with 'count', 'currTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long, long)"})
  void testUpdateAndAddWithCountCurrTime4() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(-1L);
    intervalledCounter.addTime(0L);

    // Act
    intervalledCounter.updateAndAdd(3L, 1L);

    // Assert
    assertEquals(-0.0d, intervalledCounter.getRate());
    assertEquals(0L, intervalledCounter.getSum());
    assertEquals(1, intervalledCounter.head);
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long)} with {@code count}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is forty-two
   *       {@link IntervalledCounter#head} is one.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long)}
   */
  @Test
  @DisplayName(
      "Test updateAndAdd(long) with 'count'; then IntervalledCounter(long) with interval is forty-two head is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long)"})
  void testUpdateAndAddWithCount_thenIntervalledCounterWithIntervalIsFortyTwoHeadIsOne() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);
    intervalledCounter.addTime(42L);

    // Act
    intervalledCounter.updateAndAdd(3L);

    // Assert
    assertEquals(1, intervalledCounter.head);
    assertEquals(2, intervalledCounter.tail);
    assertEquals(3L, intervalledCounter.getSum());
    assertEquals(7.142857142857142E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {0L, 3L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long)} with {@code count}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is forty-two
   *       {@link IntervalledCounter#tail} is one.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long)}
   */
  @Test
  @DisplayName(
      "Test updateAndAdd(long) with 'count'; then IntervalledCounter(long) with interval is forty-two tail is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long)"})
  void testUpdateAndAddWithCount_thenIntervalledCounterWithIntervalIsFortyTwoTailIsOne() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    intervalledCounter.updateAndAdd(3L);

    // Assert
    assertEquals(1, intervalledCounter.tail);
    assertEquals(3L, intervalledCounter.getSum());
    assertEquals(7.142857142857142E7d, intervalledCounter.getRate());
    assertArrayEquals(new long[] {3L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long)} with {@code count}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is {@link
   *       Long#MAX_VALUE} {@link IntervalledCounter#tail} is two.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long)}
   */
  @Test
  @DisplayName(
      "Test updateAndAdd(long) with 'count'; then IntervalledCounter(long) with interval is MAX_VALUE tail is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long)"})
  void testUpdateAndAddWithCount_thenIntervalledCounterWithIntervalIsMax_valueTailIsTwo() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(Long.MAX_VALUE);
    intervalledCounter.addTime(42L);

    // Act
    intervalledCounter.updateAndAdd(3L);

    // Assert
    assertEquals(2, intervalledCounter.tail);
    assertEquals(4.336808689942017E-10d, intervalledCounter.getRate());
    assertEquals(4L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {1L, 3L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#updateAndAdd(long)} with {@code count}.
   *
   * <ul>
   *   <li>Then {@link IntervalledCounter#IntervalledCounter(long)} with interval is minus one Rate
   *       is {@code -0.0}.
   * </ul>
   *
   * <p>Method under test: {@link IntervalledCounter#updateAndAdd(long)}
   */
  @Test
  @DisplayName(
      "Test updateAndAdd(long) with 'count'; then IntervalledCounter(long) with interval is minus one Rate is '-0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntervalledCounter.updateAndAdd(long)"})
  void testUpdateAndAddWithCount_thenIntervalledCounterWithIntervalIsMinusOneRateIs00() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(-1L);

    // Act
    intervalledCounter.updateAndAdd(3L);

    // Assert that nothing has changed
    assertEquals(-0.0d, intervalledCounter.getRate());
    assertEquals(0, intervalledCounter.tail);
    assertEquals(0L, intervalledCounter.getSum());
    assertArrayEquals(new long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intervalledCounter.counts);
  }

  /**
   * Test {@link IntervalledCounter#getRate()}.
   *
   * <p>Method under test: {@link IntervalledCounter#getRate()}
   */
  @Test
  @DisplayName("Test getRate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double IntervalledCounter.getRate()"})
  void testGetRate() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new IntervalledCounter(42L).getRate());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntervalledCounter#getInterval()}
   *   <li>{@link IntervalledCounter#getSum()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntervalledCounter.getInterval()", "long IntervalledCounter.getSum()"})
  void testGettersAndSetters() {
    // Arrange
    IntervalledCounter intervalledCounter = new IntervalledCounter(42L);

    // Act
    long actualInterval = intervalledCounter.getInterval();

    // Assert
    assertEquals(0L, intervalledCounter.getSum());
    assertEquals(42L, actualInterval);
  }

  /**
   * Test {@link IntervalledCounter#totalDataPoints()}.
   *
   * <p>Method under test: {@link IntervalledCounter#totalDataPoints()}
   */
  @Test
  @DisplayName("Test totalDataPoints()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntervalledCounter.totalDataPoints()"})
  void testTotalDataPoints() {
    // Arrange, Act and Assert
    assertEquals(0, new IntervalledCounter(42L).totalDataPoints());
  }
}
