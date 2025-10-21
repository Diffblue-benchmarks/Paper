package io.papermc.paper.inventory.tooltip;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TooltipContextDiffblueTest {
  /**
   * Test {@link TooltipContext#create()}.
   *
   * <p>Method under test: {@link TooltipContext#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TooltipContext TooltipContext.create()"})
  void testCreate() {
    // Arrange and Act
    TooltipContext actualCreateResult = TooltipContext.create();

    // Assert
    assertTrue(actualCreateResult instanceof TooltipContextImpl);
    assertFalse(actualCreateResult.isAdvanced());
    assertFalse(actualCreateResult.isCreative());
  }

  /**
   * Test {@link TooltipContext#create(boolean, boolean)} with {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link TooltipContext#create(boolean, boolean)}
   */
  @Test
  @DisplayName("Test create(boolean, boolean) with 'boolean', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TooltipContext TooltipContext.create(boolean, boolean)"})
  void testCreateWithBooleanBoolean() {
    // Arrange and Act
    TooltipContext actualCreateResult = TooltipContext.create(true, true);

    // Assert
    assertTrue(actualCreateResult instanceof TooltipContextImpl);
    assertTrue(actualCreateResult.isAdvanced());
    assertTrue(actualCreateResult.isCreative());
  }
}
