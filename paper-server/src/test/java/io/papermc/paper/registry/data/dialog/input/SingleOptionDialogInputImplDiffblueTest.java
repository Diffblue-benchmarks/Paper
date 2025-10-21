package io.papermc.paper.registry.data.dialog.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInput.OptionEntry;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInputImpl.BuilderImpl;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInputImpl.SingleOptionEntryImpl;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SingleOptionDialogInputImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#labelVisible(boolean)}.
   *
   * <p>Method under test: {@link BuilderImpl#labelVisible(boolean)}
   */
  @Test
  @DisplayName("Test BuilderImpl labelVisible(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.labelVisible(boolean)"})
  void testBuilderImplLabelVisible() {
    // Arrange
    ArrayList<OptionEntry> entries = new ArrayList<>();
    SingleOptionEntryImpl singleOptionEntryImpl =
        new SingleOptionEntryImpl("42", mock(Component.class), true);
    entries.add(singleOptionEntryImpl);
    BuilderImpl builderImpl = new BuilderImpl("Key", entries, mock(Component.class));

    // Act
    BuilderImpl actualLabelVisibleResult = builderImpl.labelVisible(true);

    // Assert
    assertSame(builderImpl, actualLabelVisibleResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(String, List, Component)}.
   *
   * <ul>
   *   <li>Then build return {@link SingleOptionDialogInputImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(String, List, Component)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl new BuilderImpl(String, List, Component); then build return SingleOptionDialogInputImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(String, List, Component)"})
  void testBuilderImplNewBuilderImpl_thenBuildReturnSingleOptionDialogInputImpl() {
    // Arrange
    ArrayList<OptionEntry> entries = new ArrayList<>();
    SingleOptionEntryImpl singleOptionEntryImpl =
        new SingleOptionEntryImpl("42", mock(Component.class), true);
    entries.add(singleOptionEntryImpl);
    Component label = mock(Component.class);

    // Act
    BuilderImpl actualBuilderImpl = new BuilderImpl("Key", entries, label);

    // Assert
    SingleOptionDialogInput singleOptionDialogInput = actualBuilderImpl.build();
    assertTrue(singleOptionDialogInput instanceof SingleOptionDialogInputImpl);
    assertEquals("Key", singleOptionDialogInput.key());
    assertEquals(200, singleOptionDialogInput.width());
    assertTrue(singleOptionDialogInput.labelVisible());
    assertEquals(entries, singleOptionDialogInput.entries());
    assertSame(label, singleOptionDialogInput.label());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#width(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#width(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl width(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BuilderImpl BuilderImpl.width(int)"})
  void testBuilderImplWidth() {
    // Arrange
    ArrayList<OptionEntry> entries = new ArrayList<>();
    SingleOptionEntryImpl singleOptionEntryImpl =
        new SingleOptionEntryImpl("42", mock(Component.class), true);
    entries.add(singleOptionEntryImpl);
    BuilderImpl builderImpl = new BuilderImpl("Key", entries, mock(Component.class));

    // Act
    BuilderImpl actualWidthResult = builderImpl.width(1);

    // Assert
    SingleOptionDialogInput singleOptionDialogInput = builderImpl.build();
    assertTrue(singleOptionDialogInput instanceof SingleOptionDialogInputImpl);
    assertEquals(1, singleOptionDialogInput.width());
    assertSame(builderImpl, actualWidthResult);
  }
}
