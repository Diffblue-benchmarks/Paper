package io.papermc.paper.configuration.transformation.world.versioned;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.configuration.Configurations;
import io.papermc.paper.configuration.Configurations.ContextKey;
import io.papermc.paper.configuration.Configurations.ContextMap;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.GameRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.transformation.ConfigurationTransformation.VersionedBuilder;

class V31_SpawnLoadedRangeToGameRuleDiffblueTest {
  /**
   * Test {@link V31_SpawnLoadedRangeToGameRule#apply(VersionedBuilder, ContextMap,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link GameRules#GameRules(FeatureFlagSet)} with enabledFeatures is {@link
   *       FeatureFlags#DEFAULT_FLAGS}.
   *   <li>Then calls {@link ContextMap#require(ContextKey)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * V31_SpawnLoadedRangeToGameRule#apply(ConfigurationTransformation.VersionedBuilder, ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test apply(VersionedBuilder, ContextMap, ConfigurationNode); given GameRules(FeatureFlagSet) with enabledFeatures is DEFAULT_FLAGS; then calls require(ContextKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void V31_SpawnLoadedRangeToGameRule.apply(ConfigurationTransformation.VersionedBuilder, ContextMap, ConfigurationNode)"
  })
  void testApply_givenGameRulesWithEnabledFeaturesIsDefault_flags_thenCallsRequire() {
    // Arrange
    VersionedBuilder builder = ConfigurationTransformation.versionedBuilder();

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    // Act
    V31_SpawnLoadedRangeToGameRule.apply(builder, contextMap, mock(ConfigurationNode.class));

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
  }
}
