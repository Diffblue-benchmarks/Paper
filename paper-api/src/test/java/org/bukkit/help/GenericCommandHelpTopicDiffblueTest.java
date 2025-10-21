package org.bukkit.help;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import co.aikar.timings.TimingsCommand;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Server;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.command.defaults.VersionCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GenericCommandHelpTopicDiffblueTest {
  /**
   * Test {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)}.
   *
   * <ul>
   *   <li>Then {@link GenericCommandHelpTopic#command} return {@link TimingsCommand}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)}
   */
  @Test
  @DisplayName("Test new GenericCommandHelpTopic(Command); then command return TimingsCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericCommandHelpTopic.<init>(Command)"})
  void testNewGenericCommandHelpTopic_thenCommandReturnTimingsCommand() {
    // Arrange and Act
    GenericCommandHelpTopic actualGenericCommandHelpTopic =
        new GenericCommandHelpTopic(new TimingsCommand("/"));

    // Assert
    Command command = actualGenericCommandHelpTopic.command;
    assertTrue(command instanceof TimingsCommand);
    assertEquals("/", command.getLabel());
    assertEquals("/", command.getName());
    assertEquals("/", command.getTimingName());
    assertEquals("/", actualGenericCommandHelpTopic.getName());
    assertEquals("/timings <reset|report|on|off|verbon|verboff>", command.getUsage());
    assertEquals(
        "Manages Spigot Timings data to see performance of the server.", command.getDescription());
    assertEquals(
        "Manages Spigot Timings data to see performance of the server.",
        actualGenericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n"
            + "§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        actualGenericCommandHelpTopic.fullText);
    assertEquals("bukkit.command.timings", command.getPermission());
    assertTrue(command.getAliases().isEmpty());
  }

  /**
   * Test {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)}.
   *
   * <ul>
   *   <li>Then {@link GenericCommandHelpTopic#command} return {@link VersionCommand}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)}
   */
  @Test
  @DisplayName("Test new GenericCommandHelpTopic(Command); then command return VersionCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericCommandHelpTopic.<init>(Command)"})
  void testNewGenericCommandHelpTopic_thenCommandReturnVersionCommand() {
    // Arrange and Act
    GenericCommandHelpTopic actualGenericCommandHelpTopic =
        new GenericCommandHelpTopic(new VersionCommand("Name"));

    // Assert
    Command command = actualGenericCommandHelpTopic.command;
    assertTrue(command instanceof VersionCommand);
    assertEquals("/Name", actualGenericCommandHelpTopic.getName());
    assertEquals("/version [plugin name]", command.getUsage());
    assertEquals(
        "Gets the version of this server including any plugins in use", command.getDescription());
    assertEquals(
        "Gets the version of this server including any plugins in use",
        actualGenericCommandHelpTopic.getShortText());
    assertEquals("Name", command.getLabel());
    assertEquals("Name", command.getName());
    assertEquals("Name", command.getTimingName());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §f/version [plugin name]\n"
            + "§6Aliases: §fver, about",
        actualGenericCommandHelpTopic.fullText);
    assertEquals("bukkit.command.version", command.getPermission());
    assertEquals(2, command.getAliases().size());
  }

  /**
   * Test {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)}.
   *
   * <ul>
   *   <li>When {@link HelpCommand} (default constructor).
   *   <li>Then {@link GenericCommandHelpTopic#command} return {@link HelpCommand}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)}
   */
  @Test
  @DisplayName(
      "Test new GenericCommandHelpTopic(Command); when HelpCommand (default constructor); then command return HelpCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericCommandHelpTopic.<init>(Command)"})
  void testNewGenericCommandHelpTopic_whenHelpCommand_thenCommandReturnHelpCommand() {
    // Arrange and Act
    GenericCommandHelpTopic actualGenericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Assert
    Command command = actualGenericCommandHelpTopic.command;
    assertTrue(command instanceof HelpCommand);
    assertEquals(
        "/help <pageNumber>\n/help <topic>\n/help <topic> <pageNumber>", command.getUsage());
    assertEquals("/help", actualGenericCommandHelpTopic.getName());
    List<String> aliases = command.getAliases();
    assertEquals(1, aliases.size());
    assertEquals("?", aliases.get(0));
    assertEquals("Shows the help menu", command.getDescription());
    assertEquals("Shows the help menu", actualGenericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        actualGenericCommandHelpTopic.fullText);
    assertEquals("bukkit.command.help", command.getPermission());
    assertEquals("help", command.getLabel());
    assertEquals("help", command.getName());
    assertEquals("help", command.getTimingName());
  }

  /**
   * Test {@link GenericCommandHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)} with command is
   *       {@link HelpCommand} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); given GenericCommandHelpTopic(Command) with command is HelpCommand (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericCommandHelpTopic.canSee(CommandSender)"})
  void testCanSee_givenGenericCommandHelpTopicWithCommandIsHelpCommand_thenReturnFalse() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act and Assert
    assertFalse(genericCommandHelpTopic.canSee(new BufferedCommandSender()));
  }

  /**
   * Test {@link GenericCommandHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is empty
   *       string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); given TimingsCommand(String) with 'Name' Permission is empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericCommandHelpTopic.canSee(CommandSender)"})
  void testCanSee_givenTimingsCommandWithNamePermissionIsEmptyString_thenReturnTrue() {
    // Arrange
    TimingsCommand command = new TimingsCommand("Name");
    command.setPermission("");
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    command.register(commandMap);

    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);
    genericCommandHelpTopic.amendCanSee(null);

    // Act and Assert
    assertTrue(genericCommandHelpTopic.canSee(new BufferedCommandSender()));
  }

  /**
   * Test {@link GenericCommandHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is
   *       {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); given TimingsCommand(String) with 'Name' Permission is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericCommandHelpTopic.canSee(CommandSender)"})
  void testCanSee_givenTimingsCommandWithNamePermissionIsNull_thenReturnTrue() {
    // Arrange
    TimingsCommand command = new TimingsCommand("Name");
    command.setPermission(null);
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    command.register(commandMap);

    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);
    genericCommandHelpTopic.amendCanSee(null);

    // Act and Assert
    assertTrue(genericCommandHelpTopic.canSee(new BufferedCommandSender()));
  }

  /**
   * Test {@link GenericCommandHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link TimingsCommand#TimingsCommand(String)} with {@code Name} Permission is
   *       {@code null}.
   *   <li>When {@link ConsoleCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCommandHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); given TimingsCommand(String) with 'Name' Permission is 'null'; when ConsoleCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GenericCommandHelpTopic.canSee(CommandSender)"})
  void testCanSee_givenTimingsCommandWithNamePermissionIsNull_whenConsoleCommandSender() {
    // Arrange
    TimingsCommand command = new TimingsCommand("Name");
    command.setPermission(null);
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    command.register(commandMap);

    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);
    genericCommandHelpTopic.amendCanSee(null);

    // Act and Assert
    assertTrue(genericCommandHelpTopic.canSee(mock(ConsoleCommandSender.class)));
  }
}
