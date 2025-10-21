package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BlockIteratorDiffblueTest {
  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 1);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2, atLeast(1)).getX();
    verify(block2, atLeast(1)).getY();
    verify(block2, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location loc = new Location(world, 10.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(10, 3, 1);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.EAST);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block5, atLeast(1)).getX();
    verify(block2).getY();
    verify(block5, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block5, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, -0.17101007166283433d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(-1, 3, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator5() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    Block block6 = mock(Block.class);
    when(block6.getX()).thenReturn(2);
    when(block6.getY()).thenReturn(3);
    when(block6.getZ()).thenReturn(1);
    when(block6.getRelative(Mockito.<BlockFace>any())).thenReturn(block5);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block6);
    Location loc = new Location(world, 10.0d, 10.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(10, 10, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.EAST);
    verify(block6).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block6, atLeast(1)).getX();
    verify(block2).getY();
    verify(block6, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block6, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator6() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    Block block6 = mock(Block.class);
    when(block6.getX()).thenReturn(2);
    when(block6.getY()).thenReturn(3);
    when(block6.getZ()).thenReturn(1);
    when(block6.getRelative(Mockito.<BlockFace>any())).thenReturn(block5);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block6);
    Location loc = new Location(world, 10.0d, 10.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(10, 10, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.EAST);
    verify(block6).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block6, atLeast(1)).getX();
    verify(block6, atLeast(1)).getY();
    verify(block6, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator7() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location loc = new Location(world, 10.0d, 10.0d, 1.0d, -180.0f, 10.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(10, 10, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block2).getRelative(BlockFace.EAST);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block5).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getX();
    verify(block5, atLeast(1)).getX();
    verify(block2).getY();
    verify(block5, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block5, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator8() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 10.0d, 10.0d, 1.0d, -90.0f, 10.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(10, 10, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block2).getRelative(BlockFace.EAST);
    verify(block3).getRelative(BlockFace.UP);
    verify(block4).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block4, atLeast(1)).getX();
    verify(block).getY();
    verify(block4, atLeast(1)).getY();
    verify(block).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator9() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 10.0d, 10.0d, 1.0d, 0.0f, 10.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(10, 10, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getRelative(BlockFace.UP);
    verify(block).getX();
    verify(block4, atLeast(1)).getX();
    verify(block).getY();
    verify(block4, atLeast(1)).getY();
    verify(block).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator10() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 10.0d, 10.0d, 1.0d, 10.0f, -180.0f);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(10, 10, 1);
    verify(block).getRelative(BlockFace.EAST);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block4).getRelative(BlockFace.SOUTH);
    verify(block2).getRelative(BlockFace.UP);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator11() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block5, atLeast(1)).getX();
    verify(block2).getY();
    verify(block5, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block5, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator12() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    Block block6 = mock(Block.class);
    when(block6.getX()).thenReturn(2);
    when(block6.getY()).thenReturn(3);
    when(block6.getZ()).thenReturn(1);
    when(block6.getRelative(Mockito.<BlockFace>any())).thenReturn(block5);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block6);
    Location loc = new Location(world, 13.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(13, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.EAST);
    verify(block6).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block6, atLeast(1)).getX();
    verify(block2).getY();
    verify(block6, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block6, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator13() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act
    new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, -180.0f, 10.0f), 10.0d);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator14() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);

    // Act
    new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, -90.0f, 10.0f), 10.0d);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block2).getRelative(BlockFace.EAST);
    verify(block3).getRelative(BlockFace.UP);
    verify(block4).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block4, atLeast(1)).getX();
    verify(block).getY();
    verify(block4, atLeast(1)).getY();
    verify(block).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator15() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act
    new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, 0.0f, 10.0f), 10.0d);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator16() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act
    new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, -180.0f), 10.0d);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator17() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block5, atLeast(1)).getX();
    verify(block2).getY();
    verify(block5, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block5, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator18() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    Block block6 = mock(Block.class);
    when(block6.getX()).thenReturn(2);
    when(block6.getY()).thenReturn(3);
    when(block6.getZ()).thenReturn(1);
    when(block6.getRelative(Mockito.<BlockFace>any())).thenReturn(block5);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block6);
    Location loc = new Location(world, 13.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(13, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.EAST);
    verify(block6).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block6, atLeast(1)).getX();
    verify(block2).getY();
    verify(block6, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block6, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator19() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block5, atLeast(1)).getX();
    verify(block2).getY();
    verify(block5, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block5, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator20() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    Block block6 = mock(Block.class);
    when(block6.getX()).thenReturn(2);
    when(block6.getY()).thenReturn(3);
    when(block6.getZ()).thenReturn(1);
    when(block6.getRelative(Mockito.<BlockFace>any())).thenReturn(block5);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block6);
    Location location = new Location(world, 13.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(13, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.EAST);
    verify(block6).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block6, atLeast(1)).getX();
    verify(block2).getY();
    verify(block6, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block6, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator21() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, -180.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator22() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, -90.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block2).getRelative(BlockFace.EAST);
    verify(block3).getRelative(BlockFace.UP);
    verify(block4).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block4, atLeast(1)).getX();
    verify(block).getY();
    verify(block4, atLeast(1)).getY();
    verify(block).getZ();
    verify(block4, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator23() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 0.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator24() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, -180.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator25() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block5, atLeast(1)).getX();
    verify(block2).getY();
    verify(block5, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block5, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator26() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    Block block6 = mock(Block.class);
    when(block6.getX()).thenReturn(2);
    when(block6.getY()).thenReturn(3);
    when(block6.getZ()).thenReturn(1);
    when(block6.getRelative(Mockito.<BlockFace>any())).thenReturn(block5);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block6);
    Location location = new Location(world, 13.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(13, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.EAST);
    verify(block6).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block6, atLeast(1)).getX();
    verify(block2).getY();
    verify(block6, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block6, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 10);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getX();
    verify(block2).getY();
    verify(block2).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 10);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getX();
    verify(block2).getY();
    verify(block2).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 1);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.UP);
    verify(block2, atLeast(1)).getX();
    verify(block2, atLeast(1)).getY();
    verify(block2, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 1);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getRelative(BlockFace.UP);
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException5() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 1);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getRelative(BlockFace.UP);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4, atLeast(1)).getX();
    verify(block4, atLeast(1)).getY();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException6() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block5, atLeast(1)).getX();
    verify(block5, atLeast(1)).getY();
    verify(block5, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException7() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getX();
    verify(block2).getY();
    verify(block2).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException8() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.UP);
    verify(block2, atLeast(1)).getX();
    verify(block2, atLeast(1)).getY();
    verify(block2, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException9() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getRelative(BlockFace.UP);
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException10() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getRelative(BlockFace.UP);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4, atLeast(1)).getX();
    verify(block4, atLeast(1)).getY();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException11() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block5, atLeast(1)).getX();
    verify(block5, atLeast(1)).getY();
    verify(block5, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException12() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 10);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getX();
    verify(block2).getY();
    verify(block2).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException13() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 1);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.UP);
    verify(block2, atLeast(1)).getX();
    verify(block2, atLeast(1)).getY();
    verify(block2, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException14() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 1);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getRelative(BlockFace.UP);
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException15() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 1);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getRelative(BlockFace.UP);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4, atLeast(1)).getX();
    verify(block4, atLeast(1)).getY();
    verify(block4, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException16() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block5, atLeast(1)).getX();
    verify(block5, atLeast(1)).getY();
    verify(block5, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException17() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getX();
    verify(block2).getY();
    verify(block2).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException18() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getX()).thenReturn(2);
    when(block2.getY()).thenReturn(3);
    when(block2.getZ()).thenReturn(1);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block2);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block2).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.UP);
    verify(block2, atLeast(1)).getX();
    verify(block2, atLeast(1)).getY();
    verify(block2, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException19() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block).getRelative(BlockFace.SOUTH);
    verify(block2).getRelative(BlockFace.UP);
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException20() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getRelative(BlockFace.UP);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4, atLeast(1)).getX();
    verify(block4, atLeast(1)).getY();
    verify(block4, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getRelative(BlockFace)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getRelative(BlockFace) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetRelativeThrowIllegalStateException21() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    Block block5 = mock(Block.class);
    when(block5.getX()).thenReturn(2);
    when(block5.getY()).thenReturn(3);
    when(block5.getZ()).thenReturn(1);
    when(block5.getRelative(Mockito.<BlockFace>any())).thenReturn(block4);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block5);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block5).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block4).getRelative(BlockFace.UP);
    verify(block2).getRelative(BlockFace.WEST);
    verify(block5, atLeast(1)).getX();
    verify(block5, atLeast(1)).getY();
    verify(block5, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double); given Block getX() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetXReturnOne() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(1);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int); given Block getX() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetXReturnOne2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(1);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new BlockIterator(
                new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d, 3));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity); given Block getX() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetXReturnOne3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(1);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int); given Block getX() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetXReturnOne4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(1);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getX();
    verify(block).getX();
    verify(block3).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 1);
    verify(block).getX();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getX();
    verify(block).getX();
    verify(block3).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getX();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException5() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getX();
    verify(block).getX();
    verify(block3).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException6() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getX();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException7() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getX();
    verify(block).getX();
    verify(block3).getY();
    verify(block3).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException8() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getX();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException9() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block3).getX();
    verify(block).getX();
    verify(block3).getY();
    verify(block3).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getX()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getX() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetXThrowIllegalStateException10() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getX()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(block).getX();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double); given Block getY() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetYReturnOne() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(1);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int); given Block getY() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetYReturnOne2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(1);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new BlockIterator(
                new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d, 3));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity); given Block getY() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetYReturnOne3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(1);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int); given Block getY() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetYReturnOne4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(1);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given Block getY() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenBlockGetYThrowIllegalStateException() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenThrow(new IllegalStateException());
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3).getY();
    verify(block).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getY() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetYThrowIllegalStateException2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenThrow(new IllegalStateException());
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3).getY();
    verify(block).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getY() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetYThrowIllegalStateException3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenThrow(new IllegalStateException());
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3).getY();
    verify(block).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getY() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetYThrowIllegalStateException4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenThrow(new IllegalStateException());
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3).getY();
    verify(block).getY();
    verify(block3).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getY()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getY() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetYThrowIllegalStateException5() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getY()).thenThrow(new IllegalStateException());
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block3).getY();
    verify(block).getY();
    verify(block3).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} return one.
   *   <li>When zero.
   *   <li>Then calls {@link Block#getRelative(BlockFace)}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getZ() return one; when zero; then calls getRelative(BlockFace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetZReturnOne_whenZero_thenCallsGetRelative() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act
    new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d, 0);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double); given Block getZ() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetZReturnZero() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(0);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new BlockIterator(new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int); given Block getZ() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetZReturnZero2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(0);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new BlockIterator(
                new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f), 10.0d, 3));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity); given Block getZ() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetZReturnZero3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(0);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int); given Block getZ() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetZReturnZero4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(0);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 10);
    verify(block).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3).getZ();
    verify(block).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 10);
    verify(block).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3).getZ();
    verify(block).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException5() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException6() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3).getZ();
    verify(block).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException7() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 10);
    verify(block).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException8() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3).getZ();
    verify(block).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException9() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Block} {@link Block#getZ()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Block getZ() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenBlockGetZThrowIllegalStateException10() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenThrow(new IllegalStateException());
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block3).getZ();
    verify(block).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenIllegalStateException() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 10);
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_givenIllegalStateException2() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(2, 3, 1);
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenIllegalStateException3() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 10);
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_givenIllegalStateException4() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(2, 13, 1);
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenIllegalStateException5() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 10);
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(Location, double, int); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_givenIllegalStateException6() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location loc = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(2, 13, 1);
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenIllegalStateException7() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getLocation()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(entity).getLocation();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenIllegalStateException8() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getLocation()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(entity).getLocation();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4).getX();
    verify(block4).getY();
    verify(block4).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location location = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4).getX();
    verify(block4).getY();
    verify(block4).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 1.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 1.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block3).getX();
    verify(block3).getY();
    verify(block3).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 1.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 1.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block3).getX();
    verify(block3).getY();
    verify(block3).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is thirteen and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is thirteen and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsThirteenAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(13, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is thirteen and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is thirteen and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsThirteenAndYIsThreeAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(13, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is two and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsTwoAndYIs16777216e7AndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 1.6777216E7d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(2, 16777226, 10);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is two and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsTwoAndYIs16777216e7AndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 1.6777216E7d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(2, 16777226, 10);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity);

    // Assert
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 3);

    // Assert
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getBlockAt(int, int, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given World getBlockAt(int, int, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenWorldGetBlockAtThrowIllegalStateException() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 10);
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity)}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getBlockAt(int, int, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity); given World getBlockAt(int, int, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity)"})
  void testNewBlockIterator_givenWorldGetBlockAtThrowIllegalStateException2() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity));
    verify(world).getBlockAt(2, 13, 1);
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getBlockAt(int, int, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given World getBlockAt(int, int, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenWorldGetBlockAtThrowIllegalStateException3() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 10);
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getBlockAt(int, int, int)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(LivingEntity, int); given World getBlockAt(int, int, int) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_givenWorldGetBlockAtThrowIllegalStateException4() {
    // Arrange
    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenThrow(new IllegalStateException());
    Location location = new Location(world, 2.0d, 3.0d, 1.0d, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(entity, 3));
    verify(world).getBlockAt(2, 13, 1);
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4).getX();
    verify(block4).getY();
    verify(block4).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is one and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIs16777216e7AndZIsTen4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 1.0d, 1.6777216E7d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(1, 16777226, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4).getX();
    verify(block4).getY();
    verify(block4).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is one and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is one and y is one and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsOneAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);
    when(block2.getZ()).thenReturn(1);
    when(block2.getY()).thenReturn(3);
    when(block2.getX()).thenReturn(2);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 1.0d, 1.0d, 10.0d);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(1, 1, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block2).getX();
    verify(block4, atLeast(1)).getX();
    verify(block2).getY();
    verify(block4, atLeast(1)).getY();
    verify(block2).getZ();
    verify(block4, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is one and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is one and y is one and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsOneAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    Block block4 = mock(Block.class);
    when(block4.getX()).thenReturn(2);
    when(block4.getY()).thenReturn(3);
    when(block4.getZ()).thenReturn(1);
    when(block4.getRelative(Mockito.<BlockFace>any())).thenReturn(block3);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block4);
    Location loc = new Location(world, 1.0d, 1.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(1, 1, 10);
    verify(block2).getRelative(BlockFace.DOWN);
    verify(block4).getRelative(BlockFace.NORTH);
    verify(block3).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block4).getX();
    verify(block4).getY();
    verify(block4).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is ten and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is one and y is ten and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsTenAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 10.0d, 10.0d);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(1, 10, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(1, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc));
    verify(world).getBlockAt(1, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block3).getX();
    verify(block3).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen4() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d));
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block3).getX();
    verify(block3).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen5() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       one and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is one and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsOneAndYIsThreeAndZIsTen6() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenThrow(new IllegalStateException());

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 1.0d, 3.0d, 10.0d);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new BlockIterator(loc, 10.0d, 3));
    verify(world).getBlockAt(1, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getRelative(BlockFace.WEST);
    verify(block3).getX();
    verify(block3).getY();
    verify(block3).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       thirteen and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is thirteen and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsThirteenAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 13.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(13, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       thirteen and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is thirteen and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsThirteenAndYIsThreeAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 13.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(13, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       three and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is three and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsThreeAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 3.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(3, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is two and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsTwoAndYIs16777216e7AndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 1.6777216E7d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(2, 16777226, 10);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is {@code 1.6777216E7} and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is two and y is '1.6777216E7' and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsTwoAndYIs16777216e7AndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 1.6777216E7d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(2, 16777226, 10);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is one and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is two and y is one and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsTwoAndYIsOneAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getRelative(Mockito.<BlockFace>any())).thenReturn(mock(Block.class));
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 1.0d, 10.0d);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(2, 1, 10);
    verify(block).getRelative(BlockFace.DOWN);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location); when Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc);

    // Assert
    verify(world).getBlockAt(2, 3, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double); when Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen2() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d);

    // Assert
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(Location, double, int)}.
   *
   * <ul>
   *   <li>When {@link Location#Location(World, double, double, double)} with {@link World} and x is
   *       two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(Location, double, int)}
   */
  @Test
  @DisplayName(
      "Test new BlockIterator(Location, double, int); when Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(Location, double, int)"})
  void testNewBlockIterator_whenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen3() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location loc = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act
    new BlockIterator(loc, 10.0d, 3);

    // Assert
    verify(world).getBlockAt(2, 13, 10);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
  }

  /**
   * Test {@link BlockIterator#BlockIterator(LivingEntity, int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link BlockIterator#BlockIterator(LivingEntity, int)}
   */
  @Test
  @DisplayName("Test new BlockIterator(LivingEntity, int); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockIterator.<init>(LivingEntity, int)"})
  void testNewBlockIterator_whenZero() {
    // Arrange
    Block block = mock(Block.class);
    when(block.getZ()).thenReturn(1);
    when(block.getY()).thenReturn(3);
    when(block.getX()).thenReturn(2);

    Block block2 = mock(Block.class);
    when(block2.getRelative(Mockito.<BlockFace>any())).thenReturn(block);

    Block block3 = mock(Block.class);
    when(block3.getX()).thenReturn(2);
    when(block3.getY()).thenReturn(3);
    when(block3.getZ()).thenReturn(1);
    when(block3.getRelative(Mockito.<BlockFace>any())).thenReturn(block2);

    World world = mock(World.class);
    when(world.getBlockAt(anyInt(), anyInt(), anyInt())).thenReturn(block3);
    Location location = new Location(world, 13.0d, 3.0d, Double.NaN, 10.0f, 10.0f);

    LivingEntity entity = mock(LivingEntity.class);
    when(entity.getEyeHeight()).thenReturn(10.0d);
    when(entity.getLocation()).thenReturn(location);

    // Act
    new BlockIterator(entity, 0);

    // Assert
    verify(world).getBlockAt(13, 13, 0);
    verify(block3).getRelative(BlockFace.NORTH);
    verify(block2).getRelative(BlockFace.SOUTH);
    verify(block).getX();
    verify(block3, atLeast(1)).getX();
    verify(block).getY();
    verify(block3, atLeast(1)).getY();
    verify(block).getZ();
    verify(block3, atLeast(1)).getZ();
    verify(entity).getLocation();
    verify(entity).getEyeHeight();
  }
}
