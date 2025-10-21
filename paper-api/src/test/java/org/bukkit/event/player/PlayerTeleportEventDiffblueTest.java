package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.entity.TeleportFlag;
import io.papermc.paper.entity.TeleportFlag.Relative;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerTeleportEventDiffblueTest {
  /**
   * Test {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location, Location)}.
   *
   * <p>Method under test: {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location,
   * Location)}
   */
  @Test
  @DisplayName("Test new PlayerTeleportEvent(Player, Location, Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerTeleportEvent.<init>(Player, Location, Location)"})
  void testNewPlayerTeleportEvent() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerTeleportEvent actualPlayerTeleportEvent = new PlayerTeleportEvent(player, from, resultTo);

    // Assert
    assertEquals("PlayerTeleportEvent", actualPlayerTeleportEvent.getEventName());
    assertEquals(TeleportCause.UNKNOWN, actualPlayerTeleportEvent.getCause());
    assertFalse(actualPlayerTeleportEvent.isAsynchronous());
    assertFalse(actualPlayerTeleportEvent.hasChangedOrientation());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerTeleportEvent.isCancelled());
    assertTrue(actualPlayerTeleportEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerTeleportEvent.hasChangedBlock());
    assertTrue(actualPlayerTeleportEvent.hasChangedPosition());
    assertSame(from, actualPlayerTeleportEvent.getFrom());
    assertSame(resultTo, actualPlayerTeleportEvent.getTo());
    assertSame(player, actualPlayerTeleportEvent.getPlayer());
  }

  /**
   * Test {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location, Location,
   * TeleportCause)}.
   *
   * <p>Method under test: {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location,
   * Location, TeleportCause)}
   */
  @Test
  @DisplayName("Test new PlayerTeleportEvent(Player, Location, Location, TeleportCause)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerTeleportEvent.<init>(Player, Location, Location, TeleportCause)"})
  void testNewPlayerTeleportEvent2() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerTeleportEvent actualPlayerTeleportEvent =
        new PlayerTeleportEvent(player, from, resultTo, TeleportCause.ENDER_PEARL);

    // Assert
    assertEquals("PlayerTeleportEvent", actualPlayerTeleportEvent.getEventName());
    assertEquals(TeleportCause.ENDER_PEARL, actualPlayerTeleportEvent.getCause());
    assertFalse(actualPlayerTeleportEvent.isAsynchronous());
    assertFalse(actualPlayerTeleportEvent.hasChangedOrientation());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerTeleportEvent.isCancelled());
    assertTrue(actualPlayerTeleportEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerTeleportEvent.hasChangedBlock());
    assertTrue(actualPlayerTeleportEvent.hasChangedPosition());
    assertSame(from, actualPlayerTeleportEvent.getFrom());
    assertSame(resultTo, actualPlayerTeleportEvent.getTo());
    assertSame(player, actualPlayerTeleportEvent.getPlayer());
  }

  /**
   * Test {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location, Location, TeleportCause,
   * Set)}.
   *
   * <ul>
   *   <li>Given {@code VELOCITY_Y}.
   *   <li>When {@link HashSet#HashSet()} add {@code VELOCITY_Y}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location,
   * Location, TeleportCause, Set)}
   */
  @Test
  @DisplayName(
      "Test new PlayerTeleportEvent(Player, Location, Location, TeleportCause, Set); given 'VELOCITY_Y'; when HashSet() add 'VELOCITY_Y'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerTeleportEvent.<init>(Player, Location, Location, TeleportCause, Set)"
  })
  void testNewPlayerTeleportEvent_givenVelocityY_whenHashSetAddVelocityY() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    HashSet<Relative> teleportFlags = new HashSet<>();
    teleportFlags.add(Relative.VELOCITY_Y);
    teleportFlags.add(Relative.VELOCITY_X);

    // Act
    PlayerTeleportEvent actualPlayerTeleportEvent =
        new PlayerTeleportEvent(player, from, resultTo, TeleportCause.ENDER_PEARL, teleportFlags);

    // Assert
    assertSame(teleportFlags, actualPlayerTeleportEvent.getRelativeTeleportationFlags());
  }

  /**
   * Test {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location, Location, TeleportCause,
   * Set)}.
   *
   * <ul>
   *   <li>Then return RelativeTeleportationFlags size is one.
   * </ul>
   *
   * <p>Method under test: {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location,
   * Location, TeleportCause, Set)}
   */
  @Test
  @DisplayName(
      "Test new PlayerTeleportEvent(Player, Location, Location, TeleportCause, Set); then return RelativeTeleportationFlags size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerTeleportEvent.<init>(Player, Location, Location, TeleportCause, Set)"
  })
  void testNewPlayerTeleportEvent_thenReturnRelativeTeleportationFlagsSizeIsOne() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    HashSet<Relative> teleportFlags = new HashSet<>();
    teleportFlags.add(Relative.VELOCITY_X);

    // Act
    PlayerTeleportEvent actualPlayerTeleportEvent =
        new PlayerTeleportEvent(player, from, resultTo, TeleportCause.ENDER_PEARL, teleportFlags);

    // Assert
    assertEquals("PlayerTeleportEvent", actualPlayerTeleportEvent.getEventName());
    Set<Relative> relativeTeleportationFlags =
        actualPlayerTeleportEvent.getRelativeTeleportationFlags();
    assertEquals(1, relativeTeleportationFlags.size());
    assertEquals(TeleportCause.ENDER_PEARL, actualPlayerTeleportEvent.getCause());
    assertFalse(actualPlayerTeleportEvent.isAsynchronous());
    assertFalse(actualPlayerTeleportEvent.hasChangedOrientation());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerTeleportEvent.isCancelled());
    assertTrue(actualPlayerTeleportEvent.hasChangedBlock());
    assertTrue(actualPlayerTeleportEvent.hasChangedPosition());
    assertSame(teleportFlags, relativeTeleportationFlags);
    assertSame(from, actualPlayerTeleportEvent.getFrom());
    assertSame(resultTo, actualPlayerTeleportEvent.getTo());
    assertSame(player, actualPlayerTeleportEvent.getPlayer());
  }

  /**
   * Test {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location, Location, TeleportCause,
   * Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return RelativeTeleportationFlags Empty.
   * </ul>
   *
   * <p>Method under test: {@link PlayerTeleportEvent#PlayerTeleportEvent(Player, Location,
   * Location, TeleportCause, Set)}
   */
  @Test
  @DisplayName(
      "Test new PlayerTeleportEvent(Player, Location, Location, TeleportCause, Set); when HashSet(); then return RelativeTeleportationFlags Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerTeleportEvent.<init>(Player, Location, Location, TeleportCause, Set)"
  })
  void testNewPlayerTeleportEvent_whenHashSet_thenReturnRelativeTeleportationFlagsEmpty() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    PlayerTeleportEvent actualPlayerTeleportEvent =
        new PlayerTeleportEvent(player, from, resultTo, TeleportCause.ENDER_PEARL, new HashSet<>());

    // Assert
    assertEquals("PlayerTeleportEvent", actualPlayerTeleportEvent.getEventName());
    assertEquals(TeleportCause.ENDER_PEARL, actualPlayerTeleportEvent.getCause());
    assertFalse(actualPlayerTeleportEvent.isAsynchronous());
    assertFalse(actualPlayerTeleportEvent.hasChangedOrientation());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerTeleportEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerTeleportEvent.isCancelled());
    assertTrue(actualPlayerTeleportEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerTeleportEvent.hasChangedBlock());
    assertTrue(actualPlayerTeleportEvent.hasChangedPosition());
    assertSame(from, actualPlayerTeleportEvent.getFrom());
    assertSame(resultTo, actualPlayerTeleportEvent.getTo());
    assertSame(player, actualPlayerTeleportEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerTeleportEvent#getHandlerList()}
   *   <li>{@link PlayerTeleportEvent#getCause()}
   *   <li>{@link PlayerTeleportEvent#getHandlers()}
   *   <li>{@link PlayerTeleportEvent#getRelativeTeleportationFlags()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeleportCause PlayerTeleportEvent.getCause()",
    "HandlerList PlayerTeleportEvent.getHandlerList()",
    "HandlerList PlayerTeleportEvent.getHandlers()",
    "Set PlayerTeleportEvent.getRelativeTeleportationFlags()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerTeleportEvent playerTeleportEvent = new PlayerTeleportEvent(player, from, resultTo);

    // Act
    HandlerList actualHandlerList = playerTeleportEvent.getHandlerList();
    TeleportCause actualCause = playerTeleportEvent.getCause();
    HandlerList actualHandlers = playerTeleportEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(TeleportCause.UNKNOWN, actualCause);
    assertTrue(playerTeleportEvent.getRelativeTeleportationFlags().isEmpty());
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link PlayerTeleportEvent#willDismountPlayer()}.
   *
   * <p>Method under test: {@link PlayerTeleportEvent#willDismountPlayer()}
   */
  @Test
  @DisplayName("Test willDismountPlayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerTeleportEvent.willDismountPlayer()"})
  void testWillDismountPlayer() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerTeleportEvent playerTeleportEvent = new PlayerTeleportEvent(player, from, resultTo);

    // Act and Assert
    assertTrue(playerTeleportEvent.willDismountPlayer());
  }
}
