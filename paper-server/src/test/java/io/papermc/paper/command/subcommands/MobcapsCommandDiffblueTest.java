package io.papermc.paper.command.subcommands;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MobcapsCommandDiffblueTest {
  /**
   * Test {@link MobcapsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code mobcaps} and {@code *}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when array of String with 'mobcaps' and '*'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobcapsCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenArrayOfStringWithMobcapsAndAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand()
            .execute(NullCommandSender.INSTANCE, "mobcaps", new String[] {"mobcaps", "*"}));
  }

  /**
   * Test {@link MobcapsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code mobcaps} and {@code *}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when array of String with 'mobcaps' and '*'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobcapsCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenArrayOfStringWithMobcapsAndAsterisk_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand()
            .execute(NullCommandSender.INSTANCE, "playermobcaps", new String[] {"mobcaps", "*"}));
  }

  /**
   * Test {@link MobcapsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when empty array of String; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobcapsCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenEmptyArrayOfString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand().execute(NullCommandSender.INSTANCE, "mobcaps", new String[] {}));
  }

  /**
   * Test {@link MobcapsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when empty array of String; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobcapsCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenEmptyArrayOfString_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand().execute(NullCommandSender.INSTANCE, "playermobcaps", new String[] {}));
  }

  /**
   * Test {@link MobcapsCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Sub Command}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when 'Sub Command'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobcapsCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenSubCommand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }

  /**
   * Test {@link MobcapsCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args} and {@code *}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'Args' and '*'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List MobcapsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithArgsAndAsterisk_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand()
            .tabComplete(NullCommandSender.INSTANCE, "mobcaps", new String[] {"Args", "*"})
            .isEmpty());
  }

  /**
   * Test {@link MobcapsCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args} and {@code *}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'Args' and '*'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List MobcapsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithArgsAndAsterisk_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertTrue(
        new MobcapsCommand()
            .tabComplete(NullCommandSender.INSTANCE, "playermobcaps", new String[] {"Args", "*"})
            .isEmpty());
  }

  /**
   * Test {@link MobcapsCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When {@code Sub Command}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MobcapsCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when 'Sub Command'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List MobcapsCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenSubCommand_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new MobcapsCommand()
                .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"}));
  }
}
