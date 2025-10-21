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

class PlayerPickupItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPickupItemEvent#PlayerPickupItemEvent(Player, Item, int)}
   *   <li>{@link PlayerPickupItemEvent#setFlyAtPlayer(boolean)}
   *   <li>{@link PlayerPickupItemEvent#getHandlerList()}
   *   <li>{@link PlayerPickupItemEvent#getFlyAtPlayer()}
   *   <li>{@link PlayerPickupItemEvent#getHandlers()}
   *   <li>{@link PlayerPickupItemEvent#getItem()}
   *   <li>{@link PlayerPickupItemEvent#getRemaining()}
   *   <li>{@link PlayerPickupItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPickupItemEvent.<init>(Player, Item, int)",
    "boolean PlayerPickupItemEvent.getFlyAtPlayer()",
    "HandlerList PlayerPickupItemEvent.getHandlerList()",
    "HandlerList PlayerPickupItemEvent.getHandlers()",
    "Item PlayerPickupItemEvent.getItem()",
    "int PlayerPickupItemEvent.getRemaining()",
    "boolean PlayerPickupItemEvent.isCancelled()",
    "void PlayerPickupItemEvent.setFlyAtPlayer(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Item item = mock(Item.class);

    // Act
    PlayerPickupItemEvent actualPlayerPickupItemEvent = new PlayerPickupItemEvent(player, item, 1);
    actualPlayerPickupItemEvent.setFlyAtPlayer(true);
    HandlerList actualHandlerList = actualPlayerPickupItemEvent.getHandlerList();
    boolean actualFlyAtPlayer = actualPlayerPickupItemEvent.getFlyAtPlayer();
    HandlerList actualHandlers = actualPlayerPickupItemEvent.getHandlers();
    Item actualItem = actualPlayerPickupItemEvent.getItem();
    int actualRemaining = actualPlayerPickupItemEvent.getRemaining();
    boolean actualIsCancelledResult = actualPlayerPickupItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualRemaining);
    assertFalse(actualPlayerPickupItemEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualFlyAtPlayer);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(item, actualItem);
    assertSame(player, actualPlayerPickupItemEvent.getPlayer());
  }

  /**
   * Test {@link PlayerPickupItemEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerPickupItemEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPickupItemEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    PlayerPickupItemEvent playerPickupItemEvent =
        new PlayerPickupItemEvent(mock(Player.class), mock(Item.class), 1);

    // Act
    playerPickupItemEvent.setCancelled(true);

    // Assert
    assertFalse(playerPickupItemEvent.getFlyAtPlayer());
    assertTrue(playerPickupItemEvent.isCancelled());
  }

  /**
   * Test {@link PlayerPickupItemEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerPickupItemEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPickupItemEvent.setCancelled(boolean)"})
  void testSetCancelled2() {
    // Arrange
    PlayerPickupItemEvent playerPickupItemEvent =
        new PlayerPickupItemEvent(mock(Player.class), mock(Item.class), 1);

    // Act
    playerPickupItemEvent.setCancelled(false);

    // Assert that nothing has changed
    assertFalse(playerPickupItemEvent.isCancelled());
    assertTrue(playerPickupItemEvent.getFlyAtPlayer());
  }
}
