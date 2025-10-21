package org.bukkit.event.player;

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

class PlayerRecipeDiscoverEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerRecipeDiscoverEvent#PlayerRecipeDiscoverEvent(Player, NamespacedKey,
   *       boolean)}
   *   <li>{@link PlayerRecipeDiscoverEvent#setCancelled(boolean)}
   *   <li>{@link PlayerRecipeDiscoverEvent#shouldShowNotification(boolean)}
   *   <li>{@link PlayerRecipeDiscoverEvent#getHandlerList()}
   *   <li>{@link PlayerRecipeDiscoverEvent#getHandlers()}
   *   <li>{@link PlayerRecipeDiscoverEvent#getRecipe()}
   *   <li>{@link PlayerRecipeDiscoverEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerRecipeDiscoverEvent.<init>(Player, NamespacedKey, boolean)",
    "HandlerList PlayerRecipeDiscoverEvent.getHandlerList()",
    "HandlerList PlayerRecipeDiscoverEvent.getHandlers()",
    "NamespacedKey PlayerRecipeDiscoverEvent.getRecipe()",
    "boolean PlayerRecipeDiscoverEvent.isCancelled()",
    "void PlayerRecipeDiscoverEvent.setCancelled(boolean)",
    "void PlayerRecipeDiscoverEvent.shouldShowNotification(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    NamespacedKey recipe = NamespacedKey.randomKey();

    // Act
    PlayerRecipeDiscoverEvent actualPlayerRecipeDiscoverEvent =
        new PlayerRecipeDiscoverEvent(player, recipe, true);
    actualPlayerRecipeDiscoverEvent.setCancelled(true);
    actualPlayerRecipeDiscoverEvent.shouldShowNotification(true);
    HandlerList actualHandlerList = actualPlayerRecipeDiscoverEvent.getHandlerList();
    HandlerList actualHandlers = actualPlayerRecipeDiscoverEvent.getHandlers();
    NamespacedKey actualRecipe = actualPlayerRecipeDiscoverEvent.getRecipe();
    boolean actualIsCancelledResult = actualPlayerRecipeDiscoverEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerRecipeDiscoverEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(recipe, actualRecipe);
    assertSame(player, actualPlayerRecipeDiscoverEvent.getPlayer());
  }

  /**
   * Test {@link PlayerRecipeDiscoverEvent#shouldShowNotification()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRecipeDiscoverEvent#shouldShowNotification()}
   */
  @Test
  @DisplayName("Test shouldShowNotification(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerRecipeDiscoverEvent.shouldShowNotification()"})
  void testShouldShowNotification_thenReturnFalse() {
    // Arrange
    Player player = mock(Player.class);
    PlayerRecipeDiscoverEvent playerRecipeDiscoverEvent =
        new PlayerRecipeDiscoverEvent(player, NamespacedKey.randomKey(), false);

    // Act and Assert
    assertFalse(playerRecipeDiscoverEvent.shouldShowNotification());
  }

  /**
   * Test {@link PlayerRecipeDiscoverEvent#shouldShowNotification()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerRecipeDiscoverEvent#shouldShowNotification()}
   */
  @Test
  @DisplayName("Test shouldShowNotification(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerRecipeDiscoverEvent.shouldShowNotification()"})
  void testShouldShowNotification_thenReturnTrue() {
    // Arrange
    Player player = mock(Player.class);
    PlayerRecipeDiscoverEvent playerRecipeDiscoverEvent =
        new PlayerRecipeDiscoverEvent(player, NamespacedKey.randomKey(), true);

    // Act and Assert
    assertTrue(playerRecipeDiscoverEvent.shouldShowNotification());
  }
}
