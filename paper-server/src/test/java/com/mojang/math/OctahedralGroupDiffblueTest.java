package com.mojang.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.FrontAndTop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OctahedralGroupDiffblueTest {
  /**
   * Test {@link OctahedralGroup#compose(OctahedralGroup)}.
   *
   * <p>Method under test: {@link OctahedralGroup#compose(OctahedralGroup)}
   */
  @Test
  @DisplayName("Test compose(OctahedralGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OctahedralGroup OctahedralGroup.compose(OctahedralGroup)"})
  void testCompose() {
    // Arrange, Act and Assert
    assertEquals(
        OctahedralGroup.IDENTITY, OctahedralGroup.IDENTITY.compose(OctahedralGroup.IDENTITY));
  }

  /**
   * Test {@link OctahedralGroup#inverse()}.
   *
   * <p>Method under test: {@link OctahedralGroup#inverse()}
   */
  @Test
  @DisplayName("Test inverse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OctahedralGroup OctahedralGroup.inverse()"})
  void testInverse() {
    // Arrange, Act and Assert
    assertEquals(OctahedralGroup.IDENTITY, OctahedralGroup.IDENTITY.inverse());
  }

  /**
   * Test {@link OctahedralGroup#rotate(Direction)} with {@code direction}.
   *
   * <p>Method under test: {@link OctahedralGroup#rotate(Direction)}
   */
  @Test
  @DisplayName("Test rotate(Direction) with 'direction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Direction OctahedralGroup.rotate(Direction)"})
  void testRotateWithDirection() {
    // Arrange, Act and Assert
    assertEquals(Direction.DOWN, OctahedralGroup.IDENTITY.rotate(Direction.DOWN));
  }

  /**
   * Test {@link OctahedralGroup#rotate(FrontAndTop)} with {@code frontAndTop}.
   *
   * <p>Method under test: {@link OctahedralGroup#rotate(FrontAndTop)}
   */
  @Test
  @DisplayName("Test rotate(FrontAndTop) with 'frontAndTop'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FrontAndTop OctahedralGroup.rotate(FrontAndTop)"})
  void testRotateWithFrontAndTop() {
    // Arrange, Act and Assert
    assertEquals(FrontAndTop.DOWN_EAST, OctahedralGroup.IDENTITY.rotate(FrontAndTop.DOWN_EAST));
  }

  /**
   * Test {@link OctahedralGroup#inverts(Axis)}.
   *
   * <ul>
   *   <li>Given {@code IDENTITY}.
   *   <li>When {@code X}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OctahedralGroup#inverts(Direction.Axis)}
   */
  @Test
  @DisplayName("Test inverts(Axis); given 'IDENTITY'; when 'X'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OctahedralGroup.inverts(Direction.Axis)"})
  void testInverts_givenIdentity_whenX_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OctahedralGroup.IDENTITY.inverts(Axis.X));
  }

  /**
   * Test {@link OctahedralGroup#inverts(Axis)}.
   *
   * <ul>
   *   <li>Given {@code IDENTITY}.
   *   <li>When {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OctahedralGroup#inverts(Direction.Axis)}
   */
  @Test
  @DisplayName("Test inverts(Axis); given 'IDENTITY'; when 'Y'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OctahedralGroup.inverts(Direction.Axis)"})
  void testInverts_givenIdentity_whenY_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OctahedralGroup.IDENTITY.inverts(Axis.Y));
  }

  /**
   * Test {@link OctahedralGroup#inverts(Axis)}.
   *
   * <ul>
   *   <li>Given {@code IDENTITY}.
   *   <li>When {@code Z}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OctahedralGroup#inverts(Direction.Axis)}
   */
  @Test
  @DisplayName("Test inverts(Axis); given 'IDENTITY'; when 'Z'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OctahedralGroup.inverts(Direction.Axis)"})
  void testInverts_givenIdentity_whenZ_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(OctahedralGroup.IDENTITY.inverts(Axis.Z));
  }

  /**
   * Test {@link OctahedralGroup#inverts(Axis)}.
   *
   * <ul>
   *   <li>Given {@code ROT_180_FACE_XY}.
   *   <li>When {@code X}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OctahedralGroup#inverts(Direction.Axis)}
   */
  @Test
  @DisplayName("Test inverts(Axis); given 'ROT_180_FACE_XY'; when 'X'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OctahedralGroup.inverts(Direction.Axis)"})
  void testInverts_givenRot180FaceXy_whenX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(OctahedralGroup.ROT_180_FACE_XY.inverts(Axis.X));
  }

  /**
   * Test {@link OctahedralGroup#permute(Axis)}.
   *
   * <p>Method under test: {@link OctahedralGroup#permute(Direction.Axis)}
   */
  @Test
  @DisplayName("Test permute(Axis)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Direction.Axis OctahedralGroup.permute(Direction.Axis)"})
  void testPermute() {
    // Arrange, Act and Assert
    assertEquals(Axis.X, OctahedralGroup.IDENTITY.permute(Axis.X));
  }

  /**
   * Test {@link OctahedralGroup#fromXYAngles(Quadrant, Quadrant)}.
   *
   * <p>Method under test: {@link OctahedralGroup#fromXYAngles(Quadrant, Quadrant)}
   */
  @Test
  @DisplayName("Test fromXYAngles(Quadrant, Quadrant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OctahedralGroup OctahedralGroup.fromXYAngles(Quadrant, Quadrant)"})
  void testFromXYAngles() {
    // Arrange, Act and Assert
    assertEquals(OctahedralGroup.IDENTITY, OctahedralGroup.fromXYAngles(Quadrant.R0, Quadrant.R0));
  }
}
