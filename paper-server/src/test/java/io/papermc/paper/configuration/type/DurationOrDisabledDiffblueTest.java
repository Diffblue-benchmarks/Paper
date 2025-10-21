package io.papermc.paper.configuration.type;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DurationOrDisabledDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DurationOrDisabled#DurationOrDisabled(Optional)}
   *   <li>{@link DurationOrDisabled#value(Optional)}
   *   <li>{@link DurationOrDisabled#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DurationOrDisabled.<init>(Optional)",
    "Optional DurationOrDisabled.value()",
    "void DurationOrDisabled.value(Optional)"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<Duration> value = Optional.of(Duration.of("Time"));

    // Act
    DurationOrDisabled actualDurationOrDisabled = new DurationOrDisabled(value);
    Optional<Duration> value2 = Optional.of(Duration.of("Time"));
    actualDurationOrDisabled.value(value2);

    // Assert
    assertSame(value2, actualDurationOrDisabled.value());
  }

  /**
   * Test {@link DurationOrDisabled#or(Duration)}.
   *
   * <p>Method under test: {@link DurationOrDisabled#or(Duration)}
   */
  @Test
  @DisplayName("Test or(Duration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration DurationOrDisabled.or(Duration)"})
  void testOr() {
    // Arrange
    Duration fallback = Duration.of("Time");

    // Act
    Duration actualOrResult = DurationOrDisabled.USE_DISABLED.or(fallback);

    // Assert
    assertSame(fallback, actualOrResult);
  }
}
