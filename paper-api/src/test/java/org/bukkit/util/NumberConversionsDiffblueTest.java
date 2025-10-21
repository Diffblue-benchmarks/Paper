package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NumberConversionsDiffblueTest {
  /**
   * Test {@link NumberConversions#floor(double)}.
   *
   * <ul>
   *   <li>When {@link Double#MAX_VALUE}.
   *   <li>Then return {@link ChatPaginator#UNBOUNDED_PAGE_HEIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#floor(double)}
   */
  @Test
  @DisplayName("Test floor(double); when MAX_VALUE; then return UNBOUNDED_PAGE_HEIGHT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.floor(double)"})
  void testFloor_whenMax_value_thenReturnUnbounded_page_height() {
    // Arrange, Act and Assert
    assertEquals(ChatPaginator.UNBOUNDED_PAGE_HEIGHT, NumberConversions.floor(Double.MAX_VALUE));
  }

  /**
   * Test {@link NumberConversions#floor(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link ChatPaginator#CLOSED_CHAT_PAGE_HEIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#floor(double)}
   */
  @Test
  @DisplayName("Test floor(double); when ten; then return CLOSED_CHAT_PAGE_HEIGHT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.floor(double)"})
  void testFloor_whenTen_thenReturnClosed_chat_page_height() {
    // Arrange, Act and Assert
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, NumberConversions.floor(10.0d));
  }

  /**
   * Test {@link NumberConversions#ceil(double)}.
   *
   * <ul>
   *   <li>When {@link Double#MAX_VALUE}.
   *   <li>Then return {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#ceil(double)}
   */
  @Test
  @DisplayName("Test ceil(double); when MAX_VALUE; then return MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.ceil(double)"})
  void testCeil_whenMax_value_thenReturnMin_value() {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, NumberConversions.ceil(Double.MAX_VALUE));
  }

  /**
   * Test {@link NumberConversions#ceil(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link ChatPaginator#CLOSED_CHAT_PAGE_HEIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#ceil(double)}
   */
  @Test
  @DisplayName("Test ceil(double); when ten; then return CLOSED_CHAT_PAGE_HEIGHT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.ceil(double)"})
  void testCeil_whenTen_thenReturnClosed_chat_page_height() {
    // Arrange, Act and Assert
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, NumberConversions.ceil(10.0d));
  }

  /**
   * Test {@link NumberConversions#round(double)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#round(double)}
   */
  @Test
  @DisplayName("Test round(double); when '0.5'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.round(double)"})
  void testRound_when05_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, NumberConversions.round(0.5d));
  }

  /**
   * Test {@link NumberConversions#round(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link ChatPaginator#CLOSED_CHAT_PAGE_HEIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#round(double)}
   */
  @Test
  @DisplayName("Test round(double); when ten; then return CLOSED_CHAT_PAGE_HEIGHT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.round(double)"})
  void testRound_whenTen_thenReturnClosed_chat_page_height() {
    // Arrange, Act and Assert
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, NumberConversions.round(10.0d));
  }

  /**
   * Test {@link NumberConversions#square(double)}.
   *
   * <p>Method under test: {@link NumberConversions#square(double)}
   */
  @Test
  @DisplayName("Test square(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NumberConversions.square(double)"})
  void testSquare() {
    // Arrange, Act and Assert
    assertEquals(100.0d, NumberConversions.square(10.0d));
  }

  /**
   * Test {@link NumberConversions#toInt(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toInt(Object)}
   */
  @Test
  @DisplayName("Test toInt(Object); when '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.toInt(Object)"})
  void testToInt_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, NumberConversions.toInt("42"));
  }

  /**
   * Test {@link NumberConversions#toInt(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toInt(Object)}
   */
  @Test
  @DisplayName("Test toInt(Object); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.toInt(Object)"})
  void testToInt_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, NumberConversions.toInt(null));
  }

  /**
   * Test {@link NumberConversions#toInt(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toInt(Object)}
   */
  @Test
  @DisplayName("Test toInt(Object); when 'Object'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.toInt(Object)"})
  void testToInt_whenObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, NumberConversions.toInt("Object"));
  }

  /**
   * Test {@link NumberConversions#toInt(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toInt(Object)}
   */
  @Test
  @DisplayName("Test toInt(Object); when valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int NumberConversions.toInt(Object)"})
  void testToInt_whenValueOfOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, NumberConversions.toInt(Integer.valueOf(1)));
  }

  /**
   * Test {@link NumberConversions#toFloat(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toFloat(Object)}
   */
  @Test
  @DisplayName("Test toFloat(Object); when '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NumberConversions.toFloat(Object)"})
  void testToFloat_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, NumberConversions.toFloat("42"));
  }

  /**
   * Test {@link NumberConversions#toFloat(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toFloat(Object)}
   */
  @Test
  @DisplayName("Test toFloat(Object); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NumberConversions.toFloat(Object)"})
  void testToFloat_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, NumberConversions.toFloat(null));
  }

  /**
   * Test {@link NumberConversions#toFloat(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toFloat(Object)}
   */
  @Test
  @DisplayName("Test toFloat(Object); when 'Object'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NumberConversions.toFloat(Object)"})
  void testToFloat_whenObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, NumberConversions.toFloat("Object"));
  }

  /**
   * Test {@link NumberConversions#toFloat(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toFloat(Object)}
   */
  @Test
  @DisplayName("Test toFloat(Object); when valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float NumberConversions.toFloat(Object)"})
  void testToFloat_whenValueOfOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, NumberConversions.toFloat(Integer.valueOf(1)));
  }

  /**
   * Test {@link NumberConversions#toDouble(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toDouble(Object)}
   */
  @Test
  @DisplayName("Test toDouble(Object); when '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NumberConversions.toDouble(Object)"})
  void testToDouble_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, NumberConversions.toDouble("42"));
  }

  /**
   * Test {@link NumberConversions#toDouble(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toDouble(Object)}
   */
  @Test
  @DisplayName("Test toDouble(Object); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NumberConversions.toDouble(Object)"})
  void testToDouble_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, NumberConversions.toDouble(null));
  }

  /**
   * Test {@link NumberConversions#toDouble(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toDouble(Object)}
   */
  @Test
  @DisplayName("Test toDouble(Object); when 'Object'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NumberConversions.toDouble(Object)"})
  void testToDouble_whenObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, NumberConversions.toDouble("Object"));
  }

  /**
   * Test {@link NumberConversions#toDouble(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toDouble(Object)}
   */
  @Test
  @DisplayName("Test toDouble(Object); when valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double NumberConversions.toDouble(Object)"})
  void testToDouble_whenValueOfOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0d, NumberConversions.toDouble(Integer.valueOf(1)));
  }

  /**
   * Test {@link NumberConversions#toLong(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toLong(Object)}
   */
  @Test
  @DisplayName("Test toLong(Object); when '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NumberConversions.toLong(Object)"})
  void testToLong_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, NumberConversions.toLong("42"));
  }

  /**
   * Test {@link NumberConversions#toLong(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toLong(Object)}
   */
  @Test
  @DisplayName("Test toLong(Object); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NumberConversions.toLong(Object)"})
  void testToLong_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, NumberConversions.toLong(null));
  }

  /**
   * Test {@link NumberConversions#toLong(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toLong(Object)}
   */
  @Test
  @DisplayName("Test toLong(Object); when 'Object'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NumberConversions.toLong(Object)"})
  void testToLong_whenObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, NumberConversions.toLong("Object"));
  }

  /**
   * Test {@link NumberConversions#toLong(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toLong(Object)}
   */
  @Test
  @DisplayName("Test toLong(Object); when valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NumberConversions.toLong(Object)"})
  void testToLong_whenValueOfOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, NumberConversions.toLong(Integer.valueOf(1)));
  }

  /**
   * Test {@link NumberConversions#toShort(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toShort(Object)}
   */
  @Test
  @DisplayName("Test toShort(Object); when '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NumberConversions.toShort(Object)"})
  void testToShort_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals((short) 42, NumberConversions.toShort("42"));
  }

  /**
   * Test {@link NumberConversions#toShort(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toShort(Object)}
   */
  @Test
  @DisplayName("Test toShort(Object); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NumberConversions.toShort(Object)"})
  void testToShort_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((short) 0, NumberConversions.toShort(null));
  }

  /**
   * Test {@link NumberConversions#toShort(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toShort(Object)}
   */
  @Test
  @DisplayName("Test toShort(Object); when 'Object'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NumberConversions.toShort(Object)"})
  void testToShort_whenObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((short) 0, NumberConversions.toShort("Object"));
  }

  /**
   * Test {@link NumberConversions#toShort(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toShort(Object)}
   */
  @Test
  @DisplayName("Test toShort(Object); when valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short NumberConversions.toShort(Object)"})
  void testToShort_whenValueOfOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals((short) 1, NumberConversions.toShort(Integer.valueOf(1)));
  }

  /**
   * Test {@link NumberConversions#toByte(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toByte(Object)}
   */
  @Test
  @DisplayName("Test toByte(Object); when '42'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NumberConversions.toByte(Object)"})
  void testToByte_when42_thenReturnAsterisk() {
    // Arrange, Act and Assert
    assertEquals('*', NumberConversions.toByte("42"));
  }

  /**
   * Test {@link NumberConversions#toByte(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toByte(Object)}
   */
  @Test
  @DisplayName("Test toByte(Object); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NumberConversions.toByte(Object)"})
  void testToByte_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, NumberConversions.toByte(null));
  }

  /**
   * Test {@link NumberConversions#toByte(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toByte(Object)}
   */
  @Test
  @DisplayName("Test toByte(Object); when 'Object'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NumberConversions.toByte(Object)"})
  void testToByte_whenObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, NumberConversions.toByte("Object"));
  }

  /**
   * Test {@link NumberConversions#toByte(Object)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#toByte(Object)}
   */
  @Test
  @DisplayName("Test toByte(Object); when valueOf one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte NumberConversions.toByte(Object)"})
  void testToByte_whenValueOfOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals((byte) 1, NumberConversions.toByte(Integer.valueOf(1)));
  }

  /**
   * Test {@link NumberConversions#isFinite(double)} with {@code d}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#isFinite(double)}
   */
  @Test
  @DisplayName("Test isFinite(double) with 'd'; when NaN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NumberConversions.isFinite(double)"})
  void testIsFiniteWithD_whenNaN_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(NumberConversions.isFinite(Double.NaN));
  }

  /**
   * Test {@link NumberConversions#isFinite(double)} with {@code d}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#isFinite(double)}
   */
  @Test
  @DisplayName("Test isFinite(double) with 'd'; when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NumberConversions.isFinite(double)"})
  void testIsFiniteWithD_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NumberConversions.isFinite(10.0d));
  }

  /**
   * Test {@link NumberConversions#isFinite(float)} with {@code f}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#isFinite(float)}
   */
  @Test
  @DisplayName("Test isFinite(float) with 'f'; when NaN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NumberConversions.isFinite(float)"})
  void testIsFiniteWithF_whenNaN_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(NumberConversions.isFinite(Float.NaN));
  }

  /**
   * Test {@link NumberConversions#isFinite(float)} with {@code f}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#isFinite(float)}
   */
  @Test
  @DisplayName("Test isFinite(float) with 'f'; when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NumberConversions.isFinite(float)"})
  void testIsFiniteWithF_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NumberConversions.isFinite(10.0f));
  }

  /**
   * Test {@link NumberConversions#checkFinite(double, String)} with {@code double}, {@code String}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#checkFinite(double, String)}
   */
  @Test
  @DisplayName(
      "Test checkFinite(double, String) with 'double', 'String'; when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NumberConversions.checkFinite(double, String)"})
  void testCheckFiniteWithDoubleString_whenNaN_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> NumberConversions.checkFinite(Double.NaN, "Not all who wander are lost"));
  }

  /**
   * Test {@link NumberConversions#checkFinite(float, String)} with {@code float}, {@code String}.
   *
   * <ul>
   *   <li>When {@link Float#NaN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NumberConversions#checkFinite(float, String)}
   */
  @Test
  @DisplayName(
      "Test checkFinite(float, String) with 'float', 'String'; when NaN; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NumberConversions.checkFinite(float, String)"})
  void testCheckFiniteWithFloatString_whenNaN_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> NumberConversions.checkFinite(Float.NaN, "Not all who wander are lost"));
  }
}
