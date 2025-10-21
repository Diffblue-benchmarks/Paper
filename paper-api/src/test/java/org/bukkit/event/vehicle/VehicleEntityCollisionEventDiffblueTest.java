package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleEntityCollisionEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleEntityCollisionEvent#VehicleEntityCollisionEvent(Vehicle, Entity)}
   *   <li>{@link VehicleEntityCollisionEvent#setCancelled(boolean)}
   *   <li>{@link VehicleEntityCollisionEvent#setCollisionCancelled(boolean)}
   *   <li>{@link VehicleEntityCollisionEvent#setPickupCancelled(boolean)}
   *   <li>{@link VehicleEntityCollisionEvent#getEntity()}
   *   <li>{@link VehicleEntityCollisionEvent#isCancelled()}
   *   <li>{@link VehicleEntityCollisionEvent#isCollisionCancelled()}
   *   <li>{@link VehicleEntityCollisionEvent#isPickupCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleEntityCollisionEvent.<init>(Vehicle, Entity)",
    "Entity VehicleEntityCollisionEvent.getEntity()",
    "boolean VehicleEntityCollisionEvent.isCancelled()",
    "boolean VehicleEntityCollisionEvent.isCollisionCancelled()",
    "boolean VehicleEntityCollisionEvent.isPickupCancelled()",
    "void VehicleEntityCollisionEvent.setCancelled(boolean)",
    "void VehicleEntityCollisionEvent.setCollisionCancelled(boolean)",
    "void VehicleEntityCollisionEvent.setPickupCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Entity entity = mock(Entity.class);

    // Act
    VehicleEntityCollisionEvent actualVehicleEntityCollisionEvent =
        new VehicleEntityCollisionEvent(vehicle, entity);
    actualVehicleEntityCollisionEvent.setCancelled(true);
    actualVehicleEntityCollisionEvent.setCollisionCancelled(true);
    actualVehicleEntityCollisionEvent.setPickupCancelled(true);
    Entity actualEntity = actualVehicleEntityCollisionEvent.getEntity();
    boolean actualIsCancelledResult = actualVehicleEntityCollisionEvent.isCancelled();
    boolean actualIsCollisionCancelledResult =
        actualVehicleEntityCollisionEvent.isCollisionCancelled();
    boolean actualIsPickupCancelledResult = actualVehicleEntityCollisionEvent.isPickupCancelled();

    // Assert
    assertFalse(actualVehicleEntityCollisionEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsCollisionCancelledResult);
    assertTrue(actualIsPickupCancelledResult);
    assertSame(entity, actualEntity);
    assertSame(vehicle, actualVehicleEntityCollisionEvent.getVehicle());
  }
}
