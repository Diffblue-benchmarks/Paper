package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleMoveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleMoveEvent#VehicleMoveEvent(Vehicle, Location, Location)}
   *   <li>{@link VehicleMoveEvent#getHandlerList()}
   *   <li>{@link VehicleMoveEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleMoveEvent.<init>(Vehicle, Location, Location)",
    "HandlerList VehicleMoveEvent.getHandlerList()",
    "HandlerList VehicleMoveEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    VehicleMoveEvent actualVehicleMoveEvent = new VehicleMoveEvent(vehicle, from, resultTo);
    HandlerList actualHandlerList = actualVehicleMoveEvent.getHandlerList();
    HandlerList actualHandlers = actualVehicleMoveEvent.getHandlers();

    // Assert
    assertFalse(actualVehicleMoveEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(vehicle, actualVehicleMoveEvent.getVehicle());
  }

  /**
   * Test {@link VehicleMoveEvent#getFrom()}.
   *
   * <p>Method under test: {@link VehicleMoveEvent#getFrom()}
   */
  @Test
  @DisplayName("Test getFrom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location VehicleMoveEvent.getFrom()"})
  void testGetFrom() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    VehicleMoveEvent vehicleMoveEvent = new VehicleMoveEvent(vehicle, from, resultTo);

    // Act and Assert
    assertEquals(from, vehicleMoveEvent.getFrom());
  }

  /**
   * Test {@link VehicleMoveEvent#getTo()}.
   *
   * <p>Method under test: {@link VehicleMoveEvent#getTo()}
   */
  @Test
  @DisplayName("Test getTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location VehicleMoveEvent.getTo()"})
  void testGetTo() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    VehicleMoveEvent vehicleMoveEvent = new VehicleMoveEvent(vehicle, from, resultTo);

    // Act and Assert
    assertEquals(resultTo, vehicleMoveEvent.getTo());
  }
}
