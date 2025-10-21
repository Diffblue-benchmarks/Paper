package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPortalExitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPortalExitEvent#EntityPortalExitEvent(Entity, Location, Location, Vector,
   *       Vector)}
   *   <li>{@link EntityPortalExitEvent#getHandlerList()}
   *   <li>{@link EntityPortalExitEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPortalExitEvent.<init>(Entity, Location, Location, Vector, Vector)",
    "HandlerList EntityPortalExitEvent.getHandlerList()",
    "HandlerList EntityPortalExitEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityPortalExitEvent actualEntityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, Vector.getRandom(), Vector.getRandom());
    HandlerList actualHandlerList = actualEntityPortalExitEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityPortalExitEvent.getHandlers();

    // Assert
    assertFalse(actualEntityPortalExitEvent.isAsynchronous());
    assertFalse(actualEntityPortalExitEvent.isCancelled());
    assertSame(from, actualEntityPortalExitEvent.getFrom());
    assertSame(resultTo, actualEntityPortalExitEvent.getTo());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityPortalExitEvent.getEntity());
  }

  /**
   * Test {@link EntityPortalExitEvent#getBefore()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link EntityPortalExitEvent#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityPortalExitEvent.getBefore()"})
  void testGetBefore_thenReturnBlockVector() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    BlockVector before = new BlockVector(2.0d, 3.0d, 10.0d);

    EntityPortalExitEvent entityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, before, Vector.getRandom());

    // Act
    Vector actualBefore = entityPortalExitEvent.getBefore();

    // Assert
    assertTrue(actualBefore instanceof BlockVector);
    assertEquals(before, actualBefore);
  }

  /**
   * Test {@link EntityPortalExitEvent#getBefore()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link EntityPortalExitEvent#getBefore()}
   */
  @Test
  @DisplayName("Test getBefore(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityPortalExitEvent.getBefore()"})
  void testGetBefore_thenReturnRandom() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Vector before = Vector.getRandom();

    EntityPortalExitEvent entityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, before, Vector.getRandom());

    // Act and Assert
    assertEquals(before, entityPortalExitEvent.getBefore());
  }

  /**
   * Test {@link EntityPortalExitEvent#getAfter()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link EntityPortalExitEvent#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityPortalExitEvent.getAfter()"})
  void testGetAfter_thenReturnBlockVector() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Vector before = Vector.getRandom();
    BlockVector after = new BlockVector(2.0d, 3.0d, 10.0d);

    EntityPortalExitEvent entityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, before, after);

    // Act
    Vector actualAfter = entityPortalExitEvent.getAfter();

    // Assert
    assertTrue(actualAfter instanceof BlockVector);
    assertEquals(after, actualAfter);
  }

  /**
   * Test {@link EntityPortalExitEvent#getAfter()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link EntityPortalExitEvent#getAfter()}
   */
  @Test
  @DisplayName("Test getAfter(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityPortalExitEvent.getAfter()"})
  void testGetAfter_thenReturnRandom() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Vector after = Vector.getRandom();

    EntityPortalExitEvent entityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, Vector.getRandom(), after);

    // Act and Assert
    assertEquals(after, entityPortalExitEvent.getAfter());
  }

  /**
   * Test {@link EntityPortalExitEvent#setAfter(Vector)}.
   *
   * <p>Method under test: {@link EntityPortalExitEvent#setAfter(Vector)}
   */
  @Test
  @DisplayName("Test setAfter(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPortalExitEvent.setAfter(Vector)"})
  void testSetAfter() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityPortalExitEvent entityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, Vector.getRandom(), Vector.getRandom());
    Vector after = Vector.getRandom();

    // Act
    entityPortalExitEvent.setAfter(after);

    // Assert
    assertEquals(after, entityPortalExitEvent.getAfter());
  }

  /**
   * Test {@link EntityPortalExitEvent#setAfter(Vector)}.
   *
   * <p>Method under test: {@link EntityPortalExitEvent#setAfter(Vector)}
   */
  @Test
  @DisplayName("Test setAfter(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPortalExitEvent.setAfter(Vector)"})
  void testSetAfter2() {
    // Arrange
    Entity entity = mock(Entity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityPortalExitEvent entityPortalExitEvent =
        new EntityPortalExitEvent(entity, from, resultTo, Vector.getRandom(), Vector.getRandom());
    BlockVector after = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    entityPortalExitEvent.setAfter(after);

    // Assert
    Vector after2 = entityPortalExitEvent.getAfter();
    assertTrue(after2 instanceof BlockVector);
    assertEquals(after, after2);
  }
}
