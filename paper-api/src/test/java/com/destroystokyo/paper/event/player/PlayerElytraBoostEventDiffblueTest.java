package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerElytraBoostEventDiffblueTest {
  /**
   * Test {@link PlayerElytraBoostEvent#shouldConsume()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerElytraBoostEvent#shouldConsume()}
   */
  @Test
  @DisplayName("Test shouldConsume(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerElytraBoostEvent.shouldConsume()"})
  void testShouldConsume_thenReturnFalse() {
    // Arrange
    PlayerElytraBoostEvent playerElytraBoostEvent =
        new PlayerElytraBoostEvent(
            mock(Player.class), null, mock(Firework.class), EquipmentSlot.HAND);
    playerElytraBoostEvent.setShouldConsume(false);

    // Act and Assert
    assertFalse(playerElytraBoostEvent.shouldConsume());
  }

  /**
   * Test {@link PlayerElytraBoostEvent#shouldConsume()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerElytraBoostEvent#shouldConsume()}
   */
  @Test
  @DisplayName("Test shouldConsume(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerElytraBoostEvent.shouldConsume()"})
  void testShouldConsume_thenReturnTrue() {
    // Arrange
    PlayerElytraBoostEvent playerElytraBoostEvent =
        new PlayerElytraBoostEvent(
            mock(Player.class), null, mock(Firework.class), EquipmentSlot.HAND);

    // Act and Assert
    assertTrue(playerElytraBoostEvent.shouldConsume());
  }
}
