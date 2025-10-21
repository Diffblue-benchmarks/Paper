package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerLevelChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerLevelChangeEvent#PlayerLevelChangeEvent(Player, int, int)}
   *   <li>{@link PlayerLevelChangeEvent#getHandlerList()}
   *   <li>{@link PlayerLevelChangeEvent#getHandlers()}
   *   <li>{@link PlayerLevelChangeEvent#getNewLevel()}
   *   <li>{@link PlayerLevelChangeEvent#getOldLevel()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerLevelChangeEvent.<init>(Player, int, int)",
    "HandlerList PlayerLevelChangeEvent.getHandlerList()",
    "HandlerList PlayerLevelChangeEvent.getHandlers()",
    "int PlayerLevelChangeEvent.getNewLevel()",
    "int PlayerLevelChangeEvent.getOldLevel()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLevelChangeEvent actualPlayerLevelChangeEvent = new PlayerLevelChangeEvent(player, 1, 1);
    HandlerList actualHandlerList = actualPlayerLevelChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerLevelChangeEvent.getHandlers();
    int actualNewLevel = actualPlayerLevelChangeEvent.getNewLevel();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewLevel);
    assertEquals(1, actualPlayerLevelChangeEvent.getOldLevel());
    assertFalse(actualPlayerLevelChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerLevelChangeEvent.getPlayer());
  }
}
