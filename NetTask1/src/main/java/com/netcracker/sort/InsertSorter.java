package com.netcracker.sort;

import java.util.Comparator;
import ru.vsu.lab.repository.IRepository;

/**
 * Insert sort
 */
public class InsertSorter<T> implements ISorted<T> {
    /**
     * method which sort containers
     * @param repository
     * @param comparator
     */
    @Override
    public void sort(final IRepository<T> repository,
                     final Comparator<T> comparator) {
        int personLength = 0;
        for (T iPerson : repository.toList()) {
            if (iPerson != null) {
                ++personLength;
            }
        }
        for (int i = 1; i < personLength; i++) {
            T current = repository.get(i);
            int j = i - 1;
            while(j >= 0 && comparator.compare(repository.get(j), current) > 0) {
                repository.set(j + 1, repository.get(j));
                j--;
            }
            repository.set(j + 1, current);
        }
    }
}
