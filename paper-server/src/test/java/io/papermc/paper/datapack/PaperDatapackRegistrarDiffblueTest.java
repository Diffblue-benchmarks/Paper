package io.papermc.paper.datapack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.AdventureComponent;
import io.papermc.paper.datapack.Datapack.Compatibility;
import io.papermc.paper.datapack.Datapack.Position;
import io.papermc.paper.datapack.DatapackRegistrar.Configurer;
import io.papermc.paper.datapack.PaperDatapackRegistrar.ConfigurerImpl;
import io.papermc.paper.plugin.bootstrap.PluginBootstrapContextImpl;
import io.papermc.paper.plugin.configuration.PluginMeta;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.FilePackResources.FileResourcesSupplier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.Pack.Metadata;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.validation.DirectoryValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDatapackRegistrarDiffblueTest {
  /**
   * Test ConfigurerImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConfigurerImpl#title(Component)}
   *   <li>{@link ConfigurerImpl#autoEnableOnServerStart(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test ConfigurerImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configurer ConfigurerImpl.autoEnableOnServerStart(boolean)",
    "Configurer ConfigurerImpl.title(Component)"
  })
  void testConfigurerImplGettersAndSetters() {
    // Arrange
    ConfigurerImpl configurerImpl = new ConfigurerImpl(mock(Component.class));

    // Act
    Configurer actualTitleResult = configurerImpl.title(mock(Component.class));
    Configurer actualAutoEnableOnServerStartResult = configurerImpl.autoEnableOnServerStart(true);

    // Assert
    assertTrue(actualTitleResult instanceof ConfigurerImpl);
    assertSame(configurerImpl, actualAutoEnableOnServerStartResult);
    assertSame(configurerImpl, actualTitleResult);
  }

  /**
   * Test ConfigurerImpl {@link ConfigurerImpl#position(boolean, Position)}.
   *
   * <ul>
   *   <li>When {@code BOTTOM}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurerImpl#position(boolean, Position)}
   */
  @Test
  @DisplayName("Test ConfigurerImpl position(boolean, Position); when 'BOTTOM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configurer ConfigurerImpl.position(boolean, Position)"})
  void testConfigurerImplPosition_whenBottom() {
    // Arrange
    ConfigurerImpl configurerImpl = new ConfigurerImpl(mock(Component.class));

    // Act
    Configurer actualPositionResult = configurerImpl.position(true, Position.BOTTOM);

    // Assert
    assertTrue(actualPositionResult instanceof ConfigurerImpl);
    assertSame(configurerImpl, actualPositionResult);
  }

  /**
   * Test ConfigurerImpl {@link ConfigurerImpl#position(boolean, Position)}.
   *
   * <ul>
   *   <li>When {@code TOP}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurerImpl#position(boolean, Position)}
   */
  @Test
  @DisplayName("Test ConfigurerImpl position(boolean, Position); when 'TOP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configurer ConfigurerImpl.position(boolean, Position)"})
  void testConfigurerImplPosition_whenTop() {
    // Arrange
    ConfigurerImpl configurerImpl = new ConfigurerImpl(mock(Component.class));

    // Act
    Configurer actualPositionResult = configurerImpl.position(true, Position.TOP);

    // Assert
    assertTrue(actualPositionResult instanceof ConfigurerImpl);
    assertSame(configurerImpl, actualPositionResult);
  }

  /**
   * Test {@link PaperDatapackRegistrar#PaperDatapackRegistrar(DirectoryValidator, Map)}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#PaperDatapackRegistrar(DirectoryValidator,
   * Map)}
   */
  @Test
  @DisplayName("Test new PaperDatapackRegistrar(DirectoryValidator, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperDatapackRegistrar.<init>(DirectoryValidator, Map)"})
  void testNewPaperDatapackRegistrar() {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    // Act
    PaperDatapackRegistrar actualPaperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());

    // Assert
    assertTrue(actualPaperDatapackRegistrar.getDiscoveredPacks().isEmpty());
    assertTrue(actualPaperDatapackRegistrar.discoveredPacks.isEmpty());
  }

  /**
   * Test {@link PaperDatapackRegistrar#hasPackDiscovered(String)}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#hasPackDiscovered(String)}
   */
  @Test
  @DisplayName("Test hasPackDiscovered(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperDatapackRegistrar.hasPackDiscovered(String)"})
  void testHasPackDiscovered() {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));
    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());

    // Act and Assert
    assertFalse(paperDatapackRegistrar.hasPackDiscovered("Name"));
  }

  /**
   * Test {@link PaperDatapackRegistrar#getDiscoveredPack(String)}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#getDiscoveredPack(String)}
   */
  @Test
  @DisplayName("Test getDiscoveredPack(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DiscoveredDatapack PaperDatapackRegistrar.getDiscoveredPack(String)"})
  void testGetDiscoveredPack() {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));
    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> paperDatapackRegistrar.getDiscoveredPack("Name"));
  }

  /**
   * Test {@link PaperDatapackRegistrar#removeDiscoveredPack(String)}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#removeDiscoveredPack(String)}
   */
  @Test
  @DisplayName("Test removeDiscoveredPack(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperDatapackRegistrar.removeDiscoveredPack(String)"})
  void testRemoveDiscoveredPack() {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));
    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());

    // Act and Assert
    assertFalse(paperDatapackRegistrar.removeDiscoveredPack("Name"));
  }

  /**
   * Test {@link PaperDatapackRegistrar#getDiscoveredPacks()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#getDiscoveredPacks()}
   */
  @Test
  @DisplayName("Test getDiscoveredPacks(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperDatapackRegistrar.getDiscoveredPacks()"})
  void testGetDiscoveredPacks_thenReturnEmpty() {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));
    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());

    // Act and Assert
    assertTrue(paperDatapackRegistrar.getDiscoveredPacks().isEmpty());
  }

  /**
   * Test {@link PaperDatapackRegistrar#getDiscoveredPacks()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#getDiscoveredPacks()}
   */
  @Test
  @DisplayName("Test getDiscoveredPacks(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperDatapackRegistrar.getDiscoveredPacks()"})
  void testGetDiscoveredPacks_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Pack> discoveredPacks = new HashMap<>();
    AdventureComponent title = new AdventureComponent(mock(Component.class));
    KnownPack knownPack = new KnownPack("Namespace", "42", "1.0.2");
    Optional<KnownPack> knownPackInfo = Optional.of(knownPack);

    PackLocationInfo location =
        new PackLocationInfo("42", title, PluginPackSource.INSTANCE, knownPackInfo);
    FileResourcesSupplier resources = new FileResourcesSupplier(OldUsersConverter.OLD_IPBANLIST);
    AdventureComponent description = new AdventureComponent(mock(Component.class));
    Metadata metadata =
        new Metadata(
            description, PackCompatibility.TOO_OLD, FeatureFlags.DEFAULT_FLAGS, new ArrayList<>());

    Pack pack =
        new Pack(
            location, resources, metadata, new PackSelectionConfig(true, Pack.Position.TOP, true));
    discoveredPacks.put("Key", pack);
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, discoveredPacks);

    // Act
    Map<String, DiscoveredDatapack> actualDiscoveredPacks =
        paperDatapackRegistrar.getDiscoveredPacks();

    // Assert
    assertEquals(1, actualDiscoveredPacks.size());
    DiscoveredDatapack getResult = actualDiscoveredPacks.get("Key");
    DatapackSource source = getResult.getSource();
    assertTrue(source instanceof DatapackSourceImpl);
    assertTrue(getResult instanceof PaperDiscoveredDatapack);
    assertEquals("42", getResult.getName());
    assertEquals("plugin", ((DatapackSourceImpl) source).name());
    assertEquals("plugin", source.toString());
    assertEquals(1, getResult.getRequiredFeatures().size());
    assertEquals(Compatibility.TOO_OLD, getResult.getCompatibility());
    assertTrue(getResult.isRequired());
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)} with {@code path},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(Path, String, Consumer) with 'path', 'id', 'configurer'; when PROFILING_RESULTS_DIR; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(Path, String, Consumer)"
  })
  void testDiscoverPackWithPathIdConfigurer_whenProfiling_results_dir_thenReturnNull()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            MetricsPersister.PROFILING_RESULTS_DIR, "42", mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)} with {@code path},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(Path, String, Consumer) with 'path', 'id', 'configurer'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(Path, String, Consumer)"
  })
  void testDiscoverPackWithPathIdConfigurer_whenPropertyIsJavaIoTmpdirIsEmptyString()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(System.getProperty("java.io.tmpdir"), ""), "42", mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)} with {@code path},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(Path, String, Consumer) with 'path', 'id', 'configurer'; when Property is 'java.io.tmpdir' is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(Path, String, Consumer)"
  })
  void testDiscoverPackWithPathIdConfigurer_whenPropertyIsJavaIoTmpdirIsFoo() throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo"), "42", mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)} with {@code path},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(Path, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(Path, String, Consumer) with 'path', 'id', 'configurer'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(Path, String, Consumer)"
  })
  void testDiscoverPackWithPathIdConfigurer_whenPropertyIsJavaIoTmpdirIsTestTxt()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String, Consumer)} with
   * {@code pluginMeta}, {@code path}, {@code id}, {@code configurer}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(PluginMeta, Path, String, Consumer) with 'pluginMeta', 'path', 'id', 'configurer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(PluginMeta, Path, String, Consumer)"
  })
  void testDiscoverPackWithPluginMetaPathIdConfigurer() throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            new PaperPluginMeta(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String, Consumer)} with
   * {@code pluginMeta}, {@code path}, {@code id}, {@code configurer}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(PluginMeta, Path, String, Consumer) with 'pluginMeta', 'path', 'id', 'configurer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(PluginMeta, Path, String, Consumer)"
  })
  void testDiscoverPackWithPluginMetaPathIdConfigurer2() throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            new PaperPluginMeta(),
            Paths.get(System.getProperty("java.io.tmpdir"), ""),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String, Consumer)} with
   * {@code pluginMeta}, {@code path}, {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When {@link MetricsPersister#PROFILING_RESULTS_DIR}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(PluginMeta, Path, String, Consumer) with 'pluginMeta', 'path', 'id', 'configurer'; when PROFILING_RESULTS_DIR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(PluginMeta, Path, String, Consumer)"
  })
  void testDiscoverPackWithPluginMetaPathIdConfigurer_whenProfiling_results_dir()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String, Consumer)} with
   * {@code pluginMeta}, {@code path}, {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(PluginMeta, Path, String,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(PluginMeta, Path, String, Consumer) with 'pluginMeta', 'path', 'id', 'configurer'; when Property is 'java.io.tmpdir' is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(PluginMeta, Path, String, Consumer)"
  })
  void testDiscoverPackWithPluginMetaPathIdConfigurer_whenPropertyIsJavaIoTmpdirIsFoo()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            new PaperPluginMeta(),
            Paths.get(System.getProperty("java.io.tmpdir"), "foo"),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(PluginMeta, URI, String, Consumer)} with {@code
   * pluginMeta}, {@code uri}, {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(PluginMeta, URI, String,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(PluginMeta, URI, String, Consumer) with 'pluginMeta', 'uri', 'id', 'configurer'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(PluginMeta, URI, String, Consumer)"
  })
  void testDiscoverPackWithPluginMetaUriIdConfigurer_thenReturnNull() throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            new PaperPluginMeta(),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)} with {@code uri},
   * {@code id}, {@code configurer}.
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)}
   */
  @Test
  @DisplayName("Test discoverPack(URI, String, Consumer) with 'uri', 'id', 'configurer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(URI, String, Consumer)"
  })
  void testDiscoverPackWithUriIdConfigurer() throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(
                    System.getProperty("java.io.tmpdir"),
                    "Discovering packs is not supported outside of lifecycle events")
                .toUri(),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)} with {@code uri},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string toUri.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(URI, String, Consumer) with 'uri', 'id', 'configurer'; when Property is 'java.io.tmpdir' is empty string toUri")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(URI, String, Consumer)"
  })
  void testDiscoverPackWithUriIdConfigurer_whenPropertyIsJavaIoTmpdirIsEmptyStringToUri()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(System.getProperty("java.io.tmpdir"), "").toUri(),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)} with {@code uri},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toUri.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(URI, String, Consumer) with 'uri', 'id', 'configurer'; when Property is 'java.io.tmpdir' is 'foo' toUri")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(URI, String, Consumer)"
  })
  void testDiscoverPackWithUriIdConfigurer_whenPropertyIsJavaIoTmpdirIsFooToUri()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri(),
            "42",
            mock(Consumer.class)));
  }

  /**
   * Test {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)} with {@code uri},
   * {@code id}, {@code configurer}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapackRegistrar#discoverPack(URI, String, Consumer)}
   */
  @Test
  @DisplayName(
      "Test discoverPack(URI, String, Consumer) with 'uri', 'id', 'configurer'; when Property is 'java.io.tmpdir' is 'test.txt' toUri")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DiscoveredDatapack PaperDatapackRegistrar.discoverPack(URI, String, Consumer)"
  })
  void testDiscoverPackWithUriIdConfigurer_whenPropertyIsJavaIoTmpdirIsTestTxtToUri()
      throws IOException {
    // Arrange
    DirectoryValidator symlinkValidator = new DirectoryValidator(mock(PathMatcher.class));

    PaperDatapackRegistrar paperDatapackRegistrar =
        new PaperDatapackRegistrar(symlinkValidator, new HashMap<>());
    PluginBootstrapContextImpl owner =
        new PluginBootstrapContextImpl(
            new PaperPluginMeta(),
            MetricsPersister.PROFILING_RESULTS_DIR,
            MinecraftServer.COMPONENT_LOGGER,
            MetricsPersister.PROFILING_RESULTS_DIR);
    paperDatapackRegistrar.setCurrentContext(owner);

    // Act and Assert
    assertNull(
        paperDatapackRegistrar.discoverPack(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(),
            "42",
            mock(Consumer.class)));
  }
}
