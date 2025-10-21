package org.bukkit.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SectionPathDataDiffblueTest {
  /**
   * Test {@link SectionPathData#SectionPathData(Object)}.
   *
   * <p>Method under test: {@link SectionPathData#SectionPathData(Object)}
   */
  @Test
  @DisplayName("Test new SectionPathData(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.<init>(Object)"})
  void testNewSectionPathData() {
    // Arrange and Act
    SectionPathData actualSectionPathData = new SectionPathData("Data");

    // Assert
    assertEquals("Data", actualSectionPathData.getData());
    List<String> comments = actualSectionPathData.getComments();
    assertTrue(comments.isEmpty());
    assertSame(comments, actualSectionPathData.getInlineComments());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SectionPathData#setData(Object)}
   *   <li>{@link SectionPathData#getComments()}
   *   <li>{@link SectionPathData#getData()}
   *   <li>{@link SectionPathData#getInlineComments()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SectionPathData.getComments()",
    "Object SectionPathData.getData()",
    "List SectionPathData.getInlineComments()",
    "void SectionPathData.setData(Object)"
  })
  void testGettersAndSetters() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    // Act
    sectionPathData.setData("Data");
    List<String> actualComments = sectionPathData.getComments();
    Object actualData = sectionPathData.getData();
    List<String> actualInlineComments = sectionPathData.getInlineComments();

    // Assert
    assertEquals("Data", actualData);
    assertTrue(actualComments.isEmpty());
    assertSame(actualComments, actualInlineComments);
  }

  /**
   * Test {@link SectionPathData#setComments(List)}.
   *
   * <p>Method under test: {@link SectionPathData#setComments(List)}
   */
  @Test
  @DisplayName("Test setComments(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setComments(List)"})
  void testSetComments() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    // Act
    sectionPathData.setComments(null);

    // Assert that nothing has changed
    List<String> comments = sectionPathData.getComments();
    assertTrue(comments.isEmpty());
    assertSame(comments, sectionPathData.getInlineComments());
  }

  /**
   * Test {@link SectionPathData#setComments(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SectionPathData#setComments(List)}
   */
  @Test
  @DisplayName("Test setComments(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setComments(List)"})
  void testSetComments_given42_whenArrayListAdd42() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    ArrayList<String> comments = new ArrayList<>();
    comments.add("42");
    comments.add("foo");

    // Act
    sectionPathData.setComments(comments);

    // Assert
    assertTrue(sectionPathData.getInlineComments().isEmpty());
    assertEquals(comments, sectionPathData.getComments());
  }

  /**
   * Test {@link SectionPathData#setComments(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then {@link SectionPathData#SectionPathData(Object)} with {@code Data} Comments is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SectionPathData#setComments(List)}
   */
  @Test
  @DisplayName(
      "Test setComments(List); given 'foo'; then SectionPathData(Object) with 'Data' Comments is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setComments(List)"})
  void testSetComments_givenFoo_thenSectionPathDataWithDataCommentsIsArrayList() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    ArrayList<String> comments = new ArrayList<>();
    comments.add("foo");

    // Act
    sectionPathData.setComments(comments);

    // Assert
    assertTrue(sectionPathData.getInlineComments().isEmpty());
    assertEquals(comments, sectionPathData.getComments());
  }

  /**
   * Test {@link SectionPathData#setComments(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link SectionPathData#SectionPathData(Object)} with {@code Data} Comments Empty.
   * </ul>
   *
   * <p>Method under test: {@link SectionPathData#setComments(List)}
   */
  @Test
  @DisplayName(
      "Test setComments(List); when ArrayList(); then SectionPathData(Object) with 'Data' Comments Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setComments(List)"})
  void testSetComments_whenArrayList_thenSectionPathDataWithDataCommentsEmpty() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    // Act
    sectionPathData.setComments(new ArrayList<>());

    // Assert
    assertTrue(sectionPathData.getComments().isEmpty());
    assertTrue(sectionPathData.getInlineComments().isEmpty());
  }

  /**
   * Test {@link SectionPathData#setInlineComments(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SectionPathData#setInlineComments(List)}
   */
  @Test
  @DisplayName("Test setInlineComments(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setInlineComments(List)"})
  void testSetInlineComments_given42_whenArrayListAdd42() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    ArrayList<String> inlineComments = new ArrayList<>();
    inlineComments.add("42");
    inlineComments.add("foo");

    // Act
    sectionPathData.setInlineComments(inlineComments);

    // Assert
    assertEquals(inlineComments, sectionPathData.getInlineComments());
  }

  /**
   * Test {@link SectionPathData#setInlineComments(List)}.
   *
   * <ul>
   *   <li>Then {@link SectionPathData#SectionPathData(Object)} with {@code Data} InlineComments
   *       Empty.
   * </ul>
   *
   * <p>Method under test: {@link SectionPathData#setInlineComments(List)}
   */
  @Test
  @DisplayName(
      "Test setInlineComments(List); then SectionPathData(Object) with 'Data' InlineComments Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setInlineComments(List)"})
  void testSetInlineComments_thenSectionPathDataWithDataInlineCommentsEmpty() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    // Act
    sectionPathData.setInlineComments(new ArrayList<>());

    // Assert
    assertTrue(sectionPathData.getInlineComments().isEmpty());
  }

  /**
   * Test {@link SectionPathData#setInlineComments(List)}.
   *
   * <ul>
   *   <li>Then {@link SectionPathData#SectionPathData(Object)} with {@code Data} InlineComments is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SectionPathData#setInlineComments(List)}
   */
  @Test
  @DisplayName(
      "Test setInlineComments(List); then SectionPathData(Object) with 'Data' InlineComments is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SectionPathData.setInlineComments(List)"})
  void testSetInlineComments_thenSectionPathDataWithDataInlineCommentsIsArrayList() {
    // Arrange
    SectionPathData sectionPathData = new SectionPathData("Data");

    ArrayList<String> inlineComments = new ArrayList<>();
    inlineComments.add("foo");

    // Act
    sectionPathData.setInlineComments(inlineComments);

    // Assert
    assertEquals(inlineComments, sectionPathData.getInlineComments());
  }
}
