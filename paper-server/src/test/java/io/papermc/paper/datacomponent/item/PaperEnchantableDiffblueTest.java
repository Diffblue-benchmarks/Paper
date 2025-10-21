package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.item.enchantment.Enchantable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperEnchantableDiffblueTest {
  /**
   * Test {@link PaperEnchantable#getHandle()}.
   *
   * <p>Method under test: {@link PaperEnchantable#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enchantable PaperEnchantable.getHandle()"})
  void testGetHandle() {
    // Arrange
    Enchantable impl = new Enchantable(42);

    // Act
    Enchantable actualHandle = new PaperEnchantable(impl).getHandle();

    // Assert
    assertEquals(42, actualHandle.value());
    assertSame(impl, actualHandle);
  }

  /**
   * Test {@link PaperEnchantable#value()}.
   *
   * <ul>
   *   <li>Given {@link Enchantable#Enchantable(int)} with value is forty-two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link PaperEnchantable#value()}
   */
  @Test
  @DisplayName(
      "Test value(); given Enchantable(int) with value is forty-two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperEnchantable.value()"})
  void testValue_givenEnchantableWithValueIsFortyTwo_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new PaperEnchantable(new Enchantable(42)).value());
  }
}
