package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.APlus;
import rs.ac.bg.etf.pp1.ast.ActP;
import rs.ac.bg.etf.pp1.ast.ActParsDesignatorOptionY;
import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AddopTerms;
import rs.ac.bg.etf.pp1.ast.Assign;
import rs.ac.bg.etf.pp1.ast.Decrement;
import rs.ac.bg.etf.pp1.ast.DesignatorExprLSquare;
import rs.ac.bg.etf.pp1.ast.DesignatorIdentExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement;
import rs.ac.bg.etf.pp1.ast.Divv;
import rs.ac.bg.etf.pp1.ast.Expr;
import rs.ac.bg.etf.pp1.ast.ExprSquareOptionYes;
import rs.ac.bg.etf.pp1.ast.FactorBoolean;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorDesig;
import rs.ac.bg.etf.pp1.ast.FactorExpr;
import rs.ac.bg.etf.pp1.ast.FactorNew;
import rs.ac.bg.etf.pp1.ast.FactorNumber;
import rs.ac.bg.etf.pp1.ast.Increment;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeNamee;
import rs.ac.bg.etf.pp1.ast.MethodVoidName;
import rs.ac.bg.etf.pp1.ast.MinusOption;
import rs.ac.bg.etf.pp1.ast.Minuss;
import rs.ac.bg.etf.pp1.ast.Modd;
import rs.ac.bg.etf.pp1.ast.Mull;
import rs.ac.bg.etf.pp1.ast.PrintS;
import rs.ac.bg.etf.pp1.ast.ReadS;
import rs.ac.bg.etf.pp1.ast.ReturnS;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.TermMany;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.YesNumOption;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPC;

	public int getMainPC() {
		return mainPC;
	}

	

	public void visit(Assign assign) {
		DesignatorStatement designatorStatement = (DesignatorStatement) assign.getParent();
		Code.store(designatorStatement.getDesignator().obj);
	}

	public void visit(Increment increment) {
		DesignatorStatement designatorStatement = (DesignatorStatement) increment.getParent();

		if (designatorStatement.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}

		Code.load(designatorStatement.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorStatement.getDesignator().obj);
	}
	
	public void visit(Decrement decrement) {
		DesignatorStatement designatorStatement = (DesignatorStatement) decrement.getParent();

		if (designatorStatement.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}

		Code.load(designatorStatement.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorStatement.getDesignator().obj);
	}
	
	public void visit(ReadS readS) {
		
		Code.load(readS.getDesignator().obj);
		
		if(!readS.getDesignator().obj.getType().equals(Tab.charType)) {
			Code.put(Code.read);
		}else {
			Code.put(Code.bread);
		}
		
		Code.store(readS.getDesignator().obj);
	}
	
	public void visit(PrintS printS) {

		int w = 5;

		if (printS.getNumOption() instanceof YesNumOption) {
			YesNumOption yesNumOption = (YesNumOption) printS.getNumOption();
			w = yesNumOption.getNum();
		}

		if (printS.getExpr().struct == Tab.intType) {
			Code.loadConst(w);
			Code.put(Code.print);
		} else {
			Code.loadConst(w);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(Expr expr) {
		if(expr.getMinusOption() instanceof Minuss) {
			Code.put(Code.neg);
		}
		

	}
	
	public void visit(AddopTerms addopTerms) {
		if(addopTerms.getAddop() instanceof APlus) {
			Code.put(Code.add);
		}else {
			Code.put(Code.sub);
		}
	}
	
	public void visit(TermMany termMany) {
		
		if(termMany.getMulop() instanceof Mull) {
			Code.put(Code.mul);
		}else if (termMany.getMulop() instanceof Divv) {
			Code.put(Code.div);
		}else if(termMany.getMulop() instanceof Modd) {
			Code.put(Code.rem);
		}
		
		
	}
	
	public void visit(FactorDesig factorDesig) {
		Obj func = factorDesig.getDesignator().obj;
		if(func.getKind() == Obj.Meth && factorDesig.getActParsDesignatorOption() instanceof ActParsDesignatorOptionY)
		{
			int offset = func.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);

		}else {
			Code.load(factorDesig.getDesignator().obj);
		}
		
	}
	
	public void visit(FactorNumber factorNumber) {
		Code.loadConst(factorNumber.getNumber());
	}
	
	public void visit(FactorChar factorChar) {
		Code.loadConst(factorChar.getCharr());
	}
	
	public void visit(FactorNew factorNew) {
		if(factorNew.getExprSquareOption() instanceof ExprSquareOptionYes) {
			Code.put(Code.newarray);
			if(!factorNew.getType().struct.equals(Tab.charType)) {
				Code.put(1);
			}else {
				Code.put(0);
			}
			
		}
	}
	
	public void visit(FactorBoolean factorBoolean) {
		if(factorBoolean.getBool()) {
			Code.loadConst(1);
		}else {
			Code.loadConst(0);
		}
		
	}
	
	public void visit(DesignatorExprLSquare designatorExprLSquare) {
		Code.load(designatorExprLSquare.getDesignator().obj);
	}
	
	public void visit(MethodDecl methodDecl) {
		
		if(methodDecl.getMethodTypeName() instanceof MethodVoidName) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}else {
			Code.put(Code.trap);
			Code.put(1);
		}
		
	}
	
	public void visit(MethodVoidName methodVoidName) {
		if(methodVoidName.getMethName().equals("main")) {
			mainPC = Code.pc;
		}
		
		methodVoidName.obj.setAdr(Code.pc);
		
		
		SyntaxNode methodNode = methodVoidName.getParent();
		
		VarCounter varCounter = new VarCounter();
		methodNode.traverseTopDown(varCounter);
		
		FormParamCounter formParamCounter = new FormParamCounter();
		methodNode.traverseTopDown(formParamCounter);
		methodVoidName.obj.setLevel(formParamCounter.getCount());
		Code.put(Code.enter);
		Code.put(formParamCounter.getCount());
		Code.put(formParamCounter.getCount() + varCounter.getCount());
		
	}
	
	public void visit(MethodTypeNamee methodTypeNamee) {
		
		methodTypeNamee.obj.setAdr(Code.pc);
		
		SyntaxNode methodNode = methodTypeNamee.getParent();
		
		VarCounter varCounter = new VarCounter();
		methodNode.traverseTopDown(varCounter);
		
		FormParamCounter formParamCounter = new FormParamCounter();
		methodNode.traverseTopDown(formParamCounter);
		
		methodTypeNamee.obj.setLevel(formParamCounter.getCount());
		Code.put(Code.enter);
		Code.put(formParamCounter.getCount());
		Code.put(formParamCounter.getCount() + varCounter.getCount());
	}
	
	public void visit(ActP actP) {
		DesignatorStatement designatorStatement = (DesignatorStatement) actP.getParent();
		if (designatorStatement.getDesignator().obj.getKind() == Obj.Meth) {
			Obj funcCall = designatorStatement.getDesignator().obj;
			int offset = funcCall.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);

			
		}
	}
	
	public void visit(ReturnS returnS) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
}
