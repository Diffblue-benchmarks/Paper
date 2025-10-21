package ca.spottedleaf.dataconverter.minecraft.versions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ca.spottedleaf.dataconverter.types.MapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class V4309DiffblueTest {
  /**
   * Test {@link V4309#makeBlockPosition(Number, Number, Number)}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with minus one and minus one.
   * </ul>
   *
   * <p>Method under test: {@link V4309#makeBlockPosition(Number, Number, Number)}
   */
  @Test
  @DisplayName(
      "Test makeBlockPosition(Number, Number, Number); then return array of int with minus one and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] V4309.makeBlockPosition(Number, Number, Number)"})
  void testMakeBlockPosition_thenReturnArrayOfIntWithMinusOneAndMinusOne() {
    // Arrange and Act
    int[] actualMakeBlockPositionResult =
        V4309.makeBlockPosition(
            Bootstrap.bootstrapDuration, Bootstrap.bootstrapDuration, Bootstrap.bootstrapDuration);

    // Assert
    assertArrayEquals(new int[] {-1, -1, -1}, actualMakeBlockPositionResult);
  }

  /**
   * Test {@link V4309#convertBlockPosition(MapType, String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Bootstrap#bootstrapDuration}.
   *   <li>Then calls {@link MapType#getNumber(String)}.
   * </ul>
   *
   * <p>Method under test: {@link V4309#convertBlockPosition(MapType, String, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertBlockPosition(MapType, String, String, String, String); given bootstrapDuration; then calls getNumber(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void V4309.convertBlockPosition(MapType, String, String, String, String)"})
  void testConvertBlockPosition_givenBootstrapDuration_thenCallsGetNumber() {
    // Arrange
    MapType data = mock(MapType.class);
    doNothing().when(data).remove(Mockito.<String>any());
    doNothing().when(data).setInts(Mockito.<String>any(), Mockito.<int[]>any());
    when(data.getNumber(Mockito.<String>any())).thenReturn(Bootstrap.bootstrapDuration);

    // Act
    V4309.convertBlockPosition(data, "X Path", "Y Path", "Z Path", "To Path");

    // Assert
    verify(data, atLeast(1)).getNumber(Mockito.<String>any());
    verify(data, atLeast(1)).remove(Mockito.<String>any());
    verify(data).setInts(eq("To Path"), isA(int[].class));
  }
}
