package io.papermc.paper.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class CommandUtilDiffblueTest {
  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], String[])} with {@code
   * sender}, {@code args}, {@code matches}.
   *
   * <ul>
   *   <li>When {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], String[]) with 'sender', 'args', 'matches'; when 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], String[])"})
  void testGetListMatchingLastWithSenderArgsMatches_whenArgs_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(
            NullCommandSender.INSTANCE, new String[] {"Args"}, "Matches");

    // Assert
    assertTrue(actualListMatchingLast.isEmpty());
  }

  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], String[])} with {@code
   * sender}, {@code args}, {@code matches}.
   *
   * <ul>
   *   <li>When {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], String[]) with 'sender', 'args', 'matches'; when 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], String[])"})
  void testGetListMatchingLastWithSenderArgsMatches_whenArgs_thenReturnEmpty2() {
    // Arrange and Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(NullCommandSender.INSTANCE, new String[] {"Args"});

    // Assert
    assertTrue(actualListMatchingLast.isEmpty());
  }

  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], String[])} with {@code
   * sender}, {@code args}, {@code matches}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], String[]) with 'sender', 'args', 'matches'; when empty string; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], String[])"})
  void testGetListMatchingLastWithSenderArgsMatches_whenEmptyString_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(NullCommandSender.INSTANCE, new String[] {""}, "Matches");

    // Assert
    assertEquals(1, actualListMatchingLast.size());
    assertEquals("Matches", actualListMatchingLast.get(0));
  }

  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], Collection)} with {@code
   * sender}, {@code strings}, {@code collection}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], Collection) with 'sender', 'strings', 'collection'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], Collection)"})
  void testGetListMatchingLastWithSenderStringsCollection_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(
            NullCommandSender.INSTANCE, new String[] {"Strings"}, collection);

    // Assert
    assertTrue(actualListMatchingLast.isEmpty());
  }

  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], Collection)} with {@code
   * sender}, {@code strings}, {@code collection}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], Collection) with 'sender', 'strings', 'collection'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], Collection)"})
  void testGetListMatchingLastWithSenderStringsCollection_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(
            NullCommandSender.INSTANCE, new String[] {"Strings"}, collection);

    // Assert
    assertTrue(actualListMatchingLast.isEmpty());
  }

  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], Collection)} with {@code
   * sender}, {@code strings}, {@code collection}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], Collection) with 'sender', 'strings', 'collection'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], Collection)"})
  void testGetListMatchingLastWithSenderStringsCollection_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(NullCommandSender.INSTANCE, new String[] {""}, collection);

    // Assert
    assertEquals(1, actualListMatchingLast.size());
  }

  /**
   * Test {@link CommandUtil#getListMatchingLast(CommandSender, String[], Collection)} with {@code
   * sender}, {@code strings}, {@code collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#getListMatchingLast(CommandSender, String[],
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test getListMatchingLast(CommandSender, String[], Collection) with 'sender', 'strings', 'collection'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List CommandUtil.getListMatchingLast(CommandSender, String[], Collection)"})
  void testGetListMatchingLastWithSenderStringsCollection_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualListMatchingLast =
        CommandUtil.getListMatchingLast(
            NullCommandSender.INSTANCE, new String[] {"Strings"}, new ArrayList<>());

    // Assert
    assertTrue(actualListMatchingLast.isEmpty());
  }

  /**
   * Test {@link CommandUtil#matches(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#matches(String, String)}
   */
  @Test
  @DisplayName("Test matches(String, String); when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandUtil.matches(String, String)"})
  void testMatches_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CommandUtil.matches("", "S1"));
  }

  /**
   * Test {@link CommandUtil#matches(String, String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CommandUtil#matches(String, String)}
   */
  @Test
  @DisplayName("Test matches(String, String); when 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CommandUtil.matches(String, String)"})
  void testMatches_whenFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CommandUtil.matches("foo", "S1"));
  }
}
