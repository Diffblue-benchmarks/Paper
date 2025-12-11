package io.papermc.paper.command.subcommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChunkDebugCommandDiffblueTest {
  /**
   * Test {@link ChunkDebugCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@code debug}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkDebugCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[]); when 'debug'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkDebugCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenDebug_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ChunkDebugCommand()
            .execute(NullCommandSender.INSTANCE, "debug", new String[] {"Args"}));
  }

  /**
   * Test {@link ChunkDebugCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkDebugCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when empty array of String; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkDebugCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenEmptyArrayOfString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ChunkDebugCommand().execute(NullCommandSender.INSTANCE, "debug", new String[] {}));
  }

  /**
   * Test {@link ChunkDebugCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Sub Command}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkDebugCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when 'Sub Command'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChunkDebugCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenSubCommand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ChunkDebugCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }

  /**
   * Test {@link ChunkDebugCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code help}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ChunkDebugCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'help'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkDebugCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithHelp_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTabCompleteResult =
        new ChunkDebugCommand()
            .tabComplete(NullCommandSender.INSTANCE, "debug", new String[] {"help"});

    // Assert
    assertEquals(1, actualTabCompleteResult.size());
    assertEquals("help", actualTabCompleteResult.get(0));
  }

  /**
   * Test {@link ChunkDebugCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@code debug}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChunkDebugCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[]); when 'debug'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkDebugCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenDebug_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new ChunkDebugCommand()
            .tabComplete(NullCommandSender.INSTANCE, "debug", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link ChunkDebugCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Sub Command}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChunkDebugCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when 'Sub Command'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChunkDebugCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenSubCommand_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new ChunkDebugCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"})
            .isEmpty());
  }
}
