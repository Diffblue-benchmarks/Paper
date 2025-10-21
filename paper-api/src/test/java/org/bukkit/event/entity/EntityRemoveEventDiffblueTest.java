package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityRemoveEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityRemoveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRemoveEvent#EntityRemoveEvent(Entity, Cause)}
   *   <li>{@link EntityRemoveEvent#getHandlerList()}
   *   <li>{@link EntityRemoveEvent#getCause()}
   *   <li>{@link EntityRemoveEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRemoveEvent.<init>(Entity, Cause)",
    "Cause EntityRemoveEvent.getCause()",
    "HandlerList EntityRemoveEvent.getHandlerList()",
    "HandlerList EntityRemoveEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityRemoveEvent actualEntityRemoveEvent = new EntityRemoveEvent(entity, Cause.DEATH);
    HandlerList actualHandlerList = actualEntityRemoveEvent.getHandlerList();
    Cause actualCause = actualEntityRemoveEvent.getCause();
    HandlerList actualHandlers = actualEntityRemoveEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.DEATH, actualCause);
    assertFalse(actualEntityRemoveEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityRemoveEvent.getEntity());
  }
}
