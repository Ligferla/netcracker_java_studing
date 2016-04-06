package ru.ncedu.java.tasks;

import static java.text.DateFormat.MEDIUM;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateCollectionsImpl implements DateCollections {

    private int dateStyle = MEDIUM;

    Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            DateFormat df = DateFormat.getDateInstance(dateStyle, Locale.getDefault());
            Date d1 = null;
            try {
                d1 = df.parse(s1);
            } catch (ParseException ex) {
                Logger.getLogger(DateCollectionsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date d2 = null;
            try {
                d2 = df.parse(s2);
            } catch (ParseException ex) {
                Logger.getLogger(DateCollectionsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return d1.compareTo(d2);
        }
    };
    private Map<String, Element> sortedMap = new TreeMap(comp);

    @Override
    public void setDateStyle(int dateStyle) {
        this.dateStyle = dateStyle;
    }

    @Override
    public Calendar toCalendar(String dateString) throws ParseException {
        try {
            DateFormat df = DateFormat.getDateInstance(this.dateStyle, Locale.getDefault());
            Date date = df.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (NullPointerException ex) {
            throw new ParseException(ex.getMessage(), 0);
        }
    }

    @Override
    public String toString(Calendar date) {
        DateFormat df = DateFormat.getDateInstance(this.dateStyle, Locale.getDefault());
        return df.format(date.getTime());
    }

    @Override
    public void initMainMap(int elementsNumber, Calendar firstDate) {
        DateFormat df = DateFormat.getDateInstance(this.dateStyle, Locale.getDefault());
        Random rand = new Random();
        for (int i = 0; i < elementsNumber; i++) {
            Calendar c = (Calendar) firstDate.clone();
            c.add(Calendar.DAY_OF_MONTH, i * 110);
            int lifetime = rand.nextInt(2001);
            this.sortedMap.put(df.format(c.getTime()), new Element(c, lifetime));
        }
    }

    @Override
    public void setMainMap(Map<String, Element> map) {
        Map<String, Element> newSortedMap = new TreeMap<>(comp);
        newSortedMap.putAll(map);
        this.sortedMap = newSortedMap;
    }

    @Override
    public Map<String, Element> getMainMap() {
        return this.sortedMap;
    }

    @Override
    public SortedMap<String, Element> getSortedSubMap() {

        SortedMap<String, Element> subMap = new TreeMap<>(comp);
        DateFormat df = DateFormat.getDateInstance(this.dateStyle, Locale.getDefault());

        Date now = new Date();
        Calendar nowCal = Calendar.getInstance();
        nowCal.setTime(now);

        for (Map.Entry<String, Element> pair : sortedMap.entrySet()) {
            Calendar c = pair.getValue().getBirthDate();
            if (c.after(nowCal)) {
                subMap.put(pair.getKey(), pair.getValue());
            }
        }
        return subMap;
    }

    @Override
    public List<Element> getMainList() {
        List<Element> list = new ArrayList<>();
        for (Map.Entry<String, Element> pair : sortedMap.entrySet()) {
            list.add(pair.getValue());
        }
        return list;
    }

    @Override
    public void sortList(List<Element> list) {
        class ListComparator implements Comparator<Element> {

            @Override
            public int compare(Element e1, Element e2) {
                return e1.getDeathDate().compareTo(e2.getDeathDate());
            }
        }
        Collections.sort(list, new ListComparator());
    }

    @Override
    public void removeFromList(List<Element> list) {
        for (Iterator<Element> it = list.iterator(); it.hasNext();) {
            int month = it.next().getBirthDate().get(Calendar.MONTH) + 1;
            if ((1 == month) || (2 == month) || (12 == month)) {
                it.remove();
            }
        }
    }
}
