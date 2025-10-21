package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.player.PlayerItemFrameChangeEvent.ItemFrameChangeAction;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerItemFrameChangeEventDiffblueTest {
  /**
   * Test {@link PlayerItemFrameChangeEvent#setItemStack(ItemStack)}.
   *
   * <p>Method under test: {@link PlayerItemFrameChangeEvent#setItemStack(ItemStack)}
   */
  @Test
  @DisplayName("Test setItemStack(ItemStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerItemFrameChangeEvent.setItemStack(ItemStack)"})
  void testSetItemStack() {
    // Arrange
    PlayerItemFrameChangeEvent playerItemFrameChangeEvent =
        new PlayerItemFrameChangeEvent(
            mock(Player.class), mock(ItemFrame.class), null, ItemFrameChangeAction.PLACE);
    ItemStack itemStack = mock(ItemStack.class);

    // Act
    playerItemFrameChangeEvent.setItemStack(itemStack);

    // Assert
    assertSame(itemStack, playerItemFrameChangeEvent.getItemStack());
  }
}
