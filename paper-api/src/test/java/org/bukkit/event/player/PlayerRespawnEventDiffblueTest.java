package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerRespawnEvent.RespawnFlag;
import org.bukkit.event.player.PlayerRespawnEvent.RespawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerRespawnEventDiffblueTest {
  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean)}.
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean)}
   */
  @Test
  @DisplayName("Test new PlayerRespawnEvent(Player, Location, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean)"})
  void testNewPlayerRespawnEvent() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, false);

    // Assert
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean)}.
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean)}
   */
  @Test
  @DisplayName("Test new PlayerRespawnEvent(Player, Location, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean)"})
  void testNewPlayerRespawnEvent2() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 10.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, false);

    // Assert
    assertEquals(respawnLocation, actualPlayerRespawnEvent.getRespawnLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean, boolean,
   * RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code DEATH}.
   *   <li>Then return RespawnFlags size is two.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean, boolean, RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'DEATH'; then return RespawnFlags size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, RespawnReason)"
  })
  void testNewPlayerRespawnEvent_whenDeath_thenReturnRespawnFlagsSizeIsTwo() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.DEATH);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerRespawnEvent.getRespawnFlags();
    assertEquals(2, respawnFlags.size());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean, boolean,
   * RespawnReason)}.
   *
   * <ul>
   *   <li>When {@link RespawnReason#END_PORTAL}.
   *   <li>Then return RespawnFlags size is three.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean, boolean, RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when END_PORTAL; then return RespawnFlags size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, RespawnReason)"
  })
  void testNewPlayerRespawnEvent_whenEnd_portal_thenReturnRespawnFlagsSizeIsThree() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.END_PORTAL);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerRespawnEvent.getRespawnFlags();
    assertEquals(3, respawnFlags.size());
    assertEquals(RespawnReason.END_PORTAL, actualPlayerRespawnEvent.getRespawnReason());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    assertTrue(respawnFlags.contains(RespawnFlag.BED_SPAWN));
    assertTrue(respawnFlags.contains(RespawnFlag.END_PORTAL));
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean, boolean,
   * RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean, boolean, RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, RespawnReason)"
  })
  void testNewPlayerRespawnEvent_whenFalse() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(
            respawnPlayer, respawnLocation, true, false, true, RespawnReason.DEATH);

    // Assert
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return RespawnFlags Empty.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean); when 'false'; then return RespawnFlags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean)"})
  void testNewPlayerRespawnEvent_whenFalse_thenReturnRespawnFlagsEmpty() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, false, false);

    // Assert
    assertTrue(actualPlayerRespawnEvent.getRespawnFlags().isEmpty());
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean, boolean,
   * RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return RespawnFlags Empty.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean, boolean, RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'false'; then return RespawnFlags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, RespawnReason)"
  })
  void testNewPlayerRespawnEvent_whenFalse_thenReturnRespawnFlagsEmpty2() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(
            respawnPlayer, respawnLocation, false, false, true, RespawnReason.DEATH);

    // Assert
    assertTrue(actualPlayerRespawnEvent.getRespawnFlags().isEmpty());
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return RespawnFlags size is one.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean); when 'false'; then return RespawnFlags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean)"})
  void testNewPlayerRespawnEvent_whenFalse_thenReturnRespawnFlagsSizeIsOne() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, false, true);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerRespawnEvent.getRespawnFlags();
    assertEquals(1, respawnFlags.size());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean, boolean,
   * RespawnReason)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return RespawnFlags size is one.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean, boolean, RespawnReason)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean, boolean, RespawnReason); when 'false'; then return RespawnFlags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean, boolean, RespawnReason)"
  })
  void testNewPlayerRespawnEvent_whenFalse_thenReturnRespawnFlagsSizeIsOne2() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(
            respawnPlayer, respawnLocation, false, true, true, RespawnReason.DEATH);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerRespawnEvent.getRespawnFlags();
    assertEquals(1, respawnFlags.size());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean)}
   */
  @Test
  @DisplayName("Test new PlayerRespawnEvent(Player, Location, boolean, boolean); when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean)"})
  void testNewPlayerRespawnEvent_whenTrue() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true, false);

    // Assert
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return RespawnFlags size is one.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean); when 'true'; then return RespawnFlags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean)"})
  void testNewPlayerRespawnEvent_whenTrue_thenReturnRespawnFlagsSizeIsOne() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerRespawnEvent.getRespawnFlags();
    assertEquals(1, respawnFlags.size());
    assertTrue(actualPlayerRespawnEvent.isBedSpawn());
    assertTrue(respawnFlags.contains(RespawnFlag.BED_SPAWN));
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return RespawnFlags size is two.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#PlayerRespawnEvent(Player, Location, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerRespawnEvent(Player, Location, boolean, boolean); when 'true'; then return RespawnFlags size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.<init>(Player, Location, boolean, boolean)"})
  void testNewPlayerRespawnEvent_whenTrue_thenReturnRespawnFlagsSizeIsTwo() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerRespawnEvent actualPlayerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true, true);

    // Assert
    Set<RespawnFlag> respawnFlags = actualPlayerRespawnEvent.getRespawnFlags();
    assertEquals(2, respawnFlags.size());
    assertTrue(respawnFlags.contains(RespawnFlag.ANCHOR_SPAWN));
    assertEquals(
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation(),
        actualPlayerRespawnEvent.getRespawnLocation().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link PlayerRespawnEvent#setRespawnLocation(Location)}.
   *
   * <ul>
   *   <li>Given {@link World}.
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRespawnEvent#setRespawnLocation(Location)}
   */
  @Test
  @DisplayName("Test setRespawnLocation(Location); given World; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRespawnEvent.setRespawnLocation(Location)"})
  void testSetRespawnLocation_givenWorld_thenCallsClone() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    Location respawnLocation2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(respawnLocation2.clone()).thenReturn(location);
    when(respawnLocation2.getWorld()).thenReturn(mock(World.class));

    // Act
    playerRespawnEvent.setRespawnLocation(respawnLocation2);

    // Assert
    verify(respawnLocation2).clone();
    verify(respawnLocation2).getWorld();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerRespawnEvent#getHandlerList()}
   *   <li>{@link PlayerRespawnEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList PlayerRespawnEvent.getHandlerList()",
    "HandlerList PlayerRespawnEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act
    HandlerList actualHandlerList = playerRespawnEvent.getHandlerList();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(actualHandlerList, playerRespawnEvent.getHandlers());
  }
}
