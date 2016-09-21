/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.unibi.cebitec.bibiserv.web.rest;

import de.unibi.cebitec.bibiserv.server.manager.Core;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.core.Application;

/**
 *
 * @author jkrueger
 */
public class BiBiServRESTServlet extends ServletContainer {

    private Core core = Core.getInstance();

    public BiBiServRESTServlet() {
        super();
        //register current servlet instance at Core
        core.addRestServletContainer(this);
    }

    public BiBiServRESTServlet(Application app) {
        super(ResourceConfig.forApplication(app));
        //register current servlet instance at Core
        core.addRestServletContainer(this);
    }

    public BiBiServRESTServlet(Class<? extends Application> appClass) {
        super(ResourceConfig.forApplicationClass(appClass));
        //register current servlet instance at Core
        core.addRestServletContainer(this);
    }
}
