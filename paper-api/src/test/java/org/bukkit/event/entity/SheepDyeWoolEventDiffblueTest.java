package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SheepDyeWoolEventDiffblueTest {
  /**
   * Test {@link SheepDyeWoolEvent#SheepDyeWoolEvent(Sheep, DyeColor, Player)}.
   *
   * <ul>
   *   <li>When {@link Player}.
   *   <li>Then return {@link Player}.
   * </ul>
   *
   * <p>Method under test: {@link SheepDyeWoolEvent#SheepDyeWoolEvent(Sheep, DyeColor, Player)}
   */
  @Test
  @DisplayName(
      "Test new SheepDyeWoolEvent(Sheep, DyeColor, Player); when Player; then return Player")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SheepDyeWoolEvent.<init>(Sheep, DyeColor)",
    "void SheepDyeWoolEvent.<init>(Sheep, DyeColor, Player)"
  })
  void testNewSheepDyeWoolEvent_whenPlayer_thenReturnPlayer() {
    // Arrange
    Sheep sheep = mock(Sheep.class);
    Player player = mock(Player.class);

    // Act
    SheepDyeWoolEvent actualSheepDyeWoolEvent =
        new SheepDyeWoolEvent(sheep, DyeColor.WHITE, player);

    // Assert
    assertEquals(DyeColor.WHITE, actualSheepDyeWoolEvent.getColor());
    assertFalse(actualSheepDyeWoolEvent.isCancelled());
    assertFalse(actualSheepDyeWoolEvent.isAsynchronous());
    assertSame(player, actualSheepDyeWoolEvent.getPlayer());
    assertSame(sheep, actualSheepDyeWoolEvent.getEntity());
  }

  /**
   * Test {@link SheepDyeWoolEvent#SheepDyeWoolEvent(Sheep, DyeColor)}.
   *
   * <ul>
   *   <li>When {@link Sheep}.
   *   <li>Then return Player is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SheepDyeWoolEvent#SheepDyeWoolEvent(Sheep, DyeColor)}
   */
  @Test
  @DisplayName(
      "Test new SheepDyeWoolEvent(Sheep, DyeColor); when Sheep; then return Player is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SheepDyeWoolEvent.<init>(Sheep, DyeColor)",
    "void SheepDyeWoolEvent.<init>(Sheep, DyeColor, Player)"
  })
  void testNewSheepDyeWoolEvent_whenSheep_thenReturnPlayerIsNull() {
    // Arrange
    Sheep sheep = mock(Sheep.class);

    // Act
    SheepDyeWoolEvent actualSheepDyeWoolEvent = new SheepDyeWoolEvent(sheep, DyeColor.WHITE);

    // Assert
    assertNull(actualSheepDyeWoolEvent.getPlayer());
    assertEquals(DyeColor.WHITE, actualSheepDyeWoolEvent.getColor());
    assertFalse(actualSheepDyeWoolEvent.isCancelled());
    assertFalse(actualSheepDyeWoolEvent.isAsynchronous());
    assertSame(sheep, actualSheepDyeWoolEvent.getEntity());
  }

  /**
   * Test {@link SheepDyeWoolEvent#getEntity()}.
   *
   * <p>Method under test: {@link SheepDyeWoolEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sheep SheepDyeWoolEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    SheepDyeWoolEvent sheepDyeWoolEvent = new SheepDyeWoolEvent(mock(Sheep.class), DyeColor.WHITE);

    // Act
    Sheep actualEntity = sheepDyeWoolEvent.getEntity();

    // Assert
    assertSame(sheepDyeWoolEvent.entity, actualEntity);
  }
}
