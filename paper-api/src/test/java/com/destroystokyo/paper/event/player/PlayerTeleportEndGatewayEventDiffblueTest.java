package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.EndGateway;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerTeleportEndGatewayEventDiffblueTest {
  /**
   * Test {@link PlayerTeleportEndGatewayEvent#PlayerTeleportEndGatewayEvent(Player, Location,
   * Location, EndGateway)}.
   *
   * <p>Method under test: {@link
   * PlayerTeleportEndGatewayEvent#PlayerTeleportEndGatewayEvent(Player, Location, Location,
   * EndGateway)}
   */
  @Test
  @DisplayName("Test new PlayerTeleportEndGatewayEvent(Player, Location, Location, EndGateway)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerTeleportEndGatewayEvent.<init>(Player, Location, Location, EndGateway)"
  })
  void testNewPlayerTeleportEndGatewayEvent() {
    // Arrange
    Player player = mock(Player.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    EndGateway gateway = mock(EndGateway.class);

    // Act
    PlayerTeleportEndGatewayEvent actualPlayerTeleportEndGatewayEvent =
        new PlayerTeleportEndGatewayEvent(player, from, resultTo, gateway);

    // Assert
    assertEquals(
        "PlayerTeleportEndGatewayEvent", actualPlayerTeleportEndGatewayEvent.getEventName());
    assertEquals(TeleportCause.END_GATEWAY, actualPlayerTeleportEndGatewayEvent.getCause());
    assertFalse(actualPlayerTeleportEndGatewayEvent.isAsynchronous());
    assertFalse(actualPlayerTeleportEndGatewayEvent.hasChangedOrientation());
    assertFalse(actualPlayerTeleportEndGatewayEvent.hasExplicitlyChangedBlock());
    assertFalse(actualPlayerTeleportEndGatewayEvent.hasExplicitlyChangedPosition());
    assertFalse(actualPlayerTeleportEndGatewayEvent.isCancelled());
    assertTrue(actualPlayerTeleportEndGatewayEvent.getRelativeTeleportationFlags().isEmpty());
    assertTrue(actualPlayerTeleportEndGatewayEvent.hasChangedBlock());
    assertTrue(actualPlayerTeleportEndGatewayEvent.hasChangedPosition());
    assertSame(from, actualPlayerTeleportEndGatewayEvent.getFrom());
    assertSame(resultTo, actualPlayerTeleportEndGatewayEvent.getTo());
    assertSame(gateway, actualPlayerTeleportEndGatewayEvent.getGateway());
    assertSame(player, actualPlayerTeleportEndGatewayEvent.getPlayer());
  }
}
