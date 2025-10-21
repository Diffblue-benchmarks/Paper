package io.papermc.paper.threadedregions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.threadedregions.EntityScheduler.EntitySchedulerTickList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitySchedulerDiffblueTest {
  /**
   * Test EntitySchedulerTickList new {@link EntitySchedulerTickList} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EntitySchedulerTickList}
   */
  @Test
  @DisplayName("Test EntitySchedulerTickList new EntitySchedulerTickList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitySchedulerTickList.<init>()"})
  void testEntitySchedulerTickListNewEntitySchedulerTickList() {
    // Arrange, Act and Assert
    assertEquals(0, new EntitySchedulerTickList().getAllSchedulers().length);
  }
}
