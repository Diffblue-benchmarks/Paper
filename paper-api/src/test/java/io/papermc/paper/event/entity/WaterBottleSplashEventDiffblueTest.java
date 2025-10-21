package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WaterBottleSplashEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WaterBottleSplashEvent#WaterBottleSplashEvent(ThrownPotion, Entity, Block,
   *       BlockFace, Map, Set, Set)}
   *   <li>{@link WaterBottleSplashEvent#getToExtinguish()}
   *   <li>{@link WaterBottleSplashEvent#getToRehydrate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WaterBottleSplashEvent.<init>(ThrownPotion, Entity, Block, BlockFace, Map, Set, Set)",
    "Collection WaterBottleSplashEvent.getToExtinguish()",
    "Collection WaterBottleSplashEvent.getToRehydrate()"
  })
  void testGettersAndSetters() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();
    HashSet<LivingEntity> extinguish = new HashSet<>();

    // Act
    WaterBottleSplashEvent actualWaterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion, hitEntity, hitBlock, BlockFace.NORTH, affectedEntities, rehydrate, extinguish);
    Collection<LivingEntity> actualToExtinguish = actualWaterBottleSplashEvent.getToExtinguish();
    Collection<LivingEntity> actualToRehydrate = actualWaterBottleSplashEvent.getToRehydrate();

    // Assert
    assertTrue(actualToExtinguish instanceof Set);
    assertTrue(actualToRehydrate instanceof Set);
    assertEquals(BlockFace.NORTH, actualWaterBottleSplashEvent.getHitBlockFace());
    assertFalse(actualWaterBottleSplashEvent.isAsynchronous());
    assertFalse(actualWaterBottleSplashEvent.isCancelled());
    assertSame(extinguish, actualToExtinguish);
    assertSame(rehydrate, actualToRehydrate);
    assertSame(hitBlock, actualWaterBottleSplashEvent.getHitBlock());
    assertSame(hitEntity, actualWaterBottleSplashEvent.getHitEntity());
    assertSame(potion, actualWaterBottleSplashEvent.getEntity());
  }

  /**
   * Test {@link WaterBottleSplashEvent#getToDamage()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link LivingEntity} is ten.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#getToDamage()}
   */
  @Test
  @DisplayName("Test getToDamage(); given HashMap() LivingEntity is ten; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection WaterBottleSplashEvent.getToDamage()"})
  void testGetToDamage_givenHashMapLivingEntityIsTen_thenReturnSizeIsOne() {
    // Arrange
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    affectedEntities.put(mock(LivingEntity.class), 10.0d);
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());

    // Act
    Collection<LivingEntity> actualToDamage = waterBottleSplashEvent.getToDamage();

    // Assert
    assertTrue(actualToDamage instanceof Set);
    assertEquals(1, actualToDamage.size());
  }

  /**
   * Test {@link WaterBottleSplashEvent#getToDamage()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link LivingEntity} is zero.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#getToDamage()}
   */
  @Test
  @DisplayName("Test getToDamage(); given HashMap() LivingEntity is zero; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection WaterBottleSplashEvent.getToDamage()"})
  void testGetToDamage_givenHashMapLivingEntityIsZero_thenReturnSizeIsOne() {
    // Arrange
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    affectedEntities.put(mock(LivingEntity.class), 0.0d);
    affectedEntities.put(mock(LivingEntity.class), 10.0d);
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());

    // Act
    Collection<LivingEntity> actualToDamage = waterBottleSplashEvent.getToDamage();

    // Assert
    assertTrue(actualToDamage instanceof Set);
    assertEquals(1, actualToDamage.size());
  }

  /**
   * Test {@link WaterBottleSplashEvent#getToDamage()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#getToDamage()}
   */
  @Test
  @DisplayName("Test getToDamage(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection WaterBottleSplashEvent.getToDamage()"})
  void testGetToDamage_thenReturnEmpty() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());

    // Act
    Collection<LivingEntity> actualToDamage = waterBottleSplashEvent.getToDamage();

    // Assert
    assertTrue(actualToDamage instanceof Set);
    assertTrue(actualToDamage.isEmpty());
  }

  /**
   * Test {@link WaterBottleSplashEvent#damageAsWaterSensitive(LivingEntity)}.
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#damageAsWaterSensitive(LivingEntity)}
   */
  @Test
  @DisplayName("Test damageAsWaterSensitive(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WaterBottleSplashEvent.damageAsWaterSensitive(LivingEntity)"})
  void testDamageAsWaterSensitive() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    waterBottleSplashEvent.damageAsWaterSensitive(entity);

    // Assert
    Collection<LivingEntity> affectedEntities2 = waterBottleSplashEvent.getAffectedEntities();
    assertEquals(1, affectedEntities2.size());
    assertTrue(affectedEntities2 instanceof List);
    Collection<LivingEntity> toDamage = waterBottleSplashEvent.getToDamage();
    assertEquals(1, toDamage.size());
    assertTrue(toDamage instanceof Set);
    assertSame(entity, ((List<LivingEntity>) affectedEntities2).get(0));
  }

  /**
   * Test {@link WaterBottleSplashEvent#getAffectedEntities()}.
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#getAffectedEntities()}
   */
  @Test
  @DisplayName("Test getAffectedEntities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection WaterBottleSplashEvent.getAffectedEntities()"})
  void testGetAffectedEntities() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());

    // Act
    Collection<LivingEntity> actualAffectedEntities = waterBottleSplashEvent.getAffectedEntities();

    // Assert
    assertTrue(actualAffectedEntities instanceof List);
    assertTrue(actualAffectedEntities.isEmpty());
  }

  /**
   * Test {@link WaterBottleSplashEvent#getIntensity(LivingEntity)}.
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#getIntensity(LivingEntity)}
   */
  @Test
  @DisplayName("Test getIntensity(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double WaterBottleSplashEvent.getIntensity(LivingEntity)"})
  void testGetIntensity() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());

    // Act and Assert
    assertEquals(0.0d, waterBottleSplashEvent.getIntensity(mock(LivingEntity.class)));
  }

  /**
   * Test {@link WaterBottleSplashEvent#setIntensity(LivingEntity, double)}.
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#setIntensity(LivingEntity, double)}
   */
  @Test
  @DisplayName("Test setIntensity(LivingEntity, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WaterBottleSplashEvent.setIntensity(LivingEntity, double)"})
  void testSetIntensity() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    waterBottleSplashEvent.setIntensity(entity, 10.0d);

    // Assert
    Collection<LivingEntity> affectedEntities2 = waterBottleSplashEvent.getAffectedEntities();
    assertEquals(1, affectedEntities2.size());
    assertTrue(affectedEntities2 instanceof List);
    Collection<LivingEntity> toDamage = waterBottleSplashEvent.getToDamage();
    assertEquals(1, toDamage.size());
    assertTrue(toDamage instanceof Set);
    assertSame(entity, ((List<LivingEntity>) affectedEntities2).get(0));
  }

  /**
   * Test {@link WaterBottleSplashEvent#setIntensity(LivingEntity, double)}.
   *
   * <p>Method under test: {@link WaterBottleSplashEvent#setIntensity(LivingEntity, double)}
   */
  @Test
  @DisplayName("Test setIntensity(LivingEntity, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WaterBottleSplashEvent.setIntensity(LivingEntity, double)"})
  void testSetIntensity2() {
    // Arrange
    ThrownPotion potion = mock(ThrownPotion.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);
    HashMap<LivingEntity, Double> affectedEntities = new HashMap<>();
    HashSet<LivingEntity> rehydrate = new HashSet<>();

    WaterBottleSplashEvent waterBottleSplashEvent =
        new WaterBottleSplashEvent(
            potion,
            hitEntity,
            hitBlock,
            BlockFace.NORTH,
            affectedEntities,
            rehydrate,
            new HashSet<>());

    // Act
    waterBottleSplashEvent.setIntensity(mock(LivingEntity.class), 0.0d);

    // Assert that nothing has changed
    Collection<LivingEntity> affectedEntities2 = waterBottleSplashEvent.getAffectedEntities();
    assertTrue(affectedEntities2 instanceof List);
    Collection<LivingEntity> toDamage = waterBottleSplashEvent.getToDamage();
    assertTrue(toDamage instanceof Set);
    assertTrue(affectedEntities2.isEmpty());
    assertTrue(toDamage.isEmpty());
  }
}
