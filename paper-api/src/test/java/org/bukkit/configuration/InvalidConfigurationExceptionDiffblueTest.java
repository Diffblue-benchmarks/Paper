package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvalidConfigurationExceptionDiffblueTest {
  /**
   * Test {@link InvalidConfigurationException#InvalidConfigurationException(Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvalidConfigurationException#InvalidConfigurationException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new InvalidConfigurationException(Throwable); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidConfigurationException.<init>()",
    "void InvalidConfigurationException.<init>(String)",
    "void InvalidConfigurationException.<init>(String, Throwable)",
    "void InvalidConfigurationException.<init>(Throwable)"
  })
  void testNewInvalidConfigurationException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidConfigurationException actualInvalidConfigurationException =
        new InvalidConfigurationException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualInvalidConfigurationException.getMessage());
    assertEquals(0, actualInvalidConfigurationException.getSuppressed().length);
    assertSame(cause, actualInvalidConfigurationException.getCause());
  }

  /**
   * Test {@link InvalidConfigurationException#InvalidConfigurationException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvalidConfigurationException#InvalidConfigurationException()}
   */
  @Test
  @DisplayName("Test new InvalidConfigurationException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidConfigurationException.<init>()",
    "void InvalidConfigurationException.<init>(String)",
    "void InvalidConfigurationException.<init>(String, Throwable)",
    "void InvalidConfigurationException.<init>(Throwable)"
  })
  void testNewInvalidConfigurationException_thenReturnMessageIsNull() {
    // Arrange and Act
    InvalidConfigurationException actualInvalidConfigurationException =
        new InvalidConfigurationException();

    // Assert
    assertNull(actualInvalidConfigurationException.getMessage());
    assertNull(actualInvalidConfigurationException.getCause());
    assertEquals(0, actualInvalidConfigurationException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidConfigurationException#InvalidConfigurationException(String)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Message is {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvalidConfigurationException#InvalidConfigurationException(String)}
   */
  @Test
  @DisplayName(
      "Test new InvalidConfigurationException(String); when 'Msg'; then return Message is 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidConfigurationException.<init>()",
    "void InvalidConfigurationException.<init>(String)",
    "void InvalidConfigurationException.<init>(String, Throwable)",
    "void InvalidConfigurationException.<init>(Throwable)"
  })
  void testNewInvalidConfigurationException_whenMsg_thenReturnMessageIsMsg() {
    // Arrange and Act
    InvalidConfigurationException actualInvalidConfigurationException =
        new InvalidConfigurationException("Msg");

    // Assert
    assertEquals("Msg", actualInvalidConfigurationException.getMessage());
    assertNull(actualInvalidConfigurationException.getCause());
    assertEquals(0, actualInvalidConfigurationException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidConfigurationException#InvalidConfigurationException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Message is {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvalidConfigurationException#InvalidConfigurationException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new InvalidConfigurationException(String, Throwable); when 'Msg'; then return Message is 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvalidConfigurationException.<init>()",
    "void InvalidConfigurationException.<init>(String)",
    "void InvalidConfigurationException.<init>(String, Throwable)",
    "void InvalidConfigurationException.<init>(Throwable)"
  })
  void testNewInvalidConfigurationException_whenMsg_thenReturnMessageIsMsg2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InvalidConfigurationException actualInvalidConfigurationException =
        new InvalidConfigurationException("Msg", cause);

    // Assert
    assertEquals("Msg", actualInvalidConfigurationException.getMessage());
    assertEquals(0, actualInvalidConfigurationException.getSuppressed().length);
    assertSame(cause, actualInvalidConfigurationException.getCause());
  }
}
