package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperBannerPatternLayers.BuilderImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperBannerPatternLayersDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BannerPatternLayers BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    BannerPatternLayers actualBannerPatternLayers = new BuilderImpl().build();

    // Assert
    assertTrue(actualBannerPatternLayers instanceof PaperBannerPatternLayers);
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
    BannerPatternLayers bannerPatternLayers = new BuilderImpl().build();
    assertTrue(bannerPatternLayers instanceof PaperBannerPatternLayers);
    net.minecraft.world.level.block.entity.BannerPatternLayers handle =
        ((PaperBannerPatternLayers) bannerPatternLayers).getHandle();
    assertTrue(handle.layers().isEmpty());
    assertSame(handle, ((PaperBannerPatternLayers) bannerPatternLayers).impl());
  }

  /**
   * Test {@link PaperBannerPatternLayers#getHandle()}.
   *
   * <p>Method under test: {@link PaperBannerPatternLayers#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.level.block.entity.BannerPatternLayers PaperBannerPatternLayers.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperBannerPatternLayers paperBannerPatternLayers =
        new PaperBannerPatternLayers(
            net.minecraft.world.level.block.entity.BannerPatternLayers.EMPTY);

    // Act
    net.minecraft.world.level.block.entity.BannerPatternLayers actualHandle =
        paperBannerPatternLayers.getHandle();

    // Assert
    assertTrue(actualHandle.layers().isEmpty());
    net.minecraft.world.level.block.entity.BannerPatternLayers bannerPatternLayers =
        net.minecraft.world.level.block.entity.BannerPatternLayers.EMPTY;
    assertSame(bannerPatternLayers, actualHandle);
    assertSame(bannerPatternLayers, paperBannerPatternLayers.impl());
  }

  /**
   * Test {@link PaperBannerPatternLayers#patterns()}.
   *
   * <ul>
   *   <li>Given {@link PaperBannerPatternLayers#PaperBannerPatternLayers(BannerPatternLayers)} with
   *       impl is {@link net.minecraft.world.level.block.entity.BannerPatternLayers#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperBannerPatternLayers#patterns()}
   */
  @Test
  @DisplayName(
      "Test patterns(); given PaperBannerPatternLayers(BannerPatternLayers) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PaperBannerPatternLayers.patterns()"})
  void testPatterns_givenPaperBannerPatternLayersWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperBannerPatternLayers(
                net.minecraft.world.level.block.entity.BannerPatternLayers.EMPTY)
            .patterns()
            .isEmpty());
  }
}
