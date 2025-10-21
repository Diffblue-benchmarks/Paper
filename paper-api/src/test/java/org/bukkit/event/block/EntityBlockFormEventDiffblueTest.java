package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityBlockFormEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityBlockFormEvent#EntityBlockFormEvent(Entity, Block, BlockState)}
   *   <li>{@link EntityBlockFormEvent#getEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityBlockFormEvent.<init>(Entity, Block, BlockState)",
    "Entity EntityBlockFormEvent.getEntity()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Block block = mock(Block.class);
    BlockState blockstate = mock(BlockState.class);

    // Act
    EntityBlockFormEvent actualEntityBlockFormEvent =
        new EntityBlockFormEvent(entity, block, blockstate);
    Entity actualEntity = actualEntityBlockFormEvent.getEntity();

    // Assert
    assertFalse(actualEntityBlockFormEvent.isAsynchronous());
    assertFalse(actualEntityBlockFormEvent.isCancelled());
    assertSame(block, actualEntityBlockFormEvent.getBlock());
    assertSame(blockstate, actualEntityBlockFormEvent.getNewState());
    assertSame(entity, actualEntity);
  }
}
