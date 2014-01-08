/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enums.p07;

import java.util.EnumSet;

/**
 *
 * @author rage
 */
public class EnumSetTest {
    enum Test {
        A, B, C
    }
    public static void main(String[] args) {
        EnumSet<Test> es = EnumSet.allOf(Test.class);
    }
}
