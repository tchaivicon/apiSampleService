package com.chae.apiservice.api.controller;

import com.chae.apiservice.api.dto.Auction;
import com.chae.apiservice.api.dto.RequestAuctionDTO;
import com.chae.apiservice.api.dto.RequestAuctionResponseDTO;
import com.chae.apiservice.api.service.AuctionService;
import com.chae.apiservice.message.service.Message;
import com.chae.apiservice.message.service.MessageService;
import com.chae.apiservice.message.service.factory.MessageFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuctionControllerTest {

    @Mock
    private AuctionService auctionService;

    @Mock
    private MessageFactory messageFactory;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private AuctionController auctionController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void requestAuctionTest() {
        RequestAuctionDTO requestAuctionDTO = new RequestAuctionDTO("item", "John Doe", "1000");
        RequestAuctionResponseDTO responseDTO = new RequestAuctionResponseDTO("1", "item", "John Doe", "1000");
        when(auctionService.requestAuction(requestAuctionDTO)).thenReturn(responseDTO);

        ResponseEntity<RequestAuctionResponseDTO> response = auctionController.requestAuction(requestAuctionDTO);
        assert response.getBody().equals(responseDTO);
    }

    @Test
    public void startAuctionTest() {
        String auctionId = "123";
        Auction auction = new Auction();
        auction.setId(auctionId);

        when(auctionService.getAuction(auctionId)).thenReturn(auction);
        Message message = mock(Message.class);
        when(messageFactory.getMessage(any())).thenReturn(message);

        ResponseEntity<Auction> response = auctionController.startAuction(auctionId);
        verify(auctionService).startAuction(auctionId);
        verify(messageService).sendMessage(message);
        assert response.getBody().equals(auction);
    }
}