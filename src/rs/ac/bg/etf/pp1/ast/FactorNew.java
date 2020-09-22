// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private ExprSquareOption ExprSquareOption;

    public FactorNew (Type Type, ExprSquareOption ExprSquareOption) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprSquareOption=ExprSquareOption;
        if(ExprSquareOption!=null) ExprSquareOption.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprSquareOption getExprSquareOption() {
        return ExprSquareOption;
    }

    public void setExprSquareOption(ExprSquareOption ExprSquareOption) {
        this.ExprSquareOption=ExprSquareOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprSquareOption!=null) ExprSquareOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprSquareOption!=null) ExprSquareOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprSquareOption!=null) ExprSquareOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprSquareOption!=null)
            buffer.append(ExprSquareOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
