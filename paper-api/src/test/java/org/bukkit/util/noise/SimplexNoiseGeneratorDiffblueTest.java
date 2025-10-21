package org.bukkit.util.noise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Random;
import org.bukkit.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimplexNoiseGeneratorDiffblueTest {
  /**
   * Test {@link SimplexNoiseGenerator#SimplexNoiseGenerator()}.
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#SimplexNoiseGenerator()}
   */
  @Test
  @DisplayName("Test new SimplexNoiseGenerator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexNoiseGenerator.<init>()"})
  void testNewSimplexNoiseGenerator() {
    // Arrange and Act
    SimplexNoiseGenerator actualSimplexNoiseGenerator = new SimplexNoiseGenerator();

    // Assert
    assertEquals(0.0d, actualSimplexNoiseGenerator.offsetX);
    assertEquals(0.0d, actualSimplexNoiseGenerator.offsetY);
    assertEquals(0.0d, actualSimplexNoiseGenerator.offsetZ);
    assertEquals(0.0d, actualSimplexNoiseGenerator.offsetW);
    assertEquals(512, actualSimplexNoiseGenerator.perm.length);
  }

  /**
   * Test {@link SimplexNoiseGenerator#SimplexNoiseGenerator(long)}.
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#SimplexNoiseGenerator(long)}
   */
  @Test
  @DisplayName("Test new SimplexNoiseGenerator(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexNoiseGenerator.<init>(long)"})
  void testNewSimplexNoiseGenerator2() {
    // Arrange and Act
    SimplexNoiseGenerator actualSimplexNoiseGenerator = new SimplexNoiseGenerator(42L);

    // Assert
    assertEquals(174.90520877052043d, actualSimplexNoiseGenerator.offsetY);
    assertEquals(186.25630208841423d, actualSimplexNoiseGenerator.offsetX);
    assertEquals(512, actualSimplexNoiseGenerator.perm.length);
    assertEquals(74.30495038659771d, actualSimplexNoiseGenerator.offsetW);
    assertEquals(79.0321805651609d, actualSimplexNoiseGenerator.offsetZ);
  }

  /**
   * Test {@link SimplexNoiseGenerator#SimplexNoiseGenerator(Random)}.
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#SimplexNoiseGenerator(Random)}
   */
  @Test
  @DisplayName("Test new SimplexNoiseGenerator(Random)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexNoiseGenerator.<init>(Random)"})
  void testNewSimplexNoiseGenerator3() {
    // Arrange, Act and Assert
    assertEquals(512, new SimplexNoiseGenerator(new Random()).perm.length);
  }

  /**
   * Test {@link SimplexNoiseGenerator#SimplexNoiseGenerator(World)}.
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#SimplexNoiseGenerator(World)}
   */
  @Test
  @DisplayName("Test new SimplexNoiseGenerator(World)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplexNoiseGenerator.<init>(World)"})
  void testNewSimplexNoiseGenerator4() {
    // Arrange
    World world = mock(World.class);
    when(world.getSeed()).thenReturn(42L);

    // Act
    SimplexNoiseGenerator actualSimplexNoiseGenerator = new SimplexNoiseGenerator(world);

    // Assert
    verify(world).getSeed();
    assertEquals(174.90520877052043d, actualSimplexNoiseGenerator.offsetY);
    assertEquals(186.25630208841423d, actualSimplexNoiseGenerator.offsetX);
    assertEquals(512, actualSimplexNoiseGenerator.perm.length);
    assertEquals(74.30495038659771d, actualSimplexNoiseGenerator.offsetW);
    assertEquals(79.0321805651609d, actualSimplexNoiseGenerator.offsetZ);
  }

  /**
   * Test {@link SimplexNoiseGenerator#dot(int[], double, double, double, double)} with {@code g},
   * {@code x}, {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#dot(int[], double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test dot(int[], double, double, double, double) with 'g', 'x', 'y', 'z', 'w'; when array of int with one and minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.dot(int[], double, double, double, double)"})
  void testDotWithGXYZW_whenArrayOfIntWithOneAndMinusOne_thenReturnMinusOne() {
    // Arrange and Act
    double actualDotResult =
        SimplexNoiseGenerator.dot(new int[] {1, -1, 1, -1}, 2.0d, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(-1.0d, actualDotResult);
  }

  /**
   * Test {@link SimplexNoiseGenerator#dot(int[], double, double, double)} with {@code g}, {@code
   * x}, {@code y}, {@code z}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and minus one.
   *   <li>Then return nine.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#dot(int[], double, double, double)}
   */
  @Test
  @DisplayName(
      "Test dot(int[], double, double, double) with 'g', 'x', 'y', 'z'; when array of int with one and minus one; then return nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.dot(int[], double, double, double)"})
  void testDotWithGXYZ_whenArrayOfIntWithOneAndMinusOne_thenReturnNine() {
    // Arrange and Act
    double actualDotResult = SimplexNoiseGenerator.dot(new int[] {1, -1, 1, -1}, 2.0d, 3.0d, 10.0d);

    // Assert
    assertEquals(9.0d, actualDotResult);
  }

  /**
   * Test {@link SimplexNoiseGenerator#dot(int[], double, double)} with {@code g}, {@code x}, {@code
   * y}.
   *
   * <ul>
   *   <li>When array of {@code int} with one and minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#dot(int[], double, double)}
   */
  @Test
  @DisplayName(
      "Test dot(int[], double, double) with 'g', 'x', 'y'; when array of int with one and minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.dot(int[], double, double)"})
  void testDotWithGXY_whenArrayOfIntWithOneAndMinusOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0d, SimplexNoiseGenerator.dot(new int[] {1, -1, 1, -1}, 2.0d, 3.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code 0.10775160304331897}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '-0.5'; then return '0.10775160304331897'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when05_thenReturn010775160304331897() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(-0.5d, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.10775160304331897d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 9.725424859373685}.
   *   <li>Then return {@code 0.02843029011496447}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '9.725424859373685'; then return '0.02843029011496447'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when9725424859373685_thenReturn002843029011496447() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(9.725424859373685d, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.02843029011496447d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 9.725424859373685}.
   *   <li>Then return {@code 0.3960214882759161}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '9.725424859373685'; then return '0.3960214882759161'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when9725424859373685_thenReturn03960214882759161() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(2.0d, 3.0d, 9.725424859373685d, 10.0d);

    // Assert
    assertEquals(0.3960214882759161d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 9.725424859373685}.
   *   <li>Then return {@code 0.09235640031918549}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '9.725424859373685'; then return '0.09235640031918549'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when9725424859373685_thenReturn009235640031918549() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(2.0d, 3.0d, 10.0d, 9.725424859373685d);

    // Assert
    assertEquals(0.09235640031918549d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 10.725424859373685}.
   *   <li>Then return {@code -0.4722768104151813}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '10.725424859373685'; then return '-0.4722768104151813'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when10725424859373685_thenReturn04722768104151813() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(10.725424859373685d, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(-0.4722768104151813d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 10.725424859373685}.
   *   <li>Then return {@code 0.42732825514094486}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '10.725424859373685'; then return '0.42732825514094486'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when10725424859373685_thenReturn042732825514094486() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(2.0d, 10.725424859373685d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.42732825514094486d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 17.725424859373685}.
   *   <li>Then return {@code -0.20617678886870844}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '17.725424859373685'; then return '-0.20617678886870844'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when17725424859373685_thenReturn020617678886870844() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(2.0d, 3.0d, 17.725424859373685d, 10.0d);

    // Assert
    assertEquals(-0.20617678886870844d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 17.725424859373685}.
   *   <li>Then return {@code -0.47322780286493626}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '17.725424859373685'; then return '-0.47322780286493626'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_when17725424859373685_thenReturn047322780286493626() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(17.725424859373685d, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(-0.47322780286493626d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_whenNaN_thenReturnNaN() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(Double.NaN, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(Double.NaN, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double, double)} with {@code x},
   * {@code y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 0.290253431076334}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double, double) with 'x', 'y', 'z', 'w'; when two; then return '0.290253431076334'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double, double)"})
  void testGetNoiseWithXYZW_whenTwo_thenReturn0290253431076334() {
    // Arrange and Act
    double actualNoise = SimplexNoiseGenerator.getNoise(2.0d, 3.0d, 10.0d, 10.0d);

    // Assert
    assertEquals(0.290253431076334d, actualNoise);
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.3333333333333333}.
   *   <li>Then return {@code 0.7600579688055679}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '0.3333333333333333'; then return '0.7600579688055679'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when03333333333333333_thenReturn07600579688055679() {
    // Arrange, Act and Assert
    assertEquals(
        0.7600579688055679d, SimplexNoiseGenerator.getNoise(10.0d, 0.3333333333333333d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.3333333333333333}.
   *   <li>Then return {@code 0.011993923690494429}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '0.3333333333333333'; then return '0.011993923690494429'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when03333333333333333_thenReturn0011993923690494429() {
    // Arrange, Act and Assert
    assertEquals(
        0.011993923690494429d, SimplexNoiseGenerator.getNoise(0.3333333333333333d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 7.111111111111112}.
   *   <li>Then return {@code 0.6008904053156557}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '7.111111111111112'; then return '0.6008904053156557'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when7111111111111112_thenReturn06008904053156557() {
    // Arrange, Act and Assert
    assertEquals(
        0.6008904053156557d,
        SimplexNoiseGenerator.getNoise(0.3333333333333333d, 10.0d, 7.111111111111112d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 7.111111111111112}.
   *   <li>Then return {@code 0.30117721385097035}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '7.111111111111112'; then return '0.30117721385097035'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when7111111111111112_thenReturn030117721385097035() {
    // Arrange, Act and Assert
    assertEquals(
        0.30117721385097035d,
        SimplexNoiseGenerator.getNoise(0.3333333333333333d, 7.111111111111112d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.16666666666666666}.
   *   <li>Then return {@code 0.4671910684346916}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '0.16666666666666666'; then return '0.4671910684346916'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when016666666666666666_thenReturn04671910684346916() {
    // Arrange, Act and Assert
    assertEquals(
        0.4671910684346916d, SimplexNoiseGenerator.getNoise(0.16666666666666666d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.16666666666666666}.
   *   <li>Then return {@code 0.9386473555860407}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '0.16666666666666666'; then return '0.9386473555860407'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when016666666666666666_thenReturn09386473555860407() {
    // Arrange, Act and Assert
    assertEquals(
        0.9386473555860407d, SimplexNoiseGenerator.getNoise(10.0d, 10.0d, 0.16666666666666666d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.16666666666666666}.
   *   <li>Then return {@code 0.46150164101000823}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when '0.16666666666666666'; then return '0.46150164101000823'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_when016666666666666666_thenReturn046150164101000823() {
    // Arrange, Act and Assert
    assertEquals(
        0.46150164101000823d, SimplexNoiseGenerator.getNoise(10.0d, 0.16666666666666666d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, SimplexNoiseGenerator.getNoise(Double.NaN, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_whenTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SimplexNoiseGenerator.getNoise(10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double, double)} with {@code xin}, {@code
   * yin}, {@code zin}.
   *
   * <ul>
   *   <li>When twenty.
   *   <li>Then return {@code -0.10787818930040409}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double, double) with 'xin', 'yin', 'zin'; when twenty; then return '-0.10787818930040409'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double, double)"})
  void testGetNoiseWithXinYinZin_whenTwenty_thenReturn010787818930040409() {
    // Arrange, Act and Assert
    assertEquals(-0.10787818930040409d, SimplexNoiseGenerator.getNoise(20.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code -0.5509476169637227}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double) with 'xin', 'yin'; when '0.5'; then return '-0.5509476169637227'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXinYin_when05_thenReturn05509476169637227() {
    // Arrange, Act and Assert
    assertEquals(-0.5509476169637227d, SimplexNoiseGenerator.getNoise(0.5d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When {@code 17.32050807568877}.
   *   <li>Then return {@code -0.5486144786665645}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double) with 'xin', 'yin'; when '17.32050807568877'; then return '-0.5486144786665645'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXinYin_when1732050807568877_thenReturn05486144786665645() {
    // Arrange, Act and Assert
    assertEquals(-0.5486144786665645d, SimplexNoiseGenerator.getNoise(17.32050807568877d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When {@code 0.18504542377636213}.
   *   <li>Then return {@code 0.03934676562704267}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double) with 'xin', 'yin'; when '0.18504542377636213'; then return '0.03934676562704267'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXinYin_when018504542377636213_thenReturn003934676562704267() {
    // Arrange, Act and Assert
    assertEquals(0.03934676562704267d, SimplexNoiseGenerator.getNoise(0.18504542377636213d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName("Test getNoise(double, double) with 'xin', 'yin'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXinYin_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, SimplexNoiseGenerator.getNoise(Double.NaN, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code -0.4865928797511877}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double) with 'xin', 'yin'; when ten; then return '-0.4865928797511877'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXinYin_whenTen_thenReturn04865928797511877() {
    // Arrange, Act and Assert
    assertEquals(-0.4865928797511877d, SimplexNoiseGenerator.getNoise(10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When twenty.
   *   <li>Then return {@code 0.6325484584469009}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double, double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double, double) with 'xin', 'yin'; when twenty; then return '0.6325484584469009'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double, double)"})
  void testGetNoiseWithXinYin_whenTwenty_thenReturn06325484584469009() {
    // Arrange, Act and Assert
    assertEquals(0.6325484584469009d, SimplexNoiseGenerator.getNoise(17.32050807568877d, 20.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.6194139917695471}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName("Test getNoise(double) with 'xin'; when '-0.5'; then return '-0.6194139917695471'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_when05_thenReturn06194139917695471() {
    // Arrange, Act and Assert
    assertEquals(-0.6194139917695471d, SimplexNoiseGenerator.getNoise(-0.5d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When {@code 0.3333333333333333}.
   *   <li>Then return {@code 0.690109627597419}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double) with 'xin'; when '0.3333333333333333'; then return '0.690109627597419'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_when03333333333333333_thenReturn0690109627597419() {
    // Arrange, Act and Assert
    assertEquals(0.690109627597419d, SimplexNoiseGenerator.getNoise(0.3333333333333333d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When {@code -0.06666666666666643}.
   *   <li>Then return {@code -0.2683785735621594}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double) with 'xin'; when '-0.06666666666666643'; then return '-0.2683785735621594'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_when006666666666666643_thenReturn02683785735621594() {
    // Arrange, Act and Assert
    assertEquals(-0.2683785735621594d, SimplexNoiseGenerator.getNoise(-0.06666666666666643d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When {@code 13.333333333333332}.
   *   <li>Then return {@code -0.18897427221460178}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double) with 'xin'; when '13.333333333333332'; then return '-0.18897427221460178'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_when13333333333333332_thenReturn018897427221460178() {
    // Arrange, Act and Assert
    assertEquals(-0.18897427221460178d, SimplexNoiseGenerator.getNoise(13.333333333333332d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When {@code 0.16666666666666666}.
   *   <li>Then return {@code 0.5734177157953562}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName(
      "Test getNoise(double) with 'xin'; when '0.16666666666666666'; then return '0.5734177157953562'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_when016666666666666666_thenReturn05734177157953562() {
    // Arrange, Act and Assert
    assertEquals(0.5734177157953562d, SimplexNoiseGenerator.getNoise(0.16666666666666666d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName("Test getNoise(double) with 'xin'; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, SimplexNoiseGenerator.getNoise(Double.NaN));
  }

  /**
   * Test {@link SimplexNoiseGenerator#getNoise(double)} with {@code xin}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code -0.652221399176956}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getNoise(double)}
   */
  @Test
  @DisplayName("Test getNoise(double) with 'xin'; when ten; then return '-0.652221399176956'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.getNoise(double)"})
  void testGetNoiseWithXin_whenTen_thenReturn0652221399176956() {
    // Arrange, Act and Assert
    assertEquals(-0.652221399176956d, SimplexNoiseGenerator.getNoise(10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; given Instance; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_givenInstance_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(
        Double.NaN, SimplexNoiseGenerator.getInstance().noise(Double.NaN, 3.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When two.
   *   <li>Then return {@code 0.290253431076334}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; given Instance; when two; then return '0.290253431076334'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_givenInstance_whenTwo_thenReturn0290253431076334() {
    // Arrange, Act and Assert
    assertEquals(
        0.290253431076334d, SimplexNoiseGenerator.getInstance().noise(2.0d, 3.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>Then return {@code 0.022992113551095508}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; then return '0.022992113551095508'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_thenReturn0022992113551095508() {
    // Arrange, Act and Assert
    assertEquals(
        0.022992113551095508d,
        new SimplexNoiseGenerator(42L).noise(2.0d, 10.725424859373685d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>Then return {@code 0.46341559385533015}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; then return '0.46341559385533015'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_thenReturn046341559385533015() {
    // Arrange, Act and Assert
    assertEquals(
        0.46341559385533015d, new SimplexNoiseGenerator(42L).noise(2.0d, 3.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 9.725424859373685}.
   *   <li>Then return {@code 0.02843029011496447}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '9.725424859373685'; then return '0.02843029011496447'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_when9725424859373685_thenReturn002843029011496447() {
    // Arrange, Act and Assert
    assertEquals(
        0.02843029011496447d,
        SimplexNoiseGenerator.getInstance().noise(9.725424859373685d, 3.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 10.725424859373685}.
   *   <li>Then return {@code -0.4722768104151813}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '10.725424859373685'; then return '-0.4722768104151813'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_when10725424859373685_thenReturn04722768104151813() {
    // Arrange, Act and Assert
    assertEquals(
        -0.4722768104151813d,
        SimplexNoiseGenerator.getInstance().noise(10.725424859373685d, 3.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 10.725424859373685}.
   *   <li>Then return {@code 0.42732825514094486}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '10.725424859373685'; then return '0.42732825514094486'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_when10725424859373685_thenReturn042732825514094486() {
    // Arrange, Act and Assert
    assertEquals(
        0.42732825514094486d,
        SimplexNoiseGenerator.getInstance().noise(2.0d, 10.725424859373685d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 17.725424859373685}.
   *   <li>Then return {@code -0.20617678886870844}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '17.725424859373685'; then return '-0.20617678886870844'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_when17725424859373685_thenReturn020617678886870844() {
    // Arrange, Act and Assert
    assertEquals(
        -0.20617678886870844d,
        SimplexNoiseGenerator.getInstance().noise(2.0d, 3.0d, 17.725424859373685d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double, double)} with {@code x}, {@code
   * y}, {@code z}, {@code w}.
   *
   * <ul>
   *   <li>When {@code 17.725424859373685}.
   *   <li>Then return {@code -0.47322780286493626}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double, double) with 'x', 'y', 'z', 'w'; when '17.725424859373685'; then return '-0.47322780286493626'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double, double)"})
  void testNoiseWithXYZW_when17725424859373685_thenReturn047322780286493626() {
    // Arrange, Act and Assert
    assertEquals(
        -0.47322780286493626d,
        SimplexNoiseGenerator.getInstance().noise(17.725424859373685d, 3.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; given Instance; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_givenInstance_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, SimplexNoiseGenerator.getInstance().noise(Double.NaN, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; given Instance; when ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_givenInstance_whenTen_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SimplexNoiseGenerator.getInstance().noise(10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When twenty.
   *   <li>Then return {@code -0.10787818930040409}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; given Instance; when twenty; then return '-0.10787818930040409'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_givenInstance_whenTwenty_thenReturn010787818930040409() {
    // Arrange, Act and Assert
    assertEquals(
        -0.10787818930040409d, SimplexNoiseGenerator.getInstance().noise(20.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>Then return {@code -0.2927647317766138}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; then return '-0.2927647317766138'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_thenReturn02927647317766138() {
    // Arrange, Act and Assert
    assertEquals(-0.2927647317766138d, new SimplexNoiseGenerator(42L).noise(10.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>Then return {@code 0.031866389461608385}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; then return '0.031866389461608385'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_thenReturn0031866389461608385() {
    // Arrange, Act and Assert
    assertEquals(
        0.031866389461608385d,
        new SimplexNoiseGenerator(42L).noise(0.3333333333333333d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.3333333333333333}.
   *   <li>Then return {@code 0.011993923690494429}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; when '0.3333333333333333'; then return '0.011993923690494429'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_when03333333333333333_thenReturn0011993923690494429() {
    // Arrange, Act and Assert
    assertEquals(
        0.011993923690494429d,
        SimplexNoiseGenerator.getInstance().noise(0.3333333333333333d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>When {@code 7.111111111111112}.
   *   <li>Then return {@code 0.30117721385097035}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; when '7.111111111111112'; then return '0.30117721385097035'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_when7111111111111112_thenReturn030117721385097035() {
    // Arrange, Act and Assert
    assertEquals(
        0.30117721385097035d,
        SimplexNoiseGenerator.getInstance().noise(0.3333333333333333d, 7.111111111111112d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.16666666666666666}.
   *   <li>Then return {@code 0.4671910684346916}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; when '0.16666666666666666'; then return '0.4671910684346916'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_when016666666666666666_thenReturn04671910684346916() {
    // Arrange, Act and Assert
    assertEquals(
        0.4671910684346916d,
        SimplexNoiseGenerator.getInstance().noise(0.16666666666666666d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>When {@code 0.16666666666666666}.
   *   <li>Then return {@code 0.9386473555860407}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; when '0.16666666666666666'; then return '0.9386473555860407'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_when016666666666666666_thenReturn09386473555860407() {
    // Arrange, Act and Assert
    assertEquals(
        0.9386473555860407d,
        SimplexNoiseGenerator.getInstance().noise(10.0d, 10.0d, 0.16666666666666666d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double, double)} with {@code xin}, {@code yin},
   * {@code zin}.
   *
   * <ul>
   *   <li>When twenty.
   *   <li>Then return {@code -0.7882127969279723}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double, double) with 'xin', 'yin', 'zin'; when twenty; then return '-0.7882127969279723'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double, double)"})
  void testNoiseWithXinYinZin_whenTwenty_thenReturn07882127969279723() {
    // Arrange, Act and Assert
    assertEquals(-0.7882127969279723d, new SimplexNoiseGenerator(42L).noise(20.0d, 10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code -0.5509476169637227}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'xin', 'yin'; given Instance; when '0.5'; then return '-0.5509476169637227'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_givenInstance_when05_thenReturn05509476169637227() {
    // Arrange, Act and Assert
    assertEquals(-0.5509476169637227d, SimplexNoiseGenerator.getInstance().noise(0.5d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link Double#NaN}.
   *   <li>Then return {@link Double#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'xin', 'yin'; given Instance; when NaN; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_givenInstance_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, SimplexNoiseGenerator.getInstance().noise(Double.NaN, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When ten.
   *   <li>Then return {@code -0.4865928797511877}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'xin', 'yin'; given Instance; when ten; then return '-0.4865928797511877'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_givenInstance_whenTen_thenReturn04865928797511877() {
    // Arrange, Act and Assert
    assertEquals(-0.4865928797511877d, SimplexNoiseGenerator.getInstance().noise(10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>Then return {@code 0.04362248597803256}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double) with 'xin', 'yin'; then return '0.04362248597803256'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_thenReturn004362248597803256() {
    // Arrange, Act and Assert
    assertEquals(0.04362248597803256d, new SimplexNoiseGenerator(42L).noise(10.0d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>Then return {@code 0.5467962069377263}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName("Test noise(double, double) with 'xin', 'yin'; then return '0.5467962069377263'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_thenReturn05467962069377263() {
    // Arrange, Act and Assert
    assertEquals(0.5467962069377263d, new SimplexNoiseGenerator(42L).noise(0.5d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When {@code 17.32050807568877}.
   *   <li>Then return {@code -0.5486144786665645}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'xin', 'yin'; when '17.32050807568877'; then return '-0.5486144786665645'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_when1732050807568877_thenReturn05486144786665645() {
    // Arrange, Act and Assert
    assertEquals(
        -0.5486144786665645d, SimplexNoiseGenerator.getInstance().noise(17.32050807568877d, 10.0d));
  }

  /**
   * Test {@link SimplexNoiseGenerator#noise(double, double)} with {@code xin}, {@code yin}.
   *
   * <ul>
   *   <li>When {@code 0.18504542377636213}.
   *   <li>Then return {@code 0.03934676562704267}.
   * </ul>
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#noise(double, double)}
   */
  @Test
  @DisplayName(
      "Test noise(double, double) with 'xin', 'yin'; when '0.18504542377636213'; then return '0.03934676562704267'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double SimplexNoiseGenerator.noise(double, double)"})
  void testNoiseWithXinYin_when018504542377636213_thenReturn003934676562704267() {
    // Arrange, Act and Assert
    assertEquals(
        0.03934676562704267d,
        SimplexNoiseGenerator.getInstance().noise(0.18504542377636213d, 10.0d));
  }

  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link SimplexNoiseGenerator#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimplexNoiseGenerator SimplexNoiseGenerator.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SimplexNoiseGenerator actualInstance = SimplexNoiseGenerator.getInstance();
    SimplexNoiseGenerator actualInstance2 = actualInstance.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance2);
  }
}
