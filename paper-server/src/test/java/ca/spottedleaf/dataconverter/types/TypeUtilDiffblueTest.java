package ca.spottedleaf.dataconverter.types;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.nbt.ByteTag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class TypeUtilDiffblueTest {
  /**
   * Test {@link TypeUtil#convertBaseToBase(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>When {@link ByteTag#ONE}.
   *   <li>Then calls {@link TypeUtil#genericToBase(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TypeUtil#convertBaseToBase(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertBaseToBase(Object, TypeUtil); when ONE; then calls genericToBase(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TypeUtil.convertBaseToBase(Object, TypeUtil)"})
  void testConvertBaseToBase_whenOne_thenCallsGenericToBase() {
    // Arrange
    TypeUtil<Object> resultTo = mock(TypeUtil.class);
    when(resultTo.genericToBase(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Types.NBT.convertBaseToBase(ByteTag.ONE, resultTo);

    // Assert
    verify(resultTo).genericToBase(isA(Object.class));
  }

  /**
   * Test {@link TypeUtil#convertGenericToBase(Object, TypeUtil)}.
   *
   * <ul>
   *   <li>Given {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link TypeUtil#genericToBase(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TypeUtil#convertGenericToBase(Object, TypeUtil)}
   */
  @Test
  @DisplayName(
      "Test convertGenericToBase(Object, TypeUtil); given WILDCARD_OBJECT; when '42'; then calls genericToBase(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TypeUtil.convertGenericToBase(Object, TypeUtil)"})
  void testConvertGenericToBase_givenWildcard_object_when42_thenCallsGenericToBase() {
    // Arrange
    TypeUtil<Object> resultTo = mock(TypeUtil.class);
    when(resultTo.genericToBase(Mockito.<Object>any()))
        .thenReturn(ConfigurationTransformation.WILDCARD_OBJECT);

    // Act
    Types.NBT.convertGenericToBase("42", resultTo);

    // Assert
    verify(resultTo).genericToBase(isA(Object.class));
  }
}
