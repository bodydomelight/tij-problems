/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types.p15.pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aamelin
 */
public class RegisteredFactoriesPetCreator extends PetCreator{

    @Override
    public List<Class<? extends Pet>> types() {
        List<Class<? extends Pet>> list = new ArrayList<Class<? extends Pet>>();
        list.addAll(Arrays.asList(Cat.class, Cymric.class, Dog.class, 
                EgyptianMau.class, Gerbil.class, Hamster.class, Manx.class,
                Mouse.class, Mutt.class, Pug.class, Rat.class, Rodent.class));
        return list;
    }
    
}
