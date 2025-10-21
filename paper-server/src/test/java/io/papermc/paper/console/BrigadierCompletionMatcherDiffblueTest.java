package io.papermc.paper.console;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.jline.reader.CompletingParsedLine;
import org.jline.reader.LineReader;
import org.jline.reader.LineReader.Option;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.DefaultParser.ArgumentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BrigadierCompletionMatcherDiffblueTest {
  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>Given {@code COMPLETE_IN_WORD}.
   *   <li>When {@link HashMap#HashMap()} {@code COMPLETE_IN_WORD} is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); given 'COMPLETE_IN_WORD'; when HashMap() 'COMPLETE_IN_WORD' is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_givenCompleteInWord_whenHashMapCompleteInWordIsTrue() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();

    HashMap<Option, Boolean> options = new HashMap<>();
    options.put(Option.COMPLETE_MATCHER_TYPO, false);
    options.put(Option.COMPLETE_IN_WORD, true);

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, false, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line, atLeast(1)).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link ArgumentList#word()}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); given one; when HashMap(); then calls word()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_givenOne_whenHashMap_thenCallsWord() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();
    HashMap<Option, Boolean> options = new HashMap<>();

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, true, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link ArgumentList#word()}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); given one; when HashMap(); then calls word()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_givenOne_whenHashMap_thenCallsWord2() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();
    HashMap<Option, Boolean> options = new HashMap<>();

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, false, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link ArgumentList#word()}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); given one; when HashMap(); then calls word()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_givenOne_whenHashMap_thenCallsWord3() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();
    HashMap<Option, Boolean> options = new HashMap<>();

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, true, line, false, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code COMPLETE_MATCHER_CAMELCASE} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); when HashMap() 'COMPLETE_MATCHER_CAMELCASE' is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_whenHashMapCompleteMatcherCamelcaseIsFalse() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();

    HashMap<Option, Boolean> options = new HashMap<>();
    options.put(Option.COMPLETE_MATCHER_TYPO, false);
    options.put(Option.COMPLETE_MATCHER_CAMELCASE, false);

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, true, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code COMPLETE_MATCHER_CAMELCASE} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); when HashMap() 'COMPLETE_MATCHER_CAMELCASE' is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_whenHashMapCompleteMatcherCamelcaseIsFalse2() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();

    HashMap<Option, Boolean> options = new HashMap<>();
    options.put(Option.COMPLETE_MATCHER_TYPO, false);
    options.put(Option.COMPLETE_MATCHER_CAMELCASE, false);

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, false, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code COMPLETE_MATCHER_CAMELCASE} is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); when HashMap() 'COMPLETE_MATCHER_CAMELCASE' is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_whenHashMapCompleteMatcherCamelcaseIsTrue() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();

    HashMap<Option, Boolean> options = new HashMap<>();
    options.put(Option.COMPLETE_MATCHER_TYPO, false);
    options.put(Option.COMPLETE_MATCHER_CAMELCASE, true);

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, false, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }

  /**
   * Test {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean, CompletingParsedLine,
   * boolean, int, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code COMPLETE_MATCHER_TYPO} is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BrigadierCompletionMatcher#defaultMatchers(Map, boolean,
   * CompletingParsedLine, boolean, int, String)}
   */
  @Test
  @DisplayName(
      "Test defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String); when HashMap() 'COMPLETE_MATCHER_TYPO' is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BrigadierCompletionMatcher.defaultMatchers(Map, boolean, CompletingParsedLine, boolean, int, String)"
  })
  void testDefaultMatchers_whenHashMapCompleteMatcherTypoIsTrue() {
    // Arrange
    BrigadierCompletionMatcher brigadierCompletionMatcher = new BrigadierCompletionMatcher();

    HashMap<Option, Boolean> options = new HashMap<>();
    options.put(Option.COMPLETE_MATCHER_TYPO, true);

    ArgumentList line = mock(ArgumentList.class);
    when(line.wordCursor()).thenReturn(1);
    when(line.word()).thenReturn("Word");

    // Act
    brigadierCompletionMatcher.defaultMatchers(
        options, false, line, true, -1, "Original Group Name");

    // Assert
    verify(line).word();
    verify(line).wordCursor();
  }
}
