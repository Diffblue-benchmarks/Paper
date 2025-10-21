package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Bat;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BatToggleSleepEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatToggleSleepEvent#BatToggleSleepEvent(Bat, boolean)}
   *   <li>{@link BatToggleSleepEvent#setCancelled(boolean)}
   *   <li>{@link BatToggleSleepEvent#getHandlerList()}
   *   <li>{@link BatToggleSleepEvent#getHandlers()}
   *   <li>{@link BatToggleSleepEvent#isAwake()}
   *   <li>{@link BatToggleSleepEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BatToggleSleepEvent.<init>(Bat, boolean)",
    "HandlerList BatToggleSleepEvent.getHandlerList()",
    "HandlerList BatToggleSleepEvent.getHandlers()",
    "boolean BatToggleSleepEvent.isAwake()",
    "boolean BatToggleSleepEvent.isCancelled()",
    "void BatToggleSleepEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Bat bat = mock(Bat.class);

    // Act
    BatToggleSleepEvent actualBatToggleSleepEvent = new BatToggleSleepEvent(bat, true);
    actualBatToggleSleepEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBatToggleSleepEvent.getHandlerList();
    HandlerList actualHandlers = actualBatToggleSleepEvent.getHandlers();
    boolean actualIsAwakeResult = actualBatToggleSleepEvent.isAwake();
    boolean actualIsCancelledResult = actualBatToggleSleepEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBatToggleSleepEvent.isAsynchronous());
    assertTrue(actualIsAwakeResult);
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(bat, actualBatToggleSleepEvent.getEntity());
  }
}
