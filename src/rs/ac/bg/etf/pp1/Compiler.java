package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Struct;

public class Compiler {
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	static void tsdump() {
		Tab.dump();
	}
	
	public static final Struct boolType = new Struct(Struct.Bool);
	public static final Struct enumType = new Struct(Struct.Enum);
}
