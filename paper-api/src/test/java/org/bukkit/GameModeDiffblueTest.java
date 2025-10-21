package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GameModeDiffblueTest {
  /**
   * Test {@link GameMode#getByValue(int)}.
   *
   * <p>Method under test: {@link GameMode#getByValue(int)}
   */
  @Test
  @DisplayName("Test getByValue(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GameMode GameMode.getByValue(int)"})
  void testGetByValue() {
    // Arrange, Act and Assert
    assertNull(GameMode.getByValue(42));
  }

  /**
   * Test {@link GameMode#isInvulnerable()}.
   *
   * <ul>
   *   <li>Given {@code CREATIVE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GameMode#isInvulnerable()}
   */
  @Test
  @DisplayName("Test isInvulnerable(); given 'CREATIVE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GameMode.isInvulnerable()"})
  void testIsInvulnerable_givenCreative_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(GameMode.CREATIVE.isInvulnerable());
  }

  /**
   * Test {@link GameMode#isInvulnerable()}.
   *
   * <ul>
   *   <li>Given {@link GameMode#SPECTATOR}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GameMode#isInvulnerable()}
   */
  @Test
  @DisplayName("Test isInvulnerable(); given SPECTATOR; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GameMode.isInvulnerable()"})
  void testIsInvulnerable_givenSpectator_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(GameMode.SPECTATOR.isInvulnerable());
  }

  /**
   * Test {@link GameMode#isInvulnerable()}.
   *
   * <ul>
   *   <li>Given {@code SURVIVAL}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GameMode#isInvulnerable()}
   */
  @Test
  @DisplayName("Test isInvulnerable(); given 'SURVIVAL'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GameMode.isInvulnerable()"})
  void testIsInvulnerable_givenSurvival_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(GameMode.SURVIVAL.isInvulnerable());
  }
}
