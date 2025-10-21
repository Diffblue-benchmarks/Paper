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

class VehicleDamageEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleDamageEvent#VehicleDamageEvent(Vehicle, Entity, double)}
   *   <li>{@link VehicleDamageEvent#setCancelled(boolean)}
   *   <li>{@link VehicleDamageEvent#setDamage(double)}
   *   <li>{@link VehicleDamageEvent#getHandlerList()}
   *   <li>{@link VehicleDamageEvent#getAttacker()}
   *   <li>{@link VehicleDamageEvent#getDamage()}
   *   <li>{@link VehicleDamageEvent#getHandlers()}
   *   <li>{@link VehicleDamageEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleDamageEvent.<init>(Vehicle, Entity, double)",
    "Entity VehicleDamageEvent.getAttacker()",
    "double VehicleDamageEvent.getDamage()",
    "HandlerList VehicleDamageEvent.getHandlerList()",
    "HandlerList VehicleDamageEvent.getHandlers()",
    "boolean VehicleDamageEvent.isCancelled()",
    "void VehicleDamageEvent.setCancelled(boolean)",
    "void VehicleDamageEvent.setDamage(double)"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Entity attacker = mock(Entity.class);

    // Act
    VehicleDamageEvent actualVehicleDamageEvent = new VehicleDamageEvent(vehicle, attacker, 10.0d);
    actualVehicleDamageEvent.setCancelled(true);
    actualVehicleDamageEvent.setDamage(10.0d);
    HandlerList actualHandlerList = actualVehicleDamageEvent.getHandlerList();
    Entity actualAttacker = actualVehicleDamageEvent.getAttacker();
    double actualDamage = actualVehicleDamageEvent.getDamage();
    HandlerList actualHandlers = actualVehicleDamageEvent.getHandlers();
    boolean actualIsCancelledResult = actualVehicleDamageEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0d, actualDamage);
    assertFalse(actualVehicleDamageEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(attacker, actualAttacker);
    assertSame(vehicle, actualVehicleDamageEvent.getVehicle());
  }
}
