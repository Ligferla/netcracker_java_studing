package ru.ncedu.java.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.HashSet;

public class StringFilterImpl implements StringFilter {

    HashSet<String> h_set = new HashSet<>();

    @Override
    public void add(String s) {
        String lower_case_s;
        if (s == null) {
            lower_case_s = s;
        } else {
            lower_case_s = s.toLowerCase();
        }
        if (!h_set.contains(lower_case_s)) {
            h_set.add(lower_case_s);
        }
    }

    @Override
    public boolean remove(String s) {
        String lower_case_s;
        if (s == null) {
            lower_case_s = s;
        } else {
            lower_case_s = s.toLowerCase();
        }
        if (!h_set.contains(lower_case_s)) {
            return false;
        } else {
            h_set.remove(lower_case_s);
            return true;
        }
    }

    @Override
    public void removeAll() {
        h_set.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return h_set;
    }

    interface Filter {

        public String getFilterString();

        public boolean filter(String s);
    }

    public Iterator<String> getStrings(Filter f) {
        if ((f.getFilterString() == null) || (f.getFilterString().equals(""))) {
            return h_set.iterator();
        }
        HashSet<String> result = new HashSet<>();
        Iterator iterator = h_set.iterator();
        while (iterator.hasNext()) {
            Object s = iterator.next();
            String str;
            if ((!(s == null)) && (f.filter(str = s.toString()))) {
                result.add(str);
            }
        }
        return result.iterator();
    }

    @Override
    public Iterator<String> getStringsContaining(final String chars) {
        Filter f = new Filter() {
            public String filter_string;

            public String getFilterString() {
                filter_string = chars;
                return filter_string;
            }

            public boolean filter(String s) {
                filter_string = chars.toLowerCase();
                return s.contains(filter_string);
            }
        };
        return getStrings(f);
    }

    @Override
    public Iterator<String> getStringsStartingWith(final String begin) {
        Filter f = new Filter() {
            public String filter_string;

            @Override
            public String getFilterString() {
                filter_string = begin;
                return filter_string;
            }

            @Override
            public boolean filter(String s) {
                filter_string = begin.toLowerCase();
                return s.startsWith(filter_string);
            }
        };
        return getStrings(f);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        return h_set.iterator();
    }
    
    @Override
    public Iterator<String> getStringsByPattern(String pattern){
        return h_set.iterator();
    }
}
