package Shader;

import Utils.Types;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SymbolTable {

  private final Map<String, Types> unmodifiableEntries = new HashMap<>();
  private final Map<String, Types> modifiableEntries = new HashMap<>();

  public SymbolTable() {
    unmodifiableEntries.put("resolution", Types.VEC2);
  }

  public void addUnmodifiableEntry(String name, Types type) {
    unmodifiableEntries.put(name, type);
  }

  public void addModifiableEntry(String name, Types type) {
    modifiableEntries.put(name, type);
  }

  public static String declareVaraible(Entry<String, Types> entry) {
    return entry.getValue() + entry.getKey();
  }

  public String declareInputParameters() {
    return unmodifiableEntries.entrySet().stream().sorted(Comparator.comparing(Entry::getKey)).map
        (x -> "uniform " + declareVaraible(x) + ";\n").reduce(String::concat).orElse("");
  }
}
