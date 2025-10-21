package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.math.Rotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LocationDiffblueTest {
  /**
   * Test {@link Location#Location(World, double, double, double)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#Location(World, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test new Location(World, double, double, double); when 'null'; then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Location.<init>(World, double, double, double)"})
  void testNewLocation_whenNull_thenReturnWorldIsNull() {
    // Arrange and Act
    Location actualLocation = new Location(null, 2.0d, 3.0d, 10.0d);

    // Assert
    assertNull(actualLocation.getWorld());
    Vector direction = actualLocation.getDirection();
    BlockVector toBlockVectorResult = direction.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector toVectorResult = actualLocation.toVector();
    BlockVector toBlockVectorResult2 = toVectorResult.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector3i toVector3iResult = direction.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = toVectorResult.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = direction.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3f toVector3fResult = direction.toVector3f();
    Vector3f actualAbsoluteResult3 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult3);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult3 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult3);
    Vector3f toVector3fResult2 = toVectorResult.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3i actualAbsoluteResult5 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult5);
    Vector3i actualAbsoluteResult6 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult6);
  }

  /**
   * Test {@link Location#Location(World, double, double, double, float, float)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#Location(World, double, double, double, float, float)}
   */
  @Test
  @DisplayName(
      "Test new Location(World, double, double, double, float, float); when 'null'; then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Location.<init>(World, double, double, double, float, float)"})
  void testNewLocation_whenNull_thenReturnWorldIsNull2() {
    // Arrange and Act
    Location actualLocation = new Location(null, 2.0d, 3.0d, 10.0d, 10.0f, 10.0f);

    // Assert
    assertNull(actualLocation.getWorld());
    Vector direction = actualLocation.getDirection();
    assertEquals(
        direction.toBlockVector().toBlockVector(), direction.toBlockVector().toBlockVector());
    Vector toVectorResult = actualLocation.toVector();
    BlockVector toBlockVectorResult = toVectorResult.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3i toVector3iResult = toVectorResult.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = direction.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3f toVector3fResult = direction.toVector3f();
    Vector3f actualAbsoluteResult3 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult3);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult3 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult3);
    Vector3f toVector3fResult2 = toVectorResult.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3i toVector3iResult2 = direction.toVector3i();
    Vector3i actualAbsoluteResult5 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult5);
    Vector3i actualAbsoluteResult6 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult6);
  }

  /**
   * Test {@link Location#Location(World, double, double, double)}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then return Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#Location(World, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test new Location(World, double, double, double); when World; then return Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Location.<init>(World, double, double, double)"})
  void testNewLocation_whenWorld_thenReturnChunkIsNull() {
    // Arrange
    World world = mock(World.class);

    // Act
    Location actualLocation = new Location(world, 2.0d, 3.0d, 10.0d);

    // Assert
    assertNull(actualLocation.getChunk());
    assertNull(actualLocation.getBlock());
    assertSame(world, actualLocation.getWorld());
  }

  /**
   * Test {@link Location#Location(World, double, double, double, float, float)}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then return Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#Location(World, double, double, double, float, float)}
   */
  @Test
  @DisplayName(
      "Test new Location(World, double, double, double, float, float); when World; then return Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Location.<init>(World, double, double, double, float, float)"})
  void testNewLocation_whenWorld_thenReturnChunkIsNull2() {
    // Arrange
    World world = mock(World.class);

    // Act
    Location actualLocation = new Location(world, 2.0d, 3.0d, 10.0d, 10.0f, 10.0f);

    // Assert
    assertNull(actualLocation.getChunk());
    assertNull(actualLocation.getBlock());
    assertSame(world, actualLocation.getWorld());
  }

  /**
   * Test {@link Location#setWorld(World)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then deserialize {@link HashMap#HashMap()} World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#setWorld(World)}
   */
  @Test
  @DisplayName("Test setWorld(World); when 'null'; then deserialize HashMap() World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Location.setWorld(World)"})
  void testSetWorld_whenNull_thenDeserializeHashMapWorldIsNull() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    deserializeResult.setWorld(null);

    // Assert that nothing has changed
    assertNull(deserializeResult.getWorld());
  }

  /**
   * Test {@link Location#setWorld(World)}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then deserialize {@link HashMap#HashMap()} Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#setWorld(World)}
   */
  @Test
  @DisplayName("Test setWorld(World); when World; then deserialize HashMap() Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Location.setWorld(World)"})
  void testSetWorld_whenWorld_thenDeserializeHashMapChunkIsNull() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    World world = mock(World.class);

    // Act
    deserializeResult.setWorld(world);

    // Assert
    assertNull(deserializeResult.getChunk());
    assertNull(deserializeResult.getBlock());
    Location actualToHighestLocationResult = deserializeResult.toHighestLocation();
    assertEquals(deserializeResult, actualToHighestLocationResult);
    assertSame(world, deserializeResult.getWorld());
  }

  /**
   * Test {@link Location#isWorldLoaded()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isWorldLoaded()}
   */
  @Test
  @DisplayName("Test isWorldLoaded(); given deserialize HashMap(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isWorldLoaded()"})
  void testIsWorldLoaded_givenDeserializeHashMap_thenReturnFalse() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertFalse(deserializeResult.isWorldLoaded());
  }

  /**
   * Test {@link Location#isWorldLoaded()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isWorldLoaded()}
   */
  @Test
  @DisplayName("Test isWorldLoaded(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isWorldLoaded()"})
  void testIsWorldLoaded_thenThrowIllegalArgumentException() {
    // Arrange
    World world = mock(World.class);
    when(world.getUID()).thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.isWorldLoaded());
    verify(world).getUID();
  }

  /**
   * Test {@link Location#getWorld()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getWorld()}
   */
  @Test
  @DisplayName("Test getWorld(); given deserialize HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"World Location.getWorld()"})
  void testGetWorld_givenDeserializeHashMap_thenReturnNull() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertNull(deserializeResult.getWorld());
  }

  /**
   * Test {@link Location#getChunk()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getChunkAt(Location)} return {@link Chunk}.
   *   <li>Then calls {@link World#getChunkAt(Location)}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getChunk()}
   */
  @Test
  @DisplayName(
      "Test getChunk(); given World getChunkAt(Location) return Chunk; then calls getChunkAt(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Chunk Location.getChunk()"})
  void testGetChunk_givenWorldGetChunkAtReturnChunk_thenCallsGetChunkAt() {
    // Arrange
    World world = mock(World.class);
    when(world.getChunkAt(Mockito.<Location>any())).thenReturn(mock(Chunk.class));

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    location.getChunk();

    // Assert
    verify(world).getChunkAt(isA(Location.class));
  }

  /**
   * Test {@link Location#getBlock()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getBlockAt(Location)} return {@link Block}.
   *   <li>Then calls {@link World#getBlockAt(Location)}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlock()}
   */
  @Test
  @DisplayName(
      "Test getBlock(); given World getBlockAt(Location) return Block; then calls getBlockAt(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Block Location.getBlock()"})
  void testGetBlock_givenWorldGetBlockAtReturnBlock_thenCallsGetBlockAt() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(Mockito.<Location>any())).thenReturn(mock(Block.class));

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    location.getBlock();

    // Assert
    verify(world).getBlockAt(isA(Location.class));
  }

  /**
   * Test {@link Location#getBlockX()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlockX()}
   */
  @Test
  @DisplayName("Test getBlockX(); given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.getBlockX()"})
  void testGetBlockX_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0, deserializeResult.getBlockX());
  }

  /**
   * Test {@link Location#getBlockX()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()} add Random.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlockX()}
   */
  @Test
  @DisplayName("Test getBlockX(); given deserialize HashMap() add Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.getBlockX()"})
  void testGetBlockX_givenDeserializeHashMapAddRandom() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    deserializeResult.add(Vector.getRandom());

    // Act and Assert
    assertEquals(0, deserializeResult.getBlockX());
  }

  /**
   * Test {@link Location#getBlockY()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlockY()}
   */
  @Test
  @DisplayName("Test getBlockY(); given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.getBlockY()"})
  void testGetBlockY_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0, deserializeResult.getBlockY());
  }

  /**
   * Test {@link Location#getBlockY()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()} add Random.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlockY()}
   */
  @Test
  @DisplayName("Test getBlockY(); given deserialize HashMap() add Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.getBlockY()"})
  void testGetBlockY_givenDeserializeHashMapAddRandom() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    deserializeResult.add(Vector.getRandom());

    // Act and Assert
    assertEquals(0, deserializeResult.getBlockY());
  }

  /**
   * Test {@link Location#getBlockZ()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlockZ()}
   */
  @Test
  @DisplayName("Test getBlockZ(); given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.getBlockZ()"})
  void testGetBlockZ_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0, deserializeResult.getBlockZ());
  }

  /**
   * Test {@link Location#getBlockZ()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()} add Random.
   * </ul>
   *
   * <p>Method under test: {@link Location#getBlockZ()}
   */
  @Test
  @DisplayName("Test getBlockZ(); given deserialize HashMap() add Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.getBlockZ()"})
  void testGetBlockZ_givenDeserializeHashMapAddRandom() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    deserializeResult.add(Vector.getRandom());

    // Act and Assert
    assertEquals(0, deserializeResult.getBlockZ());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Location#setPitch(float)}
   *   <li>{@link Location#setX(double)}
   *   <li>{@link Location#setY(double)}
   *   <li>{@link Location#setYaw(float)}
   *   <li>{@link Location#setZ(double)}
   *   <li>{@link Location#getPitch()}
   *   <li>{@link Location#getX()}
   *   <li>{@link Location#getY()}
   *   <li>{@link Location#getYaw()}
   *   <li>{@link Location#getZ()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "float Location.getPitch()",
    "double Location.getX()",
    "double Location.getY()",
    "float Location.getYaw()",
    "double Location.getZ()",
    "void Location.setPitch(float)",
    "void Location.setX(double)",
    "void Location.setY(double)",
    "void Location.setYaw(float)",
    "void Location.setZ(double)"
  })
  void testGettersAndSetters() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    deserializeResult.setPitch(10.0f);
    deserializeResult.setX(2.0d);
    deserializeResult.setY(3.0d);
    deserializeResult.setYaw(10.0f);
    deserializeResult.setZ(10.0d);
    float actualPitch = deserializeResult.getPitch();
    double actualX = deserializeResult.getX();
    double actualY = deserializeResult.getY();
    float actualYaw = deserializeResult.getYaw();

    // Assert
    assertEquals(10.0d, deserializeResult.getZ());
    assertEquals(10.0f, actualPitch);
    assertEquals(10.0f, actualYaw);
    assertEquals(2.0d, actualX);
    assertEquals(3.0d, actualY);
  }

  /**
   * Test {@link Location#getDirection()}.
   *
   * <p>Method under test: {@link Location#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Location.getDirection()"})
  void testGetDirection() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Vector actualDirection = deserializeResult.getDirection();

    // Assert
    assertEquals(-0.0d, actualDirection.getX());
    assertEquals(-0.0d, actualDirection.getY());
    assertEquals(0, actualDirection.getBlockX());
    assertEquals(0, actualDirection.getBlockY());
    assertEquals(1, actualDirection.getBlockZ());
    assertEquals(1.0d, actualDirection.getZ());
    assertEquals(1.0d, actualDirection.length());
    assertFalse(actualDirection.isZero());
  }

  /**
   * Test {@link Location#setDirection(Vector)}.
   *
   * <p>Method under test: {@link Location#setDirection(Vector)}
   */
  @Test
  @DisplayName("Test setDirection(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setDirection(Vector)"})
  void testSetDirection() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSetDirectionResult = deserializeResult.setDirection(Vector.getRandom());

    // Assert
    Vector direction = actualSetDirectionResult.getDirection();
    BlockVector toBlockVectorResult = direction.toBlockVector();
    BlockVector toBlockVectorResult2 = toBlockVectorResult.toBlockVector();
    Vector toVectorResult = actualSetDirectionResult.toVector();
    assertEquals(toBlockVectorResult2, toVectorResult.toBlockVector());
    assertEquals(toBlockVectorResult2, toBlockVectorResult2);
    Vector3i toVector3iResult = direction.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d toVector3dResult = direction.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3f toVector3fResult = direction.toVector3f();
    Vector3f actualAbsoluteResult3 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult3);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult3 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult3);
    Vector3f toVector3fResult2 = toVectorResult.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3i actualAbsoluteResult5 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult5);
    Vector3i toVector3iResult2 = toVectorResult.toVector3i();
    Vector3i actualAbsoluteResult6 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult6);
  }

  /**
   * Test {@link Location#setDirection(Vector)}.
   *
   * <ul>
   *   <li>Then return Direction BlockY is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Location#setDirection(Vector)}
   */
  @Test
  @DisplayName("Test setDirection(Vector); then return Direction BlockY is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setDirection(Vector)"})
  void testSetDirection_thenReturnDirectionBlockYIsMinusOne() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    Vector vector = new Vector(0.0d, 0.0d, 0.0d);

    // Act
    Location actualSetDirectionResult = deserializeResult.setDirection(vector);

    // Assert
    Vector direction = actualSetDirectionResult.getDirection();
    assertEquals(-1, direction.getBlockY());
    Vector direction2 = deserializeResult.getDirection();
    assertEquals(-1, direction2.getBlockY());
    assertEquals(-1.0d, direction.getY());
    assertEquals(-1.0d, direction2.getY());
    assertEquals(90.0f, actualSetDirectionResult.getPitch());
    assertEquals(90.0f, deserializeResult.getPitch());
    assertEquals(vector, actualSetDirectionResult.toVector());
  }

  /**
   * Test {@link Location#setDirection(Vector)}.
   *
   * <ul>
   *   <li>Then return Pitch is {@code -25.522835}.
   * </ul>
   *
   * <p>Method under test: {@link Location#setDirection(Vector)}
   */
  @Test
  @DisplayName("Test setDirection(Vector); then return Pitch is '-25.522835'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setDirection(Vector)"})
  void testSetDirection_thenReturnPitchIs25522835() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSetDirectionResult =
        deserializeResult.setDirection(new Vector(-0.0d, 3.0d, 6.283185307179586d));

    // Assert
    assertEquals(-25.522835f, actualSetDirectionResult.getPitch());
    assertEquals(-25.522835f, deserializeResult.getPitch());
    Vector direction = actualSetDirectionResult.getDirection();
    assertEquals(0.43087078080445224d, direction.getY());
    Vector direction2 = deserializeResult.getDirection();
    assertEquals(0.43087078080445224d, direction2.getY());
    assertEquals(0.9024136358948494d, direction.getZ());
    assertEquals(0.9024136358948494d, direction2.getZ());
  }

  /**
   * Test {@link Location#setDirection(Vector)}.
   *
   * <ul>
   *   <li>Then return Pitch is minus ninety.
   * </ul>
   *
   * <p>Method under test: {@link Location#setDirection(Vector)}
   */
  @Test
  @DisplayName("Test setDirection(Vector); then return Pitch is minus ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setDirection(Vector)"})
  void testSetDirection_thenReturnPitchIsMinusNinety() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSetDirectionResult =
        deserializeResult.setDirection(new Vector(0.0d, 1.0E-10d, 0.0d));

    // Assert
    assertEquals(-90.0f, actualSetDirectionResult.getPitch());
    assertEquals(-90.0f, deserializeResult.getPitch());
    Vector direction = actualSetDirectionResult.getDirection();
    assertEquals(1, direction.getBlockY());
    Vector direction2 = deserializeResult.getDirection();
    assertEquals(1, direction2.getBlockY());
    assertEquals(1.0d, direction.getY());
    assertEquals(1.0d, direction2.getY());
  }

  /**
   * Test {@link Location#add(double, double, double)} with {@code double}, {@code double}, {@code
   * double}.
   *
   * <p>Method under test: {@link Location#add(double, double, double)}
   */
  @Test
  @DisplayName("Test add(double, double, double) with 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.add(double, double, double)"})
  void testAddWithDoubleDoubleDouble() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualAddResult = deserializeResult.add(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10, deserializeResult.getBlockZ());
    assertEquals(10.0d, deserializeResult.getZ());
    assertEquals(10.0d, deserializeResult.z());
    assertEquals(10.63014581273465d, deserializeResult.length());
    assertEquals(2, deserializeResult.getBlockX());
    assertEquals(2.0d, deserializeResult.getX());
    assertEquals(2.0d, deserializeResult.x());
    assertEquals(3, deserializeResult.getBlockY());
    assertEquals(3.0d, deserializeResult.getY());
    assertEquals(3.0d, deserializeResult.y());
    assertEquals(54043196870623234L, deserializeResult.toBlockKey());
    assertSame(deserializeResult, actualAddResult);
  }

  /**
   * Test {@link Location#add(Location, double, double, double)} with {@code Location}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link Location#add(Location, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test add(Location, double, double, double) with 'Location', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.add(Location, double, double, double)"})
  void testAddWithLocationDoubleDoubleDouble() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualAddResult =
        deserializeResult.add(Location.deserialize(new HashMap<>()), 2.0d, 3.0d, 10.0d);

    // Assert
    assertSame(deserializeResult, actualAddResult);
  }

  /**
   * Test {@link Location#add(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#add(Location)}
   */
  @Test
  @DisplayName(
      "Test add(Location) with 'Location'; given deserialize HashMap(); then return deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.add(Location)"})
  void testAddWithLocation_givenDeserializeHashMap_thenReturnDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualAddResult = deserializeResult.add(Location.deserialize(new HashMap<>()));

    // Assert
    assertSame(deserializeResult, actualAddResult);
  }

  /**
   * Test {@link Location#add(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Given {@link World}.
   * </ul>
   *
   * <p>Method under test: {@link Location#add(Location)}
   */
  @Test
  @DisplayName("Test add(Location) with 'Location'; given World")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.add(Location)"})
  void testAddWithLocation_givenWorld() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(null);

    Location vec = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    vec.setWorld(mock(World.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.add(vec));
  }

  /**
   * Test {@link Location#add(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#add(Location)}
   */
  @Test
  @DisplayName(
      "Test add(Location) with 'Location'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.add(Location)"})
  void testAddWithLocation_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.add((Location) null));
  }

  /**
   * Test {@link Location#add(Vector)} with {@code Vector}.
   *
   * <p>Method under test: {@link Location#add(Vector)}
   */
  @Test
  @DisplayName("Test add(Vector) with 'Vector'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.add(Vector)"})
  void testAddWithVector() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    Vector vec = Vector.getRandom();

    // Act
    Location actualAddResult = deserializeResult.add(vec);

    // Assert
    assertEquals(vec, deserializeResult.toVector());
    assertSame(deserializeResult, actualAddResult);
  }

  /**
   * Test {@link Location#createExplosion(float, boolean, boolean)} with {@code power}, {@code
   * setFire}, {@code breakBlocks}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(float, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(float, boolean, boolean) with 'power', 'setFire', 'breakBlocks'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(float, boolean, boolean)"})
  void testCreateExplosionWithPowerSetFireBreakBlocks_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(10.0f, true, true);

    // Assert
    verify(world).createExplosion(isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertFalse(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(float, boolean, boolean)} with {@code power}, {@code
   * setFire}, {@code breakBlocks}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(float, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(float, boolean, boolean) with 'power', 'setFire', 'breakBlocks'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(float, boolean, boolean)"})
  void testCreateExplosionWithPowerSetFireBreakBlocks_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(10.0f, true, true);

    // Assert
    verify(world).createExplosion(isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertTrue(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(float, boolean)} with {@code power}, {@code setFire}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(float, boolean)}
   */
  @Test
  @DisplayName("Test createExplosion(float, boolean) with 'power', 'setFire'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(float, boolean)"})
  void testCreateExplosionWithPowerSetFire_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(Mockito.<Location>any(), anyFloat(), anyBoolean()))
        .thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(10.0f, true);

    // Assert
    verify(world).createExplosion(isA(Location.class), eq(10.0f), eq(true));
    assertFalse(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(float, boolean)} with {@code power}, {@code setFire}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(float, boolean)}
   */
  @Test
  @DisplayName("Test createExplosion(float, boolean) with 'power', 'setFire'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(float, boolean)"})
  void testCreateExplosionWithPowerSetFire_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(Mockito.<Location>any(), anyFloat(), anyBoolean())).thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(10.0f, true);

    // Assert
    verify(world).createExplosion(isA(Location.class), eq(10.0f), eq(true));
    assertTrue(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(float)} with {@code power}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#createExplosion(Location, float)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(float)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(float) with 'power'; given World createExplosion(Location, float) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(float)"})
  void testCreateExplosionWithPower_givenWorldCreateExplosionReturnTrue_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(Mockito.<Location>any(), anyFloat())).thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(10.0f);

    // Assert
    verify(world).createExplosion(isA(Location.class), eq(10.0f));
    assertTrue(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(float)} with {@code power}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(float)}
   */
  @Test
  @DisplayName("Test createExplosion(float) with 'power'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(float)"})
  void testCreateExplosionWithPower_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(Mockito.<Location>any(), anyFloat())).thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(10.0f);

    // Assert
    verify(world).createExplosion(isA(Location.class), eq(10.0f));
    assertFalse(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(Entity, float, boolean, boolean)} with {@code source},
   * {@code power}, {@code setFire}, {@code breakBlocks}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(Entity, float, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(Entity, float, boolean, boolean) with 'source', 'power', 'setFire', 'breakBlocks'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(Entity, float, boolean, boolean)"})
  void testCreateExplosionWithSourcePowerSetFireBreakBlocks_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(
            Mockito.<Entity>any(), Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult =
        location.createExplosion(mock(Entity.class), 10.0f, true, true);

    // Assert
    verify(world)
        .createExplosion(isA(Entity.class), isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertFalse(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(Entity, float, boolean, boolean)} with {@code source},
   * {@code power}, {@code setFire}, {@code breakBlocks}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(Entity, float, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(Entity, float, boolean, boolean) with 'source', 'power', 'setFire', 'breakBlocks'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(Entity, float, boolean, boolean)"})
  void testCreateExplosionWithSourcePowerSetFireBreakBlocks_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(
            Mockito.<Entity>any(), Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult =
        location.createExplosion(mock(Entity.class), 10.0f, true, true);

    // Assert
    verify(world)
        .createExplosion(isA(Entity.class), isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertTrue(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(Entity, float, boolean)} with {@code source}, {@code
   * power}, {@code setFire}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(Entity, float, boolean)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(Entity, float, boolean) with 'source', 'power', 'setFire'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(Entity, float, boolean)"})
  void testCreateExplosionWithSourcePowerSetFire_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(
            Mockito.<Entity>any(), Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(mock(Entity.class), 10.0f, true);

    // Assert
    verify(world)
        .createExplosion(isA(Entity.class), isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertFalse(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(Entity, float, boolean)} with {@code source}, {@code
   * power}, {@code setFire}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(Entity, float, boolean)}
   */
  @Test
  @DisplayName(
      "Test createExplosion(Entity, float, boolean) with 'source', 'power', 'setFire'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(Entity, float, boolean)"})
  void testCreateExplosionWithSourcePowerSetFire_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(
            Mockito.<Entity>any(), Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(mock(Entity.class), 10.0f, true);

    // Assert
    verify(world)
        .createExplosion(isA(Entity.class), isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertTrue(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(Entity, float)} with {@code source}, {@code power}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(Entity, float)}
   */
  @Test
  @DisplayName("Test createExplosion(Entity, float) with 'source', 'power'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(Entity, float)"})
  void testCreateExplosionWithSourcePower_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(
            Mockito.<Entity>any(), Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(mock(Entity.class), 10.0f);

    // Assert
    verify(world)
        .createExplosion(isA(Entity.class), isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertFalse(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#createExplosion(Entity, float)} with {@code source}, {@code power}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#createExplosion(Entity, float)}
   */
  @Test
  @DisplayName("Test createExplosion(Entity, float) with 'source', 'power'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.createExplosion(Entity, float)"})
  void testCreateExplosionWithSourcePower_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.createExplosion(
            Mockito.<Entity>any(), Mockito.<Location>any(), anyFloat(), anyBoolean(), anyBoolean()))
        .thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualCreateExplosionResult = location.createExplosion(mock(Entity.class), 10.0f);

    // Assert
    verify(world)
        .createExplosion(isA(Entity.class), isA(Location.class), eq(10.0f), eq(true), eq(true));
    assertTrue(actualCreateExplosionResult);
  }

  /**
   * Test {@link Location#getNearbyEntities(double, double, double)}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyEntities(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyEntities(double, double, double); given deserialize HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyEntities(double, double, double)"})
  void testGetNearbyEntities_givenDeserializeHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyEntities(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link Location#getNearbyEntities(double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getNearbyEntities(Location, double, double, double)}
   *       return {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyEntities(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyEntities(double, double, double); given World getNearbyEntities(Location, double, double, double) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyEntities(double, double, double)"})
  void testGetNearbyEntities_givenWorldGetNearbyEntitiesReturnArrayList_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntities(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Entity> actualNearbyEntities = location.getNearbyEntities(2.0d, 3.0d, 10.0d);

    // Assert
    verify(world).getNearbyEntities(isA(Location.class), eq(2.0d), eq(3.0d), eq(10.0d));
    assertTrue(actualNearbyEntities instanceof List);
    assertTrue(actualNearbyEntities.isEmpty());
    assertSame(entityList, actualNearbyEntities);
  }

  /**
   * Test {@link Location#getNearbyEntities(double, double, double)}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getNearbyEntities(Location, double, double, double)}
   *       throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyEntities(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyEntities(double, double, double); given World getNearbyEntities(Location, double, double, double) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyEntities(double, double, double)"})
  void testGetNearbyEntities_givenWorldGetNearbyEntitiesThrowIllegalArgumentException() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntities(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyEntities(2.0d, 3.0d, 10.0d));
    verify(world).getNearbyEntities(isA(Location.class), eq(2.0d), eq(3.0d), eq(10.0d));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double)} with {@code radius}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double)}
   */
  @Test
  @DisplayName("Test getNearbyLivingEntities(double) with 'radius'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double)"})
  void testGetNearbyLivingEntitiesWithRadius() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.getNearbyLivingEntities(10.0d));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, Predicate)} with {@code radius}, {@code
   * predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, Predicate)}
   */
  @Test
  @DisplayName("Test getNearbyLivingEntities(double, Predicate) with 'radius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, Predicate)"})
  void testGetNearbyLivingEntitiesWithRadiusPredicate() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyLivingEntities(10.0d, null));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, Predicate)} with {@code radius}, {@code
   * predicate}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, Predicate) with 'radius', 'predicate'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, Predicate)"})
  void testGetNearbyLivingEntitiesWithRadiusPredicate_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyLivingEntities(10.0d, mock(Predicate.class)));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, Predicate)} with {@code radius}, {@code
   * predicate}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, Predicate) with 'radius', 'predicate'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, Predicate)"})
  void testGetNearbyLivingEntitiesWithRadiusPredicate_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<LivingEntity> actualNearbyLivingEntities =
        location.getNearbyLivingEntities(10.0d, null);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyLivingEntities instanceof List);
    assertTrue(actualNearbyLivingEntities.isEmpty());
    assertSame(entityList, actualNearbyLivingEntities);
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double)} with {@code radius}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double)}
   */
  @Test
  @DisplayName("Test getNearbyLivingEntities(double) with 'radius'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double)"})
  void testGetNearbyLivingEntitiesWithRadius_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> deserializeResult.getNearbyLivingEntities(10.0d));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double)} with {@code radius}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double)}
   */
  @Test
  @DisplayName("Test getNearbyLivingEntities(double) with 'radius'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double)"})
  void testGetNearbyLivingEntitiesWithRadius_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<LivingEntity> actualNearbyLivingEntities = location.getNearbyLivingEntities(10.0d);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyLivingEntities instanceof List);
    assertTrue(actualNearbyLivingEntities.isEmpty());
    assertSame(entityList, actualNearbyLivingEntities);
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, double)} with {@code xRadius},
   * {@code yRadius}, {@code zRadius}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, double) with 'xRadius', 'yRadius', 'zRadius'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double, double)"})
  void testGetNearbyLivingEntitiesWithXRadiusYRadiusZRadius() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> location.getNearbyLivingEntities(10.0d, 10.0d, 10.0d));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, double, Predicate)} with {@code
   * xRadius}, {@code yRadius}, {@code zRadius}, {@code predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, double,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, double, Predicate) with 'xRadius', 'yRadius', 'zRadius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection Location.getNearbyLivingEntities(double, double, double, Predicate)"
  })
  void testGetNearbyLivingEntitiesWithXRadiusYRadiusZRadiusPredicate() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            deserializeResult.getNearbyLivingEntities(10.0d, 10.0d, 10.0d, mock(Predicate.class)));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, double, Predicate)} with {@code
   * xRadius}, {@code yRadius}, {@code zRadius}, {@code predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, double,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, double, Predicate) with 'xRadius', 'yRadius', 'zRadius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection Location.getNearbyLivingEntities(double, double, double, Predicate)"
  })
  void testGetNearbyLivingEntitiesWithXRadiusYRadiusZRadiusPredicate2() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> location.getNearbyLivingEntities(10.0d, 10.0d, 10.0d, null));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, double, Predicate)} with {@code
   * xRadius}, {@code yRadius}, {@code zRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, double,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, double, Predicate) with 'xRadius', 'yRadius', 'zRadius', 'predicate'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection Location.getNearbyLivingEntities(double, double, double, Predicate)"
  })
  void testGetNearbyLivingEntitiesWithXRadiusYRadiusZRadiusPredicate_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<LivingEntity> actualNearbyLivingEntities =
        location.getNearbyLivingEntities(10.0d, 10.0d, 10.0d, null);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyLivingEntities instanceof List);
    assertTrue(actualNearbyLivingEntities.isEmpty());
    assertSame(entityList, actualNearbyLivingEntities);
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, double)} with {@code xRadius},
   * {@code yRadius}, {@code zRadius}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, double) with 'xRadius', 'yRadius', 'zRadius'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double, double)"})
  void testGetNearbyLivingEntitiesWithXRadiusYRadiusZRadius_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyLivingEntities(10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, double)} with {@code xRadius},
   * {@code yRadius}, {@code zRadius}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, double) with 'xRadius', 'yRadius', 'zRadius'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double, double)"})
  void testGetNearbyLivingEntitiesWithXRadiusYRadiusZRadius_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<LivingEntity> actualNearbyLivingEntities =
        location.getNearbyLivingEntities(10.0d, 10.0d, 10.0d);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyLivingEntities instanceof List);
    assertTrue(actualNearbyLivingEntities.isEmpty());
    assertSame(entityList, actualNearbyLivingEntities);
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double)} with {@code xzRadius}, {@code
   * yRadius}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double)}
   */
  @Test
  @DisplayName("Test getNearbyLivingEntities(double, double) with 'xzRadius', 'yRadius'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double)"})
  void testGetNearbyLivingEntitiesWithXzRadiusYRadius() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyLivingEntities(10.0d, 10.0d));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, Predicate)} with {@code xzRadius},
   * {@code yRadius}, {@code predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, Predicate) with 'xzRadius', 'yRadius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double, Predicate)"})
  void testGetNearbyLivingEntitiesWithXzRadiusYRadiusPredicate() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyLivingEntities(10.0d, 10.0d, null));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, Predicate)} with {@code xzRadius},
   * {@code yRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, Predicate) with 'xzRadius', 'yRadius', 'predicate'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double, Predicate)"})
  void testGetNearbyLivingEntitiesWithXzRadiusYRadiusPredicate_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyLivingEntities(10.0d, 10.0d, mock(Predicate.class)));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double, Predicate)} with {@code xzRadius},
   * {@code yRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double, Predicate) with 'xzRadius', 'yRadius', 'predicate'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double, Predicate)"})
  void testGetNearbyLivingEntitiesWithXzRadiusYRadiusPredicate_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<LivingEntity> actualNearbyLivingEntities =
        location.getNearbyLivingEntities(10.0d, 10.0d, null);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyLivingEntities instanceof List);
    assertTrue(actualNearbyLivingEntities.isEmpty());
    assertSame(entityList, actualNearbyLivingEntities);
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double)} with {@code xzRadius}, {@code
   * yRadius}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double) with 'xzRadius', 'yRadius'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double)"})
  void testGetNearbyLivingEntitiesWithXzRadiusYRadius_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyLivingEntities(10.0d, 10.0d));
  }

  /**
   * Test {@link Location#getNearbyLivingEntities(double, double)} with {@code xzRadius}, {@code
   * yRadius}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyLivingEntities(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyLivingEntities(double, double) with 'xzRadius', 'yRadius'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyLivingEntities(double, double)"})
  void testGetNearbyLivingEntitiesWithXzRadiusYRadius_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<LivingEntity> actualNearbyLivingEntities =
        location.getNearbyLivingEntities(10.0d, 10.0d);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyLivingEntities instanceof List);
    assertTrue(actualNearbyLivingEntities.isEmpty());
    assertSame(entityList, actualNearbyLivingEntities);
  }

  /**
   * Test {@link Location#getNearbyPlayers(double)} with {@code radius}.
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double) with 'radius'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double)"})
  void testGetNearbyPlayersWithRadius() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.getNearbyPlayers(10.0d));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, Predicate)} with {@code radius}, {@code
   * predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, Predicate)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double, Predicate) with 'radius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, Predicate)"})
  void testGetNearbyPlayersWithRadiusPredicate() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.getNearbyPlayers(10.0d, null));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, Predicate)} with {@code radius}, {@code
   * predicate}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>When {@link Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, Predicate) with 'radius', 'predicate'; given deserialize HashMap(); when Predicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, Predicate)"})
  void testGetNearbyPlayersWithRadiusPredicate_givenDeserializeHashMap_whenPredicate() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyPlayers(10.0d, mock(Predicate.class)));
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, Predicate)} with {@code radius}, {@code
   * predicate}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, Predicate) with 'radius', 'predicate'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, Predicate)"})
  void testGetNearbyPlayersWithRadiusPredicate_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Player> actualNearbyPlayers = location.getNearbyPlayers(10.0d, null);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyPlayers instanceof List);
    assertTrue(actualNearbyPlayers.isEmpty());
    assertSame(entityList, actualNearbyPlayers);
  }

  /**
   * Test {@link Location#getNearbyPlayers(double)} with {@code radius}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double) with 'radius'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double)"})
  void testGetNearbyPlayersWithRadius_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> deserializeResult.getNearbyPlayers(10.0d));
  }

  /**
   * Test {@link Location#getNearbyPlayers(double)} with {@code radius}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double) with 'radius'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double)"})
  void testGetNearbyPlayersWithRadius_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Player> actualNearbyPlayers = location.getNearbyPlayers(10.0d);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyPlayers instanceof List);
    assertTrue(actualNearbyPlayers.isEmpty());
    assertSame(entityList, actualNearbyPlayers);
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, double)} with {@code xRadius}, {@code
   * yRadius}, {@code zRadius}.
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, double)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double, double, double) with 'xRadius', 'yRadius', 'zRadius'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, double)"})
  void testGetNearbyPlayersWithXRadiusYRadiusZRadius() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyPlayers(10.0d, 10.0d, 10.0d));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, double, Predicate)} with {@code xRadius},
   * {@code yRadius}, {@code zRadius}, {@code predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, double, Predicate) with 'xRadius', 'yRadius', 'zRadius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, double, Predicate)"})
  void testGetNearbyPlayersWithXRadiusYRadiusZRadiusPredicate() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyPlayers(10.0d, 10.0d, 10.0d, null));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, double, Predicate)} with {@code xRadius},
   * {@code yRadius}, {@code zRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, double, Predicate) with 'xRadius', 'yRadius', 'zRadius', 'predicate'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, double, Predicate)"})
  void testGetNearbyPlayersWithXRadiusYRadiusZRadiusPredicate_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyPlayers(10.0d, 10.0d, 10.0d, mock(Predicate.class)));
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, double, Predicate)} with {@code xRadius},
   * {@code yRadius}, {@code zRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, double, Predicate) with 'xRadius', 'yRadius', 'zRadius', 'predicate'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, double, Predicate)"})
  void testGetNearbyPlayersWithXRadiusYRadiusZRadiusPredicate_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Player> actualNearbyPlayers = location.getNearbyPlayers(10.0d, 10.0d, 10.0d, null);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyPlayers instanceof List);
    assertTrue(actualNearbyPlayers.isEmpty());
    assertSame(entityList, actualNearbyPlayers);
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, double)} with {@code xRadius}, {@code
   * yRadius}, {@code zRadius}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, double) with 'xRadius', 'yRadius', 'zRadius'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, double)"})
  void testGetNearbyPlayersWithXRadiusYRadiusZRadius_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyPlayers(10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, double)} with {@code xRadius}, {@code
   * yRadius}, {@code zRadius}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, double) with 'xRadius', 'yRadius', 'zRadius'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, double)"})
  void testGetNearbyPlayersWithXRadiusYRadiusZRadius_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Player> actualNearbyPlayers = location.getNearbyPlayers(10.0d, 10.0d, 10.0d);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyPlayers instanceof List);
    assertTrue(actualNearbyPlayers.isEmpty());
    assertSame(entityList, actualNearbyPlayers);
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double)} with {@code xzRadius}, {@code yRadius}.
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double, double) with 'xzRadius', 'yRadius'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double)"})
  void testGetNearbyPlayersWithXzRadiusYRadius() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.getNearbyPlayers(10.0d, 10.0d));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, Predicate)} with {@code xzRadius}, {@code
   * yRadius}, {@code predicate}.
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, Predicate) with 'xzRadius', 'yRadius', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, Predicate)"})
  void testGetNearbyPlayersWithXzRadiusYRadiusPredicate() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> location.getNearbyPlayers(10.0d, 10.0d, null));
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, Predicate)} with {@code xzRadius}, {@code
   * yRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, Predicate) with 'xzRadius', 'yRadius', 'predicate'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, Predicate)"})
  void testGetNearbyPlayersWithXzRadiusYRadiusPredicate_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> deserializeResult.getNearbyPlayers(10.0d, 10.0d, mock(Predicate.class)));
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double, Predicate)} with {@code xzRadius}, {@code
   * yRadius}, {@code predicate}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double, Predicate)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double, Predicate) with 'xzRadius', 'yRadius', 'predicate'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double, Predicate)"})
  void testGetNearbyPlayersWithXzRadiusYRadiusPredicate_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Player> actualNearbyPlayers = location.getNearbyPlayers(10.0d, 10.0d, null);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyPlayers instanceof List);
    assertTrue(actualNearbyPlayers.isEmpty());
    assertSame(entityList, actualNearbyPlayers);
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double)} with {@code xzRadius}, {@code yRadius}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNearbyPlayers(double, double) with 'xzRadius', 'yRadius'; given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double)"})
  void testGetNearbyPlayersWithXzRadiusYRadius_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> deserializeResult.getNearbyPlayers(10.0d, 10.0d));
  }

  /**
   * Test {@link Location#getNearbyPlayers(double, double)} with {@code xzRadius}, {@code yRadius}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link Location#getNearbyPlayers(double, double)}
   */
  @Test
  @DisplayName("Test getNearbyPlayers(double, double) with 'xzRadius', 'yRadius'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Location.getNearbyPlayers(double, double)"})
  void testGetNearbyPlayersWithXzRadiusYRadius_thenReturnList() {
    // Arrange
    World world = mock(World.class);
    ArrayList<Entity> entityList = new ArrayList<>();
    when(world.getNearbyEntitiesByType(
            Mockito.<Class<Entity>>any(),
            Mockito.<Location>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Predicate<Entity>>any()))
        .thenReturn(entityList);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    Collection<Player> actualNearbyPlayers = location.getNearbyPlayers(10.0d, 10.0d);

    // Assert
    verify(world)
        .getNearbyEntitiesByType(
            isA(Class.class), isA(Location.class), eq(10.0d), eq(10.0d), eq(10.0d), isNull());
    assertTrue(actualNearbyPlayers instanceof List);
    assertTrue(actualNearbyPlayers.isEmpty());
    assertSame(entityList, actualNearbyPlayers);
  }

  /**
   * Test {@link Location#toVector()}.
   *
   * <p>Method under test: {@link Location#toVector()}
   */
  @Test
  @DisplayName("Test toVector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Location.toVector()"})
  void testToVector() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Vector actualToVectorResult = deserializeResult.toVector();

    // Assert
    assertEquals(0, actualToVectorResult.getBlockX());
    assertEquals(0, actualToVectorResult.getBlockY());
    assertEquals(0, actualToVectorResult.getBlockZ());
    assertEquals(0.0d, actualToVectorResult.getX());
    assertEquals(0.0d, actualToVectorResult.getY());
    assertEquals(0.0d, actualToVectorResult.getZ());
    assertEquals(0.0d, actualToVectorResult.length());
    assertTrue(actualToVectorResult.isZero());
  }

  /**
   * Test {@link Location#clone()}.
   *
   * <p>Method under test: {@link Location#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.clone()"})
  void testClone() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualCloneResult = deserializeResult.clone();

    // Assert
    assertEquals(deserializeResult, actualCloneResult);
  }

  /**
   * Test {@link Location#locToBlock(double)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Location#locToBlock(double)}
   */
  @Test
  @DisplayName("Test locToBlock(double); when '0.5'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.locToBlock(double)"})
  void testLocToBlock_when05_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Location.locToBlock(0.5d));
  }

  /**
   * Test {@link Location#locToBlock(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link Location#locToBlock(double)}
   */
  @Test
  @DisplayName("Test locToBlock(double); when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Location.locToBlock(double)"})
  void testLocToBlock_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, Location.locToBlock(10.0d));
  }

  /**
   * Test {@link Location#normalizeYaw(float)}.
   *
   * <ul>
   *   <li>When one hundred eighty.
   *   <li>Then return minus one hundred eighty.
   * </ul>
   *
   * <p>Method under test: {@link Location#normalizeYaw(float)}
   */
  @Test
  @DisplayName(
      "Test normalizeYaw(float); when one hundred eighty; then return minus one hundred eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Location.normalizeYaw(float)"})
  void testNormalizeYaw_whenOneHundredEighty_thenReturnMinusOneHundredEighty() {
    // Arrange, Act and Assert
    assertEquals(-180.0f, Location.normalizeYaw(180.0f));
  }

  /**
   * Test {@link Location#normalizeYaw(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link Location#normalizeYaw(float)}
   */
  @Test
  @DisplayName("Test normalizeYaw(float); when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Location.normalizeYaw(float)"})
  void testNormalizeYaw_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, Location.normalizeYaw(10.0f));
  }

  /**
   * Test {@link Location#normalizePitch(float)}.
   *
   * <ul>
   *   <li>When {@code -90.00001}.
   *   <li>Then return minus ninety.
   * </ul>
   *
   * <p>Method under test: {@link Location#normalizePitch(float)}
   */
  @Test
  @DisplayName("Test normalizePitch(float); when '-90.00001'; then return minus ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Location.normalizePitch(float)"})
  void testNormalizePitch_when9000001_thenReturnMinusNinety() {
    // Arrange, Act and Assert
    assertEquals(-90.0f, Location.normalizePitch(-90.00001f));
  }

  /**
   * Test {@link Location#normalizePitch(float)}.
   *
   * <ul>
   *   <li>When {@code 90.00001}.
   *   <li>Then return ninety.
   * </ul>
   *
   * <p>Method under test: {@link Location#normalizePitch(float)}
   */
  @Test
  @DisplayName("Test normalizePitch(float); when '90.00001'; then return ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Location.normalizePitch(float)"})
  void testNormalizePitch_when9000001_thenReturnNinety() {
    // Arrange, Act and Assert
    assertEquals(90.0f, Location.normalizePitch(90.00001f));
  }

  /**
   * Test {@link Location#normalizePitch(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link Location#normalizePitch(float)}
   */
  @Test
  @DisplayName("Test normalizePitch(float); when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Location.normalizePitch(float)"})
  void testNormalizePitch_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, Location.normalizePitch(10.0f));
  }

  /**
   * Test {@link Location#x()}.
   *
   * <p>Method under test: {@link Location#x()}
   */
  @Test
  @DisplayName("Test x()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Location.x()"})
  void testX() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, deserializeResult.x());
  }

  /**
   * Test {@link Location#y()}.
   *
   * <p>Method under test: {@link Location#y()}
   */
  @Test
  @DisplayName("Test y()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Location.y()"})
  void testY() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, deserializeResult.y());
  }

  /**
   * Test {@link Location#z()}.
   *
   * <p>Method under test: {@link Location#z()}
   */
  @Test
  @DisplayName("Test z()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Location.z()"})
  void testZ() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, deserializeResult.z());
  }

  /**
   * Test {@link Location#isFinite()}.
   *
   * <p>Method under test: {@link Location#isFinite()}
   */
  @Test
  @DisplayName("Test isFinite()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isFinite()"})
  void testIsFinite() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d, Float.NaN, 10.0f);

    // Act and Assert
    assertFalse(location.isFinite());
  }

  /**
   * Test {@link Location#isFinite()}.
   *
   * <p>Method under test: {@link Location#isFinite()}
   */
  @Test
  @DisplayName("Test isFinite()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isFinite()"})
  void testIsFinite2() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d, 10.0f, Float.NaN);

    // Act and Assert
    assertFalse(location.isFinite());
  }

  /**
   * Test {@link Location#isFinite()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isFinite()}
   */
  @Test
  @DisplayName("Test isFinite(); given deserialize HashMap(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isFinite()"})
  void testIsFinite_givenDeserializeHashMap_thenReturnTrue() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertTrue(deserializeResult.isFinite());
  }

  /**
   * Test {@link Location#isFinite()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@link Double#NaN} and y is three and z is ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isFinite()}
   */
  @Test
  @DisplayName(
      "Test isFinite(); given Location(World, double, double, double) with World and x is NaN and y is three and z is ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isFinite()"})
  void testIsFinite_givenLocationWithWorldAndXIsNaNAndYIsThreeAndZIsTen_thenReturnFalse() {
    // Arrange
    Location location = new Location(mock(World.class), Double.NaN, 3.0d, 10.0d);

    // Act and Assert
    assertFalse(location.isFinite());
  }

  /**
   * Test {@link Location#isFinite()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is {@link Double#NaN} and z is ten.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isFinite()}
   */
  @Test
  @DisplayName(
      "Test isFinite(); given Location(World, double, double, double) with World and x is two and y is NaN and z is ten; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isFinite()"})
  void testIsFinite_givenLocationWithWorldAndXIsTwoAndYIsNaNAndZIsTen_thenReturnFalse() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, Double.NaN, 10.0d);

    // Act and Assert
    assertFalse(location.isFinite());
  }

  /**
   * Test {@link Location#isFinite()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is {@link Double#NaN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isFinite()}
   */
  @Test
  @DisplayName(
      "Test isFinite(); given Location(World, double, double, double) with World and x is two and y is three and z is NaN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isFinite()"})
  void testIsFinite_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsNaN_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Location(mock(World.class), 2.0d, 3.0d, Double.NaN).isFinite());
  }

  /**
   * Test {@link Location#toLocation(World)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#toLocation(World)}
   */
  @Test
  @DisplayName("Test toLocation(World); when 'null'; then return deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.toLocation(World)"})
  void testToLocation_whenNull_thenReturnDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualToLocationResult = deserializeResult.toLocation(null);

    // Assert
    assertEquals(deserializeResult, actualToLocationResult);
  }

  /**
   * Test {@link Location#toLocation(World)}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then return Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#toLocation(World)}
   */
  @Test
  @DisplayName("Test toLocation(World); when World; then return Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.toLocation(World)"})
  void testToLocation_whenWorld_thenReturnChunkIsNull() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    World world = mock(World.class);

    // Act
    Location actualToLocationResult = deserializeResult.toLocation(world);

    // Assert
    assertNull(actualToLocationResult.getChunk());
    assertNull(actualToLocationResult.getBlock());
    Location actualToHighestLocationResult = actualToLocationResult.toHighestLocation();
    assertEquals(actualToLocationResult, actualToHighestLocationResult);
    assertSame(world, actualToLocationResult.getWorld());
  }

  /**
   * Test {@link Location#addRotation(Rotation)} with {@code rotation}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then deserialize {@link HashMap#HashMap()} Pitch is ten.
   * </ul>
   *
   * <p>Method under test: {@link Location#addRotation(Rotation)}
   */
  @Test
  @DisplayName(
      "Test addRotation(Rotation) with 'rotation'; given ten; then deserialize HashMap() Pitch is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.addRotation(Rotation)"})
  void testAddRotationWithRotation_givenTen_thenDeserializeHashMapPitchIsTen() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    Rotation rotation = mock(Rotation.class);
    when(rotation.pitch()).thenReturn(10.0f);
    when(rotation.yaw()).thenReturn(10.0f);

    // Act
    Location actualAddRotationResult = deserializeResult.addRotation(rotation);

    // Assert
    verify(rotation).pitch();
    verify(rotation).yaw();
    assertEquals(10.0f, deserializeResult.getPitch());
    assertEquals(10.0f, deserializeResult.getYaw());
    assertSame(deserializeResult, actualAddRotationResult);
  }

  /**
   * Test {@link Location#addRotation(Rotation)} with {@code rotation}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#addRotation(Rotation)}
   */
  @Test
  @DisplayName("Test addRotation(Rotation) with 'rotation'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.addRotation(Rotation)"})
  void testAddRotationWithRotation_thenThrowIllegalArgumentException() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    Rotation rotation = mock(Rotation.class);
    when(rotation.yaw()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> deserializeResult.addRotation(rotation));
    verify(rotation).yaw();
  }

  /**
   * Test {@link Location#addRotation(float, float)} with {@code yaw}, {@code pitch}.
   *
   * <p>Method under test: {@link Location#addRotation(float, float)}
   */
  @Test
  @DisplayName("Test addRotation(float, float) with 'yaw', 'pitch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.addRotation(float, float)"})
  void testAddRotationWithYawPitch() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualAddRotationResult = deserializeResult.addRotation(10.0f, 10.0f);

    // Assert
    assertEquals(10.0f, deserializeResult.getPitch());
    assertEquals(10.0f, deserializeResult.getYaw());
    assertSame(deserializeResult, actualAddRotationResult);
  }

  /**
   * Test {@link Location#subtract(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <p>Method under test: {@link Location#subtract(double, double, double)}
   */
  @Test
  @DisplayName("Test subtract(double, double, double) with 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtract(double, double, double)"})
  void testSubtractWithDoubleDoubleDouble() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSubtractResult = deserializeResult.subtract(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(-10, deserializeResult.getBlockZ());
    assertEquals(-10.0d, deserializeResult.getZ());
    assertEquals(-10.0d, deserializeResult.z());
    assertEquals(-2, deserializeResult.getBlockX());
    assertEquals(-2.0d, deserializeResult.getX());
    assertEquals(-2.0d, deserializeResult.x());
    assertEquals(-3, deserializeResult.getBlockY());
    assertEquals(-3.0d, deserializeResult.getY());
    assertEquals(-3.0d, deserializeResult.y());
    assertEquals(-36028798226923522L, deserializeResult.toBlockKey());
    assertEquals(10.63014581273465d, deserializeResult.length());
    assertSame(deserializeResult, actualSubtractResult);
  }

  /**
   * Test {@link Location#subtract(Location, double, double, double)} with {@code Location}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link Location#subtract(Location, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test subtract(Location, double, double, double) with 'Location', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtract(Location, double, double, double)"})
  void testSubtractWithLocationDoubleDoubleDouble() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSubtractResult =
        deserializeResult.subtract(Location.deserialize(new HashMap<>()), 2.0d, 3.0d, 10.0d);

    // Assert
    assertSame(deserializeResult, actualSubtractResult);
  }

  /**
   * Test {@link Location#subtract(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#subtract(Location)}
   */
  @Test
  @DisplayName(
      "Test subtract(Location) with 'Location'; given deserialize HashMap(); then return deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtract(Location)"})
  void testSubtractWithLocation_givenDeserializeHashMap_thenReturnDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSubtractResult =
        deserializeResult.subtract(Location.deserialize(new HashMap<>()));

    // Assert
    assertSame(deserializeResult, actualSubtractResult);
  }

  /**
   * Test {@link Location#subtract(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Given {@link World}.
   * </ul>
   *
   * <p>Method under test: {@link Location#subtract(Location)}
   */
  @Test
  @DisplayName("Test subtract(Location) with 'Location'; given World")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtract(Location)"})
  void testSubtractWithLocation_givenWorld() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(null);

    Location vec = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    vec.setWorld(mock(World.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.subtract(vec));
  }

  /**
   * Test {@link Location#subtract(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#subtract(Location)}
   */
  @Test
  @DisplayName(
      "Test subtract(Location) with 'Location'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtract(Location)"})
  void testSubtractWithLocation_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.subtract((Location) null));
  }

  /**
   * Test {@link Location#subtract(Vector)} with {@code Vector}.
   *
   * <p>Method under test: {@link Location#subtract(Vector)}
   */
  @Test
  @DisplayName("Test subtract(Vector) with 'Vector'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtract(Vector)"})
  void testSubtractWithVector() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSubtractResult = deserializeResult.subtract(Vector.getRandom());

    // Assert
    assertEquals(-1, deserializeResult.getBlockX());
    assertEquals(-1, deserializeResult.getBlockY());
    assertEquals(-1, deserializeResult.getBlockZ());
    assertEquals(-1L, deserializeResult.toBlockKey());
    assertSame(deserializeResult, actualSubtractResult);
  }

  /**
   * Test {@link Location#toBlockLocation()}.
   *
   * <p>Method under test: {@link Location#toBlockLocation()}
   */
  @Test
  @DisplayName("Test toBlockLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.toBlockLocation()"})
  void testToBlockLocation() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualToBlockLocationResult = deserializeResult.toBlockLocation();

    // Assert
    BlockVector toBlockVectorResult =
        deserializeResult
            .toVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector();
    Vector3d toVector3dResult = toBlockVectorResult.toVector3d();
    assertEquals(0.0d, toVector3dResult.x);
    assertEquals(0.0d, toVector3dResult.y);
    assertEquals(0.0d, toVector3dResult.z);
    Vector3f toVector3fResult = toBlockVectorResult.toVector3f();
    assertEquals(0.0f, toVector3fResult.x);
    assertEquals(0.0f, toVector3fResult.y);
    assertEquals(0.0f, toVector3fResult.z);
    assertEquals(deserializeResult, actualToBlockLocationResult);
  }

  /**
   * Test {@link Location#toBlockLocation()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()} add Random.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#toBlockLocation()}
   */
  @Test
  @DisplayName(
      "Test toBlockLocation(); given deserialize HashMap() add Random; then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.toBlockLocation()"})
  void testToBlockLocation_givenDeserializeHashMapAddRandom_thenReturnWorldIsNull() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    deserializeResult.add(Vector.getRandom());

    // Act
    Location actualToBlockLocationResult = deserializeResult.toBlockLocation();

    // Assert
    assertNull(actualToBlockLocationResult.getWorld());
    assertEquals(0, actualToBlockLocationResult.getBlockX());
    assertEquals(0, actualToBlockLocationResult.getBlockY());
    assertEquals(0, actualToBlockLocationResult.getBlockZ());
    assertEquals(0.0d, actualToBlockLocationResult.getX());
    assertEquals(0.0d, actualToBlockLocationResult.getY());
    assertEquals(0.0d, actualToBlockLocationResult.getZ());
    assertEquals(0.0d, actualToBlockLocationResult.length());
    assertEquals(0.0d, actualToBlockLocationResult.x());
    assertEquals(0.0d, actualToBlockLocationResult.y());
    assertEquals(0.0d, actualToBlockLocationResult.z());
    assertEquals(0.0f, actualToBlockLocationResult.getPitch());
    assertEquals(0.0f, actualToBlockLocationResult.getYaw());
    assertEquals(0L, actualToBlockLocationResult.toBlockKey());
    assertFalse(actualToBlockLocationResult.isBlock());
    assertFalse(actualToBlockLocationResult.isWorldLoaded());
    assertTrue(actualToBlockLocationResult.isFine());
    assertTrue(actualToBlockLocationResult.isFinite());
  }

  /**
   * Test {@link Location#toBlockKey()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link Location#toBlockKey()}
   */
  @Test
  @DisplayName("Test toBlockKey(); given deserialize HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Location.toBlockKey()"})
  void testToBlockKey_givenDeserializeHashMap() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0L, deserializeResult.toBlockKey());
  }

  /**
   * Test {@link Location#toBlockKey()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()} add Random.
   * </ul>
   *
   * <p>Method under test: {@link Location#toBlockKey()}
   */
  @Test
  @DisplayName("Test toBlockKey(); given deserialize HashMap() add Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Location.toBlockKey()"})
  void testToBlockKey_givenDeserializeHashMapAddRandom() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());
    deserializeResult.add(Vector.getRandom());

    // Act and Assert
    assertEquals(0L, deserializeResult.toBlockKey());
  }

  /**
   * Test {@link Location#toCenterLocation()}.
   *
   * <ul>
   *   <li>Given deserialize {@link HashMap#HashMap()}.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#toCenterLocation()}
   */
  @Test
  @DisplayName("Test toCenterLocation(); given deserialize HashMap(); then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.toCenterLocation()"})
  void testToCenterLocation_givenDeserializeHashMap_thenReturnWorldIsNull() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualToCenterLocationResult = deserializeResult.toCenterLocation();

    // Assert
    assertNull(actualToCenterLocationResult.getWorld());
    assertEquals(0, actualToCenterLocationResult.getBlockX());
    assertEquals(0, actualToCenterLocationResult.getBlockY());
    Vector toVectorResult = actualToCenterLocationResult.toVector();
    assertEquals(0, toVectorResult.getBlockX());
    assertEquals(0, toVectorResult.getBlockY());
    assertEquals(0.5d, actualToCenterLocationResult.getX());
    assertEquals(0.5d, actualToCenterLocationResult.getY());
    assertEquals(0.5d, actualToCenterLocationResult.x());
    assertEquals(0.5d, actualToCenterLocationResult.y());
    assertEquals(0.5d, toVectorResult.getX());
    assertEquals(0.5d, toVectorResult.getY());
    assertEquals(0.8660254037844386d, actualToCenterLocationResult.length());
    assertEquals(0.8660254037844386d, toVectorResult.length());
    assertEquals(0L, actualToCenterLocationResult.toBlockKey());
  }

  /**
   * Test {@link Location#toCenterLocation()}.
   *
   * <ul>
   *   <li>Then return Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Location#toCenterLocation()}
   */
  @Test
  @DisplayName("Test toCenterLocation(); then return Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.toCenterLocation()"})
  void testToCenterLocation_thenReturnChunkIsNull() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 0.5d);

    // Act
    Location actualToCenterLocationResult = location.toCenterLocation();

    // Assert
    assertNull(actualToCenterLocationResult.getChunk());
    assertNull(actualToCenterLocationResult.getBlock());
    assertEquals(2, actualToCenterLocationResult.getBlockX());
    assertEquals(2.5d, actualToCenterLocationResult.getX());
    assertEquals(2.5d, actualToCenterLocationResult.x());
    assertEquals(3, actualToCenterLocationResult.getBlockY());
    assertEquals(3.5d, actualToCenterLocationResult.getY());
    assertEquals(3.5d, actualToCenterLocationResult.y());
    assertEquals(4.330127018922194d, actualToCenterLocationResult.length());
    assertEquals(54043195528445954L, actualToCenterLocationResult.toBlockKey());
  }

  /**
   * Test {@link Location#subtractRotation(Rotation)} with {@code rotation}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then deserialize {@link HashMap#HashMap()} Pitch is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link Location#subtractRotation(Rotation)}
   */
  @Test
  @DisplayName(
      "Test subtractRotation(Rotation) with 'rotation'; given ten; then deserialize HashMap() Pitch is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtractRotation(Rotation)"})
  void testSubtractRotationWithRotation_givenTen_thenDeserializeHashMapPitchIsMinusTen() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    Rotation rotation = mock(Rotation.class);
    when(rotation.pitch()).thenReturn(10.0f);
    when(rotation.yaw()).thenReturn(10.0f);

    // Act
    Location actualSubtractRotationResult = deserializeResult.subtractRotation(rotation);

    // Assert
    verify(rotation).pitch();
    verify(rotation).yaw();
    assertEquals(-10.0f, deserializeResult.getPitch());
    assertEquals(-10.0f, deserializeResult.getYaw());
    assertSame(deserializeResult, actualSubtractRotationResult);
  }

  /**
   * Test {@link Location#subtractRotation(Rotation)} with {@code rotation}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#subtractRotation(Rotation)}
   */
  @Test
  @DisplayName(
      "Test subtractRotation(Rotation) with 'rotation'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtractRotation(Rotation)"})
  void testSubtractRotationWithRotation_thenThrowIllegalArgumentException() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    Rotation rotation = mock(Rotation.class);
    when(rotation.yaw()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> deserializeResult.subtractRotation(rotation));
    verify(rotation).yaw();
  }

  /**
   * Test {@link Location#subtractRotation(float, float)} with {@code yaw}, {@code pitch}.
   *
   * <p>Method under test: {@link Location#subtractRotation(float, float)}
   */
  @Test
  @DisplayName("Test subtractRotation(float, float) with 'yaw', 'pitch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.subtractRotation(float, float)"})
  void testSubtractRotationWithYawPitch() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSubtractRotationResult = deserializeResult.subtractRotation(10.0f, 10.0f);

    // Assert
    assertEquals(-10.0f, deserializeResult.getPitch());
    assertEquals(-10.0f, deserializeResult.getYaw());
    assertSame(deserializeResult, actualSubtractRotationResult);
  }

  /**
   * Test {@link Location#length()}.
   *
   * <p>Method under test: {@link Location#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Location.length()"})
  void testLength() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, deserializeResult.length());
  }

  /**
   * Test {@link Location#lengthSquared()}.
   *
   * <p>Method under test: {@link Location#lengthSquared()}
   */
  @Test
  @DisplayName("Test lengthSquared()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Location.lengthSquared()"})
  void testLengthSquared() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, deserializeResult.lengthSquared());
  }

  /**
   * Test {@link Location#multiply(double)}.
   *
   * <p>Method under test: {@link Location#multiply(double)}
   */
  @Test
  @DisplayName("Test multiply(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.multiply(double)"})
  void testMultiply() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualMultiplyResult = deserializeResult.multiply(10.0d);

    // Assert
    assertSame(deserializeResult, actualMultiplyResult);
  }

  /**
   * Test {@link Location#zero()}.
   *
   * <p>Method under test: {@link Location#zero()}
   */
  @Test
  @DisplayName("Test zero()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.zero()"})
  void testZero() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualZeroResult = deserializeResult.zero();

    // Assert
    assertSame(deserializeResult, actualZeroResult);
  }

  /**
   * Test {@link Location#isChunkLoaded()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@code 0.5} and y is three and z is ten World is {@link World}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isChunkLoaded()}
   */
  @Test
  @DisplayName(
      "Test isChunkLoaded(); given Location(World, double, double, double) with World and x is '0.5' and y is three and z is ten World is World")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isChunkLoaded()"})
  void testIsChunkLoaded_givenLocationWithWorldAndXIs05AndYIsThreeAndZIsTenWorldIsWorld() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkLoaded(anyInt(), anyInt())).thenReturn(true);

    Location location = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualIsChunkLoadedResult = location.isChunkLoaded();

    // Assert
    verify(world).isChunkLoaded(0, 0);
    assertTrue(actualIsChunkLoadedResult);
  }

  /**
   * Test {@link Location#isChunkLoaded()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#isChunkLoaded(int, int)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isChunkLoaded()}
   */
  @Test
  @DisplayName(
      "Test isChunkLoaded(); given World isChunkLoaded(int, int) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isChunkLoaded()"})
  void testIsChunkLoaded_givenWorldIsChunkLoadedReturnFalse_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkLoaded(anyInt(), anyInt())).thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualIsChunkLoadedResult = location.isChunkLoaded();

    // Assert
    verify(world).isChunkLoaded(0, 0);
    assertFalse(actualIsChunkLoadedResult);
  }

  /**
   * Test {@link Location#isChunkLoaded()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#isChunkLoaded(int, int)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isChunkLoaded()}
   */
  @Test
  @DisplayName(
      "Test isChunkLoaded(); given World isChunkLoaded(int, int) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isChunkLoaded()"})
  void testIsChunkLoaded_givenWorldIsChunkLoadedReturnTrue_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkLoaded(anyInt(), anyInt())).thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualIsChunkLoadedResult = location.isChunkLoaded();

    // Assert
    verify(world).isChunkLoaded(0, 0);
    assertTrue(actualIsChunkLoadedResult);
  }

  /**
   * Test {@link Location#isGenerated()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@code 0.5} and y is three and z is ten World is {@link World}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isGenerated()}
   */
  @Test
  @DisplayName(
      "Test isGenerated(); given Location(World, double, double, double) with World and x is '0.5' and y is three and z is ten World is World")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isGenerated()"})
  void testIsGenerated_givenLocationWithWorldAndXIs05AndYIsThreeAndZIsTenWorldIsWorld() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkGenerated(anyInt(), anyInt())).thenReturn(true);

    Location location = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualIsGeneratedResult = location.isGenerated();

    // Assert
    verify(world).isChunkGenerated(0, 0);
    assertTrue(actualIsGeneratedResult);
  }

  /**
   * Test {@link Location#isGenerated()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#isChunkGenerated(int, int)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isGenerated()}
   */
  @Test
  @DisplayName(
      "Test isGenerated(); given World isChunkGenerated(int, int) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isGenerated()"})
  void testIsGenerated_givenWorldIsChunkGeneratedReturnFalse_thenReturnFalse() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkGenerated(anyInt(), anyInt())).thenReturn(false);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualIsGeneratedResult = location.isGenerated();

    // Assert
    verify(world).isChunkGenerated(0, 0);
    assertFalse(actualIsGeneratedResult);
  }

  /**
   * Test {@link Location#isGenerated()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#isChunkGenerated(int, int)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isGenerated()}
   */
  @Test
  @DisplayName(
      "Test isGenerated(); given World isChunkGenerated(int, int) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isGenerated()"})
  void testIsGenerated_givenWorldIsChunkGeneratedReturnTrue_thenReturnTrue() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkGenerated(anyInt(), anyInt())).thenReturn(true);

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act
    boolean actualIsGeneratedResult = location.isGenerated();

    // Assert
    verify(world).isChunkGenerated(0, 0);
    assertTrue(actualIsGeneratedResult);
  }

  /**
   * Test {@link Location#isGenerated()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#isGenerated()}
   */
  @Test
  @DisplayName("Test isGenerated(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Location.isGenerated()"})
  void testIsGenerated_thenThrowIllegalArgumentException() {
    // Arrange
    World world = mock(World.class);
    when(world.isChunkGenerated(anyInt(), anyInt())).thenThrow(new IllegalArgumentException());

    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(world);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> location.isGenerated());
    verify(world).isChunkGenerated(0, 0);
  }

  /**
   * Test {@link Location#set(double, double, double)}.
   *
   * <p>Method under test: {@link Location#set(double, double, double)}
   */
  @Test
  @DisplayName("Test set(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.set(double, double, double)"})
  void testSet() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSetResult = deserializeResult.set(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10, deserializeResult.getBlockZ());
    assertEquals(10.0d, deserializeResult.getZ());
    assertEquals(10.0d, deserializeResult.z());
    assertEquals(10.63014581273465d, deserializeResult.length());
    assertEquals(2, deserializeResult.getBlockX());
    assertEquals(2.0d, deserializeResult.getX());
    assertEquals(2.0d, deserializeResult.x());
    assertEquals(3, deserializeResult.getBlockY());
    assertEquals(3.0d, deserializeResult.getY());
    assertEquals(3.0d, deserializeResult.y());
    assertEquals(54043196870623234L, deserializeResult.toBlockKey());
    assertSame(deserializeResult, actualSetResult);
  }

  /**
   * Test {@link Location#setRotation(Rotation)} with {@code rotation}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then deserialize {@link HashMap#HashMap()} Pitch is ten.
   * </ul>
   *
   * <p>Method under test: {@link Location#setRotation(Rotation)}
   */
  @Test
  @DisplayName(
      "Test setRotation(Rotation) with 'rotation'; given ten; then deserialize HashMap() Pitch is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setRotation(Rotation)"})
  void testSetRotationWithRotation_givenTen_thenDeserializeHashMapPitchIsTen() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    Rotation rotation = mock(Rotation.class);
    when(rotation.pitch()).thenReturn(10.0f);
    when(rotation.yaw()).thenReturn(10.0f);

    // Act
    Location actualSetRotationResult = deserializeResult.setRotation(rotation);

    // Assert
    verify(rotation).pitch();
    verify(rotation).yaw();
    assertEquals(10.0f, deserializeResult.getPitch());
    assertEquals(10.0f, deserializeResult.getYaw());
    assertSame(deserializeResult, actualSetRotationResult);
  }

  /**
   * Test {@link Location#setRotation(Rotation)} with {@code rotation}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Location#setRotation(Rotation)}
   */
  @Test
  @DisplayName("Test setRotation(Rotation) with 'rotation'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setRotation(Rotation)"})
  void testSetRotationWithRotation_thenThrowIllegalArgumentException() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    Rotation rotation = mock(Rotation.class);
    when(rotation.yaw()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> deserializeResult.setRotation(rotation));
    verify(rotation).yaw();
  }

  /**
   * Test {@link Location#setRotation(float, float)} with {@code yaw}, {@code pitch}.
   *
   * <p>Method under test: {@link Location#setRotation(float, float)}
   */
  @Test
  @DisplayName("Test setRotation(float, float) with 'yaw', 'pitch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Location.setRotation(float, float)"})
  void testSetRotationWithYawPitch() {
    // Arrange
    Location deserializeResult = Location.deserialize(new HashMap<>());

    // Act
    Location actualSetRotationResult = deserializeResult.setRotation(10.0f, 10.0f);

    // Assert
    assertEquals(10.0f, deserializeResult.getPitch());
    assertEquals(10.0f, deserializeResult.getYaw());
    assertSame(deserializeResult, actualSetRotationResult);
  }
}
