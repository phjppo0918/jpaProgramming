package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {

        //엔티티 메니저 팩토리 생성
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpabook");
        //엔티티 메니저 생성
        EntityManager em = emf.createEntityManager();

        //트랜젝션 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin(); // 트랜젝션 시작
            joinMember(em); // 비즈니스 로직 실행
            tx.commit(); //트란젝션 - 커밋
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

    //비즈니스 로직
    private static void joinMember(EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUserName("준");
        member.setAge(24);

        //등록
        em.persist(member);

        //수정
        member.setAge(21); // 엔티티메니저가 변경내용을 추적하여 db저장에 반영

        //한 건 조회
        Member findMember = em.find(Member.class, id);

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        //제거
        em.remove(member);
    }
}
