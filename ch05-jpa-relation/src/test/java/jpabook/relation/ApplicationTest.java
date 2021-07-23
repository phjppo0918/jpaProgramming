package jpabook.relation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ApplicationTest {
    @Test
    public void test순수한_객체_양방향() {

        //팀1
        Team team1 = new Team("team3", "팀1");
        team1.setMembers(new ArrayList<Member>());
        Member member3 = new Member("member3", "회원3");
        Member member4 = new Member("member4", "회원4");

        member3.setTeam(team1);
        team1.getMembers().add(member3);
        member4.setTeam(team1);
        team1.getMembers().add(member4);

        List<Member> members = team1.getMembers();
        Assertions.assertEquals(2, members.size());

    }
}