package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Animals;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityEnterLoveModeEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityEnterLoveModeEvent#EntityEnterLoveModeEvent(Animals, HumanEntity, int)}
   *   <li>{@link EntityEnterLoveModeEvent#setCancelled(boolean)}
   *   <li>{@link EntityEnterLoveModeEvent#setTicksInLove(int)}
   *   <li>{@link EntityEnterLoveModeEvent#getHandlerList()}
   *   <li>{@link EntityEnterLoveModeEvent#getHandlers()}
   *   <li>{@link EntityEnterLoveModeEvent#getHumanEntity()}
   *   <li>{@link EntityEnterLoveModeEvent#getTicksInLove()}
   *   <li>{@link EntityEnterLoveModeEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityEnterLoveModeEvent.<init>(Animals, HumanEntity, int)",
    "HandlerList EntityEnterLoveModeEvent.getHandlerList()",
    "HandlerList EntityEnterLoveModeEvent.getHandlers()",
    "HumanEntity EntityEnterLoveModeEvent.getHumanEntity()",
    "int EntityEnterLoveModeEvent.getTicksInLove()",
    "boolean EntityEnterLoveModeEvent.isCancelled()",
    "void EntityEnterLoveModeEvent.setCancelled(boolean)",
    "void EntityEnterLoveModeEvent.setTicksInLove(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    Animals animalInLove = mock(Animals.class);
    HumanEntity humanEntity = mock(HumanEntity.class);

    // Act
    EntityEnterLoveModeEvent actualEntityEnterLoveModeEvent =
        new EntityEnterLoveModeEvent(animalInLove, humanEntity, 1);
    actualEntityEnterLoveModeEvent.setCancelled(true);
    actualEntityEnterLoveModeEvent.setTicksInLove(1);
    HandlerList actualHandlerList = actualEntityEnterLoveModeEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityEnterLoveModeEvent.getHandlers();
    HumanEntity actualHumanEntity = actualEntityEnterLoveModeEvent.getHumanEntity();
    int actualTicksInLove = actualEntityEnterLoveModeEvent.getTicksInLove();
    boolean actualIsCancelledResult = actualEntityEnterLoveModeEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualTicksInLove);
    assertFalse(actualEntityEnterLoveModeEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(animalInLove, actualEntityEnterLoveModeEvent.getEntity());
    assertSame(humanEntity, actualHumanEntity);
  }

  /**
   * Test {@link EntityEnterLoveModeEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityEnterLoveModeEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Animals EntityEnterLoveModeEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityEnterLoveModeEvent entityEnterLoveModeEvent =
        new EntityEnterLoveModeEvent(mock(Animals.class), mock(HumanEntity.class), 1);

    // Act
    Animals actualEntity = entityEnterLoveModeEvent.getEntity();

    // Assert
    assertSame(entityEnterLoveModeEvent.entity, actualEntity);
  }
}
