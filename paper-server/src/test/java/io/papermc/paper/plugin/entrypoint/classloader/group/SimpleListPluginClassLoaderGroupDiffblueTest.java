package io.papermc.paper.plugin.entrypoint.classloader.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.entrypoint.classloader.PaperPluginClassLoader;
import io.papermc.paper.plugin.provider.classloader.ConfiguredPluginClassLoader;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleListPluginClassLoaderGroupDiffblueTest {
  /**
   * Test {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName("Test getClassByName(String, boolean, ConfiguredPluginClassLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class SimpleListPluginClassLoaderGroup.getClassByName(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testGetClassByName() throws ClassNotFoundException {
    // Arrange
    PaperPluginClassLoader configuredPluginClassLoader = mock(PaperPluginClassLoader.class);
    Mockito.<Class<?>>when(
            configuredPluginClassLoader.loadClass(
                Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new ClassNotFoundException());

    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    globalPluginClassLoaderGroup.add(configuredPluginClassLoader);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader requester = mock(PaperPluginClassLoader.class);
    Mockito.<Class<?>>when(
            requester.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new ClassNotFoundException());

    // Act
    Class<?> actualClassByName =
        globalPluginClassLoaderGroup.getClassByName("Name", true, requester);

    // Assert
    verify(requester).loadClass("Name", false, false, true);
    verify(configuredPluginClassLoader).loadClass("Name", true, false, true);
    assertNull(actualClassByName);
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link GlobalPluginClassLoaderGroup} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test getClassByName(String, boolean, ConfiguredPluginClassLoader); given GlobalPluginClassLoaderGroup (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class SimpleListPluginClassLoaderGroup.getClassByName(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testGetClassByName_givenGlobalPluginClassLoaderGroup_thenReturnNull()
      throws ClassNotFoundException {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader requester = mock(PaperPluginClassLoader.class);
    Mockito.<Class<?>>when(
            requester.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new ClassNotFoundException());

    // Act
    Class<?> actualClassByName =
        globalPluginClassLoaderGroup.getClassByName("Name", true, requester);

    // Assert
    verify(requester).loadClass("Name", false, false, true);
    assertNull(actualClassByName);
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When {@link PaperPluginClassLoader} {@link PaperPluginClassLoader#loadClass(String,
   *       boolean, boolean, boolean)} return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test getClassByName(String, boolean, ConfiguredPluginClassLoader); given Object; when PaperPluginClassLoader loadClass(String, boolean, boolean, boolean) return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class SimpleListPluginClassLoaderGroup.getClassByName(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testGetClassByName_givenObject_whenPaperPluginClassLoaderLoadClassReturnObject()
      throws ClassNotFoundException {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader requester = mock(PaperPluginClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(
            requester.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualClassByName =
        globalPluginClassLoaderGroup.getClassByName("Name", true, requester);

    // Assert
    verify(requester).loadClass("Name", false, false, true);
    Class<Object> expectedClassByName = Object.class;
    assertEquals(expectedClassByName, actualClassByName);
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link PaperPluginClassLoader} {@link PaperPluginClassLoader#loadClass(String,
   *       boolean, boolean, boolean)} return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#getClassByName(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test getClassByName(String, boolean, ConfiguredPluginClassLoader); given PaperPluginClassLoader loadClass(String, boolean, boolean, boolean) return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class SimpleListPluginClassLoaderGroup.getClassByName(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testGetClassByName_givenPaperPluginClassLoaderLoadClassReturnObject()
      throws ClassNotFoundException {
    // Arrange
    PaperPluginClassLoader configuredPluginClassLoader = mock(PaperPluginClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(
            configuredPluginClassLoader.loadClass(
                Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(forNameResult);

    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    globalPluginClassLoaderGroup.add(configuredPluginClassLoader);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader requester = mock(PaperPluginClassLoader.class);
    Mockito.<Class<?>>when(
            requester.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new ClassNotFoundException());

    // Act
    Class<?> actualClassByName =
        globalPluginClassLoaderGroup.getClassByName("Name", true, requester);

    // Assert
    verify(requester).loadClass("Name", false, false, true);
    verify(configuredPluginClassLoader).loadClass("Name", true, false, true);
    Class<Object> expectedClassByName = Object.class;
    assertEquals(expectedClassByName, actualClassByName);
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#lookupClass(String, boolean,
   * ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#lookupClass(String, boolean,
   * ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test lookupClass(String, boolean, ConfiguredPluginClassLoader); given 'java.lang.Object'; then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class SimpleListPluginClassLoaderGroup.lookupClass(String, boolean, ConfiguredPluginClassLoader)"
  })
  void testLookupClass_givenJavaLangObject_thenReturnObject() throws ClassNotFoundException {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    PaperPluginClassLoader current = mock(PaperPluginClassLoader.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(
            current.loadClass(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualLookupClassResult =
        globalPluginClassLoaderGroup.lookupClass("Name", true, current);

    // Assert
    verify(current).loadClass("Name", true, false, true);
    Class<Object> expectedLookupClassResult = Object.class;
    assertEquals(expectedLookupClassResult, actualLookupClassResult);
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#add(ConfiguredPluginClassLoader)}.
   *
   * <ul>
   *   <li>Then {@link GlobalPluginClassLoaderGroup} (default constructor) ClassLoaders size is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#add(ConfiguredPluginClassLoader)}
   */
  @Test
  @DisplayName(
      "Test add(ConfiguredPluginClassLoader); then GlobalPluginClassLoaderGroup (default constructor) ClassLoaders size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleListPluginClassLoaderGroup.add(ConfiguredPluginClassLoader)"})
  void testAdd_thenGlobalPluginClassLoaderGroupClassLoadersSizeIsOne() {
    // Arrange
    GlobalPluginClassLoaderGroup globalPluginClassLoaderGroup = new GlobalPluginClassLoaderGroup();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    globalPluginClassLoaderGroup.add(null);

    // Assert
    List<ConfiguredPluginClassLoader> classLoaders = globalPluginClassLoaderGroup.getClassLoaders();
    assertEquals(1, classLoaders.size());
    assertNull(classLoaders.get(0));
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#getClassLoaders()}.
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#getClassLoaders()}
   */
  @Test
  @DisplayName("Test getClassLoaders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SimpleListPluginClassLoaderGroup.getClassLoaders()"})
  void testGetClassLoaders() {
    // Arrange, Act and Assert
    assertTrue(new GlobalPluginClassLoaderGroup().getClassLoaders().isEmpty());
  }

  /**
   * Test {@link SimpleListPluginClassLoaderGroup#toString()}.
   *
   * <p>Method under test: {@link SimpleListPluginClassLoaderGroup#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleListPluginClassLoaderGroup.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "GLOBAL:SimpleListPluginClassLoaderGroup{classloaders=[]}",
        new GlobalPluginClassLoaderGroup().toString());
  }
}
