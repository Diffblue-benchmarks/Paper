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

class PlayerClientLoadedWorldEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerClientLoadedWorldEvent#PlayerClientLoadedWorldEvent(Player, boolean)}
   *   <li>{@link PlayerClientLoadedWorldEvent#getHandlerList()}
   *   <li>{@link PlayerClientLoadedWorldEvent#getHandlers()}
   *   <li>{@link PlayerClientLoadedWorldEvent#isTimeout()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerClientLoadedWorldEvent.<init>(Player, boolean)",
    "HandlerList PlayerClientLoadedWorldEvent.getHandlerList()",
    "HandlerList PlayerClientLoadedWorldEvent.getHandlers()",
    "boolean PlayerClientLoadedWorldEvent.isTimeout()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerClientLoadedWorldEvent actualPlayerClientLoadedWorldEvent =
        new PlayerClientLoadedWorldEvent(player, true);
    HandlerList actualHandlerList = actualPlayerClientLoadedWorldEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerClientLoadedWorldEvent.getHandlers();
    boolean actualIsTimeoutResult = actualPlayerClientLoadedWorldEvent.isTimeout();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerClientLoadedWorldEvent.isAsynchronous());
    assertTrue(actualIsTimeoutResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerClientLoadedWorldEvent.getPlayer());
  }
}
