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
import org.bukkit.PortalType;
import org.bukkit.block.BlockState;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityCreatePortalEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCreatePortalEvent#EntityCreatePortalEvent(LivingEntity, List, PortalType)}
   *   <li>{@link EntityCreatePortalEvent#setCancelled(boolean)}
   *   <li>{@link EntityCreatePortalEvent#getHandlerList()}
   *   <li>{@link EntityCreatePortalEvent#getBlocks()}
   *   <li>{@link EntityCreatePortalEvent#getHandlers()}
   *   <li>{@link EntityCreatePortalEvent#getPortalType()}
   *   <li>{@link EntityCreatePortalEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCreatePortalEvent.<init>(LivingEntity, List, PortalType)",
    "List EntityCreatePortalEvent.getBlocks()",
    "HandlerList EntityCreatePortalEvent.getHandlerList()",
    "HandlerList EntityCreatePortalEvent.getHandlers()",
    "PortalType EntityCreatePortalEvent.getPortalType()",
    "boolean EntityCreatePortalEvent.isCancelled()",
    "void EntityCreatePortalEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity livingEntity = mock(LivingEntity.class);
    ArrayList<BlockState> blocks = new ArrayList<>();

    // Act
    EntityCreatePortalEvent actualEntityCreatePortalEvent =
        new EntityCreatePortalEvent(livingEntity, blocks, PortalType.NETHER);
    actualEntityCreatePortalEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityCreatePortalEvent.getHandlerList();
    List<BlockState> actualBlocks = actualEntityCreatePortalEvent.getBlocks();
    HandlerList actualHandlers = actualEntityCreatePortalEvent.getHandlers();
    PortalType actualPortalType = actualEntityCreatePortalEvent.getPortalType();
    boolean actualIsCancelledResult = actualEntityCreatePortalEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(PortalType.NETHER, actualPortalType);
    assertFalse(actualEntityCreatePortalEvent.isAsynchronous());
    assertTrue(actualBlocks.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(blocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(livingEntity, actualEntityCreatePortalEvent.getEntity());
  }

  /**
   * Test {@link EntityCreatePortalEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityCreatePortalEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityCreatePortalEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    LivingEntity livingEntity = mock(LivingEntity.class);
    EntityCreatePortalEvent entityCreatePortalEvent =
        new EntityCreatePortalEvent(livingEntity, new ArrayList<>(), PortalType.NETHER);

    // Act
    LivingEntity actualEntity = entityCreatePortalEvent.getEntity();

    // Assert
    assertSame(entityCreatePortalEvent.entity, actualEntity);
  }
}
