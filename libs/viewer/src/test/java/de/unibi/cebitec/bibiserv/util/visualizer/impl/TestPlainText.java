/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2010,2011 BiBiServ Curator Team, http://bibiserv.cebitec.uni-bielefeld.de,
 * All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common
 * Development and Distribution License("CDDL") (the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at http://www.sun.com/cddl/cddl.html
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.  When distributing the software, include
 * this License Header Notice in each file.  If applicable, add the following
 * below the License Header, with the fields enclosed by brackets [] replaced
 *  by your own identifying information:
 *
 * "Portions Copyrighted 2010,2011 BiBiServ Curator Team, http://bibiserv.cebitec.uni-bielefeld.dev"
 *
 * Contributor(s): Jan Krueger, Benjamin Paassen
 *
 */
package de.unibi.cebitec.bibiserv.util.visualizer.impl;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Benjamin Paassen 
 * 
 * This class tests the PlainText-Visualizer implementation.
 */
public class TestPlainText {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of showThis method of class PlainText.java.
     */
    @Test
    public void testShowThis() throws Exception {
        PlainText plainTextVisualizer = new PlainText();

        StringBuilder inputData = new StringBuilder();
        String NL = System.getProperty("line.separator");

        /*
         * The input-file is specified here.
         * Please correct the path if necessary!
         * If you do not know where the relative path leads, please use the
         * following line of code
         */

        // System.out.println((new File("test/TestPlainText_input.xml")).getAbsolutePath());

        System.out.println("Now start scanning of test/TestPlainText_input.txt");


        Scanner scanner = new Scanner(new FileInputStream("src/test/resources/TestPlainText_input.txt"), "UTF-8");

        while (scanner.hasNextLine()) {
            inputData.append(scanner.nextLine());
            inputData.append(NL);
        }
        scanner.close();


        System.out.println("Content of input-file:\n" + inputData.toString() + "\n\n\n");


        String container = plainTextVisualizer.showThis(inputData.toString());


        System.out.println("Visualization as text in div-container:\n" + container + "\n\n\n");


        String output = "<html>\n";
        output += "<head>\n";
        output += "<title>PlainText Testpage</title>\n";
        output += "</head>\n";
        output += "<body>\n";
        output += container;
        output += "</body>\n";
        output += "</html>\n";

        //test.html-page is created.
        //Please correct the path if necessary!

        System.out.println("Creating result-page named test/TestPlainText_result.html");

        File f = File.createTempFile("TestPlainText_result", ".html");
        f.deleteOnExit();
        Writer w = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
        w.write(output);
        w.flush();
        w.close();

        System.out.println("Successfully created result-page.");
    }
}
