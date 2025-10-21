package io.papermc.paper.inventory.tooltip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TooltipContextImplDiffblueTest {
  /**
   * Test {@link TooltipContextImpl#asCreative()}.
   *
   * <p>Method under test: {@link TooltipContextImpl#asCreative()}
   */
  @Test
  @DisplayName("Test asCreative()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TooltipContext TooltipContextImpl.asCreative()"})
  void testAsCreative() {
    // Arrange
    TooltipContextImpl tooltipContextImpl = new TooltipContextImpl(true, true);

    // Act
    TooltipContext actualAsCreativeResult = tooltipContextImpl.asCreative();

    // Assert
    assertTrue(actualAsCreativeResult instanceof TooltipContextImpl);
    assertEquals(tooltipContextImpl, actualAsCreativeResult);
  }

  /**
   * Test {@link TooltipContextImpl#asAdvanced()}.
   *
   * <p>Method under test: {@link TooltipContextImpl#asAdvanced()}
   */
  @Test
  @DisplayName("Test asAdvanced()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TooltipContext TooltipContextImpl.asAdvanced()"})
  void testAsAdvanced() {
    // Arrange
    TooltipContextImpl tooltipContextImpl = new TooltipContextImpl(true, true);

    // Act
    TooltipContext actualAsAdvancedResult = tooltipContextImpl.asAdvanced();

    // Assert
    assertTrue(actualAsAdvancedResult instanceof TooltipContextImpl);
    assertEquals(tooltipContextImpl, actualAsAdvancedResult);
  }
}
