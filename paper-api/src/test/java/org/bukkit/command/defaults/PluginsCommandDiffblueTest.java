package org.bukkit.command.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginsCommandDiffblueTest {
  /**
   * Test {@link PluginsCommand#PluginsCommand(String)}.
   *
   * <p>Method under test: {@link PluginsCommand#PluginsCommand(String)}
   */
  @Test
  @DisplayName("Test new PluginsCommand(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginsCommand.<init>(String)"})
  void testNewPluginsCommand() {
    // Arrange and Act
    PluginsCommand actualPluginsCommand = new PluginsCommand("Name");

    // Assert
    assertEquals("/plugins", actualPluginsCommand.getUsage());
    assertEquals(
        "Gets a list of plugins running on the server", actualPluginsCommand.getDescription());
    assertEquals("Name", actualPluginsCommand.getLabel());
    assertEquals("Name", actualPluginsCommand.getName());
    assertEquals("Name", actualPluginsCommand.getTimingName());
    assertEquals("bukkit.command.plugins", actualPluginsCommand.getPermission());
    List<String> aliases = actualPluginsCommand.getAliases();
    assertEquals(1, aliases.size());
    assertEquals("pl", aliases.get(0));
    assertNull(actualPluginsCommand.timings);
    assertNull(actualPluginsCommand.getPermissionMessage());
    assertNull(actualPluginsCommand.permissionMessage());
    assertFalse(actualPluginsCommand.isRegistered());
  }

  /**
   * Test {@link PluginsCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <p>Method under test: {@link PluginsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs() throws IllegalArgumentException {
    // Arrange
    PluginsCommand pluginsCommand = new PluginsCommand("Name");

    // Act and Assert
    assertTrue(
        pluginsCommand
            .tabComplete(new BufferedCommandSender(), "Alias", new String[] {"Args"})
            .isEmpty());
  }
}
