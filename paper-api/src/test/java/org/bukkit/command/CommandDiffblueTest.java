package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import co.aikar.timings.TimingsCommand;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommandDiffblueTest {
  /**
   * Test {@link Command#getTimingName()}.
   *
   * <p>Method under test: {@link Command#getTimingName()}
   */
  @Test
  @DisplayName("Test getTimingName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getTimingName()"})
  void testGetTimingName() {
    // Arrange, Act and Assert
    assertEquals("help", new HelpCommand().getTimingName());
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[])} with {@code sender}, {@code
   * alias}, {@code args}.
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs() throws IllegalArgumentException {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};
    FormattedCommandAlias formattedCommandAlias =
        new FormattedCommandAlias("Sender cannot be null", formatStrings);

    // Act and Assert
    assertTrue(
        formattedCommandAlias
            .tabComplete(new BufferedCommandSender(), "Alias", new String[] {})
            .isEmpty());
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[])} with {@code sender}, {@code
   * alias}, {@code args}.
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs2() throws IllegalArgumentException {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};
    FormattedCommandAlias formattedCommandAlias = new FormattedCommandAlias("Alias", formatStrings);

    Server server = mock(Server.class);
    when(server.suggestPlayerNamesWhenNullTabCompletions()).thenReturn(false);

    MessageCommandSender sender = mock(MessageCommandSender.class);
    when(sender.getServer()).thenReturn(server);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Sender cannot be null"), "Sender cannot be null", true);

    // Act
    List<String> actualTabCompleteResult =
        formattedCommandAlias.tabComplete(sender, "Alias", new String[] {"Args"});

    // Assert
    verify(server).suggestPlayerNamesWhenNullTabCompletions();
    verify(sender).addAttachment(isA(Plugin.class), eq("Sender cannot be null"), eq(true));
    verify(sender).getServer();
    assertTrue(actualTabCompleteResult.isEmpty());
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[])} with {@code sender}, {@code
   * alias}, {@code args}.
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs3() throws IllegalArgumentException {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};
    FormattedCommandAlias formattedCommandAlias = new FormattedCommandAlias("Alias", formatStrings);

    Server server = mock(Server.class);
    Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenThrow(new IllegalArgumentException());
    when(server.suggestPlayerNamesWhenNullTabCompletions()).thenReturn(true);

    MessageCommandSender sender = mock(MessageCommandSender.class);
    when(sender.getServer()).thenReturn(server);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Sender cannot be null"), "Sender cannot be null", true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> formattedCommandAlias.tabComplete(sender, "Alias", new String[] {"Args"}));
    verify(server).getOnlinePlayers();
    verify(server).suggestPlayerNamesWhenNullTabCompletions();
    verify(sender).addAttachment(isA(Plugin.class), eq("Sender cannot be null"), eq(true));
    verify(sender, atLeast(1)).getServer();
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[], Location)} with {@code
   * sender}, {@code alias}, {@code args}, {@code location}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[], Location)}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[], Location) with 'sender', 'alias', 'args', 'location'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[], Location)"})
  void testTabCompleteWithSenderAliasArgsLocation_thenReturnEmpty()
      throws IllegalArgumentException {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    BufferedCommandSender sender = new BufferedCommandSender();
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertTrue(helpCommand.tabComplete(sender, "Alias", new String[] {}, location).isEmpty());
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[])} with {@code sender}, {@code
   * alias}, {@code args}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>When {@code Sender cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; given HelpCommand (default constructor); when 'Sender cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_givenHelpCommand_whenSenderCannotBeNull() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act and Assert
    assertTrue(
        helpCommand
            .tabComplete(new BufferedCommandSender(), "Sender cannot be null", new String[] {})
            .isEmpty());
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[])} with {@code sender}, {@code
   * alias}, {@code args}.
   *
   * <ul>
   *   <li>Given {@link Server} {@link Server#getOnlinePlayers()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; given Server getOnlinePlayers() return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_givenServerGetOnlinePlayersReturnArrayList()
      throws IllegalArgumentException {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};
    FormattedCommandAlias formattedCommandAlias = new FormattedCommandAlias("Alias", formatStrings);

    Server server = mock(Server.class);
    Mockito.<Collection<? extends Player>>when(server.getOnlinePlayers())
        .thenReturn(new ArrayList<>());
    when(server.suggestPlayerNamesWhenNullTabCompletions()).thenReturn(true);

    MessageCommandSender sender = mock(MessageCommandSender.class);
    when(sender.getServer()).thenReturn(server);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Sender cannot be null"), "Sender cannot be null", true);

    // Act
    List<String> actualTabCompleteResult =
        formattedCommandAlias.tabComplete(sender, "Alias", new String[] {"Args"});

    // Assert
    verify(server).getOnlinePlayers();
    verify(server).suggestPlayerNamesWhenNullTabCompletions();
    verify(sender).addAttachment(isA(Plugin.class), eq("Sender cannot be null"), eq(true));
    verify(sender, atLeast(1)).getServer();
    assertTrue(actualTabCompleteResult.isEmpty());
  }

  /**
   * Test {@link Command#tabComplete(CommandSender, String, String[])} with {@code sender}, {@code
   * alias}, {@code args}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Command#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; when empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_whenEmptyArrayOfString_thenReturnEmpty()
      throws IllegalArgumentException {
    // Arrange
    String[] formatStrings = new String[] {"Format Strings"};
    FormattedCommandAlias formattedCommandAlias = new FormattedCommandAlias("Alias", formatStrings);

    // Act and Assert
    assertTrue(
        formattedCommandAlias
            .tabComplete(new BufferedCommandSender(), "Alias", new String[] {})
            .isEmpty());
  }

  /**
   * Test {@link Command#getName()}.
   *
   * <p>Method under test: {@link Command#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("help", new HelpCommand().getName());
  }

  /**
   * Test {@link Command#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>When {@code Name}.
   *   <li>Then {@link HelpCommand} (default constructor) Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); given HelpCommand (default constructor); when 'Name'; then HelpCommand (default constructor) Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.setName(String)"})
  void testSetName_givenHelpCommand_whenName_thenHelpCommandNameIsName() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    boolean actualSetNameResult = helpCommand.setName("Name");

    // Assert
    assertEquals("Name", helpCommand.getName());
    assertEquals("Name", helpCommand.getTimingName());
    assertTrue(actualSetNameResult);
  }

  /**
   * Test {@link Command#setName(String)}.
   *
   * <ul>
   *   <li>Then {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Name is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link Command#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); then TimingsCommand(String) with 'Name' Name is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.setName(String)"})
  void testSetName_thenTimingsCommandWithNameNameIsEmptyString() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.register(null);

    // Act
    boolean actualSetNameResult = timingsCommand.setName(null);

    // Assert
    assertEquals("", timingsCommand.getName());
    assertEquals("", timingsCommand.getTimingName());
    assertTrue(actualSetNameResult);
  }

  /**
   * Test {@link Command#setName(String)}.
   *
   * <ul>
   *   <li>Then {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Name is {@code
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); then TimingsCommand(String) with 'Name' Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.setName(String)"})
  void testSetName_thenTimingsCommandWithNameNameIsName() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    timingsCommand.register(commandMap);

    // Act
    boolean actualSetNameResult = timingsCommand.setName(null);

    // Assert
    assertEquals("Name", timingsCommand.getName());
    assertEquals("Name", timingsCommand.getTimingName());
    assertFalse(actualSetNameResult);
  }

  /**
   * Test {@link Command#getPermission()}.
   *
   * <p>Method under test: {@link Command#getPermission()}
   */
  @Test
  @DisplayName("Test getPermission()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getPermission()"})
  void testGetPermission() {
    // Arrange, Act and Assert
    assertEquals("bukkit.command.help", new HelpCommand().getPermission());
  }

  /**
   * Test {@link Command#setPermission(String)}.
   *
   * <p>Method under test: {@link Command#setPermission(String)}
   */
  @Test
  @DisplayName("Test setPermission(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.setPermission(String)"})
  void testSetPermission() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    helpCommand.setPermission("Permission");

    // Assert
    assertEquals("Permission", helpCommand.getPermission());
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Permission is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) Permission is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionIsEmptyString() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermission("");
    helpCommand.setPermissionMessage(";");

    // Act and Assert
    assertTrue(helpCommand.testPermission(mock(BufferedCommandSender.class)));
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Permission is {@code null}.
   *   <li>When {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) Permission is 'null'; when BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionIsNull_whenBufferedCommandSender() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermission(null);
    helpCommand.setPermissionMessage(";");

    // Act and Assert
    assertTrue(helpCommand.testPermission(mock(BufferedCommandSender.class)));
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) PermissionMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) PermissionMessage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionMessageIsEmptyString() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage("");

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) PermissionMessage is {@code
   *       <permission>}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) PermissionMessage is '<permission>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionMessageIsPermission() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage("<permission>");

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    doNothing().when(target).sendMessage(Mockito.<Component>any());
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).sendMessage(isA(Component.class));
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) PermissionMessage is {@code
   *       <permission>;}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) PermissionMessage is '<permission>;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionMessageIsPermission2() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage("<permission>;");

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    doNothing().when(target).sendMessage(Mockito.<Component>any());
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).sendMessage(isA(Component.class));
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) PermissionMessage is {@code
   *       ;<permission>}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) PermissionMessage is ';<permission>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionMessageIsPermission3() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage(";<permission>");

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    doNothing().when(target).sendMessage(Mockito.<Component>any());
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).sendMessage(isA(Component.class));
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) PermissionMessage is {@code
   *       <permission><permission>}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) PermissionMessage is '<permission><permission>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionMessageIsPermissionPermission() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage("<permission><permission>");

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    doNothing().when(target).sendMessage(Mockito.<Component>any());
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).sendMessage(isA(Component.class));
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) PermissionMessage is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given HelpCommand (default constructor) PermissionMessage is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenHelpCommandPermissionMessageIsSemicolon() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage(";");

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    doNothing().when(target).sendMessage(Mockito.<Component>any());
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).sendMessage(isA(Component.class));
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermission(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link BufferedCommandSender} {@link BufferedCommandSender#hasPermission(String)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermission(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermission(CommandSender); given 'true'; when BufferedCommandSender hasPermission(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermission(CommandSender)"})
  void testTestPermission_givenTrue_whenBufferedCommandSenderHasPermissionReturnTrue() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    when(target.hasPermission(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualTestPermissionResult = helpCommand.testPermission(target);

    // Assert
    verify(target).hasPermission("bukkit.command.help");
    assertTrue(actualTestPermissionResult);
  }

  /**
   * Test {@link Command#testPermissionSilent(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermissionSilent(CommandSender)}
   */
  @Test
  @DisplayName("Test testPermissionSilent(CommandSender); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermissionSilent(CommandSender)"})
  void testTestPermissionSilent_givenFalse() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    when(target.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualTestPermissionSilentResult = helpCommand.testPermissionSilent(target);

    // Assert
    verify(target).hasPermission("bukkit.command.help");
    assertFalse(actualTestPermissionSilentResult);
  }

  /**
   * Test {@link Command#testPermissionSilent(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Permission is {@code ;}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermissionSilent(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermissionSilent(CommandSender); given HelpCommand (default constructor) Permission is ';'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermissionSilent(CommandSender)"})
  void testTestPermissionSilent_givenHelpCommandPermissionIsSemicolon_thenReturnFalse() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermission(";");

    // Act and Assert
    assertFalse(helpCommand.testPermissionSilent(new BufferedCommandSender()));
  }

  /**
   * Test {@link Command#testPermissionSilent(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermissionSilent(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermissionSilent(CommandSender); given TimingsCommand(String) with 'Name' Permission is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermissionSilent(CommandSender)"})
  void testTestPermissionSilent_givenTimingsCommandWithNamePermissionIsEmptyString() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.setPermission("");

    // Act and Assert
    assertTrue(timingsCommand.testPermissionSilent(new BufferedCommandSender()));
  }

  /**
   * Test {@link Command#testPermissionSilent(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermissionSilent(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test testPermissionSilent(CommandSender); given TimingsCommand(String) with 'Name' Permission is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermissionSilent(CommandSender)"})
  void testTestPermissionSilent_givenTimingsCommandWithNamePermissionIsNull() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.setPermission(null);

    // Act and Assert
    assertTrue(timingsCommand.testPermissionSilent(new BufferedCommandSender()));
  }

  /**
   * Test {@link Command#testPermissionSilent(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Command#testPermissionSilent(CommandSender)}
   */
  @Test
  @DisplayName("Test testPermissionSilent(CommandSender); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.testPermissionSilent(CommandSender)"})
  void testTestPermissionSilent_givenTrue() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    BufferedCommandSender target = mock(BufferedCommandSender.class);
    when(target.hasPermission(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualTestPermissionSilentResult = helpCommand.testPermissionSilent(target);

    // Assert
    verify(target).hasPermission("bukkit.command.help");
    assertTrue(actualTestPermissionSilentResult);
  }

  /**
   * Test {@link Command#getLabel()}.
   *
   * <p>Method under test: {@link Command#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("help", new HelpCommand().getLabel());
  }

  /**
   * Test {@link Command#setLabel(String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>When {@code Name}.
   *   <li>Then {@link HelpCommand} (default constructor) Label is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setLabel(String)}
   */
  @Test
  @DisplayName(
      "Test setLabel(String); given HelpCommand (default constructor); when 'Name'; then HelpCommand (default constructor) Label is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.setLabel(String)"})
  void testSetLabel_givenHelpCommand_whenName_thenHelpCommandLabelIsName() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    boolean actualSetLabelResult = helpCommand.setLabel("Name");

    // Assert
    assertEquals("Name", helpCommand.getLabel());
    assertTrue(actualSetLabelResult);
  }

  /**
   * Test {@link Command#setLabel(String)}.
   *
   * <ul>
   *   <li>Then {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Label is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link Command#setLabel(String)}
   */
  @Test
  @DisplayName(
      "Test setLabel(String); then TimingsCommand(String) with 'Name' Label is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.setLabel(String)"})
  void testSetLabel_thenTimingsCommandWithNameLabelIsEmptyString() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    timingsCommand.register(null);

    // Act
    boolean actualSetLabelResult = timingsCommand.setLabel(null);

    // Assert
    assertEquals("", timingsCommand.getLabel());
    assertTrue(actualSetLabelResult);
  }

  /**
   * Test {@link Command#setLabel(String)}.
   *
   * <ul>
   *   <li>Then {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Label is {@code
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String); then TimingsCommand(String) with 'Name' Label is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.setLabel(String)"})
  void testSetLabel_thenTimingsCommandWithNameLabelIsName() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    timingsCommand.register(commandMap);

    // Act
    boolean actualSetLabelResult = timingsCommand.setLabel(null);

    // Assert
    assertEquals("Name", timingsCommand.getLabel());
    assertFalse(actualSetLabelResult);
  }

  /**
   * Test {@link Command#register(CommandMap)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>Then {@link HelpCommand} (default constructor) Registered.
   * </ul>
   *
   * <p>Method under test: {@link Command#register(CommandMap)}
   */
  @Test
  @DisplayName(
      "Test register(CommandMap); given HelpCommand (default constructor); then HelpCommand (default constructor) Registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.register(CommandMap)"})
  void testRegister_givenHelpCommand_thenHelpCommandRegistered() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act
    boolean actualRegisterResult = helpCommand.register(commandMap);

    // Assert
    assertTrue(helpCommand.isRegistered());
    assertTrue(actualRegisterResult);
  }

  /**
   * Test {@link Command#register(CommandMap)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Command#register(CommandMap)}
   */
  @Test
  @DisplayName("Test register(CommandMap); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.register(CommandMap)"})
  void testRegister_thenReturnFalse() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    timingsCommand.register(commandMap);
    Server server2 = mock(Server.class);
    SimpleCommandMap commandMap2 = new SimpleCommandMap(server2, new HashMap<>());

    // Act
    boolean actualRegisterResult = timingsCommand.register(commandMap2);

    // Assert
    assertFalse(actualRegisterResult);
    assertTrue(timingsCommand.isRegistered());
  }

  /**
   * Test {@link Command#unregister(CommandMap)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Command#unregister(CommandMap)}
   */
  @Test
  @DisplayName(
      "Test unregister(CommandMap); given HelpCommand (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.unregister(CommandMap)"})
  void testUnregister_givenHelpCommand_thenReturnTrue() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act
    boolean actualUnregisterResult = helpCommand.unregister(commandMap);

    // Assert
    assertTrue(actualUnregisterResult);
  }

  /**
   * Test {@link Command#unregister(CommandMap)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Command#unregister(CommandMap)}
   */
  @Test
  @DisplayName("Test unregister(CommandMap); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.unregister(CommandMap)"})
  void testUnregister_thenReturnFalse() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    timingsCommand.register(commandMap);
    Server server2 = mock(Server.class);
    SimpleCommandMap commandMap2 = new SimpleCommandMap(server2, new HashMap<>());

    // Act
    boolean actualUnregisterResult = timingsCommand.unregister(commandMap2);

    // Assert
    assertFalse(actualUnregisterResult);
  }

  /**
   * Test {@link Command#isRegistered()}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Command#isRegistered()}
   */
  @Test
  @DisplayName("Test isRegistered(); given HelpCommand (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.isRegistered()"})
  void testIsRegistered_givenHelpCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new HelpCommand().isRegistered());
  }

  /**
   * Test {@link Command#isRegistered()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Command#isRegistered()}
   */
  @Test
  @DisplayName("Test isRegistered(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.isRegistered()"})
  void testIsRegistered_thenReturnTrue() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    timingsCommand.register(commandMap);

    // Act and Assert
    assertTrue(timingsCommand.isRegistered());
  }

  /**
   * Test {@link Command#getAliases()}.
   *
   * <p>Method under test: {@link Command#getAliases()}
   */
  @Test
  @DisplayName("Test getAliases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Command.getAliases()"})
  void testGetAliases() {
    // Arrange and Act
    List<String> actualAliases = new HelpCommand().getAliases();

    // Assert
    assertEquals(1, actualAliases.size());
    assertEquals("?", actualAliases.get(0));
  }

  /**
   * Test {@link Command#getPermissionMessage()}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Command#getPermissionMessage()}
   */
  @Test
  @DisplayName(
      "Test getPermissionMessage(); given HelpCommand (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getPermissionMessage()"})
  void testGetPermissionMessage_givenHelpCommand_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new HelpCommand().getPermissionMessage());
  }

  /**
   * Test {@link Command#getPermissionMessage()}.
   *
   * <ul>
   *   <li>Then return {@code Permission Message}.
   * </ul>
   *
   * <p>Method under test: {@link Command#getPermissionMessage()}
   */
  @Test
  @DisplayName("Test getPermissionMessage(); then return 'Permission Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getPermissionMessage()"})
  void testGetPermissionMessage_thenReturnPermissionMessage() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    helpCommand.setPermissionMessage("Permission Message");

    // Act and Assert
    assertEquals("Permission Message", helpCommand.getPermissionMessage());
  }

  /**
   * Test {@link Command#getDescription()}.
   *
   * <p>Method under test: {@link Command#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("Shows the help menu", new HelpCommand().getDescription());
  }

  /**
   * Test {@link Command#getUsage()}.
   *
   * <p>Method under test: {@link Command#getUsage()}
   */
  @Test
  @DisplayName("Test getUsage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.getUsage()"})
  void testGetUsage() {
    // Arrange, Act and Assert
    assertEquals(
        "/help <pageNumber>\n/help <topic>\n/help <topic> <pageNumber>",
        new HelpCommand().getUsage());
  }

  /**
   * Test {@link Command#setAliases(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Command#setAliases(List)}
   */
  @Test
  @DisplayName(
      "Test setAliases(List); given '42'; when ArrayList() add '42'; then return HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setAliases(List)"})
  void testSetAliases_given42_whenArrayListAdd42_thenReturnHelpCommand() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("42");
    aliases.add("foo");

    // Act
    Command actualSetAliasesResult = helpCommand.setAliases(aliases);

    // Assert
    assertSame(helpCommand, actualSetAliasesResult);
  }

  /**
   * Test {@link Command#setAliases(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@link HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Command#setAliases(List)}
   */
  @Test
  @DisplayName(
      "Test setAliases(List); given 'foo'; when ArrayList() add 'foo'; then return HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setAliases(List)"})
  void testSetAliases_givenFoo_whenArrayListAddFoo_thenReturnHelpCommand() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("foo");

    // Act
    Command actualSetAliasesResult = helpCommand.setAliases(aliases);

    // Assert
    assertSame(helpCommand, actualSetAliasesResult);
  }

  /**
   * Test {@link Command#setAliases(List)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Command#setAliases(List)}
   */
  @Test
  @DisplayName(
      "Test setAliases(List); given HelpCommand (default constructor); when ArrayList(); then return HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setAliases(List)"})
  void testSetAliases_givenHelpCommand_whenArrayList_thenReturnHelpCommand() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetAliasesResult = helpCommand.setAliases(new ArrayList<>());

    // Assert
    assertSame(helpCommand, actualSetAliasesResult);
  }

  /**
   * Test {@link Command#setAliases(List)}.
   *
   * <ul>
   *   <li>Then return {@link TimingsCommand#TimingsCommand(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setAliases(List)}
   */
  @Test
  @DisplayName("Test setAliases(List); then return TimingsCommand(String) with 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setAliases(List)"})
  void testSetAliases_thenReturnTimingsCommandWithName() {
    // Arrange
    TimingsCommand timingsCommand = new TimingsCommand("Name");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    timingsCommand.register(commandMap);

    // Act
    Command actualSetAliasesResult = timingsCommand.setAliases(new ArrayList<>());

    // Assert
    assertSame(timingsCommand, actualSetAliasesResult);
  }

  /**
   * Test {@link Command#setDescription(String)}.
   *
   * <p>Method under test: {@link Command#setDescription(String)}
   */
  @Test
  @DisplayName("Test setDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setDescription(String)"})
  void testSetDescription() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetDescriptionResult =
        helpCommand.setDescription("The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something", helpCommand.getDescription());
    assertSame(helpCommand, actualSetDescriptionResult);
  }

  /**
   * Test {@link Command#setDescription(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link HelpCommand} (default constructor) Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#setDescription(String)}
   */
  @Test
  @DisplayName(
      "Test setDescription(String); when 'null'; then HelpCommand (default constructor) Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setDescription(String)"})
  void testSetDescription_whenNull_thenHelpCommandDescriptionIsEmptyString() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetDescriptionResult = helpCommand.setDescription(null);

    // Assert
    assertEquals("", helpCommand.getDescription());
    assertSame(helpCommand, actualSetDescriptionResult);
  }

  /**
   * Test {@link Command#setPermissionMessage(String)}.
   *
   * <ul>
   *   <li>Then {@link HelpCommand} (default constructor) PermissionMessage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#setPermissionMessage(String)}
   */
  @Test
  @DisplayName(
      "Test setPermissionMessage(String); then HelpCommand (default constructor) PermissionMessage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setPermissionMessage(String)"})
  void testSetPermissionMessage_thenHelpCommandPermissionMessageIsEmptyString() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetPermissionMessageResult = helpCommand.setPermissionMessage("");

    // Assert
    assertTrue(actualSetPermissionMessageResult instanceof HelpCommand);
    assertEquals("", helpCommand.getPermissionMessage());
    assertEquals("", actualSetPermissionMessageResult.getPermissionMessage());
    Component permissionMessageResult = actualSetPermissionMessageResult.permissionMessage();
    assertNull(permissionMessageResult.insertion());
    assertNull(permissionMessageResult.font());
    assertNull(permissionMessageResult.color());
    Map<TextDecoration, State> decorationsResult = permissionMessageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(permissionMessageResult.hasStyling());
    Component actualCompactResult = permissionMessageResult.compact();
    assertSame(permissionMessageResult, actualCompactResult);
  }

  /**
   * Test {@link Command#setPermissionMessage(String)}.
   *
   * <ul>
   *   <li>Then {@link HelpCommand} (default constructor) PermissionMessage is {@code Permission
   *       Message}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setPermissionMessage(String)}
   */
  @Test
  @DisplayName(
      "Test setPermissionMessage(String); then HelpCommand (default constructor) PermissionMessage is 'Permission Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setPermissionMessage(String)"})
  void testSetPermissionMessage_thenHelpCommandPermissionMessageIsPermissionMessage() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetPermissionMessageResult =
        helpCommand.setPermissionMessage("Permission Message");

    // Assert
    assertTrue(actualSetPermissionMessageResult instanceof HelpCommand);
    assertEquals("Permission Message", helpCommand.getPermissionMessage());
    assertEquals("Permission Message", actualSetPermissionMessageResult.getPermissionMessage());
    Component permissionMessageResult = actualSetPermissionMessageResult.permissionMessage();
    Component actualCompactResult = permissionMessageResult.compact();
    assertEquals(permissionMessageResult, actualCompactResult);
  }

  /**
   * Test {@link Command#setPermissionMessage(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link HelpCommand} (default constructor) PermissionMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setPermissionMessage(String)}
   */
  @Test
  @DisplayName(
      "Test setPermissionMessage(String); when 'null'; then HelpCommand (default constructor) PermissionMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setPermissionMessage(String)"})
  void testSetPermissionMessage_whenNull_thenHelpCommandPermissionMessageIsNull() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetPermissionMessageResult = helpCommand.setPermissionMessage(null);

    // Assert
    assertNull(helpCommand.getPermissionMessage());
    assertSame(helpCommand, actualSetPermissionMessageResult);
  }

  /**
   * Test {@link Command#setUsage(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link HelpCommand} (default constructor) Usage is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#setUsage(String)}
   */
  @Test
  @DisplayName(
      "Test setUsage(String); when 'null'; then HelpCommand (default constructor) Usage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setUsage(String)"})
  void testSetUsage_whenNull_thenHelpCommandUsageIsEmptyString() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetUsageResult = helpCommand.setUsage(null);

    // Assert
    assertEquals("", helpCommand.getUsage());
    assertSame(helpCommand, actualSetUsageResult);
  }

  /**
   * Test {@link Command#setUsage(String)}.
   *
   * <ul>
   *   <li>When {@code Usage}.
   *   <li>Then {@link HelpCommand} (default constructor) Usage is {@code Usage}.
   * </ul>
   *
   * <p>Method under test: {@link Command#setUsage(String)}
   */
  @Test
  @DisplayName(
      "Test setUsage(String); when 'Usage'; then HelpCommand (default constructor) Usage is 'Usage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command Command.setUsage(String)"})
  void testSetUsage_whenUsage_thenHelpCommandUsageIsUsage() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act
    Command actualSetUsageResult = helpCommand.setUsage("Usage");

    // Assert
    assertEquals("Usage", helpCommand.getUsage());
    assertSame(helpCommand, actualSetUsageResult);
  }

  /**
   * Test {@link Command#permissionMessage()}.
   *
   * <p>Method under test: {@link Command#permissionMessage()}
   */
  @Test
  @DisplayName("Test permissionMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component Command.permissionMessage()"})
  void testPermissionMessage() {
    // Arrange, Act and Assert
    assertNull(new HelpCommand().permissionMessage());
  }

  /**
   * Test {@link Command#permissionMessage(Component)} with {@code Component}.
   *
   * <p>Method under test: {@link Command#permissionMessage(Component)}
   */
  @Test
  @DisplayName("Test permissionMessage(Component) with 'Component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.permissionMessage(Component)"})
  void testPermissionMessageWithComponent() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    Component permissionMessage = mock(Component.class);

    // Act
    helpCommand.permissionMessage(permissionMessage);

    // Assert
    assertSame(permissionMessage, helpCommand.permissionMessage());
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component)} with {@code
   * CommandSender}, {@code Component}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component) with 'CommandSender', 'Component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component)"})
  void testBroadcastCommandMessageWithCommandSenderComponent() {
    // Arrange
    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class)));
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component)} with {@code
   * CommandSender}, {@code Component}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component) with 'CommandSender', 'Component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component)"})
  void testBroadcastCommandMessageWithCommandSenderComponent2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getWorld()).thenThrow(new IllegalArgumentException());

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class)));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component)} with {@code
   * CommandSender}, {@code Component}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component) with 'CommandSender', 'Component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component)"})
  void testBroadcastCommandMessageWithCommandSenderComponent3() {
    // Arrange
    CommandMinecart source = mock(CommandMinecart.class);
    when(source.getWorld()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class)));
    verify(source).name();
    verify(source).getWorld();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component, boolean)} with {@code
   * CommandSender}, {@code Component}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component, boolean) with 'CommandSender', 'Component', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderComponentBoolean() {
    // Arrange
    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class), false));
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component, boolean)} with {@code
   * CommandSender}, {@code Component}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component, boolean) with 'CommandSender', 'Component', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderComponentBoolean2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getWorld()).thenThrow(new IllegalArgumentException());

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class), false));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component, boolean)} with {@code
   * CommandSender}, {@code Component}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component, boolean) with 'CommandSender', 'Component', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderComponentBoolean3() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class), false));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component, boolean)} with {@code
   * CommandSender}, {@code Component}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component, boolean) with 'CommandSender', 'Component', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderComponentBoolean4() {
    // Arrange
    CommandMinecart source = mock(CommandMinecart.class);
    when(source.getWorld()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class), false));
    verify(source).name();
    verify(source).getWorld();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component, boolean)} with {@code
   * CommandSender}, {@code Component}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component, boolean) with 'CommandSender', 'Component', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderComponentBoolean5() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    CommandMinecart source = mock(CommandMinecart.class);
    when(source.getWorld()).thenReturn(world);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class), false));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(source).name();
    verify(source).getWorld();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component)} with {@code
   * CommandSender}, {@code Component}.
   *
   * <ul>
   *   <li>Then calls {@link World#getGameRuleValue(GameRule)}.
   * </ul>
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component) with 'CommandSender', 'Component'; then calls getGameRuleValue(GameRule)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component)"})
  void testBroadcastCommandMessageWithCommandSenderComponent_thenCallsGetGameRuleValue() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class)));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, Component)} with {@code
   * CommandSender}, {@code Component}.
   *
   * <ul>
   *   <li>Then calls {@link World#getGameRuleValue(GameRule)}.
   * </ul>
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, Component)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, Component) with 'CommandSender', 'Component'; then calls getGameRuleValue(GameRule)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, Component)"})
  void testBroadcastCommandMessageWithCommandSenderComponent_thenCallsGetGameRuleValue2() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    CommandMinecart source = mock(CommandMinecart.class);
    when(source.getWorld()).thenReturn(world);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, mock(Component.class)));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(source).name();
    verify(source).getWorld();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String)} with {@code CommandSender},
   * {@code String}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String)}
   */
  @Test
  @DisplayName("Test broadcastCommandMessage(CommandSender, String) with 'CommandSender', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String)"})
  void testBroadcastCommandMessageWithCommandSenderString() {
    // Arrange
    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.name()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost"));
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String)} with {@code CommandSender},
   * {@code String}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String)}
   */
  @Test
  @DisplayName("Test broadcastCommandMessage(CommandSender, String) with 'CommandSender', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String)"})
  void testBroadcastCommandMessageWithCommandSenderString2() {
    // Arrange
    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost"));
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String)} with {@code CommandSender},
   * {@code String}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String)}
   */
  @Test
  @DisplayName("Test broadcastCommandMessage(CommandSender, String) with 'CommandSender', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String)"})
  void testBroadcastCommandMessageWithCommandSenderString3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getWorld()).thenThrow(new IllegalArgumentException());

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost"));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String, boolean)} with {@code
   * CommandSender}, {@code String}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String, boolean) with 'CommandSender', 'String', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderStringBoolean() {
    // Arrange
    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost", false));
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String, boolean)} with {@code
   * CommandSender}, {@code String}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String, boolean) with 'CommandSender', 'String', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderStringBoolean2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getWorld()).thenThrow(new IllegalArgumentException());

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost", false));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String, boolean)} with {@code
   * CommandSender}, {@code String}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String, boolean) with 'CommandSender', 'String', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderStringBoolean3() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost", false));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String, boolean)} with {@code
   * CommandSender}, {@code String}, {@code boolean}.
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String, boolean) with 'CommandSender', 'String', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderStringBoolean4() {
    // Arrange
    CommandMinecart source = mock(CommandMinecart.class);
    when(source.getWorld()).thenThrow(new IllegalArgumentException());
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost", false));
    verify(source).name();
    verify(source).getWorld();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String, boolean)} with {@code
   * CommandSender}, {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>Then calls {@link CommandMinecart#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String, boolean) with 'CommandSender', 'String', 'boolean'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderStringBoolean_thenCallsName() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    CommandMinecart source = mock(CommandMinecart.class);
    when(source.getWorld()).thenReturn(world);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost", false));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(source).name();
    verify(source).getWorld();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String, boolean)} with {@code
   * CommandSender}, {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String, boolean) with 'CommandSender', 'String', 'boolean'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String, boolean)"})
  void testBroadcastCommandMessageWithCommandSenderStringBoolean_whenEmptyString() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> Command.broadcastCommandMessage(source, "", false));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String)} with {@code CommandSender},
   * {@code String}.
   *
   * <ul>
   *   <li>Then calls {@link World#getGameRuleValue(GameRule)}.
   * </ul>
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String) with 'CommandSender', 'String'; then calls getGameRuleValue(GameRule)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String)"})
  void testBroadcastCommandMessageWithCommandSenderString_thenCallsGetGameRuleValue() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> Command.broadcastCommandMessage(source, "Not all who wander are lost"));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#broadcastCommandMessage(CommandSender, String)} with {@code CommandSender},
   * {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link Command#broadcastCommandMessage(CommandSender, String)}
   */
  @Test
  @DisplayName(
      "Test broadcastCommandMessage(CommandSender, String) with 'CommandSender', 'String'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Command.broadcastCommandMessage(CommandSender, String)"})
  void testBroadcastCommandMessageWithCommandSenderString_whenEmptyString() {
    // Arrange
    World world = mock(World.class);
    when(world.getGameRuleValue(Mockito.<GameRule<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    Block block = mock(Block.class);
    when(block.getWorld()).thenReturn(world);

    BlockCommandSender source = mock(BlockCommandSender.class);
    when(source.getBlock()).thenReturn(block);
    when(source.name()).thenReturn(mock(Component.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Command.broadcastCommandMessage(source, ""));
    verify(world).getGameRuleValue(isA(GameRule.class));
    verify(block).getWorld();
    verify(source).getBlock();
    verify(source).name();
  }

  /**
   * Test {@link Command#toString()}.
   *
   * <p>Method under test: {@link Command#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Command.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("org.bukkit.command.defaults.HelpCommand(help)", new HelpCommand().toString());
  }

  /**
   * Test {@link Command#canBeOverriden()}.
   *
   * <p>Method under test: {@link Command#canBeOverriden()}
   */
  @Test
  @DisplayName("Test canBeOverriden()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Command.canBeOverriden()"})
  void testCanBeOverriden() {
    // Arrange, Act and Assert
    assertFalse(new HelpCommand().canBeOverriden());
  }
}
