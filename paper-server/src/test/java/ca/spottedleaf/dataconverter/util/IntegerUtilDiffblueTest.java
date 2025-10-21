package ca.spottedleaf.dataconverter.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerUtilDiffblueTest {
  /**
   * Test {@link IntegerUtil#ceilLog2(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#ceilLog2(int)}
   */
  @Test
  @DisplayName("Test ceilLog2(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.ceilLog2(int)"})
  void testCeilLog2WithInt() {
    // Arrange, Act and Assert
    assertEquals(6, IntegerUtil.ceilLog2(42));
  }

  /**
   * Test {@link IntegerUtil#ceilLog2(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#ceilLog2(long)}
   */
  @Test
  @DisplayName("Test ceilLog2(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.ceilLog2(long)"})
  void testCeilLog2WithLong() {
    // Arrange, Act and Assert
    assertEquals(6L, IntegerUtil.ceilLog2(42L));
  }

  /**
   * Test {@link IntegerUtil#floorLog2(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#floorLog2(int)}
   */
  @Test
  @DisplayName("Test floorLog2(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.floorLog2(int)"})
  void testFloorLog2WithInt() {
    // Arrange, Act and Assert
    assertEquals(5, IntegerUtil.floorLog2(42));
  }

  /**
   * Test {@link IntegerUtil#floorLog2(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#floorLog2(long)}
   */
  @Test
  @DisplayName("Test floorLog2(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.floorLog2(long)"})
  void testFloorLog2WithLong() {
    // Arrange, Act and Assert
    assertEquals(5, IntegerUtil.floorLog2(42L));
  }

  /**
   * Test {@link IntegerUtil#roundCeilLog2(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#roundCeilLog2(int)}
   */
  @Test
  @DisplayName("Test roundCeilLog2(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.roundCeilLog2(int)"})
  void testRoundCeilLog2WithInt() {
    // Arrange, Act and Assert
    assertEquals(Double.SIZE, IntegerUtil.roundCeilLog2(42));
  }

  /**
   * Test {@link IntegerUtil#roundCeilLog2(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#roundCeilLog2(long)}
   */
  @Test
  @DisplayName("Test roundCeilLog2(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.roundCeilLog2(long)"})
  void testRoundCeilLog2WithLong() {
    // Arrange, Act and Assert
    assertEquals(64L, IntegerUtil.roundCeilLog2(42L));
  }

  /**
   * Test {@link IntegerUtil#roundFloorLog2(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#roundFloorLog2(int)}
   */
  @Test
  @DisplayName("Test roundFloorLog2(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.roundFloorLog2(int)"})
  void testRoundFloorLog2WithInt() {
    // Arrange, Act and Assert
    assertEquals(Integer.SIZE, IntegerUtil.roundFloorLog2(42));
  }

  /**
   * Test {@link IntegerUtil#roundFloorLog2(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#roundFloorLog2(long)}
   */
  @Test
  @DisplayName("Test roundFloorLog2(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.roundFloorLog2(long)"})
  void testRoundFloorLog2WithLong() {
    // Arrange, Act and Assert
    assertEquals(32L, IntegerUtil.roundFloorLog2(42L));
  }

  /**
   * Test {@link IntegerUtil#isPowerOfTwo(int)} with {@code int}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#isPowerOfTwo(int)}
   */
  @Test
  @DisplayName("Test isPowerOfTwo(int) with 'int'; when minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegerUtil.isPowerOfTwo(int)"})
  void testIsPowerOfTwoWithInt_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IntegerUtil.isPowerOfTwo(-1));
  }

  /**
   * Test {@link IntegerUtil#isPowerOfTwo(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#isPowerOfTwo(int)}
   */
  @Test
  @DisplayName("Test isPowerOfTwo(int) with 'int'; when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegerUtil.isPowerOfTwo(int)"})
  void testIsPowerOfTwoWithInt_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(IntegerUtil.isPowerOfTwo(1));
  }

  /**
   * Test {@link IntegerUtil#isPowerOfTwo(long)} with {@code long}.
   *
   * <ul>
   *   <li>When {@code 4294967295}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#isPowerOfTwo(long)}
   */
  @Test
  @DisplayName("Test isPowerOfTwo(long) with 'long'; when '4294967295'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegerUtil.isPowerOfTwo(long)"})
  void testIsPowerOfTwoWithLong_when4294967295_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IntegerUtil.isPowerOfTwo(4294967295L));
  }

  /**
   * Test {@link IntegerUtil#isPowerOfTwo(long)} with {@code long}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#isPowerOfTwo(long)}
   */
  @Test
  @DisplayName("Test isPowerOfTwo(long) with 'long'; when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntegerUtil.isPowerOfTwo(long)"})
  void testIsPowerOfTwoWithLong_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(IntegerUtil.isPowerOfTwo(1L));
  }

  /**
   * Test {@link IntegerUtil#getTrailingBit(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#getTrailingBit(int)}
   */
  @Test
  @DisplayName("Test getTrailingBit(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.getTrailingBit(int)"})
  void testGetTrailingBitWithInt() {
    // Arrange, Act and Assert
    assertEquals(1, IntegerUtil.getTrailingBit(1));
  }

  /**
   * Test {@link IntegerUtil#getTrailingBit(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#getTrailingBit(long)}
   */
  @Test
  @DisplayName("Test getTrailingBit(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.getTrailingBit(long)"})
  void testGetTrailingBitWithLong() {
    // Arrange, Act and Assert
    assertEquals(1L, IntegerUtil.getTrailingBit(1L));
  }

  /**
   * Test {@link IntegerUtil#trailingZeros(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#trailingZeros(int)}
   */
  @Test
  @DisplayName("Test trailingZeros(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.trailingZeros(int)"})
  void testTrailingZerosWithInt() {
    // Arrange, Act and Assert
    assertEquals(0, IntegerUtil.trailingZeros(1));
  }

  /**
   * Test {@link IntegerUtil#trailingZeros(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#trailingZeros(long)}
   */
  @Test
  @DisplayName("Test trailingZeros(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.trailingZeros(long)"})
  void testTrailingZerosWithLong() {
    // Arrange, Act and Assert
    assertEquals(0, IntegerUtil.trailingZeros(1L));
  }

  /**
   * Test {@link IntegerUtil#getDivisorMultiple(long)}.
   *
   * <p>Method under test: {@link IntegerUtil#getDivisorMultiple(long)}
   */
  @Test
  @DisplayName("Test getDivisorMultiple(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.getDivisorMultiple(long)"})
  void testGetDivisorMultiple() {
    // Arrange, Act and Assert
    assertEquals(0, IntegerUtil.getDivisorMultiple(1L));
  }

  /**
   * Test {@link IntegerUtil#getDivisorShift(long)}.
   *
   * <p>Method under test: {@link IntegerUtil#getDivisorShift(long)}
   */
  @Test
  @DisplayName("Test getDivisorShift(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.getDivisorShift(long)"})
  void testGetDivisorShift() {
    // Arrange, Act and Assert
    assertEquals(1, IntegerUtil.getDivisorShift(1L));
  }

  /**
   * Test {@link IntegerUtil#getDivisorNumbers(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#getDivisorNumbers(int)}
   */
  @Test
  @DisplayName("Test getDivisorNumbers(int); when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.getDivisorNumbers(int)"})
  void testGetDivisorNumbers_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IntegerUtil.getDivisorNumbers(1));
  }

  /**
   * Test {@link IntegerUtil#getDivisorNumbers(int)}.
   *
   * <ul>
   *   <li>When thirty-one.
   *   <li>Then return {@code -8925843902615781340}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#getDivisorNumbers(int)}
   */
  @Test
  @DisplayName("Test getDivisorNumbers(int); when thirty-one; then return '-8925843902615781340'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.getDivisorNumbers(int)"})
  void testGetDivisorNumbers_whenThirtyOne_thenReturn8925843902615781340() {
    // Arrange, Act and Assert
    assertEquals(-8925843902615781340L, IntegerUtil.getDivisorNumbers(31));
  }

  /**
   * Test {@link IntegerUtil#getDivisorNumbers(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code -9223372032559808480}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerUtil#getDivisorNumbers(int)}
   */
  @Test
  @DisplayName("Test getDivisorNumbers(int); when two; then return '-9223372032559808480'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.getDivisorNumbers(int)"})
  void testGetDivisorNumbers_whenTwo_thenReturn9223372032559808480() {
    // Arrange, Act and Assert
    assertEquals(-9223372032559808480L, IntegerUtil.getDivisorNumbers(2));
  }

  /**
   * Test {@link IntegerUtil#branchlessAbs(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#branchlessAbs(int)}
   */
  @Test
  @DisplayName("Test branchlessAbs(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.branchlessAbs(int)"})
  void testBranchlessAbsWithInt() {
    // Arrange, Act and Assert
    assertEquals(42, IntegerUtil.branchlessAbs(42));
  }

  /**
   * Test {@link IntegerUtil#branchlessAbs(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#branchlessAbs(long)}
   */
  @Test
  @DisplayName("Test branchlessAbs(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.branchlessAbs(long)"})
  void testBranchlessAbsWithLong() {
    // Arrange, Act and Assert
    assertEquals(42L, IntegerUtil.branchlessAbs(42L));
  }

  /**
   * Test {@link IntegerUtil#hash0(int)}.
   *
   * <p>Method under test: {@link IntegerUtil#hash0(int)}
   */
  @Test
  @DisplayName("Test hash0(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.hash0(int)"})
  void testHash0() {
    // Arrange, Act and Assert
    assertEquals(1831257996, IntegerUtil.hash0(2));
  }

  /**
   * Test {@link IntegerUtil#hash1(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#hash1(int)}
   */
  @Test
  @DisplayName("Test hash1(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.hash1(int)"})
  void testHash1WithInt() {
    // Arrange, Act and Assert
    assertEquals(1792368688, IntegerUtil.hash1(2));
  }

  /**
   * Test {@link IntegerUtil#hash1(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#hash1(long)}
   */
  @Test
  @DisplayName("Test hash1(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.hash1(long)"})
  void testHash1WithLong() {
    // Arrange, Act and Assert
    assertEquals(-3279431766639686665L, IntegerUtil.hash1(81985529216486895L));
  }

  /**
   * Test {@link IntegerUtil#hash2(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#hash2(int)}
   */
  @Test
  @DisplayName("Test hash2(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.hash2(int)"})
  void testHash2WithInt() {
    // Arrange, Act and Assert
    assertEquals(-787275391, IntegerUtil.hash2(2));
  }

  /**
   * Test {@link IntegerUtil#hash2(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#hash2(long)}
   */
  @Test
  @DisplayName("Test hash2(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.hash2(long)"})
  void testHash2WithLong() {
    // Arrange, Act and Assert
    assertEquals(4539041602027451628L, IntegerUtil.hash2(81985529216486895L));
  }

  /**
   * Test {@link IntegerUtil#hash3(int)} with {@code int}.
   *
   * <p>Method under test: {@link IntegerUtil#hash3(int)}
   */
  @Test
  @DisplayName("Test hash3(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerUtil.hash3(int)"})
  void testHash3WithInt() {
    // Arrange, Act and Assert
    assertEquals(-236984087, IntegerUtil.hash3(2));
  }

  /**
   * Test {@link IntegerUtil#hash3(long)} with {@code long}.
   *
   * <p>Method under test: {@link IntegerUtil#hash3(long)}
   */
  @Test
  @DisplayName("Test hash3(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long IntegerUtil.hash3(long)"})
  void testHash3WithLong() {
    // Arrange, Act and Assert
    assertEquals(7826707912731368578L, IntegerUtil.hash3(81985529216486895L));
  }
}
