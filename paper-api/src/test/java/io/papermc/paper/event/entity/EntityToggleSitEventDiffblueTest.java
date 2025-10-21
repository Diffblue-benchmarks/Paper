package io.papermc.paper.event.entity;

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

class EntityToggleSitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityToggleSitEvent#EntityToggleSitEvent(Entity, boolean)}
   *   <li>{@link EntityToggleSitEvent#setCancelled(boolean)}
   *   <li>{@link EntityToggleSitEvent#getHandlerList()}
   *   <li>{@link EntityToggleSitEvent#getHandlers()}
   *   <li>{@link EntityToggleSitEvent#getSittingState()}
   *   <li>{@link EntityToggleSitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityToggleSitEvent.<init>(Entity, boolean)",
    "HandlerList EntityToggleSitEvent.getHandlerList()",
    "HandlerList EntityToggleSitEvent.getHandlers()",
    "boolean EntityToggleSitEvent.getSittingState()",
    "boolean EntityToggleSitEvent.isCancelled()",
    "void EntityToggleSitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityToggleSitEvent actualEntityToggleSitEvent = new EntityToggleSitEvent(entity, true);
    actualEntityToggleSitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityToggleSitEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityToggleSitEvent.getHandlers();
    boolean actualSittingState = actualEntityToggleSitEvent.getSittingState();
    boolean actualIsCancelledResult = actualEntityToggleSitEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityToggleSitEvent.isAsynchronous());
    assertTrue(actualSittingState);
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityToggleSitEvent.getEntity());
  }
}
