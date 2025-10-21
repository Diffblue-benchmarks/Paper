package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.bukkit.entity.Piglin;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PiglinBarterEventDiffblueTest {
  /**
   * Test {@link PiglinBarterEvent#getEntity()}.
   *
   * <p>Method under test: {@link PiglinBarterEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Piglin PiglinBarterEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    Piglin piglin = mock(Piglin.class);
    ItemStack input = mock(ItemStack.class);

    PiglinBarterEvent piglinBarterEvent = new PiglinBarterEvent(piglin, input, new ArrayList<>());

    // Act
    Piglin actualEntity = piglinBarterEvent.getEntity();

    // Assert
    assertSame(piglinBarterEvent.entity, actualEntity);
  }
}
