package com.support.eng.notifier.data.repository;

import com.support.eng.notifier.data.User;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import jakarta.inject.Singleton;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepository extends ReactorCrudRepository<User, UUID> {

  @NonNull
  @Override
  //@Query("""
  //          SELECT user_."id",user_."name",user_."email",user_."age",user_."created_at",user_."updated_at",
  //                 user_posts_."id" AS posts_id,
  //                 user_posts_."title" AS posts_title,
  //                 user_posts_."content" AS posts_content,
  //                 user_posts_."user_id" AS posts_user_id,
  //                 user_posts_."created_at" AS posts_created_at,
  //                 user_posts_."updated_at" AS posts_updated_at
  //          FROM "user" user_
  //          LEFT JOIN "post" user_posts_ ON user_."id"=user_posts_."user_id"
  //          """)
  @Join(value = "posts", type = Join.Type.LEFT_FETCH)
  Flux<User> findAll();

  @NonNull
  @Query("""
            SELECT * FROM "user" u ORDER BY u.age ASC 
            """)
  Flux<User> findAllOrderByAgeAsc();


  @NonNull
  @Override
  @Query("""
            SELECT * FROM "user" u WHERE u.id = :id LIMIT 1
            """)
  Mono<User> findById(@NonNull UUID id);


  Mono<User> findByAgeOrId(@NonNull Integer age, @NonNull UUID id);
}
