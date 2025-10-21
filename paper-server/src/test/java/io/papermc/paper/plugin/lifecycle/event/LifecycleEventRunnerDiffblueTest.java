package io.papermc.paper.plugin.lifecycle.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.registrar.PaperRegistrar;
import io.papermc.paper.plugin.lifecycle.event.registrar.RegistrarEventImpl;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.MonitorableLifecycleEventType;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LifecycleEventRunnerDiffblueTest {
  /**
   * Test {@link LifecycleEventRunner#checkRegisteredHandler(LifecycleEventOwner,
   * AbstractLifecycleEventType)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#checkRegisteredHandler(LifecycleEventOwner,
   * AbstractLifecycleEventType)}
   */
  @Test
  @DisplayName(
      "Test checkRegisteredHandler(LifecycleEventOwner, AbstractLifecycleEventType); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.checkRegisteredHandler(LifecycleEventOwner, AbstractLifecycleEventType)"
  })
  void testCheckRegisteredHandler_givenFalse() {
    // Arrange
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);

    AbstractLifecycleEventType<LifecycleEventOwner, ?, ?> eventType =
        mock(AbstractLifecycleEventType.class);
    when(eventType.blocksReloading(Mockito.<LifecycleEventOwner>any())).thenReturn(false);

    // Act
    LifecycleEventRunner.INSTANCE.checkRegisteredHandler(lifecycleEventOwner, eventType);

    // Assert
    verify(eventType).blocksReloading(isA(LifecycleEventOwner.class));
  }

  /**
   * Test {@link LifecycleEventRunner#checkRegisteredHandler(LifecycleEventOwner,
   * AbstractLifecycleEventType)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#checkRegisteredHandler(LifecycleEventOwner,
   * AbstractLifecycleEventType)}
   */
  @Test
  @DisplayName(
      "Test checkRegisteredHandler(LifecycleEventOwner, AbstractLifecycleEventType); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.checkRegisteredHandler(LifecycleEventOwner, AbstractLifecycleEventType)"
  })
  void testCheckRegisteredHandler_givenTrue() {
    // Arrange
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);

    AbstractLifecycleEventType<LifecycleEventOwner, ?, ?> eventType =
        mock(AbstractLifecycleEventType.class);
    when(eventType.blocksReloading(Mockito.<LifecycleEventOwner>any())).thenReturn(true);

    // Act
    LifecycleEventRunner.INSTANCE.checkRegisteredHandler(lifecycleEventOwner, eventType);

    // Assert
    verify(eventType).blocksReloading(isA(LifecycleEventOwner.class));
  }

  /**
   * Test {@link LifecycleEventRunner#checkRegisteredHandler(LifecycleEventOwner,
   * AbstractLifecycleEventType)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#checkRegisteredHandler(LifecycleEventOwner,
   * AbstractLifecycleEventType)}
   */
  @Test
  @DisplayName(
      "Test checkRegisteredHandler(LifecycleEventOwner, AbstractLifecycleEventType); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.checkRegisteredHandler(LifecycleEventOwner, AbstractLifecycleEventType)"
  })
  void testCheckRegisteredHandler_thenThrowIllegalStateException() {
    // Arrange
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);

    AbstractLifecycleEventType<LifecycleEventOwner, ?, ?> eventType =
        mock(AbstractLifecycleEventType.class);
    when(eventType.blocksReloading(Mockito.<LifecycleEventOwner>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> LifecycleEventRunner.INSTANCE.checkRegisteredHandler(lifecycleEventOwner, eventType));
    verify(eventType).blocksReloading(isA(LifecycleEventOwner.class));
  }

  /**
   * Test {@link LifecycleEventRunner#blocksPluginReloading()}.
   *
   * <p>Method under test: {@link LifecycleEventRunner#blocksPluginReloading()}
   */
  @Test
  @DisplayName("Test blocksPluginReloading()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LifecycleEventRunner.blocksPluginReloading()"})
  void testBlocksPluginReloading() {
    // Arrange, Act and Assert
    assertFalse(LifecycleEventRunner.INSTANCE.blocksPluginReloading());
  }

  /**
   * Test {@link LifecycleEventRunner#callEvent(LifecycleEventType, PaperLifecycleEvent, Predicate)}
   * with {@code eventType}, {@code event}, {@code ownerPredicate}.
   *
   * <ul>
   *   <li>Then calls {@link PaperRegistrar#invalidate()}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#callEvent(LifecycleEventType,
   * PaperLifecycleEvent, Predicate)}
   */
  @Test
  @DisplayName(
      "Test callEvent(LifecycleEventType, PaperLifecycleEvent, Predicate) with 'eventType', 'event', 'ownerPredicate'; then calls invalidate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.callEvent(LifecycleEventType, PaperLifecycleEvent, Predicate)"
  })
  void testCallEventWithEventTypeEventOwnerPredicate_thenCallsInvalidate() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, ? super PaperLifecycleEvent> eventType =
        new MonitorableLifecycleEventType<>("Name", ownerType);

    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    doNothing().when(paperRegistrar).invalidate();
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act
    LifecycleEventRunner.INSTANCE.callEvent(
        eventType, new RegistrarEventImpl<>(paperRegistrar, ownerClass), mock(Predicate.class));

    // Assert
    verify(paperRegistrar).invalidate();
  }

  /**
   * Test {@link LifecycleEventRunner#callEvent(LifecycleEventType, PaperLifecycleEvent, Predicate)}
   * with {@code eventType}, {@code event}, {@code ownerPredicate}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#callEvent(LifecycleEventType,
   * PaperLifecycleEvent, Predicate)}
   */
  @Test
  @DisplayName(
      "Test callEvent(LifecycleEventType, PaperLifecycleEvent, Predicate) with 'eventType', 'event', 'ownerPredicate'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.callEvent(LifecycleEventType, PaperLifecycleEvent, Predicate)"
  })
  void testCallEventWithEventTypeEventOwnerPredicate_thenThrowIllegalStateException() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, ? super PaperLifecycleEvent> eventType =
        new MonitorableLifecycleEventType<>("Name", ownerType);

    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    doThrow(new IllegalStateException()).when(paperRegistrar).invalidate();
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            LifecycleEventRunner.INSTANCE.callEvent(
                eventType,
                new RegistrarEventImpl<>(paperRegistrar, ownerClass),
                mock(Predicate.class)));
    verify(paperRegistrar).invalidate();
  }

  /**
   * Test {@link LifecycleEventRunner#callEvent(LifecycleEventType, PaperLifecycleEvent)} with
   * {@code eventType}, {@code event}.
   *
   * <ul>
   *   <li>Then calls {@link PaperRegistrar#invalidate()}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#callEvent(LifecycleEventType,
   * PaperLifecycleEvent)}
   */
  @Test
  @DisplayName(
      "Test callEvent(LifecycleEventType, PaperLifecycleEvent) with 'eventType', 'event'; then calls invalidate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.callEvent(LifecycleEventType, PaperLifecycleEvent)"
  })
  void testCallEventWithEventTypeEvent_thenCallsInvalidate() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, ? super PaperLifecycleEvent> eventType =
        new MonitorableLifecycleEventType<>("Name", ownerType);

    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    doNothing().when(paperRegistrar).invalidate();
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act
    LifecycleEventRunner.INSTANCE.callEvent(
        eventType, new RegistrarEventImpl<>(paperRegistrar, ownerClass));

    // Assert
    verify(paperRegistrar).invalidate();
  }

  /**
   * Test {@link LifecycleEventRunner#callEvent(LifecycleEventType, PaperLifecycleEvent)} with
   * {@code eventType}, {@code event}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link LifecycleEventRunner#callEvent(LifecycleEventType,
   * PaperLifecycleEvent)}
   */
  @Test
  @DisplayName(
      "Test callEvent(LifecycleEventType, PaperLifecycleEvent) with 'eventType', 'event'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LifecycleEventRunner.callEvent(LifecycleEventType, PaperLifecycleEvent)"
  })
  void testCallEventWithEventTypeEvent_thenThrowIllegalStateException() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    MonitorableLifecycleEventType<LifecycleEventOwner, ? super PaperLifecycleEvent> eventType =
        new MonitorableLifecycleEventType<>("Name", ownerType);

    PaperRegistrar<LifecycleEventOwner> paperRegistrar = mock(PaperRegistrar.class);
    doThrow(new IllegalStateException()).when(paperRegistrar).invalidate();
    Class<LifecycleEventOwner> ownerClass = LifecycleEventOwner.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            LifecycleEventRunner.INSTANCE.callEvent(
                eventType, new RegistrarEventImpl<>(paperRegistrar, ownerClass)));
    verify(paperRegistrar).invalidate();
  }
}
