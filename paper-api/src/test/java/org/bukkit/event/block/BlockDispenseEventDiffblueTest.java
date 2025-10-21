package org.bukkit.event.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockDispenseEventDiffblueTest {
  /**
   * Test {@link BlockDispenseEvent#getVelocity()}.
   *
   * <ul>
   *   <li>Then calls {@link BlockVector#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockDispenseEvent#getVelocity()}
   */
  @Test
  @DisplayName("Test getVelocity(); then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockDispenseEvent.getVelocity()"})
  void testGetVelocity_thenCallsClone() {
    // Arrange
    BlockVector velocity = mock(BlockVector.class);
    BlockVector blockVector = new BlockVector(2.0d, 3.0d, 10.0d);
    when(velocity.clone()).thenReturn(blockVector);
    BlockDispenseEvent blockDispenseEvent =
        new BlockDispenseEvent(mock(Block.class), mock(ItemStack.class), velocity);

    // Act
    Vector actualVelocity = blockDispenseEvent.getVelocity();

    // Assert
    verify(velocity).clone();
    assertSame(blockVector, actualVelocity);
  }

  /**
   * Test {@link BlockDispenseEvent#getVelocity()}.
   *
   * <ul>
   *   <li>Then return {@link BlockVector}.
   * </ul>
   *
   * <p>Method under test: {@link BlockDispenseEvent#getVelocity()}
   */
  @Test
  @DisplayName("Test getVelocity(); then return BlockVector")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockDispenseEvent.getVelocity()"})
  void testGetVelocity_thenReturnBlockVector() {
    // Arrange
    Block block = mock(Block.class);
    ItemStack item = mock(ItemStack.class);
    BlockVector velocity = new BlockVector(2.0d, 3.0d, 10.0d);

    BlockDispenseEvent blockDispenseEvent = new BlockDispenseEvent(block, item, velocity);

    // Act
    Vector actualVelocity = blockDispenseEvent.getVelocity();

    // Assert
    assertTrue(actualVelocity instanceof BlockVector);
    assertEquals(velocity, actualVelocity);
  }

  /**
   * Test {@link BlockDispenseEvent#getVelocity()}.
   *
   * <ul>
   *   <li>Then return Random.
   * </ul>
   *
   * <p>Method under test: {@link BlockDispenseEvent#getVelocity()}
   */
  @Test
  @DisplayName("Test getVelocity(); then return Random")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector BlockDispenseEvent.getVelocity()"})
  void testGetVelocity_thenReturnRandom() {
    // Arrange
    Vector velocity = Vector.getRandom();
    BlockDispenseEvent blockDispenseEvent =
        new BlockDispenseEvent(mock(Block.class), mock(ItemStack.class), velocity);

    // Act and Assert
    assertEquals(velocity, blockDispenseEvent.getVelocity());
  }

  /**
   * Test {@link BlockDispenseEvent#setVelocity(Vector)}.
   *
   * <p>Method under test: {@link BlockDispenseEvent#setVelocity(Vector)}
   */
  @Test
  @DisplayName("Test setVelocity(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockDispenseEvent.setVelocity(Vector)"})
  void testSetVelocity() {
    // Arrange
    BlockDispenseEvent blockDispenseEvent =
        new BlockDispenseEvent(mock(Block.class), mock(ItemStack.class), Vector.getRandom());
    Vector velocity = Vector.getRandom();

    // Act
    blockDispenseEvent.setVelocity(velocity);

    // Assert
    assertEquals(velocity, blockDispenseEvent.getVelocity());
  }

  /**
   * Test {@link BlockDispenseEvent#setVelocity(Vector)}.
   *
   * <p>Method under test: {@link BlockDispenseEvent#setVelocity(Vector)}
   */
  @Test
  @DisplayName("Test setVelocity(Vector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockDispenseEvent.setVelocity(Vector)"})
  void testSetVelocity2() {
    // Arrange
    BlockDispenseEvent blockDispenseEvent =
        new BlockDispenseEvent(mock(Block.class), mock(ItemStack.class), Vector.getRandom());

    BlockVector velocity = mock(BlockVector.class);
    when(velocity.clone()).thenReturn(new BlockVector(2.0d, 3.0d, 10.0d));

    // Act
    blockDispenseEvent.setVelocity(velocity);

    // Assert
    verify(velocity).clone();
    Vector velocity2 = blockDispenseEvent.getVelocity();
    assertTrue(velocity2 instanceof BlockVector);
    BlockVector toBlockVectorResult =
        velocity2
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector();
    Vector3d toVector3dResult = toBlockVectorResult.toVector3d();
    assertEquals(10.0d, toVector3dResult.z);
    Vector3f toVector3fResult = toBlockVectorResult.toVector3f();
    assertEquals(10.0f, toVector3fResult.z);
    assertEquals(2.0d, toVector3dResult.x);
    assertEquals(2.0f, toVector3fResult.x);
    assertEquals(3.0d, toVector3dResult.y);
    assertEquals(3.0f, toVector3fResult.y);
  }

  /**
   * Test {@link BlockDispenseEvent#setVelocity(Vector)}.
   *
   * <ul>
   *   <li>When {@link BlockVector#BlockVector(double, double, double)} with x is two and y is three
   *       and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockDispenseEvent#setVelocity(Vector)}
   */
  @Test
  @DisplayName(
      "Test setVelocity(Vector); when BlockVector(double, double, double) with x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockDispenseEvent.setVelocity(Vector)"})
  void testSetVelocity_whenBlockVectorWithXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    BlockDispenseEvent blockDispenseEvent =
        new BlockDispenseEvent(mock(Block.class), mock(ItemStack.class), Vector.getRandom());

    // Act
    blockDispenseEvent.setVelocity(new BlockVector(2.0d, 3.0d, 10.0d));

    // Assert
    assertTrue(blockDispenseEvent.getVelocity() instanceof BlockVector);
  }
}
