package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent.RespawnFlag;
import org.bukkit.event.player.PlayerRespawnEvent.RespawnReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractRespawnEventDiffblueTest {
  /**
   * Test {@link AbstractRespawnEvent#getRespawnLocation()}.
   *
   * <p>Method under test: {@link AbstractRespawnEvent#getRespawnLocation()}
   */
  @Test
  @DisplayName("Test getRespawnLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location AbstractRespawnEvent.getRespawnLocation()"})
  void testGetRespawnLocation() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act
    Location actualRespawnLocation = playerRespawnEvent.getRespawnLocation();

    // Assert
    assertEquals(playerRespawnEvent.respawnLocation, actualRespawnLocation);
  }

  /**
   * Test {@link AbstractRespawnEvent#isBedSpawn()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRespawnEvent#isBedSpawn()}
   */
  @Test
  @DisplayName("Test isBedSpawn(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRespawnEvent.isBedSpawn()"})
  void testIsBedSpawn_thenReturnFalse() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, false);

    // Act and Assert
    assertFalse(playerRespawnEvent.isBedSpawn());
  }

  /**
   * Test {@link AbstractRespawnEvent#isBedSpawn()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRespawnEvent#isBedSpawn()}
   */
  @Test
  @DisplayName("Test isBedSpawn(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRespawnEvent.isBedSpawn()"})
  void testIsBedSpawn_thenReturnTrue() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act and Assert
    assertTrue(playerRespawnEvent.isBedSpawn());
  }

  /**
   * Test {@link AbstractRespawnEvent#isAnchorSpawn()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRespawnEvent#isAnchorSpawn()}
   */
  @Test
  @DisplayName("Test isAnchorSpawn(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRespawnEvent.isAnchorSpawn()"})
  void testIsAnchorSpawn_thenReturnFalse() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act and Assert
    assertFalse(playerRespawnEvent.isAnchorSpawn());
  }

  /**
   * Test {@link AbstractRespawnEvent#isAnchorSpawn()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRespawnEvent#isAnchorSpawn()}
   */
  @Test
  @DisplayName("Test isAnchorSpawn(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRespawnEvent.isAnchorSpawn()"})
  void testIsAnchorSpawn_thenReturnTrue() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true, true);

    // Act and Assert
    assertTrue(playerRespawnEvent.isAnchorSpawn());
  }

  /**
   * Test {@link AbstractRespawnEvent#isMissingRespawnBlock()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRespawnEvent#isMissingRespawnBlock()}
   */
  @Test
  @DisplayName("Test isMissingRespawnBlock(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRespawnEvent.isMissingRespawnBlock()"})
  void testIsMissingRespawnBlock_thenReturnFalse() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act and Assert
    assertFalse(playerRespawnEvent.isMissingRespawnBlock());
  }

  /**
   * Test {@link AbstractRespawnEvent#isMissingRespawnBlock()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRespawnEvent#isMissingRespawnBlock()}
   */
  @Test
  @DisplayName("Test isMissingRespawnBlock(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRespawnEvent.isMissingRespawnBlock()"})
  void testIsMissingRespawnBlock_thenReturnTrue() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(
            respawnPlayer, respawnLocation, true, true, true, RespawnReason.DEATH);

    // Act and Assert
    assertTrue(playerRespawnEvent.isMissingRespawnBlock());
  }

  /**
   * Test {@link AbstractRespawnEvent#getRespawnReason()}.
   *
   * <p>Method under test: {@link AbstractRespawnEvent#getRespawnReason()}
   */
  @Test
  @DisplayName("Test getRespawnReason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PlayerRespawnEvent.RespawnReason AbstractRespawnEvent.getRespawnReason()"})
  void testGetRespawnReason() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act and Assert
    assertEquals(RespawnReason.PLUGIN, playerRespawnEvent.getRespawnReason());
  }

  /**
   * Test {@link AbstractRespawnEvent#getRespawnFlags()}.
   *
   * <p>Method under test: {@link AbstractRespawnEvent#getRespawnFlags()}
   */
  @Test
  @DisplayName("Test getRespawnFlags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AbstractRespawnEvent.getRespawnFlags()"})
  void testGetRespawnFlags() {
    // Arrange
    Player respawnPlayer = mock(Player.class);
    Location respawnLocation = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    PlayerRespawnEvent playerRespawnEvent =
        new PlayerRespawnEvent(respawnPlayer, respawnLocation, true);

    // Act
    Set<RespawnFlag> actualRespawnFlags = playerRespawnEvent.getRespawnFlags();

    // Assert
    assertEquals(1, actualRespawnFlags.size());
    assertTrue(actualRespawnFlags.contains(RespawnFlag.BED_SPAWN));
  }
}
