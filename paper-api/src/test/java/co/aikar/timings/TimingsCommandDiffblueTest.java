package co.aikar.timings;

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
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
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

class TimingsCommandDiffblueTest {
  /**
   * Test {@link TimingsCommand#TimingsCommand(String)}.
   *
   * <p>Method under test: {@link TimingsCommand#TimingsCommand(String)}
   */
  @Test
  @DisplayName("Test new TimingsCommand(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsCommand.<init>(String)"})
  void testNewTimingsCommand() {
    // Arrange and Act
    TimingsCommand actualTimingsCommand = new TimingsCommand("Name");

    // Assert
    assertEquals("/timings <reset|report|on|off|verbon|verboff>", actualTimingsCommand.getUsage());
    assertEquals(
        "Manages Spigot Timings data to see performance of the server.",
        actualTimingsCommand.getDescription());
    assertEquals("Name", actualTimingsCommand.getLabel());
    assertEquals("Name", actualTimingsCommand.getName());
    assertEquals("Name", actualTimingsCommand.getTimingName());
    assertEquals("bukkit.command.timings", actualTimingsCommand.getPermission());
    assertNull(actualTimingsCommand.timings);
    assertNull(actualTimingsCommand.getPermissionMessage());
    assertNull(actualTimingsCommand.permissionMessage());
    assertFalse(actualTimingsCommand.isRegistered());
    assertTrue(actualTimingsCommand.getAliases().isEmpty());
  }

  /**
   * Test {@link TimingsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link Component} {@link Component#replaceText(TextReplacementConfig)} return
   *       {@link Component}.
   *   <li>Then calls {@link Component#replaceText(TextReplacementConfig)}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given Component replaceText(TextReplacementConfig) return Component; then calls replaceText(TextReplacementConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingsCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenComponentReplaceTextReturnComponent_thenCallsReplaceText() {
    // Arrange
    Component permissionMessage = mock(Component.class);
    when(permissionMessage.replaceText(Mockito.<TextReplacementConfig>any()))
        .thenReturn(mock(Component.class));

    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.permissionMessage(permissionMessage);

    MessageCommandSender sender = mock(MessageCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(false);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualExecuteResult =
        timingsCommand.execute(sender, "Current Alias", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(permissionMessage).replaceText(isA(TextReplacementConfig.class));
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(sender).hasPermission("bukkit.command.timings");
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link TimingsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is empty
   *       string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TimingsCommand(String) with 'Name' Permission is empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingsCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTimingsCommandWithNamePermissionIsEmptyString_thenReturnTrue() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.setPermission("");
    timingsCommand.permissionMessage(mock(Component.class));

    MessageCommandSender sender = mock(MessageCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualExecuteResult =
        timingsCommand.execute(sender, "Current Alias", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link TimingsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is
   *       {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TimingsCommand(String) with 'Name' Permission is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingsCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTimingsCommandWithNamePermissionIsNull_thenReturnTrue() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.setPermission(null);
    timingsCommand.permissionMessage(mock(Component.class));

    MessageCommandSender sender = mock(MessageCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualExecuteResult =
        timingsCommand.execute(sender, "Current Alias", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link TimingsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} PermissionMessage
   *       is {@code Permission Message}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); given TimingsCommand(String) with 'Name' PermissionMessage is 'Permission Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingsCommand.execute(CommandSender, String, String[])"})
  void testExecute_givenTimingsCommandWithNamePermissionMessageIsPermissionMessage() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.setPermissionMessage("Permission Message");

    MessageCommandSender sender = mock(MessageCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(false);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualExecuteResult =
        timingsCommand.execute(sender, "Current Alias", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(sender).hasPermission("bukkit.command.timings");
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link TimingsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(String)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when MessageCommandSender hasPermission(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingsCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenMessageCommandSenderHasPermissionReturnTrue() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");

    MessageCommandSender sender = mock(MessageCommandSender.class);
    doNothing().when(sender).sendMessage(Mockito.<Component>any());
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(true);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualExecuteResult =
        timingsCommand.execute(sender, "Current Alias", new String[] {"Args"});

    // Assert
    verify(sender).sendMessage(isA(Component.class));
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(sender).hasPermission("bukkit.command.timings");
    assertTrue(actualExecuteResult);
  }

  /**
   * Test {@link TimingsCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; when array of String with 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TimingsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_whenArrayOfStringWithArgs_thenReturnEmpty() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");

    // Act and Assert
    assertTrue(
        timingsCommand
            .tabComplete(new BufferedCommandSender(), "Alias", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link TimingsCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code off}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; when array of String with 'off'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TimingsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_whenArrayOfStringWithOff_thenReturnSizeIsOne() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");

    // Act
    List<String> actualTabCompleteResult =
        timingsCommand.tabComplete(new BufferedCommandSender(), "Alias", new String[] {"off"});

    // Assert
    assertEquals(1, actualTabCompleteResult.size());
    assertEquals("off", actualTabCompleteResult.get(0));
  }

  /**
   * Test {@link TimingsCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TimingsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; when empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TimingsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");

    // Act and Assert
    assertTrue(
        timingsCommand
            .tabComplete(new BufferedCommandSender(), "Alias", new String[] {})
            .isEmpty());
  }
}
