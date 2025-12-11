package io.papermc.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.SparksFly.CommandImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import org.bukkit.Server;
import org.bukkit.craftbukkit.CraftServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class SparksFlyDiffblueTest {
  /**
   * Test CommandImpl {@link CommandImpl#CommandImpl(String, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Permission is {@code foo;;}.
   * </ul>
   *
   * <p>Method under test: {@link CommandImpl#CommandImpl(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test CommandImpl new CommandImpl(String, Collection); given 'foo'; then return Permission is 'foo;;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandImpl.<init>(String, Collection)"})
  void testCommandImplNewCommandImpl_givenFoo_thenReturnPermissionIsFoo() {
    // Arrange
    ArrayList<String> permissions = new ArrayList<>();
    permissions.add("foo");
    permissions.add(";");

    // Act
    CommandImpl actualCommandImpl = new CommandImpl("Name", permissions);

    // Assert
    assertEquals("", actualCommandImpl.getDescription());
    assertEquals("/Name", actualCommandImpl.getUsage());
    assertEquals("Name", actualCommandImpl.getLabel());
    assertEquals("Name", actualCommandImpl.getName());
    assertEquals("Name", actualCommandImpl.getTimingName());
    assertEquals("foo;;", actualCommandImpl.getPermission());
    assertNull(actualCommandImpl.timings);
    assertNull(actualCommandImpl.getPermissionMessage());
    assertNull(actualCommandImpl.permissionMessage());
    assertFalse(actualCommandImpl.isRegistered());
    assertTrue(actualCommandImpl.getAliases().isEmpty());
  }

  /**
   * Test CommandImpl {@link CommandImpl#CommandImpl(String, Collection)}.
   *
   * <ul>
   *   <li>Given {@code ;}.
   *   <li>Then return Permission is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link CommandImpl#CommandImpl(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test CommandImpl new CommandImpl(String, Collection); given ';'; then return Permission is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandImpl.<init>(String, Collection)"})
  void testCommandImplNewCommandImpl_givenSemicolon_thenReturnPermissionIsSemicolon() {
    // Arrange
    ArrayList<String> permissions = new ArrayList<>();
    permissions.add(";");

    // Act
    CommandImpl actualCommandImpl = new CommandImpl("Name", permissions);

    // Assert
    assertEquals("", actualCommandImpl.getDescription());
    assertEquals("/Name", actualCommandImpl.getUsage());
    assertEquals(";", actualCommandImpl.getPermission());
    assertEquals("Name", actualCommandImpl.getLabel());
    assertEquals("Name", actualCommandImpl.getName());
    assertEquals("Name", actualCommandImpl.getTimingName());
    assertNull(actualCommandImpl.timings);
    assertNull(actualCommandImpl.getPermissionMessage());
    assertNull(actualCommandImpl.permissionMessage());
    assertFalse(actualCommandImpl.isRegistered());
    assertTrue(actualCommandImpl.getAliases().isEmpty());
  }

  /**
   * Test CommandImpl {@link CommandImpl#CommandImpl(String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Permission is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CommandImpl#CommandImpl(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test CommandImpl new CommandImpl(String, Collection); when ArrayList(); then return Permission is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandImpl.<init>(String, Collection)"})
  void testCommandImplNewCommandImpl_whenArrayList_thenReturnPermissionIsEmptyString() {
    // Arrange and Act
    CommandImpl actualCommandImpl = new CommandImpl("Name", new ArrayList<>());

    // Assert
    assertEquals("", actualCommandImpl.getDescription());
    assertEquals("", actualCommandImpl.getPermission());
    assertEquals("/Name", actualCommandImpl.getUsage());
    assertEquals("Name", actualCommandImpl.getLabel());
    assertEquals("Name", actualCommandImpl.getName());
    assertEquals("Name", actualCommandImpl.getTimingName());
    assertNull(actualCommandImpl.timings);
    assertNull(actualCommandImpl.getPermissionMessage());
    assertNull(actualCommandImpl.permissionMessage());
    assertFalse(actualCommandImpl.isRegistered());
    assertTrue(actualCommandImpl.getAliases().isEmpty());
  }

  /**
   * Test {@link SparksFly#SparksFly(Server)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#exists(Path, LinkOption[])} return {@code false}.
   *   <li>Then calls {@link Files#createDirectories(Path, FileAttribute[])}.
   * </ul>
   *
   * <p>Method under test: {@link SparksFly#SparksFly(Server)}
   */
  @Test
  @DisplayName(
      "Test new SparksFly(Server); given Files exists(Path, LinkOption[]) return 'false'; then calls createDirectories(Path, FileAttribute[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SparksFly.<init>(Server)"})
  void testNewSparksFly_givenFilesExistsReturnFalse_thenCallsCreateDirectories()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.newBufferedReader(Mockito.<Path>any(), Mockito.<Charset>any()))
          .thenReturn(new BufferedReader(new StringReader("foo"), 1));
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      mockFiles
          .when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(() -> Files.walkFileTree(Mockito.<Path>any(), Mockito.<FileVisitor<Path>>any()))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);
      mockFiles
          .when(
              () ->
                  Files.write(
                      Mockito.<Path>any(),
                      Mockito.<Iterable<CharSequence>>any(),
                      Mockito.<Charset>any(),
                      isA(OpenOption[].class)))
          .thenReturn(MetricsPersister.PROFILING_RESULTS_DIR);

      CraftServer server = mock(CraftServer.class);
      when(server.getPluginsFolder()).thenReturn(OldUsersConverter.OLD_IPBANLIST);

      // Act
      new SparksFly(server);

      // Assert
      mockFiles.verify(
          () -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(
          () -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.walkFileTree(Mockito.<Path>any(), Mockito.<FileVisitor<Path>>any()));
      mockFiles.verify(
          () ->
              Files.write(
                  Mockito.<Path>any(),
                  Mockito.<Iterable<CharSequence>>any(),
                  Mockito.<Charset>any(),
                  isA(OpenOption[].class)));
      verify(server, atLeast(1)).getPluginsFolder();
    }
  }

  /**
   * Test {@link SparksFly#isPluginPreferred()}.
   *
   * <p>Method under test: {@link SparksFly#isPluginPreferred()}
   */
  @Test
  @DisplayName("Test isPluginPreferred()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparksFly.isPluginPreferred()"})
  void testIsPluginPreferred() {
    // Arrange, Act and Assert
    assertFalse(SparksFly.isPluginPreferred());
  }
}
