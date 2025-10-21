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
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityResurrectEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code HAND}.
   *   <li>Then return {@code HAND}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityResurrectEvent#EntityResurrectEvent(LivingEntity, EquipmentSlot)}
   *   <li>{@link EntityResurrectEvent#setCancelled(boolean)}
   *   <li>{@link EntityResurrectEvent#getHandlerList()}
   *   <li>{@link EntityResurrectEvent#getHand()}
   *   <li>{@link EntityResurrectEvent#getHandlers()}
   *   <li>{@link EntityResurrectEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'HAND'; then return 'HAND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityResurrectEvent.<init>(LivingEntity)",
    "void EntityResurrectEvent.<init>(LivingEntity, EquipmentSlot)",
    "EquipmentSlot EntityResurrectEvent.getHand()",
    "HandlerList EntityResurrectEvent.getHandlerList()",
    "HandlerList EntityResurrectEvent.getHandlers()",
    "boolean EntityResurrectEvent.isCancelled()",
    "void EntityResurrectEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenHand_thenReturnHand() {
    // Arrange
    LivingEntity livingEntity = mock(LivingEntity.class);

    // Act
    EntityResurrectEvent actualEntityResurrectEvent =
        new EntityResurrectEvent(livingEntity, EquipmentSlot.HAND);
    actualEntityResurrectEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityResurrectEvent.getHandlerList();
    EquipmentSlot actualHand = actualEntityResurrectEvent.getHand();
    HandlerList actualHandlers = actualEntityResurrectEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityResurrectEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(EquipmentSlot.HAND, actualHand);
    assertFalse(actualEntityResurrectEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(livingEntity, actualEntityResurrectEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link LivingEntity}.
   *   <li>Then return Hand is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityResurrectEvent#EntityResurrectEvent(LivingEntity)}
   *   <li>{@link EntityResurrectEvent#setCancelled(boolean)}
   *   <li>{@link EntityResurrectEvent#getHandlerList()}
   *   <li>{@link EntityResurrectEvent#getHand()}
   *   <li>{@link EntityResurrectEvent#getHandlers()}
   *   <li>{@link EntityResurrectEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when LivingEntity; then return Hand is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityResurrectEvent.<init>(LivingEntity)",
    "void EntityResurrectEvent.<init>(LivingEntity, EquipmentSlot)",
    "EquipmentSlot EntityResurrectEvent.getHand()",
    "HandlerList EntityResurrectEvent.getHandlerList()",
    "HandlerList EntityResurrectEvent.getHandlers()",
    "boolean EntityResurrectEvent.isCancelled()",
    "void EntityResurrectEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenLivingEntity_thenReturnHandIsNull() {
    // Arrange
    LivingEntity livingEntity = mock(LivingEntity.class);

    // Act
    EntityResurrectEvent actualEntityResurrectEvent = new EntityResurrectEvent(livingEntity);
    actualEntityResurrectEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityResurrectEvent.getHandlerList();
    EquipmentSlot actualHand = actualEntityResurrectEvent.getHand();
    HandlerList actualHandlers = actualEntityResurrectEvent.getHandlers();
    boolean actualIsCancelledResult = actualEntityResurrectEvent.isCancelled();

    // Assert
    assertNull(actualHand);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityResurrectEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(livingEntity, actualEntityResurrectEvent.getEntity());
  }

  /**
   * Test {@link EntityResurrectEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityResurrectEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityResurrectEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityResurrectEvent entityResurrectEvent = new EntityResurrectEvent(mock(LivingEntity.class));

    // Act
    LivingEntity actualEntity = entityResurrectEvent.getEntity();

    // Assert
    assertSame(entityResurrectEvent.entity, actualEntity);
  }
}
