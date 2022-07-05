package com.aesys.libraryapp.reservation.data.model;


import com.aesys.libraryapp.reservation.data.dto.Filter;
import com.aesys.libraryapp.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
@Component
public class ReservationSpec {
    @Autowired
    public Utils utils;

    public Specification<Reservation> getByReservationId(String reservationId){
        return (root, query, criteriaBuilder) -> {
            Predicate equalPredicate = criteriaBuilder.equal(root.get("id"), reservationId);
            return equalPredicate;
        };
    }

    public Specification<Reservation> getByReservationIdAndTaxCode(String reservationId, String taxCode){
        return (root, query, criteriaBuilder) -> {
            Predicate equalPredicate = criteriaBuilder.
                    and(criteriaBuilder.like(root.get("id"), reservationId),
                            criteriaBuilder.like(root.get("userLibrary").get("taxCode"), taxCode));
            return equalPredicate;
        };
    }


    public  Specification<Reservation> createSpecification(Filter input) {
        switch (input.getOperator()){
            case EQUALS:
                return executeEquals(input);
            case NOT_EQUALS:
                return executeNotEquals(input);
            case GREATER_THAN:
                return executeGT(input);
            case LESS_THAN:
                return executeLT(input);
            case LIKE:
                return executeLike(input);
            case IN:
                return executeIn(input);
            default:
                throw new RuntimeException("Operation not supported yet");
        }
    }

    private Specification<Reservation> executeIn(Filter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.in(root.get(input.getField()))
                        .value(utils.castToRequiredType(
                                root.get(input.getField()).getJavaType(),
                                input.getValues()));
    }

    private Specification<Reservation> executeLike(Filter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(input.getField()),
                        "%" + input.getValue() + "%");
    }

    private Specification<Reservation> executeLT(Filter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lt(root.get(input.getField()),
                        (Number) utils.castToRequiredType(
                                root.get(input.getField()).getJavaType(),
                                input.getValue()));
    }

    private Specification<Reservation> executeGT(Filter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.gt(root.get(input.getField()),
                        (Number) utils.castToRequiredType(
                                root.get(input.getField()).getJavaType(),
                                input.getValue()));
    }

    private Specification<Reservation> executeNotEquals(Filter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.notEqual(root.get(input.getField()),
                        utils.castToRequiredType(root.get(input.getField()).getJavaType(),
                                input.getValue()));
    }

    private Specification<Reservation> executeEquals(Filter input) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(input.getField()),
                        utils.castToRequiredType(root.get(input.getField()).getJavaType(),
                                input.getValue()));
    }
}
