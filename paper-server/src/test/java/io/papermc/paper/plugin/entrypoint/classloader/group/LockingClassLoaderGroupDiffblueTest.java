package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.classloader.PaperPluginClassLoader;
import io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess;
import io.papermc.paper.plugin.provider.classloader.ConfiguredPluginClassLoader;
import io.papermc.paper.plugin.provider.classloader.PluginClassLoaderGroup;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LockingClassLoaderGroupDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LockingClassLoaderGroup#LockingClassLoaderGroup(PluginClassLoaderGroup)}
   *   <li>{@link LockingClassLoaderGroup#toString()}
   *   <li>{@link LockingClassLoaderGroup#getParent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LockingClassLoaderGroup.<init>(PluginClassLoaderGroup)",
    "PluginClassLoaderGroup LockingClassLoaderGroup.getParent()",
    "String LockingClassLoaderGroup.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    GlobalPluginClassLoaderGroup parent = new GlobalPluginClassLoaderGroup();

    // Act
    LockingClassLoaderGroup actualLockingClassLoaderGroup = new LockingClassLoaderGroup(parent);
    String actualToStringResult = actualLockingClassLoaderGroup.toString();

    // Assert
    assertEquals(
        "LockingClassLoaderGroup{parent=GLOBAL:SimpleListPluginClassLoaderGroup{classloaders=[]},"
            + " classLoadLock={}}",
        actualToStringResult);
    assertSame(parent, actualLockingClassLoaderGroup.getParent());
  }

  /**
   * Test {@link LockingClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test getClassByName(String, boolean, ConfiguredPluginClassLoader); given 'java.lang.Object'; then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class LockingClassLoaderGroup.getClassByName(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testGetClassByName_givenJavaLangObject_thenReturnObject() throws ClassNotFoundException {
    // Arrange
    LockingClassLoaderGroup lockingClassLoaderGroup =
        new LockingClassLoaderGroup(new GlobalPluginClassLoaderGroup());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader requester = mock(PaperPluginClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(
            requester.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualClassByName = lockingClassLoaderGroup.getClassByName("Name", true, requester);

    // Assert
    verify(requester).loadClass("Name", false, false, true);
    Class<Object> expectedClassByName = Object.class;
    assertEquals(expectedClassByName, actualClassByName);
  }

  /**
   * Test {@link LockingClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test getClassByName(String, boolean, ConfiguredPluginClassLoader); then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class LockingClassLoaderGroup.getClassByName(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testGetClassByName_thenReturnObject() throws ClassNotFoundException {
    // Arrange
    LockingClassLoaderGroup lockingClassLoaderGroup =
        new LockingClassLoaderGroup(
            new LockingClassLoaderGroup(new GlobalPluginClassLoaderGroup()));
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader requester = mock(PaperPluginClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(
            requester.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualClassByName = lockingClassLoaderGroup.getClassByName("Name", true, requester);

    // Assert
    verify(requester).loadClass("Name", false, false, true);
    Class<Object> expectedClassByName = Object.class;
    assertEquals(expectedClassByName, actualClassByName);
  }

  /**
   * Test {@link LockingClassLoaderGroup#add(ConfiguredPluginClassLoader)}.
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#add(ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName("Test add(ConfiguredPluginClassLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LockingClassLoaderGroup.add(ConfiguredPluginClassLoader)"})
  void testAdd() {
    // Arrange
    LockingClassLoaderGroup lockingClassLoaderGroup =
        new LockingClassLoaderGroup(new GlobalPluginClassLoaderGroup());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    lockingClassLoaderGroup.add(null);

    // Assert
    PluginClassLoaderGroup parent = lockingClassLoaderGroup.getParent();
    assertTrue(parent instanceof GlobalPluginClassLoaderGroup);
    List<ConfiguredPluginClassLoader> classLoaders =
        ((GlobalPluginClassLoaderGroup) parent).getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
  }

  /**
   * Test {@link LockingClassLoaderGroup#add(ConfiguredPluginClassLoader)}.
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#add(ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName("Test add(ConfiguredPluginClassLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LockingClassLoaderGroup.add(ConfiguredPluginClassLoader)"})
  void testAdd2() {
    // Arrange
    LockingClassLoaderGroup lockingClassLoaderGroup =
        new LockingClassLoaderGroup(
            new LockingClassLoaderGroup(new GlobalPluginClassLoaderGroup()));
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    lockingClassLoaderGroup.add(null);

    // Assert
    PluginClassLoaderGroup parent = lockingClassLoaderGroup.getParent();
    PluginClassLoaderGroup parent2 = ((LockingClassLoaderGroup) parent).getParent();
    assertTrue(parent2 instanceof GlobalPluginClassLoaderGroup);
    assertTrue(parent instanceof LockingClassLoaderGroup);
    List<ConfiguredPluginClassLoader> classLoaders =
        ((GlobalPluginClassLoaderGroup) parent2).getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
  }

  /**
   * Test {@link LockingClassLoaderGroup#getAccess()}.
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#getAccess()}
   */
  @Test
  @DisplayName("Test getAccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassLoaderAccess LockingClassLoaderGroup.getAccess()"})
  void testGetAccess() {
    // Arrange
    GlobalPluginClassLoaderGroup parent = new GlobalPluginClassLoaderGroup();
    LockingClassLoaderGroup lockingClassLoaderGroup = new LockingClassLoaderGroup(parent);

    // Act
    lockingClassLoaderGroup.getAccess();

    // Assert that nothing has changed
    PluginClassLoaderGroup parent2 = lockingClassLoaderGroup.getParent();
    assertTrue(parent2 instanceof GlobalPluginClassLoaderGroup);
    assertTrue(((GlobalPluginClassLoaderGroup) parent2).getClassLoaders().isEmpty());
    assertSame(parent, parent2);
  }

  /**
   * Test {@link LockingClassLoaderGroup#getAccess()}.
   *
   * <ul>
   *   <li>Given {@link ClassLoaderAccess} {@link
   *       ClassLoaderAccess#canAccess(ConfiguredPluginClassLoader)} return {@code true}.
   *   <li>Then return canAccess {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#getAccess()}
   */
  @Test
  @DisplayName(
      "Test getAccess(); given ClassLoaderAccess canAccess(ConfiguredPluginClassLoader) return 'true'; then return canAccess 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassLoaderAccess LockingClassLoaderGroup.getAccess()"})
  void testGetAccess_givenClassLoaderAccessCanAccessReturnTrue_thenReturnCanAccessNull() {
    // Arrange
    ClassLoaderAccess classLoaderAccess = mock(ClassLoaderAccess.class);
    when(classLoaderAccess.canAccess(Mockito.<ConfiguredPluginClassLoader>any())).thenReturn(true);

    DependencyBasedPluginClassLoaderGroup parent =
        mock(DependencyBasedPluginClassLoaderGroup.class);
    when(parent.getAccess()).thenReturn(classLoaderAccess);
    LockingClassLoaderGroup parent2 = new LockingClassLoaderGroup(parent);
    LockingClassLoaderGroup lockingClassLoaderGroup = new LockingClassLoaderGroup(parent2);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    boolean actualCanAccessResult = lockingClassLoaderGroup.getAccess().canAccess(null);

    // Assert
    verify(parent).getAccess();
    verify(classLoaderAccess).canAccess(isNull());
    PluginClassLoaderGroup parent3 = lockingClassLoaderGroup.getParent();
    assertTrue(parent3 instanceof LockingClassLoaderGroup);
    assertNull(null);
    assertTrue(actualCanAccessResult);
    assertSame(parent2, parent3);
  }

  /**
   * Test {@link LockingClassLoaderGroup#getAccess()}.
   *
   * <ul>
   *   <li>Then return not canAccess {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LockingClassLoaderGroup#getAccess()}
   */
  @Test
  @DisplayName("Test getAccess(); then return not canAccess 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassLoaderAccess LockingClassLoaderGroup.getAccess()"})
  void testGetAccess_thenReturnNotCanAccessNull() {
    // Arrange
    ClassLoaderAccess classLoaderAccess = mock(ClassLoaderAccess.class);
    when(classLoaderAccess.canAccess(Mockito.<ConfiguredPluginClassLoader>any())).thenReturn(false);

    DependencyBasedPluginClassLoaderGroup parent =
        mock(DependencyBasedPluginClassLoaderGroup.class);
    when(parent.getAccess()).thenReturn(classLoaderAccess);
    LockingClassLoaderGroup parent2 = new LockingClassLoaderGroup(parent);
    LockingClassLoaderGroup lockingClassLoaderGroup = new LockingClassLoaderGroup(parent2);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    boolean actualCanAccessResult = lockingClassLoaderGroup.getAccess().canAccess(null);

    // Assert
    verify(parent).getAccess();
    verify(classLoaderAccess).canAccess(isNull());
    PluginClassLoaderGroup parent3 = lockingClassLoaderGroup.getParent();
    assertTrue(parent3 instanceof LockingClassLoaderGroup);
    assertNull(null);
    assertFalse(actualCanAccessResult);
    assertSame(parent2, parent3);
  }
}
