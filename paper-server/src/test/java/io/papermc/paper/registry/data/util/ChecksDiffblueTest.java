package io.papermc.paper.registry.data.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ChecksDiffblueTest {
  /**
   * Test {@link Checks#asConfigured(Object, String)} with {@code Object}, {@code String}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asConfigured(Object, String)}
   */
  @Test
  @DisplayName(
      "Test asConfigured(Object, String) with 'Object', 'String'; when WILDCARD_OBJECT; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.asConfigured(Object, String)"})
  void testAsConfiguredWithObjectString_whenWildcard_object_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> Checks.asConfigured(ConfigurationTransformation.WILDCARD_OBJECT, "Field"));
  }

  /**
   * Test {@link Checks#asConfigured(OptionalInt, String)} with {@code OptionalInt}, {@code String}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asConfigured(OptionalInt, String)}
   */
  @Test
  @DisplayName(
      "Test asConfigured(OptionalInt, String) with 'OptionalInt', 'String'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asConfigured(OptionalInt, String)"})
  void testAsConfiguredWithOptionalIntString_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, Checks.asConfigured(OptionalInt.of(42), "Field"));
  }

  /**
   * Test {@link Checks#asConfigured(OptionalInt, String)} with {@code OptionalInt}, {@code String}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asConfigured(OptionalInt, String)}
   */
  @Test
  @DisplayName(
      "Test asConfigured(OptionalInt, String) with 'OptionalInt', 'String'; when empty; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asConfigured(OptionalInt, String)"})
  void testAsConfiguredWithOptionalIntString_whenEmpty_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> Checks.asConfigured(OptionalInt.empty(), "Field"));
  }

  /**
   * Test {@link Checks#asArgument(Object, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgument(Object, String)}
   */
  @Test
  @DisplayName("Test asArgument(Object, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.asArgument(Object, String)"})
  void testAsArgument_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.asArgument(null, "Field"));
  }

  /**
   * Test {@link Checks#asArgument(Object, String)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgument(Object, String)}
   */
  @Test
  @DisplayName("Test asArgument(Object, String); when WILDCARD_OBJECT; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Checks.asArgument(Object, String)"})
  void testAsArgument_whenWildcard_object_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> Checks.asArgument(ConfigurationTransformation.WILDCARD_OBJECT, "Field"));
  }

  /**
   * Test {@link Checks#asArgumentRange(int, String, int, int)}.
   *
   * <ul>
   *   <li>When {@code Field}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentRange(int, String, int, int)}
   */
  @Test
  @DisplayName("Test asArgumentRange(int, String, int, int); when 'Field'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asArgumentRange(int, String, int, int)"})
  void testAsArgumentRange_whenField_thenReturnOne() {
    // Arrange and Act
    int actualAsArgumentRangeResult = Checks.asArgumentRange(1, "Field", 1, 3);

    // Assert
    assertEquals(1, actualAsArgumentRangeResult);
  }

  /**
   * Test {@link Checks#asArgumentRange(int, String, int, int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentRange(int, String, int, int)}
   */
  @Test
  @DisplayName(
      "Test asArgumentRange(int, String, int, int); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asArgumentRange(int, String, int, int)"})
  void testAsArgumentRange_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.asArgumentRange(42, "Field", 1, 3));
  }

  /**
   * Test {@link Checks#asArgumentRange(int, String, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentRange(int, String, int, int)}
   */
  @Test
  @DisplayName(
      "Test asArgumentRange(int, String, int, int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asArgumentRange(int, String, int, int)"})
  void testAsArgumentRange_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.asArgumentRange(0, "Field", 1, 3));
  }

  /**
   * Test {@link Checks#asArgumentMin(int, String, int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentMin(int, String, int)}
   */
  @Test
  @DisplayName("Test asArgumentMin(int, String, int); when forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asArgumentMin(int, String, int)"})
  void testAsArgumentMin_whenFortyTwo_thenReturnFortyTwo() {
    // Arrange and Act
    int actualAsArgumentMinResult = Checks.asArgumentMin(42, "Field", 1);

    // Assert
    assertEquals(42, actualAsArgumentMinResult);
  }

  /**
   * Test {@link Checks#asArgumentMin(int, String, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentMin(int, String, int)}
   */
  @Test
  @DisplayName(
      "Test asArgumentMin(int, String, int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Checks.asArgumentMin(int, String, int)"})
  void testAsArgumentMin_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.asArgumentMin(0, "Field", 1));
  }

  /**
   * Test {@link Checks#asArgumentMinExclusive(float, String, float)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentMinExclusive(float, String, float)}
   */
  @Test
  @DisplayName("Test asArgumentMinExclusive(float, String, float); when '0.5'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Checks.asArgumentMinExclusive(float, String, float)"})
  void testAsArgumentMinExclusive_when05_thenReturnTen() {
    // Arrange and Act
    float actualAsArgumentMinExclusiveResult = Checks.asArgumentMinExclusive(10.0f, "Field", 0.5f);

    // Assert
    assertEquals(10.0f, actualAsArgumentMinExclusiveResult);
  }

  /**
   * Test {@link Checks#asArgumentMinExclusive(float, String, float)}.
   *
   * <ul>
   *   <li>When {@code Field}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Checks#asArgumentMinExclusive(float, String, float)}
   */
  @Test
  @DisplayName(
      "Test asArgumentMinExclusive(float, String, float); when 'Field'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Checks.asArgumentMinExclusive(float, String, float)"})
  void testAsArgumentMinExclusive_whenField_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Checks.asArgumentMinExclusive(10.0f, "Field", 10.0f));
  }
}
