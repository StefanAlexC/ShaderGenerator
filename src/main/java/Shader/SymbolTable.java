package Shader;

import Utils.Types;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class SymbolTable {

  private final Map<String, Types> unmodifiableEntries = new HashMap<>();
  private final Map<String, Types> modifiableEntries = new HashMap<>();
  private final List<String> allFloats = new LinkedList<>();
  private final List<String> modifiableFloats = new LinkedList<>();

  public SymbolTable() {
    //TODO: Modifiy later to improve type assignment
    addUnmodifiableEntry("resolution", Types.VEC2);
    addModifiableEntry("_GLF_color", Types.VEC4);
  }

  public void addUnmodifiableEntry(String name, Types type) {
    unmodifiableEntries.put(name, type);
    addFloatEntries(allFloats, name, type);
  }

  public void addModifiableEntry(String name, Types type) {
    modifiableEntries.put(name, type);
    addFloatEntries(allFloats, name, type);
    addFloatEntries(modifiableFloats, name, type);
  }

  private void addFloatEntries(List<String> list, String name, Types types) {
    //TODO: Add the other types
    //TODO: Add arrays

    switch (types) {
      case VEC4: list.add(name + ".w");
      case VEC3: list.add(name + ".z");
      case VEC2: list.add(name + ".y"); list.add(name + ".x"); break;
      case FLOAT: list.add(name); break;
      default:
        System.err.println("Not implemented");
    }
  }

  public static String declareVariable(Entry<String, Types> entry) {
    return entry.getValue() + entry.getKey();
  }

  public String declareInputParameters() {
    return unmodifiableEntries.entrySet().stream().sorted(Comparator.comparing(Entry::getKey)).map
        (x -> "uniform " + declareVariable(x) + ";\n").reduce(String::concat).orElse("");
  }

  public int getAllFloatsLength() {
    return allFloats.size();
  }

  public int getModifiableFloatsLength() {
    return modifiableFloats.size();
  }

  public String getModifiableEntry(int index) {
    return modifiableFloats.get(index);
  }

  public String getAEntry(int index) {
    return allFloats.get(index);
  }

  Stream<Entry<String,Types>> getModifiableList() {
    return modifiableEntries.entrySet().stream();
  }
}
