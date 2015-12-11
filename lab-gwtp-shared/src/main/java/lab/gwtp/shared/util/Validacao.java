package lab.gwtp.shared.util;

public class Validacao {
	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean nonNull(Object object) {
		return !isNull(object);
	}
}
