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

class SyncLoadInfoCommandDiffblueTest {
  /**
   * Test {@link SyncLoadInfoCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@link NullCommandSender#INSTANCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SyncLoadInfoCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[]); when INSTANCE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SyncLoadInfoCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenInstance_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new SyncLoadInfoCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }

  /**
   * Test {@link SyncLoadInfoCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SyncLoadInfoCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SyncLoadInfoCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithArgs_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new SyncLoadInfoCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link SyncLoadInfoCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code clear} and {@code Args}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SyncLoadInfoCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'clear' and 'Args'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SyncLoadInfoCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithClearAndArgs_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTabCompleteResult =
        new SyncLoadInfoCommand()
            .tabComplete(
                NullCommandSender.INSTANCE, "Sub Command", new String[] {"clear", "Args", "clear"});

    // Assert
    assertEquals(1, actualTabCompleteResult.size());
    assertEquals("clear", actualTabCompleteResult.get(0));
  }
}
