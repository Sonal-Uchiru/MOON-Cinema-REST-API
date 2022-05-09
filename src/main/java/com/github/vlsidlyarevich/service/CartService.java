package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.dto.CartTicketDetailsDTO;
import com.github.vlsidlyarevich.model.Cart;
import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;
    private final ShowTimeService showTimeService;

    @Autowired
    public CartService(CartRepository repository,ShowTimeService showTimeService) {
        this.repository = repository;
        this.showTimeService = showTimeService;
    }

    public Cart saveCart(Cart cart, User user){
        cart.setCustomer_id(user.getId());
        cart.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return this.repository.save(cart);
    }

    public void removeCartTicket(String cartId) throws Exception {
        getCartById(cartId);
        this.repository.delete(cartId);
    }

    public Cart getCartById(String cartId) throws Exception {
        Cart cart = this.repository.findOne(cartId);
        if(cart != null){
            return cart;
        }else{
            throw new Exception("Cart Ticket Not Found");
        }
    }

    public void updateTicketCount(String id, boolean isChild, int tickets) throws Exception {
        Cart cart = this.getCartById(id);
        if(isChild){
            cart.setChild_tickets(tickets);
        }else{
            cart.setAdult_tickets(tickets);
        }
        cart.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        this.repository.save(cart);
    }


    public List<CartTicketDetailsDTO> getUserCart(User user) throws Exception {
        List<Cart> carts = this.repository.findAll();
        List<CartTicketDetailsDTO> cartTicketDetailsDTOS = new ArrayList<>();
        for(Cart value : carts){
            if(value.getCustomer_id().equals(user.getId())){
                CartTicketDetailsDTO ticket = new CartTicketDetailsDTO();
                ticket.setCart(value);
                ticket.setShowTimeWithMovieTheaterDetailsDTO(showTimeService.getShowTimesWithMoviesAndTheaterDetailsById(value.getShow_time_id()));
                cartTicketDetailsDTOS.add(ticket);
            }
        }

        return cartTicketDetailsDTOS;
    }



}
