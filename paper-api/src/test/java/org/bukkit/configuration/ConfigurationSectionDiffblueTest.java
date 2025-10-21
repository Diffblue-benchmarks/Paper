package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.adventure.text.serializer.ComponentDecoder;
import net.kyori.adventure.text.serializer.ComponentEncoder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConfigurationSectionDiffblueTest {
  /**
   * Test {@link ConfigurationSection#getRichMessage(String, Component)} with {@code path}, {@code
   * fallback}.
   *
   * <p>Method under test: {@link ConfigurationSection#getRichMessage(String, Component)}
   */
  @Test
  @DisplayName("Test getRichMessage(String, Component) with 'path', 'fallback'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ConfigurationSection.getRichMessage(String, Component)"})
  void testGetRichMessageWithPathFallback() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    Component fallback = mock(Component.class);

    // Act
    Component actualRichMessage = memoryConfiguration.getRichMessage("Path", fallback);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(fallback, actualRichMessage);
  }

  /**
   * Test {@link ConfigurationSection#getRichMessage(String, Component)} with {@code path}, {@code
   * fallback}.
   *
   * <ul>
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSection#getRichMessage(String, Component)}
   */
  @Test
  @DisplayName(
      "Test getRichMessage(String, Component) with 'path', 'fallback'; then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ConfigurationSection.getRichMessage(String, Component)"})
  void testGetRichMessageWithPathFallback_thenReturnInsertionIsNull() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    memoryConfiguration.addDefault("Path", "Value");

    // Act
    Component actualRichMessage = memoryConfiguration.getRichMessage("Path", mock(Component.class));

    // Assert
    assertNull(actualRichMessage.insertion());
    assertNull(actualRichMessage.font());
    assertNull(actualRichMessage.color());
    Map<TextDecoration, State> decorationsResult = actualRichMessage.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualRichMessage.hasStyling());
    Component actualCompactResult = actualRichMessage.compact();
    assertEquals(actualRichMessage, actualCompactResult);
  }

  /**
   * Test {@link ConfigurationSection#getRichMessage(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSection#getRichMessage(String)}
   */
  @Test
  @DisplayName(
      "Test getRichMessage(String) with 'path'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ConfigurationSection.getRichMessage(String)"})
  void testGetRichMessageWithPath_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    Component actualRichMessage = memoryConfiguration.getRichMessage("Path");

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertNull(actualRichMessage);
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link ConfigurationSection#getRichMessage(String)} with {@code path}.
   *
   * <ul>
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSection#getRichMessage(String)}
   */
  @Test
  @DisplayName("Test getRichMessage(String) with 'path'; then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ConfigurationSection.getRichMessage(String)"})
  void testGetRichMessageWithPath_thenReturnInsertionIsNull() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();
    memoryConfiguration.addDefault("Path", "Value");

    // Act
    Component actualRichMessage = memoryConfiguration.getRichMessage("Path");

    // Assert
    assertNull(actualRichMessage.insertion());
    assertNull(actualRichMessage.font());
    assertNull(actualRichMessage.color());
    Map<TextDecoration, State> decorationsResult = actualRichMessage.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualRichMessage.hasStyling());
    Component actualCompactResult = actualRichMessage.compact();
    assertEquals(actualRichMessage, actualCompactResult);
  }

  /**
   * Test {@link ConfigurationSection#setRichMessage(String, Component)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link
   *       MemoryConfiguration#options} pathSeparator is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSection#setRichMessage(String, Component)}
   */
  @Test
  @DisplayName(
      "Test setRichMessage(String, Component); when 'null'; then MemoryConfiguration() options pathSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigurationSection.setRichMessage(String, Component)"})
  void testSetRichMessage_whenNull_thenMemoryConfigurationOptionsPathSeparatorIsDot() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    // Act
    memoryConfiguration.setRichMessage("Path", null);

    // Assert
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link ConfigurationSection#getComponent(String, ComponentDecoder)} with {@code path},
   * {@code decoder}.
   *
   * <p>Method under test: {@link ConfigurationSection#getComponent(String, ComponentDecoder)}
   */
  @Test
  @DisplayName("Test getComponent(String, ComponentDecoder) with 'path', 'decoder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component ConfigurationSection.getComponent(String, ComponentDecoder)"})
  void testGetComponentWithPathDecoder() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    ComponentDecoder<String, Component> decoder = mock(ComponentDecoder.class);
    when(decoder.deserializeOr(Mockito.<String>any(), Mockito.<Component>any()))
        .thenReturn(mock(Component.class));

    // Act
    memoryConfiguration.getComponent("Path", decoder);

    // Assert
    verify(decoder).deserializeOr(isNull(), isNull());
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link ConfigurationSection#getComponent(String, ComponentDecoder, Component)} with {@code
   * path}, {@code decoder}, {@code fallback}.
   *
   * <p>Method under test: {@link ConfigurationSection#getComponent(String, ComponentDecoder,
   * Component)}
   */
  @Test
  @DisplayName(
      "Test getComponent(String, ComponentDecoder, Component) with 'path', 'decoder', 'fallback'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Component ConfigurationSection.getComponent(String, ComponentDecoder, Component)"
  })
  void testGetComponentWithPathDecoderFallback() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    ComponentDecoder<String, Component> decoder = mock(ComponentDecoder.class);
    when(decoder.deserializeOr(Mockito.<String>any(), Mockito.<Component>any()))
        .thenReturn(mock(Component.class));

    // Act
    memoryConfiguration.getComponent("Path", decoder, mock(Component.class));

    // Assert
    verify(decoder).deserializeOr(isNull(), isA(Component.class));
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
  }

  /**
   * Test {@link ConfigurationSection#setComponent(String, ComponentEncoder, Component)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then {@link MemoryConfiguration#MemoryConfiguration()} {@link MemorySection#map} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ConfigurationSection#setComponent(String, ComponentEncoder,
   * Component)}
   */
  @Test
  @DisplayName(
      "Test setComponent(String, ComponentEncoder, Component); when 'Path'; then MemoryConfiguration() map size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConfigurationSection.setComponent(String, ComponentEncoder, Component)"})
  void testSetComponent_whenPath_thenMemoryConfigurationMapSizeIsOne() {
    // Arrange
    MemoryConfiguration memoryConfiguration = new MemoryConfiguration();

    ComponentEncoder<Component, String> encoder = mock(ComponentEncoder.class);
    when(encoder.serializeOrNull(Mockito.<Component>any())).thenReturn("Serialize Or Null");

    // Act
    memoryConfiguration.setComponent("Path", encoder, mock(Component.class));

    // Assert
    verify(encoder).serializeOrNull(isA(Component.class));
    Map<String, SectionPathData> stringSectionPathDataMap = memoryConfiguration.map;
    assertEquals(1, stringSectionPathDataMap.size());
    SectionPathData getResult = stringSectionPathDataMap.get("Path");
    assertEquals("Serialize Or Null", getResult.getData());
    MemoryConfigurationOptions memoryConfigurationOptions = memoryConfiguration.options;
    assertEquals('.', memoryConfigurationOptions.pathSeparator());
    assertFalse(memoryConfigurationOptions.copyDefaults());
    List<String> comments = getResult.getComments();
    assertTrue(comments.isEmpty());
    assertSame(memoryConfiguration, memoryConfigurationOptions.configuration());
    assertSame(comments, getResult.getInlineComments());
  }
}
