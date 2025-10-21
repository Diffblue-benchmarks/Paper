package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPurchaseEventDiffblueTest {
  /**
   * Test {@link PlayerPurchaseEvent#setTrade(MerchantRecipe)}.
   *
   * <p>Method under test: {@link PlayerPurchaseEvent#setTrade(MerchantRecipe)}
   */
  @Test
  @DisplayName("Test setTrade(MerchantRecipe)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPurchaseEvent.setTrade(MerchantRecipe)"})
  void testSetTrade() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe trade = new MerchantRecipe(result, 3);
    PlayerPurchaseEvent playerPurchaseEvent =
        new PlayerPurchaseEvent(mock(Player.class), trade, true, true);
    MerchantRecipe trade2 = mock(MerchantRecipe.class);

    // Act
    playerPurchaseEvent.setTrade(trade2);

    // Assert
    verify(result).isEmpty();
    assertSame(trade2, playerPurchaseEvent.getTrade());
  }

  /**
   * Test {@link PlayerPurchaseEvent#willIncreaseTradeUses()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPurchaseEvent#willIncreaseTradeUses()}
   */
  @Test
  @DisplayName("Test willIncreaseTradeUses(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPurchaseEvent.willIncreaseTradeUses()"})
  void testWillIncreaseTradeUses_thenReturnFalse() {
    // Arrange
    PlayerPurchaseEvent playerPurchaseEvent =
        new PlayerPurchaseEvent(mock(Player.class), null, true, false);

    // Act and Assert
    assertFalse(playerPurchaseEvent.willIncreaseTradeUses());
  }

  /**
   * Test {@link PlayerPurchaseEvent#willIncreaseTradeUses()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPurchaseEvent#willIncreaseTradeUses()}
   */
  @Test
  @DisplayName("Test willIncreaseTradeUses(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPurchaseEvent.willIncreaseTradeUses()"})
  void testWillIncreaseTradeUses_thenReturnTrue() {
    // Arrange
    PlayerPurchaseEvent playerPurchaseEvent =
        new PlayerPurchaseEvent(mock(Player.class), null, true, true);

    // Act and Assert
    assertTrue(playerPurchaseEvent.willIncreaseTradeUses());
  }
}
