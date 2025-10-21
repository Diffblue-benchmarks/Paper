package io.papermc.paper.datacomponent.item.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Default;
import net.minecraft.world.item.component.ItemAttributeModifiers.Display.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDefaultDisplayDiffblueTest {
  /**
   * Test {@link PaperDefaultDisplay#getHandle()}.
   *
   * <p>Method under test: {@link PaperDefaultDisplay#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemAttributeModifiers.Display.Default PaperDefaultDisplay.getHandle()"})
  void testGetHandle() {
    // Arrange
    Default impl = new Default();

    // Act
    Default actualHandle = new PaperDefaultDisplay(impl).getHandle();

    // Assert
    assertEquals(Type.DEFAULT, actualHandle.type());
    assertSame(impl, actualHandle);
  }
}
