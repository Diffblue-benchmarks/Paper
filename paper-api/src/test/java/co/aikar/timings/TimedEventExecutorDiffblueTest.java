package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Method;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.event.TestEvent;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TimedEventExecutorDiffblueTest {
  /**
   * Test {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin, Method, Class)}.
   *
   * <p>Method under test: {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin,
   * Method, Class)}
   */
  @Test
  @DisplayName("Test new TimedEventExecutor(EventExecutor, Plugin, Method, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.<init>(EventExecutor, Plugin, Method, Class)"})
  void testNewTimedEventExecutor() {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Class<Event> eventClass = Event.class;

    // Act
    new TimedEventExecutor(executor, plugin, null, eventClass);

    // Assert that nothing has changed
    assertTrue(plugin.getPluginMeta() instanceof PluginDescriptionFile);
    assertEquals("Plugin_Name", plugin.getName());
    assertEquals("plugin_name", plugin.namespace());
    assertTrue(plugin.isEnabled());
  }

  /**
   * Test {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin, Method, Class)}.
   *
   * <p>Method under test: {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin,
   * Method, Class)}
   */
  @Test
  @DisplayName("Test new TimedEventExecutor(EventExecutor, Plugin, Method, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.<init>(EventExecutor, Plugin, Method, Class)"})
  void testNewTimedEventExecutor2() throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Class<Event> eventClass = Event.class;

    // Act
    TimedEventExecutor actualTimedEventExecutor =
        new TimedEventExecutor(executor, null, null, eventClass);
    Listener listener = mock(Listener.class);
    ServerTickStartEvent event = new ServerTickStartEvent(10);
    actualTimedEventExecutor.execute(listener, event);

    // Assert that nothing has changed
    verify(executor).execute(isA(Listener.class), isA(Event.class));
    assertEquals("ServerTickStartEvent", event.getEventName());
    assertEquals(0, event.getHandlers().getRegisteredListeners().length);
    assertEquals(10, event.getTickNumber());
    assertFalse(event.isAsynchronous());
  }

  /**
   * Test {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin, Method, Class)}.
   *
   * <ul>
   *   <li>Then {@link TestEvent#TestEvent(boolean)} with async is {@code true} EventName is {@code
   *       TestEvent}.
   * </ul>
   *
   * <p>Method under test: {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin,
   * Method, Class)}
   */
  @Test
  @DisplayName(
      "Test new TimedEventExecutor(EventExecutor, Plugin, Method, Class); then TestEvent(boolean) with async is 'true' EventName is 'TestEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.<init>(EventExecutor, Plugin, Method, Class)"})
  void testNewTimedEventExecutor_thenTestEventWithAsyncIsTrueEventNameIsTestEvent()
      throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Class<Event> eventClass = Event.class;

    // Act
    TimedEventExecutor actualTimedEventExecutor =
        new TimedEventExecutor(executor, null, null, eventClass);
    Listener listener = mock(Listener.class);
    TestEvent event = new TestEvent(true);
    actualTimedEventExecutor.execute(listener, event);

    // Assert that nothing has changed
    verify(executor).execute(isA(Listener.class), isA(Event.class));
    assertEquals("TestEvent", event.getEventName());
    assertEquals(0, event.getHandlers().getRegisteredListeners().length);
    assertTrue(event.isAsynchronous());
  }

  /**
   * Test {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin, Method, Class)}.
   *
   * <ul>
   *   <li>When {@link EventExecutor}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimedEventExecutor#TimedEventExecutor(EventExecutor, Plugin,
   * Method, Class)}
   */
  @Test
  @DisplayName(
      "Test new TimedEventExecutor(EventExecutor, Plugin, Method, Class); when EventExecutor; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.<init>(EventExecutor, Plugin, Method, Class)"})
  void testNewTimedEventExecutor_whenEventExecutor_thenNull() {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    Class<Event> eventClass = Event.class;

    // Act
    new TimedEventExecutor(executor, null, null, eventClass);

    // Assert that nothing has changed
    assertNull(null);
    assertNull(null);
  }

  /**
   * Test {@link TimedEventExecutor#execute(Listener, Event)}.
   *
   * <ul>
   *   <li>Given {@link EventExecutor} {@link EventExecutor#execute(Listener, Event)} does nothing.
   *   <li>When {@link TestEvent#TestEvent(boolean)} with async is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimedEventExecutor#execute(Listener, Event)}
   */
  @Test
  @DisplayName(
      "Test execute(Listener, Event); given EventExecutor execute(Listener, Event) does nothing; when TestEvent(boolean) with async is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.execute(Listener, Event)"})
  void testExecute_givenEventExecutorExecuteDoesNothing_whenTestEventWithAsyncIsFalse()
      throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Class<Event> eventClass = Event.class;

    TimedEventExecutor timedEventExecutor =
        new TimedEventExecutor(executor, plugin, null, eventClass);
    Listener listener = mock(Listener.class);

    // Act
    timedEventExecutor.execute(listener, new TestEvent(false));

    // Assert
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link TimedEventExecutor#execute(Listener, Event)}.
   *
   * <ul>
   *   <li>Given {@link EventExecutor} {@link EventExecutor#execute(Listener, Event)} does nothing.
   *   <li>When {@link TestEvent#TestEvent(boolean)} with async is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimedEventExecutor#execute(Listener, Event)}
   */
  @Test
  @DisplayName(
      "Test execute(Listener, Event); given EventExecutor execute(Listener, Event) does nothing; when TestEvent(boolean) with async is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.execute(Listener, Event)"})
  void testExecute_givenEventExecutorExecuteDoesNothing_whenTestEventWithAsyncIsTrue()
      throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Class<Event> eventClass = Event.class;

    TimedEventExecutor timedEventExecutor =
        new TimedEventExecutor(executor, plugin, null, eventClass);
    Listener listener = mock(Listener.class);

    // Act
    timedEventExecutor.execute(listener, new TestEvent(true));

    // Assert
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link TimedEventExecutor#execute(Listener, Event)}.
   *
   * <ul>
   *   <li>Then throw {@link EventException}.
   * </ul>
   *
   * <p>Method under test: {@link TimedEventExecutor#execute(Listener, Event)}
   */
  @Test
  @DisplayName("Test execute(Listener, Event); then throw EventException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedEventExecutor.execute(Listener, Event)"})
  void testExecute_thenThrowEventException() throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doThrow(new EventException("An error occurred"))
        .when(executor)
        .execute(Mockito.<Listener>any(), Mockito.<Event>any());
    TestPlugin plugin = new TestPlugin("Plugin Name");
    Class<Event> eventClass = Event.class;

    TimedEventExecutor timedEventExecutor =
        new TimedEventExecutor(executor, plugin, null, eventClass);
    Listener listener = mock(Listener.class);

    // Act and Assert
    assertThrows(
        EventException.class, () -> timedEventExecutor.execute(listener, new TestEvent(true)));
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }
}
