package ru.ncedu.java.tasks;

import java.text.DateFormat;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.getDateInstance;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import ru.ncedu.java.tasks.DateCollections.Element;

public class Main {

    public static void main(String[] args) throws ParseException {
        DateCollections dc = new DateCollectionsImpl();
        Calendar c = dc.toCalendar("20.12.1992");
//        dc.initMainMap(4,c);
//        System.out.println(dc.getMainMap());
//        dc.toCalendar(null);
        Map<String, Element> map = new TreeMap<>();
        DateFormat df = DateFormat.getDateInstance(MEDIUM);

        Calendar c1 = dc.toCalendar("21.11.2014");
        int lifetime_1 = 3000;
        Calendar c2 = dc.toCalendar("21.11.2015");
        int lifetime_2 = 300;
        Calendar c3 = dc.toCalendar("21.11.2017");
        int lifetime_3 = 30;
        
        map.put(df.format(c1.getTime()), new Element(c1, lifetime_1));
        map.put(df.format(c2.getTime()), new Element(c2, lifetime_2));
        map.put(df.format(c3.getTime()), new Element(c3, lifetime_3));
        
        dc.setMainMap(map);
        
        System.out.println(dc.getSortedSubMap());
    }

}
