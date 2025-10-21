package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.PortalType;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPortalReadyEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPortalReadyEvent#EntityPortalReadyEvent(Entity, World, PortalType)}
   *   <li>{@link EntityPortalReadyEvent#setCancelled(boolean)}
   *   <li>{@link EntityPortalReadyEvent#setTargetWorld(World)}
   *   <li>{@link EntityPortalReadyEvent#getHandlerList()}
   *   <li>{@link EntityPortalReadyEvent#getHandlers()}
   *   <li>{@link EntityPortalReadyEvent#getPortalType()}
   *   <li>{@link EntityPortalReadyEvent#getTargetWorld()}
   *   <li>{@link EntityPortalReadyEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPortalReadyEvent.<init>(Entity, World, PortalType)",
    "HandlerList EntityPortalReadyEvent.getHandlerList()",
    "HandlerList EntityPortalReadyEvent.getHandlers()",
    "PortalType EntityPortalReadyEvent.getPortalType()",
    "World EntityPortalReadyEvent.getTargetWorld()",
    "boolean EntityPortalReadyEvent.isCancelled()",
    "void EntityPortalReadyEvent.setCancelled(boolean)",
    "void EntityPortalReadyEvent.setTargetWorld(World)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityPortalReadyEvent actualEntityPortalReadyEvent =
        new EntityPortalReadyEvent(entity, mock(World.class), PortalType.NETHER);
    actualEntityPortalReadyEvent.setCancelled(true);
    World targetWorld = mock(World.class);
    actualEntityPortalReadyEvent.setTargetWorld(targetWorld);
    HandlerList actualHandlerList = actualEntityPortalReadyEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityPortalReadyEvent.getHandlers();
    PortalType actualPortalType = actualEntityPortalReadyEvent.getPortalType();
    World actualTargetWorld = actualEntityPortalReadyEvent.getTargetWorld();
    boolean actualIsCancelledResult = actualEntityPortalReadyEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PortalType.NETHER, actualPortalType);
    assertFalse(actualEntityPortalReadyEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(targetWorld, actualTargetWorld);
    assertSame(entity, actualEntityPortalReadyEvent.getEntity());
  }
}
