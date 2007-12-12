//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> ArrayInitializer()
 *       | Expression()
 * </PRE>
 */
public class VariableInitializer implements Node {
   private Node parent;
   public NodeChoice f0;

   public VariableInitializer(NodeChoice n0) {
      f0 = n0;
      if ( f0 != null ) f0.setParent(this);
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

