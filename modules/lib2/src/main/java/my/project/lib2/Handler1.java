package my.project.lib2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.context.Dependent;

import my.project.lib2.dto.ResponseDTO;

@Dependent
public class Handler1 {

    private List<String> actors = List.of(
        "Scarlett Johansson", "Robert Downey Jr.", "Paul Rudd", "Chris Evans", "Chris Hemsworth",
        "Samuel L. Jackson", "Anthony Mackie", "Chris Pratt", "Evangeline Lilly", "Benedict Cumberbatch",
        "Tom Holland", "Don Cheadle", "Brie Larson", "Mark Ruffalo", "Jeremy Renner", "Jon Favreau", "Anthony Hopkins", "Josh Brolin", "Natalie Portman", 
        "Cobie Smulders", "Liv Tyler", "Chadwick Boseman", "Zoe Saldana", "Tommy Lee Jones", "Elizabeth Olsen",
        "Dave Bautista", "Tom Hiddleston", "Karen Gillan", "Paul Bettany", "Aaron Taylor-Johnson", "Idris Elba"
    );

    private String mapString = "OMG, SEBASTIAN STAN, man you're looking good man oh man let me tell you something. You ever seen a guy this handsome walking in the streets, he's gonna get arrested because he's killing all the ladys. Look at that. Pow pow pow pow pow";
    
    private String connectionsString = "We come to this place for magic. We come to AMC theaters to laugh, to cry, to care, because we need that--all of us. That indescribable feeling we get when the lights begin to dim, and we go somewhere we've never been before. Not just entertained but somehow reborn together. Dazzling images on a huge silver screen. Sound that I can feel. Somehow, heartbreak feels good in a place like this. Our heroes feel like the best part of us. And stories feel perfect and powerful. Because here... they are.";

    public ResponseDTO getLargeDTO(final UUID id) {
        
        final String name = "This is my full name it's very formal and long";
        final String nickname = "This is my nickname it's shorter I guess";
        final Map<String, String> map = new HashMap<>();
        final Map<String, String> connections = new HashMap<>();

        for (String actor : actors) {
            map.putIfAbsent(actor, mapString);
            connections.putIfAbsent(actor, connectionsString);
        }

        final ResponseDTO response = new ResponseDTO(id, name, nickname, map, connections);
        
        return response;
    }

    public ResponseDTO getAverageDTO(final UUID id) {

        final String name = "My name";
        final String nickname = "My nickname";
        final Map<String, String> map = new HashMap<>();
        final Map<String, String> connections = new HashMap<>();

        for (String actor : actors) {
            map.putIfAbsent(actor, "hi");
            connections.putIfAbsent(actor, "hello");
        }

        final ResponseDTO response = new ResponseDTO(id, name, nickname, map, connections);
        
        return response;
    }
}