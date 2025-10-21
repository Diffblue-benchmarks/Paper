package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockDispenseArmorEventDiffblueTest {
  /**
   * Test {@link BlockDispenseArmorEvent#BlockDispenseArmorEvent(Block, ItemStack, LivingEntity)}.
   *
   * <ul>
   *   <li>Then return EventName is {@code BlockDispenseArmorEvent}.
   * </ul>
   *
   * <p>Method under test: {@link BlockDispenseArmorEvent#BlockDispenseArmorEvent(Block, ItemStack,
   * LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockDispenseArmorEvent(Block, ItemStack, LivingEntity); then return EventName is 'BlockDispenseArmorEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockDispenseArmorEvent.<init>(Block, ItemStack, LivingEntity)"})
  void testNewBlockDispenseArmorEvent_thenReturnEventNameIsBlockDispenseArmorEvent() {
    // Arrange
    Block block = mock(Block.class);
    LivingEntity target = mock(LivingEntity.class);

    // Act
    BlockDispenseArmorEvent actualBlockDispenseArmorEvent =
        new BlockDispenseArmorEvent(block, mock(ItemStack.class), target);

    // Assert
    assertEquals("BlockDispenseArmorEvent", actualBlockDispenseArmorEvent.getEventName());
    assertNull(actualBlockDispenseArmorEvent.getItem());
    Vector velocity = actualBlockDispenseArmorEvent.getVelocity();
    assertEquals(0, velocity.getBlockX());
    assertEquals(0, velocity.getBlockY());
    assertEquals(0, velocity.getBlockZ());
    assertEquals(0, actualBlockDispenseArmorEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(0.0d, velocity.getX());
    assertEquals(0.0d, velocity.getY());
    assertEquals(0.0d, velocity.getZ());
    assertEquals(0.0d, velocity.length());
    assertFalse(actualBlockDispenseArmorEvent.isAsynchronous());
    assertFalse(actualBlockDispenseArmorEvent.isCancelled());
    assertTrue(velocity.isZero());
    assertSame(block, actualBlockDispenseArmorEvent.getBlock());
    assertSame(target, actualBlockDispenseArmorEvent.getTargetEntity());
  }
}
