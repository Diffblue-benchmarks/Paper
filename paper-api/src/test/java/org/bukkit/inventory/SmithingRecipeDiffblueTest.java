package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice.ExactChoice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmithingRecipeDiffblueTest {
  /**
   * Test {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice,
   * RecipeChoice)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Addition is {@link EmptyRecipeChoice#INSTANCE} {@link
   *       EmptyRecipeChoice#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice)}
   */
  @Test
  @DisplayName(
      "Test new SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice); given 'false'; then return Addition is INSTANCE INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice)"
  })
  void testNewSmithingRecipe_givenFalse_thenReturnAdditionIsInstanceInstance() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    RecipeChoice addition = EmptyRecipeChoice.INSTANCE;

    // Act
    SmithingRecipe actualSmithingRecipe =
        new SmithingRecipe(key, result, EmptyRecipeChoice.INSTANCE, addition);

    // Assert
    verify(result).isEmpty();
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) addition).INSTANCE;
    assertSame(recipeChoice, actualSmithingRecipe.getAddition());
    assertSame(recipeChoice, actualSmithingRecipe.getBase());
  }

  /**
   * Test {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice,
   * RecipeChoice)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Addition is {@link EmptyRecipeChoice#INSTANCE} {@link
   *       EmptyRecipeChoice#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice)}
   */
  @Test
  @DisplayName(
      "Test new SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice); given 'false'; then return Addition is INSTANCE INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice)"
  })
  void testNewSmithingRecipe_givenFalse_thenReturnAdditionIsInstanceInstance2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    RecipeChoice addition = EmptyRecipeChoice.INSTANCE;

    // Act
    SmithingRecipe actualSmithingRecipe = new SmithingRecipe(key, result, null, addition);

    // Assert
    verify(result).isEmpty();
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) addition).INSTANCE;
    assertSame(recipeChoice, actualSmithingRecipe.getAddition());
    assertSame(recipeChoice, actualSmithingRecipe.getBase());
  }

  /**
   * Test {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Addition is {@link EmptyRecipeChoice#INSTANCE} {@link
   *       EmptyRecipeChoice#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, boolean); given 'false'; then return Addition is INSTANCE INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, boolean)"
  })
  void testNewSmithingRecipe_givenFalse_thenReturnAdditionIsInstanceInstance3() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    RecipeChoice addition = EmptyRecipeChoice.INSTANCE;

    // Act
    SmithingRecipe actualSmithingRecipe =
        new SmithingRecipe(key, result, EmptyRecipeChoice.INSTANCE, addition, true);

    // Assert
    verify(result).isEmpty();
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) addition).INSTANCE;
    assertSame(recipeChoice, actualSmithingRecipe.getAddition());
    assertSame(recipeChoice, actualSmithingRecipe.getBase());
  }

  /**
   * Test {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return Addition is {@link EmptyRecipeChoice#INSTANCE} {@link
   *       EmptyRecipeChoice#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, boolean); given 'false'; then return Addition is INSTANCE INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, boolean)"
  })
  void testNewSmithingRecipe_givenFalse_thenReturnAdditionIsInstanceInstance4() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    RecipeChoice addition = EmptyRecipeChoice.INSTANCE;

    // Act
    SmithingRecipe actualSmithingRecipe = new SmithingRecipe(key, result, null, addition, true);

    // Assert
    verify(result).isEmpty();
    RecipeChoice recipeChoice = ((EmptyRecipeChoice) addition).INSTANCE;
    assertSame(recipeChoice, actualSmithingRecipe.getAddition());
    assertSame(recipeChoice, actualSmithingRecipe.getBase());
  }

  /**
   * Test {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice,
   * RecipeChoice)}.
   *
   * <ul>
   *   <li>Given {@link EmptyRecipeChoice#INSTANCE}.
   *   <li>Then Addition return {@link EmptyRecipeChoice}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice)}
   */
  @Test
  @DisplayName(
      "Test new SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice); given INSTANCE; then Addition return EmptyRecipeChoice")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice)"
  })
  void testNewSmithingRecipe_givenInstance_thenAdditionReturnEmptyRecipeChoice() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    ExactChoice base = mock(ExactChoice.class);
    when(base.validate(anyBoolean())).thenReturn(EmptyRecipeChoice.INSTANCE);

    // Act
    SmithingRecipe actualSmithingRecipe = new SmithingRecipe(key, result, base, null);

    // Assert
    verify(result).isEmpty();
    verify(base).validate(true);
    RecipeChoice addition = actualSmithingRecipe.getAddition();
    assertTrue(addition instanceof EmptyRecipeChoice);
    assertNull(actualSmithingRecipe.getResult());
    assertSame(key, actualSmithingRecipe.key());
    assertSame(key, actualSmithingRecipe.getKey());
    assertSame(addition, actualSmithingRecipe.getBase());
  }

  /**
   * Test {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link EmptyRecipeChoice#INSTANCE}.
   *   <li>Then Addition return {@link EmptyRecipeChoice}.
   * </ul>
   *
   * <p>Method under test: {@link SmithingRecipe#SmithingRecipe(NamespacedKey, ItemStack,
   * RecipeChoice, RecipeChoice, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SmithingRecipe(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, boolean); given INSTANCE; then Addition return EmptyRecipeChoice")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmithingRecipe.<init>(NamespacedKey, ItemStack, RecipeChoice, RecipeChoice, boolean)"
  })
  void testNewSmithingRecipe_givenInstance_thenAdditionReturnEmptyRecipeChoice2() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    ExactChoice base = mock(ExactChoice.class);
    when(base.validate(anyBoolean())).thenReturn(EmptyRecipeChoice.INSTANCE);

    // Act
    SmithingRecipe actualSmithingRecipe = new SmithingRecipe(key, result, base, null, true);

    // Assert
    verify(result).isEmpty();
    verify(base).validate(true);
    RecipeChoice addition = actualSmithingRecipe.getAddition();
    assertTrue(addition instanceof EmptyRecipeChoice);
    assertNull(actualSmithingRecipe.getResult());
    assertSame(key, actualSmithingRecipe.key());
    assertSame(key, actualSmithingRecipe.getKey());
    assertSame(addition, actualSmithingRecipe.getBase());
  }
}
