package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.entity.EntityKnockbackEvent.Cause;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPushedByEntityAttackEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPushedByEntityAttackEvent#EntityPushedByEntityAttackEvent(Entity, Cause,
   *       Entity, Vector)}
   *   <li>{@link EntityPushedByEntityAttackEvent#getAcceleration()}
   *   <li>{@link EntityPushedByEntityAttackEvent#getPushedBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPushedByEntityAttackEvent.<init>(Entity, Cause, Entity, Vector)",
    "Vector EntityPushedByEntityAttackEvent.getAcceleration()",
    "Entity EntityPushedByEntityAttackEvent.getPushedBy()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);
    Entity pushedBy = mock(Entity.class);
    Vector knockback = Vector.getRandom();

    // Act
    EntityPushedByEntityAttackEvent actualEntityPushedByEntityAttackEvent =
        new EntityPushedByEntityAttackEvent(entity, Cause.DAMAGE, pushedBy, knockback);
    Vector actualAcceleration = actualEntityPushedByEntityAttackEvent.getAcceleration();
    Entity actualPushedBy = actualEntityPushedByEntityAttackEvent.getPushedBy();

    // Assert
    assertEquals(Cause.DAMAGE, actualEntityPushedByEntityAttackEvent.getCause());
    assertFalse(actualEntityPushedByEntityAttackEvent.isCancelled());
    assertFalse(actualEntityPushedByEntityAttackEvent.isAsynchronous());
    assertSame(knockback, actualAcceleration);
    assertSame(pushedBy, actualPushedBy);
    assertSame(entity, actualEntityPushedByEntityAttackEvent.getEntity());
  }

  /**
   * Test {@link EntityPushedByEntityAttackEvent#setAcceleration(Vector)}.
   *
   * <p>Method under test: {@link EntityPushedByEntityAttackEvent#setAcceleration(Vector)}
   */
  @Test
  @DisplayName("Test setAcceleration(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPushedByEntityAttackEvent.setAcceleration(Vector)"})
  void testSetAcceleration() {
    // Arrange
    EntityPushedByEntityAttackEvent entityPushedByEntityAttackEvent =
        new EntityPushedByEntityAttackEvent(
            mock(Entity.class), Cause.DAMAGE, mock(Entity.class), Vector.getRandom());
    Vector acceleration = Vector.getRandom();

    // Act
    entityPushedByEntityAttackEvent.setAcceleration(acceleration);

    // Assert
    assertEquals(acceleration, entityPushedByEntityAttackEvent.getAcceleration());
  }

  /**
   * Test {@link EntityPushedByEntityAttackEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityPushedByEntityAttackEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityPushedByEntityAttackEvent.isCancelled()"})
  void testIsCancelled_thenReturnFalse() {
    // Arrange
    EntityPushedByEntityAttackEvent entityPushedByEntityAttackEvent =
        new EntityPushedByEntityAttackEvent(
            mock(Entity.class), Cause.DAMAGE, mock(Entity.class), Vector.getRandom());

    // Act and Assert
    assertFalse(entityPushedByEntityAttackEvent.isCancelled());
  }

  /**
   * Test {@link EntityPushedByEntityAttackEvent#isCancelled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityPushedByEntityAttackEvent#isCancelled()}
   */
  @Test
  @DisplayName("Test isCancelled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityPushedByEntityAttackEvent.isCancelled()"})
  void testIsCancelled_thenReturnTrue() {
    // Arrange
    EntityPushedByEntityAttackEvent entityPushedByEntityAttackEvent =
        new EntityPushedByEntityAttackEvent(
            mock(Entity.class), Cause.DAMAGE, mock(Entity.class), Vector.getRandom());
    entityPushedByEntityAttackEvent.setCancelled(true);

    // Act and Assert
    assertTrue(entityPushedByEntityAttackEvent.isCancelled());
  }

  /**
   * Test {@link EntityPushedByEntityAttackEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link EntityPushedByEntityAttackEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityPushedByEntityAttackEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    EntityPushedByEntityAttackEvent entityPushedByEntityAttackEvent =
        new EntityPushedByEntityAttackEvent(
            mock(Entity.class), Cause.DAMAGE, mock(Entity.class), Vector.getRandom());

    // Act
    entityPushedByEntityAttackEvent.setCancelled(true);

    // Assert
    assertTrue(entityPushedByEntityAttackEvent.isCancelled());
  }
}
