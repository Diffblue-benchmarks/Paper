package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.FishHook.HookState;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FishHookStateChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FishHookStateChangeEvent#FishHookStateChangeEvent(FishHook, FishHook.HookState)}
   *   <li>{@link FishHookStateChangeEvent#getHandlerList()}
   *   <li>{@link FishHookStateChangeEvent#getHandlers()}
   *   <li>{@link FishHookStateChangeEvent#getNewHookState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FishHookStateChangeEvent.<init>(FishHook, FishHook.HookState)",
    "HandlerList FishHookStateChangeEvent.getHandlerList()",
    "HandlerList FishHookStateChangeEvent.getHandlers()",
    "FishHook.HookState FishHookStateChangeEvent.getNewHookState()"
  })
  void testGettersAndSetters() {
    // Arrange
    FishHook entity = mock(FishHook.class);

    // Act
    FishHookStateChangeEvent actualFishHookStateChangeEvent =
        new FishHookStateChangeEvent(entity, HookState.UNHOOKED);
    HandlerList actualHandlerList = actualFishHookStateChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualFishHookStateChangeEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(HookState.UNHOOKED, actualFishHookStateChangeEvent.getNewHookState());
    assertFalse(actualFishHookStateChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualFishHookStateChangeEvent.getEntity());
  }
}
