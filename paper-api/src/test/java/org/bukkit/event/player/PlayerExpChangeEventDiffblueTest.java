package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerExpChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return Source is {@link Entity}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerExpChangeEvent#PlayerExpChangeEvent(Player, Entity, int)}
   *   <li>{@link PlayerExpChangeEvent#setAmount(int)}
   *   <li>{@link PlayerExpChangeEvent#getHandlerList()}
   *   <li>{@link PlayerExpChangeEvent#getAmount()}
   *   <li>{@link PlayerExpChangeEvent#getHandlers()}
   *   <li>{@link PlayerExpChangeEvent#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return Source is Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerExpChangeEvent.<init>(Player, int)",
    "void PlayerExpChangeEvent.<init>(Player, Entity, int)",
    "int PlayerExpChangeEvent.getAmount()",
    "HandlerList PlayerExpChangeEvent.getHandlerList()",
    "HandlerList PlayerExpChangeEvent.getHandlers()",
    "Entity PlayerExpChangeEvent.getSource()",
    "void PlayerExpChangeEvent.setAmount(int)"
  })
  void testGettersAndSetters_whenEntity_thenReturnSourceIsEntity() {
    // Arrange
    Player player = mock(Player.class);
    Entity sourceEntity = mock(Entity.class);

    // Act
    PlayerExpChangeEvent actualPlayerExpChangeEvent =
        new PlayerExpChangeEvent(player, sourceEntity, 1);
    actualPlayerExpChangeEvent.setAmount(10);
    HandlerList actualHandlerList = actualPlayerExpChangeEvent.getHandlerList();
    int actualAmount = actualPlayerExpChangeEvent.getAmount();
    HandlerList actualHandlers = actualPlayerExpChangeEvent.getHandlers();
    Entity actualSource = actualPlayerExpChangeEvent.getSource();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, actualAmount);
    assertFalse(actualPlayerExpChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(sourceEntity, actualSource);
    assertSame(player, actualPlayerExpChangeEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Player}.
   *   <li>Then return Source is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerExpChangeEvent#PlayerExpChangeEvent(Player, int)}
   *   <li>{@link PlayerExpChangeEvent#setAmount(int)}
   *   <li>{@link PlayerExpChangeEvent#getHandlerList()}
   *   <li>{@link PlayerExpChangeEvent#getAmount()}
   *   <li>{@link PlayerExpChangeEvent#getHandlers()}
   *   <li>{@link PlayerExpChangeEvent#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Player; then return Source is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerExpChangeEvent.<init>(Player, int)",
    "void PlayerExpChangeEvent.<init>(Player, Entity, int)",
    "int PlayerExpChangeEvent.getAmount()",
    "HandlerList PlayerExpChangeEvent.getHandlerList()",
    "HandlerList PlayerExpChangeEvent.getHandlers()",
    "Entity PlayerExpChangeEvent.getSource()",
    "void PlayerExpChangeEvent.setAmount(int)"
  })
  void testGettersAndSetters_whenPlayer_thenReturnSourceIsNull() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerExpChangeEvent actualPlayerExpChangeEvent = new PlayerExpChangeEvent(player, 1);
    actualPlayerExpChangeEvent.setAmount(10);
    HandlerList actualHandlerList = actualPlayerExpChangeEvent.getHandlerList();
    int actualAmount = actualPlayerExpChangeEvent.getAmount();
    HandlerList actualHandlers = actualPlayerExpChangeEvent.getHandlers();

    // Assert
    assertNull(actualPlayerExpChangeEvent.getSource());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10, actualAmount);
    assertFalse(actualPlayerExpChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerExpChangeEvent.getPlayer());
  }
}
