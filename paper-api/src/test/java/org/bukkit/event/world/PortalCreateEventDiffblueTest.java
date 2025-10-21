package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.PortalCreateEvent.CreateReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PortalCreateEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Entity is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PortalCreateEvent#PortalCreateEvent(List, World, CreateReason)}
   *   <li>{@link PortalCreateEvent#setCancelled(boolean)}
   *   <li>{@link PortalCreateEvent#getHandlerList()}
   *   <li>{@link PortalCreateEvent#getBlocks()}
   *   <li>{@link PortalCreateEvent#getEntity()}
   *   <li>{@link PortalCreateEvent#getHandlers()}
   *   <li>{@link PortalCreateEvent#getReason()}
   *   <li>{@link PortalCreateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList(); then return Entity is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PortalCreateEvent.<init>(List, World, Entity, CreateReason)",
    "void PortalCreateEvent.<init>(List, World, CreateReason)",
    "List PortalCreateEvent.getBlocks()",
    "Entity PortalCreateEvent.getEntity()",
    "HandlerList PortalCreateEvent.getHandlerList()",
    "HandlerList PortalCreateEvent.getHandlers()",
    "CreateReason PortalCreateEvent.getReason()",
    "boolean PortalCreateEvent.isCancelled()",
    "void PortalCreateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenArrayList_thenReturnEntityIsNull() {
    // Arrange
    ArrayList<BlockState> blocks = new ArrayList<>();
    World world = mock(World.class);

    // Act
    PortalCreateEvent actualPortalCreateEvent =
        new PortalCreateEvent(blocks, world, CreateReason.FIRE);
    actualPortalCreateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPortalCreateEvent.getHandlerList();
    List<BlockState> actualBlocks = actualPortalCreateEvent.getBlocks();
    Entity actualEntity = actualPortalCreateEvent.getEntity();
    HandlerList actualHandlers = actualPortalCreateEvent.getHandlers();
    CreateReason actualReason = actualPortalCreateEvent.getReason();
    boolean actualIsCancelledResult = actualPortalCreateEvent.isCancelled();

    // Assert
    assertNull(actualEntity);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(CreateReason.FIRE, actualReason);
    assertFalse(actualPortalCreateEvent.isAsynchronous());
    assertTrue(actualBlocks.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(blocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualPortalCreateEvent.getWorld());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   *   <li>Then return {@link Entity}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PortalCreateEvent#PortalCreateEvent(List, World, Entity, CreateReason)}
   *   <li>{@link PortalCreateEvent#setCancelled(boolean)}
   *   <li>{@link PortalCreateEvent#getHandlerList()}
   *   <li>{@link PortalCreateEvent#getBlocks()}
   *   <li>{@link PortalCreateEvent#getEntity()}
   *   <li>{@link PortalCreateEvent#getHandlers()}
   *   <li>{@link PortalCreateEvent#getReason()}
   *   <li>{@link PortalCreateEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity; then return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PortalCreateEvent.<init>(List, World, Entity, CreateReason)",
    "void PortalCreateEvent.<init>(List, World, CreateReason)",
    "List PortalCreateEvent.getBlocks()",
    "Entity PortalCreateEvent.getEntity()",
    "HandlerList PortalCreateEvent.getHandlerList()",
    "HandlerList PortalCreateEvent.getHandlers()",
    "CreateReason PortalCreateEvent.getReason()",
    "boolean PortalCreateEvent.isCancelled()",
    "void PortalCreateEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenEntity_thenReturnEntity() {
    // Arrange
    ArrayList<BlockState> blocks = new ArrayList<>();
    World world = mock(World.class);
    Entity entity = mock(Entity.class);

    // Act
    PortalCreateEvent actualPortalCreateEvent =
        new PortalCreateEvent(blocks, world, entity, CreateReason.FIRE);
    actualPortalCreateEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPortalCreateEvent.getHandlerList();
    List<BlockState> actualBlocks = actualPortalCreateEvent.getBlocks();
    Entity actualEntity = actualPortalCreateEvent.getEntity();
    HandlerList actualHandlers = actualPortalCreateEvent.getHandlers();
    CreateReason actualReason = actualPortalCreateEvent.getReason();
    boolean actualIsCancelledResult = actualPortalCreateEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(CreateReason.FIRE, actualReason);
    assertFalse(actualPortalCreateEvent.isAsynchronous());
    assertTrue(actualBlocks.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(blocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(world, actualPortalCreateEvent.getWorld());
    assertSame(entity, actualEntity);
  }
}
