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

class PlayerAttemptPickupItemEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Remaining is one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAttemptPickupItemEvent#PlayerAttemptPickupItemEvent(Player, Item, int)}
   *   <li>{@link PlayerAttemptPickupItemEvent#setFlyAtPlayer(boolean)}
   *   <li>{@link PlayerAttemptPickupItemEvent#getHandlerList()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getFlyAtPlayer()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getHandlers()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getItem()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getRemaining()}
   *   <li>{@link PlayerAttemptPickupItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one; then return Remaining is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAttemptPickupItemEvent.<init>(Player, Item)",
    "void PlayerAttemptPickupItemEvent.<init>(Player, Item, int)",
    "boolean PlayerAttemptPickupItemEvent.getFlyAtPlayer()",
    "HandlerList PlayerAttemptPickupItemEvent.getHandlerList()",
    "HandlerList PlayerAttemptPickupItemEvent.getHandlers()",
    "Item PlayerAttemptPickupItemEvent.getItem()",
    "int PlayerAttemptPickupItemEvent.getRemaining()",
    "boolean PlayerAttemptPickupItemEvent.isCancelled()",
    "void PlayerAttemptPickupItemEvent.setFlyAtPlayer(boolean)"
  })
  void testGettersAndSetters_whenOne_thenReturnRemainingIsOne() {
    // Arrange
    Player player = mock(Player.class);
    Item item = mock(Item.class);

    // Act
    PlayerAttemptPickupItemEvent actualPlayerAttemptPickupItemEvent =
        new PlayerAttemptPickupItemEvent(player, item, 1);
    actualPlayerAttemptPickupItemEvent.setFlyAtPlayer(true);
    HandlerList actualHandlerList = actualPlayerAttemptPickupItemEvent.getHandlerList();
    boolean actualFlyAtPlayer = actualPlayerAttemptPickupItemEvent.getFlyAtPlayer();
    HandlerList actualHandlers = actualPlayerAttemptPickupItemEvent.getHandlers();
    Item actualItem = actualPlayerAttemptPickupItemEvent.getItem();
    int actualRemaining = actualPlayerAttemptPickupItemEvent.getRemaining();
    boolean actualIsCancelledResult = actualPlayerAttemptPickupItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualRemaining);
    assertFalse(actualPlayerAttemptPickupItemEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualFlyAtPlayer);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(item, actualItem);
    assertSame(player, actualPlayerAttemptPickupItemEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Player}.
   *   <li>Then return Remaining is zero.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAttemptPickupItemEvent#PlayerAttemptPickupItemEvent(Player, Item)}
   *   <li>{@link PlayerAttemptPickupItemEvent#setFlyAtPlayer(boolean)}
   *   <li>{@link PlayerAttemptPickupItemEvent#getHandlerList()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getFlyAtPlayer()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getHandlers()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getItem()}
   *   <li>{@link PlayerAttemptPickupItemEvent#getRemaining()}
   *   <li>{@link PlayerAttemptPickupItemEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Player; then return Remaining is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAttemptPickupItemEvent.<init>(Player, Item)",
    "void PlayerAttemptPickupItemEvent.<init>(Player, Item, int)",
    "boolean PlayerAttemptPickupItemEvent.getFlyAtPlayer()",
    "HandlerList PlayerAttemptPickupItemEvent.getHandlerList()",
    "HandlerList PlayerAttemptPickupItemEvent.getHandlers()",
    "Item PlayerAttemptPickupItemEvent.getItem()",
    "int PlayerAttemptPickupItemEvent.getRemaining()",
    "boolean PlayerAttemptPickupItemEvent.isCancelled()",
    "void PlayerAttemptPickupItemEvent.setFlyAtPlayer(boolean)"
  })
  void testGettersAndSetters_whenPlayer_thenReturnRemainingIsZero() {
    // Arrange
    Player player = mock(Player.class);
    Item item = mock(Item.class);

    // Act
    PlayerAttemptPickupItemEvent actualPlayerAttemptPickupItemEvent =
        new PlayerAttemptPickupItemEvent(player, item);
    actualPlayerAttemptPickupItemEvent.setFlyAtPlayer(true);
    HandlerList actualHandlerList = actualPlayerAttemptPickupItemEvent.getHandlerList();
    boolean actualFlyAtPlayer = actualPlayerAttemptPickupItemEvent.getFlyAtPlayer();
    HandlerList actualHandlers = actualPlayerAttemptPickupItemEvent.getHandlers();
    Item actualItem = actualPlayerAttemptPickupItemEvent.getItem();
    int actualRemaining = actualPlayerAttemptPickupItemEvent.getRemaining();
    boolean actualIsCancelledResult = actualPlayerAttemptPickupItemEvent.isCancelled();

    // Assert
    assertEquals(0, actualRemaining);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerAttemptPickupItemEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualFlyAtPlayer);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(item, actualItem);
    assertSame(player, actualPlayerAttemptPickupItemEvent.getPlayer());
  }

  /**
   * Test {@link PlayerAttemptPickupItemEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Then not {@link PlayerAttemptPickupItemEvent#PlayerAttemptPickupItemEvent(Player, Item)}
   *       with {@link Player} and {@link Item} Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link PlayerAttemptPickupItemEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); then not PlayerAttemptPickupItemEvent(Player, Item) with Player and Item Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerAttemptPickupItemEvent.setCancelled(boolean)"})
  void testSetCancelled_thenNotPlayerAttemptPickupItemEventWithPlayerAndItemCancelled() {
    // Arrange
    PlayerAttemptPickupItemEvent playerAttemptPickupItemEvent =
        new PlayerAttemptPickupItemEvent(mock(Player.class), mock(Item.class));

    // Act
    playerAttemptPickupItemEvent.setCancelled(false);

    // Assert that nothing has changed
    assertFalse(playerAttemptPickupItemEvent.isCancelled());
    assertTrue(playerAttemptPickupItemEvent.getFlyAtPlayer());
  }

  /**
   * Test {@link PlayerAttemptPickupItemEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Then not {@link PlayerAttemptPickupItemEvent#PlayerAttemptPickupItemEvent(Player, Item)}
   *       with {@link Player} and {@link Item} FlyAtPlayer.
   * </ul>
   *
   * <p>Method under test: {@link PlayerAttemptPickupItemEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); then not PlayerAttemptPickupItemEvent(Player, Item) with Player and Item FlyAtPlayer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerAttemptPickupItemEvent.setCancelled(boolean)"})
  void testSetCancelled_thenNotPlayerAttemptPickupItemEventWithPlayerAndItemFlyAtPlayer() {
    // Arrange
    PlayerAttemptPickupItemEvent playerAttemptPickupItemEvent =
        new PlayerAttemptPickupItemEvent(mock(Player.class), mock(Item.class));

    // Act
    playerAttemptPickupItemEvent.setCancelled(true);

    // Assert
    assertFalse(playerAttemptPickupItemEvent.getFlyAtPlayer());
    assertTrue(playerAttemptPickupItemEvent.isCancelled());
  }
}
