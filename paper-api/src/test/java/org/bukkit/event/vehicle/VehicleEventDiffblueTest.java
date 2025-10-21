package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleEventDiffblueTest {
  /**
   * Test {@link VehicleEvent#getVehicle()}.
   *
   * <p>Method under test: {@link VehicleEvent#getVehicle()}
   */
  @Test
  @DisplayName("Test getVehicle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vehicle VehicleEvent.getVehicle()"})
  void testGetVehicle() {
    // Arrange
    VehicleCreateEvent vehicleCreateEvent = new VehicleCreateEvent(mock(Vehicle.class));

    // Act
    Vehicle actualVehicle = vehicleCreateEvent.getVehicle();

    // Assert
    assertSame(vehicleCreateEvent.vehicle, actualVehicle);
  }
}
