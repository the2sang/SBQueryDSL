package com.example.sbquerydsl.repository;


import com.example.sbquerydsl.dto.MemberTeamDto;
import com.example.sbquerydsl.dto.condition.MemberSearchCondition;
import com.example.sbquerydsl.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends BaseRepository<Member, Integer> {

    public void saveMember(Member member);

    public Optional<Member> findById(Integer id);

    public List<Member> findAll_Querydsl();

    public List<Member> findByUsername_Querydsl(String username);

    public List<Member> findByUsername(String username);

    public List<Member> findAll();

    public List<MemberTeamDto> search(MemberSearchCondition condition);
}
