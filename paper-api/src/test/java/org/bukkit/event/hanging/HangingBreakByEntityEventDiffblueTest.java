package org.bukkit.event.hanging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HangingBreakByEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HangingBreakByEntityEvent#HangingBreakByEntityEvent(Hanging, Entity, RemoveCause)}
   *   <li>{@link HangingBreakByEntityEvent#getRemover()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HangingBreakByEntityEvent.<init>(Hanging, Entity, RemoveCause)",
    "Entity HangingBreakByEntityEvent.getRemover()"
  })
  void testGettersAndSetters() {
    // Arrange
    Hanging hanging = mock(Hanging.class);
    Entity remover = mock(Entity.class);

    // Act
    HangingBreakByEntityEvent actualHangingBreakByEntityEvent =
        new HangingBreakByEntityEvent(hanging, remover, RemoveCause.ENTITY);
    Entity actualRemover = actualHangingBreakByEntityEvent.getRemover();

    // Assert
    assertEquals(RemoveCause.ENTITY, actualHangingBreakByEntityEvent.getCause());
    assertFalse(actualHangingBreakByEntityEvent.isAsynchronous());
    assertFalse(actualHangingBreakByEntityEvent.isCancelled());
    assertSame(remover, actualRemover);
    assertSame(hanging, actualHangingBreakByEntityEvent.getEntity());
  }

  /**
   * Test {@link HangingBreakByEntityEvent#HangingBreakByEntityEvent(Hanging, Entity)}.
   *
   * <p>Method under test: {@link HangingBreakByEntityEvent#HangingBreakByEntityEvent(Hanging,
   * Entity)}
   */
  @Test
  @DisplayName("Test new HangingBreakByEntityEvent(Hanging, Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HangingBreakByEntityEvent.<init>(Hanging, Entity)"})
  void testNewHangingBreakByEntityEvent() {
    // Arrange
    Hanging hanging = mock(Hanging.class);
    Entity remover = mock(Entity.class);

    // Act
    HangingBreakByEntityEvent actualHangingBreakByEntityEvent =
        new HangingBreakByEntityEvent(hanging, remover);

    // Assert
    assertEquals("HangingBreakByEntityEvent", actualHangingBreakByEntityEvent.getEventName());
    assertEquals(0, actualHangingBreakByEntityEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(RemoveCause.ENTITY, actualHangingBreakByEntityEvent.getCause());
    assertFalse(actualHangingBreakByEntityEvent.isAsynchronous());
    assertFalse(actualHangingBreakByEntityEvent.isCancelled());
    assertSame(remover, actualHangingBreakByEntityEvent.getRemover());
    assertSame(hanging, actualHangingBreakByEntityEvent.getEntity());
  }
}
