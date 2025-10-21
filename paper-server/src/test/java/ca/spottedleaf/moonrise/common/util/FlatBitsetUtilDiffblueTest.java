package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlatBitsetUtilDiffblueTest {
  /**
   * Test {@link FlatBitsetUtil#firstSet(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with one and zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#firstSet(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test firstSet(long[], int, int); when array of long with one and zero; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlatBitsetUtil.firstSet(long[], int, int)"})
  void testFirstSet_whenArrayOfLongWithOneAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, FlatBitsetUtil.firstSet(new long[] {1L, 0L, 1L, 0L}, 1, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#firstSet(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with six and zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#firstSet(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test firstSet(long[], int, int); when array of long with six and zero; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlatBitsetUtil.firstSet(long[], int, int)"})
  void testFirstSet_whenArrayOfLongWithSixAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, FlatBitsetUtil.firstSet(new long[] {6L, 0L, 1L, 0L}, 1, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#firstSet(long[], int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#firstSet(long[], int, int)}
   */
  @Test
  @DisplayName("Test firstSet(long[], int, int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlatBitsetUtil.firstSet(long[], int, int)"})
  void testFirstSet_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, FlatBitsetUtil.firstSet(new long[] {1L, 0L, 1L, 0L}, 0, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#firstClear(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with minus one and zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#firstClear(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test firstClear(long[], int, int); when array of long with minus one and zero; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlatBitsetUtil.firstClear(long[], int, int)"})
  void testFirstClear_whenArrayOfLongWithMinusOneAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, FlatBitsetUtil.firstClear(new long[] {-1L, 0L, 1L, 0L}, 1, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#firstClear(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with one and zero.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#firstClear(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test firstClear(long[], int, int); when array of long with one and zero; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlatBitsetUtil.firstClear(long[], int, int)"})
  void testFirstClear_whenArrayOfLongWithOneAndZero_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, FlatBitsetUtil.firstClear(new long[] {1L, 0L, 1L, 0L}, 1, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#firstClear(long[], int, int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#firstClear(long[], int, int)}
   */
  @Test
  @DisplayName("Test firstClear(long[], int, int); when six; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlatBitsetUtil.firstClear(long[], int, int)"})
  void testFirstClear_whenSix_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, FlatBitsetUtil.firstClear(new long[] {1L, 0L, 1L, 0L}, 1, 6));
  }

  /**
   * Test {@link FlatBitsetUtil#clearRange(long[], int, int)}.
   *
   * <ul>
   *   <li>Then array of {@code long} with one and zero is array of {@code long} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#clearRange(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test clearRange(long[], int, int); then array of long with one and zero is array of long with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlatBitsetUtil.clearRange(long[], int, int)"})
  void testClearRange_thenArrayOfLongWithOneAndZeroIsArrayOfLongWithZeroAndZero() {
    // Arrange
    long[] bitset = new long[] {1L, 0L, 1L, 0L};

    // Act
    FlatBitsetUtil.clearRange(bitset, 0, 1);

    // Assert
    assertArrayEquals(new long[] {0L, 0L, 1L, 0L}, bitset);
  }

  /**
   * Test {@link FlatBitsetUtil#clearRange(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with one and zero.
   *   <li>Then array of {@code long} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#clearRange(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test clearRange(long[], int, int); when array of long with one and zero; then array of long with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlatBitsetUtil.clearRange(long[], int, int)"})
  void testClearRange_whenArrayOfLongWithOneAndZero_thenArrayOfLongWithOneAndZero() {
    // Arrange
    long[] bitset = new long[] {1L, 0L, 1L, 0L};

    // Act
    FlatBitsetUtil.clearRange(bitset, 1, 1);

    // Assert that nothing has changed
    assertArrayEquals(new long[] {1L, 0L, 1L, 0L}, bitset);
  }

  /**
   * Test {@link FlatBitsetUtil#isRangeSet(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with minus one and zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#isRangeSet(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test isRangeSet(long[], int, int); when array of long with minus one and zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatBitsetUtil.isRangeSet(long[], int, int)"})
  void testIsRangeSet_whenArrayOfLongWithMinusOneAndZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FlatBitsetUtil.isRangeSet(new long[] {-1L, 0L, 1L, 0L}, 1, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#isRangeSet(long[], int, int)}.
   *
   * <ul>
   *   <li>When array of {@code long} with one and zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#isRangeSet(long[], int, int)}
   */
  @Test
  @DisplayName(
      "Test isRangeSet(long[], int, int); when array of long with one and zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatBitsetUtil.isRangeSet(long[], int, int)"})
  void testIsRangeSet_whenArrayOfLongWithOneAndZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FlatBitsetUtil.isRangeSet(new long[] {1L, 0L, 1L, 0L}, 1, 1));
  }

  /**
   * Test {@link FlatBitsetUtil#isRangeSet(long[], int, int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlatBitsetUtil#isRangeSet(long[], int, int)}
   */
  @Test
  @DisplayName("Test isRangeSet(long[], int, int); when six; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatBitsetUtil.isRangeSet(long[], int, int)"})
  void testIsRangeSet_whenSix_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlatBitsetUtil.isRangeSet(new long[] {1L, 0L, 1L, 0L}, 1, 6));
  }
}
