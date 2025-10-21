package io.papermc.paper.redstone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.BlockPos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RedstoneWireTurboDiffblueTest {
  /**
   * Test {@link RedstoneWireTurbo#computeAllNeighbors(BlockPos)}.
   *
   * <ul>
   *   <li>Then return array length is {@link Float#PRECISION}.
   * </ul>
   *
   * <p>Method under test: {@link RedstoneWireTurbo#computeAllNeighbors(BlockPos)}
   */
  @Test
  @DisplayName("Test computeAllNeighbors(BlockPos); then return array length is PRECISION")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockPos[] RedstoneWireTurbo.computeAllNeighbors(BlockPos)"})
  void testComputeAllNeighbors_thenReturnArrayLengthIsPrecision() {
    // Arrange and Act
    BlockPos[] actualComputeAllNeighborsResult =
        RedstoneWireTurbo.computeAllNeighbors(BlockPos.of(1L));

    // Assert
    assertEquals(Float.PRECISION, actualComputeAllNeighborsResult.length);
    assertEquals(BlockPos.ZERO, actualComputeAllNeighborsResult[2]);
  }
}
