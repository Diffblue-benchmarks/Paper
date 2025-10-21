package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExpBottleEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return HitBlockFace is {@code NORTH}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpBottleEvent#ExpBottleEvent(ThrownExpBottle, Entity, Block, BlockFace, int)}
   *   <li>{@link ExpBottleEvent#setExperience(int)}
   *   <li>{@link ExpBottleEvent#setShowEffect(boolean)}
   *   <li>{@link ExpBottleEvent#getHandlerList()}
   *   <li>{@link ExpBottleEvent#getExperience()}
   *   <li>{@link ExpBottleEvent#getHandlers()}
   *   <li>{@link ExpBottleEvent#getShowEffect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return HitBlockFace is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpBottleEvent.<init>(ThrownExpBottle, int)",
    "void ExpBottleEvent.<init>(ThrownExpBottle, Entity, Block, BlockFace, int)",
    "int ExpBottleEvent.getExperience()",
    "HandlerList ExpBottleEvent.getHandlerList()",
    "HandlerList ExpBottleEvent.getHandlers()",
    "boolean ExpBottleEvent.getShowEffect()",
    "void ExpBottleEvent.setExperience(int)",
    "void ExpBottleEvent.setShowEffect(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnHitBlockFaceIsNorth() {
    // Arrange
    ThrownExpBottle bottle = mock(ThrownExpBottle.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);

    // Act
    ExpBottleEvent actualExpBottleEvent =
        new ExpBottleEvent(bottle, hitEntity, hitBlock, BlockFace.NORTH, 1);
    actualExpBottleEvent.setExperience(1);
    actualExpBottleEvent.setShowEffect(true);
    HandlerList actualHandlerList = actualExpBottleEvent.getHandlerList();
    int actualExperience = actualExpBottleEvent.getExperience();
    HandlerList actualHandlers = actualExpBottleEvent.getHandlers();
    boolean actualShowEffect = actualExpBottleEvent.getShowEffect();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualExperience);
    assertEquals(BlockFace.NORTH, actualExpBottleEvent.getHitBlockFace());
    assertFalse(actualExpBottleEvent.isAsynchronous());
    assertFalse(actualExpBottleEvent.isCancelled());
    assertTrue(actualShowEffect);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitBlock, actualExpBottleEvent.getHitBlock());
    assertSame(hitEntity, actualExpBottleEvent.getHitEntity());
    assertSame(bottle, actualExpBottleEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ThrownExpBottle}.
   *   <li>Then return HitBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpBottleEvent#ExpBottleEvent(ThrownExpBottle, int)}
   *   <li>{@link ExpBottleEvent#setExperience(int)}
   *   <li>{@link ExpBottleEvent#setShowEffect(boolean)}
   *   <li>{@link ExpBottleEvent#getHandlerList()}
   *   <li>{@link ExpBottleEvent#getExperience()}
   *   <li>{@link ExpBottleEvent#getHandlers()}
   *   <li>{@link ExpBottleEvent#getShowEffect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ThrownExpBottle; then return HitBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpBottleEvent.<init>(ThrownExpBottle, int)",
    "void ExpBottleEvent.<init>(ThrownExpBottle, Entity, Block, BlockFace, int)",
    "int ExpBottleEvent.getExperience()",
    "HandlerList ExpBottleEvent.getHandlerList()",
    "HandlerList ExpBottleEvent.getHandlers()",
    "boolean ExpBottleEvent.getShowEffect()",
    "void ExpBottleEvent.setExperience(int)",
    "void ExpBottleEvent.setShowEffect(boolean)"
  })
  void testGettersAndSetters_whenThrownExpBottle_thenReturnHitBlockIsNull() {
    // Arrange
    ThrownExpBottle bottle = mock(ThrownExpBottle.class);

    // Act
    ExpBottleEvent actualExpBottleEvent = new ExpBottleEvent(bottle, 1);
    actualExpBottleEvent.setExperience(1);
    actualExpBottleEvent.setShowEffect(true);
    HandlerList actualHandlerList = actualExpBottleEvent.getHandlerList();
    int actualExperience = actualExpBottleEvent.getExperience();
    HandlerList actualHandlers = actualExpBottleEvent.getHandlers();
    boolean actualShowEffect = actualExpBottleEvent.getShowEffect();

    // Assert
    assertNull(actualExpBottleEvent.getHitBlock());
    assertNull(actualExpBottleEvent.getHitBlockFace());
    assertNull(actualExpBottleEvent.getHitEntity());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualExperience);
    assertFalse(actualExpBottleEvent.isAsynchronous());
    assertFalse(actualExpBottleEvent.isCancelled());
    assertTrue(actualShowEffect);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(bottle, actualExpBottleEvent.getEntity());
  }

  /**
   * Test {@link ExpBottleEvent#getEntity()}.
   *
   * <p>Method under test: {@link ExpBottleEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThrownExpBottle ExpBottleEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ExpBottleEvent expBottleEvent = new ExpBottleEvent(mock(ThrownExpBottle.class), 1);

    // Act
    ThrownExpBottle actualEntity = expBottleEvent.getEntity();

    // Assert
    assertSame(expBottleEvent.entity, actualEntity);
  }
}
