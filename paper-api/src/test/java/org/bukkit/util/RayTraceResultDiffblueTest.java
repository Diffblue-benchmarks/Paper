package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RayTraceResultDiffblueTest {
  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector)}.
   *
   * <ul>
   *   <li>Then HitPosition return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector)}
   */
  @Test
  @DisplayName("Test new RayTraceResult(Vector); then HitPosition return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector)"})
  void testNewRayTraceResult_thenHitPositionReturnBlockVector() {
    // Arrange
    BlockVector hitPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act and Assert
    Vector hitPosition2 = new RayTraceResult(hitPosition).getHitPosition();
    assertTrue(hitPosition2 instanceof BlockVector);
    assertEquals(hitPosition, hitPosition2);
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, Block, BlockFace)}.
   *
   * <ul>
   *   <li>Then HitPosition return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, Block, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new RayTraceResult(Vector, Block, BlockFace); then HitPosition return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, Block, BlockFace)"})
  void testNewRayTraceResult_thenHitPositionReturnBlockVector2() {
    // Arrange
    BlockVector hitPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    RayTraceResult actualRayTraceResult =
        new RayTraceResult(hitPosition, mock(Block.class), BlockFace.NORTH);

    // Assert
    Vector hitPosition2 = actualRayTraceResult.getHitPosition();
    assertTrue(hitPosition2 instanceof BlockVector);
    assertEquals(hitPosition, hitPosition2);
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, BlockFace)}.
   *
   * <ul>
   *   <li>Then HitPosition return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, BlockFace)}
   */
  @Test
  @DisplayName("Test new RayTraceResult(Vector, BlockFace); then HitPosition return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, BlockFace)"})
  void testNewRayTraceResult_thenHitPositionReturnBlockVector3() {
    // Arrange
    BlockVector hitPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act and Assert
    Vector hitPosition2 = new RayTraceResult(hitPosition, BlockFace.NORTH).getHitPosition();
    assertTrue(hitPosition2 instanceof BlockVector);
    assertEquals(hitPosition, hitPosition2);
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, Entity)}.
   *
   * <ul>
   *   <li>Then HitPosition return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, Entity)}
   */
  @Test
  @DisplayName("Test new RayTraceResult(Vector, Entity); then HitPosition return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, Entity)"})
  void testNewRayTraceResult_thenHitPositionReturnBlockVector4() {
    // Arrange
    BlockVector hitPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    RayTraceResult actualRayTraceResult = new RayTraceResult(hitPosition, mock(Entity.class));

    // Assert
    Vector hitPosition2 = actualRayTraceResult.getHitPosition();
    assertTrue(hitPosition2 instanceof BlockVector);
    assertEquals(hitPosition, hitPosition2);
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, Entity, BlockFace)}.
   *
   * <ul>
   *   <li>Then HitPosition return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, Entity, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new RayTraceResult(Vector, Entity, BlockFace); then HitPosition return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, Entity, BlockFace)"})
  void testNewRayTraceResult_thenHitPositionReturnBlockVector5() {
    // Arrange
    BlockVector hitPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    RayTraceResult actualRayTraceResult =
        new RayTraceResult(hitPosition, mock(Entity.class), BlockFace.NORTH);

    // Assert
    Vector hitPosition2 = actualRayTraceResult.getHitPosition();
    assertTrue(hitPosition2 instanceof BlockVector);
    assertEquals(hitPosition, hitPosition2);
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return HitPosition is Random.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector)}
   */
  @Test
  @DisplayName("Test new RayTraceResult(Vector); when Random; then return HitPosition is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector)"})
  void testNewRayTraceResult_whenRandom_thenReturnHitPositionIsRandom() {
    // Arrange
    Vector hitPosition = Vector.getRandom();

    // Act and Assert
    assertEquals(hitPosition, new RayTraceResult(hitPosition).getHitPosition());
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, Block, BlockFace)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return HitPosition is Random.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, Block, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new RayTraceResult(Vector, Block, BlockFace); when Random; then return HitPosition is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, Block, BlockFace)"})
  void testNewRayTraceResult_whenRandom_thenReturnHitPositionIsRandom2() {
    // Arrange
    Vector hitPosition = Vector.getRandom();

    // Act
    RayTraceResult actualRayTraceResult =
        new RayTraceResult(hitPosition, mock(Block.class), BlockFace.NORTH);

    // Assert
    assertEquals(hitPosition, actualRayTraceResult.getHitPosition());
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, BlockFace)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return HitPosition is Random.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new RayTraceResult(Vector, BlockFace); when Random; then return HitPosition is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, BlockFace)"})
  void testNewRayTraceResult_whenRandom_thenReturnHitPositionIsRandom3() {
    // Arrange
    Vector hitPosition = Vector.getRandom();

    // Act and Assert
    assertEquals(hitPosition, new RayTraceResult(hitPosition, BlockFace.NORTH).getHitPosition());
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, Entity)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return HitPosition is Random.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, Entity)}
   */
  @Test
  @DisplayName(
      "Test new RayTraceResult(Vector, Entity); when Random; then return HitPosition is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, Entity)"})
  void testNewRayTraceResult_whenRandom_thenReturnHitPositionIsRandom4() {
    // Arrange
    Vector hitPosition = Vector.getRandom();

    // Act
    RayTraceResult actualRayTraceResult = new RayTraceResult(hitPosition, mock(Entity.class));

    // Assert
    assertEquals(hitPosition, actualRayTraceResult.getHitPosition());
  }

  /**
   * Test {@link RayTraceResult#RayTraceResult(Vector, Entity, BlockFace)}.
   *
   * <ul>
   *   <li>When Random.
   *   <li>Then return HitPosition is Random.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#RayTraceResult(Vector, Entity, BlockFace)}
   */
  @Test
  @DisplayName(
      "Test new RayTraceResult(Vector, Entity, BlockFace); when Random; then return HitPosition is Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RayTraceResult.<init>(Vector, Entity, BlockFace)"})
  void testNewRayTraceResult_whenRandom_thenReturnHitPositionIsRandom5() {
    // Arrange
    Vector hitPosition = Vector.getRandom();

    // Act
    RayTraceResult actualRayTraceResult =
        new RayTraceResult(hitPosition, mock(Entity.class), BlockFace.NORTH);

    // Assert
    assertEquals(hitPosition, actualRayTraceResult.getHitPosition());
  }

  /**
   * Test {@link RayTraceResult#getHitPosition()}.
   *
   * <ul>
   *   <li>Given {@link RayTraceResult#RayTraceResult(Vector)} with hitPosition is Random.
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#getHitPosition()}
   */
  @Test
  @DisplayName(
      "Test getHitPosition(); given RayTraceResult(Vector) with hitPosition is Random; then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector RayTraceResult.getHitPosition()"})
  void testGetHitPosition_givenRayTraceResultWithHitPositionIsRandom_thenReturnRandom() {
    // Arrange
    Vector hitPosition = Vector.getRandom();

    // Act and Assert
    assertEquals(hitPosition, new RayTraceResult(hitPosition).getHitPosition());
  }

  /**
   * Test {@link RayTraceResult#getHitPosition()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#getHitPosition()}
   */
  @Test
  @DisplayName("Test getHitPosition(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector RayTraceResult.getHitPosition()"})
  void testGetHitPosition_thenReturnBlockVector() {
    // Arrange
    BlockVector hitPosition = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    Vector actualHitPosition = new RayTraceResult(hitPosition).getHitPosition();

    // Assert
    assertTrue(actualHitPosition instanceof BlockVector);
    assertEquals(hitPosition, actualHitPosition);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RayTraceResult#toString()}
   *   <li>{@link RayTraceResult#getHitBlock()}
   *   <li>{@link RayTraceResult#getHitBlockFace()}
   *   <li>{@link RayTraceResult#getHitEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Block RayTraceResult.getHitBlock()",
    "BlockFace RayTraceResult.getHitBlockFace()",
    "Entity RayTraceResult.getHitEntity()",
    "java.lang.String RayTraceResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RayTraceResult rayTraceResult = new RayTraceResult(Vector.getRandom());

    // Act
    rayTraceResult.toString();
    Block actualHitBlock = rayTraceResult.getHitBlock();
    BlockFace actualHitBlockFace = rayTraceResult.getHitBlockFace();

    // Assert
    assertNull(actualHitBlock);
    assertNull(actualHitBlockFace);
    assertNull(rayTraceResult.getHitEntity());
  }

  /**
   * Test {@link RayTraceResult#equals(Object)}, and {@link RayTraceResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RayTraceResult#equals(Object)}
   *   <li>{@link RayTraceResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RayTraceResult.equals(Object)", "int RayTraceResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RayTraceResult rayTraceResult = new RayTraceResult(Vector.getRandom());

    // Act and Assert
    assertEquals(rayTraceResult, rayTraceResult);
    int expectedHashCodeResult = rayTraceResult.hashCode();
    assertEquals(expectedHashCodeResult, rayTraceResult.hashCode());
  }

  /**
   * Test {@link RayTraceResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RayTraceResult.equals(Object)", "int RayTraceResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RayTraceResult rayTraceResult = new RayTraceResult(Vector.getRandom());

    // Act and Assert
    assertNotEquals(rayTraceResult, new RayTraceResult(Vector.getRandom()));
  }

  /**
   * Test {@link RayTraceResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RayTraceResult.equals(Object)", "int RayTraceResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RayTraceResult(Vector.getRandom()), null);
  }

  /**
   * Test {@link RayTraceResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RayTraceResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RayTraceResult.equals(Object)", "int RayTraceResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RayTraceResult(Vector.getRandom()), "Different type to RayTraceResult");
  }
}
