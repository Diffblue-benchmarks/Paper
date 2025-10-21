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

class PlayerToggleSprintEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerToggleSprintEvent#PlayerToggleSprintEvent(Player, boolean)}
   *   <li>{@link PlayerToggleSprintEvent#setCancelled(boolean)}
   *   <li>{@link PlayerToggleSprintEvent#getHandlerList()}
   *   <li>{@link PlayerToggleSprintEvent#getHandlers()}
   *   <li>{@link PlayerToggleSprintEvent#isCancelled()}
   *   <li>{@link PlayerToggleSprintEvent#isSprinting()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerToggleSprintEvent.<init>(Player, boolean)",
    "HandlerList PlayerToggleSprintEvent.getHandlerList()",
    "HandlerList PlayerToggleSprintEvent.getHandlers()",
    "boolean PlayerToggleSprintEvent.isCancelled()",
    "boolean PlayerToggleSprintEvent.isSprinting()",
    "void PlayerToggleSprintEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerToggleSprintEvent actualPlayerToggleSprintEvent =
        new PlayerToggleSprintEvent(player, true);
    actualPlayerToggleSprintEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerToggleSprintEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerToggleSprintEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerToggleSprintEvent.isCancelled();
    boolean actualIsSprintingResult = actualPlayerToggleSprintEvent.isSprinting();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerToggleSprintEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsSprintingResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerToggleSprintEvent.getPlayer());
  }
}
