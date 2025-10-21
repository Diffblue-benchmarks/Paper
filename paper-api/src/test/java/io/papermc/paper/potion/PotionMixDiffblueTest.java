package io.papermc.paper.potion;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PotionMixDiffblueTest {
  /**
   * Test {@link PotionMix#createPredicateChoice(Predicate)}.
   *
   * <p>Method under test: {@link PotionMix#createPredicateChoice(Predicate)}
   */
  @Test
  @DisplayName("Test createPredicateChoice(Predicate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice PotionMix.createPredicateChoice(Predicate)"})
  void testCreatePredicateChoice() {
    // Arrange
    Predicate<ItemStack> stackPredicate = mock(Predicate.class);

    // Act
    RecipeChoice actualCreatePredicateChoiceResult =
        PotionMix.createPredicateChoice(stackPredicate);

    // Assert
    assertTrue(actualCreatePredicateChoiceResult instanceof PredicateRecipeChoice);
    assertSame(
        stackPredicate,
        ((PredicateRecipeChoice) actualCreatePredicateChoiceResult).itemStackPredicate());
  }
}
