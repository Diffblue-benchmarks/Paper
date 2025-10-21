package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleEnterEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleEnterEvent#VehicleEnterEvent(Vehicle, Entity)}
   *   <li>{@link VehicleEnterEvent#setCancelled(boolean)}
   *   <li>{@link VehicleEnterEvent#getHandlerList()}
   *   <li>{@link VehicleEnterEvent#getEntered()}
   *   <li>{@link VehicleEnterEvent#getHandlers()}
   *   <li>{@link VehicleEnterEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleEnterEvent.<init>(Vehicle, Entity)",
    "Entity VehicleEnterEvent.getEntered()",
    "HandlerList VehicleEnterEvent.getHandlerList()",
    "HandlerList VehicleEnterEvent.getHandlers()",
    "boolean VehicleEnterEvent.isCancelled()",
    "void VehicleEnterEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Entity entered = mock(Entity.class);

    // Act
    VehicleEnterEvent actualVehicleEnterEvent = new VehicleEnterEvent(vehicle, entered);
    actualVehicleEnterEvent.setCancelled(true);
    HandlerList actualHandlerList = actualVehicleEnterEvent.getHandlerList();
    Entity actualEntered = actualVehicleEnterEvent.getEntered();
    HandlerList actualHandlers = actualVehicleEnterEvent.getHandlers();
    boolean actualIsCancelledResult = actualVehicleEnterEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualVehicleEnterEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entered, actualEntered);
    assertSame(vehicle, actualVehicleEnterEvent.getVehicle());
  }
}
