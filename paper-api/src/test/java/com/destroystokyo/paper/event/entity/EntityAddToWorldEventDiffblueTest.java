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

class EntityAddToWorldEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAddToWorldEvent#EntityAddToWorldEvent(Entity, World)}
   *   <li>{@link EntityAddToWorldEvent#getHandlerList()}
   *   <li>{@link EntityAddToWorldEvent#getHandlers()}
   *   <li>{@link EntityAddToWorldEvent#getWorld()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAddToWorldEvent.<init>(Entity, World)",
    "HandlerList EntityAddToWorldEvent.getHandlerList()",
    "HandlerList EntityAddToWorldEvent.getHandlers()",
    "World EntityAddToWorldEvent.getWorld()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    World world = mock(World.class);

    // Act
    EntityAddToWorldEvent actualEntityAddToWorldEvent = new EntityAddToWorldEvent(entity, world);
    HandlerList actualHandlerList = actualEntityAddToWorldEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityAddToWorldEvent.getHandlers();
    World actualWorld = actualEntityAddToWorldEvent.getWorld();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityAddToWorldEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWorld);
    assertSame(entity, actualEntityAddToWorldEvent.getEntity());
  }
}
