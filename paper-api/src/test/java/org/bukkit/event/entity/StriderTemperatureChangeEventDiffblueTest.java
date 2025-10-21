package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Strider;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StriderTemperatureChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StriderTemperatureChangeEvent#StriderTemperatureChangeEvent(Strider, boolean)}
   *   <li>{@link StriderTemperatureChangeEvent#setCancelled(boolean)}
   *   <li>{@link StriderTemperatureChangeEvent#getHandlerList()}
   *   <li>{@link StriderTemperatureChangeEvent#getHandlers()}
   *   <li>{@link StriderTemperatureChangeEvent#isCancelled()}
   *   <li>{@link StriderTemperatureChangeEvent#isShivering()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StriderTemperatureChangeEvent.<init>(Strider, boolean)",
    "HandlerList StriderTemperatureChangeEvent.getHandlerList()",
    "HandlerList StriderTemperatureChangeEvent.getHandlers()",
    "boolean StriderTemperatureChangeEvent.isCancelled()",
    "boolean StriderTemperatureChangeEvent.isShivering()",
    "void StriderTemperatureChangeEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Strider strider = mock(Strider.class);

    // Act
    StriderTemperatureChangeEvent actualStriderTemperatureChangeEvent =
        new StriderTemperatureChangeEvent(strider, true);
    actualStriderTemperatureChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualStriderTemperatureChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualStriderTemperatureChangeEvent.getHandlers();
    boolean actualIsCancelledResult = actualStriderTemperatureChangeEvent.isCancelled();
    boolean actualIsShiveringResult = actualStriderTemperatureChangeEvent.isShivering();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualStriderTemperatureChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsShiveringResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(strider, actualStriderTemperatureChangeEvent.getEntity());
  }

  /**
   * Test {@link StriderTemperatureChangeEvent#getEntity()}.
   *
   * <p>Method under test: {@link StriderTemperatureChangeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Strider StriderTemperatureChangeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    StriderTemperatureChangeEvent striderTemperatureChangeEvent =
        new StriderTemperatureChangeEvent(mock(Strider.class), true);

    // Act
    Strider actualEntity = striderTemperatureChangeEvent.getEntity();

    // Assert
    assertSame(striderTemperatureChangeEvent.entity, actualEntity);
  }
}
