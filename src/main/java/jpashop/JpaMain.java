package jpashop;

import food.FoodMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            FoodMember foodMember = new FoodMember();
            foodMember.setUsername("member1");
            foodMember.setHomeAddress(new Address("city1", "street", "1000"));

            foodMember.getFavoriteFoods().add("치킨");
            foodMember.getFavoriteFoods().add("족발");
            foodMember.getFavoriteFoods().add("피자");

            foodMember.getAddressHistory().add(new AddressEntity("city2", "street2", "2000"));
            foodMember.getAddressHistory().add(new AddressEntity("city3", "street3", "3000"));

            em.persist(foodMember);

            em.flush();
            em.clear();

            System.out.println("========START=========");
            FoodMember findMember = em.find(FoodMember.class, foodMember.getId());

            //city1->new city
//            findMember.getHomeAddress().setCity("newCity"); 이렇게 변경하는 방식은 사이드 이펙트가 생길 수 있다
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            //치킨->한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            //equals, hashcode가 중요!
            //city2-> newCity
            findMember.getAddressHistory().remove(new AddressEntity("city2", "street2", "2000"));
            foodMember.getAddressHistory().add(new AddressEntity("newCity", "street2", "2000"));



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
