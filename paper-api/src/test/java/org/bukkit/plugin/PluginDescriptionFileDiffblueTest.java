package org.bukkit.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginAwareness.Flags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PluginDescriptionFileDiffblueTest {
  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Authors is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return Authors is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnAuthorsIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();

    ArrayList<String> authors = new ArrayList<>();
    authors.add("42");
    authors.add("foo");
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertSame(authors, actualPluginDescriptionFile.getAuthors());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Contributors is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return Contributors is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnContributorsIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();

    ArrayList<String> contributors = new ArrayList<>();
    contributors.add("42");
    contributors.add("foo");
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertSame(contributors, actualPluginDescriptionFile.getContributors());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Depend is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return Depend is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnDependIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();

    ArrayList<String> depend = new ArrayList<>();
    depend.add("42");
    depend.add("foo");
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertSame(depend, actualPluginDescriptionFile.getDepend());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Libraries is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return Libraries is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnLibrariesIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    ArrayList<String> libraries = new ArrayList<>();
    libraries.add("42");
    libraries.add("foo");

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            libraries);

    // Assert
    assertSame(libraries, actualPluginDescriptionFile.getLibraries());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return LoadBefore is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return LoadBefore is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnLoadBeforeIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();

    ArrayList<String> loadBefore = new ArrayList<>();
    loadBefore.add("42");
    loadBefore.add("foo");
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertSame(loadBefore, actualPluginDescriptionFile.getLoadBefore());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return PluginSoftDependencies is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return PluginSoftDependencies is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnPluginSoftDependenciesIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();

    ArrayList<String> softDepend = new ArrayList<>();
    softDepend.add("42");
    softDepend.add("foo");
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertSame(softDepend, actualPluginDescriptionFile.getPluginSoftDependencies());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return ProvidedPlugins is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given '42'; then return ProvidedPlugins is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_given42_thenReturnProvidedPluginsIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    resultProvides.add("42");
    resultProvides.add("foo");
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertTrue(actualPluginDescriptionFile.getAuthors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getContributors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getDepend().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLibraries().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLoadBefore().isEmpty());
    assertTrue(actualPluginDescriptionFile.getPluginSoftDependencies().isEmpty());
    assertSame(resultProvides, actualPluginDescriptionFile.getProvidedPlugins());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}.
   *
   * <ul>
   *   <li>Given A null A toCharArray.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}
   */
  @Test
  @DisplayName("Test new PluginDescriptionFile(Reader); given A null A toCharArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(Reader)"})
  void testNewPluginDescriptionFile_givenANullAToCharArray()
      throws IOException, InvalidDescriptionException {
    // Arrange
    StringReader reader = new StringReader("yes");
    reader.read("A\u0000A\u0000".toCharArray(), 1, 1);

    // Act and Assert
    assertThrows(InvalidDescriptionException.class, () -> new PluginDescriptionFile(reader));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Authors size is one.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return Authors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnAuthorsSizeIsOne() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();

    ArrayList<String> authors = new ArrayList<>();
    authors.add("foo");
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    List<String> authors2 = actualPluginDescriptionFile.getAuthors();
    assertEquals(1, authors2.size());
    assertEquals("foo", authors2.get(0));
    assertTrue(actualPluginDescriptionFile.getProvidedPlugins().isEmpty());
    assertSame(authors, authors2);
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Contributors size is one.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return Contributors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnContributorsSizeIsOne() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();

    ArrayList<String> contributors = new ArrayList<>();
    contributors.add("foo");
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    List<String> contributors2 = actualPluginDescriptionFile.getContributors();
    assertEquals(1, contributors2.size());
    assertEquals("foo", contributors2.get(0));
    assertTrue(actualPluginDescriptionFile.getProvidedPlugins().isEmpty());
    assertSame(contributors, contributors2);
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Depend size is one.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return Depend size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnDependSizeIsOne() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();

    ArrayList<String> depend = new ArrayList<>();
    depend.add("foo");
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    List<String> depend2 = actualPluginDescriptionFile.getDepend();
    assertEquals(1, depend2.size());
    assertEquals("foo", depend2.get(0));
    assertTrue(actualPluginDescriptionFile.getProvidedPlugins().isEmpty());
    assertSame(depend, depend2);
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Libraries size is one.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return Libraries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnLibrariesSizeIsOne() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    ArrayList<String> libraries = new ArrayList<>();
    libraries.add("foo");

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            libraries);

    // Assert
    List<String> libraries2 = actualPluginDescriptionFile.getLibraries();
    assertEquals(1, libraries2.size());
    assertEquals("foo", libraries2.get(0));
    assertTrue(actualPluginDescriptionFile.getProvidedPlugins().isEmpty());
    assertSame(libraries, libraries2);
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return LoadBefore size is one.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return LoadBefore size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnLoadBeforeSizeIsOne() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();

    ArrayList<String> loadBefore = new ArrayList<>();
    loadBefore.add("foo");
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    List<String> loadBefore2 = actualPluginDescriptionFile.getLoadBefore();
    assertEquals(1, loadBefore2.size());
    assertEquals("foo", loadBefore2.get(0));
    assertTrue(actualPluginDescriptionFile.getProvidedPlugins().isEmpty());
    assertSame(loadBefore, loadBefore2);
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return PluginSoftDependencies size is one.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return PluginSoftDependencies size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnPluginSoftDependenciesSizeIsOne() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();

    ArrayList<String> softDepend = new ArrayList<>();
    softDepend.add("foo");
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    List<String> pluginSoftDependencies = actualPluginDescriptionFile.getPluginSoftDependencies();
    assertEquals(1, pluginSoftDependencies.size());
    assertEquals("foo", pluginSoftDependencies.get(0));
    assertTrue(actualPluginDescriptionFile.getProvidedPlugins().isEmpty());
    assertSame(softDepend, pluginSoftDependencies);
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ProvidedPlugins is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given 'foo'; then return ProvidedPlugins is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenFoo_thenReturnProvidedPluginsIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    resultProvides.add("foo");
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertTrue(actualPluginDescriptionFile.getAuthors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getContributors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getDepend().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLibraries().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLoadBefore().isEmpty());
    assertTrue(actualPluginDescriptionFile.getPluginSoftDependencies().isEmpty());
    assertSame(resultProvides, actualPluginDescriptionFile.getProvidedPlugins());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Given {@link Flags#UTF8}.
   *   <li>Then return Awareness is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); given UTF8; then return Awareness is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_givenUtf8_thenReturnAwarenessIsHashSet() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();

    HashSet<PluginAwareness> awareness = new HashSet<>();
    awareness.add(Flags.UTF8);

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertTrue(actualPluginDescriptionFile.getAuthors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getContributors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getDepend().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLibraries().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLoadBefore().isEmpty());
    assertTrue(actualPluginDescriptionFile.getPluginSoftDependencies().isEmpty());
    assertSame(awareness, actualPluginDescriptionFile.getAwareness());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Then return Permissions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); then return Permissions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_thenReturnPermissionsIsArrayList() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();

    ArrayList<Permission> permissions = new ArrayList<>();
    permissions.add(new Permission("Name"));
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertSame(permissions, actualPluginDescriptionFile.getPermissions());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>Then return Permissions size is two.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); then return Permissions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_thenReturnPermissionsSizeIsTwo() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();

    ArrayList<Permission> permissions = new ArrayList<>();
    permissions.add(new Permission("Name"));
    Permission permission = new Permission("Name");
    permissions.add(permission);
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    List<Permission> permissions2 = actualPluginDescriptionFile.getPermissions();
    assertEquals(2, permissions2.size());
    assertSame(permission, permissions2.get(1));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(InputStream)"})
  void testNewPluginDescriptionFile_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class,
        () -> new PluginDescriptionFile(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code
   *       byte}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(InputStream); when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(InputStream)"})
  void testNewPluginDescriptionFile_whenByteArrayInputStreamWithEmptyArrayOfByte()
      throws InvalidDescriptionException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[] {});

    // Act and Assert
    assertThrows(InvalidDescriptionException.class, () -> new PluginDescriptionFile(stream));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, String); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(String, String, String)"})
  void testNewPluginDescriptionFile_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PluginDescriptionFile("", "1.0.2", "Main Class"));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List, String, String,
   * List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List,
   * PermissionDefault, Set, String, List)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Authors Empty.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String, List,
   * String, String, List, List, List, String, Map, String, List, List, String, String,
   * PluginLoadOrder, List, PermissionDefault, Set, String, List)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List); when HashSet(); then return Authors Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PluginDescriptionFile.<init>(String, String, List, String, String, List, List, List, String, Map, String, List, List, String, String, PluginLoadOrder, List, PermissionDefault, Set, String, List)"
  })
  void testNewPluginDescriptionFile_whenHashSet_thenReturnAuthorsEmpty() {
    // Arrange
    ArrayList<String> resultProvides = new ArrayList<>();
    ArrayList<String> depend = new ArrayList<>();
    ArrayList<String> softDepend = new ArrayList<>();
    ArrayList<String> loadBefore = new ArrayList<>();
    HashMap<String, Map<String, Object>> commands = new HashMap<>();
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> contributors = new ArrayList<>();
    ArrayList<Permission> permissions = new ArrayList<>();
    HashSet<PluginAwareness> awareness = new HashSet<>();

    // Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile(
            "Raw Name",
            "Name",
            resultProvides,
            "Main",
            "Class Loader Of",
            depend,
            softDepend,
            loadBefore,
            "1.0.2",
            commands,
            "The characteristics of someone or something",
            authors,
            contributors,
            "Website",
            "Prefix",
            PluginLoadOrder.STARTUP,
            permissions,
            PermissionDefault.TRUE,
            awareness,
            "1.0.2",
            new ArrayList<>());

    // Assert
    assertTrue(actualPluginDescriptionFile.getAuthors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getContributors().isEmpty());
    assertTrue(actualPluginDescriptionFile.getDepend().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLibraries().isEmpty());
    assertTrue(actualPluginDescriptionFile.getLoadBefore().isEmpty());
    assertTrue(actualPluginDescriptionFile.getPluginSoftDependencies().isEmpty());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Plugin Name}.
   *   <li>Then return Version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(String, String, String); when 'Plugin Name'; then return Version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(String, String, String)"})
  void testNewPluginDescriptionFile_whenPluginName_thenReturnVersionIs102() {
    // Arrange and Act
    PluginDescriptionFile actualPluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Assert
    assertEquals("1.0.2", actualPluginDescriptionFile.getVersion());
    assertEquals("Main Class", actualPluginDescriptionFile.getMain());
    assertEquals("Main Class", actualPluginDescriptionFile.getMainClass());
    assertEquals("Plugin Name", actualPluginDescriptionFile.getRawName());
    assertEquals("Plugin_Name v1.0.2", actualPluginDescriptionFile.getDisplayName());
    assertEquals("Plugin_Name v1.0.2", actualPluginDescriptionFile.getFullName());
    assertEquals("Plugin_Name", actualPluginDescriptionFile.getName());
    assertEquals("plugin_name", actualPluginDescriptionFile.namespace());
    assertNull(actualPluginDescriptionFile.getAPIVersion());
    assertNull(actualPluginDescriptionFile.getClassLoaderOf());
    assertNull(actualPluginDescriptionFile.getDescription());
    assertNull(actualPluginDescriptionFile.getLoggerPrefix());
    assertNull(actualPluginDescriptionFile.getPaperPluginLoader());
    assertNull(actualPluginDescriptionFile.getPrefix());
    assertNull(actualPluginDescriptionFile.getWebsite());
    assertNull(actualPluginDescriptionFile.getAuthors());
    assertNull(actualPluginDescriptionFile.getContributors());
    assertEquals(PermissionDefault.OP, actualPluginDescriptionFile.getPermissionDefault());
    assertEquals(PluginLoadOrder.POSTWORLD, actualPluginDescriptionFile.getLoad());
    assertEquals(PluginLoadOrder.POSTWORLD, actualPluginDescriptionFile.getLoadOrder());
    List<String> depend = actualPluginDescriptionFile.getDepend();
    assertTrue(depend.isEmpty());
    assertTrue(actualPluginDescriptionFile.getCommands().isEmpty());
    assertTrue(actualPluginDescriptionFile.getAwareness().isEmpty());
    assertSame(depend, actualPluginDescriptionFile.getLibraries());
    assertSame(depend, actualPluginDescriptionFile.getLoadBefore());
    assertSame(depend, actualPluginDescriptionFile.getLoadBeforePlugins());
    assertSame(depend, actualPluginDescriptionFile.getPermissions());
    assertSame(depend, actualPluginDescriptionFile.getPluginDependencies());
    assertSame(depend, actualPluginDescriptionFile.getPluginSoftDependencies());
    assertSame(depend, actualPluginDescriptionFile.getProvidedPlugins());
    assertSame(depend, actualPluginDescriptionFile.getProvides());
    assertSame(depend, actualPluginDescriptionFile.getSoftDepend());
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}
   */
  @Test
  @DisplayName("Test new PluginDescriptionFile(Reader); when StringReader(String) with '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(Reader)"})
  void testNewPluginDescriptionFile_whenStringReaderWith42() throws InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class, () -> new PluginDescriptionFile(new StringReader("42")));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}
   */
  @Test
  @DisplayName(
      "Test new PluginDescriptionFile(Reader); when StringReader(String) with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(Reader)"})
  void testNewPluginDescriptionFile_whenStringReaderWithEmptyString()
      throws InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class, () -> new PluginDescriptionFile(new StringReader("")));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}
   */
  @Test
  @DisplayName("Test new PluginDescriptionFile(Reader); when StringReader(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(Reader)"})
  void testNewPluginDescriptionFile_whenStringReaderWithFoo() throws InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class,
        () -> new PluginDescriptionFile(new StringReader("foo")));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code ~}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}
   */
  @Test
  @DisplayName("Test new PluginDescriptionFile(Reader); when StringReader(String) with '~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(Reader)"})
  void testNewPluginDescriptionFile_whenStringReaderWithTilde() throws InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class, () -> new PluginDescriptionFile(new StringReader("~")));
  }

  /**
   * Test {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code yes}.
   * </ul>
   *
   * <p>Method under test: {@link PluginDescriptionFile#PluginDescriptionFile(Reader)}
   */
  @Test
  @DisplayName("Test new PluginDescriptionFile(Reader); when StringReader(String) with 'yes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PluginDescriptionFile.<init>(Reader)"})
  void testNewPluginDescriptionFile_whenStringReaderWithYes() throws InvalidDescriptionException {
    // Arrange, Act and Assert
    assertThrows(
        InvalidDescriptionException.class,
        () -> new PluginDescriptionFile(new StringReader("yes")));
  }

  /**
   * Test {@link PluginDescriptionFile#getPermissions()}.
   *
   * <p>Method under test: {@link PluginDescriptionFile#getPermissions()}
   */
  @Test
  @DisplayName("Test getPermissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PluginDescriptionFile.getPermissions()"})
  void testGetPermissions() {
    // Arrange
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act and Assert
    assertTrue(pluginDescriptionFile.getPermissions().isEmpty());
  }

  /**
   * Test {@link PluginDescriptionFile#getFullName()}.
   *
   * <p>Method under test: {@link PluginDescriptionFile#getFullName()}
   */
  @Test
  @DisplayName("Test getFullName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PluginDescriptionFile.getFullName()"})
  void testGetFullName() {
    // Arrange
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act and Assert
    assertEquals("Plugin_Name v1.0.2", pluginDescriptionFile.getFullName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PluginDescriptionFile#getAPIVersion()}
   *   <li>{@link PluginDescriptionFile#getAuthors()}
   *   <li>{@link PluginDescriptionFile#getAwareness()}
   *   <li>{@link PluginDescriptionFile#getClassLoaderOf()}
   *   <li>{@link PluginDescriptionFile#getCommands()}
   *   <li>{@link PluginDescriptionFile#getContributors()}
   *   <li>{@link PluginDescriptionFile#getDepend()}
   *   <li>{@link PluginDescriptionFile#getDescription()}
   *   <li>{@link PluginDescriptionFile#getLibraries()}
   *   <li>{@link PluginDescriptionFile#getLoad()}
   *   <li>{@link PluginDescriptionFile#getLoadBefore()}
   *   <li>{@link PluginDescriptionFile#getLoadBeforePlugins()}
   *   <li>{@link PluginDescriptionFile#getLoadOrder()}
   *   <li>{@link PluginDescriptionFile#getLoggerPrefix()}
   *   <li>{@link PluginDescriptionFile#getMain()}
   *   <li>{@link PluginDescriptionFile#getMainClass()}
   *   <li>{@link PluginDescriptionFile#getName()}
   *   <li>{@link PluginDescriptionFile#getPaperPluginLoader()}
   *   <li>{@link PluginDescriptionFile#getPermissionDefault()}
   *   <li>{@link PluginDescriptionFile#getPluginDependencies()}
   *   <li>{@link PluginDescriptionFile#getPluginSoftDependencies()}
   *   <li>{@link PluginDescriptionFile#getPrefix()}
   *   <li>{@link PluginDescriptionFile#getProvidedPlugins()}
   *   <li>{@link PluginDescriptionFile#getProvides()}
   *   <li>{@link PluginDescriptionFile#getRawName()}
   *   <li>{@link PluginDescriptionFile#getSoftDepend()}
   *   <li>{@link PluginDescriptionFile#getVersion()}
   *   <li>{@link PluginDescriptionFile#getWebsite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PluginDescriptionFile.getAPIVersion()",
    "List PluginDescriptionFile.getAuthors()",
    "Set PluginDescriptionFile.getAwareness()",
    "String PluginDescriptionFile.getClassLoaderOf()",
    "Map PluginDescriptionFile.getCommands()",
    "List PluginDescriptionFile.getContributors()",
    "List PluginDescriptionFile.getDepend()",
    "String PluginDescriptionFile.getDescription()",
    "List PluginDescriptionFile.getLibraries()",
    "PluginLoadOrder PluginDescriptionFile.getLoad()",
    "List PluginDescriptionFile.getLoadBefore()",
    "List PluginDescriptionFile.getLoadBeforePlugins()",
    "PluginLoadOrder PluginDescriptionFile.getLoadOrder()",
    "String PluginDescriptionFile.getLoggerPrefix()",
    "String PluginDescriptionFile.getMain()",
    "String PluginDescriptionFile.getMainClass()",
    "String PluginDescriptionFile.getName()",
    "String PluginDescriptionFile.getPaperPluginLoader()",
    "PermissionDefault PluginDescriptionFile.getPermissionDefault()",
    "List PluginDescriptionFile.getPluginDependencies()",
    "List PluginDescriptionFile.getPluginSoftDependencies()",
    "String PluginDescriptionFile.getPrefix()",
    "List PluginDescriptionFile.getProvidedPlugins()",
    "List PluginDescriptionFile.getProvides()",
    "String PluginDescriptionFile.getRawName()",
    "List PluginDescriptionFile.getSoftDepend()",
    "String PluginDescriptionFile.getVersion()",
    "String PluginDescriptionFile.getWebsite()"
  })
  void testGettersAndSetters() {
    // Arrange
    PluginDescriptionFile pluginDescriptionFile =
        new PluginDescriptionFile("Plugin Name", "1.0.2", "Main Class");

    // Act
    String actualAPIVersion = pluginDescriptionFile.getAPIVersion();
    List<String> actualAuthors = pluginDescriptionFile.getAuthors();
    Set<PluginAwareness> actualAwareness = pluginDescriptionFile.getAwareness();
    String actualClassLoaderOf = pluginDescriptionFile.getClassLoaderOf();
    Map<String, Map<String, Object>> actualCommands = pluginDescriptionFile.getCommands();
    List<String> actualContributors = pluginDescriptionFile.getContributors();
    List<String> actualDepend = pluginDescriptionFile.getDepend();
    String actualDescription = pluginDescriptionFile.getDescription();
    List<String> actualLibraries = pluginDescriptionFile.getLibraries();
    PluginLoadOrder actualLoad = pluginDescriptionFile.getLoad();
    List<String> actualLoadBefore = pluginDescriptionFile.getLoadBefore();
    List<String> actualLoadBeforePlugins = pluginDescriptionFile.getLoadBeforePlugins();
    PluginLoadOrder actualLoadOrder = pluginDescriptionFile.getLoadOrder();
    String actualLoggerPrefix = pluginDescriptionFile.getLoggerPrefix();
    String actualMain = pluginDescriptionFile.getMain();
    String actualMainClass = pluginDescriptionFile.getMainClass();
    String actualName = pluginDescriptionFile.getName();
    String actualPaperPluginLoader = pluginDescriptionFile.getPaperPluginLoader();
    PermissionDefault actualPermissionDefault = pluginDescriptionFile.getPermissionDefault();
    List<String> actualPluginDependencies = pluginDescriptionFile.getPluginDependencies();
    List<String> actualPluginSoftDependencies = pluginDescriptionFile.getPluginSoftDependencies();
    String actualPrefix = pluginDescriptionFile.getPrefix();
    List<String> actualProvidedPlugins = pluginDescriptionFile.getProvidedPlugins();
    List<String> actualProvides = pluginDescriptionFile.getProvides();
    String actualRawName = pluginDescriptionFile.getRawName();
    List<String> actualSoftDepend = pluginDescriptionFile.getSoftDepend();
    String actualVersion = pluginDescriptionFile.getVersion();

    // Assert
    assertEquals("1.0.2", actualVersion);
    assertEquals("Main Class", actualMain);
    assertEquals("Main Class", actualMainClass);
    assertEquals("Plugin Name", actualRawName);
    assertEquals("Plugin_Name", actualName);
    assertNull(actualAPIVersion);
    assertNull(actualClassLoaderOf);
    assertNull(actualDescription);
    assertNull(actualLoggerPrefix);
    assertNull(actualPaperPluginLoader);
    assertNull(actualPrefix);
    assertNull(pluginDescriptionFile.getWebsite());
    assertNull(actualAuthors);
    assertNull(actualContributors);
    assertEquals(PermissionDefault.OP, actualPermissionDefault);
    assertEquals(PluginLoadOrder.POSTWORLD, actualLoad);
    assertEquals(PluginLoadOrder.POSTWORLD, actualLoadOrder);
    assertTrue(actualDepend.isEmpty());
    assertTrue(actualCommands.isEmpty());
    assertTrue(actualAwareness.isEmpty());
    assertSame(actualDepend, actualLibraries);
    assertSame(actualDepend, actualLoadBefore);
    assertSame(actualDepend, actualLoadBeforePlugins);
    assertSame(actualDepend, actualPluginDependencies);
    assertSame(actualDepend, actualPluginSoftDependencies);
    assertSame(actualDepend, actualProvidedPlugins);
    assertSame(actualDepend, actualProvides);
    assertSame(actualDepend, actualSoftDepend);
  }
}
