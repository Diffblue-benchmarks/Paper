package org.bukkit.command.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.MessageCommandSender;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VersionCommandDiffblueTest {
  /**
   * Test {@link VersionCommand#VersionCommand(String)}.
   *
   * <p>Method under test: {@link VersionCommand#VersionCommand(String)}
   */
  @Test
  @DisplayName("Test new VersionCommand(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionCommand.<init>(String)"})
  void testNewVersionCommand() {
    // Arrange and Act
    VersionCommand actualVersionCommand = new VersionCommand("Name");

    // Assert
    assertEquals("/version [plugin name]", actualVersionCommand.getUsage());
    assertEquals(
        "Gets the version of this server including any plugins in use",
        actualVersionCommand.getDescription());
    assertEquals("Name", actualVersionCommand.getLabel());
    assertEquals("Name", actualVersionCommand.getName());
    assertEquals("Name", actualVersionCommand.getTimingName());
    assertEquals("bukkit.command.version", actualVersionCommand.getPermission());
    assertNull(actualVersionCommand.timings);
    assertNull(actualVersionCommand.getPermissionMessage());
    assertNull(actualVersionCommand.permissionMessage());
    assertEquals(2, actualVersionCommand.getAliases().size());
    assertFalse(actualVersionCommand.isRegistered());
  }

  /**
   * Test {@link VersionCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@link MessageCommandSender} {@link MessageCommandSender#sendMessage(Component)}
   *       does nothing.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VersionCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when MessageCommandSender sendMessage(Component) does nothing; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenMessageCommandSenderSendMessageDoesNothing_thenReturnTrue() {
    // Arrange
    VersionCommand versionCommand = new VersionCommand("Name");

    MessageCommandSender sender = mock(MessageCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(true);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(
        new TestPlugin("Plugin Name"), "co.aikar.timings.TimingsReportListener", false);

    // Act
    boolean actualExecuteResult = versionCommand.execute(sender, "Current Alias", new String[] {});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(sender)
        .addAttachment(isA(Plugin.class), eq("co.aikar.timings.TimingsReportListener"), eq(false));
    verify(sender).hasPermission("bukkit.command.version");
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link VersionCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link VersionCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; when empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List VersionCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange
    VersionCommand versionCommand = new VersionCommand("Name");

    // Act and Assert
    assertTrue(
        versionCommand
            .tabComplete(new BufferedCommandSender(), "Alias", new String[] {})
            .isEmpty());
  }
}
