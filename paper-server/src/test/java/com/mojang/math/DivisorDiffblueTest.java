package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DivisorDiffblueTest {
  /**
   * Test {@link Divisor#Divisor(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return next intValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#Divisor(int, int)}
   */
  @Test
  @DisplayName("Test new Divisor(int, int); when one; then return next intValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Divisor.<init>(int, int)"})
  void testNewDivisor_whenOne_thenReturnNextIntValueIsTen() {
    // Arrange and Act
    Divisor actualDivisor = new Divisor(10, 1);

    // Assert
    assertEquals(10, actualDivisor.next().intValue());
    assertFalse(actualDivisor.hasNext());
  }

  /**
   * Test {@link Divisor#Divisor(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#Divisor(int, int)}
   */
  @Test
  @DisplayName("Test new Divisor(int, int); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Divisor.<init>(int, int)"})
  void testNewDivisor_whenZero() {
    // Arrange, Act and Assert
    assertFalse(new Divisor(10, 0).hasNext());
  }

  /**
   * Test {@link Divisor#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link Divisor#Divisor(int, int)} with numerator is ten and denominator is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#hasNext()}
   */
  @Test
  @DisplayName(
      "Test hasNext(); given Divisor(int, int) with numerator is ten and denominator is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Divisor.hasNext()"})
  void testHasNext_givenDivisorWithNumeratorIsTenAndDenominatorIsOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Divisor(10, 1).hasNext());
  }

  /**
   * Test {@link Divisor#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link Divisor#Divisor(int, int)} with numerator is ten and denominator is zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#hasNext()}
   */
  @Test
  @DisplayName(
      "Test hasNext(); given Divisor(int, int) with numerator is ten and denominator is zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Divisor.hasNext()"})
  void testHasNext_givenDivisorWithNumeratorIsTenAndDenominatorIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Divisor(10, 0).hasNext());
  }

  /**
   * Test {@link Divisor#nextInt()}.
   *
   * <ul>
   *   <li>Given {@link Divisor#Divisor(int, int)} with numerator is ten and denominator is one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#nextInt()}
   */
  @Test
  @DisplayName(
      "Test nextInt(); given Divisor(int, int) with numerator is ten and denominator is one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Divisor.nextInt()"})
  void testNextInt_givenDivisorWithNumeratorIsTenAndDenominatorIsOne_thenReturnTen() {
    // Arrange
    Divisor divisor = new Divisor(10, 1);

    // Act and Assert
    assertEquals(10, divisor.nextInt());
    assertFalse(divisor.hasNext());
  }

  /**
   * Test {@link Divisor#nextInt()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#nextInt()}
   */
  @Test
  @DisplayName("Test nextInt(); then throw NoSuchElementException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Divisor.nextInt()"})
  void testNextInt_thenThrowNoSuchElementException() {
    // Arrange, Act and Assert
    assertThrows(NoSuchElementException.class, () -> new Divisor(10, 0).nextInt());
  }

  /**
   * Test {@link Divisor#asIterable(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return iterator next intValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#asIterable(int, int)}
   */
  @Test
  @DisplayName("Test asIterable(int, int); when one; then return iterator next intValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Divisor.asIterable(int, int)"})
  void testAsIterable_whenOne_thenReturnIteratorNextIntValueIsTen() {
    // Arrange and Act
    Iterable<Integer> actualAsIterableResult = Divisor.asIterable(10, 1);
    Iterator<Integer> actualIteratorResult = actualAsIterableResult.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof Divisor);
    assertEquals(-1L, actualAsIterableResult.spliterator().getExactSizeIfKnown());
    assertEquals(10, actualIteratorResult.next().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link Divisor#asIterable(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link Divisor#asIterable(int, int)}
   */
  @Test
  @DisplayName("Test asIterable(int, int); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable Divisor.asIterable(int, int)"})
  void testAsIterable_whenZero() {
    // Arrange and Act
    Iterable<Integer> actualAsIterableResult = Divisor.asIterable(10, 0);
    Iterator<Integer> actualIteratorResult = actualAsIterableResult.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof Divisor);
    assertEquals(-1L, actualAsIterableResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }
}
