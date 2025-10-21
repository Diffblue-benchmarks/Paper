package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginCommandYamlParserDiffblueTest {
  /**
   * Test {@link PluginCommandYamlParser#parse(Plugin)}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PluginCommandYamlParser#parse(Plugin)}
   */
  @Test
  @DisplayName("Test parse(Plugin); when TestPlugin(String) with 'Plugin Name'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginCommandYamlParser.parse(Plugin)"})
  void testParse_whenTestPluginWithPluginName_thenReturnEmpty() {
    // Arrange and Act
    List<Command> actualParseResult = PluginCommandYamlParser.parse(new TestPlugin("Plugin Name"));

    // Assert
    assertTrue(actualParseResult.isEmpty());
  }
}
