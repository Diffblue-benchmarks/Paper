package org.bukkit.util.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Map;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BukkitObjectOutputStreamDiffblueTest {
  /**
   * Test {@link BukkitObjectOutputStream#replaceObject(Object)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link World} {@link World#getName()} return {@code Name}.
   *   <li>Then return {@link Wrapper#map} size is seven.
   * </ul>
   *
   * <p>Method under test: {@link BukkitObjectOutputStream#replaceObject(Object)}
   */
  @Test
  @DisplayName(
      "Test replaceObject(Object); given 'Name'; when World getName() return 'Name'; then return map size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BukkitObjectOutputStream.replaceObject(Object)"})
  void testReplaceObject_givenName_whenWorldGetNameReturnName_thenReturnMapSizeIsSeven()
      throws IOException, SecurityException {
    // Arrange
    BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream();

    World world = mock(World.class);
    when(world.getName()).thenReturn("Name");
    Location location = new Location(world, 2.0d, 3.0d, 10.0d);

    // Act
    Object actualReplaceObjectResult = bukkitObjectOutputStream.replaceObject(location);

    // Assert
    verify(world).getName();
    Object object = ((Wrapper) actualReplaceObjectResult).map;
    assertTrue(object instanceof Map);
    assertTrue(actualReplaceObjectResult instanceof Wrapper);
    assertEquals(7, ((Map<String, Object>) object).size());
    assertEquals("Name", ((Map<String, Object>) object).get("world"));
    assertEquals("org.bukkit.Location", ((Map<String, Object>) object).get("=="));
    assertEquals(0.0f, ((Float) ((Map<String, Object>) object).get("pitch")).floatValue());
    assertEquals(10.0d, ((Double) ((Map<String, Object>) object).get("z")).doubleValue());
    assertEquals(2.0d, ((Double) ((Map<String, Object>) object).get("x")).doubleValue());
    assertEquals(3.0d, ((Double) ((Map<String, Object>) object).get("y")).doubleValue());
  }

  /**
   * Test {@link BukkitObjectOutputStream#replaceObject(Object)}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   *   <li>Then return {@link Wrapper#map} {@code BLUE} intValue is two hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link BukkitObjectOutputStream#replaceObject(Object)}
   */
  @Test
  @DisplayName(
      "Test replaceObject(Object); when AQUA; then return map 'BLUE' intValue is two hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BukkitObjectOutputStream.replaceObject(Object)"})
  void testReplaceObject_whenAqua_thenReturnMapBlueIntValueIsTwoHundredFiftyFive()
      throws IOException, SecurityException {
    // Arrange and Act
    Object actualReplaceObjectResult = new BukkitObjectOutputStream().replaceObject(Color.AQUA);

    // Assert
    Object object = ((Wrapper) actualReplaceObjectResult).map;
    assertTrue(object instanceof Map);
    assertTrue(actualReplaceObjectResult instanceof Wrapper);
    assertEquals(5, ((Map<String, Object>) object).size());
    assertEquals("Color", ((Map<String, Object>) object).get("=="));
    assertEquals(0, ((Integer) ((Map<String, Object>) object).get("RED")).intValue());
    assertEquals(255, ((Integer) ((Map<String, Object>) object).get("ALPHA")).intValue());
    assertEquals(255, ((Integer) ((Map<String, Object>) object).get("BLUE")).intValue());
    assertEquals(255, ((Integer) ((Map<String, Object>) object).get("GREEN")).intValue());
  }

  /**
   * Test {@link BukkitObjectOutputStream#replaceObject(Object)}.
   *
   * <ul>
   *   <li>When {@link Color#BLACK}.
   *   <li>Then return {@link Wrapper#map} {@code BLUE} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link BukkitObjectOutputStream#replaceObject(Object)}
   */
  @Test
  @DisplayName("Test replaceObject(Object); when BLACK; then return map 'BLUE' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BukkitObjectOutputStream.replaceObject(Object)"})
  void testReplaceObject_whenBlack_thenReturnMapBlueIntValueIsZero()
      throws IOException, SecurityException {
    // Arrange and Act
    Object actualReplaceObjectResult = new BukkitObjectOutputStream().replaceObject(Color.BLACK);

    // Assert
    Object object = ((Wrapper) actualReplaceObjectResult).map;
    assertTrue(object instanceof Map);
    assertTrue(actualReplaceObjectResult instanceof Wrapper);
    assertEquals(5, ((Map<String, Object>) object).size());
    assertEquals("Color", ((Map<String, Object>) object).get("=="));
    assertEquals(0, ((Integer) ((Map<String, Object>) object).get("BLUE")).intValue());
    assertEquals(0, ((Integer) ((Map<String, Object>) object).get("GREEN")).intValue());
    assertEquals(0, ((Integer) ((Map<String, Object>) object).get("RED")).intValue());
    assertEquals(255, ((Integer) ((Map<String, Object>) object).get("ALPHA")).intValue());
  }

  /**
   * Test {@link BukkitObjectOutputStream#replaceObject(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitObjectOutputStream#replaceObject(Object)}
   */
  @Test
  @DisplayName("Test replaceObject(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BukkitObjectOutputStream.replaceObject(Object)"})
  void testReplaceObject_whenNull_thenReturnNull() throws IOException, SecurityException {
    // Arrange, Act and Assert
    assertNull(new BukkitObjectOutputStream().replaceObject(null));
  }

  /**
   * Test {@link BukkitObjectOutputStream#replaceObject(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code Obj}.
   * </ul>
   *
   * <p>Method under test: {@link BukkitObjectOutputStream#replaceObject(Object)}
   */
  @Test
  @DisplayName("Test replaceObject(Object); when 'Obj'; then return 'Obj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BukkitObjectOutputStream.replaceObject(Object)"})
  void testReplaceObject_whenObj_thenReturnObj() throws IOException, SecurityException {
    // Arrange, Act and Assert
    assertEquals("Obj", new BukkitObjectOutputStream().replaceObject("Obj"));
  }
}
