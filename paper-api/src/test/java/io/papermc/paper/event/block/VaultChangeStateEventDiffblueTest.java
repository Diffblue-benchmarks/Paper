package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Vault;
import org.bukkit.block.data.type.Vault.State;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VaultChangeStateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VaultChangeStateEvent#VaultChangeStateEvent(Block, Player, State, State)}
   *   <li>{@link VaultChangeStateEvent#setCancelled(boolean)}
   *   <li>{@link VaultChangeStateEvent#getHandlerList()}
   *   <li>{@link VaultChangeStateEvent#getCurrentState()}
   *   <li>{@link VaultChangeStateEvent#getHandlers()}
   *   <li>{@link VaultChangeStateEvent#getNewState()}
   *   <li>{@link VaultChangeStateEvent#getPlayer()}
   *   <li>{@link VaultChangeStateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VaultChangeStateEvent.<init>(Block, Player, State, State)",
    "State VaultChangeStateEvent.getCurrentState()",
    "HandlerList VaultChangeStateEvent.getHandlerList()",
    "HandlerList VaultChangeStateEvent.getHandlers()",
    "State VaultChangeStateEvent.getNewState()",
    "Player VaultChangeStateEvent.getPlayer()",
    "boolean VaultChangeStateEvent.isCancelled()",
    "void VaultChangeStateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Block vaultBlock = mock(Block.class);
    Player player = mock(Player.class);

    // Act
    VaultChangeStateEvent actualVaultChangeStateEvent =
        new VaultChangeStateEvent(vaultBlock, player, State.INACTIVE, State.INACTIVE);
    actualVaultChangeStateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualVaultChangeStateEvent.getHandlerList();
    State actualCurrentState = actualVaultChangeStateEvent.getCurrentState();
    HandlerList actualHandlers = actualVaultChangeStateEvent.getHandlers();
    State actualNewState = actualVaultChangeStateEvent.getNewState();
    Player actualPlayer = actualVaultChangeStateEvent.getPlayer();
    boolean actualIsCancelledResult = actualVaultChangeStateEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(State.INACTIVE, actualCurrentState);
    assertEquals(State.INACTIVE, actualNewState);
    assertFalse(actualVaultChangeStateEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(vaultBlock, actualVaultChangeStateEvent.getBlock());
    assertSame(player, actualPlayer);
  }
}
