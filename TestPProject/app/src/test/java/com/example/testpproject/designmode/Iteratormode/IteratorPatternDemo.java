package com.example.testpproject.designmode.Iteratormode;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

//        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
//            String name = (String)iter.next();
//            System.out.println("Name : " + name);
//        }

        Iterator iterator = namesRepository.getIterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
