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
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlainTextComponentSerializerProviderImplDiffblueTest {
  /**
   * Test {@link PlainTextComponentSerializerProviderImpl#plainTextSimple()}.
   *
   * <p>Method under test: {@link PlainTextComponentSerializerProviderImpl#plainTextSimple()}
   */
  @Test
  @DisplayName("Test plainTextSimple()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlainTextComponentSerializer PlainTextComponentSerializerProviderImpl.plainTextSimple()"
  })
  void testPlainTextSimple() {
    // Arrange and Act
    PlainTextComponentSerializer actualPlainTextSimpleResult =
        new PlainTextComponentSerializerProviderImpl().plainTextSimple();

    // Assert
    TextComponent deseializeOrNullResult = actualPlainTextSimpleResult.deseializeOrNull("Input");
    assertNull(deseializeOrNullResult.insertion());
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
    assertEquals(deseializeOrNullResult, actualPlainTextSimpleResult.deserializeOrNull("Input"));
    assertEquals(deseializeOrNullResult, actualPlainTextSimpleResult.deserialize("Input"));
  }

  /**
   * Test {@link PlainTextComponentSerializerProviderImpl#plainText()}.
   *
   * <ul>
   *   <li>Then calls {@link Builder#flattener(ComponentFlattener)}.
   * </ul>
   *
   * <p>Method under test: {@link PlainTextComponentSerializerProviderImpl#plainText()}
   */
  @Test
  @DisplayName("Test plainText(); then calls flattener(ComponentFlattener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Consumer PlainTextComponentSerializerProviderImpl.plainText()"})
  void testPlainText_thenCallsFlattener() {
    // Arrange and Act
    Consumer<Builder> actualPlainTextResult =
        new PlainTextComponentSerializerProviderImpl().plainText();
    Builder builder = mock(Builder.class);
    when(builder.flattener(Mockito.<ComponentFlattener>any())).thenReturn(mock(Builder.class));
    actualPlainTextResult.accept(builder);

    // Assert
    verify(builder).flattener(isA(ComponentFlattener.class));
  }
}
