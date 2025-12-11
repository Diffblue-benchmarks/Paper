package io.papermc.paper.plugin.provider.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.provider.configuration.type.DependencyConfiguration;
import io.papermc.paper.plugin.provider.configuration.type.DependencyConfiguration.LoadOrder;
import io.papermc.paper.plugin.provider.configuration.type.PluginDependencyLifeCycle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.craftbukkit.util.ApiVersion;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginLoadOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperPluginMetaDiffblueTest {
  @Mock private ApiVersion apiVersion;

  @Mock private Map<PluginDependencyLifeCycle, Map<String, DependencyConfiguration>> map;

  @InjectMocks private PaperPluginMeta paperPluginMeta;

  /**
   * Test new {@link PaperPluginMeta} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PaperPluginMeta}
   */
  @Test
  @DisplayName("Test new PaperPluginMeta (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPluginMeta.<init>()"})
  void testNewPaperPluginMeta() {
    // Arrange and Act
    PaperPluginMeta actualPaperPluginMeta = new PaperPluginMeta();

    // Assert
    assertEquals("null vnull", actualPaperPluginMeta.getDisplayName());
    assertNull(actualPaperPluginMeta.getBootstrapper());
    assertNull(actualPaperPluginMeta.getDescription());
    assertNull(actualPaperPluginMeta.getLoader());
    assertNull(actualPaperPluginMeta.getLoggerPrefix());
    assertNull(actualPaperPluginMeta.getMainClass());
    assertNull(actualPaperPluginMeta.getName());
    assertNull(actualPaperPluginMeta.getVersion());
    assertNull(actualPaperPluginMeta.getWebsite());
    assertEquals(PermissionDefault.OP, actualPaperPluginMeta.getPermissionDefault());
    assertEquals(PluginLoadOrder.POSTWORLD, actualPaperPluginMeta.getLoadOrder());
    assertFalse(actualPaperPluginMeta.hasOpenClassloader());
    List<String> authors = actualPaperPluginMeta.getAuthors();
    assertTrue(authors.isEmpty());
    List<String> loadAfterPlugins = actualPaperPluginMeta.getLoadAfterPlugins();
    assertTrue(loadAfterPlugins.isEmpty());
    Map<String, DependencyConfiguration> bootstrapDependencies =
        actualPaperPluginMeta.getBootstrapDependencies();
    assertTrue(bootstrapDependencies.isEmpty());
    assertSame(authors, actualPaperPluginMeta.getContributors());
    assertSame(authors, actualPaperPluginMeta.getPermissions());
    assertSame(authors, actualPaperPluginMeta.getProvidedPlugins());
    assertSame(bootstrapDependencies, actualPaperPluginMeta.getServerDependencies());
    assertSame(loadAfterPlugins, actualPaperPluginMeta.getLoadBeforePlugins());
    assertSame(loadAfterPlugins, actualPaperPluginMeta.getPluginDependencies());
    assertSame(loadAfterPlugins, actualPaperPluginMeta.getPluginSoftDependencies());
  }

  /**
   * Test {@link PaperPluginMeta#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor).
   *   <li>Then {@link PaperPluginMeta} (default constructor) DisplayName is {@code Name vnull}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); given PaperPluginMeta (default constructor); then PaperPluginMeta (default constructor) DisplayName is 'Name vnull'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPluginMeta.setName(String)"})
  void testSetName_givenPaperPluginMeta_thenPaperPluginMetaDisplayNameIsNameVnull() {
    // Arrange
    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();

    // Act
    paperPluginMeta.setName("Name");

    // Assert
    assertEquals("Name vnull", paperPluginMeta.getDisplayName());
    assertEquals("Name", paperPluginMeta.getName());
    assertEquals("name", paperPluginMeta.namespace());
  }

  /**
   * Test {@link PaperPluginMeta#setVersion(String)}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor).
   *   <li>When {@code 1.0.2}.
   *   <li>Then {@link PaperPluginMeta} (default constructor) Version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#setVersion(String)}
   */
  @Test
  @DisplayName(
      "Test setVersion(String); given PaperPluginMeta (default constructor); when '1.0.2'; then PaperPluginMeta (default constructor) Version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPluginMeta.setVersion(String)"})
  void testSetVersion_givenPaperPluginMeta_when102_thenPaperPluginMetaVersionIs102() {
    // Arrange
    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();

    // Act
    paperPluginMeta.setVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", paperPluginMeta.getVersion());
    assertEquals("null v1.0.2", paperPluginMeta.getDisplayName());
  }

  /**
   * Test {@link PaperPluginMeta#getPluginDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginDependencies()}
   */
  @Test
  @DisplayName("Test getPluginDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginDependencies()"})
  void testGetPluginDependencies() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, false, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginDependencies = paperPluginMeta.getPluginDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualPluginDependencies.size());
    assertEquals("42", actualPluginDependencies.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getPluginDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginDependencies()}
   */
  @Test
  @DisplayName("Test getPluginDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginDependencies()"})
  void testGetPluginDependencies2() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, false));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginDependencies = paperPluginMeta.getPluginDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualPluginDependencies.size());
    assertEquals("42", actualPluginDependencies.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getPluginDependencies()}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginDependencies()}
   */
  @Test
  @DisplayName(
      "Test getPluginDependencies(); given PaperPluginMeta (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginDependencies()"})
  void testGetPluginDependencies_givenPaperPluginMeta_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getPluginDependencies().isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getPluginDependencies()}.
   *
   * <ul>
   *   <li>Then return first is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginDependencies()}
   */
  @Test
  @DisplayName("Test getPluginDependencies(); then return first is 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginDependencies()"})
  void testGetPluginDependencies_thenReturnFirstIsKey() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginDependencies = paperPluginMeta.getPluginDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualPluginDependencies.size());
    assertEquals("Key", actualPluginDependencies.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getPluginDependencies()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginDependencies()}
   */
  @Test
  @DisplayName("Test getPluginDependencies(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginDependencies()"})
  void testGetPluginDependencies_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginDependencies = paperPluginMeta.getPluginDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(2, actualPluginDependencies.size());
    assertEquals("42", actualPluginDependencies.get(0));
    assertEquals("Key", actualPluginDependencies.get(1));
  }

  /**
   * Test {@link PaperPluginMeta#getPluginSoftDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginSoftDependencies()}
   */
  @Test
  @DisplayName("Test getPluginSoftDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginSoftDependencies()"})
  void testGetPluginSoftDependencies() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginSoftDependencies = paperPluginMeta.getPluginSoftDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertTrue(actualPluginSoftDependencies.isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getPluginSoftDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginSoftDependencies()}
   */
  @Test
  @DisplayName("Test getPluginSoftDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginSoftDependencies()"})
  void testGetPluginSoftDependencies2() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginSoftDependencies = paperPluginMeta.getPluginSoftDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertTrue(actualPluginSoftDependencies.isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getPluginSoftDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginSoftDependencies()}
   */
  @Test
  @DisplayName("Test getPluginSoftDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginSoftDependencies()"})
  void testGetPluginSoftDependencies3() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, false, false));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginSoftDependencies = paperPluginMeta.getPluginSoftDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertTrue(actualPluginSoftDependencies.isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getPluginSoftDependencies()}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginSoftDependencies()}
   */
  @Test
  @DisplayName(
      "Test getPluginSoftDependencies(); given PaperPluginMeta (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginSoftDependencies()"})
  void testGetPluginSoftDependencies_givenPaperPluginMeta_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getPluginSoftDependencies().isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getPluginSoftDependencies()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getPluginSoftDependencies()}
   */
  @Test
  @DisplayName("Test getPluginSoftDependencies(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPluginSoftDependencies()"})
  void testGetPluginSoftDependencies_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, false, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualPluginSoftDependencies = paperPluginMeta.getPluginSoftDependencies();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualPluginSoftDependencies.size());
    assertEquals("Key", actualPluginSoftDependencies.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getLoadBeforePlugins()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadBeforePlugins()}
   */
  @Test
  @DisplayName("Test getLoadBeforePlugins()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadBeforePlugins()"})
  void testGetLoadBeforePlugins() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualLoadBeforePlugins = paperPluginMeta.getLoadBeforePlugins();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertTrue(actualLoadBeforePlugins.isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getLoadBeforePlugins()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadBeforePlugins()}
   */
  @Test
  @DisplayName("Test getLoadBeforePlugins()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadBeforePlugins()"})
  void testGetLoadBeforePlugins2() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualLoadBeforePlugins = paperPluginMeta.getLoadBeforePlugins();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertTrue(actualLoadBeforePlugins.isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getLoadBeforePlugins()}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadBeforePlugins()}
   */
  @Test
  @DisplayName(
      "Test getLoadBeforePlugins(); given PaperPluginMeta (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadBeforePlugins()"})
  void testGetLoadBeforePlugins_givenPaperPluginMeta_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getLoadBeforePlugins().isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getLoadBeforePlugins()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadBeforePlugins()}
   */
  @Test
  @DisplayName("Test getLoadBeforePlugins(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadBeforePlugins()"})
  void testGetLoadBeforePlugins_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.AFTER, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualLoadBeforePlugins = paperPluginMeta.getLoadBeforePlugins();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualLoadBeforePlugins.size());
    assertEquals("Key", actualLoadBeforePlugins.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getLoadAfterPlugins()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadAfterPlugins()}
   */
  @Test
  @DisplayName("Test getLoadAfterPlugins()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadAfterPlugins()"})
  void testGetLoadAfterPlugins() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.AFTER, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualLoadAfterPlugins = paperPluginMeta.getLoadAfterPlugins();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualLoadAfterPlugins.size());
    assertEquals("42", actualLoadAfterPlugins.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getLoadAfterPlugins()}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginMeta} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadAfterPlugins()}
   */
  @Test
  @DisplayName(
      "Test getLoadAfterPlugins(); given PaperPluginMeta (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadAfterPlugins()"})
  void testGetLoadAfterPlugins_givenPaperPluginMeta_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getLoadAfterPlugins().isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getLoadAfterPlugins()}.
   *
   * <ul>
   *   <li>Then return first is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadAfterPlugins()}
   */
  @Test
  @DisplayName("Test getLoadAfterPlugins(); then return first is 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadAfterPlugins()"})
  void testGetLoadAfterPlugins_thenReturnFirstIsKey() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualLoadAfterPlugins = paperPluginMeta.getLoadAfterPlugins();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(1, actualLoadAfterPlugins.size());
    assertEquals("Key", actualLoadAfterPlugins.get(0));
  }

  /**
   * Test {@link PaperPluginMeta#getLoadAfterPlugins()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperPluginMeta#getLoadAfterPlugins()}
   */
  @Test
  @DisplayName("Test getLoadAfterPlugins(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getLoadAfterPlugins()"})
  void testGetLoadAfterPlugins_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<String, DependencyConfiguration> stringDependencyConfigurationMap = new HashMap<>();
    stringDependencyConfigurationMap.put(
        "42", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    stringDependencyConfigurationMap.put(
        "Key", new DependencyConfiguration(LoadOrder.BEFORE, true, true));
    when(map.getOrDefault(
            Mockito.<Object>any(), Mockito.<Map<String, DependencyConfiguration>>any()))
        .thenReturn(stringDependencyConfigurationMap);

    // Act
    List<String> actualLoadAfterPlugins = paperPluginMeta.getLoadAfterPlugins();

    // Assert
    verify(map).getOrDefault(isA(Object.class), isA(Map.class));
    assertEquals(2, actualLoadAfterPlugins.size());
    assertEquals("42", actualLoadAfterPlugins.get(0));
    assertEquals("Key", actualLoadAfterPlugins.get(1));
  }

  /**
   * Test {@link PaperPluginMeta#getServerDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getServerDependencies()}
   */
  @Test
  @DisplayName("Test getServerDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPluginMeta.getServerDependencies()"})
  void testGetServerDependencies() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getServerDependencies().isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getBootstrapDependencies()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getBootstrapDependencies()}
   */
  @Test
  @DisplayName("Test getBootstrapDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PaperPluginMeta.getBootstrapDependencies()"})
  void testGetBootstrapDependencies() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getBootstrapDependencies().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperPluginMeta#getAuthors()}
   *   <li>{@link PaperPluginMeta#getBootstrapper()}
   *   <li>{@link PaperPluginMeta#getContributors()}
   *   <li>{@link PaperPluginMeta#getDescription()}
   *   <li>{@link PaperPluginMeta#getLoadOrder()}
   *   <li>{@link PaperPluginMeta#getLoader()}
   *   <li>{@link PaperPluginMeta#getLoggerPrefix()}
   *   <li>{@link PaperPluginMeta#getMainClass()}
   *   <li>{@link PaperPluginMeta#getName()}
   *   <li>{@link PaperPluginMeta#getProvidedPlugins()}
   *   <li>{@link PaperPluginMeta#getVersion()}
   *   <li>{@link PaperPluginMeta#getWebsite()}
   *   <li>{@link PaperPluginMeta#hasOpenClassloader()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PaperPluginMeta.getAuthors()",
    "String PaperPluginMeta.getBootstrapper()",
    "List PaperPluginMeta.getContributors()",
    "String PaperPluginMeta.getDescription()",
    "PluginLoadOrder PaperPluginMeta.getLoadOrder()",
    "String PaperPluginMeta.getLoader()",
    "String PaperPluginMeta.getLoggerPrefix()",
    "String PaperPluginMeta.getMainClass()",
    "String PaperPluginMeta.getName()",
    "List PaperPluginMeta.getProvidedPlugins()",
    "String PaperPluginMeta.getVersion()",
    "String PaperPluginMeta.getWebsite()",
    "boolean PaperPluginMeta.hasOpenClassloader()"
  })
  void testGettersAndSetters() {
    // Arrange
    PaperPluginMeta paperPluginMeta = new PaperPluginMeta();

    // Act
    List<String> actualAuthors = paperPluginMeta.getAuthors();
    String actualBootstrapper = paperPluginMeta.getBootstrapper();
    List<String> actualContributors = paperPluginMeta.getContributors();
    String actualDescription = paperPluginMeta.getDescription();
    PluginLoadOrder actualLoadOrder = paperPluginMeta.getLoadOrder();
    String actualLoader = paperPluginMeta.getLoader();
    String actualLoggerPrefix = paperPluginMeta.getLoggerPrefix();
    String actualMainClass = paperPluginMeta.getMainClass();
    String actualName = paperPluginMeta.getName();
    List<String> actualProvidedPlugins = paperPluginMeta.getProvidedPlugins();
    String actualVersion = paperPluginMeta.getVersion();
    String actualWebsite = paperPluginMeta.getWebsite();

    // Assert
    assertNull(actualBootstrapper);
    assertNull(actualDescription);
    assertNull(actualLoader);
    assertNull(actualLoggerPrefix);
    assertNull(actualMainClass);
    assertNull(actualName);
    assertNull(actualVersion);
    assertNull(actualWebsite);
    assertEquals(PluginLoadOrder.POSTWORLD, actualLoadOrder);
    assertFalse(paperPluginMeta.hasOpenClassloader());
    assertTrue(actualAuthors.isEmpty());
    assertSame(actualAuthors, actualContributors);
    assertSame(actualAuthors, actualProvidedPlugins);
  }

  /**
   * Test {@link PaperPluginMeta#getPermissions()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperPluginMeta.getPermissions()"})
  void testGetPermissions() {
    // Arrange, Act and Assert
    assertTrue(new PaperPluginMeta().getPermissions().isEmpty());
  }

  /**
   * Test {@link PaperPluginMeta#getPermissionDefault()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getPermissionDefault()}
   */
  @Test
  @DisplayName("Test getPermissionDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PermissionDefault PaperPluginMeta.getPermissionDefault()"})
  void testGetPermissionDefault() {
    // Arrange, Act and Assert
    assertEquals(PermissionDefault.OP, new PaperPluginMeta().getPermissionDefault());
  }

  /**
   * Test {@link PaperPluginMeta#getAPIVersion()}.
   *
   * <p>Method under test: {@link PaperPluginMeta#getAPIVersion()}
   */
  @Test
  @DisplayName("Test getAPIVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperPluginMeta.getAPIVersion()"})
  void testGetAPIVersion() {
    // Arrange
    when(apiVersion.getVersionString()).thenReturn("1.0.2");

    // Act
    String actualAPIVersion = paperPluginMeta.getAPIVersion();

    // Assert
    verify(apiVersion).getVersionString();
    assertEquals("1.0.2", actualAPIVersion);
  }
}
