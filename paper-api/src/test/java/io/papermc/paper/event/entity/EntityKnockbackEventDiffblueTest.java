package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.event.entity.EntityKnockbackEvent.Cause;
import org.bukkit.entity.Entity;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKnockbackEventDiffblueTest {
  /**
   * Test {@link EntityKnockbackEvent#getKnockback()}.
   *
   * <p>Method under test: {@link EntityKnockbackEvent#getKnockback()}
   */
  @Test
  @DisplayName("Test getKnockback()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityKnockbackEvent.getKnockback()"})
  void testGetKnockback() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(mock(Entity.class), Cause.DAMAGE, Vector.getRandom());

    // Act
    Vector actualKnockback = entityKnockbackEvent.getKnockback();

    // Assert
    assertEquals(entityKnockbackEvent.knockback, actualKnockback);
  }

  /**
   * Test {@link EntityKnockbackEvent#getKnockback()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKnockbackEvent#getKnockback()}
   */
  @Test
  @DisplayName("Test getKnockback(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityKnockbackEvent.getKnockback()"})
  void testGetKnockback_thenReturnBlockVector() {
    // Arrange
    Entity entity = mock(Entity.class);
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(entity, Cause.DAMAGE, new BlockVector(2.0d, 3.0d, 10.0d));

    // Act
    Vector actualKnockback = entityKnockbackEvent.getKnockback();

    // Assert
    assertTrue(actualKnockback instanceof BlockVector);
    assertEquals(entityKnockbackEvent.knockback, actualKnockback);
  }

  /**
   * Test {@link EntityKnockbackEvent#setKnockback(Vector)}.
   *
   * <p>Method under test: {@link EntityKnockbackEvent#setKnockback(Vector)}
   */
  @Test
  @DisplayName("Test setKnockback(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKnockbackEvent.setKnockback(Vector)"})
  void testSetKnockback() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(mock(Entity.class), Cause.DAMAGE, Vector.getRandom());
    BlockVector knockback = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    entityKnockbackEvent.setKnockback(knockback);

    // Assert
    Vector knockback2 = entityKnockbackEvent.getKnockback();
    assertTrue(knockback2 instanceof BlockVector);
    assertTrue(entityKnockbackEvent.knockback instanceof BlockVector);
    Vector vector = entityKnockbackEvent.knockback;
    assertEquals(vector, knockback.toBlockVector());
    assertEquals(vector, knockback2);
  }

  /**
   * Test {@link EntityKnockbackEvent#setKnockback(Vector)}.
   *
   * <ul>
   *   <li>When Random.
   * </ul>
   *
   * <p>Method under test: {@link EntityKnockbackEvent#setKnockback(Vector)}
   */
  @Test
  @DisplayName("Test setKnockback(Vector); when Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKnockbackEvent.setKnockback(Vector)"})
  void testSetKnockback_whenRandom() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(mock(Entity.class), Cause.DAMAGE, Vector.getRandom());

    // Act
    entityKnockbackEvent.setKnockback(Vector.getRandom());

    // Assert
    Vector expectedKnockback = entityKnockbackEvent.knockback;
    assertEquals(expectedKnockback, entityKnockbackEvent.getKnockback());
  }
}
