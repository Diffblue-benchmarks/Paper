package io.papermc.paper.enchantments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnchantmentRarityDiffblueTest {
  /**
   * Test {@link EnchantmentRarity#getWeight()}.
   *
   * <p>Method under test: {@link EnchantmentRarity#getWeight()}
   */
  @Test
  @DisplayName("Test getWeight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EnchantmentRarity.getWeight()"})
  void testGetWeight() {
    // Arrange, Act and Assert
    assertEquals(10, EnchantmentRarity.valueOf("COMMON").getWeight());
  }
}
