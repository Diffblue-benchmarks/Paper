package org.bukkit.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginNameConversationPrefixDiffblueTest {
  /**
   * Test {@link PluginNameConversationPrefix#PluginNameConversationPrefix(Plugin)}.
   *
   * <p>Method under test: {@link PluginNameConversationPrefix#PluginNameConversationPrefix(Plugin)}
   */
  @Test
  @DisplayName("Test new PluginNameConversationPrefix(Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginNameConversationPrefix.<init>(Plugin)"})
  void testNewPluginNameConversationPrefix() {
    // Arrange and Act
    PluginNameConversationPrefix actualPluginNameConversationPrefix =
        new PluginNameConversationPrefix(new TestPlugin("Plugin Name"));
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();
    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());
    String actualPrefix = actualPluginNameConversationPrefix.getPrefix(context);

    // Assert
    Plugin plugin2 = actualPluginNameConversationPrefix.plugin;
    assertTrue(plugin2.getPluginMeta() instanceof PluginDescriptionFile);
    assertTrue(plugin2 instanceof TestPlugin);
    assertEquals(" > ", actualPluginNameConversationPrefix.separator);
    assertEquals("Plugin_Name", plugin2.getName());
    assertEquals("§dPlugin_Name > §f", actualPrefix);
    assertEquals("plugin_name", plugin2.namespace());
    assertEquals(ChatColor.LIGHT_PURPLE, actualPluginNameConversationPrefix.prefixColor);
    assertTrue(plugin2.isEnabled());
  }

  /**
   * Test {@link PluginNameConversationPrefix#PluginNameConversationPrefix(Plugin, String,
   * ChatColor)}.
   *
   * <p>Method under test: {@link PluginNameConversationPrefix#PluginNameConversationPrefix(Plugin,
   * String, ChatColor)}
   */
  @Test
  @DisplayName("Test new PluginNameConversationPrefix(Plugin, String, ChatColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginNameConversationPrefix.<init>(Plugin, String, ChatColor)"})
  void testNewPluginNameConversationPrefix2() {
    // Arrange and Act
    PluginNameConversationPrefix actualPluginNameConversationPrefix =
        new PluginNameConversationPrefix(
            new TestPlugin("Plugin Name"), "Separator", ChatColor.BLACK);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();
    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());
    String actualPrefix = actualPluginNameConversationPrefix.getPrefix(context);

    // Assert
    Plugin plugin2 = actualPluginNameConversationPrefix.plugin;
    assertTrue(plugin2.getPluginMeta() instanceof PluginDescriptionFile);
    assertTrue(plugin2 instanceof TestPlugin);
    assertEquals("Plugin_Name", plugin2.getName());
    assertEquals("Separator", actualPluginNameConversationPrefix.separator);
    assertEquals("§0Plugin_NameSeparator§f", actualPrefix);
    assertEquals("plugin_name", plugin2.namespace());
    assertEquals(ChatColor.BLACK, actualPluginNameConversationPrefix.prefixColor);
    assertTrue(plugin2.isEnabled());
  }

  /**
   * Test {@link PluginNameConversationPrefix#getPrefix(ConversationContext)}.
   *
   * <p>Method under test: {@link PluginNameConversationPrefix#getPrefix(ConversationContext)}
   */
  @Test
  @DisplayName("Test getPrefix(ConversationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PluginNameConversationPrefix.getPrefix(ConversationContext)"})
  void testGetPrefix() {
    // Arrange
    PluginNameConversationPrefix pluginNameConversationPrefix =
        new PluginNameConversationPrefix(new TestPlugin("Plugin Name"));
    TestPlugin plugin = new TestPlugin("Plugin Name");
    FakeConversable forWhom = new FakeConversable();

    ConversationContext context = new ConversationContext(plugin, forWhom, new HashMap<>());

    // Act
    String actualPrefix = pluginNameConversationPrefix.getPrefix(context);

    // Assert
    assertEquals("§dPlugin_Name > §f", actualPrefix);
  }
}
