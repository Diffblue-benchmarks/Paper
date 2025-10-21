package io.papermc.paper.datapack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.adventure.AdventureComponent;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.minecraft.server.packs.repository.Pack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDatapackDiffblueTest {
  /**
   * Test {@link PaperDatapack#computeDisplayName()}.
   *
   * <p>Method under test: {@link PaperDatapack#computeDisplayName()}
   */
  @Test
  @DisplayName("Test computeDisplayName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PaperDatapack.computeDisplayName()"})
  void testComputeDisplayName() {
    // Arrange
    Pack pack = mock(Pack.class);
    when(pack.getChatLink(anyBoolean())).thenReturn(new AdventureComponent(mock(Component.class)));

    // Act
    new PaperDatapack(pack, true).computeDisplayName();

    // Assert
    verify(pack).getChatLink(true);
  }

  /**
   * Test {@link PaperDatapack#computeDisplayName()}.
   *
   * <ul>
   *   <li>Given {@link Pack} {@link Pack#getChatLink(boolean)} return {@code null}.
   *   <li>Then return insertion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDatapack#computeDisplayName()}
   */
  @Test
  @DisplayName(
      "Test computeDisplayName(); given Pack getChatLink(boolean) return 'null'; then return insertion is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Component PaperDatapack.computeDisplayName()"})
  void testComputeDisplayName_givenPackGetChatLinkReturnNull_thenReturnInsertionIsNull() {
    // Arrange
    Pack pack = mock(Pack.class);
    when(pack.getChatLink(anyBoolean())).thenReturn(null);

    // Act
    Component actualComputeDisplayNameResult = new PaperDatapack(pack, true).computeDisplayName();

    // Assert
    verify(pack).getChatLink(true);
    assertNull(actualComputeDisplayNameResult.insertion());
    assertNull(actualComputeDisplayNameResult.font());
    assertNull(actualComputeDisplayNameResult.color());
    Map<TextDecoration, State> decorationsResult = actualComputeDisplayNameResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.ITALIC));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(actualComputeDisplayNameResult.hasStyling());
    Component actualCompactResult = actualComputeDisplayNameResult.compact();
    assertSame(actualComputeDisplayNameResult, actualCompactResult);
  }
}
