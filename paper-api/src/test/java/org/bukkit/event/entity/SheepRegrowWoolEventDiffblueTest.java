package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Sheep;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SheepRegrowWoolEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SheepRegrowWoolEvent#SheepRegrowWoolEvent(Sheep)}
   *   <li>{@link SheepRegrowWoolEvent#setCancelled(boolean)}
   *   <li>{@link SheepRegrowWoolEvent#getHandlerList()}
   *   <li>{@link SheepRegrowWoolEvent#getHandlers()}
   *   <li>{@link SheepRegrowWoolEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SheepRegrowWoolEvent.<init>(Sheep)",
    "HandlerList SheepRegrowWoolEvent.getHandlerList()",
    "HandlerList SheepRegrowWoolEvent.getHandlers()",
    "boolean SheepRegrowWoolEvent.isCancelled()",
    "void SheepRegrowWoolEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Sheep sheep = mock(Sheep.class);

    // Act
    SheepRegrowWoolEvent actualSheepRegrowWoolEvent = new SheepRegrowWoolEvent(sheep);
    actualSheepRegrowWoolEvent.setCancelled(true);
    HandlerList actualHandlerList = actualSheepRegrowWoolEvent.getHandlerList();
    HandlerList actualHandlers = actualSheepRegrowWoolEvent.getHandlers();
    boolean actualIsCancelledResult = actualSheepRegrowWoolEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualSheepRegrowWoolEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(sheep, actualSheepRegrowWoolEvent.getEntity());
  }

  /**
   * Test {@link SheepRegrowWoolEvent#getEntity()}.
   *
   * <p>Method under test: {@link SheepRegrowWoolEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Sheep SheepRegrowWoolEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    SheepRegrowWoolEvent sheepRegrowWoolEvent = new SheepRegrowWoolEvent(mock(Sheep.class));

    // Act
    Sheep actualEntity = sheepRegrowWoolEvent.getEntity();

    // Assert
    assertSame(sheepRegrowWoolEvent.entity, actualEntity);
  }
}
