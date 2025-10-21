package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElderGuardianAppearanceEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElderGuardianAppearanceEvent#ElderGuardianAppearanceEvent(ElderGuardian, Player)}
   *   <li>{@link ElderGuardianAppearanceEvent#setCancelled(boolean)}
   *   <li>{@link ElderGuardianAppearanceEvent#getHandlerList()}
   *   <li>{@link ElderGuardianAppearanceEvent#getAffectedPlayer()}
   *   <li>{@link ElderGuardianAppearanceEvent#getHandlers()}
   *   <li>{@link ElderGuardianAppearanceEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElderGuardianAppearanceEvent.<init>(ElderGuardian, Player)",
    "Player ElderGuardianAppearanceEvent.getAffectedPlayer()",
    "HandlerList ElderGuardianAppearanceEvent.getHandlerList()",
    "HandlerList ElderGuardianAppearanceEvent.getHandlers()",
    "boolean ElderGuardianAppearanceEvent.isCancelled()",
    "void ElderGuardianAppearanceEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    ElderGuardian guardian = mock(ElderGuardian.class);
    Player affectedPlayer = mock(Player.class);

    // Act
    ElderGuardianAppearanceEvent actualElderGuardianAppearanceEvent =
        new ElderGuardianAppearanceEvent(guardian, affectedPlayer);
    actualElderGuardianAppearanceEvent.setCancelled(true);
    HandlerList actualHandlerList = actualElderGuardianAppearanceEvent.getHandlerList();
    Player actualAffectedPlayer = actualElderGuardianAppearanceEvent.getAffectedPlayer();
    HandlerList actualHandlers = actualElderGuardianAppearanceEvent.getHandlers();
    boolean actualIsCancelledResult = actualElderGuardianAppearanceEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualElderGuardianAppearanceEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(guardian, actualElderGuardianAppearanceEvent.getEntity());
    assertSame(affectedPlayer, actualAffectedPlayer);
  }
}
