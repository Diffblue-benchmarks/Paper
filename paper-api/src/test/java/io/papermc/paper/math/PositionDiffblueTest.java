package io.papermc.paper.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PositionDiffblueTest {
  /**
   * Test {@link Position#isFinite()}.
   *
   * <p>Method under test: {@link Position#isFinite()}
   */
  @Test
  @DisplayName("Test isFinite()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Position.isFinite()"})
  void testIsFinite() {
    // Arrange, Act and Assert
    assertTrue(new BlockPositionImpl(1, 1, 1).isFinite());
  }

  /**
   * Test {@link Position#toCenter()}.
   *
   * <p>Method under test: {@link Position#toCenter()}
   */
  @Test
  @DisplayName("Test toCenter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition Position.toCenter()"})
  void testToCenter() {
    // Arrange and Act
    FinePosition actualToCenterResult = new BlockPositionImpl(1, 1, 1).toCenter();

    // Assert
    assertTrue(actualToCenterResult instanceof FinePositionImpl);
    Vector toVectorResult = actualToCenterResult.toVector();
    assertEquals(1, toVectorResult.getBlockX());
    assertEquals(1, toVectorResult.getBlockY());
    assertEquals(1, toVectorResult.getBlockZ());
    assertEquals(1.5d, actualToCenterResult.x());
    assertEquals(1.5d, actualToCenterResult.y());
    assertEquals(1.5d, actualToCenterResult.z());
    assertEquals(1.5d, toVectorResult.getX());
    assertEquals(1.5d, toVectorResult.getY());
    assertEquals(1.5d, toVectorResult.getZ());
    assertEquals(2.598076211353316d, toVectorResult.length());
    assertFalse(actualToCenterResult.isBlock());
    assertFalse(toVectorResult.isZero());
    assertTrue(actualToCenterResult.isFine());
    assertTrue(actualToCenterResult.isFinite());
  }

  /**
   * Test {@link Position#toVector()}.
   *
   * <p>Method under test: {@link Position#toVector()}
   */
  @Test
  @DisplayName("Test toVector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector Position.toVector()"})
  void testToVector() {
    // Arrange and Act
    Vector actualToVectorResult = new BlockPositionImpl(1, 1, 1).toVector();

    // Assert
    assertEquals(1, actualToVectorResult.getBlockX());
    assertEquals(1, actualToVectorResult.getBlockY());
    assertEquals(1, actualToVectorResult.getBlockZ());
    assertEquals(1.0d, actualToVectorResult.getX());
    assertEquals(1.0d, actualToVectorResult.getY());
    assertEquals(1.0d, actualToVectorResult.getZ());
    assertEquals(1.7320508075688772d, actualToVectorResult.length());
    assertFalse(actualToVectorResult.isZero());
  }

  /**
   * Test {@link Position#toLocation(World)}.
   *
   * <ul>
   *   <li>Given {@link Position#BLOCK_ZERO}.
   *   <li>When {@code null}.
   *   <li>Then return World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Position#toLocation(World)}
   */
  @Test
  @DisplayName("Test toLocation(World); given BLOCK_ZERO; when 'null'; then return World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Position.toLocation(World)"})
  void testToLocation_givenBlock_zero_whenNull_thenReturnWorldIsNull() {
    // Arrange and Act
    Location actualToLocationResult = Position.BLOCK_ZERO.toLocation(null);

    // Assert
    assertNull(actualToLocationResult.getWorld());
    assertEquals(0, actualToLocationResult.getBlockX());
    assertEquals(0, actualToLocationResult.getBlockY());
    assertEquals(0, actualToLocationResult.getBlockZ());
    assertEquals(0.0d, actualToLocationResult.getX());
    assertEquals(0.0d, actualToLocationResult.getY());
    assertEquals(0.0d, actualToLocationResult.getZ());
    assertEquals(0.0d, actualToLocationResult.length());
    assertEquals(0.0d, actualToLocationResult.x());
    assertEquals(0.0d, actualToLocationResult.y());
    assertEquals(0.0d, actualToLocationResult.z());
    assertEquals(0L, actualToLocationResult.toBlockKey());
    assertFalse(actualToLocationResult.isWorldLoaded());
  }

  /**
   * Test {@link Position#toLocation(World)}.
   *
   * <ul>
   *   <li>Then return Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Position#toLocation(World)}
   */
  @Test
  @DisplayName("Test toLocation(World); then return Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location Position.toLocation(World)"})
  void testToLocation_thenReturnChunkIsNull() {
    // Arrange
    World world = mock(World.class);

    // Act
    Location actualToLocationResult = new BlockPositionImpl(1, 1, 1).toLocation(world);

    // Assert
    assertNull(actualToLocationResult.getChunk());
    assertNull(actualToLocationResult.getBlock());
    assertEquals(1, actualToLocationResult.getBlockX());
    assertEquals(1, actualToLocationResult.getBlockY());
    assertEquals(1, actualToLocationResult.getBlockZ());
    assertEquals(1.0d, actualToLocationResult.getX());
    assertEquals(1.0d, actualToLocationResult.getY());
    assertEquals(1.0d, actualToLocationResult.getZ());
    assertEquals(1.0d, actualToLocationResult.x());
    assertEquals(1.0d, actualToLocationResult.y());
    assertEquals(1.0d, actualToLocationResult.z());
    assertEquals(1.7320508075688772d, actualToLocationResult.length());
    assertEquals(18014398643699713L, actualToLocationResult.toBlockKey());
    assertSame(world, actualToLocationResult.getWorld());
  }

  /**
   * Test {@link Position#block(Location)} with {@code location}.
   *
   * <ul>
   *   <li>Then return blockX is zero.
   * </ul>
   *
   * <p>Method under test: {@link Position#block(Location)}
   */
  @Test
  @DisplayName("Test block(Location) with 'location'; then return blockX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition Position.block(Location)"})
  void testBlockWithLocation_thenReturnBlockXIsZero() {
    // Arrange
    Location location = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);

    // Act
    BlockPosition actualBlockResult = Position.block(location);

    // Assert
    assertTrue(actualBlockResult instanceof BlockPositionImpl);
    assertEquals(0, actualBlockResult.blockX());
    Vector toVectorResult = actualBlockResult.toVector();
    assertEquals(0, toVectorResult.getBlockX());
    assertEquals(0.0d, toVectorResult.getX());
    assertEquals(10.44030650891055d, toVectorResult.length());
  }

  /**
   * Test {@link Position#block(Location)} with {@code location}.
   *
   * <ul>
   *   <li>Then return toVector length is {@code 10.63014581273465}.
   * </ul>
   *
   * <p>Method under test: {@link Position#block(Location)}
   */
  @Test
  @DisplayName(
      "Test block(Location) with 'location'; then return toVector length is '10.63014581273465'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition Position.block(Location)"})
  void testBlockWithLocation_thenReturnToVectorLengthIs1063014581273465() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    BlockPosition actualBlockResult = Position.block(location);

    // Assert
    assertTrue(actualBlockResult instanceof BlockPositionImpl);
    Vector toVectorResult = actualBlockResult.toVector();
    assertEquals(10.63014581273465d, toVectorResult.length());
    assertEquals(2, actualBlockResult.blockX());
    assertEquals(2, toVectorResult.getBlockX());
    assertEquals(2.0d, toVectorResult.getX());
  }

  /**
   * Test {@link Position#block(int, int, int)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link Position#block(int, int, int)}
   */
  @Test
  @DisplayName("Test block(int, int, int) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPosition Position.block(int, int, int)"})
  void testBlockWithXYZ() {
    // Arrange and Act
    BlockPosition actualBlockResult = Position.block(2, 3, 1);

    // Assert
    assertTrue(actualBlockResult instanceof BlockPositionImpl);
    assertEquals(1, actualBlockResult.blockZ());
    Vector toVectorResult = actualBlockResult.toVector();
    assertEquals(1, toVectorResult.getBlockZ());
    assertEquals(1.0d, toVectorResult.getZ());
    assertEquals(2, actualBlockResult.blockX());
    assertEquals(2, toVectorResult.getBlockX());
    assertEquals(2.0d, toVectorResult.getX());
    assertEquals(3, actualBlockResult.blockY());
    assertEquals(3, toVectorResult.getBlockY());
    assertEquals(3.0d, toVectorResult.getY());
    assertEquals(3.7416573867739413d, toVectorResult.length());
    assertFalse(actualBlockResult.isFine());
    assertFalse(toVectorResult.isZero());
    assertTrue(actualBlockResult.isBlock());
    assertTrue(actualBlockResult.isFinite());
  }

  /**
   * Test {@link Position#fine(Location)} with {@code location}.
   *
   * <ul>
   *   <li>Then return {@link FinePositionImpl}.
   * </ul>
   *
   * <p>Method under test: {@link Position#fine(Location)}
   */
  @Test
  @DisplayName("Test fine(Location) with 'location'; then return FinePositionImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition Position.fine(Location)"})
  void testFineWithLocation_thenReturnFinePositionImpl() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    FinePosition actualFineResult = Position.fine(location);

    // Assert
    assertTrue(actualFineResult instanceof FinePositionImpl);
    Vector toVectorResult = actualFineResult.toVector();
    assertEquals(10, toVectorResult.getBlockZ());
    assertEquals(10.0d, actualFineResult.z());
    assertEquals(10.0d, toVectorResult.getZ());
    assertEquals(10.63014581273465d, toVectorResult.length());
    assertEquals(2, toVectorResult.getBlockX());
    assertEquals(2.0d, actualFineResult.x());
    assertEquals(2.0d, toVectorResult.getX());
    assertEquals(3, toVectorResult.getBlockY());
    assertEquals(3.0d, actualFineResult.y());
    assertEquals(3.0d, toVectorResult.getY());
    assertFalse(actualFineResult.isBlock());
    assertFalse(toVectorResult.isZero());
    assertTrue(actualFineResult.isFine());
    assertTrue(actualFineResult.isFinite());
  }

  /**
   * Test {@link Position#fine(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link Position#fine(double, double, double)}
   */
  @Test
  @DisplayName("Test fine(double, double, double) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FinePosition Position.fine(double, double, double)"})
  void testFineWithXYZ() {
    // Arrange and Act
    FinePosition actualFineResult = Position.fine(2.0d, 3.0d, 10.0d);

    // Assert
    assertTrue(actualFineResult instanceof FinePositionImpl);
    Vector toVectorResult = actualFineResult.toVector();
    assertEquals(10, toVectorResult.getBlockZ());
    assertEquals(10.0d, actualFineResult.z());
    assertEquals(10.0d, toVectorResult.getZ());
    assertEquals(10.63014581273465d, toVectorResult.length());
    assertEquals(2, toVectorResult.getBlockX());
    assertEquals(2.0d, actualFineResult.x());
    assertEquals(2.0d, toVectorResult.getX());
    assertEquals(3, toVectorResult.getBlockY());
    assertEquals(3.0d, actualFineResult.y());
    assertEquals(3.0d, toVectorResult.getY());
    assertFalse(actualFineResult.isBlock());
    assertFalse(toVectorResult.isZero());
    assertTrue(actualFineResult.isFine());
    assertTrue(actualFineResult.isFinite());
  }
}
