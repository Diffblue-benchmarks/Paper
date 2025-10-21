package org.bukkit.material.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MushroomBlockTextureDiffblueTest {
  /**
   * Test {@link MushroomBlockTexture#getData()}.
   *
   * <p>Method under test: {@link MushroomBlockTexture#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte MushroomBlockTexture.getData()"})
  void testGetData() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, MushroomBlockTexture.ALL_PORES.getData());
  }

  /**
   * Test {@link MushroomBlockTexture#getCapFace()}.
   *
   * <p>Method under test: {@link MushroomBlockTexture#getCapFace()}
   */
  @Test
  @DisplayName("Test getCapFace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockFace MushroomBlockTexture.getCapFace()"})
  void testGetCapFace() {
    // Arrange, Act and Assert
    assertNull(MushroomBlockTexture.valueOf("ALL_PORES").getCapFace());
  }

  /**
   * Test {@link MushroomBlockTexture#getByData(byte)}.
   *
   * <p>Method under test: {@link MushroomBlockTexture#getByData(byte)}
   */
  @Test
  @DisplayName("Test getByData(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MushroomBlockTexture MushroomBlockTexture.getByData(byte)"})
  void testGetByData() {
    // Arrange, Act and Assert
    assertNull(MushroomBlockTexture.getByData((byte) 'A'));
  }

  /**
   * Test {@link MushroomBlockTexture#getCapByFace(BlockFace)}.
   *
   * <p>Method under test: {@link MushroomBlockTexture#getCapByFace(BlockFace)}
   */
  @Test
  @DisplayName("Test getCapByFace(BlockFace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MushroomBlockTexture MushroomBlockTexture.getCapByFace(BlockFace)"})
  void testGetCapByFace() {
    // Arrange, Act and Assert
    assertEquals(
        MushroomBlockTexture.CAP_NORTH, MushroomBlockTexture.getCapByFace(BlockFace.NORTH));
  }
}
