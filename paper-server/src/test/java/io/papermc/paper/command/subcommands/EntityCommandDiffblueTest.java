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

class EntityCommandDiffblueTest {
  /**
   * Test {@link EntityCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when empty array of String; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenEmptyArrayOfString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new EntityCommand().execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {}));
  }

  /**
   * Test {@link EntityCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@link NullCommandSender#INSTANCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName("Test execute(CommandSender, String, String[]); when INSTANCE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenInstance_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new EntityCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }

  /**
   * Test {@link EntityCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithArgs_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new EntityCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link EntityCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code help}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'help'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithHelp_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTabCompleteResult =
        new EntityCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"help"});

    // Assert
    assertEquals(1, actualTabCompleteResult.size());
    assertEquals("help", actualTabCompleteResult.get(0));
  }

  /**
   * Test {@link EntityCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new EntityCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {})
            .isEmpty());
  }
}
