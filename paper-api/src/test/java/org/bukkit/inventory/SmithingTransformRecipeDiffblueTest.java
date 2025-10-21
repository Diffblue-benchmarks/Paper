package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmithingTransformRecipeDiffblueTest {
  /**
   * Test {@link SmithingTransformRecipe#SmithingTransformRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice, RecipeChoice)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then Addition return {@link EmptyRecipeChoice}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingTransformRecipe#SmithingTransformRecipe(NamespacedKey,
   * ItemStack, RecipeChoice, RecipeChoice, RecipeChoice)}
   */
  @Test
  @DisplayName(
      "Test new SmithingTransformRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, RecipeChoice); given 'false'; then Addition return EmptyRecipeChoice")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingTransformRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, RecipeChoice)"
  })
  void testNewSmithingTransformRecipe_givenFalse_thenAdditionReturnEmptyRecipeChoice() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    RecipeChoice addition = EmptyRecipeChoice.INSTANCE;

    // Act
    SmithingTransformRecipe actualSmithingTransformRecipe =
        new SmithingTransformRecipe(
            key, result, EmptyRecipeChoice.INSTANCE, EmptyRecipeChoice.INSTANCE, addition);

    // Assert
    verify(result).isEmpty();
    RecipeChoice addition2 = actualSmithingTransformRecipe.getAddition();
    assertTrue(addition2 instanceof EmptyRecipeChoice);
    assertNull(actualSmithingTransformRecipe.getResult());
    assertSame(key, actualSmithingTransformRecipe.key());
    assertSame(key, actualSmithingTransformRecipe.getKey());
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) addition).INSTANCE;
    assertSame(recipeChoice, addition2);
    assertSame(recipeChoice, actualSmithingTransformRecipe.getBase());
    assertSame(recipeChoice, actualSmithingTransformRecipe.getTemplate());
  }

  /**
   * Test {@link SmithingTransformRecipe#SmithingTransformRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice, RecipeChoice, boolean)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then Addition return {@link EmptyRecipeChoice}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingTransformRecipe#SmithingTransformRecipe(NamespacedKey,
   * ItemStack, RecipeChoice, RecipeChoice, RecipeChoice, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SmithingTransformRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, RecipeChoice, boolean); given 'false'; then Addition return EmptyRecipeChoice")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingTransformRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, RecipeChoice, boolean)"
  })
  void testNewSmithingTransformRecipe_givenFalse_thenAdditionReturnEmptyRecipeChoice2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    RecipeChoice addition = EmptyRecipeChoice.INSTANCE;

    // Act
    SmithingTransformRecipe actualSmithingTransformRecipe =
        new SmithingTransformRecipe(
            key, result, EmptyRecipeChoice.INSTANCE, EmptyRecipeChoice.INSTANCE, addition, true);

    // Assert
    verify(result).isEmpty();
    RecipeChoice addition2 = actualSmithingTransformRecipe.getAddition();
    assertTrue(addition2 instanceof EmptyRecipeChoice);
    assertNull(actualSmithingTransformRecipe.getResult());
    assertSame(key, actualSmithingTransformRecipe.key());
    assertSame(key, actualSmithingTransformRecipe.getKey());
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) addition).INSTANCE;
    assertSame(recipeChoice, addition2);
    assertSame(recipeChoice, actualSmithingTransformRecipe.getBase());
    assertSame(recipeChoice, actualSmithingTransformRecipe.getTemplate());
  }

  /**
   * Test {@link SmithingTransformRecipe#getTemplate()}.
   *
   * <p>Method under test: {@link SmithingTransformRecipe#getTemplate()}
   */
  @Test
  @DisplayName("Test getTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice SmithingTransformRecipe.getTemplate()"})
  void testGetTemplate() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    SmithingTransformRecipe smithingTransformRecipe =
        new SmithingTransformRecipe(
            NamespacedKey.randomKey(),
            result,
            EmptyRecipeChoice.INSTANCE,
            EmptyRecipeChoice.INSTANCE,
            EmptyRecipeChoice.INSTANCE);

    // Act
    RecipeChoice actualTemplate = smithingTransformRecipe.getTemplate();

    // Assert
    verify(result).isEmpty();
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) actualTemplate).INSTANCE;
    assertSame(recipeChoice, smithingTransformRecipe.getAddition());
    assertSame(recipeChoice, smithingTransformRecipe.getBase());
    assertSame(recipeChoice, actualTemplate);
  }
}
