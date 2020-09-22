// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListMany extends DesignatorList {

    private DesignatorList DesignatorList;
    private IdentOrExpr IdentOrExpr;

    public DesignatorListMany (DesignatorList DesignatorList, IdentOrExpr IdentOrExpr) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.IdentOrExpr=IdentOrExpr;
        if(IdentOrExpr!=null) IdentOrExpr.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public IdentOrExpr getIdentOrExpr() {
        return IdentOrExpr;
    }

    public void setIdentOrExpr(IdentOrExpr IdentOrExpr) {
        this.IdentOrExpr=IdentOrExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(IdentOrExpr!=null) IdentOrExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(IdentOrExpr!=null) IdentOrExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(IdentOrExpr!=null) IdentOrExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListMany(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentOrExpr!=null)
            buffer.append(IdentOrExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListMany]");
        return buffer.toString();
    }
}
