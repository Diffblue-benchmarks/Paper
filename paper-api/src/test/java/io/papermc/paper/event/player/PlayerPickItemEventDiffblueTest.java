package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPickItemEventDiffblueTest {
  /**
   * Test {@link PlayerPickItemEvent#isIncludeData()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPickItemEvent#isIncludeData()}
   */
  @Test
  @DisplayName("Test isIncludeData(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPickItemEvent.isIncludeData()"})
  void testIsIncludeData_thenReturnFalse() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), false, 1, 1);

    // Act and Assert
    assertFalse(playerPickBlockEvent.isIncludeData());
  }

  /**
   * Test {@link PlayerPickItemEvent#isIncludeData()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPickItemEvent#isIncludeData()}
   */
  @Test
  @DisplayName("Test isIncludeData(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPickItemEvent.isIncludeData()"})
  void testIsIncludeData_thenReturnTrue() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);

    // Act and Assert
    assertTrue(playerPickBlockEvent.isIncludeData());
  }

  /**
   * Test {@link PlayerPickItemEvent#getTargetSlot()}.
   *
   * <p>Method under test: {@link PlayerPickItemEvent#getTargetSlot()}
   */
  @Test
  @DisplayName("Test getTargetSlot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PlayerPickItemEvent.getTargetSlot()"})
  void testGetTargetSlot() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);

    // Act and Assert
    assertEquals(1, playerPickBlockEvent.getTargetSlot());
  }

  /**
   * Test {@link PlayerPickItemEvent#getSourceSlot()}.
   *
   * <p>Method under test: {@link PlayerPickItemEvent#getSourceSlot()}
   */
  @Test
  @DisplayName("Test getSourceSlot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PlayerPickItemEvent.getSourceSlot()"})
  void testGetSourceSlot() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);

    // Act and Assert
    assertEquals(1, playerPickBlockEvent.getSourceSlot());
  }

  /**
   * Test {@link PlayerPickItemEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPickItemEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPickItemEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);

    // Act and Assert
    assertFalse(playerPickBlockEvent.isCancelled());
  }

  /**
   * Test {@link PlayerPickItemEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PlayerPickItemEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PlayerPickItemEvent.isCancelled()"})
  void testIsCancelled_thenReturnTrue() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);
    playerPickBlockEvent.setCancelled(true);

    // Act and Assert
    assertTrue(playerPickBlockEvent.isCancelled());
  }

  /**
   * Test {@link PlayerPickItemEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PlayerPickItemEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerPickItemEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);

    // Act
    playerPickBlockEvent.setCancelled(true);

    // Assert
    assertTrue(playerPickBlockEvent.isCancelled());
  }

  /**
   * Test {@link PlayerPickItemEvent#getHandlers()}.
   *
   * <p>Method under test: {@link PlayerPickItemEvent#getHandlers()}
   */
  @Test
  @DisplayName("Test getHandlers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.event.HandlerList PlayerPickItemEvent.getHandlers()"})
  void testGetHandlers() {
    // Arrange
    PlayerPickBlockEvent playerPickBlockEvent =
        new PlayerPickBlockEvent(mock(Player.class), mock(Block.class), true, 1, 1);

    // Act and Assert
    assertEquals(0, playerPickBlockEvent.getHandlers().getRegisteredListeners().length);
  }
}
