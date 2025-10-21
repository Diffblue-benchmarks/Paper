package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockShearEntityEventDiffblueTest {
  /**
   * Test {@link BlockShearEntityEvent#getDrops()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BlockShearEntityEvent#getDrops()}
   */
  @Test
  @DisplayName("Test getDrops(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List BlockShearEntityEvent.getDrops()"})
  void testGetDrops_thenReturnEmpty() {
    // Arrange
    Block dispenser = mock(Block.class);
    Entity sheared = mock(Entity.class);
    ItemStack tool = mock(ItemStack.class);

    BlockShearEntityEvent blockShearEntityEvent =
        new BlockShearEntityEvent(dispenser, sheared, tool, new ArrayList<>());

    // Act and Assert
    assertTrue(blockShearEntityEvent.getDrops().isEmpty());
  }
}
