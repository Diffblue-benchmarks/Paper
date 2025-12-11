package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.classloader.PaperPluginClassLoader;
import io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess;
import io.papermc.paper.plugin.provider.classloader.ConfiguredPluginClassLoader;
import io.papermc.paper.plugin.provider.classloader.PluginClassLoaderGroup;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.List;
import org.bukkit.plugin.java.PluginClassLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperPluginClassLoaderStorageDiffblueTest {
  /**
   * Test new {@link PaperPluginClassLoaderStorage} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PaperPluginClassLoaderStorage}
   */
  @Test
  @DisplayName("Test new PaperPluginClassLoaderStorage (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaperPluginClassLoaderStorage.<init>()"})
  void testNewPaperPluginClassLoaderStorage() {
    // Arrange and Act
    PaperPluginClassLoaderStorage actualPaperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();

    // Assert
    List<PluginClassLoaderGroup> groups = actualPaperPluginClassLoaderStorage.getGroups();
    assertEquals(1, groups.size());
    GlobalPluginClassLoaderGroup globalGroup = actualPaperPluginClassLoaderStorage.getGlobalGroup();
    assertTrue(globalGroup.getClassLoaders().isEmpty());
    assertSame(globalGroup, groups.get(0));
  }

  /**
   * Test {@link PaperPluginClassLoaderStorage#registerSpigotGroup(PluginClassLoader)}.
   *
   * <ul>
   *   <li>Then return {@link LockingClassLoaderGroup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperPluginClassLoaderStorage#registerSpigotGroup(PluginClassLoader)}
   */
  @Test
  @DisplayName("Test registerSpigotGroup(PluginClassLoader); then return LockingClassLoaderGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginClassLoaderGroup PaperPluginClassLoaderStorage.registerSpigotGroup(PluginClassLoader)"
  })
  void testRegisterSpigotGroup_thenReturnLockingClassLoaderGroup() throws MalformedURLException {
    // Arrange
    PaperPluginClassLoaderStorage paperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);

    // Act
    PluginClassLoaderGroup actualRegisterSpigotGroupResult =
        paperPluginClassLoaderStorage.registerSpigotGroup(null);

    // Assert
    assertTrue(actualRegisterSpigotGroupResult instanceof LockingClassLoaderGroup);
    PluginClassLoaderGroup parent =
        ((LockingClassLoaderGroup) actualRegisterSpigotGroupResult).getParent();
    assertTrue(parent instanceof SpigotPluginClassLoaderGroup);
    List<ConfiguredPluginClassLoader> classLoaders =
        ((SpigotPluginClassLoaderGroup) parent).getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
    assertNull(((SpigotPluginClassLoaderGroup) parent).getPluginClassLoader());
    assertEquals(2, paperPluginClassLoaderStorage.getGroups().size());
  }

  /**
   * Test {@link PaperPluginClassLoaderStorage#registerOpenGroup(ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Then Parent return {@link GlobalPluginClassLoaderGroup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperPluginClassLoaderStorage#registerOpenGroup(ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test registerOpenGroup(ConfiguredPluginClassLoader); then Parent return GlobalPluginClassLoaderGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginClassLoaderGroup PaperPluginClassLoaderStorage.registerOpenGroup(ConfiguredPluginClassLoader)"
  })
  void testRegisterOpenGroup_thenParentReturnGlobalPluginClassLoaderGroup()
      throws MalformedURLException {
    // Arrange
    PaperPluginClassLoaderStorage paperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);

    // Act
    PluginClassLoaderGroup actualRegisterOpenGroupResult =
        paperPluginClassLoaderStorage.registerOpenGroup(null);

    // Assert
    PluginClassLoaderGroup parent =
        ((LockingClassLoaderGroup) actualRegisterOpenGroupResult).getParent();
    assertTrue(parent instanceof GlobalPluginClassLoaderGroup);
    assertTrue(actualRegisterOpenGroupResult instanceof LockingClassLoaderGroup);
    List<ConfiguredPluginClassLoader> classLoaders =
        ((GlobalPluginClassLoaderGroup) parent).getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
    assertEquals(2, paperPluginClassLoaderStorage.getGroups().size());
  }

  /**
   * Test {@link
   * PaperPluginClassLoaderStorage#registerAccessBackedGroup(ConfiguredPluginClassLoader,
   * ClassLoaderAccess)}.
   *
   * <ul>
   *   <li>Then return {@link LockingClassLoaderGroup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperPluginClassLoaderStorage#registerAccessBackedGroup(ConfiguredPluginClassLoader,
   * ClassLoaderAccess)}
   */
  @Test
  @DisplayName(
      "Test registerAccessBackedGroup(ConfiguredPluginClassLoader, ClassLoaderAccess); then return LockingClassLoaderGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginClassLoaderGroup PaperPluginClassLoaderStorage.registerAccessBackedGroup(ConfiguredPluginClassLoader, ClassLoaderAccess)"
  })
  void testRegisterAccessBackedGroup_thenReturnLockingClassLoaderGroup()
      throws MalformedURLException {
    // Arrange
    PaperPluginClassLoaderStorage paperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);
    ClassLoaderAccess access = mock(ClassLoaderAccess.class);

    // Act
    PluginClassLoaderGroup actualRegisterAccessBackedGroupResult =
        paperPluginClassLoaderStorage.registerAccessBackedGroup(null, access);

    // Assert
    assertTrue(actualRegisterAccessBackedGroupResult instanceof LockingClassLoaderGroup);
    PluginClassLoaderGroup parent =
        ((LockingClassLoaderGroup) actualRegisterAccessBackedGroupResult).getParent();
    assertTrue(parent instanceof StaticPluginClassLoaderGroup);
    assertNull(((StaticPluginClassLoaderGroup) parent).getPluginClassloader());
    List<ConfiguredPluginClassLoader> classLoaders =
        paperPluginClassLoaderStorage.getGlobalGroup().getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
    assertEquals(2, paperPluginClassLoaderStorage.getGroups().size());
    assertTrue(((StaticPluginClassLoaderGroup) parent).getClassLoaders().isEmpty());
    assertSame(access, parent.getAccess());
    assertSame(access, actualRegisterAccessBackedGroupResult.getAccess());
  }

  /**
   * Test {@link PaperPluginClassLoaderStorage#unregisterClassloader(ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link GlobalPluginClassLoaderGroup} (default constructor).
   *   <li>Then calls {@link PaperPluginClassLoader#getGroup()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaperPluginClassLoaderStorage#unregisterClassloader(ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test unregisterClassloader(ConfiguredPluginClassLoader); given GlobalPluginClassLoaderGroup (default constructor); then calls getGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperPluginClassLoaderStorage.unregisterClassloader(ConfiguredPluginClassLoader)"
  })
  void testUnregisterClassloader_givenGlobalPluginClassLoaderGroup_thenCallsGetGroup()
      throws MalformedURLException {
    // Arrange
    PaperPluginClassLoaderStorage paperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);

    PaperPluginClassLoader configuredPluginClassLoader = mock(PaperPluginClassLoader.class);
    when(configuredPluginClassLoader.getGroup()).thenReturn(new GlobalPluginClassLoaderGroup());

    // Act
    paperPluginClassLoaderStorage.unregisterClassloader(configuredPluginClassLoader);

    // Assert
    verify(configuredPluginClassLoader).getGroup();
  }

  /**
   * Test {@link PaperPluginClassLoaderStorage#registerUnsafePlugin(ConfiguredPluginClassLoader)}.
   *
   * <p>Method under test: {@link
   * PaperPluginClassLoaderStorage#registerUnsafePlugin(ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName("Test registerUnsafePlugin(ConfiguredPluginClassLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaperPluginClassLoaderStorage.registerUnsafePlugin(ConfiguredPluginClassLoader)"
  })
  void testRegisterUnsafePlugin() throws MalformedURLException {
    // Arrange
    PaperPluginClassLoaderStorage paperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray);
    URL[] urlArray2 =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    new URLClassLoader(urlArray2);

    // Act
    boolean actualRegisterUnsafePluginResult =
        paperPluginClassLoaderStorage.registerUnsafePlugin(null);

    // Assert
    List<ConfiguredPluginClassLoader> classLoaders =
        paperPluginClassLoaderStorage.getGlobalGroup().getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
    assertTrue(actualRegisterUnsafePluginResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaperPluginClassLoaderStorage#getGlobalGroup()}
   *   <li>{@link PaperPluginClassLoaderStorage#getGroups()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GlobalPluginClassLoaderGroup PaperPluginClassLoaderStorage.getGlobalGroup()",
    "List PaperPluginClassLoaderStorage.getGroups()"
  })
  void testGettersAndSetters() {
    // Arrange
    PaperPluginClassLoaderStorage paperPluginClassLoaderStorage =
        new PaperPluginClassLoaderStorage();

    // Act
    GlobalPluginClassLoaderGroup actualGlobalGroup = paperPluginClassLoaderStorage.getGlobalGroup();
    List<PluginClassLoaderGroup> actualGroups = paperPluginClassLoaderStorage.getGroups();

    // Assert
    assertEquals(1, actualGroups.size());
    assertTrue(actualGlobalGroup.getClassLoaders().isEmpty());
    assertSame(actualGlobalGroup, actualGroups.get(0));
  }
}
