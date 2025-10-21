package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerExceptionDiffblueTest {
  /**
   * Test {@link ServerException#ServerException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ServerException#ServerException(String)}
   */
  @Test
  @DisplayName(
      "Test new ServerException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerException.<init>(String)",
    "void ServerException.<init>(String, Throwable)",
    "void ServerException.<init>(String, Throwable, boolean, boolean)",
    "void ServerException.<init>(Throwable)"
  })
  void testNewServerException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ServerException actualServerException = new ServerException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualServerException.getMessage());
    assertNull(actualServerException.getCause());
    assertEquals(0, actualServerException.getSuppressed().length);
  }

  /**
   * Test {@link ServerException#ServerException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerException#ServerException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ServerException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerException.<init>(String)",
    "void ServerException.<init>(String, Throwable)",
    "void ServerException.<init>(String, Throwable, boolean, boolean)",
    "void ServerException.<init>(Throwable)"
  })
  void testNewServerException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServerException actualServerException = new ServerException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualServerException.getMessage());
    assertEquals(0, actualServerException.getSuppressed().length);
    assertSame(cause, actualServerException.getCause());
  }

  /**
   * Test {@link ServerException#ServerException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ServerException#ServerException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ServerException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerException.<init>(String)",
    "void ServerException.<init>(String, Throwable)",
    "void ServerException.<init>(String, Throwable, boolean, boolean)",
    "void ServerException.<init>(Throwable)"
  })
  void testNewServerException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServerException actualServerException = new ServerException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualServerException.getMessage());
    assertEquals(0, actualServerException.getSuppressed().length);
    assertSame(cause, actualServerException.getCause());
  }

  /**
   * Test {@link ServerException#ServerException(String, Throwable, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerException#ServerException(String, Throwable, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new ServerException(String, Throwable, boolean, boolean); when 'true'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerException.<init>(String)",
    "void ServerException.<init>(String, Throwable)",
    "void ServerException.<init>(String, Throwable, boolean, boolean)",
    "void ServerException.<init>(Throwable)"
  })
  void testNewServerException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServerException actualServerException =
        new ServerException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualServerException.getMessage());
    assertEquals(0, actualServerException.getSuppressed().length);
    assertSame(cause, actualServerException.getCause());
  }
}
