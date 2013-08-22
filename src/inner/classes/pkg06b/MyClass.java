/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inner.classes.pkg06b;

import inner.classes.pkg06a.MyInterface;

/**
 *
 * @author aamelin
 */
public class MyClass {
    
    protected class MyInnerClass implements MyInterface{
        
        private String name;
        
        protected MyInnerClass(String name) {
            this.name = name;
        }
        
        @Override
        public String getName() {
            return name;
        }

    }
    
    public MyInnerClass getMyInnerClass(String name) {
        return new MyInnerClass(name);
    }
}
