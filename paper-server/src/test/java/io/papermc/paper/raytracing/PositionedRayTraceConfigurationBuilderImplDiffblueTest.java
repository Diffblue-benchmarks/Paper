package io.papermc.paper.raytracing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import org.bukkit.FluidCollisionMode;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PositionedRayTraceConfigurationBuilderImplDiffblueTest {
  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#direction(Vector)}.
   *
   * <p>Method under test: {@link PositionedRayTraceConfigurationBuilderImpl#direction(Vector)}
   */
  @Test
  @DisplayName("Test direction(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.direction(Vector)"
  })
  void testDirection() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();
    Vector direction = Vector.getRandom();

    // Act
    PositionedRayTraceConfigurationBuilder actualDirectionResult =
        positionedRayTraceConfigurationBuilderImpl.direction(direction);

    // Assert
    assertTrue(actualDirectionResult instanceof PositionedRayTraceConfigurationBuilderImpl);
    Vector vector = positionedRayTraceConfigurationBuilderImpl.direction;
    assertFalse(vector.toBlockVector().isZero());
    Vector vector2 = ((PositionedRayTraceConfigurationBuilderImpl) actualDirectionResult).direction;
    BlockVector toBlockVectorResult = vector2.toBlockVector();
    assertFalse(toBlockVectorResult.isZero());
    assertFalse(vector.isZero());
    assertFalse(vector2.isZero());
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector3i toVector3iResult = vector2.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    assertEquals(
        ((PositionedRayTraceConfigurationBuilderImpl) actualDirectionResult).direction, direction);
    Vector3d toVector3dResult = vector2.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3f toVector3fResult = vector2.toVector3f();
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
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#direction(Vector)}.
   *
   * <ul>
   *   <li>Then {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor) {@link
   *       PositionedRayTraceConfigurationBuilderImpl#direction} {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link PositionedRayTraceConfigurationBuilderImpl#direction(Vector)}
   */
  @Test
  @DisplayName(
      "Test direction(Vector); then PositionedRayTraceConfigurationBuilderImpl (default constructor) direction BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.direction(Vector)"
  })
  void testDirection_thenPositionedRayTraceConfigurationBuilderImplDirectionBlockVector() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();
    BlockVector direction = new BlockVector();

    // Act
    PositionedRayTraceConfigurationBuilder actualDirectionResult =
        positionedRayTraceConfigurationBuilderImpl.direction(direction);

    // Assert
    assertTrue(actualDirectionResult instanceof PositionedRayTraceConfigurationBuilderImpl);
    Vector vector = positionedRayTraceConfigurationBuilderImpl.direction;
    assertTrue(vector instanceof BlockVector);
    Vector vector2 = ((PositionedRayTraceConfigurationBuilderImpl) actualDirectionResult).direction;
    assertTrue(vector2 instanceof BlockVector);
    assertEquals(0.0d, vector.getX());
    assertEquals(0.0d, vector2.getX());
    assertEquals(0.0d, vector.getY());
    assertEquals(0.0d, vector2.getY());
    assertEquals(0.0d, vector.getZ());
    assertEquals(0.0d, vector2.getZ());
    assertEquals(0.0d, vector.length());
    assertEquals(0.0d, vector2.length());
    assertTrue(vector.isZero());
    assertTrue(vector2.isZero());
    assertEquals(
        ((PositionedRayTraceConfigurationBuilderImpl) actualDirectionResult).direction, direction);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#maxDistance(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PositionedRayTraceConfigurationBuilderImpl#maxDistance(double)}
   */
  @Test
  @DisplayName(
      "Test maxDistance(double); when ten; then return PositionedRayTraceConfigurationBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.maxDistance(double)"
  })
  void testMaxDistance_whenTen_thenReturnPositionedRayTraceConfigurationBuilderImpl() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualMaxDistanceResult =
        positionedRayTraceConfigurationBuilderImpl.maxDistance(10.0d);

    // Assert
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualMaxDistanceResult);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#fluidCollisionMode(FluidCollisionMode)}.
   *
   * <ul>
   *   <li>Then return {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PositionedRayTraceConfigurationBuilderImpl#fluidCollisionMode(FluidCollisionMode)}
   */
  @Test
  @DisplayName(
      "Test fluidCollisionMode(FluidCollisionMode); then return PositionedRayTraceConfigurationBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.fluidCollisionMode(FluidCollisionMode)"
  })
  void testFluidCollisionMode_thenReturnPositionedRayTraceConfigurationBuilderImpl() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualFluidCollisionModeResult =
        positionedRayTraceConfigurationBuilderImpl.fluidCollisionMode(FluidCollisionMode.NEVER);

    // Assert
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualFluidCollisionModeResult);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#ignorePassableBlocks(boolean)}.
   *
   * <p>Method under test: {@link
   * PositionedRayTraceConfigurationBuilderImpl#ignorePassableBlocks(boolean)}
   */
  @Test
  @DisplayName("Test ignorePassableBlocks(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.ignorePassableBlocks(boolean)"
  })
  void testIgnorePassableBlocks() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualIgnorePassableBlocksResult =
        positionedRayTraceConfigurationBuilderImpl.ignorePassableBlocks(true);

    // Assert
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualIgnorePassableBlocksResult);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#raySize(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor) {@link
   *       PositionedRayTraceConfigurationBuilderImpl#raySize} is ten.
   * </ul>
   *
   * <p>Method under test: {@link PositionedRayTraceConfigurationBuilderImpl#raySize(double)}
   */
  @Test
  @DisplayName(
      "Test raySize(double); when ten; then PositionedRayTraceConfigurationBuilderImpl (default constructor) raySize is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.raySize(double)"
  })
  void testRaySize_whenTen_thenPositionedRayTraceConfigurationBuilderImplRaySizeIsTen() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualRaySizeResult =
        positionedRayTraceConfigurationBuilderImpl.raySize(10.0d);

    // Assert
    assertEquals(10.0d, positionedRayTraceConfigurationBuilderImpl.raySize);
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualRaySizeResult);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#entityFilter(Predicate)}.
   *
   * <ul>
   *   <li>Then return {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PositionedRayTraceConfigurationBuilderImpl#entityFilter(Predicate)}
   */
  @Test
  @DisplayName(
      "Test entityFilter(Predicate); then return PositionedRayTraceConfigurationBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.entityFilter(Predicate)"
  })
  void testEntityFilter_thenReturnPositionedRayTraceConfigurationBuilderImpl() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualEntityFilterResult =
        positionedRayTraceConfigurationBuilderImpl.entityFilter(mock(Predicate.class));

    // Assert
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualEntityFilterResult);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#blockFilter(Predicate)}.
   *
   * <ul>
   *   <li>Then return {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PositionedRayTraceConfigurationBuilderImpl#blockFilter(Predicate)}
   */
  @Test
  @DisplayName(
      "Test blockFilter(Predicate); then return PositionedRayTraceConfigurationBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.blockFilter(Predicate)"
  })
  void testBlockFilter_thenReturnPositionedRayTraceConfigurationBuilderImpl() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualBlockFilterResult =
        positionedRayTraceConfigurationBuilderImpl.blockFilter(mock(Predicate.class));

    // Assert
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualBlockFilterResult);
  }

  /**
   * Test {@link PositionedRayTraceConfigurationBuilderImpl#targets(RayTraceTarget,
   * RayTraceTarget[])}.
   *
   * <ul>
   *   <li>Then {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor) {@link
   *       PositionedRayTraceConfigurationBuilderImpl#targets} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PositionedRayTraceConfigurationBuilderImpl#targets(RayTraceTarget,
   * RayTraceTarget[])}
   */
  @Test
  @DisplayName(
      "Test targets(RayTraceTarget, RayTraceTarget[]); then PositionedRayTraceConfigurationBuilderImpl (default constructor) targets size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PositionedRayTraceConfigurationBuilder PositionedRayTraceConfigurationBuilderImpl.targets(RayTraceTarget, RayTraceTarget[])"
  })
  void testTargets_thenPositionedRayTraceConfigurationBuilderImplTargetsSizeIsOne() {
    // Arrange
    PositionedRayTraceConfigurationBuilderImpl positionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Act
    PositionedRayTraceConfigurationBuilder actualTargetsResult =
        positionedRayTraceConfigurationBuilderImpl.targets(
            RayTraceTarget.ENTITY, RayTraceTarget.ENTITY);

    // Assert
    assertEquals(1, positionedRayTraceConfigurationBuilderImpl.targets.size());
    assertSame(positionedRayTraceConfigurationBuilderImpl, actualTargetsResult);
  }

  /**
   * Test new {@link PositionedRayTraceConfigurationBuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PositionedRayTraceConfigurationBuilderImpl}
   */
  @Test
  @DisplayName("Test new PositionedRayTraceConfigurationBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionedRayTraceConfigurationBuilderImpl.<init>()"})
  void testNewPositionedRayTraceConfigurationBuilderImpl() {
    // Arrange and Act
    PositionedRayTraceConfigurationBuilderImpl actualPositionedRayTraceConfigurationBuilderImpl =
        new PositionedRayTraceConfigurationBuilderImpl();

    // Assert
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.blockFilter);
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.entityFilter);
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.start);
    assertNull(actualPositionedRayTraceConfigurationBuilderImpl.direction);
    assertEquals(0.0d, actualPositionedRayTraceConfigurationBuilderImpl.raySize);
    assertEquals(
        FluidCollisionMode.NEVER,
        actualPositionedRayTraceConfigurationBuilderImpl.fluidCollisionMode);
    OptionalDouble optionalDouble = actualPositionedRayTraceConfigurationBuilderImpl.maxDistance;
    assertFalse(optionalDouble.isPresent());
    assertFalse(actualPositionedRayTraceConfigurationBuilderImpl.ignorePassableBlocks);
    assertTrue(actualPositionedRayTraceConfigurationBuilderImpl.targets.isEmpty());
    assertTrue(optionalDouble.isEmpty());
  }
}
