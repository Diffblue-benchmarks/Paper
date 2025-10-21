package org.bukkit.command.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelpCommandDiffblueTest {
  /**
   * Test new {@link HelpCommand} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link HelpCommand}
   */
  @Test
  @DisplayName("Test new HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpCommand.<init>()"})
  void testNewHelpCommand() {
    // Arrange and Act
    HelpCommand actualHelpCommand = new HelpCommand();

    // Assert
    assertEquals(
        "/help <pageNumber>\n/help <topic>\n/help <topic> <pageNumber>",
        actualHelpCommand.getUsage());
    List<String> aliases = actualHelpCommand.getAliases();
    assertEquals(1, aliases.size());
    assertEquals("?", aliases.get(0));
    assertEquals("Shows the help menu", actualHelpCommand.getDescription());
    assertEquals("bukkit.command.help", actualHelpCommand.getPermission());
    assertEquals("help", actualHelpCommand.getLabel());
    assertEquals("help", actualHelpCommand.getName());
    assertEquals("help", actualHelpCommand.getTimingName());
    assertNull(actualHelpCommand.timings);
    assertNull(actualHelpCommand.getPermissionMessage());
    assertNull(actualHelpCommand.permissionMessage());
    assertFalse(actualHelpCommand.isRegistered());
  }

  /**
   * Test {@link HelpCommand#tabComplete(CommandSender, String, String[])} with {@code sender},
   * {@code alias}, {@code args}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]) with 'sender', 'alias', 'args'; when empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List HelpCommand.tabComplete(CommandSender, String, String[])"})
  void testTabCompleteWithSenderAliasArgs_whenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange
    HelpCommand helpCommand = new HelpCommand();

    // Act and Assert
    assertTrue(
        helpCommand.tabComplete(new BufferedCommandSender(), "Alias", new String[] {}).isEmpty());
  }

  /**
   * Test {@link HelpCommand#findPossibleMatches(String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#findPossibleMatches(String)}
   */
  @Test
  @DisplayName(
      "Test findPossibleMatches(String); given HelpCommand (default constructor); when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.help.HelpTopic HelpCommand.findPossibleMatches(String)"})
  void testFindPossibleMatches_givenHelpCommand_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new HelpCommand().findPossibleMatches(""));
  }

  /**
   * Test {@link HelpCommand#findPossibleMatches(String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor).
   *   <li>When {@code /}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#findPossibleMatches(String)}
   */
  @Test
  @DisplayName(
      "Test findPossibleMatches(String); given HelpCommand (default constructor); when '/'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.help.HelpTopic HelpCommand.findPossibleMatches(String)"})
  void testFindPossibleMatches_givenHelpCommand_whenSlash_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new HelpCommand().findPossibleMatches("/"));
  }

  /**
   * Test {@link HelpCommand#damerauLevenshteinDistance(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#damerauLevenshteinDistance(String, String)}
   */
  @Test
  @DisplayName("Test damerauLevenshteinDistance(String, String); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpCommand.damerauLevenshteinDistance(String, String)"})
  void testDamerauLevenshteinDistance_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, HelpCommand.damerauLevenshteinDistance(null, null));
  }

  /**
   * Test {@link HelpCommand#damerauLevenshteinDistance(String, String)}.
   *
   * <ul>
   *   <li>When {@code S1}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#damerauLevenshteinDistance(String, String)}
   */
  @Test
  @DisplayName("Test damerauLevenshteinDistance(String, String); when 'S1'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpCommand.damerauLevenshteinDistance(String, String)"})
  void testDamerauLevenshteinDistance_whenS1_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, HelpCommand.damerauLevenshteinDistance("S1", "S2"));
  }

  /**
   * Test {@link HelpCommand#damerauLevenshteinDistance(String, String)}.
   *
   * <ul>
   *   <li>When {@code S1}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#damerauLevenshteinDistance(String, String)}
   */
  @Test
  @DisplayName("Test damerauLevenshteinDistance(String, String); when 'S1'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpCommand.damerauLevenshteinDistance(String, String)"})
  void testDamerauLevenshteinDistance_whenS1_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, HelpCommand.damerauLevenshteinDistance("S1", null));
  }

  /**
   * Test {@link HelpCommand#damerauLevenshteinDistance(String, String)}.
   *
   * <ul>
   *   <li>When {@code S2}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link HelpCommand#damerauLevenshteinDistance(String, String)}
   */
  @Test
  @DisplayName("Test damerauLevenshteinDistance(String, String); when 'S2'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HelpCommand.damerauLevenshteinDistance(String, String)"})
  void testDamerauLevenshteinDistance_whenS2_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, HelpCommand.damerauLevenshteinDistance(null, "S2"));
  }
}
