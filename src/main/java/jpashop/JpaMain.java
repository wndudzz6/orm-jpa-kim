package jpashop;

import food.FoodMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpashop.domain.*;

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

            foodMember.getAddressHistory().add(new Address("city2", "street2", "2000"));
            foodMember.getAddressHistory().add(new Address("city3", "street3", "3000"));

            em.persist(foodMember);

            em.flush();
            em.clear();

            System.out.println("========START=========");
            FoodMember findMember = em.find(FoodMember.class, foodMember.getId());

            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address = " + address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }
}
