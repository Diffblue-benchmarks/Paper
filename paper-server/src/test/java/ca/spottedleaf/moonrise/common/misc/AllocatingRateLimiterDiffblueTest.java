package ca.spottedleaf.moonrise.common.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllocatingRateLimiterDiffblueTest {
  /**
   * Test {@link AllocatingRateLimiter#previewAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#previewAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test previewAllocation(long, double, long); when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.previewAllocation(long, double, long)"})
  void testPreviewAllocation_whenFive() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).previewAllocation(10L, 10.0d, 5L));
  }

  /**
   * Test {@link AllocatingRateLimiter#previewAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#previewAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test previewAllocation(long, double, long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.previewAllocation(long, double, long)"})
  void testPreviewAllocation_whenOne() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).previewAllocation(10L, 10.0d, 1L));
  }

  /**
   * Test {@link AllocatingRateLimiter#previewAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#previewAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test previewAllocation(long, double, long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.previewAllocation(long, double, long)"})
  void testPreviewAllocation_whenOne2() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).previewAllocation(1L, 10.0d, 5L));
  }

  /**
   * Test {@link AllocatingRateLimiter#previewAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#previewAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test previewAllocation(long, double, long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.previewAllocation(long, double, long)"})
  void testPreviewAllocation_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).previewAllocation(10L, 10.0d, 0L));
  }

  /**
   * Test {@link AllocatingRateLimiter#takeAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#takeAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test takeAllocation(long, double, long); when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.takeAllocation(long, double, long)"})
  void testTakeAllocation_whenFive() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).takeAllocation(10L, 10.0d, 5L));
  }

  /**
   * Test {@link AllocatingRateLimiter#takeAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#takeAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test takeAllocation(long, double, long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.takeAllocation(long, double, long)"})
  void testTakeAllocation_whenOne() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).takeAllocation(10L, 10.0d, 1L));
  }

  /**
   * Test {@link AllocatingRateLimiter#takeAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#takeAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test takeAllocation(long, double, long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.takeAllocation(long, double, long)"})
  void testTakeAllocation_whenOne2() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).takeAllocation(1L, 10.0d, 5L));
  }

  /**
   * Test {@link AllocatingRateLimiter#takeAllocation(long, double, long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link AllocatingRateLimiter#takeAllocation(long, double, long)}
   */
  @Test
  @DisplayName("Test takeAllocation(long, double, long); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AllocatingRateLimiter.takeAllocation(long, double, long)"})
  void testTakeAllocation_whenZero() {
    // Arrange, Act and Assert
    assertEquals(0L, new AllocatingRateLimiter(5L).takeAllocation(10L, 10.0d, 0L));
  }
}
