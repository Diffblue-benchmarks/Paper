package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityCombustByEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCombustByEntityEvent#EntityCombustByEntityEvent(Entity, Entity, float)}
   *   <li>{@link EntityCombustByEntityEvent#getCombuster()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCombustByEntityEvent.<init>(Entity, Entity, float)",
    "Entity EntityCombustByEntityEvent.getCombuster()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity combuster = mock(Entity.class);
    Entity combustee = mock(Entity.class);

    // Act
    EntityCombustByEntityEvent actualEntityCombustByEntityEvent =
        new EntityCombustByEntityEvent(combuster, combustee, 10.0f);
    Entity actualCombuster = actualEntityCombustByEntityEvent.getCombuster();

    // Assert
    assertEquals(10.0f, actualEntityCombustByEntityEvent.getDuration());
    assertFalse(actualEntityCombustByEntityEvent.isAsynchronous());
    assertFalse(actualEntityCombustByEntityEvent.isCancelled());
    assertSame(combuster, actualCombuster);
    assertSame(combustee, actualEntityCombustByEntityEvent.getEntity());
  }

  /**
   * Test {@link EntityCombustByEntityEvent#EntityCombustByEntityEvent(Entity, Entity, int)}.
   *
   * <p>Method under test: {@link EntityCombustByEntityEvent#EntityCombustByEntityEvent(Entity,
   * Entity, int)}
   */
  @Test
  @DisplayName("Test new EntityCombustByEntityEvent(Entity, Entity, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityCombustByEntityEvent.<init>(Entity, Entity, int)"})
  void testNewEntityCombustByEntityEvent() {
    // Arrange
    Entity combuster = mock(Entity.class);
    Entity combustee = mock(Entity.class);

    // Act
    EntityCombustByEntityEvent actualEntityCombustByEntityEvent =
        new EntityCombustByEntityEvent(combuster, combustee, 1);

    // Assert
    assertEquals("EntityCombustByEntityEvent", actualEntityCombustByEntityEvent.getEventName());
    assertNull(actualEntityCombustByEntityEvent.getEntityType());
    assertEquals(0, actualEntityCombustByEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1.0f, actualEntityCombustByEntityEvent.getDuration());
    assertFalse(actualEntityCombustByEntityEvent.isAsynchronous());
    assertFalse(actualEntityCombustByEntityEvent.isCancelled());
    assertSame(combuster, actualEntityCombustByEntityEvent.getCombuster());
    assertSame(combustee, actualEntityCombustByEntityEvent.getEntity());
  }
}
