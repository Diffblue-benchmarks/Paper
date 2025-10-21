package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.IntUnaryOperator;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerItemMendEventDiffblueTest {
  /**
   * Test {@link PlayerItemMendEvent#PlayerItemMendEvent(Player, ItemStack, ExperienceOrb, int)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerItemMendEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerItemMendEvent#PlayerItemMendEvent(Player, ItemStack,
   * ExperienceOrb, int)}
   */
  @Test
  @DisplayName(
      "Test new PlayerItemMendEvent(Player, ItemStack, ExperienceOrb, int); then return EventName is 'PlayerItemMendEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerItemMendEvent.<init>(Player, ItemStack, ExperienceOrb, int)"})
  void testNewPlayerItemMendEvent_thenReturnEventNameIsPlayerItemMendEvent() {
    // Arrange
    Player player = mock(Player.class);
    ItemStack item = mock(ItemStack.class);
    ExperienceOrb experienceOrb = mock(ExperienceOrb.class);

    // Act
    PlayerItemMendEvent actualPlayerItemMendEvent =
        new PlayerItemMendEvent(player, item, experienceOrb, 1);

    // Assert
    assertEquals("PlayerItemMendEvent", actualPlayerItemMendEvent.getEventName());
    assertNull(actualPlayerItemMendEvent.getSlot());
    assertEquals(0, actualPlayerItemMendEvent.getConsumedExperience());
    assertEquals(0, actualPlayerItemMendEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualPlayerItemMendEvent.getRepairAmount());
    assertFalse(actualPlayerItemMendEvent.isAsynchronous());
    assertFalse(actualPlayerItemMendEvent.isCancelled());
    assertSame(experienceOrb, actualPlayerItemMendEvent.getExperienceOrb());
    assertSame(player, actualPlayerItemMendEvent.getPlayer());
    assertSame(item, actualPlayerItemMendEvent.getItem());
  }

  /**
   * Test {@link PlayerItemMendEvent#PlayerItemMendEvent(Player, ItemStack, EquipmentSlot,
   * ExperienceOrb, int)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerItemMendEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerItemMendEvent#PlayerItemMendEvent(Player, ItemStack,
   * EquipmentSlot, ExperienceOrb, int)}
   */
  @Test
  @DisplayName(
      "Test new PlayerItemMendEvent(Player, ItemStack, EquipmentSlot, ExperienceOrb, int); then return EventName is 'PlayerItemMendEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerItemMendEvent.<init>(Player, ItemStack, EquipmentSlot, ExperienceOrb, int)"
  })
  void testNewPlayerItemMendEvent_thenReturnEventNameIsPlayerItemMendEvent2() {
    // Arrange
    Player player = mock(Player.class);
    ItemStack item = mock(ItemStack.class);
    ExperienceOrb experienceOrb = mock(ExperienceOrb.class);

    // Act
    PlayerItemMendEvent actualPlayerItemMendEvent =
        new PlayerItemMendEvent(player, item, EquipmentSlot.HAND, experienceOrb, 1);

    // Assert
    assertEquals("PlayerItemMendEvent", actualPlayerItemMendEvent.getEventName());
    assertEquals(0, actualPlayerItemMendEvent.getConsumedExperience());
    assertEquals(0, actualPlayerItemMendEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualPlayerItemMendEvent.getRepairAmount());
    assertEquals(EquipmentSlot.HAND, actualPlayerItemMendEvent.getSlot());
    assertFalse(actualPlayerItemMendEvent.isAsynchronous());
    assertFalse(actualPlayerItemMendEvent.isCancelled());
    assertSame(experienceOrb, actualPlayerItemMendEvent.getExperienceOrb());
    assertSame(player, actualPlayerItemMendEvent.getPlayer());
    assertSame(item, actualPlayerItemMendEvent.getItem());
  }

  /**
   * Test {@link PlayerItemMendEvent#setDurabilityToXpOperation(IntUnaryOperator)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerItemMendEvent#setDurabilityToXpOperation(IntUnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test setDurabilityToXpOperation(IntUnaryOperator); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerItemMendEvent.setDurabilityToXpOperation(IntUnaryOperator)"})
  void testSetDurabilityToXpOperation_thenThrowUnsupportedOperationException() {
    // Arrange
    PlayerItemMendEvent playerItemMendEvent =
        new PlayerItemMendEvent(
            mock(Player.class), mock(ItemStack.class), mock(ExperienceOrb.class), 1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> playerItemMendEvent.setDurabilityToXpOperation(mock(IntUnaryOperator.class)));
  }
}
