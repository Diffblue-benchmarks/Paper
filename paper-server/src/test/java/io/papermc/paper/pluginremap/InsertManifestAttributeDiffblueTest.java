package io.papermc.paper.pluginremap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import net.neoforged.art.api.Transformer;
import net.neoforged.art.api.Transformer.Entry;
import net.neoforged.art.internal.EntryImpl;
import net.neoforged.art.internal.EntryImpl.ManifestEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InsertManifestAttributeDiffblueTest {
  /**
   * Test {@link InsertManifestAttribute#addNamespaceManifestAttribute(String)}.
   *
   * <p>Method under test: {@link InsertManifestAttribute#addNamespaceManifestAttribute(String)}
   */
  @Test
  @DisplayName("Test addNamespaceManifestAttribute(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Transformer InsertManifestAttribute.addNamespaceManifestAttribute(String)"})
  void testAddNamespaceManifestAttribute() {
    // Arrange and Act
    Transformer actualAddNamespaceManifestAttributeResult =
        InsertManifestAttribute.addNamespaceManifestAttribute("Namespace");

    // Assert
    assertTrue(actualAddNamespaceManifestAttributeResult instanceof InsertManifestAttribute);
    Collection<? extends Entry> extras = actualAddNamespaceManifestAttributeResult.getExtras();
    assertEquals(1, extras.size());
    assertTrue(extras instanceof List);
    Entry getResult = ((List<? extends Entry>) extras).get(0);
    assertTrue(getResult instanceof ManifestEntry);
    assertEquals("META-INF/MANIFEST.MF", getResult.getName());
    assertEquals(68, getResult.getData().length);
    assertEquals(946684800L, getResult.getTime());
  }

  /**
   * Test {@link InsertManifestAttribute#process(ManifestEntry)} with {@code ManifestEntry}.
   *
   * <p>Method under test: {@link InsertManifestAttribute#process(Transformer.ManifestEntry)}
   */
  @Test
  @DisplayName("Test process(ManifestEntry) with 'ManifestEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Transformer.ManifestEntry InsertManifestAttribute.process(Transformer.ManifestEntry)"
  })
  void testProcessWithManifestEntry() throws UnsupportedEncodingException {
    // Arrange
    InsertManifestAttribute insertManifestAttribute =
        new InsertManifestAttribute("mojang", "Namespace", true);
    ManifestEntry entry = new ManifestEntry(10L, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    Transformer.ManifestEntry actualProcessResult = insertManifestAttribute.process(entry);

    // Assert
    Collection<? extends Entry> extras = insertManifestAttribute.getExtras();
    assertTrue(extras instanceof List);
    assertTrue(actualProcessResult instanceof ManifestEntry);
    assertEquals("META-INF/MANIFEST.MF", actualProcessResult.getName());
    assertEquals(946684800L, actualProcessResult.getTime());
    assertTrue(extras.isEmpty());
    assertArrayEquals(new byte[] {'\r', '\n'}, actualProcessResult.getData());
  }

  /**
   * Test {@link InsertManifestAttribute#getExtras()}.
   *
   * <p>Method under test: {@link InsertManifestAttribute#getExtras()}
   */
  @Test
  @DisplayName("Test getExtras()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection InsertManifestAttribute.getExtras()"})
  void testGetExtras() {
    // Arrange
    InsertManifestAttribute insertManifestAttribute =
        new InsertManifestAttribute("Main Attributes Key", "Namespace", false);

    // Act
    Collection<? extends Entry> actualExtras = insertManifestAttribute.getExtras();

    // Assert
    assertTrue(actualExtras instanceof List);
    assertTrue(actualExtras.isEmpty());
  }

  /**
   * Test {@link InsertManifestAttribute#getExtras()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InsertManifestAttribute#getExtras()}
   */
  @Test
  @DisplayName("Test getExtras(); given 'A'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection InsertManifestAttribute.getExtras()"})
  void testGetExtras_givenA_thenReturnEmpty() {
    // Arrange
    InsertManifestAttribute insertManifestAttribute =
        new InsertManifestAttribute("mojang", "Namespace", true);
    ManifestEntry entry = new ManifestEntry(10L, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    insertManifestAttribute.process(entry);

    // Act
    Collection<? extends Entry> actualExtras = insertManifestAttribute.getExtras();

    // Assert
    assertTrue(actualExtras instanceof List);
    assertTrue(actualExtras.isEmpty());
  }

  /**
   * Test {@link InsertManifestAttribute#getExtras()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link InsertManifestAttribute#getExtras()}
   */
  @Test
  @DisplayName("Test getExtras(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection InsertManifestAttribute.getExtras()"})
  void testGetExtras_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    InsertManifestAttribute insertManifestAttribute =
        new InsertManifestAttribute("mojang", "Namespace", true);

    // Act
    Collection<? extends Entry> actualExtras = insertManifestAttribute.getExtras();

    // Assert
    assertTrue(actualExtras instanceof List);
    assertEquals(1, actualExtras.size());
    Entry getResult = ((List<? extends Entry>) actualExtras).get(0);
    assertTrue(getResult instanceof ManifestEntry);
    assertEquals("META-INF/MANIFEST.MF", getResult.getName());
    assertEquals(946684800L, getResult.getTime());
    assertArrayEquals(
        "Manifest-Version: 1.0\r\nmojang: Namespace\r\n\r\n".getBytes("UTF-8"),
        getResult.getData());
  }
}
