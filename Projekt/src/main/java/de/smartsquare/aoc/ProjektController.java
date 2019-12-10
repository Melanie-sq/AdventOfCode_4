package de.smartsquare.aoc;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProjektController {
    Projekt passwords;

    ProjektController(final Projekt passwords){
        this.passwords = passwords;
    }

    @RequestMapping(value = "/{start}/{end}", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> findPasswordsInRange(final @PathVariable Integer start, final @PathVariable int end){
        return passwords.findPasswordsInRange(start, end);
    }
}