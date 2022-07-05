package com.aesys.libraryapp.userlibrary.repository;

import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibrary,String>,
        JpaSpecificationExecutor<UserLibrary> {

    @Query(nativeQuery = true, value="SELECT * FROM user_library")
    List<UserLibrary> findEverything(Specification<UserLibrary> spec);


}
