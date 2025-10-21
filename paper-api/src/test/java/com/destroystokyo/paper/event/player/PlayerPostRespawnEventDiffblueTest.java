package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent.RespawnFlag;
import org.bukkit.event.player.PlayerRespawnEvent.RespawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPostRespawnEventDiffblueTest {
  /**
   * Test {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location, boolean, boolean,
   * boolean, RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code DEATH}.
   *   <li>Then return RespawnFlags size is two.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location,
   * boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerPostRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'DEATH'; then return RespawnFlags size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPostRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)"
  })
  void testNewPlayerPostRespawnEvent_whenDeath_thenReturnRespawnFlagsSizeIsTwo() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPostRespawnEvent actualPlayerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.DEATH);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerPostRespawnEvent.getRespawnFlags();
    assertEquals(2, respawnFlags.size());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    Location toHighestLocationResult =
        actualPlayerPostRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation();
    assertEquals(
        toHighestLocationResult,
        actualPlayerPostRespawnEvent.getRespawnedLocation().toHighestLocation());
    assertEquals(toHighestLocationResult, toHighestLocationResult);
  }

  /**
   * Test {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location, boolean, boolean,
   * boolean, RespawnReason)}.
   *
   * <ul>
   *   <li>When {@link PlayerRespawnEvent.RespawnReason#END_PORTAL}.
   *   <li>Then return RespawnFlags size is three.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location,
   * boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerPostRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when END_PORTAL; then return RespawnFlags size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPostRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)"
  })
  void testNewPlayerPostRespawnEvent_whenEnd_portal_thenReturnRespawnFlagsSizeIsThree() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPostRespawnEvent actualPlayerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.END_PORTAL);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerPostRespawnEvent.getRespawnFlags();
    assertEquals(3, respawnFlags.size());
    assertEquals(RespawnReason.END_PORTAL, actualPlayerPostRespawnEvent.getRespawnReason());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    assertTrue(respawnFlags.contains(RespawnFlag.BED_SPAWN));
    assertTrue(respawnFlags.contains(RespawnFlag.END_PORTAL));
  }

  /**
   * Test {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location, boolean, boolean,
   * boolean, RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location,
   * boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerPostRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPostRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)"
  })
  void testNewPlayerPostRespawnEvent_whenFalse() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPostRespawnEvent actualPlayerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, true, false, true, RespawnReason.DEATH);

    // Assert
    Location toHighestLocationResult =
        actualPlayerPostRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation();
    assertEquals(
        toHighestLocationResult,
        actualPlayerPostRespawnEvent.getRespawnedLocation().toHighestLocation());
    assertEquals(toHighestLocationResult, toHighestLocationResult);
  }

  /**
   * Test {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location, boolean, boolean,
   * boolean, RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return RespawnFlags Empty.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location,
   * boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerPostRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'false'; then return RespawnFlags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPostRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)"
  })
  void testNewPlayerPostRespawnEvent_whenFalse_thenReturnRespawnFlagsEmpty() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPostRespawnEvent actualPlayerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, false, false, true, RespawnReason.DEATH);

    // Assert
    assertTrue(actualPlayerPostRespawnEvent.getRespawnFlags().isEmpty());
    Location toHighestLocationResult =
        actualPlayerPostRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation();
    assertEquals(
        toHighestLocationResult,
        actualPlayerPostRespawnEvent.getRespawnedLocation().toHighestLocation());
    assertEquals(toHighestLocationResult, toHighestLocationResult);
  }

  /**
   * Test {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location, boolean, boolean,
   * boolean, RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return RespawnFlags size is one.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPostRespawnEvent#PlayerPostRespawnEvent(Player, Location,
   * boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerPostRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'false'; then return RespawnFlags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPostRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, PlayerRespawnEvent.RespawnReason)"
  })
  void testNewPlayerPostRespawnEvent_whenFalse_thenReturnRespawnFlagsSizeIsOne() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerPostRespawnEvent actualPlayerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, false, true, true, RespawnReason.DEATH);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerPostRespawnEvent.getRespawnFlags();
    assertEquals(1, respawnFlags.size());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    Location toHighestLocationResult =
        actualPlayerPostRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation();
    assertEquals(
        toHighestLocationResult,
        actualPlayerPostRespawnEvent.getRespawnedLocation().toHighestLocation());
    assertEquals(toHighestLocationResult, toHighestLocationResult);
  }

  /**
   * Test {@link PlayerPostRespawnEvent#getRespawnedLocation()}.
   *
   * <p>Method under test: {@link PlayerPostRespawnEvent#getRespawnedLocation()}
   */
  @Test
  @DisplayName("Test getRespawnedLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location PlayerPostRespawnEvent.getRespawnedLocation()"})
  void testGetRespawnedLocation() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerPostRespawnEvent playerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.DEATH);

    // Act and Assert
    assertEquals(respawnLocation, playerPostRespawnEvent.getRespawnedLocation());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPostRespawnEvent#getHandlerList()}
   *   <li>{@link PlayerPostRespawnEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList PlayerPostRespawnEvent.getHandlerList()",
    "HandlerList PlayerPostRespawnEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerPostRespawnEvent playerPostRespawnEvent =
        new PlayerPostRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.DEATH);

    // Act
    HandlerList actualHandlerList = playerPostRespawnEvent.getHandlerList();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(actualHandlerList, playerPostRespawnEvent.getHandlers());
  }
}
