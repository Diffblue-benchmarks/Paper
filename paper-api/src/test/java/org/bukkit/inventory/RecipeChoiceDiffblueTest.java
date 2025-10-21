package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RecipeChoiceDiffblueTest {
  /**
   * Test {@link RecipeChoice#empty()}.
   *
   * <p>Method under test: {@link RecipeChoice#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice RecipeChoice.empty()"})
  void testEmpty() {
    // Arrange and Act
    RecipeChoice actualEmptyResult = RecipeChoice.empty();

    // Assert
    assertTrue(actualEmptyResult instanceof EmptyRecipeChoice);
    RecipeChoice expectedCloneResult = ((EmptyRecipeChoice) actualEmptyResult).INSTANCE;
    assertSame(expectedCloneResult, actualEmptyResult.clone());
  }

  /**
   * Test {@link RecipeChoice#validate(boolean)}.
   *
   * <p>Method under test: {@link RecipeChoice#validate(boolean)}
   */
  @Test
  @DisplayName("Test validate(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice RecipeChoice.validate(boolean)"})
  void testValidate() {
    // Arrange
    RecipeChoice recipeChoice = EmptyRecipeChoice.INSTANCE;

    // Act
    RecipeChoice actualValidateResult = recipeChoice.validate(true);

    // Assert
    assertTrue(recipeChoice instanceof EmptyRecipeChoice);
    RecipeChoice recipeChoice2 = ((EmptyRecipeChoice) actualValidateResult).INSTANCE;
    assertSame(recipeChoice2, recipeChoice.clone());
    assertSame(recipeChoice2, actualValidateResult);
  }
}
