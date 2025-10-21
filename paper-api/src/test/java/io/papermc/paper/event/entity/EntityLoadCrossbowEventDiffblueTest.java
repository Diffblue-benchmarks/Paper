package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EquipmentSlot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityLoadCrossbowEventDiffblueTest {
  /**
   * Test {@link EntityLoadCrossbowEvent#shouldConsumeItem()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadCrossbowEvent#shouldConsumeItem()}
   */
  @Test
  @DisplayName("Test shouldConsumeItem(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadCrossbowEvent.shouldConsumeItem()"})
  void testShouldConsumeItem_thenReturnFalse() {
    // Arrange
    EntityLoadCrossbowEvent entityLoadCrossbowEvent =
        new EntityLoadCrossbowEvent(mock(LivingEntity.class), null, EquipmentSlot.HAND);
    entityLoadCrossbowEvent.setConsumeItem(false);

    // Act and Assert
    assertFalse(entityLoadCrossbowEvent.shouldConsumeItem());
  }

  /**
   * Test {@link EntityLoadCrossbowEvent#shouldConsumeItem()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLoadCrossbowEvent#shouldConsumeItem()}
   */
  @Test
  @DisplayName("Test shouldConsumeItem(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityLoadCrossbowEvent.shouldConsumeItem()"})
  void testShouldConsumeItem_thenReturnTrue() {
    // Arrange
    EntityLoadCrossbowEvent entityLoadCrossbowEvent =
        new EntityLoadCrossbowEvent(mock(LivingEntity.class), null, EquipmentSlot.HAND);

    // Act and Assert
    assertTrue(entityLoadCrossbowEvent.shouldConsumeItem());
  }
}
