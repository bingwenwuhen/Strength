package cn.com.jersey.kryo.resources;

import cn.com.jersey.kryo.bean.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xiaxuan on 16/11/25.
 */
@Path("/")
@Consumes("application/x-kryo")
@Produces("application/x-kryo")
public class PersonResource {

    @POST
    public Person echo(final Person person) {
        return person;
    }

    @PUT
    public void put(final Person person) {
        System.out.println(person);
    }

    @GET
    public Person get() {
        return new Person("xiaxuan", 21, "Sazburg");
    }
}
