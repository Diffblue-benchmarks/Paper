package io.papermc.paper.adventure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec.MapCodecCodec;
import com.mojang.serialization.codecs.KeyDispatchCodec;
import io.papermc.paper.adventure.AdventureCodecs.ClickEventType;
import io.papermc.paper.adventure.AdventureCodecs.ComponentType;
import io.papermc.paper.adventure.AdventureCodecs.DataSourceType;
import io.papermc.paper.adventure.AdventureCodecs.HoverEventType;
import io.papermc.paper.adventure.AdventureCodecs.NbtComponentDataSource;
import java.util.function.Function;
import java.util.function.Predicate;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdventureCodecsDiffblueTest {
  /**
   * Test ClickEventType {@link ClickEventType#getSerializedName()}.
   *
   * <p>Method under test: {@link ClickEventType#getSerializedName()}
   */
  @Test
  @DisplayName("Test ClickEventType getSerializedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ClickEventType.getSerializedName()"})
  void testClickEventTypeGetSerializedName() {
    // Arrange
    KeyDispatchCodec<Object, ClickEvent> codec =
        new KeyDispatchCodec<>(
            "Type Key", new MapCodecCodec<>(null), mock(Function.class), mock(Function.class));

    // Act and Assert
    assertEquals("42", new ClickEventType(codec, "42").getSerializedName());
  }

  /**
   * Test ComponentType {@link ComponentType#getSerializedName()}.
   *
   * <p>Method under test: {@link ComponentType#getSerializedName()}
   */
  @Test
  @DisplayName("Test ComponentType getSerializedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ComponentType.getSerializedName()"})
  void testComponentTypeGetSerializedName() {
    // Arrange
    KeyDispatchCodec<Object, Component> codec =
        new KeyDispatchCodec<>(
            "Type Key", new MapCodecCodec<>(null), mock(Function.class), mock(Function.class));
    ComponentType<Component> componentType =
        new ComponentType<>(codec, mock(Predicate.class), "42");

    // Act and Assert
    assertEquals("42", componentType.getSerializedName());
  }

  /**
   * Test DataSourceType {@link DataSourceType#getSerializedName()}.
   *
   * <p>Method under test: {@link DataSourceType#getSerializedName()}
   */
  @Test
  @DisplayName("Test DataSourceType getSerializedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DataSourceType.getSerializedName()"})
  void testDataSourceTypeGetSerializedName() {
    // Arrange
    MapCodecCodec<Object> keyCodec = new MapCodecCodec<>(mock(MapCodec.class));
    KeyDispatchCodec<Object, NbtComponentDataSource> codec =
        new KeyDispatchCodec<>("Type Key", keyCodec, mock(Function.class), mock(Function.class));
    DataSourceType<NbtComponentDataSource> dataSourceType = new DataSourceType<>(codec, "42");

    // Act and Assert
    assertEquals("42", dataSourceType.getSerializedName());
  }

  /**
   * Test HoverEventType {@link HoverEventType#getSerializedName()}.
   *
   * <p>Method under test: {@link HoverEventType#getSerializedName()}
   */
  @Test
  @DisplayName("Test HoverEventType getSerializedName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HoverEventType.getSerializedName()"})
  void testHoverEventTypeGetSerializedName() {
    // Arrange
    KeyDispatchCodec<Object, HoverEvent<Object>> codec =
        new KeyDispatchCodec<>(
            "Type Key", new MapCodecCodec<>(null), mock(Function.class), mock(Function.class));
    HoverEventType<Object> hoverEventType = new HoverEventType<>(codec, "42");

    // Act and Assert
    assertEquals("42", hoverEventType.getSerializedName());
  }
}
