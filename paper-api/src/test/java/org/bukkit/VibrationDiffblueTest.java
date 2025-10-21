package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.Vibration.Destination;
import org.bukkit.Vibration.Destination.BlockDestination;
import org.bukkit.Vibration.Destination.EntityDestination;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VibrationDiffblueTest {
  /**
   * Test Destination_BlockDestination {@link Destination.BlockDestination#getBlock()}.
   *
   * <ul>
   *   <li>Then calls {@link World#getBlockAt(Location)}.
   * </ul>
   *
   * <p>Method under test: {@link Destination.BlockDestination#getBlock()}
   */
  @Test
  @DisplayName("Test Destination_BlockDestination getBlock(); then calls getBlockAt(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block Destination.BlockDestination.getBlock()"})
  void testDestination_BlockDestinationGetBlock_thenCallsGetBlockAt() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(Mockito.<Location>any())).thenReturn(mock(Block.class));
    Location block = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act
    new BlockDestination(block).getBlock();

    // Assert
    verify(world).getBlockAt(isA(Location.class));
  }

  /**
   * Test Destination_BlockDestination {@link Destination.BlockDestination#getLocation()}.
   *
   * <p>Method under test: {@link Destination.BlockDestination#getLocation()}
   */
  @Test
  @DisplayName("Test Destination_BlockDestination getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Destination.BlockDestination.getLocation()"})
  void testDestination_BlockDestinationGetLocation() {
    // Arrange
    Location block = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(block, new BlockDestination(block).getLocation());
  }

  /**
   * Test Destination_BlockDestination {@link
   * Destination.BlockDestination#BlockDestination(Location)}.
   *
   * <p>Method under test: {@link Destination.BlockDestination#BlockDestination(Location)}
   */
  @Test
  @DisplayName("Test Destination_BlockDestination new BlockDestination(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Destination.BlockDestination.<init>(Location)"})
  void testDestination_BlockDestinationNewBlockDestination() {
    // Arrange
    Location block = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(block, new BlockDestination(block).getLocation());
  }

  /**
   * Test Destination_BlockDestination {@link Destination.BlockDestination#BlockDestination(Block)}.
   *
   * <p>Method under test: {@link Destination.BlockDestination#BlockDestination(Block)}
   */
  @Test
  @DisplayName("Test Destination_BlockDestination new BlockDestination(Block)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Destination.BlockDestination.<init>(Block)"})
  void testDestination_BlockDestinationNewBlockDestination2() {
    // Arrange
    Block block = mock(Block.class);
    Location deserializeResult = Location.deserialize(new HashMap<>());
    when(block.getLocation()).thenReturn(deserializeResult);

    // Act
    BlockDestination actualBlockDestination = new BlockDestination(block);

    // Assert
    verify(block).getLocation();
    assertEquals(deserializeResult, actualBlockDestination.getLocation());
  }

  /**
   * Test Destination_EntityDestination getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Destination.EntityDestination#EntityDestination(Entity)}
   *   <li>{@link Destination.EntityDestination#getEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test Destination_EntityDestination getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Destination.EntityDestination.<init>(Entity)",
    "Entity Destination.EntityDestination.getEntity()"
  })
  void testDestination_EntityDestinationGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act and Assert
    assertSame(entity, new EntityDestination(entity).getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Vibration#Vibration(Location, Destination, int)}
   *   <li>{@link Vibration#getArrivalTime()}
   *   <li>{@link Vibration#getDestination()}
   *   <li>{@link Vibration#getOrigin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Vibration.<init>(Location, Destination, int)",
    "int Vibration.getArrivalTime()",
    "Destination Vibration.getDestination()",
    "Location Vibration.getOrigin()"
  })
  void testGettersAndSetters() {
    // Arrange
    Location origin = Location.deserialize(new HashMap<>());
    Location block = Location.deserialize(new HashMap<>());
    BlockDestination destination = new BlockDestination(block);

    // Act
    Vibration actualVibration = new Vibration(origin, destination, 42);
    int actualArrivalTime = actualVibration.getArrivalTime();
    Destination actualDestination = actualVibration.getDestination();

    // Assert
    assertEquals(42, actualArrivalTime);
    assertSame(destination, actualDestination);
    assertSame(origin, actualVibration.getOrigin());
  }

  /**
   * Test {@link Vibration#Vibration(Destination, int)}.
   *
   * <p>Method under test: {@link Vibration#Vibration(Destination, int)}
   */
  @Test
  @DisplayName("Test new Vibration(Destination, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vibration.<init>(Destination, int)"})
  void testNewVibration() {
    // Arrange
    Location block = Location.deserialize(new HashMap<>());
    BlockDestination destination = new BlockDestination(block);

    // Act
    Vibration actualVibration = new Vibration(destination, 42);

    // Assert
    Destination destination2 = actualVibration.getDestination();
    assertTrue(destination2 instanceof BlockDestination);
    assertEquals(42, actualVibration.getArrivalTime());
    assertEquals(block, actualVibration.getOrigin());
    assertSame(destination, destination2);
  }
}
