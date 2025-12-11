package io.papermc.paper.command.subcommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.brigadier.NullCommandSender;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class DumpListenersCommandDiffblueTest {
  /**
   * Test {@link DumpListenersCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>Then calls {@link Files#createDirectories(Path, FileAttribute[])}.
   * </ul>
   *
   * <p>Method under test: {@link DumpListenersCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); then calls createDirectories(Path, FileAttribute[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DumpListenersCommand.execute(CommandSender, String, String[])"})
  void testExecute_thenCallsCreateDirectories() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());

      // Act
      boolean actualExecuteResult =
          new DumpListenersCommand()
              .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {"tofile", "Args"});

      // Assert
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      assertTrue(actualExecuteResult);
    }
  }

  /**
   * Test {@link DumpListenersCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code net.kyori.adventure.text.TextComponent} and
   *       {@code Args}.
   * </ul>
   *
   * <p>Method under test: {@link DumpListenersCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when array of String with 'net.kyori.adventure.text.TextComponent' and 'Args'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DumpListenersCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenArrayOfStringWithNetKyoriAdventureTextTextComponentAndArgs()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      // Act and Assert
      assertTrue(
          new DumpListenersCommand()
              .execute(
                  NullCommandSender.INSTANCE,
                  "Sub Command",
                  new String[] {"net.kyori.adventure.text.TextComponent", "Args"}));
    }
  }

  /**
   * Test {@link DumpListenersCommand#execute(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DumpListenersCommand#execute(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test execute(CommandSender, String, String[]); when empty array of String; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DumpListenersCommand.execute(CommandSender, String, String[])"})
  void testExecute_whenEmptyArrayOfString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpListenersCommand()
            .execute(NullCommandSender.INSTANCE, "Sub Command", new String[] {}));
  }

  /**
   * Test {@link DumpListenersCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DumpListenersCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DumpListenersCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithArgs_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpListenersCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"Args"})
            .isEmpty());
  }

  /**
   * Test {@link DumpListenersCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code tofile} and {@code Args}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DumpListenersCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'tofile' and 'Args'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DumpListenersCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithTofileAndArgs_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new DumpListenersCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"tofile", "Args"})
            .isEmpty());
  }

  /**
   * Test {@link DumpListenersCommand#tabComplete(CommandSender, String, String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code tofile}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DumpListenersCommand#tabComplete(CommandSender, String, String[])}
   */
  @Test
  @DisplayName(
      "Test tabComplete(CommandSender, String, String[]); when array of String with 'tofile'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DumpListenersCommand.tabComplete(CommandSender, String, String[])"})
  void testTabComplete_whenArrayOfStringWithTofile_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualTabCompleteResult =
        new DumpListenersCommand()
            .tabComplete(NullCommandSender.INSTANCE, "Sub Command", new String[] {"tofile"});

    // Assert
    assertEquals(1, actualTabCompleteResult.size());
    assertEquals("tofile", actualTabCompleteResult.get(0));
  }
}
