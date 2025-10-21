package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerSpawnChangeEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerSpawnChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerSpawnChangeEvent#PlayerSpawnChangeEvent(Player, Location, boolean, Cause)}
   *   <li>{@link PlayerSpawnChangeEvent#setCancelled(boolean)}
   *   <li>{@link PlayerSpawnChangeEvent#setForced(boolean)}
   *   <li>{@link PlayerSpawnChangeEvent#getHandlerList()}
   *   <li>{@link PlayerSpawnChangeEvent#getCause()}
   *   <li>{@link PlayerSpawnChangeEvent#getHandlers()}
   *   <li>{@link PlayerSpawnChangeEvent#getNewSpawn()}
   *   <li>{@link PlayerSpawnChangeEvent#isCancelled()}
   *   <li>{@link PlayerSpawnChangeEvent#isForced()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerSpawnChangeEvent.<init>(Player, Location, boolean, Cause)",
    "Cause PlayerSpawnChangeEvent.getCause()",
    "HandlerList PlayerSpawnChangeEvent.getHandlerList()",
    "HandlerList PlayerSpawnChangeEvent.getHandlers()",
    "Location PlayerSpawnChangeEvent.getNewSpawn()",
    "boolean PlayerSpawnChangeEvent.isCancelled()",
    "boolean PlayerSpawnChangeEvent.isForced()",
    "void PlayerSpawnChangeEvent.setCancelled(boolean)",
    "void PlayerSpawnChangeEvent.setForced(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location newSpawn = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerSpawnChangeEvent actualPlayerSpawnChangeEvent =
        new PlayerSpawnChangeEvent(player, newSpawn, true, Cause.COMMAND);
    actualPlayerSpawnChangeEvent.setCancelled(true);
    actualPlayerSpawnChangeEvent.setForced(true);
    HandlerList actualHandlerList = actualPlayerSpawnChangeEvent.getHandlerList();
    Cause actualCause = actualPlayerSpawnChangeEvent.getCause();
    HandlerList actualHandlers = actualPlayerSpawnChangeEvent.getHandlers();
    Location actualNewSpawn = actualPlayerSpawnChangeEvent.getNewSpawn();
    boolean actualIsCancelledResult = actualPlayerSpawnChangeEvent.isCancelled();
    boolean actualIsForcedResult = actualPlayerSpawnChangeEvent.isForced();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.COMMAND, actualCause);
    assertFalse(actualPlayerSpawnChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsForcedResult);
    assertSame(newSpawn, actualNewSpawn);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerSpawnChangeEvent.getPlayer());
  }

  /**
   * Test {@link PlayerSpawnChangeEvent#setNewSpawn(Location)}.
   *
   * <p>Method under test: {@link PlayerSpawnChangeEvent#setNewSpawn(Location)}
   */
  @Test
  @DisplayName("Test setNewSpawn(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerSpawnChangeEvent.setNewSpawn(Location)"})
  void testSetNewSpawn() {
    // Arrange
    Player player = mock(Player.class);
    Location newSpawn = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerSpawnChangeEvent playerSpawnChangeEvent =
        new PlayerSpawnChangeEvent(player, newSpawn, true, Cause.COMMAND);

    // Act
    playerSpawnChangeEvent.setNewSpawn(null);

    // Assert
    assertNull(playerSpawnChangeEvent.getNewSpawn());
  }
}
