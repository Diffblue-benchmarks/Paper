package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThrownEggHatchEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThrownEggHatchEvent#ThrownEggHatchEvent(Egg, boolean, byte, EntityType)}
   *   <li>{@link ThrownEggHatchEvent#setHatching(boolean)}
   *   <li>{@link ThrownEggHatchEvent#setNumHatches(byte)}
   *   <li>{@link ThrownEggHatchEvent#getHandlerList()}
   *   <li>{@link ThrownEggHatchEvent#getEgg()}
   *   <li>{@link ThrownEggHatchEvent#getHandlers()}
   *   <li>{@link ThrownEggHatchEvent#getHatchingType()}
   *   <li>{@link ThrownEggHatchEvent#getNumHatches()}
   *   <li>{@link ThrownEggHatchEvent#isHatching()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThrownEggHatchEvent.<init>(Egg, boolean, byte, EntityType)",
    "Egg ThrownEggHatchEvent.getEgg()",
    "HandlerList ThrownEggHatchEvent.getHandlerList()",
    "HandlerList ThrownEggHatchEvent.getHandlers()",
    "EntityType ThrownEggHatchEvent.getHatchingType()",
    "byte ThrownEggHatchEvent.getNumHatches()",
    "boolean ThrownEggHatchEvent.isHatching()",
    "void ThrownEggHatchEvent.setHatching(boolean)",
    "void ThrownEggHatchEvent.setNumHatches(byte)"
  })
  void testGettersAndSetters() {
    // Arrange
    Egg egg = mock(Egg.class);

    // Act
    ThrownEggHatchEvent actualThrownEggHatchEvent =
        new ThrownEggHatchEvent(egg, true, (byte) 'A', EntityType.ACACIA_BOAT);
    actualThrownEggHatchEvent.setHatching(true);
    actualThrownEggHatchEvent.setNumHatches((byte) 'A');
    HandlerList actualHandlerList = actualThrownEggHatchEvent.getHandlerList();
    Egg actualEgg = actualThrownEggHatchEvent.getEgg();
    HandlerList actualHandlers = actualThrownEggHatchEvent.getHandlers();
    EntityType actualHatchingType = actualThrownEggHatchEvent.getHatchingType();
    byte actualNumHatches = actualThrownEggHatchEvent.getNumHatches();
    boolean actualIsHatchingResult = actualThrownEggHatchEvent.isHatching();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EntityType.ACACIA_BOAT, actualHatchingType);
    assertFalse(actualThrownEggHatchEvent.isAsynchronous());
    assertTrue(actualIsHatchingResult);
    assertEquals('A', actualNumHatches);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(egg, actualEgg);
  }
}
