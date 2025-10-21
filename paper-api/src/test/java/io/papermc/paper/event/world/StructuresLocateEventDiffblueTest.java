package io.papermc.paper.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.world.StructuresLocateEvent.Result;
import io.papermc.paper.math.Position;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StructuresLocateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuresLocateEvent#StructuresLocateEvent(World, Location, List, int, boolean)}
   *   <li>{@link StructuresLocateEvent#setCancelled(boolean)}
   *   <li>{@link StructuresLocateEvent#setFindUnexplored(boolean)}
   *   <li>{@link StructuresLocateEvent#setRadius(int)}
   *   <li>{@link StructuresLocateEvent#setResult(Result)}
   *   <li>{@link StructuresLocateEvent#setStructures(List)}
   *   <li>{@link StructuresLocateEvent#getHandlerList()}
   *   <li>{@link StructuresLocateEvent#getHandlers()}
   *   <li>{@link StructuresLocateEvent#getRadius()}
   *   <li>{@link StructuresLocateEvent#getResult()}
   *   <li>{@link StructuresLocateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuresLocateEvent.<init>(World, Location, List, int, boolean)",
    "HandlerList StructuresLocateEvent.getHandlerList()",
    "HandlerList StructuresLocateEvent.getHandlers()",
    "int StructuresLocateEvent.getRadius()",
    "Result StructuresLocateEvent.getResult()",
    "boolean StructuresLocateEvent.isCancelled()",
    "void StructuresLocateEvent.setCancelled(boolean)",
    "void StructuresLocateEvent.setFindUnexplored(boolean)",
    "void StructuresLocateEvent.setRadius(int)",
    "void StructuresLocateEvent.setResult(Result)",
    "void StructuresLocateEvent.setStructures(List)"
  })
  void testGettersAndSetters() {
    // Arrange
    World world = mock(World.class);
    Location origin = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    StructuresLocateEvent actualStructuresLocateEvent =
        new StructuresLocateEvent(world, origin, new ArrayList<>(), 1, true);
    actualStructuresLocateEvent.setCancelled(true);
    actualStructuresLocateEvent.setFindUnexplored(true);
    actualStructuresLocateEvent.setRadius(1);
    Result result = new Result(Position.BLOCK_ZERO, null);
    actualStructuresLocateEvent.setResult(result);
    actualStructuresLocateEvent.setStructures(new ArrayList<>());
    HandlerList actualHandlerList = actualStructuresLocateEvent.getHandlerList();
    HandlerList actualHandlers = actualStructuresLocateEvent.getHandlers();
    int actualRadius = actualStructuresLocateEvent.getRadius();
    Result actualResult = actualStructuresLocateEvent.getResult();
    boolean actualIsCancelledResult = actualStructuresLocateEvent.isCancelled();

    // Assert
    assertEquals(1, actualRadius);
    assertFalse(actualStructuresLocateEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(result, actualResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualStructuresLocateEvent.getWorld());
  }
}
