package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HorseJumpEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HorseJumpEvent#HorseJumpEvent(AbstractHorse, float)}
   *   <li>{@link HorseJumpEvent#setCancelled(boolean)}
   *   <li>{@link HorseJumpEvent#setPower(float)}
   *   <li>{@link HorseJumpEvent#getHandlerList()}
   *   <li>{@link HorseJumpEvent#getHandlers()}
   *   <li>{@link HorseJumpEvent#getPower()}
   *   <li>{@link HorseJumpEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HorseJumpEvent.<init>(AbstractHorse, float)",
    "HandlerList HorseJumpEvent.getHandlerList()",
    "HandlerList HorseJumpEvent.getHandlers()",
    "float HorseJumpEvent.getPower()",
    "boolean HorseJumpEvent.isCancelled()",
    "void HorseJumpEvent.setCancelled(boolean)",
    "void HorseJumpEvent.setPower(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    AbstractHorse horse = mock(AbstractHorse.class);

    // Act
    HorseJumpEvent actualHorseJumpEvent = new HorseJumpEvent(horse, 10.0f);
    actualHorseJumpEvent.setCancelled(true);
    actualHorseJumpEvent.setPower(10.0f);
    HandlerList actualHandlerList = actualHorseJumpEvent.getHandlerList();
    HandlerList actualHandlers = actualHorseJumpEvent.getHandlers();
    float actualPower = actualHorseJumpEvent.getPower();
    boolean actualIsCancelledResult = actualHorseJumpEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0f, actualPower);
    assertFalse(actualHorseJumpEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(horse, actualHorseJumpEvent.getEntity());
  }

  /**
   * Test {@link HorseJumpEvent#getEntity()}.
   *
   * <p>Method under test: {@link HorseJumpEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractHorse HorseJumpEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    HorseJumpEvent horseJumpEvent = new HorseJumpEvent(mock(AbstractHorse.class), 10.0f);

    // Act
    AbstractHorse actualEntity = horseJumpEvent.getEntity();

    // Assert
    assertSame(horseJumpEvent.entity, actualEntity);
  }
}
