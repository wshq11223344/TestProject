package com.example.testpproject.designmode.Iteratormode;

public class NameRepository implements Container {

    private String[] names = {"Robert", "John", "Julie", "Lora"};


    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }


    public class NameIterator implements Iterator {


        private int index;

        @Override
        public boolean hasNext() {

            if (index < names.length) {

                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (hasNext()) {

                return names[index++];

            }
            return null;
        }
    }
}
