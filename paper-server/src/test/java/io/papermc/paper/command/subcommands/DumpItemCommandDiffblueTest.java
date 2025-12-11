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

class DumpItemCommandDiffblueTest {
  /**
   * Test {@link DumpItemCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code all} and {@code Args}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DumpItemCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when array of String with 'all' and 'Args'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DumpItemCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenArrayOfStringWithAllAndArgs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpItemCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"all", "Args"}));
  }

  /**
   * Test {@link DumpItemCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DumpItemCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when array of String with 'Args'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DumpItemCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenArrayOfStringWithArgs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpItemCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }

  /**
   * Test {@link DumpItemCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DumpItemCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when empty array of String; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DumpItemCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenEmptyArrayOfString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpItemCommand().execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {}));
  }

  /**
   * Test {@link DumpItemCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code all}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DumpItemCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'all'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DumpItemCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithAll_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTabCompleteResult =
        new DumpItemCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"all"});

    // Assert
    assertEquals(1, actualTabCompleteResult.size());
    assertEquals("all", actualTabCompleteResult.get(0));
  }

  /**
   * Test {@link DumpItemCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DumpItemCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DumpItemCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithArgs_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpItemCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link DumpItemCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DumpItemCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DumpItemCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpItemCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {})
            .isEmpty());
  }
}
