package io.papermc.paper.scoreboard.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.Style.Builder;
import net.kyori.adventure.text.format.StyleBuilderApplicable;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NumberFormatDiffblueTest {
  /**
   * Test {@link NumberFormat#blank()}.
   *
   * <p>Method under test: {@link NumberFormat#blank()}
   */
  @Test
  @DisplayName("Test blank()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NumberFormat NumberFormat.blank()"})
  void testBlank() {
    // Arrange, Act and Assert
    assertTrue(NumberFormat.blank() instanceof BlankFormatImpl);
  }

  /**
   * Test {@link NumberFormat#noStyle()}.
   *
   * <p>Method under test: {@link NumberFormat#noStyle()}
   */
  @Test
  @DisplayName("Test noStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StyledFormat NumberFormat.noStyle()"})
  void testNoStyle() {
    // Arrange and Act
    StyledFormat actualNoStyleResult = NumberFormat.noStyle();

    // Assert
    assertTrue(actualNoStyleResult instanceof StyledFormatImpl);
    Map<TextDecoration, State> decorationsResult = actualNoStyleResult.style().decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
  }

  /**
   * Test {@link NumberFormat#styled(Style)} with {@code style}.
   *
   * <p>Method under test: {@link NumberFormat#styled(Style)}
   */
  @Test
  @DisplayName("Test styled(Style) with 'style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StyledFormat NumberFormat.styled(Style)"})
  void testStyledWithStyle() {
    // Arrange
    Style style = mock(Style.class);

    // Act
    StyledFormat actualStyledResult = NumberFormat.styled(style);

    // Assert
    assertTrue(actualStyledResult instanceof StyledFormatImpl);
    assertSame(style, actualStyledResult.style());
  }

  /**
   * Test {@link NumberFormat#styled(StyleBuilderApplicable[])} with {@code
   * styleBuilderApplicables}.
   *
   * <p>Method under test: {@link NumberFormat#styled(StyleBuilderApplicable[])}
   */
  @Test
  @DisplayName("Test styled(StyleBuilderApplicable[]) with 'styleBuilderApplicables'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StyledFormat NumberFormat.styled(StyleBuilderApplicable[])"})
  void testStyledWithStyleBuilderApplicables() {
    // Arrange and Act
    StyledFormat actualStyledResult = NumberFormat.styled();

    // Assert
    assertTrue(actualStyledResult instanceof StyledFormatImpl);
    Map<TextDecoration, State> decorationsResult = actualStyledResult.style().decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
  }

  /**
   * Test {@link NumberFormat#styled(StyleBuilderApplicable[])} with {@code
   * styleBuilderApplicables}.
   *
   * <ul>
   *   <li>Then calls {@link StyleBuilderApplicable#styleApply(Builder)}.
   * </ul>
   *
   * <p>Method under test: {@link NumberFormat#styled(StyleBuilderApplicable[])}
   */
  @Test
  @DisplayName(
      "Test styled(StyleBuilderApplicable[]) with 'styleBuilderApplicables'; then calls styleApply(Builder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StyledFormat NumberFormat.styled(StyleBuilderApplicable[])"})
  void testStyledWithStyleBuilderApplicables_thenCallsStyleApply() {
    // Arrange
    StyleBuilderApplicable styleBuilderApplicable = mock(StyleBuilderApplicable.class);
    doNothing().when(styleBuilderApplicable).styleApply(Mockito.<Builder>any());

    // Act
    StyledFormat actualStyledResult = NumberFormat.styled(styleBuilderApplicable);

    // Assert
    verify(styleBuilderApplicable).styleApply(isA(Builder.class));
    assertTrue(actualStyledResult instanceof StyledFormatImpl);
    Map<TextDecoration, State> decorationsResult = actualStyledResult.style().decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
  }

  /**
   * Test {@link NumberFormat#fixed(ComponentLike)}.
   *
   * <p>Method under test: {@link NumberFormat#fixed(ComponentLike)}
   */
  @Test
  @DisplayName("Test fixed(ComponentLike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FixedFormat NumberFormat.fixed(ComponentLike)"})
  void testFixed() {
    // Arrange
    ComponentLike component = mock(ComponentLike.class);
    when(component.asComponent()).thenReturn(mock(Component.class));

    // Act
    FixedFormat actualFixedResult = NumberFormat.fixed(component);

    // Assert
    verify(component).asComponent();
    assertTrue(actualFixedResult instanceof FixedFormatImpl);
  }
}
