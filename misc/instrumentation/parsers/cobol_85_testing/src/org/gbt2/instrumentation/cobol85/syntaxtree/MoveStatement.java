﻿///////////////////////////////////////////////////////////////////////////////
//
// $Id$
// 
///////////////////////////////////////////////////////////////////////////////

//
// Generated by JTB 1.3.2
//

package org.gbt2.instrumentation.cobol85.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> &lt;MOVE&gt;
 * f1 -> ( ( Identifier() | Literal() ) &lt;TO&gt; ( Identifier() )+ | ( &lt;CORRESPONDING&gt; | &lt;CORR&gt; ) QualifiedDataName() &lt;TO&gt; ( QualifiedDataName() )+ )
 * </PRE>
 */
public class MoveStatement implements Node {
   private Node parent;
   public NodeToken f0;
   public NodeChoice f1;

   public MoveStatement(NodeToken n0, NodeChoice n1) {
      f0 = n0;
      if ( f0 != null ) f0.setParent(this);
      f1 = n1;
      if ( f1 != null ) f1.setParent(this);
   }

   public MoveStatement(NodeChoice n0) {
      f0 = new NodeToken("move");
      if ( f0 != null ) f0.setParent(this);
      f1 = n0;
      if ( f1 != null ) f1.setParent(this);
   }

   public void accept(org.gbt2.instrumentation.cobol85.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(org.gbt2.instrumentation.cobol85.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(org.gbt2.instrumentation.cobol85.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(org.gbt2.instrumentation.cobol85.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

