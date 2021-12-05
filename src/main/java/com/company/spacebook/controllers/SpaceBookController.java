package com.company.spacebook.controllers;

import com.company.spacebook.models.SpacePost;
import com.company.spacebook.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.memory.Space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SpaceBookController {
    private List<User> userList;

    public SpaceBookController(){

        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        luis.setSpacePosts(Arrays.asList(new SpacePost("Hey! This is my first post!"), new SpacePost("Anybody want to be friends?")));
        sue.setSpacePosts(Arrays.asList(new SpacePost("I'm bored"), new SpacePost("Who wants to hang?")));
        timothy.setSpacePosts(Arrays.asList(new SpacePost("My life is awesome!"), new SpacePost("Click here to buy my vegan shakes!")));
        george.setSpacePosts(Arrays.asList(new SpacePost("I like pigs."), new SpacePost("I love lamp.")));
        arturo.setSpacePosts(Arrays.asList(new SpacePost("My cat is so cute"), new SpacePost("My kitten is purr-fect.")));
        mariella.setSpacePosts(Arrays.asList(new SpacePost("I'll never post again")));
        paolo.setSpacePosts(Arrays.asList(new SpacePost("Have you ever heard of the band Nirvana?"), new SpacePost("Pearl Jam 4 Life")));
        tri.setSpacePosts(Arrays.asList(new SpacePost("You definitely grew up in the 90s if you get these 10 references."), new SpacePost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setSpacePosts(Arrays.asList(new SpacePost("I just wrecked my dad's car. He's going to kill me!"), new SpacePost("Grounded.... for 5 months :( ")));
        carol.setSpacePosts(Arrays.asList(new SpacePost("Does anyone have some imodium?")));
        carl.setSpacePosts(Arrays.asList(new SpacePost("My roommate is awful!!!!"), new SpacePost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);

    }
    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getAllUsers(){
        return userList;
    }
    @RequestMapping(value="/users/{username}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User getUserByUsername(@PathVariable String username){
        User rv= null;
        for(User user: userList){
            if(user.getName().equals(username)){
                rv= user;
                break;
            }
        }
        return rv;
    }
    @RequestMapping(value="/spacePosts/{username}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<SpacePost>  getSpacePostsByUser(@PathVariable String username){
        List<SpacePost> spacePosts = null;
        for(User user: userList){
            if(user.getName().equals(username)){
                spacePosts= user.getSpacePosts();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        return spacePosts;
    }
}
