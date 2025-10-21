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

class ServerPluginExceptionDiffblueTest {
  /**
   * Test {@link ServerPluginException#ServerPluginException(String, Throwable, Plugin)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerPluginException#ServerPluginException(String, Throwable,
   * Plugin)}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginException(String, Throwable, Plugin); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerPluginException.<init>(String, Throwable, Plugin)"})
  void testNewServerPluginException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    // Act
    ServerPluginException actualServerPluginException =
        new ServerPluginException("An error occurred", cause, responsiblePlugin);

    // Assert
    assertEquals("An error occurred", actualServerPluginException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerPluginException.getMessage());
    assertEquals(0, actualServerPluginException.getSuppressed().length);
    assertSame(cause, actualServerPluginException.getCause());
    assertSame(responsiblePlugin, actualServerPluginException.getResponsiblePlugin());
  }

  /**
   * Test {@link ServerPluginException#ServerPluginException(String, Throwable, boolean, boolean,
   * Plugin)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerPluginException#ServerPluginException(String, Throwable,
   * boolean, boolean, Plugin)}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginException(String, Throwable, boolean, boolean, Plugin); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerPluginException.<init>(String, Throwable, boolean, boolean, Plugin)"
  })
  void testNewServerPluginException_thenReturnLocalizedMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    // Act
    ServerPluginException actualServerPluginException =
        new ServerPluginException("An error occurred", cause, true, true, responsiblePlugin);

    // Assert
    assertEquals("An error occurred", actualServerPluginException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerPluginException.getMessage());
    assertEquals(0, actualServerPluginException.getSuppressed().length);
    assertSame(cause, actualServerPluginException.getCause());
    assertSame(responsiblePlugin, actualServerPluginException.getResponsiblePlugin());
  }

  /**
   * Test {@link ServerPluginException#ServerPluginException(Throwable, Plugin)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ServerPluginException#ServerPluginException(Throwable, Plugin)}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginException(Throwable, Plugin); then return LocalizedMessage is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerPluginException.<init>(Throwable, Plugin)"})
  void testNewServerPluginException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    // Act
    ServerPluginException actualServerPluginException =
        new ServerPluginException(cause, responsiblePlugin);

    // Assert
    assertEquals("java.lang.Throwable", actualServerPluginException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerPluginException.getMessage());
    assertEquals(0, actualServerPluginException.getSuppressed().length);
    assertSame(cause, actualServerPluginException.getCause());
    assertSame(responsiblePlugin, actualServerPluginException.getResponsiblePlugin());
  }

  /**
   * Test {@link ServerPluginException#getResponsiblePlugin()}.
   *
   * <p>Method under test: {@link ServerPluginException#getResponsiblePlugin()}
   */
  @Test
  @DisplayName("Test getResponsiblePlugin()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Plugin ServerPluginException.getResponsiblePlugin()"})
  void testGetResponsiblePlugin() {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");

    ServerPluginException serverPluginException =
        new ServerPluginException(cause, responsiblePlugin);

    // Act and Assert
    assertSame(responsiblePlugin, serverPluginException.getResponsiblePlugin());
  }
}
