package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperDyedItemColor.BuilderImpl;
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
    "DyedItemColor.Builder BuilderImpl.color(org.bukkit.Color)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    DyedItemColor actualDyedItemColor = new BuilderImpl().build();

    // Assert
    assertTrue(actualDyedItemColor instanceof PaperDyedItemColor);
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
    DyedItemColor dyedItemColor = new BuilderImpl().build();
    assertTrue(dyedItemColor instanceof PaperDyedItemColor);
    net.minecraft.world.item.component.DyedItemColor handle =
        ((PaperDyedItemColor) dyedItemColor).getHandle();
    assertEquals(16777215, handle.rgb());
    assertSame(handle, ((PaperDyedItemColor) dyedItemColor).impl());
  }
}
