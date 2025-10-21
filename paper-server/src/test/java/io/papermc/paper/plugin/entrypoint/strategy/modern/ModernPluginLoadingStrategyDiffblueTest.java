package io.papermc.paper.plugin.entrypoint.strategy.modern;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.dependency.BootstrapMetaDependencyTree;
import io.papermc.paper.plugin.entrypoint.dependency.MetaDependencyTree;
import io.papermc.paper.plugin.entrypoint.strategy.ProviderConfiguration;
import io.papermc.paper.plugin.provider.PluginProvider;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ModernPluginLoadingStrategyDiffblueTest {
  /**
   * Test {@link ModernPluginLoadingStrategy#loadProviders(List, MetaDependencyTree)}.
   *
   * <p>Method under test: {@link ModernPluginLoadingStrategy#loadProviders(List,
   * MetaDependencyTree)}
   */
  @Test
  @DisplayName("Test loadProviders(List, MetaDependencyTree)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ModernPluginLoadingStrategy.loadProviders(List, MetaDependencyTree)"})
  void testLoadProviders() {
    // Arrange
    ModernPluginLoadingStrategy<Object> modernPluginLoadingStrategy =
        new ModernPluginLoadingStrategy<>(mock(ProviderConfiguration.class));
    ArrayList<PluginProvider<Object>> pluginProviders = new ArrayList<>();

    // Act and Assert
    assertTrue(
        modernPluginLoadingStrategy
            .loadProviders(pluginProviders, new BootstrapMetaDependencyTree())
            .isEmpty());
  }
}
