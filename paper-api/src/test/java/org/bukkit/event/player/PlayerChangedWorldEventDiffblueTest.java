package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerChangedWorldEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChangedWorldEvent#PlayerChangedWorldEvent(Player, World)}
   *   <li>{@link PlayerChangedWorldEvent#getHandlerList()}
   *   <li>{@link PlayerChangedWorldEvent#getFrom()}
   *   <li>{@link PlayerChangedWorldEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerChangedWorldEvent.<init>(Player, World)",
    "World PlayerChangedWorldEvent.getFrom()",
    "HandlerList PlayerChangedWorldEvent.getHandlerList()",
    "HandlerList PlayerChangedWorldEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    World from = mock(World.class);

    // Act
    PlayerChangedWorldEvent actualPlayerChangedWorldEvent =
        new PlayerChangedWorldEvent(player, from);
    HandlerList actualHandlerList = actualPlayerChangedWorldEvent.getHandlerList();
    World actualFrom = actualPlayerChangedWorldEvent.getFrom();
    HandlerList actualHandlers = actualPlayerChangedWorldEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerChangedWorldEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(from, actualFrom);
    assertSame(player, actualPlayerChangedWorldEvent.getPlayer());
  }
}
