package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleCreateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleCreateEvent#VehicleCreateEvent(Vehicle)}
   *   <li>{@link VehicleCreateEvent#setCancelled(boolean)}
   *   <li>{@link VehicleCreateEvent#getHandlerList()}
   *   <li>{@link VehicleCreateEvent#getHandlers()}
   *   <li>{@link VehicleCreateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleCreateEvent.<init>(Vehicle)",
    "HandlerList VehicleCreateEvent.getHandlerList()",
    "HandlerList VehicleCreateEvent.getHandlers()",
    "boolean VehicleCreateEvent.isCancelled()",
    "void VehicleCreateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);

    // Act
    VehicleCreateEvent actualVehicleCreateEvent = new VehicleCreateEvent(vehicle);
    actualVehicleCreateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualVehicleCreateEvent.getHandlerList();
    HandlerList actualHandlers = actualVehicleCreateEvent.getHandlers();
    boolean actualIsCancelledResult = actualVehicleCreateEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualVehicleCreateEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(vehicle, actualVehicleCreateEvent.getVehicle());
  }
}
