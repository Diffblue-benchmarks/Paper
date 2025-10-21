package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MiniMessageProviderImplDiffblueTest {
  /**
   * Test {@link MiniMessageProviderImpl#miniMessage()}.
   *
   * <p>Method under test: {@link MiniMessageProviderImpl#miniMessage()}
   */
  @Test
  @DisplayName("Test miniMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MiniMessage MiniMessageProviderImpl.miniMessage()"})
  void testMiniMessage() {
    // Arrange and Act
    MiniMessage actualMiniMessageResult = new MiniMessageProviderImpl().miniMessage();

    // Assert
    Component deseializeOrNullResult = actualMiniMessageResult.deseializeOrNull("Input");
    assertNull(deseializeOrNullResult.insertion());
    assertNull(actualMiniMessageResult.serializeOrNull(null));
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
    assertEquals(deseializeOrNullResult, actualMiniMessageResult.deserializeOrNull("Input"));
  }
}
