// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class CondTerm implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ConditionFactList ConditionFactList;

    public CondTerm (ConditionFactList ConditionFactList) {
        this.ConditionFactList=ConditionFactList;
        if(ConditionFactList!=null) ConditionFactList.setParent(this);
    }

    public ConditionFactList getConditionFactList() {
        return ConditionFactList;
    }

    public void setConditionFactList(ConditionFactList ConditionFactList) {
        this.ConditionFactList=ConditionFactList;
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
        if(ConditionFactList!=null) ConditionFactList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFactList!=null) ConditionFactList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFactList!=null) ConditionFactList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTerm(\n");

        if(ConditionFactList!=null)
            buffer.append(ConditionFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTerm]");
        return buffer.toString();
    }
}
