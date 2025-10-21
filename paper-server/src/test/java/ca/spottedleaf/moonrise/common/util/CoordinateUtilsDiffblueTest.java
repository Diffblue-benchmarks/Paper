package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoordinateUtilsDiffblueTest {
  /**
   * Test {@link CoordinateUtils#getChunkKey(BlockPos)} with {@code BlockPos}.
   *
   * <ul>
   *   <li>When {@link BlockPos} with packedPos is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkKey(BlockPos)}
   */
  @Test
  @DisplayName(
      "Test getChunkKey(BlockPos) with 'BlockPos'; when BlockPos with packedPos is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkKey(BlockPos)"})
  void testGetChunkKeyWithBlockPos_whenBlockPosWithPackedPosIsOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CoordinateUtils.getChunkKey(BlockPos.of(1L)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkKey(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When {@link MoonriseConstants#MAX_VIEW_DISTANCE}.
   *   <li>Then return {@code 12884901920}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkKey(int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkKey(int, int) with 'int', 'int'; when MAX_VIEW_DISTANCE; then return '12884901920'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkKey(int, int)"})
  void testGetChunkKeyWithIntInt_whenMax_view_distance_thenReturn12884901920() {
    // Arrange, Act and Assert
    assertEquals(12884901920L, CoordinateUtils.getChunkKey(MoonriseConstants.MAX_VIEW_DISTANCE, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkKey(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 17179869183}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkKey(int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkKey(int, int) with 'int', 'int'; when minus one; then return '17179869183'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkKey(int, int)"})
  void testGetChunkKeyWithIntInt_whenMinusOne_thenReturn17179869183() {
    // Arrange, Act and Assert
    assertEquals(17179869183L, CoordinateUtils.getChunkKey(-1, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkKey(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 12884901891}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkKey(int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkKey(int, int) with 'int', 'int'; when three; then return '12884901891'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkKey(int, int)"})
  void testGetChunkKeyWithIntInt_whenThree_thenReturn12884901891() {
    // Arrange, Act and Assert
    assertEquals(12884901891L, CoordinateUtils.getChunkKey(3, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkKey(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 12884901890}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkKey(int, int)}
   */
  @Test
  @DisplayName("Test getChunkKey(int, int) with 'int', 'int'; when two; then return '12884901890'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkKey(int, int)"})
  void testGetChunkKeyWithIntInt_whenTwo_thenReturn12884901890() {
    // Arrange, Act and Assert
    assertEquals(12884901890L, CoordinateUtils.getChunkKey(2, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkKey(SectionPos)} with {@code SectionPos}.
   *
   * <ul>
   *   <li>When {@link SectionPos} with packed is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkKey(SectionPos)}
   */
  @Test
  @DisplayName(
      "Test getChunkKey(SectionPos) with 'SectionPos'; when SectionPos with packed is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkKey(SectionPos)"})
  void testGetChunkKeyWithSectionPos_whenSectionPosWithPackedIsOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CoordinateUtils.getChunkKey(SectionPos.of(1L)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkX(long)} with {@code chunkKey}.
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkX(long)}
   */
  @Test
  @DisplayName("Test getChunkX(long) with 'chunkKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkX(long)"})
  void testGetChunkXWithChunkKey() {
    // Arrange, Act and Assert
    assertEquals(1, CoordinateUtils.getChunkX(1L));
  }

  /**
   * Test {@link CoordinateUtils#getChunkX(Vec3)} with {@code pos}.
   *
   * <ul>
   *   <li>When directionFromRotation ten and ten.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkX(Vec3)}
   */
  @Test
  @DisplayName(
      "Test getChunkX(Vec3) with 'pos'; when directionFromRotation ten and ten; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkX(Vec3)"})
  void testGetChunkXWithPos_whenDirectionFromRotationTenAndTen_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getChunkX(Vec3.directionFromRotation(10.0f, 10.0f)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkX(Vec3)} with {@code pos}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkX(Vec3)}
   */
  @Test
  @DisplayName("Test getChunkX(Vec3) with 'pos'; when fromRGB24 one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkX(Vec3)"})
  void testGetChunkXWithPos_whenFromRGB24One_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkX(Vec3.fromRGB24(1)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkZ(long)} with {@code chunkKey}.
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkZ(long)}
   */
  @Test
  @DisplayName("Test getChunkZ(long) with 'chunkKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkZ(long)"})
  void testGetChunkZWithChunkKey() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkZ(1L));
  }

  /**
   * Test {@link CoordinateUtils#getChunkZ(Vec3)} with {@code pos}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkZ(Vec3)}
   */
  @Test
  @DisplayName("Test getChunkZ(Vec3) with 'pos'; when fromRGB24 one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkZ(Vec3)"})
  void testGetChunkZWithPos_whenFromRGB24One_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkZ(Vec3.fromRGB24(1)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkZ(Vec3)} with {@code pos}.
   *
   * <ul>
   *   <li>When {@link Vec3#Vec3(double, double, double)} with x is two and y is three and z is
   *       {@code -0.5}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkZ(Vec3)}
   */
  @Test
  @DisplayName(
      "Test getChunkZ(Vec3) with 'pos'; when Vec3(double, double, double) with x is two and y is three and z is '-0.5'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkZ(Vec3)"})
  void testGetChunkZWithPos_whenVec3WithXIsTwoAndYIsThreeAndZIs05_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getChunkZ(new Vec3(2.0d, 3.0d, -0.5d)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkY(Vec3)}.
   *
   * <ul>
   *   <li>When directionFromRotation ten and ten.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkY(Vec3)}
   */
  @Test
  @DisplayName(
      "Test getChunkY(Vec3); when directionFromRotation ten and ten; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkY(Vec3)"})
  void testGetChunkY_whenDirectionFromRotationTenAndTen_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getChunkY(Vec3.directionFromRotation(10.0f, 10.0f)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkY(Vec3)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkY(Vec3)}
   */
  @Test
  @DisplayName("Test getChunkY(Vec3); when fromRGB24 one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkY(Vec3)"})
  void testGetChunkY_whenFromRGB24One_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkY(Vec3.fromRGB24(1)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkCoordinate(double)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkCoordinate(double)}
   */
  @Test
  @DisplayName("Test getChunkCoordinate(double); when '-0.5'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkCoordinate(double)"})
  void testGetChunkCoordinate_when05_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getChunkCoordinate(-0.5d));
  }

  /**
   * Test {@link CoordinateUtils#getChunkCoordinate(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkCoordinate(double)}
   */
  @Test
  @DisplayName("Test getChunkCoordinate(double); when ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkCoordinate(double)"})
  void testGetChunkCoordinate_whenTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkCoordinate(10.0d));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionKey(BlockPos)} with {@code BlockPos}.
   *
   * <ul>
   *   <li>When {@link BlockPos} with packedPos is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionKey(BlockPos)}
   */
  @Test
  @DisplayName(
      "Test getChunkSectionKey(BlockPos) with 'BlockPos'; when BlockPos with packedPos is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkSectionKey(BlockPos)"})
  void testGetChunkSectionKeyWithBlockPos_whenBlockPosWithPackedPosIsOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CoordinateUtils.getChunkSectionKey(BlockPos.of(1L)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionKey(int, int, int)} with {@code int}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code 1048575}.
   *   <li>Then return {@code 4611681620384022531}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkSectionKey(int, int, int) with 'int', 'int', 'int'; when '1048575'; then return '4611681620384022531'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkSectionKey(int, int, int)"})
  void testGetChunkSectionKeyWithIntIntInt_when1048575_thenReturn4611681620384022531() {
    // Arrange, Act and Assert
    assertEquals(4611681620384022531L, CoordinateUtils.getChunkSectionKey(1048575, 3, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionKey(int, int, int)} with {@code int}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code 4194303}.
   *   <li>Then return {@code -4398043365373}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkSectionKey(int, int, int) with 'int', 'int', 'int'; when '4194303'; then return '-4398043365373'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkSectionKey(int, int, int)"})
  void testGetChunkSectionKeyWithIntIntInt_when4194303_thenReturn4398043365373() {
    // Arrange, Act and Assert
    assertEquals(-4398043365373L, CoordinateUtils.getChunkSectionKey(4194303, 3, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionKey(int, int, int)} with {@code int}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code 184717956612099}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkSectionKey(int, int, int) with 'int', 'int', 'int'; when forty-two; then return '184717956612099'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkSectionKey(int, int, int)"})
  void testGetChunkSectionKeyWithIntIntInt_whenFortyTwo_thenReturn184717956612099() {
    // Arrange, Act and Assert
    assertEquals(184717956612099L, CoordinateUtils.getChunkSectionKey(42, 3, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionKey(int, int, int)} with {@code int}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 8796096167939}.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionKey(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getChunkSectionKey(int, int, int) with 'int', 'int', 'int'; when two; then return '8796096167939'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkSectionKey(int, int, int)"})
  void testGetChunkSectionKeyWithIntIntInt_whenTwo_thenReturn8796096167939() {
    // Arrange, Act and Assert
    assertEquals(8796096167939L, CoordinateUtils.getChunkSectionKey(2, 3, 3));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionKey(SectionPos)} with {@code SectionPos}.
   *
   * <ul>
   *   <li>When {@link SectionPos} with packed is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionKey(SectionPos)}
   */
  @Test
  @DisplayName(
      "Test getChunkSectionKey(SectionPos) with 'SectionPos'; when SectionPos with packed is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CoordinateUtils.getChunkSectionKey(SectionPos)"})
  void testGetChunkSectionKeyWithSectionPos_whenSectionPosWithPackedIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, CoordinateUtils.getChunkSectionKey(SectionPos.of(1L)));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionX(long)}.
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionX(long)}
   */
  @Test
  @DisplayName("Test getChunkSectionX(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkSectionX(long)"})
  void testGetChunkSectionX() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkSectionX(1L));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionY(long)}.
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionY(long)}
   */
  @Test
  @DisplayName("Test getChunkSectionY(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkSectionY(long)"})
  void testGetChunkSectionY() {
    // Arrange, Act and Assert
    assertEquals(1, CoordinateUtils.getChunkSectionY(1L));
  }

  /**
   * Test {@link CoordinateUtils#getChunkSectionZ(long)}.
   *
   * <p>Method under test: {@link CoordinateUtils#getChunkSectionZ(long)}
   */
  @Test
  @DisplayName("Test getChunkSectionZ(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getChunkSectionZ(long)"})
  void testGetChunkSectionZ() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getChunkSectionZ(1L));
  }

  /**
   * Test {@link CoordinateUtils#getBlockX(Vec3)}.
   *
   * <ul>
   *   <li>When directionFromRotation ten and ten.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getBlockX(Vec3)}
   */
  @Test
  @DisplayName(
      "Test getBlockX(Vec3); when directionFromRotation ten and ten; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getBlockX(Vec3)"})
  void testGetBlockX_whenDirectionFromRotationTenAndTen_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getBlockX(Vec3.directionFromRotation(10.0f, 10.0f)));
  }

  /**
   * Test {@link CoordinateUtils#getBlockX(Vec3)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getBlockX(Vec3)}
   */
  @Test
  @DisplayName("Test getBlockX(Vec3); when fromRGB24 one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getBlockX(Vec3)"})
  void testGetBlockX_whenFromRGB24One_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getBlockX(Vec3.fromRGB24(1)));
  }

  /**
   * Test {@link CoordinateUtils#getBlockY(Vec3)}.
   *
   * <ul>
   *   <li>When directionFromRotation ten and ten.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getBlockY(Vec3)}
   */
  @Test
  @DisplayName(
      "Test getBlockY(Vec3); when directionFromRotation ten and ten; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getBlockY(Vec3)"})
  void testGetBlockY_whenDirectionFromRotationTenAndTen_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getBlockY(Vec3.directionFromRotation(10.0f, 10.0f)));
  }

  /**
   * Test {@link CoordinateUtils#getBlockY(Vec3)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getBlockY(Vec3)}
   */
  @Test
  @DisplayName("Test getBlockY(Vec3); when fromRGB24 one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getBlockY(Vec3)"})
  void testGetBlockY_whenFromRGB24One_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getBlockY(Vec3.fromRGB24(1)));
  }

  /**
   * Test {@link CoordinateUtils#getBlockZ(Vec3)}.
   *
   * <ul>
   *   <li>When fromRGB24 one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getBlockZ(Vec3)}
   */
  @Test
  @DisplayName("Test getBlockZ(Vec3); when fromRGB24 one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getBlockZ(Vec3)"})
  void testGetBlockZ_whenFromRGB24One_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CoordinateUtils.getBlockZ(Vec3.fromRGB24(1)));
  }

  /**
   * Test {@link CoordinateUtils#getBlockZ(Vec3)}.
   *
   * <ul>
   *   <li>When {@link Vec3#Vec3(double, double, double)} with x is two and y is three and z is
   *       {@code -0.5}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link CoordinateUtils#getBlockZ(Vec3)}
   */
  @Test
  @DisplayName(
      "Test getBlockZ(Vec3); when Vec3(double, double, double) with x is two and y is three and z is '-0.5'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CoordinateUtils.getBlockZ(Vec3)"})
  void testGetBlockZ_whenVec3WithXIsTwoAndYIsThreeAndZIs05_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, CoordinateUtils.getBlockZ(new Vec3(2.0d, 3.0d, -0.5d)));
  }
}
