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

class ArrowBodyCountChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrowBodyCountChangeEvent#ArrowBodyCountChangeEvent(LivingEntity, int, int,
   *       boolean)}
   *   <li>{@link ArrowBodyCountChangeEvent#setCancelled(boolean)}
   *   <li>{@link ArrowBodyCountChangeEvent#getHandlerList()}
   *   <li>{@link ArrowBodyCountChangeEvent#getHandlers()}
   *   <li>{@link ArrowBodyCountChangeEvent#getNewAmount()}
   *   <li>{@link ArrowBodyCountChangeEvent#getOldAmount()}
   *   <li>{@link ArrowBodyCountChangeEvent#isCancelled()}
   *   <li>{@link ArrowBodyCountChangeEvent#isReset()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ArrowBodyCountChangeEvent.<init>(LivingEntity, int, int, boolean)",
    "HandlerList ArrowBodyCountChangeEvent.getHandlerList()",
    "HandlerList ArrowBodyCountChangeEvent.getHandlers()",
    "int ArrowBodyCountChangeEvent.getNewAmount()",
    "int ArrowBodyCountChangeEvent.getOldAmount()",
    "boolean ArrowBodyCountChangeEvent.isCancelled()",
    "boolean ArrowBodyCountChangeEvent.isReset()",
    "void ArrowBodyCountChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    ArrowBodyCountChangeEvent actualArrowBodyCountChangeEvent =
        new ArrowBodyCountChangeEvent(entity, 1, 1, true);
    actualArrowBodyCountChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualArrowBodyCountChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualArrowBodyCountChangeEvent.getHandlers();
    int actualNewAmount = actualArrowBodyCountChangeEvent.getNewAmount();
    int actualOldAmount = actualArrowBodyCountChangeEvent.getOldAmount();
    boolean actualIsCancelledResult = actualArrowBodyCountChangeEvent.isCancelled();
    boolean actualIsResetResult = actualArrowBodyCountChangeEvent.isReset();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewAmount);
    assertEquals(1, actualOldAmount);
    assertFalse(actualArrowBodyCountChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsResetResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualArrowBodyCountChangeEvent.getEntity());
  }

  /**
   * Test {@link ArrowBodyCountChangeEvent#getEntity()}.
   *
   * <p>Method under test: {@link ArrowBodyCountChangeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity ArrowBodyCountChangeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ArrowBodyCountChangeEvent arrowBodyCountChangeEvent =
        new ArrowBodyCountChangeEvent(mock(LivingEntity.class), 1, 1, true);

    // Act
    LivingEntity actualEntity = arrowBodyCountChangeEvent.getEntity();

    // Assert
    assertSame(arrowBodyCountChangeEvent.entity, actualEntity);
  }
}
