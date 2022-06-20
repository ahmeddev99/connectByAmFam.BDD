package reporting;

import java.util.logging.Logger;

public class Loggers {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void log(final String msg) {
		LOGGER.info(msg);
		}
}
