package com.sparknetworks.filterhandler.utils;

import java.util.Map;
import java.util.Objects;

import org.springframework.http.ResponseEntity;

public class Helper {
	private static Helper helper = null;

	public String getViewByResponse(ResponseEntity<?> response) {
		String view = "";
		switch (response.getStatusCode()) {
		case GONE:
			view = Const.REDIRECT;
			break;
		case BAD_REQUEST:
			view = Const.ERROR;
			break;
		case EXPECTATION_FAILED:
			view = Const.ERROR;
			break;
		default:
			view = Const.SUCCESS;
		}
		return view;
	}

	private Helper() {

	}

	public <T, V> boolean isNullOrEmptyMap(Map<T, V> map) {
		return Objects.isNull(map) || map.isEmpty();
	}

	public boolean isNullOrEmptyString(String string) {
		return Objects.isNull(string) || string.isEmpty();
	}

	// Double check locking
	public static Helper getInstance() {
		if (Objects.isNull(helper))
			synchronized (Helper.class) {
				if (Objects.isNull(helper))
					helper = new Helper();
			}
		return helper;
	}
}
