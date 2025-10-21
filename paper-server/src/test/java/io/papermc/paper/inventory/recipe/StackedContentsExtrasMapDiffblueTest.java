package io.papermc.paper.inventory.recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.entity.player.StackedContents;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StackedContentsExtrasMapDiffblueTest {
  /**
   * Test {@link StackedContentsExtrasMap#StackedContentsExtrasMap(StackedContents)}.
   *
   * <p>Method under test: {@link
   * StackedContentsExtrasMap#StackedContentsExtrasMap(StackedContents)}
   */
  @Test
  @DisplayName("Test new StackedContentsExtrasMap(StackedContents)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackedContentsExtrasMap.<init>(StackedContents)"})
  void testNewStackedContentsExtrasMap() {
    // Arrange and Act
    StackedContentsExtrasMap actualStackedContentsExtrasMap =
        new StackedContentsExtrasMap(new StackedContents<>());

    // Assert
    assertTrue(actualStackedContentsExtrasMap.exactIngredients.isEmpty());
    assertTrue(actualStackedContentsExtrasMap.regularRemoved.isEmpty());
  }
}
