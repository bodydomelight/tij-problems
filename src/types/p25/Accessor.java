/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types.p25;

import types.p25.a.ProtectedClass;
import java.lang.reflect.*;

/**
 *
 * @author rage
 */
public class Accessor {
    static void invokeMethod(ProtectedClass p, String methodName) throws Exception {
        Method method = p.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(p);
    }
    public static void main(String[] args) {
        ProtectedClass pc = new ProtectedClass();
        try {
        invokeMethod(pc, "packageMethod");
        invokeMethod(pc, "protectedMethod");
        invokeMethod(pc, "privateMethod");
        } catch(Exception e) {
            System.out.println("Something's wrong " + e.toString());
        }
    }
}
