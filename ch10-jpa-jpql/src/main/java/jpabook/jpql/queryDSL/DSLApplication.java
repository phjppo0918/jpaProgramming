package jpabook.jpql.queryDSL;

import com.querydsl.jpa.impl.JPAQuery;
import jpabook.jpql.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DSLApplication {
    public static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("jpabook");
    public static EntityManager em = emf.createEntityManager();
    public static EntityTransaction tx = em.getTransaction();
    public static void main(String[] args) {


    }
    public static void queryDSL() {
        JPAQuery query = new JPAQuery(em);
        QMember qMember = new QMember("m"); //생성되는 jpql 별칭이 m
        List<Member> members = query.from(qMember)
                .where(qMember.username.eq("회원1"))
                .orderBy(qMember.username.desc())
                .list(qMember);
    }
}
