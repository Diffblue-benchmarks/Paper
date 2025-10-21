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
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegacyComponentSerializerProviderImplDiffblueTest {
  /**
   * Test {@link LegacyComponentSerializerProviderImpl#legacyAmpersand()}.
   *
   * <p>Method under test: {@link LegacyComponentSerializerProviderImpl#legacyAmpersand()}
   */
  @Test
  @DisplayName("Test legacyAmpersand()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegacyComponentSerializer LegacyComponentSerializerProviderImpl.legacyAmpersand()"
  })
  void testLegacyAmpersand() {
    // Arrange and Act
    LegacyComponentSerializer actualLegacyAmpersandResult =
        new LegacyComponentSerializerProviderImpl().legacyAmpersand();

    // Assert
    TextComponent deseializeOrNullResult = actualLegacyAmpersandResult.deseializeOrNull("Input");
    assertNull(deseializeOrNullResult.insertion());
    assertNull(actualLegacyAmpersandResult.serializeOrNull(null));
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
    assertEquals(deseializeOrNullResult, actualLegacyAmpersandResult.deserializeOrNull("Input"));
  }

  /**
   * Test {@link LegacyComponentSerializerProviderImpl#legacySection()}.
   *
   * <p>Method under test: {@link LegacyComponentSerializerProviderImpl#legacySection()}
   */
  @Test
  @DisplayName("Test legacySection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegacyComponentSerializer LegacyComponentSerializerProviderImpl.legacySection()"
  })
  void testLegacySection() {
    // Arrange and Act
    LegacyComponentSerializer actualLegacySectionResult =
        new LegacyComponentSerializerProviderImpl().legacySection();

    // Assert
    TextComponent deseializeOrNullResult = actualLegacySectionResult.deseializeOrNull("Input");
    assertNull(deseializeOrNullResult.insertion());
    assertNull(actualLegacySectionResult.serializeOrNull(null));
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
    assertEquals(deseializeOrNullResult, actualLegacySectionResult.deserializeOrNull("Input"));
  }

  /**
   * Test {@link LegacyComponentSerializerProviderImpl#legacy()}.
   *
   * <ul>
   *   <li>Then calls {@link Builder#flattener(ComponentFlattener)}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyComponentSerializerProviderImpl#legacy()}
   */
  @Test
  @DisplayName("Test legacy(); then calls flattener(ComponentFlattener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Consumer LegacyComponentSerializerProviderImpl.legacy()"})
  void testLegacy_thenCallsFlattener() {
    // Arrange and Act
    Consumer<Builder> actualLegacyResult = new LegacyComponentSerializerProviderImpl().legacy();
    Builder builder = mock(Builder.class);
    when(builder.flattener(Mockito.<ComponentFlattener>any())).thenReturn(mock(Builder.class));
    actualLegacyResult.accept(builder);

    // Assert
    verify(builder).flattener(isA(ComponentFlattener.class));
  }
}
