package springbook.proxy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Team {
    @Id
    private String teamId;

    private String teamName;
}
