package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.item.component.DamageResistant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDamageResistantDiffblueTest {
  /**
   * Test {@link PaperDamageResistant#getHandle()}.
   *
   * <p>Method under test: {@link PaperDamageResistant#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageResistant PaperDamageResistant.getHandle()"})
  void testGetHandle() {
    // Arrange
    DamageResistant impl = new DamageResistant(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);

    // Act and Assert
    assertSame(impl, new PaperDamageResistant(impl).getHandle());
  }
}
