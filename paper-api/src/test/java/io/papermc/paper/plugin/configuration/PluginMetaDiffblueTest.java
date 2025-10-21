package io.papermc.paper.plugin.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.PluginDescriptionFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginMetaDiffblueTest {
  /**
   * Test {@link PluginMeta#getDisplayName()}.
   *
   * <p>Method under test: {@link PluginMeta#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PluginMeta.getDisplayName()"})
  void testGetDisplayName() {
    // Arrange
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act and Assert
    assertEquals("Plugin_Name v1.0.2", pluginDescriptionFile.getDisplayName());
  }

  /**
   * Test {@link PluginMeta#namespace()}.
   *
   * <p>Method under test: {@link PluginMeta#namespace()}
   */
  @Test
  @DisplayName("Test namespace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PluginMeta.namespace()"})
  void testNamespace() {
    // Arrange
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act and Assert
    assertEquals("plugin_name", pluginDescriptionFile.namespace());
  }
}
