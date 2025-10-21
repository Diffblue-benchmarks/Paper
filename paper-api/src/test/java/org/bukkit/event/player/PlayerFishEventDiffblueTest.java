package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerFishEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link FishHook}.
   *   <li>Then return Hand is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerFishEvent#PlayerFishEvent(Player, Entity, FishHook, State)}
   *   <li>{@link PlayerFishEvent#setCancelled(boolean)}
   *   <li>{@link PlayerFishEvent#setExpToDrop(int)}
   *   <li>{@link PlayerFishEvent#getHandlerList()}
   *   <li>{@link PlayerFishEvent#getCaught()}
   *   <li>{@link PlayerFishEvent#getExpToDrop()}
   *   <li>{@link PlayerFishEvent#getHand()}
   *   <li>{@link PlayerFishEvent#getHandlers()}
   *   <li>{@link PlayerFishEvent#getHook()}
   *   <li>{@link PlayerFishEvent#getState()}
   *   <li>{@link PlayerFishEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when FishHook; then return Hand is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerFishEvent.<init>(Player, Entity, FishHook, State)",
    "void PlayerFishEvent.<init>(Player, Entity, FishHook, EquipmentSlot, State)",
    "Entity PlayerFishEvent.getCaught()",
    "int PlayerFishEvent.getExpToDrop()",
    "EquipmentSlot PlayerFishEvent.getHand()",
    "HandlerList PlayerFishEvent.getHandlerList()",
    "HandlerList PlayerFishEvent.getHandlers()",
    "FishHook PlayerFishEvent.getHook()",
    "State PlayerFishEvent.getState()",
    "boolean PlayerFishEvent.isCancelled()",
    "void PlayerFishEvent.setCancelled(boolean)",
    "void PlayerFishEvent.setExpToDrop(int)"
  })
  void testGettersAndSetters_whenFishHook_thenReturnHandIsNull() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);
    FishHook hookEntity = mock(FishHook.class);

    // Act
    PlayerFishEvent actualPlayerFishEvent =
        new PlayerFishEvent(player, entity, hookEntity, State.FISHING);
    actualPlayerFishEvent.setCancelled(true);
    actualPlayerFishEvent.setExpToDrop(10);
    HandlerList actualHandlerList = actualPlayerFishEvent.getHandlerList();
    Entity actualCaught = actualPlayerFishEvent.getCaught();
    int actualExpToDrop = actualPlayerFishEvent.getExpToDrop();
    EquipmentSlot actualHand = actualPlayerFishEvent.getHand();
    HandlerList actualHandlers = actualPlayerFishEvent.getHandlers();
    FishHook actualHook = actualPlayerFishEvent.getHook();
    State actualState = actualPlayerFishEvent.getState();
    boolean actualIsCancelledResult = actualPlayerFishEvent.isCancelled();

    // Assert
    assertNull(actualHand);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, actualExpToDrop);
    assertEquals(State.FISHING, actualState);
    assertFalse(actualPlayerFishEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualCaught);
    assertSame(hookEntity, actualHook);
    assertSame(player, actualPlayerFishEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code HAND}.
   *   <li>Then return {@code HAND}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerFishEvent#PlayerFishEvent(Player, Entity, FishHook, EquipmentSlot, State)}
   *   <li>{@link PlayerFishEvent#setCancelled(boolean)}
   *   <li>{@link PlayerFishEvent#setExpToDrop(int)}
   *   <li>{@link PlayerFishEvent#getHandlerList()}
   *   <li>{@link PlayerFishEvent#getCaught()}
   *   <li>{@link PlayerFishEvent#getExpToDrop()}
   *   <li>{@link PlayerFishEvent#getHand()}
   *   <li>{@link PlayerFishEvent#getHandlers()}
   *   <li>{@link PlayerFishEvent#getHook()}
   *   <li>{@link PlayerFishEvent#getState()}
   *   <li>{@link PlayerFishEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'HAND'; then return 'HAND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerFishEvent.<init>(Player, Entity, FishHook, State)",
    "void PlayerFishEvent.<init>(Player, Entity, FishHook, EquipmentSlot, State)",
    "Entity PlayerFishEvent.getCaught()",
    "int PlayerFishEvent.getExpToDrop()",
    "EquipmentSlot PlayerFishEvent.getHand()",
    "HandlerList PlayerFishEvent.getHandlerList()",
    "HandlerList PlayerFishEvent.getHandlers()",
    "FishHook PlayerFishEvent.getHook()",
    "State PlayerFishEvent.getState()",
    "boolean PlayerFishEvent.isCancelled()",
    "void PlayerFishEvent.setCancelled(boolean)",
    "void PlayerFishEvent.setExpToDrop(int)"
  })
  void testGettersAndSetters_whenHand_thenReturnHand() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);
    FishHook hookEntity = mock(FishHook.class);

    // Act
    PlayerFishEvent actualPlayerFishEvent =
        new PlayerFishEvent(player, entity, hookEntity, EquipmentSlot.HAND, State.FISHING);
    actualPlayerFishEvent.setCancelled(true);
    actualPlayerFishEvent.setExpToDrop(10);
    HandlerList actualHandlerList = actualPlayerFishEvent.getHandlerList();
    Entity actualCaught = actualPlayerFishEvent.getCaught();
    int actualExpToDrop = actualPlayerFishEvent.getExpToDrop();
    EquipmentSlot actualHand = actualPlayerFishEvent.getHand();
    HandlerList actualHandlers = actualPlayerFishEvent.getHandlers();
    FishHook actualHook = actualPlayerFishEvent.getHook();
    State actualState = actualPlayerFishEvent.getState();
    boolean actualIsCancelledResult = actualPlayerFishEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, actualExpToDrop);
    assertEquals(State.FISHING, actualState);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualPlayerFishEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualCaught);
    assertSame(hookEntity, actualHook);
    assertSame(player, actualPlayerFishEvent.getPlayer());
  }
}
