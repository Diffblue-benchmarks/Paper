package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.TestEvent;
import org.bukkit.event.block.BellRingEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TimedRegisteredListenerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimedRegisteredListener#TimedRegisteredListener(Listener, EventExecutor,
   *       EventPriority, Plugin, boolean)}
   *   <li>{@link TimedRegisteredListener#getCount()}
   *   <li>{@link TimedRegisteredListener#getEventClass()}
   *   <li>{@link TimedRegisteredListener#getTotalTime()}
   *   <li>{@link TimedRegisteredListener#hasMultiple()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimedRegisteredListener.<init>(Listener, EventExecutor, EventPriority, Plugin, boolean)",
    "int TimedRegisteredListener.getCount()",
    "Class TimedRegisteredListener.getEventClass()",
    "long TimedRegisteredListener.getTotalTime()",
    "boolean TimedRegisteredListener.hasMultiple()"
  })
  void testGettersAndSetters() {
    // Arrange
    Listener pluginListener = mock(Listener.class);
    EventExecutor eventExecutor = mock(EventExecutor.class);
    TestPlugin registeredPlugin = new TestPlugin("Plugin Name");

    // Act
    TimedRegisteredListener actualTimedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener, eventExecutor, EventPriority.LOWEST, registeredPlugin, true);
    int actualCount = actualTimedRegisteredListener.getCount();
    Class<? extends Event> actualEventClass = actualTimedRegisteredListener.getEventClass();
    long actualTotalTime = actualTimedRegisteredListener.getTotalTime();
    boolean actualHasMultipleResult = actualTimedRegisteredListener.hasMultiple();

    // Assert
    assertNull(actualEventClass);
    assertEquals(0, actualCount);
    assertEquals(0L, actualTotalTime);
    assertEquals(EventPriority.LOWEST, actualTimedRegisteredListener.getPriority());
    assertFalse(actualHasMultipleResult);
    assertTrue(actualTimedRegisteredListener.isIgnoringCancelled());
    assertSame(registeredPlugin, actualTimedRegisteredListener.getPlugin());
    assertSame(pluginListener, actualTimedRegisteredListener.getListener());
    assertSame(eventExecutor, actualTimedRegisteredListener.getExecutor());
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent() throws EventException {
    // Arrange
    EventExecutor eventExecutor = mock(EventExecutor.class);
    doNothing().when(eventExecutor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener pluginListener = mock(Listener.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            true);

    // Act
    timedRegisteredListener.callEvent(new TestEvent(true));

    // Assert that nothing has changed
    verify(eventExecutor).execute(isA(Listener.class), isA(Event.class));
    assertEquals(0, timedRegisteredListener.getCount());
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent2() throws EventException {
    // Arrange
    EventExecutor eventExecutor = mock(EventExecutor.class);
    doNothing().when(eventExecutor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener pluginListener = mock(Listener.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            true);

    // Act
    timedRegisteredListener.callEvent(new TestEvent(false));

    // Assert
    verify(eventExecutor).execute(isA(Listener.class), isA(Event.class));
    assertEquals(1, timedRegisteredListener.getCount());
    Class<TestEvent> expectedEventClass = TestEvent.class;
    assertEquals(expectedEventClass, timedRegisteredListener.getEventClass());
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent3() throws EventException {
    // Arrange
    Listener pluginListener = mock(Listener.class);
    EventExecutor eventExecutor = mock(EventExecutor.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            true);

    BellRingEvent event = new BellRingEvent(mock(Block.class), BlockFace.NORTH, mock(Entity.class));
    event.setCancelled(true);

    // Act
    timedRegisteredListener.callEvent(event);

    // Assert
    assertEquals(1, timedRegisteredListener.getCount());
    Class<BellRingEvent> expectedEventClass = BellRingEvent.class;
    assertEquals(expectedEventClass, timedRegisteredListener.getEventClass());
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent4() throws EventException {
    // Arrange
    EventExecutor eventExecutor = mock(EventExecutor.class);
    doNothing().when(eventExecutor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener pluginListener = mock(Listener.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            false);

    BellRingEvent event = new BellRingEvent(mock(Block.class), BlockFace.NORTH, mock(Entity.class));
    event.setCancelled(true);

    // Act
    timedRegisteredListener.callEvent(event);

    // Assert
    verify(eventExecutor).execute(isA(Listener.class), isA(Event.class));
    assertEquals(1, timedRegisteredListener.getCount());
    Class<BellRingEvent> expectedEventClass = BellRingEvent.class;
    assertEquals(expectedEventClass, timedRegisteredListener.getEventClass());
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Then throw {@link EventException}.
   * </ul>
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event); then throw EventException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent_thenThrowEventException() throws EventException {
    // Arrange
    EventExecutor eventExecutor = mock(EventExecutor.class);
    doThrow(new EventException("An error occurred"))
        .when(eventExecutor)
        .execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener pluginListener = mock(Listener.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            true);

    // Act and Assert
    assertThrows(
        EventException.class, () -> timedRegisteredListener.callEvent(new TestEvent(true)));
    verify(eventExecutor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Then throw {@link EventException}.
   * </ul>
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event); then throw EventException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent_thenThrowEventException2() throws EventException {
    // Arrange
    EventExecutor eventExecutor = mock(EventExecutor.class);
    doThrow(new EventException("An error occurred"))
        .when(eventExecutor)
        .execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener pluginListener = mock(Listener.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            true);

    // Act and Assert
    assertThrows(
        EventException.class, () -> timedRegisteredListener.callEvent(new TestEvent(false)));
    verify(eventExecutor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link TimedRegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>When {@link BellRingEvent#BellRingEvent(Block, BlockFace, Entity)} with {@link Block} and
   *       direction is {@code NORTH} and {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link TimedRegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName(
      "Test callEvent(Event); when BellRingEvent(Block, BlockFace, Entity) with Block and direction is 'NORTH' and Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedRegisteredListener.callEvent(Event)"})
  void testCallEvent_whenBellRingEventWithBlockAndDirectionIsNorthAndEntity()
      throws EventException {
    // Arrange
    EventExecutor eventExecutor = mock(EventExecutor.class);
    doNothing().when(eventExecutor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener pluginListener = mock(Listener.class);

    TimedRegisteredListener timedRegisteredListener =
        new TimedRegisteredListener(
            pluginListener,
            eventExecutor,
            EventPriority.LOWEST,
            new TestPlugin("Plugin Name"),
            true);
    BellRingEvent event = new BellRingEvent(mock(Block.class), BlockFace.NORTH, mock(Entity.class));

    // Act
    timedRegisteredListener.callEvent(event);

    // Assert
    verify(eventExecutor).execute(isA(Listener.class), isA(Event.class));
    assertEquals(1, timedRegisteredListener.getCount());
    Class<BellRingEvent> expectedEventClass = BellRingEvent.class;
    assertEquals(expectedEventClass, timedRegisteredListener.getEventClass());
  }
}
