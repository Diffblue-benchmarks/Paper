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

class SuggestionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Suggestion#Suggestion(StringRange, String)}
   *   <li>{@link Suggestion#toString()}
   *   <li>{@link Suggestion#getRange()}
   *   <li>{@link Suggestion#getText()}
   *   <li>{@link Suggestion#getTooltip()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Suggestion.<init>(StringRange, String)",
    "void Suggestion.<init>(StringRange, String, Message)",
    "StringRange Suggestion.getRange()",
    "String Suggestion.getText()",
    "Message Suggestion.getTooltip()",
    "String Suggestion.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act
    Suggestion actualSuggestion = new Suggestion(range, "Text");
    String actualToStringResult = actualSuggestion.toString();
    StringRange actualRange = actualSuggestion.getRange();
    String actualText = actualSuggestion.getText();

    // Assert
    assertEquals(
        "Suggestion{range=StringRange{start=1, end=1}, text='Text', tooltip='null'}",
        actualToStringResult);
    assertEquals("Text", actualText);
    assertNull(actualSuggestion.getTooltip());
    assertSame(range, actualRange);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Message}.
   *   <li>Then return Tooltip is {@link Message}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Suggestion#Suggestion(StringRange, String, Message)}
   *   <li>{@link Suggestion#toString()}
   *   <li>{@link Suggestion#getRange()}
   *   <li>{@link Suggestion#getText()}
   *   <li>{@link Suggestion#getTooltip()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Message; then return Tooltip is Message")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Suggestion.<init>(StringRange, String)",
    "void Suggestion.<init>(StringRange, String, Message)",
    "StringRange Suggestion.getRange()",
    "String Suggestion.getText()",
    "Message Suggestion.getTooltip()",
    "String Suggestion.toString()"
  })
  void testGettersAndSetters_whenMessage_thenReturnTooltipIsMessage() {
    // Arrange
    StringRange range = StringRange.at(1);
    Message tooltip = mock(Message.class);

    // Act
    Suggestion actualSuggestion = new Suggestion(range, "Text", tooltip);
    actualSuggestion.toString();
    StringRange actualRange = actualSuggestion.getRange();
    String actualText = actualSuggestion.getText();

    // Assert
    assertEquals("Text", actualText);
    assertSame(range, actualRange);
    assertSame(tooltip, actualSuggestion.getTooltip());
  }

  /**
   * Test {@link Suggestion#apply(String)}.
   *
   * <ul>
   *   <li>Given {@link StringRange#StringRange(int, int)} with start is one and end is five.
   *   <li>When {@code Input}.
   *   <li>Then return {@code IText}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#apply(String)}
   */
  @Test
  @DisplayName(
      "Test apply(String); given StringRange(int, int) with start is one and end is five; when 'Input'; then return 'IText'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Suggestion.apply(String)"})
  void testApply_givenStringRangeWithStartIsOneAndEndIsFive_whenInput_thenReturnIText() {
    // Arrange, Act and Assert
    assertEquals("IText", new Suggestion(new StringRange(1, 5), "Text").apply("Input"));
  }

  /**
   * Test {@link Suggestion#apply(String)}.
   *
   * <ul>
   *   <li>Given {@link StringRange#StringRange(int, int)} with start is zero and end is five.
   *   <li>When {@code Input}.
   *   <li>Then return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#apply(String)}
   */
  @Test
  @DisplayName(
      "Test apply(String); given StringRange(int, int) with start is zero and end is five; when 'Input'; then return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Suggestion.apply(String)"})
  void testApply_givenStringRangeWithStartIsZeroAndEndIsFive_whenInput_thenReturnText() {
    // Arrange, Act and Assert
    assertEquals("Text", new Suggestion(new StringRange(0, 5), "Text").apply("Input"));
  }

  /**
   * Test {@link Suggestion#apply(String)}.
   *
   * <ul>
   *   <li>Given {@link StringRange#StringRange(int, int)} with start is zero and end is three.
   *   <li>Then return {@code Textut}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#apply(String)}
   */
  @Test
  @DisplayName(
      "Test apply(String); given StringRange(int, int) with start is zero and end is three; then return 'Textut'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Suggestion.apply(String)"})
  void testApply_givenStringRangeWithStartIsZeroAndEndIsThree_thenReturnTextut() {
    // Arrange, Act and Assert
    assertEquals("Textut", new Suggestion(new StringRange(0, 3), "Text").apply("Input"));
  }

  /**
   * Test {@link Suggestion#apply(String)}.
   *
   * <ul>
   *   <li>Given {@link Suggestion#Suggestion(StringRange, String)} with range is at one and {@code
   *       Text}.
   *   <li>When {@code Input}.
   *   <li>Then return {@code ITextnput}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#apply(String)}
   */
  @Test
  @DisplayName(
      "Test apply(String); given Suggestion(StringRange, String) with range is at one and 'Text'; when 'Input'; then return 'ITextnput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Suggestion.apply(String)"})
  void testApply_givenSuggestionWithRangeIsAtOneAndText_whenInput_thenReturnITextnput() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertEquals("ITextnput", new Suggestion(range, "Text").apply("Input"));
  }

  /**
   * Test {@link Suggestion#equals(Object)}, and {@link Suggestion#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Suggestion#equals(Object)}
   *   <li>{@link Suggestion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);
    Suggestion suggestion2 = new Suggestion(range2, "Text");

    // Act and Assert
    assertEquals(suggestion, suggestion2);
    assertEquals(suggestion.hashCode(), suggestion2.hashCode());
  }

  /**
   * Test {@link Suggestion#equals(Object)}, and {@link Suggestion#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Suggestion#equals(Object)}
   *   <li>{@link Suggestion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");

    // Act and Assert
    assertEquals(suggestion, suggestion);
    int expectedHashCodeResult = suggestion.hashCode();
    assertEquals(expectedHashCodeResult, suggestion.hashCode());
  }

  /**
   * Test {@link Suggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Suggestion suggestion = new Suggestion(null, "Text");
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertNotEquals(suggestion, new Suggestion(range, "Text"));
  }

  /**
   * Test {@link Suggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion =
        new Suggestion(range, "com.mojang.brigadier.suggestion.IntegerSuggestion");
    StringRange range2 = StringRange.at(1);

    // Act and Assert
    assertNotEquals(suggestion, new Suggestion(range2, "Text"));
  }

  /**
   * Test {@link Suggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text", mock(Message.class));
    StringRange range2 = StringRange.at(1);

    // Act and Assert
    assertNotEquals(suggestion, new Suggestion(range2, "Text"));
  }

  /**
   * Test {@link Suggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertNotEquals(new Suggestion(range, "Text"), null);
  }

  /**
   * Test {@link Suggestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Suggestion.equals(Object)", "int Suggestion.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StringRange range = StringRange.at(1);

    // Act and Assert
    assertNotEquals(new Suggestion(range, "Text"), "Different type to Suggestion");
  }

  /**
   * Test {@link Suggestion#compareTo(Suggestion)} with {@code o}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareTo(Suggestion)}
   */
  @Test
  @DisplayName("Test compareTo(Suggestion) with 'o'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareTo(Suggestion)"})
  void testCompareToWithO_thenReturnMinusOne() {
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
   * Test {@link Suggestion#compareTo(Suggestion)} with {@code o}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareTo(Suggestion)}
   */
  @Test
  @DisplayName("Test compareTo(Suggestion) with 'o'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareTo(Suggestion)"})
  void testCompareToWithO_thenReturnOne() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToResult = suggestion.compareTo(new IntegerSuggestion(range2, 42));

    // Assert
    assertEquals(1, actualCompareToResult);
  }

  /**
   * Test {@link Suggestion#compareTo(Suggestion)} with {@code o}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareTo(Suggestion)}
   */
  @Test
  @DisplayName("Test compareTo(Suggestion) with 'o'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareTo(Suggestion)"})
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
   * Test {@link Suggestion#compareTo(Suggestion)} with {@code o}.
   *
   * <ul>
   *   <li>When {@link Suggestion#Suggestion(StringRange, String)} with range is at one and {@code
   *       Text}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareTo(Suggestion)}
   */
  @Test
  @DisplayName(
      "Test compareTo(Suggestion) with 'o'; when Suggestion(StringRange, String) with range is at one and 'Text'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareTo(Suggestion)"})
  void testCompareToWithO_whenSuggestionWithRangeIsAtOneAndText_thenReturnZero() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToResult = suggestion.compareTo(new Suggestion(range2, "Text"));

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link Suggestion#compareToIgnoreCase(Suggestion)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareToIgnoreCase(Suggestion)}
   */
  @Test
  @DisplayName("Test compareToIgnoreCase(Suggestion); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareToIgnoreCase(Suggestion)"})
  void testCompareToIgnoreCase_thenReturnMinusOne() {
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

  /**
   * Test {@link Suggestion#compareToIgnoreCase(Suggestion)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareToIgnoreCase(Suggestion)}
   */
  @Test
  @DisplayName("Test compareToIgnoreCase(Suggestion); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareToIgnoreCase(Suggestion)"})
  void testCompareToIgnoreCase_thenReturnOne() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToIgnoreCaseResult =
        suggestion.compareToIgnoreCase(new IntegerSuggestion(range2, 42));

    // Assert
    assertEquals(1, actualCompareToIgnoreCaseResult);
  }

  /**
   * Test {@link Suggestion#compareToIgnoreCase(Suggestion)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareToIgnoreCase(Suggestion)}
   */
  @Test
  @DisplayName("Test compareToIgnoreCase(Suggestion); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareToIgnoreCase(Suggestion)"})
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
   * Test {@link Suggestion#compareToIgnoreCase(Suggestion)}.
   *
   * <ul>
   *   <li>When {@link Suggestion#Suggestion(StringRange, String)} with range is at one and {@code
   *       Text}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#compareToIgnoreCase(Suggestion)}
   */
  @Test
  @DisplayName(
      "Test compareToIgnoreCase(Suggestion); when Suggestion(StringRange, String) with range is at one and 'Text'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Suggestion.compareToIgnoreCase(Suggestion)"})
  void testCompareToIgnoreCase_whenSuggestionWithRangeIsAtOneAndText_thenReturnZero() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);

    // Act
    int actualCompareToIgnoreCaseResult =
        suggestion.compareToIgnoreCase(new Suggestion(range2, "Text"));

    // Assert
    assertEquals(0, actualCompareToIgnoreCaseResult);
  }

  /**
   * Test {@link Suggestion#expand(String, StringRange)}.
   *
   * <ul>
   *   <li>Given {@link Suggestion#Suggestion(StringRange, String)} with range is at zero and {@code
   *       Text}.
   *   <li>Then return Text is {@code TextC}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#expand(String, StringRange)}
   */
  @Test
  @DisplayName(
      "Test expand(String, StringRange); given Suggestion(StringRange, String) with range is at zero and 'Text'; then return Text is 'TextC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Suggestion Suggestion.expand(String, StringRange)"})
  void testExpand_givenSuggestionWithRangeIsAtZeroAndText_thenReturnTextIsTextC() {
    // Arrange
    StringRange range = StringRange.at(0);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);

    // Act
    Suggestion actualExpandResult = suggestion.expand("Command", range2);

    // Assert
    assertEquals("TextC", actualExpandResult.getText());
    assertNull(actualExpandResult.getTooltip());
    assertSame(range2, actualExpandResult.getRange());
  }

  /**
   * Test {@link Suggestion#expand(String, StringRange)}.
   *
   * <ul>
   *   <li>Given {@link Suggestion#Suggestion(StringRange, String)} with range is between one and
   *       three and {@code Text}.
   *   <li>Then return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#expand(String, StringRange)}
   */
  @Test
  @DisplayName(
      "Test expand(String, StringRange); given Suggestion(StringRange, String) with range is between one and three and 'Text'; then return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Suggestion Suggestion.expand(String, StringRange)"})
  void testExpand_givenSuggestionWithRangeIsBetweenOneAndThreeAndText_thenReturnText() {
    // Arrange
    StringRange range = StringRange.between(1, 3);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(1);

    // Act
    Suggestion actualExpandResult = suggestion.expand("Command", range2);

    // Assert
    assertEquals("Text", actualExpandResult.getText());
    assertNull(actualExpandResult.getTooltip());
    assertSame(range2, actualExpandResult.getRange());
  }

  /**
   * Test {@link Suggestion#expand(String, StringRange)}.
   *
   * <ul>
   *   <li>Then return {@link Suggestion#Suggestion(StringRange, String)} with range is at one and
   *       {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#expand(String, StringRange)}
   */
  @Test
  @DisplayName(
      "Test expand(String, StringRange); then return Suggestion(StringRange, String) with range is at one and 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Suggestion Suggestion.expand(String, StringRange)"})
  void testExpand_thenReturnSuggestionWithRangeIsAtOneAndText() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");

    // Act
    Suggestion actualExpandResult = suggestion.expand("Command", StringRange.at(1));

    // Assert
    assertSame(suggestion, actualExpandResult);
  }

  /**
   * Test {@link Suggestion#expand(String, StringRange)}.
   *
   * <ul>
   *   <li>When at zero.
   *   <li>Then return Text is {@code CText}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#expand(String, StringRange)}
   */
  @Test
  @DisplayName("Test expand(String, StringRange); when at zero; then return Text is 'CText'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Suggestion Suggestion.expand(String, StringRange)"})
  void testExpand_whenAtZero_thenReturnTextIsCText() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.at(0);

    // Act
    Suggestion actualExpandResult = suggestion.expand("Command", range2);

    // Assert
    assertEquals("CText", actualExpandResult.getText());
    assertNull(actualExpandResult.getTooltip());
    assertSame(range2, actualExpandResult.getRange());
  }

  /**
   * Test {@link Suggestion#expand(String, StringRange)}.
   *
   * <ul>
   *   <li>When between one and three.
   *   <li>Then return Text is {@code Textom}.
   * </ul>
   *
   * <p>Method under test: {@link Suggestion#expand(String, StringRange)}
   */
  @Test
  @DisplayName(
      "Test expand(String, StringRange); when between one and three; then return Text is 'Textom'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Suggestion Suggestion.expand(String, StringRange)"})
  void testExpand_whenBetweenOneAndThree_thenReturnTextIsTextom() {
    // Arrange
    StringRange range = StringRange.at(1);
    Suggestion suggestion = new Suggestion(range, "Text");
    StringRange range2 = StringRange.between(1, 3);

    // Act
    Suggestion actualExpandResult = suggestion.expand("Command", range2);

    // Assert
    assertEquals("Textom", actualExpandResult.getText());
    assertNull(actualExpandResult.getTooltip());
    assertSame(range2, actualExpandResult.getRange());
  }
}
