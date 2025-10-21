package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IllegalPacketEventDiffblueTest {
  /**
   * Test {@link IllegalPacketEvent#IllegalPacketEvent(Player, String, String, Exception)}.
   *
   * <p>Method under test: {@link IllegalPacketEvent#IllegalPacketEvent(Player, String, String,
   * Exception)}
   */
  @Test
  @DisplayName("Test new IllegalPacketEvent(Player, String, String, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IllegalPacketEvent.<init>(Player, String, String, Exception)"})
  void testNewIllegalPacketEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    IllegalPacketEvent actualIllegalPacketEvent =
        new IllegalPacketEvent(player, "Type", "Kick Message", new Exception());

    // Assert
    assertEquals("IllegalPacketEvent", actualIllegalPacketEvent.getEventName());
    assertEquals("Kick Message", actualIllegalPacketEvent.getKickMessage());
    assertEquals("Type", actualIllegalPacketEvent.getType());
    assertNull(actualIllegalPacketEvent.getExceptionMessage());
    assertEquals(0, actualIllegalPacketEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualIllegalPacketEvent.isAsynchronous());
    assertTrue(actualIllegalPacketEvent.isShouldKick());
    assertSame(player, actualIllegalPacketEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IllegalPacketEvent#setKickMessage(String)}
   *   <li>{@link IllegalPacketEvent#setShouldKick(boolean)}
   *   <li>{@link IllegalPacketEvent#getHandlerList()}
   *   <li>{@link IllegalPacketEvent#getExceptionMessage()}
   *   <li>{@link IllegalPacketEvent#getHandlers()}
   *   <li>{@link IllegalPacketEvent#getKickMessage()}
   *   <li>{@link IllegalPacketEvent#getType()}
   *   <li>{@link IllegalPacketEvent#isShouldKick()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String IllegalPacketEvent.getExceptionMessage()",
    "HandlerList IllegalPacketEvent.getHandlerList()",
    "HandlerList IllegalPacketEvent.getHandlers()",
    "String IllegalPacketEvent.getKickMessage()",
    "String IllegalPacketEvent.getType()",
    "boolean IllegalPacketEvent.isShouldKick()",
    "void IllegalPacketEvent.setKickMessage(String)",
    "void IllegalPacketEvent.setShouldKick(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    IllegalPacketEvent illegalPacketEvent =
        new IllegalPacketEvent(player, "Type", "Kick Message", new Exception());

    // Act
    illegalPacketEvent.setKickMessage("Kick Message");
    illegalPacketEvent.setShouldKick(true);
    HandlerList actualHandlerList = illegalPacketEvent.getHandlerList();
    String actualExceptionMessage = illegalPacketEvent.getExceptionMessage();
    HandlerList actualHandlers = illegalPacketEvent.getHandlers();
    String actualKickMessage = illegalPacketEvent.getKickMessage();
    String actualType = illegalPacketEvent.getType();

    // Assert
    assertEquals("Kick Message", actualKickMessage);
    assertEquals("Type", actualType);
    assertNull(actualExceptionMessage);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(illegalPacketEvent.isShouldKick());
    assertSame(actualHandlerList, actualHandlers);
  }
}
