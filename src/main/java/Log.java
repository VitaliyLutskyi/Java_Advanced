import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	
	private static Logger LOG = Logger.getLogger(Log.class);
	
	public static void main(String[] args) {
		
		DOMConfigurator.configure("Log4j.xml");
		
		LOG.debug("DEBUG Message");
		LOG.info("INFO Message");
		LOG.warn("WARN Message");
		LOG.error("ERROR Message");
		LOG.fatal("FATAL Message");
	
	
	}
}
