package io.papermc.paper.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.command.subcommands.ChunkDebugCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperSubcommandDiffblueTest {
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

  /**
   * Test {@link PaperSubcommand#tabCompletes()}.
   *
   * <ul>
   *   <li>Then calls {@link PaperSubcommand#tabCompletes()}.
   * </ul>
   *
   * <p>Method under test: {@link PaperSubcommand#tabCompletes()}
   */
  @Test
  @DisplayName("Test tabCompletes(); then calls tabCompletes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperSubcommand.tabCompletes()"})
  void testTabCompletes_thenCallsTabCompletes() {
    // Arrange
    PaperSubcommand paperSubcommand = mock(PaperSubcommand.class);
    when(paperSubcommand.tabCompletes()).thenReturn(false);

    // Act
    paperSubcommand.tabCompletes();

    // Assert
    verify(paperSubcommand).tabCompletes();
  }
}
