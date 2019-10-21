package impl;

import java.lang.reflect.Field;
import java.util.Optional;

import anno.JsonName;

public class JsonNameProcessor {
	public static String toJson(Object obj) throws IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("\t\"");
		Class<?> clazz = obj.getClass();
		JsonName jsonName = clazz.getDeclaredAnnotation(JsonName.class);
		sb.append(Optional.ofNullable(jsonName).map(JsonName::name).orElse(clazz.getSimpleName()));
		sb.append("\": {\n");
		Field[] fields = clazz.getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			sb.append("\t\t\"");
			Field fieldElm = fields[i];
			fieldElm.setAccessible(true);
			JsonName fieldJsonName = fieldElm.getDeclaredAnnotation(JsonName.class);
			sb.append(Optional.ofNullable(fieldJsonName).map(JsonName::name).orElse(fieldElm.getName()));
			sb.append("\": ");
			if(fieldElm.getType() == String.class || !fieldElm.getType().isPrimitive()) {
				sb.append("\"");
				sb.append(fieldElm.get(obj));
				sb.append("\"");
			}else {
				sb.append(fieldElm.get(obj));
			}
			if(i < (fields.length-1)) sb.append(",");
			sb.append("\n");
		}
		sb.append("\t}\n");
		sb.append("}");
		return sb.toString();
	}
}
