package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProjectileCollideEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileCollideEvent#ProjectileCollideEvent(Projectile, Entity)}
   *   <li>{@link ProjectileCollideEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileCollideEvent#getHandlerList()}
   *   <li>{@link ProjectileCollideEvent#getCollidedWith()}
   *   <li>{@link ProjectileCollideEvent#getHandlers()}
   *   <li>{@link ProjectileCollideEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileCollideEvent.<init>(Projectile, Entity)",
    "Entity ProjectileCollideEvent.getCollidedWith()",
    "HandlerList ProjectileCollideEvent.getHandlerList()",
    "HandlerList ProjectileCollideEvent.getHandlers()",
    "boolean ProjectileCollideEvent.isCancelled()",
    "void ProjectileCollideEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Projectile projectile = mock(Projectile.class);
    Entity collidedWith = mock(Entity.class);

    // Act
    ProjectileCollideEvent actualProjectileCollideEvent =
        new ProjectileCollideEvent(projectile, collidedWith);
    actualProjectileCollideEvent.setCancelled(true);
    HandlerList actualHandlerList = actualProjectileCollideEvent.getHandlerList();
    Entity actualCollidedWith = actualProjectileCollideEvent.getCollidedWith();
    HandlerList actualHandlers = actualProjectileCollideEvent.getHandlers();
    boolean actualIsCancelledResult = actualProjectileCollideEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualProjectileCollideEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(collidedWith, actualCollidedWith);
    assertSame(projectile, actualProjectileCollideEvent.getEntity());
  }
}
