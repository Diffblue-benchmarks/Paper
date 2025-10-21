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
import org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent.RecipeBookType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerRecipeBookSettingsChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerRecipeBookSettingsChangeEvent#PlayerRecipeBookSettingsChangeEvent(Player,
   *       RecipeBookType, boolean, boolean)}
   *   <li>{@link PlayerRecipeBookSettingsChangeEvent#getHandlerList()}
   *   <li>{@link PlayerRecipeBookSettingsChangeEvent#getHandlers()}
   *   <li>{@link PlayerRecipeBookSettingsChangeEvent#getRecipeBookType()}
   *   <li>{@link PlayerRecipeBookSettingsChangeEvent#isFiltering()}
   *   <li>{@link PlayerRecipeBookSettingsChangeEvent#isOpen()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRecipeBookSettingsChangeEvent.<init>(Player, RecipeBookType, boolean, boolean)",
    "HandlerList PlayerRecipeBookSettingsChangeEvent.getHandlerList()",
    "HandlerList PlayerRecipeBookSettingsChangeEvent.getHandlers()",
    "RecipeBookType PlayerRecipeBookSettingsChangeEvent.getRecipeBookType()",
    "boolean PlayerRecipeBookSettingsChangeEvent.isFiltering()",
    "boolean PlayerRecipeBookSettingsChangeEvent.isOpen()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerRecipeBookSettingsChangeEvent actualPlayerRecipeBookSettingsChangeEvent =
        new PlayerRecipeBookSettingsChangeEvent(player, RecipeBookType.CRAFTING, true, true);
    HandlerList actualHandlerList = actualPlayerRecipeBookSettingsChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerRecipeBookSettingsChangeEvent.getHandlers();
    RecipeBookType actualRecipeBookType =
        actualPlayerRecipeBookSettingsChangeEvent.getRecipeBookType();
    boolean actualIsFilteringResult = actualPlayerRecipeBookSettingsChangeEvent.isFiltering();
    boolean actualIsOpenResult = actualPlayerRecipeBookSettingsChangeEvent.isOpen();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(RecipeBookType.CRAFTING, actualRecipeBookType);
    assertFalse(actualPlayerRecipeBookSettingsChangeEvent.isAsynchronous());
    assertTrue(actualIsFilteringResult);
    assertTrue(actualIsOpenResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerRecipeBookSettingsChangeEvent.getPlayer());
  }
}
