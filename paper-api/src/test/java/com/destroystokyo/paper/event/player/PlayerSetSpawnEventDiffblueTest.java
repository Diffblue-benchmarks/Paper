package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.event.player.PlayerSetSpawnEvent.Cause;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerSetSpawnEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerSetSpawnEvent#PlayerSetSpawnEvent(Player, Cause, Location, boolean, boolean,
   *       Component)}
   *   <li>{@link PlayerSetSpawnEvent#setCancelled(boolean)}
   *   <li>{@link PlayerSetSpawnEvent#setForced(boolean)}
   *   <li>{@link PlayerSetSpawnEvent#setNotification(Component)}
   *   <li>{@link PlayerSetSpawnEvent#setNotifyPlayer(boolean)}
   *   <li>{@link PlayerSetSpawnEvent#getHandlerList()}
   *   <li>{@link PlayerSetSpawnEvent#getCause()}
   *   <li>{@link PlayerSetSpawnEvent#getHandlers()}
   *   <li>{@link PlayerSetSpawnEvent#getLocation()}
   *   <li>{@link PlayerSetSpawnEvent#getNotification()}
   *   <li>{@link PlayerSetSpawnEvent#isCancelled()}
   *   <li>{@link PlayerSetSpawnEvent#isForced()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerSetSpawnEvent.<init>(Player, Cause, Location, boolean, boolean, Component)",
    "Cause PlayerSetSpawnEvent.getCause()",
    "HandlerList PlayerSetSpawnEvent.getHandlerList()",
    "HandlerList PlayerSetSpawnEvent.getHandlers()",
    "Location PlayerSetSpawnEvent.getLocation()",
    "Component PlayerSetSpawnEvent.getNotification()",
    "boolean PlayerSetSpawnEvent.isCancelled()",
    "boolean PlayerSetSpawnEvent.isForced()",
    "void PlayerSetSpawnEvent.setCancelled(boolean)",
    "void PlayerSetSpawnEvent.setForced(boolean)",
    "void PlayerSetSpawnEvent.setNotification(Component)",
    "void PlayerSetSpawnEvent.setNotifyPlayer(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerSetSpawnEvent actualPlayerSetSpawnEvent =
        new PlayerSetSpawnEvent(player, Cause.BED, location, true, true, mock(Component.class));
    actualPlayerSetSpawnEvent.setCancelled(true);
    actualPlayerSetSpawnEvent.setForced(true);
    Component notification = mock(Component.class);
    actualPlayerSetSpawnEvent.setNotification(notification);
    actualPlayerSetSpawnEvent.setNotifyPlayer(true);
    HandlerList actualHandlerList = actualPlayerSetSpawnEvent.getHandlerList();
    Cause actualCause = actualPlayerSetSpawnEvent.getCause();
    HandlerList actualHandlers = actualPlayerSetSpawnEvent.getHandlers();
    Location actualLocation = actualPlayerSetSpawnEvent.getLocation();
    Component actualNotification = actualPlayerSetSpawnEvent.getNotification();
    boolean actualIsCancelledResult = actualPlayerSetSpawnEvent.isCancelled();
    boolean actualIsForcedResult = actualPlayerSetSpawnEvent.isForced();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.BED, actualCause);
    assertFalse(actualPlayerSetSpawnEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsForcedResult);
    assertSame(location, actualLocation);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(notification, actualNotification);
    assertSame(player, actualPlayerSetSpawnEvent.getPlayer());
  }

  /**
   * Test {@link PlayerSetSpawnEvent#setLocation(Location)}.
   *
   * <p>Method under test: {@link PlayerSetSpawnEvent#setLocation(Location)}
   */
  @Test
  @DisplayName("Test setLocation(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerSetSpawnEvent.setLocation(Location)"})
  void testSetLocation() {
    // Arrange
    Player player = mock(Player.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerSetSpawnEvent playerSetSpawnEvent =
        new PlayerSetSpawnEvent(player, Cause.BED, location, true, true, mock(Component.class));

    // Act
    playerSetSpawnEvent.setLocation(null);

    // Assert
    assertNull(playerSetSpawnEvent.getLocation());
  }

  /**
   * Test {@link PlayerSetSpawnEvent#willNotifyPlayer()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerSetSpawnEvent#willNotifyPlayer()}
   */
  @Test
  @DisplayName("Test willNotifyPlayer(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerSetSpawnEvent.willNotifyPlayer()"})
  void testWillNotifyPlayer_thenReturnFalse() {
    // Arrange
    Player player = mock(Player.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerSetSpawnEvent playerSetSpawnEvent =
        new PlayerSetSpawnEvent(player, Cause.BED, location, true, false, mock(Component.class));

    // Act and Assert
    assertFalse(playerSetSpawnEvent.willNotifyPlayer());
  }

  /**
   * Test {@link PlayerSetSpawnEvent#willNotifyPlayer()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerSetSpawnEvent#willNotifyPlayer()}
   */
  @Test
  @DisplayName("Test willNotifyPlayer(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerSetSpawnEvent.willNotifyPlayer()"})
  void testWillNotifyPlayer_thenReturnTrue() {
    // Arrange
    Player player = mock(Player.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerSetSpawnEvent playerSetSpawnEvent =
        new PlayerSetSpawnEvent(player, Cause.BED, location, true, true, mock(Component.class));

    // Act and Assert
    assertTrue(playerSetSpawnEvent.willNotifyPlayer());
  }
}
