package com.ezen.phonefly2.util;

import java.util.HashMap;

public class LowerKeyMap extends HashMap<String, Object> {
	private static final long serialVersionUID = -7700790403928325865L;

	@Override
	public Object put(String key, Object value) {
		return super.put(key.toLowerCase(), value);
	}

	@Override
	public Object get(Object key) {
		return super.get(((String)key).toLowerCase());
	}
}
