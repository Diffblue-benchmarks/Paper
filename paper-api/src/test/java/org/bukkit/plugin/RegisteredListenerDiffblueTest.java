package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.event.block.AnvilDamagedEvent;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.TestEvent;
import org.bukkit.inventory.InventoryView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegisteredListenerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegisteredListener#RegisteredListener(Listener, EventExecutor, EventPriority,
   *       Plugin, boolean)}
   *   <li>{@link RegisteredListener#toString()}
   *   <li>{@link RegisteredListener#getExecutor()}
   *   <li>{@link RegisteredListener#getListener()}
   *   <li>{@link RegisteredListener#getPlugin()}
   *   <li>{@link RegisteredListener#getPriority()}
   *   <li>{@link RegisteredListener#isIgnoringCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegisteredListener.<init>(Listener, EventExecutor, EventPriority, Plugin, boolean)",
    "EventExecutor RegisteredListener.getExecutor()",
    "Listener RegisteredListener.getListener()",
    "Plugin RegisteredListener.getPlugin()",
    "EventPriority RegisteredListener.getPriority()",
    "boolean RegisteredListener.isIgnoringCancelled()",
    "java.lang.String RegisteredListener.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Listener listener = mock(Listener.class);
    EventExecutor executor = mock(EventExecutor.class);
    TestPlugin plugin = new TestPlugin("Plugin Name");

    // Act
    RegisteredListener actualRegisteredListener =
        new RegisteredListener(listener, executor, EventPriority.LOWEST, plugin, true);
    actualRegisteredListener.toString();
    EventExecutor actualExecutor = actualRegisteredListener.getExecutor();
    Listener actualListener = actualRegisteredListener.getListener();
    Plugin actualPlugin = actualRegisteredListener.getPlugin();
    EventPriority actualPriority = actualRegisteredListener.getPriority();

    // Assert
    assertEquals(EventPriority.LOWEST, actualPriority);
    assertTrue(actualRegisteredListener.isIgnoringCancelled());
    assertSame(plugin, actualPlugin);
    assertSame(listener, actualListener);
    assertSame(executor, actualExecutor);
  }

  /**
   * Test {@link RegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Given {@link EventExecutor} {@link EventExecutor#execute(Listener, Event)} does nothing.
   *   <li>When {@link TestEvent#TestEvent(boolean)} with async is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName(
      "Test callEvent(Event); given EventExecutor execute(Listener, Event) does nothing; when TestEvent(boolean) with async is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegisteredListener.callEvent(Event)"})
  void testCallEvent_givenEventExecutorExecuteDoesNothing_whenTestEventWithAsyncIsTrue()
      throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener listener = mock(Listener.class);

    RegisteredListener registeredListener =
        new RegisteredListener(
            listener, executor, EventPriority.LOWEST, new TestPlugin("Plugin Name"), true);

    // Act
    registeredListener.callEvent(new TestEvent(true));

    // Assert
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link RegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegisteredListener.callEvent(Event)"})
  void testCallEvent_givenFalse() throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener listener = mock(Listener.class);

    RegisteredListener registeredListener =
        new RegisteredListener(
            listener, executor, EventPriority.LOWEST, new TestPlugin("Plugin Name"), false);

    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent event = new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    event.setCancelled(false);

    // Act
    registeredListener.callEvent(event);

    // Assert
    verify(blockData).getMaterial();
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link RegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegisteredListener.callEvent(Event)"})
  void testCallEvent_givenTrue() throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doNothing().when(executor).execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener listener = mock(Listener.class);

    RegisteredListener registeredListener =
        new RegisteredListener(
            listener, executor, EventPriority.LOWEST, new TestPlugin("Plugin Name"), false);

    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent event = new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    event.setCancelled(true);

    // Act
    registeredListener.callEvent(event);

    // Assert
    verify(blockData).getMaterial();
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }

  /**
   * Test {@link RegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegisteredListener.callEvent(Event)"})
  void testCallEvent_givenTrue2() throws EventException {
    // Arrange
    Listener listener = mock(Listener.class);
    EventExecutor executor = mock(EventExecutor.class);

    RegisteredListener registeredListener =
        new RegisteredListener(
            listener, executor, EventPriority.LOWEST, new TestPlugin("Plugin Name"), true);

    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent event = new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    event.setCancelled(true);

    // Act
    registeredListener.callEvent(event);

    // Assert
    verify(blockData).getMaterial();
  }

  /**
   * Test {@link RegisteredListener#callEvent(Event)}.
   *
   * <ul>
   *   <li>Then throw {@link EventException}.
   * </ul>
   *
   * <p>Method under test: {@link RegisteredListener#callEvent(Event)}
   */
  @Test
  @DisplayName("Test callEvent(Event); then throw EventException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegisteredListener.callEvent(Event)"})
  void testCallEvent_thenThrowEventException() throws EventException {
    // Arrange
    EventExecutor executor = mock(EventExecutor.class);
    doThrow(new EventException("An error occurred"))
        .when(executor)
        .execute(Mockito.<Listener>any(), Mockito.<Event>any());
    Listener listener = mock(Listener.class);

    RegisteredListener registeredListener =
        new RegisteredListener(
            listener, executor, EventPriority.LOWEST, new TestPlugin("Plugin Name"), false);

    BlockData blockData = mock(BlockData.class);
    when(blockData.getMaterial()).thenReturn(Material.AIR);

    AnvilDamagedEvent event = new AnvilDamagedEvent(mock(InventoryView.class), blockData);
    event.setCancelled(false);

    // Act and Assert
    assertThrows(EventException.class, () -> registeredListener.callEvent(event));
    verify(blockData).getMaterial();
    verify(executor).execute(isA(Listener.class), isA(Event.class));
  }
}
