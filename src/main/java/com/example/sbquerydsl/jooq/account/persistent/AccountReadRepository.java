package com.example.sbquerydsl.jooq.account.persistent;

import lombok.RequiredArgsConstructor;
import nu.studer.sample.tables.Account;
import org.jooq.*;
import org.springframework.stereotype.Repository;

import static nu.studer.sample.Tables.ACCOUNT;
import static org.jooq.impl.DSL.*;


@Repository
@RequiredArgsConstructor
public class AccountReadRepository {

    private final DSLContext dsl;
    private final Account account = Account.ACCOUNT;

    public boolean existsUserInfo(String email, String username) {
        return dsl.fetchExists(
                dsl.selectOne()
                        .from(account)
                        .where(account.EMAIL.eq(email), account.USERNAME.eq(username))
        );
    }

    public AccountEntity findByUsername(String username) {

        /*  명시적 매핑 alias
            dsl.select(
                        account.ID.as("id"),
                        account.USERNAME.as("username"),
                        account.PASSWORD.as("password"),
                        account.EMAIL.as("email"),
                        account.ROLES.as("roles")
                )
                .from(account)
                .where(account.USERNAME.eq(username))
                .fetchOneInto(AccountEntity.class);
         */

        // 묵시적 매핑 - ResultSet 과 Entity field 명 자동 매칭
        return dsl.select()
                .from(account)
                .where(account.USERNAME.eq(username))
                .fetchOneInto(AccountEntity.class);
    }

    public String fetchAccountPageAndMetadata(int limit, int offset) {
        return paginate(
                dsl, dsl.select(ACCOUNT.ID, ACCOUNT.USERNAME, ACCOUNT.EMAIL, ACCOUNT.ROLES ).from(ACCOUNT),
                new Field[]{ACCOUNT.ID}, limit, offset
        ).fetch().formatJSON(JSONFormat.DEFAULT_FOR_RECORDS);
    }

    private Select<?> paginate(DSLContext ctx, Select<?> original, Field<?>[] sort, int limit, int offset) {

        Table<?> u = original.asTable("u");
        Field<Integer> totalRows = count().over().as("total_rows");
        Field<Integer> row = rowNumber().over().orderBy(u.fields(sort))
                .as("row");

        Table<?> t = ctx
                .select(u.asterisk())
                .select(totalRows, row)
                .from(u)
                .orderBy(u.fields(sort))
                .limit(limit)
                .offset(offset)
                .asTable("t");

        Select<?> result = ctx
                .select(t.fields(original.getSelect().toArray(Field[]::new)))
                .select(
                        count().over().as("actual_page_size"),
                        field(max(t.field(row)).over().eq(t.field(totalRows)))
                                .as("last_page"),
                        t.field(totalRows),
                        t.field(row),
                        t.field(row).minus(inline(1)).div(limit).plus(inline(1))
                                .as("current_page"))
                .from(t)
                .orderBy(t.fields(sort));

        return result;
    }
}