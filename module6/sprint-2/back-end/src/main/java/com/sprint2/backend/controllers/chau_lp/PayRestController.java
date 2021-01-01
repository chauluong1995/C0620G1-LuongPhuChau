package com.sprint2.backend.controllers.chau_lp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.sprint2.backend.services.member_card.MemberCardService;
import com.sprint2.backend.entity.MemberCard;

@RestController
@RequestMapping("/chau")
@CrossOrigin
public class PayRestController {
    @Autowired
    private MemberCardService memberCardService;

    /*
     * get all member card of customer currently logged in database
     * @param idCustomer
     * @return ResponseEntity<List<MemberCard>>
     * */
    @GetMapping("/list/{id}")
    public ResponseEntity<List<MemberCard>> getListMemberCardByIDCustomer(@PathVariable Long id) {
        List<MemberCard> memberCardList = this.memberCardService.findByCustomerID(id);
        return new ResponseEntity<>(memberCardList, HttpStatus.OK);
    }

    /*
     * update member card after customer pay
     * @param money, memberCardList
     * void
     * */
    @GetMapping("/pay/{money}/{memberCardList}")
    public void updateMemberCardAfterPay(@PathVariable Double money, @PathVariable List<Integer> memberCardList) {
        System.out.println(money);
        System.out.println(memberCardList);
    }
}
