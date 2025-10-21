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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityCombustEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCombustEvent#EntityCombustEvent(Entity, float)}
   *   <li>{@link EntityCombustEvent#setCancelled(boolean)}
   *   <li>{@link EntityCombustEvent#setDuration(float)}
   *   <li>{@link EntityCombustEvent#setDuration(int)}
   *   <li>{@link EntityCombustEvent#getHandlerList()}
   *   <li>{@link EntityCombustEvent#getDuration()}
   *   <li>{@link EntityCombustEvent#getHandlers()}
   *   <li>{@link EntityCombustEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCombustEvent.<init>(Entity, float)",
    "float EntityCombustEvent.getDuration()",
    "HandlerList EntityCombustEvent.getHandlerList()",
    "HandlerList EntityCombustEvent.getHandlers()",
    "boolean EntityCombustEvent.isCancelled()",
    "void EntityCombustEvent.setCancelled(boolean)",
    "void EntityCombustEvent.setDuration(float)",
    "void EntityCombustEvent.setDuration(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity combustee = mock(Entity.class);

    // Act
    EntityCombustEvent actualEntityCombustEvent = new EntityCombustEvent(combustee, 10.0f);
    actualEntityCombustEvent.setCancelled(true);
    actualEntityCombustEvent.setDuration(10.0f);
    actualEntityCombustEvent.setDuration(1);
    HandlerList actualHandlerList = actualEntityCombustEvent.getHandlerList();
    float actualDuration = actualEntityCombustEvent.getDuration();
    HandlerList actualHandlers = actualEntityCombustEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityCombustEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1.0f, actualDuration);
    assertFalse(actualEntityCombustEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(combustee, actualEntityCombustEvent.getEntity());
  }

  /**
   * Test {@link EntityCombustEvent#EntityCombustEvent(Entity, int)}.
   *
   * <p>Method under test: {@link EntityCombustEvent#EntityCombustEvent(Entity, int)}
   */
  @Test
  @DisplayName("Test new EntityCombustEvent(Entity, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityCombustEvent.<init>(Entity, int)"})
  void testNewEntityCombustEvent() {
    // Arrange
    Entity combustee = mock(Entity.class);

    // Act
    EntityCombustEvent actualEntityCombustEvent = new EntityCombustEvent(combustee, 1);

    // Assert
    assertEquals("EntityCombustEvent", actualEntityCombustEvent.getEventName());
    assertNull(actualEntityCombustEvent.getEntityType());
    assertEquals(0, actualEntityCombustEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1.0f, actualEntityCombustEvent.getDuration());
    assertFalse(actualEntityCombustEvent.isAsynchronous());
    assertFalse(actualEntityCombustEvent.isCancelled());
    assertSame(combustee, actualEntityCombustEvent.getEntity());
  }
}
