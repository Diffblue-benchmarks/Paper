package ca.spottedleaf.dataconverter.minecraft.walkers.tile_entity;

import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataWalkerTileEntitiesDiffblueTest {
  /**
   * Test {@link DataWalkerTileEntities#DataWalkerTileEntities(String[])}.
   *
   * <p>Method under test: {@link DataWalkerTileEntities#DataWalkerTileEntities(String[])}
   */
  @Test
  @DisplayName("Test new DataWalkerTileEntities(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataWalkerTileEntities.<init>(String[])"})
  void testNewDataWalkerTileEntities() {
    // Arrange and Act
    DataWalkerTileEntities actualDataWalkerTileEntities = new DataWalkerTileEntities("Paths");

    // Assert
    assertNull(actualDataWalkerTileEntities.walk(new NBTMapType(), 1L, 1L));
  }
}
