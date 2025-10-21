package ca.spottedleaf.moonrise.patches.collisions.shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.phys.AABB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CachedToAABBsDiffblueTest {
  /**
   * Test {@link CachedToAABBs#removeOffset()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Hopper#SUCK_AABB}.
   *   <li>Then return aabbs size is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link CachedToAABBs#removeOffset()}
   */
  @Test
  @DisplayName(
      "Test removeOffset(); given ArrayList() add SUCK_AABB; then return aabbs size is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CachedToAABBs CachedToAABBs.removeOffset()"})
  void testRemoveOffset_givenArrayListAddSuck_aabb_thenReturnAabbsSizeIsEighteen() {
    // Arrange
    ArrayList<AABB> aabbs = new ArrayList<>();
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    aabbs.add(Hopper.SUCK_AABB);
    CachedToAABBs cachedToAABBs = new CachedToAABBs(aabbs, true, 10.0d, 10.0d, 10.0d);

    // Act and Assert
    List<AABB> aabbsResult = cachedToAABBs.removeOffset().aabbs();
    assertEquals(18, aabbsResult.size());
    AABB getResult = aabbsResult.get(0);
    assertEquals(getResult, aabbsResult.get(1));
    assertEquals(getResult, aabbsResult.get(15));
    assertEquals(getResult, aabbsResult.get(17));
    assertEquals(getResult, aabbsResult.get(2));
    assertEquals(getResult, aabbsResult.get(Short.SIZE));
  }

  /**
   * Test {@link CachedToAABBs#removeOffset()}.
   *
   * <ul>
   *   <li>Then return offX is zero.
   * </ul>
   *
   * <p>Method under test: {@link CachedToAABBs#removeOffset()}
   */
  @Test
  @DisplayName("Test removeOffset(); then return offX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CachedToAABBs CachedToAABBs.removeOffset()"})
  void testRemoveOffset_thenReturnOffXIsZero() {
    // Arrange
    CachedToAABBs cache = new CachedToAABBs(new ArrayList<>(), true, 10.0d, 10.0d, 10.0d);
    CachedToAABBs offsetResult = CachedToAABBs.offset(cache, 10.0d, 10.0d, 10.0d);

    // Act
    CachedToAABBs actualRemoveOffsetResult = offsetResult.removeOffset();

    // Assert
    assertEquals(0.0d, actualRemoveOffsetResult.offX());
    assertEquals(0.0d, actualRemoveOffsetResult.offY());
    assertEquals(0.0d, actualRemoveOffsetResult.offZ());
    assertFalse(actualRemoveOffsetResult.isOffset());
    assertTrue(actualRemoveOffsetResult.aabbs().isEmpty());
  }

  /**
   * Test {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}.
   *
   * <p>Method under test: {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}
   */
  @Test
  @DisplayName("Test offset(CachedToAABBs, double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CachedToAABBs CachedToAABBs.offset(CachedToAABBs, double, double, double)"})
  void testOffset() {
    // Arrange
    CachedToAABBs cache = new CachedToAABBs(new ArrayList<>(), true, 10.0d, 10.0d, 10.0d);
    CachedToAABBs cache2 = CachedToAABBs.offset(cache, 10.0d, 10.0d, 10.0d);

    // Act
    CachedToAABBs actualOffsetResult = CachedToAABBs.offset(cache2, 0.0d, 0.0d, 0.0d);

    // Assert
    assertEquals(20.0d, actualOffsetResult.offX());
    assertEquals(20.0d, actualOffsetResult.offY());
    assertEquals(20.0d, actualOffsetResult.offZ());
    assertTrue(actualOffsetResult.isOffset());
    assertTrue(actualOffsetResult.aabbs().isEmpty());
  }

  /**
   * Test {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}.
   *
   * <ul>
   *   <li>Then return offX is twenty.
   * </ul>
   *
   * <p>Method under test: {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}
   */
  @Test
  @DisplayName("Test offset(CachedToAABBs, double, double, double); then return offX is twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CachedToAABBs CachedToAABBs.offset(CachedToAABBs, double, double, double)"})
  void testOffset_thenReturnOffXIsTwenty() {
    // Arrange
    CachedToAABBs cache = new CachedToAABBs(new ArrayList<>(), true, 10.0d, 10.0d, 10.0d);

    // Act
    CachedToAABBs actualOffsetResult = CachedToAABBs.offset(cache, 10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(20.0d, actualOffsetResult.offX());
    assertEquals(20.0d, actualOffsetResult.offY());
    assertEquals(20.0d, actualOffsetResult.offZ());
    assertTrue(actualOffsetResult.isOffset());
    assertTrue(actualOffsetResult.aabbs().isEmpty());
  }

  /**
   * Test {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return offX is ten.
   * </ul>
   *
   * <p>Method under test: {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test offset(CachedToAABBs, double, double, double); when zero; then return offX is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CachedToAABBs CachedToAABBs.offset(CachedToAABBs, double, double, double)"})
  void testOffset_whenZero_thenReturnOffXIsTen() {
    // Arrange
    CachedToAABBs cache = new CachedToAABBs(new ArrayList<>(), true, 10.0d, 10.0d, 10.0d);

    // Act
    CachedToAABBs actualOffsetResult = CachedToAABBs.offset(cache, 0.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualOffsetResult.offX());
    assertEquals(20.0d, actualOffsetResult.offY());
    assertEquals(20.0d, actualOffsetResult.offZ());
    assertTrue(actualOffsetResult.isOffset());
    assertTrue(actualOffsetResult.aabbs().isEmpty());
  }

  /**
   * Test {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return offY is ten.
   * </ul>
   *
   * <p>Method under test: {@link CachedToAABBs#offset(CachedToAABBs, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test offset(CachedToAABBs, double, double, double); when zero; then return offY is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CachedToAABBs CachedToAABBs.offset(CachedToAABBs, double, double, double)"})
  void testOffset_whenZero_thenReturnOffYIsTen() {
    // Arrange
    CachedToAABBs cache = new CachedToAABBs(new ArrayList<>(), true, 10.0d, 10.0d, 10.0d);

    // Act
    CachedToAABBs actualOffsetResult = CachedToAABBs.offset(cache, 0.0d, 0.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualOffsetResult.offX());
    assertEquals(10.0d, actualOffsetResult.offY());
    assertEquals(20.0d, actualOffsetResult.offZ());
    assertTrue(actualOffsetResult.isOffset());
    assertTrue(actualOffsetResult.aabbs().isEmpty());
  }
}
