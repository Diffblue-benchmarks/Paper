package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityRegainHealthEventDiffblueTest {
  /**
   * Test {@link EntityRegainHealthEvent#EntityRegainHealthEvent(Entity, double, RegainReason)}.
   *
   * <p>Method under test: {@link EntityRegainHealthEvent#EntityRegainHealthEvent(Entity, double,
   * RegainReason)}
   */
  @Test
  @DisplayName("Test new EntityRegainHealthEvent(Entity, double, RegainReason)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRegainHealthEvent.<init>(Entity, double, RegainReason)"})
  void testNewEntityRegainHealthEvent() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityRegainHealthEvent actualEntityRegainHealthEvent =
        new EntityRegainHealthEvent(entity, 10.0d, RegainReason.REGEN);

    // Assert
    assertEquals("EntityRegainHealthEvent", actualEntityRegainHealthEvent.getEventName());
    assertNull(actualEntityRegainHealthEvent.getEntityType());
    assertEquals(0, actualEntityRegainHealthEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityRegainHealthEvent.getAmount());
    assertEquals(RegainReason.REGEN, actualEntityRegainHealthEvent.getRegainReason());
    assertFalse(actualEntityRegainHealthEvent.isAsynchronous());
    assertFalse(actualEntityRegainHealthEvent.isCancelled());
    assertFalse(actualEntityRegainHealthEvent.isFastRegen());
    assertSame(entity, actualEntityRegainHealthEvent.getEntity());
  }

  /**
   * Test {@link EntityRegainHealthEvent#EntityRegainHealthEvent(Entity, double, RegainReason,
   * boolean)}.
   *
   * <p>Method under test: {@link EntityRegainHealthEvent#EntityRegainHealthEvent(Entity, double,
   * RegainReason, boolean)}
   */
  @Test
  @DisplayName("Test new EntityRegainHealthEvent(Entity, double, RegainReason, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRegainHealthEvent.<init>(Entity, double, RegainReason, boolean)"})
  void testNewEntityRegainHealthEvent2() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityRegainHealthEvent actualEntityRegainHealthEvent =
        new EntityRegainHealthEvent(entity, 10.0d, RegainReason.REGEN, true);

    // Assert
    assertEquals("EntityRegainHealthEvent", actualEntityRegainHealthEvent.getEventName());
    assertNull(actualEntityRegainHealthEvent.getEntityType());
    assertEquals(0, actualEntityRegainHealthEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(10.0d, actualEntityRegainHealthEvent.getAmount());
    assertEquals(RegainReason.REGEN, actualEntityRegainHealthEvent.getRegainReason());
    assertFalse(actualEntityRegainHealthEvent.isAsynchronous());
    assertFalse(actualEntityRegainHealthEvent.isCancelled());
    assertTrue(actualEntityRegainHealthEvent.isFastRegen());
    assertSame(entity, actualEntityRegainHealthEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRegainHealthEvent#setAmount(double)}
   *   <li>{@link EntityRegainHealthEvent#setCancelled(boolean)}
   *   <li>{@link EntityRegainHealthEvent#getHandlerList()}
   *   <li>{@link EntityRegainHealthEvent#getAmount()}
   *   <li>{@link EntityRegainHealthEvent#getHandlers()}
   *   <li>{@link EntityRegainHealthEvent#getRegainReason()}
   *   <li>{@link EntityRegainHealthEvent#isCancelled()}
   *   <li>{@link EntityRegainHealthEvent#isFastRegen()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double EntityRegainHealthEvent.getAmount()",
    "HandlerList EntityRegainHealthEvent.getHandlerList()",
    "HandlerList EntityRegainHealthEvent.getHandlers()",
    "RegainReason EntityRegainHealthEvent.getRegainReason()",
    "boolean EntityRegainHealthEvent.isCancelled()",
    "boolean EntityRegainHealthEvent.isFastRegen()",
    "void EntityRegainHealthEvent.setAmount(double)",
    "void EntityRegainHealthEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityRegainHealthEvent entityRegainHealthEvent =
        new EntityRegainHealthEvent(mock(Entity.class), 10.0d, RegainReason.REGEN);

    // Act
    entityRegainHealthEvent.setAmount(10.0d);
    entityRegainHealthEvent.setCancelled(true);
    HandlerList actualHandlerList = entityRegainHealthEvent.getHandlerList();
    double actualAmount = entityRegainHealthEvent.getAmount();
    HandlerList actualHandlers = entityRegainHealthEvent.getHandlers();
    RegainReason actualRegainReason = entityRegainHealthEvent.getRegainReason();
    boolean actualIsCancelledResult = entityRegainHealthEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0d, actualAmount);
    assertEquals(RegainReason.REGEN, actualRegainReason);
    assertFalse(entityRegainHealthEvent.isFastRegen());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
  }
}
