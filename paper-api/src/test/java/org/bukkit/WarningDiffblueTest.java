package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Warning.WarningState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WarningDiffblueTest {
  /**
   * Test WarningState {@link WarningState#printFor(Warning)}.
   *
   * <ul>
   *   <li>Given {@link WarningState#DEFAULT}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WarningState#printFor(Warning)}
   */
  @Test
  @DisplayName(
      "Test WarningState printFor(Warning); given DEFAULT; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningState.printFor(Warning)"})
  void testWarningStatePrintFor_givenDefault_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(WarningState.DEFAULT.printFor(null));
  }

  /**
   * Test WarningState {@link WarningState#printFor(Warning)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Warning} {@link Warning#value()} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WarningState#printFor(Warning)}
   */
  @Test
  @DisplayName(
      "Test WarningState printFor(Warning); given 'false'; when Warning value() return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningState.printFor(Warning)"})
  void testWarningStatePrintFor_givenFalse_whenWarningValueReturnFalse_thenReturnFalse() {
    // Arrange
    Warning warning = mock(Warning.class);
    when(warning.value()).thenReturn(false);

    // Act
    boolean actualPrintForResult = WarningState.DEFAULT.printFor(warning);

    // Assert
    verify(warning).value();
    assertFalse(actualPrintForResult);
  }

  /**
   * Test WarningState {@link WarningState#printFor(Warning)}.
   *
   * <ul>
   *   <li>Given {@code OFF}.
   *   <li>When {@link Warning}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WarningState#printFor(Warning)}
   */
  @Test
  @DisplayName(
      "Test WarningState printFor(Warning); given 'OFF'; when Warning; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningState.printFor(Warning)"})
  void testWarningStatePrintFor_givenOff_whenWarning_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(WarningState.OFF.printFor(mock(Warning.class)));
  }

  /**
   * Test WarningState {@link WarningState#printFor(Warning)}.
   *
   * <ul>
   *   <li>Given {@code ON}.
   *   <li>When {@link Warning}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WarningState#printFor(Warning)}
   */
  @Test
  @DisplayName("Test WarningState printFor(Warning); given 'ON'; when Warning; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningState.printFor(Warning)"})
  void testWarningStatePrintFor_givenOn_whenWarning_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(WarningState.ON.printFor(mock(Warning.class)));
  }

  /**
   * Test WarningState {@link WarningState#printFor(Warning)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Warning} {@link Warning#value()} return {@code true}.
   *   <li>Then calls {@link Warning#value()}.
   * </ul>
   *
   * <p>Method under test: {@link WarningState#printFor(Warning)}
   */
  @Test
  @DisplayName(
      "Test WarningState printFor(Warning); given 'true'; when Warning value() return 'true'; then calls value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WarningState.printFor(Warning)"})
  void testWarningStatePrintFor_givenTrue_whenWarningValueReturnTrue_thenCallsValue() {
    // Arrange
    Warning warning = mock(Warning.class);
    when(warning.value()).thenReturn(true);

    // Act
    boolean actualPrintForResult = WarningState.DEFAULT.printFor(warning);

    // Assert
    verify(warning).value();
    assertTrue(actualPrintForResult);
  }
}
