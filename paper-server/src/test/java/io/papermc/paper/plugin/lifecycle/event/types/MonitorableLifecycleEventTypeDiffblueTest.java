package io.papermc.paper.plugin.lifecycle.event.types;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.AbstractLifecycleEventHandlerConfiguration;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.MonitorLifecycleEventHandlerConfigurationImpl;
import io.papermc.paper.plugin.lifecycle.event.registrar.PaperRegistrar;
import io.papermc.paper.plugin.lifecycle.event.registrar.RegistrarEventImpl;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType.RegisteredHandler;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MonitorableLifecycleEventTypeDiffblueTest {
  /**
   * Test {@link MonitorableLifecycleEventType#MonitorableLifecycleEventType(String, Class)}.
   *
   * <p>Method under test: {@link
   * MonitorableLifecycleEventType#MonitorableLifecycleEventType(String, Class)}
   */
  @Test
  @DisplayName("Test new MonitorableLifecycleEventType(String, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MonitorableLifecycleEventType.<init>(String, Class)"})
  void testNewMonitorableLifecycleEventType() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    // Act
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        actualMonitorableLifecycleEventType =
            new MonitorableLifecycleEventType<>("Name", ownerType);

    // Assert
    assertEquals("Name", actualMonitorableLifecycleEventType.name());
    assertEquals(0, actualMonitorableLifecycleEventType.nonMonitorIdx);
    assertFalse(actualMonitorableLifecycleEventType.hasHandlers());
    assertTrue(actualMonitorableLifecycleEventType.handlers.isEmpty());
  }

  /**
   * Test {@link MonitorableLifecycleEventType#hasHandlers()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#hasHandlers()}
   */
  @Test
  @DisplayName("Test hasHandlers(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonitorableLifecycleEventType.hasHandlers()"})
  void testHasHandlers_thenReturnFalse() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);

    // Act and Assert
    assertFalse(monitorableLifecycleEventType.hasHandlers());
  }

  /**
   * Test {@link MonitorableLifecycleEventType#hasHandlers()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#hasHandlers()}
   */
  @Test
  @DisplayName("Test hasHandlers(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MonitorableLifecycleEventType.hasHandlers()"})
  void testHasHandlers_thenReturnTrue() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    monitorableLifecycleEventType.register(lifecycleEventOwner, config);

    // Act and Assert
    assertTrue(monitorableLifecycleEventType.hasHandlers());
  }

  /**
   * Test {@link MonitorableLifecycleEventType#newHandler(LifecycleEventHandler)}.
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#newHandler(LifecycleEventHandler)}
   */
  @Test
  @DisplayName("Test newHandler(LifecycleEventHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MonitorLifecycleEventHandlerConfigurationImpl MonitorableLifecycleEventType.newHandler(LifecycleEventHandler)"
  })
  void testNewHandler() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);

    // Act
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        actualNewHandlerResult = monitorableLifecycleEventType.newHandler(handler);

    // Assert
    assertFalse(actualNewHandlerResult.isMonitor());
    assertSame(handler, actualNewHandlerResult.handler());
  }

  /**
   * Test {@link MonitorableLifecycleEventType#register(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}.
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#register(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName("Test register(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.register(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)"
  })
  void testRegister() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    // Act
    monitorableLifecycleEventType.register(lifecycleEventOwner, config);

    // Assert
    List<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> registeredHandlerList =
        monitorableLifecycleEventType.handlers;
    assertEquals(1, registeredHandlerList.size());
    assertEquals(1, monitorableLifecycleEventType.nonMonitorIdx);
    assertTrue(monitorableLifecycleEventType.hasHandlers());
    RegisteredHandler<LifecycleEventOwner, LifecycleEvent> getResult = registeredHandlerList.get(0);
    assertSame(config, getResult.config());
    assertSame(lifecycleEventOwner, getResult.owner());
  }

  /**
   * Test {@link MonitorableLifecycleEventType#register(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#register(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName(
      "Test register(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.register(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)"
  })
  void testRegister_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> monitorableLifecycleEventType.register(mock(LifecycleEventOwner.class), null));
  }

  /**
   * Test {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent, Consumer, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent,
   * Consumer, Predicate)}
   */
  @Test
  @DisplayName(
      "Test forEachHandler(LifecycleEvent, Consumer, Predicate); given 'false'; when Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.forEachHandler(LifecycleEvent, Consumer, Predicate)"
  })
  void testForEachHandler_givenFalse_whenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    monitorableLifecycleEventType.register(lifecycleEventOwner, config);
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);
    Consumer<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> consumer =
        mock(Consumer.class);

    Predicate<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> predicate =
        mock(Predicate.class);
    when(predicate.test(Mockito.<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>>any()))
        .thenReturn(false);

    // Act
    monitorableLifecycleEventType.forEachHandler(registrarEventImpl, consumer, predicate);

    // Assert
    verify(predicate).test(isA(RegisteredHandler.class));
  }

  /**
   * Test {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent, Consumer, Predicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent,
   * Consumer, Predicate)}
   */
  @Test
  @DisplayName(
      "Test forEachHandler(LifecycleEvent, Consumer, Predicate); given 'true'; when Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.forEachHandler(LifecycleEvent, Consumer, Predicate)"
  })
  void testForEachHandler_givenTrue_whenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    monitorableLifecycleEventType.register(lifecycleEventOwner, config);
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);

    Consumer<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> consumer =
        mock(Consumer.class);
    doNothing()
        .when(consumer)
        .accept(Mockito.<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>>any());

    Predicate<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> predicate =
        mock(Predicate.class);
    when(predicate.test(Mockito.<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>>any()))
        .thenReturn(true);

    // Act
    monitorableLifecycleEventType.forEachHandler(registrarEventImpl, consumer, predicate);

    // Assert
    verify(consumer).accept(isA(RegisteredHandler.class));
    verify(predicate).test(isA(RegisteredHandler.class));
  }

  /**
   * Test {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent, Consumer, Predicate)}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent,
   * Consumer, Predicate)}
   */
  @Test
  @DisplayName(
      "Test forEachHandler(LifecycleEvent, Consumer, Predicate); when Consumer accept(Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.forEachHandler(LifecycleEvent, Consumer, Predicate)"
  })
  void testForEachHandler_whenConsumerAcceptThrowIllegalArgumentException() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    monitorableLifecycleEventType.register(lifecycleEventOwner, config);
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);

    Consumer<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> consumer =
        mock(Consumer.class);
    doThrow(new IllegalArgumentException())
        .when(consumer)
        .accept(Mockito.<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>>any());

    Predicate<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> predicate =
        mock(Predicate.class);
    when(predicate.test(Mockito.<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            monitorableLifecycleEventType.forEachHandler(registrarEventImpl, consumer, predicate));
    verify(consumer).accept(isA(RegisteredHandler.class));
    verify(predicate).test(isA(RegisteredHandler.class));
  }

  /**
   * Test {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent, Consumer, Predicate)}.
   *
   * <ul>
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent,
   * Consumer, Predicate)}
   */
  @Test
  @DisplayName(
      "Test forEachHandler(LifecycleEvent, Consumer, Predicate); when Predicate test(Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.forEachHandler(LifecycleEvent, Consumer, Predicate)"
  })
  void testForEachHandler_whenPredicateTestThrowIllegalArgumentException() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    MonitorLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new MonitorLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    monitorableLifecycleEventType.register(lifecycleEventOwner, config);
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    RegistrarEventImpl<PaperRegistrar<? super LifecycleEventOwner>, LifecycleEventOwner>
        registrarEventImpl = new RegistrarEventImpl<>(paperRegistrar, ownerClass);
    Consumer<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> consumer =
        mock(Consumer.class);

    Predicate<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>> predicate =
        mock(Predicate.class);
    when(predicate.test(Mockito.<RegisteredHandler<LifecycleEventOwner, LifecycleEvent>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            monitorableLifecycleEventType.forEachHandler(registrarEventImpl, consumer, predicate));
    verify(predicate).test(isA(RegisteredHandler.class));
  }

  /**
   * Test {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent, Consumer, Predicate)}.
   *
   * <ul>
   *   <li>When {@link Predicate}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MonitorableLifecycleEventType#forEachHandler(LifecycleEvent,
   * Consumer, Predicate)}
   */
  @Test
  @DisplayName(
      "Test forEachHandler(LifecycleEvent, Consumer, Predicate); when Predicate; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MonitorableLifecycleEventType.forEachHandler(LifecycleEvent, Consumer, Predicate)"
  })
  void testForEachHandler_whenPredicate_thenDoesNotThrow() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>
        monitorableLifecycleEventType = new MonitorableLifecycleEventType<>("Name", ownerType);
    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act and Assert
    assertDoesNotThrow(
        () ->
            monitorableLifecycleEventType.forEachHandler(
                new RegistrarEventImpl<>(paperRegistrar, ownerClass),
                mock(Consumer.class),
                mock(Predicate.class)));
  }
}
