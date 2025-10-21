package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPortalEventDiffblueTest {
  /**
   * Test {@link PlayerPortalEvent#PlayerPortalEvent(Player, Location, Location)}.
   *
   * <p>Method under test: {@link PlayerPortalEvent#PlayerPortalEvent(Player, Location, Location)}
   */
  @Test
  @DisplayName("Test new PlayerPortalEvent(Player, Location, Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPortalEvent.<init>(Player, Location, Location)"})
  void testNewPlayerPortalEvent() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPortalEvent actualPlayerPortalEvent = new PlayerPortalEvent(player, from, resultTo);

    // Assert
    assertEquals("PlayerPortalEvent", actualPlayerPortalEvent.getEventName());
    assertEquals(128, actualPlayerPortalEvent.getSearchRadius());
    assertEquals(TeleportCause.UNKNOWN, actualPlayerPortalEvent.getCause());
    assertFalse(actualPlayerPortalEvent.isAsynchronous());
    assertFalse(actualPlayerPortalEvent.hasChangedOrientation());
    assertFalse(actualPlayerPortalEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerPortalEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerPortalEvent.isCancelled());
    assertTrue(actualPlayerPortalEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerPortalEvent.hasChangedBlock());
    assertTrue(actualPlayerPortalEvent.hasChangedPosition());
    assertTrue(actualPlayerPortalEvent.getCanCreatePortal());
    assertEquals(Short.SIZE, actualPlayerPortalEvent.getCreationRadius());
    assertSame(from, actualPlayerPortalEvent.getFrom());
    assertSame(resultTo, actualPlayerPortalEvent.getTo());
    assertSame(player, actualPlayerPortalEvent.getPlayer());
  }

  /**
   * Test {@link PlayerPortalEvent#PlayerPortalEvent(Player, Location, Location, TeleportCause)}.
   *
   * <p>Method under test: {@link PlayerPortalEvent#PlayerPortalEvent(Player, Location, Location,
   * TeleportCause)}
   */
  @Test
  @DisplayName("Test new PlayerPortalEvent(Player, Location, Location, TeleportCause)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPortalEvent.<init>(Player, Location, Location, TeleportCause)"})
  void testNewPlayerPortalEvent2() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPortalEvent actualPlayerPortalEvent =
        new PlayerPortalEvent(player, from, resultTo, TeleportCause.ENDER_PEARL);

    // Assert
    assertEquals("PlayerPortalEvent", actualPlayerPortalEvent.getEventName());
    assertEquals(128, actualPlayerPortalEvent.getSearchRadius());
    assertEquals(TeleportCause.ENDER_PEARL, actualPlayerPortalEvent.getCause());
    assertFalse(actualPlayerPortalEvent.isAsynchronous());
    assertFalse(actualPlayerPortalEvent.hasChangedOrientation());
    assertFalse(actualPlayerPortalEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerPortalEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerPortalEvent.isCancelled());
    assertTrue(actualPlayerPortalEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerPortalEvent.hasChangedBlock());
    assertTrue(actualPlayerPortalEvent.hasChangedPosition());
    assertTrue(actualPlayerPortalEvent.getCanCreatePortal());
    assertEquals(Short.SIZE, actualPlayerPortalEvent.getCreationRadius());
    assertSame(from, actualPlayerPortalEvent.getFrom());
    assertSame(resultTo, actualPlayerPortalEvent.getTo());
    assertSame(player, actualPlayerPortalEvent.getPlayer());
  }

  /**
   * Test {@link PlayerPortalEvent#PlayerPortalEvent(Player, Location, Location, TeleportCause, int,
   * boolean, int)}.
   *
   * <p>Method under test: {@link PlayerPortalEvent#PlayerPortalEvent(Player, Location, Location,
   * TeleportCause, int, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test new PlayerPortalEvent(Player, Location, Location, TeleportCause, int, boolean, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPortalEvent.<init>(Player, Location, Location, TeleportCause, int, boolean, int)"
  })
  void testNewPlayerPortalEvent3() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPortalEvent actualPlayerPortalEvent =
        new PlayerPortalEvent(player, from, resultTo, TeleportCause.ENDER_PEARL, 1, true, 1);

    // Assert
    assertEquals("PlayerPortalEvent", actualPlayerPortalEvent.getEventName());
    assertEquals(1, actualPlayerPortalEvent.getCreationRadius());
    assertEquals(1, actualPlayerPortalEvent.getSearchRadius());
    assertEquals(TeleportCause.ENDER_PEARL, actualPlayerPortalEvent.getCause());
    assertFalse(actualPlayerPortalEvent.isAsynchronous());
    assertFalse(actualPlayerPortalEvent.hasChangedOrientation());
    assertFalse(actualPlayerPortalEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerPortalEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerPortalEvent.isCancelled());
    assertTrue(actualPlayerPortalEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerPortalEvent.hasChangedBlock());
    assertTrue(actualPlayerPortalEvent.hasChangedPosition());
    assertTrue(actualPlayerPortalEvent.getCanCreatePortal());
    assertSame(from, actualPlayerPortalEvent.getFrom());
    assertSame(resultTo, actualPlayerPortalEvent.getTo());
    assertSame(player, actualPlayerPortalEvent.getPlayer());
  }

  /**
   * Test {@link PlayerPortalEvent#getTo()}.
   *
   * <p>Method under test: {@link PlayerPortalEvent#getTo()}
   */
  @Test
  @DisplayName("Test getTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PlayerPortalEvent.getTo()"})
  void testGetTo() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerPortalEvent playerPortalEvent = new PlayerPortalEvent(player, from, resultTo);

    // Act and Assert
    assertSame(resultTo, playerPortalEvent.getTo());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPortalEvent#setCanCreatePortal(boolean)}
   *   <li>{@link PlayerPortalEvent#setCreationRadius(int)}
   *   <li>{@link PlayerPortalEvent#setSearchRadius(int)}
   *   <li>{@link PlayerPortalEvent#getHandlerList()}
   *   <li>{@link PlayerPortalEvent#getCanCreatePortal()}
   *   <li>{@link PlayerPortalEvent#getCreationRadius()}
   *   <li>{@link PlayerPortalEvent#getHandlers()}
   *   <li>{@link PlayerPortalEvent#getSearchRadius()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PlayerPortalEvent.getCanCreatePortal()",
    "int PlayerPortalEvent.getCreationRadius()",
    "HandlerList PlayerPortalEvent.getHandlerList()",
    "HandlerList PlayerPortalEvent.getHandlers()",
    "int PlayerPortalEvent.getSearchRadius()",
    "void PlayerPortalEvent.setCanCreatePortal(boolean)",
    "void PlayerPortalEvent.setCreationRadius(int)",
    "void PlayerPortalEvent.setSearchRadius(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerPortalEvent playerPortalEvent = new PlayerPortalEvent(player, from, resultTo);

    // Act
    playerPortalEvent.setCanCreatePortal(true);
    playerPortalEvent.setCreationRadius(1);
    playerPortalEvent.setSearchRadius(1);
    HandlerList actualHandlerList = playerPortalEvent.getHandlerList();
    boolean actualCanCreatePortal = playerPortalEvent.getCanCreatePortal();
    int actualCreationRadius = playerPortalEvent.getCreationRadius();
    HandlerList actualHandlers = playerPortalEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualCreationRadius);
    assertEquals(1, playerPortalEvent.getSearchRadius());
    assertTrue(actualCanCreatePortal);
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link PlayerPortalEvent#willDismountPlayer()}.
   *
   * <p>Method under test: {@link PlayerPortalEvent#willDismountPlayer()}
   */
  @Test
  @DisplayName("Test willDismountPlayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPortalEvent.willDismountPlayer()"})
  void testWillDismountPlayer() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerPortalEvent playerPortalEvent = new PlayerPortalEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerPortalEvent.willDismountPlayer());
  }

  /**
   * Test {@link PlayerPortalEvent#getRelativeTeleportationFlags()}.
   *
   * <p>Method under test: {@link PlayerPortalEvent#getRelativeTeleportationFlags()}
   */
  @Test
  @DisplayName("Test getRelativeTeleportationFlags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PlayerPortalEvent.getRelativeTeleportationFlags()"})
  void testGetRelativeTeleportationFlags() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerPortalEvent playerPortalEvent = new PlayerPortalEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerPortalEvent.getRelativeTeleportationFlags().isEmpty());
  }
}
