package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.function.Consumer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer.Builder;
import net.kyori.adventure.text.serializer.json.LegacyHoverEventSerializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GsonComponentSerializerProviderImplDiffblueTest {
  /**
   * Test {@link GsonComponentSerializerProviderImpl#gson()}.
   *
   * <p>Method under test: {@link GsonComponentSerializerProviderImpl#gson()}
   */
  @Test
  @DisplayName("Test gson()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsonComponentSerializer GsonComponentSerializerProviderImpl.gson()"})
  void testGson() {
    // Arrange and Act
    GsonComponentSerializer actualGsonResult = new GsonComponentSerializerProviderImpl().gson();

    // Assert
    Component deseializeOrNullResult = actualGsonResult.deseializeOrNull("Input");
    assertNull(deseializeOrNullResult.insertion());
    assertNull(actualGsonResult.serializeOrNull(null));
    assertNull(deseializeOrNullResult.font());
    assertNull(deseializeOrNullResult.color());
    Map<TextDecoration, State> decorationsResult = deseializeOrNullResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(deseializeOrNullResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    Component actualCompactResult = deseializeOrNullResult.compact();
    assertEquals(deseializeOrNullResult, actualCompactResult);
    assertEquals(deseializeOrNullResult, actualGsonResult.deserializeOrNull("Input"));
  }

  /**
   * Test {@link GsonComponentSerializerProviderImpl#gsonLegacy()}.
   *
   * <p>Method under test: {@link GsonComponentSerializerProviderImpl#gsonLegacy()}
   */
  @Test
  @DisplayName("Test gsonLegacy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GsonComponentSerializer GsonComponentSerializerProviderImpl.gsonLegacy()"})
  void testGsonLegacy() {
    // Arrange and Act
    GsonComponentSerializer actualGsonLegacyResult =
        new GsonComponentSerializerProviderImpl().gsonLegacy();

    // Assert
    Component deseializeOrNullResult = actualGsonLegacyResult.deseializeOrNull("Input");
    assertNull(deseializeOrNullResult.insertion());
    assertNull(actualGsonLegacyResult.serializeOrNull(null));
    assertNull(deseializeOrNullResult.font());
    assertNull(deseializeOrNullResult.color());
    Map<TextDecoration, State> decorationsResult = deseializeOrNullResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(deseializeOrNullResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    Component actualCompactResult = deseializeOrNullResult.compact();
    assertEquals(deseializeOrNullResult, actualCompactResult);
    assertEquals(deseializeOrNullResult, actualGsonLegacyResult.deserializeOrNull("Input"));
  }

  /**
   * Test {@link GsonComponentSerializerProviderImpl#builder()}.
   *
   * <ul>
   *   <li>Then calls {@link Builder#legacyHoverEventSerializer(LegacyHoverEventSerializer)}.
   * </ul>
   *
   * <p>Method under test: {@link GsonComponentSerializerProviderImpl#builder()}
   */
  @Test
  @DisplayName("Test builder(); then calls legacyHoverEventSerializer(LegacyHoverEventSerializer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Consumer GsonComponentSerializerProviderImpl.builder()"})
  void testBuilder_thenCallsLegacyHoverEventSerializer() {
    // Arrange and Act
    Consumer<Builder> actualBuilderResult = new GsonComponentSerializerProviderImpl().builder();
    Builder builder = mock(Builder.class);
    when(builder.legacyHoverEventSerializer(Mockito.<LegacyHoverEventSerializer>any()))
        .thenReturn(mock(Builder.class));
    actualBuilderResult.accept(builder);

    // Assert
    verify(builder).legacyHoverEventSerializer(isA(LegacyHoverEventSerializer.class));
  }
}
