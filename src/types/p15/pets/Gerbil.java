package types.p15.pets;

public class Gerbil extends Rodent {

    public Gerbil(String name) {
        super(name);
    }

    public Gerbil() {
        super();
    }

    public static class Factory implements types.p15.pets.Factory<Gerbil> {

        @Override
        public Gerbil create() {
            return new Gerbil();
        }
    }
}
