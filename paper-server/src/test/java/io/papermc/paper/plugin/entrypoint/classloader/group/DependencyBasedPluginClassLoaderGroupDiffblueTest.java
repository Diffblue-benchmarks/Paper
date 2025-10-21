package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess;
import io.papermc.paper.plugin.provider.classloader.ConfiguredPluginClassLoader;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DependencyBasedPluginClassLoaderGroupDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       DependencyBasedPluginClassLoaderGroup#DependencyBasedPluginClassLoaderGroup(GlobalPluginClassLoaderGroup,
   *       ClassLoaderAccess)}
   *   <li>{@link DependencyBasedPluginClassLoaderGroup#toString()}
   *   <li>{@link DependencyBasedPluginClassLoaderGroup#getAccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DependencyBasedPluginClassLoaderGroup.<init>(GlobalPluginClassLoaderGroup, ClassLoaderAccess)",
    "ClassLoaderAccess DependencyBasedPluginClassLoaderGroup.getAccess()",
    "java.lang.String DependencyBasedPluginClassLoaderGroup.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ClassLoaderAccess access = mock(ClassLoaderAccess.class);

    // Act
    DependencyBasedPluginClassLoaderGroup actualDependencyBasedPluginClassLoaderGroup =
        new DependencyBasedPluginClassLoaderGroup(new GlobalPluginClassLoaderGroup(), access);
    actualDependencyBasedPluginClassLoaderGroup.toString();
    ClassLoaderAccess actualAccess = actualDependencyBasedPluginClassLoaderGroup.getAccess();

    // Assert
    assertTrue(actualDependencyBasedPluginClassLoaderGroup.getClassLoaders().isEmpty());
    assertSame(access, actualAccess);
  }

  /**
   * Test {@link DependencyBasedPluginClassLoaderGroup#populateDependencies()}.
   *
   * <p>Method under test: {@link DependencyBasedPluginClassLoaderGroup#populateDependencies()}
   */
  @Test
  @DisplayName("Test populateDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DependencyBasedPluginClassLoaderGroup.populateDependencies()"})
  void testPopulateDependencies() {
    // Arrange
    DependencyBasedPluginClassLoaderGroup dependencyBasedPluginClassLoaderGroup =
        new DependencyBasedPluginClassLoaderGroup(
            new GlobalPluginClassLoaderGroup(), mock(ClassLoaderAccess.class));

    // Act
    dependencyBasedPluginClassLoaderGroup.populateDependencies();

    // Assert that nothing has changed
    assertTrue(dependencyBasedPluginClassLoaderGroup.getClassLoaders().isEmpty());
  }

  /**
   * Test {@link DependencyBasedPluginClassLoaderGroup#populateDependencies()}.
   *
   * <p>Method under test: {@link DependencyBasedPluginClassLoaderGroup#populateDependencies()}
   */
  @Test
  @DisplayName("Test populateDependencies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DependencyBasedPluginClassLoaderGroup.populateDependencies()"})
  void testPopulateDependencies2() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    globalPluginClassLoaderGroup.add(null);

    ClassLoaderAccess access = mock(ClassLoaderAccess.class);
    when(access.canAccess(Mockito.<ConfiguredPluginClassLoader>any())).thenReturn(true);

    DependencyBasedPluginClassLoaderGroup dependencyBasedPluginClassLoaderGroup =
        new DependencyBasedPluginClassLoaderGroup(globalPluginClassLoaderGroup, access);

    // Act
    dependencyBasedPluginClassLoaderGroup.populateDependencies();

    // Assert
    verify(access).canAccess(isNull());
    List<ConfiguredPluginClassLoader> classLoaders =
        dependencyBasedPluginClassLoaderGroup.getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
  }

  /**
   * Test {@link DependencyBasedPluginClassLoaderGroup#populateDependencies()}.
   *
   * <ul>
   *   <li>Given {@link ClassLoaderAccess} {@link
   *       ClassLoaderAccess#canAccess(ConfiguredPluginClassLoader)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DependencyBasedPluginClassLoaderGroup#populateDependencies()}
   */
  @Test
  @DisplayName(
      "Test populateDependencies(); given ClassLoaderAccess canAccess(ConfiguredPluginClassLoader) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DependencyBasedPluginClassLoaderGroup.populateDependencies()"})
  void testPopulateDependencies_givenClassLoaderAccessCanAccessReturnFalse() {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    globalPluginClassLoaderGroup.add(null);

    ClassLoaderAccess access = mock(ClassLoaderAccess.class);
    when(access.canAccess(Mockito.<ConfiguredPluginClassLoader>any())).thenReturn(false);

    DependencyBasedPluginClassLoaderGroup dependencyBasedPluginClassLoaderGroup =
        new DependencyBasedPluginClassLoaderGroup(globalPluginClassLoaderGroup, access);

    // Act
    dependencyBasedPluginClassLoaderGroup.populateDependencies();

    // Assert that nothing has changed
    verify(access).canAccess(isNull());
    assertTrue(dependencyBasedPluginClassLoaderGroup.getClassLoaders().isEmpty());
  }
}
