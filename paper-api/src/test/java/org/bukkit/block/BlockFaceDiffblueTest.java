package org.bukkit.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockFaceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockFace#getModX()}
   *   <li>{@link BlockFace#getModY()}
   *   <li>{@link BlockFace#getModZ()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BlockFace.getModX()",
    "int BlockFace.getModY()",
    "int BlockFace.getModZ()"
  })
  void testGettersAndSetters() {
    // Arrange
    BlockFace valueOfResult = BlockFace.valueOf("NORTH");

    // Act
    int actualModX = valueOfResult.getModX();
    int actualModY = valueOfResult.getModY();

    // Assert
    assertEquals(-1, valueOfResult.getModZ());
    assertEquals(0, actualModX);
    assertEquals(0, actualModY);
  }

  /**
   * Test {@link BlockFace#getDirection()}.
   *
   * <ul>
   *   <li>Given {@code EAST}.
   *   <li>Then return BlockX is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given 'EAST'; then return BlockX is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockFace.getDirection()"})
  void testGetDirection_givenEast_thenReturnBlockXIsOne() {
    // Arrange and Act
    Vector actualDirection = BlockFace.EAST.getDirection();

    // Assert
    assertEquals(1, actualDirection.getBlockX());
    BlockVector toBlockVectorResult = actualDirection.toBlockVector();
    assertEquals(1, toBlockVectorResult.getBlockX());
    Vector3i toVector3iResult = actualDirection.toVector3i();
    assertEquals(1, toVector3iResult.x());
    assertEquals(1, toVector3iResult.x);
    assertEquals(1.0d, actualDirection.getX());
    assertEquals(1.0d, toBlockVectorResult.getX());
    Vector3d toVector3dResult = actualDirection.toVector3d();
    assertEquals(1.0d, toVector3dResult.x());
    assertEquals(1.0d, toVector3dResult.x);
    Vector3f toVector3fResult = actualDirection.toVector3f();
    assertEquals(1.0f, toVector3fResult.x());
    assertEquals(1.0f, toVector3fResult.x);
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    assertEquals(toVector3dResult, toBlockVectorResult.toVector3d());
    assertEquals(toVector3fResult, toBlockVectorResult.toVector3f());
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
   * Test {@link BlockFace#getDirection()}.
   *
   * <ul>
   *   <li>Given {@code NORTH}.
   *   <li>Then return BlockZ is minus one.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given 'NORTH'; then return BlockZ is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockFace.getDirection()"})
  void testGetDirection_givenNorth_thenReturnBlockZIsMinusOne() {
    // Arrange and Act
    Vector actualDirection = BlockFace.NORTH.getDirection();

    // Assert
    assertEquals(-1, actualDirection.getBlockZ());
    BlockVector toBlockVectorResult = actualDirection.toBlockVector();
    assertEquals(-1, toBlockVectorResult.getBlockZ());
    assertEquals(-1.0d, actualDirection.getZ());
    assertEquals(-1.0d, toBlockVectorResult.getZ());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3d toVector3dResult = actualDirection.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = actualDirection.toVector3f();
    Vector3f actualAbsoluteResult2 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult2);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult2 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult2);
    Vector3i toVector3iResult = actualDirection.toVector3i();
    Vector3i actualAbsoluteResult3 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult3);
  }

  /**
   * Test {@link BlockFace#getDirection()}.
   *
   * <ul>
   *   <li>Given {@code SELF}.
   *   <li>Then return length is zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given 'SELF'; then return length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockFace.getDirection()"})
  void testGetDirection_givenSelf_thenReturnLengthIsZero() {
    // Arrange and Act
    Vector actualDirection = BlockFace.SELF.getDirection();

    // Assert
    assertEquals(0.0d, actualDirection.length());
    BlockVector toBlockVectorResult = actualDirection.toBlockVector();
    assertEquals(0.0d, toBlockVectorResult.length());
    Vector3d toVector3dResult = actualDirection.toVector3d();
    assertEquals(0.0d, toVector3dResult.length());
    Vector3i toVector3iResult = actualDirection.toVector3i();
    assertEquals(0.0d, toVector3iResult.length());
    Vector3f toVector3fResult = actualDirection.toVector3f();
    assertEquals(0.0f, toVector3fResult.length());
    assertTrue(actualDirection.isZero());
    assertTrue(toBlockVectorResult.isZero());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
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
   * Test {@link BlockFace#getDirection()}.
   *
   * <ul>
   *   <li>Given {@code UP}.
   *   <li>Then return BlockY is one.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given 'UP'; then return BlockY is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockFace.getDirection()"})
  void testGetDirection_givenUp_thenReturnBlockYIsOne() {
    // Arrange and Act
    Vector actualDirection = BlockFace.UP.getDirection();

    // Assert
    assertEquals(1, actualDirection.getBlockY());
    BlockVector toBlockVectorResult = actualDirection.toBlockVector();
    assertEquals(1, toBlockVectorResult.getBlockY());
    Vector3i toVector3iResult = actualDirection.toVector3i();
    assertEquals(1, toVector3iResult.y());
    assertEquals(1, toVector3iResult.y);
    assertEquals(1.0d, actualDirection.getY());
    assertEquals(1.0d, toBlockVectorResult.getY());
    Vector3d toVector3dResult = actualDirection.toVector3d();
    assertEquals(1.0d, toVector3dResult.y());
    assertEquals(1.0d, toVector3dResult.y);
    Vector3f toVector3fResult = actualDirection.toVector3f();
    assertEquals(1.0f, toVector3fResult.y());
    assertEquals(1.0f, toVector3fResult.y);
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    assertEquals(toVector3dResult, toBlockVectorResult.toVector3d());
    assertEquals(toVector3fResult, toBlockVectorResult.toVector3f());
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
   * Test {@link BlockFace#isCartesian()}.
   *
   * <ul>
   *   <li>Given {@code NORTH_EAST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#isCartesian()}
   */
  @Test
  @DisplayName("Test isCartesian(); given 'NORTH_EAST'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockFace.isCartesian()"})
  void testIsCartesian_givenNorthEast_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BlockFace.NORTH_EAST.isCartesian());
  }

  /**
   * Test {@link BlockFace#isCartesian()}.
   *
   * <ul>
   *   <li>Given {@code NORTH}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#isCartesian()}
   */
  @Test
  @DisplayName("Test isCartesian(); given 'NORTH'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockFace.isCartesian()"})
  void testIsCartesian_givenNorth_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BlockFace.NORTH.isCartesian());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code DOWN}.
   *   <li>Then return {@code UP}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'DOWN'; then return 'UP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenDown_thenReturnUp() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.UP, BlockFace.DOWN.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code EAST_NORTH_EAST}.
   *   <li>Then return {@code WEST_SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'EAST_NORTH_EAST'; then return 'WEST_SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenEastNorthEast_thenReturnWestSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST_SOUTH_WEST, BlockFace.EAST_NORTH_EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code EAST_SOUTH_EAST}.
   *   <li>Then return {@code WEST_NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'EAST_SOUTH_EAST'; then return 'WEST_NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenEastSouthEast_thenReturnWestNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST_NORTH_WEST, BlockFace.EAST_SOUTH_EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code EAST}.
   *   <li>Then return {@code WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'EAST'; then return 'WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenEast_thenReturnWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.WEST, BlockFace.EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code NORTH_EAST}.
   *   <li>Then return {@code SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'NORTH_EAST'; then return 'SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenNorthEast_thenReturnSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_WEST, BlockFace.NORTH_EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code NORTH_NORTH_EAST}.
   *   <li>Then return {@code SOUTH_SOUTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'NORTH_NORTH_EAST'; then return 'SOUTH_SOUTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenNorthNorthEast_thenReturnSouthSouthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_SOUTH_WEST, BlockFace.NORTH_NORTH_EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code NORTH_NORTH_WEST}.
   *   <li>Then return {@code SOUTH_SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'NORTH_NORTH_WEST'; then return 'SOUTH_SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenNorthNorthWest_thenReturnSouthSouthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_SOUTH_EAST, BlockFace.NORTH_NORTH_WEST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code NORTH_WEST}.
   *   <li>Then return {@code SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'NORTH_WEST'; then return 'SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenNorthWest_thenReturnSouthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH_EAST, BlockFace.NORTH_WEST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code NORTH}.
   *   <li>Then return {@code SOUTH}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'NORTH'; then return 'SOUTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenNorth_thenReturnSouth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SOUTH, BlockFace.NORTH.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code SELF}.
   *   <li>Then return {@code SELF}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'SELF'; then return 'SELF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenSelf_thenReturnSelf() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.SELF, BlockFace.SELF.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code SOUTH_EAST}.
   *   <li>Then return {@code NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'SOUTH_EAST'; then return 'NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenSouthEast_thenReturnNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_WEST, BlockFace.SOUTH_EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code SOUTH_SOUTH_EAST}.
   *   <li>Then return {@code NORTH_NORTH_WEST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'SOUTH_SOUTH_EAST'; then return 'NORTH_NORTH_WEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenSouthSouthEast_thenReturnNorthNorthWest() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_NORTH_WEST, BlockFace.SOUTH_SOUTH_EAST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code SOUTH_SOUTH_WEST}.
   *   <li>Then return {@code NORTH_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'SOUTH_SOUTH_WEST'; then return 'NORTH_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenSouthSouthWest_thenReturnNorthNorthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_NORTH_EAST, BlockFace.SOUTH_SOUTH_WEST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code SOUTH_WEST}.
   *   <li>Then return {@code NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'SOUTH_WEST'; then return 'NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenSouthWest_thenReturnNorthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH_EAST, BlockFace.SOUTH_WEST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code SOUTH}.
   *   <li>Then return {@code NORTH}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'SOUTH'; then return 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenSouth_thenReturnNorth() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.NORTH, BlockFace.SOUTH.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code UP}.
   *   <li>Then return {@code DOWN}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'UP'; then return 'DOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenUp_thenReturnDown() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.DOWN, BlockFace.UP.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code WEST_NORTH_WEST}.
   *   <li>Then return {@code EAST_SOUTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'WEST_NORTH_WEST'; then return 'EAST_SOUTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenWestNorthWest_thenReturnEastSouthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST_SOUTH_EAST, BlockFace.WEST_NORTH_WEST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code WEST_SOUTH_WEST}.
   *   <li>Then return {@code EAST_NORTH_EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'WEST_SOUTH_WEST'; then return 'EAST_NORTH_EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenWestSouthWest_thenReturnEastNorthEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST_NORTH_EAST, BlockFace.WEST_SOUTH_WEST.getOppositeFace());
  }

  /**
   * Test {@link BlockFace#getOppositeFace()}.
   *
   * <ul>
   *   <li>Given {@code WEST}.
   *   <li>Then return {@code EAST}.
   * </ul>
   *
   * <p>Method under test: {@link BlockFace#getOppositeFace()}
   */
  @Test
  @DisplayName("Test getOppositeFace(); given 'WEST'; then return 'EAST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace BlockFace.getOppositeFace()"})
  void testGetOppositeFace_givenWest_thenReturnEast() {
    // Arrange, Act and Assert
    assertEquals(BlockFace.EAST, BlockFace.WEST.getOppositeFace());
  }
}
