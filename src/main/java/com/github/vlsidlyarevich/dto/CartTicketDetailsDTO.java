package com.github.vlsidlyarevich.dto;

import com.github.vlsidlyarevich.model.Cart;

public class CartTicketDetailsDTO {
    private Cart cart;
    private ShowTimeWithMovieTheaterDetailsDTO showTimeWithMovieTheaterDetailsDTO;

    public CartTicketDetailsDTO() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ShowTimeWithMovieTheaterDetailsDTO getShowTimeWithMovieTheaterDetailsDTO() {
        return showTimeWithMovieTheaterDetailsDTO;
    }

    public void setShowTimeWithMovieTheaterDetailsDTO(ShowTimeWithMovieTheaterDetailsDTO showTimeWithMovieTheaterDetailsDTO) {
        this.showTimeWithMovieTheaterDetailsDTO = showTimeWithMovieTheaterDetailsDTO;
    }
}
