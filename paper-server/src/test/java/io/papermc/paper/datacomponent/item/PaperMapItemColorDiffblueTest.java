package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperMapItemColor.BuilderImpl;
import org.bukkit.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperMapItemColorDiffblueTest {
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
    "MapItemColor BuilderImpl.build()",
    "MapItemColor.Builder BuilderImpl.color(Color)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    MapItemColor actualMapItemColor = new BuilderImpl().build();

    // Assert
    assertTrue(actualMapItemColor instanceof PaperMapItemColor);
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
    MapItemColor mapItemColor = new BuilderImpl().build();
    assertTrue(mapItemColor instanceof PaperMapItemColor);
    net.minecraft.world.item.component.MapItemColor handle =
        ((PaperMapItemColor) mapItemColor).getHandle();
    assertEquals(4603950, handle.rgb());
    assertSame(handle, ((PaperMapItemColor) mapItemColor).impl());
  }

  /**
   * Test {@link PaperMapItemColor#getHandle()}.
   *
   * <p>Method under test: {@link PaperMapItemColor#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.MapItemColor PaperMapItemColor.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperMapItemColor paperMapItemColor =
        new PaperMapItemColor(net.minecraft.world.item.component.MapItemColor.DEFAULT);

    // Act
    net.minecraft.world.item.component.MapItemColor actualHandle = paperMapItemColor.getHandle();

    // Assert
    assertEquals(4603950, actualHandle.rgb());
    net.minecraft.world.item.component.MapItemColor mapItemColor =
        net.minecraft.world.item.component.MapItemColor.DEFAULT;
    assertSame(mapItemColor, actualHandle);
    assertSame(mapItemColor, paperMapItemColor.impl());
  }

  /**
   * Test {@link PaperMapItemColor#color()}.
   *
   * <ul>
   *   <li>Then return Alpha is two hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link PaperMapItemColor#color()}
   */
  @Test
  @DisplayName("Test color(); then return Alpha is two hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color PaperMapItemColor.color()"})
  void testColor_thenReturnAlphaIsTwoHundredFiftyFive() {
    // Arrange and Act
    Color actualColorResult =
        new PaperMapItemColor(net.minecraft.world.item.component.MapItemColor.DEFAULT).color();

    // Assert
    assertEquals(255, actualColorResult.getAlpha());
    assertEquals(46, actualColorResult.getBlue());
    assertEquals(70, actualColorResult.getRed());
    assertEquals(Double.SIZE, actualColorResult.getGreen());
  }
}
