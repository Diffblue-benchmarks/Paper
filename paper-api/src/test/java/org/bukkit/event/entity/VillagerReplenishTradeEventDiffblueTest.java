package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VillagerReplenishTradeEventDiffblueTest {
  /**
   * Test {@link VillagerReplenishTradeEvent#getEntity()}.
   *
   * <p>Method under test: {@link VillagerReplenishTradeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractVillager VillagerReplenishTradeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe recipe = new MerchantRecipe(result, 3);
    VillagerReplenishTradeEvent villagerReplenishTradeEvent =
        new VillagerReplenishTradeEvent(mock(AbstractVillager.class), recipe);

    // Act
    AbstractVillager actualEntity = villagerReplenishTradeEvent.getEntity();

    // Assert
    verify(result).isEmpty();
    assertSame(villagerReplenishTradeEvent.entity, actualEntity);
  }

  /**
   * Test {@link VillagerReplenishTradeEvent#getBonus()}.
   *
   * <ul>
   *   <li>Given {@link ItemStack} {@link ItemStack#isEmpty()} return {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link VillagerReplenishTradeEvent#getBonus()}
   */
  @Test
  @DisplayName("Test getBonus(); given ItemStack isEmpty() return 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VillagerReplenishTradeEvent.getBonus()"})
  void testGetBonus_givenItemStackIsEmptyReturnFalse_thenReturnZero() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe recipe = new MerchantRecipe(result, 3);
    VillagerReplenishTradeEvent villagerReplenishTradeEvent =
        new VillagerReplenishTradeEvent(mock(AbstractVillager.class), recipe);

    // Act
    int actualBonus = villagerReplenishTradeEvent.getBonus();

    // Assert
    verify(result).isEmpty();
    assertEquals(0, actualBonus);
  }
}
