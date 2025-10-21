package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Firework;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FireworkExplodeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FireworkExplodeEvent#FireworkExplodeEvent(Firework)}
   *   <li>{@link FireworkExplodeEvent#setCancelled(boolean)}
   *   <li>{@link FireworkExplodeEvent#getHandlerList()}
   *   <li>{@link FireworkExplodeEvent#getHandlers()}
   *   <li>{@link FireworkExplodeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FireworkExplodeEvent.<init>(Firework)",
    "HandlerList FireworkExplodeEvent.getHandlerList()",
    "HandlerList FireworkExplodeEvent.getHandlers()",
    "boolean FireworkExplodeEvent.isCancelled()",
    "void FireworkExplodeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Firework firework = mock(Firework.class);

    // Act
    FireworkExplodeEvent actualFireworkExplodeEvent = new FireworkExplodeEvent(firework);
    actualFireworkExplodeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualFireworkExplodeEvent.getHandlerList();
    HandlerList actualHandlers = actualFireworkExplodeEvent.getHandlers();
    boolean actualIsCancelledResult = actualFireworkExplodeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualFireworkExplodeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(firework, actualFireworkExplodeEvent.getEntity());
  }

  /**
   * Test {@link FireworkExplodeEvent#getEntity()}.
   *
   * <p>Method under test: {@link FireworkExplodeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Firework FireworkExplodeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    FireworkExplodeEvent fireworkExplodeEvent = new FireworkExplodeEvent(mock(Firework.class));

    // Act
    Firework actualEntity = fireworkExplodeEvent.getEntity();

    // Assert
    assertSame(fireworkExplodeEvent.entity, actualEntity);
  }
}
