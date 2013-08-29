package inner.classes.pkg20;

public interface Interface {
    void print(InterfaceInner i);
    class InterfaceInner {
        private String name;
        public InterfaceInner(String str) {
            name = str;
        }
        public void setName(String str) {
            name = str;
        };
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return name;
        }
    }
}
