package net.hackraft.api.resourse;

import net.hackraft.api.model.action.ActionMouse;
import net.hackraft.core.domain.action.ActionDomain;
import net.hackraft.core.model.action.ActionMouseBO;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static net.hackraft.api.resourse.converter.ConverterAction.convertorToActionMouseBO;
import static net.hackraft.api.resourse.converter.ConverterAction.toActionMouseList;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
@RequestScoped
@Path(value = "/")
@PermitAll
public class ActionAPI {

    private ActionDomain actionDomain = new ActionDomain();

    @POST
    @Path("action/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUsersActions(List<ActionMouse> actionMouses) {
        List<ActionMouseBO> actionMouseList = new ArrayList<>();
        for (ActionMouse action : actionMouses) {
            actionMouseList.add(convertorToActionMouseBO(action));
        }
        List<ActionMouse> responses = toActionMouseList(actionDomain.insert(actionMouseList));
        return  Response.ok().entity(responses).build();
    }

    @GET
    @Path("action/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersActions(@QueryParam("user_id") String userId) {
        List<ActionMouse> responses = toActionMouseList(actionDomain.get(userId));
        return  Response.ok().entity(responses).build();
    }
}