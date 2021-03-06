package com.fasttrackit.persistence;

import com.fasttrackit.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
    User findByEmailAndPassword(String email, String password);
}
