package com.myschoolbook.resources;

import com.myschoolbook.model.Profile;
import com.myschoolbook.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Krystian on 2017-05-23.
 */
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }

    @POST
    public Profile addMessage(Profile profile){
        return profileService.addProfile(profile);
    }


    @GET
    @Path("/{profileName}")
    public Profile getMessageById(@PathParam("profileName") String profileName ){
        return profileService.getProfileByName(profileName);
    }

    @PUT
    @Path("/{profileId}")
    public Profile updateMessage(@PathParam("profileName") String profileName, Profile profile){
        return profileService.updateMessage(profileName, profile);
    }

    @DELETE
    @Path("/{profileId}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileService.removeProfile(profileName);
    }

}
