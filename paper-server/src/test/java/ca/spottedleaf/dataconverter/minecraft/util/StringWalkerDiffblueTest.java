package ca.spottedleaf.dataconverter.minecraft.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringWalkerDiffblueTest {
  /**
   * Test {@link StringWalker#StringWalker(String)}.
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String)}
   */
  @Test
  @DisplayName("Test new StringWalker(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String)"})
  void testNewStringWalker() {
    // Arrange and Act
    StringWalker actualStringWalker = new StringWalker("String");

    // Assert
    assertEquals("String", actualStringWalker.string);
    assertEquals(0, actualStringWalker.getIndex());
    assertTrue(actualStringWalker.hasNext());
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int)}
   */
  @Test
  @DisplayName(
      "Test new StringWalker(String, int); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int)"})
  void testNewStringWalker_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StringWalker("", 1));
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int, int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test new StringWalker(String, int, int); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int, int)"})
  void testNewStringWalker_whenEmptyString_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StringWalker("", 1, 1));
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int)}
   */
  @Test
  @DisplayName(
      "Test new StringWalker(String, int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int)"})
  void testNewStringWalker_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StringWalker("String", -1));
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test new StringWalker(String, int, int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int, int)"})
  void testNewStringWalker_whenMinusOne_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StringWalker("String", -1, 0));
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int, int)}
   */
  @Test
  @DisplayName("Test new StringWalker(String, int, int); when one; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int, int)"})
  void testNewStringWalker_whenOne_thenReturnString() {
    // Arrange and Act
    StringWalker actualStringWalker = new StringWalker("String", 1, 1);

    // Assert
    assertEquals("String", actualStringWalker.string);
    assertEquals(1, actualStringWalker.getIndex());
    assertFalse(actualStringWalker.hasNext());
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int, int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test new StringWalker(String, int, int); when six; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int, int)"})
  void testNewStringWalker_whenSix_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StringWalker("String", 6, 1));
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int)}
   */
  @Test
  @DisplayName("Test new StringWalker(String, int); when 'String'; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int)"})
  void testNewStringWalker_whenString_thenReturnString() {
    // Arrange and Act
    StringWalker actualStringWalker = new StringWalker("String", 1);

    // Assert
    assertEquals("String", actualStringWalker.string);
    assertEquals(1, actualStringWalker.getIndex());
    assertTrue(actualStringWalker.hasNext());
  }

  /**
   * Test {@link StringWalker#StringWalker(String, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#StringWalker(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test new StringWalker(String, int, int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.<init>(String, int, int)"})
  void testNewStringWalker_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new StringWalker("String", 0, -1));
  }

  /**
   * Test {@link StringWalker#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link StringWalker#StringWalker(String)} with {@code String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given StringWalker(String) with 'String'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringWalker.hasNext()"})
  void testHasNext_givenStringWalkerWithString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new StringWalker("String").hasNext());
  }

  /**
   * Test {@link StringWalker#hasNext()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringWalker.hasNext()"})
  void testHasNext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StringWalker("String", 1, 1).hasNext());
  }

  /**
   * Test {@link StringWalker#next()}.
   *
   * <ul>
   *   <li>Given {@link StringWalker#StringWalker(String)} with {@code String}.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#next()}
   */
  @Test
  @DisplayName("Test next(); given StringWalker(String) with 'String'; then return 'S'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char StringWalker.next()"})
  void testNext_givenStringWalkerWithString_thenReturnS() {
    // Arrange
    StringWalker stringWalker = new StringWalker("String");

    // Act and Assert
    assertEquals('S', stringWalker.next());
    assertEquals(1, stringWalker.getIndex());
  }

  /**
   * Test {@link StringWalker#peek()}.
   *
   * <ul>
   *   <li>Given {@link StringWalker#StringWalker(String)} with {@code String}.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#peek()}
   */
  @Test
  @DisplayName("Test peek(); given StringWalker(String) with 'String'; then return 'S'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char StringWalker.peek()"})
  void testPeek_givenStringWalkerWithString_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals('S', new StringWalker("String").peek());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringWalker#setIndex(int)}
   *   <li>{@link StringWalker#advance()}
   *   <li>{@link StringWalker#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StringWalker.advance()",
    "int StringWalker.getIndex()",
    "void StringWalker.setIndex(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    StringWalker stringWalker = new StringWalker("String");

    // Act
    stringWalker.setIndex(1);
    stringWalker.advance();

    // Assert
    assertEquals(2, stringWalker.getIndex());
  }

  /**
   * Test {@link StringWalker#skipWhitespace()}.
   *
   * <p>Method under test: {@link StringWalker#skipWhitespace()}
   */
  @Test
  @DisplayName("Test skipWhitespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.skipWhitespace()"})
  void testSkipWhitespace() {
    // Arrange
    StringWalker stringWalker = new StringWalker("String", 1, 1);

    // Act
    stringWalker.skipWhitespace();

    // Assert that nothing has changed
    assertEquals(1, stringWalker.getIndex());
    assertFalse(stringWalker.hasNext());
  }

  /**
   * Test {@link StringWalker#skipWhitespace()}.
   *
   * <p>Method under test: {@link StringWalker#skipWhitespace()}
   */
  @Test
  @DisplayName("Test skipWhitespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringWalker.skipWhitespace()"})
  void testSkipWhitespace2() {
    // Arrange
    StringWalker stringWalker = new StringWalker("String", 0, 1);

    // Act
    stringWalker.skipWhitespace();

    // Assert
    assertEquals(1, stringWalker.getIndex());
    assertFalse(stringWalker.hasNext());
  }

  /**
   * Test {@link StringWalker#skipIf(char)}.
   *
   * <ul>
   *   <li>Given {@link StringWalker#StringWalker(String)} with {@code String}.
   *   <li>Then {@link StringWalker#StringWalker(String)} with {@code String} Index is zero.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#skipIf(char)}
   */
  @Test
  @DisplayName(
      "Test skipIf(char); given StringWalker(String) with 'String'; then StringWalker(String) with 'String' Index is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringWalker.skipIf(char)"})
  void testSkipIf_givenStringWalkerWithString_thenStringWalkerWithStringIndexIsZero() {
    // Arrange
    StringWalker stringWalker = new StringWalker("String");

    // Act
    boolean actualSkipIfResult = stringWalker.skipIf('A');

    // Assert
    assertEquals(0, stringWalker.getIndex());
    assertFalse(actualSkipIfResult);
  }

  /**
   * Test {@link StringWalker#skipIf(char)}.
   *
   * <ul>
   *   <li>Then {@link StringWalker#StringWalker(String)} with string is empty string Index is zero.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#skipIf(char)}
   */
  @Test
  @DisplayName(
      "Test skipIf(char); then StringWalker(String) with string is empty string Index is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringWalker.skipIf(char)"})
  void testSkipIf_thenStringWalkerWithStringIsEmptyStringIndexIsZero() {
    // Arrange
    StringWalker stringWalker = new StringWalker("");

    // Act
    boolean actualSkipIfResult = stringWalker.skipIf('A');

    // Assert
    assertEquals(0, stringWalker.getIndex());
    assertFalse(actualSkipIfResult);
  }

  /**
   * Test {@link StringWalker#skipIf(char)}.
   *
   * <ul>
   *   <li>When {@code S}.
   *   <li>Then {@link StringWalker#StringWalker(String)} with {@code String} Index is one.
   * </ul>
   *
   * <p>Method under test: {@link StringWalker#skipIf(char)}
   */
  @Test
  @DisplayName("Test skipIf(char); when 'S'; then StringWalker(String) with 'String' Index is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringWalker.skipIf(char)"})
  void testSkipIf_whenS_thenStringWalkerWithStringIndexIsOne() {
    // Arrange
    StringWalker stringWalker = new StringWalker("String");

    // Act
    boolean actualSkipIfResult = stringWalker.skipIf('S');

    // Assert
    assertEquals(1, stringWalker.getIndex());
    assertTrue(actualSkipIfResult);
  }

  /**
   * Test {@link StringWalker#parseFail(int, String)}.
   *
   * <p>Method under test: {@link StringWalker#parseFail(int, String)}
   */
  @Test
  @DisplayName("Test parseFail(int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IllegalStateException StringWalker.parseFail(int, String)"})
  void testParseFail() {
    // Arrange and Act
    IllegalStateException actualParseFailResult =
        new StringWalker("String").parseFail(1, "Just cause");

    // Assert
    assertEquals("At column 1: Just cause", actualParseFailResult.getLocalizedMessage());
    assertEquals("At column 1: Just cause", actualParseFailResult.getMessage());
    assertNull(actualParseFailResult.getCause());
    assertEquals(0, actualParseFailResult.getSuppressed().length);
  }
}
