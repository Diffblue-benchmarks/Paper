package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerDropItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerDropItemEvent#PlayerDropItemEvent(Player, Item)}
   *   <li>{@link PlayerDropItemEvent#setCancelled(boolean)}
   *   <li>{@link PlayerDropItemEvent#getHandlerList()}
   *   <li>{@link PlayerDropItemEvent#getHandlers()}
   *   <li>{@link PlayerDropItemEvent#getItemDrop()}
   *   <li>{@link PlayerDropItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDropItemEvent.<init>(Player, Item)",
    "HandlerList PlayerDropItemEvent.getHandlerList()",
    "HandlerList PlayerDropItemEvent.getHandlers()",
    "Item PlayerDropItemEvent.getItemDrop()",
    "boolean PlayerDropItemEvent.isCancelled()",
    "void PlayerDropItemEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Item drop = mock(Item.class);

    // Act
    PlayerDropItemEvent actualPlayerDropItemEvent = new PlayerDropItemEvent(player, drop);
    actualPlayerDropItemEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerDropItemEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerDropItemEvent.getHandlers();
    Item actualItemDrop = actualPlayerDropItemEvent.getItemDrop();
    boolean actualIsCancelledResult = actualPlayerDropItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerDropItemEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(drop, actualItemDrop);
    assertSame(player, actualPlayerDropItemEvent.getPlayer());
  }
}
