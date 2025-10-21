package io.papermc.paper.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommandUtilDiffblueTest {
  /**
   * Test {@link CommandUtil#matches(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#matches(String, String)}
   */
  @Test
  @DisplayName("Test matches(String, String); when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandUtil.matches(String, String)"})
  void testMatches_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CommandUtil.matches("", "S1"));
  }

  /**
   * Test {@link CommandUtil#matches(String, String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#matches(String, String)}
   */
  @Test
  @DisplayName("Test matches(String, String); when 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandUtil.matches(String, String)"})
  void testMatches_whenFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CommandUtil.matches("foo", "S1"));
  }
}
