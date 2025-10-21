package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerStatisticIncrementEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code ACACIA_BOAT}.
   *   <li>Then return EntityType is {@code ACACIA_BOAT}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerStatisticIncrementEvent#PlayerStatisticIncrementEvent(Player, Statistic,
   *       int, int, EntityType)}
   *   <li>{@link PlayerStatisticIncrementEvent#setCancelled(boolean)}
   *   <li>{@link PlayerStatisticIncrementEvent#getHandlerList()}
   *   <li>{@link PlayerStatisticIncrementEvent#getEntityType()}
   *   <li>{@link PlayerStatisticIncrementEvent#getHandlers()}
   *   <li>{@link PlayerStatisticIncrementEvent#getMaterial()}
   *   <li>{@link PlayerStatisticIncrementEvent#getNewValue()}
   *   <li>{@link PlayerStatisticIncrementEvent#getPreviousValue()}
   *   <li>{@link PlayerStatisticIncrementEvent#getStatistic()}
   *   <li>{@link PlayerStatisticIncrementEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'ACACIA_BOAT'; then return EntityType is 'ACACIA_BOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerStatisticIncrementEvent.<init>(Player, Statistic, int, int)",
    "void PlayerStatisticIncrementEvent.<init>(Player, Statistic, int, int, EntityType)",
    "EntityType PlayerStatisticIncrementEvent.getEntityType()",
    "HandlerList PlayerStatisticIncrementEvent.getHandlerList()",
    "HandlerList PlayerStatisticIncrementEvent.getHandlers()",
    "Material PlayerStatisticIncrementEvent.getMaterial()",
    "int PlayerStatisticIncrementEvent.getNewValue()",
    "int PlayerStatisticIncrementEvent.getPreviousValue()",
    "Statistic PlayerStatisticIncrementEvent.getStatistic()",
    "boolean PlayerStatisticIncrementEvent.isCancelled()",
    "void PlayerStatisticIncrementEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenAcaciaBoat_thenReturnEntityTypeIsAcaciaBoat() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerStatisticIncrementEvent actualPlayerStatisticIncrementEvent =
        new PlayerStatisticIncrementEvent(
            player, Statistic.ANIMALS_BRED, 42, 42, EntityType.ACACIA_BOAT);
    actualPlayerStatisticIncrementEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerStatisticIncrementEvent.getHandlerList();
    EntityType actualEntityType = actualPlayerStatisticIncrementEvent.getEntityType();
    HandlerList actualHandlers = actualPlayerStatisticIncrementEvent.getHandlers();
    Material actualMaterial = actualPlayerStatisticIncrementEvent.getMaterial();
    int actualNewValue = actualPlayerStatisticIncrementEvent.getNewValue();
    int actualPreviousValue = actualPlayerStatisticIncrementEvent.getPreviousValue();
    Statistic actualStatistic = actualPlayerStatisticIncrementEvent.getStatistic();
    boolean actualIsCancelledResult = actualPlayerStatisticIncrementEvent.isCancelled();

    // Assert
    assertNull(actualMaterial);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(42, actualNewValue);
    assertEquals(42, actualPreviousValue);
    assertEquals(Statistic.ANIMALS_BRED, actualStatistic);
    assertEquals(EntityType.ACACIA_BOAT, actualEntityType);
    assertFalse(actualPlayerStatisticIncrementEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerStatisticIncrementEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Player}.
   *   <li>Then return EntityType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerStatisticIncrementEvent#PlayerStatisticIncrementEvent(Player, Statistic,
   *       int, int)}
   *   <li>{@link PlayerStatisticIncrementEvent#setCancelled(boolean)}
   *   <li>{@link PlayerStatisticIncrementEvent#getHandlerList()}
   *   <li>{@link PlayerStatisticIncrementEvent#getEntityType()}
   *   <li>{@link PlayerStatisticIncrementEvent#getHandlers()}
   *   <li>{@link PlayerStatisticIncrementEvent#getMaterial()}
   *   <li>{@link PlayerStatisticIncrementEvent#getNewValue()}
   *   <li>{@link PlayerStatisticIncrementEvent#getPreviousValue()}
   *   <li>{@link PlayerStatisticIncrementEvent#getStatistic()}
   *   <li>{@link PlayerStatisticIncrementEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Player; then return EntityType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerStatisticIncrementEvent.<init>(Player, Statistic, int, int)",
    "void PlayerStatisticIncrementEvent.<init>(Player, Statistic, int, int, EntityType)",
    "EntityType PlayerStatisticIncrementEvent.getEntityType()",
    "HandlerList PlayerStatisticIncrementEvent.getHandlerList()",
    "HandlerList PlayerStatisticIncrementEvent.getHandlers()",
    "Material PlayerStatisticIncrementEvent.getMaterial()",
    "int PlayerStatisticIncrementEvent.getNewValue()",
    "int PlayerStatisticIncrementEvent.getPreviousValue()",
    "Statistic PlayerStatisticIncrementEvent.getStatistic()",
    "boolean PlayerStatisticIncrementEvent.isCancelled()",
    "void PlayerStatisticIncrementEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenPlayer_thenReturnEntityTypeIsNull() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerStatisticIncrementEvent actualPlayerStatisticIncrementEvent =
        new PlayerStatisticIncrementEvent(player, Statistic.ANIMALS_BRED, 42, 42);
    actualPlayerStatisticIncrementEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerStatisticIncrementEvent.getHandlerList();
    EntityType actualEntityType = actualPlayerStatisticIncrementEvent.getEntityType();
    HandlerList actualHandlers = actualPlayerStatisticIncrementEvent.getHandlers();
    Material actualMaterial = actualPlayerStatisticIncrementEvent.getMaterial();
    int actualNewValue = actualPlayerStatisticIncrementEvent.getNewValue();
    int actualPreviousValue = actualPlayerStatisticIncrementEvent.getPreviousValue();
    Statistic actualStatistic = actualPlayerStatisticIncrementEvent.getStatistic();
    boolean actualIsCancelledResult = actualPlayerStatisticIncrementEvent.isCancelled();

    // Assert
    assertNull(actualMaterial);
    assertNull(actualEntityType);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(42, actualNewValue);
    assertEquals(42, actualPreviousValue);
    assertEquals(Statistic.ANIMALS_BRED, actualStatistic);
    assertFalse(actualPlayerStatisticIncrementEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(player, actualPlayerStatisticIncrementEvent.getPlayer());
  }

  /**
   * Test {@link PlayerStatisticIncrementEvent#PlayerStatisticIncrementEvent(Player, Statistic, int,
   * int, Material)}.
   *
   * <p>Method under test: {@link
   * PlayerStatisticIncrementEvent#PlayerStatisticIncrementEvent(Player, Statistic, int, int,
   * Material)}
   */
  @Test
  @DisplayName("Test new PlayerStatisticIncrementEvent(Player, Statistic, int, int, Material)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerStatisticIncrementEvent.<init>(Player, Statistic, int, int, Material)"
  })
  void testNewPlayerStatisticIncrementEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerStatisticIncrementEvent actualPlayerStatisticIncrementEvent =
        new PlayerStatisticIncrementEvent(
            player, Statistic.ANIMALS_BRED, 42, 42, Material.ACACIA_BOAT);

    // Assert
    assertEquals(
        "PlayerStatisticIncrementEvent", actualPlayerStatisticIncrementEvent.getEventName());
    assertNull(actualPlayerStatisticIncrementEvent.getEntityType());
    assertEquals(
        0, actualPlayerStatisticIncrementEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(42, actualPlayerStatisticIncrementEvent.getNewValue());
    assertEquals(42, actualPlayerStatisticIncrementEvent.getPreviousValue());
    assertEquals(Material.ACACIA_BOAT, actualPlayerStatisticIncrementEvent.getMaterial());
    assertEquals(Statistic.ANIMALS_BRED, actualPlayerStatisticIncrementEvent.getStatistic());
    assertFalse(actualPlayerStatisticIncrementEvent.isAsynchronous());
    assertFalse(actualPlayerStatisticIncrementEvent.isCancelled());
    assertSame(player, actualPlayerStatisticIncrementEvent.getPlayer());
  }
}
