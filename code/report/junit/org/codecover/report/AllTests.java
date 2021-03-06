/******************************************************************************
 * Copyright (c) 2007 Stefan Franke, Robert Hanussek, Benjamin Keil,          *
 *                    Steffen Kieß, Johannes Langauf,                         *
 *                    Christoph Marian Müller, Igor Podolskiy,                *
 *                    Tilmann Scheller, Michael Starzmann, Markus Wittlinger  *
 * All rights reserved. This program and the accompanying materials           *
 * are made available under the terms of the Eclipse Public License v1.0      *
 * which accompanies this distribution, and is available at                   *
 * http://www.eclipse.org/legal/epl-v10.html                                  *
 ******************************************************************************/

package org.codecover.report;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Johannes Langauf
 * @version 1.0 $Id$
 */
public class AllTests {
    public static Test suite() {
        TestSuite suite = new TestSuite("Test for org.codecover.report");
        //$JUnit-BEGIN$
        suite.addTestSuite(DefaultFileCreationHandlerTest.class);
        suite.addTestSuite(TemplateTest.class);
        suite.addTestSuite(ReportTest.class);
        //$JUnit-END$
        return suite;
    }
}
