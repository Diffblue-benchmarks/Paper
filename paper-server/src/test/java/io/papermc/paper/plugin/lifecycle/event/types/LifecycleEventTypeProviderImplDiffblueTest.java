package io.papermc.paper.plugin.lifecycle.event.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEvent;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventOwner;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEventType.Monitorable;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEventType.Prioritizable;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType.Simple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LifecycleEventTypeProviderImplDiffblueTest {
  /**
   * Test {@link LifecycleEventTypeProviderImpl#monitor(String, Class)}.
   *
   * <p>Method under test: {@link LifecycleEventTypeProviderImpl#monitor(String, Class)}
   */
  @Test
  @DisplayName("Test monitor(String, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Monitorable LifecycleEventTypeProviderImpl.monitor(String, Class)"})
  void testMonitor() {
    // Arrange
    LifecycleEventTypeProviderImpl lifecycleEventTypeProviderImpl =
        new LifecycleEventTypeProviderImpl();
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    // Act
    Monitorable<LifecycleEventOwner, LifecycleEvent> actualMonitorResult =
        lifecycleEventTypeProviderImpl.monitor("Name", ownerType);

    // Assert
    assertTrue(actualMonitorResult instanceof MonitorableLifecycleEventType);
    assertEquals("Name", actualMonitorResult.name());
    assertEquals(
        0,
        ((MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>) actualMonitorResult)
            .nonMonitorIdx);
    assertFalse(
        ((MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>) actualMonitorResult)
            .hasHandlers());
    assertTrue(
        ((MonitorableLifecycleEventType<LifecycleEventOwner, LifecycleEvent>) actualMonitorResult)
            .handlers.isEmpty());
  }

  /**
   * Test {@link LifecycleEventTypeProviderImpl#prioritized(String, Class)}.
   *
   * <p>Method under test: {@link LifecycleEventTypeProviderImpl#prioritized(String, Class)}
   */
  @Test
  @DisplayName("Test prioritized(String, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Prioritizable LifecycleEventTypeProviderImpl.prioritized(String, Class)"})
  void testPrioritized() {
    // Arrange
    LifecycleEventTypeProviderImpl lifecycleEventTypeProviderImpl =
        new LifecycleEventTypeProviderImpl();
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    // Act
    Prioritizable<LifecycleEventOwner, LifecycleEvent> actualPrioritizedResult =
        lifecycleEventTypeProviderImpl.prioritized("Name", ownerType);

    // Assert
    assertTrue(actualPrioritizedResult instanceof Simple);
    assertEquals("Name", actualPrioritizedResult.name());
    assertFalse(
        ((Simple<LifecycleEventOwner, LifecycleEvent>) actualPrioritizedResult).hasHandlers());
  }
}
