package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Slime;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SlimeSplitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlimeSplitEvent#SlimeSplitEvent(Slime, int)}
   *   <li>{@link SlimeSplitEvent#setCancelled(boolean)}
   *   <li>{@link SlimeSplitEvent#setCount(int)}
   *   <li>{@link SlimeSplitEvent#getHandlerList()}
   *   <li>{@link SlimeSplitEvent#getCount()}
   *   <li>{@link SlimeSplitEvent#getHandlers()}
   *   <li>{@link SlimeSplitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlimeSplitEvent.<init>(Slime, int)",
    "int SlimeSplitEvent.getCount()",
    "HandlerList SlimeSplitEvent.getHandlerList()",
    "HandlerList SlimeSplitEvent.getHandlers()",
    "boolean SlimeSplitEvent.isCancelled()",
    "void SlimeSplitEvent.setCancelled(boolean)",
    "void SlimeSplitEvent.setCount(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Slime slime = mock(Slime.class);

    // Act
    SlimeSplitEvent actualSlimeSplitEvent = new SlimeSplitEvent(slime, 3);
    actualSlimeSplitEvent.setCancelled(true);
    actualSlimeSplitEvent.setCount(3);
    HandlerList actualHandlerList = actualSlimeSplitEvent.getHandlerList();
    int actualCount = actualSlimeSplitEvent.getCount();
    HandlerList actualHandlers = actualSlimeSplitEvent.getHandlers();
    boolean actualIsCancelledResult = actualSlimeSplitEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(3, actualCount);
    assertFalse(actualSlimeSplitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(slime, actualSlimeSplitEvent.getEntity());
  }

  /**
   * Test {@link SlimeSplitEvent#getEntity()}.
   *
   * <p>Method under test: {@link SlimeSplitEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Slime SlimeSplitEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    SlimeSplitEvent slimeSplitEvent = new SlimeSplitEvent(mock(Slime.class), 3);

    // Act
    Slime actualEntity = slimeSplitEvent.getEntity();

    // Assert
    assertSame(slimeSplitEvent.entity, actualEntity);
  }
}
