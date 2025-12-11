package io.papermc.paper.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import io.papermc.paper.command.subcommands.ChunkDebugCommand;
import io.papermc.paper.command.subcommands.DumpPluginsCommand;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperSubcommandDiffblueTest {
  /**
   * Test {@link PaperSubcommand#tabComplete(CommandSender, String, String[])}.
   *
   * <p>Method under test: {@link PaperSubcommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test tabComplete(CommandSender, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PaperSubcommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpPluginsCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link PaperSubcommand#tabCompletes()}.
   *
   * <ul>
   *   <li>Given {@link ChunkDebugCommand} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSubcommand#tabCompletes()}
   */
  @Test
  @DisplayName(
      "Test tabCompletes(); given ChunkDebugCommand (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSubcommand.tabCompletes()"})
  void testTabCompletes_givenChunkDebugCommand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ChunkDebugCommand().tabCompletes());
  }
}
