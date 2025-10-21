package io.papermc.paper.datacomponent.item.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Hidden;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperHiddenDisplayDiffblueTest {
  /**
   * Test {@link PaperHiddenDisplay#getHandle()}.
   *
   * <p>Method under test: {@link PaperHiddenDisplay#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemAttributeModifiers.Display.Hidden PaperHiddenDisplay.getHandle()"})
  void testGetHandle() {
    // Arrange
    Hidden impl = new Hidden();

    // Act
    Hidden actualHandle = new PaperHiddenDisplay(impl).getHandle();

    // Assert
    assertEquals(Type.HIDDEN, actualHandle.type());
    assertSame(impl, actualHandle);
  }
}
