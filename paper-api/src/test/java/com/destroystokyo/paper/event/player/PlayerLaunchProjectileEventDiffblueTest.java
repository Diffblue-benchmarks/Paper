package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerLaunchProjectileEventDiffblueTest {
  /**
   * Test {@link PlayerLaunchProjectileEvent#shouldConsume()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerLaunchProjectileEvent#shouldConsume()}
   */
  @Test
  @DisplayName("Test shouldConsume(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerLaunchProjectileEvent.shouldConsume()"})
  void testShouldConsume_thenReturnFalse() {
    // Arrange
    PlayerLaunchProjectileEvent playerLaunchProjectileEvent =
        new PlayerLaunchProjectileEvent(mock(Player.class), null, mock(Projectile.class));
    playerLaunchProjectileEvent.setShouldConsume(false);

    // Act and Assert
    assertFalse(playerLaunchProjectileEvent.shouldConsume());
  }

  /**
   * Test {@link PlayerLaunchProjectileEvent#shouldConsume()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerLaunchProjectileEvent#shouldConsume()}
   */
  @Test
  @DisplayName("Test shouldConsume(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerLaunchProjectileEvent.shouldConsume()"})
  void testShouldConsume_thenReturnTrue() {
    // Arrange
    PlayerLaunchProjectileEvent playerLaunchProjectileEvent =
        new PlayerLaunchProjectileEvent(mock(Player.class), null, mock(Projectile.class));

    // Act and Assert
    assertTrue(playerLaunchProjectileEvent.shouldConsume());
  }
}
