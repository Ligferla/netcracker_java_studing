package ru.ncedu.java.tasks;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        StringFilter sf = new StringFilterImpl();
        sf.add("aa");
        sf.add("Hg");
        sf.add(null);
        sf.add("gsgg");
        sf.add("gsf");
//        sf.remove(null);
      Iterator it = sf.getStringsStartingWith("gs");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
