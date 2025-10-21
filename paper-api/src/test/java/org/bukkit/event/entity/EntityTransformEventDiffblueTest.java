package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityTransformEvent.TransformReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTransformEventDiffblueTest {
  /**
   * Test {@link EntityTransformEvent#EntityTransformEvent(Entity, List, TransformReason)}.
   *
   * <ul>
   *   <li>Given {@link Entity}.
   *   <li>Then return TransformedEntities is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityTransformEvent#EntityTransformEvent(Entity, List,
   * TransformReason)}
   */
  @Test
  @DisplayName(
      "Test new EntityTransformEvent(Entity, List, TransformReason); given Entity; then return TransformedEntities is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityTransformEvent.<init>(Entity, List, TransformReason)"})
  void testNewEntityTransformEvent_givenEntity_thenReturnTransformedEntitiesIsArrayList() {
    // Arrange
    Entity original = mock(Entity.class);

    ArrayList<Entity> convertedList = new ArrayList<>();
    convertedList.add(mock(Entity.class));
    convertedList.add(mock(Entity.class));

    // Act
    EntityTransformEvent actualEntityTransformEvent =
        new EntityTransformEvent(original, convertedList, TransformReason.CURED);

    // Assert
    assertEquals("EntityTransformEvent", actualEntityTransformEvent.getEventName());
    assertNull(actualEntityTransformEvent.getEntityType());
    assertEquals(0, actualEntityTransformEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(TransformReason.CURED, actualEntityTransformEvent.getTransformReason());
    assertFalse(actualEntityTransformEvent.isAsynchronous());
    assertFalse(actualEntityTransformEvent.isCancelled());
    assertEquals(convertedList, actualEntityTransformEvent.getTransformedEntities());
    assertSame(original, actualEntityTransformEvent.getEntity());
  }

  /**
   * Test {@link EntityTransformEvent#EntityTransformEvent(Entity, List, TransformReason)}.
   *
   * <ul>
   *   <li>Given {@link Entity}.
   *   <li>Then return TransformedEntities size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityTransformEvent#EntityTransformEvent(Entity, List,
   * TransformReason)}
   */
  @Test
  @DisplayName(
      "Test new EntityTransformEvent(Entity, List, TransformReason); given Entity; then return TransformedEntities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityTransformEvent.<init>(Entity, List, TransformReason)"})
  void testNewEntityTransformEvent_givenEntity_thenReturnTransformedEntitiesSizeIsOne() {
    // Arrange
    Entity original = mock(Entity.class);

    ArrayList<Entity> convertedList = new ArrayList<>();
    convertedList.add(mock(Entity.class));

    // Act
    EntityTransformEvent actualEntityTransformEvent =
        new EntityTransformEvent(original, convertedList, TransformReason.CURED);

    // Assert
    assertEquals("EntityTransformEvent", actualEntityTransformEvent.getEventName());
    assertNull(actualEntityTransformEvent.getEntityType());
    assertEquals(0, actualEntityTransformEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1, actualEntityTransformEvent.getTransformedEntities().size());
    assertEquals(TransformReason.CURED, actualEntityTransformEvent.getTransformReason());
    assertFalse(actualEntityTransformEvent.isAsynchronous());
    assertFalse(actualEntityTransformEvent.isCancelled());
    assertSame(original, actualEntityTransformEvent.getEntity());
  }
}
