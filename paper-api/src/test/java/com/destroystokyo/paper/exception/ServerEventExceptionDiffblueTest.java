package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.TestEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerEventExceptionDiffblueTest {
  /**
   * Test {@link ServerEventException#ServerEventException(String, Throwable, Plugin, Listener,
   * Event)}.
   *
   * <ul>
   *   <li>Then Event return {@link TestEvent}.
   * </ul>
   *
   * <p>Method under test: {@link ServerEventException#ServerEventException(String, Throwable,
   * Plugin, Listener, Event)}
   */
  @Test
  @DisplayName(
      "Test new ServerEventException(String, Throwable, Plugin, Listener, Event); then Event return TestEvent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerEventException.<init>(String, Throwable, Plugin, Listener, Event)"
  })
  void testNewServerEventException_thenEventReturnTestEvent() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");
    Listener listener = mock(Listener.class);
    TestEvent event = new TestEvent(true);

    // Act
    ServerEventException actualServerEventException =
        new ServerEventException("An error occurred", cause, responsiblePlugin, listener, event);

    // Assert
    Event event2 = actualServerEventException.getEvent();
    assertTrue(event2 instanceof TestEvent);
    Plugin responsiblePlugin2 = actualServerEventException.getResponsiblePlugin();
    assertTrue(responsiblePlugin2 instanceof TestPlugin);
    assertEquals("An error occurred", actualServerEventException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerEventException.getMessage());
    assertEquals(0, actualServerEventException.getSuppressed().length);
    assertSame(cause, actualServerEventException.getCause());
    assertSame(event, event2);
    assertSame(responsiblePlugin, responsiblePlugin2);
    assertSame(listener, actualServerEventException.getListener());
  }

  /**
   * Test {@link ServerEventException#ServerEventException(String, Throwable, boolean, boolean,
   * Plugin, Listener, Event)}.
   *
   * <ul>
   *   <li>Then Event return {@link TestEvent}.
   * </ul>
   *
   * <p>Method under test: {@link ServerEventException#ServerEventException(String, Throwable,
   * boolean, boolean, Plugin, Listener, Event)}
   */
  @Test
  @DisplayName(
      "Test new ServerEventException(String, Throwable, boolean, boolean, Plugin, Listener, Event); then Event return TestEvent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerEventException.<init>(String, Throwable, boolean, boolean, Plugin, Listener, Event)"
  })
  void testNewServerEventException_thenEventReturnTestEvent2() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");
    Listener listener = mock(Listener.class);
    TestEvent event = new TestEvent(true);

    // Act
    ServerEventException actualServerEventException =
        new ServerEventException(
            "An error occurred", cause, true, true, responsiblePlugin, listener, event);

    // Assert
    Event event2 = actualServerEventException.getEvent();
    assertTrue(event2 instanceof TestEvent);
    Plugin responsiblePlugin2 = actualServerEventException.getResponsiblePlugin();
    assertTrue(responsiblePlugin2 instanceof TestPlugin);
    assertEquals("An error occurred", actualServerEventException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerEventException.getMessage());
    assertEquals(0, actualServerEventException.getSuppressed().length);
    assertSame(cause, actualServerEventException.getCause());
    assertSame(event, event2);
    assertSame(responsiblePlugin, responsiblePlugin2);
    assertSame(listener, actualServerEventException.getListener());
  }

  /**
   * Test {@link ServerEventException#ServerEventException(Throwable, Plugin, Listener, Event)}.
   *
   * <ul>
   *   <li>Then Event return {@link TestEvent}.
   * </ul>
   *
   * <p>Method under test: {@link ServerEventException#ServerEventException(Throwable, Plugin,
   * Listener, Event)}
   */
  @Test
  @DisplayName(
      "Test new ServerEventException(Throwable, Plugin, Listener, Event); then Event return TestEvent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerEventException.<init>(Throwable, Plugin, Listener, Event)"})
  void testNewServerEventException_thenEventReturnTestEvent3() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");
    Listener listener = mock(Listener.class);
    TestEvent event = new TestEvent(true);

    // Act
    ServerEventException actualServerEventException =
        new ServerEventException(cause, responsiblePlugin, listener, event);

    // Assert
    Event event2 = actualServerEventException.getEvent();
    assertTrue(event2 instanceof TestEvent);
    Plugin responsiblePlugin2 = actualServerEventException.getResponsiblePlugin();
    assertTrue(responsiblePlugin2 instanceof TestPlugin);
    assertEquals("java.lang.Throwable", actualServerEventException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerEventException.getMessage());
    assertEquals(0, actualServerEventException.getSuppressed().length);
    assertSame(cause, actualServerEventException.getCause());
    assertSame(event, event2);
    assertSame(responsiblePlugin, responsiblePlugin2);
    assertSame(listener, actualServerEventException.getListener());
  }
}
