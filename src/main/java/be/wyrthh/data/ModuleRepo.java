package be.wyrthh.data;

import be.wyrthh.model.Module;
import be.wyrthh.service.EntityChecker;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;

public class ModuleRepo {

    /* Instances of objects containing the validation methods and entity manager methods to interact with the database */
    EntityManagerMethods emMethods = new EntityManagerMethods();
    EntityChecker eCheck = new EntityChecker();


    /**
     * Insert module into the database.
     * @param module
     *          module to be inserted into the database.
     */
    public void insertmodule(Module module){
        emMethods.mergeTransaction(module);
    }

    /**
     * Get the module entity from the database that has the given ID.
     * @param id
     *          ID of the module that has to be get from the database
     * @return
     *          Returns the module with the given ID.
     *          If there is no module with that given ID, it returns an empty object.
     */
    public Module getmoduleById (Long id){
        EntityManager em = EntityManagerProvider.getEM();
        Module module = em.find(Module.class, id);
        return module;
    }

    /**
     * Update the module entity in the database, if the module entity doesn't exist in the database it will be added to the database,
     * if it already exists in the database it will be updated with the new properties.
     * @param module
     *          Entity to be updated.
     */
    public void updatemodule (Module module){
        emMethods.mergeTransaction(module);
    }

    /**
     * Delete the given module from the database.
     * @param module
     *          module entity to be deleted from the database.
     * @return
     *          True if the module entity has been deleted.
     * @throws TransactionException
     *          Throw exception if there isn't a module object with the same ID in the database.
     */
    public Boolean deletemodule (Module module) throws TransactionException{
        if (eCheck.checkIfModuleExists(module)){
            throw new TransactionException("The module you are looking for is not to be found (maybe they deleted themselves when they realised what you were going to do...)");
        }
        else {
            emMethods.deleteTransaction(module);
            return true;
        }
    }
}
