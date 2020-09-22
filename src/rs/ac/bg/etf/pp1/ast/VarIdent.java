// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class VarIdent implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varName;
    private BracketOption BracketOption;

    public VarIdent (String varName, BracketOption BracketOption) {
        this.varName=varName;
        this.BracketOption=BracketOption;
        if(BracketOption!=null) BracketOption.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public BracketOption getBracketOption() {
        return BracketOption;
    }

    public void setBracketOption(BracketOption BracketOption) {
        this.BracketOption=BracketOption;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BracketOption!=null) BracketOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BracketOption!=null) BracketOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BracketOption!=null) BracketOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdent(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(BracketOption!=null)
            buffer.append(BracketOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdent]");
        return buffer.toString();
    }
}
