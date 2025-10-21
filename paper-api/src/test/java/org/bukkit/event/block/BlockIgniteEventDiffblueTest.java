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
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockIgniteEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Block}.
   *   <li>Then return IgnitingEntity is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockIgniteEvent#BlockIgniteEvent(Block, IgniteCause, Block)}
   *   <li>{@link BlockIgniteEvent#setCancelled(boolean)}
   *   <li>{@link BlockIgniteEvent#getHandlerList()}
   *   <li>{@link BlockIgniteEvent#getCause()}
   *   <li>{@link BlockIgniteEvent#getHandlers()}
   *   <li>{@link BlockIgniteEvent#getIgnitingBlock()}
   *   <li>{@link BlockIgniteEvent#getIgnitingEntity()}
   *   <li>{@link BlockIgniteEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Block; then return IgnitingEntity is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Block)",
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Entity)",
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Entity, Block)",
    "IgniteCause BlockIgniteEvent.getCause()",
    "HandlerList BlockIgniteEvent.getHandlerList()",
    "HandlerList BlockIgniteEvent.getHandlers()",
    "Block BlockIgniteEvent.getIgnitingBlock()",
    "Entity BlockIgniteEvent.getIgnitingEntity()",
    "boolean BlockIgniteEvent.isCancelled()",
    "void BlockIgniteEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenBlock_thenReturnIgnitingEntityIsNull() {
    // Arrange
    Block block = mock(Block.class);
    Block ignitingBlock = mock(Block.class);

    // Act
    BlockIgniteEvent actualBlockIgniteEvent =
        new BlockIgniteEvent(block, IgniteCause.LAVA, ignitingBlock);
    actualBlockIgniteEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockIgniteEvent.getHandlerList();
    IgniteCause actualCause = actualBlockIgniteEvent.getCause();
    HandlerList actualHandlers = actualBlockIgniteEvent.getHandlers();
    Block actualIgnitingBlock = actualBlockIgniteEvent.getIgnitingBlock();
    Entity actualIgnitingEntity = actualBlockIgniteEvent.getIgnitingEntity();
    boolean actualIsCancelledResult = actualBlockIgniteEvent.isCancelled();

    // Assert
    assertNull(actualIgnitingEntity);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(IgniteCause.LAVA, actualCause);
    assertFalse(actualBlockIgniteEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockIgniteEvent.getBlock());
    assertSame(ignitingBlock, actualIgnitingBlock);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return IgnitingBlock is {@link Block}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockIgniteEvent#BlockIgniteEvent(Block, IgniteCause, Entity, Block)}
   *   <li>{@link BlockIgniteEvent#setCancelled(boolean)}
   *   <li>{@link BlockIgniteEvent#getHandlerList()}
   *   <li>{@link BlockIgniteEvent#getCause()}
   *   <li>{@link BlockIgniteEvent#getHandlers()}
   *   <li>{@link BlockIgniteEvent#getIgnitingBlock()}
   *   <li>{@link BlockIgniteEvent#getIgnitingEntity()}
   *   <li>{@link BlockIgniteEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return IgnitingBlock is Block")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Block)",
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Entity)",
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Entity, Block)",
    "IgniteCause BlockIgniteEvent.getCause()",
    "HandlerList BlockIgniteEvent.getHandlerList()",
    "HandlerList BlockIgniteEvent.getHandlers()",
    "Block BlockIgniteEvent.getIgnitingBlock()",
    "Entity BlockIgniteEvent.getIgnitingEntity()",
    "boolean BlockIgniteEvent.isCancelled()",
    "void BlockIgniteEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnIgnitingBlockIsBlock() {
    // Arrange
    Block block = mock(Block.class);
    Entity ignitingEntity = mock(Entity.class);
    Block ignitingBlock = mock(Block.class);

    // Act
    BlockIgniteEvent actualBlockIgniteEvent =
        new BlockIgniteEvent(block, IgniteCause.LAVA, ignitingEntity, ignitingBlock);
    actualBlockIgniteEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockIgniteEvent.getHandlerList();
    IgniteCause actualCause = actualBlockIgniteEvent.getCause();
    HandlerList actualHandlers = actualBlockIgniteEvent.getHandlers();
    Block actualIgnitingBlock = actualBlockIgniteEvent.getIgnitingBlock();
    Entity actualIgnitingEntity = actualBlockIgniteEvent.getIgnitingEntity();
    boolean actualIsCancelledResult = actualBlockIgniteEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(IgniteCause.LAVA, actualCause);
    assertFalse(actualBlockIgniteEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockIgniteEvent.getBlock());
    assertSame(ignitingBlock, actualIgnitingBlock);
    assertSame(ignitingEntity, actualIgnitingEntity);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return IgnitingBlock is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockIgniteEvent#BlockIgniteEvent(Block, IgniteCause, Entity)}
   *   <li>{@link BlockIgniteEvent#setCancelled(boolean)}
   *   <li>{@link BlockIgniteEvent#getHandlerList()}
   *   <li>{@link BlockIgniteEvent#getCause()}
   *   <li>{@link BlockIgniteEvent#getHandlers()}
   *   <li>{@link BlockIgniteEvent#getIgnitingBlock()}
   *   <li>{@link BlockIgniteEvent#getIgnitingEntity()}
   *   <li>{@link BlockIgniteEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return IgnitingBlock is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Block)",
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Entity)",
    "void BlockIgniteEvent.<init>(Block, IgniteCause, Entity, Block)",
    "IgniteCause BlockIgniteEvent.getCause()",
    "HandlerList BlockIgniteEvent.getHandlerList()",
    "HandlerList BlockIgniteEvent.getHandlers()",
    "Block BlockIgniteEvent.getIgnitingBlock()",
    "Entity BlockIgniteEvent.getIgnitingEntity()",
    "boolean BlockIgniteEvent.isCancelled()",
    "void BlockIgniteEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnIgnitingBlockIsNull() {
    // Arrange
    Block block = mock(Block.class);
    Entity ignitingEntity = mock(Entity.class);

    // Act
    BlockIgniteEvent actualBlockIgniteEvent =
        new BlockIgniteEvent(block, IgniteCause.LAVA, ignitingEntity);
    actualBlockIgniteEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBlockIgniteEvent.getHandlerList();
    IgniteCause actualCause = actualBlockIgniteEvent.getCause();
    HandlerList actualHandlers = actualBlockIgniteEvent.getHandlers();
    Block actualIgnitingBlock = actualBlockIgniteEvent.getIgnitingBlock();
    Entity actualIgnitingEntity = actualBlockIgniteEvent.getIgnitingEntity();
    boolean actualIsCancelledResult = actualBlockIgniteEvent.isCancelled();

    // Assert
    assertNull(actualIgnitingBlock);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(IgniteCause.LAVA, actualCause);
    assertFalse(actualBlockIgniteEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(block, actualBlockIgniteEvent.getBlock());
    assertSame(ignitingEntity, actualIgnitingEntity);
  }

  /**
   * Test {@link BlockIgniteEvent#getPlayer()}.
   *
   * <p>Method under test: {@link BlockIgniteEvent#getPlayer()}
   */
  @Test
  @DisplayName("Test getPlayer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.entity.Player BlockIgniteEvent.getPlayer()"})
  void testGetPlayer() {
    // Arrange
    BlockIgniteEvent blockIgniteEvent =
        new BlockIgniteEvent(mock(Block.class), IgniteCause.LAVA, mock(Block.class));

    // Act and Assert
    assertNull(blockIgniteEvent.getPlayer());
  }
}
