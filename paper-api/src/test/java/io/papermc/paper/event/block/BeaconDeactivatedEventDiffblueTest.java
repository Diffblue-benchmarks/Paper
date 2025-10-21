package io.papermc.paper.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BeaconDeactivatedEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BeaconDeactivatedEvent#BeaconDeactivatedEvent(Block)}
   *   <li>{@link BeaconDeactivatedEvent#getHandlerList()}
   *   <li>{@link BeaconDeactivatedEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeaconDeactivatedEvent.<init>(Block)",
    "HandlerList BeaconDeactivatedEvent.getHandlerList()",
    "HandlerList BeaconDeactivatedEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block beacon = mock(Block.class);

    // Act
    BeaconDeactivatedEvent actualBeaconDeactivatedEvent = new BeaconDeactivatedEvent(beacon);
    HandlerList actualHandlerList = actualBeaconDeactivatedEvent.getHandlerList();
    HandlerList actualHandlers = actualBeaconDeactivatedEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBeaconDeactivatedEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(beacon, actualBeaconDeactivatedEvent.getBlock());
  }

  /**
   * Test {@link BeaconDeactivatedEvent#getBeacon()}.
   *
   * <p>Method under test: {@link BeaconDeactivatedEvent#getBeacon()}
   */
  @Test
  @DisplayName("Test getBeacon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Beacon BeaconDeactivatedEvent.getBeacon()"})
  void testGetBeacon() {
    // Arrange
    Block beacon = mock(Block.class);
    when(beacon.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    Beacon actualBeacon = new BeaconDeactivatedEvent(beacon).getBeacon();

    // Assert
    verify(beacon).getType();
    assertNull(actualBeacon);
  }
}
