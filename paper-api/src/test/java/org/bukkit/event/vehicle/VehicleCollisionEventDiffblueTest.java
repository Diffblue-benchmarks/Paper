package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleCollisionEventDiffblueTest {
  /**
   * Test {@link VehicleCollisionEvent#getHandlers()}.
   *
   * <p>Method under test: {@link VehicleCollisionEvent#getHandlers()}
   */
  @Test
  @DisplayName("Test getHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HandlerList VehicleCollisionEvent.getHandlers()"})
  void testGetHandlers() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    when(vehicle.getVelocity()).thenReturn(Vector.getRandom());
    VehicleBlockCollisionEvent vehicleBlockCollisionEvent =
        new VehicleBlockCollisionEvent(vehicle, mock(Block.class));

    // Act
    HandlerList actualHandlers = vehicleBlockCollisionEvent.getHandlers();

    // Assert
    verify(vehicle).getVelocity();
    assertEquals(0, actualHandlers.getRegisteredListeners().length);
  }
}
