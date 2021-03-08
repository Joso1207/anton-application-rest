/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author joso
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(database.service.CategoryFacadeREST.class);
        resources.add(database.service.DiningtableFacadeREST.class);
        resources.add(database.service.DishFacadeREST.class);
        resources.add(database.service.EmployeeFacadeREST.class);
        resources.add(database.service.LoginFacadeREST.class);
        resources.add(database.service.MenuFacadeREST.class);
        resources.add(database.service.OrderItemFacadeREST.class);
        resources.add(database.service.OrdersFacadeREST.class);
        resources.add(database.service.StatesFacadeREST.class);
        resources.add(database.service.TableBookingFacadeREST.class);
        resources.add(database.service.WeekSchedualFacadeREST.class);
        resources.add(database.service.WorkShiftFacadeREST.class);
    }
    
}
