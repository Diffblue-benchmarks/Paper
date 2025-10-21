package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Collection cannot be null}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}
   */
  @Test
  @DisplayName(
      "Test copyPartialMatches(String, Iterable, Collection); given 'Collection cannot be null'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection StringUtil.copyPartialMatches(String, Iterable, Collection)"})
  void testCopyPartialMatches_givenCollectionCannotBeNull_thenReturnSizeIsTwo()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    ArrayList<String> originals = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Collection cannot be null");
    stringList.add("Search token cannot be null");

    // Act
    Collection<? super String> actualCopyPartialMatchesResult =
        StringUtil.copyPartialMatches("ABC123", originals, stringList);

    // Assert
    assertTrue(actualCopyPartialMatchesResult instanceof List);
    assertEquals(2, actualCopyPartialMatchesResult.size());
    assertEquals(
        "Collection cannot be null",
        ((List<? super String>) actualCopyPartialMatchesResult).get(0));
    assertEquals(
        "Search token cannot be null",
        ((List<? super String>) actualCopyPartialMatchesResult).get(1));
  }

  /**
   * Test {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}
   */
  @Test
  @DisplayName(
      "Test copyPartialMatches(String, Iterable, Collection); given 'foo'; when ArrayList() add 'foo'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection StringUtil.copyPartialMatches(String, Iterable, Collection)"})
  void testCopyPartialMatches_givenFoo_whenArrayListAddFoo_thenReturnEmpty()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    ArrayList<String> originals = new ArrayList<>();
    originals.add("foo");

    // Act
    Collection<? super String> actualCopyPartialMatchesResult =
        StringUtil.copyPartialMatches("ABC123", originals, new ArrayList<>());

    // Assert
    assertTrue(actualCopyPartialMatchesResult instanceof List);
    assertTrue(actualCopyPartialMatchesResult.isEmpty());
  }

  /**
   * Test {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When empty string.
   *   <li>Then return first is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}
   */
  @Test
  @DisplayName(
      "Test copyPartialMatches(String, Iterable, Collection); given 'foo'; when empty string; then return first is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection StringUtil.copyPartialMatches(String, Iterable, Collection)"})
  void testCopyPartialMatches_givenFoo_whenEmptyString_thenReturnFirstIsFoo()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    ArrayList<String> originals = new ArrayList<>();
    originals.add("foo");

    // Act
    Collection<? super String> actualCopyPartialMatchesResult =
        StringUtil.copyPartialMatches("", originals, new ArrayList<>());

    // Assert
    assertTrue(actualCopyPartialMatchesResult instanceof List);
    assertEquals(1, actualCopyPartialMatchesResult.size());
    assertEquals("foo", ((List<? super String>) actualCopyPartialMatchesResult).get(0));
  }

  /**
   * Test {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Originals}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Originals}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}
   */
  @Test
  @DisplayName(
      "Test copyPartialMatches(String, Iterable, Collection); given 'Originals'; when LinkedHashSet() add 'Originals'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection StringUtil.copyPartialMatches(String, Iterable, Collection)"})
  void testCopyPartialMatches_givenOriginals_whenLinkedHashSetAddOriginals()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    LinkedHashSet<String> originals = new LinkedHashSet<>();
    originals.add("Originals");

    // Act
    Collection<? super String> actualCopyPartialMatchesResult =
        StringUtil.copyPartialMatches("ABC123", originals, new ArrayList<>());

    // Assert
    assertTrue(actualCopyPartialMatchesResult instanceof List);
    assertTrue(actualCopyPartialMatchesResult.isEmpty());
  }

  /**
   * Test {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}.
   *
   * <ul>
   *   <li>Then return first is {@code Search token cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}
   */
  @Test
  @DisplayName(
      "Test copyPartialMatches(String, Iterable, Collection); then return first is 'Search token cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection StringUtil.copyPartialMatches(String, Iterable, Collection)"})
  void testCopyPartialMatches_thenReturnFirstIsSearchTokenCannotBeNull()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    ArrayList<String> originals = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Search token cannot be null");

    // Act
    Collection<? super String> actualCopyPartialMatchesResult =
        StringUtil.copyPartialMatches("ABC123", originals, stringList);

    // Assert
    assertTrue(actualCopyPartialMatchesResult instanceof List);
    assertEquals(1, actualCopyPartialMatchesResult.size());
    assertEquals(
        "Search token cannot be null",
        ((List<? super String>) actualCopyPartialMatchesResult).get(0));
  }

  /**
   * Test {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}.
   *
   * <ul>
   *   <li>When {@code ABC123}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#copyPartialMatches(String, Iterable, Collection)}
   */
  @Test
  @DisplayName(
      "Test copyPartialMatches(String, Iterable, Collection); when 'ABC123'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection StringUtil.copyPartialMatches(String, Iterable, Collection)"})
  void testCopyPartialMatches_whenAbc123_thenReturnEmpty()
      throws IllegalArgumentException, UnsupportedOperationException {
    // Arrange
    ArrayList<String> originals = new ArrayList<>();

    // Act
    Collection<? super String> actualCopyPartialMatchesResult =
        StringUtil.copyPartialMatches("ABC123", originals, new ArrayList<>());

    // Assert
    assertTrue(actualCopyPartialMatchesResult instanceof List);
    assertTrue(actualCopyPartialMatchesResult.isEmpty());
  }

  /**
   * Test {@link StringUtil#startsWithIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#startsWithIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test startsWithIgnoreCase(String, String); when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.startsWithIgnoreCase(String, String)"})
  void testStartsWithIgnoreCase_when42_thenReturnFalse()
      throws IllegalArgumentException, NullPointerException {
    // Arrange, Act and Assert
    assertFalse(StringUtil.startsWithIgnoreCase("42", "Prefix"));
  }

  /**
   * Test {@link StringUtil#startsWithIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#startsWithIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test startsWithIgnoreCase(String, String); when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.startsWithIgnoreCase(String, String)"})
  void testStartsWithIgnoreCase_whenEmptyString_thenReturnTrue()
      throws IllegalArgumentException, NullPointerException {
    // Arrange, Act and Assert
    assertTrue(StringUtil.startsWithIgnoreCase("String", ""));
  }

  /**
   * Test {@link StringUtil#startsWithIgnoreCase(String, String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#startsWithIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test startsWithIgnoreCase(String, String); when 'String'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.startsWithIgnoreCase(String, String)"})
  void testStartsWithIgnoreCase_whenString_thenReturnFalse()
      throws IllegalArgumentException, NullPointerException {
    // Arrange, Act and Assert
    assertFalse(StringUtil.startsWithIgnoreCase("String", "Prefix"));
  }
}
