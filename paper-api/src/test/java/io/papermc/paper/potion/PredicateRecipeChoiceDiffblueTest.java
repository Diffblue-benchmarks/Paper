package io.papermc.paper.potion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PredicateRecipeChoiceDiffblueTest {
  /**
   * Test {@link PredicateRecipeChoice#getItemStack()}.
   *
   * <p>Method under test: {@link PredicateRecipeChoice#getItemStack()}
   */
  @Test
  @DisplayName("Test getItemStack()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack PredicateRecipeChoice.getItemStack()"})
  void testGetItemStack() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PredicateRecipeChoice(mock(Predicate.class)).getItemStack());
  }

  /**
   * Test {@link PredicateRecipeChoice#clone()}.
   *
   * <p>Method under test: {@link PredicateRecipeChoice#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice PredicateRecipeChoice.clone()"})
  void testClone() {
    // Arrange
    PredicateRecipeChoice predicateRecipeChoice = new PredicateRecipeChoice(mock(Predicate.class));

    // Act
    RecipeChoice actualCloneResult = predicateRecipeChoice.clone();

    // Assert
    assertTrue(actualCloneResult instanceof PredicateRecipeChoice);
    assertEquals(predicateRecipeChoice, actualCloneResult);
  }

  /**
   * Test {@link PredicateRecipeChoice#test(ItemStack)} with {@code itemStack}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateRecipeChoice#test(ItemStack)}
   */
  @Test
  @DisplayName(
      "Test test(ItemStack) with 'itemStack'; given Predicate test(Object) return 'false'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateRecipeChoice.test(ItemStack)"})
  void testTestWithItemStack_givenPredicateTestReturnFalse_whenNull_thenReturnFalse() {
    // Arrange
    Predicate<ItemStack> itemStackPredicate = mock(Predicate.class);
    when(itemStackPredicate.test(Mockito.<ItemStack>any())).thenReturn(false);

    // Act
    boolean actualTestResult = new PredicateRecipeChoice(itemStackPredicate).test(null);

    // Assert
    verify(itemStackPredicate).test(isNull());
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link PredicateRecipeChoice#test(ItemStack)} with {@code itemStack}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateRecipeChoice#test(ItemStack)}
   */
  @Test
  @DisplayName(
      "Test test(ItemStack) with 'itemStack'; given Predicate test(Object) return 'true'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateRecipeChoice.test(ItemStack)"})
  void testTestWithItemStack_givenPredicateTestReturnTrue_whenNull_thenReturnTrue() {
    // Arrange
    Predicate<ItemStack> itemStackPredicate = mock(Predicate.class);
    when(itemStackPredicate.test(Mockito.<ItemStack>any())).thenReturn(true);

    // Act
    boolean actualTestResult = new PredicateRecipeChoice(itemStackPredicate).test(null);

    // Assert
    verify(itemStackPredicate).test(isNull());
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link PredicateRecipeChoice#test(ItemStack)} with {@code itemStack}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PredicateRecipeChoice#test(ItemStack)}
   */
  @Test
  @DisplayName("Test test(ItemStack) with 'itemStack'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PredicateRecipeChoice.test(ItemStack)"})
  void testTestWithItemStack_thenThrowUnsupportedOperationException() {
    // Arrange
    Predicate<ItemStack> itemStackPredicate = mock(Predicate.class);
    when(itemStackPredicate.test(Mockito.<ItemStack>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PredicateRecipeChoice(itemStackPredicate).test(null));
    verify(itemStackPredicate).test(isNull());
  }
}
