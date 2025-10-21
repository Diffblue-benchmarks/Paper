package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.block.LockableTileState;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockLockCheckEventDiffblueTest {
  /**
   * Test {@link BlockLockCheckEvent#BlockLockCheckEvent(Block, Player, Component, Sound)}.
   *
   * <p>Method under test: {@link BlockLockCheckEvent#BlockLockCheckEvent(Block, Player, Component,
   * Sound)}
   */
  @Test
  @DisplayName("Test new BlockLockCheckEvent(Block, Player, Component, Sound)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockLockCheckEvent.<init>(Block, Player, Component, Sound)"})
  void testNewBlockLockCheckEvent() {
    // Arrange
    Block block = mock(Block.class);
    Player player = mock(Player.class);
    Component lockedMessage = mock(Component.class);
    Sound lockedSound = mock(Sound.class);

    // Act
    BlockLockCheckEvent actualBlockLockCheckEvent =
        new BlockLockCheckEvent(block, player, lockedMessage, lockedSound);

    // Assert
    assertEquals("BlockLockCheckEvent", actualBlockLockCheckEvent.getEventName());
    assertEquals(0, actualBlockLockCheckEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.DEFAULT, actualBlockLockCheckEvent.getResult());
    assertFalse(actualBlockLockCheckEvent.isUsingCustomKeyItemStack());
    assertFalse(actualBlockLockCheckEvent.isAsynchronous());
    assertSame(lockedSound, actualBlockLockCheckEvent.getLockedSound());
    assertSame(lockedMessage, actualBlockLockCheckEvent.getLockedMessage());
    assertSame(block, actualBlockLockCheckEvent.getBlock());
    assertSame(player, actualBlockLockCheckEvent.getPlayer());
  }

  /**
   * Test {@link BlockLockCheckEvent#getBlockState()}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getState()} return {@link LockableTileState}.
   *   <li>Then calls {@link Block#getState()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockLockCheckEvent#getBlockState()}
   */
  @Test
  @DisplayName(
      "Test getBlockState(); given Block getState() return LockableTileState; then calls getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LockableTileState BlockLockCheckEvent.getBlockState()"})
  void testGetBlockState_givenBlockGetStateReturnLockableTileState_thenCallsGetState() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getState()).thenReturn(mock(LockableTileState.class));
    BlockLockCheckEvent blockLockCheckEvent =
        new BlockLockCheckEvent(
            block, mock(Player.class), mock(Component.class), mock(Sound.class));

    // Act
    blockLockCheckEvent.getBlockState();

    // Assert
    verify(block).getState();
  }

  /**
   * Test {@link BlockLockCheckEvent#setKeyItem(ItemStack)}.
   *
   * <p>Method under test: {@link BlockLockCheckEvent#setKeyItem(ItemStack)}
   */
  @Test
  @DisplayName("Test setKeyItem(ItemStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockLockCheckEvent.setKeyItem(ItemStack)"})
  void testSetKeyItem() {
    // Arrange
    BlockLockCheckEvent blockLockCheckEvent =
        new BlockLockCheckEvent(
            mock(Block.class), mock(Player.class), mock(Component.class), mock(Sound.class));

    // Act
    blockLockCheckEvent.setKeyItem(mock(ItemStack.class));

    // Assert
    assertTrue(blockLockCheckEvent.isUsingCustomKeyItemStack());
  }

  /**
   * Test {@link BlockLockCheckEvent#isUsingCustomKeyItemStack()}.
   *
   * <p>Method under test: {@link BlockLockCheckEvent#isUsingCustomKeyItemStack()}
   */
  @Test
  @DisplayName("Test isUsingCustomKeyItemStack()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockLockCheckEvent.isUsingCustomKeyItemStack()"})
  void testIsUsingCustomKeyItemStack() {
    // Arrange
    BlockLockCheckEvent blockLockCheckEvent =
        new BlockLockCheckEvent(
            mock(Block.class), mock(Player.class), mock(Component.class), mock(Sound.class));

    // Act and Assert
    assertFalse(blockLockCheckEvent.isUsingCustomKeyItemStack());
  }

  /**
   * Test {@link BlockLockCheckEvent#denyWithMessageAndSound(Component, Sound)}.
   *
   * <p>Method under test: {@link BlockLockCheckEvent#denyWithMessageAndSound(Component, Sound)}
   */
  @Test
  @DisplayName("Test denyWithMessageAndSound(Component, Sound)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockLockCheckEvent.denyWithMessageAndSound(Component, Sound)"})
  void testDenyWithMessageAndSound() {
    // Arrange
    BlockLockCheckEvent blockLockCheckEvent =
        new BlockLockCheckEvent(
            mock(Block.class), mock(Player.class), mock(Component.class), mock(Sound.class));
    Component lockedMessage = mock(Component.class);
    Sound lockedSound = mock(Sound.class);

    // Act
    blockLockCheckEvent.denyWithMessageAndSound(lockedMessage, lockedSound);

    // Assert
    assertEquals(Result.DENY, blockLockCheckEvent.getResult());
    assertSame(lockedSound, blockLockCheckEvent.getLockedSound());
    assertSame(lockedMessage, blockLockCheckEvent.getLockedMessage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockLockCheckEvent#setLockedMessage(Component)}
   *   <li>{@link BlockLockCheckEvent#setLockedSound(Sound)}
   *   <li>{@link BlockLockCheckEvent#setResult(Result)}
   *   <li>{@link BlockLockCheckEvent#getHandlerList()}
   *   <li>{@link BlockLockCheckEvent#resetKeyItem()}
   *   <li>{@link BlockLockCheckEvent#getHandlers()}
   *   <li>{@link BlockLockCheckEvent#getLockedMessage()}
   *   <li>{@link BlockLockCheckEvent#getLockedSound()}
   *   <li>{@link BlockLockCheckEvent#getPlayer()}
   *   <li>{@link BlockLockCheckEvent#getResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList BlockLockCheckEvent.getHandlerList()",
    "HandlerList BlockLockCheckEvent.getHandlers()",
    "Component BlockLockCheckEvent.getLockedMessage()",
    "Sound BlockLockCheckEvent.getLockedSound()",
    "Player BlockLockCheckEvent.getPlayer()",
    "Result BlockLockCheckEvent.getResult()",
    "void BlockLockCheckEvent.resetKeyItem()",
    "void BlockLockCheckEvent.setLockedMessage(Component)",
    "void BlockLockCheckEvent.setLockedSound(Sound)",
    "void BlockLockCheckEvent.setResult(Result)"
  })
  void testGettersAndSetters() {
    // Arrange
    BlockLockCheckEvent blockLockCheckEvent =
        new BlockLockCheckEvent(
            mock(Block.class), mock(Player.class), mock(Component.class), mock(Sound.class));
    Component lockedMessage = mock(Component.class);

    // Act
    blockLockCheckEvent.setLockedMessage(lockedMessage);
    Sound lockedSound = mock(Sound.class);
    blockLockCheckEvent.setLockedSound(lockedSound);
    blockLockCheckEvent.setResult(Result.DENY);
    HandlerList actualHandlerList = blockLockCheckEvent.getHandlerList();
    blockLockCheckEvent.resetKeyItem();
    HandlerList actualHandlers = blockLockCheckEvent.getHandlers();
    Component actualLockedMessage = blockLockCheckEvent.getLockedMessage();
    Sound actualLockedSound = blockLockCheckEvent.getLockedSound();
    blockLockCheckEvent.getPlayer();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Result.DENY, blockLockCheckEvent.getResult());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(lockedSound, actualLockedSound);
    assertSame(lockedMessage, actualLockedMessage);
  }
}
