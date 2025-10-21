package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PotionSplashEventDiffblueTest {
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
   *   <li>{@link PotionSplashEvent#PotionSplashEvent(ThrownPotion, Entity, Block, BlockFace, Map)}
   *   <li>{@link PotionSplashEvent#setCancelled(boolean)}
   *   <li>{@link PotionSplashEvent#getHandlerList()}
   *   <li>{@link PotionSplashEvent#getHandlers()}
   *   <li>{@link PotionSplashEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return HitBlockFace is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PotionSplashEvent.<init>(ThrownPotion, Map)",
    "void PotionSplashEvent.<init>(ThrownPotion, Entity, Block, BlockFace, Map)",
    "HandlerList PotionSplashEvent.getHandlerList()",
    "HandlerList PotionSplashEvent.getHandlers()",
    "boolean PotionSplashEvent.isCancelled()",
    "void PotionSplashEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnHitBlockFaceIsNorth() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);

    // Act
    PotionSplashEvent actualPotionSplashEvent =
        new PotionSplashEvent(potion, hitEntity, hitBlock, BlockFace.NORTH, new HashMap<>());
    actualPotionSplashEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPotionSplashEvent.getHandlerList();
    HandlerList actualHandlers = actualPotionSplashEvent.getHandlers();
    boolean actualIsCancelledResult = actualPotionSplashEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualPotionSplashEvent.getHitBlockFace());
    assertFalse(actualPotionSplashEvent.isAsynchronous());
    assertTrue(actualPotionSplashEvent.affectedEntities.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitBlock, actualPotionSplashEvent.getHitBlock());
    assertSame(hitEntity, actualPotionSplashEvent.getHitEntity());
    assertSame(potion, actualPotionSplashEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ThrownPotion}.
   *   <li>Then return HitBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PotionSplashEvent#PotionSplashEvent(ThrownPotion, Map)}
   *   <li>{@link PotionSplashEvent#setCancelled(boolean)}
   *   <li>{@link PotionSplashEvent#getHandlerList()}
   *   <li>{@link PotionSplashEvent#getHandlers()}
   *   <li>{@link PotionSplashEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ThrownPotion; then return HitBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PotionSplashEvent.<init>(ThrownPotion, Map)",
    "void PotionSplashEvent.<init>(ThrownPotion, Entity, Block, BlockFace, Map)",
    "HandlerList PotionSplashEvent.getHandlerList()",
    "HandlerList PotionSplashEvent.getHandlers()",
    "boolean PotionSplashEvent.isCancelled()",
    "void PotionSplashEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenThrownPotion_thenReturnHitBlockIsNull() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);

    // Act
    PotionSplashEvent actualPotionSplashEvent = new PotionSplashEvent(potion, new HashMap<>());
    actualPotionSplashEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPotionSplashEvent.getHandlerList();
    HandlerList actualHandlers = actualPotionSplashEvent.getHandlers();
    boolean actualIsCancelledResult = actualPotionSplashEvent.isCancelled();

    // Assert
    assertNull(actualPotionSplashEvent.getHitBlock());
    assertNull(actualPotionSplashEvent.getHitBlockFace());
    assertNull(actualPotionSplashEvent.getHitEntity());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPotionSplashEvent.isAsynchronous());
    assertTrue(actualPotionSplashEvent.affectedEntities.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(potion, actualPotionSplashEvent.getEntity());
  }

  /**
   * Test {@link PotionSplashEvent#getEntity()}.
   *
   * <p>Method under test: {@link PotionSplashEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThrownPotion PotionSplashEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    PotionSplashEvent potionSplashEvent = new PotionSplashEvent(potion, new HashMap<>());

    // Act
    ThrownPotion actualEntity = potionSplashEvent.getEntity();

    // Assert
    assertSame(potionSplashEvent.entity, actualEntity);
  }

  /**
   * Test {@link PotionSplashEvent#getAffectedEntities()}.
   *
   * <p>Method under test: {@link PotionSplashEvent#getAffectedEntities()}
   */
  @Test
  @DisplayName("Test getAffectedEntities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PotionSplashEvent.getAffectedEntities()"})
  void testGetAffectedEntities() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    PotionSplashEvent potionSplashEvent = new PotionSplashEvent(potion, new HashMap<>());

    // Act
    Collection<LivingEntity> actualAffectedEntities = potionSplashEvent.getAffectedEntities();

    // Assert
    assertTrue(actualAffectedEntities instanceof List);
    assertTrue(actualAffectedEntities.isEmpty());
  }

  /**
   * Test {@link PotionSplashEvent#getIntensity(LivingEntity)}.
   *
   * <p>Method under test: {@link PotionSplashEvent#getIntensity(LivingEntity)}
   */
  @Test
  @DisplayName("Test getIntensity(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PotionSplashEvent.getIntensity(LivingEntity)"})
  void testGetIntensity() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    PotionSplashEvent potionSplashEvent = new PotionSplashEvent(potion, new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, potionSplashEvent.getIntensity(mock(LivingEntity.class)));
  }

  /**
   * Test {@link PotionSplashEvent#setIntensity(LivingEntity, double)}.
   *
   * <p>Method under test: {@link PotionSplashEvent#setIntensity(LivingEntity, double)}
   */
  @Test
  @DisplayName("Test setIntensity(LivingEntity, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PotionSplashEvent.setIntensity(LivingEntity, double)"})
  void testSetIntensity() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    PotionSplashEvent potionSplashEvent = new PotionSplashEvent(potion, new HashMap<>());
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    potionSplashEvent.setIntensity(entity, 10.0d);

    // Assert
    Collection<LivingEntity> affectedEntities = potionSplashEvent.getAffectedEntities();
    assertEquals(1, affectedEntities.size());
    assertTrue(affectedEntities instanceof List);
    assertEquals(1, potionSplashEvent.affectedEntities.size());
    assertSame(entity, ((List<LivingEntity>) affectedEntities).get(0));
  }

  /**
   * Test {@link PotionSplashEvent#setIntensity(LivingEntity, double)}.
   *
   * <p>Method under test: {@link PotionSplashEvent#setIntensity(LivingEntity, double)}
   */
  @Test
  @DisplayName("Test setIntensity(LivingEntity, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PotionSplashEvent.setIntensity(LivingEntity, double)"})
  void testSetIntensity2() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    PotionSplashEvent potionSplashEvent = new PotionSplashEvent(potion, new HashMap<>());

    // Act
    potionSplashEvent.setIntensity(mock(LivingEntity.class), 0.0d);

    // Assert that nothing has changed
    Collection<LivingEntity> affectedEntities = potionSplashEvent.getAffectedEntities();
    assertTrue(affectedEntities instanceof List);
    assertTrue(affectedEntities.isEmpty());
    assertTrue(potionSplashEvent.affectedEntities.isEmpty());
  }
}
