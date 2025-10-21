package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.LivingEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityBreakDoorEventDiffblueTest {
  /**
   * Test {@link EntityBreakDoorEvent#EntityBreakDoorEvent(LivingEntity, Block, BlockData)}.
   *
   * <p>Method under test: {@link EntityBreakDoorEvent#EntityBreakDoorEvent(LivingEntity, Block,
   * BlockData)}
   */
  @Test
  @DisplayName("Test new EntityBreakDoorEvent(LivingEntity, Block, BlockData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityBreakDoorEvent.<init>(LivingEntity, Block, BlockData)"})
  void testNewEntityBreakDoorEvent() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Block targetBlock = mock(Block.class);

    // Act
    EntityBreakDoorEvent actualEntityBreakDoorEvent =
        new EntityBreakDoorEvent(entity, targetBlock, mock(BlockData.class));

    // Assert
    assertFalse(actualEntityBreakDoorEvent.isAsynchronous());
    assertFalse(actualEntityBreakDoorEvent.isCancelled());
    assertSame(targetBlock, actualEntityBreakDoorEvent.getBlock());
    assertSame(entity, actualEntityBreakDoorEvent.getEntity());
  }

  /**
   * Test {@link EntityBreakDoorEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityBreakDoorEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityBreakDoorEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityBreakDoorEvent entityBreakDoorEvent =
        new EntityBreakDoorEvent(
            mock(LivingEntity.class), mock(Block.class), mock(BlockData.class));

    // Act
    LivingEntity actualEntity = entityBreakDoorEvent.getEntity();

    // Assert
    assertSame(entityBreakDoorEvent.entity, actualEntity);
  }
}
