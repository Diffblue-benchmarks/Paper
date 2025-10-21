package io.papermc.paper.scoreboard.numbers;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.Style.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StyledFormatImplDiffblueTest {
  /**
   * Test {@link StyledFormatImpl#styleApply(Builder)}.
   *
   * <p>Method under test: {@link StyledFormatImpl#styleApply(Builder)}
   */
  @Test
  @DisplayName("Test styleApply(Builder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StyledFormatImpl.styleApply(Builder)"})
  void testStyleApply() {
    // Arrange
    StyledFormatImpl styledFormatImpl = new StyledFormatImpl(mock(Style.class));

    Builder style = mock(Builder.class);
    when(style.merge(Mockito.<Style>any())).thenReturn(mock(Builder.class));

    // Act
    styledFormatImpl.styleApply(style);

    // Assert
    verify(style).merge(isA(Style.class));
  }
}
