package org.bukkit.help;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.MessageCommandSender;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IndexHelpTopicDiffblueTest {
  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}.
   *
   * <ul>
   *   <li>Then return {@link IndexHelpTopic#allTopics} size is one.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection); then return allTopics size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection)"})
  void testNewIndexHelpTopic_thenReturnAllTopicsSizeIsOne() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());
    topics.add(genericCommandHelpTopic);

    // Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", topics);

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertEquals(1, collection.size());
    assertTrue(collection instanceof List);
    assertSame(genericCommandHelpTopic, ((List<HelpTopic>) collection).get(0));
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@link IndexHelpTopic#allTopics} size is one.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection, String); then return allTopics size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection, String)"})
  void testNewIndexHelpTopic_thenReturnAllTopicsSizeIsOne2() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());
    topics.add(genericCommandHelpTopic);

    // Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", topics, "Preamble");

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertEquals(1, collection.size());
    assertTrue(collection instanceof List);
    assertSame(genericCommandHelpTopic, ((List<HelpTopic>) collection).get(0));
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}.
   *
   * <ul>
   *   <li>Then return {@link IndexHelpTopic#allTopics} size is two.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection); then return allTopics size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection)"})
  void testNewIndexHelpTopic_thenReturnAllTopicsSizeIsTwo() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    topics.add(new GenericCommandHelpTopic(new HelpCommand()));
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());
    topics.add(genericCommandHelpTopic);

    // Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", topics);

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertEquals(2, collection.size());
    assertTrue(collection instanceof List);
    assertSame(genericCommandHelpTopic, ((List<HelpTopic>) collection).get(1));
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection, String)}.
   *
   * <ul>
   *   <li>Then return {@link IndexHelpTopic#allTopics} size is two.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection, String); then return allTopics size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection, String)"})
  void testNewIndexHelpTopic_thenReturnAllTopicsSizeIsTwo2() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    topics.add(new GenericCommandHelpTopic(new HelpCommand()));
    GenericCommandHelpTopic genericCommandHelpTopic =
        new GenericCommandHelpTopic(new HelpCommand());
    topics.add(genericCommandHelpTopic);

    // Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", topics, "Preamble");

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertEquals(2, collection.size());
    assertTrue(collection instanceof List);
    assertSame(genericCommandHelpTopic, ((List<HelpTopic>) collection).get(1));
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Preamble}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection, String); when ArrayList(); then return 'Preamble'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection, String)"})
  void testNewIndexHelpTopic_whenArrayList_thenReturnPreamble() {
    // Arrange and Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>(), "Preamble");

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertTrue(collection instanceof List);
    assertEquals("", actualIndexHelpTopic.fullText);
    assertEquals("Name", actualIndexHelpTopic.getName());
    assertEquals("Permission", actualIndexHelpTopic.permission);
    assertEquals("Preamble", actualIndexHelpTopic.preamble);
    assertEquals("Short Text", actualIndexHelpTopic.getShortText());
    assertNull(actualIndexHelpTopic.amendedPermission);
    assertTrue(collection.isEmpty());
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Short Text}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection); when ArrayList(); then return 'Short Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection)"})
  void testNewIndexHelpTopic_whenArrayList_thenReturnShortText() {
    // Arrange and Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>());

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertTrue(collection instanceof List);
    assertEquals("", actualIndexHelpTopic.fullText);
    assertEquals("", actualIndexHelpTopic.preamble);
    assertEquals("Name", actualIndexHelpTopic.getName());
    assertEquals("Permission", actualIndexHelpTopic.permission);
    assertEquals("Short Text", actualIndexHelpTopic.getShortText());
    assertNull(actualIndexHelpTopic.amendedPermission);
    assertTrue(collection.isEmpty());
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ShortText is empty string.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection); when 'null'; then return ShortText is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection)"})
  void testNewIndexHelpTopic_whenNull_thenReturnShortTextIsEmptyString() {
    // Arrange and Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", null, "Permission", new ArrayList<>());

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertTrue(collection instanceof List);
    assertEquals("", actualIndexHelpTopic.getShortText());
    assertEquals("", actualIndexHelpTopic.fullText);
    assertEquals("", actualIndexHelpTopic.preamble);
    assertEquals("Name", actualIndexHelpTopic.getName());
    assertEquals("Permission", actualIndexHelpTopic.permission);
    assertNull(actualIndexHelpTopic.amendedPermission);
    assertTrue(collection.isEmpty());
  }

  /**
   * Test {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ShortText is empty string.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#IndexHelpTopic(String, String, String, Collection,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new IndexHelpTopic(String, String, String, Collection, String); when 'null'; then return ShortText is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IndexHelpTopic.<init>(String, String, String, Collection, String)"})
  void testNewIndexHelpTopic_whenNull_thenReturnShortTextIsEmptyString2() {
    // Arrange and Act
    IndexHelpTopic actualIndexHelpTopic =
        new IndexHelpTopic("Name", null, "Permission", new ArrayList<>(), null);

    // Assert
    Collection<HelpTopic> collection = actualIndexHelpTopic.allTopics;
    assertTrue(collection instanceof List);
    assertEquals("", actualIndexHelpTopic.getShortText());
    assertEquals("", actualIndexHelpTopic.fullText);
    assertEquals("", actualIndexHelpTopic.preamble);
    assertEquals("Name", actualIndexHelpTopic.getName());
    assertEquals("Permission", actualIndexHelpTopic.permission);
    assertNull(actualIndexHelpTopic.amendedPermission);
    assertTrue(collection.isEmpty());
  }

  /**
   * Test {@link IndexHelpTopic#canSee(CommandSender)}.
   *
   * <p>Method under test: {@link IndexHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName("Test canSee(CommandSender)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexHelpTopic.canSee(CommandSender)"})
  void testCanSee() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", null, new ArrayList<>());
    topics.add(indexHelpTopic);
    IndexHelpTopic indexHelpTopic2 = new IndexHelpTopic("Name", "Short Text", null, topics);

    // Act and Assert
    assertFalse(indexHelpTopic2.canSee(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       GenericCommandHelpTopic#GenericCommandHelpTopic(Command)} with command is {@link
   *       HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); given ArrayList() add GenericCommandHelpTopic(Command) with command is HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexHelpTopic.canSee(CommandSender)"})
  void testCanSee_givenArrayListAddGenericCommandHelpTopicWithCommandIsHelpCommand() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    topics.add(new GenericCommandHelpTopic(new HelpCommand()));
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("Name", "Short Text", null, topics);

    // Act and Assert
    assertFalse(indexHelpTopic.canSee(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(String)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); given 'false'; when MessageCommandSender hasPermission(String) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexHelpTopic.canSee(CommandSender)"})
  void testCanSee_givenFalse_whenMessageCommandSenderHasPermissionReturnFalse() {
    // Arrange
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>());

    MessageCommandSender sender = mock(MessageCommandSender.class);
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(false);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualCanSeeResult = indexHelpTopic.canSee(sender);

    // Assert
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(sender).hasPermission("Permission");
    assertFalse(actualCanSeeResult);
  }

  /**
   * Test {@link IndexHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName("Test canSee(CommandSender); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexHelpTopic.canSee(CommandSender)"})
  void testCanSee_thenReturnFalse() {
    // Arrange
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", null, new ArrayList<>());

    // Act and Assert
    assertFalse(indexHelpTopic.canSee(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName("Test canSee(CommandSender); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexHelpTopic.canSee(CommandSender)"})
  void testCanSee_thenReturnTrue() {
    // Arrange
    LinkedHashSet<HelpTopic> topics = new LinkedHashSet<>();
    topics.add(new GenericCommandHelpTopic(new HelpCommand()));

    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", null, new ArrayList<>());
    indexHelpTopic.setTopicsCollection(topics);

    // Act and Assert
    assertTrue(indexHelpTopic.canSee(mock(ConsoleCommandSender.class)));
  }

  /**
   * Test {@link IndexHelpTopic#canSee(CommandSender)}.
   *
   * <ul>
   *   <li>When {@link MessageCommandSender} {@link MessageCommandSender#hasPermission(String)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#canSee(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test canSee(CommandSender); when MessageCommandSender hasPermission(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexHelpTopic.canSee(CommandSender)"})
  void testCanSee_whenMessageCommandSenderHasPermissionReturnTrue() {
    // Arrange
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>());

    MessageCommandSender sender = mock(MessageCommandSender.class);
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(true);
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PermissionAttachment permissionAttachment =
        new PermissionAttachment(plugin, new BufferedCommandSender());
    when(sender.addAttachment(Mockito.<Plugin>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(permissionAttachment);
    sender.addAttachment(new TestPlugin("Plugin Name"), "Name", true);

    // Act
    boolean actualCanSeeResult = indexHelpTopic.canSee(sender);

    // Assert
    verify(sender).addAttachment(isA(Plugin.class), eq("Name"), eq(true));
    verify(sender).hasPermission("Permission");
    assertFalse(actualCanSeeResult);
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName("Test getFullText(CommandSender)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("\n", "\n", null, new ArrayList<>());
    topics.add(indexHelpTopic);
    IndexHelpTopic indexHelpTopic2 = new IndexHelpTopic("Name", "Short Text", "Permission", topics);

    // Act and Assert
    assertEquals("§7\n", indexHelpTopic2.getFullText(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName("Test getFullText(CommandSender)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText2() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("\n", "\n", null, new ArrayList<>());
    topics.add(indexHelpTopic);
    IndexHelpTopic indexHelpTopic2 = new IndexHelpTopic("\n", "\n", null, topics);

    ArrayList<HelpTopic> topics2 = new ArrayList<>();
    topics2.add(indexHelpTopic2);
    IndexHelpTopic indexHelpTopic3 =
        new IndexHelpTopic("Name", "Short Text", "Permission", topics2);

    // Act and Assert
    assertEquals("§7\n", indexHelpTopic3.getFullText(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       GenericCommandHelpTopic#GenericCommandHelpTopic(Command)} with command is {@link
   *       HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test getFullText(CommandSender); given ArrayList() add GenericCommandHelpTopic(Command) with command is HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText_givenArrayListAddGenericCommandHelpTopicWithCommandIsHelpCommand() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    topics.add(new GenericCommandHelpTopic(new HelpCommand()));
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("Name", "Short Text", "Permission", topics);

    // Act and Assert
    assertEquals("§7\n", indexHelpTopic.getFullText(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       GenericCommandHelpTopic#GenericCommandHelpTopic(Command)} with command is {@link
   *       HelpCommand} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test getFullText(CommandSender); given ArrayList() add GenericCommandHelpTopic(Command) with command is HelpCommand (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText_givenArrayListAddGenericCommandHelpTopicWithCommandIsHelpCommand2() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    topics.add(new GenericCommandHelpTopic(new HelpCommand()));
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("\n", "\n", null, topics);

    ArrayList<HelpTopic> topics2 = new ArrayList<>();
    topics2.add(indexHelpTopic);
    IndexHelpTopic indexHelpTopic2 =
        new IndexHelpTopic("Name", "Short Text", "Permission", topics2);

    // Act and Assert
    assertEquals("§7\n", indexHelpTopic2.getFullText(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Player} {@link Player#hasPermission(String)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test getFullText(CommandSender); given 'false'; when Player hasPermission(String) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText_givenFalse_whenPlayerHasPermissionReturnFalse() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("\n", "\n", "\n", new ArrayList<>());
    topics.add(indexHelpTopic);
    IndexHelpTopic indexHelpTopic2 = new IndexHelpTopic("Name", "Short Text", "Permission", topics);

    Player sender = mock(Player.class);
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(false);

    // Act
    String actualFullText = indexHelpTopic2.getFullText(sender);

    // Assert
    verify(sender).hasPermission("\n");
    assertEquals("§7\n", actualFullText);
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Player} {@link Player#hasPermission(String)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test getFullText(CommandSender); given 'true'; when Player hasPermission(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText_givenTrue_whenPlayerHasPermissionReturnTrue() {
    // Arrange
    ArrayList<HelpTopic> topics = new ArrayList<>();
    IndexHelpTopic indexHelpTopic = new IndexHelpTopic("\n", "\n", "\n", new ArrayList<>());
    topics.add(indexHelpTopic);
    IndexHelpTopic indexHelpTopic2 = new IndexHelpTopic("Name", "Short Text", "Permission", topics);

    Player sender = mock(Player.class);
    when(sender.hasPermission(Mockito.<String>any())).thenReturn(true);

    // Act
    String actualFullText = indexHelpTopic2.getFullText(sender);

    // Assert
    verify(sender).hasPermission("\n");
    assertEquals("§7\n", actualFullText);
  }

  /**
   * Test {@link IndexHelpTopic#getFullText(CommandSender)}.
   *
   * <ul>
   *   <li>When {@link BufferedCommandSender} (default constructor).
   *   <li>Then return {@code §7}.
   * </ul>
   *
   * <p>Method under test: {@link IndexHelpTopic#getFullText(CommandSender)}
   */
  @Test
  @DisplayName(
      "Test getFullText(CommandSender); when BufferedCommandSender (default constructor); then return '§7'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.getFullText(CommandSender)"})
  void testGetFullText_whenBufferedCommandSender_thenReturn7() {
    // Arrange
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>());

    // Act and Assert
    assertEquals("§7\n", indexHelpTopic.getFullText(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#buildPreamble(CommandSender)}.
   *
   * <p>Method under test: {@link IndexHelpTopic#buildPreamble(CommandSender)}
   */
  @Test
  @DisplayName("Test buildPreamble(CommandSender)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.buildPreamble(CommandSender)"})
  void testBuildPreamble() {
    // Arrange
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>());

    // Act and Assert
    assertEquals("§7", indexHelpTopic.buildPreamble(new BufferedCommandSender()));
  }

  /**
   * Test {@link IndexHelpTopic#buildIndexLine(CommandSender, HelpTopic)}.
   *
   * <p>Method under test: {@link IndexHelpTopic#buildIndexLine(CommandSender, HelpTopic)}
   */
  @Test
  @DisplayName("Test buildIndexLine(CommandSender, HelpTopic)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexHelpTopic.buildIndexLine(CommandSender, HelpTopic)"})
  void testBuildIndexLine() {
    // Arrange
    IndexHelpTopic indexHelpTopic =
        new IndexHelpTopic("Name", "Short Text", "Permission", new ArrayList<>());
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act and Assert
    assertEquals(
        "§6/help: §fShows the help menu",
        indexHelpTopic.buildIndexLine(sender, new GenericCommandHelpTopic(new HelpCommand())));
  }
}
