package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingsDiffblueTest {
  /**
   * Test {@link Timings#deprecationMessage()}.
   *
   * <p>Method under test: {@link Timings#deprecationMessage()}
   */
  @Test
  @DisplayName("Test deprecationMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component Timings.deprecationMessage()"})
  void testDeprecationMessage() {
    // Arrange and Act
    Component actualDeprecationMessageResult = Timings.deprecationMessage();

    // Assert
    Component compactResult = actualDeprecationMessageResult.compact();
    assertNull(compactResult.insertion());
    assertNull(actualDeprecationMessageResult.insertion());
    assertNull(compactResult.font());
    assertNull(actualDeprecationMessageResult.font());
    Map<TextDecoration, State> decorationsResult = actualDeprecationMessageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertTrue(compactResult.hasStyling());
    assertTrue(actualDeprecationMessageResult.hasStyling());
    assertEquals(compactResult.compact(), compactResult.compact());
    assertSame(decorationsResult, compactResult.decorations());
  }
}
