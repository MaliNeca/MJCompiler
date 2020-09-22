// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class ConditionFactMany extends ConditionFactList {

    private ConditionFactList ConditionFactList;
    private CondFact CondFact;

    public ConditionFactMany (ConditionFactList ConditionFactList, CondFact CondFact) {
        this.ConditionFactList=ConditionFactList;
        if(ConditionFactList!=null) ConditionFactList.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public ConditionFactList getConditionFactList() {
        return ConditionFactList;
    }

    public void setConditionFactList(ConditionFactList ConditionFactList) {
        this.ConditionFactList=ConditionFactList;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFactList!=null) ConditionFactList.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFactList!=null) ConditionFactList.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFactList!=null) ConditionFactList.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFactMany(\n");

        if(ConditionFactList!=null)
            buffer.append(ConditionFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFactMany]");
        return buffer.toString();
    }
}
