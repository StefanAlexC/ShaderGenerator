import Utils.Types;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

  private static final Map<String, Types> unmodifiableEntries = new HashMap<>();
  private static final Map<String, Types> modifiableEntries = new HashMap<>();

  public static Map<String, Types> getUnmodifiableEntries() {
    return unmodifiableEntries;
  }

  public static Map<String, Types> getModifiableEntries() {
    return modifiableEntries;
  }
}
