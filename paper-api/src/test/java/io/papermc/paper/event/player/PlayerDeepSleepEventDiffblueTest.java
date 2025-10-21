package io.papermc.paper.event.player;

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

class PlayerDeepSleepEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerDeepSleepEvent#PlayerDeepSleepEvent(Player)}
   *   <li>{@link PlayerDeepSleepEvent#setCancelled(boolean)}
   *   <li>{@link PlayerDeepSleepEvent#getHandlerList()}
   *   <li>{@link PlayerDeepSleepEvent#getHandlers()}
   *   <li>{@link PlayerDeepSleepEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerDeepSleepEvent.<init>(Player)",
    "HandlerList PlayerDeepSleepEvent.getHandlerList()",
    "HandlerList PlayerDeepSleepEvent.getHandlers()",
    "boolean PlayerDeepSleepEvent.isCancelled()",
    "void PlayerDeepSleepEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerDeepSleepEvent actualPlayerDeepSleepEvent = new PlayerDeepSleepEvent(player);
    actualPlayerDeepSleepEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerDeepSleepEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerDeepSleepEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerDeepSleepEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerDeepSleepEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerDeepSleepEvent.getPlayer());
  }
}
