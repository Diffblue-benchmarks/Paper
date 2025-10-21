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

class EntitiesLoadEventDiffblueTest {
  /**
   * Test {@link EntitiesLoadEvent#EntitiesLoadEvent(Chunk, List)}.
   *
   * <ul>
   *   <li>Given {@link Entity}.
   *   <li>Then return Entities is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLoadEvent#EntitiesLoadEvent(Chunk, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesLoadEvent(Chunk, List); given Entity; then return Entities is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesLoadEvent.<init>(Chunk, List)"})
  void testNewEntitiesLoadEvent_givenEntity_thenReturnEntitiesIsArrayList() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(mock(Entity.class));

    // Act
    EntitiesLoadEvent actualEntitiesLoadEvent = new EntitiesLoadEvent(chunk, entities);

    // Assert
    verify(chunk).getWorld();
    assertEquals("EntitiesLoadEvent", actualEntitiesLoadEvent.getEventName());
    assertEquals(0, actualEntitiesLoadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualEntitiesLoadEvent.isAsynchronous());
    assertSame(entities, actualEntitiesLoadEvent.getEntities());
    assertSame(chunk, actualEntitiesLoadEvent.getChunk());
  }

  /**
   * Test {@link EntitiesLoadEvent#EntitiesLoadEvent(Chunk, List)}.
   *
   * <ul>
   *   <li>Given {@link Entity}.
   *   <li>Then return Entities is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLoadEvent#EntitiesLoadEvent(Chunk, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesLoadEvent(Chunk, List); given Entity; then return Entities is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesLoadEvent.<init>(Chunk, List)"})
  void testNewEntitiesLoadEvent_givenEntity_thenReturnEntitiesIsArrayList2() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(mock(Entity.class));
    entities.add(mock(Entity.class));

    // Act
    EntitiesLoadEvent actualEntitiesLoadEvent = new EntitiesLoadEvent(chunk, entities);

    // Assert
    verify(chunk).getWorld();
    assertEquals("EntitiesLoadEvent", actualEntitiesLoadEvent.getEventName());
    assertEquals(0, actualEntitiesLoadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualEntitiesLoadEvent.isAsynchronous());
    assertSame(entities, actualEntitiesLoadEvent.getEntities());
    assertSame(chunk, actualEntitiesLoadEvent.getChunk());
  }

  /**
   * Test {@link EntitiesLoadEvent#EntitiesLoadEvent(Chunk, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLoadEvent#EntitiesLoadEvent(Chunk, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesLoadEvent(Chunk, List); when ArrayList(); then return Entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesLoadEvent.<init>(Chunk, List)"})
  void testNewEntitiesLoadEvent_whenArrayList_thenReturnEntitiesEmpty() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    when(chunk.getWorld()).thenReturn(mock(World.class));

    // Act
    EntitiesLoadEvent actualEntitiesLoadEvent = new EntitiesLoadEvent(chunk, new ArrayList<>());

    // Assert
    verify(chunk).getWorld();
    assertEquals("EntitiesLoadEvent", actualEntitiesLoadEvent.getEventName());
    assertEquals(0, actualEntitiesLoadEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualEntitiesLoadEvent.isAsynchronous());
    assertTrue(actualEntitiesLoadEvent.getEntities().isEmpty());
    assertSame(chunk, actualEntitiesLoadEvent.getChunk());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLoadEvent#getHandlerList()}
   *   <li>{@link EntitiesLoadEvent#getEntities()}
   *   <li>{@link EntitiesLoadEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List EntitiesLoadEvent.getEntities()",
    "HandlerList EntitiesLoadEvent.getHandlerList()",
    "HandlerList EntitiesLoadEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Chunk chunk = mock(Chunk.class);
    ArrayList<Entity> entities = new ArrayList<>();

    EntitiesLoadEvent entitiesLoadEvent = new EntitiesLoadEvent(chunk, entities);

    // Act
    HandlerList actualHandlerList = entitiesLoadEvent.getHandlerList();
    List<Entity> actualEntities = entitiesLoadEvent.getEntities();
    HandlerList actualHandlers = entitiesLoadEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualEntities.isEmpty());
    assertSame(entities, actualEntities);
    assertSame(actualHandlerList, actualHandlers);
  }
}
