package io.papermc.paper.configuration.legacy;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.ConfigurationNode;

class SpawnLoadedRangeInitializerDiffblueTest {
  /**
   * Test {@link SpawnLoadedRangeInitializer#resolve(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#virtual()} return {@code false}.
   *   <li>Then calls {@link ConfigurationNode#node(Object[])}.
   * </ul>
   *
   * <p>Method under test: {@link SpawnLoadedRangeInitializer#resolve(ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test resolve(ConfigurationNode); given ConfigurationNode virtual() return 'false'; then calls node(Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationNode SpawnLoadedRangeInitializer.resolve(ConfigurationNode)"})
  void testResolve_givenConfigurationNodeVirtualReturnFalse_thenCallsNode() {
    // Arrange
    SpawnLoadedRangeInitializer spawnLoadedRangeInitializer =
        new SpawnLoadedRangeInitializer("Name", null);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(false);

    ConfigurationNode parent = mock(ConfigurationNode.class);
    when(parent.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    spawnLoadedRangeInitializer.resolve(parent);

    // Assert
    verify(parent).node(isA(Object[].class));
    verify(configurationNode).virtual();
  }
}
