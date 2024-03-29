package com.ertu.weddingplanner.guest;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(
        origins = {
                "http://localhost:5173/",
                "https://elisabeth-ertugrul.netlify.app",
                "https://meliha-ali.netlify.app"},
        methods = {
                RequestMethod.GET,
                RequestMethod.POST
        }
)
@RequestMapping(path = "guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getGuests() {
        return guestService.getGuests();
    }

    @GetMapping("{guestId}")
    public Optional<Guest> getGuest(@PathVariable Long guestId) {
        return guestService.getGuest(guestId);
    }

    @GetMapping("count")
    public int getGuestsCount() {
        return guestService.getGuestsCount();
    }

    @PostMapping
    public void addGuest(@RequestBody Guest guest) throws MessagingException, IOException {
        guestService.createGuest(guest);
    }


}
