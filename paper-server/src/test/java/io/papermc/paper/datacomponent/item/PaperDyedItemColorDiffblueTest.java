package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperDyedItemColor.BuilderImpl;
import org.bukkit.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDyedItemColorDiffblueTest {
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
    "DyedItemColor BuilderImpl.build()",
    "DyedItemColor.Builder BuilderImpl.color(Color)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    DyedItemColor actualDyedItemColor = new BuilderImpl().build();

    // Assert
    assertTrue(actualDyedItemColor instanceof PaperDyedItemColor);
  }

  /**
   * Test {@link PaperDyedItemColor#getHandle()}.
   *
   * <p>Method under test: {@link PaperDyedItemColor#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.DyedItemColor PaperDyedItemColor.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    net.minecraft.world.item.component.DyedItemColor impl =
        new net.minecraft.world.item.component.DyedItemColor(1);

    // Act
    net.minecraft.world.item.component.DyedItemColor actualHandle =
        new PaperDyedItemColor(impl).getHandle();

    // Assert
    assertEquals(1, actualHandle.rgb());
    assertSame(impl, actualHandle);
  }

  /**
   * Test {@link PaperDyedItemColor#color()}.
   *
   * <ul>
   *   <li>Given {@link net.minecraft.world.item.component.DyedItemColor#DyedItemColor(int)} with
   *       rgb is one.
   *   <li>Then return Green is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperDyedItemColor#color()}
   */
  @Test
  @DisplayName("Test color(); given DyedItemColor(int) with rgb is one; then return Green is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color PaperDyedItemColor.color()"})
  void testColor_givenDyedItemColorWithRgbIsOne_thenReturnGreenIsZero() {
    // Arrange and Act
    Color actualColorResult =
        new PaperDyedItemColor(new net.minecraft.world.item.component.DyedItemColor(1)).color();

    // Assert
    assertEquals(0, actualColorResult.getGreen());
    assertEquals(0, actualColorResult.getRed());
    assertEquals(1, actualColorResult.getBlue());
    assertEquals(255, actualColorResult.getAlpha());
  }
}
