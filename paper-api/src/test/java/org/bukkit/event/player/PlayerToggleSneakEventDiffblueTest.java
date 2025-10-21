package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerToggleSneakEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerToggleSneakEvent#PlayerToggleSneakEvent(Player, boolean)}
   *   <li>{@link PlayerToggleSneakEvent#setCancelled(boolean)}
   *   <li>{@link PlayerToggleSneakEvent#getHandlerList()}
   *   <li>{@link PlayerToggleSneakEvent#getHandlers()}
   *   <li>{@link PlayerToggleSneakEvent#isCancelled()}
   *   <li>{@link PlayerToggleSneakEvent#isSneaking()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerToggleSneakEvent.<init>(Player, boolean)",
    "HandlerList PlayerToggleSneakEvent.getHandlerList()",
    "HandlerList PlayerToggleSneakEvent.getHandlers()",
    "boolean PlayerToggleSneakEvent.isCancelled()",
    "boolean PlayerToggleSneakEvent.isSneaking()",
    "void PlayerToggleSneakEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerToggleSneakEvent actualPlayerToggleSneakEvent = new PlayerToggleSneakEvent(player, true);
    actualPlayerToggleSneakEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerToggleSneakEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerToggleSneakEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerToggleSneakEvent.isCancelled();
    boolean actualIsSneakingResult = actualPlayerToggleSneakEvent.isSneaking();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerToggleSneakEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsSneakingResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerToggleSneakEvent.getPlayer());
  }
}
