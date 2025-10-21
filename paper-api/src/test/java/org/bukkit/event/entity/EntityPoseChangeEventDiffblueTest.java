package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pose;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityPoseChangeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityPoseChangeEvent#EntityPoseChangeEvent(Entity, Pose)}
   *   <li>{@link EntityPoseChangeEvent#getHandlerList()}
   *   <li>{@link EntityPoseChangeEvent#getHandlers()}
   *   <li>{@link EntityPoseChangeEvent#getPose()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityPoseChangeEvent.<init>(Entity, Pose)",
    "HandlerList EntityPoseChangeEvent.getHandlerList()",
    "HandlerList EntityPoseChangeEvent.getHandlers()",
    "Pose EntityPoseChangeEvent.getPose()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityPoseChangeEvent actualEntityPoseChangeEvent =
        new EntityPoseChangeEvent(entity, Pose.STANDING);
    HandlerList actualHandlerList = actualEntityPoseChangeEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityPoseChangeEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Pose.STANDING, actualEntityPoseChangeEvent.getPose());
    assertFalse(actualEntityPoseChangeEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityPoseChangeEvent.getEntity());
  }
}
