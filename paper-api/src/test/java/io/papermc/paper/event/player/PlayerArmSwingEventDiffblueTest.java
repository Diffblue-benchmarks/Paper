package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerArmSwingEventDiffblueTest {
  /**
   * Test {@link PlayerArmSwingEvent#PlayerArmSwingEvent(Player, EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code HAND}.
   *   <li>Then return AnimationType is {@code ARM_SWING}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerArmSwingEvent#PlayerArmSwingEvent(Player, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new PlayerArmSwingEvent(Player, EquipmentSlot); when 'HAND'; then return AnimationType is 'ARM_SWING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerArmSwingEvent.<init>(Player, EquipmentSlot)"})
  void testNewPlayerArmSwingEvent_whenHand_thenReturnAnimationTypeIsArmSwing() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerArmSwingEvent actualPlayerArmSwingEvent =
        new PlayerArmSwingEvent(player, EquipmentSlot.HAND);

    // Assert
    assertEquals("PlayerArmSwingEvent", actualPlayerArmSwingEvent.getEventName());
    assertEquals(0, actualPlayerArmSwingEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(PlayerAnimationType.ARM_SWING, actualPlayerArmSwingEvent.getAnimationType());
    assertEquals(EquipmentSlot.HAND, actualPlayerArmSwingEvent.getHand());
    assertFalse(actualPlayerArmSwingEvent.isAsynchronous());
    assertFalse(actualPlayerArmSwingEvent.isCancelled());
    assertSame(player, actualPlayerArmSwingEvent.getPlayer());
  }

  /**
   * Test {@link PlayerArmSwingEvent#PlayerArmSwingEvent(Player, EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code OFF_HAND}.
   *   <li>Then return AnimationType is {@code OFF_ARM_SWING}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerArmSwingEvent#PlayerArmSwingEvent(Player, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new PlayerArmSwingEvent(Player, EquipmentSlot); when 'OFF_HAND'; then return AnimationType is 'OFF_ARM_SWING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerArmSwingEvent.<init>(Player, EquipmentSlot)"})
  void testNewPlayerArmSwingEvent_whenOffHand_thenReturnAnimationTypeIsOffArmSwing() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerArmSwingEvent actualPlayerArmSwingEvent =
        new PlayerArmSwingEvent(player, EquipmentSlot.OFF_HAND);

    // Assert
    assertEquals("PlayerArmSwingEvent", actualPlayerArmSwingEvent.getEventName());
    assertEquals(0, actualPlayerArmSwingEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(PlayerAnimationType.OFF_ARM_SWING, actualPlayerArmSwingEvent.getAnimationType());
    assertEquals(EquipmentSlot.OFF_HAND, actualPlayerArmSwingEvent.getHand());
    assertFalse(actualPlayerArmSwingEvent.isAsynchronous());
    assertFalse(actualPlayerArmSwingEvent.isCancelled());
    assertSame(player, actualPlayerArmSwingEvent.getPlayer());
  }

  /**
   * Test {@link PlayerArmSwingEvent#getHand()}.
   *
   * <p>Method under test: {@link PlayerArmSwingEvent#getHand()}
   */
  @Test
  @DisplayName("Test getHand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlot PlayerArmSwingEvent.getHand()"})
  void testGetHand() {
    // Arrange, Act and Assert
    assertEquals(
        EquipmentSlot.HAND,
        new PlayerArmSwingEvent(mock(Player.class), EquipmentSlot.HAND).getHand());
  }
}
