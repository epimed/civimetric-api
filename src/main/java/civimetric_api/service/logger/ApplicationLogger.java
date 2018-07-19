package civimetric_api.service.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ApplicationLogger {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
