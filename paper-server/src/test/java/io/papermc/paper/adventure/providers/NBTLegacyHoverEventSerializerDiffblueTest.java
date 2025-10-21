package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEvent.ShowEntity;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.adventure.util.Codec;
import net.kyori.adventure.util.Codec.Decoder;
import net.kyori.adventure.util.Codec.Encoder;
import net.minecraft.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NBTLegacyHoverEventSerializerDiffblueTest {
  /**
   * Test {@link NBTLegacyHoverEventSerializer#deserializeShowItem(Component)}.
   *
   * <p>Method under test: {@link NBTLegacyHoverEventSerializer#deserializeShowItem(Component)}
   */
  @Test
  @DisplayName("Test deserializeShowItem(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HoverEvent.ShowItem NBTLegacyHoverEventSerializer.deserializeShowItem(Component)"
  })
  void testDeserializeShowItem() throws IOException {
    // Arrange
    Component input = mock(Component.class);
    when(input.children()).thenReturn(new ArrayList<>());
    when(input.style()).thenReturn(mock(Style.class));

    // Act and Assert
    assertThrows(
        IOException.class, () -> NBTLegacyHoverEventSerializer.INSTANCE.deserializeShowItem(input));
    verify(input).children();
    verify(input).style();
  }

  /**
   * Test {@link NBTLegacyHoverEventSerializer#deserializeShowEntity(Component, Decoder)}.
   *
   * <p>Method under test: {@link NBTLegacyHoverEventSerializer#deserializeShowEntity(Component,
   * Decoder)}
   */
  @Test
  @DisplayName("Test deserializeShowEntity(Component, Decoder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HoverEvent.ShowEntity NBTLegacyHoverEventSerializer.deserializeShowEntity(Component, Decoder)"
  })
  void testDeserializeShowEntity() throws IOException {
    // Arrange
    Component input = mock(Component.class);
    when(input.children()).thenReturn(new ArrayList<>());
    when(input.style()).thenReturn(mock(Style.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            NBTLegacyHoverEventSerializer.INSTANCE.deserializeShowEntity(
                input, mock(Decoder.class)));
    verify(input).children();
    verify(input).style();
  }

  /**
   * Test {@link NBTLegacyHoverEventSerializer#serializeShowEntity(ShowEntity, Encoder)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link Codec.Encoder} {@link Codec.Encoder#encode(Object)} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * NBTLegacyHoverEventSerializer#serializeShowEntity(HoverEvent.ShowEntity, Codec.Encoder)}
   */
  @Test
  @DisplayName(
      "Test serializeShowEntity(ShowEntity, Encoder); given empty string; when Encoder encode(Object) return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Component NBTLegacyHoverEventSerializer.serializeShowEntity(HoverEvent.ShowEntity, Codec.Encoder)"
  })
  void testSerializeShowEntity_givenEmptyString_whenEncoderEncodeReturnEmptyString()
      throws Throwable {
    // Arrange
    ShowEntity input =
        ShowEntity.of(
            ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY,
            Util.NIL_UUID,
            mock(Component.class));

    Encoder<Component, String, RuntimeException> componentCodec = mock(Encoder.class);
    when(componentCodec.encode(Mockito.<Component>any())).thenReturn("");

    // Act
    Component actualSerializeShowEntityResult =
        NBTLegacyHoverEventSerializer.INSTANCE.serializeShowEntity(input, componentCodec);

    // Assert
    verify(componentCodec).encode(isA(Component.class));
    assertNull(actualSerializeShowEntityResult.insertion());
    assertNull(actualSerializeShowEntityResult.font());
    assertNull(actualSerializeShowEntityResult.color());
    Map<TextDecoration, State> decorationsResult = actualSerializeShowEntityResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualSerializeShowEntityResult.hasStyling());
    Component actualCompactResult = actualSerializeShowEntityResult.compact();
    assertEquals(actualSerializeShowEntityResult, actualCompactResult);
  }

  /**
   * Test {@link NBTLegacyHoverEventSerializer#serializeShowEntity(ShowEntity, Encoder)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NBTLegacyHoverEventSerializer#serializeShowEntity(HoverEvent.ShowEntity, Codec.Encoder)}
   */
  @Test
  @DisplayName(
      "Test serializeShowEntity(ShowEntity, Encoder); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Component NBTLegacyHoverEventSerializer.serializeShowEntity(HoverEvent.ShowEntity, Codec.Encoder)"
  })
  void testSerializeShowEntity_givenIOException_thenThrowIOException() throws Throwable {
    // Arrange
    ShowEntity input =
        ShowEntity.of(
            ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY,
            Util.NIL_UUID,
            mock(Component.class));

    Encoder<Component, String, RuntimeException> componentCodec = mock(Encoder.class);
    when(componentCodec.encode(Mockito.<Component>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> NBTLegacyHoverEventSerializer.INSTANCE.serializeShowEntity(input, componentCodec));
    verify(componentCodec).encode(isA(Component.class));
  }

  /**
   * Test {@link NBTLegacyHoverEventSerializer#serializeShowEntity(ShowEntity, Encoder)}.
   *
   * <ul>
   *   <li>Given {@code secret}.
   *   <li>When {@link Codec.Encoder} {@link Codec.Encoder#encode(Object)} return {@code secret}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NBTLegacyHoverEventSerializer#serializeShowEntity(HoverEvent.ShowEntity, Codec.Encoder)}
   */
  @Test
  @DisplayName(
      "Test serializeShowEntity(ShowEntity, Encoder); given 'secret'; when Encoder encode(Object) return 'secret'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Component NBTLegacyHoverEventSerializer.serializeShowEntity(HoverEvent.ShowEntity, Codec.Encoder)"
  })
  void testSerializeShowEntity_givenSecret_whenEncoderEncodeReturnSecret() throws Throwable {
    // Arrange
    ShowEntity input =
        ShowEntity.of(
            ClickCallbackProviderImpl.DIALOG_CLICK_CALLBACK_KEY,
            Util.NIL_UUID,
            mock(Component.class));

    Encoder<Component, String, RuntimeException> componentCodec = mock(Encoder.class);
    when(componentCodec.encode(Mockito.<Component>any())).thenReturn("secret");

    // Act
    Component actualSerializeShowEntityResult =
        NBTLegacyHoverEventSerializer.INSTANCE.serializeShowEntity(input, componentCodec);

    // Assert
    verify(componentCodec).encode(isA(Component.class));
    assertNull(actualSerializeShowEntityResult.insertion());
    assertNull(actualSerializeShowEntityResult.font());
    assertNull(actualSerializeShowEntityResult.color());
    Map<TextDecoration, State> decorationsResult = actualSerializeShowEntityResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualSerializeShowEntityResult.hasStyling());
    Component actualCompactResult = actualSerializeShowEntityResult.compact();
    assertEquals(actualSerializeShowEntityResult, actualCompactResult);
  }
}
