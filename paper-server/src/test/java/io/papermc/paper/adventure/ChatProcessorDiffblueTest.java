package io.papermc.paper.adventure;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.server.ServerResourcesReloadedEvent;
import io.papermc.paper.plugin.PaperTestPlugin;
import io.papermc.paper.plugin.SyntheticEventTest;
import io.papermc.paper.plugin.SyntheticEventTest.Impl;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.RegisteredListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatProcessorDiffblueTest {
  /**
   * Test {@link ChatProcessor#canYouHearMe(HandlerList)}.
   *
   * <ul>
   *   <li>Given {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   * </ul>
   *
   * <p>Method under test: {@link ChatProcessor#canYouHearMe(HandlerList)}
   */
  @Test
  @DisplayName("Test canYouHearMe(HandlerList); given PaperTestPlugin(String) with 'Plugin Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChatProcessor.canYouHearMe(HandlerList)"})
  void testCanYouHearMe_givenPaperTestPluginWithPluginName() {
    // Arrange
    HandlerList handlers = ServerResourcesReloadedEvent.HANDLER_LIST;
    Impl listener = new Impl();
    EventExecutor executor = mock(EventExecutor.class);

    RegisteredListener listener2 =
        new RegisteredListener(
            listener, executor, EventPriority.LOWEST, new PaperTestPlugin("Plugin Name"), true);
    handlers.register(listener2);

    // Act and Assert
    assertTrue(ChatProcessor.canYouHearMe(handlers));
  }
}
