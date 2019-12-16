package com.netcracker.sort;

import java.util.Comparator;
import ru.vsu.lab.entities.IPerson;

/**
 * comparator for years
 */
public class AgeComparator<T> implements Comparator<T> {
    /**
     * @param o1 
     * @param o2 
     * @return 
     */
    @Override
    public int compare(final T o1, final T o2) {
        if (((IPerson)o1).getBirthdate().isBefore(((IPerson)o2).getBirthdate())) {
            return 1;
        }
        return 0;
    }
}