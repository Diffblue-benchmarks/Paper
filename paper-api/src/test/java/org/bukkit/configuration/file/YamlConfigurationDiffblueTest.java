package org.bukkit.configuration.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.CharArrayReader;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Paths;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class YamlConfigurationDiffblueTest {
  /**
   * Test new {@link YamlConfiguration} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link YamlConfiguration}
   */
  @Test
  @DisplayName("Test new YamlConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlConfiguration.<init>()"})
  void testNewYamlConfiguration() {
    // Arrange and Act
    YamlConfiguration actualYamlConfiguration = new YamlConfiguration();

    // Assert
    assertEquals("", actualYamlConfiguration.getCurrentPath());
    assertEquals("", actualYamlConfiguration.getName());
    assertNull(actualYamlConfiguration.getDefaults());
    assertNull(actualYamlConfiguration.getParent());
    assertNull(actualYamlConfiguration.getDefaultSection());
    Configuration actualRoot = actualYamlConfiguration.getRoot();
    assertSame(actualYamlConfiguration, actualRoot);
  }

  /**
   * Test {@link YamlConfiguration#saveToString()}.
   *
   * <p>Method under test: {@link YamlConfiguration#saveToString()}
   */
  @Test
  @DisplayName("Test saveToString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String YamlConfiguration.saveToString()"})
  void testSaveToString() {
    // Arrange, Act and Assert
    assertEquals("", new YamlConfiguration().saveToString());
  }

  /**
   * Test {@link YamlConfiguration#loadFromString(String)}.
   *
   * <p>Method under test: {@link YamlConfiguration#loadFromString(String)}
   */
  @Test
  @DisplayName("Test loadFromString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void YamlConfiguration.loadFromString(String)"})
  void testLoadFromString() throws InvalidConfigurationException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidConfigurationException.class,
        () -> new YamlConfiguration().loadFromString("Not all who wander are lost"));
  }

  /**
   * Test {@link YamlConfiguration#options()}.
   *
   * <p>Method under test: {@link YamlConfiguration#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfiguration.options()"})
  void testOptions() {
    // Arrange
    YamlConfiguration loadConfigurationResult =
        YamlConfiguration.loadConfiguration(new StringReader(""));

    // Act and Assert
    assertSame(loadConfigurationResult, loadConfigurationResult.options().configuration());
  }

  /**
   * Test {@link YamlConfiguration#options()}.
   *
   * <ul>
   *   <li>Given {@link YamlConfiguration} (default constructor).
   *   <li>Then return configuration is {@link YamlConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link YamlConfiguration#options()}
   */
  @Test
  @DisplayName(
      "Test options(); given YamlConfiguration (default constructor); then return configuration is YamlConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfigurationOptions YamlConfiguration.options()"})
  void testOptions_givenYamlConfiguration_thenReturnConfigurationIsYamlConfiguration() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();

    // Act and Assert
    assertSame(yamlConfiguration, yamlConfiguration.options().configuration());
  }

  /**
   * Test {@link YamlConfiguration#loadConfiguration(File)} with {@code file}.
   *
   * <ul>
   *   <li>Then return CurrentPath is empty string.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfiguration#loadConfiguration(File)}
   */
  @Test
  @DisplayName("Test loadConfiguration(File) with 'file'; then return CurrentPath is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfiguration YamlConfiguration.loadConfiguration(File)"})
  void testLoadConfigurationWithFile_thenReturnCurrentPathIsEmptyString() {
    // Arrange and Act
    YamlConfiguration actualLoadConfigurationResult =
        YamlConfiguration.loadConfiguration(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertEquals("", actualLoadConfigurationResult.getCurrentPath());
    assertEquals("", actualLoadConfigurationResult.getName());
    assertNull(actualLoadConfigurationResult.getDefaults());
    assertNull(actualLoadConfigurationResult.getParent());
    assertNull(actualLoadConfigurationResult.getDefaultSection());
    Configuration actualRoot = actualLoadConfigurationResult.getRoot();
    assertSame(actualLoadConfigurationResult, actualRoot);
  }

  /**
   * Test {@link YamlConfiguration#loadConfiguration(Reader)} with {@code reader}.
   *
   * <ul>
   *   <li>Then return CurrentPath is empty string.
   * </ul>
   *
   * <p>Method under test: {@link YamlConfiguration#loadConfiguration(Reader)}
   */
  @Test
  @DisplayName(
      "Test loadConfiguration(Reader) with 'reader'; then return CurrentPath is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"YamlConfiguration YamlConfiguration.loadConfiguration(Reader)"})
  void testLoadConfigurationWithReader_thenReturnCurrentPathIsEmptyString() {
    // Arrange
    CharArrayReader reader = new CharArrayReader(new char[] {});

    // Act
    YamlConfiguration actualLoadConfigurationResult = YamlConfiguration.loadConfiguration(reader);

    // Assert
    assertEquals("", actualLoadConfigurationResult.getCurrentPath());
    assertEquals("", actualLoadConfigurationResult.getName());
    assertNull(actualLoadConfigurationResult.getDefaults());
    assertNull(actualLoadConfigurationResult.getParent());
    assertNull(actualLoadConfigurationResult.getDefaultSection());
    Configuration actualRoot = actualLoadConfigurationResult.getRoot();
    assertSame(actualLoadConfigurationResult, actualRoot);
  }
}
