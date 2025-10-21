package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemorySectionDiffblueTest {
  /**
   * Test {@link MemorySection#MemorySection()}.
   *
   * <p>Method under test: {@link MemorySection#MemorySection()}
   */
  @Test
  @DisplayName("Test new MemorySection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.<init>()"})
  void testNewMemorySection() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new MemorySection());
  }

  /**
   * Test {@link MemorySection#MemorySection(ConfigurationSection, String)}.
   *
   * <ul>
   *   <li>Then Root return {@link MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#MemorySection(ConfigurationSection, String)}
   */
  @Test
  @DisplayName(
      "Test new MemorySection(ConfigurationSection, String); then Root return MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.<init>(ConfigurationSection, String)"})
  void testNewMemorySection_thenRootReturnMemoryConfiguration() {
    // Arrange
    MemoryConfiguration parent = new MemoryConfiguration();
    MemorySection parent2 = new MemorySection(parent, "Parent cannot be null");

    // Act
    MemorySection actualMemorySection = new MemorySection(parent2, "Path");

    // Assert
    Configuration root = actualMemorySection.getRoot();
    assertTrue(root instanceof MemoryConfiguration);
    assertEquals("", root.getCurrentPath());
    assertEquals("", root.getName());
    assertEquals("Parent cannot be null.Path", actualMemorySection.getCurrentPath());
    assertNull(root.getDefaults());
    assertNull(root.getDefaultSection());
    assertNull(root.getParent());
    assertTrue(((MemoryConfiguration) root).map.isEmpty());
    assertSame(parent, root.getRoot());
    assertSame(parent2, actualMemorySection.getParent());
    assertSame(parent.options, ((MemoryConfiguration) root).options);
  }

  /**
   * Test {@link MemorySection#MemorySection(ConfigurationSection, String)}.
   *
   * <ul>
   *   <li>When {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return CurrentPath is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#MemorySection(ConfigurationSection, String)}
   */
  @Test
  @DisplayName(
      "Test new MemorySection(ConfigurationSection, String); when MemoryConfiguration(); then return CurrentPath is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.<init>(ConfigurationSection, String)"})
  void testNewMemorySection_whenMemoryConfiguration_thenReturnCurrentPathIsPath() {
    // Arrange
    MemoryConfiguration parent = new MemoryConfiguration();

    // Act
    MemorySection actualMemorySection = new MemorySection(parent, "Path");

    // Assert
    assertEquals("Path", actualMemorySection.getCurrentPath());
    MemoryConfigurationOptions memoryConfigurationOptions = parent.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(parent, memoryConfigurationOptions.configuration());
    ConfigurationSection parent2 = actualMemorySection.getParent();
    assertSame(parent, parent2);
    assertSame(parent2, actualMemorySection.getRoot());
  }

  /**
   * Test {@link MemorySection#getKeys(boolean)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getKeys(boolean)}
   */
  @Test
  @DisplayName("Test getKeys(boolean); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MemorySection.getKeys(boolean)"})
  void testGetKeys_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Set<String> actualKeys = memoryConfiguration.getKeys(false);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualKeys.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getValues(boolean)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getValues(boolean)}
   */
  @Test
  @DisplayName("Test getValues(boolean); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MemorySection.getValues(boolean)"})
  void testGetValues_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Map<String, Object> actualValues = memoryConfiguration.getValues(false);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualValues.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#contains(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.contains(String)"})
  void testContainsWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.contains("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#contains(String, boolean)} with {@code path}, {@code ignoreDefault}.
   *
   * <p>Method under test: {@link MemorySection#contains(String, boolean)}
   */
  @Test
  @DisplayName("Test contains(String, boolean) with 'path', 'ignoreDefault'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.contains(String, boolean)"})
  void testContainsWithPathIgnoreDefault() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualContainsResult = memoryConfiguration.contains("Path", true);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualContainsResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#contains(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#contains(String)}
   */
  @Test
  @DisplayName(
      "Test contains(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.contains(String)"})
  void testContainsWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualContainsResult = memoryConfiguration.contains("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualContainsResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#contains(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) {@link MemoryConfiguration#options}
   *       {@link YamlConfigurationOptions}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#contains(String)}
   */
  @Test
  @DisplayName(
      "Test contains(String) with 'path'; then YamlConfiguration (default constructor) options YamlConfigurationOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.contains(String)"})
  void testContainsWithPath_thenYamlConfigurationOptionsYamlConfigurationOptions() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    boolean actualContainsResult = yamlConfiguration.contains("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(actualContainsResult);
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isSet(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isSet(String)}
   */
  @Test
  @DisplayName("Test isSet(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isSet(String)"})
  void testIsSet_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsSetResult = memoryConfiguration.isSet("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsSetResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getDefaultSection()}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDefaultSection()}
   */
  @Test
  @DisplayName("Test getDefaultSection(); given MemoryConfiguration(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.getDefaultSection()"})
  void testGetDefaultSection_givenMemoryConfiguration_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MemoryConfiguration().getDefaultSection());
  }

  /**
   * Test {@link MemorySection#getDefaultSection()}.
   *
   * <ul>
   *   <li>Then return {@link MemoryConfiguration#MemoryConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDefaultSection()}
   */
  @Test
  @DisplayName("Test getDefaultSection(); then return MemoryConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.getDefaultSection()"})
  void testGetDefaultSection_thenReturnMemoryConfiguration() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();

    // Act and Assert
    assertSame(defaults, new MemoryConfiguration(defaults).getDefaultSection());
  }

  /**
   * Test {@link MemorySection#set(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link MemorySection#map} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#set(String, Object)}
   */
  @Test
  @DisplayName(
      "Test set(String, Object); given MemoryConfiguration(); then MemoryConfiguration() map size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.set(String, Object)"})
  void testSet_givenMemoryConfiguration_thenMemoryConfigurationMapSizeIsOne() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    memoryConfiguration.set("Path", "Value");

    // Assert
    Map<String, SectionPathData> stringSectionPathDataMap = memoryConfiguration.map;
    assertEquals(1, stringSectionPathDataMap.size());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertEquals("Value", getResult.getData());
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    List<String> comments = getResult.getComments();
    assertTrue(comments.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(comments, getResult.getInlineComments());
  }

  /**
   * Test {@link MemorySection#get(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.get(String)"})
  void testGetWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.get("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#get(String, Object)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return {@code Def}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#get(String, Object)}
   */
  @Test
  @DisplayName(
      "Test get(String, Object) with 'path', 'def'; given MemoryConfiguration(); then return 'Def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.get(String, Object)"})
  void testGetWithPathDef_givenMemoryConfiguration_thenReturnDef() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act and Assert
    assertEquals("Def", memoryConfiguration.get("Path", "Def"));
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#get(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.get(String)"})
  void testGetWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Object actualGetResult = memoryConfiguration.get("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualGetResult);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#get(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) {@link MemoryConfiguration#options}
   *       {@link YamlConfigurationOptions}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String) with 'path'; then YamlConfiguration (default constructor) options YamlConfigurationOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.get(String)"})
  void testGetWithPath_thenYamlConfigurationOptionsYamlConfigurationOptions() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    Object actualGetResult = yamlConfiguration.get("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    assertEquals("Value", actualGetResult);
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#createSection(String, Map)} with {@code path}, {@code map}.
   *
   * <ul>
   *   <li>Then return CurrentPath is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createSection(String, Map)}
   */
  @Test
  @DisplayName(
      "Test createSection(String, Map) with 'path', 'map'; then return CurrentPath is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.createSection(String, Map)"})
  void testCreateSectionWithPathMap_thenReturnCurrentPathIsPath() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    ConfigurationSection actualCreateSectionResult =
        memoryConfiguration.createSection("Path", new HashMap<>());

    // Assert
    assertTrue(actualCreateSectionResult instanceof MemorySection);
    assertEquals("Path", actualCreateSectionResult.getCurrentPath());
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    ConfigurationSection parent = actualCreateSectionResult.getParent();
    assertSame(memoryConfiguration, parent);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(parent, actualCreateSectionResult.getRoot());
  }

  /**
   * Test {@link MemorySection#createSection(String, Map)} with {@code path}, {@code map}.
   *
   * <ul>
   *   <li>Then Root return {@link MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createSection(String, Map)}
   */
  @Test
  @DisplayName(
      "Test createSection(String, Map) with 'path', 'map'; then Root return MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.createSection(String, Map)"})
  void testCreateSectionWithPathMap_thenRootReturnMemoryConfiguration() {
    // Arrange
    MemoryConfiguration parent = new MemoryConfiguration();
    MemorySection memorySection = new MemorySection(parent, "Path");

    // Act
    ConfigurationSection actualCreateSectionResult =
        memorySection.createSection("Path", new HashMap<>());

    // Assert
    Configuration root = actualCreateSectionResult.getRoot();
    assertTrue(root instanceof MemoryConfiguration);
    assertTrue(actualCreateSectionResult instanceof MemorySection);
    assertEquals("", root.getCurrentPath());
    assertEquals("", root.getName());
    assertEquals("Path.Path", actualCreateSectionResult.getCurrentPath());
    assertNull(root.getDefaults());
    assertNull(root.getDefaultSection());
    assertNull(root.getParent());
    assertTrue(((MemoryConfiguration) root).map.isEmpty());
    assertSame(parent, root.getRoot());
    assertSame(memorySection, actualCreateSectionResult.getParent());
    assertSame(parent.options, ((MemoryConfiguration) root).options);
  }

  /**
   * Test {@link MemorySection#createSection(String)} with {@code path}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return CurrentPath is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createSection(String)}
   */
  @Test
  @DisplayName(
      "Test createSection(String) with 'path'; given MemoryConfiguration(); then return CurrentPath is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.createSection(String)"})
  void testCreateSectionWithPath_givenMemoryConfiguration_thenReturnCurrentPathIsPath() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    ConfigurationSection actualCreateSectionResult = memoryConfiguration.createSection("Path");

    // Assert
    assertTrue(actualCreateSectionResult instanceof MemorySection);
    assertEquals("Path", actualCreateSectionResult.getCurrentPath());
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    ConfigurationSection parent = actualCreateSectionResult.getParent();
    assertSame(memoryConfiguration, parent);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(parent, actualCreateSectionResult.getRoot());
  }

  /**
   * Test {@link MemorySection#createSection(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then Root return {@link MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createSection(String)}
   */
  @Test
  @DisplayName("Test createSection(String) with 'path'; then Root return MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.createSection(String)"})
  void testCreateSectionWithPath_thenRootReturnMemoryConfiguration() {
    // Arrange
    MemoryConfiguration parent = new MemoryConfiguration();
    MemorySection memorySection = new MemorySection(parent, "Path");

    // Act
    ConfigurationSection actualCreateSectionResult = memorySection.createSection("Path");

    // Assert
    Configuration root = actualCreateSectionResult.getRoot();
    assertTrue(root instanceof MemoryConfiguration);
    assertTrue(actualCreateSectionResult instanceof MemorySection);
    assertEquals("", root.getCurrentPath());
    assertEquals("", root.getName());
    assertEquals("Path.Path", actualCreateSectionResult.getCurrentPath());
    assertNull(root.getDefaults());
    assertNull(root.getDefaultSection());
    assertNull(root.getParent());
    assertTrue(((MemoryConfiguration) root).map.isEmpty());
    assertSame(parent, root.getRoot());
    assertSame(memorySection, actualCreateSectionResult.getParent());
    assertSame(parent.options, ((MemoryConfiguration) root).options);
  }

  /**
   * Test {@link MemorySection#getString(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.getString(String)"})
  void testGetStringWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getString("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getString(String, String)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return {@code Def}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'path', 'def'; given MemoryConfiguration(); then return 'Def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.getString(String, String)"})
  void testGetStringWithPathDef_givenMemoryConfiguration_thenReturnDef() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act and Assert
    assertEquals("Def", memoryConfiguration.getString("Path", "Def"));
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getString(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.getString(String)"})
  void testGetStringWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    String actualString = memoryConfiguration.getString("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualString);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getString(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) {@link MemoryConfiguration#options}
   *       {@link YamlConfigurationOptions}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'path'; then YamlConfiguration (default constructor) options YamlConfigurationOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.getString(String)"})
  void testGetStringWithPath_thenYamlConfigurationOptionsYamlConfigurationOptions() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    String actualString = yamlConfiguration.getString("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    assertEquals("Value", actualString);
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isString(String)}.
   *
   * <p>Method under test: {@link MemorySection#isString(String)}
   */
  @Test
  @DisplayName("Test isString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isString(String)"})
  void testIsString() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isString("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isString(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isString(String)}
   */
  @Test
  @DisplayName("Test isString(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isString(String)"})
  void testIsString_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsStringResult = memoryConfiguration.isString("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsStringResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isString(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) {@link MemoryConfiguration#options}
   *       {@link YamlConfigurationOptions}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isString(String)}
   */
  @Test
  @DisplayName(
      "Test isString(String); then YamlConfiguration (default constructor) options YamlConfigurationOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isString(String)"})
  void testIsString_thenYamlConfigurationOptionsYamlConfigurationOptions() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    boolean actualIsStringResult = yamlConfiguration.isString("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(actualIsStringResult);
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getInt(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MemorySection.getInt(String)"})
  void testGetIntWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getInt("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getInt(String, int)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'path', 'def'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MemorySection.getInt(String, int)"})
  void testGetIntWithPathDef_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    int actualInt = memoryConfiguration.getInt("Path", 1);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(1, actualInt);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getInt(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MemorySection.getInt(String)"})
  void testGetIntWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    int actualInt = memoryConfiguration.getInt("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(0, actualInt);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getInt(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MemorySection.getInt(String)"})
  void testGetIntWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getInt("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isInt(String)}.
   *
   * <p>Method under test: {@link MemorySection#isInt(String)}
   */
  @Test
  @DisplayName("Test isInt(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isInt(String)"})
  void testIsInt() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isInt("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isInt(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isInt(String)}
   */
  @Test
  @DisplayName("Test isInt(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isInt(String)"})
  void testIsInt_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsIntResult = memoryConfiguration.isInt("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsIntResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isInt(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isInt(String)}
   */
  @Test
  @DisplayName(
      "Test isInt(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isInt(String)"})
  void testIsInt_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isInt("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getBoolean(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getBoolean(String)}
   */
  @Test
  @DisplayName("Test getBoolean(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.getBoolean(String)"})
  void testGetBooleanWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getBoolean("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getBoolean(String, boolean)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'path', 'def'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.getBoolean(String, boolean)"})
  void testGetBooleanWithPathDef_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualBoolean = memoryConfiguration.getBoolean("Path", true);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualBoolean);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getBoolean(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.getBoolean(String)"})
  void testGetBooleanWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualBoolean = memoryConfiguration.getBoolean("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualBoolean);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getBoolean(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.getBoolean(String)"})
  void testGetBooleanWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getBoolean("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isBoolean(String)}.
   *
   * <p>Method under test: {@link MemorySection#isBoolean(String)}
   */
  @Test
  @DisplayName("Test isBoolean(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isBoolean(String)"})
  void testIsBoolean() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isBoolean("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isBoolean(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isBoolean(String)}
   */
  @Test
  @DisplayName("Test isBoolean(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isBoolean(String)"})
  void testIsBoolean_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsBooleanResult = memoryConfiguration.isBoolean("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsBooleanResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isBoolean(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isBoolean(String)}
   */
  @Test
  @DisplayName(
      "Test isBoolean(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isBoolean(String)"})
  void testIsBoolean_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isBoolean("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getDouble(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getDouble(String)}
   */
  @Test
  @DisplayName("Test getDouble(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MemorySection.getDouble(String)"})
  void testGetDoubleWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getDouble("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getDouble(String, double)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDouble(String, double)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String, double) with 'path', 'def'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MemorySection.getDouble(String, double)"})
  void testGetDoubleWithPathDef_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    double actualDouble = memoryConfiguration.getDouble("Path", 10.0d);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(10.0d, actualDouble);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getDouble(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MemorySection.getDouble(String)"})
  void testGetDoubleWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    double actualDouble = memoryConfiguration.getDouble("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(0.0d, actualDouble);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getDouble(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDouble(String)}
   */
  @Test
  @DisplayName(
      "Test getDouble(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double MemorySection.getDouble(String)"})
  void testGetDoubleWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getDouble("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isDouble(String)}.
   *
   * <p>Method under test: {@link MemorySection#isDouble(String)}
   */
  @Test
  @DisplayName("Test isDouble(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isDouble(String)"})
  void testIsDouble() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isDouble("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isDouble(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isDouble(String)}
   */
  @Test
  @DisplayName("Test isDouble(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isDouble(String)"})
  void testIsDouble_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsDoubleResult = memoryConfiguration.isDouble("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsDoubleResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isDouble(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isDouble(String)}
   */
  @Test
  @DisplayName(
      "Test isDouble(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isDouble(String)"})
  void testIsDouble_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isDouble("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getLong(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MemorySection.getLong(String)"})
  void testGetLongWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getLong("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getLong(String, long)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'path', 'def'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MemorySection.getLong(String, long)"})
  void testGetLongWithPathDef_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    long actualLong = memoryConfiguration.getLong("Path", 1L);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(1L, actualLong);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getLong(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MemorySection.getLong(String)"})
  void testGetLongWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    long actualLong = memoryConfiguration.getLong("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(0L, actualLong);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getLong(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long MemorySection.getLong(String)"})
  void testGetLongWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getLong("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isLong(String)}.
   *
   * <p>Method under test: {@link MemorySection#isLong(String)}
   */
  @Test
  @DisplayName("Test isLong(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isLong(String)"})
  void testIsLong() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isLong("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isLong(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isLong(String)}
   */
  @Test
  @DisplayName("Test isLong(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isLong(String)"})
  void testIsLong_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsLongResult = memoryConfiguration.isLong("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsLongResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isLong(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isLong(String)}
   */
  @Test
  @DisplayName(
      "Test isLong(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isLong(String)"})
  void testIsLong_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isLong("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getList(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getList(String)}
   */
  @Test
  @DisplayName("Test getList(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getList(String)"})
  void testGetListWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getList(String, List)} with {@code path}, {@code def}.
   *
   * <p>Method under test: {@link MemorySection#getList(String, List)}
   */
  @Test
  @DisplayName("Test getList(String, List) with 'path', 'def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getList(String, List)"})
  void testGetListWithPathDef() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<?> actualList = memoryConfiguration.getList("Path", new ArrayList<>());

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getList(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getList(String)}
   */
  @Test
  @DisplayName(
      "Test getList(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getList(String)"})
  void testGetListWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<?> actualList = memoryConfiguration.getList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualList);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getList(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getList(String)}
   */
  @Test
  @DisplayName(
      "Test getList(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getList(String)"})
  void testGetListWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isList(String)}.
   *
   * <p>Method under test: {@link MemorySection#isList(String)}
   */
  @Test
  @DisplayName("Test isList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isList(String)"})
  void testIsList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isList(String)}
   */
  @Test
  @DisplayName("Test isList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isList(String)"})
  void testIsList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsListResult = memoryConfiguration.isList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsListResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isList(String)}
   */
  @Test
  @DisplayName(
      "Test isList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isList(String)"})
  void testIsList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getStringList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getStringList(String)}
   */
  @Test
  @DisplayName("Test getStringList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getStringList(String)"})
  void testGetStringList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getStringList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getStringList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getStringList(String)}
   */
  @Test
  @DisplayName(
      "Test getStringList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getStringList(String)"})
  void testGetStringList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<String> actualStringList = memoryConfiguration.getStringList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualStringList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getStringList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getStringList(String)}
   */
  @Test
  @DisplayName(
      "Test getStringList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getStringList(String)"})
  void testGetStringList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getStringList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getIntegerList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getIntegerList(String)}
   */
  @Test
  @DisplayName("Test getIntegerList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getIntegerList(String)"})
  void testGetIntegerList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getIntegerList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getIntegerList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getIntegerList(String)}
   */
  @Test
  @DisplayName(
      "Test getIntegerList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getIntegerList(String)"})
  void testGetIntegerList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Integer> actualIntegerList = memoryConfiguration.getIntegerList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualIntegerList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getIntegerList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getIntegerList(String)}
   */
  @Test
  @DisplayName(
      "Test getIntegerList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getIntegerList(String)"})
  void testGetIntegerList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getIntegerList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getBooleanList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getBooleanList(String)}
   */
  @Test
  @DisplayName("Test getBooleanList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getBooleanList(String)"})
  void testGetBooleanList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getBooleanList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getBooleanList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getBooleanList(String)}
   */
  @Test
  @DisplayName(
      "Test getBooleanList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getBooleanList(String)"})
  void testGetBooleanList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Boolean> actualBooleanList = memoryConfiguration.getBooleanList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualBooleanList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getBooleanList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getBooleanList(String)}
   */
  @Test
  @DisplayName(
      "Test getBooleanList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getBooleanList(String)"})
  void testGetBooleanList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getBooleanList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getDoubleList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getDoubleList(String)}
   */
  @Test
  @DisplayName("Test getDoubleList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getDoubleList(String)"})
  void testGetDoubleList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getDoubleList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getDoubleList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDoubleList(String)}
   */
  @Test
  @DisplayName(
      "Test getDoubleList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getDoubleList(String)"})
  void testGetDoubleList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Double> actualDoubleList = memoryConfiguration.getDoubleList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualDoubleList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getDoubleList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getDoubleList(String)}
   */
  @Test
  @DisplayName(
      "Test getDoubleList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getDoubleList(String)"})
  void testGetDoubleList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getDoubleList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getFloatList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getFloatList(String)}
   */
  @Test
  @DisplayName("Test getFloatList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getFloatList(String)"})
  void testGetFloatList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getFloatList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getFloatList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getFloatList(String)}
   */
  @Test
  @DisplayName("Test getFloatList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getFloatList(String)"})
  void testGetFloatList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Float> actualFloatList = memoryConfiguration.getFloatList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualFloatList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getFloatList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getFloatList(String)}
   */
  @Test
  @DisplayName(
      "Test getFloatList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getFloatList(String)"})
  void testGetFloatList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getFloatList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getLongList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getLongList(String)}
   */
  @Test
  @DisplayName("Test getLongList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getLongList(String)"})
  void testGetLongList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getLongList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getLongList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLongList(String)}
   */
  @Test
  @DisplayName("Test getLongList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getLongList(String)"})
  void testGetLongList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Long> actualLongList = memoryConfiguration.getLongList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualLongList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getLongList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLongList(String)}
   */
  @Test
  @DisplayName(
      "Test getLongList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getLongList(String)"})
  void testGetLongList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getLongList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getByteList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getByteList(String)}
   */
  @Test
  @DisplayName("Test getByteList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getByteList(String)"})
  void testGetByteList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getByteList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getByteList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getByteList(String)}
   */
  @Test
  @DisplayName("Test getByteList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getByteList(String)"})
  void testGetByteList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Byte> actualByteList = memoryConfiguration.getByteList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualByteList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getByteList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getByteList(String)}
   */
  @Test
  @DisplayName(
      "Test getByteList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getByteList(String)"})
  void testGetByteList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getByteList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getCharacterList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getCharacterList(String)}
   */
  @Test
  @DisplayName("Test getCharacterList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getCharacterList(String)"})
  void testGetCharacterList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getCharacterList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getCharacterList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getCharacterList(String)}
   */
  @Test
  @DisplayName(
      "Test getCharacterList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getCharacterList(String)"})
  void testGetCharacterList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Character> actualCharacterList = memoryConfiguration.getCharacterList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualCharacterList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getCharacterList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getCharacterList(String)}
   */
  @Test
  @DisplayName(
      "Test getCharacterList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getCharacterList(String)"})
  void testGetCharacterList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getCharacterList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getShortList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getShortList(String)}
   */
  @Test
  @DisplayName("Test getShortList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getShortList(String)"})
  void testGetShortList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getShortList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getShortList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getShortList(String)}
   */
  @Test
  @DisplayName("Test getShortList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getShortList(String)"})
  void testGetShortList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Short> actualShortList = memoryConfiguration.getShortList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualShortList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getShortList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getShortList(String)}
   */
  @Test
  @DisplayName(
      "Test getShortList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getShortList(String)"})
  void testGetShortList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getShortList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getMapList(String)}.
   *
   * <p>Method under test: {@link MemorySection#getMapList(String)}
   */
  @Test
  @DisplayName("Test getMapList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getMapList(String)"})
  void testGetMapList() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getMapList("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getMapList(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getMapList(String)}
   */
  @Test
  @DisplayName("Test getMapList(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getMapList(String)"})
  void testGetMapList_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<Map<?, ?>> actualMapList = memoryConfiguration.getMapList("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualMapList.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getMapList(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getMapList(String)}
   */
  @Test
  @DisplayName(
      "Test getMapList(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getMapList(String)"})
  void testGetMapList_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getMapList("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getObject(String, Class)} with {@code path}, {@code clazz}.
   *
   * <p>Method under test: {@link MemorySection#getObject(String, Class)}
   */
  @Test
  @DisplayName("Test getObject(String, Class) with 'path', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.getObject(String, Class)"})
  void testGetObjectWithPathClazz() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);
    Class<Object> clazz = Object.class;

    // Act
    memoryConfiguration.getObject("Path", clazz);

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getObject(String, Class, Object)} with {@code path}, {@code clazz},
   * {@code def}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return {@code Def}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getObject(String, Class, Object)}
   */
  @Test
  @DisplayName(
      "Test getObject(String, Class, Object) with 'path', 'clazz', 'def'; given MemoryConfiguration(); then return 'Def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.getObject(String, Class, Object)"})
  void testGetObjectWithPathClazzDef_givenMemoryConfiguration_thenReturnDef() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Def", memoryConfiguration.getObject("Path", clazz, "Def"));
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getObject(String, Class)} with {@code path}, {@code clazz}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getObject(String, Class)}
   */
  @Test
  @DisplayName(
      "Test getObject(String, Class) with 'path', 'clazz'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.getObject(String, Class)"})
  void testGetObjectWithPathClazz_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    Class<Object> clazz = Object.class;

    // Act
    Object actualObject = memoryConfiguration.getObject("Path", clazz);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualObject);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getObject(String, Class)} with {@code path}, {@code clazz}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) {@link MemoryConfiguration#options}
   *       {@link YamlConfigurationOptions}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getObject(String, Class)}
   */
  @Test
  @DisplayName(
      "Test getObject(String, Class) with 'path', 'clazz'; then YamlConfiguration (default constructor) options YamlConfigurationOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MemorySection.getObject(String, Class)"})
  void testGetObjectWithPathClazz_thenYamlConfigurationOptionsYamlConfigurationOptions() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());
    Class<Object> clazz = Object.class;

    // Act
    Object actualObject = yamlConfiguration.getObject("Path", clazz);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    assertEquals("Value", actualObject);
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getSerializable(String, Class)} with {@code path}, {@code clazz}.
   *
   * <p>Method under test: {@link MemorySection#getSerializable(String, Class)}
   */
  @Test
  @DisplayName("Test getSerializable(String, Class) with 'path', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable MemorySection.getSerializable(String, Class)"})
  void testGetSerializableWithPathClazz() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act
    memoryConfiguration.getSerializable("Path", clazz);

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getSerializable(String, Class)} with {@code path}, {@code clazz}.
   *
   * <p>Method under test: {@link MemorySection#getSerializable(String, Class)}
   */
  @Test
  @DisplayName("Test getSerializable(String, Class) with 'path', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable MemorySection.getSerializable(String, Class)"})
  void testGetSerializableWithPathClazz2() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    memoryConfiguration.addDefault("Path", "Value");
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act
    memoryConfiguration.getSerializable("Path", clazz);

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    MemoryConfigurationOptions memoryConfigurationOptions2 =
        ((MemoryConfiguration) defaultSection).options;
    assertEquals('.', memoryConfigurationOptions2.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(memoryConfigurationOptions2.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(defaultSection, memoryConfigurationOptions2.configuration());
  }

  /**
   * Test {@link MemorySection#getSerializable(String, Class)} with {@code path}, {@code clazz}.
   *
   * <p>Method under test: {@link MemorySection#getSerializable(String, Class)}
   */
  @Test
  @DisplayName("Test getSerializable(String, Class) with 'path', 'clazz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable MemorySection.getSerializable(String, Class)"})
  void testGetSerializableWithPathClazz3() {
    // Arrange
    MemorySection memorySection = new MemorySection(new MemoryConfiguration(), "Path");
    memorySection.addDefault("Path", "Value");
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act and Assert
    assertNull(memorySection.getSerializable("Path", clazz));
  }

  /**
   * Test {@link MemorySection#getSerializable(String, Class, ConfigurationSerializable)} with
   * {@code path}, {@code clazz}, {@code def}.
   *
   * <p>Method under test: {@link MemorySection#getSerializable(String, Class,
   * ConfigurationSerializable)}
   */
  @Test
  @DisplayName(
      "Test getSerializable(String, Class, ConfigurationSerializable) with 'path', 'clazz', 'def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConfigurationSerializable MemorySection.getSerializable(String, Class, ConfigurationSerializable)"
  })
  void testGetSerializableWithPathClazzDef() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;
    ConfigurationSerializable configurationSerializable = mock(ConfigurationSerializable.class);

    // Act
    ConfigurationSerializable actualSerializable =
        memoryConfiguration.getSerializable("Path", clazz, configurationSerializable);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(configurationSerializable, actualSerializable);
  }

  /**
   * Test {@link MemorySection#getSerializable(String, Class)} with {@code path}, {@code clazz}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getSerializable(String, Class)}
   */
  @Test
  @DisplayName(
      "Test getSerializable(String, Class) with 'path', 'clazz'; given MemoryConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSerializable MemorySection.getSerializable(String, Class)"})
  void testGetSerializableWithPathClazz_givenMemoryConfiguration() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    Class<ConfigurationSerializable> clazz = ConfigurationSerializable.class;

    // Act
    ConfigurationSerializable actualSerializable =
        memoryConfiguration.getSerializable("Path", clazz);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualSerializable);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getVector(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getVector(String)}
   */
  @Test
  @DisplayName("Test getVector(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector MemorySection.getVector(String)"})
  void testGetVectorWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getVector("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getVector(String, Vector)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getVector(String, Vector)}
   */
  @Test
  @DisplayName(
      "Test getVector(String, Vector) with 'path', 'def'; given MemoryConfiguration(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector MemorySection.getVector(String, Vector)"})
  void testGetVectorWithPathDef_givenMemoryConfiguration_thenReturnRandom() {
    // Arrange
    Vector def = Vector.getRandom();

    // Act
    Vector actualVector = new MemoryConfiguration().getVector("Path", def);

    // Assert
    assertSame(def, actualVector);
  }

  /**
   * Test {@link MemorySection#getVector(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getVector(String)}
   */
  @Test
  @DisplayName(
      "Test getVector(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector MemorySection.getVector(String)"})
  void testGetVectorWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Vector actualVector = memoryConfiguration.getVector("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualVector);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getVector(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getVector(String)}
   */
  @Test
  @DisplayName(
      "Test getVector(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector MemorySection.getVector(String)"})
  void testGetVectorWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getVector("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isVector(String)}.
   *
   * <p>Method under test: {@link MemorySection#isVector(String)}
   */
  @Test
  @DisplayName("Test isVector(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isVector(String)"})
  void testIsVector() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isVector("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isVector(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isVector(String)}
   */
  @Test
  @DisplayName("Test isVector(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isVector(String)"})
  void testIsVector_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsVectorResult = memoryConfiguration.isVector("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsVectorResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isVector(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isVector(String)}
   */
  @Test
  @DisplayName(
      "Test isVector(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isVector(String)"})
  void testIsVector_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isVector("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getOfflinePlayer(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getOfflinePlayer(String)}
   */
  @Test
  @DisplayName("Test getOfflinePlayer(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OfflinePlayer MemorySection.getOfflinePlayer(String)"})
  void testGetOfflinePlayerWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getOfflinePlayer("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getOfflinePlayer(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getOfflinePlayer(String)}
   */
  @Test
  @DisplayName("Test getOfflinePlayer(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OfflinePlayer MemorySection.getOfflinePlayer(String)"})
  void testGetOfflinePlayerWithPath2() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getOfflinePlayer("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getOfflinePlayer(String, OfflinePlayer)} with {@code path}, {@code
   * def}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getOfflinePlayer(String, OfflinePlayer)}
   */
  @Test
  @DisplayName(
      "Test getOfflinePlayer(String, OfflinePlayer) with 'path', 'def'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OfflinePlayer MemorySection.getOfflinePlayer(String, OfflinePlayer)"})
  void testGetOfflinePlayerWithPathDef_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    OfflinePlayer def = mock(OfflinePlayer.class);

    // Act
    OfflinePlayer actualOfflinePlayer = memoryConfiguration.getOfflinePlayer("Path", def);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(def, actualOfflinePlayer);
  }

  /**
   * Test {@link MemorySection#getOfflinePlayer(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getOfflinePlayer(String)}
   */
  @Test
  @DisplayName(
      "Test getOfflinePlayer(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OfflinePlayer MemorySection.getOfflinePlayer(String)"})
  void testGetOfflinePlayerWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    OfflinePlayer actualOfflinePlayer = memoryConfiguration.getOfflinePlayer("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualOfflinePlayer);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isOfflinePlayer(String)}.
   *
   * <p>Method under test: {@link MemorySection#isOfflinePlayer(String)}
   */
  @Test
  @DisplayName("Test isOfflinePlayer(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isOfflinePlayer(String)"})
  void testIsOfflinePlayer() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isOfflinePlayer("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isOfflinePlayer(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isOfflinePlayer(String)}
   */
  @Test
  @DisplayName(
      "Test isOfflinePlayer(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isOfflinePlayer(String)"})
  void testIsOfflinePlayer_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsOfflinePlayerResult = memoryConfiguration.isOfflinePlayer("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsOfflinePlayerResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isOfflinePlayer(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isOfflinePlayer(String)}
   */
  @Test
  @DisplayName(
      "Test isOfflinePlayer(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isOfflinePlayer(String)"})
  void testIsOfflinePlayer_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isOfflinePlayer("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getItemStack(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getItemStack(String)}
   */
  @Test
  @DisplayName("Test getItemStack(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack MemorySection.getItemStack(String)"})
  void testGetItemStackWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getItemStack("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getItemStack(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getItemStack(String)}
   */
  @Test
  @DisplayName(
      "Test getItemStack(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack MemorySection.getItemStack(String)"})
  void testGetItemStackWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    ItemStack actualItemStack = memoryConfiguration.getItemStack("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualItemStack);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getItemStack(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getItemStack(String)}
   */
  @Test
  @DisplayName(
      "Test getItemStack(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack MemorySection.getItemStack(String)"})
  void testGetItemStackWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getItemStack("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isItemStack(String)}.
   *
   * <p>Method under test: {@link MemorySection#isItemStack(String)}
   */
  @Test
  @DisplayName("Test isItemStack(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isItemStack(String)"})
  void testIsItemStack() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isItemStack("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isItemStack(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isItemStack(String)}
   */
  @Test
  @DisplayName("Test isItemStack(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isItemStack(String)"})
  void testIsItemStack_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsItemStackResult = memoryConfiguration.isItemStack("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsItemStackResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isItemStack(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isItemStack(String)}
   */
  @Test
  @DisplayName(
      "Test isItemStack(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isItemStack(String)"})
  void testIsItemStack_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isItemStack("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getColor(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getColor(String)}
   */
  @Test
  @DisplayName("Test getColor(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color MemorySection.getColor(String)"})
  void testGetColorWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getColor("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getColor(String, Color)} with {@code path}, {@code def}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getColor(String, Color)}
   */
  @Test
  @DisplayName(
      "Test getColor(String, Color) with 'path', 'def'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color MemorySection.getColor(String, Color)"})
  void testGetColorWithPathDef_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Color actualColor = memoryConfiguration.getColor("Path", Color.AQUA);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(Color.AQUA, actualColor);
  }

  /**
   * Test {@link MemorySection#getColor(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getColor(String)}
   */
  @Test
  @DisplayName(
      "Test getColor(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color MemorySection.getColor(String)"})
  void testGetColorWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Color actualColor = memoryConfiguration.getColor("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualColor);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getColor(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getColor(String)}
   */
  @Test
  @DisplayName(
      "Test getColor(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color MemorySection.getColor(String)"})
  void testGetColorWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getColor("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isColor(String)}.
   *
   * <p>Method under test: {@link MemorySection#isColor(String)}
   */
  @Test
  @DisplayName("Test isColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isColor(String)"})
  void testIsColor() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isColor("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isColor(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isColor(String)}
   */
  @Test
  @DisplayName("Test isColor(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isColor(String)"})
  void testIsColor_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsColorResult = memoryConfiguration.isColor("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsColorResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isColor(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isColor(String)}
   */
  @Test
  @DisplayName(
      "Test isColor(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isColor(String)"})
  void testIsColor_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isColor("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getLocation(String)} with {@code path}.
   *
   * <p>Method under test: {@link MemorySection#getLocation(String)}
   */
  @Test
  @DisplayName("Test getLocation(String) with 'path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location MemorySection.getLocation(String)"})
  void testGetLocationWithPath() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getLocation("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getLocation(String, Location)} with {@code path}, {@code def}.
   *
   * <p>Method under test: {@link MemorySection#getLocation(String, Location)}
   */
  @Test
  @DisplayName("Test getLocation(String, Location) with 'path', 'def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location MemorySection.getLocation(String, Location)"})
  void testGetLocationWithPathDef() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    Location def = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    Location actualLocation = memoryConfiguration.getLocation("Path", def);

    // Assert
    assertSame(def, actualLocation);
  }

  /**
   * Test {@link MemorySection#getLocation(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLocation(String)}
   */
  @Test
  @DisplayName(
      "Test getLocation(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location MemorySection.getLocation(String)"})
  void testGetLocationWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Location actualLocation = memoryConfiguration.getLocation("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualLocation);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getLocation(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getLocation(String)}
   */
  @Test
  @DisplayName(
      "Test getLocation(String) with 'path'; then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location MemorySection.getLocation(String)"})
  void testGetLocationWithPath_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getLocation("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isLocation(String)}.
   *
   * <p>Method under test: {@link MemorySection#isLocation(String)}
   */
  @Test
  @DisplayName("Test isLocation(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isLocation(String)"})
  void testIsLocation() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isLocation("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isLocation(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isLocation(String)}
   */
  @Test
  @DisplayName("Test isLocation(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isLocation(String)"})
  void testIsLocation_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsLocationResult = memoryConfiguration.isLocation("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsLocationResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isLocation(String)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isLocation(String)}
   */
  @Test
  @DisplayName(
      "Test isLocation(String); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isLocation(String)"})
  void testIsLocation_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isLocation("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getConfigurationSection(String)}.
   *
   * <p>Method under test: {@link MemorySection#getConfigurationSection(String)}
   */
  @Test
  @DisplayName("Test getConfigurationSection(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.getConfigurationSection(String)"})
  void testGetConfigurationSection() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.getConfigurationSection("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#getConfigurationSection(String)}.
   *
   * <p>Method under test: {@link MemorySection#getConfigurationSection(String)}
   */
  @Test
  @DisplayName("Test getConfigurationSection(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.getConfigurationSection(String)"})
  void testGetConfigurationSection2() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.getConfigurationSection("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#getConfigurationSection(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getConfigurationSection(String)}
   */
  @Test
  @DisplayName(
      "Test getConfigurationSection(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConfigurationSection MemorySection.getConfigurationSection(String)"})
  void testGetConfigurationSection_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    ConfigurationSection actualConfigurationSection =
        memoryConfiguration.getConfigurationSection("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualConfigurationSection);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isConfigurationSection(String)}.
   *
   * <p>Method under test: {@link MemorySection#isConfigurationSection(String)}
   */
  @Test
  @DisplayName("Test isConfigurationSection(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isConfigurationSection(String)"})
  void testIsConfigurationSection() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.isConfigurationSection("Path");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertSame(memoryConfiguration, memoryConfiguration.options.configuration());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
  }

  /**
   * Test {@link MemorySection#isConfigurationSection(String)}.
   *
   * <p>Method under test: {@link MemorySection#isConfigurationSection(String)}
   */
  @Test
  @DisplayName("Test isConfigurationSection(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isConfigurationSection(String)"})
  void testIsConfigurationSection2() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.isConfigurationSection("Path");

    // Assert
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    MemoryConfigurationOptions memoryConfigurationOptions = yamlConfiguration.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(yamlConfiguration, memoryConfigurationOptions.configuration());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertSame(footer, getResult.getComments());
    assertSame(footer, getResult.getInlineComments());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemorySection#isConfigurationSection(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isConfigurationSection(String)}
   */
  @Test
  @DisplayName(
      "Test isConfigurationSection(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isConfigurationSection(String)"})
  void testIsConfigurationSection_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    boolean actualIsConfigurationSectionResult = memoryConfiguration.isConfigurationSection("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertFalse(actualIsConfigurationSectionResult);
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper('A'));
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenA_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper((byte) 'A'));
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper(1));
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenOne_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper((short) 1));
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenOne_thenReturnTrue3() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper(1L));
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper(10.0d));
  }

  /**
   * Test {@link MemorySection#isPrimitiveWrapper(Object)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#isPrimitiveWrapper(Object)}
   */
  @Test
  @DisplayName(
      "Test isPrimitiveWrapper(Object); given MemoryConfiguration(); when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemorySection.isPrimitiveWrapper(Object)"})
  void testIsPrimitiveWrapper_givenMemoryConfiguration_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MemoryConfiguration().isPrimitiveWrapper(true));
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); given empty string; then HashMap() 'foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_givenEmptyString_thenHashMapFooIs42() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    MemoryConfiguration memoryConfiguration2 = mock(MemoryConfiguration.class);
    when(memoryConfiguration2.options())
        .thenReturn(new MemoryConfigurationOptions(new MemoryConfiguration()));

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getParent()).thenReturn(null);
    when(section.getName()).thenReturn("");
    when(section.getRoot()).thenReturn(memoryConfiguration2);
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act
    memoryConfiguration.mapChildrenValues(output, section, false);

    // Assert
    verify(section).getName();
    verify(section).getParent();
    verify(section).getRoot();
    verify(section).getValues(false);
    verify(memoryConfiguration2).options();
    assertEquals(1, output.size());
    assertEquals("42", output.get("foo"));
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is {@code 42}.
   *   <li>Then {@link HashMap#HashMap()} {@code Name} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); given HashMap() empty string is '42'; then HashMap() 'Name' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_givenHashMapEmptyStringIs42_thenHashMapNameIs42() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("", "42");

    MemoryConfiguration memoryConfiguration2 = mock(MemoryConfiguration.class);
    when(memoryConfiguration2.options())
        .thenReturn(new MemoryConfigurationOptions(new MemoryConfiguration()));

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getParent()).thenReturn(null);
    when(section.getName()).thenReturn("Name");
    when(section.getRoot()).thenReturn(memoryConfiguration2);
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act
    memoryConfiguration.mapChildrenValues(output, section, false);

    // Assert
    verify(section).getName();
    verify(section).getParent();
    verify(section).getRoot();
    verify(section).getValues(false);
    verify(memoryConfiguration2).options();
    assertEquals(1, output.size());
    assertEquals("42", output.get("Name"));
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); given HashMap(); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_givenHashMap_thenHashMapEmpty() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getValues(anyBoolean())).thenReturn(new HashMap<>());

    // Act
    memoryConfiguration.mapChildrenValues(output, section, false);

    // Assert that nothing has changed
    verify(section).getValues(false);
    assertTrue(output.isEmpty());
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_givenIllegalStateException() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getName()).thenThrow(new IllegalStateException());
    when(section.getRoot()).thenReturn(new MemoryConfiguration());
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> memoryConfiguration.mapChildrenValues(output, section, false));
    verify(section).getName();
    verify(section).getRoot();
    verify(section).getValues(false);
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Given {@link MemoryConfiguration} {@link MemoryConfiguration#options()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); given MemoryConfiguration options() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_givenMemoryConfigurationOptionsThrowIllegalStateException() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    MemoryConfiguration memoryConfiguration2 = mock(MemoryConfiguration.class);
    when(memoryConfiguration2.options()).thenThrow(new IllegalStateException());

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getRoot()).thenReturn(memoryConfiguration2);
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> memoryConfiguration.mapChildrenValues(output, section, false));
    verify(section).getRoot();
    verify(section).getValues(false);
    verify(memoryConfiguration2).options();
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Name.foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); then HashMap() 'Name.foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_thenHashMapNameFooIs42() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getParent()).thenReturn(null);
    when(section.getName()).thenReturn("Name");
    when(section.getRoot()).thenReturn(new MemoryConfiguration());
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act
    memoryConfiguration.mapChildrenValues(output, section, false);

    // Assert
    verify(section).getName();
    verify(section).getParent();
    verify(section).getRoot();
    verify(section).getValues(false);
    assertEquals(1, output.size());
    assertEquals("42", output.get("Name.foo"));
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code .Name.foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); then HashMap() '.Name.foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_thenHashMapNameFooIs422() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getName()).thenReturn("Name");
    when(section.getParent()).thenReturn(new MemoryConfiguration());
    when(section.getRoot()).thenReturn(new MemoryConfiguration());
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act
    memoryConfiguration.mapChildrenValues(output, section, false);

    // Assert
    verify(section).getName();
    verify(section).getParent();
    verify(section).getRoot();
    verify(section).getValues(false);
    assertEquals(1, output.size());
    assertEquals("42", output.get(".Name.foo"));
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code .Path.Name.foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); then HashMap() '.Path.Name.foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_thenHashMapPathNameFooIs42() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    MemoryConfiguration memoryConfiguration2 = mock(MemoryConfiguration.class);
    when(memoryConfiguration2.options())
        .thenReturn(new MemoryConfigurationOptions(new MemoryConfiguration()));

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getParent()).thenReturn(new MemorySection(new MemoryConfiguration(), "Path"));
    when(section.getName()).thenReturn("Name");
    when(section.getRoot()).thenReturn(memoryConfiguration2);
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act
    memoryConfiguration.mapChildrenValues(output, section, false);

    // Assert
    verify(section).getName();
    verify(section).getParent();
    verify(section).getRoot();
    verify(section).getValues(false);
    verify(memoryConfiguration2).options();
    assertEquals(1, output.size());
    assertEquals("42", output.get(".Path.Name.foo"));
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationSection} {@link ConfigurationSection#getRoot()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); when ConfigurationSection getRoot() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_whenConfigurationSectionGetRootReturnNull() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    ConfigurationSection section = mock(ConfigurationSection.class);
    when(section.getRoot()).thenReturn(null);
    when(section.getValues(anyBoolean())).thenReturn(stringObjectMap);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> memoryConfiguration.mapChildrenValues(output, section, false));
    verify(section).getRoot();
    verify(section).getValues(false);
  }

  /**
   * Test {@link MemorySection#mapChildrenValues(Map, ConfigurationSection, boolean)}.
   *
   * <ul>
   *   <li>When {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#mapChildrenValues(Map, ConfigurationSection,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test mapChildrenValues(Map, ConfigurationSection, boolean); when MemoryConfiguration(); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.mapChildrenValues(Map, ConfigurationSection, boolean)"})
  void testMapChildrenValues_whenMemoryConfiguration_thenHashMapEmpty() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    HashMap<String, Object> output = new HashMap<>();

    // Act
    memoryConfiguration.mapChildrenValues(output, new MemoryConfiguration(), false);

    // Assert that nothing has changed
    assertTrue(output.isEmpty());
  }

  /**
   * Test {@link MemorySection#createPath(ConfigurationSection, String, ConfigurationSection)} with
   * {@code section}, {@code key}, {@code relativeTo}.
   *
   * <p>Method under test: {@link MemorySection#createPath(ConfigurationSection, String,
   * ConfigurationSection)}
   */
  @Test
  @DisplayName(
      "Test createPath(ConfigurationSection, String, ConfigurationSection) with 'section', 'key', 'relativeTo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MemorySection.createPath(ConfigurationSection, String, ConfigurationSection)"
  })
  void testCreatePathWithSectionKeyRelativeTo() {
    // Arrange
    MemorySection section =
        new MemorySection(new MemoryConfiguration(), "Cannot create path without a section");

    // Act
    String actualCreatePathResult =
        MemorySection.createPath(section, "Key", new MemoryConfiguration());

    // Assert
    assertEquals(".Cannot create path without a section.Key", actualCreatePathResult);
  }

  /**
   * Test {@link MemorySection#createPath(ConfigurationSection, String, ConfigurationSection)} with
   * {@code section}, {@code key}, {@code relativeTo}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createPath(ConfigurationSection, String,
   * ConfigurationSection)}
   */
  @Test
  @DisplayName(
      "Test createPath(ConfigurationSection, String, ConfigurationSection) with 'section', 'key', 'relativeTo'; when 'Key'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MemorySection.createPath(ConfigurationSection, String, ConfigurationSection)"
  })
  void testCreatePathWithSectionKeyRelativeTo_whenKey_thenReturnKey() {
    // Arrange
    MemoryConfiguration section = new MemoryConfiguration();

    // Act
    String actualCreatePathResult =
        MemorySection.createPath(section, "Key", new MemoryConfiguration());

    // Assert
    assertEquals("Key", actualCreatePathResult);
    MemoryConfigurationOptions memoryConfigurationOptions = section.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(section, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#createPath(ConfigurationSection, String, ConfigurationSection)} with
   * {@code section}, {@code key}, {@code relativeTo}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createPath(ConfigurationSection, String,
   * ConfigurationSection)}
   */
  @Test
  @DisplayName(
      "Test createPath(ConfigurationSection, String, ConfigurationSection) with 'section', 'key', 'relativeTo'; when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MemorySection.createPath(ConfigurationSection, String, ConfigurationSection)"
  })
  void testCreatePathWithSectionKeyRelativeTo_whenNull_thenReturnEmptyString() {
    // Arrange
    MemoryConfiguration section = new MemoryConfiguration();

    // Act
    String actualCreatePathResult =
        MemorySection.createPath(section, null, new MemoryConfiguration());

    // Assert
    assertEquals("", actualCreatePathResult);
    MemoryConfigurationOptions memoryConfigurationOptions = section.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(section, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#createPath(ConfigurationSection, String)} with {@code section},
   * {@code key}.
   *
   * <ul>
   *   <li>Then return {@code Cannot create path without a section.Key}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createPath(ConfigurationSection, String)}
   */
  @Test
  @DisplayName(
      "Test createPath(ConfigurationSection, String) with 'section', 'key'; then return 'Cannot create path without a section.Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.createPath(ConfigurationSection, String)"})
  void testCreatePathWithSectionKey_thenReturnCannotCreatePathWithoutASectionKey() {
    // Arrange, Act and Assert
    assertEquals(
        "Cannot create path without a section.Key",
        MemorySection.createPath(
            new MemorySection(new MemoryConfiguration(), "Cannot create path without a section"),
            "Key"));
  }

  /**
   * Test {@link MemorySection#createPath(ConfigurationSection, String)} with {@code section},
   * {@code key}.
   *
   * <ul>
   *   <li>When {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createPath(ConfigurationSection, String)}
   */
  @Test
  @DisplayName(
      "Test createPath(ConfigurationSection, String) with 'section', 'key'; when MemoryConfiguration(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.createPath(ConfigurationSection, String)"})
  void testCreatePathWithSectionKey_whenMemoryConfiguration_thenReturnEmptyString() {
    // Arrange
    MemoryConfiguration section = new MemoryConfiguration();

    // Act and Assert
    assertEquals("", MemorySection.createPath(section, null));
    MemoryConfigurationOptions memoryConfigurationOptions = section.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(section, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#createPath(ConfigurationSection, String)} with {@code section},
   * {@code key}.
   *
   * <ul>
   *   <li>When {@link MemoryConfiguration#MemoryConfiguration()}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#createPath(ConfigurationSection, String)}
   */
  @Test
  @DisplayName(
      "Test createPath(ConfigurationSection, String) with 'section', 'key'; when MemoryConfiguration(); then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.createPath(ConfigurationSection, String)"})
  void testCreatePathWithSectionKey_whenMemoryConfiguration_thenReturnKey() {
    // Arrange
    MemoryConfiguration section = new MemoryConfiguration();

    // Act and Assert
    assertEquals("Key", MemorySection.createPath(section, "Key"));
    MemoryConfigurationOptions memoryConfigurationOptions = section.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(section, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getComments(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getComments(String)}
   */
  @Test
  @DisplayName("Test getComments(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getComments(String)"})
  void testGetComments_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<String> actualComments = memoryConfiguration.getComments("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualComments.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#getInlineComments(String)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#getInlineComments(String)}
   */
  @Test
  @DisplayName(
      "Test getInlineComments(String); then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MemorySection.getInlineComments(String)"})
  void testGetInlineComments_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    List<String> actualInlineComments = memoryConfiguration.getInlineComments("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(actualInlineComments.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#setComments(String, List)}.
   *
   * <p>Method under test: {@link MemorySection#setComments(String, List)}
   */
  @Test
  @DisplayName("Test setComments(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.setComments(String, List)"})
  void testSetComments() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    memoryConfiguration.setComments("Path", new ArrayList<>());

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#setInlineComments(String, List)}.
   *
   * <p>Method under test: {@link MemorySection#setInlineComments(String, List)}
   */
  @Test
  @DisplayName("Test setInlineComments(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemorySection.setInlineComments(String, List)"})
  void testSetInlineComments() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    memoryConfiguration.setInlineComments("Path", new ArrayList<>());

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemorySection#toString()}.
   *
   * <ul>
   *   <li>Then return {@code MemoryConfiguration[path='', root='MemoryConfiguration']}.
   * </ul>
   *
   * <p>Method under test: {@link MemorySection#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'MemoryConfiguration[path='', root='MemoryConfiguration']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MemorySection.toString()"})
  void testToString_thenReturnMemoryConfigurationPathRootMemoryConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        "MemoryConfiguration[path='', root='MemoryConfiguration']",
        new MemoryConfiguration().toString());
  }
}
