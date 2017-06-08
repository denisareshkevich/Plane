package com.epam.oreshkevich.entity;


/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public interface Observable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();

}
