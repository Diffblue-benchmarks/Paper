package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleExitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link LivingEntity}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleExitEvent#VehicleExitEvent(Vehicle, LivingEntity)}
   *   <li>{@link VehicleExitEvent#getHandlerList()}
   *   <li>{@link VehicleExitEvent#getExited()}
   *   <li>{@link VehicleExitEvent#getHandlers()}
   *   <li>{@link VehicleExitEvent#isCancellable()}
   *   <li>{@link VehicleExitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when LivingEntity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleExitEvent.<init>(Vehicle, LivingEntity)",
    "void VehicleExitEvent.<init>(Vehicle, LivingEntity, boolean)",
    "LivingEntity VehicleExitEvent.getExited()",
    "HandlerList VehicleExitEvent.getHandlerList()",
    "HandlerList VehicleExitEvent.getHandlers()",
    "boolean VehicleExitEvent.isCancellable()",
    "boolean VehicleExitEvent.isCancelled()"
  })
  void testGettersAndSetters_whenLivingEntity() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    LivingEntity exited = mock(LivingEntity.class);

    // Act
    VehicleExitEvent actualVehicleExitEvent = new VehicleExitEvent(vehicle, exited);
    HandlerList actualHandlerList = actualVehicleExitEvent.getHandlerList();
    LivingEntity actualExited = actualVehicleExitEvent.getExited();
    HandlerList actualHandlers = actualVehicleExitEvent.getHandlers();
    boolean actualIsCancellableResult = actualVehicleExitEvent.isCancellable();
    boolean actualIsCancelledResult = actualVehicleExitEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualVehicleExitEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualIsCancellableResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(exited, actualExited);
    assertSame(vehicle, actualVehicleExitEvent.getVehicle());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleExitEvent#VehicleExitEvent(Vehicle, LivingEntity, boolean)}
   *   <li>{@link VehicleExitEvent#getHandlerList()}
   *   <li>{@link VehicleExitEvent#getExited()}
   *   <li>{@link VehicleExitEvent#getHandlers()}
   *   <li>{@link VehicleExitEvent#isCancellable()}
   *   <li>{@link VehicleExitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleExitEvent.<init>(Vehicle, LivingEntity)",
    "void VehicleExitEvent.<init>(Vehicle, LivingEntity, boolean)",
    "LivingEntity VehicleExitEvent.getExited()",
    "HandlerList VehicleExitEvent.getHandlerList()",
    "HandlerList VehicleExitEvent.getHandlers()",
    "boolean VehicleExitEvent.isCancellable()",
    "boolean VehicleExitEvent.isCancelled()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    LivingEntity exited = mock(LivingEntity.class);

    // Act
    VehicleExitEvent actualVehicleExitEvent = new VehicleExitEvent(vehicle, exited, true);
    HandlerList actualHandlerList = actualVehicleExitEvent.getHandlerList();
    LivingEntity actualExited = actualVehicleExitEvent.getExited();
    HandlerList actualHandlers = actualVehicleExitEvent.getHandlers();
    boolean actualIsCancellableResult = actualVehicleExitEvent.isCancellable();
    boolean actualIsCancelledResult = actualVehicleExitEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualVehicleExitEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualIsCancellableResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(exited, actualExited);
    assertSame(vehicle, actualVehicleExitEvent.getVehicle());
  }

  /**
   * Test {@link VehicleExitEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link VehicleExitEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VehicleExitEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    VehicleExitEvent vehicleExitEvent =
        new VehicleExitEvent(mock(Vehicle.class), mock(LivingEntity.class));

    // Act
    vehicleExitEvent.setCancelled(false);

    // Assert that nothing has changed
    assertFalse(vehicleExitEvent.isCancelled());
  }

  /**
   * Test {@link VehicleExitEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link VehicleExitEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VehicleExitEvent.setCancelled(boolean)"})
  void testSetCancelled2() {
    // Arrange
    VehicleExitEvent vehicleExitEvent =
        new VehicleExitEvent(mock(Vehicle.class), mock(LivingEntity.class), false);

    // Act
    vehicleExitEvent.setCancelled(true);

    // Assert that nothing has changed
    assertFalse(vehicleExitEvent.isCancelled());
  }

  /**
   * Test {@link VehicleExitEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Then {@link VehicleExitEvent#VehicleExitEvent(Vehicle, LivingEntity)} with {@link
   *       Vehicle} and exited is {@link LivingEntity} Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link VehicleExitEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); then VehicleExitEvent(Vehicle, LivingEntity) with Vehicle and exited is LivingEntity Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VehicleExitEvent.setCancelled(boolean)"})
  void testSetCancelled_thenVehicleExitEventWithVehicleAndExitedIsLivingEntityCancelled() {
    // Arrange
    VehicleExitEvent vehicleExitEvent =
        new VehicleExitEvent(mock(Vehicle.class), mock(LivingEntity.class));

    // Act
    vehicleExitEvent.setCancelled(true);

    // Assert
    assertTrue(vehicleExitEvent.isCancelled());
  }
}
