package org.bukkit.plugin.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReservedChannelExceptionDiffblueTest {
  /**
   * Test {@link ReservedChannelException#ReservedChannelException()}.
   *
   * <p>Method under test: {@link ReservedChannelException#ReservedChannelException()}
   */
  @Test
  @DisplayName("Test new ReservedChannelException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReservedChannelException.<init>()"})
  void testNewReservedChannelException() {
    // Arrange and Act
    ReservedChannelException actualReservedChannelException = new ReservedChannelException();

    // Assert
    assertEquals(
        "Attempted to register for a reserved channel name ('Attempted to register for a reserved channel"
            + " name.')",
        actualReservedChannelException.getLocalizedMessage());
    assertEquals(
        "Attempted to register for a reserved channel name ('Attempted to register for a reserved channel"
            + " name.')",
        actualReservedChannelException.getMessage());
    assertNull(actualReservedChannelException.getCause());
    assertEquals(0, actualReservedChannelException.getSuppressed().length);
  }

  /**
   * Test {@link ReservedChannelException#ReservedChannelException(String)}.
   *
   * <p>Method under test: {@link ReservedChannelException#ReservedChannelException(String)}
   */
  @Test
  @DisplayName("Test new ReservedChannelException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReservedChannelException.<init>(String)"})
  void testNewReservedChannelException2() {
    // Arrange and Act
    ReservedChannelException actualReservedChannelException = new ReservedChannelException("Name");

    // Assert
    assertEquals(
        "Attempted to register for a reserved channel name ('Name')",
        actualReservedChannelException.getLocalizedMessage());
    assertEquals(
        "Attempted to register for a reserved channel name ('Name')",
        actualReservedChannelException.getMessage());
    assertNull(actualReservedChannelException.getCause());
    assertEquals(0, actualReservedChannelException.getSuppressed().length);
  }
}
