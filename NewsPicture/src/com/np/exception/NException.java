package com.np.exception;

@SuppressWarnings("serial")
public class NException extends RuntimeException {

		// 提供一个无参数的构造器
		public NException() {
		}

		// 提供一个带字符串参数的构造器
		public NException(String msg) {
			super(msg);
		}
	}

