package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.EndGateway;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTeleportEndGatewayEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTeleportEndGatewayEvent#EntityTeleportEndGatewayEvent(Entity, Location,
   *       Location, EndGateway)}
   *   <li>{@link EntityTeleportEndGatewayEvent#getGateway()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTeleportEndGatewayEvent.<init>(Entity, Location, Location, EndGateway)",
    "EndGateway EntityTeleportEndGatewayEvent.getGateway()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    EndGateway gateway = mock(EndGateway.class);

    // Act
    EntityTeleportEndGatewayEvent actualEntityTeleportEndGatewayEvent =
        new EntityTeleportEndGatewayEvent(entity, from, resultTo, gateway);
    EndGateway actualGateway = actualEntityTeleportEndGatewayEvent.getGateway();

    // Assert
    assertFalse(actualEntityTeleportEndGatewayEvent.isAsynchronous());
    assertFalse(actualEntityTeleportEndGatewayEvent.isCancelled());
    assertSame(from, actualEntityTeleportEndGatewayEvent.getFrom());
    assertSame(resultTo, actualEntityTeleportEndGatewayEvent.getTo());
    assertSame(gateway, actualGateway);
    assertSame(entity, actualEntityTeleportEndGatewayEvent.getEntity());
  }
}
