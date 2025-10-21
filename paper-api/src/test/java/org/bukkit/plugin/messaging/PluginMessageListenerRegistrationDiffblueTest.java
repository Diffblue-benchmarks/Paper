package org.bukkit.plugin.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.TestPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginMessageListenerRegistrationDiffblueTest {
  /**
   * Test {@link PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger,
   * Plugin, String, PluginMessageListener)}.
   *
   * <ul>
   *   <li>Then return {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger, Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test new PluginMessageListenerRegistration(Messenger, Plugin, String, PluginMessageListener); then return 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginMessageListenerRegistration.<init>(Messenger, Plugin, String, PluginMessageListener)"
  })
  void testNewPluginMessageListenerRegistration_thenReturnChannel() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();
    TestPlugin plugin = new TestPlugin("Plugin Name");
    PluginMessageListener listener = mock(PluginMessageListener.class);

    // Act
    PluginMessageListenerRegistration actualPluginMessageListenerRegistration =
        new PluginMessageListenerRegistration(messenger, plugin, "Channel", listener);

    // Assert
    assertEquals("Channel", actualPluginMessageListenerRegistration.getChannel());
    assertFalse(actualPluginMessageListenerRegistration.isValid());
    assertSame(plugin, actualPluginMessageListenerRegistration.getPlugin());
    assertSame(listener, actualPluginMessageListenerRegistration.getListener());
  }

  /**
   * Test {@link PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger,
   * Plugin, String, PluginMessageListener)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger, Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test new PluginMessageListenerRegistration(Messenger, Plugin, String, PluginMessageListener); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginMessageListenerRegistration.<init>(Messenger, Plugin, String, PluginMessageListener)"
  })
  void testNewPluginMessageListenerRegistration_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PluginMessageListenerRegistration(null, null, null, null));
  }

  /**
   * Test {@link PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger,
   * Plugin, String, PluginMessageListener)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger, Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test new PluginMessageListenerRegistration(Messenger, Plugin, String, PluginMessageListener); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginMessageListenerRegistration.<init>(Messenger, Plugin, String, PluginMessageListener)"
  })
  void testNewPluginMessageListenerRegistration_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PluginMessageListenerRegistration(new StandardMessenger(), null, null, null));
  }

  /**
   * Test {@link PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger,
   * Plugin, String, PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@code Channel}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger, Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test new PluginMessageListenerRegistration(Messenger, Plugin, String, PluginMessageListener); when 'Channel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginMessageListenerRegistration.<init>(Messenger, Plugin, String, PluginMessageListener)"
  })
  void testNewPluginMessageListenerRegistration_whenChannel() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PluginMessageListenerRegistration(
                messenger, new TestPlugin("Plugin Name"), "Channel", null));
  }

  /**
   * Test {@link PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger,
   * Plugin, String, PluginMessageListener)}.
   *
   * <ul>
   *   <li>When {@link TestPlugin#TestPlugin(String)} with {@code Plugin Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PluginMessageListenerRegistration#PluginMessageListenerRegistration(Messenger, Plugin, String,
   * PluginMessageListener)}
   */
  @Test
  @DisplayName(
      "Test new PluginMessageListenerRegistration(Messenger, Plugin, String, PluginMessageListener); when TestPlugin(String) with 'Plugin Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginMessageListenerRegistration.<init>(Messenger, Plugin, String, PluginMessageListener)"
  })
  void testNewPluginMessageListenerRegistration_whenTestPluginWithPluginName() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PluginMessageListenerRegistration(
                messenger, new TestPlugin("Plugin Name"), null, null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginMessageListenerRegistration#getChannel()}
   *   <li>{@link PluginMessageListenerRegistration#getListener()}
   *   <li>{@link PluginMessageListenerRegistration#getPlugin()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PluginMessageListenerRegistration.getChannel()",
    "PluginMessageListener PluginMessageListenerRegistration.getListener()",
    "Plugin PluginMessageListenerRegistration.getPlugin()"
  })
  void testGettersAndSetters() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();
    TestPlugin plugin = new TestPlugin("Plugin Name");

    PluginMessageListenerRegistration pluginMessageListenerRegistration =
        new PluginMessageListenerRegistration(
            messenger, plugin, "Channel", mock(PluginMessageListener.class));

    // Act
    String actualChannel = pluginMessageListenerRegistration.getChannel();
    pluginMessageListenerRegistration.getListener();

    // Assert
    assertEquals("Channel", actualChannel);
    assertSame(plugin, pluginMessageListenerRegistration.getPlugin());
  }

  /**
   * Test {@link PluginMessageListenerRegistration#isValid()}.
   *
   * <p>Method under test: {@link PluginMessageListenerRegistration#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PluginMessageListenerRegistration.isValid()"})
  void testIsValid() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();
    PluginMessageListenerRegistration pluginMessageListenerRegistration =
        new PluginMessageListenerRegistration(
            messenger, new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class));

    // Act and Assert
    assertFalse(pluginMessageListenerRegistration.isValid());
  }

  /**
   * Test {@link PluginMessageListenerRegistration#equals(Object)}, and {@link
   * PluginMessageListenerRegistration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginMessageListenerRegistration#equals(Object)}
   *   <li>{@link PluginMessageListenerRegistration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PluginMessageListenerRegistration.equals(Object)",
    "int PluginMessageListenerRegistration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();
    PluginMessageListenerRegistration pluginMessageListenerRegistration =
        new PluginMessageListenerRegistration(
            messenger, new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class));

    // Act and Assert
    assertEquals(pluginMessageListenerRegistration, pluginMessageListenerRegistration);
    int expectedHashCodeResult = pluginMessageListenerRegistration.hashCode();
    assertEquals(expectedHashCodeResult, pluginMessageListenerRegistration.hashCode());
  }

  /**
   * Test {@link PluginMessageListenerRegistration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PluginMessageListenerRegistration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PluginMessageListenerRegistration.equals(Object)",
    "int PluginMessageListenerRegistration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();
    PluginMessageListenerRegistration pluginMessageListenerRegistration =
        new PluginMessageListenerRegistration(
            messenger, new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class));
    StandardMessenger messenger2 = new StandardMessenger();

    // Act and Assert
    assertNotEquals(
        pluginMessageListenerRegistration,
        new PluginMessageListenerRegistration(
            messenger2,
            new TestPlugin("Plugin Name"),
            "Channel",
            mock(PluginMessageListener.class)));
  }

  /**
   * Test {@link PluginMessageListenerRegistration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PluginMessageListenerRegistration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PluginMessageListenerRegistration.equals(Object)",
    "int PluginMessageListenerRegistration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertNotEquals(
        new PluginMessageListenerRegistration(
            messenger, new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class)),
        null);
  }

  /**
   * Test {@link PluginMessageListenerRegistration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PluginMessageListenerRegistration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PluginMessageListenerRegistration.equals(Object)",
    "int PluginMessageListenerRegistration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StandardMessenger messenger = new StandardMessenger();

    // Act and Assert
    assertNotEquals(
        new PluginMessageListenerRegistration(
            messenger, new TestPlugin("Plugin Name"), "Channel", mock(PluginMessageListener.class)),
        "Different type to PluginMessageListenerRegistration");
  }
}
