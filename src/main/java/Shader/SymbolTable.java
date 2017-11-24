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
    //TODO: Modifiy later to improve type assignment
    unmodifiableEntries.put("resolution", Types.VEC2);
    modifiableEntries.put("_GLF_color.x", Types.FLOAT);
    modifiableEntries.put("_GLF_color.y", Types.FLOAT);
    modifiableEntries.put("_GLF_color.z", Types.FLOAT);
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

  public int getModifiableEntriesLength() {
    return modifiableEntries.size();
  }

  public int getTotalNumberOfEntries() {
    return modifiableEntries.size() + unmodifiableEntries.size() - 1;
  }

  //TODO: Extend for different type
  public String getModifiableEntry(int index) {
    return (String) modifiableEntries.keySet().toArray()[index];
  }

  public String getAEntry(int index) {
    if (index < unmodifiableEntries.size()) {
      return unmodifiableEntries.keySet().toArray(new String[0])[index];
    } else {
      return getModifiableEntry(index - unmodifiableEntries.size());
    }
  }
}
