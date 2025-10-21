package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.HolderSet;
import net.minecraft.world.item.enchantment.Repairable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperRepairableDiffblueTest {
  /**
   * Test {@link PaperRepairable#getHandle()}.
   *
   * <p>Method under test: {@link PaperRepairable#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Repairable PaperRepairable.getHandle()"})
  void testGetHandle() {
    // Arrange
    Repairable impl = new Repairable(mock(HolderSet.class));

    // Act and Assert
    assertSame(impl, new PaperRepairable(impl).getHandle());
  }
}
