package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlobalPluginClassLoaderGroupDiffblueTest {
  /**
   * Test {@link GlobalPluginClassLoaderGroup#getAccess()}.
   *
   * <ul>
   *   <li>Then {@link GlobalPluginClassLoaderGroup} (default constructor) ClassLoaders Empty.
   * </ul>
   *
   * <p>Method under test: {@link GlobalPluginClassLoaderGroup#getAccess()}
   */
  @Test
  @DisplayName(
      "Test getAccess(); then GlobalPluginClassLoaderGroup (default constructor) ClassLoaders Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess GlobalPluginClassLoaderGroup.getAccess()"
  })
  void testGetAccess_thenGlobalPluginClassLoaderGroupClassLoadersEmpty() {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();

    // Act
    globalPluginClassLoaderGroup.getAccess();

    // Assert that nothing has changed
    assertTrue(globalPluginClassLoaderGroup.getClassLoaders().isEmpty());
  }

  /**
   * Test {@link GlobalPluginClassLoaderGroup#getAccess()}.
   *
   * <ul>
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalPluginClassLoaderGroup#getAccess()}
   */
  @Test
  @DisplayName("Test getAccess(); then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess GlobalPluginClassLoaderGroup.getAccess()"
  })
  void testGetAccess_thenNull() {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act and Assert
    assertNull(null);
    assertTrue(globalPluginClassLoaderGroup.getAccess().canAccess(null));
    assertTrue(globalPluginClassLoaderGroup.getClassLoaders().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GlobalPluginClassLoaderGroup}
   *   <li>{@link GlobalPluginClassLoaderGroup#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GlobalPluginClassLoaderGroup.<init>()",
    "java.lang.String GlobalPluginClassLoaderGroup.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GlobalPluginClassLoaderGroup actualGlobalPluginClassLoaderGroup =
        new GlobalPluginClassLoaderGroup();

    // Assert
    assertEquals(
        "GLOBAL:SimpleListPluginClassLoaderGroup{classloaders=[]}",
        actualGlobalPluginClassLoaderGroup.toString());
    assertTrue(actualGlobalPluginClassLoaderGroup.getClassLoaders().isEmpty());
  }
}
