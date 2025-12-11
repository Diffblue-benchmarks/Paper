package io.papermc.paper.configuration.type.fallback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UtilDiffblueTest {
  /**
   * Test {@link Util#negToDef(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return AsInt is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Util#negToDef(int)}
   */
  @Test
  @DisplayName("Test negToDef(int); when forty-two; then return AsInt is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Util.negToDef(int)"})
  void testNegToDef_whenFortyTwo_thenReturnAsIntIsFortyTwo() {
    // Arrange and Act
    OptionalInt actualNegToDefResult = Util.negToDef(42);

    // Assert
    assertEquals(42, actualNegToDefResult.getAsInt());
    assertFalse(actualNegToDefResult.isEmpty());
    assertTrue(actualNegToDefResult.isPresent());
  }

  /**
   * Test {@link Util#negToDef(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link Util#negToDef(int)}
   */
  @Test
  @DisplayName("Test negToDef(int); when minus one; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionalInt Util.negToDef(int)"})
  void testNegToDef_whenMinusOne_thenReturnNotPresent() {
    // Arrange and Act
    OptionalInt actualNegToDefResult = Util.negToDef(-1);

    // Assert
    assertFalse(actualNegToDefResult.isPresent());
    assertTrue(actualNegToDefResult.isEmpty());
  }
}
