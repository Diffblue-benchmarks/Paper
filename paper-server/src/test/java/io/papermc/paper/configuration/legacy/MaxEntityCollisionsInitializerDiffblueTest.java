package io.papermc.paper.configuration.legacy;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spigotmc.SpigotWorldConfig;
import org.spongepowered.configurate.ConfigurationNode;

class MaxEntityCollisionsInitializerDiffblueTest {
  /**
   * Test {@link MaxEntityCollisionsInitializer#resolve(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#raw(Object)} return {@link
   *       ConfigurationNode}.
   *   <li>Then calls {@link ConfigurationNode#raw(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxEntityCollisionsInitializer#resolve(ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test resolve(ConfigurationNode); given ConfigurationNode raw(Object) return ConfigurationNode; then calls raw(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationNode MaxEntityCollisionsInitializer.resolve(ConfigurationNode)"})
  void testResolve_givenConfigurationNodeRawReturnConfigurationNode_thenCallsRaw() {
    // Arrange
    SpigotWorldConfig spigotConfig = mock(SpigotWorldConfig.class);
    when(spigotConfig.getInt(Mockito.<String>any(), anyInt(), anyBoolean())).thenReturn(1);
    MaxEntityCollisionsInitializer maxEntityCollisionsInitializer =
        new MaxEntityCollisionsInitializer("Name", spigotConfig);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode parent = mock(ConfigurationNode.class);
    when(parent.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    maxEntityCollisionsInitializer.resolve(parent);

    // Assert
    verify(spigotConfig).getInt("max-entity-collisions", -1, false);
    verify(parent).node(isA(Object[].class));
    verify(configurationNode).raw(isA(Object.class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link MaxEntityCollisionsInitializer#resolve(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#virtual()} return {@code false}.
   *   <li>Then calls {@link SpigotWorldConfig#getInt(String, int, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxEntityCollisionsInitializer#resolve(ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test resolve(ConfigurationNode); given ConfigurationNode virtual() return 'false'; then calls getInt(String, int, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationNode MaxEntityCollisionsInitializer.resolve(ConfigurationNode)"})
  void testResolve_givenConfigurationNodeVirtualReturnFalse_thenCallsGetInt() {
    // Arrange
    SpigotWorldConfig spigotConfig = mock(SpigotWorldConfig.class);
    when(spigotConfig.getInt(Mockito.<String>any(), anyInt(), anyBoolean())).thenReturn(1);
    MaxEntityCollisionsInitializer maxEntityCollisionsInitializer =
        new MaxEntityCollisionsInitializer("Name", spigotConfig);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(false);

    ConfigurationNode parent = mock(ConfigurationNode.class);
    when(parent.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    maxEntityCollisionsInitializer.resolve(parent);

    // Assert
    verify(spigotConfig).getInt("max-entity-collisions", -1, false);
    verify(parent).node(isA(Object[].class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link MaxEntityCollisionsInitializer#resolve(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link SpigotWorldConfig} {@link SpigotWorldConfig#getInt(String, int, boolean)}
   *       return minus one.
   *   <li>Then calls {@link SpigotWorldConfig#getInt(String, int, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link MaxEntityCollisionsInitializer#resolve(ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test resolve(ConfigurationNode); given SpigotWorldConfig getInt(String, int, boolean) return minus one; then calls getInt(String, int, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationNode MaxEntityCollisionsInitializer.resolve(ConfigurationNode)"})
  void testResolve_givenSpigotWorldConfigGetIntReturnMinusOne_thenCallsGetInt() {
    // Arrange
    SpigotWorldConfig spigotConfig = mock(SpigotWorldConfig.class);
    when(spigotConfig.getInt(Mockito.<String>any(), anyInt(), anyBoolean())).thenReturn(-1);
    MaxEntityCollisionsInitializer maxEntityCollisionsInitializer =
        new MaxEntityCollisionsInitializer("Name", spigotConfig);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode parent = mock(ConfigurationNode.class);
    when(parent.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    maxEntityCollisionsInitializer.resolve(parent);

    // Assert
    verify(spigotConfig).getInt("max-entity-collisions", -1, false);
    verify(parent).node(isA(Object[].class));
    verify(configurationNode).virtual();
  }
}
