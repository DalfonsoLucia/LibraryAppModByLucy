package com.aesys.libraryapp.userlibrary.data.model;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class UserLibrarySpec {

    public static Specification<UserLibrary> getByName(String firstName){
        return (root, query, criteriaBuilder) -> {
            Predicate equalPredicate = criteriaBuilder.equal(root.get("firstName"), firstName);
            return equalPredicate;
        };
    }

    public static Specification<UserLibrary> getByNameAndLastName(String firstName, String lastName){
        return (root, query, criteriaBuilder) -> criteriaBuilder.
                and(criteriaBuilder.like(root.get("firstName"), firstName),
                        criteriaBuilder.like(root.get("lastName"), lastName));
    }
}
