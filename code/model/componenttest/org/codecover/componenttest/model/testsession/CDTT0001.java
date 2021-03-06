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

package org.codecover.componenttest.model.testsession;

import java.util.Date;

import junit.framework.TestCase;

import org.codecover.model.MASTBuilder;
import org.codecover.model.TestSession;
import org.codecover.model.TestSessionContainer;
import org.codecover.model.exceptions.FileLoadException;
import org.codecover.model.utils.Logger;
import org.codecover.model.utils.SimpleLogger;

/**
 * 
 * @author Markus Wittlinger
 * @author Robert Hanussek
 * @version 1.0 ($Id$)
 * 
 */
public class CDTT0001 extends TestCase {

    /**
     * CDTT0001: Deleting empty test sessions
     * <p>
     * Loads a <code>TestSessionContainer</code> from a file, creates an empty
     * test session in it, deletes the test session and checks if it was
     * deleted properly.
     */
    public void testCDTT0001() throws FileLoadException {
        String singleContainerLocation
                = "../../qa/testdata/containers/singlefile/statement.xml";
        Logger logger = new SimpleLogger();
        MASTBuilder builder = new MASTBuilder(logger);

        // 1.
        TestSessionContainer tsc = TestSessionContainer.load(org.codecover.model.extensions.PluginManager.create(), logger,
                builder, singleContainerLocation);

        // 2.
        TestSession ts = tsc.createTestSession("ts1",
                "test session1", new Date());

        // 3.
        ts.delete();

        // 4.
        /* for(String sessionName : tsc.getTestSessionNames()) {
            fail("There is a test session in the test session container (named"+
                    " \""+ sessionName +"\").");
        } */
        assertTrue(tsc.getTestSessionNames().isEmpty());
        assertNull(tsc.getTestSessionWithName("ts1"));
        assertFalse(tsc.containsTestSessionWithName("ts1"));
        assertTrue(tsc.getTestSessions().isEmpty());
        try {
            ts.getTestSessionContainer();
            fail();
        } catch (IllegalStateException e) {
        }
    }
}
