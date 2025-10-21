package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuthorNagExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuthorNagException#AuthorNagException(String)}
   *   <li>{@link AuthorNagException#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthorNagException.<init>(String)",
    "String AuthorNagException.getMessage()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AuthorNagException actualAuthorNagException = new AuthorNagException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAuthorNagException.getMessage());
    assertNull(actualAuthorNagException.getCause());
    assertEquals(0, actualAuthorNagException.getSuppressed().length);
  }
}
