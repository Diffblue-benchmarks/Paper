package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BeaconActivatedEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BeaconActivatedEvent#BeaconActivatedEvent(Block)}
   *   <li>{@link BeaconActivatedEvent#getHandlerList()}
   *   <li>{@link BeaconActivatedEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeaconActivatedEvent.<init>(Block)",
    "HandlerList BeaconActivatedEvent.getHandlerList()",
    "HandlerList BeaconActivatedEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block beacon = mock(Block.class);

    // Act
    BeaconActivatedEvent actualBeaconActivatedEvent = new BeaconActivatedEvent(beacon);
    HandlerList actualHandlerList = actualBeaconActivatedEvent.getHandlerList();
    HandlerList actualHandlers = actualBeaconActivatedEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBeaconActivatedEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(beacon, actualBeaconActivatedEvent.getBlock());
  }
}
