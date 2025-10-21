package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerPluginMessageExceptionDiffblueTest {
  /**
   * Test {@link ServerPluginMessageException#ServerPluginMessageException(String, Throwable,
   * Plugin, Player, String, byte[])}.
   *
   * <ul>
   *   <li>Then ResponsiblePlugin return {@link TestPlugin}.
   * </ul>
   *
   * <p>Method under test: {@link ServerPluginMessageException#ServerPluginMessageException(String,
   * Throwable, Plugin, Player, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginMessageException(String, Throwable, Plugin, Player, String, byte[]); then ResponsiblePlugin return TestPlugin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerPluginMessageException.<init>(String, Throwable, Plugin, Player, String, byte[])"
  })
  void testNewServerPluginMessageException_thenResponsiblePluginReturnTestPlugin()
      throws UnsupportedEncodingException {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");
    Player player = mock(Player.class);

    // Act
    ServerPluginMessageException actualServerPluginMessageException =
        new ServerPluginMessageException(
            "An error occurred",
            cause,
            responsiblePlugin,
            player,
            "Channel",
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Plugin responsiblePlugin2 = actualServerPluginMessageException.getResponsiblePlugin();
    assertTrue(responsiblePlugin2 instanceof TestPlugin);
    assertEquals("An error occurred", actualServerPluginMessageException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerPluginMessageException.getMessage());
    assertEquals("Channel", actualServerPluginMessageException.getChannel());
    assertEquals(0, actualServerPluginMessageException.getSuppressed().length);
    assertSame(cause, actualServerPluginMessageException.getCause());
    assertSame(responsiblePlugin, responsiblePlugin2);
    assertSame(player, actualServerPluginMessageException.getPlayer());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualServerPluginMessageException.getData());
  }

  /**
   * Test {@link ServerPluginMessageException#ServerPluginMessageException(String, Throwable,
   * boolean, boolean, Plugin, Player, String, byte[])}.
   *
   * <ul>
   *   <li>Then ResponsiblePlugin return {@link TestPlugin}.
   * </ul>
   *
   * <p>Method under test: {@link ServerPluginMessageException#ServerPluginMessageException(String,
   * Throwable, boolean, boolean, Plugin, Player, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginMessageException(String, Throwable, boolean, boolean, Plugin, Player, String, byte[]); then ResponsiblePlugin return TestPlugin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerPluginMessageException.<init>(String, Throwable, boolean, boolean, Plugin, Player, String, byte[])"
  })
  void testNewServerPluginMessageException_thenResponsiblePluginReturnTestPlugin2()
      throws UnsupportedEncodingException {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");
    Player player = mock(Player.class);

    // Act
    ServerPluginMessageException actualServerPluginMessageException =
        new ServerPluginMessageException(
            "An error occurred",
            cause,
            true,
            true,
            responsiblePlugin,
            player,
            "Channel",
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Plugin responsiblePlugin2 = actualServerPluginMessageException.getResponsiblePlugin();
    assertTrue(responsiblePlugin2 instanceof TestPlugin);
    assertEquals("An error occurred", actualServerPluginMessageException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerPluginMessageException.getMessage());
    assertEquals("Channel", actualServerPluginMessageException.getChannel());
    assertEquals(0, actualServerPluginMessageException.getSuppressed().length);
    assertSame(cause, actualServerPluginMessageException.getCause());
    assertSame(responsiblePlugin, responsiblePlugin2);
    assertSame(player, actualServerPluginMessageException.getPlayer());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualServerPluginMessageException.getData());
  }

  /**
   * Test {@link ServerPluginMessageException#ServerPluginMessageException(Throwable, Plugin,
   * Player, String, byte[])}.
   *
   * <ul>
   *   <li>Then ResponsiblePlugin return {@link TestPlugin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerPluginMessageException#ServerPluginMessageException(Throwable, Plugin, Player, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test new ServerPluginMessageException(Throwable, Plugin, Player, String, byte[]); then ResponsiblePlugin return TestPlugin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerPluginMessageException.<init>(Throwable, Plugin, Player, String, byte[])"
  })
  void testNewServerPluginMessageException_thenResponsiblePluginReturnTestPlugin3()
      throws UnsupportedEncodingException {
    // Arrange
    Throwable cause = new Throwable();
    TestPlugin responsiblePlugin = new TestPlugin("Plugin Name");
    Player player = mock(Player.class);

    // Act
    ServerPluginMessageException actualServerPluginMessageException =
        new ServerPluginMessageException(
            cause, responsiblePlugin, player, "Channel", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    Plugin responsiblePlugin2 = actualServerPluginMessageException.getResponsiblePlugin();
    assertTrue(responsiblePlugin2 instanceof TestPlugin);
    assertEquals("Channel", actualServerPluginMessageException.getChannel());
    assertEquals("java.lang.Throwable", actualServerPluginMessageException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerPluginMessageException.getMessage());
    assertEquals(0, actualServerPluginMessageException.getSuppressed().length);
    assertSame(cause, actualServerPluginMessageException.getCause());
    assertSame(responsiblePlugin, responsiblePlugin2);
    assertSame(player, actualServerPluginMessageException.getPlayer());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualServerPluginMessageException.getData());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ServerPluginMessageException#getChannel()}
   *   <li>{@link ServerPluginMessageException#getData()}
   *   <li>{@link ServerPluginMessageException#getPlayer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ServerPluginMessageException.getChannel()",
    "byte[] ServerPluginMessageException.getData()",
    "Player ServerPluginMessageException.getPlayer()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Throwable cause = new Throwable();
    ServerPluginMessageException serverPluginMessageException =
        new ServerPluginMessageException(
            cause,
            new TestPlugin("Plugin Name"),
            mock(Player.class),
            "Channel",
            "AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualChannel = serverPluginMessageException.getChannel();
    byte[] actualData = serverPluginMessageException.getData();
    serverPluginMessageException.getPlayer();

    // Assert
    assertEquals("Channel", actualChannel);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }
}
