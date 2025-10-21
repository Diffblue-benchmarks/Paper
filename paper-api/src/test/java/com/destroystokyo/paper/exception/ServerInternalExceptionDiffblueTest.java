package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerInternalExceptionDiffblueTest {
  /**
   * Test {@link ServerInternalException#ServerInternalException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInternalException#ServerInternalException(String,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ServerInternalException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerInternalException.<init>(String)",
    "void ServerInternalException.<init>(String, Throwable)",
    "void ServerInternalException.<init>(String, Throwable, boolean, boolean)",
    "void ServerInternalException.<init>(Throwable)"
  })
  void testNewServerInternalException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServerInternalException actualServerInternalException =
        new ServerInternalException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualServerInternalException.getMessage());
    assertEquals(0, actualServerInternalException.getSuppressed().length);
    assertSame(cause, actualServerInternalException.getCause());
  }

  /**
   * Test {@link ServerInternalException#ServerInternalException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInternalException#ServerInternalException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ServerInternalException(Throwable); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerInternalException.<init>(String)",
    "void ServerInternalException.<init>(String, Throwable)",
    "void ServerInternalException.<init>(String, Throwable, boolean, boolean)",
    "void ServerInternalException.<init>(Throwable)"
  })
  void testNewServerInternalException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServerInternalException actualServerInternalException = new ServerInternalException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualServerInternalException.getMessage());
    assertEquals(0, actualServerInternalException.getSuppressed().length);
    assertSame(cause, actualServerInternalException.getCause());
  }

  /**
   * Test {@link ServerInternalException#ServerInternalException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInternalException#ServerInternalException(String)}
   */
  @Test
  @DisplayName(
      "Test new ServerInternalException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerInternalException.<init>(String)",
    "void ServerInternalException.<init>(String, Throwable)",
    "void ServerInternalException.<init>(String, Throwable, boolean, boolean)",
    "void ServerInternalException.<init>(Throwable)"
  })
  void testNewServerInternalException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ServerInternalException actualServerInternalException =
        new ServerInternalException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualServerInternalException.getMessage());
    assertNull(actualServerInternalException.getCause());
    assertEquals(0, actualServerInternalException.getSuppressed().length);
  }

  /**
   * Test {@link ServerInternalException#ServerInternalException(String, Throwable, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerInternalException#ServerInternalException(String, Throwable,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ServerInternalException(String, Throwable, boolean, boolean); when 'true'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerInternalException.<init>(String)",
    "void ServerInternalException.<init>(String, Throwable)",
    "void ServerInternalException.<init>(String, Throwable, boolean, boolean)",
    "void ServerInternalException.<init>(Throwable)"
  })
  void testNewServerInternalException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServerInternalException actualServerInternalException =
        new ServerInternalException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualServerInternalException.getMessage());
    assertEquals(0, actualServerInternalException.getSuppressed().length);
    assertSame(cause, actualServerInternalException.getCause());
  }
}
