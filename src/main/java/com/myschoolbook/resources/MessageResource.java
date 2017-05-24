package com.myschoolbook.resources;

import com.myschoolbook.model.Message;
import com.myschoolbook.service.MessageService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by Krystian on 2017-05-03.
 */
@Path("/messeges")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService msgs = new MessageService();

    @GET
    public List<Message> getMessages(){
        return msgs.getAllMessages();
    }

    @POST
    public Message addMessage(Message message){
        return msgs.addMessage(message);
    }


    @GET
    @Path("/{messageId}")
    public Message getMessageById(@PathParam("messageId") String messageId ){
        int id = Integer.parseInt(messageId);
        return msgs.getMessageById(id);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") int id, Message message){
        return msgs.updateMessage(id, message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") int id){
        msgs.removeMessage(id);
    }

}
