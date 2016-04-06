package ru.ncedu.java.tasks;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double t[] = {1, 2, 1, 1};
        ArrayVectorImpl vector = new ArrayVectorImpl();
        vector.set(t);
//        vector.getSize();
//        double t_copy[] = vector.get();
//        System.out.println(vector.getMax());
//        vector.sortAscending();//fill by set function
//        vector.mult(2.0);
//        double t2[] = {1, 3, 2};
//        ArrayVectorImpl vector2 = new ArrayVectorImpl();
//        vector2.set(t2);
//        System.out.println(vector2.scalarMult(vector));
//        System.out.println(vector.getNorm());
        
//        ArrayVector vectorClone = vector.clone();
//        System.out.println(vectorClone.get()[1]);
//        ArrayVectorImpl vectorSum = new ArrayVectorImpl();
//        double t3[] = {2,4,5};
//        vectorSum.set(t3);
//        vector.sum(vectorSum);
//        System.out.println(vector.get()[3]);
        
        vector.set(5, 5);
        System.out.println(vector.get()[5]);
        System.out.println(vector.get()[3]);
    }
    
}
