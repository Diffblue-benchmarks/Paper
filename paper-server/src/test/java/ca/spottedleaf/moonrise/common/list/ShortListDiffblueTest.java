package ca.spottedleaf.moonrise.common.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ShortListDiffblueTest {
  /**
   * Test new {@link ShortList} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ShortList}
   */
  @Test
  @DisplayName("Test new ShortList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShortList.<init>()"})
  void testNewShortList() {
    // Arrange, Act and Assert
    assertEquals(0, new ShortList().size());
  }

  /**
   * Test {@link ShortList#size()}.
   *
   * <p>Method under test: {@link ShortList#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ShortList.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new ShortList().size());
  }

  /**
   * Test {@link ShortList#getRaw(int)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#getRaw(int)}
   */
  @Test
  @DisplayName("Test getRaw(int); given ShortList (default constructor) add one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short ShortList.getRaw(int)"})
  void testGetRaw_givenShortListAddOne_thenReturnZero() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 1);

    // Act and Assert
    assertEquals((short) 0, shortList.getRaw(1));
  }

  /**
   * Test {@link ShortList#add(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add {@link Short#MIN_VALUE}.
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#add(short)}
   */
  @Test
  @DisplayName(
      "Test add(short); given ShortList (default constructor) add MIN_VALUE; when one; then ShortList (default constructor) size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.add(short)"})
  void testAdd_givenShortListAddMin_value_whenOne_thenShortListSizeIsTwo() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add(Short.MIN_VALUE);

    // Act
    boolean actualAddResult = shortList.add((short) 1);

    // Assert
    assertEquals(2, shortList.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ShortList#add(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add one.
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#add(short)}
   */
  @Test
  @DisplayName(
      "Test add(short); given ShortList (default constructor) add one; when one; then ShortList (default constructor) size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.add(short)"})
  void testAdd_givenShortListAddOne_whenOne_thenShortListSizeIsTwo() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 1);
    shortList.add(Short.MIN_VALUE);

    // Act
    boolean actualAddResult = shortList.add((short) 1);

    // Assert
    assertEquals(2, shortList.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link ShortList#add(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add zero.
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#add(short)}
   */
  @Test
  @DisplayName(
      "Test add(short); given ShortList (default constructor) add zero; when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.add(short)"})
  void testAdd_givenShortListAddZero_whenZero_thenReturnFalse() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 0);

    // Act
    boolean actualAddResult = shortList.add((short) 0);

    // Assert
    assertEquals(1, shortList.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link ShortList#add(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor).
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#add(short)}
   */
  @Test
  @DisplayName(
      "Test add(short); given ShortList (default constructor); when one; then ShortList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.add(short)"})
  void testAdd_givenShortList_whenOne_thenShortListSizeIsOne() {
    // Arrange
    ShortList shortList = new ShortList();

    // Act
    boolean actualAddResult = shortList.add((short) 1);

    // Assert
    assertEquals(1, shortList.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ShortList#add(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor).
   *   <li>When zero.
   *   <li>Then {@link ShortList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#add(short)}
   */
  @Test
  @DisplayName(
      "Test add(short); given ShortList (default constructor); when zero; then ShortList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.add(short)"})
  void testAdd_givenShortList_whenZero_thenShortListSizeIsOne() {
    // Arrange
    ShortList shortList = new ShortList();

    // Act
    boolean actualAddResult = shortList.add((short) 0);

    // Assert
    assertEquals(1, shortList.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add minus one.
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor) add minus one; when one; then ShortList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortListAddMinusOne_whenOne_thenShortListSizeIsOne() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) -1);
    shortList.add((short) 1);

    // Act
    boolean actualRemoveResult = shortList.remove((short) 1);

    // Assert
    assertEquals(1, shortList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add minus one.
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor) add minus one; when one; then ShortList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortListAddMinusOne_whenOne_thenShortListSizeIsOne2() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 1);
    shortList.add((short) -1);
    shortList.add((short) 1);

    // Act
    boolean actualRemoveResult = shortList.remove((short) 1);

    // Assert
    assertEquals(1, shortList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add one.
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor) add one; when one; then ShortList (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortListAddOne_whenOne_thenShortListSizeIsZero() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 1);

    // Act
    boolean actualRemoveResult = shortList.remove((short) 1);

    // Assert
    assertEquals(0, shortList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add zero.
   *   <li>When one.
   *   <li>Then {@link ShortList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor) add zero; when one; then ShortList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortListAddZero_whenOne_thenShortListSizeIsOne() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 1);
    shortList.add((short) 0);
    shortList.add((short) 1);

    // Act
    boolean actualRemoveResult = shortList.remove((short) 1);

    // Assert
    assertEquals(1, shortList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add zero.
   *   <li>When zero.
   *   <li>Then {@link ShortList} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor) add zero; when zero; then ShortList (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortListAddZero_whenZero_thenShortListSizeIsZero() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 0);

    // Act
    boolean actualRemoveResult = shortList.remove((short) 0);

    // Assert
    assertEquals(0, shortList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor).
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortList_whenOne_thenReturnFalse() {
    // Arrange
    ShortList shortList = new ShortList();

    // Act
    boolean actualRemoveResult = shortList.remove((short) 1);

    // Assert
    assertEquals(0, shortList.size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#remove(short)}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor).
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#remove(short)}
   */
  @Test
  @DisplayName(
      "Test remove(short); given ShortList (default constructor); when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShortList.remove(short)"})
  void testRemove_givenShortList_whenZero_thenReturnFalse() {
    // Arrange
    ShortList shortList = new ShortList();

    // Act
    boolean actualRemoveResult = shortList.remove((short) 0);

    // Assert
    assertEquals(0, shortList.size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ShortList#clear()}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ShortList#clear()}
   */
  @Test
  @DisplayName("Test clear(); given ShortList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShortList.clear()"})
  void testClear_givenShortList() {
    // Arrange
    ShortList shortList = new ShortList();

    // Act
    shortList.clear();

    // Assert that nothing has changed
    assertEquals(0, shortList.size());
  }

  /**
   * Test {@link ShortList#clear()}.
   *
   * <ul>
   *   <li>Given {@link ShortList} (default constructor) add one.
   * </ul>
   *
   * <p>Method under test: {@link ShortList#clear()}
   */
  @Test
  @DisplayName("Test clear(); given ShortList (default constructor) add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShortList.clear()"})
  void testClear_givenShortListAddOne() {
    // Arrange
    ShortList shortList = new ShortList();
    shortList.add((short) 1);

    // Act
    shortList.clear();

    // Assert
    assertEquals(0, shortList.size());
  }
}
