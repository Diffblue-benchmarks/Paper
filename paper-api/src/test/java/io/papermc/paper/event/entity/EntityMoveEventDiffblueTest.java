package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityMoveEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityMoveEvent#EntityMoveEvent(LivingEntity, Location, Location)}
   *   <li>{@link EntityMoveEvent#setCancelled(boolean)}
   *   <li>{@link EntityMoveEvent#getHandlerList()}
   *   <li>{@link EntityMoveEvent#getFrom()}
   *   <li>{@link EntityMoveEvent#getHandlers()}
   *   <li>{@link EntityMoveEvent#getTo()}
   *   <li>{@link EntityMoveEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityMoveEvent.<init>(LivingEntity, Location, Location)",
    "Location EntityMoveEvent.getFrom()",
    "HandlerList EntityMoveEvent.getHandlerList()",
    "HandlerList EntityMoveEvent.getHandlers()",
    "Location EntityMoveEvent.getTo()",
    "boolean EntityMoveEvent.isCancelled()",
    "void EntityMoveEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    EntityMoveEvent actualEntityMoveEvent = new EntityMoveEvent(entity, from, resultTo);
    actualEntityMoveEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityMoveEvent.getHandlerList();
    Location actualFrom = actualEntityMoveEvent.getFrom();
    HandlerList actualHandlers = actualEntityMoveEvent.getHandlers();
    Location actualTo = actualEntityMoveEvent.getTo();
    boolean actualIsCancelledResult = actualEntityMoveEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityMoveEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(from, actualFrom);
    assertSame(resultTo, actualTo);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityMoveEvent.getEntity());
  }

  /**
   * Test {@link EntityMoveEvent#setFrom(Location)}.
   *
   * <ul>
   *   <li>Given {@link World}.
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#setFrom(Location)}
   */
  @Test
  @DisplayName("Test setFrom(Location); given World; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityMoveEvent.setFrom(Location)"})
  void testSetFrom_givenWorld_thenCallsClone() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    Location from2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(from2.clone()).thenReturn(location);
    when(from2.getWorld()).thenReturn(mock(World.class));

    // Act
    entityMoveEvent.setFrom(from2);

    // Assert
    verify(from2).clone();
    verify(from2).getWorld();
  }

  /**
   * Test {@link EntityMoveEvent#setTo(Location)}.
   *
   * <ul>
   *   <li>Given {@link World}.
   *   <li>Then calls {@link Location#clone()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#setTo(Location)}
   */
  @Test
  @DisplayName("Test setTo(Location); given World; then calls clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityMoveEvent.setTo(Location)"})
  void testSetTo_givenWorld_thenCallsClone() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    Location resultTo2 = mock(Location.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(resultTo2.clone()).thenReturn(location);
    when(resultTo2.getWorld()).thenReturn(mock(World.class));

    // Act
    entityMoveEvent.setTo(resultTo2);

    // Assert
    verify(resultTo2).clone();
    verify(resultTo2).getWorld();
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedPosition()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName("Test hasChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition() {
    // Arrange
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    from.setWorld(mock(World.class));

    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    resultTo.setWorld(null);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(mock(LivingEntity.class), from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is three and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName(
      "Test hasChangedPosition(); given Location(World, double, double, double) with World and x is three and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_givenLocationWithWorldAndXIsThreeAndYIsThreeAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 3.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is two.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName(
      "Test hasChangedPosition(); given Location(World, double, double, double) with World and x is two and y is three and z is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTwo() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is two and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName(
      "Test hasChangedPosition(); given Location(World, double, double, double) with World and x is two and y is two and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_givenLocationWithWorldAndXIsTwoAndYIsTwoAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 2.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedPosition()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedPosition()}
   */
  @Test
  @DisplayName("Test hasChangedPosition(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedPosition()"})
  void testHasChangedPosition_thenReturnTrue() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 3.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition2() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 2.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition3() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 2.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedPosition()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedPosition()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedPosition(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedPosition()"})
  void testHasExplicitlyChangedPosition_thenReturnFalse() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertFalse(entityMoveEvent.hasExplicitlyChangedPosition());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedBlock()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName("Test hasChangedBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock() {
    // Arrange
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    from.setWorld(mock(World.class));

    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    resultTo.setWorld(null);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(mock(LivingEntity.class), from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@code 0.5} and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is '0.5' and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIs05AndYIsThreeAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is ten and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is ten and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIsTenAndYIsThreeAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 10.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is ten and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is two and y is ten and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIsTwoAndYIsTenAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 10.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is three and z is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasChangedBlock(); given Location(World, double, double, double) with World and x is two and y is three and z is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_givenLocationWithWorldAndXIsTwoAndYIsThreeAndZIsOne() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 1.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedBlock()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedBlock()}
   */
  @Test
  @DisplayName("Test hasChangedBlock(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedBlock()"})
  void testHasChangedBlock_thenReturnTrue() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 10.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedBlock()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock2() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 1.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is {@code 0.5} and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasExplicitlyChangedBlock(); given Location(World, double, double, double) with World and x is '0.5' and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock_givenLocationWithWorldAndXIs05AndYIsThreeAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 0.5d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <ul>
   *   <li>Given {@link Location#Location(World, double, double, double)} with {@link World} and x
   *       is two and y is ten and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName(
      "Test hasExplicitlyChangedBlock(); given Location(World, double, double, double) with World and x is two and y is ten and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock_givenLocationWithWorldAndXIsTwoAndYIsTenAndZIsTen() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 10.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasExplicitlyChangedBlock()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasExplicitlyChangedBlock()}
   */
  @Test
  @DisplayName("Test hasExplicitlyChangedBlock(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasExplicitlyChangedBlock()"})
  void testHasExplicitlyChangedBlock_thenReturnFalse() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertFalse(entityMoveEvent.hasExplicitlyChangedBlock());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedOrientation()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedOrientation()}
   */
  @Test
  @DisplayName("Test hasChangedOrientation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedOrientation()"})
  void testHasChangedOrientation() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d, 10.0f, 10.0f);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedOrientation());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedOrientation()}.
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedOrientation()}
   */
  @Test
  @DisplayName("Test hasChangedOrientation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedOrientation()"})
  void testHasChangedOrientation2() {
    // Arrange
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    from.setYaw(10.0f);
    LivingEntity entity = mock(LivingEntity.class);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertTrue(entityMoveEvent.hasChangedOrientation());
  }

  /**
   * Test {@link EntityMoveEvent#hasChangedOrientation()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMoveEvent#hasChangedOrientation()}
   */
  @Test
  @DisplayName("Test hasChangedOrientation(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMoveEvent.hasChangedOrientation()"})
  void testHasChangedOrientation_thenReturnFalse() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    Location from = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    Location resultTo = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    EntityMoveEvent entityMoveEvent = new EntityMoveEvent(entity, from, resultTo);

    // Act and Assert
    assertFalse(entityMoveEvent.hasChangedOrientation());
  }
}
