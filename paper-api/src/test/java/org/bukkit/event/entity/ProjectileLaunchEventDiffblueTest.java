package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProjectileLaunchEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectileLaunchEvent#ProjectileLaunchEvent(Entity)}
   *   <li>{@link ProjectileLaunchEvent#setCancelled(boolean)}
   *   <li>{@link ProjectileLaunchEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectileLaunchEvent.<init>(Entity)",
    "boolean ProjectileLaunchEvent.isCancelled()",
    "void ProjectileLaunchEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ProjectileLaunchEvent actualProjectileLaunchEvent =
        new ProjectileLaunchEvent(mock(Entity.class));
    actualProjectileLaunchEvent.setCancelled(true);
    boolean actualIsCancelledResult = actualProjectileLaunchEvent.isCancelled();

    // Assert
    assertFalse(actualProjectileLaunchEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
  }

  /**
   * Test {@link ProjectileLaunchEvent#getEntity()}.
   *
   * <p>Method under test: {@link ProjectileLaunchEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Projectile ProjectileLaunchEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    ProjectileLaunchEvent projectileLaunchEvent = new ProjectileLaunchEvent(mock(Projectile.class));

    // Act
    Projectile actualEntity = projectileLaunchEvent.getEntity();

    // Assert
    assertSame(projectileLaunchEvent.entity, actualEntity);
  }
}
