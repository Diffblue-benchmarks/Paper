package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemoryConfigurationOptionsDiffblueTest {
  /**
   * Test {@link MemoryConfigurationOptions#MemoryConfigurationOptions(MemoryConfiguration)}.
   *
   * <p>Method under test: {@link
   * MemoryConfigurationOptions#MemoryConfigurationOptions(MemoryConfiguration)}
   */
  @Test
  @DisplayName("Test new MemoryConfigurationOptions(MemoryConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryConfigurationOptions.<init>(MemoryConfiguration)"})
  void testNewMemoryConfigurationOptions() {
    // Arrange
    MemoryConfiguration configuration = new MemoryConfiguration();

    // Act
    MemoryConfigurationOptions actualMemoryConfigurationOptions =
        new MemoryConfigurationOptions(configuration);

    // Assert
    assertEquals('.', actualMemoryConfigurationOptions.pathSeparator());
    assertFalse(actualMemoryConfigurationOptions.copyDefaults());
    assertSame(configuration, actualMemoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link MemoryConfigurationOptions#configuration()}.
   *
   * <p>Method under test: {@link MemoryConfigurationOptions#configuration()}
   */
  @Test
  @DisplayName("Test configuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MemoryConfiguration MemoryConfigurationOptions.configuration()"})
  void testConfiguration() {
    // Arrange
    MemoryConfiguration configuration = new MemoryConfiguration();

    // Act and Assert
    assertSame(configuration, new MemoryConfigurationOptions(configuration).configuration());
  }

  /**
   * Test {@link MemoryConfigurationOptions#copyDefaults(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link MemoryConfigurationOptions#copyDefaults(boolean)}
   */
  @Test
  @DisplayName("Test copyDefaults(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MemoryConfigurationOptions MemoryConfigurationOptions.copyDefaults(boolean)"})
  void testCopyDefaultsWithBoolean() {
    // Arrange
    MemoryConfigurationOptions memoryConfigurationOptions =
        new MemoryConfigurationOptions(new MemoryConfiguration());

    // Act
    MemoryConfigurationOptions actualCopyDefaultsResult =
        memoryConfigurationOptions.copyDefaults(true);

    // Assert
    assertTrue(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfigurationOptions, actualCopyDefaultsResult);
  }

  /**
   * Test {@link MemoryConfigurationOptions#pathSeparator(char)} with {@code char}.
   *
   * <p>Method under test: {@link MemoryConfigurationOptions#pathSeparator(char)}
   */
  @Test
  @DisplayName("Test pathSeparator(char) with 'char'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MemoryConfigurationOptions MemoryConfigurationOptions.pathSeparator(char)"})
  void testPathSeparatorWithChar() {
    // Arrange
    MemoryConfigurationOptions memoryConfigurationOptions =
        new MemoryConfigurationOptions(new MemoryConfiguration());

    // Act
    MemoryConfigurationOptions actualPathSeparatorResult =
        memoryConfigurationOptions.pathSeparator('A');

    // Assert
    assertEquals('A', memoryConfigurationOptions.pathSeparator());
    assertSame(memoryConfigurationOptions, actualPathSeparatorResult);
  }
}
