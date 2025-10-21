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

class VehicleDestroyEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleDestroyEvent#VehicleDestroyEvent(Vehicle, Entity)}
   *   <li>{@link VehicleDestroyEvent#setCancelled(boolean)}
   *   <li>{@link VehicleDestroyEvent#getHandlerList()}
   *   <li>{@link VehicleDestroyEvent#getAttacker()}
   *   <li>{@link VehicleDestroyEvent#getHandlers()}
   *   <li>{@link VehicleDestroyEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleDestroyEvent.<init>(Vehicle, Entity)",
    "Entity VehicleDestroyEvent.getAttacker()",
    "HandlerList VehicleDestroyEvent.getHandlerList()",
    "HandlerList VehicleDestroyEvent.getHandlers()",
    "boolean VehicleDestroyEvent.isCancelled()",
    "void VehicleDestroyEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Entity attacker = mock(Entity.class);

    // Act
    VehicleDestroyEvent actualVehicleDestroyEvent = new VehicleDestroyEvent(vehicle, attacker);
    actualVehicleDestroyEvent.setCancelled(true);
    HandlerList actualHandlerList = actualVehicleDestroyEvent.getHandlerList();
    Entity actualAttacker = actualVehicleDestroyEvent.getAttacker();
    HandlerList actualHandlers = actualVehicleDestroyEvent.getHandlers();
    boolean actualIsCancelledResult = actualVehicleDestroyEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualVehicleDestroyEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(attacker, actualAttacker);
    assertSame(vehicle, actualVehicleDestroyEvent.getVehicle());
  }
}
