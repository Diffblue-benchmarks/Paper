package io.papermc.paper.registry.data.dialog.body;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlainMessageBodyImplDiffblueTest {
  /**
   * Test {@link PlainMessageBodyImpl#PlainMessageBodyImpl(Component)}.
   *
   * <p>Method under test: {@link PlainMessageBodyImpl#PlainMessageBodyImpl(Component)}
   */
  @Test
  @DisplayName("Test new PlainMessageBodyImpl(Component)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlainMessageBodyImpl.<init>(Component)"})
  void testNewPlainMessageBodyImpl() {
    // Arrange
    Component contents = mock(Component.class);

    // Act
    PlainMessageBodyImpl actualPlainMessageBodyImpl = new PlainMessageBodyImpl(contents);

    // Assert
    assertEquals(200, actualPlainMessageBodyImpl.width());
    assertSame(contents, actualPlainMessageBodyImpl.contents());
  }
}
