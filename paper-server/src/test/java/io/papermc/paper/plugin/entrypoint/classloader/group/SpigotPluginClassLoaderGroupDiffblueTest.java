package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess;
import io.papermc.paper.plugin.provider.classloader.ConfiguredPluginClassLoader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.bukkit.plugin.java.PluginClassLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpigotPluginClassLoaderGroupDiffblueTest {
  /**
   * Test {@link
   * SpigotPluginClassLoaderGroup#SpigotPluginClassLoaderGroup(GlobalPluginClassLoaderGroup,
   * Predicate, PluginClassLoader)}.
   *
   * <ul>
   *   <li>Then return PluginClassLoader is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SpigotPluginClassLoaderGroup#SpigotPluginClassLoaderGroup(GlobalPluginClassLoaderGroup,
   * Predicate, PluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test new SpigotPluginClassLoaderGroup(GlobalPluginClassLoaderGroup, Predicate, PluginClassLoader); then return PluginClassLoader is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SpigotPluginClassLoaderGroup.<init>(GlobalPluginClassLoaderGroup, Predicate, PluginClassLoader)"
  })
  void testNewSpigotPluginClassLoaderGroup_thenReturnPluginClassLoaderIsNull()
      throws MalformedURLException {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    Predicate<ConfiguredPluginClassLoader> libraryClassloaderPredicate = mock(Predicate.class);
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);

    // Act
    SpigotPluginClassLoaderGroup actualSpigotPluginClassLoaderGroup =
        new SpigotPluginClassLoaderGroup(
            globalPluginClassLoaderGroup, libraryClassloaderPredicate, null);

    // Assert
    assertNull(actualSpigotPluginClassLoaderGroup.getPluginClassLoader());
    assertTrue(actualSpigotPluginClassLoaderGroup.getClassLoaders().isEmpty());
  }

  /**
   * Test {@link SpigotPluginClassLoaderGroup#getAccess()}.
   *
   * <ul>
   *   <li>Then return not canAccess {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpigotPluginClassLoaderGroup#getAccess()}
   */
  @Test
  @DisplayName("Test getAccess(); then return not canAccess 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassLoaderAccess SpigotPluginClassLoaderGroup.getAccess()"})
  void testGetAccess_thenReturnNotCanAccessNull() throws MalformedURLException {
    // Arrange
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);

    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup =
        mock(GlobalPluginClassLoaderGroup.class);
    when(globalPluginClassLoaderGroup.getClassLoaders()).thenReturn(new ArrayList<>());
    SpigotPluginClassLoaderGroup spigotPluginClassLoaderGroup =
        new SpigotPluginClassLoaderGroup(globalPluginClassLoaderGroup, mock(Predicate.class), null);

    // Act
    ClassLoaderAccess actualAccess = spigotPluginClassLoaderGroup.getAccess();
    URL[] urlArray3 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray3);
    URL[] urlArray4 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray4);
    boolean actualCanAccessResult = actualAccess.canAccess(null);

    // Assert
    verify(globalPluginClassLoaderGroup).getClassLoaders();
    assertFalse(actualCanAccessResult);
  }
}
