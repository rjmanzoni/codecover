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

package org.codecover.model;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.codecover.model.utils.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/**
 * This class deals with the writing of the data of the given
 * {@link TestSessionContainer} into a xml-file.
 * 
 * @author Markus Wittlinger
 * @version 1.0 ($Id$)
 */
class XMLWriter1_0_SAX extends XMLWriter1_0_Base implements XMLReader {

    private ContentHandler contentHandler;

    private ErrorHandler errorHandler;

    private EntityResolver entityResolver;

    private DTDHandler dtdHandler;

    XMLWriter1_0_SAX(Logger logger) {
        super(logger);
    }

    // /**
    // * Starts element for {@link TestCase}s
    // *
    // * @param testCase
    // * the given test case
    // * @throws SAXException
    // */
    // private void createTestCaseElement(TestCase testCase) throws SAXException
    // {
    //
    // if (testCase == null) {
    // throw new NullPointerException("testCase == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(NAME, testCase.getName());
    // atts.put(COMMENT, testCase.getComment());
    // atts.put(DATE, Long.toString(testCase.getDate().getTime()));
    //
    // startElement(ELEMENT_TEST_CASE, atts);
    //
    // /* Creates the list of coverage data of the test case */
    // createCoverageListElement(testCase.getCoverageData());
    //
    // /*
    // * Creates the list of assignments of the root terms of the test case
    // */
    // createAssignmentListElement(testCase.getAssignmentsMap());
    //
    // /*
    // * Creates the list of objectMetaData associated with this test case
    // */
    // createObjectMetaDataListElement(testCase.getObjectMetaDataMapEntries());
    //
    // /* Creates the list of metaData associated with this test case */
    // createMetaDataListElement(testCase.getMetaDataMapEntries());
    //
    // endElement(ELEMENT_TEST_CASE);
    // }
    //
    // /**
    // * Starts element for a map of {@link RootTerm}s to another map of
    // * {@link BooleanAssignment}s and {@link Boolean}s
    // *
    // * @param assignmentsMap
    // * the map to be saved
    // * @throws SAXException
    // */
    // private void createAssignmentListElement(
    // Map<CoverableItem, BooleanAssignmentMap> assignmentsMap)
    // throws SAXException {
    // if (assignmentsMap == null) {
    // throw new NullPointerException("assignmentsMapEntries == null");
    // }
    //
    // startElement(ELEMENT_ASSIGNMENT_LIST, getEmptyAttributes());
    //
    // /*
    // * Creates an element for each root term, which itself contains the map
    // * entries of its corresponding "Map<BooleanAssignment, Boolean>"
    // */
    // Map<String, Map<String, BooleanAssignmentMap>> convertedEntry =
    // convertMap(assignmentsMap);
    //
    // for (Entry<String, Map<String, BooleanAssignmentMap>> entry :
    // convertedEntry
    // .entrySet()) {
    //
    // createAssignmentPrefixElement(entry.getKey(), entry.getValue());
    // }
    //
    // endElement(ELEMENT_ASSIGNMENT_LIST);
    // }
    //
    // private void createAssignmentPrefixElement(String prefix,
    // Map<String, BooleanAssignmentMap> map) throws SAXException {
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(ROOT_TERM_COVERABLE_ITEM_PREFIX, prefix);
    //
    // startElement(ELEMENT_ASSIGNMENT_PREFIX, atts);
    //
    // for (Map.Entry<String, BooleanAssignmentMap> entry : map.entrySet()) {
    // String rootTermId = entry.getKey();
    //
    // Map<String, String> subAtts = getNewAttributes();
    // subAtts.put(ROOT_TERM_COVERABLE_ITEM_ID, rootTermId);
    // subAtts.put(LENGTH, Integer.toString(entry.getValue().getLength()));
    //
    // createBooleanAssignmentLongMapListElement(
    // ELEMENT_ASSIGNMENT_LIST_ENTRY, entry.getValue().getData()
    // .entrySet(), subAtts);
    // }
    //
    // endElement(ELEMENT_ASSIGNMENT_PREFIX);
    // }
    //
    // /**
    // * Starts element for the list of coverage counters.
    // *
    // * @param coverageData
    // * the given set containing the id and the value of the counter
    // * @throws SAXException
    // */
    // private void createCoverageListElement(Map<CoverableItem, Long>
    // coverageData)
    // throws SAXException {
    //
    // if (coverageData == null) {
    // throw new NullPointerException("coverageData == null");
    // }
    //
    // startElement(ELEMENT_COVERAGE_LIST, getEmptyAttributes());
    //
    // Map<String, Map<String, Long>> convertedMap = convertMap(coverageData);
    //
    // for (Map.Entry<String, Map<String, Long>> entry : convertedMap
    // .entrySet()) {
    // createCoveragePrefixElement(entry.getKey(), entry.getValue());
    // }
    //
    // endElement(ELEMENT_COVERAGE_LIST);
    // }
    //
    // /**
    // * Starts element for the prefix of a {@link CoverableItem} and appends
    // all
    // * the counters with the given prefix to the element.
    // *
    // * @param prefix
    // * the prefix
    // * @param map
    // * the map holding the counter ids and the counter values.
    // * @throws SAXException
    // */
    // private void createCoveragePrefixElement(String prefix,
    // Map<String, Long> map) throws SAXException {
    // Map<String, String> atts = getNewAttributes();
    // atts.put(COVERABLE_ITEM_PREFIX, prefix);
    //
    // startElement(ELEMENT_COVERAGE_PREFIX, atts);
    //
    // for (Entry<String, Long> entry : map.entrySet()) {
    // /* Only create an element, if the counter value isn't 0. */
    // if (entry.getValue().longValue() != 0L) {
    // createCoverageElement(entry.getKey(), entry.getValue());
    // }
    // }
    //
    // endElement(ELEMENT_COVERAGE_PREFIX);
    // }
    //
    // /**
    // * Starts element for lists of {@link MetaData}
    // *
    // * @param metaDataMapEntries
    // * the given entryset containing the object used as
    // * {@link MetaData}, as well as the keys used to map them
    // * @throws SAXException
    // */
    // private void createMetaDataListElement(
    // Set<Entry<String, Object>> metaDataMapEntries) throws SAXException {
    //
    // if (metaDataMapEntries == null) {
    // throw new NullPointerException("metaDataMapEntries == null");
    // }
    //
    // startElement(ELEMENT_META_DATA_LIST, getEmptyAttributes());
    //
    // for (Entry<String, Object> entry : metaDataMapEntries) {
    // if (entry.getValue() != null) {
    // createMetaDataListEntryElement(entry.getKey(), entry.getValue());
    // }
    // }
    //
    // endElement(ELEMENT_META_DATA_LIST);
    // }
    //
    // /**
    // * Starts element for an entry of a list of {@link MetaData}
    // *
    // * @param name
    // * the name used to map the {@link MetaData}
    // * @param value
    // * the given object used as {@link MetaData}
    // * @throws SAXException
    // */
    // private void createMetaDataListEntryElement(String name, Object value)
    // throws SAXException {
    //
    // if (name == null) {
    // throw new NullPointerException("name == null");
    // }
    //
    // if (value == null) {
    // throw new NullPointerException("value == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(NAME, name);
    //
    // startElement(ELEMENT_META_DATA_LIST_ENTRY, atts);
    //
    // /* Creates the element for the meta data to be saved. */
    // createMetaDataElement(value);
    //
    // endElement(ELEMENT_META_DATA_LIST_ENTRY);
    // }
    //
    // /**
    // * Starts element for lists of {@link MetaData} associated with
    // * {@link MetaDataObject}s
    // *
    // * @param objectMetaDataMap
    // * the map containing the name, with which the {@link MetaData}
    // * is mapped, as well as a reference to the
    // * {@link MetaDataObject} the {@link MetaData} is associated
    // * with.
    // * @throws SAXException
    // */
    // private void createObjectMetaDataListElement(
    // Map<String, Map<Long, Object>> objectMetaDataMap)
    // throws SAXException {
    //
    // if (objectMetaDataMap == null) {
    // throw new NullPointerException("objectMetaDataMapEntries == null");
    // }
    //
    // startElement(ELEMENT_OBJECT_META_DATA_LIST, getEmptyAttributes());
    //
    // for (Entry<String, Map<Long, Object>> entry : objectMetaDataMap
    // .entrySet()) {
    //
    // for (Map.Entry<Long, Object> subEntry : entry.getValue().entrySet()) {
    //
    // if (subEntry != null) {
    // createObjectMetaDataListEntryElement(entry.getKey(),
    // this.metaDataObjectIdMap.get(subEntry.getKey()),
    // subEntry.getValue());
    // }
    // }
    // }
    //
    // endElement(ELEMENT_OBJECT_META_DATA_LIST);
    // }
    //
    // /**
    // * Starts element for an entry of a list of {@link MetaData} associated
    // with
    // * {@link MetaDataObject}s
    // *
    // * @param name
    // * the name used to map the {@link MetaData}
    // * @param id
    // * the id used to reference the {@link MetaDataObject} the
    // * {@link MetaData} is associated with
    // * @param value
    // * the given object used as {@link MetaData}
    // * @throws SAXException
    // */
    // private void createObjectMetaDataListEntryElement(String name, String id,
    // Object value) throws SAXException {
    //
    // if (name == null) {
    // throw new NullPointerException("name == null");
    // }
    //
    // if (id == null) {
    // throw new NullPointerException("id == null");
    // }
    //
    // if (value == null) {
    // throw new NullPointerException("value == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(NAME, name);
    // atts.put(META_DATA_OBJECT_ID, id);
    //
    // startElement(ELEMENT_OBJECT_META_DATA_LIST_ENTRY, atts);
    //
    // /* Creates the element for the meta data to be saved. */
    // createMetaDataElement(value);
    //
    // endElement(ELEMENT_OBJECT_META_DATA_LIST_ENTRY);
    // }
    //
    // /**
    // * Starts element for {@link Object}s used as {@link MetaData} in an
    // * {@link MetaDataProvider}
    // *
    // * @param value
    // * the given object used as {@link MetaData}
    // * @throws SAXException
    // */
    // private void createMetaDataElement(Object value) throws SAXException {
    //
    // if (value == null) {
    // throw new NullPointerException("value == null");
    // }
    //
    // final String base64 = TSCXMLHelper.encodeMetaData(value, getLogger());
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(BASE64, base64);
    //
    // startElement(ELEMENT_META_DATA, atts);
    //
    // endElement(ELEMENT_META_DATA);
    // }
    //
    // /**
    // * Starts element for a counter, with its id and value.
    // *
    // * @param coverableItemId
    // * the id of the counter
    // * @param value
    // * the value of the counter
    // * @throws SAXException
    // */
    // private void createCoverageElement(String coverableItemId, Long value)
    // throws SAXException {
    //
    // if (coverableItemId == null) {
    // throw new NullPointerException("coverableItemId == null");
    // }
    //
    // if (value == null) {
    // throw new NullPointerException("value == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(COVERABLE_ITEM_ID, coverableItemId);
    // atts.put(VALUE, Long.toString(value));
    //
    // startElement(ELEMENT_COVERAGE, atts);
    //
    // endElement(ELEMENT_COVERAGE);
    // }
    //
    // /**
    // * Starts element for {@link TestSession}s
    // *
    // * @param testSession
    // * the given test session
    // * @throws SAXException
    // */
    // private void createTestSessionElement(TestSession testSession)
    // throws SAXException {
    //
    // if (testSession == null) {
    // throw new NullPointerException("testSession == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(NAME, testSession.getName());
    // atts.put(COMMENT, testSession.getComment());
    // atts.put(DATE, Long.toString(testSession.getDate().getTime()));
    //
    // startElement(ELEMENT_TEST_SESSION, atts);
    //
    // for (TestCase testCase : testSession.getTestCases()) {
    // createTestCaseElement(testCase);
    // }
    //
    // /*
    // * Creates the list of metaData associated with this test session
    // */
    // createMetaDataListElement(testSession.getMetaDataMapEntries());
    //
    // endElement(ELEMENT_TEST_SESSION);
    // }
    //
    // /**
    // * Starts element for the mast
    // *
    // * @param code
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createMastElement(HierarchyLevel code) throws SAXException {
    //
    // if (code == null) {
    // throw new NullPointerException("code == null");
    // }
    //
    // startElement(ELEMENT_MAST_ROOT, getEmptyAttributes());
    //
    // if (code != null) {
    // createHierarchyLevelElement(code);
    // }
    // endElement(ELEMENT_MAST_ROOT);
    // }
    //
    // /**
    // * Starts element for {@link HierarchyLevel}s
    // *
    // * @param level
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createHierarchyLevelElement(HierarchyLevel level)
    // throws SAXException {
    //
    // if (level == null) {
    // throw new NullPointerException("level == null");
    // }
    //
    // String internalId = storeMetaDataObject(level);
    //
    // Map<String, String> atts = getNewAttributes();
    //
    // atts.put(INTERNAL_ID, internalId);
    // atts.put(NAME, level.getName());
    // atts.put(HIERARCHY_LEVEL_ID, level.getId());
    // atts.put(HIERARCHY_LEVEL_TYPE_ID, this.hierarchyLevelTypeIdMap
    // .get(level.getType()));
    //
    // startElement(ELEMENT_HIERARCHY_LEVEL, atts);
    //
    // /* Creates header element */
    // createLocationListElement(ELEMENT_HEADER, level.getHeader());
    //
    // /* Creates location list element */
    // createLocationListElement(ELEMENT_LOCATION_LIST, level.getLocation());
    //
    // /*
    // * Creates all the statement sequences of the given hierarchyLevel
    // */
    // for (StatementSequence sequence : level.getSequences()) {
    // createStatementSequenceElement(sequence);
    // }
    //
    // /*
    // * Call this method recursively to create and append all child hierarchy
    // * levels.
    // */
    // for (HierarchyLevel childLevel : level.getChildren()) {
    // createHierarchyLevelElement(childLevel);
    //
    // }
    //
    // endElement(ELEMENT_HIERARCHY_LEVEL);
    //
    // }
    //
    // /**
    // * Starts element for {@link LocationList}s
    // *
    // * @param name
    // * the name used in naming the element
    // * @param locationList
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createLocationListElement(String name,
    // LocationList locationList) throws SAXException {
    //
    // if (name == null) {
    // throw new NullPointerException("name == null");
    // }
    //
    // if (locationList == null) {
    // throw new NullPointerException("locationList == null");
    // }
    //
    // startElement(name, getEmptyAttributes());
    //
    // for (Location location : locationList.getLocations()) {
    // createLocationElement(ELEMENT_LOCATION, location);
    // }
    //
    // endElement(name);
    // }
    //
    // /**
    // * Starts element for {@link Location}s
    // *
    // * @param name
    // * the name used in naming the element
    // * @param location
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createLocationElement(String name, Location location)
    // throws SAXException {
    //
    // if (name == null) {
    // throw new NullPointerException("name == null");
    // }
    //
    // if (location == null) {
    // throw new NullPointerException("location == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(START_OFFSET, Integer.toString(location.getStartOffset()));
    // atts.put(END_OFFSET, Integer.toString(location.getEndOffset()));
    // atts.put(SOURCE_FILE_ID, this.sourceFileIdMap.get(location.getFile()));
    //
    // startElement(name, atts);
    //
    // endElement(name);
    // }
    //
    // /**
    // * Starts element for a list of
    // * {@link HierarchyLevelType HierarchyLevelTypes}
    // *
    // * @param set
    // * the Set containing the
    // * {@link HierarchyLevelType HierarchyLevelTypes}
    // * @throws SAXException
    // */
    // private void createHierarchyLevelTypeListElement(Set<HierarchyLevelType>
    // set)
    // throws SAXException {
    // if (set == null) {
    // throw new NullPointerException("map == null");
    // }
    //
    // startElement(ELEMENT_HIERARCHY_LEVEL_TYPE_LIST, getEmptyAttributes());
    //
    // for (HierarchyLevelType entry : set) {
    // String id = generateID();
    // this.hierarchyLevelTypeIdMap.put(entry, id);
    // createHierarchyLevelTypeElement(entry, id);
    // }
    //
    // endElement(ELEMENT_HIERARCHY_LEVEL_TYPE_LIST);
    // }
    //
    // /**
    // * Starts element for {@link HierarchyLevelType}s
    // *
    // * @param type
    // * the given element of the mast
    // * @param id
    // * the id of the {@link HierarchyLevelType}
    // * @throws SAXException
    // */
    // private void createHierarchyLevelTypeElement(HierarchyLevelType type,
    // String id) throws SAXException {
    //
    // if (type == null) {
    // throw new NullPointerException("type == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, id);
    // atts.put(INTERNAL_NAME, type.getInternalName());
    // atts.put(ENGLISH_NAME, type.getEnglishName());
    //
    // startElement(ELEMENT_HIERARCHY_LEVEL_TYPE, atts);
    //
    // endElement(ELEMENT_HIERARCHY_LEVEL_TYPE);
    // }
    //
    // /**
    // * Starts element for {@link StatementSequence}s
    // *
    // * @param statementSequence
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createStatementSequenceElement(
    // StatementSequence statementSequence) throws SAXException {
    //
    // if (statementSequence == null) {
    // throw new NullPointerException("statementSequence == null");
    // }
    //
    // String internalId = storeMetaDataObject(statementSequence);
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, internalId);
    //
    // startElement(ELEMENT_STATEMENT_SEQUENCE, atts);
    //
    // /* Creates location list element */
    // createLocationListElement(ELEMENT_LOCATION_LIST, statementSequence
    // .getLocation());
    //
    // /* Creates all the statements in sequence. */
    // for (Statement statement : statementSequence.getStatements()) {
    // createStatementElement(statement);
    // }
    //
    // endElement(ELEMENT_STATEMENT_SEQUENCE);
    // }
    //
    // /**
    // * Starts element for {@link Statement}s. The element is filled with the
    // * data common to all {@link Statement}s and then passed to a method for
    // * each one of the subclasses of {@link Statement}, to assign the specific
    // * data
    // *
    // * @param statement
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createStatementElement(Statement statement)
    // throws SAXException {
    //
    // if (statement == null) {
    // throw new NullPointerException("statement == null");
    // }
    //
    // String internalId = storeMetaDataObject(statement);
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, internalId);
    // /* set the id of the coverable item as an attribute. */
    // atts.put(COVERABLE_ITEM_ID, statement.getCoverableItem().getId());
    // /* set the prefix of the coverable item as an attribute. */
    // atts.put(COVERABLE_ITEM_PREFIX, statement.getCoverableItem()
    // .getPrefix());
    //
    // String elementName = null;
    //
    // /* Call the respective method for each type of statement. */
    // if (statement instanceof BasicStatement) {
    // elementName = createBasicStatementElement(
    // (BasicStatement) statement, atts);
    // } else if (statement instanceof ComplexStatement) {
    // elementName = createComplexStatementElement(
    // (ComplexStatement) statement, atts);
    // }
    //
    // /* Creates location list element */
    // createLocationListElement(ELEMENT_LOCATION_LIST, statement
    // .getLocation());
    //
    // /* Creates all the root terms of the statement */
    // for (RootTerm rootTerm : statement.getTerms()) {
    // createRootTermElement(rootTerm);
    // }
    //
    // endElement(elementName);
    // }
    //
    // /**
    // * Starts element for {@link ComplexStatement}s.The element is filled with
    // * the data common to all {@link ComplexStatement}s and then passed to a
    // * method for each one of the subclasses of {@link ComplexStatement}, to
    // * assign the specific data
    // *
    // * @param complexStatement
    // * the given element of the mast
    // * @param atts
    // * the previously created attributes map object.
    // * @return the name of the created element.
    // * @throws SAXException
    // */
    // private String createComplexStatementElement(
    // ComplexStatement complexStatement, Map<String, String> atts)
    // throws SAXException {
    //
    // if (complexStatement == null) {
    // throw new NullPointerException("complexStatement == null");
    // }
    //
    // String elementName = null;
    //
    // if (complexStatement instanceof LoopingStatement) {
    // elementName = createLoopingStatementElement(
    // (LoopingStatement) complexStatement, atts);
    // } else if (complexStatement instanceof ConditionalStatement) {
    // elementName = createConditionalStatementElement(
    // (ConditionalStatement) complexStatement, atts);
    // }
    //
    // /* Creates the keyword element */
    // createLocationElement(ELEMENT_KEYWORD, complexStatement.getKeyword());
    //
    // return elementName;
    // }
    //
    // /**
    // * Starts element for {@link ConditionalStatement}s
    // *
    // * @param conditionalStatement
    // * the given element of the mast
    // * @param atts
    // * the previously created attributes map object.
    // * @return the name of the created element.
    // * @throws SAXException
    // */
    // private String createConditionalStatementElement(
    // ConditionalStatement conditionalStatement, Map<String, String> atts)
    // throws SAXException {
    //
    // if (conditionalStatement == null) {
    // throw new NullPointerException("conditionalStatement == null");
    // }
    //
    // startElement(ELEMENT_CONDITIONAL_STATEMENT, atts);
    //
    // /* Creates all the branches of the statement. */
    // for (Branch branch : conditionalStatement.getBranches()) {
    // createBranchElement(branch);
    // }
    //
    // return ELEMENT_CONDITIONAL_STATEMENT;
    // }
    //
    // /**
    // * Starts element for {@link Branch}es
    // *
    // * @param branch
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createBranchElement(Branch branch) throws SAXException {
    //
    // if (branch == null) {
    // throw new NullPointerException("branch == null");
    // }
    //
    // String internalId = storeMetaDataObject(branch);
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, internalId);
    // /* set the id of the coverable item as an attribute. */
    // atts.put(COVERABLE_ITEM_ID, branch.getCoverableItem().getId());
    // /* set the prefix of the coverable item as an attribute. */
    // atts.put(COVERABLE_ITEM_PREFIX, branch.getCoverableItem().getPrefix());
    // atts.put(IMPLICIT, Boolean.toString(branch.isImplicit()));
    //
    // startElement(ELEMENT_BRANCH, atts);
    //
    // /* Creates decision element */
    // createLocationListElement(ELEMENT_DECISION, branch.getDecision());
    //
    // /* Creates location list element */
    // createLocationListElement(ELEMENT_LOCATION_LIST, branch.getLocation());
    //
    // /* Creates the statement sequence element */
    // createStatementSequenceElement(branch.getSequence());
    //
    // endElement(ELEMENT_BRANCH);
    // }
    //
    // /**
    // * Starts element for {@link LoopingStatement}s
    // *
    // * @param loopingStatement
    // * the given element of the mast
    // * @param atts
    // * the previously created attributes map object.
    // * @return the name of the created element.
    // * @throws SAXException
    // */
    // private String createLoopingStatementElement(
    // LoopingStatement loopingStatement, Map<String, String> atts)
    // throws SAXException {
    //
    // if (loopingStatement == null) {
    // throw new NullPointerException("loopingStatement == null");
    // }
    //
    // atts.put(MULTIPLE_EXECUTED_ID, loopingStatement
    // .getMultipleExecutedItem().getId());
    // atts.put(MULTIPLE_EXECUTED_PREFIX, loopingStatement
    // .getMultipleExecutedItem().getPrefix());
    // atts.put(NEVER_EXECUTED_ID, loopingStatement.getNeverExecutedItem()
    // .getId());
    // atts.put(NEVER_EXECUTED_PREFIX, loopingStatement.getNeverExecutedItem()
    // .getPrefix());
    // atts.put(ONCE_EXECUTED_ID, loopingStatement.getOnceExecutedItem()
    // .getId());
    // atts.put(ONCE_EXECUTED_PREFIX, loopingStatement.getOnceExecutedItem()
    // .getPrefix());
    // atts.put(OPTIONAL_BODY_EXECUTION, Boolean.toString(loopingStatement
    // .isOptionalBodyExecution()));
    //
    // startElement(ELEMENT_LOOPING_STATEMENT, atts);
    //
    // /* Creates the statement sequence element */
    // createStatementSequenceElement(loopingStatement.getBody());
    //
    // return ELEMENT_LOOPING_STATEMENT;
    // }
    //
    // /**
    // * Starts element for {@link BasicStatement}s
    // *
    // * @param basicStatement
    // * the given element of the mast
    // * @param atts
    // * the previously created attributes map object.
    // * @return the name of the created element.
    // * @throws SAXException
    // */
    // private String createBasicStatementElement(BasicStatement basicStatement,
    // Map<String, String> atts) throws SAXException {
    //
    // if (basicStatement == null) {
    // throw new NullPointerException("basicStatement == null");
    // }
    //
    // startElement(ELEMENT_BASIC_STATEMENT, atts);
    //
    // return ELEMENT_BASIC_STATEMENT;
    // }
    //
    // /**
    // * Starts element for {@link RootTerm}s
    // *
    // * @param rootTerm
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createRootTermElement(RootTerm rootTerm) throws SAXException
    // {
    //
    // if (rootTerm == null) {
    // throw new NullPointerException("rootTerm == null");
    // }
    //
    // String internalId = storeMetaDataObject(rootTerm);
    // this.rootTermIdMap.put(rootTerm, internalId);
    //
    // Map<String, String> attributes = getNewAttributes();
    // attributes.put(INTERNAL_ID, internalId);
    // /* set the id of the coverable item as an attribute. */
    // attributes.put(COVERABLE_ITEM_ID, rootTerm.getCoverableItem().getId());
    // /* set the prefix of the coverable item as an attribute. */
    // attributes.put(COVERABLE_ITEM_PREFIX, rootTerm.getCoverableItem()
    // .getPrefix());
    //
    // startElement(ELEMENT_ROOT_TERM, attributes);
    //
    // createBooleanTermElement(rootTerm.getTerm());
    //
    // endElement(ELEMENT_ROOT_TERM);
    // }
    //
    // /**
    // * Starts element for {@link BooleanTerm}s
    // *
    // * @param booleanTerm
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createBooleanTermElement(BooleanTerm booleanTerm)
    // throws SAXException {
    //
    // if (booleanTerm == null) {
    // throw new NullPointerException("booleanTerm == null");
    // }
    //
    // String internalId = storeMetaDataObject(booleanTerm);
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, internalId);
    //
    // String elementName = null;
    // /* Call the respective method for each type of boolean term. */
    // if (booleanTerm instanceof BasicBooleanTerm) {
    // elementName = createBasicBooleanTermElement(
    // (BasicBooleanTerm) booleanTerm, atts);
    // } else if (booleanTerm instanceof OperatorTerm) {
    // elementName = createOperatorTermElement((OperatorTerm) booleanTerm,
    // atts);
    // }
    //
    // createLocationListElement(ELEMENT_LOCATION_LIST, booleanTerm
    // .getLocation());
    //
    // endElement(elementName);
    // }
    //
    // /**
    // * Starts element for {@link OperatorTerm}s
    // *
    // * @param operatorTerm
    // * the given element of the mast
    // * @param atts
    // * the previously created attributes map object.
    // * @return the name of the created element.
    // * @throws SAXException
    // */
    // private String createOperatorTermElement(OperatorTerm operatorTerm,
    // Map<String, String> atts) throws SAXException {
    //
    // if (operatorTerm == null) {
    // throw new NullPointerException("operatorTerm == null");
    // }
    //
    // atts.put(BOOLEAN_OPERATOR_ID, this.operatorIdMap.get(operatorTerm
    // .getOperator()));
    //
    // startElement(ELEMENT_OPERATOR_TERM, atts);
    //
    // /* Creates all the operand terms of the operator term */
    // for (BooleanTerm operands : operatorTerm.getOperands()) {
    // createBooleanTermElement(operands);
    //
    // }
    //
    // return ELEMENT_OPERATOR_TERM;
    // }
    //
    // /**
    // * Starts element for {@link BooleanOperator}s
    // *
    // * @param booleanOperator
    // * the given element of the mast
    // * @param id
    // * the id used for referencing the operator in the remaining
    // * ContentHandler, in order to optimize space usage
    // * @throws SAXException
    // */
    // private void createBooleanOperatorElement(BooleanOperator
    // booleanOperator,
    // String id) throws SAXException {
    //
    // if (booleanOperator == null) {
    // throw new NullPointerException("booleanOperator == null");
    // }
    //
    // if (id == null) {
    // throw new NullPointerException("id == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, id);
    // atts.put(ARITY, Integer.toString(booleanOperator.getArity()));
    // atts.put(NAME, booleanOperator.getName());
    //
    // startElement(ELEMENT_BOOLEAN_OPERATOR, atts);
    //
    // createBooleanAssignmentBooleanMapListElement(
    // ELEMENT_BOOLEAN_ASSIGNMENT_BOOLEAN_MAP_LIST, booleanOperator
    // .getPossibleAssignments().entrySet());
    //
    // endElement(ELEMENT_BOOLEAN_OPERATOR);
    // }
    //
    // /**
    // * Starts element for a map of {@link BooleanAssignment}s and
    // * {@link Boolean}s
    // *
    // * @param name
    // * the name of the tag
    // * @param mapEntries
    // * the entries of the map
    // * @throws SAXException
    // */
    // private void createBooleanAssignmentBooleanMapListElement(String name,
    // Set<Map.Entry<BooleanAssignment, Boolean>> mapEntries)
    // throws SAXException {
    //
    // if (name == null) {
    // throw new NullPointerException("name == null");
    // }
    //
    // if (mapEntries == null) {
    // throw new NullPointerException("mapEntries == null");
    // }
    //
    // startElement(name, getEmptyAttributes());
    //
    // for (Map.Entry<BooleanAssignment, Boolean> entry : mapEntries) {
    // createBooleanAssignmentStringMapListEntryElement(entry.getKey(),
    // entry.getValue().toString());
    // }
    //
    // endElement(name);
    // }
    //
    // /**
    // * Starts element for an entry of a map containing {@link
    // BooleanAssignment}s
    // * and {@link Boolean}s
    // *
    // * @param booleanAssignment
    // * the booleanAssignment to be encoded
    // * @param value
    // * the value as a String
    // * @throws SAXException
    // */
    // private void createBooleanAssignmentStringMapListEntryElement(
    // BooleanAssignment booleanAssignment, String value)
    // throws SAXException {
    //
    // if (booleanAssignment == null) {
    // throw new NullPointerException("booleanAssignment");
    // }
    // if (value == null) {
    // throw new NullPointerException("value");
    // }
    //
    // final String encodedBooleanAssignment = TSCXMLHelper
    // .encodeBooleanAssignment(booleanAssignment, getLogger());
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(BOOLEAN_ASSIGNMENT, encodedBooleanAssignment);
    // atts.put(VALUE, value);
    //
    // startElement(ELEMENT_MAP_ENTRY, atts);
    //
    // endElement(ELEMENT_MAP_ENTRY);
    // }
    //
    // /**
    // * Starts element for a map of {@link BooleanAssignment}s and {@link
    // Long}s
    // *
    // * @param name
    // * the name of the tag
    // * @param mapEntries
    // * the entries of the map
    // * @param atts
    // * @throws SAXException
    // */
    // private void createBooleanAssignmentLongMapListElement(String name,
    // Set<Map.Entry<BooleanAssignment, Long>> mapEntries,
    // Map<String, String> atts) throws SAXException {
    //
    // if (name == null) {
    // throw new NullPointerException("name == null");
    // }
    //
    // if (mapEntries == null) {
    // throw new NullPointerException("mapEntries == null");
    // }
    //
    // startElement(name, atts);
    //
    // for (Map.Entry<BooleanAssignment, Long> entry : mapEntries) {
    // createBooleanAssignmentStringMapListEntryElement(entry.getKey(),
    // entry.getValue().toString());
    // }
    //
    // endElement(name);
    // }
    //
    // /**
    // * Starts element for {@link BasicBooleanTerm}s
    // *
    // * @param basicBooleanTerm
    // * the given element of the mast
    // * @param atts
    // * the previously created attributes map object.
    // * @return the name of the created element.
    // * @throws SAXException
    // */
    // private String createBasicBooleanTermElement(
    // BasicBooleanTerm basicBooleanTerm, Map<String, String> atts)
    // throws SAXException {
    //
    // if (basicBooleanTerm == null) {
    // throw new NullPointerException("basicBooleanTerm == null");
    // }
    //
    // startElement(ELEMENT_BASIC_BOOLEAN_TERM, atts);
    //
    // return ELEMENT_BASIC_BOOLEAN_TERM;
    // }
    //
    // /**
    // * Starts element for {@link TestSessionContainer}s
    // *
    // * @param testSessionContainer
    // * the given element of the mast
    // * @throws SAXException
    // */
    // private void createTestSessionContainerElement(
    // TestSessionContainer testSessionContainer) throws SAXException {
    //
    // if (testSessionContainer == null) {
    // throw new NullPointerException("testSessionContainer == null");
    // }
    //
    // /*
    // * Creates the list of source files associated with the
    // * testSessionContainer
    // */
    // createSourceFileListElement(testSessionContainer.getFiles());
    //
    // /*
    // * Creates the list of criteria associated with the testSessionContainer
    // */
    // createCriteriaListElement(testSessionContainer.getCriteria());
    //
    // /*
    // * The mast element tree must have been created before the boolean
    // * operators are appended, since the map of operators is filled during
    // * the creation of the mast element tree. Append all the
    // * BooleanOperators before the mast element
    // */
    // createBooleanOperatorListElement(getAllBooleanOperators(testSessionContainer
    // .getCode()));
    //
    // /*
    // * The mast element tree must have been created before the
    // * hierarchyLevelTypes are appended, since the map of
    // * hierarchyLevelTypes is filled during the creation of the mast element
    // * tree. Append all the HierarchyLevelTypes before the mast element.
    // */
    // createHierarchyLevelTypeListElement(getAllHierarchyLevelTypes(testSessionContainer
    // .getCode()));
    //
    // /* Creates the element representing the mast */
    // createMastElement(testSessionContainer.getCode());
    //
    // /*
    // * Creates every test session, with its test cases to the
    // * testSessionContainer
    // */
    // for (TestSession testSession : testSessionContainer.getTestSessions()) {
    // createTestSessionElement(testSession);
    // }
    // }
    //
    // /**
    // * Starts element for a list of {@link BooleanOperator BooleanOperators}
    // *
    // * @param set
    // * the set of {@link BooleanOperator BooleanOperators}
    // * @throws SAXException
    // */
    // private void createBooleanOperatorListElement(Set<BooleanOperator> set)
    // throws SAXException {
    // startElement(ELEMENT_BOOLEAN_OPERATOR_LIST, getEmptyAttributes());
    //
    // for (BooleanOperator entry : set) {
    // String id = generateID();
    // this.operatorIdMap.put(entry, id);
    // createBooleanOperatorElement(entry, id);
    // }
    //
    // endElement(ELEMENT_BOOLEAN_OPERATOR_LIST);
    // }
    //
    // /**
    // * Starts element for a list of {@link SourceFile}s
    // *
    // * @param files
    // * the list of {@link SourceFile}s
    // * @throws SAXException
    // */
    // private void createSourceFileListElement(List<SourceFile> files)
    // throws SAXException {
    //
    // startElement(ELEMENT_SOURCE_FILE_LIST, getEmptyAttributes());
    //
    // /* Attach all source files of the testSessionContainer to the element */
    // for (SourceFile sourceFile : files) {
    // /*
    // * Generate an id to be used later in the ContentHandler, to refer
    // * to this source file.
    // */
    // String sourceFileId = generateID();
    //
    // /*
    // * For easy retrieval of the id of the source file, it is put into a
    // * map.
    // */
    // this.sourceFileIdMap.put(sourceFile, sourceFileId);
    //
    // createSourceFileElement(sourceFile, sourceFileId);
    // }
    //
    // endElement(ELEMENT_SOURCE_FILE_LIST);
    // }
    //
    // /**
    // * Starts element for a list of {@link Criterion}s
    // *
    // * @param criteria
    // * the list of {@link Criterion}s
    // * @throws SAXException
    // */
    // private void createCriteriaListElement(Set<Criterion> criteria)
    // throws SAXException {
    // if (criteria == null) {
    // throw new NullPointerException("criteria == null");
    // }
    //
    // startElement(ELEMENT_CRITERIA_LIST, getEmptyAttributes());
    //
    // for (Criterion criterion : criteria) {
    // createCriteriaListEntryElement(criterion);
    // }
    //
    // endElement(ELEMENT_CRITERIA_LIST);
    // }
    //
    // /**
    // * Starts element for {@link Criterion}s
    // *
    // * @param criterion
    // * the given criterion.
    // * @throws SAXException
    // */
    // private void createCriteriaListEntryElement(Criterion criterion)
    // throws SAXException {
    // if (criterion == null) {
    // throw new NullPointerException("criterion == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(NAME, criterion.getExtensionName());
    // atts.put(PLUGIN_NAME, criterion.getPluginName());
    //
    // startElement(ELEMENT_CRITERIA_LIST_ENTRY, atts);
    // endElement(ELEMENT_CRITERIA_LIST_ENTRY);
    // }
    //
    // /**
    // * Starts element for {@link SourceFile}s
    // *
    // * @param sourceFile
    // * the given element of the mast
    // * @param id
    // * the id used for referencing the {@link SourceFile} in the
    // * remaining document, in order to optimize space usage
    // * @throws SAXException
    // */
    // private void createSourceFileElement(SourceFile sourceFile, String id)
    // throws SAXException {
    //
    // if (sourceFile == null) {
    // throw new NullPointerException("sourceFile == null");
    // }
    //
    // Map<String, String> atts = getNewAttributes();
    // atts.put(INTERNAL_ID, id);
    // atts.put(FILENAME, sourceFile.getFileName());
    // atts.put(CONTENT, sourceFile.getContent());
    //
    // startElement(ELEMENT_SOURCE_FILE, atts);
    //
    // endElement(ELEMENT_SOURCE_FILE);
    // }
    //
    // private Set<BooleanOperator> getAllBooleanOperators(
    // HierarchyLevel hierarchyLevel) {
    // /*
    // * If the hierarchyLevel is null, there is no MAST in this tsc, which is
    // * valid, so we return an empty set.
    // */
    // if (hierarchyLevel == null) {
    // return Collections.emptySet();
    // }
    //
    // final Set<BooleanOperator> set = new HashSet<BooleanOperator>();
    //
    // hierarchyLevel.accept(null, null, null, null, null, null,
    // new Visitor() {
    //
    // public void visit(BasicBooleanTerm term) {
    // /* Nothing to do here. */
    // }
    //
    // public void visit(OperatorTerm term) {
    // set.add(term.getOperator());
    // }
    //
    // }, null);
    //
    // return set;
    // }
    //
    // private Set<HierarchyLevelType> getAllHierarchyLevelTypes(
    // HierarchyLevel hierarchyLevel) {
    // /*
    // * If the hierarchyLevel is null, there is no MAST in this tsc, which is
    // * valid, so we return an empty set.
    // */
    // if (hierarchyLevel == null) {
    // return Collections.emptySet();
    // }
    //
    // final Set<HierarchyLevelType> set = new HashSet<HierarchyLevelType>();
    //
    // hierarchyLevel.accept(new HierarchyLevel.Visitor() {
    // public void visit(HierarchyLevel level) {
    // set.add(level.getType());
    // }
    // }, null, null, null, null, null, null, null);
    //
    // return set;
    // }
    //
    // /**
    // * Converts a map of {@link CoverableItem}s and a generic other object A,
    // * into a Map<String,Map<String,A>>, with the first String being the
    // * prefix of the {@link CoverableItem} and the second one, the id of the
    // * {@link CoverableItem}.
    // *
    // * @param <A>
    // * the type of the generic part of the map
    // * @param dataToConvert
    // * the map to convert
    // * @return the converted map.
    // */
    // private static <A> Map<String, Map<String, A>> convertMap(
    // Map<CoverableItem, A> dataToConvert) {
    //
    // final Map<String, Map<String, A>> map = new TreeMap<String, Map<String,
    // A>>();
    // for (Map.Entry<CoverableItem, A> entry : dataToConvert.entrySet()) {
    // final String prefix = entry.getKey().getPrefix();
    // final String id = entry.getKey().getId();
    // final A data = entry.getValue();
    //
    // Map<String, A> subMap = map.get(prefix);
    // if (subMap == null) {
    // subMap = new TreeMap<String, A>();
    // map.put(prefix, subMap);
    // }
    //
    // subMap.put(id, data);
    // }
    //
    // return map;
    // }
    //
    // private String storeMetaDataObject(MetaDataObject dataObject) {
    // /*
    // * Generate and set an id for the current mast element, for later usage
    // * in saving the meta data of the test sessions and test cases.
    // */
    // String internalId = generateID();
    // this.metaDataObjectIdMap.put(Internal.getMetaDataId(dataObject
    // .getMetaData()), internalId);
    //
    // return internalId;
    // }

