package io.papermc.paper.plugin.loader.library.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.loader.library.LibraryLoadingException;
import io.papermc.paper.plugin.loader.library.LibraryStore;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JarLibraryDiffblueTest {
  /**
   * Test {@link JarLibrary#register(LibraryStore)}.
   *
   * <ul>
   *   <li>Given {@link JarLibrary#JarLibrary(Path)} with path is Property is {@code java.io.tmpdir}
   *       is {@code foo} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JarLibrary#register(LibraryStore)}
   */
  @Test
  @DisplayName(
      "Test register(LibraryStore); given JarLibrary(Path) with path is Property is 'java.io.tmpdir' is 'foo' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JarLibrary.register(LibraryStore)"})
  void testRegister_givenJarLibraryWithPathIsPropertyIsJavaIoTmpdirIsFooAnd42()
      throws LibraryLoadingException {
    // Arrange
    Path path = Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42", "foo");

    // Act and Assert
    assertThrows(
        LibraryLoadingException.class,
        () -> new JarLibrary(path).register(mock(LibraryStore.class)));
  }

  /**
   * Test {@link JarLibrary#register(LibraryStore)}.
   *
   * <ul>
   *   <li>Given {@link LibraryLoadingException#LibraryLoadingException(String)} with s is {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link JarLibrary#register(LibraryStore)}
   */
  @Test
  @DisplayName("Test register(LibraryStore); given LibraryLoadingException(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JarLibrary.register(LibraryStore)"})
  void testRegister_givenLibraryLoadingExceptionWithSIsFoo() throws LibraryLoadingException {
    // Arrange
    Path path = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    JarLibrary jarLibrary = new JarLibrary(path);

    LibraryStore store = mock(LibraryStore.class);
    doThrow(new LibraryLoadingException("foo")).when(store).addLibrary(Mockito.<Path>any());

    // Act and Assert
    assertThrows(LibraryLoadingException.class, () -> jarLibrary.register(store));
    verify(store).addLibrary(isA(Path.class));
  }

  /**
   * Test {@link JarLibrary#register(LibraryStore)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryStore#addLibrary(Path)}.
   * </ul>
   *
   * <p>Method under test: {@link JarLibrary#register(LibraryStore)}
   */
  @Test
  @DisplayName("Test register(LibraryStore); then calls addLibrary(Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JarLibrary.register(LibraryStore)"})
  void testRegister_thenCallsAddLibrary() throws LibraryLoadingException {
    // Arrange
    Path path = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    JarLibrary jarLibrary = new JarLibrary(path);

    LibraryStore store = mock(LibraryStore.class);
    doNothing().when(store).addLibrary(Mockito.<Path>any());

    // Act
    jarLibrary.register(store);

    // Assert
    verify(store).addLibrary(isA(Path.class));
  }
}
