package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ParticleBuilderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticleBuilder#ParticleBuilder(Particle)}
   *   <li>{@link ParticleBuilder#count(int)}
   *   <li>{@link ParticleBuilder#data(Object)}
   *   <li>{@link ParticleBuilder#extra(double)}
   *   <li>{@link ParticleBuilder#force(boolean)}
   *   <li>{@link ParticleBuilder#particle(Particle)}
   *   <li>{@link ParticleBuilder#source(Player)}
   *   <li>{@link ParticleBuilder#allPlayers()}
   *   <li>{@link ParticleBuilder#data()}
   *   <li>{@link ParticleBuilder#count()}
   *   <li>{@link ParticleBuilder#extra()}
   *   <li>{@link ParticleBuilder#force()}
   *   <li>{@link ParticleBuilder#location()}
   *   <li>{@link ParticleBuilder#offsetX()}
   *   <li>{@link ParticleBuilder#offsetY()}
   *   <li>{@link ParticleBuilder#offsetZ()}
   *   <li>{@link ParticleBuilder#particle()}
   *   <li>{@link ParticleBuilder#receivers()}
   *   <li>{@link ParticleBuilder#source()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParticleBuilder.<init>(Particle)",
    "ParticleBuilder ParticleBuilder.allPlayers()",
    "int ParticleBuilder.count()",
    "ParticleBuilder ParticleBuilder.count(int)",
    "Object ParticleBuilder.data()",
    "ParticleBuilder ParticleBuilder.data(Object)",
    "double ParticleBuilder.extra()",
    "ParticleBuilder ParticleBuilder.extra(double)",
    "boolean ParticleBuilder.force()",
    "ParticleBuilder ParticleBuilder.force(boolean)",
    "Location ParticleBuilder.location()",
    "double ParticleBuilder.offsetX()",
    "double ParticleBuilder.offsetY()",
    "double ParticleBuilder.offsetZ()",
    "Particle ParticleBuilder.particle()",
    "ParticleBuilder ParticleBuilder.particle(Particle)",
    "List ParticleBuilder.receivers()",
    "Player ParticleBuilder.source()",
    "ParticleBuilder ParticleBuilder.source(Player)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ParticleBuilder actualParticleBuilder = new ParticleBuilder(Particle.POOF);
    ParticleBuilder actualCountResult = actualParticleBuilder.count(3);
    ParticleBuilder actualDataResult = actualParticleBuilder.data("Data");
    ParticleBuilder actualExtraResult = actualParticleBuilder.extra(10.0d);
    ParticleBuilder actualForceResult = actualParticleBuilder.force(true);
    ParticleBuilder actualParticleResult = actualParticleBuilder.particle(Particle.POOF);
    Player source = mock(Player.class);
    ParticleBuilder actualSourceResult = actualParticleBuilder.source(source);
    ParticleBuilder actualAllPlayersResult = actualParticleBuilder.allPlayers();
    Object actualDataResult2 = actualParticleBuilder.data();
    int actualCountResult2 = actualParticleBuilder.count();
    double actualExtraResult2 = actualParticleBuilder.extra();
    boolean actualForceResult2 = actualParticleBuilder.force();
    Location actualLocationResult = actualParticleBuilder.location();
    double actualOffsetXResult = actualParticleBuilder.offsetX();
    double actualOffsetYResult = actualParticleBuilder.offsetY();
    double actualOffsetZResult = actualParticleBuilder.offsetZ();
    Particle actualParticleResult2 = actualParticleBuilder.particle();
    List<Player> actualReceiversResult = actualParticleBuilder.receivers();
    Player actualSourceResult2 = actualParticleBuilder.source();

    // Assert
    assertEquals("Data", actualDataResult2);
    assertNull(actualReceiversResult);
    assertNull(actualLocationResult);
    assertEquals(0.0d, actualOffsetXResult);
    assertEquals(0.0d, actualOffsetYResult);
    assertEquals(0.0d, actualOffsetZResult);
    assertEquals(10.0d, actualExtraResult2);
    assertEquals(3, actualCountResult2);
    assertEquals(Particle.POOF, actualParticleResult2);
    assertTrue(actualForceResult2);
    assertSame(actualParticleBuilder, actualAllPlayersResult);
    assertSame(actualParticleBuilder, actualCountResult);
    assertSame(actualParticleBuilder, actualDataResult);
    assertSame(actualParticleBuilder, actualExtraResult);
    assertSame(actualParticleBuilder, actualForceResult);
    assertSame(actualParticleBuilder, actualParticleResult);
    assertSame(actualParticleBuilder, actualSourceResult);
    assertSame(source, actualSourceResult2);
  }

  /**
   * Test {@link ParticleBuilder#spawn()}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#spawn()}
   */
  @Test
  @DisplayName(
      "Test spawn(); given ParticleBuilder(Particle) with particle is 'POOF'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.spawn()"})
  void testSpawn_givenParticleBuilderWithParticleIsPoof_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).spawn());
  }

  /**
   * Test {@link ParticleBuilder#spawn()}.
   *
   * <ul>
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#spawn()}
   */
  @Test
  @DisplayName("Test spawn(); then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.spawn()"})
  void testSpawn_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    World world = mock(World.class);
    doNothing()
        .when(world)
        .spawnParticle(
            Mockito.<Particle>any(),
            Mockito.<List<Player>>any(),
            Mockito.<Player>any(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            anyInt(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            anyDouble(),
            Mockito.<Object>any(),
            anyBoolean());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualSpawnResult = particleBuilder.spawn();

    // Assert
    verify(world)
        .spawnParticle(
            eq(Particle.POOF),
            isNull(),
            isNull(),
            eq(2.0d),
            eq(3.0d),
            eq(10.0d),
            eq(1),
            eq(0.0d),
            eq(0.0d),
            eq(0.0d),
            eq(1.0d),
            isNull(),
            eq(true));
    assertSame(particleBuilder, actualSpawnResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Then {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}
   *       hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(Collection)}
   */
  @Test
  @DisplayName(
      "Test receivers(Collection) with 'Collection'; then ParticleBuilder(Particle) with particle is 'POOF' hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(Collection)"})
  void testReceiversWithCollection_thenParticleBuilderWithParticleIsPoofHasReceivers() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    ArrayList<Player> receivers = new ArrayList<>();
    receivers.add(mock(Player.class));

    // Act
    ParticleBuilder actualReceiversResult =
        particleBuilder.receivers((Collection<Player>) receivers);

    // Assert
    assertNull(actualReceiversResult.location());
    assertNull(actualReceiversResult.source());
    assertEquals(0.0d, actualReceiversResult.offsetX());
    assertEquals(0.0d, actualReceiversResult.offsetY());
    assertEquals(0.0d, actualReceiversResult.offsetZ());
    assertEquals(1, actualReceiversResult.count());
    assertEquals(1.0d, actualReceiversResult.extra());
    assertEquals(Particle.POOF, actualReceiversResult.particle());
    assertTrue(actualReceiversResult.force());
    assertTrue(particleBuilder.hasReceivers());
    assertTrue(actualReceiversResult.hasReceivers());
    assertEquals(receivers, actualReceiversResult.receivers());
  }

  /**
   * Test {@link ParticleBuilder#receivers(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Then {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}
   *       hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(Collection)}
   */
  @Test
  @DisplayName(
      "Test receivers(Collection) with 'Collection'; then ParticleBuilder(Particle) with particle is 'POOF' hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(Collection)"})
  void testReceiversWithCollection_thenParticleBuilderWithParticleIsPoofHasReceivers2() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    ArrayList<Player> receivers = new ArrayList<>();
    receivers.add(mock(Player.class));
    receivers.add(mock(Player.class));

    // Act
    ParticleBuilder actualReceiversResult =
        particleBuilder.receivers((Collection<Player>) receivers);

    // Assert
    assertNull(actualReceiversResult.location());
    assertNull(actualReceiversResult.source());
    assertEquals(0.0d, actualReceiversResult.offsetX());
    assertEquals(0.0d, actualReceiversResult.offsetY());
    assertEquals(0.0d, actualReceiversResult.offsetZ());
    assertEquals(1, actualReceiversResult.count());
    assertEquals(1.0d, actualReceiversResult.extra());
    assertEquals(Particle.POOF, actualReceiversResult.particle());
    assertTrue(actualReceiversResult.force());
    assertTrue(particleBuilder.hasReceivers());
    assertTrue(actualReceiversResult.hasReceivers());
    assertEquals(receivers, actualReceiversResult.receivers());
  }

  /**
   * Test {@link ParticleBuilder#receivers(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(Collection)}
   */
  @Test
  @DisplayName(
      "Test receivers(Collection) with 'Collection'; when 'null'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(Collection)"})
  void testReceiversWithCollection_whenNull_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers((Collection<Player>) null);

    // Assert
    assertFalse(particleBuilder.hasReceivers());
    assertSame(particleBuilder, actualReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, boolean) with 'int', 'boolean'; given ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_givenParticleBuilderWithParticleIsPoof() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).receivers(1, true));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, boolean) with 'int', 'boolean'; given ParticleBuilder(Particle) with particle is 'POOF'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_givenParticleBuilderWithParticleIsPoof_whenFalse() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).receivers(1, false));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link Player} {@link Player#getLocation()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, boolean) with 'int', 'boolean'; given Player getLocation() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_givenPlayerGetLocationThrowIllegalStateException() {
    // Arrange
    Player player = mock(Player.class);
    when(player.getLocation()).thenThrow(new IllegalStateException());

    ArrayList<Player> playerList = new ArrayList<>();
    playerList.add(player);

    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(playerList);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> particleBuilder.receivers(1, true));
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    verify(player).getLocation();
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getNearbyPlayers(Location, double, double, double)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, boolean) with 'int', 'boolean'; given World getNearbyPlayers(Location, double, double, double) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_givenWorldGetNearbyPlayersThrowIllegalStateException() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenThrow(new IllegalStateException());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> particleBuilder.receivers(1, true));
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return location toHighestLocation toHighestLocation.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, boolean) with 'int', 'boolean'; then return location toHighestLocation toHighestLocation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_thenReturnLocationToHighestLocationToHighestLocation() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, false);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertEquals(
        actualReceiversResult.location().toHighestLocation().toHighestLocation(),
        actualReceiversResult.location().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return not hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName("Test receivers(int, boolean) with 'int', 'boolean'; then return not hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_thenReturnNotHasReceivers() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, true);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertFalse(actualReceiversResult.hasReceivers());
    assertTrue(actualReceiversResult.receivers().isEmpty());
    assertEquals(
        actualReceiversResult.location().toHighestLocation().toHighestLocation(),
        actualReceiversResult.location().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, boolean)} with {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return receivers size is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, boolean) with 'int', 'boolean'; then return receivers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, boolean)"})
  void testReceiversWithIntBoolean_thenReturnReceiversSizeIsOne() {
    // Arrange
    Player player = mock(Player.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(player.getLocation()).thenReturn(location);

    ArrayList<Player> playerList = new ArrayList<>();
    playerList.add(player);

    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(playerList);
    Location location2 = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location2);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, true);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    verify(player).getLocation();
    assertEquals(1, actualReceiversResult.receivers().size());
    assertTrue(actualReceiversResult.hasReceivers());
    assertEquals(
        actualReceiversResult.location().toHighestLocation().toHighestLocation(),
        actualReceiversResult.location().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName("Test receivers(int, int, boolean) with 'int', 'int', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, 1, false);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertEquals(
        actualReceiversResult.location().toHighestLocation().toHighestLocation(),
        actualReceiversResult.location().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName("Test receivers(int, int, boolean) with 'int', 'int', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean2() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenThrow(new IllegalStateException());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> particleBuilder.receivers(1, 1, true));
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, boolean) with 'int', 'int', 'boolean'; given ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean_givenParticleBuilderWithParticleIsPoof() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ParticleBuilder(Particle.POOF).receivers(1, 1, true));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, boolean) with 'int', 'int', 'boolean'; given ParticleBuilder(Particle) with particle is 'POOF'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean_givenParticleBuilderWithParticleIsPoof_whenFalse() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ParticleBuilder(Particle.POOF).receivers(1, 1, false));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <ul>
   *   <li>Given {@link Player} {@link Player#getLocation()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, boolean) with 'int', 'int', 'boolean'; given Player getLocation() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean_givenPlayerGetLocationThrowIllegalStateException() {
    // Arrange
    Player player = mock(Player.class);
    when(player.getLocation()).thenThrow(new IllegalStateException());

    ArrayList<Player> playerList = new ArrayList<>();
    playerList.add(player);

    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(playerList);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> particleBuilder.receivers(1, 1, true));
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    verify(player).getLocation();
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <ul>
   *   <li>Then return not hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, boolean) with 'int', 'int', 'boolean'; then return not hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean_thenReturnNotHasReceivers() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, 1, true);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertFalse(actualReceiversResult.hasReceivers());
    assertTrue(actualReceiversResult.receivers().isEmpty());
    assertEquals(
        actualReceiversResult.location().toHighestLocation().toHighestLocation(),
        actualReceiversResult.location().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, boolean)} with {@code int}, {@code int}, {@code
   * boolean}.
   *
   * <ul>
   *   <li>Then return receivers size is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, boolean) with 'int', 'int', 'boolean'; then return receivers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, boolean)"})
  void testReceiversWithIntIntBoolean_thenReturnReceiversSizeIsOne() {
    // Arrange
    Player player = mock(Player.class);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    when(player.getLocation()).thenReturn(location);

    ArrayList<Player> playerList = new ArrayList<>();
    playerList.add(player);

    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(playerList);
    Location location2 = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location2);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, 1, true);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    verify(player).getLocation();
    assertEquals(1, actualReceiversResult.receivers().size());
    assertTrue(actualReceiversResult.hasReceivers());
    assertEquals(
        actualReceiversResult.location().toHighestLocation().toHighestLocation(),
        actualReceiversResult.location().toHighestLocation().toHighestLocation());
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, int)} with {@code int}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, int) with 'int', 'int', 'int'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, int)"})
  void testReceiversWithIntIntInt_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, 1, 1);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertSame(particleBuilder, actualReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int, int)} with {@code int}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int, int) with 'int', 'int', 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int, int)"})
  void testReceiversWithIntIntInt_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).receivers(1, 1, 1));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int)}
   */
  @Test
  @DisplayName(
      "Test receivers(int, int) with 'int', 'int'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int)"})
  void testReceiversWithIntInt_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1, 1);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertSame(particleBuilder, actualReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int, int)}
   */
  @Test
  @DisplayName("Test receivers(int, int) with 'int', 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int, int)"})
  void testReceiversWithIntInt_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).receivers(1, 1));
  }

  /**
   * Test {@link ParticleBuilder#receivers(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int)}
   */
  @Test
  @DisplayName(
      "Test receivers(int) with 'int'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int)"})
  void testReceiversWithInt_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    World world = mock(World.class);
    when(world.getNearbyPlayers(Mockito.<Location>any(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.location(location);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(1);

    // Assert
    verify(world).getNearbyPlayers(isA(Location.class), eq(1.0d), eq(1.0d), eq(1.0d));
    assertSame(particleBuilder, actualReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(int)}
   */
  @Test
  @DisplayName("Test receivers(int) with 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(int)"})
  void testReceiversWithInt_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).receivers(1));
  }

  /**
   * Test {@link ParticleBuilder#receivers(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}
   *       hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(List)}
   */
  @Test
  @DisplayName(
      "Test receivers(List) with 'List'; then ParticleBuilder(Particle) with particle is 'POOF' hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(List)"})
  void testReceiversWithList_thenParticleBuilderWithParticleIsPoofHasReceivers() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    ArrayList<Player> receivers = new ArrayList<>();
    receivers.add(mock(Player.class));

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers((List<Player>) receivers);

    // Assert
    assertNull(actualReceiversResult.location());
    assertNull(actualReceiversResult.source());
    assertEquals(0.0d, actualReceiversResult.offsetX());
    assertEquals(0.0d, actualReceiversResult.offsetY());
    assertEquals(0.0d, actualReceiversResult.offsetZ());
    assertEquals(1, actualReceiversResult.count());
    assertEquals(1.0d, actualReceiversResult.extra());
    assertEquals(Particle.POOF, actualReceiversResult.particle());
    assertTrue(actualReceiversResult.force());
    assertTrue(particleBuilder.hasReceivers());
    assertTrue(actualReceiversResult.hasReceivers());
    assertEquals(receivers, actualReceiversResult.receivers());
  }

  /**
   * Test {@link ParticleBuilder#receivers(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}
   *       hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(List)}
   */
  @Test
  @DisplayName(
      "Test receivers(List) with 'List'; then ParticleBuilder(Particle) with particle is 'POOF' hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(List)"})
  void testReceiversWithList_thenParticleBuilderWithParticleIsPoofHasReceivers2() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    ArrayList<Player> receivers = new ArrayList<>();
    receivers.add(mock(Player.class));
    receivers.add(mock(Player.class));

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers((List<Player>) receivers);

    // Assert
    assertNull(actualReceiversResult.location());
    assertNull(actualReceiversResult.source());
    assertEquals(0.0d, actualReceiversResult.offsetX());
    assertEquals(0.0d, actualReceiversResult.offsetY());
    assertEquals(0.0d, actualReceiversResult.offsetZ());
    assertEquals(1, actualReceiversResult.count());
    assertEquals(1.0d, actualReceiversResult.extra());
    assertEquals(Particle.POOF, actualReceiversResult.particle());
    assertTrue(actualReceiversResult.force());
    assertTrue(particleBuilder.hasReceivers());
    assertTrue(actualReceiversResult.hasReceivers());
    assertEquals(receivers, actualReceiversResult.receivers());
  }

  /**
   * Test {@link ParticleBuilder#receivers(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(List)}
   */
  @Test
  @DisplayName(
      "Test receivers(List) with 'List'; when 'null'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(List)"})
  void testReceiversWithList_whenNull_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers((List<Player>) null);

    // Assert
    assertFalse(particleBuilder.hasReceivers());
    assertSame(particleBuilder, actualReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(Player[])} with {@code Player[]}.
   *
   * <ul>
   *   <li>Then not {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}
   *       hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(Player[])}
   */
  @Test
  @DisplayName(
      "Test receivers(Player[]) with 'Player[]'; then not ParticleBuilder(Particle) with particle is 'POOF' hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(Player[])"})
  void testReceiversWithPlayer_thenNotParticleBuilderWithParticleIsPoofHasReceivers() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers((Player[]) null);

    // Assert
    assertFalse(particleBuilder.hasReceivers());
    assertSame(particleBuilder, actualReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#receivers(Player[])} with {@code Player[]}.
   *
   * <ul>
   *   <li>When {@link Player}.
   *   <li>Then return location is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#receivers(Player[])}
   */
  @Test
  @DisplayName(
      "Test receivers(Player[]) with 'Player[]'; when Player; then return location is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.receivers(Player[])"})
  void testReceiversWithPlayer_whenPlayer_thenReturnLocationIsNull() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualReceiversResult = particleBuilder.receivers(mock(Player.class));

    // Assert
    assertNull(actualReceiversResult.location());
    assertNull(actualReceiversResult.source());
    assertEquals(0.0d, actualReceiversResult.offsetX());
    assertEquals(0.0d, actualReceiversResult.offsetY());
    assertEquals(0.0d, actualReceiversResult.offsetZ());
    assertEquals(1, actualReceiversResult.count());
    assertEquals(1, actualReceiversResult.receivers().size());
    assertEquals(1.0d, actualReceiversResult.extra());
    assertEquals(Particle.POOF, actualReceiversResult.particle());
    assertTrue(actualReceiversResult.force());
    assertTrue(particleBuilder.hasReceivers());
    assertTrue(actualReceiversResult.hasReceivers());
  }

  /**
   * Test {@link ParticleBuilder#hasReceivers()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Player}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#hasReceivers()}
   */
  @Test
  @DisplayName("Test hasReceivers(); given ArrayList() add Player; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ParticleBuilder.hasReceivers()"})
  void testHasReceivers_givenArrayListAddPlayer_thenReturnTrue() {
    // Arrange
    ArrayList<Player> playerList = new ArrayList<>();
    playerList.add(mock(Player.class));

    World world = mock(World.class);
    when(world.getPlayers()).thenReturn(playerList);
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.receivers((List<Player>) null);
    particleBuilder.location(location);

    // Act
    boolean actualHasReceiversResult = particleBuilder.hasReceivers();

    // Assert
    verify(world).getPlayers();
    assertTrue(actualHasReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#hasReceivers()}.
   *
   * <ul>
   *   <li>Given array of {@link Player} with {@link Player}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#hasReceivers()}
   */
  @Test
  @DisplayName("Test hasReceivers(); given array of Player with Player; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ParticleBuilder.hasReceivers()"})
  void testHasReceivers_givenArrayOfPlayerWithPlayer_thenReturnTrue() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.receivers(mock(Player.class));

    // Act and Assert
    assertTrue(particleBuilder.hasReceivers());
  }

  /**
   * Test {@link ParticleBuilder#hasReceivers()}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#hasReceivers()}
   */
  @Test
  @DisplayName(
      "Test hasReceivers(); given ParticleBuilder(Particle) with particle is 'POOF'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ParticleBuilder.hasReceivers()"})
  void testHasReceivers_givenParticleBuilderWithParticleIsPoof_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ParticleBuilder(Particle.POOF).hasReceivers());
  }

  /**
   * Test {@link ParticleBuilder#hasReceivers()}.
   *
   * <ul>
   *   <li>Given {@link World} {@link World#getPlayers()} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link World#getPlayers()}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#hasReceivers()}
   */
  @Test
  @DisplayName(
      "Test hasReceivers(); given World getPlayers() return ArrayList(); then calls getPlayers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ParticleBuilder.hasReceivers()"})
  void testHasReceivers_givenWorldGetPlayersReturnArrayList_thenCallsGetPlayers() {
    // Arrange
    World world = mock(World.class);
    when(world.getPlayers()).thenReturn(new ArrayList<>());
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.receivers((List<Player>) null);
    particleBuilder.location(location);

    // Act
    boolean actualHasReceiversResult = particleBuilder.hasReceivers();

    // Assert
    verify(world).getPlayers();
    assertFalse(actualHasReceiversResult);
  }

  /**
   * Test {@link ParticleBuilder#location(Location)} with {@code location}.
   *
   * <ul>
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#location(Location)}
   */
  @Test
  @DisplayName(
      "Test location(Location) with 'location'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.location(Location)"})
  void testLocationWithLocation_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    ParticleBuilder actualLocationResult = particleBuilder.location(location);

    // Assert
    assertSame(particleBuilder, actualLocationResult);
  }

  /**
   * Test {@link ParticleBuilder#location(World, double, double, double)} with {@code world}, {@code
   * x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return location World is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#location(World, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test location(World, double, double, double) with 'world', 'x', 'y', 'z'; when 'null'; then return location World is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.location(World, double, double, double)"})
  void testLocationWithWorldXYZ_whenNull_thenReturnLocationWorldIsNull() {
    // Arrange, Act and Assert
    Location locationResult =
        new ParticleBuilder(Particle.POOF).location(null, 2.0d, 3.0d, 10.0d).location();
    assertNull(locationResult.getWorld());
    assertFalse(locationResult.isWorldLoaded());
    Vector direction = locationResult.getDirection();
    BlockVector toBlockVectorResult = direction.toBlockVector();
    assertEquals(toBlockVectorResult.toBlockVector(), toBlockVectorResult.toBlockVector());
    Vector toVectorResult = locationResult.toVector();
    BlockVector toBlockVectorResult2 = toVectorResult.toBlockVector();
    assertEquals(toBlockVectorResult2.toBlockVector(), toBlockVectorResult2.toBlockVector());
    Vector3i toVector3iResult = direction.toVector3i();
    assertEquals(toVector3iResult, toBlockVectorResult.toVector3i());
    Vector3i toVector3iResult2 = toVectorResult.toVector3i();
    assertEquals(toVector3iResult2, toBlockVectorResult2.toVector3i());
    Vector3d toVector3dResult = direction.toVector3d();
    Vector3d actualAbsoluteResult = toVector3dResult.absolute();
    assertSame(toVector3dResult, actualAbsoluteResult);
    Vector3d actualNormalizeResult = toVector3dResult.normalize();
    assertSame(toVector3dResult, actualNormalizeResult);
    Vector3d toVector3dResult2 = toVectorResult.toVector3d();
    Vector3d actualAbsoluteResult2 = toVector3dResult2.absolute();
    assertSame(toVector3dResult2, actualAbsoluteResult2);
    Vector3d actualNormalizeResult2 = toVector3dResult2.normalize();
    assertSame(toVector3dResult2, actualNormalizeResult2);
    Vector3f toVector3fResult = direction.toVector3f();
    Vector3f actualAbsoluteResult3 = toVector3fResult.absolute();
    assertSame(toVector3fResult, actualAbsoluteResult3);
    Vector3f actualCeilResult = toVector3fResult.ceil();
    assertSame(toVector3fResult, actualCeilResult);
    Vector3f actualFloorResult = toVector3fResult.floor();
    assertSame(toVector3fResult, actualFloorResult);
    Vector3f actualNormalizeResult3 = toVector3fResult.normalize();
    assertSame(toVector3fResult, actualNormalizeResult3);
    Vector3f toVector3fResult2 = toVectorResult.toVector3f();
    Vector3f actualAbsoluteResult4 = toVector3fResult2.absolute();
    assertSame(toVector3fResult2, actualAbsoluteResult4);
    Vector3f actualCeilResult2 = toVector3fResult2.ceil();
    assertSame(toVector3fResult2, actualCeilResult2);
    Vector3f actualFloorResult2 = toVector3fResult2.floor();
    assertSame(toVector3fResult2, actualFloorResult2);
    Vector3f actualNormalizeResult4 = toVector3fResult2.normalize();
    assertSame(toVector3fResult2, actualNormalizeResult4);
    Vector3i actualAbsoluteResult5 = toVector3iResult.absolute();
    assertSame(toVector3iResult, actualAbsoluteResult5);
    Vector3i actualAbsoluteResult6 = toVector3iResult2.absolute();
    assertSame(toVector3iResult2, actualAbsoluteResult6);
  }

  /**
   * Test {@link ParticleBuilder#location(World, double, double, double)} with {@code world}, {@code
   * x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When {@link World}.
   *   <li>Then return location Chunk is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#location(World, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test location(World, double, double, double) with 'world', 'x', 'y', 'z'; when World; then return location Chunk is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.location(World, double, double, double)"})
  void testLocationWithWorldXYZ_whenWorld_thenReturnLocationChunkIsNull() {
    // Arrange
    World world = mock(World.class);

    // Act
    ParticleBuilder actualLocationResult =
        new ParticleBuilder(Particle.POOF).location(world, 2.0d, 3.0d, 10.0d);

    // Assert
    Location locationResult = actualLocationResult.location();
    assertNull(locationResult.getChunk());
    assertNull(locationResult.getBlock());
    assertFalse(actualLocationResult.hasReceivers());
    assertSame(world, locationResult.getWorld());
  }

  /**
   * Test {@link ParticleBuilder#offset(double, double, double)}.
   *
   * <p>Method under test: {@link ParticleBuilder#offset(double, double, double)}
   */
  @Test
  @DisplayName("Test offset(double, double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.offset(double, double, double)"})
  void testOffset() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualOffsetResult = particleBuilder.offset(10.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(10.0d, particleBuilder.offsetX());
    assertEquals(10.0d, particleBuilder.offsetY());
    assertEquals(10.0d, particleBuilder.offsetZ());
    assertSame(particleBuilder, actualOffsetResult);
  }

  /**
   * Test {@link ParticleBuilder#color(Color, float)} with {@code Color}, {@code float}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(Color, float)}
   */
  @Test
  @DisplayName("Test color(Color, float) with 'Color', 'float'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(Color, float)"})
  void testColorWithColorFloat_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new ParticleBuilder(Particle.POOF).color(Color.AQUA, 10.0f));
  }

  /**
   * Test {@link ParticleBuilder#color(Color, float)} with {@code Color}, {@code float}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(Color, float)}
   */
  @Test
  @DisplayName(
      "Test color(Color, float) with 'Color', 'float'; when 'null'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(Color, float)"})
  void testColorWithColorFloat_whenNull_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualColorResult = particleBuilder.color(null, 10.0f);

    // Assert
    assertSame(particleBuilder, actualColorResult);
  }

  /**
   * Test {@link ParticleBuilder#color(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(Color)}
   */
  @Test
  @DisplayName("Test color(Color) with 'Color'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(Color)"})
  void testColorWithColor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).color(Color.AQUA));
  }

  /**
   * Test {@link ParticleBuilder#color(Color)} with {@code Color}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code
   *       POOF}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(Color)}
   */
  @Test
  @DisplayName(
      "Test color(Color) with 'Color'; when 'null'; then return ParticleBuilder(Particle) with particle is 'POOF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(Color)"})
  void testColorWithColor_whenNull_thenReturnParticleBuilderWithParticleIsPoof() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);

    // Act
    ParticleBuilder actualColorResult = particleBuilder.color(null);

    // Assert
    assertSame(particleBuilder, actualColorResult);
  }

  /**
   * Test {@link ParticleBuilder#color(int, int, int, int)} with {@code int}, {@code int}, {@code
   * int}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test color(int, int, int, int) with 'int', 'int', 'int', 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(int, int, int, int)"})
  void testColorWithIntIntIntInt_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).color(1, 1, 1, 1));
  }

  /**
   * Test {@link ParticleBuilder#color(int, int, int)} with {@code int}, {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(int, int, int)}
   */
  @Test
  @DisplayName(
      "Test color(int, int, int) with 'int', 'int', 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(int, int, int)"})
  void testColorWithIntIntInt_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).color(1, 1, 1));
  }

  /**
   * Test {@link ParticleBuilder#color(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(int)}
   */
  @Test
  @DisplayName("Test color(int) with 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(int)"})
  void testColorWithInt_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).color(1));
  }

  /**
   * Test {@link ParticleBuilder#color(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#color(int)}
   */
  @Test
  @DisplayName("Test color(int) with 'int'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.color(int)"})
  void testColorWithInt_thenThrowIllegalStateException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new ParticleBuilder(Particle.POOF).color(-1));
  }

  /**
   * Test {@link ParticleBuilder#colorTransition(Color, Color)} with {@code fromColor}, {@code
   * toColor}.
   *
   * <p>Method under test: {@link ParticleBuilder#colorTransition(Color, Color)}
   */
  @Test
  @DisplayName("Test colorTransition(Color, Color) with 'fromColor', 'toColor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.colorTransition(Color, Color)"})
  void testColorTransitionWithFromColorToColor() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.DUST_COLOR_TRANSITION);

    // Act
    ParticleBuilder actualColorTransitionResult =
        particleBuilder.colorTransition(Color.AQUA, Color.AQUA);

    // Assert
    assertSame(particleBuilder, actualColorTransitionResult);
  }

  /**
   * Test {@link ParticleBuilder#colorTransition(Color, Color, float)} with {@code fromColor},
   * {@code toColor}, {@code size}.
   *
   * <p>Method under test: {@link ParticleBuilder#colorTransition(Color, Color, float)}
   */
  @Test
  @DisplayName("Test colorTransition(Color, Color, float) with 'fromColor', 'toColor', 'size'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.colorTransition(Color, Color, float)"})
  void testColorTransitionWithFromColorToColorSize() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.DUST_COLOR_TRANSITION);

    // Act
    ParticleBuilder actualColorTransitionResult =
        particleBuilder.colorTransition(Color.AQUA, Color.AQUA, 10.0f);

    // Assert
    assertSame(particleBuilder, actualColorTransitionResult);
  }

  /**
   * Test {@link ParticleBuilder#colorTransition(int, int)} with {@code fromRgb}, {@code toRgb}.
   *
   * <p>Method under test: {@link ParticleBuilder#colorTransition(int, int)}
   */
  @Test
  @DisplayName("Test colorTransition(int, int) with 'fromRgb', 'toRgb'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.colorTransition(int, int)"})
  void testColorTransitionWithFromRgbToRgb() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.DUST_COLOR_TRANSITION);

    // Act
    ParticleBuilder actualColorTransitionResult = particleBuilder.colorTransition(1, 1);

    // Assert
    assertSame(particleBuilder, actualColorTransitionResult);
  }

  /**
   * Test {@link ParticleBuilder#clone()}.
   *
   * <ul>
   *   <li>Given array of {@link Player} with {@link Player}.
   *   <li>Then return receivers size is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#clone()}
   */
  @Test
  @DisplayName("Test clone(); given array of Player with Player; then return receivers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.clone()"})
  void testClone_givenArrayOfPlayerWithPlayer_thenReturnReceiversSizeIsOne() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    particleBuilder.receivers(mock(Player.class));

    // Act
    ParticleBuilder actualCloneResult = particleBuilder.clone();

    // Assert
    assertNull(actualCloneResult.location());
    assertNull(actualCloneResult.source());
    assertEquals(0.0d, actualCloneResult.offsetX());
    assertEquals(0.0d, actualCloneResult.offsetY());
    assertEquals(0.0d, actualCloneResult.offsetZ());
    assertEquals(1, actualCloneResult.count());
    assertEquals(1, actualCloneResult.receivers().size());
    assertEquals(1.0d, actualCloneResult.extra());
    assertEquals(Particle.POOF, actualCloneResult.particle());
    assertTrue(actualCloneResult.force());
    assertTrue(actualCloneResult.hasReceivers());
  }

  /**
   * Test {@link ParticleBuilder#clone()}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}
   *       receivers {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given ParticleBuilder(Particle) with particle is 'POOF' receivers 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.clone()"})
  void testClone_givenParticleBuilderWithParticleIsPoofReceiversNull() {
    // Arrange
    ParticleBuilder particleBuilder = new ParticleBuilder(Particle.POOF);
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);
    particleBuilder.location(location);
    particleBuilder.receivers((List<Player>) null);

    // Act
    ParticleBuilder actualCloneResult = particleBuilder.clone();

    // Assert
    assertNull(actualCloneResult.receivers());
    assertEquals(location, actualCloneResult.location());
  }

  /**
   * Test {@link ParticleBuilder#clone()}.
   *
   * <ul>
   *   <li>Given {@link ParticleBuilder#ParticleBuilder(Particle)} with particle is {@code POOF}.
   *   <li>Then return not hasReceivers.
   * </ul>
   *
   * <p>Method under test: {@link ParticleBuilder#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given ParticleBuilder(Particle) with particle is 'POOF'; then return not hasReceivers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticleBuilder ParticleBuilder.clone()"})
  void testClone_givenParticleBuilderWithParticleIsPoof_thenReturnNotHasReceivers() {
    // Arrange and Act
    ParticleBuilder actualCloneResult = new ParticleBuilder(Particle.POOF).clone();

    // Assert
    assertNull(actualCloneResult.receivers());
    assertNull(actualCloneResult.location());
    assertNull(actualCloneResult.source());
    assertEquals(0.0d, actualCloneResult.offsetX());
    assertEquals(0.0d, actualCloneResult.offsetY());
    assertEquals(0.0d, actualCloneResult.offsetZ());
    assertEquals(1, actualCloneResult.count());
    assertEquals(1.0d, actualCloneResult.extra());
    assertEquals(Particle.POOF, actualCloneResult.particle());
    assertFalse(actualCloneResult.hasReceivers());
    assertTrue(actualCloneResult.force());
  }
}
