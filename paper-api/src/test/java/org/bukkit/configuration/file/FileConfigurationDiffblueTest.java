package org.bukkit.configuration.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileConfigurationDiffblueTest {
  /**
   * Test {@link FileConfiguration#buildHeader()}.
   *
   * <p>Method under test: {@link FileConfiguration#buildHeader()}
   */
  @Test
  @DisplayName("Test buildHeader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileConfiguration.buildHeader()"})
  void testBuildHeader() {
    // Arrange, Act and Assert
    assertEquals("", new YamlConfiguration().buildHeader());
  }

  /**
   * Test {@link FileConfiguration#options()}.
   *
   * <p>Method under test: {@link FileConfiguration#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FileConfigurationOptions FileConfiguration.options()"})
  void testOptions() {
    // Arrange
    YamlConfiguration yamlConfiguration = new YamlConfiguration();

    // Act
    YamlConfigurationOptions actualOptionsResult = yamlConfiguration.options();

    // Assert
    assertTrue(actualOptionsResult instanceof YamlConfigurationOptions);
    assertEquals('.', actualOptionsResult.pathSeparator());
    assertEquals(2, ((YamlConfigurationOptions) actualOptionsResult).indent());
    assertEquals(80, ((YamlConfigurationOptions) actualOptionsResult).width());
    assertFalse(actualOptionsResult.copyDefaults());
    List<String> footer = actualOptionsResult.getFooter();
    assertTrue(footer.isEmpty());
    assertTrue(actualOptionsResult.parseComments());
    assertEquals(
        Integer.MAX_VALUE, ((YamlConfigurationOptions) actualOptionsResult).codePointLimit());
    assertSame(yamlConfiguration, actualOptionsResult.configuration());
    assertSame(footer, actualOptionsResult.getHeader());
  }
}
