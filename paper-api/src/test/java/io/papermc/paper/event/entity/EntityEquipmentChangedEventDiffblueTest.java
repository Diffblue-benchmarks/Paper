package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityEquipmentChangedEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityEquipmentChangedEvent#EntityEquipmentChangedEvent(LivingEntity, Map)}
   *   <li>{@link EntityEquipmentChangedEvent#getHandlerList()}
   *   <li>{@link EntityEquipmentChangedEvent#getHandlers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityEquipmentChangedEvent.<init>(LivingEntity, Map)",
    "HandlerList EntityEquipmentChangedEvent.getHandlerList()",
    "HandlerList EntityEquipmentChangedEvent.getHandlers()"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    EntityEquipmentChangedEvent actualEntityEquipmentChangedEvent =
        new EntityEquipmentChangedEvent(entity, new HashMap<>());
    HandlerList actualHandlerList = actualEntityEquipmentChangedEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityEquipmentChangedEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityEquipmentChangedEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityEquipmentChangedEvent.getEntity());
  }

  /**
   * Test {@link EntityEquipmentChangedEvent#getEquipmentChanges()}.
   *
   * <p>Method under test: {@link EntityEquipmentChangedEvent#getEquipmentChanges()}
   */
  @Test
  @DisplayName("Test getEquipmentChanges()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityEquipmentChangedEvent.getEquipmentChanges()"})
  void testGetEquipmentChanges() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    EntityEquipmentChangedEvent entityEquipmentChangedEvent =
        new EntityEquipmentChangedEvent(entity, new HashMap<>());

    // Act and Assert
    assertTrue(entityEquipmentChangedEvent.getEquipmentChanges().isEmpty());
  }
}
