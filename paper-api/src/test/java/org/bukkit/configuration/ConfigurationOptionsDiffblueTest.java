package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConfigurationOptionsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConfigurationOptions#ConfigurationOptions(Configuration)}
   *   <li>{@link ConfigurationOptions#copyDefaults(boolean)}
   *   <li>{@link ConfigurationOptions#pathSeparator(char)}
   *   <li>{@link ConfigurationOptions#configuration()}
   *   <li>{@link ConfigurationOptions#copyDefaults()}
   *   <li>{@link ConfigurationOptions#pathSeparator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConfigurationOptions.<init>(Configuration)",
    "Configuration ConfigurationOptions.configuration()",
    "boolean ConfigurationOptions.copyDefaults()",
    "ConfigurationOptions ConfigurationOptions.copyDefaults(boolean)",
    "char ConfigurationOptions.pathSeparator()",
    "ConfigurationOptions ConfigurationOptions.pathSeparator(char)"
  })
  void testGettersAndSetters() {
    // Arrange
    MemoryConfiguration configuration = new MemoryConfiguration();

    // Act
    ConfigurationOptions actualConfigurationOptions = new ConfigurationOptions(configuration);
    ConfigurationOptions actualCopyDefaultsResult = actualConfigurationOptions.copyDefaults(true);
    ConfigurationOptions actualPathSeparatorResult = actualConfigurationOptions.pathSeparator('A');
    Configuration actualConfigurationResult = actualConfigurationOptions.configuration();
    boolean actualCopyDefaultsResult2 = actualConfigurationOptions.copyDefaults();

    // Assert
    assertEquals('A', actualConfigurationOptions.pathSeparator());
    assertTrue(actualCopyDefaultsResult2);
    assertSame(actualConfigurationOptions, actualCopyDefaultsResult);
    assertSame(actualConfigurationOptions, actualPathSeparatorResult);
    assertSame(configuration, actualConfigurationResult);
  }
}
