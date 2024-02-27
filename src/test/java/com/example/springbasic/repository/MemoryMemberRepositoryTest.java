package com.example.springbasic.repository;

import com.springbasic.domain.Member;
import com.springbasic.repository.MemberRepository;
import com.springbasic.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("jongwoo");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("jongwoo");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("joy");
        repository.save(member2);

        Member result = repository.findByName("jongwoo").get();

        assertThat(result).isEqualTo(member1);
    }
}
