package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

class EntityMountEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityMountEvent#EntityMountEvent(Entity, Entity)}
   *   <li>{@link EntityMountEvent#setCancelled(boolean)}
   *   <li>{@link EntityMountEvent#getHandlerList()}
   *   <li>{@link EntityMountEvent#getHandlers()}
   *   <li>{@link EntityMountEvent#getMount()}
   *   <li>{@link EntityMountEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityMountEvent.<init>(Entity, Entity)",
    "HandlerList EntityMountEvent.getHandlerList()",
    "HandlerList EntityMountEvent.getHandlers()",
    "Entity EntityMountEvent.getMount()",
    "boolean EntityMountEvent.isCancelled()",
    "void EntityMountEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Entity mount = mock(Entity.class);

    // Act
    EntityMountEvent actualEntityMountEvent = new EntityMountEvent(entity, mount);
    actualEntityMountEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityMountEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityMountEvent.getHandlers();
    Entity actualMount = actualEntityMountEvent.getMount();
    boolean actualIsCancelledResult = actualEntityMountEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityMountEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityMountEvent.getEntity());
    assertSame(mount, actualMount);
  }
}
