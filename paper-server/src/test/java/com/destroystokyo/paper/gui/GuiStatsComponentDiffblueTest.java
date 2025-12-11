package com.destroystokyo.paper.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.event.MouseWheelListener;
import java.awt.image.DirectColorModel;
import net.minecraft.gametest.framework.GameTestServer;
import net.minecraft.server.MinecraftServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GuiStatsComponentDiffblueTest {
  /**
   * Test {@link GuiStatsComponent#GuiStatsComponent(MinecraftServer)}.
   *
   * <p>Method under test: {@link GuiStatsComponent#GuiStatsComponent(MinecraftServer)}
   */
  @Test
  @DisplayName("Test new GuiStatsComponent(MinecraftServer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GuiStatsComponent.<init>(MinecraftServer)"})
  void testNewGuiStatsComponent() {
    // Arrange and Act
    GuiStatsComponent actualGuiStatsComponent = new GuiStatsComponent(mock(GameTestServer.class));

    // Assert
    assertTrue(actualGuiStatsComponent.getLayout() instanceof BorderLayout);
    assertTrue(actualGuiStatsComponent.getColorModel() instanceof DirectColorModel);
    assertEquals("PanelUI", actualGuiStatsComponent.getUIClassID());
    assertNull(actualGuiStatsComponent.getNextFocusableComponent());
    assertNull(actualGuiStatsComponent.getFocusCycleRootAncestor());
    assertNull(actualGuiStatsComponent.getParent());
    assertNull(actualGuiStatsComponent.getTopLevelAncestor());
    assertNull(actualGuiStatsComponent.getFocusTraversalPolicy());
    assertNull(actualGuiStatsComponent.getGraphics());
    assertNull(actualGuiStatsComponent.getGraphicsConfiguration());
    assertNull(actualGuiStatsComponent.getDropTarget());
    assertNull(actualGuiStatsComponent.getInputContext());
    assertNull(actualGuiStatsComponent.getInputMethodRequests());
    assertNull(actualGuiStatsComponent.getName());
    assertNull(actualGuiStatsComponent.getToolTipText());
    assertNull(actualGuiStatsComponent.getInputVerifier());
    assertNull(actualGuiStatsComponent.getComponentPopupMenu());
    assertNull(actualGuiStatsComponent.getRootPane());
    assertNull(actualGuiStatsComponent.getTransferHandler());
    assertNull(actualGuiStatsComponent.getBorder());
    assertEquals(0, actualGuiStatsComponent.getDebugGraphicsOptions());
    assertEquals(0, actualGuiStatsComponent.getHeight());
    assertEquals(0, actualGuiStatsComponent.getWidth());
    assertEquals(0, actualGuiStatsComponent.getX());
    assertEquals(0, actualGuiStatsComponent.getY());
    assertEquals(0, actualGuiStatsComponent.getComponentListeners().length);
    assertEquals(0, actualGuiStatsComponent.getFocusListeners().length);
    assertEquals(0, actualGuiStatsComponent.getHierarchyBoundsListeners().length);
    assertEquals(0, actualGuiStatsComponent.getHierarchyListeners().length);
    assertEquals(0, actualGuiStatsComponent.getInputMethodListeners().length);
    assertEquals(0, actualGuiStatsComponent.getKeyListeners().length);
    assertEquals(0, actualGuiStatsComponent.getMouseListeners().length);
    assertEquals(0, actualGuiStatsComponent.getMouseMotionListeners().length);
    assertEquals(0, actualGuiStatsComponent.getMouseWheelListeners().length);
    assertEquals(0, actualGuiStatsComponent.getPropertyChangeListeners().length);
    assertEquals(0, actualGuiStatsComponent.getContainerListeners().length);
    assertEquals(0, actualGuiStatsComponent.getAncestorListeners().length);
    assertEquals(0, actualGuiStatsComponent.getRegisteredKeyStrokes().length);
    assertEquals(0, actualGuiStatsComponent.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualGuiStatsComponent.getAlignmentX());
    assertEquals(0.5f, actualGuiStatsComponent.getAlignmentY());
    assertEquals(2, actualGuiStatsComponent.getComponentCount());
    assertEquals(2, actualGuiStatsComponent.getComponents().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualGuiStatsComponent.getBaselineResizeBehavior());
    assertFalse(actualGuiStatsComponent.getIgnoreRepaint());
    assertFalse(actualGuiStatsComponent.hasFocus());
    assertFalse(actualGuiStatsComponent.isCursorSet());
    assertFalse(actualGuiStatsComponent.isDisplayable());
    assertFalse(actualGuiStatsComponent.isFocusOwner());
    assertFalse(actualGuiStatsComponent.isLightweight());
    assertFalse(actualGuiStatsComponent.isMaximumSizeSet());
    assertFalse(actualGuiStatsComponent.isMinimumSizeSet());
    assertFalse(actualGuiStatsComponent.isPreferredSizeSet());
    assertFalse(actualGuiStatsComponent.isShowing());
    assertFalse(actualGuiStatsComponent.isValid());
    assertFalse(actualGuiStatsComponent.isFocusCycleRoot());
    assertFalse(actualGuiStatsComponent.isFocusTraversalPolicyProvider());
    assertFalse(actualGuiStatsComponent.isFocusTraversalPolicySet());
    assertFalse(actualGuiStatsComponent.getAutoscrolls());
    assertFalse(actualGuiStatsComponent.getInheritsPopupMenu());
    assertFalse(actualGuiStatsComponent.isManagingFocus());
    assertFalse(actualGuiStatsComponent.isOpaque());
    assertFalse(actualGuiStatsComponent.isPaintingForPrint());
    assertFalse(actualGuiStatsComponent.isPaintingTile());
    assertFalse(actualGuiStatsComponent.isValidateRoot());
    assertTrue(actualGuiStatsComponent.getFocusTraversalKeysEnabled());
    assertTrue(actualGuiStatsComponent.isBackgroundSet());
    assertTrue(actualGuiStatsComponent.isEnabled());
    assertTrue(actualGuiStatsComponent.isFocusable());
    assertTrue(actualGuiStatsComponent.isFontSet());
    assertTrue(actualGuiStatsComponent.isForegroundSet());
    assertTrue(actualGuiStatsComponent.isVisible());
    assertTrue(actualGuiStatsComponent.getVerifyInputWhenFocusTarget());
    assertTrue(actualGuiStatsComponent.isDoubleBuffered());
    assertTrue(actualGuiStatsComponent.isOptimizedDrawingEnabled());
    assertTrue(actualGuiStatsComponent.isRequestFocusEnabled());
  }

  /**
   * Test {@link GuiStatsComponent#getPreferredSize()}.
   *
   * <p>Method under test: {@link GuiStatsComponent#getPreferredSize()}
   */
  @Test
  @DisplayName("Test getPreferredSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension GuiStatsComponent.getPreferredSize()"})
  void testGetPreferredSize() {
    // Arrange
    GuiStatsComponent guiStatsComponent = new GuiStatsComponent(null);
    guiStatsComponent.addMouseWheelListener(mock(MouseWheelListener.class));

    // Act
    Dimension actualPreferredSize = guiStatsComponent.getPreferredSize();

    // Assert
    Dimension actualSize = actualPreferredSize.getSize();
    assertEquals(actualPreferredSize, actualSize);
  }

  /**
   * Test {@link GuiStatsComponent#getPreferredSize()}.
   *
   * <ul>
   *   <li>Given {@link GuiStatsComponent#GuiStatsComponent(MinecraftServer)} with server is {@link
   *       GameTestServer}.
   * </ul>
   *
   * <p>Method under test: {@link GuiStatsComponent#getPreferredSize()}
   */
  @Test
  @DisplayName(
      "Test getPreferredSize(); given GuiStatsComponent(MinecraftServer) with server is GameTestServer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension GuiStatsComponent.getPreferredSize()"})
  void testGetPreferredSize_givenGuiStatsComponentWithServerIsGameTestServer() {
    // Arrange and Act
    Dimension actualPreferredSize =
        new GuiStatsComponent(mock(GameTestServer.class)).getPreferredSize();

    // Assert
    Dimension actualSize = actualPreferredSize.getSize();
    assertEquals(actualPreferredSize, actualSize);
  }

  /**
   * Test {@link GuiStatsComponent#getPreferredSize()}.
   *
   * <ul>
   *   <li>Given {@link GuiStatsComponent#GuiStatsComponent(MinecraftServer)} with server is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link GuiStatsComponent#getPreferredSize()}
   */
  @Test
  @DisplayName(
      "Test getPreferredSize(); given GuiStatsComponent(MinecraftServer) with server is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension GuiStatsComponent.getPreferredSize()"})
  void testGetPreferredSize_givenGuiStatsComponentWithServerIsNull() {
    // Arrange and Act
    Dimension actualPreferredSize = new GuiStatsComponent(null).getPreferredSize();

    // Assert
    Dimension actualSize = actualPreferredSize.getSize();
    assertEquals(actualPreferredSize, actualSize);
  }
}
