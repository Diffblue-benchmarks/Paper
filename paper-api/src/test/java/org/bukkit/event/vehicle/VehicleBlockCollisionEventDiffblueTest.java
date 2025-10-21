package org.bukkit.event.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Vehicle;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VehicleBlockCollisionEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VehicleBlockCollisionEvent#VehicleBlockCollisionEvent(Vehicle, Block, Vector)}
   *   <li>{@link VehicleBlockCollisionEvent#getBlock()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VehicleBlockCollisionEvent.<init>(Vehicle, Block, Vector)",
    "Block VehicleBlockCollisionEvent.getBlock()"
  })
  void testGettersAndSetters() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Block block = mock(Block.class);

    // Act
    VehicleBlockCollisionEvent actualVehicleBlockCollisionEvent =
        new VehicleBlockCollisionEvent(vehicle, block, Vector.getRandom());
    Block actualBlock = actualVehicleBlockCollisionEvent.getBlock();

    // Assert
    assertFalse(actualVehicleBlockCollisionEvent.isAsynchronous());
    assertSame(block, actualBlock);
    assertSame(vehicle, actualVehicleBlockCollisionEvent.getVehicle());
  }

  /**
   * Test {@link VehicleBlockCollisionEvent#VehicleBlockCollisionEvent(Vehicle, Block)}.
   *
   * <p>Method under test: {@link VehicleBlockCollisionEvent#VehicleBlockCollisionEvent(Vehicle,
   * Block)}
   */
  @Test
  @DisplayName("Test new VehicleBlockCollisionEvent(Vehicle, Block)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VehicleBlockCollisionEvent.<init>(Vehicle, Block)"})
  void testNewVehicleBlockCollisionEvent() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Vector random = Vector.getRandom();
    when(vehicle.getVelocity()).thenReturn(random);
    Block block = mock(Block.class);

    // Act
    VehicleBlockCollisionEvent actualVehicleBlockCollisionEvent =
        new VehicleBlockCollisionEvent(vehicle, block);

    // Assert
    verify(vehicle).getVelocity();
    assertEquals("VehicleBlockCollisionEvent", actualVehicleBlockCollisionEvent.getEventName());
    assertEquals(0, actualVehicleBlockCollisionEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualVehicleBlockCollisionEvent.isAsynchronous());
    assertEquals(random, actualVehicleBlockCollisionEvent.getVelocity());
    assertSame(block, actualVehicleBlockCollisionEvent.getBlock());
    assertSame(vehicle, actualVehicleBlockCollisionEvent.getVehicle());
  }

  /**
   * Test {@link VehicleBlockCollisionEvent#getVelocity()}.
   *
   * <ul>
   *   <li>Given {@link Vehicle} {@link Vehicle#getVelocity()} return Random.
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link VehicleBlockCollisionEvent#getVelocity()}
   */
  @Test
  @DisplayName("Test getVelocity(); given Vehicle getVelocity() return Random; then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector VehicleBlockCollisionEvent.getVelocity()"})
  void testGetVelocity_givenVehicleGetVelocityReturnRandom_thenReturnRandom() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    Vector random = Vector.getRandom();
    when(vehicle.getVelocity()).thenReturn(random);
    VehicleBlockCollisionEvent vehicleBlockCollisionEvent =
        new VehicleBlockCollisionEvent(vehicle, mock(Block.class));

    // Act
    Vector actualVelocity = vehicleBlockCollisionEvent.getVelocity();

    // Assert
    verify(vehicle).getVelocity();
    assertEquals(random, actualVelocity);
  }

  /**
   * Test {@link VehicleBlockCollisionEvent#getVelocity()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link VehicleBlockCollisionEvent#getVelocity()}
   */
  @Test
  @DisplayName("Test getVelocity(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector VehicleBlockCollisionEvent.getVelocity()"})
  void testGetVelocity_thenReturnBlockVector() {
    // Arrange
    Vehicle vehicle = mock(Vehicle.class);
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 10.0d);
    when(vehicle.getVelocity()).thenReturn(blockVector);
    VehicleBlockCollisionEvent vehicleBlockCollisionEvent =
        new VehicleBlockCollisionEvent(vehicle, mock(Block.class));

    // Act
    Vector actualVelocity = vehicleBlockCollisionEvent.getVelocity();

    // Assert
    verify(vehicle).getVelocity();
    assertTrue(actualVelocity instanceof BlockVector);
    assertEquals(blockVector, actualVelocity);
  }
}
