package io.papermc.paper.configuration;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader.Builder;

class ConfigurationLoadersDiffblueTest {
  /**
   * Test {@link ConfigurationLoaders#naturallySorted()}.
   *
   * <p>Method under test: {@link ConfigurationLoaders#naturallySorted()}
   */
  @Test
  @DisplayName("Test naturallySorted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder ConfigurationLoaders.naturallySorted()"})
  void testNaturallySorted() {
    // Arrange and Act
    Builder actualNaturallySortedResult = ConfigurationLoaders.naturallySorted();

    // Assert
    assertNull(actualNaturallySortedResult.source());
    assertNull(actualNaturallySortedResult.sink());
  }
}
