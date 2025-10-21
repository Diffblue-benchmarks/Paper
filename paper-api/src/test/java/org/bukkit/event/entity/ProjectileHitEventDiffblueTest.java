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
import org.bukkit.entity.Projectile;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProjectileHitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Block}.
   *   <li>Then return HitEntity is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileHitEvent#ProjectileHitEvent(Projectile, Block)}
   *   <li>{@link ProjectileHitEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileHitEvent#getHandlerList()}
   *   <li>{@link ProjectileHitEvent#getHandlers()}
   *   <li>{@link ProjectileHitEvent#getHitBlock()}
   *   <li>{@link ProjectileHitEvent#getHitBlockFace()}
   *   <li>{@link ProjectileHitEvent#getHitEntity()}
   *   <li>{@link ProjectileHitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Block; then return HitEntity is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileHitEvent.<init>(Projectile)",
    "void ProjectileHitEvent.<init>(Projectile, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block, BlockFace)",
    "HandlerList ProjectileHitEvent.getHandlerList()",
    "HandlerList ProjectileHitEvent.getHandlers()",
    "Block ProjectileHitEvent.getHitBlock()",
    "BlockFace ProjectileHitEvent.getHitBlockFace()",
    "Entity ProjectileHitEvent.getHitEntity()",
    "boolean ProjectileHitEvent.isCancelled()",
    "void ProjectileHitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenBlock_thenReturnHitEntityIsNull() {
    // Arrange
    Projectile projectile = mock(Projectile.class);
    Block hitBlock = mock(Block.class);

    // Act
    ProjectileHitEvent actualProjectileHitEvent = new ProjectileHitEvent(projectile, hitBlock);
    actualProjectileHitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualProjectileHitEvent.getHandlerList();
    HandlerList actualHandlers = actualProjectileHitEvent.getHandlers();
    Block actualHitBlock = actualProjectileHitEvent.getHitBlock();
    BlockFace actualHitBlockFace = actualProjectileHitEvent.getHitBlockFace();
    Entity actualHitEntity = actualProjectileHitEvent.getHitEntity();
    boolean actualIsCancelledResult = actualProjectileHitEvent.isCancelled();

    // Assert
    assertNull(actualHitBlockFace);
    assertNull(actualHitEntity);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualProjectileHitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitBlock, actualHitBlock);
    assertSame(projectile, actualProjectileHitEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return HitBlock is {@link Block}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileHitEvent#ProjectileHitEvent(Projectile, Entity, Block)}
   *   <li>{@link ProjectileHitEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileHitEvent#getHandlerList()}
   *   <li>{@link ProjectileHitEvent#getHandlers()}
   *   <li>{@link ProjectileHitEvent#getHitBlock()}
   *   <li>{@link ProjectileHitEvent#getHitBlockFace()}
   *   <li>{@link ProjectileHitEvent#getHitEntity()}
   *   <li>{@link ProjectileHitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return HitBlock is Block")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileHitEvent.<init>(Projectile)",
    "void ProjectileHitEvent.<init>(Projectile, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block, BlockFace)",
    "HandlerList ProjectileHitEvent.getHandlerList()",
    "HandlerList ProjectileHitEvent.getHandlers()",
    "Block ProjectileHitEvent.getHitBlock()",
    "BlockFace ProjectileHitEvent.getHitBlockFace()",
    "Entity ProjectileHitEvent.getHitEntity()",
    "boolean ProjectileHitEvent.isCancelled()",
    "void ProjectileHitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnHitBlockIsBlock() {
    // Arrange
    Projectile projectile = mock(Projectile.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);

    // Act
    ProjectileHitEvent actualProjectileHitEvent =
        new ProjectileHitEvent(projectile, hitEntity, hitBlock);
    actualProjectileHitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualProjectileHitEvent.getHandlerList();
    HandlerList actualHandlers = actualProjectileHitEvent.getHandlers();
    Block actualHitBlock = actualProjectileHitEvent.getHitBlock();
    BlockFace actualHitBlockFace = actualProjectileHitEvent.getHitBlockFace();
    Entity actualHitEntity = actualProjectileHitEvent.getHitEntity();
    boolean actualIsCancelledResult = actualProjectileHitEvent.isCancelled();

    // Assert
    assertNull(actualHitBlockFace);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualProjectileHitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitBlock, actualHitBlock);
    assertSame(hitEntity, actualHitEntity);
    assertSame(projectile, actualProjectileHitEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return HitBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileHitEvent#ProjectileHitEvent(Projectile, Entity)}
   *   <li>{@link ProjectileHitEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileHitEvent#getHandlerList()}
   *   <li>{@link ProjectileHitEvent#getHandlers()}
   *   <li>{@link ProjectileHitEvent#getHitBlock()}
   *   <li>{@link ProjectileHitEvent#getHitBlockFace()}
   *   <li>{@link ProjectileHitEvent#getHitEntity()}
   *   <li>{@link ProjectileHitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return HitBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileHitEvent.<init>(Projectile)",
    "void ProjectileHitEvent.<init>(Projectile, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block, BlockFace)",
    "HandlerList ProjectileHitEvent.getHandlerList()",
    "HandlerList ProjectileHitEvent.getHandlers()",
    "Block ProjectileHitEvent.getHitBlock()",
    "BlockFace ProjectileHitEvent.getHitBlockFace()",
    "Entity ProjectileHitEvent.getHitEntity()",
    "boolean ProjectileHitEvent.isCancelled()",
    "void ProjectileHitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnHitBlockIsNull() {
    // Arrange
    Projectile projectile = mock(Projectile.class);
    Entity hitEntity = mock(Entity.class);

    // Act
    ProjectileHitEvent actualProjectileHitEvent = new ProjectileHitEvent(projectile, hitEntity);
    actualProjectileHitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualProjectileHitEvent.getHandlerList();
    HandlerList actualHandlers = actualProjectileHitEvent.getHandlers();
    Block actualHitBlock = actualProjectileHitEvent.getHitBlock();
    BlockFace actualHitBlockFace = actualProjectileHitEvent.getHitBlockFace();
    Entity actualHitEntity = actualProjectileHitEvent.getHitEntity();
    boolean actualIsCancelledResult = actualProjectileHitEvent.isCancelled();

    // Assert
    assertNull(actualHitBlock);
    assertNull(actualHitBlockFace);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualProjectileHitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitEntity, actualHitEntity);
    assertSame(projectile, actualProjectileHitEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code NORTH}.
   *   <li>Then return HitBlockFace is {@code NORTH}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileHitEvent#ProjectileHitEvent(Projectile, Entity, Block, BlockFace)}
   *   <li>{@link ProjectileHitEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileHitEvent#getHandlerList()}
   *   <li>{@link ProjectileHitEvent#getHandlers()}
   *   <li>{@link ProjectileHitEvent#getHitBlock()}
   *   <li>{@link ProjectileHitEvent#getHitBlockFace()}
   *   <li>{@link ProjectileHitEvent#getHitEntity()}
   *   <li>{@link ProjectileHitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'NORTH'; then return HitBlockFace is 'NORTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileHitEvent.<init>(Projectile)",
    "void ProjectileHitEvent.<init>(Projectile, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block, BlockFace)",
    "HandlerList ProjectileHitEvent.getHandlerList()",
    "HandlerList ProjectileHitEvent.getHandlers()",
    "Block ProjectileHitEvent.getHitBlock()",
    "BlockFace ProjectileHitEvent.getHitBlockFace()",
    "Entity ProjectileHitEvent.getHitEntity()",
    "boolean ProjectileHitEvent.isCancelled()",
    "void ProjectileHitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenNorth_thenReturnHitBlockFaceIsNorth() {
    // Arrange
    Projectile projectile = mock(Projectile.class);
    Entity hitEntity = mock(Entity.class);
    Block hitBlock = mock(Block.class);

    // Act
    ProjectileHitEvent actualProjectileHitEvent =
        new ProjectileHitEvent(projectile, hitEntity, hitBlock, BlockFace.NORTH);
    actualProjectileHitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualProjectileHitEvent.getHandlerList();
    HandlerList actualHandlers = actualProjectileHitEvent.getHandlers();
    Block actualHitBlock = actualProjectileHitEvent.getHitBlock();
    BlockFace actualHitBlockFace = actualProjectileHitEvent.getHitBlockFace();
    Entity actualHitEntity = actualProjectileHitEvent.getHitEntity();
    boolean actualIsCancelledResult = actualProjectileHitEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(BlockFace.NORTH, actualHitBlockFace);
    assertFalse(actualProjectileHitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(hitBlock, actualHitBlock);
    assertSame(hitEntity, actualHitEntity);
    assertSame(projectile, actualProjectileHitEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Projectile}.
   *   <li>Then return HitBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileHitEvent#ProjectileHitEvent(Projectile)}
   *   <li>{@link ProjectileHitEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileHitEvent#getHandlerList()}
   *   <li>{@link ProjectileHitEvent#getHandlers()}
   *   <li>{@link ProjectileHitEvent#getHitBlock()}
   *   <li>{@link ProjectileHitEvent#getHitBlockFace()}
   *   <li>{@link ProjectileHitEvent#getHitEntity()}
   *   <li>{@link ProjectileHitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Projectile; then return HitBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileHitEvent.<init>(Projectile)",
    "void ProjectileHitEvent.<init>(Projectile, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block)",
    "void ProjectileHitEvent.<init>(Projectile, Entity, Block, BlockFace)",
    "HandlerList ProjectileHitEvent.getHandlerList()",
    "HandlerList ProjectileHitEvent.getHandlers()",
    "Block ProjectileHitEvent.getHitBlock()",
    "BlockFace ProjectileHitEvent.getHitBlockFace()",
    "Entity ProjectileHitEvent.getHitEntity()",
    "boolean ProjectileHitEvent.isCancelled()",
    "void ProjectileHitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenProjectile_thenReturnHitBlockIsNull() {
    // Arrange
    Projectile projectile = mock(Projectile.class);

    // Act
    ProjectileHitEvent actualProjectileHitEvent = new ProjectileHitEvent(projectile);
    actualProjectileHitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualProjectileHitEvent.getHandlerList();
    HandlerList actualHandlers = actualProjectileHitEvent.getHandlers();
    Block actualHitBlock = actualProjectileHitEvent.getHitBlock();
    BlockFace actualHitBlockFace = actualProjectileHitEvent.getHitBlockFace();
    Entity actualHitEntity = actualProjectileHitEvent.getHitEntity();
    boolean actualIsCancelledResult = actualProjectileHitEvent.isCancelled();

    // Assert
    assertNull(actualHitBlock);
    assertNull(actualHitBlockFace);
    assertNull(actualHitEntity);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualProjectileHitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(projectile, actualProjectileHitEvent.getEntity());
  }

  /**
   * Test {@link ProjectileHitEvent#getEntity()}.
   *
   * <p>Method under test: {@link ProjectileHitEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Projectile ProjectileHitEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ProjectileHitEvent projectileHitEvent = new ProjectileHitEvent(mock(Projectile.class));

    // Act
    Projectile actualEntity = projectileHitEvent.getEntity();

    // Assert
    assertSame(projectileHitEvent.entity, actualEntity);
  }
}
