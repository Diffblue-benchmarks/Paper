package io.papermc.paper.configuration.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DurationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Duration#toString()}
   *   <li>{@link Duration#seconds()}
   *   <li>{@link Duration#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long Duration.seconds()",
    "String Duration.toString()",
    "String Duration.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    Duration ofResult = Duration.of("Time");

    // Act
    String actualToStringResult = ofResult.toString();
    long actualSecondsResult = ofResult.seconds();

    // Assert
    assertEquals("Duration{seconds=0, value='Time'}", actualToStringResult);
    assertEquals("Time", ofResult.value());
    assertEquals(0L, actualSecondsResult);
  }

  /**
   * Test {@link Duration#ticks()}.
   *
   * <p>Method under test: {@link Duration#ticks()}
   */
  @Test
  @DisplayName("Test ticks()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Duration.ticks()"})
  void testTicks() {
    // Arrange, Act and Assert
    assertEquals(0L, Duration.of("Time").ticks());
  }

  /**
   * Test {@link Duration#equals(Object)}, and {@link Duration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Duration#equals(Object)}
   *   <li>{@link Duration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Duration ofResult = Duration.of("Time");
    Duration ofResult2 = Duration.of("Time");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link Duration#equals(Object)}, and {@link Duration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Duration#equals(Object)}
   *   <li>{@link Duration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Duration ofResult = Duration.of("Time");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link Duration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Duration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Duration.of("Time"), 1);
  }

  /**
   * Test {@link Duration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Duration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Duration ofResult = Duration.of("[^-\\d.]");

    // Act and Assert
    assertNotEquals(ofResult, Duration.of("Time"));
  }

  /**
   * Test {@link Duration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Duration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Duration ofResult = Duration.of("42");

    // Act and Assert
    assertNotEquals(ofResult, Duration.of("Time"));
  }

  /**
   * Test {@link Duration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Duration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Duration.of("Time"), null);
  }

  /**
   * Test {@link Duration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Duration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Duration.equals(Object)", "int Duration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Duration.of("Time"), "Different type to Duration");
  }

  /**
   * Test {@link Duration#of(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Duration#of(String)}
   */
  @Test
  @DisplayName("Test of(String); when '42'; then return value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration Duration.of(String)"})
  void testOf_when42_thenReturnValueIs42() {
    // Arrange and Act
    Duration actualOfResult = Duration.of("42");

    // Assert
    assertEquals("42", actualOfResult.value());
    assertEquals(42L, actualOfResult.seconds());
  }

  /**
   * Test {@link Duration#of(String)}.
   *
   * <ul>
   *   <li>When {@code Time}.
   *   <li>Then return value is {@code Time}.
   * </ul>
   *
   * <p>Method under test: {@link Duration#of(String)}
   */
  @Test
  @DisplayName("Test of(String); when 'Time'; then return value is 'Time'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Duration Duration.of(String)"})
  void testOf_whenTime_thenReturnValueIsTime() {
    // Arrange and Act
    Duration actualOfResult = Duration.of("Time");

    // Assert
    assertEquals("Time", actualOfResult.value());
    assertEquals(0L, actualOfResult.seconds());
  }
}
