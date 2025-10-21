package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitiesUnloadEventDiffblueTest {
  /**
   * Test {@link EntitiesUnloadEvent#EntitiesUnloadEvent(Chunk, List)}.
   *
   * <ul>
   *   <li>Given {@link Entity}.
   *   <li>Then return Entities is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesUnloadEvent#EntitiesUnloadEvent(Chunk, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesUnloadEvent(Chunk, List); given Entity; then return Entities is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesUnloadEvent.<init>(Chunk, List)"})
  void testNewEntitiesUnloadEvent_givenEntity_thenReturnEntitiesIsArrayList() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(mock(Entity.class));

    // Act
    EntitiesUnloadEvent actualEntitiesUnloadEvent = new EntitiesUnloadEvent(chunk, entities);

    // Assert
    verify(chunk).getWorld();
    assertEquals("EntitiesUnloadEvent", actualEntitiesUnloadEvent.getEventName());
    assertEquals(0, actualEntitiesUnloadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualEntitiesUnloadEvent.isAsynchronous());
    assertSame(entities, actualEntitiesUnloadEvent.getEntities());
    assertSame(chunk, actualEntitiesUnloadEvent.getChunk());
  }

  /**
   * Test {@link EntitiesUnloadEvent#EntitiesUnloadEvent(Chunk, List)}.
   *
   * <ul>
   *   <li>Given {@link Entity}.
   *   <li>Then return Entities is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesUnloadEvent#EntitiesUnloadEvent(Chunk, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesUnloadEvent(Chunk, List); given Entity; then return Entities is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesUnloadEvent.<init>(Chunk, List)"})
  void testNewEntitiesUnloadEvent_givenEntity_thenReturnEntitiesIsArrayList2() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(mock(Entity.class));
    entities.add(mock(Entity.class));

    // Act
    EntitiesUnloadEvent actualEntitiesUnloadEvent = new EntitiesUnloadEvent(chunk, entities);

    // Assert
    verify(chunk).getWorld();
    assertEquals("EntitiesUnloadEvent", actualEntitiesUnloadEvent.getEventName());
    assertEquals(0, actualEntitiesUnloadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualEntitiesUnloadEvent.isAsynchronous());
    assertSame(entities, actualEntitiesUnloadEvent.getEntities());
    assertSame(chunk, actualEntitiesUnloadEvent.getChunk());
  }

  /**
   * Test {@link EntitiesUnloadEvent#EntitiesUnloadEvent(Chunk, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesUnloadEvent#EntitiesUnloadEvent(Chunk, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesUnloadEvent(Chunk, List); when ArrayList(); then return Entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesUnloadEvent.<init>(Chunk, List)"})
  void testNewEntitiesUnloadEvent_whenArrayList_thenReturnEntitiesEmpty() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    // Act
    EntitiesUnloadEvent actualEntitiesUnloadEvent =
        new EntitiesUnloadEvent(chunk, new ArrayList<>());

    // Assert
    verify(chunk).getWorld();
    assertEquals("EntitiesUnloadEvent", actualEntitiesUnloadEvent.getEventName());
    assertEquals(0, actualEntitiesUnloadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualEntitiesUnloadEvent.isAsynchronous());
    assertTrue(actualEntitiesUnloadEvent.getEntities().isEmpty());
    assertSame(chunk, actualEntitiesUnloadEvent.getChunk());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesUnloadEvent#getHandlerList()}
   *   <li>{@link EntitiesUnloadEvent#getEntities()}
   *   <li>{@link EntitiesUnloadEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntitiesUnloadEvent.getEntities()",
    "HandlerList EntitiesUnloadEvent.getHandlerList()",
    "HandlerList EntitiesUnloadEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    ArrayList<Entity> entities = new ArrayList<>();

    EntitiesUnloadEvent entitiesUnloadEvent = new EntitiesUnloadEvent(chunk, entities);

    // Act
    HandlerList actualHandlerList = entitiesUnloadEvent.getHandlerList();
    List<Entity> actualEntities = entitiesUnloadEvent.getEntities();
    HandlerList actualHandlers = entitiesUnloadEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualEntities.isEmpty());
    assertSame(entities, actualEntities);
    assertSame(actualHandlerList, actualHandlers);
  }
}
