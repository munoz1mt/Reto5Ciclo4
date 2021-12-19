package com.usa.ciclo4.reto3ciclo4.repository;

import com.usa.ciclo4.reto3ciclo4.model.User;
import com.usa.ciclo4.reto3ciclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 *
 * @author Sebastián
 */
@Repository
/**
 * Class UserRepository
 */
public class UserRepository {
    /**
     * esta es la instancia UserCrudRepository
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Este es el método que retorna la lista de usuarios
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     *Con este método  retorna el usuario por id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Este método que se encarga de almacenar usuarios
     * @param user
     * @return 
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * Con este metodo se actualiza usuarios
     * @param user 
     */
    public void update(User user){
        userCrudRepository.save(user);
    }

    /**
     * Con este método se elimina usuarios
     * @param user
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /**
     * Con este método se verifica si un email ya existe
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /**
     * Con este método se autentica por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Este método se encarga de retornar el usuario por fecha de cumpleaños
     * @param month
     * @return
     */
    public List<User> getByMonthBirthDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
