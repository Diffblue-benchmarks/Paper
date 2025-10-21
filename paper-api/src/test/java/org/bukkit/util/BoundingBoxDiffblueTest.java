package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BoundingBoxDiffblueTest {
  /**
   * Test {@link BoundingBox#of(Block)} with {@code Block}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link Block} {@link Block#getX()} return two.
   *   <li>Then return Height is one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#of(Block)}
   */
  @Test
  @DisplayName(
      "Test of(Block) with 'Block'; given two; when Block getX() return two; then return Height is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.of(Block)"})
  void testOfWithBlock_givenTwo_whenBlockGetXReturnTwo_thenReturnHeightIsOne() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenReturn(2);
    when(block.getY()).thenReturn(3);
    when(block.getZ()).thenReturn(1);

    // Act
    BoundingBox actualOfResult = BoundingBox.of(block);

    // Assert
    verify(block, atLeast(1)).getX();
    verify(block, atLeast(1)).getY();
    verify(block, atLeast(1)).getZ();
    assertEquals(1.0d, actualOfResult.getHeight());
    assertEquals(1.0d, actualOfResult.getMinZ());
    assertEquals(1.0d, actualOfResult.getVolume());
    assertEquals(1.0d, actualOfResult.getWidthX());
    assertEquals(1.0d, actualOfResult.getWidthZ());
    assertEquals(1.5d, actualOfResult.getCenterZ());
    assertEquals(2.0d, actualOfResult.getMaxZ());
    assertEquals(2.0d, actualOfResult.getMinX());
    assertEquals(2.5d, actualOfResult.getCenterX());
    assertEquals(3.0d, actualOfResult.getMaxX());
    assertEquals(3.0d, actualOfResult.getMinY());
    assertEquals(3.5d, actualOfResult.getCenterY());
    assertEquals(4.0d, actualOfResult.getMaxY());
  }

  /**
   * Test {@link BoundingBox#of(Location, double, double, double)} with {@code Location}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then return MinX is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#of(Location, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test of(Location, double, double, double) with 'Location', 'double', 'double', 'double'; then return MinX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.of(Location, double, double, double)"})
  void testOfWithLocationDoubleDoubleDouble_thenReturnMinXIsZero() {
    // Arrange
    Location center = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    BoundingBox actualOfResult = BoundingBox.of(center, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualOfResult.getMinX());
    assertEquals(0.0d, actualOfResult.getMinY());
    assertEquals(0.0d, actualOfResult.getMinZ());
    assertEquals(10.0d, actualOfResult.getCenterZ());
    assertEquals(2.0d, actualOfResult.getCenterX());
    assertEquals(20.0d, actualOfResult.getMaxZ());
    assertEquals(20.0d, actualOfResult.getWidthZ());
    assertEquals(3.0d, actualOfResult.getCenterY());
    assertEquals(4.0d, actualOfResult.getMaxX());
    assertEquals(4.0d, actualOfResult.getWidthX());
    assertEquals(480.0d, actualOfResult.getVolume());
    assertEquals(6.0d, actualOfResult.getHeight());
    assertEquals(6.0d, actualOfResult.getMaxY());
  }

  /**
   * Test {@link BoundingBox#of(Location, Location)} with {@code Location}, {@code Location}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#of(Location, Location)}
   */
  @Test
  @DisplayName(
      "Test of(Location, Location) with 'Location', 'Location'; given 'null'; then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.of(Location, Location)"})
  void testOfWithLocationLocation_givenNull_thenReturnHeightIsZero() {
    // Arrange
    Location corner1 = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    corner1.setWorld(null);

    Location corner2 = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    corner2.setWorld(null);

    // Act
    BoundingBox actualOfResult = BoundingBox.of(corner1, corner2);

    // Assert
    assertEquals(0.0d, actualOfResult.getHeight());
    assertEquals(0.0d, actualOfResult.getVolume());
    assertEquals(0.0d, actualOfResult.getWidthX());
    assertEquals(0.0d, actualOfResult.getWidthZ());
    assertEquals(10.0d, actualOfResult.getCenterZ());
    assertEquals(10.0d, actualOfResult.getMaxZ());
    assertEquals(10.0d, actualOfResult.getMinZ());
    assertEquals(2.0d, actualOfResult.getCenterX());
    assertEquals(2.0d, actualOfResult.getMaxX());
    assertEquals(2.0d, actualOfResult.getMinX());
    assertEquals(3.0d, actualOfResult.getCenterY());
    assertEquals(3.0d, actualOfResult.getMaxY());
    assertEquals(3.0d, actualOfResult.getMinY());
  }

  /**
   * Test {@link BoundingBox#of(Vector, double, double, double)} with {@code Vector}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Min BlockZ is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#of(Vector, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test of(Vector, double, double, double) with 'Vector', 'double', 'double', 'double'; when Random; then return Min BlockZ is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.of(Vector, double, double, double)"})
  void testOfWithVectorDoubleDoubleDouble_whenRandom_thenReturnMinBlockZIsMinusTen() {
    // Arrange and Act
    BoundingBox actualOfResult = BoundingBox.of(Vector.getRandom(), 2.0d, 3.0d, 10.0d);

    // Assert
    Vector min = actualOfResult.getMin();
    assertEquals(-10, min.getBlockZ());
    assertEquals(-2, min.getBlockX());
    assertEquals(-3, min.getBlockY());
    Vector center = actualOfResult.getCenter();
    assertEquals(0, center.getBlockX());
    assertEquals(0, center.getBlockY());
    assertEquals(0, center.getBlockZ());
    Vector max = actualOfResult.getMax();
    assertEquals(2, max.getBlockX());
    assertEquals(20.0d, actualOfResult.getWidthZ());
    assertEquals(3, max.getBlockY());
    assertEquals(4.0d, actualOfResult.getWidthX());
    assertEquals(480.0d, actualOfResult.getVolume());
    assertEquals(6.0d, actualOfResult.getHeight());
    assertFalse(center.isZero());
    assertFalse(max.isZero());
    assertFalse(min.isZero());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max.getBlockZ());
  }

  /**
   * Test {@link BoundingBox#of(Vector, Vector)} with {@code Vector}, {@code Vector}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Center BlockX is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#of(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test of(Vector, Vector) with 'Vector', 'Vector'; when Random; then return Center BlockX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.of(Vector, Vector)"})
  void testOfWithVectorVector_whenRandom_thenReturnCenterBlockXIsZero() {
    // Arrange and Act
    BoundingBox actualOfResult = BoundingBox.of(Vector.getRandom(), Vector.getRandom());

    // Assert
    Vector center = actualOfResult.getCenter();
    assertEquals(0, center.getBlockX());
    Vector max = actualOfResult.getMax();
    assertEquals(0, max.getBlockX());
    Vector min = actualOfResult.getMin();
    assertEquals(0, min.getBlockX());
    assertEquals(0, center.getBlockY());
    assertEquals(0, max.getBlockY());
    assertEquals(0, min.getBlockY());
    assertEquals(0, center.getBlockZ());
    assertEquals(0, max.getBlockZ());
    assertEquals(0, min.getBlockZ());
    assertFalse(center.isZero());
    assertFalse(max.isZero());
    assertFalse(min.isZero());
  }

  /**
   * Test {@link BoundingBox#BoundingBox()}.
   *
   * <p>Method under test: {@link BoundingBox#BoundingBox()}
   */
  @Test
  @DisplayName("Test new BoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundingBox.<init>()"})
  void testNewBoundingBox() {
    // Arrange and Act
    BoundingBox actualBoundingBox = new BoundingBox();

    // Assert
    assertEquals(0.0d, actualBoundingBox.getCenterX());
    assertEquals(0.0d, actualBoundingBox.getCenterY());
    assertEquals(0.0d, actualBoundingBox.getCenterZ());
    assertEquals(0.0d, actualBoundingBox.getHeight());
    assertEquals(0.0d, actualBoundingBox.getMaxX());
    assertEquals(0.0d, actualBoundingBox.getMaxY());
    assertEquals(0.0d, actualBoundingBox.getMaxZ());
    assertEquals(0.0d, actualBoundingBox.getMinX());
    assertEquals(0.0d, actualBoundingBox.getMinY());
    assertEquals(0.0d, actualBoundingBox.getMinZ());
    assertEquals(0.0d, actualBoundingBox.getVolume());
    assertEquals(0.0d, actualBoundingBox.getWidthX());
    assertEquals(0.0d, actualBoundingBox.getWidthZ());
  }

  /**
   * Test {@link BoundingBox#BoundingBox(double, double, double, double, double, double)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Volume is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#BoundingBox(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test new BoundingBox(double, double, double, double, double, double); when one; then return Volume is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BoundingBox.<init>(double, double, double, double, double, double)"})
  void testNewBoundingBox_whenOne_thenReturnVolumeIsZero() {
    // Arrange and Act
    BoundingBox actualBoundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, actualBoundingBox.getVolume());
    assertEquals(0.0d, actualBoundingBox.getWidthZ());
    assertEquals(1.0d, actualBoundingBox.getMinX());
    assertEquals(10.0d, actualBoundingBox.getCenterZ());
    assertEquals(10.0d, actualBoundingBox.getMaxX());
    assertEquals(10.0d, actualBoundingBox.getMaxY());
    assertEquals(10.0d, actualBoundingBox.getMaxZ());
    assertEquals(10.0d, actualBoundingBox.getMinZ());
    assertEquals(3.0d, actualBoundingBox.getMinY());
    assertEquals(5.5d, actualBoundingBox.getCenterX());
    assertEquals(6.5d, actualBoundingBox.getCenterY());
    assertEquals(7.0d, actualBoundingBox.getHeight());
    assertEquals(9.0d, actualBoundingBox.getWidthX());
  }

  /**
   * Test {@link BoundingBox#resize(double, double, double, double, double, double)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link BoundingBox#BoundingBox()} MinX is one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#resize(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test resize(double, double, double, double, double, double); when one; then BoundingBox() MinX is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.resize(double, double, double, double, double, double)"
  })
  void testResize_whenOne_thenBoundingBoxMinXIsOne() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualResizeResult = boundingBox.resize(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(1.0d, boundingBox.getMinX());
    assertEquals(10.0d, boundingBox.getCenterZ());
    assertEquals(10.0d, boundingBox.getMaxX());
    assertEquals(10.0d, boundingBox.getMaxY());
    assertEquals(10.0d, boundingBox.getMaxZ());
    assertEquals(10.0d, boundingBox.getMinZ());
    assertEquals(3.0d, boundingBox.getMinY());
    assertEquals(5.5d, boundingBox.getCenterX());
    assertEquals(6.5d, boundingBox.getCenterY());
    assertEquals(7.0d, boundingBox.getHeight());
    assertEquals(9.0d, boundingBox.getWidthX());
    assertSame(boundingBox, actualResizeResult);
  }

  /**
   * Test {@link BoundingBox#getMin()}.
   *
   * <p>Method under test: {@link BoundingBox#getMin()}
   */
  @Test
  @DisplayName("Test getMin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BoundingBox.getMin()"})
  void testGetMin() {
    // Arrange and Act
    Vector actualMin = new BoundingBox().getMin();

    // Assert
    assertEquals(0, actualMin.getBlockX());
    assertEquals(0, actualMin.getBlockY());
    assertEquals(0, actualMin.getBlockZ());
    assertEquals(0.0d, actualMin.getX());
    assertEquals(0.0d, actualMin.getY());
    assertEquals(0.0d, actualMin.getZ());
    assertEquals(0.0d, actualMin.length());
    assertTrue(actualMin.isZero());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundingBox#toString()}
   *   <li>{@link BoundingBox#getMaxX()}
   *   <li>{@link BoundingBox#getMaxY()}
   *   <li>{@link BoundingBox#getMaxZ()}
   *   <li>{@link BoundingBox#getMinX()}
   *   <li>{@link BoundingBox#getMinY()}
   *   <li>{@link BoundingBox#getMinZ()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double BoundingBox.getMaxX()",
    "double BoundingBox.getMaxY()",
    "double BoundingBox.getMaxZ()",
    "double BoundingBox.getMinX()",
    "double BoundingBox.getMinY()",
    "double BoundingBox.getMinZ()",
    "String BoundingBox.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    String actualToStringResult = boundingBox.toString();
    double actualMaxX = boundingBox.getMaxX();
    double actualMaxY = boundingBox.getMaxY();
    double actualMaxZ = boundingBox.getMaxZ();
    double actualMinX = boundingBox.getMinX();
    double actualMinY = boundingBox.getMinY();

    // Assert
    assertEquals(
        "BoundingBox [minX=0.0, minY=0.0, minZ=0.0, maxX=0.0, maxY=0.0, maxZ=0.0]",
        actualToStringResult);
    assertEquals(0.0d, actualMaxX);
    assertEquals(0.0d, actualMaxY);
    assertEquals(0.0d, actualMaxZ);
    assertEquals(0.0d, actualMinX);
    assertEquals(0.0d, actualMinY);
    assertEquals(0.0d, boundingBox.getMinZ());
  }

  /**
   * Test {@link BoundingBox#getMax()}.
   *
   * <p>Method under test: {@link BoundingBox#getMax()}
   */
  @Test
  @DisplayName("Test getMax()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BoundingBox.getMax()"})
  void testGetMax() {
    // Arrange and Act
    Vector actualMax = new BoundingBox().getMax();

    // Assert
    assertEquals(0, actualMax.getBlockX());
    assertEquals(0, actualMax.getBlockY());
    assertEquals(0, actualMax.getBlockZ());
    assertEquals(0.0d, actualMax.getX());
    assertEquals(0.0d, actualMax.getY());
    assertEquals(0.0d, actualMax.getZ());
    assertEquals(0.0d, actualMax.length());
    assertTrue(actualMax.isZero());
  }

  /**
   * Test {@link BoundingBox#getWidthX()}.
   *
   * <p>Method under test: {@link BoundingBox#getWidthX()}
   */
  @Test
  @DisplayName("Test getWidthX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getWidthX()"})
  void testGetWidthX() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getWidthX());
  }

  /**
   * Test {@link BoundingBox#getWidthZ()}.
   *
   * <p>Method under test: {@link BoundingBox#getWidthZ()}
   */
  @Test
  @DisplayName("Test getWidthZ()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getWidthZ()"})
  void testGetWidthZ() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getWidthZ());
  }

  /**
   * Test {@link BoundingBox#getHeight()}.
   *
   * <p>Method under test: {@link BoundingBox#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getHeight()"})
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getHeight());
  }

  /**
   * Test {@link BoundingBox#getVolume()}.
   *
   * <p>Method under test: {@link BoundingBox#getVolume()}
   */
  @Test
  @DisplayName("Test getVolume()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getVolume()"})
  void testGetVolume() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getVolume());
  }

  /**
   * Test {@link BoundingBox#getCenterX()}.
   *
   * <p>Method under test: {@link BoundingBox#getCenterX()}
   */
  @Test
  @DisplayName("Test getCenterX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getCenterX()"})
  void testGetCenterX() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getCenterX());
  }

  /**
   * Test {@link BoundingBox#getCenterY()}.
   *
   * <p>Method under test: {@link BoundingBox#getCenterY()}
   */
  @Test
  @DisplayName("Test getCenterY()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getCenterY()"})
  void testGetCenterY() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getCenterY());
  }

  /**
   * Test {@link BoundingBox#getCenterZ()}.
   *
   * <p>Method under test: {@link BoundingBox#getCenterZ()}
   */
  @Test
  @DisplayName("Test getCenterZ()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double BoundingBox.getCenterZ()"})
  void testGetCenterZ() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new BoundingBox().getCenterZ());
  }

  /**
   * Test {@link BoundingBox#getCenter()}.
   *
   * <p>Method under test: {@link BoundingBox#getCenter()}
   */
  @Test
  @DisplayName("Test getCenter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BoundingBox.getCenter()"})
  void testGetCenter() {
    // Arrange and Act
    Vector actualCenter = new BoundingBox().getCenter();

    // Assert
    assertEquals(0, actualCenter.getBlockX());
    assertEquals(0, actualCenter.getBlockY());
    assertEquals(0, actualCenter.getBlockZ());
    assertEquals(0.0d, actualCenter.getX());
    assertEquals(0.0d, actualCenter.getY());
    assertEquals(0.0d, actualCenter.getZ());
    assertEquals(0.0d, actualCenter.length());
    assertTrue(actualCenter.isZero());
  }

  /**
   * Test {@link BoundingBox#copy(BoundingBox)}.
   *
   * <ul>
   *   <li>When {@link BoundingBox#BoundingBox()}.
   *   <li>Then return {@link BoundingBox#BoundingBox()}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#copy(BoundingBox)}
   */
  @Test
  @DisplayName("Test copy(BoundingBox); when BoundingBox(); then return BoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.copy(BoundingBox)"})
  void testCopy_whenBoundingBox_thenReturnBoundingBox() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualCopyResult = boundingBox.copy(new BoundingBox());

    // Assert
    assertSame(boundingBox, actualCopyResult);
  }

  /**
   * Test {@link BoundingBox#expand(BlockFace, double)} with {@code BlockFace}, {@code double}.
   *
   * <ul>
   *   <li>When {@code DOWN}.
   *   <li>Then {@link BoundingBox#BoundingBox()} Min BlockY is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(BlockFace, double)}
   */
  @Test
  @DisplayName(
      "Test expand(BlockFace, double) with 'BlockFace', 'double'; when 'DOWN'; then BoundingBox() Min BlockY is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(BlockFace, double)"})
  void testExpandWithBlockFaceDouble_whenDown_thenBoundingBoxMinBlockYIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(BlockFace.DOWN, 10.0d);

    // Assert
    Vector min = boundingBox.getMin();
    assertEquals(-10, min.getBlockY());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-10, min2.getBlockY());
    assertEquals(-10.0d, boundingBox.getMinY());
    assertEquals(-10.0d, actualExpandResult.getMinY());
    assertEquals(-10.0d, min.getY());
    assertEquals(-10.0d, min2.getY());
    Vector center = boundingBox.getCenter();
    assertEquals(-5, center.getBlockY());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(-5, center2.getBlockY());
    assertEquals(-5.0d, boundingBox.getCenterY());
    assertEquals(-5.0d, actualExpandResult.getCenterY());
    assertEquals(-5.0d, center.getY());
    assertEquals(-5.0d, center2.getY());
  }

  /**
   * Test {@link BoundingBox#expand(BlockFace, double)} with {@code BlockFace}, {@code double}.
   *
   * <ul>
   *   <li>When {@code EAST}.
   *   <li>Then {@link BoundingBox#BoundingBox()} MaxX is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(BlockFace, double)}
   */
  @Test
  @DisplayName(
      "Test expand(BlockFace, double) with 'BlockFace', 'double'; when 'EAST'; then BoundingBox() MaxX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(BlockFace, double)"})
  void testExpandWithBlockFaceDouble_whenEast_thenBoundingBoxMaxXIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(BlockFace.EAST, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getMaxX());
    assertEquals(10.0d, actualExpandResult.getMaxX());
    Vector max = boundingBox.getMax();
    assertEquals(10.0d, max.getX());
    Vector max2 = actualExpandResult.getMax();
    assertEquals(10.0d, max2.getX());
    Vector center = boundingBox.getCenter();
    assertEquals(5, center.getBlockX());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(5, center2.getBlockX());
    assertEquals(5.0d, boundingBox.getCenterX());
    assertEquals(5.0d, actualExpandResult.getCenterX());
    assertEquals(5.0d, center.getX());
    assertEquals(5.0d, center2.getX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max.getBlockX());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max2.getBlockX());
  }

  /**
   * Test {@link BoundingBox#expand(BlockFace, double)} with {@code BlockFace}, {@code double}.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then {@link BoundingBox#BoundingBox()} Min BlockZ is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(BlockFace, double)}
   */
  @Test
  @DisplayName(
      "Test expand(BlockFace, double) with 'BlockFace', 'double'; when 'NORTH'; then BoundingBox() Min BlockZ is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(BlockFace, double)"})
  void testExpandWithBlockFaceDouble_whenNorth_thenBoundingBoxMinBlockZIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(BlockFace.NORTH, 10.0d);

    // Assert
    Vector min = boundingBox.getMin();
    assertEquals(-10, min.getBlockZ());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-10, min2.getBlockZ());
    assertEquals(-10.0d, boundingBox.getMinZ());
    assertEquals(-10.0d, actualExpandResult.getMinZ());
    assertEquals(-10.0d, min.getZ());
    assertEquals(-10.0d, min2.getZ());
    Vector center = boundingBox.getCenter();
    assertEquals(-5, center.getBlockZ());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(-5, center2.getBlockZ());
    assertEquals(-5.0d, boundingBox.getCenterZ());
    assertEquals(-5.0d, actualExpandResult.getCenterZ());
    assertEquals(-5.0d, center.getZ());
    assertEquals(-5.0d, center2.getZ());
  }

  /**
   * Test {@link BoundingBox#expand(BlockFace, double)} with {@code BlockFace}, {@code double}.
   *
   * <ul>
   *   <li>When {@code SOUTH}.
   *   <li>Then {@link BoundingBox#BoundingBox()} MaxZ is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(BlockFace, double)}
   */
  @Test
  @DisplayName(
      "Test expand(BlockFace, double) with 'BlockFace', 'double'; when 'SOUTH'; then BoundingBox() MaxZ is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(BlockFace, double)"})
  void testExpandWithBlockFaceDouble_whenSouth_thenBoundingBoxMaxZIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(BlockFace.SOUTH, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getMaxZ());
    assertEquals(10.0d, actualExpandResult.getMaxZ());
    Vector max = boundingBox.getMax();
    assertEquals(10.0d, max.getZ());
    Vector max2 = actualExpandResult.getMax();
    assertEquals(10.0d, max2.getZ());
    Vector center = boundingBox.getCenter();
    assertEquals(5, center.getBlockZ());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(5, center2.getBlockZ());
    assertEquals(5.0d, boundingBox.getCenterZ());
    assertEquals(5.0d, actualExpandResult.getCenterZ());
    assertEquals(5.0d, center.getZ());
    assertEquals(5.0d, center2.getZ());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max.getBlockZ());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max2.getBlockZ());
  }

  /**
   * Test {@link BoundingBox#expand(BlockFace, double)} with {@code BlockFace}, {@code double}.
   *
   * <ul>
   *   <li>When {@code UP}.
   *   <li>Then {@link BoundingBox#BoundingBox()} MaxY is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(BlockFace, double)}
   */
  @Test
  @DisplayName(
      "Test expand(BlockFace, double) with 'BlockFace', 'double'; when 'UP'; then BoundingBox() MaxY is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(BlockFace, double)"})
  void testExpandWithBlockFaceDouble_whenUp_thenBoundingBoxMaxYIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(BlockFace.UP, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getMaxY());
    assertEquals(10.0d, actualExpandResult.getMaxY());
    Vector max = boundingBox.getMax();
    assertEquals(10.0d, max.getY());
    Vector max2 = actualExpandResult.getMax();
    assertEquals(10.0d, max2.getY());
    Vector center = boundingBox.getCenter();
    assertEquals(5, center.getBlockY());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(5, center2.getBlockY());
    assertEquals(5.0d, boundingBox.getCenterY());
    assertEquals(5.0d, actualExpandResult.getCenterY());
    assertEquals(5.0d, center.getY());
    assertEquals(5.0d, center2.getY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max.getBlockY());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max2.getBlockY());
  }

  /**
   * Test {@link BoundingBox#expand(BlockFace, double)} with {@code BlockFace}, {@code double}.
   *
   * <ul>
   *   <li>When {@code WEST}.
   *   <li>Then {@link BoundingBox#BoundingBox()} Min BlockX is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(BlockFace, double)}
   */
  @Test
  @DisplayName(
      "Test expand(BlockFace, double) with 'BlockFace', 'double'; when 'WEST'; then BoundingBox() Min BlockX is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(BlockFace, double)"})
  void testExpandWithBlockFaceDouble_whenWest_thenBoundingBoxMinBlockXIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(BlockFace.WEST, 10.0d);

    // Assert
    Vector min = boundingBox.getMin();
    assertEquals(-10, min.getBlockX());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-10, min2.getBlockX());
    assertEquals(-10.0d, boundingBox.getMinX());
    assertEquals(-10.0d, actualExpandResult.getMinX());
    assertEquals(-10.0d, min.getX());
    assertEquals(-10.0d, min2.getX());
    Vector center = boundingBox.getCenter();
    assertEquals(-5, center.getBlockX());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(-5, center2.getBlockX());
    assertEquals(-5.0d, boundingBox.getCenterX());
    assertEquals(-5.0d, actualExpandResult.getCenterX());
    assertEquals(-5.0d, center.getX());
    assertEquals(-5.0d, center2.getX());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble() {
    // Arrange and Act
    BoundingBox actualExpandResult = new BoundingBox().expand(0.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble2() {
    // Arrange and Act
    BoundingBox actualExpandResult = new BoundingBox().expand(10.0d, 0.0d, 10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    Vector min = boundingBox.getMin();
    assertEquals(-10, min.getBlockX());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-10, min2.getBlockX());
    assertEquals(-10.0d, boundingBox.getMinX());
    assertEquals(-10.0d, actualExpandResult.getMinX());
    assertEquals(-10.0d, min.getX());
    assertEquals(-10.0d, min2.getX());
    assertEquals(17.320508075688775d, min.length());
    assertEquals(17.320508075688775d, min2.length());
    assertEquals(20.0d, boundingBox.getWidthX());
    assertEquals(20.0d, actualExpandResult.getWidthX());
    assertEquals(8000.0d, boundingBox.getVolume());
    assertEquals(8000.0d, actualExpandResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    boundingBox.expand(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);

    // Assert
    assertEquals(0.0d, boundingBox.getMax().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble3() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, 0.0d, 0.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(1000.0d, boundingBox.getVolume());
    assertEquals(1000.0d, actualExpandResult.getVolume());
    assertEquals(8.660254037844387d, boundingBox.getCenter().length());
    assertEquals(8.660254037844387d, actualExpandResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble4() {
    // Arrange and Act
    BoundingBox actualExpandResult = new BoundingBox().expand(0.0d, 0.0d, 0.0d, 0.0d, 10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterX is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; then BoundingBox() CenterX is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_thenBoundingBoxCenterXIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(-10.0d, 10.0d, 10.0d, 0.5d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.5d, boundingBox.getCenterX());
    assertEquals(0.5d, actualExpandResult.getCenterX());
    assertEquals(0.5d, boundingBox.getMaxX());
    assertEquals(0.5d, actualExpandResult.getMaxX());
    assertEquals(0.5d, boundingBox.getMinX());
    assertEquals(0.5d, actualExpandResult.getMinX());
    Vector center = boundingBox.getCenter();
    assertEquals(0.5d, center.getX());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(0.5d, center2.getX());
    assertEquals(0.5d, boundingBox.getMax().getX());
    assertEquals(0.5d, actualExpandResult.getMax().getX());
    Vector min = boundingBox.getMin();
    assertEquals(0.5d, min.getX());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(0.5d, min2.getX());
    assertEquals(0.5d, center.length());
    assertEquals(0.5d, center2.length());
    assertEquals(14.150971698084906d, min.length());
    assertEquals(14.150971698084906d, min2.length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterY is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; then BoundingBox() CenterY is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_thenBoundingBoxCenterYIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, -10.0d, 10.0d, 10.0d, 0.5d, 10.0d);

    // Assert
    assertEquals(0.5d, boundingBox.getCenterY());
    assertEquals(0.5d, actualExpandResult.getCenterY());
    assertEquals(0.5d, boundingBox.getMaxY());
    assertEquals(0.5d, actualExpandResult.getMaxY());
    assertEquals(0.5d, boundingBox.getMinY());
    assertEquals(0.5d, actualExpandResult.getMinY());
    Vector center = boundingBox.getCenter();
    assertEquals(0.5d, center.getY());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(0.5d, center2.getY());
    assertEquals(0.5d, boundingBox.getMax().getY());
    assertEquals(0.5d, actualExpandResult.getMax().getY());
    Vector min = boundingBox.getMin();
    assertEquals(0.5d, min.getY());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(0.5d, min2.getY());
    assertEquals(10.012492197250394d, min.length());
    assertEquals(10.012492197250394d, min2.length());
    assertEquals(5.024937810560445d, center.length());
    assertEquals(5.024937810560445d, center2.length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; then BoundingBox() Max length is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_thenBoundingBoxMaxLengthIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getMax().length());
    assertEquals(10.0d, actualExpandResult.getMax().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Volume is {@code 2000.0}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; then BoundingBox() Volume is '2000.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_thenBoundingBoxVolumeIs20000() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, 0.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(2000.0d, boundingBox.getVolume());
    assertEquals(2000.0d, actualExpandResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Volume is {@code 4000.0}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; then BoundingBox() Volume is '4000.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_thenBoundingBoxVolumeIs40000() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(4000.0d, boundingBox.getVolume());
    assertEquals(4000.0d, actualExpandResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_when05() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(0.0d, 0.0d, 0.0d, 10.0d, 10.0d, -0.5d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_when052() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(0.0d, 0.0d, -0.5d, 10.0d, 10.0d, -0.5d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_when053() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(0.0d, 0.0d, -0.5d, 10.0d, 10.0d, 0.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_whenMinusTen() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(0.0d, 10.0d, 10.0d, -10.0d, 10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    assertEquals(min.toBlockVector().toBlockVector(), min.toBlockVector().toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i toVector3iResult3 = min.toVector3i();
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_whenMinusTen2() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(0.0d, 0.0d, 10.0d, 10.0d, -10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    assertEquals(min.toBlockVector().toBlockVector(), min.toBlockVector().toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i toVector3iResult3 = min.toVector3i();
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_whenMinusTen3() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(-10.0d, 10.0d, 10.0d, -10.0d, 10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    assertEquals(min.toBlockVector().toBlockVector(), min.toBlockVector().toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i toVector3iResult3 = min.toVector3i();
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double, double, double)} with {@code
   * double}, {@code double}, {@code double}, {@code double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double, double, double) with 'double', 'double', 'double', 'double', 'double', 'double'; when minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BoundingBox BoundingBox.expand(double, double, double, double, double, double)"
  })
  void testExpandWithDoubleDoubleDoubleDoubleDoubleDouble_whenMinusTen4() {
    // Arrange and Act
    BoundingBox actualExpandResult =
        new BoundingBox().expand(0.0d, -10.0d, 10.0d, 10.0d, -10.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    assertEquals(min.toBlockVector().toBlockVector(), min.toBlockVector().toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i toVector3iResult3 = min.toVector3i();
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center BlockX is minus one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'; then BoundingBox() Center BlockX is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble_thenBoundingBoxCenterBlockXIsMinusOne() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(-1.0E-10d, 10.0d, 10.0d, 10.0d);

    // Assert
    Vector center = boundingBox.getCenter();
    assertEquals(-1, center.getBlockX());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(-1, center2.getBlockX());
    Vector min = boundingBox.getMin();
    assertEquals(-1, min.getBlockX());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-1, min2.getBlockX());
    assertEquals(-1.0E-9d, boundingBox.getMinX());
    assertEquals(-1.0E-9d, actualExpandResult.getMinX());
    assertEquals(-1.0E-9d, min.getX());
    assertEquals(-1.0E-9d, min2.getX());
    assertEquals(-5.0E-10d, boundingBox.getCenterX());
    assertEquals(-5.0E-10d, actualExpandResult.getCenterX());
    assertEquals(-5.0E-10d, center.getX());
    assertEquals(-5.0E-10d, center2.getX());
    assertEquals(1.0E-9d, boundingBox.getWidthX());
    assertEquals(1.0E-9d, actualExpandResult.getWidthX());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center BlockY is minus one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'; then BoundingBox() Center BlockY is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble_thenBoundingBoxCenterBlockYIsMinusOne() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(10.0d, -1.0E-10d, 10.0d, 10.0d);

    // Assert
    Vector center = boundingBox.getCenter();
    assertEquals(-1, center.getBlockY());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(-1, center2.getBlockY());
    Vector min = boundingBox.getMin();
    assertEquals(-1, min.getBlockY());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-1, min2.getBlockY());
    assertEquals(-1.0E-9d, boundingBox.getMinY());
    assertEquals(-1.0E-9d, actualExpandResult.getMinY());
    assertEquals(-1.0E-9d, min.getY());
    assertEquals(-1.0E-9d, min2.getY());
    assertEquals(-5.0E-10d, boundingBox.getCenterY());
    assertEquals(-5.0E-10d, actualExpandResult.getCenterY());
    assertEquals(-5.0E-10d, center.getY());
    assertEquals(-5.0E-10d, center2.getY());
    assertEquals(1.0E-9d, boundingBox.getHeight());
    assertEquals(1.0E-9d, actualExpandResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center BlockZ is minus one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'; then BoundingBox() Center BlockZ is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble_thenBoundingBoxCenterBlockZIsMinusOne() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(10.0d, 10.0d, -1.0E-10d, 10.0d);

    // Assert
    Vector center = boundingBox.getCenter();
    assertEquals(-1, center.getBlockZ());
    Vector center2 = actualExpandResult.getCenter();
    assertEquals(-1, center2.getBlockZ());
    Vector min = boundingBox.getMin();
    assertEquals(-1, min.getBlockZ());
    Vector min2 = actualExpandResult.getMin();
    assertEquals(-1, min2.getBlockZ());
    assertEquals(-1.0E-9d, boundingBox.getMinZ());
    assertEquals(-1.0E-9d, actualExpandResult.getMinZ());
    assertEquals(-1.0E-9d, min.getZ());
    assertEquals(-1.0E-9d, min2.getZ());
    assertEquals(-5.0E-10d, boundingBox.getCenterZ());
    assertEquals(-5.0E-10d, actualExpandResult.getCenterZ());
    assertEquals(-5.0E-10d, center.getZ());
    assertEquals(-5.0E-10d, center2.getZ());
    assertEquals(1.0E-9d, boundingBox.getWidthZ());
    assertEquals(1.0E-9d, actualExpandResult.getWidthZ());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center toVector3d z is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'; then BoundingBox() Center toVector3d z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble_thenBoundingBoxCenterToVector3dZIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(10.0d, 10.0d, 0.0d, 10.0d);

    // Assert
    Vector center = boundingBox.getCenter();
    Vector3d toVector3dResult = center.toVector3d();
    assertEquals(0.0d, toVector3dResult.z());
    Vector center2 = actualExpandResult.getCenter();
    Vector3d toVector3dResult2 = center2.toVector3d();
    assertEquals(0.0d, toVector3dResult2.z());
    assertEquals(0.0d, toVector3dResult.z);
    assertEquals(0.0d, toVector3dResult2.z);
    Vector3f toVector3fResult = center.toVector3f();
    assertEquals(0.0f, toVector3fResult.z());
    Vector3f toVector3fResult2 = center2.toVector3f();
    assertEquals(0.0f, toVector3fResult2.z());
    assertEquals(0.0f, toVector3fResult.z);
    assertEquals(0.0f, toVector3fResult2.z);
    BlockVector toBlockVectorResult = center2.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center2.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d actualAbsoluteResult = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult);
    Vector3d toVector3dResult3 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult2);
    Vector3d toVector3dResult4 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult4.absolute();
    assertSame(toVector3dResult4, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult4.normalize();
    assertSame(toVector3dResult4, actualNormalizeResult3);
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3f toVector3fResult3 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult5);
    Vector3f toVector3fResult4 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult4.absolute();
    assertSame(toVector3fResult4, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult4.ceil();
    assertSame(toVector3fResult4, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult4.floor();
    assertSame(toVector3fResult4, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult4.normalize();
    assertSame(toVector3fResult4, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is one hundred.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'; then BoundingBox() Max length is one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble_thenBoundingBoxMaxLengthIsOneHundred() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, 0.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(100.0d, boundingBox.getMax().length());
    assertEquals(100.0d, actualExpandResult.getMax().length());
    assertEquals(50.0d, boundingBox.getCenter().length());
    assertEquals(50.0d, actualExpandResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double, double)} with {@code double}, {@code
   * double}, {@code double}, {@code double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BoundingBox#BoundingBox()} Volume is {@code 1000000.0}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double, double) with 'double', 'double', 'double', 'double'; when ten; then BoundingBox() Volume is '1000000.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double, double)"})
  void testExpandWithDoubleDoubleDoubleDouble_whenTen_thenBoundingBoxVolumeIs10000000() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(1000000.0d, boundingBox.getVolume());
    assertEquals(1000000.0d, actualExpandResult.getVolume());
    assertEquals(173.20508075688772d, boundingBox.getMax().length());
    assertEquals(173.20508075688772d, actualExpandResult.getMax().length());
    assertEquals(86.60254037844386d, boundingBox.getCenter().length());
    assertEquals(86.60254037844386d, actualExpandResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is {@code 10.63014581273465}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; then BoundingBox() Max length is '10.63014581273465'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_thenBoundingBoxMaxLengthIs1063014581273465() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(10.63014581273465d, boundingBox.getMax().length());
    assertEquals(10.63014581273465d, actualExpandResult.getMax().length());
    assertEquals(10.63014581273465d, boundingBox.getMin().length());
    assertEquals(10.63014581273465d, actualExpandResult.getMin().length());
    assertEquals(480.0d, boundingBox.getVolume());
    assertEquals(480.0d, actualExpandResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is {@code 3.605551275463989}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; then BoundingBox() Max length is '3.605551275463989'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_thenBoundingBoxMaxLengthIs3605551275463989() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(2.0d, 3.0d, -2.0d);

    // Assert
    assertEquals(3.605551275463989d, boundingBox.getMax().length());
    assertEquals(3.605551275463989d, actualExpandResult.getMax().length());
    assertEquals(3.605551275463989d, boundingBox.getMin().length());
    assertEquals(3.605551275463989d, actualExpandResult.getMin().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is {@code 10.198039027185569}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; then BoundingBox() Max length is '10.198039027185569'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_thenBoundingBoxMaxLengthIs10198039027185569() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(2.0d, -2.0d, 10.0d);

    // Assert
    assertEquals(10.198039027185569d, boundingBox.getMax().length());
    assertEquals(10.198039027185569d, actualExpandResult.getMax().length());
    assertEquals(10.198039027185569d, boundingBox.getMin().length());
    assertEquals(10.198039027185569d, actualExpandResult.getMin().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_thenReturnCenterToBlockVectorToBlockVector() {
    // Arrange and Act
    BoundingBox actualExpandResult = new BoundingBox().expand(-2.0d, 3.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    assertEquals(min.toBlockVector().toBlockVector(), min.toBlockVector().toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i toVector3iResult3 = min.toVector3i();
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_thenReturnCenterToBlockVectorToBlockVector2() {
    // Arrange and Act
    BoundingBox actualExpandResult = new BoundingBox().expand(0.0d, 3.0d, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    assertEquals(min.toBlockVector().toBlockVector(), min.toBlockVector().toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i toVector3iResult3 = min.toVector3i();
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; when zero; then BoundingBox() Max length is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_whenZero_thenBoundingBoxMaxLengthIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(0.0d, 0.0d, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getMax().length());
    assertEquals(10.0d, actualExpandResult.getMax().length());
    assertEquals(10.0d, boundingBox.getMin().length());
    assertEquals(10.0d, actualExpandResult.getMin().length());
  }

  /**
   * Test {@link BoundingBox#expand(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expand(double, double, double) with 'double', 'double', 'double'; when zero; then BoundingBox() Max length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double, double, double)"})
  void testExpandWithDoubleDoubleDouble_whenZero_thenBoundingBoxMaxLengthIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    boundingBox.expand(0.0d, 0.0d, 0.0d);

    // Assert
    assertEquals(0.0d, boundingBox.getMax().length());
    assertEquals(0.0d, boundingBox.getMin().length());
  }

  /**
   * Test {@link BoundingBox#expand(double)} with {@code double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BoundingBox#BoundingBox()} MinX is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(double)}
   */
  @Test
  @DisplayName("Test expand(double) with 'double'; when ten; then BoundingBox() MinX is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(double)"})
  void testExpandWithDouble_whenTen_thenBoundingBoxMinXIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(10.0d);

    // Assert
    assertEquals(-10.0d, boundingBox.getMinX());
    assertEquals(-10.0d, actualExpandResult.getMinX());
    assertEquals(-10.0d, boundingBox.getMinY());
    assertEquals(-10.0d, actualExpandResult.getMinY());
    assertEquals(-10.0d, boundingBox.getMinZ());
    assertEquals(-10.0d, actualExpandResult.getMinZ());
    assertEquals(10.0d, boundingBox.getMaxX());
    assertEquals(10.0d, actualExpandResult.getMaxX());
    assertEquals(10.0d, boundingBox.getMaxY());
    assertEquals(10.0d, actualExpandResult.getMaxY());
    assertEquals(10.0d, boundingBox.getMaxZ());
    assertEquals(10.0d, actualExpandResult.getMaxZ());
    assertEquals(20.0d, boundingBox.getHeight());
    assertEquals(20.0d, actualExpandResult.getHeight());
    assertEquals(20.0d, boundingBox.getWidthX());
    assertEquals(20.0d, actualExpandResult.getWidthX());
    assertEquals(20.0d, boundingBox.getWidthZ());
    assertEquals(20.0d, actualExpandResult.getWidthZ());
    assertEquals(8000.0d, boundingBox.getVolume());
    assertEquals(8000.0d, actualExpandResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName("Test expand(Vector, double) with 'Vector', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BlockVector direction = new BlockVector();

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    assertEquals(direction, center.toBlockVector().toBlockVector());
    assertEquals(center, actualExpandResult.getMax());
    assertEquals(center, actualExpandResult.getMin());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link BlockVector#BlockVector()} Z is one.
   *   <li>Then return MaxZ is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; given one; when BlockVector() Z is one; then return MaxZ is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_givenOne_whenBlockVectorZIsOne_thenReturnMaxZIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setZ(1);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    assertEquals(10.0d, actualExpandResult.getMaxZ());
    Vector max = actualExpandResult.getMax();
    assertEquals(10.0d, max.getZ());
    assertEquals(10.0d, max.length());
    Vector center = actualExpandResult.getCenter();
    assertEquals(5, center.getBlockZ());
    assertEquals(5.0d, actualExpandResult.getCenterZ());
    assertEquals(5.0d, center.getZ());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max.getBlockZ());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return Center BlockY is fifteen.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; given three; then return Center BlockY is fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_givenThree_thenReturnCenterBlockYIsFifteen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setY(3);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    assertEquals(15, center.getBlockY());
    assertEquals(15.0d, actualExpandResult.getCenterY());
    assertEquals(15.0d, center.getY());
    assertEquals(15.0d, center.length());
    Vector max = actualExpandResult.getMax();
    assertEquals(30, max.getBlockY());
    assertEquals(30.0d, actualExpandResult.getHeight());
    assertEquals(30.0d, actualExpandResult.getMaxY());
    assertEquals(30.0d, max.getY());
    assertEquals(30.0d, max.length());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link BlockVector#BlockVector()} X is two.
   *   <li>Then return CenterX is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; given two; when BlockVector() X is two; then return CenterX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_givenTwo_whenBlockVectorXIsTwo_thenReturnCenterXIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setX(2);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    assertEquals(10.0d, actualExpandResult.getCenterX());
    Vector center = actualExpandResult.getCenter();
    assertEquals(10.0d, center.getX());
    assertEquals(10.0d, center.length());
    assertEquals(20.0d, actualExpandResult.getMaxX());
    assertEquals(20.0d, actualExpandResult.getWidthX());
    Vector max = actualExpandResult.getMax();
    assertEquals(20.0d, max.getX());
    assertEquals(20.0d, max.length());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, center.getBlockX());
    assertEquals(ChatPaginator.OPEN_CHAT_PAGE_HEIGHT, max.getBlockX());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>Then return Min BlockX is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; then return Min BlockX is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_thenReturnMinBlockXIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setX(-1);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    Vector min = actualExpandResult.getMin();
    assertEquals(-10, min.getBlockX());
    BlockVector toBlockVectorResult = min.toBlockVector();
    assertEquals(-10, toBlockVectorResult.getBlockX());
    assertEquals(-10.0d, actualExpandResult.getMinX());
    assertEquals(-10.0d, min.getX());
    assertEquals(-10.0d, toBlockVectorResult.getX());
    Vector center = actualExpandResult.getCenter();
    assertEquals(-5, center.getBlockX());
    BlockVector toBlockVectorResult2 = center.toBlockVector();
    assertEquals(-5, toBlockVectorResult2.getBlockX());
    assertEquals(-5.0d, actualExpandResult.getCenterX());
    assertEquals(-5.0d, center.getX());
    assertEquals(-5.0d, toBlockVectorResult2.getX());
    assertEquals(10.0d, actualExpandResult.getWidthX());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>Then return Min BlockY is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; then return Min BlockY is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_thenReturnMinBlockYIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setY(-1);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    Vector min = actualExpandResult.getMin();
    assertEquals(-10, min.getBlockY());
    BlockVector toBlockVectorResult = min.toBlockVector();
    assertEquals(-10, toBlockVectorResult.getBlockY());
    assertEquals(-10.0d, actualExpandResult.getMinY());
    assertEquals(-10.0d, min.getY());
    assertEquals(-10.0d, toBlockVectorResult.getY());
    Vector center = actualExpandResult.getCenter();
    assertEquals(-5, center.getBlockY());
    BlockVector toBlockVectorResult2 = center.toBlockVector();
    assertEquals(-5, toBlockVectorResult2.getBlockY());
    assertEquals(-5.0d, actualExpandResult.getCenterY());
    assertEquals(-5.0d, center.getY());
    assertEquals(-5.0d, toBlockVectorResult2.getY());
    assertEquals(10.0d, actualExpandResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>Then return Min BlockZ is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; then return Min BlockZ is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_thenReturnMinBlockZIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setZ(-1);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(direction, 10.0d);

    // Assert
    Vector min = actualExpandResult.getMin();
    assertEquals(-10, min.getBlockZ());
    BlockVector toBlockVectorResult = min.toBlockVector();
    assertEquals(-10, toBlockVectorResult.getBlockZ());
    assertEquals(-10.0d, actualExpandResult.getMinZ());
    assertEquals(-10.0d, min.getZ());
    assertEquals(-10.0d, toBlockVectorResult.getZ());
    Vector center = actualExpandResult.getCenter();
    assertEquals(-5, center.getBlockZ());
    BlockVector toBlockVectorResult2 = center.toBlockVector();
    assertEquals(-5, toBlockVectorResult2.getBlockZ());
    assertEquals(-5.0d, actualExpandResult.getCenterZ());
    assertEquals(-5.0d, center.getZ());
    assertEquals(-5.0d, toBlockVectorResult2.getZ());
  }

  /**
   * Test {@link BoundingBox#expand(Vector, double)} with {@code Vector}, {@code double}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector, double)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector, double) with 'Vector', 'double'; when Random; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector, double)"})
  void testExpandWithVectorDouble_whenRandom_thenReturnCenterToBlockVectorToBlockVector() {
    // Arrange and Act
    BoundingBox actualExpandResult = new BoundingBox().expand(Vector.getRandom(), 10.0d);

    // Assert
    Vector center = actualExpandResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expand(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Then return Center is {@link Vector#Vector(double, double, double)} with x is zero and y
   *       is zero and z is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector) with 'Vector'; then return Center is Vector(double, double, double) with x is zero and y is zero and z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector)"})
  void testExpandWithVector_thenReturnCenterIsVectorWithXIsZeroAndYIsZeroAndZIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector expansion = new Vector(0.0d, 0.0d, 0.0d);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(expansion);

    // Assert
    assertEquals(expansion, actualExpandResult.getCenter());
    assertEquals(expansion, actualExpandResult.getMax());
    assertEquals(expansion, actualExpandResult.getMin());
  }

  /**
   * Test {@link BoundingBox#expand(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Then return Min BlockY is minus three.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector)}
   */
  @Test
  @DisplayName("Test expand(Vector) with 'Vector'; then return Min BlockY is minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector)"})
  void testExpandWithVector_thenReturnMinBlockYIsMinusThree() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector expansion = new Vector(0.0d, 3.0d, 0.0d);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(expansion);

    // Assert
    Vector min = actualExpandResult.getMin();
    assertEquals(-3, min.getBlockY());
    assertEquals(-3.0d, actualExpandResult.getMinY());
    assertEquals(-3.0d, min.getY());
    assertEquals(3.0d, actualExpandResult.getMaxY());
    assertEquals(3.0d, min.length());
    assertEquals(6.0d, actualExpandResult.getHeight());
    assertEquals(expansion, actualExpandResult.getMax());
  }

  /**
   * Test {@link BoundingBox#expand(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Then return Min BlockZ is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector)}
   */
  @Test
  @DisplayName("Test expand(Vector) with 'Vector'; then return Min BlockZ is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector)"})
  void testExpandWithVector_thenReturnMinBlockZIsMinusTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector expansion = new Vector(0.0d, 0.0d, 10.0d);

    // Act
    BoundingBox actualExpandResult = boundingBox.expand(expansion);

    // Assert
    Vector min = actualExpandResult.getMin();
    assertEquals(-10, min.getBlockZ());
    assertEquals(-10.0d, actualExpandResult.getMinZ());
    assertEquals(-10.0d, min.getZ());
    assertEquals(10.0d, actualExpandResult.getMaxZ());
    assertEquals(10.0d, min.length());
    assertEquals(20.0d, actualExpandResult.getWidthZ());
    assertEquals(expansion, actualExpandResult.getMax());
  }

  /**
   * Test {@link BoundingBox#expand(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Min BlockX is minus one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expand(Vector)}
   */
  @Test
  @DisplayName(
      "Test expand(Vector) with 'Vector'; when Random; then return Min BlockX is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expand(Vector)"})
  void testExpandWithVector_whenRandom_thenReturnMinBlockXIsMinusOne() {
    // Arrange
    Vector expansion = Vector.getRandom();

    // Act
    BoundingBox actualExpandResult = new BoundingBox().expand(expansion);

    // Assert
    Vector min = actualExpandResult.getMin();
    assertEquals(-1, min.getBlockX());
    assertEquals(-1, min.getBlockY());
    assertEquals(-1, min.getBlockZ());
    assertEquals(expansion, actualExpandResult.getMax());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center toVector3d z is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; then BoundingBox() Center toVector3d z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_thenBoundingBoxCenterToVector3dZIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(10.0d, 10.0d, 0.0d);

    // Assert
    Vector center = boundingBox.getCenter();
    Vector3d toVector3dResult = center.toVector3d();
    assertEquals(0.0d, toVector3dResult.z());
    Vector center2 = actualExpandDirectionalResult.getCenter();
    Vector3d toVector3dResult2 = center2.toVector3d();
    assertEquals(0.0d, toVector3dResult2.z());
    assertEquals(0.0d, toVector3dResult.z);
    assertEquals(0.0d, toVector3dResult2.z);
    Vector3f toVector3fResult = center.toVector3f();
    assertEquals(0.0f, toVector3fResult.z());
    Vector3f toVector3fResult2 = center2.toVector3f();
    assertEquals(0.0f, toVector3fResult2.z());
    assertEquals(0.0f, toVector3fResult.z);
    assertEquals(0.0f, toVector3fResult2.z);
    BlockVector toBlockVectorResult = center2.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandDirectionalResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandDirectionalResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center2.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d actualAbsoluteResult = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult);
    Vector3d toVector3dResult3 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult2);
    Vector3d toVector3dResult4 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult4.absolute();
    assertSame(toVector3dResult4, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult4.normalize();
    assertSame(toVector3dResult4, actualNormalizeResult3);
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3f toVector3fResult3 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult5);
    Vector3f toVector3fResult4 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult4.absolute();
    assertSame(toVector3fResult4, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult4.ceil();
    assertSame(toVector3fResult4, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult4.floor();
    assertSame(toVector3fResult4, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult4.normalize();
    assertSame(toVector3fResult4, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_thenReturnCenterToBlockVectorToBlockVector() {
    // Arrange and Act
    BoundingBox actualExpandDirectionalResult =
        new BoundingBox().expandDirectional(0.0d, 10.0d, 10.0d);

    // Assert
    Vector center = actualExpandDirectionalResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandDirectionalResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandDirectionalResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_thenReturnCenterToBlockVectorToBlockVector2() {
    // Arrange and Act
    BoundingBox actualExpandDirectionalResult =
        new BoundingBox().expandDirectional(10.0d, 0.0d, 10.0d);

    // Assert
    Vector center = actualExpandDirectionalResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualExpandDirectionalResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualExpandDirectionalResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterX is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; when '-0.5'; then BoundingBox() CenterX is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_when05_thenBoundingBoxCenterXIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(-0.5d, 10.0d, 10.0d);

    // Assert
    assertEquals(-0.25d, boundingBox.getCenterX());
    assertEquals(-0.25d, actualExpandDirectionalResult.getCenterX());
    Vector center = boundingBox.getCenter();
    assertEquals(-0.25d, center.getX());
    Vector center2 = actualExpandDirectionalResult.getCenter();
    assertEquals(-0.25d, center2.getX());
    assertEquals(-0.5d, boundingBox.getMinX());
    assertEquals(-0.5d, actualExpandDirectionalResult.getMinX());
    Vector min = boundingBox.getMin();
    assertEquals(-0.5d, min.getX());
    Vector min2 = actualExpandDirectionalResult.getMin();
    assertEquals(-0.5d, min2.getX());
    assertEquals(-1, center.getBlockX());
    assertEquals(-1, center2.getBlockX());
    assertEquals(-1, min.getBlockX());
    assertEquals(-1, min2.getBlockX());
    assertEquals(0.5d, boundingBox.getWidthX());
    assertEquals(0.5d, actualExpandDirectionalResult.getWidthX());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterY is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; when '-0.5'; then BoundingBox() CenterY is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_when05_thenBoundingBoxCenterYIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(10.0d, -0.5d, 10.0d);

    // Assert
    assertEquals(-0.25d, boundingBox.getCenterY());
    assertEquals(-0.25d, actualExpandDirectionalResult.getCenterY());
    Vector center = boundingBox.getCenter();
    assertEquals(-0.25d, center.getY());
    Vector center2 = actualExpandDirectionalResult.getCenter();
    assertEquals(-0.25d, center2.getY());
    assertEquals(-0.5d, boundingBox.getMinY());
    assertEquals(-0.5d, actualExpandDirectionalResult.getMinY());
    Vector min = boundingBox.getMin();
    assertEquals(-0.5d, min.getY());
    Vector min2 = actualExpandDirectionalResult.getMin();
    assertEquals(-0.5d, min2.getY());
    assertEquals(-1, center.getBlockY());
    assertEquals(-1, center2.getBlockY());
    assertEquals(-1, min.getBlockY());
    assertEquals(-1, min2.getBlockY());
    assertEquals(0.5d, boundingBox.getHeight());
    assertEquals(0.5d, actualExpandDirectionalResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterZ is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; when '-0.5'; then BoundingBox() CenterZ is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_when05_thenBoundingBoxCenterZIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(10.0d, 10.0d, -0.5d);

    // Assert
    assertEquals(-0.25d, boundingBox.getCenterZ());
    assertEquals(-0.25d, actualExpandDirectionalResult.getCenterZ());
    Vector center = boundingBox.getCenter();
    assertEquals(-0.25d, center.getZ());
    Vector center2 = actualExpandDirectionalResult.getCenter();
    assertEquals(-0.25d, center2.getZ());
    assertEquals(-0.5d, boundingBox.getMinZ());
    assertEquals(-0.5d, actualExpandDirectionalResult.getMinZ());
    Vector min = boundingBox.getMin();
    assertEquals(-0.5d, min.getZ());
    Vector min2 = actualExpandDirectionalResult.getMin();
    assertEquals(-0.5d, min2.getZ());
    assertEquals(-1, center.getBlockZ());
    assertEquals(-1, center2.getBlockZ());
    assertEquals(-1, min.getBlockZ());
    assertEquals(-1, min2.getBlockZ());
    assertEquals(0.5d, boundingBox.getWidthZ());
    assertEquals(0.5d, actualExpandDirectionalResult.getWidthZ());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BoundingBox#BoundingBox()} Volume is one thousand.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; when ten; then BoundingBox() Volume is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_whenTen_thenBoundingBoxVolumeIsOneThousand() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(1000.0d, boundingBox.getVolume());
    assertEquals(1000.0d, actualExpandDirectionalResult.getVolume());
    assertEquals(17.320508075688775d, boundingBox.getMax().length());
    assertEquals(17.320508075688775d, actualExpandDirectionalResult.getMax().length());
    assertEquals(8.660254037844387d, boundingBox.getCenter().length());
    assertEquals(8.660254037844387d, actualExpandDirectionalResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(double, double, double)} with {@code dirX}, {@code
   * dirY}, {@code dirZ}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link BoundingBox#BoundingBox()} Max length is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(double, double, double) with 'dirX', 'dirY', 'dirZ'; when zero; then BoundingBox() Max length is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(double, double, double)"})
  void testExpandDirectionalWithDirXDirYDirZ_whenZero_thenBoundingBoxMaxLengthIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(0.0d, 0.0d, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getMax().length());
    assertEquals(10.0d, actualExpandDirectionalResult.getMax().length());
    assertEquals(5.0d, boundingBox.getCenter().length());
    assertEquals(5.0d, actualExpandDirectionalResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Given {@link Double#NaN}.
   *   <li>When {@link BlockVector#BlockVector()} X is {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(Vector) with 'direction'; given NaN; when BlockVector() X is NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_givenNaN_whenBlockVectorXIsNaN() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setX(Double.NaN);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(0.0d, center.length());
    assertEquals(0.0d, center.toVector3d().length());
    assertEquals(0.0f, center.toVector3f().length());
    assertTrue(center.isZero());
    assertEquals(direction, center.toBlockVector());
    assertEquals(center, actualExpandDirectionalResult.getMin());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CenterZ is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(Vector) with 'direction'; given one; then return CenterZ is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_givenOne_thenReturnCenterZIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setZ(1);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    assertEquals(0.5d, actualExpandDirectionalResult.getCenterZ());
    assertEquals(0.5d, actualExpandDirectionalResult.getCenter().getZ());
    Vector max = actualExpandDirectionalResult.getMax();
    assertEquals(1, max.getBlockZ());
    assertEquals(1.0d, actualExpandDirectionalResult.getMaxZ());
    assertEquals(1.0d, max.getZ());
    assertEquals(1.0d, max.length());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return Center BlockY is one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(Vector) with 'direction'; given three; then return Center BlockY is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_givenThree_thenReturnCenterBlockYIsOne() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setY(3);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(1, center.getBlockY());
    assertEquals(1.5d, actualExpandDirectionalResult.getCenterY());
    assertEquals(1.5d, center.getY());
    assertEquals(1.5d, center.length());
    Vector max = actualExpandDirectionalResult.getMax();
    assertEquals(3, max.getBlockY());
    assertEquals(3.0d, actualExpandDirectionalResult.getHeight());
    assertEquals(3.0d, actualExpandDirectionalResult.getMaxY());
    assertEquals(3.0d, max.getY());
    assertEquals(3.0d, max.length());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return Center BlockX is one.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(Vector) with 'direction'; given two; then return Center BlockX is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_givenTwo_thenReturnCenterBlockXIsOne() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setX(2);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(1, center.getBlockX());
    assertEquals(1.0d, actualExpandDirectionalResult.getCenterX());
    assertEquals(1.0d, center.getX());
    assertEquals(1.0d, center.length());
    Vector max = actualExpandDirectionalResult.getMax();
    assertEquals(2, max.getBlockX());
    assertEquals(2.0d, actualExpandDirectionalResult.getMaxX());
    assertEquals(2.0d, actualExpandDirectionalResult.getWidthX());
    assertEquals(2.0d, max.getX());
    assertEquals(2.0d, max.length());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Then return CenterX is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName("Test expandDirectional(Vector) with 'direction'; then return CenterX is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_thenReturnCenterXIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setX(-1);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    assertEquals(-0.5d, actualExpandDirectionalResult.getCenterX());
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(-0.5d, center.getX());
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(-0.5d, toBlockVectorResult.getX());
    assertEquals(-1, center.getBlockX());
    Vector min = actualExpandDirectionalResult.getMin();
    assertEquals(-1, min.getBlockX());
    assertEquals(-1, toBlockVectorResult.getBlockX());
    BlockVector toBlockVectorResult2 = min.toBlockVector();
    assertEquals(-1, toBlockVectorResult2.getBlockX());
    assertEquals(-1.0d, actualExpandDirectionalResult.getMinX());
    assertEquals(-1.0d, min.getX());
    assertEquals(-1.0d, toBlockVectorResult2.getX());
    assertEquals(1.0d, actualExpandDirectionalResult.getWidthX());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Then return CenterY is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName("Test expandDirectional(Vector) with 'direction'; then return CenterY is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_thenReturnCenterYIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setY(-1);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    assertEquals(-0.5d, actualExpandDirectionalResult.getCenterY());
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(-0.5d, center.getY());
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(-0.5d, toBlockVectorResult.getY());
    assertEquals(-1, center.getBlockY());
    Vector min = actualExpandDirectionalResult.getMin();
    assertEquals(-1, min.getBlockY());
    assertEquals(-1, toBlockVectorResult.getBlockY());
    BlockVector toBlockVectorResult2 = min.toBlockVector();
    assertEquals(-1, toBlockVectorResult2.getBlockY());
    assertEquals(-1.0d, actualExpandDirectionalResult.getMinY());
    assertEquals(-1.0d, min.getY());
    assertEquals(-1.0d, toBlockVectorResult2.getY());
    assertEquals(1.0d, actualExpandDirectionalResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>Then return CenterZ is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName("Test expandDirectional(Vector) with 'direction'; then return CenterZ is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_thenReturnCenterZIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    BlockVector direction = new BlockVector();
    direction.setZ(-1);

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    assertEquals(-0.5d, actualExpandDirectionalResult.getCenterZ());
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(-0.5d, center.getZ());
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(-0.5d, toBlockVectorResult.getZ());
    assertEquals(-1, center.getBlockZ());
    Vector min = actualExpandDirectionalResult.getMin();
    assertEquals(-1, min.getBlockZ());
    assertEquals(-1, toBlockVectorResult.getBlockZ());
    BlockVector toBlockVectorResult2 = min.toBlockVector();
    assertEquals(-1, toBlockVectorResult2.getBlockZ());
    assertEquals(-1.0d, actualExpandDirectionalResult.getMinZ());
    assertEquals(-1.0d, min.getZ());
    assertEquals(-1.0d, toBlockVectorResult2.getZ());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector()}.
   *   <li>Then return Center length is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(Vector) with 'direction'; when BlockVector(); then return Center length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_whenBlockVector_thenReturnCenterLengthIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BlockVector direction = new BlockVector();

    // Act
    BoundingBox actualExpandDirectionalResult = boundingBox.expandDirectional(direction);

    // Assert
    Vector center = actualExpandDirectionalResult.getCenter();
    assertEquals(0.0d, center.length());
    assertEquals(0.0d, center.toVector3d().length());
    assertEquals(0.0f, center.toVector3f().length());
    assertTrue(center.isZero());
    assertEquals(direction, center.toBlockVector());
    assertEquals(center, actualExpandDirectionalResult.getMin());
  }

  /**
   * Test {@link BoundingBox#expandDirectional(Vector)} with {@code direction}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Max is Random.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#expandDirectional(Vector)}
   */
  @Test
  @DisplayName(
      "Test expandDirectional(Vector) with 'direction'; when Random; then return Max is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.expandDirectional(Vector)"})
  void testExpandDirectionalWithDirection_whenRandom_thenReturnMaxIsRandom() {
    // Arrange
    Vector direction = Vector.getRandom();

    // Act and Assert
    assertEquals(direction, new BoundingBox().expandDirectional(direction).getMax());
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName("Test union(BoundingBox) with 'BoundingBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(0.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(new BoundingBox());

    // Assert
    assertSame(boundingBox, actualUnionResult);
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName("Test union(BoundingBox) with 'BoundingBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(0.0d, 0.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(new BoundingBox());

    // Assert
    assertSame(boundingBox, actualUnionResult);
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName("Test union(BoundingBox) with 'BoundingBox'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox3() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 1.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(other);

    // Assert
    assertSame(boundingBox, actualUnionResult);
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>Then return CenterX is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName(
      "Test union(BoundingBox) with 'BoundingBox'; given BoundingBox(); then return CenterX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox_givenBoundingBox_thenReturnCenterXIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(new BoundingBox());

    // Assert
    assertEquals(0.0d, actualUnionResult.getCenterX());
    assertEquals(0.0d, actualUnionResult.getCenterY());
    assertEquals(0.0d, actualUnionResult.getCenterZ());
    assertEquals(0.0d, actualUnionResult.getHeight());
    assertEquals(0.0d, actualUnionResult.getMaxX());
    assertEquals(0.0d, actualUnionResult.getMaxY());
    assertEquals(0.0d, actualUnionResult.getMaxZ());
    assertEquals(0.0d, actualUnionResult.getWidthX());
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <ul>
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName(
      "Test union(BoundingBox) with 'BoundingBox'; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox_thenReturnCenterToBlockVectorToBlockVector() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(new BoundingBox());

    // Assert
    Vector center = actualUnionResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualUnionResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualUnionResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <ul>
   *   <li>Then return Center toBlockVector toBlockVector.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName(
      "Test union(BoundingBox) with 'BoundingBox'; then return Center toBlockVector toBlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox_thenReturnCenterToBlockVectorToBlockVector2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(other);

    // Assert
    Vector center = actualUnionResult.getCenter();
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector max = actualUnionResult.getMax();
    BlockVector toBlockVectorResult2 = max.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector min = actualUnionResult.getMin();
    BlockVector toBlockVectorResult3 = min.toBlockVector();
    assertEquals(toBlockVectorResult3.toBlockVector(), toBlockVectorResult3.toBlockVector());
    Vector3i toVector3iResult = center.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = max.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3i toVector3iResult3 = min.toVector3i();
    assertEquals(toVector3iResult3, toBlockVectorResult3.toVector3i());
    Vector3d toVector3dResult = center.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = max.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3d toVector3dResult3 = min.toVector3d();
    Vector3d actualAbsoluteResult3 = toVector3dResult3.absolute();
    assertSame(toVector3dResult3, actualAbsoluteResult3);
    Vector3d actualNormalizeResult3 = toVector3dResult3.normalize();
    assertSame(toVector3dResult3, actualNormalizeResult3);
    Vector3f toVector3fResult = center.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult4);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult4 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult4);
    Vector3f toVector3fResult2 = max.toVector3f();
    Vector3f actualAbsoluteResult5 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult5);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult5 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult5);
    Vector3f toVector3fResult3 = min.toVector3f();
    Vector3f actualAbsoluteResult6 = toVector3fResult3.absolute();
    assertSame(toVector3fResult3, actualAbsoluteResult6);
    Vector3f actualCeilResult3 = toVector3fResult3.ceil();
    assertSame(toVector3fResult3, actualCeilResult3);
    Vector3f actualFloorResult3 = toVector3fResult3.floor();
    assertSame(toVector3fResult3, actualFloorResult3);
    Vector3f actualNormalizeResult6 = toVector3fResult3.normalize();
    assertSame(toVector3fResult3, actualNormalizeResult6);
    Vector3i actualAbsoluteResult7 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult7);
    Vector3i actualAbsoluteResult8 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult8);
    Vector3i actualAbsoluteResult9 = toVector3iResult3.absolute();
    assertSame(toVector3iResult3, actualAbsoluteResult9);
  }

  /**
   * Test {@link BoundingBox#union(BoundingBox)} with {@code BoundingBox}.
   *
   * <ul>
   *   <li>Then return MinY is three.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(BoundingBox)}
   */
  @Test
  @DisplayName("Test union(BoundingBox) with 'BoundingBox'; then return MinY is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(BoundingBox)"})
  void testUnionWithBoundingBox_thenReturnMinYIsThree() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, Double.MAX_VALUE, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(other);

    // Assert
    assertEquals(3.0d, actualUnionResult.getMinY());
    assertEquals(6.5d, actualUnionResult.getCenterY());
    assertEquals(7.0d, actualUnionResult.getHeight());
    assertEquals(8.988465674311579E307d, actualUnionResult.getCenterZ());
    assertEquals(boundingBox, other);
    assertEquals(Double.MAX_VALUE, actualUnionResult.getMaxZ());
    assertEquals(Double.MAX_VALUE, actualUnionResult.getWidthZ());
    assertEquals(Double.POSITIVE_INFINITY, actualUnionResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName("Test union(double, double, double) with 'double', 'double', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.0d, boundingBox.getWidthZ());
    assertEquals(10.0d, boundingBox.getCenterZ());
    assertSame(boundingBox, actualUnionResult);
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center length is {@code 7.0710678118654755}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test union(double, double, double) with 'double', 'double', 'double'; then BoundingBox() Center length is '7.0710678118654755'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble_thenBoundingBoxCenterLengthIs70710678118654755() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(0.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(7.0710678118654755d, boundingBox.getCenter().length());
    assertEquals(7.0710678118654755d, actualUnionResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Volume is one thousand.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test union(double, double, double) with 'double', 'double', 'double'; then BoundingBox() Volume is one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble_thenBoundingBoxVolumeIsOneThousand() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(1000.0d, boundingBox.getVolume());
    assertEquals(1000.0d, actualUnionResult.getVolume());
    assertEquals(17.320508075688775d, boundingBox.getMax().length());
    assertEquals(8.660254037844387d, boundingBox.getCenter().length());
    assertEquals(8.660254037844387d, actualUnionResult.getCenter().length());
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterX is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test union(double, double, double) with 'double', 'double', 'double'; when '-0.5'; then BoundingBox() CenterX is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble_when05_thenBoundingBoxCenterXIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(-0.5d, 10.0d, 10.0d);

    // Assert
    assertEquals(-0.25d, boundingBox.getCenterX());
    assertEquals(-0.25d, actualUnionResult.getCenterX());
    Vector center = boundingBox.getCenter();
    assertEquals(-0.25d, center.getX());
    Vector center2 = actualUnionResult.getCenter();
    assertEquals(-0.25d, center2.getX());
    assertEquals(-0.5d, boundingBox.getMinX());
    assertEquals(-0.5d, actualUnionResult.getMinX());
    Vector min = boundingBox.getMin();
    assertEquals(-0.5d, min.getX());
    Vector min2 = actualUnionResult.getMin();
    assertEquals(-0.5d, min2.getX());
    assertEquals(-1, center.getBlockX());
    assertEquals(-1, center2.getBlockX());
    assertEquals(-1, min.getBlockX());
    assertEquals(-1, min2.getBlockX());
    assertEquals(0.5d, boundingBox.getWidthX());
    assertEquals(0.5d, actualUnionResult.getWidthX());
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterY is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test union(double, double, double) with 'double', 'double', 'double'; when '-0.5'; then BoundingBox() CenterY is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble_when05_thenBoundingBoxCenterYIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(10.0d, -0.5d, 10.0d);

    // Assert
    assertEquals(-0.25d, boundingBox.getCenterY());
    assertEquals(-0.25d, actualUnionResult.getCenterY());
    Vector center = boundingBox.getCenter();
    assertEquals(-0.25d, center.getY());
    Vector center2 = actualUnionResult.getCenter();
    assertEquals(-0.25d, center2.getY());
    assertEquals(-0.5d, boundingBox.getMinY());
    assertEquals(-0.5d, actualUnionResult.getMinY());
    Vector min = boundingBox.getMin();
    assertEquals(-0.5d, min.getY());
    Vector min2 = actualUnionResult.getMin();
    assertEquals(-0.5d, min2.getY());
    assertEquals(-1, center.getBlockY());
    assertEquals(-1, center2.getBlockY());
    assertEquals(-1, min.getBlockY());
    assertEquals(-1, min2.getBlockY());
    assertEquals(0.5d, boundingBox.getHeight());
    assertEquals(0.5d, actualUnionResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterZ is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test union(double, double, double) with 'double', 'double', 'double'; when '-0.5'; then BoundingBox() CenterZ is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble_when05_thenBoundingBoxCenterZIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(10.0d, 10.0d, -0.5d);

    // Assert
    assertEquals(-0.25d, boundingBox.getCenterZ());
    assertEquals(-0.25d, actualUnionResult.getCenterZ());
    assertEquals(-0.5d, boundingBox.getMinZ());
    assertEquals(-0.5d, actualUnionResult.getMinZ());
    assertEquals(0.0d, actualUnionResult.getMaxZ());
    assertEquals(0.5d, boundingBox.getWidthZ());
    assertEquals(0.5d, actualUnionResult.getWidthZ());
  }

  /**
   * Test {@link BoundingBox#union(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Center BlockY is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test union(double, double, double) with 'double', 'double', 'double'; when zero; then return Center BlockY is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(double, double, double)"})
  void testUnionWithDoubleDoubleDouble_whenZero_thenReturnCenterBlockYIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(0.0d, 0.0d, 10.0d);

    // Assert
    Vector center = actualUnionResult.getCenter();
    assertEquals(0, center.getBlockY());
    assertEquals(0.0d, actualUnionResult.getCenterY());
    assertEquals(0.0d, actualUnionResult.getHeight());
    assertEquals(0.0d, center.getY());
    assertEquals(10.0d, boundingBox.getMax().length());
    assertEquals(10.0d, actualUnionResult.getMax().length());
    assertEquals(5.0d, boundingBox.getCenter().length());
    assertEquals(5.0d, center.length());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center BlockX is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName("Test union(Location) with 'Location'; then return Center BlockX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnCenterBlockXIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location position = new Location(mock(World.class), 0.0d, 3.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    Vector center = actualUnionResult.getCenter();
    assertEquals(0, center.getBlockX());
    assertEquals(0.0d, actualUnionResult.getCenterX());
    assertEquals(0.0d, actualUnionResult.getWidthX());
    assertEquals(0.0d, center.getX());
    assertEquals(5.220153254455275d, center.length());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center BlockZ is six.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName("Test union(Location) with 'Location'; then return Center BlockZ is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnCenterBlockZIsSix() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 2.0d, 2.0d, 2.0d, 2.0d);
    Location position = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    Vector center = actualUnionResult.getCenter();
    assertEquals(6, center.getBlockZ());
    assertEquals(6.0d, actualUnionResult.getCenterZ());
    assertEquals(6.0d, center.getZ());
    assertEquals(6.670832032063167d, center.length());
    assertEquals(8.0d, actualUnionResult.getVolume());
    assertEquals(8.0d, actualUnionResult.getWidthZ());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center length is {@code 5.315072906367325}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName(
      "Test union(Location) with 'Location'; then return Center length is '5.315072906367325'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnCenterLengthIs5315072906367325() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location position = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    assertEquals(5.315072906367325d, actualUnionResult.getCenter().length());
    assertEquals(60.0d, actualUnionResult.getVolume());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return CenterX is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName("Test union(Location) with 'Location'; then return CenterX is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnCenterXIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location position = new Location(mock(World.class), -0.5d, 3.0d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    assertEquals(-0.25d, actualUnionResult.getCenterX());
    Vector center = actualUnionResult.getCenter();
    assertEquals(-0.25d, center.getX());
    assertEquals(-0.5d, actualUnionResult.getMinX());
    Vector min = actualUnionResult.getMin();
    assertEquals(-0.5d, min.getX());
    assertEquals(-1, center.getBlockX());
    assertEquals(-1, min.getBlockX());
    assertEquals(0.5d, actualUnionResult.getWidthX());
    assertEquals(15.0d, actualUnionResult.getVolume());
    assertEquals(5.226136240091718d, center.length());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return CenterY is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName("Test union(Location) with 'Location'; then return CenterY is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnCenterYIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location position = new Location(mock(World.class), 2.0d, -0.5d, 10.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    assertEquals(-0.25d, actualUnionResult.getCenterY());
    Vector center = actualUnionResult.getCenter();
    assertEquals(-0.25d, center.getY());
    assertEquals(-0.5d, actualUnionResult.getMinY());
    Vector min = actualUnionResult.getMin();
    assertEquals(-0.5d, min.getY());
    assertEquals(-1, center.getBlockY());
    assertEquals(-1, min.getBlockY());
    Vector max = actualUnionResult.getMax();
    assertEquals(0, max.getBlockY());
    assertEquals(0.0d, actualUnionResult.getMaxY());
    assertEquals(0.0d, max.getY());
    assertEquals(0.5d, actualUnionResult.getHeight());
    assertEquals(10.0d, actualUnionResult.getVolume());
    assertEquals(10.198039027185569d, max.length());
    assertEquals(5.105144464165535d, center.length());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return CenterZ is {@code -0.25}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName("Test union(Location) with 'Location'; then return CenterZ is '-0.25'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnCenterZIs025() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location position = new Location(mock(World.class), 2.0d, 3.0d, -0.5d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    assertEquals(-0.25d, actualUnionResult.getCenterZ());
    Vector center = actualUnionResult.getCenter();
    assertEquals(-0.25d, center.getZ());
    assertEquals(-0.5d, actualUnionResult.getMinZ());
    Vector min = actualUnionResult.getMin();
    assertEquals(-0.5d, min.getZ());
    assertEquals(-1, center.getBlockZ());
    assertEquals(-1, min.getBlockZ());
    Vector max = actualUnionResult.getMax();
    assertEquals(0, max.getBlockZ());
    assertEquals(0.0d, actualUnionResult.getMaxZ());
    assertEquals(0.0d, max.getZ());
    assertEquals(0.5d, actualUnionResult.getWidthZ());
    assertEquals(1.8200274723201295d, center.length());
    assertEquals(3.0d, actualUnionResult.getVolume());
    assertEquals(3.605551275463989d, max.length());
  }

  /**
   * Test {@link BoundingBox#union(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return WidthZ is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Location)}
   */
  @Test
  @DisplayName("Test union(Location) with 'Location'; then return WidthZ is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Location)"})
  void testUnionWithLocation_thenReturnWidthZIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 2.0d, 2.0d, 2.0d, 2.0d);
    Location position = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    assertEquals(0.0d, actualUnionResult.getWidthZ());
    Vector center = actualUnionResult.getCenter();
    assertEquals(2, center.getBlockZ());
    Vector max = actualUnionResult.getMax();
    assertEquals(2, max.getBlockZ());
    assertEquals(2.0d, actualUnionResult.getCenterZ());
    assertEquals(2.0d, actualUnionResult.getMaxZ());
    assertEquals(2.0d, center.getZ());
    assertEquals(2.0d, max.getZ());
    assertEquals(3.5355339059327378d, center.length());
    assertEquals(4.123105625617661d, max.length());
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName("Test union(Vector) with 'Vector'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            2.0d,
            3.0d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(Vector.getRandom());

    // Assert
    assertSame(boundingBox, actualUnionResult);
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Given {@code -0.5}.
   *   <li>When Random Y is {@code -0.5}.
   *   <li>Then return MinY is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName(
      "Test union(Vector) with 'Vector'; given '-0.5'; when Random Y is '-0.5'; then return MinY is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector_given05_whenRandomYIs05_thenReturnMinYIs05() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d);

    Vector position = Vector.getRandom();
    position.setY(-0.5f);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    Vector center = actualUnionResult.getCenter();
    double actualY = center.getY();
    assertEquals(-0.5d, actualUnionResult.getMinY());
    Vector min = actualUnionResult.getMin();
    assertEquals(-0.5d, min.getY());
    BlockVector toBlockVectorResult = min.toBlockVector();
    assertEquals(-0.5d, toBlockVectorResult.getY());
    assertEquals(-1, min.getBlockY());
    assertEquals(-1, toBlockVectorResult.getBlockY());
    assertEquals(0.5109858048318636d, min.length());
    assertEquals(0.5109858048318636d, toBlockVectorResult.length());
    assertEquals(0.5109858048318636d, min.toVector3d().length());
    assertEquals(1.0d, min.toVector3i().length());
    assertEquals(1.25d, actualUnionResult.getCenterY());
    assertEquals(1.25d, actualY);
    assertEquals(1.25d, center.toBlockVector().getY());
    assertEquals(3.5d, actualUnionResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When {@link BlockVector#BlockVector()}.
   *   <li>Then return CenterX is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName(
      "Test union(Vector) with 'Vector'; given BoundingBox(); when BlockVector(); then return CenterX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector_givenBoundingBox_whenBlockVector_thenReturnCenterXIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualUnionResult = boundingBox.union(new BlockVector());

    // Assert
    assertEquals(0.0d, actualUnionResult.getCenterX());
    assertEquals(0.0d, actualUnionResult.getCenterY());
    assertEquals(0.0d, actualUnionResult.getCenterZ());
    assertEquals(0.0d, actualUnionResult.getHeight());
    assertEquals(0.0d, actualUnionResult.getMaxX());
    assertEquals(0.0d, actualUnionResult.getMaxY());
    assertEquals(0.0d, actualUnionResult.getMaxZ());
    assertEquals(0.0d, actualUnionResult.getVolume());
    assertEquals(0.0d, actualUnionResult.getWidthX());
    assertEquals(0.0d, actualUnionResult.getWidthZ());
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When Random.
   *   <li>Then return Max is Random.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName(
      "Test union(Vector) with 'Vector'; given BoundingBox(); when Random; then return Max is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector_givenBoundingBox_whenRandom_thenReturnMaxIsRandom() {
    // Arrange
    Vector position = Vector.getRandom();

    // Act and Assert
    assertEquals(position, new BoundingBox().union(position).getMax());
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then return Min length is {@code 0.12907261177144108}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName(
      "Test union(Vector) with 'Vector'; given ten; then return Min length is '0.12907261177144108'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector_givenTen_thenReturnMinLengthIs012907261177144108() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d);

    Vector position = Vector.getRandom();
    position.setY(10.0f);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(position);

    // Assert
    assertEquals(0.12907261177144108d, actualUnionResult.getMin().length());
    assertEquals(10.0d, actualUnionResult.getMaxY());
    Vector max = actualUnionResult.getMax();
    assertEquals(10.0d, max.getY());
    Vector center = actualUnionResult.getCenter();
    assertEquals(5, center.getBlockY());
    assertEquals(5.037260053575625d, actualUnionResult.getCenterY());
    assertEquals(5.037260053575625d, center.getY());
    assertEquals(9.92547989284875d, actualUnionResult.getHeight());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, max.getBlockY());
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector()}.
   *   <li>Then return CenterZ is {@code 0.037260053575624785}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName(
      "Test union(Vector) with 'Vector'; when BlockVector(); then return CenterZ is '0.037260053575624785'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector_whenBlockVector_thenReturnCenterZIs0037260053575624785() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(new BlockVector());

    // Assert
    assertEquals(0.037260053575624785d, actualUnionResult.getCenterZ());
    Vector center = actualUnionResult.getCenter();
    assertEquals(0.037260053575624785d, center.getZ());
    assertEquals(0.07452010715124957d, actualUnionResult.getMaxZ());
    assertEquals(0.07452010715124957d, actualUnionResult.getWidthZ());
    Vector max = actualUnionResult.getMax();
    assertEquals(0.07452010715124957d, max.getZ());
    assertEquals(0.2235603214537487d, actualUnionResult.getVolume());
    assertEquals(0.5d, actualUnionResult.getCenterX());
    assertEquals(0.5d, center.getX());
    assertEquals(1.0d, actualUnionResult.getWidthX());
    assertEquals(1.581577791824499d, center.length());
    assertEquals(1.5d, actualUnionResult.getCenterY());
    assertEquals(1.5d, center.getY());
    assertEquals(3.0d, actualUnionResult.getHeight());
    assertEquals(3.163155583648998d, max.length());
  }

  /**
   * Test {@link BoundingBox#union(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return CenterY is {@code 1.537260053575625}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#union(Vector)}
   */
  @Test
  @DisplayName(
      "Test union(Vector) with 'Vector'; when Random; then return CenterY is '1.537260053575625'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.union(Vector)"})
  void testUnionWithVector_whenRandom_thenReturnCenterYIs1537260053575625() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d,
            0.07452010715124957d);

    // Act
    BoundingBox actualUnionResult = boundingBox.union(Vector.getRandom());

    // Assert
    assertEquals(1.537260053575625d, actualUnionResult.getCenterY());
    Vector center = actualUnionResult.getCenter();
    assertEquals(1.537260053575625d, center.getY());
    BlockVector toBlockVectorResult = center.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult.getY());
    BlockVector toBlockVectorResult2 = toBlockVectorResult.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult2.getY());
    BlockVector toBlockVectorResult3 = toBlockVectorResult2.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult3.getY());
    BlockVector toBlockVectorResult4 = toBlockVectorResult3.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult4.getY());
    BlockVector toBlockVectorResult5 = toBlockVectorResult4.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult5.getY());
    BlockVector toBlockVectorResult6 = toBlockVectorResult5.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult6.getY());
    BlockVector toBlockVectorResult7 = toBlockVectorResult6.toBlockVector();
    assertEquals(1.537260053575625d, toBlockVectorResult7.getY());
    assertEquals(1.537260053575625d, toBlockVectorResult7.toVector3d().y);
    assertEquals(1.53726f, toBlockVectorResult7.toVector3f().y);
    assertEquals(2.9254798928487507d, actualUnionResult.getHeight());
  }

  /**
   * Test {@link BoundingBox#intersection(BoundingBox)}.
   *
   * <p>Method under test: {@link BoundingBox#intersection(BoundingBox)}
   */
  @Test
  @DisplayName("Test intersection(BoundingBox)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.intersection(BoundingBox)"})
  void testIntersection() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 1.0d, 10.0d, 10.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 1.0d, 10.0d, 10.0d, 10.0d);

    // Act
    BoundingBox actualIntersectionResult = boundingBox.intersection(other);

    // Assert
    assertSame(boundingBox, actualIntersectionResult);
  }

  /**
   * Test {@link BoundingBox#shift(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>Then {@link BoundingBox#BoundingBox()} Center length is {@code 14.142135623730951}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shift(double, double, double) with 'double', 'double', 'double'; then BoundingBox() Center length is '14.142135623730951'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(double, double, double)"})
  void testShiftWithDoubleDoubleDouble_thenBoundingBoxCenterLengthIs14142135623730951() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(0.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(14.142135623730951d, boundingBox.getCenter().length());
    Vector center = actualShiftResult.getCenter();
    assertEquals(14.142135623730951d, center.length());
    assertEquals(14.142135623730951d, boundingBox.getMax().length());
    assertEquals(14.142135623730951d, boundingBox.getMin().length());
    assertEquals(center, actualShiftResult.getMax());
    assertEquals(center, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BoundingBox#BoundingBox()} CenterX is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shift(double, double, double) with 'double', 'double', 'double'; when ten; then BoundingBox() CenterX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(double, double, double)"})
  void testShiftWithDoubleDoubleDouble_whenTen_thenBoundingBoxCenterXIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getCenterX());
    assertEquals(10.0d, actualShiftResult.getCenterX());
    assertEquals(10.0d, boundingBox.getMaxX());
    assertEquals(10.0d, actualShiftResult.getMaxX());
    assertEquals(10.0d, boundingBox.getMinX());
    assertEquals(10.0d, actualShiftResult.getMinX());
  }

  /**
   * Test {@link BoundingBox#shift(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link BoundingBox#BoundingBox()} Center length is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shift(double, double, double) with 'double', 'double', 'double'; when zero; then BoundingBox() Center length is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(double, double, double)"})
  void testShiftWithDoubleDoubleDouble_whenZero_thenBoundingBoxCenterLengthIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(0.0d, 0.0d, 10.0d);

    // Assert
    assertEquals(10.0d, boundingBox.getCenter().length());
    Vector center = actualShiftResult.getCenter();
    assertEquals(10.0d, center.length());
    assertEquals(10.0d, boundingBox.getMax().length());
    assertEquals(10.0d, boundingBox.getMin().length());
    assertEquals(center, actualShiftResult.getMax());
    assertEquals(center, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(double, double, double)} with {@code double}, {@code double},
   * {@code double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return CenterZ is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test shift(double, double, double) with 'double', 'double', 'double'; when zero; then return CenterZ is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(double, double, double)"})
  void testShiftWithDoubleDoubleDouble_whenZero_thenReturnCenterZIsZero() {
    // Arrange and Act
    BoundingBox actualShiftResult = new BoundingBox().shift(0.0d, 0.0d, 0.0d);

    // Assert
    assertEquals(0.0d, actualShiftResult.getCenterZ());
    assertEquals(0.0d, actualShiftResult.getMaxZ());
    assertEquals(0.0d, actualShiftResult.getMinZ());
  }

  /**
   * Test {@link BoundingBox#shift(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center BlockZ is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Location)}
   */
  @Test
  @DisplayName("Test shift(Location) with 'Location'; then return Center BlockZ is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Location)"})
  void testShiftWithLocation_thenReturnCenterBlockZIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location shift = new Location(mock(World.class), 0.0d, 0.0d, 0.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    Vector center = actualShiftResult.getCenter();
    assertEquals(0, center.getBlockZ());
    assertEquals(0.0d, actualShiftResult.getCenterZ());
    assertEquals(0.0d, actualShiftResult.getMaxZ());
    assertEquals(0.0d, actualShiftResult.getMinZ());
    assertEquals(0.0d, center.getZ());
    assertEquals(0.0d, center.length());
    assertTrue(center.isZero());
    assertEquals(center, actualShiftResult.getMax());
    assertEquals(center, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center length is {@code 10.44030650891055}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Location)}
   */
  @Test
  @DisplayName(
      "Test shift(Location) with 'Location'; then return Center length is '10.44030650891055'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Location)"})
  void testShiftWithLocation_thenReturnCenterLengthIs1044030650891055() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location shift = new Location(mock(World.class), 0.0d, 3.0d, 10.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    Vector center = actualShiftResult.getCenter();
    assertEquals(10.44030650891055d, center.length());
    assertEquals(center, actualShiftResult.getMax());
    assertEquals(center, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center length is {@code 10.63014581273465}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Location)}
   */
  @Test
  @DisplayName(
      "Test shift(Location) with 'Location'; then return Center length is '10.63014581273465'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Location)"})
  void testShiftWithLocation_thenReturnCenterLengthIs1063014581273465() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location shift = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    Vector center = actualShiftResult.getCenter();
    assertEquals(10.63014581273465d, center.length());
    assertEquals(2, center.getBlockX());
    assertEquals(2.0d, actualShiftResult.getCenterX());
    assertEquals(2.0d, actualShiftResult.getMaxX());
    assertEquals(2.0d, actualShiftResult.getMinX());
    assertEquals(2.0d, center.getX());
    assertEquals(center, actualShiftResult.getMax());
    assertEquals(center, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return Center length is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Location)}
   */
  @Test
  @DisplayName("Test shift(Location) with 'Location'; then return Center length is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Location)"})
  void testShiftWithLocation_thenReturnCenterLengthIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Location shift = new Location(mock(World.class), 0.0d, 0.0d, 10.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    Vector center = actualShiftResult.getCenter();
    assertEquals(10.0d, center.length());
    assertEquals(center, actualShiftResult.getMax());
    assertEquals(center, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Then return Center is {@link Vector#Vector(double, double, double)} with x is zero and y
   *       is zero and z is zero.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Vector)}
   */
  @Test
  @DisplayName(
      "Test shift(Vector) with 'Vector'; then return Center is Vector(double, double, double) with x is zero and y is zero and z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Vector)"})
  void testShiftWithVector_thenReturnCenterIsVectorWithXIsZeroAndYIsZeroAndZIsZero() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector shift = new Vector(0.0d, 0.0d, 0.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    assertEquals(shift, actualShiftResult.getCenter());
    assertEquals(shift, actualShiftResult.getMax());
    assertEquals(shift, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Then return CenterY is three.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Vector)}
   */
  @Test
  @DisplayName("Test shift(Vector) with 'Vector'; then return CenterY is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Vector)"})
  void testShiftWithVector_thenReturnCenterYIsThree() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector shift = new Vector(0.0d, 3.0d, 0.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    assertEquals(3.0d, actualShiftResult.getCenterY());
    assertEquals(3.0d, actualShiftResult.getMaxY());
    assertEquals(3.0d, actualShiftResult.getMinY());
    assertEquals(shift, actualShiftResult.getCenter());
    assertEquals(shift, actualShiftResult.getMax());
    assertEquals(shift, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>Then return CenterZ is ten.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Vector)}
   */
  @Test
  @DisplayName("Test shift(Vector) with 'Vector'; then return CenterZ is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Vector)"})
  void testShiftWithVector_thenReturnCenterZIsTen() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector shift = new Vector(0.0d, 0.0d, 10.0d);

    // Act
    BoundingBox actualShiftResult = boundingBox.shift(shift);

    // Assert
    assertEquals(10.0d, actualShiftResult.getCenterZ());
    assertEquals(10.0d, actualShiftResult.getMaxZ());
    assertEquals(10.0d, actualShiftResult.getMinZ());
    assertEquals(shift, actualShiftResult.getCenter());
    assertEquals(shift, actualShiftResult.getMax());
    assertEquals(shift, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#shift(Vector)} with {@code Vector}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return Center is Random.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#shift(Vector)}
   */
  @Test
  @DisplayName("Test shift(Vector) with 'Vector'; when Random; then return Center is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.shift(Vector)"})
  void testShiftWithVector_whenRandom_thenReturnCenterIsRandom() {
    // Arrange
    Vector shift = Vector.getRandom();

    // Act
    BoundingBox actualShiftResult = new BoundingBox().shift(shift);

    // Assert
    assertEquals(shift, actualShiftResult.getCenter());
    assertEquals(shift, actualShiftResult.getMax());
    assertEquals(shift, actualShiftResult.getMin());
  }

  /**
   * Test {@link BoundingBox#overlaps(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <p>Method under test: {@link BoundingBox#overlaps(Vector, Vector)}
   */
  @Test
  @DisplayName("Test overlaps(Vector, Vector) with 'min', 'max'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(Vector, Vector)"})
  void testOverlapsWithMinMax() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d);

    // Act and Assert
    assertFalse(
        boundingBox.overlaps(new BlockVector(2.0d, 3.0d, 0.9756360743045299d), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#overlaps(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test overlaps(Vector, Vector) with 'min', 'max'; given BoundingBox(); when Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(Vector, Vector)"})
  void testOverlapsWithMinMax_givenBoundingBox_whenRandom_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BoundingBox().overlaps(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#overlaps(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When Random Z is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test overlaps(Vector, Vector) with 'min', 'max'; given one; when Random Z is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(Vector, Vector)"})
  void testOverlapsWithMinMax_givenOne_whenRandomZIsOne_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d);
    BlockVector min = new BlockVector(2.0d, 3.0d, 0.9756360743045299d);

    Vector max = Vector.getRandom();
    max.setZ(1);

    // Act and Assert
    assertFalse(boundingBox.overlaps(min, max));
  }

  /**
   * Test {@link BoundingBox#overlaps(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When Random Y is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test overlaps(Vector, Vector) with 'min', 'max'; given three; when Random Y is three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(Vector, Vector)"})
  void testOverlapsWithMinMax_givenThree_whenRandomYIsThree_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d);
    BlockVector min = new BlockVector(2.0d, 3.0d, 0.9756360743045299d);

    Vector max = Vector.getRandom();
    max.setY(3);

    // Act and Assert
    assertFalse(boundingBox.overlaps(min, max));
  }

  /**
   * Test {@link BoundingBox#overlaps(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(Vector, Vector)}
   */
  @Test
  @DisplayName("Test overlaps(Vector, Vector) with 'min', 'max'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(Vector, Vector)"})
  void testOverlapsWithMinMax_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d);

    // Act and Assert
    assertFalse(boundingBox.overlaps(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#overlaps(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(Vector, Vector)}
   */
  @Test
  @DisplayName("Test overlaps(Vector, Vector) with 'min', 'max'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(Vector, Vector)"})
  void testOverlapsWithMinMax_thenReturnTrue() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d,
            0.9756360743045299d);

    // Act and Assert
    assertTrue(boundingBox.overlaps(new BlockVector(10.0f, 10.0f, 10.0f), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName("Test overlaps(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualOverlapsResult = boundingBox.overlaps(other);

    // Assert
    assertFalse(actualOverlapsResult);
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName("Test overlaps(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BoundingBox other = new BoundingBox(-0.5d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualOverlapsResult = boundingBox.overlaps(other);

    // Assert
    assertFalse(actualOverlapsResult);
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName("Test overlaps(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther3() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualOverlapsResult = boundingBox.overlaps(other);

    // Assert
    assertFalse(actualOverlapsResult);
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName("Test overlaps(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther4() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 1.0d, 10.0d, 10.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualOverlapsResult = boundingBox.overlaps(other);

    // Assert
    assertFalse(actualOverlapsResult);
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName("Test overlaps(BoundingBox) with 'other'; given BoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther_givenBoundingBox() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualOverlapsResult = boundingBox.overlaps(other);

    // Assert
    assertFalse(actualOverlapsResult);
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When {@link BoundingBox#BoundingBox()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName(
      "Test overlaps(BoundingBox) with 'other'; given BoundingBox(); when BoundingBox(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther_givenBoundingBox_whenBoundingBox_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act and Assert
    assertFalse(boundingBox.overlaps(new BoundingBox()));
  }

  /**
   * Test {@link BoundingBox#overlaps(BoundingBox)} with {@code other}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#overlaps(BoundingBox)}
   */
  @Test
  @DisplayName("Test overlaps(BoundingBox) with 'other'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.overlaps(BoundingBox)"})
  void testOverlapsWithOther_thenReturnTrue() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 1.0d, 10.0d, 10.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 1.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualOverlapsResult = boundingBox.overlaps(other);

    // Assert
    assertTrue(actualOverlapsResult);
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName("Test contains(Vector, Vector) with 'min', 'max'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d);

    // Act and Assert
    assertFalse(boundingBox.contains(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName("Test contains(Vector, Vector) with 'min', 'max'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax2() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.42496112635649397d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d);

    // Act and Assert
    assertFalse(boundingBox.contains(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given {@code 0.2565465696805922}.
   *   <li>When Random Z is {@code 0.2565465696805922}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector, Vector) with 'min', 'max'; given '0.2565465696805922'; when Random Z is '0.2565465696805922'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax_given02565465696805922_whenRandomZIs02565465696805922() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d);
    Vector min = Vector.getRandom();

    Vector max = Vector.getRandom();
    max.setZ(0.2565465696805922d);

    // Act and Assert
    assertFalse(boundingBox.contains(min, max));
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector, Vector) with 'min', 'max'; given BoundingBox(); when Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax_givenBoundingBox_whenRandom_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BoundingBox().contains(Vector.getRandom(), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given Random.
   *   <li>When Random add Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector, Vector) with 'min', 'max'; given Random; when Random add Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax_givenRandom_whenRandomAddRandom_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d);
    Vector min = Vector.getRandom();

    Vector max = Vector.getRandom();
    max.add(Vector.getRandom());

    // Act and Assert
    assertFalse(boundingBox.contains(min, max));
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When Random Y is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector, Vector) with 'min', 'max'; given three; when Random Y is three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax_givenThree_whenRandomYIsThree_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d);
    Vector min = Vector.getRandom();

    Vector max = Vector.getRandom();
    max.setY(3.0d);
    max.add(Vector.getRandom());

    // Act and Assert
    assertFalse(boundingBox.contains(min, max));
  }

  /**
   * Test {@link BoundingBox#contains(Vector, Vector)} with {@code min}, {@code max}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector()}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector, Vector)}
   */
  @Test
  @DisplayName("Test contains(Vector, Vector) with 'min', 'max'; when BlockVector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector, Vector)"})
  void testContainsWithMinMax_whenBlockVector() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d,
            0.09883918394585789d);

    // Act and Assert
    assertFalse(boundingBox.contains(new BlockVector(), Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#contains(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#contains(BoundingBox)}
   */
  @Test
  @DisplayName("Test contains(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(BoundingBox)"})
  void testContainsWithOther() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(new BoundingBox()));
  }

  /**
   * Test {@link BoundingBox#contains(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#contains(BoundingBox)}
   */
  @Test
  @DisplayName("Test contains(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(BoundingBox)"})
  void testContainsWithOther2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualContainsResult = boundingBox.contains(other);

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link BoundingBox#contains(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#contains(BoundingBox)}
   */
  @Test
  @DisplayName("Test contains(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(BoundingBox)"})
  void testContainsWithOther3() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(0.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(new BoundingBox()));
  }

  /**
   * Test {@link BoundingBox#contains(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#contains(BoundingBox)}
   */
  @Test
  @DisplayName("Test contains(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(BoundingBox)"})
  void testContainsWithOther4() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(0.0d, 0.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(new BoundingBox()));
  }

  /**
   * Test {@link BoundingBox#contains(BoundingBox)} with {@code other}.
   *
   * <p>Method under test: {@link BoundingBox#contains(BoundingBox)}
   */
  @Test
  @DisplayName("Test contains(BoundingBox) with 'other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(BoundingBox)"})
  void testContainsWithOther5() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 1.0d, 10.0d);
    BoundingBox other = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    boolean actualContainsResult = boundingBox.contains(other);

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link BoundingBox#contains(BoundingBox)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When {@link BoundingBox#BoundingBox()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(BoundingBox)}
   */
  @Test
  @DisplayName(
      "Test contains(BoundingBox) with 'other'; given BoundingBox(); when BoundingBox(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(BoundingBox)"})
  void testContainsWithOther_givenBoundingBox_whenBoundingBox_thenReturnTrue() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act and Assert
    assertTrue(boundingBox.contains(new BoundingBox()));
  }

  /**
   * Test {@link BoundingBox#contains(Vector)} with {@code position}.
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector)}
   */
  @Test
  @DisplayName("Test contains(Vector) with 'position'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector)"})
  void testContainsWithPosition() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            0.6364228496812273d,
            3.0d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d);

    Vector position = Vector.getRandom();
    position.setY(1);

    // Act and Assert
    assertFalse(boundingBox.contains(position));
  }

  /**
   * Test {@link BoundingBox#contains(Vector)} with {@code position}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When Random.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector) with 'position'; given BoundingBox(); when Random; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector)"})
  void testContainsWithPosition_givenBoundingBox_whenRandom_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BoundingBox().contains(Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#contains(Vector)} with {@code position}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When Random Y is minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector) with 'position'; given minus one; when Random Y is minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector)"})
  void testContainsWithPosition_givenMinusOne_whenRandomYIsMinusOne_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d);

    Vector position = Vector.getRandom();
    position.setY(-1);

    // Act and Assert
    assertFalse(boundingBox.contains(position));
  }

  /**
   * Test {@link BoundingBox#contains(Vector)} with {@code position}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When Random Y is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector) with 'position'; given one; when Random Y is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector)"})
  void testContainsWithPosition_givenOne_whenRandomYIsOne_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d);

    Vector position = Vector.getRandom();
    position.setY(1);

    // Act and Assert
    assertFalse(boundingBox.contains(position));
  }

  /**
   * Test {@link BoundingBox#contains(Vector)} with {@code position}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When Random Y is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector)}
   */
  @Test
  @DisplayName(
      "Test contains(Vector) with 'position'; given three; when Random Y is three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector)"})
  void testContainsWithPosition_givenThree_whenRandomYIsThree_thenReturnFalse() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d);

    Vector position = Vector.getRandom();
    position.setY(3);

    // Act and Assert
    assertFalse(boundingBox.contains(position));
  }

  /**
   * Test {@link BoundingBox#contains(Vector)} with {@code position}.
   *
   * <ul>
   *   <li>When Random.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(Vector)}
   */
  @Test
  @DisplayName("Test contains(Vector) with 'position'; when Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(Vector)"})
  void testContainsWithPosition_whenRandom() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d,
            3.0d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d,
            0.4253593339049174d);

    // Act and Assert
    assertFalse(boundingBox.contains(Vector.getRandom()));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName("Test contains(double, double, double) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 2.0d, 2.0d, 2.0d, 2.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(1.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName("Test contains(double, double, double) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 10.0d, 2.0d, 2.0d, 2.0d, 2.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(1.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName("Test contains(double, double, double) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ3() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 2.0d, 2.0d, 2.0d, 2.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(1.0d, 1.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName("Test contains(double, double, double) with 'x', 'y', 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ4() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 10.0d, 2.0d, 2.0d, 2.0d, 2.0d);

    // Act and Assert
    assertFalse(boundingBox.contains(1.0d, 3.0d, 1.0d));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test contains(double, double, double) with 'x', 'y', 'z'; given BoundingBox(); when '-0.5'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ_givenBoundingBox_when05_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BoundingBox().contains(-0.5d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>Given {@link BoundingBox#BoundingBox()}.
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test contains(double, double, double) with 'x', 'y', 'z'; given BoundingBox(); when two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ_givenBoundingBox_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BoundingBox().contains(2.0d, 3.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#contains(double, double, double)} with {@code x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#contains(double, double, double)}
   */
  @Test
  @DisplayName("Test contains(double, double, double) with 'x', 'y', 'z'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.contains(double, double, double)"})
  void testContainsWithXYZ_thenReturnTrue() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 10.0d, 1.0d, 2.0d, 2.0d, 2.0d);

    // Act and Assert
    assertTrue(boundingBox.contains(1.0d, 3.0d, 1.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link BlockVector#BlockVector()} Z is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); given one; when BlockVector() Z is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_givenOne_whenBlockVectorZIsOne_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    BlockVector direction = new BlockVector();
    direction.setZ(1);

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, direction, 10.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>Then return HitBlockFace is {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName("Test rayTrace(Vector, Vector, double); then return HitBlockFace is 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_thenReturnHitBlockFaceIsEast() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d, 3.0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    BlockVector start = new BlockVector(2.0d, 3.0d, Double.MAX_VALUE);

    // Act
    RayTraceResult actualRayTraceResult =
        boundingBox.rayTrace(start, new BlockVector(2.0d, 3.0d, Double.MAX_VALUE), 10.0d);

    // Assert
    Vector hitPosition = actualRayTraceResult.getHitPosition();
    assertTrue(hitPosition instanceof BlockVector);
    assertEquals(BlockFace.EAST, actualRayTraceResult.getHitBlockFace());
    assertEquals(hitPosition, hitPosition.toBlockVector());
    Vector3d toVector3dResult = hitPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = hitPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i toVector3iResult = hitPosition.toVector3i();
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>Then return HitPosition toBlockVector toVector3d is HitPosition toVector3d.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); then return HitPosition toBlockVector toVector3d is HitPosition toVector3d")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_thenReturnHitPositionToBlockVectorToVector3dIsHitPositionToVector3d() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BlockVector start = new BlockVector();

    // Act and Assert
    Vector hitPosition =
        boundingBox
            .rayTrace(start, new BlockVector(2.0d, 3.0d, Double.MAX_VALUE), 10.0d)
            .getHitPosition();
    assertTrue(hitPosition instanceof BlockVector);
    Vector3d toVector3dResult = hitPosition.toVector3d();
    BlockVector toBlockVectorResult = hitPosition.toBlockVector();
    assertEquals(toVector3dResult, toBlockVectorResult.toVector3d());
    Vector3f toVector3fResult = hitPosition.toVector3f();
    assertEquals(toVector3fResult, toBlockVectorResult.toVector3f());
    Vector3i toVector3iResult = hitPosition.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>Then return HitPosition toBlockVector toVector3i is HitPosition toVector3i.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); then return HitPosition toBlockVector toVector3i is HitPosition toVector3i")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_thenReturnHitPositionToBlockVectorToVector3iIsHitPositionToVector3i() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act and Assert
    Vector hitPosition =
        boundingBox.rayTrace(new BlockVector(), Vector.getRandom(), 10.0d).getHitPosition();
    Vector3i toVector3iResult = hitPosition.toVector3i();
    assertEquals(toVector3iResult, hitPosition.toBlockVector().toVector3i());
    Vector3d toVector3dResult = hitPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = hitPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>Then return HitPosition toVector3i length is {@code 2.147483648E9}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); then return HitPosition toVector3i length is '2.147483648E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_thenReturnHitPositionToVector3iLengthIs2147483648e9() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d, 3.0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    BlockVector start = new BlockVector(2.0d, 3.0d, Double.MAX_VALUE);

    // Act
    RayTraceResult actualRayTraceResult = boundingBox.rayTrace(start, Vector.getRandom(), 10.0d);

    // Assert
    Vector hitPosition = actualRayTraceResult.getHitPosition();
    Vector3i toVector3iResult = hitPosition.toVector3i();
    assertEquals(2.147483648E9d, toVector3iResult.length());
    assertEquals(3, hitPosition.getBlockY());
    assertEquals(3, toVector3iResult.y());
    assertEquals(3, toVector3iResult.y);
    assertEquals(3.0d, hitPosition.getY());
    assertEquals(BlockFace.DOWN, actualRayTraceResult.getHitBlockFace());
    assertEquals(start, hitPosition.toBlockVector());
    Vector3d toVector3dResult = hitPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = hitPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>Then return HitPosition toVector3i length is {@code 3.037000448E9}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); then return HitPosition toVector3i length is '3.037000448E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_thenReturnHitPositionToVector3iLengthIs3037000448e9() {
    // Arrange
    BoundingBox boundingBox =
        new BoundingBox(
            1.0d, 3.0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    BlockVector start = new BlockVector(2.0d, Double.MAX_VALUE, Double.MAX_VALUE);

    // Act
    RayTraceResult actualRayTraceResult = boundingBox.rayTrace(start, Vector.getRandom(), 10.0d);

    // Assert
    Vector hitPosition = actualRayTraceResult.getHitPosition();
    Vector3i toVector3iResult = hitPosition.toVector3i();
    assertEquals(3.037000448E9d, toVector3iResult.length());
    assertEquals(BlockFace.NORTH, actualRayTraceResult.getHitBlockFace());
    assertEquals(start, hitPosition.toBlockVector());
    assertEquals(Double.MAX_VALUE, hitPosition.getY());
    assertEquals(ChatPaginator.UNBOUNDED_PAGE_HEIGHT, hitPosition.getBlockY());
    assertEquals(ChatPaginator.UNBOUNDED_PAGE_HEIGHT, toVector3iResult.y());
    assertEquals(ChatPaginator.UNBOUNDED_PAGE_HEIGHT, toVector3iResult.y);
    Vector3d toVector3dResult = hitPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = hitPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is {@code -0.5} and y
   *       is three and z is zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is '-0.5' and y is three and z is zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIs05AndYIsThreeAndZIsZero_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, new BlockVector(-0.5d, 3.0d, 0.0d), 10.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is
   *       {@code -0.5} and z is zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is two and y is '-0.5' and z is zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIsTwoAndYIs05AndZIsZero_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, new BlockVector(2.0d, -0.5d, 0.0d), 10.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is three
   *       and z is {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is two and y is three and z is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIsTwoAndYIsThreeAndZIs05() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BlockVector start = new BlockVector();

    // Act and Assert
    Vector hitPosition =
        boundingBox.rayTrace(start, new BlockVector(2.0d, 3.0d, -0.5d), 10.0d).getHitPosition();
    assertTrue(hitPosition instanceof BlockVector);
    Vector3i toVector3iResult = hitPosition.toVector3i();
    assertEquals(toVector3iResult, hitPosition.toBlockVector().toVector3i());
    Vector3d toVector3dResult = hitPosition.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = hitPosition.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is three
   *       and z is {@link Double#MAX_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is two and y is three and z is MAX_VALUE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIsTwoAndYIsThreeAndZIsMax_value_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, new BlockVector(2.0d, 3.0d, Double.MAX_VALUE), 10.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is three
   *       and z is zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is two and y is three and z is zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIsTwoAndYIsThreeAndZIsZero_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, new BlockVector(2.0d, 3.0d, 0.0d), 10.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is zero
   *       and z is {@link Double#MAX_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is two and y is zero and z is MAX_VALUE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIsTwoAndYIsZeroAndZIsMax_value_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, new BlockVector(2.0d, 0.0d, Double.MAX_VALUE), 10.0d));
  }

  /**
   * Test {@link BoundingBox#rayTrace(Vector, Vector, double)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is zero and y is
   *       three and z is {@link Double#MAX_VALUE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#rayTrace(Vector, Vector, double)}
   */
  @Test
  @DisplayName(
      "Test rayTrace(Vector, Vector, double); when BlockVector(double, double, double) with x is zero and y is three and z is MAX_VALUE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RayTraceResult BoundingBox.rayTrace(Vector, Vector, double)"})
  void testRayTrace_whenBlockVectorWithXIsZeroAndYIsThreeAndZIsMax_value_thenReturnNull() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    Vector start = Vector.getRandom();

    // Act and Assert
    assertNull(boundingBox.rayTrace(start, new BlockVector(0.0d, 3.0d, Double.MAX_VALUE), 10.0d));
  }

  /**
   * Test {@link BoundingBox#equals(Object)}, and {@link BoundingBox#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundingBox#equals(Object)}
   *   <li>{@link BoundingBox#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();
    BoundingBox boundingBox2 = new BoundingBox();

    // Act and Assert
    assertEquals(boundingBox, boundingBox2);
    assertEquals(boundingBox.hashCode(), boundingBox2.hashCode());
  }

  /**
   * Test {@link BoundingBox#equals(Object)}, and {@link BoundingBox#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BoundingBox#equals(Object)}
   *   <li>{@link BoundingBox#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act and Assert
    assertEquals(boundingBox, boundingBox);
    int expectedHashCodeResult = boundingBox.hashCode();
    assertEquals(expectedHashCodeResult, boundingBox.hashCode());
  }

  /**
   * Test {@link BoundingBox#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act and Assert
    assertNotEquals(boundingBox, new BoundingBox());
  }

  /**
   * Test {@link BoundingBox#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(10.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act and Assert
    assertNotEquals(boundingBox, new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox(10.0d, 3.0d, 10.0d, 10.0d, 1.0d, 10.0d);

    // Act and Assert
    assertNotEquals(boundingBox, new BoundingBox(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link BoundingBox#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BoundingBox(), null);
  }

  /**
   * Test {@link BoundingBox#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BoundingBox#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BoundingBox.equals(Object)", "int BoundingBox.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BoundingBox(), "Different type to BoundingBox");
  }

  /**
   * Test {@link BoundingBox#clone()}.
   *
   * <p>Method under test: {@link BoundingBox#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.clone()"})
  void testClone() {
    // Arrange
    BoundingBox boundingBox = new BoundingBox();

    // Act
    BoundingBox actualCloneResult = boundingBox.clone();

    // Assert
    assertEquals(boundingBox, actualCloneResult);
  }

  /**
   * Test {@link BoundingBox#serialize()}.
   *
   * <p>Method under test: {@link BoundingBox#serialize()}
   */
  @Test
  @DisplayName("Test serialize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BoundingBox.serialize()"})
  void testSerialize() {
    // Arrange and Act
    Map<String, Object> actualSerializeResult = new BoundingBox().serialize();

    // Assert
    assertEquals(6, actualSerializeResult.size());
    assertEquals(0.0d, ((Double) actualSerializeResult.get("maxX")).doubleValue());
    assertEquals(0.0d, ((Double) actualSerializeResult.get("maxY")).doubleValue());
    assertEquals(0.0d, ((Double) actualSerializeResult.get("maxZ")).doubleValue());
    assertEquals(0.0d, ((Double) actualSerializeResult.get("minX")).doubleValue());
    assertEquals(0.0d, ((Double) actualSerializeResult.get("minY")).doubleValue());
    assertEquals(0.0d, ((Double) actualSerializeResult.get("minZ")).doubleValue());
  }

  /**
   * Test {@link BoundingBox#deserialize(Map)}.
   *
   * <p>Method under test: {@link BoundingBox#deserialize(Map)}
   */
  @Test
  @DisplayName("Test deserialize(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox BoundingBox.deserialize(Map)"})
  void testDeserialize() {
    // Arrange and Act
    BoundingBox actualDeserializeResult = BoundingBox.deserialize(new HashMap<>());

    // Assert
    assertEquals(0.0d, actualDeserializeResult.getCenterX());
    assertEquals(0.0d, actualDeserializeResult.getCenterY());
    assertEquals(0.0d, actualDeserializeResult.getCenterZ());
    assertEquals(0.0d, actualDeserializeResult.getHeight());
    assertEquals(0.0d, actualDeserializeResult.getMaxX());
    assertEquals(0.0d, actualDeserializeResult.getMaxY());
    assertEquals(0.0d, actualDeserializeResult.getMaxZ());
    assertEquals(0.0d, actualDeserializeResult.getMinX());
    assertEquals(0.0d, actualDeserializeResult.getMinY());
    assertEquals(0.0d, actualDeserializeResult.getMinZ());
    assertEquals(0.0d, actualDeserializeResult.getVolume());
    assertEquals(0.0d, actualDeserializeResult.getWidthX());
    assertEquals(0.0d, actualDeserializeResult.getWidthZ());
  }
}
