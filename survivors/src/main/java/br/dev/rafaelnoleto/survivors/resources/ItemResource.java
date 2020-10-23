package br.dev.rafaelnoleto.survivors.resources;

import br.dev.rafaelnoleto.survivors.model.service.ItemService;
import br.dev.rafaelnoleto.survivors.utils.Utils;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("items")
public class ItemResource {

    private final ItemService service = new ItemService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(LinkedHashMap<String, Object> data) {
        List<String> errors = this.service.validate(data);

        if (!errors.isEmpty()) {
            return Utils.responseError(errors);
        }

        final Integer id = this.service.create(data);

        return Utils.response(Utils.parseIdResponse(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<LinkedHashMap<String, Object>> data = this.service.readAll();
        return Utils.response(data);
    }

}
