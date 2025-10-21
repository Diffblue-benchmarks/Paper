package io.papermc.paper.plugin.entrypoint.strategy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.dependency.BootstrapMetaDependencyTree;
import io.papermc.paper.plugin.entrypoint.dependency.MetaDependencyTree;
import io.papermc.paper.plugin.provider.PluginProvider;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LegacyPluginLoadingStrategyDiffblueTest {
  /**
   * Test {@link LegacyPluginLoadingStrategy#loadProviders(List, MetaDependencyTree)}.
   *
   * <ul>
   *   <li>When {@link BootstrapMetaDependencyTree#BootstrapMetaDependencyTree()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LegacyPluginLoadingStrategy#loadProviders(List,
   * MetaDependencyTree)}
   */
  @Test
  @DisplayName(
      "Test loadProviders(List, MetaDependencyTree); when BootstrapMetaDependencyTree(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LegacyPluginLoadingStrategy.loadProviders(List, MetaDependencyTree)"})
  void testLoadProviders_whenBootstrapMetaDependencyTree_thenReturnEmpty() {
    // Arrange
    LegacyPluginLoadingStrategy<Object> legacyPluginLoadingStrategy =
        new LegacyPluginLoadingStrategy<>(mock(ProviderConfiguration.class));
    ArrayList<PluginProvider<Object>> providers = new ArrayList<>();

    // Act and Assert
    assertTrue(
        legacyPluginLoadingStrategy
            .loadProviders(providers, new BootstrapMetaDependencyTree())
            .isEmpty());
  }
}
