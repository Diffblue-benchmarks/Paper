package io.papermc.paper.configuration.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BooleanOrDefaultDiffblueTest {
  /**
   * Test {@link BooleanOrDefault#or(boolean)}.
   *
   * <ul>
   *   <li>Given {@link BooleanOrDefault#BooleanOrDefault(Boolean)} with value is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanOrDefault#or(boolean)}
   */
  @Test
  @DisplayName(
      "Test or(boolean); given BooleanOrDefault(Boolean) with value is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanOrDefault.or(boolean)"})
  void testOr_givenBooleanOrDefaultWithValueIsFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BooleanOrDefault(false).or(true));
  }

  /**
   * Test {@link BooleanOrDefault#or(boolean)}.
   *
   * <ul>
   *   <li>Given {@link BooleanOrDefault#BooleanOrDefault(Boolean)} with value is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanOrDefault#or(boolean)}
   */
  @Test
  @DisplayName(
      "Test or(boolean); given BooleanOrDefault(Boolean) with value is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanOrDefault.or(boolean)"})
  void testOr_givenBooleanOrDefaultWithValueIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BooleanOrDefault(true).or(true));
  }

  /**
   * Test {@link BooleanOrDefault#or(boolean)}.
   *
   * <ul>
   *   <li>Given {@link BooleanOrDefault#USE_DEFAULT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanOrDefault#or(boolean)}
   */
  @Test
  @DisplayName("Test or(boolean); given USE_DEFAULT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BooleanOrDefault.or(boolean)"})
  void testOr_givenUse_default_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BooleanOrDefault.USE_DEFAULT.or(true));
  }
}
