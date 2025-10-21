package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Shulker;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ShulkerDuplicateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShulkerDuplicateEvent#ShulkerDuplicateEvent(Shulker, Shulker)}
   *   <li>{@link ShulkerDuplicateEvent#setCancelled(boolean)}
   *   <li>{@link ShulkerDuplicateEvent#getHandlerList()}
   *   <li>{@link ShulkerDuplicateEvent#getHandlers()}
   *   <li>{@link ShulkerDuplicateEvent#getParent()}
   *   <li>{@link ShulkerDuplicateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ShulkerDuplicateEvent.<init>(Shulker, Shulker)",
    "HandlerList ShulkerDuplicateEvent.getHandlerList()",
    "HandlerList ShulkerDuplicateEvent.getHandlers()",
    "Shulker ShulkerDuplicateEvent.getParent()",
    "boolean ShulkerDuplicateEvent.isCancelled()",
    "void ShulkerDuplicateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Shulker child = mock(Shulker.class);
    Shulker parent = mock(Shulker.class);

    // Act
    ShulkerDuplicateEvent actualShulkerDuplicateEvent = new ShulkerDuplicateEvent(child, parent);
    actualShulkerDuplicateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualShulkerDuplicateEvent.getHandlerList();
    HandlerList actualHandlers = actualShulkerDuplicateEvent.getHandlers();
    Shulker actualParent = actualShulkerDuplicateEvent.getParent();
    boolean actualIsCancelledResult = actualShulkerDuplicateEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualShulkerDuplicateEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(child, actualShulkerDuplicateEvent.getEntity());
    assertSame(parent, actualParent);
  }
}
