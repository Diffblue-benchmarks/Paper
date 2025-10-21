package io.papermc.paper.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.Lifecycle;
import io.papermc.paper.configuration.Configurations.ContextKey;
import io.papermc.paper.configuration.Configurations.ContextMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.RunningOnDifferentThreadException;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.GameRules;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.spigotmc.SpigotWorldConfig;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader.Builder;

class PaperConfigurationsDiffblueTest {
  /**
   * Test {@link PaperConfigurations#PaperConfigurations(Path)}.
   *
   * <p>Method under test: {@link PaperConfigurations#PaperConfigurations(Path)}
   */
  @Test
  @DisplayName("Test new PaperConfigurations(Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperConfigurations.<init>(Path)"})
  void testNewPaperConfigurations() {
    // Arrange, Act and Assert
    File toFileResult =
        new PaperConfigurations(MetricsPersister.PROFILING_RESULTS_DIR).globalFolder.toFile();
    assertEquals("profiling", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link PaperConfigurations#globalConfigVersion()}.
   *
   * <ul>
   *   <li>Then return thirty.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#globalConfigVersion()}
   */
  @Test
  @DisplayName("Test globalConfigVersion(); then return thirty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperConfigurations.globalConfigVersion()"})
  void testGlobalConfigVersion_thenReturnThirty() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    // Act and Assert
    assertEquals(30, setupResult.globalConfigVersion());
  }

  /**
   * Test {@link PaperConfigurations#worldConfigVersion()}.
   *
   * <ul>
   *   <li>Then return thirty-one.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#worldConfigVersion()}
   */
  @Test
  @DisplayName("Test worldConfigVersion(); then return thirty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperConfigurations.worldConfigVersion()"})
  void testWorldConfigVersion_thenReturnThirtyOne() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    // Act and Assert
    assertEquals(31, setupResult.worldConfigVersion());
  }

  /**
   * Test {@link PaperConfigurations#createLoaderBuilder()}.
   *
   * <ul>
   *   <li>Then return source is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#createLoaderBuilder()}
   */
  @Test
  @DisplayName("Test createLoaderBuilder(); then return source is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperConfigurations.createLoaderBuilder()"})
  void testCreateLoaderBuilder_thenReturnSourceIsNull() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    // Act
    Builder actualCreateLoaderBuilderResult = setupResult.createLoaderBuilder();

    // Assert
    assertNull(actualCreateLoaderBuilderResult.source());
    assertNull(actualCreateLoaderBuilderResult.sink());
  }

  /**
   * Test {@link PaperConfigurations#createGlobalLoaderBuilder(RegistryAccess)}.
   *
   * <p>Method under test: {@link PaperConfigurations#createGlobalLoaderBuilder(RegistryAccess)}
   */
  @Test
  @DisplayName("Test createGlobalLoaderBuilder(RegistryAccess)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperConfigurations.createGlobalLoaderBuilder(RegistryAccess)"})
  void testCreateGlobalLoaderBuilder() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    // Act
    Builder actualCreateGlobalLoaderBuilderResult =
        setupResult.createGlobalLoaderBuilder(new ImmutableRegistryAccess(new ArrayList<>()));

    // Assert
    assertNull(actualCreateGlobalLoaderBuilderResult.source());
    assertNull(actualCreateGlobalLoaderBuilderResult.sink());
  }

  /**
   * Test {@link PaperConfigurations#createGlobalLoaderBuilder(RegistryAccess)}.
   *
   * <p>Method under test: {@link PaperConfigurations#createGlobalLoaderBuilder(RegistryAccess)}
   */
  @Test
  @DisplayName("Test createGlobalLoaderBuilder(RegistryAccess)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperConfigurations.createGlobalLoaderBuilder(RegistryAccess)"})
  void testCreateGlobalLoaderBuilder2() {
    // Arrange
    PaperConfigurations paperConfigurations =
        new PaperConfigurations(MetricsPersister.PROFILING_RESULTS_DIR);

    // Act
    Builder actualCreateGlobalLoaderBuilderResult =
        paperConfigurations.createGlobalLoaderBuilder(
            new ImmutableRegistryAccess(new ArrayList<>()));

    // Assert
    assertNull(actualCreateGlobalLoaderBuilderResult.source());
    assertNull(actualCreateGlobalLoaderBuilderResult.sink());
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#empty()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); given ConfigurationNode empty() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_givenConfigurationNodeEmptyReturnFalse()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getBoolean(anyBoolean())).thenReturn(true);
    when(configurationNode.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.empty()).thenReturn(false);
    when(configurationNode2.virtual()).thenReturn(true);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode3);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode2);

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.getBoolean()).thenReturn(true);
    when(configurationNode4.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode4);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode2).empty();
    verify(configurationNode4).getBoolean();
    verify(configurationNode).getBoolean(true);
    verify(configurationNode4).getInt();
    verify(configurationNode3).getInt(-1);
    verify(configurationNode).getInt(1);
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode, atLeast(1)).raw(isNull());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#getBoolean(boolean)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); given ConfigurationNode getBoolean(boolean) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_givenConfigurationNodeGetBooleanReturnFalse()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.getInt()).thenReturn(1);
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(false);
    when(configurationNode3.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.empty()).thenReturn(true);
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode5 = mock(ConfigurationNode.class);
    when(configurationNode5.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode5.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode5);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode4);

    ConfigurationNode configurationNode6 = mock(ConfigurationNode.class);
    when(configurationNode6.getBoolean()).thenReturn(true);
    when(configurationNode6.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode6);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode4).empty();
    verify(configurationNode4).from(isA(ConfigurationNode.class));
    verify(configurationNode6).getBoolean();
    verify(configurationNode3).getBoolean(true);
    verify(configurationNode6).getInt();
    verify(configurationNode3, atLeast(1)).getInt();
    verify(configurationNode5).getInt(-1);
    verify(configurationNode3).getInt(1);
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode5).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#getInt(int)} return forty-nine.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); given ConfigurationNode getInt(int) return forty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_givenConfigurationNodeGetIntReturnFortyNine()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(49);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode2);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, mock(ConfigurationNode.class));

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode2).getInt(-1);
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#getInt()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); given ConfigurationNode getInt() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_givenConfigurationNodeGetIntReturnZero()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt()).thenReturn(0);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getBoolean(anyBoolean())).thenReturn(true);
    when(configurationNode2.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.empty()).thenReturn(true);
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode4);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);

    ConfigurationNode configurationNode5 = mock(ConfigurationNode.class);
    when(configurationNode5.getBoolean()).thenReturn(true);
    when(configurationNode5.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode5);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode3).empty();
    verify(configurationNode5).getBoolean();
    verify(configurationNode2).getBoolean(true);
    verify(configurationNode5).getInt();
    verify(configurationNode2, atLeast(1)).getInt();
    verify(configurationNode4).getInt(-1);
    verify(configurationNode2).getInt(1);
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#virtual()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); given ConfigurationNode virtual() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_givenConfigurationNodeVirtualReturnFalse()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getBoolean(anyBoolean())).thenReturn(true);
    when(configurationNode.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.empty()).thenReturn(true);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode3);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode2);

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.getBoolean()).thenReturn(true);
    when(configurationNode4.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode4);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode2).empty();
    verify(configurationNode4).getBoolean();
    verify(configurationNode).getBoolean(true);
    verify(configurationNode4).getInt();
    verify(configurationNode3).getInt(-1);
    verify(configurationNode).getInt(1);
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode, atLeast(1)).raw(isNull());
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
    verify(configurationNode2, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#virtual()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); given ConfigurationNode virtual() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_givenConfigurationNodeVirtualReturnFalse2()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.getInt()).thenReturn(1);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getBoolean(anyBoolean())).thenReturn(true);
    when(configurationNode2.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.empty()).thenReturn(true);
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode4);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode3);

    ConfigurationNode configurationNode5 = mock(ConfigurationNode.class);
    when(configurationNode5.getBoolean()).thenReturn(true);
    when(configurationNode5.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode5);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode3).empty();
    verify(configurationNode5).getBoolean();
    verify(configurationNode2).getBoolean(true);
    verify(configurationNode5).getInt();
    verify(configurationNode2, atLeast(1)).getInt();
    verify(configurationNode4).getInt(-1);
    verify(configurationNode2).getInt(1);
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#empty()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); then calls empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_thenCallsEmpty() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.getBoolean(anyBoolean())).thenReturn(true);
    when(configurationNode.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.empty()).thenReturn(true);
    when(configurationNode2.virtual()).thenReturn(true);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode3);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode2);

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.getBoolean()).thenReturn(true);
    when(configurationNode4.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode4);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode2).empty();
    verify(configurationNode4).getBoolean();
    verify(configurationNode).getBoolean(true);
    verify(configurationNode4).getInt();
    verify(configurationNode3).getInt(-1);
    verify(configurationNode).getInt(1);
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2).raw(isNull());
    verify(configurationNode, atLeast(1)).raw(isNull());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode2, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap, ConfigurationNode,
   * ConfigurationNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#from(ConfigurationNode)}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#applyWorldConfigTransformations(ContextMap,
   * ConfigurationNode, ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode); then calls from(ConfigurationNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyWorldConfigTransformations(ContextMap, ConfigurationNode, ConfigurationNode)"
  })
  void testApplyWorldConfigTransformations_thenCallsFrom() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new GameRules(FeatureFlags.DEFAULT_FLAGS));

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.getInt()).thenReturn(1);
    when(configurationNode3.virtual()).thenReturn(false);
    when(configurationNode3.node(isA(Object[].class))).thenReturn(configurationNode2);
    when(configurationNode3.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getBoolean(anyBoolean())).thenReturn(true);
    when(configurationNode3.getInt(anyInt())).thenReturn(1);

    ConfigurationNode configurationNode4 = mock(ConfigurationNode.class);
    when(configurationNode4.from(Mockito.<ConfigurationNode>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode4.empty()).thenReturn(true);
    when(configurationNode4.virtual()).thenReturn(false);
    when(configurationNode4.node(isA(Object[].class))).thenReturn(configurationNode3);
    when(configurationNode4.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode5 = mock(ConfigurationNode.class);
    when(configurationNode5.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode5.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode5);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode4);

    ConfigurationNode configurationNode6 = mock(ConfigurationNode.class);
    when(configurationNode6.getBoolean()).thenReturn(true);
    when(configurationNode6.getInt()).thenReturn(1);

    ConfigurationNode defaultsNode = mock(ConfigurationNode.class);
    when(defaultsNode.node(isA(Object[].class))).thenReturn(configurationNode6);

    // Act
    setupResult.applyWorldConfigTransformations(contextMap, node, defaultsNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode4).empty();
    verify(configurationNode4).from(isA(ConfigurationNode.class));
    verify(configurationNode6).getBoolean();
    verify(configurationNode3).getBoolean(true);
    verify(configurationNode6).getInt();
    verify(configurationNode3, atLeast(1)).getInt();
    verify(configurationNode5).getInt(-1);
    verify(configurationNode3).getInt(1);
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(defaultsNode, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode3, atLeast(1)).node(isA(Object[].class));
    verify(configurationNode4, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode3, atLeast(1)).raw(isNull());
    verify(configurationNode4, atLeast(1)).raw(isNull());
    verify(configurationNode5).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
    verify(configurationNode2, atLeast(1)).virtual();
    verify(configurationNode3, atLeast(1)).virtual();
    verify(configurationNode4, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyGlobalConfigTransformations(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#getInt(int)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperConfigurations#applyGlobalConfigTransformations(ConfigurationNode)}
   */
  @Test
  @DisplayName("Test applyGlobalConfigTransformations(ConfigurationNode); then calls getInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyGlobalConfigTransformations(ConfigurationNode)"
  })
  void testApplyGlobalConfigTransformations_thenCallsGetInt() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode2.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode2);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.applyGlobalConfigTransformations(node);

    // Assert
    verify(configurationNode2).getInt(-1);
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#applyGlobalConfigTransformations(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#raw(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperConfigurations#applyGlobalConfigTransformations(ConfigurationNode)}
   */
  @Test
  @DisplayName("Test applyGlobalConfigTransformations(ConfigurationNode); then calls raw(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperConfigurations.applyGlobalConfigTransformations(ConfigurationNode)"
  })
  void testApplyGlobalConfigTransformations_thenCallsRaw() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode configurationNode2 = mock(ConfigurationNode.class);
    when(configurationNode2.virtual()).thenReturn(false);
    when(configurationNode2.node(isA(Object[].class))).thenReturn(configurationNode);
    when(configurationNode2.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));

    ConfigurationNode configurationNode3 = mock(ConfigurationNode.class);
    when(configurationNode3.set(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode3.getInt(anyInt())).thenReturn(1);

    ConfigurationNode node = mock(ConfigurationNode.class);
    when(node.node(Mockito.<Iterable<?>>any())).thenReturn(configurationNode3);
    when(node.node(isA(Object[].class))).thenReturn(configurationNode2);

    // Act
    setupResult.applyGlobalConfigTransformations(node);

    // Assert
    verify(configurationNode3).getInt(-1);
    verify(configurationNode2, atLeast(1)).node(isA(Object[].class));
    verify(node, atLeast(1)).node(isA(Object[].class));
    verify(node).node(isA(Iterable.class));
    verify(configurationNode2, atLeast(1)).raw(isNull());
    verify(configurationNode3).set(isA(Object.class));
    verify(configurationNode, atLeast(1)).virtual();
    verify(configurationNode2, atLeast(1)).virtual();
  }

  /**
   * Test {@link PaperConfigurations#isConfigType(Type)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link GenericArrayType#getGenericComponentType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#isConfigType(Type)}
   */
  @Test
  @DisplayName(
      "Test isConfigType(Type); given 'java.lang.Object'; then calls getGenericComponentType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperConfigurations.isConfigType(Type)"})
  void testIsConfigType_givenJavaLangObject_thenCallsGetGenericComponentType() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    GenericArrayType type = mock(GenericArrayType.class);
    Class<Object> forNameResult = Object.class;
    when(type.getGenericComponentType()).thenReturn(forNameResult);

    // Act
    boolean actualIsConfigTypeResult = setupResult.isConfigType(type);

    // Assert
    verify(type).getGenericComponentType();
    assertFalse(actualIsConfigTypeResult);
  }

  /**
   * Test {@link PaperConfigurations#isConfigType(Type)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#isConfigType(Type)}
   */
  @Test
  @DisplayName("Test isConfigType(Type); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperConfigurations.isConfigType(Type)"})
  void testIsConfigType_whenJavaLangObject_thenReturnFalse() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(setupResult.isConfigType(type));
  }

  /**
   * Test {@link PaperConfigurations#createWorldContextMap(Path, String, ResourceLocation,
   * SpigotWorldConfig, RegistryAccess, GameRules)} with {@code dir}, {@code levelName}, {@code
   * worldKey}, {@code spigotConfig}, {@code registryAccess}, {@code gameRules}.
   *
   * <p>Method under test: {@link PaperConfigurations#createWorldContextMap(Path, String,
   * ResourceLocation, SpigotWorldConfig, RegistryAccess, GameRules)}
   */
  @Test
  @DisplayName(
      "Test createWorldContextMap(Path, String, ResourceLocation, SpigotWorldConfig, RegistryAccess, GameRules) with 'dir', 'levelName', 'worldKey', 'spigotConfig', 'registryAccess', 'gameRules'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContextMap PaperConfigurations.createWorldContextMap(Path, String, ResourceLocation, SpigotWorldConfig, RegistryAccess, GameRules)"
  })
  void testCreateWorldContextMapWithDirLevelNameWorldKeySpigotConfigRegistryAccessGameRules() {
    // Arrange
    ResourceLocation worldKey = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    ImmutableRegistryAccess registryAccess = new ImmutableRegistryAccess(new ArrayList<>());

    // Act
    ContextMap actualCreateWorldContextMapResult =
        PaperConfigurations.createWorldContextMap(
            MetricsPersister.PROFILING_RESULTS_DIR,
            "Level Name",
            worldKey,
            null,
            registryAccess,
            new GameRules(FeatureFlags.DEFAULT_FLAGS));

    // Assert
    assertFalse(actualCreateWorldContextMapResult.isDefaultWorldContext());
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createFile(Path, FileAttribute[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link Files#createFile(Path, FileAttribute[])}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files createFile(Path, FileAttribute[]) throw IOException(); then calls createFile(Path, FileAttribute[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesCreateFileThrowIOException_thenCallsCreateFile() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any(), Mockito.<Charset>any()))
          .thenReturn(new BufferedReader(new StringReader("foo"), 1));
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles.when(() -> Files.delete(Mockito.<Path>any())).thenAnswer(invocation -> null);
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              PaperConfigurations.setup(
                  Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  OldUsersConverter.OLD_IPBANLIST));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.delete(Mockito.<Path>any()));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#exists(Path, LinkOption[])} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files exists(Path, LinkOption[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesExistsReturnFalse() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act
      PaperConfigurations actualSetupResult =
          PaperConfigurations.setup(
              MetricsPersister.PROFILING_RESULTS_DIR,
              MetricsPersister.PROFILING_RESULTS_DIR,
              MetricsPersister.PROFILING_RESULTS_DIR,
              OldUsersConverter.OLD_IPBANLIST);

      // Assert
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
      assertEquals("paper-global.yml", actualSetupResult.globalConfigFileName);
      assertEquals("paper-world-defaults.yml", actualSetupResult.defaultWorldConfigFileName);
      assertEquals("paper-world.yml", actualSetupResult.worldConfigFileName);
      File toFileResult = actualSetupResult.globalFolder.toFile();
      assertEquals("profiling", toFileResult.getName());
      assertFalse(toFileResult.isAbsolute());
      Class<GlobalConfiguration> expectedResultClass = GlobalConfiguration.class;
      assertEquals(expectedResultClass, actualSetupResult.globalConfigClass);
      Class<WorldConfiguration> expectedResultClass2 = WorldConfiguration.class;
      assertEquals(expectedResultClass2, actualSetupResult.worldConfigClass);
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code false}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files isDirectory(Path, LinkOption[]) return 'false'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesIsDirectoryReturnFalse_thenThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              PaperConfigurations.setup(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  OldUsersConverter.OLD_IPBANLIST));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isRegularFile(Path, LinkOption[])} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files isRegularFile(Path, LinkOption[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesIsRegularFileReturnFalse() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act
      PaperConfigurations actualSetupResult =
          PaperConfigurations.setup(
              MetricsPersister.PROFILING_RESULTS_DIR,
              MetricsPersister.PROFILING_RESULTS_DIR,
              MetricsPersister.PROFILING_RESULTS_DIR,
              OldUsersConverter.OLD_IPBANLIST);

      // Assert
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
      assertEquals("paper-global.yml", actualSetupResult.globalConfigFileName);
      assertEquals("paper-world-defaults.yml", actualSetupResult.defaultWorldConfigFileName);
      assertEquals("paper-world.yml", actualSetupResult.worldConfigFileName);
      File toFileResult = actualSetupResult.globalFolder.toFile();
      assertEquals("profiling", toFileResult.getName());
      assertFalse(toFileResult.isAbsolute());
      Class<GlobalConfiguration> expectedResultClass = GlobalConfiguration.class;
      assertEquals(expectedResultClass, actualSetupResult.globalConfigClass);
      Class<WorldConfiguration> expectedResultClass2 = WorldConfiguration.class;
      assertEquals(expectedResultClass2, actualSetupResult.worldConfigClass);
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isRegularFile(Path, LinkOption[])} return {@code true}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files isRegularFile(Path, LinkOption[]) return 'true'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesIsRegularFileReturnTrue_thenThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              PaperConfigurations.setup(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  OldUsersConverter.OLD_IPBANLIST));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isSymbolicLink(Path)} return {@code false}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files isSymbolicLink(Path) return 'false'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesIsSymbolicLinkReturnFalse_thenThrowRuntimeException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(false);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              PaperConfigurations.setup(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  OldUsersConverter.OLD_IPBANLIST));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#notExists(Path, LinkOption[])} throw {@link
   *       RunningOnDifferentThreadException#RUNNING_ON_DIFFERENT_THREAD}.
   *   <li>Then calls {@link Files#move(Path, Path, CopyOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); given Files notExists(Path, LinkOption[]) throw RUNNING_ON_DIFFERENT_THREAD; then calls move(Path, Path, CopyOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_givenFilesNotExistsThrowRunning_on_different_thread_thenCallsMove()
      throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD);
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any(), Mockito.<Charset>any()))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenThrow(new IOException());
      mockFiles.when(() -> Files.delete(Mockito.<Path>any())).thenThrow(new IOException());
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          RuntimeException.class,
          () ->
              PaperConfigurations.setup(
                  Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  OldUsersConverter.OLD_IPBANLIST));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName("Test setup(Path, Path, Path, File); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_thenThrowIOException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(RunningOnDifferentThreadException.RUNNING_ON_DIFFERENT_THREAD);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          IOException.class,
          () ->
              PaperConfigurations.setup(
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  OldUsersConverter.OLD_IPBANLIST));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
    }
  }

  /**
   * Test {@link PaperConfigurations#setup(Path, Path, Path, File)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#setup(Path, Path, Path, File)}
   */
  @Test
  @DisplayName(
      "Test setup(Path, Path, Path, File); when Property is 'java.io.tmpdir' is 'test.txt' toFile; then throw Exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperConfigurations PaperConfigurations.setup(Path, Path, Path, File)"})
  void testSetup_whenPropertyIsJavaIoTmpdirIsTestTxtToFile_thenThrowException() throws Exception {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(
              () ->
                  Files.writeString(
                      Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any(), Mockito.<Charset>any()))
          .thenReturn(new BufferedReader(new StringReader("foo"), 1));
      mockFiles
          .when(() -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles.when(() -> Files.delete(Mockito.<Path>any())).thenAnswer(invocation -> null);
      mockFiles
          .when(() -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.readSymbolicLink(Mockito.<Path>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles.when(() -> Files.isSymbolicLink(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertThrows(
          Exception.class,
          () ->
              PaperConfigurations.setup(
                  Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  MetricsPersister.PROFILING_RESULTS_DIR,
                  Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.delete(Mockito.<Path>any()));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.isRegularFile(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.isSymbolicLink(Mockito.<Path>any()), atLeast(1));
      mockFiles.verify(
          () -> Files.move(Mockito.<Path>any(), Mockito.<Path>any(), isA(CopyOption[].class)));
      mockFiles.verify(() -> Files.newBufferedReader(Mockito.<Path>any(), Mockito.<Charset>any()));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readSymbolicLink(Mockito.<Path>any()));
      mockFiles.verify(
          () ->
              Files.writeString(
                  Mockito.<Path>any(), Mockito.<CharSequence>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link PaperConfigurations#loadLegacyConfigFile(File)}.
   *
   * <ul>
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#loadLegacyConfigFile(File)}
   */
  @Test
  @DisplayName("Test loadLegacyConfigFile(File); then throw Exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfiguration PaperConfigurations.loadLegacyConfigFile(File)"})
  void testLoadLegacyConfigFile_thenThrowException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        Exception.class,
        () ->
            PaperConfigurations.loadLegacyConfigFile(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link PaperConfigurations#loadLegacyConfigFile(File)}.
   *
   * <ul>
   *   <li>When {@link OldUsersConverter#OLD_IPBANLIST}.
   *   <li>Then return CurrentPath is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#loadLegacyConfigFile(File)}
   */
  @Test
  @DisplayName(
      "Test loadLegacyConfigFile(File); when OLD_IPBANLIST; then return CurrentPath is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfiguration PaperConfigurations.loadLegacyConfigFile(File)"})
  void testLoadLegacyConfigFile_whenOld_ipbanlist_thenReturnCurrentPathIsEmptyString()
      throws Exception {
    // Arrange and Act
    YamlConfiguration actualLoadLegacyConfigFileResult =
        PaperConfigurations.loadLegacyConfigFile(OldUsersConverter.OLD_IPBANLIST);

    // Assert
    assertEquals("", actualLoadLegacyConfigFileResult.getCurrentPath());
    assertEquals("", actualLoadLegacyConfigFileResult.getName());
    assertNull(actualLoadLegacyConfigFileResult.getDefaults());
    assertNull(actualLoadLegacyConfigFileResult.getParent());
    assertNull(actualLoadLegacyConfigFileResult.getDefaultSection());
    Configuration actualRoot = actualLoadLegacyConfigFileResult.getRoot();
    assertSame(actualLoadLegacyConfigFileResult, actualRoot);
  }

  /**
   * Test {@link PaperConfigurations#createForTesting(RegistryAccess)}.
   *
   * <p>Method under test: {@link PaperConfigurations#createForTesting(RegistryAccess)}
   */
  @Test
  @DisplayName("Test createForTesting(RegistryAccess)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationNode PaperConfigurations.createForTesting(RegistryAccess)"})
  void testCreateForTesting() {
    // Arrange
    ArrayList<Registry<?>> registries = new ArrayList<>();
    DefaultedMappedRegistry<?> defaultedMappedRegistry =
        new DefaultedMappedRegistry<>("42", mock(ResourceKey.class), mock(Lifecycle.class), true);
    registries.add(defaultedMappedRegistry);

    // Act
    ConfigurationNode actualCreateForTestingResult =
        PaperConfigurations.createForTesting(new ImmutableRegistryAccess(registries));

    // Assert
    assertEquals(0, actualCreateForTestingResult.getInt());
    assertEquals(0.0d, actualCreateForTestingResult.getDouble());
    assertEquals(0.0f, actualCreateForTestingResult.getFloat());
    assertEquals(0L, actualCreateForTestingResult.getLong());
    assertFalse(actualCreateForTestingResult.getBoolean());
    assertEquals(Boolean.FALSE.toString(), actualCreateForTestingResult.getString());
  }

  /**
   * Test {@link PaperConfigurations#createForTesting(RegistryAccess)}.
   *
   * <ul>
   *   <li>When {@link RegistryAccess.ImmutableRegistryAccess#ImmutableRegistryAccess(List)} with
   *       registries is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#createForTesting(RegistryAccess)}
   */
  @Test
  @DisplayName(
      "Test createForTesting(RegistryAccess); when ImmutableRegistryAccess(List) with registries is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationNode PaperConfigurations.createForTesting(RegistryAccess)"})
  void testCreateForTesting_whenImmutableRegistryAccessWithRegistriesIsArrayList() {
    // Arrange and Act
    ConfigurationNode actualCreateForTestingResult =
        PaperConfigurations.createForTesting(new ImmutableRegistryAccess(new ArrayList<>()));

    // Assert
    assertEquals(0, actualCreateForTestingResult.getInt());
    assertEquals(0.0d, actualCreateForTestingResult.getDouble());
    assertEquals(0.0f, actualCreateForTestingResult.getFloat());
    assertEquals(0L, actualCreateForTestingResult.getLong());
    assertFalse(actualCreateForTestingResult.getBoolean());
    assertEquals(Boolean.FALSE.toString(), actualCreateForTestingResult.getString());
  }

  /**
   * Test {@link PaperConfigurations#createDirectoriesSymlinkAware(Path)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#createDirectoriesSymlinkAware(Path)}
   */
  @Test
  @DisplayName(
      "Test createDirectoriesSymlinkAware(Path); given Files isDirectory(Path, LinkOption[]) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperConfigurations.createDirectoriesSymlinkAware(Path)"})
  void testCreateDirectoriesSymlinkAware_givenFilesIsDirectoryReturnTrue() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act
      PaperConfigurations.createDirectoriesSymlinkAware(MetricsPersister.PROFILING_RESULTS_DIR);

      // Assert
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link PaperConfigurations#createDirectoriesSymlinkAware(Path)}.
   *
   * <ul>
   *   <li>Then calls {@link Files#createDirectories(Path, FileAttribute[])}.
   * </ul>
   *
   * <p>Method under test: {@link PaperConfigurations#createDirectoriesSymlinkAware(Path)}
   */
  @Test
  @DisplayName(
      "Test createDirectoriesSymlinkAware(Path); then calls createDirectories(Path, FileAttribute[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperConfigurations.createDirectoriesSymlinkAware(Path)"})
  void testCreateDirectoriesSymlinkAware_thenCallsCreateDirectories() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act
      PaperConfigurations.createDirectoriesSymlinkAware(MetricsPersister.PROFILING_RESULTS_DIR);

      // Assert
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }
}
