package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.HelpCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerTabCompleteExceptionDiffblueTest {
  /**
   * Test {@link ServerTabCompleteException#ServerTabCompleteException(String, Throwable, Command,
   * CommandSender, String[])}.
   *
   * <ul>
   *   <li>Then CommandSender return {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link ServerTabCompleteException#ServerTabCompleteException(String,
   * Throwable, Command, CommandSender, String[])}
   */
  @Test
  @DisplayName(
      "Test new ServerTabCompleteException(String, Throwable, Command, CommandSender, String[]); then CommandSender return BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerTabCompleteException.<init>(String, Throwable, Command, CommandSender, String[])"
  })
  void testNewServerTabCompleteException_thenCommandSenderReturnBufferedCommandSender() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    // Act
    ServerTabCompleteException actualServerTabCompleteException =
        new ServerTabCompleteException(
            "An error occurred", cause, command, commandSender, arguments);

    // Assert
    CommandSender commandSender2 = actualServerTabCompleteException.getCommandSender();
    assertTrue(commandSender2 instanceof BufferedCommandSender);
    Command command2 = actualServerTabCompleteException.getCommand();
    assertTrue(command2 instanceof HelpCommand);
    assertEquals("An error occurred", actualServerTabCompleteException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerTabCompleteException.getMessage());
    assertEquals(0, actualServerTabCompleteException.getSuppressed().length);
    assertSame(cause, actualServerTabCompleteException.getCause());
    assertSame(commandSender, commandSender2);
    assertSame(command, command2);
    assertSame(arguments, actualServerTabCompleteException.getArguments());
  }

  /**
   * Test {@link ServerTabCompleteException#ServerTabCompleteException(String, Throwable, boolean,
   * boolean, Command, CommandSender, String[])}.
   *
   * <ul>
   *   <li>Then CommandSender return {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link ServerTabCompleteException#ServerTabCompleteException(String,
   * Throwable, boolean, boolean, Command, CommandSender, String[])}
   */
  @Test
  @DisplayName(
      "Test new ServerTabCompleteException(String, Throwable, boolean, boolean, Command, CommandSender, String[]); then CommandSender return BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerTabCompleteException.<init>(String, Throwable, boolean, boolean, Command, CommandSender, String[])"
  })
  void testNewServerTabCompleteException_thenCommandSenderReturnBufferedCommandSender2() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    // Act
    ServerTabCompleteException actualServerTabCompleteException =
        new ServerTabCompleteException(
            "An error occurred", cause, true, true, command, commandSender, arguments);

    // Assert
    CommandSender commandSender2 = actualServerTabCompleteException.getCommandSender();
    assertTrue(commandSender2 instanceof BufferedCommandSender);
    Command command2 = actualServerTabCompleteException.getCommand();
    assertTrue(command2 instanceof HelpCommand);
    assertEquals("An error occurred", actualServerTabCompleteException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerTabCompleteException.getMessage());
    assertEquals(0, actualServerTabCompleteException.getSuppressed().length);
    assertSame(cause, actualServerTabCompleteException.getCause());
    assertSame(commandSender, commandSender2);
    assertSame(command, command2);
    assertSame(arguments, actualServerTabCompleteException.getArguments());
  }

  /**
   * Test {@link ServerTabCompleteException#ServerTabCompleteException(Throwable, Command,
   * CommandSender, String[])}.
   *
   * <ul>
   *   <li>Then CommandSender return {@link BufferedCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link ServerTabCompleteException#ServerTabCompleteException(Throwable,
   * Command, CommandSender, String[])}
   */
  @Test
  @DisplayName(
      "Test new ServerTabCompleteException(Throwable, Command, CommandSender, String[]); then CommandSender return BufferedCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerTabCompleteException.<init>(Throwable, Command, CommandSender, String[])"
  })
  void testNewServerTabCompleteException_thenCommandSenderReturnBufferedCommandSender3() {
    // Arrange
    Throwable cause = new Throwable();
    HelpCommand command = new HelpCommand();
    BufferedCommandSender commandSender = new BufferedCommandSender();
    String[] arguments = new String[] {"Arguments"};

    // Act
    ServerTabCompleteException actualServerTabCompleteException =
        new ServerTabCompleteException(cause, command, commandSender, arguments);

    // Assert
    CommandSender commandSender2 = actualServerTabCompleteException.getCommandSender();
    assertTrue(commandSender2 instanceof BufferedCommandSender);
    Command command2 = actualServerTabCompleteException.getCommand();
    assertTrue(command2 instanceof HelpCommand);
    assertEquals("java.lang.Throwable", actualServerTabCompleteException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerTabCompleteException.getMessage());
    assertEquals(0, actualServerTabCompleteException.getSuppressed().length);
    assertSame(cause, actualServerTabCompleteException.getCause());
    assertSame(commandSender, commandSender2);
    assertSame(command, command2);
    assertSame(arguments, actualServerTabCompleteException.getArguments());
  }
}
