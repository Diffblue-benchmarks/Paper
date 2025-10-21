package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import co.aikar.timings.Timing;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.defaults.HelpCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleCommandMapDiffblueTest {
  /**
   * Test {@link SimpleCommandMap#SimpleCommandMap(Server, Map)}.
   *
   * <p>Method under test: {@link SimpleCommandMap#SimpleCommandMap(Server, Map)}
   */
  @Test
  @DisplayName("Test new SimpleCommandMap(Server, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.<init>(Server, Map)"})
  void testNewSimpleCommandMap() {
    // Arrange
    Server server = mock(Server.class);
    HashMap<String, Command> backing = new HashMap<>();

    // Act
    SimpleCommandMap actualSimpleCommandMap = new SimpleCommandMap(server, backing);

    // Assert
    assertEquals(4, backing.size());
    assertEquals(4, actualSimpleCommandMap.getCommands().size());
    assertTrue(backing.containsKey("bukkit:reload"));
    assertTrue(backing.containsKey("bukkit:rl"));
    assertTrue(backing.containsKey("bukkit:timings"));
    assertTrue(backing.containsKey("timings"));
    assertSame(backing, actualSimpleCommandMap.getKnownCommands());
  }

  /**
   * Test {@link SimpleCommandMap#setFallbackCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#setFallbackCommands()}
   */
  @Test
  @DisplayName("Test setFallbackCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.setFallbackCommands()"})
  void testSetFallbackCommands() {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act
    simpleCommandMap.setFallbackCommands();

    // Assert
    Map<String, Command> knownCommands = simpleCommandMap.getKnownCommands();
    assertEquals(8, knownCommands.size());
    Command getResult = knownCommands.get("help");
    assertTrue(getResult instanceof HelpCommand);
    List<String> aliases = getResult.getAliases();
    assertEquals(1, aliases.size());
    assertEquals("?", aliases.get(0));
    assertEquals(8, simpleCommandMap.getCommands().size());
    assertTrue(knownCommands.containsKey("bukkit:help"));
    assertTrue(knownCommands.containsKey("bukkit:reload"));
    assertTrue(knownCommands.containsKey("bukkit:timings"));
    assertTrue(knownCommands.containsKey("timings"));
    assertSame(getResult, knownCommands.get("bukkit:?"));
  }

  /**
   * Test {@link SimpleCommandMap#setFallbackCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#setFallbackCommands()}
   */
  @Test
  @DisplayName("Test setFallbackCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.setFallbackCommands()"})
  void testSetFallbackCommands2() {
    // Arrange
    Server server = mock(Server.class);

    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());
    HelpCommand command = new HelpCommand();
    simpleCommandMap.register("bukkit", "bukkit", command);

    // Act
    simpleCommandMap.setFallbackCommands();

    // Assert
    Map<String, Command> knownCommands = simpleCommandMap.getKnownCommands();
    assertEquals(10, knownCommands.size());
    Command getResult = knownCommands.get("bukkit");
    assertTrue(getResult instanceof HelpCommand);
    Command getResult2 = knownCommands.get("help");
    assertTrue(getResult2 instanceof HelpCommand);
    assertTrue(getResult2.getAliases().isEmpty());
    assertTrue(knownCommands.containsKey("bukkit:bukkit"));
    assertTrue(knownCommands.containsKey("bukkit:help"));
    assertTrue(knownCommands.containsKey("bukkit:reload"));
    assertTrue(knownCommands.containsKey("timings"));
    Timing timing = command.timings;
    assertSame(timing, ((HelpCommand) getResult).timings);
    assertSame(timing, ((HelpCommand) getResult2).timings);
  }

  /**
   * Test {@link SimpleCommandMap#setFallbackCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#setFallbackCommands()}
   */
  @Test
  @DisplayName("Test setFallbackCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.setFallbackCommands()"})
  void testSetFallbackCommands3() {
    // Arrange
    HashMap<String, Command> backing = new HashMap<>();
    HelpCommand helpCommand = new HelpCommand();
    backing.put("help", helpCommand);

    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(mock(Server.class), backing);
    simpleCommandMap.register("bukkit", "bukkit", new HelpCommand());

    // Act
    simpleCommandMap.setFallbackCommands();

    // Assert
    Map<String, Command> knownCommands = simpleCommandMap.getKnownCommands();
    assertEquals(10, knownCommands.size());
    assertTrue(knownCommands.get("bukkit:help") instanceof HelpCommand);
    Command getResult = knownCommands.get("help");
    assertTrue(getResult instanceof HelpCommand);
    assertTrue(knownCommands.containsKey("bukkit"));
    assertTrue(knownCommands.containsKey("bukkit:bukkit"));
    assertTrue(knownCommands.containsKey("bukkit:reload"));
    assertTrue(knownCommands.containsKey("timings"));
    assertSame(helpCommand, getResult);
  }

  /**
   * Test {@link SimpleCommandMap#registerAll(String, List)}.
   *
   * <p>Method under test: {@link SimpleCommandMap#registerAll(String, List)}
   */
  @Test
  @DisplayName("Test registerAll(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.registerAll(String, List)"})
  void testRegisterAll() {
    // Arrange
    Server server = mock(Server.class);
    HashMap<String, Command> backing = new HashMap<>();

    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, backing);

    // Act
    simpleCommandMap.registerAll(null, null);

    // Assert that nothing has changed
    assertEquals(4, simpleCommandMap.getCommands().size());
    assertSame(backing, simpleCommandMap.getKnownCommands());
  }

  /**
   * Test {@link SimpleCommandMap#registerAll(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#registerAll(String, List)}
   */
  @Test
  @DisplayName("Test registerAll(String, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.registerAll(String, List)"})
  void testRegisterAll_whenArrayList() {
    // Arrange
    Server server = mock(Server.class);
    HashMap<String, Command> backing = new HashMap<>();

    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, backing);

    // Act
    simpleCommandMap.registerAll("Fallback Prefix", new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(4, simpleCommandMap.getCommands().size());
    assertSame(backing, simpleCommandMap.getKnownCommands());
  }

  /**
   * Test {@link SimpleCommandMap#dispatch(CommandSender, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CommandException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#dispatch(CommandSender, String)}
   */
  @Test
  @DisplayName("Test dispatch(CommandSender, String); then throw CommandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleCommandMap.dispatch(CommandSender, String)"})
  void testDispatch_thenThrowCommandException() throws CommandException {
    // Arrange
    Server server = mock(Server.class);
    when(server.getPluginManager()).thenThrow(new CommandException(";"));
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertThrows(
        CommandException.class,
        () -> simpleCommandMap.dispatch(new BufferedCommandSender(), "bukkit:rl"));
    verify(server).getPluginManager();
  }

  /**
   * Test {@link SimpleCommandMap#dispatch(CommandSender, String)}.
   *
   * <ul>
   *   <li>When {@code Command Line}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#dispatch(CommandSender, String)}
   */
  @Test
  @DisplayName("Test dispatch(CommandSender, String); when 'Command Line'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleCommandMap.dispatch(CommandSender, String)"})
  void testDispatch_whenCommandLine_thenReturnFalse() throws CommandException {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertFalse(simpleCommandMap.dispatch(new BufferedCommandSender(), "Command Line"));
  }

  /**
   * Test {@link SimpleCommandMap#dispatch(CommandSender, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#dispatch(CommandSender, String)}
   */
  @Test
  @DisplayName("Test dispatch(CommandSender, String); when empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleCommandMap.dispatch(CommandSender, String)"})
  void testDispatch_whenEmptyString_thenReturnFalse() throws CommandException {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertFalse(simpleCommandMap.dispatch(new BufferedCommandSender(), ""));
  }

  /**
   * Test {@link SimpleCommandMap#dispatch(CommandSender, String)}.
   *
   * <ul>
   *   <li>When {@code timings}.
   *   <li>Then throw {@link CommandException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#dispatch(CommandSender, String)}
   */
  @Test
  @DisplayName("Test dispatch(CommandSender, String); when 'timings'; then throw CommandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SimpleCommandMap.dispatch(CommandSender, String)"})
  void testDispatch_whenTimings_thenThrowCommandException() throws CommandException {
    // Arrange
    Server server = mock(Server.class);
    when(server.getPluginManager()).thenThrow(new CommandException(";"));
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertThrows(
        CommandException.class,
        () -> simpleCommandMap.dispatch(new BufferedCommandSender(), "timings"));
    verify(server).getPluginManager();
  }

  /**
   * Test {@link SimpleCommandMap#clearCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#clearCommands()}
   */
  @Test
  @DisplayName("Test clearCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.clearCommands()"})
  void testClearCommands() {
    // Arrange
    Server server = mock(Server.class);
    HashMap<String, Command> backing = new HashMap<>();

    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, backing);

    // Act
    simpleCommandMap.clearCommands();

    // Assert that nothing has changed
    assertEquals(4, simpleCommandMap.getCommands().size());
    assertSame(backing, simpleCommandMap.getKnownCommands());
  }

  /**
   * Test {@link SimpleCommandMap#clearCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#clearCommands()}
   */
  @Test
  @DisplayName("Test clearCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.clearCommands()"})
  void testClearCommands2() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();
    Server server = mock(Server.class);
    SimpleCommandMap commandMap = new SimpleCommandMap(server, new HashMap<>());
    helpCommand.register(commandMap);

    HashMap<String, Command> backing = new HashMap<>();
    backing.put("reload", helpCommand);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(mock(Server.class), backing);

    // Act
    simpleCommandMap.clearCommands();

    // Assert
    assertEquals(4, simpleCommandMap.getCommands().size());
    assertSame(backing, simpleCommandMap.getKnownCommands());
  }

  /**
   * Test {@link SimpleCommandMap#getCommand(String)}.
   *
   * <p>Method under test: {@link SimpleCommandMap#getCommand(String)}
   */
  @Test
  @DisplayName("Test getCommand(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Command SimpleCommandMap.getCommand(String)"})
  void testGetCommand() {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertNull(simpleCommandMap.getCommand("Name"));
  }

  /**
   * Test {@link SimpleCommandMap#tabComplete(CommandSender, String, Location)} with {@code sender},
   * {@code cmdLine}, {@code location}.
   *
   * <ul>
   *   <li>When {@code Cmd Line}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#tabComplete(CommandSender, String, Location)}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, Location) with 'sender', 'cmdLine', 'location'; when 'Cmd Line'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SimpleCommandMap.tabComplete(CommandSender, String, Location)"})
  void testTabCompleteWithSenderCmdLineLocation_whenCmdLine_thenReturnNull() {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());
    BufferedCommandSender sender = new BufferedCommandSender();
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertNull(simpleCommandMap.tabComplete(sender, "Cmd Line", location));
  }

  /**
   * Test {@link SimpleCommandMap#tabComplete(CommandSender, String)} with {@code sender}, {@code
   * cmdLine}.
   *
   * <ul>
   *   <li>When {@code Cmd Line}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#tabComplete(CommandSender, String)}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String) with 'sender', 'cmdLine'; when 'Cmd Line'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SimpleCommandMap.tabComplete(CommandSender, String)"})
  void testTabCompleteWithSenderCmdLine_whenCmdLine_thenReturnNull() {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertNull(simpleCommandMap.tabComplete(new BufferedCommandSender(), "Cmd Line"));
  }

  /**
   * Test {@link SimpleCommandMap#getCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#getCommands()}
   */
  @Test
  @DisplayName("Test getCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection SimpleCommandMap.getCommands()"})
  void testGetCommands() {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertEquals(4, simpleCommandMap.getCommands().size());
  }

  /**
   * Test {@link SimpleCommandMap#registerServerAliases()}.
   *
   * <ul>
   *   <li>Given {@link Server} {@link Server#getCommandAliases()} return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#registerServerAliases()}
   */
  @Test
  @DisplayName("Test registerServerAliases(); given Server getCommandAliases() return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.registerServerAliases()"})
  void testRegisterServerAliases_givenServerGetCommandAliasesReturnHashMap() {
    // Arrange
    Server server = mock(Server.class);
    when(server.getCommandAliases()).thenReturn(new HashMap<>());
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act
    simpleCommandMap.registerServerAliases();

    // Assert
    verify(server).getCommandAliases();
  }

  /**
   * Test {@link SimpleCommandMap#registerServerAliases()}.
   *
   * <ul>
   *   <li>Then throw {@link CommandException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleCommandMap#registerServerAliases()}
   */
  @Test
  @DisplayName("Test registerServerAliases(); then throw CommandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleCommandMap.registerServerAliases()"})
  void testRegisterServerAliases_thenThrowCommandException() {
    // Arrange
    Server server = mock(Server.class);
    when(server.getCommandAliases()).thenThrow(new CommandException("Msg"));
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act and Assert
    assertThrows(CommandException.class, () -> simpleCommandMap.registerServerAliases());
    verify(server).getCommandAliases();
  }

  /**
   * Test {@link SimpleCommandMap#getKnownCommands()}.
   *
   * <p>Method under test: {@link SimpleCommandMap#getKnownCommands()}
   */
  @Test
  @DisplayName("Test getKnownCommands()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SimpleCommandMap.getKnownCommands()"})
  void testGetKnownCommands() {
    // Arrange
    Server server = mock(Server.class);
    SimpleCommandMap simpleCommandMap = new SimpleCommandMap(server, new HashMap<>());

    // Act
    Map<String, Command> actualKnownCommands = simpleCommandMap.getKnownCommands();

    // Assert
    assertSame(simpleCommandMap.knownCommands, actualKnownCommands);
  }
}
