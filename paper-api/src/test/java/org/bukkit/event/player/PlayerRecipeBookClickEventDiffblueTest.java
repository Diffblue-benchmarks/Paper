package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerRecipeBookClickEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerRecipeBookClickEvent#PlayerRecipeBookClickEvent(Player, Recipe, boolean)}
   *   <li>{@link PlayerRecipeBookClickEvent#setShiftClick(boolean)}
   *   <li>{@link PlayerRecipeBookClickEvent#getHandlerList()}
   *   <li>{@link PlayerRecipeBookClickEvent#getHandlers()}
   *   <li>{@link PlayerRecipeBookClickEvent#getOriginalRecipe()}
   *   <li>{@link PlayerRecipeBookClickEvent#getRecipe()}
   *   <li>{@link PlayerRecipeBookClickEvent#isShiftClick()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRecipeBookClickEvent.<init>(Player, Recipe, boolean)",
    "HandlerList PlayerRecipeBookClickEvent.getHandlerList()",
    "HandlerList PlayerRecipeBookClickEvent.getHandlers()",
    "Recipe PlayerRecipeBookClickEvent.getOriginalRecipe()",
    "Recipe PlayerRecipeBookClickEvent.getRecipe()",
    "boolean PlayerRecipeBookClickEvent.isShiftClick()",
    "void PlayerRecipeBookClickEvent.setShiftClick(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Recipe recipe = mock(Recipe.class);

    // Act
    PlayerRecipeBookClickEvent actualPlayerRecipeBookClickEvent =
        new PlayerRecipeBookClickEvent(player, recipe, true);
    actualPlayerRecipeBookClickEvent.setShiftClick(true);
    HandlerList actualHandlerList = actualPlayerRecipeBookClickEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerRecipeBookClickEvent.getHandlers();
    Recipe actualOriginalRecipe = actualPlayerRecipeBookClickEvent.getOriginalRecipe();
    Recipe actualRecipe = actualPlayerRecipeBookClickEvent.getRecipe();
    boolean actualIsShiftClickResult = actualPlayerRecipeBookClickEvent.isShiftClick();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerRecipeBookClickEvent.isAsynchronous());
    assertTrue(actualIsShiftClickResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerRecipeBookClickEvent.getPlayer());
    assertSame(recipe, actualOriginalRecipe);
    assertSame(recipe, actualRecipe);
  }

  /**
   * Test {@link PlayerRecipeBookClickEvent#setRecipe(Recipe)}.
   *
   * <p>Method under test: {@link PlayerRecipeBookClickEvent#setRecipe(Recipe)}
   */
  @Test
  @DisplayName("Test setRecipe(Recipe)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerRecipeBookClickEvent.setRecipe(Recipe)"})
  void testSetRecipe() {
    // Arrange
    PlayerRecipeBookClickEvent playerRecipeBookClickEvent =
        new PlayerRecipeBookClickEvent(mock(Player.class), mock(Recipe.class), true);
    Recipe recipe = mock(Recipe.class);

    // Act
    playerRecipeBookClickEvent.setRecipe(recipe);

    // Assert
    assertSame(recipe, playerRecipeBookClickEvent.getRecipe());
  }
}
