package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleUpdateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleUpdateEvent#VehicleUpdateEvent(Vehicle)}
   *   <li>{@link VehicleUpdateEvent#getHandlerList()}
   *   <li>{@link VehicleUpdateEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleUpdateEvent.<init>(Vehicle)",
    "HandlerList VehicleUpdateEvent.getHandlerList()",
    "HandlerList VehicleUpdateEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);

    // Act
    VehicleUpdateEvent actualVehicleUpdateEvent = new VehicleUpdateEvent(vehicle);
    HandlerList actualHandlerList = actualVehicleUpdateEvent.getHandlerList();
    HandlerList actualHandlers = actualVehicleUpdateEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualVehicleUpdateEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(vehicle, actualVehicleUpdateEvent.getVehicle());
  }
}
