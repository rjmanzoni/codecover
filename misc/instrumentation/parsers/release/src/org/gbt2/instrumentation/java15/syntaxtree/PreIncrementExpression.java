﻿///////////////////////////////////////////////////////////////////////////////
//
// $Id$
// 
// created by: Christoph Müller
// created at: 24.02.2007 17:30:00
//
///////////////////////////////////////////////////////////////////////////////

//
// Generated by JTB 1.3.2
//

package org.gbt2.instrumentation.java15.syntaxtree;

import java.io.IOException;

import org.gbt2.instrumentation.java15.visitor.GJNoArguVisitor;
import org.gbt2.instrumentation.java15.visitor.GJVisitor;
import org.gbt2.instrumentation.java15.visitor.GJVoidVisitor;
import org.gbt2.instrumentation.java15.visitor.Visitor;
import org.gbt2.instrumentation.java15.visitor.VisitorWithException;

/**
 * Grammar production:
 * 
 * <PRE>
 * 
 * f0 -> "++" f1 -> PrimaryExpression()
 * 
 * </PRE>
 */
public class PreIncrementExpression implements Node {
    private Node parent;

    public NodeToken f0;

    public PrimaryExpression f1;

    public PreIncrementExpression(NodeToken n0, PrimaryExpression n1) {
        f0 = n0;
        if (f0 != null)
            f0.setParent(this);
        f1 = n1;
        if (f1 != null)
            f1.setParent(this);
    }

    public PreIncrementExpression(PrimaryExpression n0) {
        f0 = new NodeToken("++");
        if (f0 != null)
            f0.setParent(this);
        f1 = n0;
        if (f1 != null)
            f1.setParent(this);
    }

    public void accept(VisitorWithException v) throws IOException {
        v.visit(this);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public <R, A> R accept(GJVisitor<R, A> v, A argu) {
        return v.visit(this, argu);
    }

    public <R> R accept(GJNoArguVisitor<R> v) {
        return v.visit(this);
    }

    public <A> void accept(GJVoidVisitor<A> v, A argu) {
        v.visit(this, argu);
    }

    public void setParent(Node n) {
        parent = n;
    }

    public Node getParent() {
        return parent;
    }
}
