package io.papermc.paper.plugin.lifecycle.event.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent;
import io.papermc.paper.plugin.lifecycle.event.types.PrioritizableLifecycleEventType.Simple;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.tag.PostFlattenTagRegistrar;
import io.papermc.paper.tag.PreFlattenTagRegistrar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperTagEventTypeProviderDiffblueTest {
  /**
   * Test {@link PaperTagEventTypeProvider#preFlatten(RegistryKey)}.
   *
   * <p>Method under test: {@link PaperTagEventTypeProvider#preFlatten(RegistryKey)}
   */
  @Test
  @DisplayName("Test preFlatten(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Simple PaperTagEventTypeProvider.preFlatten(RegistryKey)"})
  void testPreFlatten() {
    // Arrange and Act
    Simple<BootstrapContext, ReloadableRegistrarEvent<PreFlattenTagRegistrar<Object>>>
        actualPreFlattenResult = new PaperTagEventTypeProvider().preFlatten(null);

    // Assert
    assertEquals("pre-flatten", actualPreFlattenResult.name());
    assertFalse(actualPreFlattenResult.hasHandlers());
  }

  /**
   * Test {@link PaperTagEventTypeProvider#postFlatten(RegistryKey)}.
   *
   * <p>Method under test: {@link PaperTagEventTypeProvider#postFlatten(RegistryKey)}
   */
  @Test
  @DisplayName("Test postFlatten(RegistryKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Simple PaperTagEventTypeProvider.postFlatten(RegistryKey)"})
  void testPostFlatten() {
    // Arrange and Act
    Simple<BootstrapContext, ReloadableRegistrarEvent<PostFlattenTagRegistrar<Object>>>
        actualPostFlattenResult = new PaperTagEventTypeProvider().postFlatten(null);

    // Assert
    assertEquals("post-flatten", actualPostFlattenResult.name());
    assertFalse(actualPostFlattenResult.hasHandlers());
  }
}
