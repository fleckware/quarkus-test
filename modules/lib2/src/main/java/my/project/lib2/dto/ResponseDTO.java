package my.project.lib2.dto;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO {
    
    private UUID id;
    public UUID getId() {
        return id;
    }

    private String name;
    public String getName() {
        return name;
    }

    private String nickname;
    public String getNickname() {
        return nickname;
    }

    private Map<String, String> map;
    public Map<String, String> getMap() {
        return map;
    }

    private Map<String, String> connections;
    public Map<String, String> getConnections() {
        return connections;
    }

    @JsonCreator
    public ResponseDTO(@JsonProperty("id") final UUID id,
        @JsonProperty("name") final String name,
        @JsonProperty("nickname") final String nickname,
        @JsonProperty("map") final Map<String, String> map,
        @JsonProperty("connections") final Map<String, String> connections) {

            this.id = id;
            this.name = name;
            this.nickname = nickname;
            this.map = map;
            this.connections = connections;
    }
}
