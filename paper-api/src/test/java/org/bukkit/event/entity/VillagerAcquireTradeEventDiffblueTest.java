package org.bukkit.event.entity;

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

class VillagerAcquireTradeEventDiffblueTest {
  /**
   * Test {@link VillagerAcquireTradeEvent#getEntity()}.
   *
   * <p>Method under test: {@link VillagerAcquireTradeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractVillager VillagerAcquireTradeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe recipe = new MerchantRecipe(result, 3);
    VillagerAcquireTradeEvent villagerAcquireTradeEvent =
        new VillagerAcquireTradeEvent(mock(AbstractVillager.class), recipe);

    // Act
    AbstractVillager actualEntity = villagerAcquireTradeEvent.getEntity();

    // Assert
    verify(result).isEmpty();
    assertSame(villagerAcquireTradeEvent.entity, actualEntity);
  }
}
