package io.papermc.paper.registry.data.dialog.type;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NoticeTypeImplDiffblueTest {
  /**
   * Test {@link NoticeTypeImpl#NoticeTypeImpl()}.
   *
   * <p>Method under test: {@link NoticeTypeImpl#NoticeTypeImpl()}
   */
  @Test
  @DisplayName("Test new NoticeTypeImpl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NoticeTypeImpl.<init>()"})
  void testNewNoticeTypeImpl() {
    // Arrange, Act and Assert
    assertSame(NoticeTypeImpl.DEFAULT_ACTION, new NoticeTypeImpl().action());
  }
}
