package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemoryConfigurationDiffblueTest {
  /**
   * Test {@link MemoryConfiguration#MemoryConfiguration()}.
   *
   * <p>Method under test: {@link MemoryConfiguration#MemoryConfiguration()}
   */
  @Test
  @DisplayName("Test new MemoryConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.<init>()"})
  void testNewMemoryConfiguration() {
    // Arrange and Act
    MemoryConfiguration actualMemoryConfiguration = new MemoryConfiguration();

    // Assert
    assertEquals("", actualMemoryConfiguration.getCurrentPath());
    assertEquals("", actualMemoryConfiguration.getName());
    assertNull(actualMemoryConfiguration.getDefaults());
    assertNull(actualMemoryConfiguration.getParent());
    assertNull(actualMemoryConfiguration.getDefaultSection());
    assertNull(actualMemoryConfiguration.options);
    assertTrue(actualMemoryConfiguration.map.isEmpty());
    Configuration actualRoot = actualMemoryConfiguration.getRoot();
    assertSame(actualMemoryConfiguration, actualRoot);
  }

  /**
   * Test {@link MemoryConfiguration#MemoryConfiguration(Configuration)}.
   *
   * <p>Method under test: {@link MemoryConfiguration#MemoryConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test new MemoryConfiguration(Configuration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.<init>(Configuration)"})
  void testNewMemoryConfiguration2() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();

    // Act
    MemoryConfiguration actualMemoryConfiguration = new MemoryConfiguration(defaults);

    // Assert
    ConfigurationSection defaultSection = actualMemoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertEquals("", actualMemoryConfiguration.getCurrentPath());
    assertEquals("", actualMemoryConfiguration.getName());
    assertNull(actualMemoryConfiguration.getParent());
    assertNull(actualMemoryConfiguration.options);
    assertTrue(actualMemoryConfiguration.map.isEmpty());
    assertSame(defaults, actualMemoryConfiguration.getDefaults());
    assertSame(defaults, defaultSection);
    Configuration actualRoot = actualMemoryConfiguration.getRoot();
    assertSame(actualMemoryConfiguration, actualRoot);
  }

  /**
   * Test {@link MemoryConfiguration#addDefault(String, Object)}.
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefault(String, Object)}
   */
  @Test
  @DisplayName("Test addDefault(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefault(String, Object)"})
  void testAddDefault() {
    // Arrange
    MemoryConfiguration defaults = new MemoryConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.addDefault("Path", "Value");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertSame(defaults.options, ((MemoryConfiguration) defaultSection).options);
    assertSame(defaults.map, stringSectionPathDataMap);
  }

  /**
   * Test {@link MemoryConfiguration#addDefault(String, Object)}.
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefault(String, Object)}
   */
  @Test
  @DisplayName("Test addDefault(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefault(String, Object)"})
  void testAddDefault2() {
    // Arrange
    YamlConfiguration defaults = new YamlConfiguration();
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration(defaults);

    // Act
    memoryConfiguration.addDefault("Path", "Value");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof YamlConfiguration);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((YamlConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertSame(defaults.options, ((YamlConfiguration) defaultSection).options);
    assertSame(defaults.map, stringSectionPathDataMap);
  }

  /**
   * Test {@link MemoryConfiguration#addDefault(String, Object)}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefault(String, Object)}
   */
  @Test
  @DisplayName(
      "Test addDefault(String, Object); then MemoryConfiguration() DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefault(String, Object)"})
  void testAddDefault_thenMemoryConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    memoryConfiguration.addDefault("Path", "Value");

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertEquals("", defaultSection.getCurrentPath());
    assertEquals("", defaultSection.getName());
    assertNull(((MemoryConfiguration) defaultSection).getDefaults());
    assertNull(defaultSection.getDefaultSection());
    assertNull(defaultSection.getParent());
    assertEquals(1, ((MemoryConfiguration) defaultSection).map.size());
    assertSame(defaultSection, ((MemoryConfiguration) defaultSection).options.configuration());
  }

  /**
   * Test {@link MemoryConfiguration#addDefault(String, Object)}.
   *
   * <ul>
   *   <li>Then {@link YamlConfiguration} (default constructor) DefaultSection {@link
   *       MemoryConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefault(String, Object)}
   */
  @Test
  @DisplayName(
      "Test addDefault(String, Object); then YamlConfiguration (default constructor) DefaultSection MemoryConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefault(String, Object)"})
  void testAddDefault_thenYamlConfigurationDefaultSectionMemoryConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();
    yamlConfiguration.addDefault("Path", "Value");
    yamlConfiguration.addDefaults(new HashMap<>());

    // Act
    yamlConfiguration.addDefault("Path", "Value");

    // Assert that nothing has changed
    ConfigurationSection defaultSection = yamlConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertEquals(1, ((MemoryConfiguration) defaultSection).map.size());
  }

  /**
   * Test {@link MemoryConfiguration#addDefaults(Configuration)} with {@code Configuration}.
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefaults(Configuration)}
   */
  @Test
  @DisplayName("Test addDefaults(Configuration) with 'Configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefaults(Configuration)"})
  void testAddDefaultsWithConfiguration() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    MemoryConfiguration defaults = new MemoryConfiguration();

    // Act
    memoryConfiguration.addDefaults(defaults);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = defaults.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(defaults, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemoryConfiguration#addDefaults(Configuration)} with {@code Configuration}.
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefaults(Configuration)}
   */
  @Test
  @DisplayName("Test addDefaults(Configuration) with 'Configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefaults(Configuration)"})
  void testAddDefaultsWithConfiguration2() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    YamlConfiguration defaults = new YamlConfiguration();

    // Act
    memoryConfiguration.addDefaults(defaults);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = defaults.options;
    assertTrue(memoryConfigurationOptions instanceof YamlConfigurationOptions);
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertEquals(2, ((YamlConfigurationOptions) memoryConfigurationOptions).indent());
    assertEquals(80, ((YamlConfigurationOptions) memoryConfigurationOptions).width());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    List<String> footer = ((YamlConfigurationOptions) memoryConfigurationOptions).getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(((YamlConfigurationOptions) memoryConfigurationOptions).parseComments());
    assertEquals(
        Integer.MAX_VALUE,
        ((YamlConfigurationOptions) memoryConfigurationOptions).codePointLimit());
    assertSame(defaults, memoryConfigurationOptions.configuration());
    assertSame(footer, ((YamlConfigurationOptions) memoryConfigurationOptions).getHeader());
  }

  /**
   * Test {@link MemoryConfiguration#addDefaults(Map)} with {@code Map}.
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefaults(Map)}
   */
  @Test
  @DisplayName("Test addDefaults(Map) with 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefaults(Map)"})
  void testAddDefaultsWithMap() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    HashMap<String, Object> defaults = new HashMap<>();
    defaults.put("Defaults may not be null", "42");

    // Act
    memoryConfiguration.addDefaults(defaults);

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    assertEquals("", defaultSection.getCurrentPath());
    assertEquals("", defaultSection.getName());
    MemoryConfigurationOptions memoryConfigurationOptions =
        ((MemoryConfiguration) defaultSection).options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(((MemoryConfiguration) defaultSection).getDefaults());
    assertNull(defaultSection.getDefaultSection());
    assertNull(defaultSection.getParent());
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(1, stringSectionPathDataMap.size());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertTrue(stringSectionPathDataMap.containsKey("Defaults may not be null"));
    assertSame(defaultSection, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemoryConfiguration#addDefaults(Map)} with {@code Map}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} DefaultSection {@link
   *       MemorySection#map} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefaults(Map)}
   */
  @Test
  @DisplayName(
      "Test addDefaults(Map) with 'Map'; then MemoryConfiguration() DefaultSection map size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefaults(Map)"})
  void testAddDefaultsWithMap_thenMemoryConfigurationDefaultSectionMapSizeIsTwo() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    HashMap<String, Object> defaults = new HashMap<>();
    defaults.put("Path may not be null", "42");
    defaults.put("Defaults may not be null", "42");

    // Act
    memoryConfiguration.addDefaults(defaults);

    // Assert
    ConfigurationSection defaultSection = memoryConfiguration.getDefaultSection();
    assertTrue(defaultSection instanceof MemoryConfiguration);
    Map<String, SectionPathData> stringSectionPathDataMap =
        ((MemoryConfiguration) defaultSection).map;
    assertEquals(2, stringSectionPathDataMap.size());
    SectionPathData getResult = stringSectionPathDataMap.get("Path may not be null");
    assertEquals("42", getResult.getData());
    List<String> comments = getResult.getComments();
    assertTrue(comments.isEmpty());
    SectionPathData getResult2 = stringSectionPathDataMap.get("Defaults may not be null");
    assertSame(comments, getResult2.getComments());
    assertSame(comments, getResult2.getInlineComments());
    assertSame(comments, getResult.getInlineComments());
  }

  /**
   * Test {@link MemoryConfiguration#addDefaults(Map)} with {@code Map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} Defaults is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryConfiguration#addDefaults(Map)}
   */
  @Test
  @DisplayName(
      "Test addDefaults(Map) with 'Map'; when HashMap(); then MemoryConfiguration() Defaults is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfiguration.addDefaults(Map)"})
  void testAddDefaultsWithMap_whenHashMap_thenMemoryConfigurationDefaultsIsNull() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    memoryConfiguration.addDefaults(new HashMap<>());

    // Assert that nothing has changed
    assertNull(memoryConfiguration.getDefaults());
    assertNull(memoryConfiguration.getDefaultSection());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MemoryConfiguration#getDefaults()}
   *   <li>{@link MemoryConfiguration#getParent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Configuration MemoryConfiguration.getDefaults()",
    "ConfigurationSection MemoryConfiguration.getParent()"
  })
  void testGettersAndSetters() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Configuration actualDefaults = memoryConfiguration.getDefaults();

    // Assert
    assertNull(actualDefaults);
    assertNull(memoryConfiguration.getParent());
  }

  /**
   * Test {@link MemoryConfiguration#options()}.
   *
   * <p>Method under test: {@link MemoryConfiguration#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MemoryConfigurationOptions MemoryConfiguration.options()"})
  void testOptions() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    MemoryConfigurationOptions actualOptionsResult = memoryConfiguration.options();

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(memoryConfiguration.options, actualOptionsResult);
  }
}
