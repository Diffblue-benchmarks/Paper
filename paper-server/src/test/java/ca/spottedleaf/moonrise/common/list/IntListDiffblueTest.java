package ca.spottedleaf.moonrise.common.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntListDiffblueTest {
  /**
   * Test new {@link IntList} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link IntList}
   */
  @Test
  @DisplayName("Test new IntList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntList.<init>()"})
  void testNewIntList() {
    // Arrange, Act and Assert
    assertEquals(0, new IntList().size());
  }

  /**
   * Test {@link IntList#size()}.
   *
   * <p>Method under test: {@link IntList#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntList.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new IntList().size());
  }

  /**
   * Test {@link IntList#getRaw(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add forty-two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntList#getRaw(int)}
   */
  @Test
  @DisplayName(
      "Test getRaw(int); given IntList (default constructor) add forty-two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntList.getRaw(int)"})
  void testGetRaw_givenIntListAddFortyTwo_thenReturnZero() {
    // Arrange
    IntList intList = new IntList();
    intList.add(42);

    // Act and Assert
    assertEquals(0, intList.getRaw(1));
  }

  /**
   * Test {@link IntList#add(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add forty-two.
   *   <li>When forty-two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#add(int)}
   */
  @Test
  @DisplayName(
      "Test add(int); given IntList (default constructor) add forty-two; when forty-two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.add(int)"})
  void testAdd_givenIntListAddFortyTwo_whenFortyTwo_thenReturnFalse() {
    // Arrange
    IntList intList = new IntList();
    intList.add(42);

    // Act
    boolean actualAddResult = intList.add(42);

    // Assert
    assertEquals(1, intList.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link IntList#add(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add zero.
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#add(int)}
   */
  @Test
  @DisplayName(
      "Test add(int); given IntList (default constructor) add zero; when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.add(int)"})
  void testAdd_givenIntListAddZero_whenZero_thenReturnFalse() {
    // Arrange
    IntList intList = new IntList();
    intList.add(0);

    // Act
    boolean actualAddResult = intList.add(0);

    // Assert
    assertEquals(1, intList.size());
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link IntList#add(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) MinCapacity is three.
   *   <li>When forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#add(int)}
   */
  @Test
  @DisplayName(
      "Test add(int); given IntList (default constructor) MinCapacity is three; when forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.add(int)"})
  void testAdd_givenIntListMinCapacityIsThree_whenFortyTwo_thenReturnTrue() {
    // Arrange
    IntList intList = new IntList();
    intList.setMinCapacity(3);

    // Act
    boolean actualAddResult = intList.add(42);

    // Assert
    assertEquals(1, intList.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link IntList#add(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor).
   *   <li>When forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#add(int)}
   */
  @Test
  @DisplayName(
      "Test add(int); given IntList (default constructor); when forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.add(int)"})
  void testAdd_givenIntList_whenFortyTwo_thenReturnTrue() {
    // Arrange
    IntList intList = new IntList();

    // Act
    boolean actualAddResult = intList.add(42);

    // Assert
    assertEquals(1, intList.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link IntList#add(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor).
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#add(int)}
   */
  @Test
  @DisplayName("Test add(int); given IntList (default constructor); when zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.add(int)"})
  void testAdd_givenIntList_whenZero_thenReturnTrue() {
    // Arrange
    IntList intList = new IntList();

    // Act
    boolean actualAddResult = intList.add(0);

    // Assert
    assertEquals(1, intList.size());
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link IntList#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add forty-two.
   *   <li>When forty-two.
   *   <li>Then {@link IntList} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link IntList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given IntList (default constructor) add forty-two; when forty-two; then IntList (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.remove(int)"})
  void testRemove_givenIntListAddFortyTwo_whenFortyTwo_thenIntListSizeIsZero() {
    // Arrange
    IntList intList = new IntList();
    intList.add(42);

    // Act
    boolean actualRemoveResult = intList.remove(42);

    // Assert
    assertEquals(0, intList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link IntList#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add two.
   *   <li>When forty-two.
   *   <li>Then {@link IntList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link IntList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given IntList (default constructor) add two; when forty-two; then IntList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.remove(int)"})
  void testRemove_givenIntListAddTwo_whenFortyTwo_thenIntListSizeIsOne() {
    // Arrange
    IntList intList = new IntList();
    intList.add(42);
    intList.add(2);

    // Act
    boolean actualRemoveResult = intList.remove(42);

    // Assert
    assertEquals(1, intList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link IntList#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add zero.
   *   <li>When forty-two.
   *   <li>Then {@link IntList} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link IntList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given IntList (default constructor) add zero; when forty-two; then IntList (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.remove(int)"})
  void testRemove_givenIntListAddZero_whenFortyTwo_thenIntListSizeIsOne() {
    // Arrange
    IntList intList = new IntList();
    intList.add(42);
    intList.add(0);

    // Act
    boolean actualRemoveResult = intList.remove(42);

    // Assert
    assertEquals(1, intList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link IntList#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add zero.
   *   <li>When zero.
   *   <li>Then {@link IntList} (default constructor) size is zero.
   * </ul>
   *
   * <p>Method under test: {@link IntList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given IntList (default constructor) add zero; when zero; then IntList (default constructor) size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.remove(int)"})
  void testRemove_givenIntListAddZero_whenZero_thenIntListSizeIsZero() {
    // Arrange
    IntList intList = new IntList();
    intList.add(0);

    // Act
    boolean actualRemoveResult = intList.remove(0);

    // Assert
    assertEquals(0, intList.size());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link IntList#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor).
   *   <li>When forty-two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given IntList (default constructor); when forty-two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.remove(int)"})
  void testRemove_givenIntList_whenFortyTwo_thenReturnFalse() {
    // Arrange
    IntList intList = new IntList();

    // Act
    boolean actualRemoveResult = intList.remove(42);

    // Assert
    assertEquals(0, intList.size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link IntList#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor).
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given IntList (default constructor); when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntList.remove(int)"})
  void testRemove_givenIntList_whenZero_thenReturnFalse() {
    // Arrange
    IntList intList = new IntList();

    // Act
    boolean actualRemoveResult = intList.remove(0);

    // Assert
    assertEquals(0, intList.size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link IntList#clear()}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntList#clear()}
   */
  @Test
  @DisplayName("Test clear(); given IntList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntList.clear()"})
  void testClear_givenIntList() {
    // Arrange
    IntList intList = new IntList();

    // Act
    intList.clear();

    // Assert that nothing has changed
    assertEquals(0, intList.size());
  }

  /**
   * Test {@link IntList#clear()}.
   *
   * <ul>
   *   <li>Given {@link IntList} (default constructor) add forty-two.
   * </ul>
   *
   * <p>Method under test: {@link IntList#clear()}
   */
  @Test
  @DisplayName("Test clear(); given IntList (default constructor) add forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IntList.clear()"})
  void testClear_givenIntListAddFortyTwo() {
    // Arrange
    IntList intList = new IntList();
    intList.add(42);

    // Act
    intList.clear();

    // Assert
    assertEquals(0, intList.size());
  }
}
