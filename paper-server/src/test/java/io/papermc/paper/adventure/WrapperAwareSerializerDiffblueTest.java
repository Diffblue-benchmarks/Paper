package io.papermc.paper.adventure;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WrapperAwareSerializerDiffblueTest {
  /**
   * Test {@link WrapperAwareSerializer#WrapperAwareSerializer(Supplier)}.
   *
   * <p>Method under test: {@link WrapperAwareSerializer#WrapperAwareSerializer(Supplier)}
   */
  @Test
  @DisplayName("Test new WrapperAwareSerializer(Supplier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WrapperAwareSerializer.<init>(Supplier)"})
  void testNewWrapperAwareSerializer() {
    // Arrange and Act
    WrapperAwareSerializer actualWrapperAwareSerializer =
        new WrapperAwareSerializer(mock(Supplier.class));

    // Assert
    assertNull(actualWrapperAwareSerializer.deseializeOrNull(null));
    assertNull(actualWrapperAwareSerializer.deserializeOrNull(null));
  }

  /**
   * Test {@link WrapperAwareSerializer#deserialize(Component)} with {@code input}.
   *
   * <p>Method under test: {@link
   * WrapperAwareSerializer#deserialize(net.minecraft.network.chat.Component)}
   */
  @Test
  @DisplayName("Test deserialize(Component) with 'input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Component WrapperAwareSerializer.deserialize(net.minecraft.network.chat.Component)"
  })
  void testDeserializeWithInput() {
    // Arrange
    WrapperAwareSerializer wrapperAwareSerializer =
        new WrapperAwareSerializer(mock(Supplier.class));
    AdventureComponent input = new AdventureComponent(mock(Component.class));

    // Act
    Component actualDeserializeResult = wrapperAwareSerializer.deserialize(input);

    // Assert
    assertSame(input.adventure, actualDeserializeResult);
  }
}
