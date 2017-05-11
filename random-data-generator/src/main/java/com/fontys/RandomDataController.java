package com.fontys;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.Locale;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.OK;

/**
 * Created by Nino Vrijman on 11-5-2017.
 */
@RestController
@RequestMapping("/randomdata")
@CrossOrigin(origins = "*")
@Controller
public class RandomDataController {
    Faker faker = new Faker(new Locale("NL"));

    private void changeLocale(String locale) {
        this.faker = new Faker(new Locale(locale));
    }

    @RequestMapping(value = "/firstname", method = RequestMethod.GET)
    public Response getFirstname (@RequestParam(value = "locale") Optional<String> locale) {
        if (locale.isPresent()) {
            this.changeLocale(locale.get());
        }
        return Response.status(OK).entity(faker.name().firstName()).build();
    }

    @RequestMapping(value = "/lastname", method = RequestMethod.GET)
    public Response getLastname (@RequestParam(value = "locale") Optional<String> locale) {
        if (locale.isPresent()) {
            this.changeLocale(locale.get());
        }
        return Response.status(OK).entity(faker.name().lastName()).build();
    }

    @RequestMapping(value = "/fullname", method = RequestMethod.GET)
    public Response getFullname (@RequestParam(value = "locale") Optional<String> locale) {
        if (locale.isPresent()) {
            this.changeLocale(locale.get());
        }
        return Response.status(OK).entity(faker.name().fullName()).build();
    }

    @RequestMapping(value = "/datetime", method = RequestMethod.GET)
    public Response getDatetime (@RequestParam(value = "locale") Optional<String> locale) {
        if (locale.isPresent()) {
            this.changeLocale(locale.get());
        }
//        return Response.status(OK).entity(mapper.writeValueAsString(this.faker.date()).build();
        return Response.status(OK).entity("Faker library: DateAndTime kunnen niet geserialiseerd worden").build();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public Response getCategory (@RequestParam(value = "locale") Optional<String> locale) {
        if (locale.isPresent()) {
            this.changeLocale(locale.get());
        }
        return Response.status(OK).entity(faker.book().genre()).build();
    }

    @RequestMapping(value = "/loremipsum", method = RequestMethod.GET)
    public Response getLoremIpsum (@RequestParam(value = "locale") Optional<String> locale) {
        if (locale.isPresent()) {
            this.changeLocale(locale.get());
        }
        return Response.status(OK).entity(faker.lorem().paragraph()).build();
    }
}