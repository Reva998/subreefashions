package com.flm.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.dto.Busdetailsdto;
import com.flm.dto.PlanJourneydto;
import com.flm.dto.UserRegistrationdto;
import com.flm.model.Busdetails;
import com.flm.model.PlanJourney;
import com.flm.model.UserRegistration;
import com.flm.builder.UserBuilder;
@Component
public class PlanBuilder {
@Autowired
private UserBuilder ub;
@Autowired
private BusBuilder bd;
public PlanJourneydto toDto(PlanJourney planJourney) {
    UserRegistration user = planJourney.getUser();
    UserRegistrationdto userDto = null;
    if (user != null) {
        userDto = ub.user_e_dto_id(user);
    }

    return new PlanJourneydto(
        planJourney.getBookingid(),
        planJourney.getSource(),
        planJourney.getDestination(),
        planJourney.getDate(),
        planJourney.getDay(),
        planJourney.getTime(),
        planJourney.getStatus(),
        planJourney.getPassangers(),
        userDto,
        bd.bus_e_dto(planJourney.getBus()),
        planJourney.getTotalAmount(),
        planJourney.getPaymentstatus()
    );
}

        public PlanJourney toEn(PlanJourneydto planJourneydto) {
            // Convert nested user and bus entities to DTOs
           
            // Use full constructor of PlanJourneydto
            return new PlanJourney(
                planJourneydto.getBookingid(),
                planJourneydto.getSource(),
                planJourneydto.getDestination(),
                planJourneydto.getDate(),
                planJourneydto.getDay(),
                planJourneydto.getTime(),
                planJourneydto.getStatus(),
                planJourneydto.getPassangers(),
              ub.user_dto_e_id( planJourneydto.getUser()),
              bd.bus_dto_e( planJourneydto.getBus()),
            
              planJourneydto.getTotalamount(),
              planJourneydto.getPaymentstatus()
                
            );
    }
        public PlanJourneydto toDto_save(PlanJourney planJourney) {
            // Convert nested user and bus entities to DTOs
           
            // Use full constructor of PlanJourneydto
            return new PlanJourneydto(
               
                planJourney.getSource(),
                planJourney.getDestination(),
                planJourney.getDate(),
                planJourney.getDay(),
                planJourney.getTime(),
                planJourney.getStatus(),
                planJourney.getPassangers(),
               ub.user_e_dto_id( planJourney.getUser()),
               bd.bus_e_dto( planJourney.getBus()),
               planJourney.getTotalAmount(),
               planJourney.getPaymentstatus()
             
               
                
            );
}
        public PlanJourney toEn_save(PlanJourneydto planJourneydto) {
            // Convert nested user and bus entities to DTOs
           
            // Use full constructor of PlanJourneydto
            return new PlanJourney(
               
                planJourneydto.getSource(),
                planJourneydto.getDestination(),
                planJourneydto.getDate(),
                planJourneydto.getDay(),
                planJourneydto.getTime(),
               planJourneydto.getStatus(),
                planJourneydto.getPassangers(),
              ub.user_dto_e_id( planJourneydto.getUser()),
              bd.bus_dto_e( planJourneydto.getBus()),
              planJourneydto.getTotalamount(),
              planJourneydto.getPaymentstatus()
            
             
          
                
            );
    }
}
