package org.bukkit.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.util.ChatPaginator.ChatPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatPaginatorDiffblueTest {
  /**
   * Test ChatPage getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ChatPage#ChatPage(String[], int, int)}
   *   <li>{@link ChatPage#getLines()}
   *   <li>{@link ChatPage#getPageNumber()}
   *   <li>{@link ChatPage#getTotalPages()}
   * </ul>
   */
  @Test
  @DisplayName("Test ChatPage getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChatPage.<init>(String[], int, int)",
    "String[] ChatPage.getLines()",
    "int ChatPage.getPageNumber()",
    "int ChatPage.getTotalPages()"
  })
  void testChatPageGettersAndSetters() {
    // Arrange
    String[] lines = new String[] {"Lines"};

    // Act
    ChatPage actualChatPage = new ChatPage(lines, ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 1);
    String[] actualLines = actualChatPage.getLines();
    int actualPageNumber = actualChatPage.getPageNumber();

    // Assert
    assertEquals(1, actualChatPage.getTotalPages());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualPageNumber);
    assertSame(lines, actualLines);
    assertArrayEquals(new String[] {"Lines"}, actualLines);
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int)} with {@code unpaginatedString}, {@code
   * pageNumber}.
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int)}
   */
  @Test
  @DisplayName("Test paginate(String, int) with 'unpaginatedString', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int)"})
  void testPaginateWithUnpaginatedStringPageNumber() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("Unpaginated String", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {"Unpaginated String"}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("Unpaginated String", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 3, 1);

    // Assert
    assertEquals(6, actualPaginateResult.getPageNumber());
    assertEquals(6, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {"ing"}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight2() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate(
            "Cannot get last colors from null text", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 3, 1);

    // Assert
    assertEquals(14, actualPaginateResult.getTotalPages());
    assertEquals(ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, actualPaginateResult.getPageNumber());
    assertArrayEquals(new String[] {"m"}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight3() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("Unpaginated String", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 3, 18);

    // Assert
    assertArrayEquals(
        new String[] {"Unp", "agi", "nat", "ed", "Str", "ing"}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight4() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate(
            "Cannot get last colors from null text",
            ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT,
            Integer.SIZE,
            1);

    // Assert
    assertEquals(2, actualPaginateResult.getPageNumber());
    assertEquals(2, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {"text"}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight5() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("\n", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 1, 1);

    // Assert
    assertEquals(3, actualPaginateResult.getPageNumber());
    assertEquals(3, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {""}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight_whenEmptyString() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 3, 1);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {""}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <ul>
   *   <li>When lf.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'; when lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight_whenLf() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("\n", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 3, 1);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {""}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int, int, int)} with {@code unpaginatedString},
   * {@code pageNumber}, {@code lineLength}, {@code pageHeight}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test paginate(String, int, int, int) with 'unpaginatedString', 'pageNumber', 'lineLength', 'pageHeight'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int, int, int)"})
  void testPaginateWithUnpaginatedStringPageNumberLineLengthPageHeight_whenNull() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate(null, ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT, 3, 1);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {""}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int)} with {@code unpaginatedString}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>When lf.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int)}
   */
  @Test
  @DisplayName("Test paginate(String, int) with 'unpaginatedString', 'pageNumber'; when lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int)"})
  void testPaginateWithUnpaginatedStringPageNumber_whenLf() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate("\n", ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {""}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int)} with {@code unpaginatedString}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int)}
   */
  @Test
  @DisplayName("Test paginate(String, int) with 'unpaginatedString', 'pageNumber'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int)"})
  void testPaginateWithUnpaginatedStringPageNumber_whenNull() {
    // Arrange and Act
    ChatPage actualPaginateResult =
        ChatPaginator.paginate(null, ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {""}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#paginate(String, int)} with {@code unpaginatedString}, {@code
   * pageNumber}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#paginate(String, int)}
   */
  @Test
  @DisplayName("Test paginate(String, int) with 'unpaginatedString', 'pageNumber'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChatPage ChatPaginator.paginate(String, int)"})
  void testPaginateWithUnpaginatedStringPageNumber_whenOne() {
    // Arrange and Act
    ChatPage actualPaginateResult = ChatPaginator.paginate("Unpaginated String", 1);

    // Assert
    assertEquals(1, actualPaginateResult.getPageNumber());
    assertEquals(1, actualPaginateResult.getTotalPages());
    assertArrayEquals(new String[] {"Unpaginated String"}, actualPaginateResult.getLines());
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Cannot get last colors from null} and
   *       {@code text}.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName(
      "Test wordWrap(String, int); then return array of String with 'Cannot get last colors from null' and 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_thenReturnArrayOfStringWithCannotGetLastColorsFromNullAndText() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"Cannot get last colors from null", "text"},
        ChatPaginator.wordWrap("Cannot get last colors from null text", Integer.SIZE));
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>When {@code Cannot get last colors from null text}.
   *   <li>Then return first element is {@code Can}.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName(
      "Test wordWrap(String, int); when 'Cannot get last colors from null text'; then return first element is 'Can'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_whenCannotGetLastColorsFromNullText_thenReturnFirstElementIsCan() {
    // Arrange and Act
    String[] actualWordWrapResult =
        ChatPaginator.wordWrap("Cannot get last colors from null text", 3);

    // Assert
    assertEquals("Can", actualWordWrapResult[0]);
    assertEquals("col", actualWordWrapResult[6]);
    assertEquals("fro", actualWordWrapResult[8]);
    assertEquals("get", actualWordWrapResult[3]);
    assertEquals("l", actualWordWrapResult[11]);
    assertEquals("las", actualWordWrapResult[4]);
    assertEquals("m", actualWordWrapResult[9]);
    assertEquals("not", actualWordWrapResult[1]);
    assertEquals("nul", actualWordWrapResult[ChatPaginator.CLOSED_CHAT_PAGE_HEIGHT]);
    assertEquals("ors", actualWordWrapResult[7]);
    assertEquals("t", actualWordWrapResult[13]);
    assertEquals("t", actualWordWrapResult[5]);
    assertEquals("tex", actualWordWrapResult[12]);
    assertEquals(14, actualWordWrapResult.length);
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName(
      "Test wordWrap(String, int); when empty string; then return array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_whenEmptyString_thenReturnArrayOfStringWithEmptyString() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {""}, ChatPaginator.wordWrap("", 3));
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName("Test wordWrap(String, int); when lf; then return array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_whenLf_thenReturnArrayOfStringWithEmptyString() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {""}, ChatPaginator.wordWrap("\n", 3));
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array of {@link String} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName(
      "Test wordWrap(String, int); when 'null'; then return array of String with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_whenNull_thenReturnArrayOfStringWithEmptyString() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {""}, ChatPaginator.wordWrap(null, 3));
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array of {@link String} with empty string and empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName(
      "Test wordWrap(String, int); when one; then return array of String with empty string and empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_whenOne_thenReturnArrayOfStringWithEmptyStringAndEmptyString() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"", "", ""}, ChatPaginator.wordWrap("\n", 1));
  }

  /**
   * Test {@link ChatPaginator#wordWrap(String, int)}.
   *
   * <ul>
   *   <li>When {@code Raw String}.
   *   <li>Then return second element is {@code Raw}.
   * </ul>
   *
   * <p>Method under test: {@link ChatPaginator#wordWrap(String, int)}
   */
  @Test
  @DisplayName("Test wordWrap(String, int); when 'Raw String'; then return second element is 'Raw'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ChatPaginator.wordWrap(String, int)"})
  void testWordWrap_whenRawString_thenReturnSecondElementIsRaw() {
    // Arrange and Act
    String[] actualWordWrapResult = ChatPaginator.wordWrap("Raw String", 3);

    // Assert
    assertEquals("Raw", actualWordWrapResult[1]);
    assertEquals("Str", actualWordWrapResult[2]);
    assertEquals("ing", actualWordWrapResult[3]);
    assertEquals(4, actualWordWrapResult.length);
  }
}
