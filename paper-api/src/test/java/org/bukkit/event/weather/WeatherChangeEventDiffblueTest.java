package org.bukkit.event.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.event.weather.WeatherChangeEvent.Cause;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WeatherChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WeatherChangeEvent#WeatherChangeEvent(World, boolean, Cause)}
   *   <li>{@link WeatherChangeEvent#setCancelled(boolean)}
   *   <li>{@link WeatherChangeEvent#getHandlerList()}
   *   <li>{@link WeatherChangeEvent#getCause()}
   *   <li>{@link WeatherChangeEvent#getHandlers()}
   *   <li>{@link WeatherChangeEvent#isCancelled()}
   *   <li>{@link WeatherChangeEvent#toWeatherState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WeatherChangeEvent.<init>(World, boolean, Cause)",
    "Cause WeatherChangeEvent.getCause()",
    "HandlerList WeatherChangeEvent.getHandlerList()",
    "HandlerList WeatherChangeEvent.getHandlers()",
    "boolean WeatherChangeEvent.isCancelled()",
    "void WeatherChangeEvent.setCancelled(boolean)",
    "boolean WeatherChangeEvent.toWeatherState()"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);

    // Act
    WeatherChangeEvent actualWeatherChangeEvent =
        new WeatherChangeEvent(world, true, Cause.COMMAND);
    actualWeatherChangeEvent.setCancelled(true);
    HandlerList actualHandlerList = actualWeatherChangeEvent.getHandlerList();
    Cause actualCause = actualWeatherChangeEvent.getCause();
    HandlerList actualHandlers = actualWeatherChangeEvent.getHandlers();
    boolean actualIsCancelledResult = actualWeatherChangeEvent.isCancelled();
    boolean actualToWeatherStateResult = actualWeatherChangeEvent.toWeatherState();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Cause.COMMAND, actualCause);
    assertFalse(actualWeatherChangeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualToWeatherStateResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualWeatherChangeEvent.getWorld());
  }

  /**
   * Test {@link WeatherChangeEvent#WeatherChangeEvent(World, boolean)}.
   *
   * <p>Method under test: {@link WeatherChangeEvent#WeatherChangeEvent(World, boolean)}
   */
  @Test
  @DisplayName("Test new WeatherChangeEvent(World, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeatherChangeEvent.<init>(World, boolean)"})
  void testNewWeatherChangeEvent() {
    // Arrange
    World world = mock(World.class);

    // Act
    WeatherChangeEvent actualWeatherChangeEvent = new WeatherChangeEvent(world, true);

    // Assert
    assertEquals("WeatherChangeEvent", actualWeatherChangeEvent.getEventName());
    assertEquals(0, actualWeatherChangeEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Cause.UNKNOWN, actualWeatherChangeEvent.getCause());
    assertFalse(actualWeatherChangeEvent.isAsynchronous());
    assertFalse(actualWeatherChangeEvent.isCancelled());
    assertTrue(actualWeatherChangeEvent.toWeatherState());
    assertSame(world, actualWeatherChangeEvent.getWorld());
  }
}
