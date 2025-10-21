package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TickDiffblueTest {
  /**
   * Test {@link Tick#tick()}.
   *
   * <p>Method under test: {@link Tick#tick()}
   */
  @Test
  @DisplayName("Test tick()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tick Tick.tick()"})
  void testTick() {
    // Arrange and Act
    Tick actualTickResult = Tick.tick();

    // Assert
    assertEquals(50000000L, actualTickResult.getDuration().toNanos());
    assertFalse(actualTickResult.isDateBased());
    assertFalse(actualTickResult.isDurationEstimated());
    assertTrue(actualTickResult.isTimeBased());
  }

  /**
   * Test {@link Tick#of(long)}.
   *
   * <p>Method under test: {@link Tick#of(long)}
   */
  @Test
  @DisplayName("Test of(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration Tick.of(long)"})
  void testOf() {
    // Arrange and Act
    Duration actualOfResult = Tick.of(1L);

    // Assert
    assertEquals(50000000L, actualOfResult.toNanos());
  }

  /**
   * Test {@link Tick#fromDuration(Duration)}.
   *
   * <ul>
   *   <li>When ofSeconds one.
   *   <li>Then return twenty.
   * </ul>
   *
   * <p>Method under test: {@link Tick#fromDuration(Duration)}
   */
  @Test
  @DisplayName("Test fromDuration(Duration); when ofSeconds one; then return twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Tick.fromDuration(Duration)"})
  void testFromDuration_whenOfSecondsOne_thenReturnTwenty() {
    // Arrange, Act and Assert
    assertEquals(20, Tick.tick().fromDuration(Duration.ofSeconds(1L)));
  }

  /**
   * Test {@link Tick#getDuration()}.
   *
   * <p>Method under test: {@link Tick#getDuration()}
   */
  @Test
  @DisplayName("Test getDuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration Tick.getDuration()"})
  void testGetDuration() {
    // Arrange, Act and Assert
    assertEquals(50000000L, Tick.tick().getDuration().toNanos());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Tick#isDateBased()}
   *   <li>{@link Tick#isDurationEstimated()}
   *   <li>{@link Tick#isTimeBased()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean Tick.isDateBased()",
    "boolean Tick.isDurationEstimated()",
    "boolean Tick.isTimeBased()"
  })
  void testGettersAndSetters() {
    // Arrange
    Tick tickResult = Tick.tick();

    // Act
    boolean actualIsDateBasedResult = tickResult.isDateBased();
    boolean actualIsDurationEstimatedResult = tickResult.isDurationEstimated();

    // Assert
    assertFalse(actualIsDateBasedResult);
    assertFalse(actualIsDurationEstimatedResult);
    assertTrue(tickResult.isTimeBased());
  }

  /**
   * Test {@link Tick#between(Temporal, Temporal)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one atStartOfDay.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Tick#between(Temporal, Temporal)}
   */
  @Test
  @DisplayName(
      "Test between(Temporal, Temporal); when LocalDate with '1970' and one and one atStartOfDay; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Tick.between(Temporal, Temporal)"})
  void testBetween_whenLocalDateWith1970AndOneAndOneAtStartOfDay_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        Tick.tick()
            .between(
                LocalDate.of(1970, 1, 1).atStartOfDay(), LocalDate.of(1970, 1, 1).atStartOfDay()));
  }
}
