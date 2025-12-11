package com.destroystokyo.paper.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.DirectColorModel;
import java.beans.PropertyChangeListener;
import javax.swing.DebugGraphics;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RAMGraphDiffblueTest {
  /**
   * Test new {@link RAMGraph} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RAMGraph}
   */
  @Test
  @DisplayName("Test new RAMGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RAMGraph.<init>()"})
  void testNewRAMGraph() {
    // Arrange and Act
    RAMGraph actualRamGraph = new RAMGraph();

    // Assert
    assertTrue(actualRamGraph.getColorModel() instanceof DirectColorModel);
    assertEquals("ComponentUI", actualRamGraph.getUIClassID());
    assertNull(actualRamGraph.getBackground());
    assertNull(actualRamGraph.getForeground());
    assertNull(actualRamGraph.getNextFocusableComponent());
    assertNull(actualRamGraph.getFocusCycleRootAncestor());
    assertNull(actualRamGraph.getParent());
    assertNull(actualRamGraph.getTopLevelAncestor());
    assertNull(actualRamGraph.getFocusTraversalPolicy());
    assertNull(actualRamGraph.getFont());
    assertNull(actualRamGraph.getGraphics());
    assertNull(actualRamGraph.getGraphicsConfiguration());
    assertNull(actualRamGraph.getLayout());
    assertNull(actualRamGraph.getDropTarget());
    assertNull(actualRamGraph.getInputContext());
    assertNull(actualRamGraph.getInputMethodRequests());
    assertNull(actualRamGraph.getName());
    assertNull(actualRamGraph.getToolTipText());
    assertNull(actualRamGraph.getAccessibleContext());
    assertNull(actualRamGraph.getInputVerifier());
    assertNull(actualRamGraph.getComponentPopupMenu());
    assertNull(actualRamGraph.getRootPane());
    assertNull(actualRamGraph.getTransferHandler());
    assertNull(actualRamGraph.getBorder());
    assertNull(actualRamGraph.getUI());
    assertEquals(0, actualRamGraph.getComponentCount());
    assertEquals(0, actualRamGraph.getDebugGraphicsOptions());
    assertEquals(0, actualRamGraph.getHeight());
    assertEquals(0, actualRamGraph.getWidth());
    assertEquals(0, actualRamGraph.getX());
    assertEquals(0, actualRamGraph.getY());
    assertEquals(0, actualRamGraph.getComponentListeners().length);
    assertEquals(0, actualRamGraph.getFocusListeners().length);
    assertEquals(0, actualRamGraph.getHierarchyBoundsListeners().length);
    assertEquals(0, actualRamGraph.getHierarchyListeners().length);
    assertEquals(0, actualRamGraph.getInputMethodListeners().length);
    assertEquals(0, actualRamGraph.getKeyListeners().length);
    assertEquals(0, actualRamGraph.getMouseMotionListeners().length);
    assertEquals(0, actualRamGraph.getMouseWheelListeners().length);
    assertEquals(0, actualRamGraph.getPropertyChangeListeners().length);
    assertEquals(0, actualRamGraph.getComponents().length);
    assertEquals(0, actualRamGraph.getContainerListeners().length);
    assertEquals(0, actualRamGraph.getAncestorListeners().length);
    assertEquals(0, actualRamGraph.getRegisteredKeyStrokes().length);
    assertEquals(0, actualRamGraph.getVetoableChangeListeners().length);
    assertEquals(0.5f, actualRamGraph.getAlignmentX());
    assertEquals(0.5f, actualRamGraph.getAlignmentY());
    assertEquals(1, actualRamGraph.getMouseListeners().length);
    assertEquals(BaselineResizeBehavior.OTHER, actualRamGraph.getBaselineResizeBehavior());
    assertFalse(actualRamGraph.getIgnoreRepaint());
    assertFalse(actualRamGraph.hasFocus());
    assertFalse(actualRamGraph.isBackgroundSet());
    assertFalse(actualRamGraph.isCursorSet());
    assertFalse(actualRamGraph.isDisplayable());
    assertFalse(actualRamGraph.isFocusOwner());
    assertFalse(actualRamGraph.isFontSet());
    assertFalse(actualRamGraph.isForegroundSet());
    assertFalse(actualRamGraph.isLightweight());
    assertFalse(actualRamGraph.isMaximumSizeSet());
    assertFalse(actualRamGraph.isMinimumSizeSet());
    assertFalse(actualRamGraph.isPreferredSizeSet());
    assertFalse(actualRamGraph.isShowing());
    assertFalse(actualRamGraph.isValid());
    assertFalse(actualRamGraph.isFocusCycleRoot());
    assertFalse(actualRamGraph.isFocusTraversalPolicyProvider());
    assertFalse(actualRamGraph.isFocusTraversalPolicySet());
    assertFalse(actualRamGraph.getAutoscrolls());
    assertFalse(actualRamGraph.getInheritsPopupMenu());
    assertFalse(actualRamGraph.isDoubleBuffered());
    assertFalse(actualRamGraph.isManagingFocus());
    assertFalse(actualRamGraph.isOpaque());
    assertFalse(actualRamGraph.isPaintingForPrint());
    assertFalse(actualRamGraph.isPaintingTile());
    assertFalse(actualRamGraph.isValidateRoot());
    assertTrue(actualRamGraph.getFocusTraversalKeysEnabled());
    assertTrue(actualRamGraph.isEnabled());
    assertTrue(actualRamGraph.isFocusable());
    assertTrue(actualRamGraph.isVisible());
    assertTrue(actualRamGraph.getVerifyInputWhenFocusTarget());
    assertTrue(actualRamGraph.isOptimizedDrawingEnabled());
    assertTrue(actualRamGraph.isRequestFocusEnabled());
  }

  /**
   * Test {@link RAMGraph#getPreferredSize()}.
   *
   * <ul>
   *   <li>Given {@link RAMGraph} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RAMGraph#getPreferredSize()}
   */
  @Test
  @DisplayName("Test getPreferredSize(); given RAMGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension RAMGraph.getPreferredSize()"})
  void testGetPreferredSize_givenRAMGraph() {
    // Arrange and Act
    Dimension actualPreferredSize = new RAMGraph().getPreferredSize();

    // Assert
    assertEquals(110, actualPreferredSize.height);
    assertEquals(110.0d, actualPreferredSize.getHeight());
    assertEquals(350, actualPreferredSize.width);
    assertEquals(350.0d, actualPreferredSize.getWidth());
    Dimension actualSize = actualPreferredSize.getSize();
    assertEquals(actualPreferredSize, actualSize);
  }

  /**
   * Test {@link RAMGraph#getPreferredSize()}.
   *
   * <ul>
   *   <li>Given {@link RAMGraph} (default constructor) addFocusListener {@link BasicComboBoxEditor}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RAMGraph#getPreferredSize()}
   */
  @Test
  @DisplayName(
      "Test getPreferredSize(); given RAMGraph (default constructor) addFocusListener BasicComboBoxEditor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension RAMGraph.getPreferredSize()"})
  void testGetPreferredSize_givenRAMGraphAddFocusListenerBasicComboBoxEditor() {
    // Arrange
    RAMGraph ramGraph = new RAMGraph();
    ramGraph.addFocusListener(new BasicComboBoxEditor());
    ramGraph.add(new RAMGraph());

    // Act
    Dimension actualPreferredSize = ramGraph.getPreferredSize();

    // Assert
    assertEquals(110, actualPreferredSize.height);
    assertEquals(110.0d, actualPreferredSize.getHeight());
    assertEquals(350, actualPreferredSize.width);
    assertEquals(350.0d, actualPreferredSize.getWidth());
    Dimension actualSize = actualPreferredSize.getSize();
    assertEquals(actualPreferredSize, actualSize);
  }

  /**
   * Test {@link RAMGraph#paint(Graphics)}.
   *
   * <p>Method under test: {@link RAMGraph#paint(Graphics)}
   */
  @Test
  @DisplayName("Test paint(Graphics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RAMGraph.paint(Graphics)"})
  void testPaint() {
    // Arrange
    RAMGraph ramGraph = new RAMGraph();
    ramGraph.addPropertyChangeListener("Property Name", mock(PropertyChangeListener.class));

    // Act and Assert
    assertThrows(HeadlessException.class, () -> ramGraph.paint(new DebugGraphics()));
  }

  /**
   * Test {@link RAMGraph#paint(Graphics)}.
   *
   * <ul>
   *   <li>Given {@link RAMGraph} (default constructor).
   *   <li>When {@link DebugGraphics#DebugGraphics()}.
   *   <li>Then throw {@link HeadlessException}.
   * </ul>
   *
   * <p>Method under test: {@link RAMGraph#paint(Graphics)}
   */
  @Test
  @DisplayName(
      "Test paint(Graphics); given RAMGraph (default constructor); when DebugGraphics(); then throw HeadlessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RAMGraph.paint(Graphics)"})
  void testPaint_givenRAMGraph_whenDebugGraphics_thenThrowHeadlessException() {
    // Arrange
    RAMGraph ramGraph = new RAMGraph();

    // Act and Assert
    assertThrows(HeadlessException.class, () -> ramGraph.paint(new DebugGraphics()));
  }
}
