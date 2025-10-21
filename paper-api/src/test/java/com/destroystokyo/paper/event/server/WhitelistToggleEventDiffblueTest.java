package com.destroystokyo.paper.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WhitelistToggleEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WhitelistToggleEvent#WhitelistToggleEvent(boolean)}
   *   <li>{@link WhitelistToggleEvent#getHandlerList()}
   *   <li>{@link WhitelistToggleEvent#getHandlers()}
   *   <li>{@link WhitelistToggleEvent#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WhitelistToggleEvent.<init>(boolean)",
    "HandlerList WhitelistToggleEvent.getHandlerList()",
    "HandlerList WhitelistToggleEvent.getHandlers()",
    "boolean WhitelistToggleEvent.isEnabled()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WhitelistToggleEvent actualWhitelistToggleEvent = new WhitelistToggleEvent(true);
    HandlerList actualHandlerList = actualWhitelistToggleEvent.getHandlerList();
    HandlerList actualHandlers = actualWhitelistToggleEvent.getHandlers();
    boolean actualIsEnabledResult = actualWhitelistToggleEvent.isEnabled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualWhitelistToggleEvent.isAsynchronous());
    assertTrue(actualIsEnabledResult);
    assertSame(actualHandlerList, actualHandlers);
  }
}
