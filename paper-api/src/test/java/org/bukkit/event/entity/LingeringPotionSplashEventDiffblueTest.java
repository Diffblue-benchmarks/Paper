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
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LingeringPotionSplashEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link AreaEffectCloud}.
   *   <li>Then return HitBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LingeringPotionSplashEvent#LingeringPotionSplashEvent(ThrownPotion,
   *       AreaEffectCloud)}
   *   <li>{@link LingeringPotionSplashEvent#allowsEmptyCreation(boolean)}
   *   <li>{@link LingeringPotionSplashEvent#setCancelled(boolean)}
   *   <li>{@link LingeringPotionSplashEvent#getHandlerList()}
   *   <li>{@link LingeringPotionSplashEvent#getAreaEffectCloud()}
   *   <li>{@link LingeringPotionSplashEvent#getHandlers()}
   *   <li>{@link LingeringPotionSplashEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when AreaEffectCloud; then return HitBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LingeringPotionSplashEvent.<init>(ThrownPotion, AreaEffectCloud)",
    "void LingeringPotionSplashEvent.<init>(ThrownPotion, Entity, Block, BlockFace, AreaEffectCloud)",
    "void LingeringPotionSplashEvent.allowsEmptyCreation(boolean)",
    "AreaEffectCloud LingeringPotionSplashEvent.getAreaEffectCloud()",
    "HandlerList LingeringPotionSplashEvent.getHandlerList()",
    "HandlerList LingeringPotionSplashEvent.getHandlers()",
    "boolean LingeringPotionSplashEvent.isCancelled()",
    "void LingeringPotionSplashEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenAreaEffectCloud_thenReturnHitBlockIsNull() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    AreaEffectCloud effectCloud = mock(AreaEffectCloud.class);

    // Act
    LingeringPotionSplashEvent actualLingeringPotionSplashEvent =
        new LingeringPotionSplashEvent(potion, effectCloud);
    actualLingeringPotionSplashEvent.allowsEmptyCreation(true);
    actualLingeringPotionSplashEvent.setCancelled(true);
    HandlerList actualHandlerList = actualLingeringPotionSplashEvent.getHandlerList();
    AreaEffectCloud actualAreaEffectCloud = actualLingeringPotionSplashEvent.getAreaEffectCloud();
    HandlerList actualHandlers = actualLingeringPotionSplashEvent.getHandlers();
    boolean actualIsCancelledResult = actualLingeringPotionSplashEvent.isCancelled();

    // Assert
    assertNull(actualLingeringPotionSplashEvent.getHitBlock());
    assertNull(actualLingeringPotionSplashEvent.getHitBlockFace());
    assertNull(actualLingeringPotionSplashEvent.getHitEntity());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualLingeringPotionSplashEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(effectCloud, actualAreaEffectCloud);
    assertSame(potion, actualLingeringPotionSplashEvent.getEntity());
  }

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
   *   <li>{@link LingeringPotionSplashEvent#LingeringPotionSplashEvent(ThrownPotion, Entity, Block,
   *       BlockFace, AreaEffectCloud)}
   *   <li>{@link LingeringPotionSplashEvent#allowsEmptyCreation(boolean)}
   *   <li>{@link LingeringPotionSplashEvent#setCancelled(boolean)}
   *   <li>{@link LingeringPotionSplashEvent#getHandlerList()}
   *   <li>{@link LingeringPotionSplashEvent#getAreaEffectCloud()}
   *   <li>{@link LingeringPotionSplashEvent#getHandlers()}
   *   <li>{@link LingeringPotionSplashEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return HitBlockFace is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LingeringPotionSplashEvent.<init>(ThrownPotion, AreaEffectCloud)",
    "void LingeringPotionSplashEvent.<init>(ThrownPotion, Entity, Block, BlockFace, AreaEffectCloud)",
    "void LingeringPotionSplashEvent.allowsEmptyCreation(boolean)",
    "AreaEffectCloud LingeringPotionSplashEvent.getAreaEffectCloud()",
    "HandlerList LingeringPotionSplashEvent.getHandlerList()",
    "HandlerList LingeringPotionSplashEvent.getHandlers()",
    "boolean LingeringPotionSplashEvent.isCancelled()",
    "void LingeringPotionSplashEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnHitBlockFaceIsNorth() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    AreaEffectCloud effectCloud = mock(AreaEffectCloud.class);

    // Act
    LingeringPotionSplashEvent actualLingeringPotionSplashEvent =
        new LingeringPotionSplashEvent(potion, hitEntity, hitBlock, BlockFace.NORTH, effectCloud);
    actualLingeringPotionSplashEvent.allowsEmptyCreation(true);
    actualLingeringPotionSplashEvent.setCancelled(true);
    HandlerList actualHandlerList = actualLingeringPotionSplashEvent.getHandlerList();
    AreaEffectCloud actualAreaEffectCloud = actualLingeringPotionSplashEvent.getAreaEffectCloud();
    HandlerList actualHandlers = actualLingeringPotionSplashEvent.getHandlers();
    boolean actualIsCancelledResult = actualLingeringPotionSplashEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualLingeringPotionSplashEvent.getHitBlockFace());
    assertFalse(actualLingeringPotionSplashEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitBlock, actualLingeringPotionSplashEvent.getHitBlock());
    assertSame(effectCloud, actualAreaEffectCloud);
    assertSame(hitEntity, actualLingeringPotionSplashEvent.getHitEntity());
    assertSame(potion, actualLingeringPotionSplashEvent.getEntity());
  }

  /**
   * Test {@link LingeringPotionSplashEvent#getEntity()}.
   *
   * <p>Method under test: {@link LingeringPotionSplashEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThrownPotion LingeringPotionSplashEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    LingeringPotionSplashEvent lingeringPotionSplashEvent =
        new LingeringPotionSplashEvent(mock(ThrownPotion.class), mock(AreaEffectCloud.class));

    // Act
    ThrownPotion actualEntity = lingeringPotionSplashEvent.getEntity();

    // Assert
    assertSame(lingeringPotionSplashEvent.entity, actualEntity);
  }

  /**
   * Test {@link LingeringPotionSplashEvent#allowsEmptyCreation()}.
   *
   * <p>Method under test: {@link LingeringPotionSplashEvent#allowsEmptyCreation()}
   */
  @Test
  @DisplayName("Test allowsEmptyCreation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LingeringPotionSplashEvent.allowsEmptyCreation()"})
  void testAllowsEmptyCreation() {
    // Arrange
    LingeringPotionSplashEvent lingeringPotionSplashEvent =
        new LingeringPotionSplashEvent(mock(ThrownPotion.class), mock(AreaEffectCloud.class));

    // Act and Assert
    assertFalse(lingeringPotionSplashEvent.allowsEmptyCreation());
  }
}
