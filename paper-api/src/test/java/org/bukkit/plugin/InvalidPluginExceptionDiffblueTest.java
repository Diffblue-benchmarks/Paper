package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvalidPluginExceptionDiffblueTest {
  /**
   * Test {@link InvalidPluginException#InvalidPluginException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidPluginException#InvalidPluginException(String)}
   */
  @Test
  @DisplayName(
      "Test new InvalidPluginException(String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidPluginException.<init>()",
    "void InvalidPluginException.<init>(String)",
    "void InvalidPluginException.<init>(String, Throwable)",
    "void InvalidPluginException.<init>(Throwable)"
  })
  void testNewInvalidPluginException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    InvalidPluginException actualInvalidPluginException =
        new InvalidPluginException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidPluginException.getMessage());
    assertNull(actualInvalidPluginException.getCause());
    assertEquals(0, actualInvalidPluginException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidPluginException#InvalidPluginException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidPluginException#InvalidPluginException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new InvalidPluginException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidPluginException.<init>()",
    "void InvalidPluginException.<init>(String)",
    "void InvalidPluginException.<init>(String, Throwable)",
    "void InvalidPluginException.<init>(Throwable)"
  })
  void testNewInvalidPluginException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidPluginException actualInvalidPluginException =
        new InvalidPluginException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualInvalidPluginException.getMessage());
    assertEquals(0, actualInvalidPluginException.getSuppressed().length);
    assertSame(cause, actualInvalidPluginException.getCause());
  }

  /**
   * Test {@link InvalidPluginException#InvalidPluginException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidPluginException#InvalidPluginException()}
   */
  @Test
  @DisplayName("Test new InvalidPluginException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidPluginException.<init>()",
    "void InvalidPluginException.<init>(String)",
    "void InvalidPluginException.<init>(String, Throwable)",
    "void InvalidPluginException.<init>(Throwable)"
  })
  void testNewInvalidPluginException_thenReturnMessageIsNull() {
    // Arrange and Act
    InvalidPluginException actualInvalidPluginException = new InvalidPluginException();

    // Assert
    assertNull(actualInvalidPluginException.getMessage());
    assertNull(actualInvalidPluginException.getCause());
    assertEquals(0, actualInvalidPluginException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidPluginException#InvalidPluginException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidPluginException#InvalidPluginException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new InvalidPluginException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidPluginException.<init>()",
    "void InvalidPluginException.<init>(String)",
    "void InvalidPluginException.<init>(String, Throwable)",
    "void InvalidPluginException.<init>(Throwable)"
  })
  void testNewInvalidPluginException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidPluginException actualInvalidPluginException = new InvalidPluginException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInvalidPluginException.getMessage());
    assertEquals(0, actualInvalidPluginException.getSuppressed().length);
    assertSame(cause, actualInvalidPluginException.getCause());
  }
}
