package com.epam.oreshkevich.creator.creatorHandler;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 30.05.2017.
 */
public interface Icreator<T, V> {
    Optional<T> create(Optional<List<V>> list);

}
