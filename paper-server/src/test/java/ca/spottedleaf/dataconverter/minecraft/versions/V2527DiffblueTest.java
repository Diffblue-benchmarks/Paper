package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class V2527DiffblueTest {
  /**
   * Test {@link V2527#addPadding(int, int, long[])}.
   *
   * <ul>
   *   <li>When empty array of {@code long}.
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link V2527#addPadding(int, int, long[])}
   */
  @Test
  @DisplayName(
      "Test addPadding(int, int, long[]); when empty array of long; then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] V2527.addPadding(int, int, long[])"})
  void testAddPadding_whenEmptyArrayOfLong_thenReturnEmptyArrayOfLong() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[] {}, V2527.addPadding(2, 2, new long[] {}));
  }

  /**
   * Test {@link V2527#addPadding(int, int, long[])}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return array of {@code long} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link V2527#addPadding(int, int, long[])}
   */
  @Test
  @DisplayName(
      "Test addPadding(int, int, long[]); when four; then return array of long with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] V2527.addPadding(int, int, long[])"})
  void testAddPadding_whenFour_thenReturnArrayOfLongWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {1L, 0L, 256L, 0L},
        V2527.addPadding(Double.SIZE, 4, new long[] {1L, 0L, 1L, 0L}));
  }

  /**
   * Test {@link V2527#addPadding(int, int, long[])}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return array of {@code long} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link V2527#addPadding(int, int, long[])}
   */
  @Test
  @DisplayName(
      "Test addPadding(int, int, long[]); when six; then return array of long with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] V2527.addPadding(int, int, long[])"})
  void testAddPadding_whenSix_thenReturnArrayOfLongWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {1L, 0L, 256L, 0L, 0L, 0L, 0L},
        V2527.addPadding(Double.SIZE, 6, new long[] {1L, 0L, 1L, 0L}));
  }

  /**
   * Test {@link V2527#addPadding(int, int, long[])}.
   *
   * <ul>
   *   <li>When {@link Double#SIZE}.
   *   <li>Then return array of {@code long} with one and zero.
   * </ul>
   *
   * <p>Method under test: {@link V2527#addPadding(int, int, long[])}
   */
  @Test
  @DisplayName(
      "Test addPadding(int, int, long[]); when SIZE; then return array of long with one and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] V2527.addPadding(int, int, long[])"})
  void testAddPadding_whenSize_thenReturnArrayOfLongWithOneAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new long[] {1L, 0L}, V2527.addPadding(Double.SIZE, 2, new long[] {1L, 0L, 1L, 0L}));
  }

  /**
   * Test {@link V2527#addPadding(int, int, long[])}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return array of {@code long} with one.
   * </ul>
   *
   * <p>Method under test: {@link V2527#addPadding(int, int, long[])}
   */
  @Test
  @DisplayName("Test addPadding(int, int, long[]); when two; then return array of long with one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] V2527.addPadding(int, int, long[])"})
  void testAddPadding_whenTwo_thenReturnArrayOfLongWithOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[] {1L}, V2527.addPadding(2, 2, new long[] {1L, 0L, 1L, 0L}));
  }

  /**
   * Test {@link V2527#addPadding(int, int, long[])}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return empty array of {@code long}.
   * </ul>
   *
   * <p>Method under test: {@link V2527#addPadding(int, int, long[])}
   */
  @Test
  @DisplayName("Test addPadding(int, int, long[]); when zero; then return empty array of long")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long[] V2527.addPadding(int, int, long[])"})
  void testAddPadding_whenZero_thenReturnEmptyArrayOfLong() {
    // Arrange, Act and Assert
    assertArrayEquals(new long[] {}, V2527.addPadding(0, 2, new long[] {1L, 0L, 1L, 0L}));
  }
}
