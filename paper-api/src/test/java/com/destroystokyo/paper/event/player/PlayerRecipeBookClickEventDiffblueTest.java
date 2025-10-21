package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
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
   *   <li>{@link PlayerRecipeBookClickEvent#PlayerRecipeBookClickEvent(Player, NamespacedKey,
   *       boolean)}
   *   <li>{@link PlayerRecipeBookClickEvent#setCancelled(boolean)}
   *   <li>{@link PlayerRecipeBookClickEvent#setMakeAll(boolean)}
   *   <li>{@link PlayerRecipeBookClickEvent#setRecipe(NamespacedKey)}
   *   <li>{@link PlayerRecipeBookClickEvent#getHandlerList()}
   *   <li>{@link PlayerRecipeBookClickEvent#getHandlers()}
   *   <li>{@link PlayerRecipeBookClickEvent#getRecipe()}
   *   <li>{@link PlayerRecipeBookClickEvent#isCancelled()}
   *   <li>{@link PlayerRecipeBookClickEvent#isMakeAll()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRecipeBookClickEvent.<init>(Player, NamespacedKey, boolean)",
    "HandlerList PlayerRecipeBookClickEvent.getHandlerList()",
    "HandlerList PlayerRecipeBookClickEvent.getHandlers()",
    "NamespacedKey PlayerRecipeBookClickEvent.getRecipe()",
    "boolean PlayerRecipeBookClickEvent.isCancelled()",
    "boolean PlayerRecipeBookClickEvent.isMakeAll()",
    "void PlayerRecipeBookClickEvent.setCancelled(boolean)",
    "void PlayerRecipeBookClickEvent.setMakeAll(boolean)",
    "void PlayerRecipeBookClickEvent.setRecipe(NamespacedKey)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerRecipeBookClickEvent actualPlayerRecipeBookClickEvent =
        new PlayerRecipeBookClickEvent(player, NamespacedKey.randomKey(), true);
    actualPlayerRecipeBookClickEvent.setCancelled(true);
    actualPlayerRecipeBookClickEvent.setMakeAll(true);
    NamespacedKey recipe = NamespacedKey.randomKey();
    actualPlayerRecipeBookClickEvent.setRecipe(recipe);
    HandlerList actualHandlerList = actualPlayerRecipeBookClickEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerRecipeBookClickEvent.getHandlers();
    NamespacedKey actualRecipe = actualPlayerRecipeBookClickEvent.getRecipe();
    boolean actualIsCancelledResult = actualPlayerRecipeBookClickEvent.isCancelled();
    boolean actualIsMakeAllResult = actualPlayerRecipeBookClickEvent.isMakeAll();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerRecipeBookClickEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsMakeAllResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(recipe, actualRecipe);
    assertSame(player, actualPlayerRecipeBookClickEvent.getPlayer());
  }
}
