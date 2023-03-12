package com.example.sbquerydsl.jooq.account.persistent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountWriteRepository extends JpaRepository<AccountEntity, Long> {
}
