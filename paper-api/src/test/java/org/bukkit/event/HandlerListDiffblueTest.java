package org.bukkit.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.server.ServerResourcesReloadedEvent;
import org.bukkit.plugin.RegisteredListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HandlerListDiffblueTest {
  /**
   * Test new {@link HandlerList} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link HandlerList}
   */
  @Test
  @DisplayName("Test new HandlerList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HandlerList.<init>()"})
  void testNewHandlerList() {
    // Arrange, Act and Assert
    assertEquals(0, new HandlerList().getRegisteredListeners().length);
  }

  /**
   * Test {@link HandlerList#register(RegisteredListener)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link HandlerList#register(RegisteredListener)}
   */
  @Test
  @DisplayName(
      "Test register(RegisteredListener); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HandlerList.register(RegisteredListener)"})
  void testRegister_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    RegisteredListener listener = mock(RegisteredListener.class);
    when(listener.getPriority()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> ServerResourcesReloadedEvent.HANDLER_LIST.register(listener));
    verify(listener).getPriority();
  }

  /**
   * Test {@link HandlerList#unregister(RegisteredListener)} with {@code RegisteredListener}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link HandlerList#unregister(RegisteredListener)}
   */
  @Test
  @DisplayName(
      "Test unregister(RegisteredListener) with 'RegisteredListener'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HandlerList.unregister(RegisteredListener)"})
  void testUnregisterWithRegisteredListener_thenThrowIllegalStateException() {
    // Arrange
    RegisteredListener listener = mock(RegisteredListener.class);
    when(listener.getPriority()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> ServerResourcesReloadedEvent.HANDLER_LIST.unregister(listener));
    verify(listener).getPriority();
  }
}
