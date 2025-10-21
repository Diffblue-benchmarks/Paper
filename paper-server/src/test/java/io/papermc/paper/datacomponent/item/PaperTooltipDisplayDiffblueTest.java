package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperTooltipDisplay.BuilderImpl;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperTooltipDisplayDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TooltipDisplay BuilderImpl.build()",
    "TooltipDisplay.Builder BuilderImpl.hideTooltip(boolean)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    TooltipDisplay actualTooltipDisplay = new BuilderImpl().build();

    // Assert
    assertTrue(actualTooltipDisplay instanceof PaperTooltipDisplay);
  }

  /**
   * Test BuilderImpl new {@link BuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BuilderImpl}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()"})
  void testBuilderImplNewBuilderImpl() {
    // Arrange, Act and Assert
    TooltipDisplay tooltipDisplay = new BuilderImpl().build();
    assertTrue(tooltipDisplay instanceof PaperTooltipDisplay);
    net.minecraft.world.item.component.TooltipDisplay handle =
        ((PaperTooltipDisplay) tooltipDisplay).getHandle();
    assertFalse(handle.hideTooltip());
    assertTrue(handle.hiddenComponents().isEmpty());
    assertSame(handle, ((PaperTooltipDisplay) tooltipDisplay).impl());
  }

  /**
   * Test {@link PaperTooltipDisplay#getHandle()}.
   *
   * <p>Method under test: {@link PaperTooltipDisplay#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.TooltipDisplay PaperTooltipDisplay.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperTooltipDisplay paperTooltipDisplay =
        new PaperTooltipDisplay(net.minecraft.world.item.component.TooltipDisplay.DEFAULT);

    // Act and Assert
    net.minecraft.world.item.component.TooltipDisplay tooltipDisplay =
        net.minecraft.world.item.component.TooltipDisplay.DEFAULT;
    assertSame(tooltipDisplay, paperTooltipDisplay.getHandle());
    assertSame(tooltipDisplay, paperTooltipDisplay.impl());
  }

  /**
   * Test {@link PaperTooltipDisplay#hideTooltip()}.
   *
   * <ul>
   *   <li>Given {@link PaperTooltipDisplay#PaperTooltipDisplay(TooltipDisplay)} with impl is {@link
   *       net.minecraft.world.item.component.TooltipDisplay#DEFAULT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperTooltipDisplay#hideTooltip()}
   */
  @Test
  @DisplayName(
      "Test hideTooltip(); given PaperTooltipDisplay(TooltipDisplay) with impl is DEFAULT; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperTooltipDisplay.hideTooltip()"})
  void testHideTooltip_givenPaperTooltipDisplayWithImplIsDefault_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new PaperTooltipDisplay(net.minecraft.world.item.component.TooltipDisplay.DEFAULT)
            .hideTooltip());
  }

  /**
   * Test {@link PaperTooltipDisplay#hideTooltip()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperTooltipDisplay#hideTooltip()}
   */
  @Test
  @DisplayName("Test hideTooltip(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperTooltipDisplay.hideTooltip()"})
  void testHideTooltip_thenReturnTrue() {
    // Arrange
    net.minecraft.world.item.component.TooltipDisplay impl =
        new net.minecraft.world.item.component.TooltipDisplay(true, new LinkedHashSet<>());

    // Act and Assert
    assertTrue(new PaperTooltipDisplay(impl).hideTooltip());
  }

  /**
   * Test {@link PaperTooltipDisplay#hiddenComponents()}.
   *
   * <ul>
   *   <li>Given {@link PaperTooltipDisplay#PaperTooltipDisplay(TooltipDisplay)} with impl is {@link
   *       net.minecraft.world.item.component.TooltipDisplay#DEFAULT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperTooltipDisplay#hiddenComponents()}
   */
  @Test
  @DisplayName(
      "Test hiddenComponents(); given PaperTooltipDisplay(TooltipDisplay) with impl is DEFAULT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set PaperTooltipDisplay.hiddenComponents()"})
  void testHiddenComponents_givenPaperTooltipDisplayWithImplIsDefault_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperTooltipDisplay(net.minecraft.world.item.component.TooltipDisplay.DEFAULT)
            .hiddenComponents()
            .isEmpty());
  }
}
