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
 * f0 -> &lt;START&gt;
 * f1 -> FileName()
 * f2 -> [ &lt;KEY&gt; [ &lt;IS&gt; ] ( &lt;EQUAL&gt; [ &lt;TO&gt; ] | &lt;EQUALCHAR&gt; | &lt;GREATER&gt; [ &lt;THAN&gt; ] | &lt;MORETHANCHAR&gt; | &lt;NOT&gt; &lt;LESS&gt; [ &lt;THAN&gt; ] | &lt;NOT&gt; &lt;LESSTHANCHAR&gt; | &lt;GREATER&gt; [ &lt;THAN&gt; ] &lt;OR&gt; &lt;EQUAL&gt; [ &lt;TO&gt; ] | &lt;MORETHANOREQUAL&gt; ) QualifiedDataName() ]
 * f3 -> [ &lt;INVALID&gt; [ &lt;KEY&gt; ] StatementList() ]
 * f4 -> [ &lt;NOT&gt; &lt;INVALID&gt; [ &lt;KEY&gt; ] StatementList() ]
 * f5 -> [ &lt;END_START&gt; ]
 * </PRE>
 */
public class StartStatement implements Node {
   private Node parent;
   public NodeToken f0;
   public FileName f1;
   public NodeOptional f2;
   public NodeOptional f3;
   public NodeOptional f4;
   public NodeOptional f5;

   public StartStatement(NodeToken n0, FileName n1, NodeOptional n2, NodeOptional n3, NodeOptional n4, NodeOptional n5) {
      f0 = n0;
      if ( f0 != null ) f0.setParent(this);
      f1 = n1;
      if ( f1 != null ) f1.setParent(this);
      f2 = n2;
      if ( f2 != null ) f2.setParent(this);
      f3 = n3;
      if ( f3 != null ) f3.setParent(this);
      f4 = n4;
      if ( f4 != null ) f4.setParent(this);
      f5 = n5;
      if ( f5 != null ) f5.setParent(this);
   }

   public StartStatement(FileName n0, NodeOptional n1, NodeOptional n2, NodeOptional n3, NodeOptional n4) {
      f0 = new NodeToken("start");
      if ( f0 != null ) f0.setParent(this);
      f1 = n0;
      if ( f1 != null ) f1.setParent(this);
      f2 = n1;
      if ( f2 != null ) f2.setParent(this);
      f3 = n2;
      if ( f3 != null ) f3.setParent(this);
      f4 = n3;
      if ( f4 != null ) f4.setParent(this);
      f5 = n4;
      if ( f5 != null ) f5.setParent(this);
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

