package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AreaEffectCloudApplyEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AreaEffectCloudApplyEvent#AreaEffectCloudApplyEvent(AreaEffectCloud, List)}
   *   <li>{@link AreaEffectCloudApplyEvent#setCancelled(boolean)}
   *   <li>{@link AreaEffectCloudApplyEvent#getHandlerList()}
   *   <li>{@link AreaEffectCloudApplyEvent#getAffectedEntities()}
   *   <li>{@link AreaEffectCloudApplyEvent#getHandlers()}
   *   <li>{@link AreaEffectCloudApplyEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AreaEffectCloudApplyEvent.<init>(AreaEffectCloud, List)",
    "List AreaEffectCloudApplyEvent.getAffectedEntities()",
    "HandlerList AreaEffectCloudApplyEvent.getHandlerList()",
    "HandlerList AreaEffectCloudApplyEvent.getHandlers()",
    "boolean AreaEffectCloudApplyEvent.isCancelled()",
    "void AreaEffectCloudApplyEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    AreaEffectCloud entity = mock(AreaEffectCloud.class);
    ArrayList<LivingEntity> affectedEntities = new ArrayList<>();

    // Act
    AreaEffectCloudApplyEvent actualAreaEffectCloudApplyEvent =
        new AreaEffectCloudApplyEvent(entity, affectedEntities);
    actualAreaEffectCloudApplyEvent.setCancelled(true);
    HandlerList actualHandlerList = actualAreaEffectCloudApplyEvent.getHandlerList();
    List<LivingEntity> actualAffectedEntities =
        actualAreaEffectCloudApplyEvent.getAffectedEntities();
    HandlerList actualHandlers = actualAreaEffectCloudApplyEvent.getHandlers();
    boolean actualIsCancelledResult = actualAreaEffectCloudApplyEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualAreaEffectCloudApplyEvent.isAsynchronous());
    assertTrue(actualAffectedEntities.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(affectedEntities, actualAffectedEntities);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualAreaEffectCloudApplyEvent.getEntity());
  }

  /**
   * Test {@link AreaEffectCloudApplyEvent#getEntity()}.
   *
   * <p>Method under test: {@link AreaEffectCloudApplyEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AreaEffectCloud AreaEffectCloudApplyEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    AreaEffectCloud entity = mock(AreaEffectCloud.class);
    AreaEffectCloudApplyEvent areaEffectCloudApplyEvent =
        new AreaEffectCloudApplyEvent(entity, new ArrayList<>());

    // Act
    AreaEffectCloud actualEntity = areaEffectCloudApplyEvent.getEntity();

    // Assert
    assertSame(areaEffectCloudApplyEvent.entity, actualEntity);
  }
}
