package io.papermc.paper.plugin.manager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.PaperTestPlugin;
import io.papermc.paper.plugin.SyntheticEventTest;
import io.papermc.paper.plugin.SyntheticEventTest.Impl;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperEventManagerDiffblueTest {
  /**
   * Test {@link PaperEventManager#registerEvent(Class, Listener, EventPriority, EventExecutor,
   * Plugin)} with {@code event}, {@code listener}, {@code priority}, {@code executor}, {@code
   * plugin}.
   *
   * <p>Method under test: {@link PaperEventManager#registerEvent(Class, Listener, EventPriority,
   * EventExecutor, Plugin)}
   */
  @Test
  @DisplayName(
      "Test registerEvent(Class, Listener, EventPriority, EventExecutor, Plugin) with 'event', 'listener', 'priority', 'executor', 'plugin'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperEventManager.registerEvent(Class, Listener, EventPriority, EventExecutor, Plugin)"
  })
  void testRegisterEventWithEventListenerPriorityExecutorPlugin() {
    // Arrange
    PaperEventManager paperEventManager = new PaperEventManager(null);
    Class<Event> event = Event.class;
    Impl listener = new Impl();
    EventExecutor executor = mock(EventExecutor.class);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            paperEventManager.registerEvent(
                event,
                listener,
                EventPriority.LOWEST,
                executor,
                new PaperTestPlugin("Plugin Name")));
  }

  /**
   * Test {@link PaperEventManager#registerEvent(Class, Listener, EventPriority, EventExecutor,
   * Plugin, boolean)} with {@code event}, {@code listener}, {@code priority}, {@code executor},
   * {@code plugin}, {@code ignoreCancelled}.
   *
   * <p>Method under test: {@link PaperEventManager#registerEvent(Class, Listener, EventPriority,
   * EventExecutor, Plugin, boolean)}
   */
  @Test
  @DisplayName(
      "Test registerEvent(Class, Listener, EventPriority, EventExecutor, Plugin, boolean) with 'event', 'listener', 'priority', 'executor', 'plugin', 'ignoreCancelled'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperEventManager.registerEvent(Class, Listener, EventPriority, EventExecutor, Plugin, boolean)"
  })
  void testRegisterEventWithEventListenerPriorityExecutorPluginIgnoreCancelled() {
    // Arrange
    PaperEventManager paperEventManager = new PaperEventManager(null);
    Class<Event> event = Event.class;
    Impl listener = new Impl();
    EventExecutor executor = mock(EventExecutor.class);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            paperEventManager.registerEvent(
                event,
                listener,
                EventPriority.LOWEST,
                executor,
                new PaperTestPlugin("Plugin Name"),
                true));
  }
}
