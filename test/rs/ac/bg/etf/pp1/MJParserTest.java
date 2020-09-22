 package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class MJParserTest {
	
	public static final Struct booleanType = new Struct(Struct.Bool);
	public static final Struct enumType = new Struct(Struct.Enum);
	
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTest.class);
		
		Reader br = null;
		try {
			
			
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value); 
	        
	        
	        Tab.init();
	        Tab.currentScope.addToLocals(new Obj(Obj.Type, "boolean", booleanType));
	        Tab.currentScope.addToLocals(new Obj(Obj.Type, "enum", enumType));
	        
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// ispis prepoznatih programskih konstrukcija
			SemanticAnalyzer v = new SemanticAnalyzer();
			prog.traverseBottomUp(v); 
			
			log.info(" Print count calls = " + v.printCallCount);

			log.info(" Deklarisanih promenljivih ima = " + v.varDeclCount);
			log.info("=================");
			if(p.errorD || v.errorD()) {
				log.error("GRESKA PRILIKOM PARSIRANJA!!!");
			}else {
				Tab.dump();
				
				File objFile = new File("test/program.obj");
				if(objFile.exists()) {
					objFile.delete();
				}
				
				CodeGenerator codeGenerator = new CodeGenerator();
				prog.traverseBottomUp(codeGenerator);
				Code.dataSize = v.nVars;
				Code.mainPc = codeGenerator.getMainPC();
				Code.write(new FileOutputStream(objFile));
				
				log.info("PARSIRANJE USPESNO ZAVRSENO!!!");
				
				
				
			} 
			
			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	

}
