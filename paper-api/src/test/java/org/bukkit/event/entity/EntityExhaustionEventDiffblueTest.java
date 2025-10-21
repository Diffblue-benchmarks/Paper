package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityExhaustionEvent.ExhaustionReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityExhaustionEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExhaustionEvent#EntityExhaustionEvent(HumanEntity, ExhaustionReason, float)}
   *   <li>{@link EntityExhaustionEvent#setCancelled(boolean)}
   *   <li>{@link EntityExhaustionEvent#setExhaustion(float)}
   *   <li>{@link EntityExhaustionEvent#getHandlerList()}
   *   <li>{@link EntityExhaustionEvent#getExhaustion()}
   *   <li>{@link EntityExhaustionEvent#getExhaustionReason()}
   *   <li>{@link EntityExhaustionEvent#getHandlers()}
   *   <li>{@link EntityExhaustionEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityExhaustionEvent.<init>(HumanEntity, ExhaustionReason, float)",
    "float EntityExhaustionEvent.getExhaustion()",
    "ExhaustionReason EntityExhaustionEvent.getExhaustionReason()",
    "HandlerList EntityExhaustionEvent.getHandlerList()",
    "HandlerList EntityExhaustionEvent.getHandlers()",
    "boolean EntityExhaustionEvent.isCancelled()",
    "void EntityExhaustionEvent.setCancelled(boolean)",
    "void EntityExhaustionEvent.setExhaustion(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    HumanEntity human = mock(HumanEntity.class);

    // Act
    EntityExhaustionEvent actualEntityExhaustionEvent =
        new EntityExhaustionEvent(human, ExhaustionReason.BLOCK_MINED, 10.0f);
    actualEntityExhaustionEvent.setCancelled(true);
    actualEntityExhaustionEvent.setExhaustion(10.0f);
    HandlerList actualHandlerList = actualEntityExhaustionEvent.getHandlerList();
    float actualExhaustion = actualEntityExhaustionEvent.getExhaustion();
    ExhaustionReason actualExhaustionReason = actualEntityExhaustionEvent.getExhaustionReason();
    HandlerList actualHandlers = actualEntityExhaustionEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityExhaustionEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0f, actualExhaustion);
    assertEquals(ExhaustionReason.BLOCK_MINED, actualExhaustionReason);
    assertFalse(actualEntityExhaustionEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(human, actualEntityExhaustionEvent.getEntity());
  }

  /**
   * Test {@link EntityExhaustionEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityExhaustionEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HumanEntity EntityExhaustionEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityExhaustionEvent entityExhaustionEvent =
        new EntityExhaustionEvent(mock(HumanEntity.class), ExhaustionReason.BLOCK_MINED, 10.0f);

    // Act
    HumanEntity actualEntity = entityExhaustionEvent.getEntity();

    // Assert
    assertSame(entityExhaustionEvent.entity, actualEntity);
  }
}
