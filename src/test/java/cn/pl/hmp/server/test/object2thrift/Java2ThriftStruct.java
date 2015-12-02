package cn.pl.hmp.server.test.object2thrift;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Java2ThriftStruct {
	private Java2ThriftStruct() {
		throw new AssertionError("NOT SUPPORT...");
	}

	private static final String LS = System.lineSeparator();

	private static Map<Class<?>, String> map = new HashMap<Class<?>, String>();

	public static final String TYPE_BOOLEAN = "bool";
	public static final String TYPE_BYTE = "byte";
	public static final String TYPE_SHORT = "i16";
	public static final String TYPE_CHAR = "i16";
	public static final String TYPE_INT = "i32";
	public static final String TYPE_LONG = "i64";
	public static final String TYPE_DOUBLE = "double";
	public static final String TYPE_STRING = "string";

	public static final String TYPE_CONTAINER_LIST = "list";
	public static final String TYPE_CONTAINER_SET = "set";
	public static final String TYPE_CONTAINER_MAP = "map";
	

	public static final String TYPE_CONTAINER_LIST_BOOLEAN = "list<bool>";
	public static final String TYPE_CONTAINER_LIST_BYTE = "list<i16>";
	public static final String TYPE_CONTAINER_LIST_CHAR = "list<i16>";
	public static final String TYPE_CONTAINER_LIST_SHORT = "list<i16>";
	public static final String TYPE_CONTAINER_LIST_INT = "list<i32>";
	public static final String TYPE_CONTAINER_LIST_LONG = "list<i64>";
	public static final String TYPE_CONTAINER_LIST_FLOAT = "list<double>";
	public static final String TYPE_CONTAINER_LIST_DOUBLE = "list<double>";
	public static final String TYPE_CONTAINER_LIST_STRING = "list<string>";

	static {
		map.put(byte.class, TYPE_BYTE);
		map.put(Byte.class, TYPE_BYTE);

		map.put(short.class, TYPE_SHORT);
		map.put(Short.class, TYPE_SHORT);

		map.put(int.class, TYPE_INT);
		map.put(Integer.class, TYPE_INT);

		map.put(long.class, TYPE_LONG);
		map.put(Long.class, TYPE_LONG);

		map.put(boolean.class, TYPE_BOOLEAN);
		map.put(Boolean.class, TYPE_BOOLEAN);

		map.put(float.class, TYPE_DOUBLE);
		map.put(Float.class, TYPE_DOUBLE);

		map.put(double.class, TYPE_DOUBLE);
		map.put(Double.class, TYPE_DOUBLE);

		map.put(char.class, TYPE_CHAR);
		map.put(Character.class, TYPE_CHAR);

		map.put(String.class, TYPE_STRING);
		map.put(Date.class, TYPE_STRING);
		
		
		map.put(byte[].class, TYPE_CONTAINER_LIST_BYTE);
		map.put(Byte[].class, TYPE_CONTAINER_LIST_BYTE);

		map.put(short[].class, TYPE_CONTAINER_LIST_SHORT);
		map.put(Short[].class, TYPE_CONTAINER_LIST_SHORT);

		map.put(int[].class, TYPE_CONTAINER_LIST_INT);
		map.put(Integer[].class, TYPE_CONTAINER_LIST_INT);

		map.put(long[].class, TYPE_CONTAINER_LIST_LONG);
		map.put(Long[].class, TYPE_CONTAINER_LIST_LONG);

		map.put(boolean[].class, TYPE_CONTAINER_LIST_BOOLEAN);
		map.put(Boolean[].class, TYPE_CONTAINER_LIST_BOOLEAN);

		map.put(float[].class, TYPE_CONTAINER_LIST_DOUBLE);
		map.put(Float[].class, TYPE_CONTAINER_LIST_DOUBLE);

		map.put(double[].class, TYPE_CONTAINER_LIST_DOUBLE);
		map.put(Double[].class, TYPE_CONTAINER_LIST_DOUBLE);

		map.put(char[].class, TYPE_CONTAINER_LIST_CHAR);
		map.put(Character[].class, TYPE_CONTAINER_LIST_CHAR);

		map.put(String[].class, TYPE_CONTAINER_LIST_STRING);
	}

	public static String java2thrift(Class<?> c) {
		return java2thrift(c, c.getPackage().getName(), c.getSimpleName());
	}

	public static String java2thrift(Class<?> c, String namespace,
			String structName) {
		StringBuilder sb = new StringBuilder();
		sb.append("namespace java ").append(namespace);
		sb.append(LS);

		Field[] fields = c.getDeclaredFields();
		if (null == fields || fields.length < 1) {
			return sb.toString();
		}

		sb.append("struct ").append(structName).append("{");
		sb.append(LS);

		int i = 1;
		for (Field f : fields) {
			f.setAccessible(true);
			int modifiers = f.getModifiers();
			if (Modifier.isStatic(modifiers))
				continue;
			if (Modifier.isFinal(modifiers))
				continue;

			Class<?> ctype = f.getType();

			String type = map.get(ctype);
			if (ctype.isAssignableFrom(List.class)
					|| ctype.isAssignableFrom(Set.class)
					|| ctype.isAssignableFrom(Map.class)) {
				type = type2string(f, ctype);
			}

			if (type == null)
				type = "string";

			sb.append("\t ").append(i).append(": ")
					.append(type).append("\t").append(f.getName()).append(";")
					.append(LS);

			i++;
		}

		sb.append("}");
		return sb.toString();
	}

	private static String type2string(Field field, Class<?> ctype) {
		try {
			Type gtype = field.getGenericType();
			if(gtype == field.getType()){
				//没有用到泛型
				if (ctype.isAssignableFrom(List.class))
					return "list";
				if (ctype.isAssignableFrom(Set.class))
					return "set";
				if (ctype.isAssignableFrom(Map.class))
					return "map";
			}

			String signature = gtype.toString();

			if (signature.startsWith("java.util.List")) {
				String s = signature.substring(signature.indexOf("<") + 1,
						signature.length() - 1);
				return "list<" + getTypeStr(s) + ">";
			} else if (signature.startsWith("java.util.Set")) {
				String s = signature.substring(signature.indexOf("<") + 1,
						signature.length() - 1);
				return "set<" + getTypeStr(s) + ">";
			} else if (signature.startsWith("java.util.Map")) {
				String s = signature.substring(signature.indexOf("<") + 1,
						signature.length() - 1);
				String[] ss = s.split(",");
				return "map<" + getTypeStr(ss[0]) + "," + getTypeStr(ss[1].trim())
						+ ">";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getTypeStr(String str) {
		switch (str) {
			case "java.lang.String":
				return TYPE_STRING;
			case "java.lang.Integer":
				return TYPE_INT;
			case "java.lang.Byte":
				return TYPE_BYTE;
			case "java.lang.Long":
				return TYPE_LONG;
			case "java.lang.Boolean":
				return TYPE_BOOLEAN;
			case "java.lang.Short":
			case "java.lang.Character":
				return TYPE_SHORT;
			case "java.lang.Float":
			case "java.lang.Double":
				return TYPE_DOUBLE;
			case "float[]":
			case "java.lang.Float[]":
				return TYPE_CONTAINER_LIST_FLOAT;
			case "double[]":
			case "java.lang.Double[]":
				return TYPE_CONTAINER_LIST_DOUBLE;
			case "java.lang.String[]":
				return TYPE_CONTAINER_LIST_STRING;
			case "int[]":
			case "java.lang.Integer[]":
				return TYPE_CONTAINER_LIST_INT;
			case "long[]":
			case "java.lang.Long[]":
				return TYPE_CONTAINER_LIST_LONG;
			case "byte[]":
			case "java.lang.Byte[]":
				return TYPE_CONTAINER_LIST_BYTE;
			case "short[]":
			case "java.lang.Short[]":
				return TYPE_CONTAINER_LIST_SHORT;
			case "boolean[]":
			case "java.lang.Boolean[]":
				return TYPE_CONTAINER_LIST_BOOLEAN;
			case "char[]":
			case "java.lang.Character[]":
				return TYPE_CONTAINER_LIST_CHAR;
			default:
				return "string";
		}
	}

}
