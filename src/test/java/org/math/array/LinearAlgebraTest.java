/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.math.array;

import Jama.CholeskyDecomposition;
import Jama.EigenvalueDecomposition;
import Jama.LUDecomposition;
import Jama.QRDecomposition;
import Jama.SingularValueDecomposition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author richet
 */
public class LinearAlgebraTest {
    
    public LinearAlgebraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of minus method, of class LinearAlgebra.
     */
    @org.junit.Test
    public void testMinus_doubleArr_doubleArr() {
        System.out.println("minus");
        double[] v1 = new double[]{1.0,2.0,3.0,4.0,5.5};
        double[] v2 = new double[]{11.0,12.0,13.0,14.0,15.5};
        double[] expResult = new double[]{-10.0,-10.0,-10.0,-10.0,-10.0};
        double[] result = LinearAlgebra.minus(v1, v2);
        assertArrayEquals(expResult, result,0.0);
    }

    
}