    @Override
    protected void startElement(String elementName,
            Map<String, String> attributes) throws SAXException {
        AttributesImpl atts = new AttributesImpl();

        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();

            if (attributeName == null) {
                throw new NullPointerException("attributeName == null");
            }
            if (attributeValue == null) {
                throw new NullPointerException("attributeValue == null");
            }

            atts.addAttribute(NAMESPACE_TEST_SESSION_CONTAINER, attributeName,
                    attributeName, "CDATA", attributeValue);
        }

        getContentHandler().startElement(NAMESPACE_TEST_SESSION_CONTAINER,
                elementName, elementName, atts);
    }

    @Override
    protected void endElement(String elementName) throws SAXException {
        getContentHandler().endElement(NAMESPACE_TEST_SESSION_CONTAINER,
                elementName, elementName);
    }

    protected static Map<String, String> getEmptyAttributes() {
        return Collections.emptyMap();
    }

    protected static Map<String, String> getNewAttributes() {
        return new HashMap<String, String>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#getContentHandler()
     */
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#getDTDHandler()
     */
    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#getEntityResolver()
     */
    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#getErrorHandler()
     */
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#getFeature(java.lang.String)
     */
    public boolean getFeature(String name) throws SAXNotRecognizedException,
            SAXNotSupportedException {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#getProperty(java.lang.String)
     */
    public Object getProperty(String name) throws SAXNotRecognizedException,
            SAXNotSupportedException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#parse(org.xml.sax.InputSource)
     */
    public void parse(InputSource input) throws IOException, SAXException {
        if (!(input instanceof TestSessionContainerInputSource)) {
            throw new IllegalArgumentException(
                    "Input NOT instance of TestSessionContainerInputSource");
        }

        TestSessionContainer testSessionContainer = ((TestSessionContainerInputSource) input)
                .getTestSessionContainer();

        if (testSessionContainer == null) {
            throw new NullPointerException("testSessionContainer == null");
        }

        getContentHandler().startDocument();


        createTestSessionContainerElement(testSessionContainer);


        getContentHandler().endDocument();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#parse(java.lang.String)
     */
    public void parse(String systemId) throws IOException, SAXException {
        /* Do nothing here. */
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#setContentHandler(org.xml.sax.ContentHandler)
     */
    public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#setDTDHandler(org.xml.sax.DTDHandler)
     */
    public void setDTDHandler(DTDHandler handler) {
        this.dtdHandler = handler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#setEntityResolver(org.xml.sax.EntityResolver)
     */
    public void setEntityResolver(EntityResolver resolver) {
        this.entityResolver = resolver;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#setErrorHandler(org.xml.sax.ErrorHandler)
     */
    public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#setFeature(java.lang.String, boolean)
     */
    public void setFeature(String name, boolean value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        /* Do nothing here. */
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.XMLReader#setProperty(java.lang.String,
     *      java.lang.Object)
     */
    public void setProperty(String name, Object value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        /* Do nothing here. */
    }
}
