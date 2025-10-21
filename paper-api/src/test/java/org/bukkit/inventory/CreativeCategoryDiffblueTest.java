package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreativeCategoryDiffblueTest {
  /**
   * Test {@link CreativeCategory#translationKey()}.
   *
   * <p>Method under test: {@link CreativeCategory#translationKey()}
   */
  @Test
  @DisplayName("Test translationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CreativeCategory.translationKey()"})
  void testTranslationKey() {
    // Arrange, Act and Assert
    assertEquals(
        "itemGroup.buildingBlocks", CreativeCategory.valueOf("BUILDING_BLOCKS").translationKey());
  }
}
