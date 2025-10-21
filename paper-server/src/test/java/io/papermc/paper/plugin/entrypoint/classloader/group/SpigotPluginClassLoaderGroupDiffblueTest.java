package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  void testNewSpigotPluginClassLoaderGroup_thenReturnPluginClassLoaderIsNull() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    SpigotPluginClassLoaderGroup actualSpigotPluginClassLoaderGroup =
        new SpigotPluginClassLoaderGroup(
            new GlobalPluginClassLoaderGroup(), mock(Predicate.class), null);

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
  @MethodsUnderTest({
    "io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess SpigotPluginClassLoaderGroup.getAccess()"
  })
  void testGetAccess_thenReturnNotCanAccessNull() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup =
        mock(GlobalPluginClassLoaderGroup.class);
    when(globalPluginClassLoaderGroup.getClassLoaders()).thenReturn(new ArrayList<>());
    SpigotPluginClassLoaderGroup spigotPluginClassLoaderGroup =
        new SpigotPluginClassLoaderGroup(globalPluginClassLoaderGroup, mock(Predicate.class), null);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    boolean actualCanAccessResult = spigotPluginClassLoaderGroup.getAccess().canAccess(null);

    // Assert
    verify(globalPluginClassLoaderGroup).getClassLoaders();
    assertFalse(actualCanAccessResult);
  }
}
