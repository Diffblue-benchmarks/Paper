package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityKnockbackEvent.KnockbackCause;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityKnockbackEventDiffblueTest {
  /**
   * Test {@link EntityKnockbackEvent#EntityKnockbackEvent(LivingEntity, KnockbackCause, double,
   * Vector, Vector)}.
   *
   * <p>Method under test: {@link EntityKnockbackEvent#EntityKnockbackEvent(LivingEntity,
   * KnockbackCause, double, Vector, Vector)}
   */
  @Test
  @DisplayName(
      "Test new EntityKnockbackEvent(LivingEntity, KnockbackCause, double, Vector, Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityKnockbackEvent.<init>(LivingEntity, KnockbackCause, double, Vector, Vector)"
  })
  void testNewEntityKnockbackEvent() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Vector rawKnockback = Vector.getRandom();
    Vector knockback = Vector.getRandom();

    // Act
    EntityKnockbackEvent actualEntityKnockbackEvent =
        new EntityKnockbackEvent(entity, KnockbackCause.DAMAGE, 10.0d, rawKnockback, knockback);

    // Assert
    assertEquals("EntityKnockbackEvent", actualEntityKnockbackEvent.getEventName());
    assertNull(actualEntityKnockbackEvent.getEntityType());
    assertEquals(10.0d, actualEntityKnockbackEvent.getForce());
    assertEquals(KnockbackCause.DAMAGE, actualEntityKnockbackEvent.getCause());
    assertFalse(actualEntityKnockbackEvent.isAsynchronous());
    assertFalse(actualEntityKnockbackEvent.isCancelled());
    assertEquals(knockback, actualEntityKnockbackEvent.getFinalKnockback());
    assertEquals(rawKnockback, actualEntityKnockbackEvent.getKnockback());
    assertSame(entity, actualEntityKnockbackEvent.getEntity());
  }

  /**
   * Test {@link EntityKnockbackEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityKnockbackEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityKnockbackEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(
            mock(LivingEntity.class),
            KnockbackCause.DAMAGE,
            10.0d,
            Vector.getRandom(),
            Vector.getRandom());

    // Act
    LivingEntity actualEntity = entityKnockbackEvent.getEntity();

    // Assert
    assertSame(entityKnockbackEvent.entity, actualEntity);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKnockbackEvent#setCancelled(boolean)}
   *   <li>{@link EntityKnockbackEvent#getHandlerList()}
   *   <li>{@link EntityKnockbackEvent#getCause()}
   *   <li>{@link EntityKnockbackEvent#getForce()}
   *   <li>{@link EntityKnockbackEvent#getHandlers()}
   *   <li>{@link EntityKnockbackEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "KnockbackCause EntityKnockbackEvent.getCause()",
    "double EntityKnockbackEvent.getForce()",
    "HandlerList EntityKnockbackEvent.getHandlerList()",
    "HandlerList EntityKnockbackEvent.getHandlers()",
    "boolean EntityKnockbackEvent.isCancelled()",
    "void EntityKnockbackEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(
            mock(LivingEntity.class),
            KnockbackCause.DAMAGE,
            10.0d,
            Vector.getRandom(),
            Vector.getRandom());

    // Act
    entityKnockbackEvent.setCancelled(true);
    HandlerList actualHandlerList = entityKnockbackEvent.getHandlerList();
    KnockbackCause actualCause = entityKnockbackEvent.getCause();
    double actualForce = entityKnockbackEvent.getForce();
    HandlerList actualHandlers = entityKnockbackEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(10.0d, actualForce);
    assertEquals(KnockbackCause.DAMAGE, actualCause);
    assertTrue(entityKnockbackEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
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
    LivingEntity entity = mock(LivingEntity.class);
    BlockVector rawKnockback = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    Vector actualKnockback =
        new EntityKnockbackEvent(
                entity, KnockbackCause.DAMAGE, 10.0d, rawKnockback, Vector.getRandom())
            .getKnockback();

    // Assert
    assertTrue(actualKnockback instanceof BlockVector);
    assertEquals(rawKnockback, actualKnockback);
  }

  /**
   * Test {@link EntityKnockbackEvent#getKnockback()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link EntityKnockbackEvent#getKnockback()}
   */
  @Test
  @DisplayName("Test getKnockback(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityKnockbackEvent.getKnockback()"})
  void testGetKnockback_thenReturnRandom() {
    // Arrange
    Vector rawKnockback = Vector.getRandom();

    // Act and Assert
    assertEquals(
        rawKnockback,
        new EntityKnockbackEvent(
                mock(LivingEntity.class),
                KnockbackCause.DAMAGE,
                10.0d,
                rawKnockback,
                Vector.getRandom())
            .getKnockback());
  }

  /**
   * Test {@link EntityKnockbackEvent#getFinalKnockback()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKnockbackEvent#getFinalKnockback()}
   */
  @Test
  @DisplayName("Test getFinalKnockback(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityKnockbackEvent.getFinalKnockback()"})
  void testGetFinalKnockback_thenReturnBlockVector() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Vector rawKnockback = Vector.getRandom();
    BlockVector knockback = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    Vector actualFinalKnockback =
        new EntityKnockbackEvent(entity, KnockbackCause.DAMAGE, 10.0d, rawKnockback, knockback)
            .getFinalKnockback();

    // Assert
    assertTrue(actualFinalKnockback instanceof BlockVector);
    assertEquals(knockback, actualFinalKnockback);
  }

  /**
   * Test {@link EntityKnockbackEvent#getFinalKnockback()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link EntityKnockbackEvent#getFinalKnockback()}
   */
  @Test
  @DisplayName("Test getFinalKnockback(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector EntityKnockbackEvent.getFinalKnockback()"})
  void testGetFinalKnockback_thenReturnRandom() {
    // Arrange
    Vector knockback = Vector.getRandom();

    // Act and Assert
    assertEquals(
        knockback,
        new EntityKnockbackEvent(
                mock(LivingEntity.class),
                KnockbackCause.DAMAGE,
                10.0d,
                Vector.getRandom(),
                knockback)
            .getFinalKnockback());
  }

  /**
   * Test {@link EntityKnockbackEvent#setFinalKnockback(Vector)}.
   *
   * <p>Method under test: {@link EntityKnockbackEvent#setFinalKnockback(Vector)}
   */
  @Test
  @DisplayName("Test setFinalKnockback(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKnockbackEvent.setFinalKnockback(Vector)"})
  void testSetFinalKnockback() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(
            mock(LivingEntity.class),
            KnockbackCause.DAMAGE,
            10.0d,
            Vector.getRandom(),
            Vector.getRandom());
    Vector knockback = Vector.getRandom();

    // Act
    entityKnockbackEvent.setFinalKnockback(knockback);

    // Assert
    assertEquals(knockback, entityKnockbackEvent.getFinalKnockback());
  }

  /**
   * Test {@link EntityKnockbackEvent#setFinalKnockback(Vector)}.
   *
   * <p>Method under test: {@link EntityKnockbackEvent#setFinalKnockback(Vector)}
   */
  @Test
  @DisplayName("Test setFinalKnockback(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKnockbackEvent.setFinalKnockback(Vector)"})
  void testSetFinalKnockback2() {
    // Arrange
    EntityKnockbackEvent entityKnockbackEvent =
        new EntityKnockbackEvent(
            mock(LivingEntity.class),
            KnockbackCause.DAMAGE,
            10.0d,
            Vector.getRandom(),
            Vector.getRandom());
    BlockVector knockback = new BlockVector(2.0d, 3.0d, 10.0d);

    // Act
    entityKnockbackEvent.setFinalKnockback(knockback);

    // Assert
    Vector finalKnockback = entityKnockbackEvent.getFinalKnockback();
    assertTrue(finalKnockback instanceof BlockVector);
    assertEquals(knockback, finalKnockback);
  }
}
