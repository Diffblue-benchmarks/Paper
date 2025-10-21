package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerItemConsumeEventDiffblueTest {
  /**
   * Test {@link PlayerItemConsumeEvent#PlayerItemConsumeEvent(Player, ItemStack)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code PlayerItemConsumeEvent}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerItemConsumeEvent#PlayerItemConsumeEvent(Player, ItemStack)}
   */
  @Test
  @DisplayName(
      "Test new PlayerItemConsumeEvent(Player, ItemStack); then return EventName is 'PlayerItemConsumeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerItemConsumeEvent.<init>(Player, ItemStack)"})
  void testNewPlayerItemConsumeEvent_thenReturnEventNameIsPlayerItemConsumeEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerItemConsumeEvent actualPlayerItemConsumeEvent =
        new PlayerItemConsumeEvent(player, mock(ItemStack.class));

    // Assert
    assertEquals("PlayerItemConsumeEvent", actualPlayerItemConsumeEvent.getEventName());
    assertNull(actualPlayerItemConsumeEvent.getItem());
    assertNull(actualPlayerItemConsumeEvent.getReplacement());
    assertEquals(0, actualPlayerItemConsumeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualPlayerItemConsumeEvent.getHand());
    assertFalse(actualPlayerItemConsumeEvent.isAsynchronous());
    assertFalse(actualPlayerItemConsumeEvent.isCancelled());
    assertSame(player, actualPlayerItemConsumeEvent.getPlayer());
  }
}
