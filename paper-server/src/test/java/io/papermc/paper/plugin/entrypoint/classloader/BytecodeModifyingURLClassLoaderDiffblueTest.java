package io.papermc.paper.plugin.entrypoint.classloader;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BytecodeModifyingURLClassLoaderDiffblueTest {
  /**
   * Test {@link BytecodeModifyingURLClassLoader#BytecodeModifyingURLClassLoader(URL[], ClassLoader,
   * Function)}.
   *
   * <p>Method under test: {@link
   * BytecodeModifyingURLClassLoader#BytecodeModifyingURLClassLoader(URL[], ClassLoader, Function)}
   */
  @Test
  @DisplayName("Test new BytecodeModifyingURLClassLoader(URL[], ClassLoader, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BytecodeModifyingURLClassLoader.<init>(URL[], ClassLoader, Function)"})
  void testNewBytecodeModifyingURLClassLoader() throws MalformedURLException {
    // Arrange
    URL[] urls =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    URLClassLoader parent = new URLClassLoader(urlArray);

    // Act
    BytecodeModifyingURLClassLoader actualBytecodeModifyingURLClassLoader =
        new BytecodeModifyingURLClassLoader(urls, parent, mock(Function.class));

    // Assert
    assertNotNull(actualBytecodeModifyingURLClassLoader);
  }

  /**
   * Test {@link BytecodeModifyingURLClassLoader#BytecodeModifyingURLClassLoader(URL[],
   * ClassLoader)}.
   *
   * <p>Method under test: {@link
   * BytecodeModifyingURLClassLoader#BytecodeModifyingURLClassLoader(URL[], ClassLoader)}
   */
  @Test
  @DisplayName("Test new BytecodeModifyingURLClassLoader(URL[], ClassLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BytecodeModifyingURLClassLoader.<init>(URL[], ClassLoader)"})
  void testNewBytecodeModifyingURLClassLoader2() throws MalformedURLException {
    // Arrange
    URL[] urls =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    URLClassLoader parent = new URLClassLoader(urlArray);

    // Act
    BytecodeModifyingURLClassLoader actualBytecodeModifyingURLClassLoader =
        new BytecodeModifyingURLClassLoader(urls, parent);

    // Assert
    assertNotNull(actualBytecodeModifyingURLClassLoader);
  }

  /**
   * Test {@link BytecodeModifyingURLClassLoader#findClass(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link ClassNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link BytecodeModifyingURLClassLoader#findClass(String)}
   */
  @Test
  @DisplayName("Test findClass(String) with 'String'; then throw ClassNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class BytecodeModifyingURLClassLoader.findClass(String)"})
  void testFindClassWithString_thenThrowClassNotFoundException()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    URL[] urls =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    URL[] urlArray =
        new URL[] {Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()};
    URLClassLoader parent = new URLClassLoader(urlArray);

    BytecodeModifyingURLClassLoader bytecodeModifyingURLClassLoader =
        new BytecodeModifyingURLClassLoader(urls, parent);

    // Act and Assert
    assertThrows(
        ClassNotFoundException.class,
        () -> bytecodeModifyingURLClassLoader.findClass("https://example.org/example"));
  }
}
