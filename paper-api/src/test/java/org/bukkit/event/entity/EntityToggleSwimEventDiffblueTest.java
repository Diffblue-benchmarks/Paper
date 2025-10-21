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

class EntityToggleSwimEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityToggleSwimEvent#EntityToggleSwimEvent(LivingEntity, boolean)}
   *   <li>{@link EntityToggleSwimEvent#setCancelled(boolean)}
   *   <li>{@link EntityToggleSwimEvent#getHandlerList()}
   *   <li>{@link EntityToggleSwimEvent#getHandlers()}
   *   <li>{@link EntityToggleSwimEvent#isCancelled()}
   *   <li>{@link EntityToggleSwimEvent#isSwimming()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityToggleSwimEvent.<init>(LivingEntity, boolean)",
    "HandlerList EntityToggleSwimEvent.getHandlerList()",
    "HandlerList EntityToggleSwimEvent.getHandlers()",
    "boolean EntityToggleSwimEvent.isCancelled()",
    "boolean EntityToggleSwimEvent.isSwimming()",
    "void EntityToggleSwimEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity livingEntity = mock(LivingEntity.class);

    // Act
    EntityToggleSwimEvent actualEntityToggleSwimEvent =
        new EntityToggleSwimEvent(livingEntity, true);
    actualEntityToggleSwimEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityToggleSwimEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityToggleSwimEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityToggleSwimEvent.isCancelled();
    boolean actualIsSwimmingResult = actualEntityToggleSwimEvent.isSwimming();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityToggleSwimEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsSwimmingResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(livingEntity, actualEntityToggleSwimEvent.getEntity());
  }
}
