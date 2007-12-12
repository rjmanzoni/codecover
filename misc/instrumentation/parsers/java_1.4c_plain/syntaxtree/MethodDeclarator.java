//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> &lt;IDENTIFIER&gt;
 * f1 -> FormalParameters()
 * f2 -> ( "[" "]" )*
 * </PRE>
 */
public class MethodDeclarator implements Node {
   private Node parent;
   public NodeToken f0;
   public FormalParameters f1;
   public NodeListOptional f2;

   public MethodDeclarator(NodeToken n0, FormalParameters n1, NodeListOptional n2) {
      f0 = n0;
      if ( f0 != null ) f0.setParent(this);
      f1 = n1;
      if ( f1 != null ) f1.setParent(this);
      f2 = n2;
      if ( f2 != null ) f2.setParent(this);
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

