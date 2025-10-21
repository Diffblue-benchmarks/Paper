package io.papermc.paper.plugin.loader.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LibraryLoadingExceptionDiffblueTest {
  /**
   * Test {@link LibraryLoadingException#LibraryLoadingException(String, Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return Cause is {@link Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryLoadingException#LibraryLoadingException(String,
   * Exception)}
   */
  @Test
  @DisplayName(
      "Test new LibraryLoadingException(String, Exception); when Exception(); then return Cause is Exception()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LibraryLoadingException.<init>(String)",
    "void LibraryLoadingException.<init>(String, Exception)"
  })
  void testNewLibraryLoadingException_whenException_thenReturnCauseIsException() {
    // Arrange
    Exception e = new Exception();

    // Act
    LibraryLoadingException actualLibraryLoadingException = new LibraryLoadingException("foo", e);

    // Assert
    assertEquals("foo", actualLibraryLoadingException.getMessage());
    assertEquals(0, actualLibraryLoadingException.getSuppressed().length);
    assertSame(e, actualLibraryLoadingException.getCause());
  }

  /**
   * Test {@link LibraryLoadingException#LibraryLoadingException(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryLoadingException#LibraryLoadingException(String)}
   */
  @Test
  @DisplayName("Test new LibraryLoadingException(String); when 'foo'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LibraryLoadingException.<init>(String)",
    "void LibraryLoadingException.<init>(String, Exception)"
  })
  void testNewLibraryLoadingException_whenFoo_thenReturnCauseIsNull() {
    // Arrange and Act
    LibraryLoadingException actualLibraryLoadingException = new LibraryLoadingException("foo");

    // Assert
    assertEquals("foo", actualLibraryLoadingException.getMessage());
    assertNull(actualLibraryLoadingException.getCause());
    assertEquals(0, actualLibraryLoadingException.getSuppressed().length);
  }
}
