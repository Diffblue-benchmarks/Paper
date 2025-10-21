package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerPluginEnableDisableExceptionDiffblueTest {
  /**
   * Test {@link ServerPluginEnableDisableException#ServerPluginEnableDisableException(String,
   * Throwable, Plugin)}.
   *
   * <p>Method under test: {@link
   * ServerPluginEnableDisableException#ServerPluginEnableDisableException(String, Throwable,
   * Plugin)}
   */
  @Test
  @DisplayName("Test new ServerPluginEnableDisableException(String, Throwable, Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerPluginEnableDisableException.<init>(String, Throwable, Plugin)"})
  void testNewServerPluginEnableDisableException() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    // Act
    ServerPluginEnableDisableException actualServerPluginEnableDisableException =
        new ServerPluginEnableDisableException("An error occurred", cause, responsiblePlugin);

    // Assert
    assertEquals(
        "An error occurred", actualServerPluginEnableDisableException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerPluginEnableDisableException.getMessage());
    assertEquals(0, actualServerPluginEnableDisableException.getSuppressed().length);
    assertSame(cause, actualServerPluginEnableDisableException.getCause());
    assertSame(responsiblePlugin, actualServerPluginEnableDisableException.getResponsiblePlugin());
  }

  /**
   * Test {@link ServerPluginEnableDisableException#ServerPluginEnableDisableException(String,
   * Throwable, boolean, boolean, Plugin)}.
   *
   * <p>Method under test: {@link
   * ServerPluginEnableDisableException#ServerPluginEnableDisableException(String, Throwable,
   * boolean, boolean, Plugin)}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginEnableDisableException(String, Throwable, boolean, boolean, Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerPluginEnableDisableException.<init>(String, Throwable, boolean, boolean, Plugin)"
  })
  void testNewServerPluginEnableDisableException2() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    // Act
    ServerPluginEnableDisableException actualServerPluginEnableDisableException =
        new ServerPluginEnableDisableException(
            "An error occurred", cause, true, true, responsiblePlugin);

    // Assert
    assertEquals(
        "An error occurred", actualServerPluginEnableDisableException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerPluginEnableDisableException.getMessage());
    assertEquals(0, actualServerPluginEnableDisableException.getSuppressed().length);
    assertSame(cause, actualServerPluginEnableDisableException.getCause());
    assertSame(responsiblePlugin, actualServerPluginEnableDisableException.getResponsiblePlugin());
  }

  /**
   * Test {@link ServerPluginEnableDisableException#ServerPluginEnableDisableException(Throwable,
   * Plugin)}.
   *
   * <p>Method under test: {@link
   * ServerPluginEnableDisableException#ServerPluginEnableDisableException(Throwable, Plugin)}
   */
  @Test
  @DisplayName("Test new ServerPluginEnableDisableException(Throwable, Plugin)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerPluginEnableDisableException.<init>(Throwable, Plugin)"})
  void testNewServerPluginEnableDisableException3() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    // Act
    ServerPluginEnableDisableException actualServerPluginEnableDisableException =
        new ServerPluginEnableDisableException(cause, responsiblePlugin);

    // Assert
    assertEquals(
        "java.lang.Throwable", actualServerPluginEnableDisableException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerPluginEnableDisableException.getMessage());
    assertEquals(0, actualServerPluginEnableDisableException.getSuppressed().length);
    assertSame(cause, actualServerPluginEnableDisableException.getCause());
    assertSame(responsiblePlugin, actualServerPluginEnableDisableException.getResponsiblePlugin());
  }
}
