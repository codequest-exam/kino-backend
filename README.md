# kino-backend
Codequest's backend solution for Kino


# Group contract:

- Gruppemedlemmer: Buster, Joakim, Laurits, Marcus
- Mødetider: Møde kl. 9, daily scrum 9:15. Går senest kl 16. Tidligst kl 12?
- Fremmødepolitik:
    - MAN MØDER FYSISK PÅ SKOLEN, med mindre man har en god undskyldning. 
    - SKAL annonceres dagen før, hvis man ikke kommer (med mindre man igen har en god undskyldning for ikke at kunne annoncere det i tide).
    - Kontakt hinanden på discord
    - STRAF ved afvigelse: hjemmelavet kage, hvis man afviger fra punkt (1) eller (2) én dag. Så husk at sige til!
- Branching-strategi:
    - Alle har deres egen branch(es). Alle kan lave lige så mange branches som de vil, som ingen andre i udgangspunktet rører ved.
    - Main branch som benyttes til at dele koden med hinanden - denne branch skal gerne være up to date med alt relevant
    - Deployment branch som er direkte forbundet til azure. Denne branch har github actions tilsluttet, og skal kun bruges, når man vil ændre på den deployede udgave (undgå derfor at benytte denne branch særlig ofte, og merge kun fra main)
- Kodestandarder:
    - IKKE dummy-commit-beskeder
    - … sørg derfor for at committe OFTE
    - GERNE korte in-line kommentarer ved kode, der ikke er “indlysende” (for andres skyld)
