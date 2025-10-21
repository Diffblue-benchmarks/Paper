package io.papermc.paper.plugin.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.entrypoint.dependency.BootstrapMetaDependencyTree;
import io.papermc.paper.plugin.entrypoint.strategy.modern.ModernPluginLoadingStrategy;
import io.papermc.paper.plugin.provider.PluginProvider;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BootstrapProviderStorageDiffblueTest {
  /**
   * Test new {@link BootstrapProviderStorage} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BootstrapProviderStorage}
   */
  @Test
  @DisplayName("Test new BootstrapProviderStorage (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapProviderStorage.<init>()"})
  void testNewBootstrapProviderStorage() {
    // Arrange and Act
    BootstrapProviderStorage actualBootstrapProviderStorage = new BootstrapProviderStorage();

    // Assert
    assertTrue(actualBootstrapProviderStorage.strategy instanceof ModernPluginLoadingStrategy);
    Iterable<PluginProvider<PluginBootstrap>> registeredProviders =
        actualBootstrapProviderStorage.getRegisteredProviders();
    assertTrue(registeredProviders instanceof List);
    assertTrue(((List<PluginProvider<PluginBootstrap>>) registeredProviders).isEmpty());
  }

  /**
   * Test {@link BootstrapProviderStorage#createDependencyTree()}.
   *
   * <p>Method under test: {@link BootstrapProviderStorage#createDependencyTree()}
   */
  @Test
  @DisplayName("Test createDependencyTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.entrypoint.dependency.MetaDependencyTree BootstrapProviderStorage.createDependencyTree()"
  })
  void testCreateDependencyTree() {
    // Arrange, Act and Assert
    assertTrue(
        new BootstrapProviderStorage().createDependencyTree()
            instanceof BootstrapMetaDependencyTree);
  }
}
