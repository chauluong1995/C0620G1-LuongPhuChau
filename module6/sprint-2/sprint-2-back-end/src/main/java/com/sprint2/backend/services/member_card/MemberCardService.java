package com.sprint2.backend.services.member_card;

import com.sprint2.backend.entity.MemberCard;

import java.util.List;

public interface MemberCardService {
    List<MemberCard> findAll();

    MemberCard findByID(Long id);

    void save(MemberCard memberCard);

    MemberCard findByPlateNumber(String plateNumber);

    MemberCard findByCustomerName(String fullName);

    MemberCard findByCustomerMail(String mail);
}
