package org.bukkit.block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DoubleChestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleChest#DoubleChest(DoubleChestInventory)}
   *   <li>{@link DoubleChest#getInventory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DoubleChest.<init>(DoubleChestInventory)",
    "Inventory DoubleChest.getInventory()"
  })
  void testGettersAndSetters() {
    // Arrange
    DoubleChestInventory chest = mock(DoubleChestInventory.class);

    // Act and Assert
    assertSame(chest, new DoubleChest(chest).getInventory());
  }

  /**
   * Test {@link DoubleChest#getLeftSide()}.
   *
   * <p>Method under test: {@link DoubleChest#getLeftSide()}
   */
  @Test
  @DisplayName("Test getLeftSide()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InventoryHolder DoubleChest.getLeftSide()"})
  void testGetLeftSide() {
    // Arrange
    Inventory inventory = mock(Inventory.class);
    when(inventory.getHolder()).thenReturn(mock(InventoryHolder.class));

    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    when(chest.getLeftSide()).thenReturn(inventory);

    // Act
    new DoubleChest(chest).getLeftSide();

    // Assert
    verify(chest).getLeftSide();
    verify(inventory).getHolder();
  }

  /**
   * Test {@link DoubleChest#getLeftSide(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link DoubleChest#getLeftSide(boolean)}
   */
  @Test
  @DisplayName("Test getLeftSide(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InventoryHolder DoubleChest.getLeftSide(boolean)"})
  void testGetLeftSideWithBoolean() {
    // Arrange
    Inventory inventory = mock(Inventory.class);
    when(inventory.getHolder(anyBoolean())).thenReturn(mock(InventoryHolder.class));

    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    when(chest.getLeftSide()).thenReturn(inventory);

    // Act
    new DoubleChest(chest).getLeftSide(true);

    // Assert
    verify(chest).getLeftSide();
    verify(inventory).getHolder(true);
  }

  /**
   * Test {@link DoubleChest#getRightSide()}.
   *
   * <p>Method under test: {@link DoubleChest#getRightSide()}
   */
  @Test
  @DisplayName("Test getRightSide()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InventoryHolder DoubleChest.getRightSide()"})
  void testGetRightSide() {
    // Arrange
    Inventory inventory = mock(Inventory.class);
    when(inventory.getHolder()).thenReturn(mock(InventoryHolder.class));

    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    when(chest.getRightSide()).thenReturn(inventory);

    // Act
    new DoubleChest(chest).getRightSide();

    // Assert
    verify(chest).getRightSide();
    verify(inventory).getHolder();
  }

  /**
   * Test {@link DoubleChest#getRightSide(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link DoubleChest#getRightSide(boolean)}
   */
  @Test
  @DisplayName("Test getRightSide(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InventoryHolder DoubleChest.getRightSide(boolean)"})
  void testGetRightSideWithBoolean() {
    // Arrange
    Inventory inventory = mock(Inventory.class);
    when(inventory.getHolder(anyBoolean())).thenReturn(mock(InventoryHolder.class));

    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    when(chest.getRightSide()).thenReturn(inventory);

    // Act
    new DoubleChest(chest).getRightSide(true);

    // Assert
    verify(chest).getRightSide();
    verify(inventory).getHolder(true);
  }

  /**
   * Test {@link DoubleChest#getLocation()}.
   *
   * <p>Method under test: {@link DoubleChest#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location DoubleChest.getLocation()"})
  void testGetLocation() {
    // Arrange
    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(chest.getLocation()).thenReturn(location);

    // Act
    Location actualLocation = new DoubleChest(chest).getLocation();

    // Assert
    verify(chest).getLocation();
    assertSame(location, actualLocation);
  }

  /**
   * Test {@link DoubleChest#getWorld()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleChest#getWorld()}
   */
  @Test
  @DisplayName("Test getWorld(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"World DoubleChest.getWorld()"})
  void testGetWorld_thenReturnNull() {
    // Arrange
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    location.setWorld(null);

    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    when(chest.getLocation()).thenReturn(location);

    // Act
    World actualWorld = new DoubleChest(chest).getWorld();

    // Assert
    verify(chest).getLocation();
    assertNull(actualWorld);
  }

  /**
   * Test {@link DoubleChest#getX()}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link DoubleChest#getX()}
   */
  @Test
  @DisplayName("Test getX(); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DoubleChest.getX()"})
  void testGetX_thenReturnTwo() {
    // Arrange
    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(chest.getLocation()).thenReturn(location);

    // Act
    double actualX = new DoubleChest(chest).getX();

    // Assert
    verify(chest).getLocation();
    assertEquals(2.0d, actualX);
  }

  /**
   * Test {@link DoubleChest#getY()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link DoubleChest#getY()}
   */
  @Test
  @DisplayName("Test getY(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DoubleChest.getY()"})
  void testGetY_thenReturnThree() {
    // Arrange
    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(chest.getLocation()).thenReturn(location);

    // Act
    double actualY = new DoubleChest(chest).getY();

    // Assert
    verify(chest).getLocation();
    assertEquals(3.0d, actualY);
  }

  /**
   * Test {@link DoubleChest#getZ()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link DoubleChest#getZ()}
   */
  @Test
  @DisplayName("Test getZ(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DoubleChest.getZ()"})
  void testGetZ_thenReturnTen() {
    // Arrange
    DoubleChestInventory chest = mock(DoubleChestInventory.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(chest.getLocation()).thenReturn(location);

    // Act
    double actualZ = new DoubleChest(chest).getZ();

    // Assert
    verify(chest).getLocation();
    assertEquals(10.0d, actualZ);
  }
}
