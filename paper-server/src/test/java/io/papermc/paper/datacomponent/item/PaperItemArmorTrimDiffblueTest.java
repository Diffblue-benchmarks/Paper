package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Direct;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperItemArmorTrimDiffblueTest {
  /**
   * Test {@link PaperItemArmorTrim#getHandle()}.
   *
   * <p>Method under test: {@link PaperItemArmorTrim#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArmorTrim PaperItemArmorTrim.getHandle()"})
  void testGetHandle() {
    // Arrange
    TrimMaterial trimMaterial =
        new TrimMaterial(MaterialAssetGroup.AMETHYST, mock(Component.class));
    Direct<TrimMaterial> material = new Direct<>(trimMaterial);
    TrimPattern trimPattern =
        new TrimPattern(mock(ResourceLocation.class), mock(Component.class), true);
    ArmorTrim impl = new ArmorTrim(material, new Direct<>(trimPattern));

    // Act and Assert
    assertSame(impl, new PaperItemArmorTrim(impl).getHandle());
  }
}
