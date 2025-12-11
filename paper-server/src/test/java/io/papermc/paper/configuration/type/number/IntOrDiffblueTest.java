package io.papermc.paper.configuration.type.number;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.type.number.IntOr.Default;
import io.papermc.paper.configuration.type.number.IntOr.Disabled;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntOrDiffblueTest {
  /**
   * Test Disabled {@link Disabled#enabled()}.
   *
   * <ul>
   *   <li>Given {@link Disabled#Disabled(OptionalInt)} with value is empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#enabled()}
   */
  @Test
  @DisplayName(
      "Test Disabled enabled(); given Disabled(OptionalInt) with value is empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.enabled()"})
  void testDisabledEnabled_givenDisabledWithValueIsEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Disabled(OptionalInt.empty()).enabled());
  }

  /**
   * Test Disabled {@link Disabled#enabled()}.
   *
   * <ul>
   *   <li>Given {@link OptionalInt} with forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#enabled()}
   */
  @Test
  @DisplayName("Test Disabled enabled(); given OptionalInt with forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.enabled()"})
  void testDisabledEnabled_givenOptionalIntWithFortyTwo_thenReturnTrue() {
    // Arrange
    OptionalInt value = OptionalInt.of(42);

    // Act and Assert
    assertTrue(new Disabled(value).enabled());
  }

  /**
   * Test Disabled {@link Disabled#test(IntPredicate)}.
   *
   * <ul>
   *   <li>Given {@link Disabled#Disabled(OptionalInt)} with value is empty.
   *   <li>When {@link IntPredicate}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#test(IntPredicate)}
   */
  @Test
  @DisplayName(
      "Test Disabled test(IntPredicate); given Disabled(OptionalInt) with value is empty; when IntPredicate; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.test(IntPredicate)"})
  void testDisabledTest_givenDisabledWithValueIsEmpty_whenIntPredicate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Disabled(OptionalInt.empty()).test(mock(IntPredicate.class)));
  }

  /**
   * Test Disabled {@link Disabled#test(IntPredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link IntPredicate} {@link IntPredicate#test(int)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#test(IntPredicate)}
   */
  @Test
  @DisplayName(
      "Test Disabled test(IntPredicate); given 'false'; when IntPredicate test(int) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.test(IntPredicate)"})
  void testDisabledTest_givenFalse_whenIntPredicateTestReturnFalse_thenReturnFalse() {
    // Arrange
    OptionalInt value = OptionalInt.of(42);
    Disabled disabled = new Disabled(value);

    IntPredicate predicate = mock(IntPredicate.class);
    when(predicate.test(anyInt())).thenReturn(false);

    // Act
    boolean actualTestResult = disabled.test(predicate);

    // Assert
    verify(predicate).test(42);
    assertFalse(actualTestResult);
  }

  /**
   * Test Disabled {@link Disabled#test(IntPredicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link IntPredicate} {@link IntPredicate#test(int)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Disabled#test(IntPredicate)}
   */
  @Test
  @DisplayName(
      "Test Disabled test(IntPredicate); given 'true'; when IntPredicate test(int) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Disabled.test(IntPredicate)"})
  void testDisabledTest_givenTrue_whenIntPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    OptionalInt value = OptionalInt.of(42);
    Disabled disabled = new Disabled(value);

    IntPredicate predicate = mock(IntPredicate.class);
    when(predicate.test(anyInt())).thenReturn(true);

    // Act
    boolean actualTestResult = disabled.test(predicate);

    // Assert
    verify(predicate).test(42);
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link IntOr#or(int)}.
   *
   * <ul>
   *   <li>Given {@link Default#Default(OptionalInt)} with value is empty.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link IntOr#or(int)}
   */
  @Test
  @DisplayName("Test or(int); given Default(OptionalInt) with value is empty; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntOr.or(int)"})
  void testOr_givenDefaultWithValueIsEmpty_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new Default(OptionalInt.empty()).or(1));
  }

  /**
   * Test {@link IntOr#isDefined()}.
   *
   * <ul>
   *   <li>Given {@link Default#Default(OptionalInt)} with value is empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IntOr#isDefined()}
   */
  @Test
  @DisplayName(
      "Test isDefined(); given Default(OptionalInt) with value is empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntOr.isDefined()"})
  void testIsDefined_givenDefaultWithValueIsEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Default(OptionalInt.empty()).isDefined());
  }

  /**
   * Test {@link IntOr#isDefined()}.
   *
   * <ul>
   *   <li>Given {@link OptionalInt} with forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IntOr#isDefined()}
   */
  @Test
  @DisplayName("Test isDefined(); given OptionalInt with forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IntOr.isDefined()"})
  void testIsDefined_givenOptionalIntWithFortyTwo_thenReturnTrue() {
    // Arrange
    OptionalInt value = OptionalInt.of(42);

    // Act and Assert
    assertTrue(new Default(value).isDefined());
  }

  /**
   * Test {@link IntOr#intValue()}.
   *
   * <ul>
   *   <li>Given {@link OptionalInt} with forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link IntOr#intValue()}
   */
  @Test
  @DisplayName("Test intValue(); given OptionalInt with forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntOr.intValue()"})
  void testIntValue_givenOptionalIntWithFortyTwo_thenReturnFortyTwo() {
    // Arrange
    OptionalInt value = OptionalInt.of(42);

    // Act and Assert
    assertEquals(42, new Default(value).intValue());
  }
}
