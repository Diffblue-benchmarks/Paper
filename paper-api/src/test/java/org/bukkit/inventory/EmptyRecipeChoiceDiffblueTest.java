package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyRecipeChoiceDiffblueTest {
  /**
   * Test {@link EmptyRecipeChoice#getItemStack()}.
   *
   * <p>Method under test: {@link EmptyRecipeChoice#getItemStack()}
   */
  @Test
  @DisplayName("Test getItemStack()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.inventory.ItemStack EmptyRecipeChoice.getItemStack()"})
  void testGetItemStack() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new EmptyRecipeChoice().getItemStack());
  }

  /**
   * Test {@link EmptyRecipeChoice#clone()}.
   *
   * <p>Method under test: {@link EmptyRecipeChoice#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice EmptyRecipeChoice.clone()"})
  void testClone() {
    // Arrange
    EmptyRecipeChoice emptyRecipeChoice = new EmptyRecipeChoice();

    // Act
    RecipeChoice actualCloneResult = emptyRecipeChoice.clone();

    // Assert
    assertTrue(actualCloneResult instanceof EmptyRecipeChoice);
    assertSame(emptyRecipeChoice, actualCloneResult);
  }

  /**
   * Test {@link EmptyRecipeChoice#validate(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyRecipeChoice#validate(boolean)}
   */
  @Test
  @DisplayName("Test validate(boolean); when 'false'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice EmptyRecipeChoice.validate(boolean)"})
  void testValidate_whenFalse_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EmptyRecipeChoice().validate(false));
  }

  /**
   * Test {@link EmptyRecipeChoice#validate(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@link EmptyRecipeChoice} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EmptyRecipeChoice#validate(boolean)}
   */
  @Test
  @DisplayName(
      "Test validate(boolean); when 'true'; then return EmptyRecipeChoice (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RecipeChoice EmptyRecipeChoice.validate(boolean)"})
  void testValidate_whenTrue_thenReturnEmptyRecipeChoice() {
    // Arrange
    EmptyRecipeChoice emptyRecipeChoice = new EmptyRecipeChoice();

    // Act
    RecipeChoice actualValidateResult = emptyRecipeChoice.validate(true);

    // Assert
    assertSame(emptyRecipeChoice, actualValidateResult);
  }

  /**
   * Test {@link EmptyRecipeChoice#equals(Object)}, and {@link EmptyRecipeChoice#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyRecipeChoice#equals(Object)}
   *   <li>{@link EmptyRecipeChoice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmptyRecipeChoice.equals(Object)",
    "int EmptyRecipeChoice.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmptyRecipeChoice emptyRecipeChoice = new EmptyRecipeChoice();
    EmptyRecipeChoice emptyRecipeChoice2 = new EmptyRecipeChoice();

    // Act and Assert
    assertEquals(emptyRecipeChoice, emptyRecipeChoice2);
    assertEquals(emptyRecipeChoice.hashCode(), emptyRecipeChoice2.hashCode());
  }

  /**
   * Test {@link EmptyRecipeChoice#equals(Object)}, and {@link EmptyRecipeChoice#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyRecipeChoice#equals(Object)}
   *   <li>{@link EmptyRecipeChoice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmptyRecipeChoice.equals(Object)",
    "int EmptyRecipeChoice.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmptyRecipeChoice emptyRecipeChoice = new EmptyRecipeChoice();

    // Act and Assert
    assertEquals(emptyRecipeChoice, emptyRecipeChoice);
    int expectedHashCodeResult = emptyRecipeChoice.hashCode();
    assertEquals(expectedHashCodeResult, emptyRecipeChoice.hashCode());
  }

  /**
   * Test {@link EmptyRecipeChoice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyRecipeChoice#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmptyRecipeChoice.equals(Object)",
    "int EmptyRecipeChoice.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmptyRecipeChoice(), 4);
  }

  /**
   * Test {@link EmptyRecipeChoice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyRecipeChoice#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmptyRecipeChoice.equals(Object)",
    "int EmptyRecipeChoice.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmptyRecipeChoice(), null);
  }

  /**
   * Test {@link EmptyRecipeChoice#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyRecipeChoice#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EmptyRecipeChoice.equals(Object)",
    "int EmptyRecipeChoice.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmptyRecipeChoice(), "Different type to EmptyRecipeChoice");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyRecipeChoice}
   *   <li>{@link EmptyRecipeChoice#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EmptyRecipeChoice.<init>()",
    "java.lang.String EmptyRecipeChoice.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("EmptyRecipeChoice[]", new EmptyRecipeChoice().toString());
  }
}
