package org.bukkit.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventException#EventException()}
   *   <li>{@link EventException#getCause()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EventException.<init>()",
    "void EventException.<init>(String)",
    "void EventException.<init>(Throwable)",
    "void EventException.<init>(Throwable, String)",
    "Throwable EventException.getCause()"
  })
  void testGettersAndSetters_thenReturnMessageIsNull() {
    // Arrange and Act
    EventException actualEventException = new EventException();
    Throwable actualCause = actualEventException.getCause();

    // Assert
    assertNull(actualEventException.getMessage());
    assertNull(actualCause);
    assertEquals(0, actualEventException.getSuppressed().length);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventException#EventException(String)}
   *   <li>{@link EventException#getCause()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EventException.<init>()",
    "void EventException.<init>(String)",
    "void EventException.<init>(Throwable)",
    "void EventException.<init>(Throwable, String)",
    "Throwable EventException.getCause()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    EventException actualEventException = new EventException("An error occurred");
    Throwable actualCause = actualEventException.getCause();

    // Assert
    assertEquals("An error occurred", actualEventException.getMessage());
    assertNull(actualCause);
    assertEquals(0, actualEventException.getSuppressed().length);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventException#EventException(Throwable, String)}
   *   <li>{@link EventException#getCause()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when Throwable(); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EventException.<init>()",
    "void EventException.<init>(String)",
    "void EventException.<init>(Throwable)",
    "void EventException.<init>(Throwable, String)",
    "Throwable EventException.getCause()"
  })
  void testGettersAndSetters_whenThrowable_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EventException actualEventException = new EventException(cause, "An error occurred");
    Throwable actualCause = actualEventException.getCause();

    // Assert
    assertEquals("An error occurred", actualEventException.getMessage());
    assertEquals(0, actualEventException.getSuppressed().length);
    assertSame(cause, actualCause);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventException#EventException(Throwable)}
   *   <li>{@link EventException#getCause()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EventException.<init>()",
    "void EventException.<init>(String)",
    "void EventException.<init>(Throwable)",
    "void EventException.<init>(Throwable, String)",
    "Throwable EventException.getCause()"
  })
  void testGettersAndSetters_whenThrowable_thenReturnMessageIsNull() {
    // Arrange
    Throwable throwable = new Throwable();

    // Act
    EventException actualEventException = new EventException(throwable);
    Throwable actualCause = actualEventException.getCause();

    // Assert
    assertNull(actualEventException.getMessage());
    assertEquals(0, actualEventException.getSuppressed().length);
    assertSame(throwable, actualCause);
  }
}
