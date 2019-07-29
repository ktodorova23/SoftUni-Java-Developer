package com.example.springdataintro.controllers;

import com.example.springdataintro.domain.entities.User;
import com.example.springdataintro.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final BufferedReader reader;

    private final UserService userService;

    @Autowired
    public AppController(BufferedReader reader, UserService userService) {
        this.reader = reader;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Filling some data into users table
//        List<User> users = new ArrayList<>();
//        User user1 = new User();
//        user1.setUsername("pesho123");
//        user1.setPassword("hgtJt12$ads");
//        user1.setEmail("pesho@gmail.com");
//        user1.setLastTimeLoggedIn(LocalDate.parse("01/06/2015", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user1);
//
//        User user2 = new User();
//        user2.setUsername("vanko1");
//        user2.setPassword("hgtJt12$ads12");
//        user2.setEmail("vanko1@gmail.com");
//        user2.setLastTimeLoggedIn(LocalDate.parse("08/06/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user2);
//
//        User user3 = new User();
//        user3.setUsername("goshko_n00b ");
//        user3.setPassword("hgtJt12$adadss");
//        user3.setEmail("gn00b@gmail.com");
//        user3.setLastTimeLoggedIn(LocalDate.parse("18/09/2014", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user3);
//
//        User user4 = new User();
//        user4.setUsername("penbo");
//        user4.setPassword("hgtJadt12$ads");
//        user4.setEmail("pen@yahoo.co.uk");
//        user4.setLastTimeLoggedIn(LocalDate.parse("11/12/2016", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user4);
//
//        User user5 = new User();
//        user5.setUsername("catLady");
//        user5.setPassword("hgtJt12$ads");
//        user5.setEmail("stepheny.p@yahoo.co.uk");
//        user5.setLastTimeLoggedIn(LocalDate.parse("10/10/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user5);
//
//        User user6 = new User();
//        user6.setUsername("ze_great_someone");
//        user6.setPassword("hgtJt12$ads");
//        user6.setEmail("ze-great@mail.bg");
//        user6.setLastTimeLoggedIn(LocalDate.parse("07/04/2016", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user6);
//
//        User user7 = new User();
//        user7.setUsername("peshaka");
//        user7.setPassword("hgtJt12$ads");
//        user7.setEmail("penbaka@gmail.com");
//        user7.setLastTimeLoggedIn(LocalDate.parse("01/06/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user7);
//
//        User user8 = new User();
//        user8.setUsername("vancheto");
//        user8.setPassword("hgtJt12$ads12");
//        user8.setEmail("vancheto@gmail.com");
//        user8.setLastTimeLoggedIn(LocalDate.parse("11/08/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user8);
//
//        User user9 = new User();
//        user9.setUsername("gosheto ");
//        user9.setPassword("hgtJt12$adadss");
//        user9.setEmail("gosheto@gmail.com");
//        user9.setLastTimeLoggedIn(LocalDate.parse("18/12/2018", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user9);
//
//        User user10 = new User();
//        user10.setUsername("penko");
//        user10.setPassword("hgtJadt12$ads");
//        user10.setEmail("penko@yahoo.co.uk");
//        user10.setLastTimeLoggedIn(LocalDate.parse("01/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user10);
//
//        User user11 = new User();
//        user11.setUsername("kotkata");
//        user11.setPassword("hgtJt12$ads");
//        user11.setEmail("kotkata.p@yahoo.co.uk");
//        user11.setLastTimeLoggedIn(LocalDate.parse("01/01/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user11);
//
//        User user12 = new User();
//        user12.setUsername("somebody");
//        user12.setPassword("hgtJt12$ads");
//        user12.setEmail("somebody-great@mail.bg");
//        user12.setLastTimeLoggedIn(LocalDate.parse("31/03/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        users.add(user12);
//
//        this.userService.insertUsersIntoDB(users);

//        this.getAndPrintUsersByEmailProvider();

        this.deleteInactiveUsers();
    }

    private void getAndPrintUsersByEmailProvider() throws IOException {
        String emailProvider = reader.readLine();

        this.userService
                    .findUsersByGivenEmailProvider(emailProvider)
                    .forEach(System.out::println);
    }

    private void deleteInactiveUsers() throws IOException, ParseException {
        String dateInput = reader.readLine();
        String hyphenedDate = dateInput.replaceAll(" ", "-");

        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format1.parse(hyphenedDate);
        String format = format2.format(date);
        System.out.println();
        int countInactiveUsers = this.userService.findTheCountOfAllInactiveUsersAfterGivenDate(format);

        this.userService.deleteInactives(format);
        System.out.println(String.format("%s users have been deleted",
                countInactiveUsers > 0
                        ? String.valueOf(countInactiveUsers)
                        : "No"));
    }
}
