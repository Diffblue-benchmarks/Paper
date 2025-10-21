package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityRemoveFromWorldEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRemoveFromWorldEvent#EntityRemoveFromWorldEvent(Entity, World)}
   *   <li>{@link EntityRemoveFromWorldEvent#getHandlerList()}
   *   <li>{@link EntityRemoveFromWorldEvent#getHandlers()}
   *   <li>{@link EntityRemoveFromWorldEvent#getWorld()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRemoveFromWorldEvent.<init>(Entity, World)",
    "HandlerList EntityRemoveFromWorldEvent.getHandlerList()",
    "HandlerList EntityRemoveFromWorldEvent.getHandlers()",
    "World EntityRemoveFromWorldEvent.getWorld()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    World world = mock(World.class);

    // Act
    EntityRemoveFromWorldEvent actualEntityRemoveFromWorldEvent =
        new EntityRemoveFromWorldEvent(entity, world);
    HandlerList actualHandlerList = actualEntityRemoveFromWorldEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityRemoveFromWorldEvent.getHandlers();
    World actualWorld = actualEntityRemoveFromWorldEvent.getWorld();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityRemoveFromWorldEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorld);
    assertSame(entity, actualEntityRemoveFromWorldEvent.getEntity());
  }
}
