package io.papermc.paper.registry.data.dialog.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.ActionButton;
import io.papermc.paper.registry.data.dialog.ActionButtonImpl;
import io.papermc.paper.registry.data.dialog.type.MultiActionType.Builder;
import io.papermc.paper.registry.data.dialog.type.MultiActionTypeImpl.BuilderImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MultiActionTypeImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#columns(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#columns(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl columns(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.columns(int)"})
  void testBuilderImplColumns() {
    // Arrange
    ArrayList<ActionButton> actions = new ArrayList<>();
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);
    BuilderImpl builderImpl = new BuilderImpl(actions);

    // Act
    Builder actualColumnsResult = builderImpl.columns(1);

    // Assert
    MultiActionType multiActionType = builderImpl.build();
    assertTrue(multiActionType instanceof MultiActionTypeImpl);
    assertEquals(1, multiActionType.columns());
    assertSame(builderImpl, actualColumnsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(List)}.
   *
   * <ul>
   *   <li>Then return build actions size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl(List); then return build actions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(List)"})
  void testBuilderImplNewBuilderImpl_thenReturnBuildActionsSizeIsOne() {
    // Arrange
    ArrayList<ActionButton> actions = new ArrayList<>();
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);

    // Act and Assert
    MultiActionType multiActionType = new BuilderImpl(actions).build();
    List<ActionButton> actionsResult = multiActionType.actions();
    assertEquals(1, actionsResult.size());
    ActionButton getResult = actionsResult.get(0);
    assertTrue(getResult instanceof ActionButtonImpl);
    assertTrue(multiActionType instanceof MultiActionTypeImpl);
    Component labelResult = getResult.label();
    assertNull(labelResult.insertion());
    assertNull(labelResult.font());
    assertNull(labelResult.color());
    Map<TextDecoration, State> decorationsResult = labelResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(labelResult.hasStyling());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    Component actualCompactResult = labelResult.compact();
    assertEquals(labelResult, actualCompactResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(List)}.
   *
   * <ul>
   *   <li>Then return build exitAction is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl(List); then return build exitAction is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(List)"})
  void testBuilderImplNewBuilderImpl_thenReturnBuildExitActionIsNull() {
    // Arrange
    ArrayList<ActionButton> actions = new ArrayList<>();
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);
    actions.add(NoticeTypeImpl.DEFAULT_ACTION);

    // Act and Assert
    MultiActionType multiActionType = new BuilderImpl(actions).build();
    assertTrue(multiActionType instanceof MultiActionTypeImpl);
    assertNull(multiActionType.exitAction());
    assertEquals(2, multiActionType.columns());
    assertEquals(actions, multiActionType.actions());
  }
}
