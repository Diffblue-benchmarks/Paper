package io.papermc.paper.configuration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.leangen.geantyref.TypeToken;
import io.papermc.paper.configuration.Configurations.ContextKey;
import io.papermc.paper.configuration.Configurations.ContextMap;
import io.papermc.paper.configuration.Configurations.ContextMap.Builder;
import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.ConfigurationOptions;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;
import org.spongepowered.configurate.util.CheckedFunction;

class ConfigurationsDiffblueTest {
  /**
   * Test ContextKey {@link ContextKey#ContextKey(Class, String)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ContextKey#ContextKey(Class, String)}
   */
  @Test
  @DisplayName(
      "Test ContextKey new ContextKey(Class, String); when 'java.lang.Object'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContextKey.<init>(Class, String)"})
  void testContextKeyNewContextKey_whenJavaLangObject_thenReturnName() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    ContextKey<Object> actualContextKey = new ContextKey<>(type, "Name");

    // Assert
    assertEquals("Name", actualContextKey.name());
    TypeToken<Object> typeResult = actualContextKey.type();
    AnnotatedType annotatedType = typeResult.getAnnotatedType();
    assertNull(annotatedType.getAnnotatedOwnerType());
    assertEquals(annotatedType, typeResult.getCanonicalType());
  }

  /**
   * Test ContextKey {@link ContextKey#toString()}.
   *
   * <p>Method under test: {@link ContextKey#toString()}
   */
  @Test
  @DisplayName("Test ContextKey toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ContextKey.toString()"})
  void testContextKeyToString() {
    // Arrange
    Class<Object> type = Object.class;
    ContextKey<Object> contextKey = new ContextKey<>(type, "Name");

    // Act and Assert
    assertEquals("ContextKey{Name}", contextKey.toString());
  }

  /**
   * Test ContextMap {@link ContextMap#get(ContextKey)}.
   *
   * <p>Method under test: {@link ContextMap#get(ContextKey)}
   */
  @Test
  @DisplayName("Test ContextMap get(ContextKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ContextMap.get(ContextKey)"})
  void testContextMapGet() {
    // Arrange
    ContextMap contextMap = ContextMap.builder().build();

    // Act
    Object actualGetResult = contextMap.get(new ContextKey<>(mock(TypeToken.class), "Name"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test ContextMap {@link ContextMap#has(ContextKey)}.
   *
   * <p>Method under test: {@link ContextMap#has(ContextKey)}
   */
  @Test
  @DisplayName("Test ContextMap has(ContextKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextMap.has(ContextKey)"})
  void testContextMapHas() {
    // Arrange
    ContextMap contextMap = ContextMap.builder().build();

    // Act
    boolean actualHasResult = contextMap.has(new ContextKey<>(mock(TypeToken.class), "Name"));

    // Assert
    assertFalse(actualHasResult);
  }

  /**
   * Test ContextMap {@link ContextMap#isDefaultWorldContext()}.
   *
   * <p>Method under test: {@link ContextMap#isDefaultWorldContext()}
   */
  @Test
  @DisplayName("Test ContextMap isDefaultWorldContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContextMap.isDefaultWorldContext()"})
  void testContextMapIsDefaultWorldContext() {
    // Arrange, Act and Assert
    assertThrows(
        NoSuchElementException.class, () -> ContextMap.builder().build().isDefaultWorldContext());
  }

  /**
   * Test ContextMap {@link ContextMap#require(ContextKey)}.
   *
   * <p>Method under test: {@link ContextMap#require(ContextKey)}
   */
  @Test
  @DisplayName("Test ContextMap require(ContextKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ContextMap.require(ContextKey)"})
  void testContextMapRequire() {
    // Arrange
    ContextMap contextMap = ContextMap.builder().build();

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () -> contextMap.require(new ContextKey<>(mock(TypeToken.class), "Name")));
  }

  /**
   * Test ContextMap_Builder {@link Builder#put(ContextKey)} with {@code key}.
   *
   * <p>Method under test: {@link Builder#put(ContextKey)}
   */
  @Test
  @DisplayName("Test ContextMap_Builder put(ContextKey) with 'key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.put(ContextKey)"})
  void testContextMap_BuilderPutWithKey() {
    // Arrange
    Builder builderResult = ContextMap.builder();

    // Act
    Builder actualPutResult = builderResult.put(new ContextKey<>(mock(TypeToken.class), "Name"));

    // Assert
    assertSame(builderResult, actualPutResult);
  }

  /**
   * Test ContextMap_Builder {@link Builder#put(ContextKey, Object)} with {@code key}, {@code
   * value}.
   *
   * <p>Method under test: {@link Builder#put(ContextKey, Object)}
   */
  @Test
  @DisplayName("Test ContextMap_Builder put(ContextKey, Object) with 'key', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.put(ContextKey, Object)"})
  void testContextMap_BuilderPutWithKeyValue() {
    // Arrange
    Builder builderResult = ContextMap.builder();

    // Act
    Builder actualPutResult =
        builderResult.put(
            new ContextKey<>(mock(TypeToken.class), "Name"),
            ConfigurationTransformation.WILDCARD_OBJECT);

    // Assert
    assertSame(builderResult, actualPutResult);
  }

  /**
   * Test {@link Configurations#creator(Class, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link ConfigurationNode#require(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#creator(Class, boolean)}
   */
  @Test
  @DisplayName("Test creator(Class, boolean); when 'false'; then calls require(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.creator(Class, boolean)"})
  void testCreator_whenFalse_thenCallsRequire() throws Exception {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    CheckedFunction<ConfigurationNode, Object, SerializationException> actualCreatorResult =
        Configurations.creator(type, false);
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.require(Object.class))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    actualCreatorResult.apply(configurationNode);

    // Assert
    verify(configurationNode).require(isA(Class.class));
  }

  /**
   * Test {@link Configurations#creator(Class, boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then calls {@link ConfigurationNode#set(Type, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#creator(Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test creator(Class, boolean); when 'java.lang.Object'; then calls set(Type, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.creator(Class, boolean)"})
  void testCreator_whenJavaLangObject_thenCallsSet() throws Exception {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    CheckedFunction<ConfigurationNode, Object, SerializationException> actualCreatorResult =
        Configurations.creator(type, true);
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Type>any(), Mockito.<Object>any()))
        .thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.require(Object.class))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);
    actualCreatorResult.apply(configurationNode);

    // Assert
    verify(configurationNode).require(isA(Class.class));
    verify(configurationNode).set(isA(Type.class), isA(Object.class));
  }

  /**
   * Test {@link Configurations#creator(Class, boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#creator(Class, boolean)}
   */
  @Test
  @DisplayName("Test creator(Class, boolean); when 'java.lang.Object'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.creator(Class, boolean)"})
  void testCreator_whenJavaLangObject_thenDoesNotThrow() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    assertDoesNotThrow(() -> Configurations.creator(type, true));
  }

  /**
   * Test {@link Configurations#creator(Class, boolean)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#creator(Class, boolean)}
   */
  @Test
  @DisplayName(
      "Test creator(Class, boolean); when 'java.lang.Object'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.creator(Class, boolean)"})
  void testCreator_whenJavaLangObject_thenThrowIllegalStateException() throws Exception {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    CheckedFunction<ConfigurationNode, Object, SerializationException> actualCreatorResult =
        Configurations.creator(type, true);
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.require(Object.class)).thenThrow(new IllegalStateException());

    // Assert
    assertThrows(IllegalStateException.class, () -> actualCreatorResult.apply(configurationNode));
    verify(configurationNode).require(isA(Class.class));
  }

  /**
   * Test {@link Configurations#creator(Class, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#creator(Class, boolean)}
   */
  @Test
  @DisplayName("Test creator(Class, boolean); when 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.creator(Class, boolean)"})
  void testCreator_whenNull_thenThrowIllegalStateException() throws Exception {
    // Arrange and Act
    CheckedFunction<ConfigurationNode, Object, SerializationException> actualCreatorResult =
        Configurations.creator(null, true);
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.set(Mockito.<Type>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());

    // Assert
    assertThrows(IllegalStateException.class, () -> actualCreatorResult.apply(configurationNode));
    verify(configurationNode).set((Type) isNull(), (Object) isNull());
  }

  /**
   * Test {@link Configurations#reloader(Class, Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then calls {@link ConfigurationOptions#serializers()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#reloader(Class, Object)}
   */
  @Test
  @DisplayName("Test reloader(Class, Object); when 'java.lang.Object'; then calls serializers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.reloader(Class, Object)"})
  void testReloader_whenJavaLangObject_thenCallsSerializers() throws Exception {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    CheckedFunction<ConfigurationNode, Object, SerializationException> actualReloaderResult =
        Configurations.reloader(type, ConfigurationTransformation.WILDCARD_OBJECT);
    ConfigurationOptions configurationOptions = mock(ConfigurationOptions.class);
    when(configurationOptions.serializers()).thenThrow(new IllegalStateException());
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.options()).thenReturn(configurationOptions);

    // Assert
    assertThrows(IllegalStateException.class, () -> actualReloaderResult.apply(configurationNode));
    verify(configurationNode).options();
    verify(configurationOptions).serializers();
  }

  /**
   * Test {@link Configurations#reloader(Class, Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#reloader(Class, Object)}
   */
  @Test
  @DisplayName("Test reloader(Class, Object); when 'java.lang.Object'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.reloader(Class, Object)"})
  void testReloader_whenJavaLangObject_thenDoesNotThrow() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    assertDoesNotThrow(
        () -> Configurations.reloader(type, ConfigurationTransformation.WILDCARD_OBJECT));
  }

  /**
   * Test {@link Configurations#reloader(Class, Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#reloader(Class, Object)}
   */
  @Test
  @DisplayName(
      "Test reloader(Class, Object); when 'java.lang.Object'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckedFunction Configurations.reloader(Class, Object)"})
  void testReloader_whenJavaLangObject_thenThrowIllegalStateException() throws Exception {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    CheckedFunction<ConfigurationNode, Object, SerializationException> actualReloaderResult =
        Configurations.reloader(type, ConfigurationTransformation.WILDCARD_OBJECT);
    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.options()).thenThrow(new IllegalStateException());

    // Assert
    assertThrows(IllegalStateException.class, () -> actualReloaderResult.apply(configurationNode));
    verify(configurationNode).options();
  }

  /**
   * Test {@link Configurations#initializeGlobalConfiguration(RegistryAccess, CheckedFunction)} with
   * {@code registryAccess}, {@code creator}.
   *
   * <p>Method under test: {@link Configurations#initializeGlobalConfiguration(RegistryAccess,
   * CheckedFunction)}
   */
  @Test
  @DisplayName(
      "Test initializeGlobalConfiguration(RegistryAccess, CheckedFunction) with 'registryAccess', 'creator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object Configurations.initializeGlobalConfiguration(RegistryAccess, CheckedFunction)"
  })
  void testInitializeGlobalConfigurationWithRegistryAccessCreator() throws Exception {
    // Arrange
    PaperConfigurations paperConfigurations =
        new PaperConfigurations(MetricsPersister.PROFILING_RESULTS_DIR);
    ImmutableRegistryAccess registryAccess = new ImmutableRegistryAccess(new ArrayList<>());

    CheckedFunction<ConfigurationNode, GlobalConfiguration, SerializationException> creator =
        mock(CheckedFunction.class);
    when(creator.apply(Mockito.<ConfigurationNode>any())).thenThrow(new ConfigurateException());

    // Act and Assert
    assertThrows(
        ConfigurateException.class,
        () -> paperConfigurations.initializeGlobalConfiguration(registryAccess, creator));
    verify(creator).apply(isA(ConfigurationNode.class));
  }

  /**
   * Test {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}.
   *
   * <p>Method under test: {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}
   */
  @Test
  @DisplayName("Test verifyGlobalConfigVersion(ConfigurationNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyGlobalConfigVersion(ConfigurationNode)"})
  void testVerifyGlobalConfigVersion() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenThrow(new IllegalStateException());

    ConfigurationNode globalNode = mock(ConfigurationNode.class);
    when(globalNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> setupResult.verifyGlobalConfigVersion(globalNode));
    verify(globalNode).node(isA(Object[].class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}.
   *
   * <p>Method under test: {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}
   */
  @Test
  @DisplayName("Test verifyGlobalConfigVersion(ConfigurationNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyGlobalConfigVersion(ConfigurationNode)"})
  void testVerifyGlobalConfigVersion2() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenThrow(new IllegalStateException());
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode globalNode = mock(ConfigurationNode.class);
    when(globalNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> setupResult.verifyGlobalConfigVersion(globalNode));
    verify(globalNode).node(isA(Object[].class));
    verify(configurationNode).raw(isA(Object.class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#raw(Object)} return {@link
   *       ConfigurationNode}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test verifyGlobalConfigVersion(ConfigurationNode); given ConfigurationNode raw(Object) return ConfigurationNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyGlobalConfigVersion(ConfigurationNode)"})
  void testVerifyGlobalConfigVersion_givenConfigurationNodeRawReturnConfigurationNode()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode globalNode = mock(ConfigurationNode.class);
    when(globalNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.verifyGlobalConfigVersion(globalNode);

    // Assert
    verify(globalNode).node(isA(Object[].class));
    verify(configurationNode).raw(isA(Object.class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}
   */
  @Test
  @DisplayName("Test verifyGlobalConfigVersion(ConfigurationNode); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyGlobalConfigVersion(ConfigurationNode)"})
  void testVerifyGlobalConfigVersion_givenIllegalStateException() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode globalNode = mock(ConfigurationNode.class);
    when(globalNode.node(isA(Object[].class))).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> setupResult.verifyGlobalConfigVersion(globalNode));
    verify(globalNode).node(isA(Object[].class));
  }

  /**
   * Test {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#getInt()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyGlobalConfigVersion(ConfigurationNode)}
   */
  @Test
  @DisplayName("Test verifyGlobalConfigVersion(ConfigurationNode); then calls getInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyGlobalConfigVersion(ConfigurationNode)"})
  void testVerifyGlobalConfigVersion_thenCallsGetInt() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(false);
    when(configurationNode.getInt()).thenReturn(1);

    ConfigurationNode globalNode = mock(ConfigurationNode.class);
    when(globalNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.verifyGlobalConfigVersion(globalNode);

    // Assert
    verify(configurationNode).getInt();
    verify(globalNode).node(isA(Object[].class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#createWorldConfig(ContextMap, CheckedFunction)} with {@code
   * contextMap}, {@code creator}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#createWorldConfig(ContextMap, CheckedFunction)}
   */
  @Test
  @DisplayName(
      "Test createWorldConfig(ContextMap, CheckedFunction) with 'contextMap', 'creator'; given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Configurations.createWorldConfig(ContextMap, CheckedFunction)"})
  void testCreateWorldConfigWithContextMapCreator_givenIllegalStateException() throws IOException {
    // Arrange
    PaperConfigurations paperConfigurations =
        new PaperConfigurations(MetricsPersister.PROFILING_RESULTS_DIR);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.isDefaultWorldContext()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> paperConfigurations.createWorldConfig(contextMap, mock(CheckedFunction.class)));
    verify(contextMap).isDefaultWorldContext();
  }

  /**
   * Test {@link Configurations#createWorldConfig(ContextMap, CheckedFunction)} with {@code
   * contextMap}, {@code creator}.
   *
   * <ul>
   *   <li>Then calls {@link ContextMap#require(ContextKey)}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#createWorldConfig(ContextMap, CheckedFunction)}
   */
  @Test
  @DisplayName(
      "Test createWorldConfig(ContextMap, CheckedFunction) with 'contextMap', 'creator'; then calls require(ContextKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Configurations.createWorldConfig(ContextMap, CheckedFunction)"})
  void testCreateWorldConfigWithContextMapCreator_thenCallsRequire() throws IOException {
    // Arrange
    PaperConfigurations paperConfigurations =
        new PaperConfigurations(MetricsPersister.PROFILING_RESULTS_DIR);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.isDefaultWorldContext()).thenReturn(false);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(new ImmutableRegistryAccess(new ArrayList<>()));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> paperConfigurations.createWorldConfig(contextMap, mock(CheckedFunction.class)));
    verify(contextMap).isDefaultWorldContext();
    verify(contextMap).require(isA(ContextKey.class));
  }

  /**
   * Test {@link Configurations#verifyWorldConfigVersion(ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyWorldConfigVersion(ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test verifyWorldConfigVersion(ContextMap, ConfigurationNode); given ConfigurationNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyWorldConfigVersion(ContextMap, ConfigurationNode)"})
  void testVerifyWorldConfigVersion_givenConfigurationNode() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenThrow(new IllegalStateException());

    ConfigurationNode worldNode = mock(ConfigurationNode.class);
    when(worldNode.node(isA(Object[].class))).thenReturn(mock(ConfigurationNode.class));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> setupResult.verifyWorldConfigVersion(contextMap, worldNode));
    verify(contextMap).require(isA(ContextKey.class));
    verify(worldNode).node(isA(Object[].class));
  }

  /**
   * Test {@link Configurations#verifyWorldConfigVersion(ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#raw(Object)} return {@link
   *       ConfigurationNode}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyWorldConfigVersion(ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test verifyWorldConfigVersion(ContextMap, ConfigurationNode); given ConfigurationNode raw(Object) return ConfigurationNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyWorldConfigVersion(ContextMap, ConfigurationNode)"})
  void testVerifyWorldConfigVersion_givenConfigurationNodeRawReturnConfigurationNode()
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
        .thenReturn(Configuration.VERSION_FIELD);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode worldNode = mock(ConfigurationNode.class);
    when(worldNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.verifyWorldConfigVersion(contextMap, worldNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(worldNode).node(isA(Object[].class));
    verify(configurationNode).raw(isA(Object.class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyWorldConfigVersion(ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationNode} {@link ConfigurationNode#raw(Object)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyWorldConfigVersion(ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test verifyWorldConfigVersion(ContextMap, ConfigurationNode); given ConfigurationNode raw(Object) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyWorldConfigVersion(ContextMap, ConfigurationNode)"})
  void testVerifyWorldConfigVersion_givenConfigurationNodeRawThrowIllegalStateException()
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
        .thenReturn(Configuration.VERSION_FIELD);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenThrow(new IllegalStateException());
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode worldNode = mock(ConfigurationNode.class);
    when(worldNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> setupResult.verifyWorldConfigVersion(contextMap, worldNode));
    verify(contextMap).require(isA(ContextKey.class));
    verify(worldNode).node(isA(Object[].class));
    verify(configurationNode).raw(isA(Object.class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyWorldConfigVersion(ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Given {@link Configurations#WORLD_DEFAULTS}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyWorldConfigVersion(ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName("Test verifyWorldConfigVersion(ContextMap, ConfigurationNode); given WORLD_DEFAULTS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyWorldConfigVersion(ContextMap, ConfigurationNode)"})
  void testVerifyWorldConfigVersion_givenWorld_defaults() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(Configurations.WORLD_DEFAULTS);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.raw(Mockito.<Object>any())).thenReturn(mock(ConfigurationNode.class));
    when(configurationNode.virtual()).thenReturn(true);

    ConfigurationNode worldNode = mock(ConfigurationNode.class);
    when(worldNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.verifyWorldConfigVersion(contextMap, worldNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(worldNode).node(isA(Object[].class));
    verify(configurationNode).raw(isA(Object.class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyWorldConfigVersion(ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>Then calls {@link ConfigurationNode#getInt()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyWorldConfigVersion(ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName("Test verifyWorldConfigVersion(ContextMap, ConfigurationNode); then calls getInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyWorldConfigVersion(ContextMap, ConfigurationNode)"})
  void testVerifyWorldConfigVersion_thenCallsGetInt() throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);

    ContextMap contextMap = mock(ContextMap.class);
    when(contextMap.require(Mockito.<ContextKey<Object>>any()))
        .thenReturn(Configuration.VERSION_FIELD);

    ConfigurationNode configurationNode = mock(ConfigurationNode.class);
    when(configurationNode.virtual()).thenReturn(false);
    when(configurationNode.getInt()).thenReturn(1);

    ConfigurationNode worldNode = mock(ConfigurationNode.class);
    when(worldNode.node(isA(Object[].class))).thenReturn(configurationNode);

    // Act
    setupResult.verifyWorldConfigVersion(contextMap, worldNode);

    // Assert
    verify(contextMap).require(isA(ContextKey.class));
    verify(configurationNode).getInt();
    verify(worldNode).node(isA(Object[].class));
    verify(configurationNode).virtual();
  }

  /**
   * Test {@link Configurations#verifyWorldConfigVersion(ContextMap, ConfigurationNode)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationNode} {@link ConfigurationNode#node(Object[])} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link Configurations#verifyWorldConfigVersion(ContextMap,
   * ConfigurationNode)}
   */
  @Test
  @DisplayName(
      "Test verifyWorldConfigVersion(ContextMap, ConfigurationNode); when ConfigurationNode node(Object[]) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Configurations.verifyWorldConfigVersion(ContextMap, ConfigurationNode)"})
  void testVerifyWorldConfigVersion_whenConfigurationNodeNodeThrowIllegalStateException()
      throws Exception {
    // Arrange
    PaperConfigurations setupResult =
        PaperConfigurations.setup(
            MetricsPersister.PROFILING_RESULTS_DIR,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"),
            MetricsPersister.PROFILING_RESULTS_DIR,
            OldUsersConverter.OLD_IPBANLIST);
    ContextMap contextMap = mock(ContextMap.class);

    ConfigurationNode worldNode = mock(ConfigurationNode.class);
    when(worldNode.node(isA(Object[].class))).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> setupResult.verifyWorldConfigVersion(contextMap, worldNode));
    verify(worldNode).node(isA(Object[].class));
  }
}
