package Utils;

public enum Types {
  FLOAT,
  INT,
  VEC2,
  VEC3,
  VEC4;


  @Override
  public String toString() {
    switch (this) {
      case INT: return "int ";
      case FLOAT: return "float ";
      case VEC2: return "vec2 ";
      case VEC3: return "vec3 ";
      case VEC4: return "vec4 ";
    }
    return null;
  }
}
