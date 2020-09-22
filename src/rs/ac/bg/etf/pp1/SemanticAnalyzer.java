package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor {
	Struct lastType = null;
	int printCallCount = 0;
	int varDeclCount = 0;
	boolean errorDetected = false;
	boolean enumOpened = false;
	boolean returnFound = false;
	ArrayList<Integer> enumList = new ArrayList<>();
	int enumValue = 0;
	Obj currentMeth = null;
	boolean mainMethod = false;
	int nVars;
	ArrayList<Struct> params = new ArrayList<Struct>();
	Logger log = Logger.getLogger(getClass());
	int nPar = 0;

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(VarIdent varIdent) {
		varDeclCount++;
		Obj varNode = Tab.currentScope.findSymbol(varIdent.getVarName());
		if (varNode != null) {
			report_error("Greska, promenljiva sa imenom " + varIdent.getVarName() + " je vec deklarisana", varIdent);
		} else {
			if (varIdent.getBracketOption() instanceof Bracket) {
				varNode = Tab.insert(Obj.Var, varIdent.getVarName(), new Struct(Struct.Array, lastType));
			} else {
				varNode = Tab.insert(Obj.Var, varIdent.getVarName(), lastType);
			}
		}

	}

	public void visit(NumConst numConst) {
		if (!lastType.equals(Tab.intType)) {
			report_error("Greska, tipovi nisu kompatibilni", numConst);
		}
		Obj numNode = Tab.currentScope.findSymbol(numConst.getIdentName());
		if (numNode != null) {
			report_error("Greska, promenljiva sa imenom " + numConst.getIdentName() + " je vec deklarisana", numConst);

		} else {
			numNode = Tab.insert(Obj.Con, numConst.getIdentName(), lastType);
			numNode.setAdr(numConst.getNumber());
		}
	}

	public void visit(CharConst charConst) {
		if (!lastType.equals(Tab.charType)) {
			report_error("Greska, tipovi nisu komatibilni", charConst);

		}
		Obj charNode = Tab.currentScope.findSymbol(charConst.getIdentName());
		if (charNode != null) {
			report_error("Greska, promenljiva sa imenom " + charConst.getIdentName() + " je vec deklarisana",
					charConst);
		} else {
			charNode = Tab.insert(Obj.Con, charConst.getIdentName(), lastType);
			charNode.setAdr(charConst.getCharr());
		}
	}

	public void visit(BooleanConst booleanConst) {
		if (!lastType.equals(Compiler.boolType)) {
			report_error("Greska, tipovi nisu komatibilni", booleanConst);
		}
		Obj boolNode = Tab.currentScope.findSymbol(booleanConst.getIdentName());
		if (boolNode != null) {
			report_error("Greska, promenljiva sa imenom " + booleanConst.getIdentName() + " je vec deklarisana",
					booleanConst);

		} else {
			boolNode = Tab.insert(Obj.Con, booleanConst.getIdentName(), lastType);
			boolNode.setAdr(booleanConst.getBool() ? 1 : 0);
		}
	}

	public void visit(EnumDeclaration enumDecl) {
		Struct enumStruct = new Struct(Struct.Enum);
		enumStruct.setMembers(Tab.currentScope.getLocals());
		enumStruct.setElementType(Tab.intType);
		Tab.closeScope();
		enumOpened = false;
		enumList.clear();
		Obj enumNode = Tab.currentScope.findSymbol(enumDecl.getIdentName());
		if (enumNode != null) {
			report_error("Greska, promenljiva sa imenom " + enumDecl.getIdentName() + " je vec deklarisana", enumDecl);
		} else {
			enumNode = Tab.insert(Obj.Type, enumDecl.getIdentName(), enumStruct);
		}
	}

	public void visit(EnumIdent enumIdent) {
		if (enumOpened == false) {
			Tab.openScope();
			enumOpened = true;
		}
		Obj enumNode = Tab.currentScope.findSymbol(enumIdent.getIdentName());
		if (enumNode != null) {
			report_error("Greska, promenljiva sa imenom " + enumIdent.getIdentName() + " je vec deklarisana",
					enumIdent);
		} else {
			if (enumIdent.getValueOption() instanceof YesValueOption) {
				YesValueOption vo = (YesValueOption) enumIdent.getValueOption();
				enumValue = vo.getN1();
			}
			if (enumList.contains(enumValue)) {
				report_error(
						"Greska, promenljiva nabrajanja sa imenom " + enumIdent.getIdentName() + " je vec deklarisana",
						enumIdent);
			}
			enumNode = Tab.insert(Obj.Con, enumIdent.getIdentName(), Tab.intType);
			enumNode.setAdr(enumValue);
			enumNode.setLevel(0);
			enumList.add(enumValue);
			enumValue++;

		}
	}

	public void visit(PrintS printS) {
		if (!printS.getExpr().struct.compatibleWith(Tab.intType)
				&& !printS.getExpr().struct.compatibleWith(Tab.charType)
				&& !printS.getExpr().struct.compatibleWith(Compiler.boolType)) {
			report_error("Greska, expr nije kompatibilan sa int, char ili boolean", printS);
		}
		printCallCount++;
	}

	public void visit(ReadS readS) {
		if (readS.getDesignator().obj.getKind() != Obj.Var && readS.getDesignator().obj.getKind() != Obj.Fld
				&& readS.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Greska, read nije tipa promenljive, polja ili elementa", readS);
		}
		if (!readS.getDesignator().obj.getType().equals(Tab.intType)
				&& !readS.getDesignator().obj.getType().equals(Tab.charType)
				&& !readS.getDesignator().obj.getType().equals(Compiler.boolType)) {
			report_error("Greska, read nije tipa int, char ili boolean", readS);
		}
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if (!mainMethod) {
			report_error("Greska, ne postoji main methoda", null);
		}

		mainMethod = false;

	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + "u tabeli simbola", null);
			type.struct = Tab.noType;

		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip", type);
				type.struct = Tab.noType;
			}
		}

		lastType = type.struct;

		if (lastType.getKind() == Struct.Enum) {
			lastType = lastType.getElemType();
		}

	}

	public void visit(MethodTypeNamee methodTypeName) {
		currentMeth = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
		methodTypeName.obj = currentMeth;
		
		Tab.openScope();
		
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);

	}

	public void visit(MethodVoidName methodVoidName) {
		currentMeth = Tab.insert(Obj.Meth, methodVoidName.getMethName(), Tab.noType);
		
		methodVoidName.obj = currentMeth;
		Tab.openScope();
		report_info("Obradjuje se void funkcija " + methodVoidName.getMethName(), methodVoidName);
	}

	public void visit(FormParam formParam) {
		Obj varNode = Tab.currentScope.findSymbol(formParam.getI2());
		if (varNode != null) {
			report_error("Greska, promenljiva sa imenom " + formParam.getI2() + " je vec deklarisana", formParam);
		} else {
			if (formParam.getBracketOption() instanceof Bracket) {
				varNode = Tab.insert(Obj.Var, formParam.getI2(), new Struct(Struct.Array, lastType));
			} else {
				varNode = Tab.insert(Obj.Var, formParam.getI2(), lastType);
			}
		}
		
		
	}
	public void visit(MethodDecl methodDecl) {
		
		if (methodDecl.getMethodTypeName() instanceof MethodVoidName
				&& methodDecl.getFormParsOption() instanceof NoFormPars
				&& methodDecl.getMethodTypeName().obj.getName().equals("main")) {
			mainMethod = true;
		}
		
		if(!returnFound && currentMeth.getType() != Tab.noType) {
			
			report_error("Semantika greska na liniji " + methodDecl.getLine() + " funkcija " + currentMeth.getName() + " nema return iskaz", methodDecl);
			
		}
		
		

		Tab.chainLocalSymbols(currentMeth);
		Tab.closeScope();
		returnFound = false;
		currentMeth = null;
	}

	public void visit(DesignatorIdent designatorIdent) {
		Obj designatorNode = Tab.find(designatorIdent.getDesignatorName());

		if (designatorNode == Tab.noObj) {
			report_error("Greska na liniji " + designatorIdent.getLine() + " :promenljiva "
					+ designatorIdent.getDesignatorName() + " nije deklarisana!", null);
		}
		designatorIdent.obj = designatorNode;
//		if(designatorNode.getKind() == Obj.Meth) {
//			params.add(designatorNode.getType());
//		}
		
		DumpSymbolTableVisitor symbolTableVisitor = new DumpSymbolTableVisitor();
		symbolTableVisitor.visitObjNode(designatorNode);
		if (designatorNode.getKind() == Obj.Var) {

			if (designatorNode.getLevel() == 0) {
				log.info("Pronadjena globalna promenljiva na liniji " + designatorIdent.getLine() + " :ime "
						+ designatorIdent.getDesignatorName() + " " + symbolTableVisitor.getOutput());
			} else {
				log.info("Pronadjena lokalna promenljiva na liniji " + designatorIdent.getLine() + " :ime "
						+ designatorIdent.getDesignatorName() + " " + symbolTableVisitor.getOutput());
			}
		}
	}

	public void visit(DesignatorIdentFullstopIdent designatorIdentFullstopIdent) {
		if (designatorIdentFullstopIdent.getDesignator().obj.getType().getMembersTable()
				.searchKey(designatorIdentFullstopIdent.getI2()) == null) {
			report_error("Greska, u enumu: " + designatorIdentFullstopIdent.obj.getName() + " ne postoji vrednost "
					+ designatorIdentFullstopIdent.getI2(), designatorIdentFullstopIdent);
		}
		designatorIdentFullstopIdent.obj = designatorIdentFullstopIdent.getDesignator().obj.getType().getMembersTable()
				.searchKey(designatorIdentFullstopIdent.getI2());
	}

	public void visit(DesignatorIdentExpr designatorIdentExpr) {

		if (designatorIdentExpr.getDesignatorExprLSquare().getDesignator().obj.getType().getKind() != Struct.Array) {
			// greska niz
			report_error("Greska, designator nije niz", designatorIdentExpr);
		}

		if (designatorIdentExpr.getExpr().struct.getKind() != Struct.Enum) {
			if (!designatorIdentExpr.getExpr().struct.compatibleWith(Tab.intType)) {
				// greska int
				report_error("Greska, expr nije tipa int", designatorIdentExpr);
			}
		}
		designatorIdentExpr.obj = new Obj(Obj.Elem, "",
				designatorIdentExpr.getDesignatorExprLSquare().getDesignator().obj.getType().getElemType());
	}

	public void visit(FactorDesig factorDesig) {
		Obj func = factorDesig.getDesignator().obj;
		if (func.getKind() != Obj.Meth
				&& factorDesig.getActParsDesignatorOption() instanceof ActParsDesignatorOptionY) {
			report_error("Designator nije metoda ", factorDesig);
			factorDesig.struct = Tab.noType;
		}else if (func.getKind() == Obj.Meth && factorDesig.getActParsDesignatorOption() instanceof ActParsDesignatorOptionY) {
			
			report_info("Pronadjen poziv funkcije " + factorDesig.getDesignator().obj.getName() + " na liniji " + factorDesig.getLine(), null);
			Obj met = Tab.find(func.getName());
			Collection<Obj> locals = met.getLocalSymbols();
			factorDesig.struct = Tab.intType;
//			if(params.size() != locals.size()) {
//				report_error("Greska, formalni parametri se ne slazu po broju " , factorDesig);
//			}else {
//				int i = 0;
//				for (Obj obj : locals) {
//					if(!obj.getType().compatibleWith(params.get(i))) {
//						report_error("Greska 1", factorDesig);
//					}
//					i++;
//				}
//			}
			
			int i = params.size() - 1;
			for(Obj obj : locals) {
				if(!obj.getType().compatibleWith(params.get(i))) {
					report_error("Greska, paramentri nisu kompatibilni", factorDesig);
				}
				params.remove(i);
				i--;
			}
			
			
		}else if(func.getKind() == Obj.Var 
				|| func.getKind() == Obj.Con || func.getKind() == Obj.Elem
				|| func.getKind() == Obj.Fld ){
				
				factorDesig.struct = func.getType();
				
			}
			
		
					
		}
	

	public void visit(FactorNumber factorNumber) {
		factorNumber.struct = Tab.intType;
	}

	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}

	public void visit(FactorBoolean factorBoolean) {
		factorBoolean.struct = Compiler.boolType;
	}

	public void visit(FactorNew factorNew) {
		if (factorNew.getExprSquareOption() instanceof ExprSquareOptionYes) {

			ExprSquareOptionYes exprSquare = (ExprSquareOptionYes) factorNew.getExprSquareOption();

			if (exprSquare.getExpr().struct.compatibleWith(Tab.intType)) {
				factorNew.struct = new Struct(Struct.Array, lastType);
			} else {
				report_error("Greska, expr nije tipa int", factorNew);
			}
		} else {
			factorNew.struct = lastType;
		}

	}

	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
	}

	public void visit(Assign assign) {
		DesignatorStatement designatorStatement = (DesignatorStatement) assign.getParent();
		if (designatorStatement.getDesignator().obj.getKind() != Obj.Var
				&& designatorStatement.getDesignator().obj.getKind() != Obj.Elem
				&& designatorStatement.getDesignator().obj.getKind() != Obj.Fld) {
			report_error("Greska, designator nije promenljiva, element ili polje", assign);
		}
		if (!assign.getExpr().struct.assignableTo(designatorStatement.getDesignator().obj.getType())) {
			report_error("Greska, expr i designator nisu istog tipaaaa", assign);
		}

	}

	public void visit(ActP actP) {
		DesignatorStatement designatorStatement = (DesignatorStatement) actP.getParent();
		if (designatorStatement.getDesignator().obj.getKind() != Obj.Meth) {
			report_error("Greska, designator nije tipa metode", designatorStatement);
		}else {
		
		//poziv funkcije
		report_info("Pronadjen poziv funkcijee " + designatorStatement.getDesignator().obj.getName() + " na liniji " + designatorStatement.getLine(), null);
		Collection<Obj> locals = designatorStatement.getDesignator().obj.getLocalSymbols();
		
		if(params.size() != locals.size()) {
			report_error("Greska, formalni parametri se ne slazu po broju " , designatorStatement);
		}else {
			int i = 0;
			for (Obj obj : locals) {
				if(!obj.getType().compatibleWith(params.get(i))) {
					report_error("Greska", designatorStatement);
				}
				i++;
			}
		}
		params.clear();
//		
		
		}
	}

	public void visit(Increment increment) {
		DesignatorStatement designatorStatement = (DesignatorStatement) increment.getParent();
		if (designatorStatement.getDesignator().obj.getKind() != Obj.Var
				&& designatorStatement.getDesignator().obj.getKind() != Obj.Elem
				&& designatorStatement.getDesignator().obj.getKind() != Obj.Fld) {
			report_error("Greska, designator nije promenljiva, element ili polje", increment);
		}
		if (!designatorStatement.getDesignator().obj.getType().equals(Tab.intType)) {
			report_error("Greska, designator nije tipa int ", increment);
		}
	}

	public void visit(Decrement decrement) {
		DesignatorStatement designatorStatement = (DesignatorStatement) decrement.getParent();
		if (designatorStatement.getDesignator().obj.getKind() != Obj.Var
				&& designatorStatement.getDesignator().obj.getKind() != Obj.Elem
				&& designatorStatement.getDesignator().obj.getKind() != Obj.Fld) {
			report_error("Greska, designator nije promenljiva, element ili polje", decrement);
		}
		if (!designatorStatement.getDesignator().obj.getType().equals(Tab.intType)) {
			report_error("Greska, designator nije tipa int ", decrement);
		}
	}

	public void visit(TermOne termOne) {
		termOne.struct = termOne.getFactor().struct;
	}

	
	public void visit(TermMany termMany) {
		if (!termMany.getFactor().struct.compatibleWith(Tab.intType)
				&& !termMany.getFactor().struct.compatibleWith(termMany.getTerm().struct)) {
			report_error("Greska, faktor nije tipa int ili nije kompatibilan sa termom", termMany);
		}
		termMany.struct = termMany.getFactor().struct;
	}

	public void visit(Expr expr) {
		if (expr.getMinusOption() instanceof NoMinus && expr.getAddopTermList() instanceof NoAddopTerms) {
			expr.struct = expr.getTerm().struct;
		} else if (expr.getMinusOption() instanceof Minuss && expr.getAddopTermList() instanceof NoAddopTerms) {
			if (!expr.getTerm().struct.compatibleWith(Tab.intType)) {
				report_error("Greska, term nije tipa int", expr);
			}
			expr.struct = expr.getTerm().struct;

		} else if (expr.getAddopTermList() instanceof AddopTerms) {
			AddopTerms addopTerms = (AddopTerms) expr.getAddopTermList();

			if (!expr.getTerm().struct.compatibleWith(Tab.intType)
					|| !expr.getTerm().struct.compatibleWith(addopTerms.getTerm().struct)) {
				report_error("Greska, expr nije tipa int ili nije kompatibilan sa termomm", expr);
			}
			expr.struct = expr.getTerm().struct;
		} else {
			report_error("NEKA GRESKA", expr);
		}
		if(expr.getParent() instanceof ExprsListMany || expr.getParent() instanceof ExprsListOne) {
			params.add(expr.struct);
		}
	}

	public void visit(AddopTerms addopTerms) {

		if (!addopTerms.getTerm().struct.compatibleWith(Tab.intType)) {
			report_error("Greska, expr nije kompatibilan sa int", addopTerms);

		}

	}

	public void visit(ReturnS returnS) {
		returnFound = true;
		
		Struct currentMethType = currentMeth.getType();
		
		YesExprOption yesExprOption = (YesExprOption) returnS.getExprOption();
		if(!currentMethType.compatibleWith(yesExprOption.getExpr().struct)) {
			report_error("Semantika greska, tip izraza u return naredbi se ne slaze sa tipom povratne vrednosti", yesExprOption.getExpr());
			
		}
	}
	
	public boolean errorD() {
		return errorDetected;
	}

}
