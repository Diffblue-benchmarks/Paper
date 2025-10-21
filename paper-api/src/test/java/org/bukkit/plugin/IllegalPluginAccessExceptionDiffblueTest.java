package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IllegalPluginAccessExceptionDiffblueTest {
  /**
   * Test {@link IllegalPluginAccessException#IllegalPluginAccessException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IllegalPluginAccessException#IllegalPluginAccessException()}
   */
  @Test
  @DisplayName("Test new IllegalPluginAccessException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IllegalPluginAccessException.<init>()",
    "void IllegalPluginAccessException.<init>(String)"
  })
  void testNewIllegalPluginAccessException_thenReturnMessageIsNull() {
    // Arrange and Act
    IllegalPluginAccessException actualIllegalPluginAccessException =
        new IllegalPluginAccessException();

    // Assert
    assertNull(actualIllegalPluginAccessException.getMessage());
    assertNull(actualIllegalPluginAccessException.getCause());
    assertEquals(0, actualIllegalPluginAccessException.getSuppressed().length);
  }

  /**
   * Test {@link IllegalPluginAccessException#IllegalPluginAccessException(String)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Message is {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link IllegalPluginAccessException#IllegalPluginAccessException(String)}
   */
  @Test
  @DisplayName(
      "Test new IllegalPluginAccessException(String); when 'Msg'; then return Message is 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IllegalPluginAccessException.<init>()",
    "void IllegalPluginAccessException.<init>(String)"
  })
  void testNewIllegalPluginAccessException_whenMsg_thenReturnMessageIsMsg() {
    // Arrange and Act
    IllegalPluginAccessException actualIllegalPluginAccessException =
        new IllegalPluginAccessException("Msg");

    // Assert
    assertEquals("Msg", actualIllegalPluginAccessException.getMessage());
    assertNull(actualIllegalPluginAccessException.getCause());
    assertEquals(0, actualIllegalPluginAccessException.getSuppressed().length);
  }
}
