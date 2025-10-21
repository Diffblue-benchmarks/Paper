package io.papermc.paper.plugin.lifecycle.event.types;

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
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.AbstractLifecycleEventHandlerConfiguration;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.PrioritizedLifecycleEventHandlerConfiguration;
import io.papermc.paper.plugin.lifecycle.event.handler.configuration.PrioritizedLifecycleEventHandlerConfigurationImpl;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType.Simple;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrioritizableLifecycleEventTypeDiffblueTest {
  /**
   * Test {@link PrioritizableLifecycleEventType#hasHandlers()}.
   *
   * <p>Method under test: {@link PrioritizableLifecycleEventType#hasHandlers()}
   */
  @Test
  @DisplayName("Test hasHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PrioritizableLifecycleEventType.hasHandlers()"})
  void testHasHandlers() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    Simple<LifecycleEventOwner, LifecycleEvent> simple = new Simple<>("Name", ownerType);

    // Act and Assert
    assertFalse(simple.hasHandlers());
  }

  /**
   * Test {@link PrioritizableLifecycleEventType#register(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link Simple#Simple(String, Class)} with {@code Name} and ownerType is {@link
   *       LifecycleEventOwner} hasHandlers.
   * </ul>
   *
   * <p>Method under test: {@link PrioritizableLifecycleEventType#register(LifecycleEventOwner,
   * AbstractLifecycleEventHandlerConfiguration)}
   */
  @Test
  @DisplayName(
      "Test register(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration); then Simple(String, Class) with 'Name' and ownerType is LifecycleEventOwner hasHandlers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PrioritizableLifecycleEventType.register(LifecycleEventOwner, AbstractLifecycleEventHandlerConfiguration)"
  })
  void testRegister_thenSimpleWithNameAndOwnerTypeIsLifecycleEventOwnerHasHandlers() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    Simple<LifecycleEventOwner, LifecycleEvent> simple = new Simple<>("Name", ownerType);
    LifecycleEventOwner lifecycleEventOwner = mock(LifecycleEventOwner.class);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);
    Class<LifecycleEventOwner> ownerType2 = LifecycleEventOwner.class;
    PrioritizedLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent> config =
        new PrioritizedLifecycleEventHandlerConfigurationImpl<>(
            handler, new MonitorableLifecycleEventType<>("Name", ownerType2));

    // Act
    simple.register(lifecycleEventOwner, config);

    // Assert
    assertTrue(simple.hasHandlers());
  }

  /**
   * Test Simple {@link Simple#newHandler(LifecycleEventHandler)}.
   *
   * <p>Method under test: {@link Simple#newHandler(LifecycleEventHandler)}
   */
  @Test
  @DisplayName("Test Simple newHandler(LifecycleEventHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PrioritizedLifecycleEventHandlerConfiguration Simple.newHandler(LifecycleEventHandler)"
  })
  void testSimpleNewHandler() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;
    Simple<LifecycleEventOwner, LifecycleEvent> simple = new Simple<>("Name", ownerType);
    LifecycleEventHandler<LifecycleEvent> handler = mock(LifecycleEventHandler.class);

    // Act
    PrioritizedLifecycleEventHandlerConfiguration<LifecycleEventOwner> actualNewHandlerResult =
        simple.newHandler(handler);

    // Assert
    assertTrue(actualNewHandlerResult instanceof PrioritizedLifecycleEventHandlerConfigurationImpl);
    OptionalInt priorityResult =
        ((PrioritizedLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>)
                actualNewHandlerResult)
            .priority();
    assertEquals(0, priorityResult.getAsInt());
    assertTrue(priorityResult.isPresent());
    assertSame(
        handler,
        ((PrioritizedLifecycleEventHandlerConfigurationImpl<LifecycleEventOwner, LifecycleEvent>)
                actualNewHandlerResult)
            .handler());
  }

  /**
   * Test Simple {@link Simple#Simple(String, Class)}.
   *
   * <p>Method under test: {@link Simple#Simple(String, Class)}
   */
  @Test
  @DisplayName("Test Simple new Simple(String, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Simple.<init>(String, Class)"})
  void testSimpleNewSimple() {
    // Arrange
    Class<LifecycleEventOwner> ownerType = LifecycleEventOwner.class;

    // Act
    Simple<LifecycleEventOwner, LifecycleEvent> actualSimple = new Simple<>("Name", ownerType);

    // Assert
    assertEquals("Name", actualSimple.name());
    assertFalse(actualSimple.hasHandlers());
  }
}
