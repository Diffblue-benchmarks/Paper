package io.papermc.paper.advancement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.advancement.AdvancementDisplay.Frame;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdvancementDisplayDiffblueTest {
  /**
   * Test Frame {@link Frame#color()}.
   *
   * <p>Method under test: {@link Frame#color()}
   */
  @Test
  @DisplayName("Test Frame color()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextColor Frame.color()"})
  void testFrameColor() {
    // Arrange and Act
    TextColor actualColorResult = Frame.valueOf("CHALLENGE").color();

    // Assert
    assertSame(((NamedTextColor) actualColorResult).DARK_PURPLE, actualColorResult);
  }

  /**
   * Test Frame {@link Frame#translationKey()}.
   *
   * <p>Method under test: {@link Frame#translationKey()}
   */
  @Test
  @DisplayName("Test Frame translationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Frame.translationKey()"})
  void testFrameTranslationKey() {
    // Arrange, Act and Assert
    assertEquals("advancements.toast.challenge", Frame.CHALLENGE.translationKey());
  }
}
