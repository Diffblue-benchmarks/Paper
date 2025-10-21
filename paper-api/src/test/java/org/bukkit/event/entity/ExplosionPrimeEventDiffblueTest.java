package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Explosive;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExplosionPrimeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExplosionPrimeEvent#ExplosionPrimeEvent(Entity, float, boolean)}
   *   <li>{@link ExplosionPrimeEvent#setCancelled(boolean)}
   *   <li>{@link ExplosionPrimeEvent#setFire(boolean)}
   *   <li>{@link ExplosionPrimeEvent#setRadius(float)}
   *   <li>{@link ExplosionPrimeEvent#getHandlerList()}
   *   <li>{@link ExplosionPrimeEvent#getFire()}
   *   <li>{@link ExplosionPrimeEvent#getHandlers()}
   *   <li>{@link ExplosionPrimeEvent#getRadius()}
   *   <li>{@link ExplosionPrimeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExplosionPrimeEvent.<init>(Entity, float, boolean)",
    "boolean ExplosionPrimeEvent.getFire()",
    "HandlerList ExplosionPrimeEvent.getHandlerList()",
    "HandlerList ExplosionPrimeEvent.getHandlers()",
    "float ExplosionPrimeEvent.getRadius()",
    "boolean ExplosionPrimeEvent.isCancelled()",
    "void ExplosionPrimeEvent.setCancelled(boolean)",
    "void ExplosionPrimeEvent.setFire(boolean)",
    "void ExplosionPrimeEvent.setRadius(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    ExplosionPrimeEvent actualExplosionPrimeEvent = new ExplosionPrimeEvent(entity, 10.0f, true);
    actualExplosionPrimeEvent.setCancelled(true);
    actualExplosionPrimeEvent.setFire(true);
    actualExplosionPrimeEvent.setRadius(10.0f);
    HandlerList actualHandlerList = actualExplosionPrimeEvent.getHandlerList();
    boolean actualFire = actualExplosionPrimeEvent.getFire();
    HandlerList actualHandlers = actualExplosionPrimeEvent.getHandlers();
    float actualRadius = actualExplosionPrimeEvent.getRadius();
    boolean actualIsCancelledResult = actualExplosionPrimeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0f, actualRadius);
    assertFalse(actualExplosionPrimeEvent.isAsynchronous());
    assertTrue(actualFire);
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualExplosionPrimeEvent.getEntity());
  }

  /**
   * Test {@link ExplosionPrimeEvent#ExplosionPrimeEvent(Explosive)}.
   *
   * <p>Method under test: {@link ExplosionPrimeEvent#ExplosionPrimeEvent(Explosive)}
   */
  @Test
  @DisplayName("Test new ExplosionPrimeEvent(Explosive)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExplosionPrimeEvent.<init>(Explosive)"})
  void testNewExplosionPrimeEvent() {
    // Arrange
    Explosive explosive = mock(Explosive.class);
    when(explosive.isIncendiary()).thenReturn(true);
    when(explosive.getYield()).thenReturn(10.0f);

    // Act
    ExplosionPrimeEvent actualExplosionPrimeEvent = new ExplosionPrimeEvent(explosive);

    // Assert
    verify(explosive).getYield();
    verify(explosive).isIncendiary();
    assertEquals("ExplosionPrimeEvent", actualExplosionPrimeEvent.getEventName());
    assertNull(actualExplosionPrimeEvent.getEntityType());
    assertEquals(0, actualExplosionPrimeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0f, actualExplosionPrimeEvent.getRadius());
    assertFalse(actualExplosionPrimeEvent.isAsynchronous());
    assertFalse(actualExplosionPrimeEvent.isCancelled());
    assertTrue(actualExplosionPrimeEvent.getFire());
    assertSame(explosive, actualExplosionPrimeEvent.getEntity());
  }
}
