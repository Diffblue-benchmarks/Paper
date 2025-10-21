package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BellResonateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BellResonateEvent#BellResonateEvent(Block, List)}
   *   <li>{@link BellResonateEvent#getHandlerList()}
   *   <li>{@link BellResonateEvent#getHandlers()}
   *   <li>{@link BellResonateEvent#getResonatedEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BellResonateEvent.<init>(Block, List)",
    "HandlerList BellResonateEvent.getHandlerList()",
    "HandlerList BellResonateEvent.getHandlers()",
    "List BellResonateEvent.getResonatedEntities()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block bell = mock(Block.class);
    ArrayList<LivingEntity> resonatedEntities = new ArrayList<>();

    // Act
    BellResonateEvent actualBellResonateEvent = new BellResonateEvent(bell, resonatedEntities);
    HandlerList actualHandlerList = actualBellResonateEvent.getHandlerList();
    HandlerList actualHandlers = actualBellResonateEvent.getHandlers();
    List<LivingEntity> actualResonatedEntities = actualBellResonateEvent.getResonatedEntities();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBellResonateEvent.isAsynchronous());
    assertTrue(actualResonatedEntities.isEmpty());
    assertSame(resonatedEntities, actualResonatedEntities);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(bell, actualBellResonateEvent.getBlock());
  }
}
