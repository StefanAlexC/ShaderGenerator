package Utils;

public enum Types {
  FLOAT,
  INT,
  VEC2,
  VEC3,
  VEC4,
  FLOAT_ARRAY,
  INT_ARRAY,
  VEC2_ARRAY,
  VEC3_ARRAY,
  VEC4_ARRAY;


  @Override
  public String toString() {
    switch (this) {
      case INT: return "int ";
      case FLOAT: return "float ";
      case VEC2: return "vec2 ";
      case VEC3: return "vec3 ";
      case VEC4: return "vec4 ";
      case INT_ARRAY: return "int[] ";
      case FLOAT_ARRAY: return "float[] ";
      case VEC2_ARRAY: return "vec2[] ";
      case VEC3_ARRAY: return "vec3[] ";
      case VEC4_ARRAY: return "vec4[] ";
    }
    return null;
  }
}
