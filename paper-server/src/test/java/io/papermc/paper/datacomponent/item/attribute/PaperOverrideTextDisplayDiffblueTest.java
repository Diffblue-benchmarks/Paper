package io.papermc.paper.datacomponent.item.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.OverrideText;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperOverrideTextDisplayDiffblueTest {
  /**
   * Test {@link PaperOverrideTextDisplay#text()}.
   *
   * <ul>
   *   <li>Given {@link OverrideText#OverrideText(Component)} with component is {@code null}.
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperOverrideTextDisplay#text()}
   */
  @Test
  @DisplayName(
      "Test text(); given OverrideText(Component) with component is 'null'; then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PaperOverrideTextDisplay.text()"})
  void testText_givenOverrideTextWithComponentIsNull_thenReturnInsertionIsNull() {
    // Arrange and Act
    Component actualTextResult = new PaperOverrideTextDisplay(new OverrideText(null)).text();

    // Assert
    assertNull(actualTextResult.insertion());
    assertNull(actualTextResult.font());
    assertNull(actualTextResult.color());
    Map<TextDecoration, State> decorationsResult = actualTextResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualTextResult.hasStyling());
    Component actualCompactResult = actualTextResult.compact();
    assertSame(actualTextResult, actualCompactResult);
  }

  /**
   * Test {@link PaperOverrideTextDisplay#getHandle()}.
   *
   * <ul>
   *   <li>Given {@link PaperOverrideTextDisplay#PaperOverrideTextDisplay(OverrideText)} with impl
   *       is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperOverrideTextDisplay#getHandle()}
   */
  @Test
  @DisplayName(
      "Test getHandle(); given PaperOverrideTextDisplay(OverrideText) with impl is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverrideText PaperOverrideTextDisplay.getHandle()"})
  void testGetHandle_givenPaperOverrideTextDisplayWithImplIsNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PaperOverrideTextDisplay(null).getHandle());
  }
}
