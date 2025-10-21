package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityToggleGlideEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityToggleGlideEvent#EntityToggleGlideEvent(LivingEntity, boolean)}
   *   <li>{@link EntityToggleGlideEvent#setCancelled(boolean)}
   *   <li>{@link EntityToggleGlideEvent#getHandlerList()}
   *   <li>{@link EntityToggleGlideEvent#getHandlers()}
   *   <li>{@link EntityToggleGlideEvent#isCancelled()}
   *   <li>{@link EntityToggleGlideEvent#isGliding()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityToggleGlideEvent.<init>(LivingEntity, boolean)",
    "HandlerList EntityToggleGlideEvent.getHandlerList()",
    "HandlerList EntityToggleGlideEvent.getHandlers()",
    "boolean EntityToggleGlideEvent.isCancelled()",
    "boolean EntityToggleGlideEvent.isGliding()",
    "void EntityToggleGlideEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity livingEntity = mock(LivingEntity.class);

    // Act
    EntityToggleGlideEvent actualEntityToggleGlideEvent =
        new EntityToggleGlideEvent(livingEntity, true);
    actualEntityToggleGlideEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityToggleGlideEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityToggleGlideEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityToggleGlideEvent.isCancelled();
    boolean actualIsGlidingResult = actualEntityToggleGlideEvent.isGliding();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityToggleGlideEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsGlidingResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(livingEntity, actualEntityToggleGlideEvent.getEntity());
  }
}
