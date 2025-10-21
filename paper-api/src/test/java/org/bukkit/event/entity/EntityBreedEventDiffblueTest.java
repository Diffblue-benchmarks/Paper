package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityBreedEventDiffblueTest {
  /**
   * Test {@link EntityBreedEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityBreedEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityBreedEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityBreedEvent entityBreedEvent =
        new EntityBreedEvent(
            mock(LivingEntity.class),
            mock(LivingEntity.class),
            mock(LivingEntity.class),
            mock(LivingEntity.class),
            null,
            1);

    // Act
    LivingEntity actualEntity = entityBreedEvent.getEntity();

    // Assert
    assertSame(entityBreedEvent.entity, actualEntity);
  }
}
