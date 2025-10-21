package org.bukkit.event.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StructureGrowEventDiffblueTest {
  /**
   * Test {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean, Player, List)}.
   *
   * <ul>
   *   <li>Given {@link BlockState}.
   *   <li>Then return Blocks is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean,
   * Player, List)}
   */
  @Test
  @DisplayName(
      "Test new StructureGrowEvent(Location, TreeType, boolean, Player, List); given BlockState; then return Blocks is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructureGrowEvent.<init>(Location, TreeType, boolean, Player, List)"})
  void testNewStructureGrowEvent_givenBlockState_thenReturnBlocksIsArrayList() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Player player = mock(Player.class);

    ArrayList<BlockState> blocks = new ArrayList<>();
    blocks.add(mock(BlockState.class));
    blocks.add(mock(BlockState.class));

    // Act
    StructureGrowEvent actualStructureGrowEvent =
        new StructureGrowEvent(location, TreeType.TREE, true, player, blocks);

    // Assert
    Location location2 = actualStructureGrowEvent.getLocation();
    assertNull(location2.getChunk());
    assertNull(location2.getBlock());
    assertSame(blocks, actualStructureGrowEvent.getBlocks());
  }

  /**
   * Test {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean, Player, List)}.
   *
   * <ul>
   *   <li>Given {@link BlockState}.
   *   <li>Then return Blocks size is one.
   * </ul>
   *
   * <p>Method under test: {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean,
   * Player, List)}
   */
  @Test
  @DisplayName(
      "Test new StructureGrowEvent(Location, TreeType, boolean, Player, List); given BlockState; then return Blocks size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructureGrowEvent.<init>(Location, TreeType, boolean, Player, List)"})
  void testNewStructureGrowEvent_givenBlockState_thenReturnBlocksSizeIsOne() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Player player = mock(Player.class);

    ArrayList<BlockState> blocks = new ArrayList<>();
    blocks.add(mock(BlockState.class));

    // Act
    StructureGrowEvent actualStructureGrowEvent =
        new StructureGrowEvent(location, TreeType.TREE, true, player, blocks);

    // Assert
    Location location2 = actualStructureGrowEvent.getLocation();
    assertNull(location2.getChunk());
    assertNull(location2.getBlock());
    List<BlockState> blocks2 = actualStructureGrowEvent.getBlocks();
    assertEquals(1, blocks2.size());
    assertSame(blocks, blocks2);
  }

  /**
   * Test {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean, Player, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Location World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean,
   * Player, List)}
   */
  @Test
  @DisplayName(
      "Test new StructureGrowEvent(Location, TreeType, boolean, Player, List); given 'null'; then return Location World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructureGrowEvent.<init>(Location, TreeType, boolean, Player, List)"})
  void testNewStructureGrowEvent_givenNull_thenReturnLocationWorldIsNull() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(null);
    Player player = mock(Player.class);

    // Act
    StructureGrowEvent actualStructureGrowEvent =
        new StructureGrowEvent(location, TreeType.TREE, true, player, new ArrayList<>());

    // Assert
    Location location2 = actualStructureGrowEvent.getLocation();
    assertNull(location2.getWorld());
    assertNull(actualStructureGrowEvent.getWorld());
    assertFalse(location2.isWorldLoaded());
  }

  /**
   * Test {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean, Player, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Blocks Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructureGrowEvent#StructureGrowEvent(Location, TreeType, boolean,
   * Player, List)}
   */
  @Test
  @DisplayName(
      "Test new StructureGrowEvent(Location, TreeType, boolean, Player, List); when ArrayList(); then return Blocks Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructureGrowEvent.<init>(Location, TreeType, boolean, Player, List)"})
  void testNewStructureGrowEvent_whenArrayList_thenReturnBlocksEmpty() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Player player = mock(Player.class);

    // Act
    StructureGrowEvent actualStructureGrowEvent =
        new StructureGrowEvent(location, TreeType.TREE, true, player, new ArrayList<>());

    // Assert
    Location location2 = actualStructureGrowEvent.getLocation();
    assertNull(location2.getChunk());
    assertNull(location2.getBlock());
    assertTrue(actualStructureGrowEvent.getBlocks().isEmpty());
  }

  /**
   * Test {@link StructureGrowEvent#getLocation()}.
   *
   * <p>Method under test: {@link StructureGrowEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location StructureGrowEvent.getLocation()"})
  void testGetLocation() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Player player = mock(Player.class);

    // Act and Assert
    assertEquals(
        location,
        new StructureGrowEvent(location, TreeType.TREE, true, player, new ArrayList<>())
            .getLocation());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructureGrowEvent#setCancelled(boolean)}
   *   <li>{@link StructureGrowEvent#getHandlerList()}
   *   <li>{@link StructureGrowEvent#getBlocks()}
   *   <li>{@link StructureGrowEvent#getHandlers()}
   *   <li>{@link StructureGrowEvent#getPlayer()}
   *   <li>{@link StructureGrowEvent#getSpecies()}
   *   <li>{@link StructureGrowEvent#isCancelled()}
   *   <li>{@link StructureGrowEvent#isFromBonemeal()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StructureGrowEvent.getBlocks()",
    "HandlerList StructureGrowEvent.getHandlerList()",
    "HandlerList StructureGrowEvent.getHandlers()",
    "Player StructureGrowEvent.getPlayer()",
    "TreeType StructureGrowEvent.getSpecies()",
    "boolean StructureGrowEvent.isCancelled()",
    "boolean StructureGrowEvent.isFromBonemeal()",
    "void StructureGrowEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Player player = mock(Player.class);
    ArrayList<BlockState> blocks = new ArrayList<>();

    StructureGrowEvent structureGrowEvent =
        new StructureGrowEvent(location, TreeType.TREE, true, player, blocks);

    // Act
    structureGrowEvent.setCancelled(true);
    HandlerList actualHandlerList = structureGrowEvent.getHandlerList();
    List<BlockState> actualBlocks = structureGrowEvent.getBlocks();
    HandlerList actualHandlers = structureGrowEvent.getHandlers();
    structureGrowEvent.getPlayer();
    TreeType actualSpecies = structureGrowEvent.getSpecies();
    boolean actualIsCancelledResult = structureGrowEvent.isCancelled();
    boolean actualIsFromBonemealResult = structureGrowEvent.isFromBonemeal();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(TreeType.TREE, actualSpecies);
    assertTrue(actualBlocks.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsFromBonemealResult);
    assertSame(blocks, actualBlocks);
    assertSame(actualHandlerList, actualHandlers);
  }
}
