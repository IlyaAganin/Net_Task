package com.netcracker.sort;

import java.util.Comparator;
import ru.vsu.lab.repository.IRepository;

/**
 * Bubble sort
 */
public class BubbleSorter<T> implements ISorted<T> {
    /**
     * method which sort containers 
     * @param repository 
     * @param comparator 
     */
    @Override
    public void sort(final IRepository<T> repository,
                     final Comparator<T> comparator) {
        int personLenght = 0;
        for (Object iPerson : repository.toList()) {
            if (iPerson != null) {
                personLenght++;
            }
        }
        for (int i = personLenght - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((comparator.compare(repository.get(j),
                        repository.get(j + 1))) > 0) {
                    T tempPerson = repository.get(j);
                    repository.set(j, repository.get(j + 1));
                    repository.set(j + 1, tempPerson);
                }

            }
        }
    }
}
