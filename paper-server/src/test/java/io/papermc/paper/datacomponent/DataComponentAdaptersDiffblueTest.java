package io.papermc.paper.datacomponent;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.resources.ResourceKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataComponentAdaptersDiffblueTest {
  /**
   * Test {@link DataComponentAdapters#registerUnimplemented(ResourceKey)}.
   *
   * <ul>
   *   <li>When {@link ResourceKey}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DataComponentAdapters#registerUnimplemented(ResourceKey)}
   */
  @Test
  @DisplayName("Test registerUnimplemented(ResourceKey); when ResourceKey; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataComponentAdapters.registerUnimplemented(ResourceKey)"})
  void testRegisterUnimplemented_whenResourceKey_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> DataComponentAdapters.registerUnimplemented(mock(ResourceKey.class)));
  }
}
