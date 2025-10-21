package org.spigotmc.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerSpawnLocationEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerSpawnLocationEvent#PlayerSpawnLocationEvent(Player, Location)}
   *   <li>{@link PlayerSpawnLocationEvent#getHandlerList()}
   *   <li>{@link PlayerSpawnLocationEvent#getHandlers()}
   *   <li>{@link PlayerSpawnLocationEvent#getSpawnLocation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerSpawnLocationEvent.<init>(Player, Location)",
    "HandlerList PlayerSpawnLocationEvent.getHandlerList()",
    "HandlerList PlayerSpawnLocationEvent.getHandlers()",
    "Location PlayerSpawnLocationEvent.getSpawnLocation()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location spawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerSpawnLocationEvent actualPlayerSpawnLocationEvent =
        new PlayerSpawnLocationEvent(player, spawnLocation);
    HandlerList actualHandlerList = actualPlayerSpawnLocationEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerSpawnLocationEvent.getHandlers();
    Location actualSpawnLocation = actualPlayerSpawnLocationEvent.getSpawnLocation();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerSpawnLocationEvent.isAsynchronous());
    assertSame(spawnLocation, actualSpawnLocation);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerSpawnLocationEvent.getPlayer());
  }

  /**
   * Test {@link PlayerSpawnLocationEvent#setSpawnLocation(Location)}.
   *
   * <ul>
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerSpawnLocationEvent#setSpawnLocation(Location)}
   */
  @Test
  @DisplayName("Test setSpawnLocation(Location); then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerSpawnLocationEvent.setSpawnLocation(Location)"})
  void testSetSpawnLocation_thenCallsClone() {
    // Arrange
    Player player = mock(Player.class);
    Location spawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerSpawnLocationEvent playerSpawnLocationEvent =
        new PlayerSpawnLocationEvent(player, spawnLocation);

    Location location = mock(Location.class);
    Location location2 = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(location.clone()).thenReturn(location2);

    // Act
    playerSpawnLocationEvent.setSpawnLocation(location);

    // Assert
    verify(location).clone();
  }
}
