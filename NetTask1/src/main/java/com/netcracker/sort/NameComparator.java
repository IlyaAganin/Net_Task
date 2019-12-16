package com.netcracker.sort;

import java.util.Comparator;
import ru.vsu.lab.entities.IPerson;

/**
 * comparator
 * @param <T> parameter of typing
 */
public class NameComparator<T> implements Comparator<T> {
    /**
     *
     * @param o1 
     * @param o2 
     * @return 
     */

    @Override
    public int compare(final T o1, final T o2) {
        if (((IPerson) o1).getLastName()
                .compareTo(((IPerson) o2)
                        .getLastName()) > 0) {
            return 1;
        } else if (((IPerson) o1).getLastName()
                .compareTo(((IPerson) o2)
                        .getLastName()) == 0) {
            if (((IPerson) o1).getFirstName()
                    .compareTo(((IPerson) o2)
                            .getFirstName()) > 0) {
                return 0;
            }
        }
        return 0;
    }
}