package org.bukkit.plugin.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.connection.PlayerConnection;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StandardMessengerDiffblueTest {
  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .isReservedChannel(
                    "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String); when 'BungeeCord'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenBungeeCord_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StandardMessenger().isReservedChannel("BungeeCord"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCordminecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String); when 'BungeeCordminecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenBungeeCordminecraftRegister() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().isReservedChannel("BungeeCordminecraft:register"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String); when 'bungeecord:main'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenBungeecordMain_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new StandardMessenger().isReservedChannel("bungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName(
      "Test isReservedChannel(String); when 'Channel cannot be null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenChannelCannotBeNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().isReservedChannel("Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName(
      "Test isReservedChannel(String); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new StandardMessenger().isReservedChannel("Channel"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName(
      "Test isReservedChannel(String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new StandardMessenger().isReservedChannel(""));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String); when 'minecraft:register'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenMinecraftRegister_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new StandardMessenger().isReservedChannel("minecraft:register"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:unregister}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String); when 'minecraft:unregister'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenMinecraftUnregister_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new StandardMessenger().isReservedChannel("minecraft:unregister"));
  }

  /**
   * Test {@link StandardMessenger#isReservedChannel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isReservedChannel(String)}
   */
  @Test
  @DisplayName("Test isReservedChannel(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isReservedChannel(String)"})
  void testIsReservedChannel_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new StandardMessenger().isReservedChannel(null));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test registerOutgoingPluginChannel(Plugin, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerOutgoingPluginChannel(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>Then {@link StandardMessenger} (default constructor) OutgoingChannels size is one.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test registerOutgoingPluginChannel(Plugin, String); then StandardMessenger (default constructor) OutgoingChannels size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_thenStandardMessengerOutgoingChannelsSizeIsOne() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act
    standardMessenger.registerOutgoingPluginChannel(new TestPlugin("Plugin Name"), "BungeeCord");

    // Assert
    Set<String> outgoingChannels = standardMessenger.getOutgoingChannels();
    assertEquals(1, outgoingChannels.size());
    assertTrue(outgoingChannels.contains("bungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test registerOutgoingPluginChannel(Plugin, String); when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerOutgoingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test registerOutgoingPluginChannel(Plugin, String); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerOutgoingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel"));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test registerOutgoingPluginChannel(Plugin, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.registerOutgoingPluginChannel(new TestPlugin("Plugin Name"), ""));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test registerOutgoingPluginChannel(Plugin, String); when 'minecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenMinecraftRegister() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ReservedChannelException.class,
        () ->
            standardMessenger.registerOutgoingPluginChannel(
                new TestPlugin("Plugin Name"), "minecraft:register"));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:unregister}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test registerOutgoingPluginChannel(Plugin, String); when 'minecraft:unregister'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenMinecraftUnregister() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ReservedChannelException.class,
        () ->
            standardMessenger.registerOutgoingPluginChannel(
                new TestPlugin("Plugin Name"), "minecraft:unregister"));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test registerOutgoingPluginChannel(Plugin, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().registerOutgoingPluginChannel(null, null));
  }

  /**
   * Test {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test registerOutgoingPluginChannel(Plugin, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.registerOutgoingPluginChannel(Plugin, String)"})
  void testRegisterOutgoingPluginChannel_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.registerOutgoingPluginChannel(new TestPlugin("Plugin Name"), null));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test unregisterOutgoingPluginChannel(Plugin, String) with 'plugin', 'channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin, String)"})
  void testUnregisterOutgoingPluginChannelWithPluginChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterOutgoingPluginChannel(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterOutgoingPluginChannel(Plugin, String) with 'plugin', 'channel'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin, String)"})
  void testUnregisterOutgoingPluginChannelWithPluginChannel_whenChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterOutgoingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel"));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterOutgoingPluginChannel(Plugin, String) with 'plugin', 'channel'; when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin, String)"})
  void testUnregisterOutgoingPluginChannelWithPluginChannel_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterOutgoingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterOutgoingPluginChannel(Plugin, String) with 'plugin', 'channel'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin, String)"})
  void testUnregisterOutgoingPluginChannelWithPluginChannel_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.unregisterOutgoingPluginChannel(new TestPlugin("Plugin Name"), ""));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterOutgoingPluginChannel(Plugin, String) with 'plugin', 'channel'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin, String)"})
  void testUnregisterOutgoingPluginChannelWithPluginChannel_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().unregisterOutgoingPluginChannel(null, null));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterOutgoingPluginChannel(Plugin, String) with 'plugin', 'channel'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin, String)"})
  void testUnregisterOutgoingPluginChannelWithPluginChannel_whenNull2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterOutgoingPluginChannel(new TestPlugin("Plugin Name"), null));
  }

  /**
   * Test {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin)} with {@code plugin}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterOutgoingPluginChannel(Plugin)}
   */
  @Test
  @DisplayName(
      "Test unregisterOutgoingPluginChannel(Plugin) with 'plugin'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterOutgoingPluginChannel(Plugin)"})
  void testUnregisterOutgoingPluginChannelWithPlugin_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().unregisterOutgoingPluginChannel(null));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName("Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration",
                mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>Then return Channel is {@code bungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); then return Channel is 'bungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_thenReturnChannelIsBungeecordMain() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PluginMessageListener listener = mock(PluginMessageListener.class);

    // Act
    PluginMessageListenerRegistration actualRegisterIncomingPluginChannelResult =
        standardMessenger.registerIncomingPluginChannel(plugin, "BungeeCord", listener);

    // Assert
    assertEquals("bungeecord:main", actualRegisterIncomingPluginChannelResult.getChannel());
    Set<String> incomingChannels = standardMessenger.getIncomingChannels();
    assertEquals(1, incomingChannels.size());
    assertTrue(incomingChannels.contains("bungeecord:main"));
    assertTrue(actualRegisterIncomingPluginChannelResult.isValid());
    assertSame(plugin, actualRegisterIncomingPluginChannelResult.getPlugin());
    assertSame(listener, actualRegisterIncomingPluginChannelResult.getListener());
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'BungeeCord'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenBungeeCord() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "BungeeCord", null));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel cannot be null", null));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "", mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'minecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenMinecraftRegister() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ReservedChannelException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "minecraft:register", null));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code minecraft:unregister}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'minecraft:unregister'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenMinecraftUnregister() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ReservedChannelException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"),
                "minecraft:unregister",
                mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().registerIncomingPluginChannel(null, null, null));
  }

  /**
   * Test {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#registerIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test registerIncomingPluginChannel(Plugin, String, PluginMessageListener); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PluginMessageListenerRegistration StandardMessenger.registerIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testRegisterIncomingPluginChannel_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.registerIncomingPluginChannel(
                new TestPlugin("Plugin Name"), null, null));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName("Test unregisterIncomingPluginChannel(Plugin, String) with 'plugin', 'channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String)"})
  void testUnregisterIncomingPluginChannelWithPluginChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"),
                "Channel cannot be null",
                mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration",
                mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener_whenChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "", mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().unregisterIncomingPluginChannel(null, null, null));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener_whenNull2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"), null, null));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)} with {@code plugin}, {@code channel}, {@code listener}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener) with 'plugin', 'channel', 'listener'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String, PluginMessageListener)"
  })
  void testUnregisterIncomingPluginChannelWithPluginChannelListener_whenNull3() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"), null, mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String) with 'plugin', 'channel'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String)"})
  void testUnregisterIncomingPluginChannelWithPluginChannel_whenChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.unregisterIncomingPluginChannel(
                new TestPlugin("Plugin Name"), "Channel"));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin, String) with 'plugin', 'channel'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterIncomingPluginChannel(Plugin, String)"})
  void testUnregisterIncomingPluginChannelWithPluginChannel_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.unregisterIncomingPluginChannel(new TestPlugin("Plugin Name"), ""));
  }

  /**
   * Test {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin)} with {@code plugin}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#unregisterIncomingPluginChannel(Plugin)}
   */
  @Test
  @DisplayName(
      "Test unregisterIncomingPluginChannel(Plugin) with 'plugin'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.unregisterIncomingPluginChannel(Plugin)"})
  void testUnregisterIncomingPluginChannelWithPlugin_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().unregisterIncomingPluginChannel(null));
  }

  /**
   * Test {@link StandardMessenger#getOutgoingChannels()}.
   *
   * <p>Method under test: {@link StandardMessenger#getOutgoingChannels()}
   */
  @Test
  @DisplayName("Test getOutgoingChannels()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getOutgoingChannels()"})
  void testGetOutgoingChannels() {
    // Arrange, Act and Assert
    assertTrue(new StandardMessenger().getOutgoingChannels().isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getOutgoingChannels(Plugin)} with {@code Plugin}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getOutgoingChannels(Plugin)}
   */
  @Test
  @DisplayName(
      "Test getOutgoingChannels(Plugin) with 'Plugin'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getOutgoingChannels(Plugin)"})
  void testGetOutgoingChannelsWithPlugin_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new StandardMessenger().getOutgoingChannels(null));
  }

  /**
   * Test {@link StandardMessenger#getOutgoingChannels(Plugin)} with {@code Plugin}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getOutgoingChannels(Plugin)}
   */
  @Test
  @DisplayName(
      "Test getOutgoingChannels(Plugin) with 'Plugin'; when TestPlugin(String) with 'Plugin Name'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getOutgoingChannels(Plugin)"})
  void testGetOutgoingChannelsWithPlugin_whenTestPluginWithPluginName_thenReturnEmpty() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertTrue(standardMessenger.getOutgoingChannels(new TestPlugin("Plugin Name")).isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannels()}.
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannels()}
   */
  @Test
  @DisplayName("Test getIncomingChannels()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannels()"})
  void testGetIncomingChannels() {
    // Arrange, Act and Assert
    assertTrue(new StandardMessenger().getIncomingChannels().isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannels(Plugin)} with {@code Plugin}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannels(Plugin)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannels(Plugin) with 'Plugin'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannels(Plugin)"})
  void testGetIncomingChannelsWithPlugin_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new StandardMessenger().getIncomingChannels(null));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannels(Plugin)} with {@code Plugin}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannels(Plugin)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannels(Plugin) with 'Plugin'; when TestPlugin(String) with 'Plugin Name'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannels(Plugin)"})
  void testGetIncomingChannelsWithPlugin_whenTestPluginWithPluginName_thenReturnEmpty() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertTrue(standardMessenger.getIncomingChannels(new TestPlugin("Plugin Name")).isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName("Test getIncomingChannelRegistrations(String) with 'channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .getIncomingChannelRegistrations(
                    "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(String) with 'channel'; when 'BungeeCord'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel_whenBungeeCord_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new StandardMessenger().getIncomingChannelRegistrations("BungeeCord").isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <ul>
   *   <li>When {@code BungeeCordbungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(String) with 'channel'; when 'BungeeCordbungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel_whenBungeeCordbungeecordMain() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().getIncomingChannelRegistrations("BungeeCordbungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(String) with 'channel'; when 'bungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel_whenBungeecordMain() {
    // Arrange, Act and Assert
    assertTrue(
        new StandardMessenger().getIncomingChannelRegistrations("bungeecord:main").isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName("Test getIncomingChannelRegistrations(String) with 'channel'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel_whenChannel() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().getIncomingChannelRegistrations("Channel"));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName("Test getIncomingChannelRegistrations(String) with 'channel'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().getIncomingChannelRegistrations(""));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(String)} with {@code channel}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(String) with 'channel'; when 'minecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(String)"})
  void testGetIncomingChannelRegistrationsWithChannel_whenMinecraftRegister() {
    // Arrange, Act and Assert
    assertTrue(
        new StandardMessenger().getIncomingChannelRegistrations("minecraft:register").isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName("Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.getIncomingChannelRegistrations(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'BungeeCord'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenBungeeCord() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertTrue(
        standardMessenger
            .getIncomingChannelRegistrations(new TestPlugin("Plugin Name"), "BungeeCord")
            .isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'bungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenBungeecordMain() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertTrue(
        standardMessenger
            .getIncomingChannelRegistrations(new TestPlugin("Plugin Name"), "bungeecord:main")
            .isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenChannel() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.getIncomingChannelRegistrations(
                new TestPlugin("Plugin Name"), "Channel"));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.getIncomingChannelRegistrations(
                new TestPlugin("Plugin Name"), "Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.getIncomingChannelRegistrations(new TestPlugin("Plugin Name"), ""));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'minecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenMinecraftRegister() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertTrue(
        standardMessenger
            .getIncomingChannelRegistrations(new TestPlugin("Plugin Name"), "minecraft:register")
            .isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().getIncomingChannelRegistrations(null, null));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)} with {@code
   * plugin}, {@code channel}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin, String) with 'plugin', 'channel'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin, String)"})
  void testGetIncomingChannelRegistrationsWithPluginChannel_whenNull2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.getIncomingChannelRegistrations(new TestPlugin("Plugin Name"), null));
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin)} with {@code plugin}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin)}
   */
  @Test
  @DisplayName("Test getIncomingChannelRegistrations(Plugin) with 'plugin'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin)"})
  void testGetIncomingChannelRegistrationsWithPlugin_thenReturnEmpty() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertTrue(
        standardMessenger.getIncomingChannelRegistrations(new TestPlugin("Plugin Name")).isEmpty());
  }

  /**
   * Test {@link StandardMessenger#getIncomingChannelRegistrations(Plugin)} with {@code plugin}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#getIncomingChannelRegistrations(Plugin)}
   */
  @Test
  @DisplayName(
      "Test getIncomingChannelRegistrations(Plugin) with 'plugin'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StandardMessenger.getIncomingChannelRegistrations(Plugin)"})
  void testGetIncomingChannelRegistrationsWithPlugin_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().getIncomingChannelRegistrations((Plugin) null));
  }

  /**
   * Test {@link StandardMessenger#isRegistrationValid(PluginMessageListenerRegistration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StandardMessenger#isRegistrationValid(PluginMessageListenerRegistration)}
   */
  @Test
  @DisplayName(
      "Test isRegistrationValid(PluginMessageListenerRegistration); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardMessenger.isRegistrationValid(PluginMessageListenerRegistration)"
  })
  void testIsRegistrationValid_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new StandardMessenger().isRegistrationValid(null));
  }

  /**
   * Test {@link StandardMessenger#isRegistrationValid(PluginMessageListenerRegistration)}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StandardMessenger#isRegistrationValid(PluginMessageListenerRegistration)}
   */
  @Test
  @DisplayName(
      "Test isRegistrationValid(PluginMessageListenerRegistration); when TestPlugin(String) with 'Plugin Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StandardMessenger.isRegistrationValid(PluginMessageListenerRegistration)"
  })
  void testIsRegistrationValid_whenTestPluginWithPluginName_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();
    StandardMessenger messenger = new StandardMessenger();
    PluginMessageListenerRegistration registration =
        new PluginMessageListenerRegistration(
            messenger, new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class));

    // Act
    boolean actualIsRegistrationValidResult = standardMessenger.isRegistrationValid(registration);

    // Assert
    assertFalse(actualIsRegistrationValidResult);
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName("Test isIncomingChannelRegistered(Plugin, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.isIncomingChannelRegistered(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isIncomingChannelRegistered(Plugin, String); when 'BungeeCord'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenBungeeCord_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertFalse(
        standardMessenger.isIncomingChannelRegistered(new TestPlugin("Plugin Name"), "BungeeCord"));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isIncomingChannelRegistered(Plugin, String); when 'bungeecord:main'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenBungeecordMain_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertFalse(
        standardMessenger.isIncomingChannelRegistered(
            new TestPlugin("Plugin Name"), "bungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName("Test isIncomingChannelRegistered(Plugin, String); when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.isIncomingChannelRegistered(
                new TestPlugin("Plugin Name"), "Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isIncomingChannelRegistered(Plugin, String); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.isIncomingChannelRegistered(
                new TestPlugin("Plugin Name"), "Channel"));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName("Test isIncomingChannelRegistered(Plugin, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.isIncomingChannelRegistered(new TestPlugin("Plugin Name"), ""));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isIncomingChannelRegistered(Plugin, String); when 'minecraft:register'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenMinecraftRegister_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertFalse(
        standardMessenger.isIncomingChannelRegistered(
            new TestPlugin("Plugin Name"), "minecraft:register"));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isIncomingChannelRegistered(Plugin, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().isIncomingChannelRegistered(null, null));
  }

  /**
   * Test {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isIncomingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isIncomingChannelRegistered(Plugin, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isIncomingChannelRegistered(Plugin, String)"})
  void testIsIncomingChannelRegistered_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.isIncomingChannelRegistered(new TestPlugin("Plugin Name"), null));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName("Test isOutgoingChannelRegistered(Plugin, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.isOutgoingChannelRegistered(
                new TestPlugin("Plugin Name"),
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isOutgoingChannelRegistered(Plugin, String); when 'BungeeCord'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenBungeeCord_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertFalse(
        standardMessenger.isOutgoingChannelRegistered(new TestPlugin("Plugin Name"), "BungeeCord"));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isOutgoingChannelRegistered(Plugin, String); when 'bungeecord:main'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenBungeecordMain_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertFalse(
        standardMessenger.isOutgoingChannelRegistered(
            new TestPlugin("Plugin Name"), "bungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName("Test isOutgoingChannelRegistered(Plugin, String); when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.isOutgoingChannelRegistered(
                new TestPlugin("Plugin Name"), "Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isOutgoingChannelRegistered(Plugin, String); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            standardMessenger.isOutgoingChannelRegistered(
                new TestPlugin("Plugin Name"), "Channel"));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName("Test isOutgoingChannelRegistered(Plugin, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenEmptyString() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.isOutgoingChannelRegistered(new TestPlugin("Plugin Name"), ""));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isOutgoingChannelRegistered(Plugin, String); when 'minecraft:register'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenMinecraftRegister_thenReturnFalse() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertFalse(
        standardMessenger.isOutgoingChannelRegistered(
            new TestPlugin("Plugin Name"), "minecraft:register"));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isOutgoingChannelRegistered(Plugin, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().isOutgoingChannelRegistered(null, null));
  }

  /**
   * Test {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#isOutgoingChannelRegistered(Plugin, String)}
   */
  @Test
  @DisplayName(
      "Test isOutgoingChannelRegistered(Plugin, String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StandardMessenger.isOutgoingChannelRegistered(Plugin, String)"})
  void testIsOutgoingChannelRegistered_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange
    StandardMessenger standardMessenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> standardMessenger.isOutgoingChannelRegistered(new TestPlugin("Plugin Name"), null));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection, String, byte[])} with
   * {@code PlayerConnection}, {@code String}, {@code byte[]}.
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection,
   * String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(PlayerConnection, String, byte[]) with 'PlayerConnection', 'String', 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.dispatchIncomingMessage(PlayerConnection, String, byte[])"
  })
  void testDispatchIncomingMessageWithPlayerConnectionStringByte()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(
                    mock(PlayerConnection.class),
                    "org.bukkit.plugin.messaging.PluginMessageListenerRegistration",
                    "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection, String, byte[])} with
   * {@code PlayerConnection}, {@code String}, {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection,
   * String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(PlayerConnection, String, byte[]) with 'PlayerConnection', 'String', 'byte[]'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.dispatchIncomingMessage(PlayerConnection, String, byte[])"
  })
  void testDispatchIncomingMessageWithPlayerConnectionStringByte_whenChannel()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(
                    mock(PlayerConnection.class), "Channel", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection, String, byte[])} with
   * {@code PlayerConnection}, {@code String}, {@code byte[]}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection,
   * String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(PlayerConnection, String, byte[]) with 'PlayerConnection', 'String', 'byte[]'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.dispatchIncomingMessage(PlayerConnection, String, byte[])"
  })
  void testDispatchIncomingMessageWithPlayerConnectionStringByte_whenEmptyString()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(
                    mock(PlayerConnection.class), "", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection, String, byte[])} with
   * {@code PlayerConnection}, {@code String}, {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(PlayerConnection,
   * String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(PlayerConnection, String, byte[]) with 'PlayerConnection', 'String', 'byte[]'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.dispatchIncomingMessage(PlayerConnection, String, byte[])"
  })
  void testDispatchIncomingMessageWithPlayerConnectionStringByte_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(mock(PlayerConnection.class), "Channel", null));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])} with {@code
   * Player}, {@code String}, {@code byte[]}.
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(Player, String, byte[]) with 'Player', 'String', 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.dispatchIncomingMessage(Player, String, byte[])"})
  void testDispatchIncomingMessageWithPlayerStringByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(
                    mock(Player.class),
                    "org.bukkit.plugin.messaging.PluginMessageListenerRegistration",
                    "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])} with {@code
   * Player}, {@code String}, {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(Player, String, byte[]) with 'Player', 'String', 'byte[]'; when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.dispatchIncomingMessage(Player, String, byte[])"})
  void testDispatchIncomingMessageWithPlayerStringByte_whenChannel()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(
                    mock(Player.class), "Channel", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])} with {@code
   * Player}, {@code String}, {@code byte[]}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(Player, String, byte[]) with 'Player', 'String', 'byte[]'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.dispatchIncomingMessage(Player, String, byte[])"})
  void testDispatchIncomingMessageWithPlayerStringByte_whenEmptyString()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new StandardMessenger()
                .dispatchIncomingMessage(mock(Player.class), "", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])} with {@code
   * Player}, {@code String}, {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#dispatchIncomingMessage(Player, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test dispatchIncomingMessage(Player, String, byte[]) with 'Player', 'String', 'byte[]'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.dispatchIncomingMessage(Player, String, byte[])"})
  void testDispatchIncomingMessageWithPlayerStringByte_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new StandardMessenger().dispatchIncomingMessage(mock(Player.class), "Channel", null));
  }

  /**
   * Test {@link StandardMessenger#validateChannel(String)}.
   *
   * <p>Method under test: {@link StandardMessenger#validateChannel(String)}
   */
  @Test
  @DisplayName("Test validateChannel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.validateChannel(String)"})
  void testValidateChannel() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validateChannel(
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#validateChannel(String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCordbungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateChannel(String)}
   */
  @Test
  @DisplayName("Test validateChannel(String); when 'BungeeCordbungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.validateChannel(String)"})
  void testValidateChannel_whenBungeeCordbungeecordMain() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validateChannel("BungeeCordbungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#validateChannel(String)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateChannel(String); when 'Channel cannot be null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.validateChannel(String)"})
  void testValidateChannel_whenChannelCannotBeNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validateChannel("Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#validateChannel(String)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateChannel(String)}
   */
  @Test
  @DisplayName("Test validateChannel(String); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.validateChannel(String)"})
  void testValidateChannel_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> StandardMessenger.validateChannel("Channel"));
  }

  /**
   * Test {@link StandardMessenger#validateChannel(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateChannel(String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.validateChannel(String)"})
  void testValidateChannel_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StandardMessenger.validateChannel(""));
  }

  /**
   * Test {@link StandardMessenger#validateChannel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateChannel(String)}
   */
  @Test
  @DisplayName("Test validateChannel(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.validateChannel(String)"})
  void testValidateChannel_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> StandardMessenger.validateChannel(null));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName("Test validateAndCorrectChannel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validateAndCorrectChannel(
                "org.bukkit.plugin.messaging.PluginMessageListenerRegistration"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   *   <li>Then return {@code bungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateAndCorrectChannel(String); when 'BungeeCord'; then return 'bungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenBungeeCord_thenReturnBungeecordMain() {
    // Arrange, Act and Assert
    assertEquals("bungeecord:main", StandardMessenger.validateAndCorrectChannel("BungeeCord"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code BungeeCordbungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName("Test validateAndCorrectChannel(String); when 'BungeeCordbungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenBungeeCordbungeecordMain() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validateAndCorrectChannel("BungeeCordbungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   *   <li>Then return {@code BungeeCord}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateAndCorrectChannel(String); when 'bungeecord:main'; then return 'BungeeCord'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenBungeecordMain_thenReturnBungeeCord() {
    // Arrange, Act and Assert
    assertEquals("BungeeCord", StandardMessenger.validateAndCorrectChannel("bungeecord:main"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName("Test validateAndCorrectChannel(String); when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenChannelCannotBeNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validateAndCorrectChannel("Channel cannot be null"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateAndCorrectChannel(String); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenChannel_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validateAndCorrectChannel("Channel"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateAndCorrectChannel(String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> StandardMessenger.validateAndCorrectChannel(""));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   *   <li>Then return {@code minecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateAndCorrectChannel(String); when 'minecraft:register'; then return 'minecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenMinecraftRegister_thenReturnMinecraftRegister() {
    // Arrange, Act and Assert
    assertEquals(
        "minecraft:register", StandardMessenger.validateAndCorrectChannel("minecraft:register"));
  }

  /**
   * Test {@link StandardMessenger#validateAndCorrectChannel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validateAndCorrectChannel(String)}
   */
  @Test
  @DisplayName(
      "Test validateAndCorrectChannel(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StandardMessenger.validateAndCorrectChannel(String)"})
  void testValidateAndCorrectChannel_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> StandardMessenger.validateAndCorrectChannel(null));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code BungeeCord}.
   *   <li>Then throw {@link ChannelNotRegisteredException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'BungeeCord'; then throw ChannelNotRegisteredException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenBungeeCord_thenThrowChannelNotRegisteredException() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ChannelNotRegisteredException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger,
                new TestPlugin("Plugin Name"),
                "BungeeCord",
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code bungeecord:main}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'bungeecord:main'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenBungeecordMain() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ChannelNotRegisteredException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger,
                new TestPlugin("Plugin Name"),
                "bungeecord:main",
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code Channel cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'Channel cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenChannelCannotBeNull() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger,
                new TestPlugin("Plugin Name"),
                "Channel cannot be null",
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'Channel'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenChannel_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger, new TestPlugin("Plugin Name"), "Channel", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger,
                new TestPlugin("Plugin Name"),
                "",
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code minecraft:register}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'minecraft:register'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenMinecraftRegister() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        ChannelNotRegisteredException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger,
                new TestPlugin("Plugin Name"),
                "minecraft:register",
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validatePluginMessage(null, null, null, null));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> StandardMessenger.validatePluginMessage(new StandardMessenger(), null, null, null));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger, new TestPlugin("Plugin Name"), null, null));
  }

  /**
   * Test {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link StandardMessenger#validatePluginMessage(Messenger, Plugin, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test validatePluginMessage(Messenger, Plugin, String, byte[]); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StandardMessenger.validatePluginMessage(Messenger, Plugin, String, byte[])"
  })
  void testValidatePluginMessage_whenNull_thenThrowIllegalArgumentException4() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            StandardMessenger.validatePluginMessage(
                messenger,
                new TestPlugin("Plugin Name"),
                null,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test new {@link StandardMessenger} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StandardMessenger}
   */
  @Test
  @DisplayName("Test new StandardMessenger (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardMessenger.<init>()"})
  void testNewStandardMessenger() {
    // Arrange and Act
    StandardMessenger actualStandardMessenger = new StandardMessenger();

    // Assert
    Set<String> incomingChannels = actualStandardMessenger.getIncomingChannels();
    assertTrue(incomingChannels.isEmpty());
    assertSame(incomingChannels, actualStandardMessenger.getOutgoingChannels());
  }
}
