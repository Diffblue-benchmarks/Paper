package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Tameable;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TameableDeathMessageEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TameableDeathMessageEvent#TameableDeathMessageEvent(Tameable, Component)}
   *   <li>{@link TameableDeathMessageEvent#deathMessage(Component)}
   *   <li>{@link TameableDeathMessageEvent#setCancelled(boolean)}
   *   <li>{@link TameableDeathMessageEvent#getHandlerList()}
   *   <li>{@link TameableDeathMessageEvent#deathMessage()}
   *   <li>{@link TameableDeathMessageEvent#getHandlers()}
   *   <li>{@link TameableDeathMessageEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TameableDeathMessageEvent.<init>(Tameable, Component)",
    "Component TameableDeathMessageEvent.deathMessage()",
    "void TameableDeathMessageEvent.deathMessage(Component)",
    "HandlerList TameableDeathMessageEvent.getHandlerList()",
    "HandlerList TameableDeathMessageEvent.getHandlers()",
    "boolean TameableDeathMessageEvent.isCancelled()",
    "void TameableDeathMessageEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Tameable tameable = mock(Tameable.class);

    // Act
    TameableDeathMessageEvent actualTameableDeathMessageEvent =
        new TameableDeathMessageEvent(tameable, mock(Component.class));
    Component deathMessage = mock(Component.class);
    actualTameableDeathMessageEvent.deathMessage(deathMessage);
    actualTameableDeathMessageEvent.setCancelled(true);
    HandlerList actualHandlerList = actualTameableDeathMessageEvent.getHandlerList();
    Component actualDeathMessageResult = actualTameableDeathMessageEvent.deathMessage();
    HandlerList actualHandlers = actualTameableDeathMessageEvent.getHandlers();
    boolean actualIsCancelledResult = actualTameableDeathMessageEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualTameableDeathMessageEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(deathMessage, actualDeathMessageResult);
    assertSame(tameable, actualTameableDeathMessageEvent.getEntity());
  }
}
