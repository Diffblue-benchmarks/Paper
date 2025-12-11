package io.papermc.paper.plugin.lifecycle.event.handler.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.plugin.lifecycle.event.types.AbstractLifecycleEventType;
import io.papermc.paper.plugin.lifecycle.event.types.MonitorableLifecycleEventType;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrioritizedLifecycleEventHandlerConfigurationImplDiffblueTest {
  /**
   * Test {@link
   * PrioritizedLifecycleEventHandlerConfigurationImpl#PrioritizedLifecycleEventHandlerConfigurationImpl(LifecycleEventHandler,
   * AbstractLifecycleEventType)}.
   *
   * <p>Method under test: {@link
   * PrioritizedLifecycleEventHandlerConfigurationImpl#PrioritizedLifecycleEventHandlerConfigurationImpl(LifecycleEventHandler,
   * AbstractLifecycleEventType)}
   */
  @Test
  @DisplayName(
      "Test new PrioritizedLifecycleEventHandlerConfigurationImpl(LifecycleEventHandler, AbstractLifecycleEventType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PrioritizedLifecycleEventHandlerConfigurationImpl.<init>(LifecycleEventHandler, AbstractLifecycleEventType)"
  })
  void testNewPrioritizedLifecycleEventHandlerConfigurationImpl() {
    // Arrange
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    // Act
    PrioritizedLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        actualPrioritizedLifecycleEventHandlerConfigurationImpl =
            new PrioritizedLifecycleEventHandlerConfigurationImpl<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Assert
    OptionalInt priorityResult = actualPrioritizedLifecycleEventHandlerConfigurationImpl.priority();
    assertEquals(0, priorityResult.getAsInt());
    assertFalse(priorityResult.isEmpty());
    assertTrue(priorityResult.isPresent());
    assertSame(handler, actualPrioritizedLifecycleEventHandlerConfigurationImpl.handler());
  }

  /**
   * Test {@link PrioritizedLifecycleEventHandlerConfigurationImpl#priority(int)} with {@code int}.
   *
   * <p>Method under test: {@link PrioritizedLifecycleEventHandlerConfigurationImpl#priority(int)}
   */
  @Test
  @DisplayName("Test priority(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritizedLifecycleEventHandlerConfiguration PrioritizedLifecycleEventHandlerConfigurationImpl.priority(int)"
  })
  void testPriorityWithInt() {
    // Arrange
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    PrioritizedLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        prioritizedLifecycleEventHandlerConfigurationImpl =
            new PrioritizedLifecycleEventHandlerConfigurationImpl<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Act
    PrioritizedLifecycleEventHandlerConfiguration<LifecycleEventOwner> actualPriorityResult =
        prioritizedLifecycleEventHandlerConfigurationImpl.priority(1);

    // Assert
    assertSame(prioritizedLifecycleEventHandlerConfigurationImpl, actualPriorityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PrioritizedLifecycleEventHandlerConfigurationImpl#monitor()}
   *   <li>{@link PrioritizedLifecycleEventHandlerConfigurationImpl#priority()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritizedLifecycleEventHandlerConfiguration PrioritizedLifecycleEventHandlerConfigurationImpl.monitor()",
    "OptionalInt PrioritizedLifecycleEventHandlerConfigurationImpl.priority()"
  })
  void testGettersAndSetters() {
    // Arrange
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    PrioritizedLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>
        prioritizedLifecycleEventHandlerConfigurationImpl =
            new PrioritizedLifecycleEventHandlerConfigurationImpl<>(
                handler, new MonitorableLifecycleEventType<>("Name", ownerType));

    // Act
    PrioritizedLifecycleEventHandlerConfiguration<LifecycleEventOwner> actualMonitorResult =
        prioritizedLifecycleEventHandlerConfigurationImpl.monitor();
    OptionalInt actualPriorityResult = prioritizedLifecycleEventHandlerConfigurationImpl.priority();

    // Assert
    assertTrue(actualMonitorResult instanceof PrioritizedLifecycleEventHandlerConfigurationImpl);
    assertFalse(actualPriorityResult.isPresent());
    assertTrue(actualPriorityResult.isEmpty());
    assertSame(prioritizedLifecycleEventHandlerConfigurationImpl, actualMonitorResult);
  }
}
