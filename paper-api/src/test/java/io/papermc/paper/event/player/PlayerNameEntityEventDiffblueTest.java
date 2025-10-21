package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerNameEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerNameEntityEvent#PlayerNameEntityEvent(Player, LivingEntity, Component,
   *       boolean)}
   *   <li>{@link PlayerNameEntityEvent#setCancelled(boolean)}
   *   <li>{@link PlayerNameEntityEvent#setEntity(LivingEntity)}
   *   <li>{@link PlayerNameEntityEvent#setName(Component)}
   *   <li>{@link PlayerNameEntityEvent#setPersistent(boolean)}
   *   <li>{@link PlayerNameEntityEvent#getHandlerList()}
   *   <li>{@link PlayerNameEntityEvent#getEntity()}
   *   <li>{@link PlayerNameEntityEvent#getHandlers()}
   *   <li>{@link PlayerNameEntityEvent#getName()}
   *   <li>{@link PlayerNameEntityEvent#isCancelled()}
   *   <li>{@link PlayerNameEntityEvent#isPersistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerNameEntityEvent.<init>(Player, LivingEntity, Component, boolean)",
    "LivingEntity PlayerNameEntityEvent.getEntity()",
    "HandlerList PlayerNameEntityEvent.getHandlerList()",
    "HandlerList PlayerNameEntityEvent.getHandlers()",
    "Component PlayerNameEntityEvent.getName()",
    "boolean PlayerNameEntityEvent.isCancelled()",
    "boolean PlayerNameEntityEvent.isPersistent()",
    "void PlayerNameEntityEvent.setCancelled(boolean)",
    "void PlayerNameEntityEvent.setEntity(LivingEntity)",
    "void PlayerNameEntityEvent.setName(Component)",
    "void PlayerNameEntityEvent.setPersistent(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerNameEntityEvent actualPlayerNameEntityEvent =
        new PlayerNameEntityEvent(player, mock(LivingEntity.class), mock(Component.class), true);
    actualPlayerNameEntityEvent.setCancelled(true);
    LivingEntity entity = mock(LivingEntity.class);
    actualPlayerNameEntityEvent.setEntity(entity);
    Component name = mock(Component.class);
    actualPlayerNameEntityEvent.setName(name);
    actualPlayerNameEntityEvent.setPersistent(true);
    HandlerList actualHandlerList = actualPlayerNameEntityEvent.getHandlerList();
    LivingEntity actualEntity = actualPlayerNameEntityEvent.getEntity();
    HandlerList actualHandlers = actualPlayerNameEntityEvent.getHandlers();
    Component actualName = actualPlayerNameEntityEvent.getName();
    boolean actualIsCancelledResult = actualPlayerNameEntityEvent.isCancelled();
    boolean actualIsPersistentResult = actualPlayerNameEntityEvent.isPersistent();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerNameEntityEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsPersistentResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(name, actualName);
    assertSame(entity, actualEntity);
    assertSame(player, actualPlayerNameEntityEvent.getPlayer());
  }
}
