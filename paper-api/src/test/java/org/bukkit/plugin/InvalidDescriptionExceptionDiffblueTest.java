package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvalidDescriptionExceptionDiffblueTest {
  /**
   * Test {@link InvalidDescriptionException#InvalidDescriptionException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidDescriptionException#InvalidDescriptionException(String)}
   */
  @Test
  @DisplayName(
      "Test new InvalidDescriptionException(String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidDescriptionException.<init>()",
    "void InvalidDescriptionException.<init>(String)",
    "void InvalidDescriptionException.<init>(Throwable)",
    "void InvalidDescriptionException.<init>(Throwable, String)"
  })
  void testNewInvalidDescriptionException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    InvalidDescriptionException actualInvalidDescriptionException =
        new InvalidDescriptionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidDescriptionException.getMessage());
    assertNull(actualInvalidDescriptionException.getCause());
    assertEquals(0, actualInvalidDescriptionException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidDescriptionException#InvalidDescriptionException(Throwable, String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidDescriptionException#InvalidDescriptionException(Throwable,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new InvalidDescriptionException(Throwable, String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidDescriptionException.<init>()",
    "void InvalidDescriptionException.<init>(String)",
    "void InvalidDescriptionException.<init>(Throwable)",
    "void InvalidDescriptionException.<init>(Throwable, String)"
  })
  void testNewInvalidDescriptionException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidDescriptionException actualInvalidDescriptionException =
        new InvalidDescriptionException(cause, "An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidDescriptionException.getMessage());
    assertEquals(0, actualInvalidDescriptionException.getSuppressed().length);
    assertSame(cause, actualInvalidDescriptionException.getCause());
  }

  /**
   * Test {@link InvalidDescriptionException#InvalidDescriptionException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code Invalid plugin.yml}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidDescriptionException#InvalidDescriptionException()}
   */
  @Test
  @DisplayName(
      "Test new InvalidDescriptionException(); then return Message is 'Invalid plugin.yml'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidDescriptionException.<init>()",
    "void InvalidDescriptionException.<init>(String)",
    "void InvalidDescriptionException.<init>(Throwable)",
    "void InvalidDescriptionException.<init>(Throwable, String)"
  })
  void testNewInvalidDescriptionException_thenReturnMessageIsInvalidPluginYml() {
    // Arrange and Act
    InvalidDescriptionException actualInvalidDescriptionException =
        new InvalidDescriptionException();

    // Assert
    assertEquals("Invalid plugin.yml", actualInvalidDescriptionException.getMessage());
    assertNull(actualInvalidDescriptionException.getCause());
    assertEquals(0, actualInvalidDescriptionException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidDescriptionException#InvalidDescriptionException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Invalid plugin.yml}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvalidDescriptionException#InvalidDescriptionException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new InvalidDescriptionException(Throwable); then return Message is 'Invalid plugin.yml'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidDescriptionException.<init>()",
    "void InvalidDescriptionException.<init>(String)",
    "void InvalidDescriptionException.<init>(Throwable)",
    "void InvalidDescriptionException.<init>(Throwable, String)"
  })
  void testNewInvalidDescriptionException_thenReturnMessageIsInvalidPluginYml2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidDescriptionException actualInvalidDescriptionException =
        new InvalidDescriptionException(cause);

    // Assert
    assertEquals("Invalid plugin.yml", actualInvalidDescriptionException.getMessage());
    assertEquals(0, actualInvalidDescriptionException.getSuppressed().length);
    assertSame(cause, actualInvalidDescriptionException.getCause());
  }
}
