package com.yesterdaysnews.yesterdaysnews.service;

import java.util.List;

/**
 * Generic interface for CRUD operations.
 *
 * @param <T>  The type of the entity.
 * @param <ID> The type of the entity's ID.
 */
public interface IGenericService<T, ID> {

    /**
     * Creates a new entity.
     *
     * @param entity The entity to create.
     * @return The created entity.
     */
    T create(T entity);

    /**
     * Retrieves all entities.
     *
     * @return A list of all entities.
     */
    List<T> getAll();

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity.
     * @return The entity with the given ID.
     * @throws RuntimeException If the entity is not found.
     */
    T getById(ID id);

    /**
     * Updates an existing entity by its ID.
     *
     * @param id     The ID of the entity to update.
     * @param entity The updated entity data.
     * @return The updated entity.
     * @throws RuntimeException If the entity is not found.
     */
    T update(ID id, T entity);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     * @throws RuntimeException If the entity is not found.
     */
    void deleteById(ID id);
}