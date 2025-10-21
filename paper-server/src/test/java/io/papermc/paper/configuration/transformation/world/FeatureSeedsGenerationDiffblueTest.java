package io.papermc.paper.configuration.transformation.world;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.Configurations;
import io.papermc.paper.configuration.Configurations.ContextMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.transformation.ConfigurationTransformation.Builder;

class FeatureSeedsGenerationDiffblueTest {
  /**
   * Test {@link FeatureSeedsGeneration#apply(Builder, ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#getBoolean(boolean)} return
   *       {@code false}.
   *   <li>Then calls {@link ConfigurationNode#getBoolean(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link FeatureSeedsGeneration#apply(ConfigurationTransformation.Builder,
   * ContextMap, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test apply(Builder, ContextMap, ConfigurationNode); given ConfigurationNode getBoolean(boolean) return 'false'; then calls getBoolean(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FeatureSeedsGeneration.apply(ConfigurationTransformation.Builder, ContextMap, ConfigurationNode)"
  })
  void testApply_givenConfigurationNodeGetBooleanReturnFalse_thenCallsGetBoolean() {
    // Arrange
    Builder builder = ConfigurationTransformation.builder();
    ContextMap contextMap = ContextMap.builder().build();

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.getBoolean(anyBoolean())).thenReturn(false);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    FeatureSeedsGeneration.apply(builder, contextMap, defaultsNode);

    // Assert
    verify(configurationNode).getBoolean(false);
    verify(defaultsNode).node(isA(Object[].class));
  }
}
