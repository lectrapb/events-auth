package com.app.signUp.infra.database.infra;

import com.app.signUp.infra.database.domain.UserAuthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAuthData, Long> {
}
