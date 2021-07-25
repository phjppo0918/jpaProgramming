package jpabook.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
            tx.begin(); // 트랜젝션 시작
            searchByName(em); // 비즈니스 로직 실행
            tx.commit(); //트란젝션 - 커밋
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
    public static List<Member> searchByName(EntityManager em) {
        String jpql = "select m from Member as m where m.username = 'kim'";

        return em.createQuery(jpql, Member.class).getResultList();
    }

    public static List<Member> searchByNameCriteria(EntityManager em) {

        // Criteria 사용 준비
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);

        // 루트 클래스 (조회를 시작할 클래스)
        Root<Member> m = query.from(Member.class);

        //쿼리 생성
        CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
        return em.createQuery(cq).getResultList();

    }

    public static List<Member> searchByNameNativeSQL(EntityManager em) {
        String sql = "SELECT ID, AGE, TEAM_ID, NAME FROM MEMBER WHERE NAME = 'KIM'";
        return em.createNativeQuery(sql, Member.class).getResultList();
    }


}
