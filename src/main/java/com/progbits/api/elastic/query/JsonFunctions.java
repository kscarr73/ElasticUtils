package com.progbits.api.elastic.query;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author scarr
 */
public class JsonFunctions {

	private static DateTimeFormatter format = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

	public static void processFieldValue(StringBuilder sb, Object value) {
		processFieldValue(sb, value, true);
	}

	public static void processFieldValue(StringBuilder sb, Object value,
			boolean bLower) {

		if (value instanceof String) {
			sb.append("\"");
			if (bLower) {
				sb.append(((String) value).replace("\"", "\\\"").toLowerCase());
			} else {
				sb.append(((String) value).replace("\"", "\\\""));
			}
			sb.append("\"");
		} else if (value instanceof OffsetDateTime) {
			sb.append("\"");
			sb.append(((OffsetDateTime) value).format(format));
			sb.append("\"");
		} else {
			sb.append(value);
		}
	}

	public static void processFieldName(StringBuilder sb, String fieldName) {
		sb.append("\"");
		sb.append(fieldName);
		sb.append("\": ");
	}
}
