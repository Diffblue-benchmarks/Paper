package org.bukkit.help;

import static org.junit.jupiter.api.Assertions.assertEquals;
import co.aikar.timings.TimingsCommand;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.FormattedCommandAlias;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.command.defaults.PluginsCommand;
import org.bukkit.command.defaults.ReloadCommand;
import org.bukkit.command.defaults.VersionCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelpTopicDiffblueTest {
  /**
   * Test {@link HelpTopic#amendCanSee(String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendCanSee(String)}
   */
  @Test
  @DisplayName("Test amendCanSee(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendCanSee(String)"})
  void testAmendCanSee() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act
    genericCommandHelpTopic.amendCanSee("Amended Permission");

    // Assert
    assertEquals("Amended Permission", genericCommandHelpTopic.amendedPermission);
  }

  /**
   * Test {@link HelpTopic#getName()}.
   *
   * <p>Method under test: {@link HelpTopic#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("/help", new GenericCommandHelpTopic(new HelpCommand()).getName());
  }

  /**
   * Test {@link HelpTopic#getShortText()}.
   *
   * <p>Method under test: {@link HelpTopic#getShortText()}
   */
  @Test
  @DisplayName("Test getShortText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.getShortText()"})
  void testGetShortText() {
    // Arrange, Act and Assert
    assertEquals(
        "Shows the help menu", new GenericCommandHelpTopic(new HelpCommand()).getShortText());
  }

  /**
   * Test {@link HelpTopic#getFullText(CommandSender)}.
   *
   * <p>Method under test: {@link HelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName("Test getFullText(CommandSender)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.getFullText(CommandSender)"})
  void testGetFullText() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act and Assert
    assertEquals(
        "§6Description: §fShows the help menu\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.getFullText(new BufferedCommandSender()));
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic2() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals("Shows the help menu", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic3() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic4() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("", genericCommandHelpTopic.getShortText());
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic5() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new PluginsCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals(
        "Gets a list of plugins running on the server", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic6() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new TimingsCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals(
        "Manages Spigot Timings data to see performance of the server.",
        genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic7() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new ReloadCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals(
        "Reloads the server configuration and plugins", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic8() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new VersionCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals(
        "Gets the version of this server including any plugins in use",
        genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic9() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f/<text>", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic10() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new PluginsCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets a list of plugins running on the server\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic11() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new TimingsCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n"
            + "§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic12() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new ReloadCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fReloads the server configuration and plugins\n"
            + "§6Usage: §f/reload [permissions|commands|confirm]\n"
            + "§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic13() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals(
        "The characteristics of someone or something", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic14() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic15() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setUsage("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n§6Usage: §f<text>\n§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic16() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("Alias", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f/Alias", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic17() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("42", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f/42", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic18() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("java.lang.String", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f\n§6Usage: §f/java.lang.String", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic19() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f/", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic20() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals("Description", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic21() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals("]", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic22() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setUsage("Usage");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n§6Usage: §fUsage\n§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic23() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setUsage("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n§6Usage: §f\n§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic24() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setUsage("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n§6Usage: §f42\n§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic25() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setUsage("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n§6Usage: §f]\n§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic26() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};
    FormattedCommandAlias command = new FormattedCommandAlias("minecraft", formatStrings);
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f/minecraft", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic27() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n§6Usage: §f/<text>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic28() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setUsage("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f<text>", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic29() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic30() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setUsage("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets a list of plugins running on the server\n§6Usage: §f<text>\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic31() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n"
            + "§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic32() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setUsage("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n§6Usage: §f<text>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic33() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n"
            + "§6Usage: §f/reload [permissions|commands|confirm]\n"
            + "§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic34() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setUsage("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fReloads the server configuration and plugins\n§6Usage: §f<text>\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic35() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n"
            + "§6Usage: §f/version [plugin name]\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic36() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("bukkit.broadcast.admin");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
    assertEquals("bukkit.broadcast.admin", genericCommandHelpTopic.getShortText());
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic37() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setDescription("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f<text>\n§6Usage: §f/<text>", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic38() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setDescription("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f<text>\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic39() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setDescription("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f<text>\n§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic40() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setDescription("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f<text>\n§6Usage: §f/reload [permissions|commands|confirm]\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic41() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setDescription("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f<text>\n§6Usage: §f/version [plugin name]\n§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic42() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fDescription\n§6Usage: §f/<text>", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic43() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fDescription\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic44() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fDescription\n§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic45() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fDescription\n§6Usage: §f/reload [permissions|commands|confirm]\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic46() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fDescription\n§6Usage: §f/version [plugin name]\n§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic47() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setDescription("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic48() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setDescription("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f\n§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic49() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setDescription("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f\n§6Usage: §f/reload [permissions|commands|confirm]\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic50() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setDescription("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f\n§6Usage: §f/version [plugin name]\n§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic51() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f42\n§6Usage: §f/<text>", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic52() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f42\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic53() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f42\n§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic54() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f42\n§6Usage: §f/reload [permissions|commands|confirm]\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic55() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f42\n§6Usage: §f/version [plugin name]\n§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic56() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f]\n§6Usage: §f/<text>", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic57() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f]\n§6Usage: §f/plugins\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic58() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f]\n§6Usage: §f/timings <reset|report|on|off|verbon|verboff>",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic59() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f]\n§6Usage: §f/reload [permissions|commands|confirm]\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic60() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f]\n§6Usage: §f/version [plugin name]\n§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic61() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setUsage("bukkit.broadcast.admin");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n§6Usage: §fbukkit.broadcast.admin\n§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic62() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setUsage("Usage");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §fUsage", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic63() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setUsage("Usage");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets a list of plugins running on the server\n§6Usage: §fUsage\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic64() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setUsage("Usage");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n§6Usage: §fUsage",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic65() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setUsage("Usage");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fReloads the server configuration and plugins\n§6Usage: §fUsage\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic66() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setUsage("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic67() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setUsage("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets a list of plugins running on the server\n§6Usage: §f\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic68() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setUsage("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n§6Usage: §f",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic69() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setUsage("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fReloads the server configuration and plugins\n§6Usage: §f\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic70() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setUsage("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f42", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic71() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setUsage("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets a list of plugins running on the server\n§6Usage: §f42\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic72() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setUsage("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n§6Usage: §f42",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic73() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setUsage("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fReloads the server configuration and plugins\n§6Usage: §f42\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic74() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("<text>", formatStrings);
    command.setUsage("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals("§6Description: §f\n§6Usage: §f]", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic75() {
    // Arrange
    PluginsCommand command = new PluginsCommand("<text>");
    command.setUsage("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets a list of plugins running on the server\n§6Usage: §f]\n§6Aliases: §fpl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic76() {
    // Arrange
    TimingsCommand command = new TimingsCommand("<text>");
    command.setUsage("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fManages Spigot Timings data to see performance of the server.\n§6Usage: §f]",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic77() {
    // Arrange
    ReloadCommand command = new ReloadCommand("<text>");
    command.setUsage("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fReloads the server configuration and plugins\n§6Usage: §f]\n§6Aliases: §frl",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic78() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("Alias", formatStrings);
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n§6Usage: §f/Alias",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic79() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("42", formatStrings);
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n§6Usage: §f/42",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic80() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("java.lang.String", formatStrings);
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n§6Usage: §f/java.lang.String",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic81() {
    // Arrange
    String[] formatStrings = new String[] {"<text>"};

    FormattedCommandAlias command = new FormattedCommandAlias("", formatStrings);
    command.setDescription("The characteristics of someone or something");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fThe characteristics of someone or something\n§6Usage: §f/",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given HelpCommand (default constructor) Description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenHelpCommandDescriptionIs42() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f42\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Description is {@code
   *       bukkit.broadcast.admin}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given HelpCommand (default constructor) Description is 'bukkit.broadcast.admin'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenHelpCommandDescriptionIsBukkitBroadcastAdmin() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("bukkit.broadcast.admin");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fbukkit.broadcast.admin\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Description is {@code Description}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given HelpCommand (default constructor) Description is 'Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenHelpCommandDescriptionIsDescription() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("Description");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fDescription\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Description is empty string.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given HelpCommand (default constructor) Description is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenHelpCommandDescriptionIsEmptyString() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Description is {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given HelpCommand (default constructor) Description is ']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenHelpCommandDescriptionIsRightSquareBracket() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f]\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link HelpCommand} (default constructor) Description is {@code <text>}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given HelpCommand (default constructor) Description is '<text>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenHelpCommandDescriptionIsText() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §f<text>\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link VersionCommand#VersionCommand(String)} with name is {@code <text>}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given VersionCommand(String) with name is '<text>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenVersionCommandWithNameIsText() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new VersionCommand("<text>"));

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §f/version [plugin name]\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link VersionCommand#VersionCommand(String)} with name is {@code <text>} Usage is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given VersionCommand(String) with name is '<text>' Usage is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenVersionCommandWithNameIsTextUsageIs42() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setUsage("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §f42\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link VersionCommand#VersionCommand(String)} with name is {@code <text>} Usage is
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given VersionCommand(String) with name is '<text>' Usage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenVersionCommandWithNameIsTextUsageIsEmptyString() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setUsage("");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §f\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link VersionCommand#VersionCommand(String)} with name is {@code <text>} Usage is
   *       {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given VersionCommand(String) with name is '<text>' Usage is ']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenVersionCommandWithNameIsTextUsageIsRightSquareBracket() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setUsage("]");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §f]\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link VersionCommand#VersionCommand(String)} with name is {@code <text>} Usage is
   *       {@code <text>}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given VersionCommand(String) with name is '<text>' Usage is '<text>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenVersionCommandWithNameIsTextUsageIsText() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setUsage("<text>");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §f<text>\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Given {@link VersionCommand#VersionCommand(String)} with name is {@code <text>} Usage is
   *       {@code Usage}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); given VersionCommand(String) with name is '<text>' Usage is 'Usage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_givenVersionCommandWithNameIsTextUsageIsUsage() {
    // Arrange
    VersionCommand command = new VersionCommand("<text>");
    command.setUsage("Usage");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("Amended Short Text", "<text>");

    // Assert
    assertEquals("Amended Short Text", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fGets the version of this server including any plugins in use\n"
            + "§6Usage: §fUsage\n"
            + "§6Aliases: §fver, about",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>Then {@link GenericCommandHelpTopic#GenericCommandHelpTopic(Command)} with command is
   *       {@link HelpCommand} (default constructor) ShortText is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName(
      "Test amendTopic(String, String); then GenericCommandHelpTopic(Command) with command is HelpCommand (default constructor) ShortText is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_thenGenericCommandHelpTopicWithCommandIsHelpCommandShortTextIs42() {
    // Arrange
    HelpCommand command = new HelpCommand();
    command.setDescription("42");
    GenericCommandHelpTopic genericCommandHelpTopic = new GenericCommandHelpTopic(command);

    // Act
    genericCommandHelpTopic.amendTopic("<text>", "Amended Full Text");

    // Assert
    assertEquals("42", genericCommandHelpTopic.getShortText());
    assertEquals("Amended Full Text", genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#amendTopic(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#amendTopic(String, String)}
   */
  @Test
  @DisplayName("Test amendTopic(String, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HelpTopic.amendTopic(String, String)"})
  void testAmendTopic_whenNull() {
    // Arrange
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());

    // Act
    genericCommandHelpTopic.amendTopic(null, null);

    // Assert that nothing has changed
    assertEquals("Shows the help menu", genericCommandHelpTopic.getShortText());
    assertEquals(
        "§6Description: §fShows the help menu\n"
            + "§6Usage: §f/help <pageNumber>\n"
            + "/help <topic>\n"
            + "/help <topic> <pageNumber>\n"
            + "§6Aliases: §f?",
        genericCommandHelpTopic.fullText);
  }

  /**
   * Test {@link HelpTopic#applyAmendment(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#applyAmendment(String, String)}
   */
  @Test
  @DisplayName("Test applyAmendment(String, String); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.applyAmendment(String, String)"})
  void testApplyAmendment_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals(
        "42", new GenericCommandHelpTopic(new HelpCommand()).applyAmendment("42", "<text>"));
  }

  /**
   * Test {@link HelpTopic#applyAmendment(String, String)}.
   *
   * <ul>
   *   <li>When {@code Amendment}.
   *   <li>Then return {@code Amendment}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#applyAmendment(String, String)}
   */
  @Test
  @DisplayName("Test applyAmendment(String, String); when 'Amendment'; then return 'Amendment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.applyAmendment(String, String)"})
  void testApplyAmendment_whenAmendment_thenReturnAmendment() {
    // Arrange, Act and Assert
    assertEquals(
        "Amendment",
        new GenericCommandHelpTopic(new HelpCommand()).applyAmendment("Base Text", "Amendment"));
  }

  /**
   * Test {@link HelpTopic#applyAmendment(String, String)}.
   *
   * <ul>
   *   <li>When {@code Base Text}.
   *   <li>Then return {@code Base Text}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#applyAmendment(String, String)}
   */
  @Test
  @DisplayName("Test applyAmendment(String, String); when 'Base Text'; then return 'Base Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.applyAmendment(String, String)"})
  void testApplyAmendment_whenBaseText_thenReturnBaseText() {
    // Arrange, Act and Assert
    assertEquals(
        "Base Text",
        new GenericCommandHelpTopic(new HelpCommand()).applyAmendment("Base Text", "<text>"));
  }

  /**
   * Test {@link HelpTopic#applyAmendment(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#applyAmendment(String, String)}
   */
  @Test
  @DisplayName("Test applyAmendment(String, String); when empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.applyAmendment(String, String)"})
  void testApplyAmendment_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new GenericCommandHelpTopic(new HelpCommand()).applyAmendment("", "<text>"));
  }

  /**
   * Test {@link HelpTopic#applyAmendment(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Base Text}.
   * </ul>
   *
   * <p>Method under test: {@link HelpTopic#applyAmendment(String, String)}
   */
  @Test
  @DisplayName("Test applyAmendment(String, String); when 'null'; then return 'Base Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HelpTopic.applyAmendment(String, String)"})
  void testApplyAmendment_whenNull_thenReturnBaseText() {
    // Arrange, Act and Assert
    assertEquals(
        "Base Text",
        new GenericCommandHelpTopic(new HelpCommand()).applyAmendment("Base Text", null));
  }
}
