package ca.spottedleaf.moonrise.patches.collisions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.AABB.Builder;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Vector3f;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CollisionUtilDiffblueTest {
  /**
   * Test {@link CollisionUtil#isEmpty(AABB)} with {@code aabb}.
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(AABB)}
   */
  @Test
  @DisplayName("Test isEmpty(AABB) with 'aabb'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isEmpty(AABB)"})
  void testIsEmptyWithAabb() {
    // Arrange
    AABB aabb =
        new AABB(
            1.0d,
            3.0d,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON);

    // Act and Assert
    assertTrue(CollisionUtil.isEmpty(aabb));
  }

  /**
   * Test {@link CollisionUtil#isEmpty(AABB)} with {@code aabb}.
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(AABB)}
   */
  @Test
  @DisplayName("Test isEmpty(AABB) with 'aabb'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isEmpty(AABB)"})
  void testIsEmptyWithAabb2() {
    // Arrange
    AABB aabb =
        new AABB(
            CollisionUtil.COLLISION_EPSILON,
            3.0d,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON);

    // Act and Assert
    assertTrue(CollisionUtil.isEmpty(aabb));
  }

  /**
   * Test {@link CollisionUtil#isEmpty(AABB)} with {@code aabb}.
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(AABB)}
   */
  @Test
  @DisplayName("Test isEmpty(AABB) with 'aabb'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isEmpty(AABB)"})
  void testIsEmptyWithAabb3() {
    // Arrange
    AABB aabb =
        new AABB(
            1.0d,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON);

    // Act and Assert
    assertTrue(CollisionUtil.isEmpty(aabb));
  }

  /**
   * Test {@link CollisionUtil#isEmpty(AABB)} with {@code aabb}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(AABB)}
   */
  @Test
  @DisplayName("Test isEmpty(AABB) with 'aabb'; when SUCK_AABB; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isEmpty(AABB)"})
  void testIsEmptyWithAabb_whenSuck_aabb_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollisionUtil.isEmpty(Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#isEmpty(double, double, double, double, double, double)} with {@code
   * minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link CollisionUtil#COLLISION_EPSILON}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test isEmpty(double, double, double, double, double, double) with 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when COLLISION_EPSILON; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isEmpty(double, double, double, double, double, double)"
  })
  void testIsEmptyWithMinXMinYMinZMaxXMaxYMaxZ_whenCollision_epsilon_thenReturnFalse() {
    // Arrange and Act
    boolean actualIsEmptyResult =
        CollisionUtil.isEmpty(
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            10.0d,
            10.0d,
            10.0d);

    // Assert
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Test {@link CollisionUtil#isEmpty(double, double, double, double, double, double)} with {@code
   * minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link CollisionUtil#COLLISION_EPSILON}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test isEmpty(double, double, double, double, double, double) with 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when COLLISION_EPSILON; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isEmpty(double, double, double, double, double, double)"
  })
  void testIsEmptyWithMinXMinYMinZMaxXMaxYMaxZ_whenCollision_epsilon_thenReturnTrue() {
    // Arrange and Act
    boolean actualIsEmptyResult =
        CollisionUtil.isEmpty(CollisionUtil.COLLISION_EPSILON, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Test {@link CollisionUtil#isEmpty(double, double, double, double, double, double)} with {@code
   * minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link CollisionUtil#COLLISION_EPSILON}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test isEmpty(double, double, double, double, double, double) with 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when COLLISION_EPSILON; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isEmpty(double, double, double, double, double, double)"
  })
  void testIsEmptyWithMinXMinYMinZMaxXMaxYMaxZ_whenCollision_epsilon_thenReturnTrue2() {
    // Arrange and Act
    boolean actualIsEmptyResult =
        CollisionUtil.isEmpty(
            CollisionUtil.COLLISION_EPSILON,
            CollisionUtil.COLLISION_EPSILON,
            10.0d,
            10.0d,
            10.0d,
            10.0d);

    // Assert
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Test {@link CollisionUtil#isEmpty(double, double, double, double, double, double)} with {@code
   * minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isEmpty(double, double, double, double, double,
   * double)}
   */
  @Test
  @DisplayName(
      "Test isEmpty(double, double, double, double, double, double) with 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isEmpty(double, double, double, double, double, double)"
  })
  void testIsEmptyWithMinXMinYMinZMaxXMaxYMaxZ_whenTen_thenReturnTrue() {
    // Arrange and Act
    boolean actualIsEmptyResult = CollisionUtil.isEmpty(10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Test {@link CollisionUtil#getBoxForChunk(int, int)}.
   *
   * <p>Method under test: {@link CollisionUtil#getBoxForChunk(int, int)}
   */
  @Test
  @DisplayName("Test getBoxForChunk(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.getBoxForChunk(int, int)"})
  void testGetBoxForChunk() {
    // Arrange and Act
    AABB actualBoxForChunk = CollisionUtil.getBoxForChunk(1, 1);

    // Assert
    assertEquals(15.9999997d, actualBoxForChunk.minX);
    assertEquals(15.9999997d, actualBoxForChunk.minZ);
    assertEquals(16.000000599999996d, actualBoxForChunk.getXsize());
    assertEquals(16.000000599999996d, actualBoxForChunk.getZsize());
    assertEquals(32.000000299999996d, actualBoxForChunk.maxX);
    assertEquals(32.000000299999996d, actualBoxForChunk.maxZ);
    assertFalse(actualBoxForChunk.hasNaN());
    assertEquals(Double.NEGATIVE_INFINITY, actualBoxForChunk.minY);
    assertEquals(Double.POSITIVE_INFINITY, actualBoxForChunk.getSize());
    assertEquals(Double.POSITIVE_INFINITY, actualBoxForChunk.getYsize());
    assertEquals(Double.POSITIVE_INFINITY, actualBoxForChunk.maxY);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName("Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box2() {
    // Arrange
    AABB box1 = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act and Assert
    assertFalse(CollisionUtil.voxelShapeIntersect(box1, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'; when SUCK_AABB; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box2_whenSuck_aabb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollisionUtil.voxelShapeIntersect(Hopper.SUCK_AABB, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName("Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box22() {
    // Arrange
    AABB box2 = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(Hopper.SUCK_AABB, box2);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName("Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box23() {
    // Arrange
    AABB box1 = new AABB(-1.0E-7d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act and Assert
    assertFalse(CollisionUtil.voxelShapeIntersect(box1, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName("Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box24() {
    // Arrange
    AABB box1 = new AABB(1.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act and Assert
    assertFalse(CollisionUtil.voxelShapeIntersect(box1, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName("Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box25() {
    // Arrange
    AABB box1 = new AABB(1.0d, 3.0d, -1.0E-7d, 1.0d, -1.0E-7d, -1.0E-7d);

    // Act and Assert
    assertFalse(CollisionUtil.voxelShapeIntersect(box1, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)} with {@code box1}, {@code box2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, AABB)}
   */
  @Test
  @DisplayName("Test voxelShapeIntersect(AABB, AABB) with 'box1', 'box2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.voxelShapeIntersect(AABB, AABB)"})
  void testVoxelShapeIntersectWithBox1Box26() {
    // Arrange
    AABB box1 = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, 2.3125d, -1.0E-7d);

    // Act and Assert
    assertFalse(CollisionUtil.voxelShapeIntersect(box1, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            CollisionUtil.getBoxForChunk(-1, -1), -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ_thenReturnTrue() {
    // Arrange
    AABB box = new Builder().build();

    // Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(box, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertTrue(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link Double#NEGATIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when NEGATIVE_INFINITY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ_whenNegative_infinity() {
    // Arrange
    AABB box = new Builder().build();

    // Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            box, 10.0d, 10.0d, 10.0d, 10.0d, Double.NEGATIVE_INFINITY, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link Double#NEGATIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when NEGATIVE_INFINITY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ_whenNegative_infinity2() {
    // Arrange
    AABB box = new Builder().build();

    // Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            box, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, Double.NEGATIVE_INFINITY);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when SUCK_AABB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ_whenSuck_aabb() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            Hopper.SUCK_AABB, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when SUCK_AABB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ_whenSuck_aabb2() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            Hopper.SUCK_AABB, -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double, double, double,
   * double)} with {@code box}, {@code minX}, {@code minY}, {@code minZ}, {@code maxX}, {@code
   * maxY}, {@code maxZ}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(AABB, double, double, double,
   * double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(AABB, double, double, double, double, double, double) with 'box', 'minX', 'minY', 'minZ', 'maxX', 'maxY', 'maxZ'; when SUCK_AABB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(AABB, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithBoxMinXMinYMinZMaxXMaxYMaxZ_whenSuck_aabb3() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            Hopper.SUCK_AABB, 10.0d, 10.0d, 10.0d, -1.0E-7d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ2() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ22() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ23() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d, 10.0d, -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d,
            10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ24() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            -1.0E-7d, -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d, -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d,
            10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ25() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            -1.0E-7d, -1.0E-7d, 10.0d, 10.0d, 10.0d, 10.0d, -1.0E-7d, -1.0E-7d, 10.0d, 10.0d, 10.0d,
            10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ26() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            -1.0E-7d, -1.0E-7d, -1.0E-7d, 10.0d, 10.0d, 10.0d, -1.0E-7d, -1.0E-7d, 10.0d, 10.0d,
            10.0d, 10.0d);

    // Assert
    assertFalse(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#voxelShapeIntersect(double, double, double, double, double, double,
   * double, double, double, double, double, double)} with {@code minX1}, {@code minY1}, {@code
   * minZ1}, {@code maxX1}, {@code maxY1}, {@code maxZ1}, {@code minX2}, {@code minY2}, {@code
   * minZ2}, {@code maxX2}, {@code maxY2}, {@code maxZ2}.
   *
   * <p>Method under test: {@link CollisionUtil#voxelShapeIntersect(double, double, double, double,
   * double, double, double, double, double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double) with 'minX1', 'minY1', 'minZ1', 'maxX1', 'maxY1', 'maxZ1', 'minX2', 'minY2', 'minZ2', 'maxX2', 'maxY2', 'maxZ2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.voxelShapeIntersect(double, double, double, double, double, double, double, double, double, double, double, double)"
  })
  void testVoxelShapeIntersectWithMinX1MinY1MinZ1MaxX1MaxY1MaxZ1MinX2MinY2MinZ2MaxX2MaxY2MaxZ27() {
    // Arrange and Act
    boolean actualVoxelShapeIntersectResult =
        CollisionUtil.voxelShapeIntersect(
            -1.0E-7d, -1.0E-7d, -1.0E-7d, 10.0d, 10.0d, 10.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, 10.0d,
            10.0d, 10.0d);

    // Assert
    assertTrue(actualVoxelShapeIntersectResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble() {
    // Arrange
    AABB target = new AABB(1.0d, 3.0d, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    double actualCollideXResult = CollisionUtil.collideX(target, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble2() {
    // Arrange
    AABB target = new AABB(1.0d, Double.NaN, 10.0d, 10.0d, 10.0d, 10.0d);

    // Act
    double actualCollideXResult = CollisionUtil.collideX(target, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When {@code -1.0E-10}.
   *   <li>Then return {@code -1.0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when '-1.0E-10'; then return '-1.0E-10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble_when10e10_thenReturn10e10() {
    // Arrange and Act
    double actualCollideXResult =
        CollisionUtil.collideX(Hopper.SUCK_AABB, Hopper.SUCK_AABB, -1.0E-10d);

    // Assert
    assertEquals(-1.0E-10d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When BoxForChunk one is minus one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when BoxForChunk one is minus one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble_whenBoxForChunkOneIsMinusOne_thenReturnTen() {
    // Arrange and Act
    double actualCollideXResult =
        CollisionUtil.collideX(CollisionUtil.getBoxForChunk(1, -1), Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When BoxForChunk one is one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when BoxForChunk one is one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble_whenBoxForChunkOneIsOne_thenReturnTen() {
    // Arrange and Act
    double actualCollideXResult =
        CollisionUtil.collideX(CollisionUtil.getBoxForChunk(1, 1), Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When cutBackwards {@link Builder} (default constructor) build and ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when cutBackwards Builder (default constructor) build and ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble_whenCutBackwardsBuilderBuildAndTen_thenReturnTen() {
    // Arrange
    AABB box = new Builder().build();

    // Act
    double actualCollideXResult =
        CollisionUtil.collideX(CollisionUtil.cutBackwards(box, 10.0d), Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideX(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideX(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideX(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideX(AABB, AABB, double)"})
  void testCollideXWithAabbAabbDouble_whenZero_thenReturnZero() {
    // Arrange and Act
    double actualCollideXResult = CollisionUtil.collideX(Hopper.SUCK_AABB, Hopper.SUCK_AABB, 0.0d);

    // Assert
    assertEquals(0.0d, actualCollideXResult);
  }

  /**
   * Test {@link CollisionUtil#collideY(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideY(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideY(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideY(AABB, AABB, double)"})
  void testCollideYWithAabbAabbDouble() {
    // Arrange
    AABB target = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideYResult = CollisionUtil.collideY(target, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideYResult);
  }

  /**
   * Test {@link CollisionUtil#collideY(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideY(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideY(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideY(AABB, AABB, double)"})
  void testCollideYWithAabbAabbDouble2() {
    // Arrange
    AABB source = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideYResult = CollisionUtil.collideY(Hopper.SUCK_AABB, source, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideYResult);
  }

  /**
   * Test {@link CollisionUtil#collideY(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideY(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideY(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideY(AABB, AABB, double)"})
  void testCollideYWithAabbAabbDouble3() {
    // Arrange
    AABB target = new AABB(-1.0E-7d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideYResult = CollisionUtil.collideY(target, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideYResult);
  }

  /**
   * Test {@link CollisionUtil#collideY(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideY(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideY(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideY(AABB, AABB, double)"})
  void testCollideYWithAabbAabbDouble4() {
    // Arrange
    AABB target = new AABB(1.0d, 3.0d, -1.0E-7d, 1.0000001d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideYResult = CollisionUtil.collideY(target, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideYResult);
  }

  /**
   * Test {@link CollisionUtil#collideY(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When {@code -1.0E-10}.
   *   <li>Then return {@code -1.0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideY(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideY(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when '-1.0E-10'; then return '-1.0E-10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideY(AABB, AABB, double)"})
  void testCollideYWithAabbAabbDouble_when10e10_thenReturn10e10() {
    // Arrange and Act
    double actualCollideYResult =
        CollisionUtil.collideY(Hopper.SUCK_AABB, Hopper.SUCK_AABB, -1.0E-10d);

    // Assert
    assertEquals(-1.0E-10d, actualCollideYResult);
  }

  /**
   * Test {@link CollisionUtil#collideY(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideY(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideY(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideY(AABB, AABB, double)"})
  void testCollideYWithAabbAabbDouble_whenTen_thenReturnTen() {
    // Arrange and Act
    double actualCollideYResult = CollisionUtil.collideY(Hopper.SUCK_AABB, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideYResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble() {
    // Arrange
    AABB source = new AABB(-1.0E-7d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideZResult = CollisionUtil.collideZ(Hopper.SUCK_AABB, source, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble2() {
    // Arrange
    AABB source = new AABB(1.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideZResult = CollisionUtil.collideZ(Hopper.SUCK_AABB, source, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble3() {
    // Arrange
    AABB source = new AABB(1.0d, 3.0d, -1.0E-7d, 1.0d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideZResult = CollisionUtil.collideZ(Hopper.SUCK_AABB, source, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName("Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble4() {
    // Arrange
    AABB source = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, 2.3125d, -1.0E-7d);

    // Act
    double actualCollideZResult = CollisionUtil.collideZ(Hopper.SUCK_AABB, source, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>Then return {@link CollisionUtil#COLLISION_EPSILON}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'; then return COLLISION_EPSILON")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble_thenReturnCollision_epsilon() {
    // Arrange
    AABB source = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideZResult = CollisionUtil.collideZ(Hopper.SUCK_AABB, source, 10.0d);

    // Assert
    assertEquals(CollisionUtil.COLLISION_EPSILON, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When {@code -1.0E-7}.
   *   <li>Then return {@code -1.0E-7}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when '-1.0E-7'; then return '-1.0E-7'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble_when10e7_thenReturn10e7() {
    // Arrange
    AABB target = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    // Act
    double actualCollideZResult = CollisionUtil.collideZ(target, Hopper.SUCK_AABB, -1.0E-7d);

    // Assert
    assertEquals(-1.0E-7d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When {@code -1.0E-10}.
   *   <li>Then return {@code -1.0E-10}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when '-1.0E-10'; then return '-1.0E-10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble_when10e10_thenReturn10e10() {
    // Arrange and Act
    double actualCollideZResult =
        CollisionUtil.collideZ(Hopper.SUCK_AABB, Hopper.SUCK_AABB, -1.0E-10d);

    // Assert
    assertEquals(-1.0E-10d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#collideZ(AABB, AABB, double)} with {@code AABB}, {@code AABB}, {@code
   * double}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#collideZ(AABB, AABB, double)}
   */
  @Test
  @DisplayName(
      "Test collideZ(AABB, AABB, double) with 'AABB', 'AABB', 'double'; when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.collideZ(AABB, AABB, double)"})
  void testCollideZWithAabbAabbDouble_whenTen_thenReturnTen() {
    // Arrange and Act
    double actualCollideZResult = CollisionUtil.collideZ(Hopper.SUCK_AABB, Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(10.0d, actualCollideZResult);
  }

  /**
   * Test {@link CollisionUtil#findFloor(double[], double, double, int, int)}.
   *
   * <ul>
   *   <li>When array of {@code double} with ten and {@code -1.0E-7}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#findFloor(double[], double, double, int, int)}
   */
  @Test
  @DisplayName(
      "Test findFloor(double[], double, double, int, int); when array of double with ten and '-1.0E-7'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CollisionUtil.findFloor(double[], double, double, int, int)"})
  void testFindFloor_whenArrayOfDoubleWithTenAnd10e7_thenReturnOne() {
    // Arrange and Act
    int actualFindFloorResult =
        CollisionUtil.findFloor(
            new double[] {10.0d, -1.0E-7d, 10.0d, -1.0E-7d}, 10.0d, 10.0d, 1, 3);

    // Assert
    assertEquals(1, actualFindFloorResult);
  }

  /**
   * Test {@link CollisionUtil#equals(DiscreteVoxelShape, DiscreteVoxelShape)} with {@code
   * DiscreteVoxelShape}, {@code DiscreteVoxelShape}.
   *
   * <p>Method under test: {@link CollisionUtil#equals(DiscreteVoxelShape, DiscreteVoxelShape)}
   */
  @Test
  @DisplayName(
      "Test equals(DiscreteVoxelShape, DiscreteVoxelShape) with 'DiscreteVoxelShape', 'DiscreteVoxelShape'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.equals(DiscreteVoxelShape, DiscreteVoxelShape)"})
  void testEqualsWithDiscreteVoxelShapeDiscreteVoxelShape() {
    // Arrange
    BitSetDiscreteVoxelShape shape1 =
        BitSetDiscreteVoxelShape.withFilledBounds(1, 3, 1, 1, 1, 1, 1, 1, 1);
    BitSetDiscreteVoxelShape shape2 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertTrue(CollisionUtil.equals(shape1, shape2));
  }

  /**
   * Test {@link CollisionUtil#equals(DiscreteVoxelShape, DiscreteVoxelShape)} with {@code
   * DiscreteVoxelShape}, {@code DiscreteVoxelShape}.
   *
   * <p>Method under test: {@link CollisionUtil#equals(DiscreteVoxelShape, DiscreteVoxelShape)}
   */
  @Test
  @DisplayName(
      "Test equals(DiscreteVoxelShape, DiscreteVoxelShape) with 'DiscreteVoxelShape', 'DiscreteVoxelShape'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.equals(DiscreteVoxelShape, DiscreteVoxelShape)"})
  void testEqualsWithDiscreteVoxelShapeDiscreteVoxelShape2() {
    // Arrange
    BitSetDiscreteVoxelShape shape1 =
        BitSetDiscreteVoxelShape.withFilledBounds(0, 3, 1, 1, 1, 1, 1, 1, 1);
    BitSetDiscreteVoxelShape shape2 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertTrue(CollisionUtil.equals(shape1, shape2));
  }

  /**
   * Test {@link CollisionUtil#equals(DiscreteVoxelShape, DiscreteVoxelShape)} with {@code
   * DiscreteVoxelShape}, {@code DiscreteVoxelShape}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#equals(DiscreteVoxelShape, DiscreteVoxelShape)}
   */
  @Test
  @DisplayName(
      "Test equals(DiscreteVoxelShape, DiscreteVoxelShape) with 'DiscreteVoxelShape', 'DiscreteVoxelShape'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.equals(DiscreteVoxelShape, DiscreteVoxelShape)"})
  void testEqualsWithDiscreteVoxelShapeDiscreteVoxelShape_thenReturnTrue() {
    // Arrange
    BitSetDiscreteVoxelShape shape1 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);
    BitSetDiscreteVoxelShape shape2 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertTrue(CollisionUtil.equals(shape1, shape2));
  }

  /**
   * Test {@link CollisionUtil#areAnyFull(DiscreteVoxelShape)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#areAnyFull(DiscreteVoxelShape)}
   */
  @Test
  @DisplayName("Test areAnyFull(DiscreteVoxelShape); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.areAnyFull(DiscreteVoxelShape)"})
  void testAreAnyFull_thenReturnFalse() {
    // Arrange
    BitSetDiscreteVoxelShape shape =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertFalse(CollisionUtil.areAnyFull(shape));
  }

  /**
   * Test {@link CollisionUtil#shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)}.
   *
   * <p>Method under test: {@link CollisionUtil#shapeMismatch(DiscreteVoxelShape,
   * DiscreteVoxelShape)}
   */
  @Test
  @DisplayName("Test shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CollisionUtil.shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)"
  })
  void testShapeMismatch() {
    // Arrange
    BitSetDiscreteVoxelShape shape1 =
        BitSetDiscreteVoxelShape.withFilledBounds(1, 3, 1, 1, 1, 1, 1, 1, 1);
    BitSetDiscreteVoxelShape shape2 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertNull(CollisionUtil.shapeMismatch(shape1, shape2));
  }

  /**
   * Test {@link CollisionUtil#shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)}.
   *
   * <p>Method under test: {@link CollisionUtil#shapeMismatch(DiscreteVoxelShape,
   * DiscreteVoxelShape)}
   */
  @Test
  @DisplayName("Test shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CollisionUtil.shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)"
  })
  void testShapeMismatch2() {
    // Arrange
    BitSetDiscreteVoxelShape shape1 =
        BitSetDiscreteVoxelShape.withFilledBounds(0, 3, 1, 1, 1, 1, 1, 1, 1);
    BitSetDiscreteVoxelShape shape2 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertNull(CollisionUtil.shapeMismatch(shape1, shape2));
  }

  /**
   * Test {@link CollisionUtil#shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#shapeMismatch(DiscreteVoxelShape,
   * DiscreteVoxelShape)}
   */
  @Test
  @DisplayName("Test shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String CollisionUtil.shapeMismatch(DiscreteVoxelShape, DiscreteVoxelShape)"
  })
  void testShapeMismatch_thenReturnNull() {
    // Arrange
    BitSetDiscreteVoxelShape shape1 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);
    BitSetDiscreteVoxelShape shape2 =
        BitSetDiscreteVoxelShape.withFilledBounds(2, 3, 1, 1, 1, 1, 1, 1, 1);

    // Act and Assert
    assertNull(CollisionUtil.shapeMismatch(shape1, shape2));
  }

  /**
   * Test {@link CollisionUtil#offsetX(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minZ} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#offsetX(AABB, double)}
   */
  @Test
  @DisplayName("Test offsetX(AABB, double); when SUCK_AABB; then return minZ is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.offsetX(AABB, double)"})
  void testOffsetX_whenSuck_aabb_thenReturnMinZIsZero() {
    // Arrange and Act
    AABB actualOffsetXResult = CollisionUtil.offsetX(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualOffsetXResult.minZ);
    assertEquals(0.6875d, actualOffsetXResult.minY);
    assertEquals(1.0d, actualOffsetXResult.getXsize());
    assertEquals(1.0d, actualOffsetXResult.getZsize());
    assertEquals(1.0d, actualOffsetXResult.maxZ);
    assertEquals(1.1041666666666667d, actualOffsetXResult.getSize());
    assertEquals(1.3125d, actualOffsetXResult.getYsize());
    assertEquals(10.0d, actualOffsetXResult.minX);
    assertEquals(11.0d, actualOffsetXResult.maxX);
    assertEquals(2.0d, actualOffsetXResult.maxY);
    assertFalse(actualOffsetXResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#offsetY(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#offsetY(AABB, double)}
   */
  @Test
  @DisplayName("Test offsetY(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.offsetY(AABB, double)"})
  void testOffsetY_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualOffsetYResult = CollisionUtil.offsetY(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualOffsetYResult.minX);
    assertEquals(0.0d, actualOffsetYResult.minZ);
    assertEquals(1.0d, actualOffsetYResult.getXsize());
    assertEquals(1.0d, actualOffsetYResult.getZsize());
    assertEquals(1.0d, actualOffsetYResult.maxX);
    assertEquals(1.0d, actualOffsetYResult.maxZ);
    assertEquals(1.1041666666666667d, actualOffsetYResult.getSize());
    assertEquals(1.3125d, actualOffsetYResult.getYsize());
    assertEquals(10.6875d, actualOffsetYResult.minY);
    assertEquals(12.0d, actualOffsetYResult.maxY);
    assertFalse(actualOffsetYResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#offsetZ(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#offsetZ(AABB, double)}
   */
  @Test
  @DisplayName("Test offsetZ(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.offsetZ(AABB, double)"})
  void testOffsetZ_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualOffsetZResult = CollisionUtil.offsetZ(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualOffsetZResult.minX);
    assertEquals(0.6875d, actualOffsetZResult.minY);
    assertEquals(1.0d, actualOffsetZResult.getXsize());
    assertEquals(1.0d, actualOffsetZResult.getZsize());
    assertEquals(1.0d, actualOffsetZResult.maxX);
    assertEquals(1.1041666666666667d, actualOffsetZResult.getSize());
    assertEquals(1.3125d, actualOffsetZResult.getYsize());
    assertEquals(10.0d, actualOffsetZResult.minZ);
    assertEquals(11.0d, actualOffsetZResult.maxZ);
    assertEquals(2.0d, actualOffsetZResult.maxY);
    assertFalse(actualOffsetZResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#expandRight(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#expandRight(AABB, double)}
   */
  @Test
  @DisplayName("Test expandRight(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.expandRight(AABB, double)"})
  void testExpandRight_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualExpandRightResult = CollisionUtil.expandRight(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualExpandRightResult.minX);
    assertEquals(0.0d, actualExpandRightResult.minZ);
    assertEquals(0.6875d, actualExpandRightResult.minY);
    assertEquals(1.0d, actualExpandRightResult.getZsize());
    assertEquals(1.0d, actualExpandRightResult.maxZ);
    assertEquals(1.3125d, actualExpandRightResult.getYsize());
    assertEquals(11.0d, actualExpandRightResult.getXsize());
    assertEquals(11.0d, actualExpandRightResult.maxX);
    assertEquals(2.0d, actualExpandRightResult.maxY);
    assertEquals(4.4375d, actualExpandRightResult.getSize());
    assertFalse(actualExpandRightResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#expandLeft(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#expandLeft(AABB, double)}
   */
  @Test
  @DisplayName("Test expandLeft(AABB, double); when SUCK_AABB; then return minX is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.expandLeft(AABB, double)"})
  void testExpandLeft_whenSuck_aabb_thenReturnMinXIsMinusTen() {
    // Arrange and Act
    AABB actualExpandLeftResult = CollisionUtil.expandLeft(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(-10.0d, actualExpandLeftResult.minX);
    assertEquals(0.0d, actualExpandLeftResult.minZ);
    assertEquals(0.6875d, actualExpandLeftResult.minY);
    assertEquals(1.0d, actualExpandLeftResult.getZsize());
    assertEquals(1.0d, actualExpandLeftResult.maxX);
    assertEquals(1.0d, actualExpandLeftResult.maxZ);
    assertEquals(1.3125d, actualExpandLeftResult.getYsize());
    assertEquals(11.0d, actualExpandLeftResult.getXsize());
    assertEquals(2.0d, actualExpandLeftResult.maxY);
    assertEquals(4.4375d, actualExpandLeftResult.getSize());
    assertFalse(actualExpandLeftResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#expandUpwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#expandUpwards(AABB, double)}
   */
  @Test
  @DisplayName("Test expandUpwards(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.expandUpwards(AABB, double)"})
  void testExpandUpwards_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualExpandUpwardsResult = CollisionUtil.expandUpwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualExpandUpwardsResult.minX);
    assertEquals(0.0d, actualExpandUpwardsResult.minZ);
    assertEquals(0.6875d, actualExpandUpwardsResult.minY);
    assertEquals(1.0d, actualExpandUpwardsResult.getXsize());
    assertEquals(1.0d, actualExpandUpwardsResult.getZsize());
    assertEquals(1.0d, actualExpandUpwardsResult.maxX);
    assertEquals(1.0d, actualExpandUpwardsResult.maxZ);
    assertEquals(11.3125d, actualExpandUpwardsResult.getYsize());
    assertEquals(12.0d, actualExpandUpwardsResult.maxY);
    assertEquals(4.4375d, actualExpandUpwardsResult.getSize());
    assertFalse(actualExpandUpwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#expandDownwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minY} is {@code -9.3125}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#expandDownwards(AABB, double)}
   */
  @Test
  @DisplayName("Test expandDownwards(AABB, double); when SUCK_AABB; then return minY is '-9.3125'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.expandDownwards(AABB, double)"})
  void testExpandDownwards_whenSuck_aabb_thenReturnMinYIs93125() {
    // Arrange and Act
    AABB actualExpandDownwardsResult = CollisionUtil.expandDownwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(-9.3125d, actualExpandDownwardsResult.minY);
    assertEquals(0.0d, actualExpandDownwardsResult.minX);
    assertEquals(0.0d, actualExpandDownwardsResult.minZ);
    assertEquals(1.0d, actualExpandDownwardsResult.getXsize());
    assertEquals(1.0d, actualExpandDownwardsResult.getZsize());
    assertEquals(1.0d, actualExpandDownwardsResult.maxX);
    assertEquals(1.0d, actualExpandDownwardsResult.maxZ);
    assertEquals(11.3125d, actualExpandDownwardsResult.getYsize());
    assertEquals(2.0d, actualExpandDownwardsResult.maxY);
    assertEquals(4.4375d, actualExpandDownwardsResult.getSize());
    assertFalse(actualExpandDownwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#expandForwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#expandForwards(AABB, double)}
   */
  @Test
  @DisplayName("Test expandForwards(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.expandForwards(AABB, double)"})
  void testExpandForwards_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualExpandForwardsResult = CollisionUtil.expandForwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualExpandForwardsResult.minX);
    assertEquals(0.0d, actualExpandForwardsResult.minZ);
    assertEquals(0.6875d, actualExpandForwardsResult.minY);
    assertEquals(1.0d, actualExpandForwardsResult.getXsize());
    assertEquals(1.0d, actualExpandForwardsResult.maxX);
    assertEquals(1.3125d, actualExpandForwardsResult.getYsize());
    assertEquals(11.0d, actualExpandForwardsResult.getZsize());
    assertEquals(11.0d, actualExpandForwardsResult.maxZ);
    assertEquals(2.0d, actualExpandForwardsResult.maxY);
    assertEquals(4.4375d, actualExpandForwardsResult.getSize());
    assertFalse(actualExpandForwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#expandBackwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minZ} is minus ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#expandBackwards(AABB, double)}
   */
  @Test
  @DisplayName("Test expandBackwards(AABB, double); when SUCK_AABB; then return minZ is minus ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.expandBackwards(AABB, double)"})
  void testExpandBackwards_whenSuck_aabb_thenReturnMinZIsMinusTen() {
    // Arrange and Act
    AABB actualExpandBackwardsResult = CollisionUtil.expandBackwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(-10.0d, actualExpandBackwardsResult.minZ);
    assertEquals(0.0d, actualExpandBackwardsResult.minX);
    assertEquals(0.6875d, actualExpandBackwardsResult.minY);
    assertEquals(1.0d, actualExpandBackwardsResult.getXsize());
    assertEquals(1.0d, actualExpandBackwardsResult.maxX);
    assertEquals(1.0d, actualExpandBackwardsResult.maxZ);
    assertEquals(1.3125d, actualExpandBackwardsResult.getYsize());
    assertEquals(11.0d, actualExpandBackwardsResult.getZsize());
    assertEquals(2.0d, actualExpandBackwardsResult.maxY);
    assertEquals(4.4375d, actualExpandBackwardsResult.getSize());
    assertFalse(actualExpandBackwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#cutRight(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minZ} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#cutRight(AABB, double)}
   */
  @Test
  @DisplayName("Test cutRight(AABB, double); when SUCK_AABB; then return minZ is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.cutRight(AABB, double)"})
  void testCutRight_whenSuck_aabb_thenReturnMinZIsZero() {
    // Arrange and Act
    AABB actualCutRightResult = CollisionUtil.cutRight(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualCutRightResult.minZ);
    assertEquals(0.6875d, actualCutRightResult.minY);
    assertEquals(1.0d, actualCutRightResult.getZsize());
    assertEquals(1.0d, actualCutRightResult.maxZ);
    assertEquals(1.0d, actualCutRightResult.minX);
    assertEquals(1.3125d, actualCutRightResult.getYsize());
    assertEquals(10.0d, actualCutRightResult.getXsize());
    assertEquals(11.0d, actualCutRightResult.maxX);
    assertEquals(2.0d, actualCutRightResult.maxY);
    assertEquals(4.104166666666667d, actualCutRightResult.getSize());
    assertFalse(actualCutRightResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#cutLeft(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#cutLeft(AABB, double)}
   */
  @Test
  @DisplayName("Test cutLeft(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.cutLeft(AABB, double)"})
  void testCutLeft_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualCutLeftResult = CollisionUtil.cutLeft(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualCutLeftResult.minX);
    assertEquals(0.0d, actualCutLeftResult.minZ);
    assertEquals(0.6875d, actualCutLeftResult.minY);
    assertEquals(1.0d, actualCutLeftResult.getZsize());
    assertEquals(1.0d, actualCutLeftResult.maxZ);
    assertEquals(1.3125d, actualCutLeftResult.getYsize());
    assertEquals(10.0d, actualCutLeftResult.getXsize());
    assertEquals(10.0d, actualCutLeftResult.maxX);
    assertEquals(2.0d, actualCutLeftResult.maxY);
    assertEquals(4.104166666666667d, actualCutLeftResult.getSize());
    assertFalse(actualCutLeftResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#cutUpwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#cutUpwards(AABB, double)}
   */
  @Test
  @DisplayName("Test cutUpwards(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.cutUpwards(AABB, double)"})
  void testCutUpwards_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualCutUpwardsResult = CollisionUtil.cutUpwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualCutUpwardsResult.minX);
    assertEquals(0.0d, actualCutUpwardsResult.minZ);
    assertEquals(1.0d, actualCutUpwardsResult.getXsize());
    assertEquals(1.0d, actualCutUpwardsResult.getZsize());
    assertEquals(1.0d, actualCutUpwardsResult.maxX);
    assertEquals(1.0d, actualCutUpwardsResult.maxZ);
    assertEquals(10.0d, actualCutUpwardsResult.getYsize());
    assertEquals(12.0d, actualCutUpwardsResult.maxY);
    assertEquals(2.0d, actualCutUpwardsResult.minY);
    assertEquals(4.0d, actualCutUpwardsResult.getSize());
    assertFalse(actualCutUpwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#cutDownwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#cutDownwards(AABB, double)}
   */
  @Test
  @DisplayName("Test cutDownwards(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.cutDownwards(AABB, double)"})
  void testCutDownwards_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualCutDownwardsResult = CollisionUtil.cutDownwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualCutDownwardsResult.minX);
    assertEquals(0.0d, actualCutDownwardsResult.minZ);
    assertEquals(0.6875d, actualCutDownwardsResult.minY);
    assertEquals(1.0d, actualCutDownwardsResult.getXsize());
    assertEquals(1.0d, actualCutDownwardsResult.getZsize());
    assertEquals(1.0d, actualCutDownwardsResult.maxX);
    assertEquals(1.0d, actualCutDownwardsResult.maxZ);
    assertEquals(10.0d, actualCutDownwardsResult.getYsize());
    assertEquals(10.6875d, actualCutDownwardsResult.maxY);
    assertEquals(4.0d, actualCutDownwardsResult.getSize());
    assertFalse(actualCutDownwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#cutForwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#cutForwards(AABB, double)}
   */
  @Test
  @DisplayName("Test cutForwards(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.cutForwards(AABB, double)"})
  void testCutForwards_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualCutForwardsResult = CollisionUtil.cutForwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualCutForwardsResult.minX);
    assertEquals(0.6875d, actualCutForwardsResult.minY);
    assertEquals(1.0d, actualCutForwardsResult.getXsize());
    assertEquals(1.0d, actualCutForwardsResult.maxX);
    assertEquals(1.0d, actualCutForwardsResult.minZ);
    assertEquals(1.3125d, actualCutForwardsResult.getYsize());
    assertEquals(10.0d, actualCutForwardsResult.getZsize());
    assertEquals(11.0d, actualCutForwardsResult.maxZ);
    assertEquals(2.0d, actualCutForwardsResult.maxY);
    assertEquals(4.104166666666667d, actualCutForwardsResult.getSize());
    assertFalse(actualCutForwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#cutBackwards(AABB, double)}.
   *
   * <ul>
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return {@link AABB#minX} is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#cutBackwards(AABB, double)}
   */
  @Test
  @DisplayName("Test cutBackwards(AABB, double); when SUCK_AABB; then return minX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AABB CollisionUtil.cutBackwards(AABB, double)"})
  void testCutBackwards_whenSuck_aabb_thenReturnMinXIsZero() {
    // Arrange and Act
    AABB actualCutBackwardsResult = CollisionUtil.cutBackwards(Hopper.SUCK_AABB, 10.0d);

    // Assert
    assertEquals(0.0d, actualCutBackwardsResult.minX);
    assertEquals(0.0d, actualCutBackwardsResult.minZ);
    assertEquals(0.6875d, actualCutBackwardsResult.minY);
    assertEquals(1.0d, actualCutBackwardsResult.getXsize());
    assertEquals(1.0d, actualCutBackwardsResult.maxX);
    assertEquals(1.3125d, actualCutBackwardsResult.getYsize());
    assertEquals(10.0d, actualCutBackwardsResult.getZsize());
    assertEquals(10.0d, actualCutBackwardsResult.maxZ);
    assertEquals(2.0d, actualCutBackwardsResult.maxY);
    assertEquals(4.104166666666667d, actualCutBackwardsResult.getSize());
    assertFalse(actualCutBackwardsResult.hasNaN());
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsX(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsX(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsX(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX2() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsX(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsX(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX3() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, 2.3125d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsX(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@code -1.0E-7}.
   *   <li>Then return {@code -1.0E-7}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsX(AABB, double, List); given SUCK_AABB; when '-1.0E-7'; then return '-1.0E-7'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX_givenSuck_aabb_when10e7_thenReturn10e7() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        -1.0E-7d,
        CollisionUtil.performAABBCollisionsX(Hopper.SUCK_AABB, -1.0E-7d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When BoxForChunk one is one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsX(AABB, double, List); given SUCK_AABB; when BoxForChunk one is one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX_givenSuck_aabb_whenBoxForChunkOneIsOne_thenReturnTen() {
    // Arrange
    AABB currentBoundingBox = CollisionUtil.getBoxForChunk(1, 1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsX(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsX(AABB, double, List); given SUCK_AABB; when SUCK_AABB; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX_givenSuck_aabb_whenSuck_aabb_thenReturnTen() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsX(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsX(AABB, double, List); given SUCK_AABB; when SUCK_AABB; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX_givenSuck_aabb_whenSuck_aabb_thenReturnTen2() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsX(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsX(AABB, double, List); given SUCK_AABB; when SUCK_AABB; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX_givenSuck_aabb_whenSuck_aabb_thenReturnTen3() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsX(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsX(AABB, double, List); when ArrayList(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsX(AABB, double, List)"})
  void testPerformAABBCollisionsX_whenArrayList_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsX(Hopper.SUCK_AABB, 10.0d, new ArrayList<>()));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsY(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsY(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsY(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY2() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    AABB aabb = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);
    potentialCollisions.add(aabb);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given BoxForChunk one is one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsY(AABB, double, List); given BoxForChunk one is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_givenBoxForChunkOneIsOne() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(CollisionUtil.getBoxForChunk(1, 1));

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@code -1.0E-7}.
   *   <li>Then return {@code -1.0E-7}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsY(AABB, double, List); given SUCK_AABB; when '-1.0E-7'; then return '-1.0E-7'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_givenSuck_aabb_when10e7_thenReturn10e7() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        -1.0E-7d,
        CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, -1.0E-7d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Hopper#SUCK_AABB}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsY(AABB, double, List); given SUCK_AABB; when ArrayList() add SUCK_AABB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_givenSuck_aabb_whenArrayListAddSuck_aabb() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Hopper#SUCK_AABB}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsY(AABB, double, List); given SUCK_AABB; when ArrayList() add SUCK_AABB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_givenSuck_aabb_whenArrayListAddSuck_aabb2() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Hopper#SUCK_AABB}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsY(AABB, double, List); given SUCK_AABB; when ArrayList() add SUCK_AABB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_givenSuck_aabb_whenArrayListAddSuck_aabb3() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When BoxForChunk one is one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsY(AABB, double, List); given SUCK_AABB; when BoxForChunk one is one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_givenSuck_aabb_whenBoxForChunkOneIsOne_thenReturnTen() {
    // Arrange
    AABB currentBoundingBox = CollisionUtil.getBoxForChunk(1, 1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsY(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsY(AABB, double, List); when ArrayList(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsY(AABB, double, List)"})
  void testPerformAABBCollisionsY_whenArrayList_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsY(Hopper.SUCK_AABB, 10.0d, new ArrayList<>()));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsZ(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    AABB aabb = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);
    potentialCollisions.add(aabb);

    // Act and Assert
    assertEquals(
        -1.0E-7d,
        CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, -1.0E-7d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsZ(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ2() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsZ(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsZ(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ3() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, 2.3125d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsZ(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given BoxForChunk one is one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsZ(AABB, double, List); given BoxForChunk one is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_givenBoxForChunkOneIsOne() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(CollisionUtil.getBoxForChunk(1, 1));

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@code -1.0E-7}.
   *   <li>Then return {@code -1.0E-7}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsZ(AABB, double, List); given SUCK_AABB; when '-1.0E-7'; then return '-1.0E-7'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_givenSuck_aabb_when10e7_thenReturn10e7() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        -1.0E-7d,
        CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, -1.0E-7d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When BoxForChunk one is one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsZ(AABB, double, List); given SUCK_AABB; when BoxForChunk one is one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_givenSuck_aabb_whenBoxForChunkOneIsOne_thenReturnTen() {
    // Arrange
    AABB currentBoundingBox = CollisionUtil.getBoxForChunk(1, 1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d,
        CollisionUtil.performAABBCollisionsZ(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsZ(AABB, double, List); given SUCK_AABB; when SUCK_AABB; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_givenSuck_aabb_whenSuck_aabb_thenReturnTen() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsZ(AABB, double, List); given SUCK_AABB; when SUCK_AABB; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_givenSuck_aabb_whenSuck_aabb_thenReturnTen2() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When {@link Hopper#SUCK_AABB}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisionsZ(AABB, double, List); given SUCK_AABB; when SUCK_AABB; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_givenSuck_aabb_whenSuck_aabb_thenReturnTen3() {
    // Arrange
    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>Then return {@link CollisionUtil#COLLISION_EPSILON}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsZ(AABB, double, List); then return COLLISION_EPSILON")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_thenReturnCollision_epsilon() {
    // Arrange
    AABB currentBoundingBox = new AABB(1.0d, 3.0d, -1.0E-7d, -1.0E-7d, -1.0E-7d, -1.0E-7d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act and Assert
    assertEquals(
        CollisionUtil.COLLISION_EPSILON,
        CollisionUtil.performAABBCollisionsZ(currentBoundingBox, 10.0d, potentialCollisions));
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisionsZ(AABB, double, List); when ArrayList(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performAABBCollisionsZ(AABB, double, List)"})
  void testPerformAABBCollisionsZ_whenArrayList_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performAABBCollisionsZ(Hopper.SUCK_AABB, 10.0d, new ArrayList<>()));
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisionsX(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisionsX(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performVoxelCollisionsX(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performVoxelCollisionsX(AABB, double, List)"})
  void testPerformVoxelCollisionsX() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performVoxelCollisionsX(Hopper.SUCK_AABB, 10.0d, new ArrayList<>()));
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisionsY(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisionsY(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performVoxelCollisionsY(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performVoxelCollisionsY(AABB, double, List)"})
  void testPerformVoxelCollisionsY() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performVoxelCollisionsY(Hopper.SUCK_AABB, 10.0d, new ArrayList<>()));
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisionsZ(AABB, double, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisionsZ(AABB, double, List)}
   */
  @Test
  @DisplayName("Test performVoxelCollisionsZ(AABB, double, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double CollisionUtil.performVoxelCollisionsZ(AABB, double, List)"})
  void testPerformVoxelCollisionsZ() {
    // Arrange, Act and Assert
    assertEquals(
        10.0d, CollisionUtil.performVoxelCollisionsZ(Hopper.SUCK_AABB, 10.0d, new ArrayList<>()));
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performVoxelCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performVoxelCollisions(Vec3, AABB, List)"})
  void testPerformVoxelCollisions() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.00392156862745098d);

    // Act
    Vec3 actualPerformVoxelCollisionsResult =
        CollisionUtil.performVoxelCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformVoxelCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Then return directionFromRotation ten and ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performVoxelCollisions(Vec3, AABB, List); then return directionFromRotation ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performVoxelCollisions(Vec3, AABB, List)"})
  void testPerformVoxelCollisions_thenReturnDirectionFromRotationTenAndTen() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);

    // Act
    Vec3 actualPerformVoxelCollisionsResult =
        CollisionUtil.performVoxelCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformVoxelCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Then return {@link Vec3#Vec3(double, double, double)} with x is two and y is three and z
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performVoxelCollisions(Vec3, AABB, List); then return Vec3(double, double, double) with x is two and y is three and z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performVoxelCollisions(Vec3, AABB, List)"})
  void testPerformVoxelCollisions_thenReturnVec3WithXIsTwoAndYIsThreeAndZIsZero() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.0d);

    // Act
    Vec3 actualPerformVoxelCollisionsResult =
        CollisionUtil.performVoxelCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformVoxelCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performVoxelCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performVoxelCollisions(Vec3, AABB, List); when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performVoxelCollisions(Vec3, AABB, List)"})
  void testPerformVoxelCollisions_whenFromRGB24One_thenReturnFromRGB24One() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);

    // Act
    Vec3 actualPerformVoxelCollisionsResult =
        CollisionUtil.performVoxelCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformVoxelCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.00392156862745098d);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions2() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions3() {
    // Arrange
    Vec3 moveVector = new Vec3(-1.0E-7d, 3.0d, 0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions4() {
    // Arrange
    Vec3 moveVector = new Vec3(-1.0d, 3.0d, 0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions5() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, -1.3125d, 0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions6() {
    // Arrange
    Vec3 moveVector = new Vec3(-1.0E-7d, -1.3125d, 0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Given BoxForChunk minus one is minus one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); given BoxForChunk minus one is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_givenBoxForChunkMinusOneIsMinusOne() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(CollisionUtil.getBoxForChunk(-1, -1));

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(
        actualPerformAABBCollisionsResult.horizontal().horizontal(),
        actualPerformAABBCollisionsResult.horizontal().horizontal());
    assertEquals(
        actualPerformAABBCollisionsResult.normalize().normalize(),
        actualPerformAABBCollisionsResult.normalize().normalize());
    Vector3f toVector3fResult = actualPerformAABBCollisionsResult.toVector3f();
    Vector3f actualAbsoluteResult = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Given BoxForChunk minus one is minus one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); given BoxForChunk minus one is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_givenBoxForChunkMinusOneIsMinusOne2() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);
    AABB axisalignedbb =
        new AABB(
            1.0d,
            3.0d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(CollisionUtil.getBoxForChunk(-1, -1));

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, axisalignedbb, potentialCollisions);

    // Assert
    assertEquals(
        actualPerformAABBCollisionsResult.horizontal().horizontal(),
        actualPerformAABBCollisionsResult.horizontal().horizontal());
    assertEquals(
        actualPerformAABBCollisionsResult.normalize().normalize(),
        actualPerformAABBCollisionsResult.normalize().normalize());
    Vector3f toVector3fResult = actualPerformAABBCollisionsResult.toVector3f();
    Vector3f actualAbsoluteResult = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); given SUCK_AABB; when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_givenSuck_aabb_whenFromRGB24One_thenReturnFromRGB24One() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); given SUCK_AABB; when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_givenSuck_aabb_whenFromRGB24One_thenReturnFromRGB24One2() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Then return horizontal horizontal.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName("Test performAABBCollisions(Vec3, AABB, List); then return horizontal horizontal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_thenReturnHorizontalHorizontal() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(
        actualPerformAABBCollisionsResult.horizontal().horizontal(),
        actualPerformAABBCollisionsResult.horizontal().horizontal());
    assertEquals(
        actualPerformAABBCollisionsResult.normalize().normalize(),
        actualPerformAABBCollisionsResult.normalize().normalize());
    Vector3f toVector3fResult = actualPerformAABBCollisionsResult.toVector3f();
    Vector3f actualAbsoluteResult = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Then return normalize x is {@code -0.7016705062022076}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); then return normalize x is '-0.7016705062022076'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_thenReturnNormalizeXIs07016705062022076() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);
    AABB axisalignedbb =
        new AABB(
            1.0d,
            3.0d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    AABB aabb =
        new AABB(
            1.0d,
            3.0d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d);
    potentialCollisions.add(aabb);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, axisalignedbb, potentialCollisions);

    // Assert
    Vec3 normalizeResult = actualPerformAABBCollisionsResult.normalize();
    assertEquals(-0.7016705062022076d, normalizeResult.x());
    assertEquals(-0.7016705062022076d, normalizeResult.x);
    assertEquals(-0.7125015794550478d, normalizeResult.y());
    assertEquals(-0.7125015794550478d, normalizeResult.y);
    assertEquals(0.17096714675426483d, actualPerformAABBCollisionsResult.horizontal().length());
    assertEquals(0.24365730815682235d, actualPerformAABBCollisionsResult.length());
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>Then return {@link Vec3#Vec3(double, double, double)} with x is two and y is three and z
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); then return Vec3(double, double, double) with x is two and y is three and z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_thenReturnVec3WithXIsTwoAndYIsThreeAndZIsZero() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.0d);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return horizontal horizontal.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); when ArrayList(); then return horizontal horizontal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_whenArrayList_thenReturnHorizontalHorizontal() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(
        actualPerformAABBCollisionsResult.horizontal().horizontal(),
        actualPerformAABBCollisionsResult.horizontal().horizontal());
    assertEquals(
        actualPerformAABBCollisionsResult.normalize().normalize(),
        actualPerformAABBCollisionsResult.normalize().normalize());
    Vector3f toVector3fResult = actualPerformAABBCollisionsResult.toVector3f();
    Vector3f actualAbsoluteResult = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>When BoxForChunk minus one is minus one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); when BoxForChunk minus one is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_whenBoxForChunkMinusOneIsMinusOne() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);
    AABB axisalignedbb = CollisionUtil.getBoxForChunk(-1, -1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    AABB aabb =
        new AABB(
            1.0d,
            3.0d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d);
    potentialCollisions.add(aabb);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, axisalignedbb, potentialCollisions);

    // Assert
    assertEquals(
        actualPerformAABBCollisionsResult.horizontal().horizontal(),
        actualPerformAABBCollisionsResult.horizontal().horizontal());
    assertEquals(
        actualPerformAABBCollisionsResult.normalize().normalize(),
        actualPerformAABBCollisionsResult.normalize().normalize());
    Vector3f toVector3fResult = actualPerformAABBCollisionsResult.toVector3f();
    Vector3f actualAbsoluteResult = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>When cutBackwards {@link Hopper#SUCK_AABB} and {@code 0.00392156862745098}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); when cutBackwards SUCK_AABB and '0.00392156862745098'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_whenCutBackwardsSuck_aabbAnd000392156862745098() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);
    AABB axisalignedbb = CollisionUtil.cutBackwards(Hopper.SUCK_AABB, 0.00392156862745098d);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    AABB aabb =
        new AABB(
            1.0d,
            3.0d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d,
            0.00392156862745098d);
    potentialCollisions.add(aabb);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, axisalignedbb, potentialCollisions);

    // Assert
    assertEquals(
        actualPerformAABBCollisionsResult.horizontal().horizontal(),
        actualPerformAABBCollisionsResult.horizontal().horizontal());
    assertEquals(
        actualPerformAABBCollisionsResult.normalize().normalize(),
        actualPerformAABBCollisionsResult.normalize().normalize());
    Vector3f toVector3fResult = actualPerformAABBCollisionsResult.toVector3f();
    Vector3f actualAbsoluteResult = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>When fromRGB24 minus one.
   *   <li>Then return fromRGB24 minus one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); when fromRGB24 minus one; then return fromRGB24 minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_whenFromRGB24MinusOne_thenReturnFromRGB24MinusOne() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(-1);

    ArrayList<AABB> potentialCollisions = new ArrayList<>();
    potentialCollisions.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, potentialCollisions);

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performAABBCollisions(Vec3, AABB, List)}
   */
  @Test
  @DisplayName(
      "Test performAABBCollisions(Vec3, AABB, List); when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performAABBCollisions(Vec3, AABB, List)"})
  void testPerformAABBCollisions_whenFromRGB24One_thenReturnFromRGB24One() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);

    // Act
    Vec3 actualPerformAABBCollisionsResult =
        CollisionUtil.performAABBCollisions(moveVector, Hopper.SUCK_AABB, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformAABBCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName("Test performCollisions(Vec3, AABB, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.00392156862745098d);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName("Test performCollisions(Vec3, AABB, List, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions2() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.00392156862745098d);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    ArrayList<AABB> aabbs = new ArrayList<>();
    aabbs.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, aabbs);

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName(
      "Test performCollisions(Vec3, AABB, List, List); given SUCK_AABB; when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions_givenSuck_aabb_whenFromRGB24One_thenReturnFromRGB24One() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    ArrayList<AABB> aabbs = new ArrayList<>();
    aabbs.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, aabbs);

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <ul>
   *   <li>Given {@link Hopper#SUCK_AABB}.
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName(
      "Test performCollisions(Vec3, AABB, List, List); given SUCK_AABB; when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions_givenSuck_aabb_whenFromRGB24One_thenReturnFromRGB24One2() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    ArrayList<AABB> aabbs = new ArrayList<>();
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, aabbs);

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <ul>
   *   <li>Then return directionFromRotation ten and ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName(
      "Test performCollisions(Vec3, AABB, List, List); then return directionFromRotation ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions_thenReturnDirectionFromRotationTenAndTen() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <ul>
   *   <li>Then return directionFromRotation ten and ten.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName(
      "Test performCollisions(Vec3, AABB, List, List); then return directionFromRotation ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions_thenReturnDirectionFromRotationTenAndTen2() {
    // Arrange
    Vec3 moveVector = Vec3.directionFromRotation(10.0f, 10.0f);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    ArrayList<AABB> aabbs = new ArrayList<>();
    aabbs.add(Hopper.SUCK_AABB);

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, aabbs);

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <ul>
   *   <li>Then return {@link Vec3#Vec3(double, double, double)} with x is two and y is three and z
   *       is zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName(
      "Test performCollisions(Vec3, AABB, List, List); then return Vec3(double, double, double) with x is two and y is three and z is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions_thenReturnVec3WithXIsTwoAndYIsThreeAndZIsZero() {
    // Arrange
    Vec3 moveVector = new Vec3(2.0d, 3.0d, 0.0d);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return fromRGB24 one.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#performCollisions(Vec3, AABB, List, List)}
   */
  @Test
  @DisplayName(
      "Test performCollisions(Vec3, AABB, List, List); when fromRGB24 one; then return fromRGB24 one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vec3 CollisionUtil.performCollisions(Vec3, AABB, List, List)"})
  void testPerformCollisions_whenFromRGB24One_thenReturnFromRGB24One() {
    // Arrange
    Vec3 moveVector = Vec3.fromRGB24(1);
    ArrayList<VoxelShape> voxels = new ArrayList<>();

    // Act
    Vec3 actualPerformCollisionsResult =
        CollisionUtil.performCollisions(moveVector, Hopper.SUCK_AABB, voxels, new ArrayList<>());

    // Assert
    assertEquals(moveVector, actualPerformCollisionsResult);
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)} with {@code worldborder},
   * {@code boundingBox}.
   *
   * <ul>
   *   <li>Given {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, AABB) with 'worldborder', 'boundingBox'; given '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isCollidingWithBorder(WorldBorder, AABB)"})
  void testIsCollidingWithBorderWithWorldborderBoundingBox_given05() {
    // Arrange
    WorldBorder worldborder = new WorldBorder();
    worldborder.setSize(-0.5d);

    // Act and Assert
    assertTrue(CollisionUtil.isCollidingWithBorder(worldborder, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)} with {@code worldborder},
   * {@code boundingBox}.
   *
   * <ul>
   *   <li>Given three.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, AABB) with 'worldborder', 'boundingBox'; given three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isCollidingWithBorder(WorldBorder, AABB)"})
  void testIsCollidingWithBorderWithWorldborderBoundingBox_givenThree() {
    // Arrange
    WorldBorder worldborder = new WorldBorder();
    worldborder.setAbsoluteMaxSize(3);
    worldborder.lerpSizeBetween(10.0d, CollisionUtil.COLLISION_EPSILON, 10L);

    // Act and Assert
    assertFalse(CollisionUtil.isCollidingWithBorder(worldborder, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)} with {@code worldborder},
   * {@code boundingBox}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, AABB) with 'worldborder', 'boundingBox'; given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isCollidingWithBorder(WorldBorder, AABB)"})
  void testIsCollidingWithBorderWithWorldborderBoundingBox_givenZero() {
    // Arrange
    WorldBorder worldborder = new WorldBorder();
    worldborder.lerpSizeBetween(10.0d, CollisionUtil.COLLISION_EPSILON, 0L);

    // Act and Assert
    assertFalse(CollisionUtil.isCollidingWithBorder(worldborder, Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)} with {@code worldborder},
   * {@code boundingBox}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, AABB) with 'worldborder', 'boundingBox'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isCollidingWithBorder(WorldBorder, AABB)"})
  void testIsCollidingWithBorderWithWorldborderBoundingBox_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollisionUtil.isCollidingWithBorder(new WorldBorder(), Hopper.SUCK_AABB));
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)} with {@code worldborder},
   * {@code boundingBox}.
   *
   * <ul>
   *   <li>When {@link Builder} (default constructor) build.
   * </ul>
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, AABB)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, AABB) with 'worldborder', 'boundingBox'; when Builder (default constructor) build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollisionUtil.isCollidingWithBorder(WorldBorder, AABB)"})
  void testIsCollidingWithBorderWithWorldborderBoundingBox_whenBuilderBuild() {
    // Arrange
    WorldBorder worldborder = new WorldBorder();
    AABB boundingBox = new Builder().build();

    // Act
    boolean actualIsCollidingWithBorderResult =
        CollisionUtil.isCollidingWithBorder(worldborder, boundingBox);

    // Assert
    assertTrue(actualIsCollidingWithBorderResult);
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double, double, double)}
   * with {@code worldborder}, {@code boxMinX}, {@code boxMaxX}, {@code boxMinZ}, {@code boxMaxZ}.
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, double, double, double, double) with 'worldborder', 'boxMinX', 'boxMaxX', 'boxMinZ', 'boxMaxZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isCollidingWithBorder(WorldBorder, double, double, double, double)"
  })
  void testIsCollidingWithBorderWithWorldborderBoxMinXBoxMaxXBoxMinZBoxMaxZ() {
    // Arrange and Act
    boolean actualIsCollidingWithBorderResult =
        CollisionUtil.isCollidingWithBorder(new WorldBorder(), 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertFalse(actualIsCollidingWithBorderResult);
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double, double, double)}
   * with {@code worldborder}, {@code boxMinX}, {@code boxMaxX}, {@code boxMinZ}, {@code boxMaxZ}.
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, double, double, double, double) with 'worldborder', 'boxMinX', 'boxMaxX', 'boxMinZ', 'boxMaxZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isCollidingWithBorder(WorldBorder, double, double, double, double)"
  })
  void testIsCollidingWithBorderWithWorldborderBoxMinXBoxMaxXBoxMinZBoxMaxZ2() {
    // Arrange
    WorldBorder worldborder = new WorldBorder();
    worldborder.setSize(CollisionUtil.COLLISION_EPSILON);

    // Act
    boolean actualIsCollidingWithBorderResult =
        CollisionUtil.isCollidingWithBorder(worldborder, 10.0d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertTrue(actualIsCollidingWithBorderResult);
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double, double, double)}
   * with {@code worldborder}, {@code boxMinX}, {@code boxMaxX}, {@code boxMinZ}, {@code boxMaxZ}.
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, double, double, double, double) with 'worldborder', 'boxMinX', 'boxMaxX', 'boxMinZ', 'boxMaxZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isCollidingWithBorder(WorldBorder, double, double, double, double)"
  })
  void testIsCollidingWithBorderWithWorldborderBoxMinXBoxMaxXBoxMinZBoxMaxZ3() {
    // Arrange and Act
    boolean actualIsCollidingWithBorderResult =
        CollisionUtil.isCollidingWithBorder(new WorldBorder(), -2.9999994E7d, 10.0d, 10.0d, 10.0d);

    // Assert
    assertTrue(actualIsCollidingWithBorderResult);
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double, double, double)}
   * with {@code worldborder}, {@code boxMinX}, {@code boxMaxX}, {@code boxMinZ}, {@code boxMaxZ}.
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, double, double, double, double) with 'worldborder', 'boxMinX', 'boxMaxX', 'boxMinZ', 'boxMaxZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isCollidingWithBorder(WorldBorder, double, double, double, double)"
  })
  void testIsCollidingWithBorderWithWorldborderBoxMinXBoxMaxXBoxMinZBoxMaxZ4() {
    // Arrange and Act
    boolean actualIsCollidingWithBorderResult =
        CollisionUtil.isCollidingWithBorder(new WorldBorder(), 10.0d, 10.0d, -2.9999994E7d, 10.0d);

    // Assert
    assertTrue(actualIsCollidingWithBorderResult);
  }

  /**
   * Test {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double, double, double)}
   * with {@code worldborder}, {@code boxMinX}, {@code boxMaxX}, {@code boxMinZ}, {@code boxMaxZ}.
   *
   * <p>Method under test: {@link CollisionUtil#isCollidingWithBorder(WorldBorder, double, double,
   * double, double)}
   */
  @Test
  @DisplayName(
      "Test isCollidingWithBorder(WorldBorder, double, double, double, double) with 'worldborder', 'boxMinX', 'boxMaxX', 'boxMinZ', 'boxMaxZ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollisionUtil.isCollidingWithBorder(WorldBorder, double, double, double, double)"
  })
  void testIsCollidingWithBorderWithWorldborderBoxMinXBoxMaxXBoxMinZBoxMaxZ5() {
    // Arrange
    WorldBorder worldborder = new WorldBorder();
    worldborder.setSize(CollisionUtil.COLLISION_EPSILON);

    // Act
    boolean actualIsCollidingWithBorderResult =
        CollisionUtil.isCollidingWithBorder(
            worldborder, 10.0d, CollisionUtil.COLLISION_EPSILON, 10.0d, 10.0d);

    // Assert
    assertTrue(actualIsCollidingWithBorderResult);
  }
}
