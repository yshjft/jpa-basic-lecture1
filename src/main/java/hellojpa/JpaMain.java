package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션을 할 때마다 반드시 EntityManager를 만들어야 한다
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 데이터 저장
            // Member member = new Member();
            // member.setId(2L);
            // member.setName("Hello B");
            // em.persist(member);

            // 전체 데이터 조회
            // 객체를 대상으로 쿼리를 작성(Member 객체를 모두 가지고 와라)
            //            List<Member> result = em.createQuery("select m from Member as m", Member.class)
            //                    .setFirstResult(0) // 0번 부터
            //                    .setMaxResults(8) // 8개의 결과물을 가져와
            //                    .getResultList();
            //            for(Member member : result) {
            //                System.out.println(member.getId()+" "+member.getName());
            //            }

            // 특정 데이터 조회
            // Member findMember = em.find(Member.class, 1L);
            // System.out.println(findMember.getId() + " "+findMember.getName());

            // 삭제
            // em.remove(findMember);

            // 수정
            // jpa를 통해 entity를 가져오면 해당 Entity를 JPA가 관리하게 된다.
            // jpa가 Entity를 트랜잭션 커밋하기 직전에 체크한다 -> 변경이 있을 경우 update 쿼리를 생성하고 전달한다
            // findMember.setName("HelloJPA");

            tx.commit(); // 변경 사항 반영을 위해 반드시 할 것
        }catch(Exception e) {
            tx.rollback(); // 에러가 발생한 경우 transaction 롤백
        }finally {
            em.close(); // 끝난 후에 데이터베이스 커낵션 반환
        }
        emf.close();

    }
}
