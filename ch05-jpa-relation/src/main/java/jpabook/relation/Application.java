package jpabook.relation;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //엔티티 메니저 팩토리 생성
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpabook");
        //엔티티 메니저 생성
        EntityManager em = emf.createEntityManager();

        //트랜젝션 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            biDirection(em);
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
    public static void testSave(EntityManager em) {
        //팀1 저장
        Team team1 = new Team("Team1", "팀1");
        em.persist(team1);

        //회원 저장
        Member member1 = new Member("Member1", "회원1");
        member1.setTeam(team1); // 연관관계 설정
        //team1.getMembers().add(member1);
        em.persist(member1);

        Member member2 = new Member("Member2", "회원2");
        member2.setTeam(team1); // 연관관계 설정
       // team1.getMembers().add(member2);
        em.persist(member2);
    }
    public static void queryLogicJoin(EntityManager em) {

        String jpql = "select m from Member m join m.team t " +
                "where t.name=:teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for(Member member : resultList) {
            System.out.println("[query] member.username = " + member.getUsername());
        }

    }

    public static void updateRelation(EntityManager em) {

        //새로운 팀2
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    public static void deleteRelation(EntityManager em) {

        Member member = em.find(Member.class, "member2");
        member.setTeam(null);
    }

    public static void biDirection(EntityManager em) {
        Team team = em.find(Team.class, "team2");
        List<Member> members = team.getMembers();

        for(Member member: members) {
            System.out.println("member.username = " + member.getUsername());
        }
    }
}
