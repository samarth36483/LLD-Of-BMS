Low level design of Book My Show

Flow in which we use app
City > Movie > Theatre > Show > Seat > Payment

1. Overview => Known to us. If not known we can discuss with interviewer about the system and what it does.
2. Requirement Gathering :-
   1. User should be able to book tickets.
   2. User can select seats while booking.
   3. BMS is available in lot of cities and user can choose any city.
   4. User can choose movie.
   5. User can choose theatre.
   6. User can choose show(time).
   7. User can choose seat or seats.
   8. User can make payment.
   9. User will get a ticket.
   10. Each theatre can have multiple screens and each screen can show different movie at same time.
   11. A show is a particular movie playing at a particular time at a particular screen in a particular theatre.
   12. Users should be able to see all movies in a particular region.
   13. In one booking user can book upto 10 seats.
   14. No 2 persons should be able to book same seat.
   15. Price of ticket will depend on 2 things => Show + seat type
   16. Payment will be handled by 3rd party, we just need to store ref. no., payment status, payment mode and payment gateway.
   17. We want to support partial payments.
   18. Movie details :-
       Poster, Name, cast, trailer, language, genre, duration, certification, rating, release date
   19. Movie features :-
       Dolby Audio/Dolby Vision/2D/3D/4K/IMAX
   20. Auditorium features :-
       Dolby Audio/Dolby Vision/2D/3D/4K/IMAX
   21. Each audi will have different types of seats.
    
