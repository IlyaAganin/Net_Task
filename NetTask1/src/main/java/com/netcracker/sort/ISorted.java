package com.netcracker.sort;

import java.util.Comparator;

import ru.vsu.lab.repository.IRepository;

public interface ISorted<T> {
	void sort(final IRepository<T> repository,final Comparator<T> comparator);
}
