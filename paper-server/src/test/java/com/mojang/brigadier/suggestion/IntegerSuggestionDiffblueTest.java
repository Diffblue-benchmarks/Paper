package com.mojang.brigadier.suggestion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.context.StringRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerSuggestionDiffblueTest {
  /**
   * Test {@link IntegerSuggestion#IntegerSuggestion(StringRange, int)}.
   *
   * <p>Method under test: {@link IntegerSuggestion#IntegerSuggestion(StringRange, int)}
   */
  @Test
  @DisplayName("Test new IntegerSuggestion(StringRange, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegerSuggestion.<init>(StringRange, int)"})
  void testNewIntegerSuggestion() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act
    IntegerSuggestion actualIntegerSuggestion = new IntegerSuggestion(range, 42);

    // Assert
    assertEquals("42", actualIntegerSuggestion.getText());
    assertNull(actualIntegerSuggestion.getTooltip());
    assertEquals(42, actualIntegerSuggestion.getValue());
    assertSame(range, actualIntegerSuggestion.getRange());
  }

  /**
   * Test {@link IntegerSuggestion#IntegerSuggestion(StringRange, int, Message)}.
   *
   * <p>Method under test: {@link IntegerSuggestion#IntegerSuggestion(StringRange, int, Message)}
   */
  @Test
  @DisplayName("Test new IntegerSuggestion(StringRange, int, Message)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntegerSuggestion.<init>(StringRange, int, Message)"})
  void testNewIntegerSuggestion2() {
    // Arrange
    StringRange range = StringRange.at(1);
    Message tooltip = mock(Message.class);

    // Act
    IntegerSuggestion actualIntegerSuggestion = new IntegerSuggestion(range, 42, tooltip);

    // Assert
    assertEquals("42", actualIntegerSuggestion.getText());
    assertEquals(42, actualIntegerSuggestion.getValue());
    assertSame(range, actualIntegerSuggestion.getRange());
    assertSame(tooltip, actualIntegerSuggestion.getTooltip());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerSuggestion#toString()}
   *   <li>{@link IntegerSuggestion#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerSuggestion.getValue()", "String IntegerSuggestion.toString()"})
  void testGettersAndSetters() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);

    // Act
    String actualToStringResult = integerSuggestion.toString();

    // Assert
    assertEquals(
        "IntegerSuggestion{value=42, range=StringRange{start=1, end=1}, text='42', tooltip='null'}",
        actualToStringResult);
    assertEquals(42, integerSuggestion.getValue());
  }

  /**
   * Test {@link IntegerSuggestion#equals(Object)}, and {@link IntegerSuggestion#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerSuggestion#equals(Object)}
   *   <li>{@link IntegerSuggestion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegerSuggestion.equals(Object)",
    "int IntegerSuggestion.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);
    StringRange range2 = StringRange.at(1);
    IntegerSuggestion integerSuggestion2 = new IntegerSuggestion(range2, 42);

    // Act and Assert
    assertEquals(integerSuggestion, integerSuggestion2);
    assertEquals(integerSuggestion.hashCode(), integerSuggestion2.hashCode());
  }

  /**
   * Test {@link IntegerSuggestion#equals(Object)}, and {@link IntegerSuggestion#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerSuggestion#equals(Object)}
   *   <li>{@link IntegerSuggestion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegerSuggestion.equals(Object)",
    "int IntegerSuggestion.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);

    // Act and Assert
    assertEquals(integerSuggestion, integerSuggestion);
    int expectedHashCodeResult = integerSuggestion.hashCode();
    assertEquals(expectedHashCodeResult, integerSuggestion.hashCode());
  }

  /**
   * Test {@link IntegerSuggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegerSuggestion.equals(Object)",
    "int IntegerSuggestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(null, 42);
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertNotEquals(integerSuggestion, new IntegerSuggestion(range, 42));
  }

  /**
   * Test {@link IntegerSuggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegerSuggestion.equals(Object)",
    "int IntegerSuggestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 1);
    StringRange range2 = StringRange.at(1);

    // Act and Assert
    assertNotEquals(integerSuggestion, new IntegerSuggestion(range2, 42));
  }

  /**
   * Test {@link IntegerSuggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegerSuggestion.equals(Object)",
    "int IntegerSuggestion.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertNotEquals(new IntegerSuggestion(range, 42), null);
  }

  /**
   * Test {@link IntegerSuggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IntegerSuggestion.equals(Object)",
    "int IntegerSuggestion.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertNotEquals(new IntegerSuggestion(range, 42), "Different type to IntegerSuggestion");
  }

  /**
   * Test {@link IntegerSuggestion#compareTo(Suggestion)} with {@code o}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#compareTo(Suggestion)}
   */
  @Test
  @DisplayName("Test compareTo(Suggestion) with 'o'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerSuggestion.compareTo(Suggestion)"})
  void testCompareToWithO_thenReturnZero() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToResult = integerSuggestion.compareTo(new IntegerSuggestion(range2, 42));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link IntegerSuggestion#compareTo(Suggestion)} with {@code o}.
   *
   * <ul>
   *   <li>When {@link Suggestion#Suggestion(StringRange, String)} with range is at one and {@code
   *       Text}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#compareTo(Suggestion)}
   */
  @Test
  @DisplayName(
      "Test compareTo(Suggestion) with 'o'; when Suggestion(StringRange, String) with range is at one and 'Text'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerSuggestion.compareTo(Suggestion)"})
  void testCompareToWithO_whenSuggestionWithRangeIsAtOneAndText_thenReturnMinusOne() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToResult = integerSuggestion.compareTo(new Suggestion(range2, "Text"));

    // Assert
    assertEquals(-1, actualCompareToResult);
  }

  /**
   * Test {@link IntegerSuggestion#compareToIgnoreCase(Suggestion)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#compareToIgnoreCase(Suggestion)}
   */
  @Test
  @DisplayName("Test compareToIgnoreCase(Suggestion); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerSuggestion.compareToIgnoreCase(Suggestion)"})
  void testCompareToIgnoreCase_thenReturnZero() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToIgnoreCaseResult =
        integerSuggestion.compareToIgnoreCase(new IntegerSuggestion(range2, 42));

    // Assert
    assertEquals(0, actualCompareToIgnoreCaseResult);
  }

  /**
   * Test {@link IntegerSuggestion#compareToIgnoreCase(Suggestion)}.
   *
   * <ul>
   *   <li>When {@link Suggestion#Suggestion(StringRange, String)} with range is at one and {@code
   *       Text}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link IntegerSuggestion#compareToIgnoreCase(Suggestion)}
   */
  @Test
  @DisplayName(
      "Test compareToIgnoreCase(Suggestion); when Suggestion(StringRange, String) with range is at one and 'Text'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerSuggestion.compareToIgnoreCase(Suggestion)"})
  void testCompareToIgnoreCase_whenSuggestionWithRangeIsAtOneAndText_thenReturnMinusOne() {
    // Arrange
    StringRange range = StringRange.at(1);
    IntegerSuggestion integerSuggestion = new IntegerSuggestion(range, 42);
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToIgnoreCaseResult =
        integerSuggestion.compareToIgnoreCase(new Suggestion(range2, "Text"));

    // Assert
    assertEquals(-1, actualCompareToIgnoreCaseResult);
  }
}
