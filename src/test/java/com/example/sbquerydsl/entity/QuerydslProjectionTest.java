package com.example.sbquerydsl.entity;


import com.example.sbquerydsl.dto.MemberDto;
import com.example.sbquerydsl.dto.QMemberDto;
import com.example.sbquerydsl.dto.UserDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.sbquerydsl.entity.QMember.member;
import static com.example.sbquerydsl.entity.QTeam.team;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.linesOf;

@SpringBootTest
@Transactional
public class QuerydslProjectionTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @PersistenceUnit
    EntityManagerFactory emf;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);

//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();


        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);

        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        //em.flush();
       // em.clear();
//        transaction.commit();
    }

    @Test
    public void simpleProjection() {
        List<String> result = queryFactory
                .select(member.username)
                .from(member)
                .fetch();

        for(String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void tupleProjection() {
        List<Tuple> result = queryFactory
                .select(member.username, member.age)
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            String username = tuple.get(member.username);
            Integer age = tuple.get(member.age);
            System.out.println("username = " + username +"/"+ "age = " + age);
        }
    }

    @Test
    public void findDtoBySetter() {
        List<MemberDto> result = queryFactory
                .select(Projections.bean(MemberDto.class, member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto:" + memberDto);
        }

    }

    @Test
    public void findUserDto() {
        List<UserDto> result = queryFactory
                .select(Projections.fields(UserDto.class, member.username.as("name"), member.age))
                .from(member)
                .fetch();

        for (UserDto userDto : result) {
            System.out.println("memberDto:" + userDto);
        }
    }

    @Test
    public void findDataByQueryProjection() {
        List<MemberDto> result = queryFactory
                .select(new QMemberDto(member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto:" + memberDto);
        }
    }

    private List<Member> searchMember(String usernameParam, Integer ageParam) {
        BooleanBuilder builder = new BooleanBuilder();
        if (usernameParam != null) {
            builder.and(member.username.eq(usernameParam));
        }
        if (ageParam != null) {
            builder.and(member.age.eq(ageParam));
        }
        return queryFactory
                .selectFrom(member)
                .where(builder)
                .fetch();
    }

    @Test
    public void dynamicQueryBooleanBuilder() {
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember(usernameParam,ageParam );

        Assertions.assertEquals(1, result.size());
    }

    private List<Member> searchMemberWithWhere(String usernameCond, Integer ageCond) {
        return queryFactory
                .selectFrom(member)
                .where(usernameEq(usernameCond), ageEq(ageCond))
                .fetch();
    }

    private BooleanExpression usernameEq(String usernameCond) {
        if (usernameCond == null) {
            return null;
        }
        return member.username.eq(usernameCond);
    }

    private BooleanExpression ageEq(Integer ageCond) {
        if(ageCond == null) {
            return null;
        }
        return  member.age.eq(ageCond);
    }

    @Test
    public void dynaicQueryWhereParam() {
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMemberWithWhere(usernameParam, ageParam);

        Assertions.assertEquals(1, result.size());
    }

}
